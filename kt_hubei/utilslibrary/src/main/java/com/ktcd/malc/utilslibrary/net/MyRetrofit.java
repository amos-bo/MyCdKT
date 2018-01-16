package com.ktcd.malc.utilslibrary.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.GsonUtils;
import com.ktcd.malc.utilslibrary.tools.PhoneUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2017/6/6.
 */

public class MyRetrofit {

    public static final String TAG = "MyRetrofit";

    private static Retrofit mRetrofit;
    /**
     * set模式，值不能重复，所以每次必须新new不然导致取消后，再添加也不能接受新的事件
     */
    private static CompositeDisposable mDisposables;

    private  static HashSet<String> mCookies=new HashSet<>();

    private static HttpLoggingInterceptor mHttpLoggingInterceptor;
    private static OkHttpClient mOkHttpClient;
    private static BaseRequestApi mBaseRequestApi;
    //操作失败
    public static String ERROR_CODE = "LINKAGECOMMAND-0002";
    //操作成功
    public static String SUCCESS_CODE = "LINKAGECOMMAND-0000";
    //入参不正确
    public static String ERROR_REQUESTPARMS = "LINKAGECOMMAND-0001";

    /***
     *
     * @param context 只用于POST JSON对象使用
     * @param action 地址后缀
     * @param obj    发送数据的对象
     * @param callBack
     * @param <T>    返回类型Bean
     */
    public static <T extends Serializable> void StartNet(Context context, String action,boolean isAllUrl, HashMap<String,String> obj, ResponseCallBack<T> callBack) {
        if (!PhoneUtils.isNetworkAvailable(context)) {
            ToastUtils.showMessage(context, "请您先检测网络连接是否良好");
            return;
        }
        initRetrofit(context);
        initBasePostRequestApi(action,isAllUrl, obj, callBack);
    }

    /***
     *
     * @param context
     * @param isPOST 是否为POST或GET请求
     * @param action 地址后缀
     * @param map    拼在URL中的键值对
     * @param callBack
     * @param <T>    返回类型Bean
     */

    public static <T extends Serializable> void StartQueryNet(Context context, boolean isPOST, String action, Map<String, String> map, ResponseCallBack<T> callBack) {
        if (!PhoneUtils.isNetworkAvailable(context)) {
            ToastUtils.showMessage(context, "请您先检测网络连接是否良好");
            return;
        }
        initRetrofit(context);
        initBaseQueryRequestApi(isPOST, action, map, callBack);
    }

    /**
     * @param context   上下文
     * @param action    上传地址
     * @param filesList 上传文件路径
     * @param callBack
     * @param <T>       返回数据类型
     */
    public static <T extends Serializable> void StartUpLoadFilesAndJsonObj(Context context, String action, Map<String, String> mapVal, List<String> filesList, ResponseCallBack<T> callBack) {
        if (!PhoneUtils.isNetworkAvailable(context)) {
            ToastUtils.showMessage(context, "请您先检测网络连接是否良好");
            return;
        }
        if (mDisposables == null) {
            mDisposables = new CompositeDisposable();
        }
        initRetrofit(context);
        upDateFilesAndJson(action, mapVal, filesList, callBack);
    }

    /***
     *
     * @param context
     * @param action 地址后缀
     * @param map    拼在URL中的键值对
     * @param callBack
     * @param <T>    返回类型Bean
     */

    public static <T extends Serializable> void StartQueryNetByAllPath(Context context,boolean isPost, String action, Map<String, String> map, ResponseCallBack<T> callBack) {
        if (!PhoneUtils.isNetworkAvailable(context)) {
            ToastUtils.showMessage(context, "请您先检测网络连接是否良好");
            return;
        }
        initRetrofit(context);
        initBaseQueryRequestApiByAllPath(isPost,action, map, callBack);
    }




    private static void initRetrofit(Context content) {
        if (mOkHttpClient == null) {
            initLog(content);
            if (mRetrofit == null) {
                String[] ip = ConfigUtils.getAppDataIP(content).split(",");
                mRetrofit = new Retrofit.Builder().client(mOkHttpClient)
                        .baseUrl(ip[0] + ":" + ip[1] + "/service/KT_S_LinkageCommand-service/")
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 使用RxJava作为回调适配器
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
    }

    private static <T extends Serializable> void initBasePostRequestApi(final String action,boolean isAllPath, HashMap<String,String> obj, final ResponseCallBack<T> callBack) {
        if (mBaseRequestApi == null) {
            mBaseRequestApi = mRetrofit.create(BaseRequestApi.class);
        }
        Observable<BaseResponse> call=null;
        if (isAllPath){
            call = mBaseRequestApi.getBasePostJsonRequestData(action, obj);
        }else{
            call = mBaseRequestApi.getBasePostRequestData(action, obj);
        }
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        callBack.onLoad(d);
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {
                        if (baseResponse.code != null) {
                            if (baseResponse.code.equals(MyRetrofit.SUCCESS_CODE)) {
                                try {
                                    Class<T> mClass = callBack.initGenericClass();
                                    if (!baseResponse.data.toString().startsWith("[")) {
                                        callBack.onSuccess(GsonUtils.parseJsonWithGson(GsonUtils.beanToJSONString(baseResponse.data), mClass));
                                    } else {
                                        callBack.onSuccessList(convertEntities(baseResponse.data.toString(), mClass));
                                    }
                                } catch (Exception e) {
                                    throw new IllegalArgumentException("Bean类型不匹配");
                                }
                            } else {
                                callBack.onError(new KtkjError(baseResponse.code, baseResponse.msg));
                            }
                        } else {
                            callBack.onError(new KtkjError("-101", "返回状态码为空"));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onError(new KtkjError("400", e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private static <T extends Serializable> void initBaseQueryRequestApi(Boolean isPost, final String action, Map<String, String> map, final ResponseCallBack<T> callBack) {
        if (mBaseRequestApi == null) {
            mBaseRequestApi = mRetrofit.create(BaseRequestApi.class);
        }
        Observable<BaseResponse> call;
        if (isPost) {
            call = mBaseRequestApi.getBasePostQueryRequestData(action, map);
        } else {
            call = mBaseRequestApi.getBaseGetQueryRequestData(action, map);
        }
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        callBack.onLoad(d);
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {
                        if (baseResponse.code != null) {
                            if (baseResponse.code.equals(MyRetrofit.SUCCESS_CODE)) {
                                try {
                                    Class<T> mClass = callBack.initGenericClass();
                                    callBack.onSuccess(GsonUtils.parseJsonWithGson(GsonUtils.beanToJSONString(baseResponse.data), mClass));
                                } catch (Exception e) {
                                    callBack.onError(new KtkjError("400", e.getMessage()));
                                    throw new IllegalArgumentException("Bean类型不匹配");
                                }
                            } else {
                                callBack.onError(new KtkjError(baseResponse.code, baseResponse.msg));
                            }
                        } else {
                            callBack.onError(new KtkjError("-101", "返回状态码为空"));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onError(new KtkjError("400", e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private static void initLog(final Context content) {
        if (mHttpLoggingInterceptor == null || mOkHttpClient == null) {
            //新建log拦截器
            mHttpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.e("OkHttpLog", "OkHttpMessage:" + message);
                }
            });
            mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder= new OkHttpClient.Builder();
            setCookies(builder);
//          setCookies(builder,content);
//            builder.addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                   Log.e("xb","请求头"+chain.request().header("Cookie"));
//                   Log.e("xb","请求头s"+chain.request().headers().toString());
//                   return chain.proceed(chain.request().newBuilder().build());
//                }
//            });
//                    .addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    //TODO 2017.8.4 修复动态修改HOSTBUG
//                    Request.Builder newBuilder = chain.request().newBuilder();
//                    String[] ip = ConfigUtils.getAppDataIP(content).split(",");
//                    String url = ip[0] + ":" + ip[1] + "/KT_S_LinkageCommand-service/";
//                    String action=chain.request().url().url().toString().substring((chain.request().url().url().toString().indexOf("/",10)),chain.request().url().url().toString().length());
//                    return chain.proceed(newBuilder
//                            .url(HttpUrl.parse(url+action))
//                            .build());
//                }
//            })
            mOkHttpClient = builder.addInterceptor(mHttpLoggingInterceptor).build();
        }
    }

    /***
     *
     * @param urlPath
     * @param ""
     * @param mFilesList
     * @param callBack
     * @param <T>
     */
    private static <T extends Serializable> void upDateFilesAndJson(final String urlPath, Map<String, String> mapType, List<String> mFilesList, final ResponseCallBack<T> callBack) {
        if (mBaseRequestApi == null) {
            mBaseRequestApi = mRetrofit.create(BaseRequestApi.class);
        }
        Map<String, RequestBody> photos = new HashMap<>();
        for (String requestFile : mFilesList) {
            File file = new File(requestFile);
            RequestBody photo = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            photos.put("files\"; filename=\"" + file.getName(), photo);
        }
        for (Map.Entry<String, String> entry : mapType.entrySet()) {
            RequestBody vale = RequestBody.create(MediaType.parse("Content-Type: text/html"), entry.getValue());
            photos.put(entry.getKey(), vale);
        }
        Observable<BaseResponse> call = mBaseRequestApi.upFilesAndJson(urlPath, RequestBody.create(MediaType.parse("multipart/form-data"), ""), photos);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        callBack.onLoad(d);
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {
                        if (baseResponse.code != null) {
                            if (baseResponse.code.equals(MyRetrofit.SUCCESS_CODE)) {
                                try {
                                    Class<T> mClass = callBack.initGenericClass();
                                    if (!baseResponse.data.toString().startsWith("[")) {
                                        callBack.onSuccess(GsonUtils.parseJsonWithGson(GsonUtils.beanToJSONString(baseResponse.data), mClass));
                                    } else {
                                        //  解析List
//                                        callBack.onSuccess(convertEntities(baseResponse.data.toString(), mClass));
                                    }

                                } catch (Exception e) {
                                    callBack.onError(new KtkjError("-101", "返回状态码为空"));
                                    throw new IllegalArgumentException("Bean类型不匹配");
                                }
                            } else {
                                callBack.onError(new KtkjError(baseResponse.code, baseResponse.msg));
                            }
                        } else {
                            callBack.onError(new KtkjError("-101", "返回状态码为空"));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onError(new KtkjError("-101", "返回状态码为空"));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    private static <T extends Serializable> void initBaseQueryRequestApiByAllPath(boolean isPost,final String action, Map<String, String> map, final ResponseCallBack<T> callBack) {
        if (mBaseRequestApi == null) {
            mBaseRequestApi = mRetrofit.create(BaseRequestApi.class);
        }
        Observable<BaseResponse> call=null;
        if (isPost) {
            call = mBaseRequestApi.getBasePostQueryRequestDataByAllPath(action, map);
        } else {
            call = mBaseRequestApi.getBaseGetQueryRequestDataByAllPath(action, map);;
        }
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        callBack.onLoad(d);
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {
                        if (baseResponse.code != null) {
                            if (baseResponse.code.endsWith(MyRetrofit.SUCCESS_CODE.substring(MyRetrofit.SUCCESS_CODE.length()-1,MyRetrofit.SUCCESS_CODE.length()))||baseResponse.code.equals("")) {
                                try {
                                    Class<T> mClass = callBack.initGenericClass();
                                    if (!baseResponse.data.toString().startsWith("[")) {
                                        callBack.onSuccess(GsonUtils.parseJsonWithGson(GsonUtils.beanToJSONString(baseResponse.data), mClass));
                                    } else {
                                        callBack.onSuccessList(convertEntities(baseResponse.data.toString(), mClass));
                                    }
                                } catch (Exception e) {
                                    callBack.onError(new KtkjError("400", e.getMessage()));
                                    Log.e("xb","Bean解析错误："+e.toString());
                                    throw new IllegalArgumentException("Bean类型不匹配");
                                }
                            } else {
                                callBack.onError(new KtkjError(baseResponse.code, baseResponse.msg));
                            }
                        } else {
                            callBack.onError(new KtkjError("-101", "返回状态码为空"));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (!e.getMessage().toString().endsWith("401")) {
                            callBack.onError(new KtkjError("400", e.getMessage()));
                        }else{
                            callBack.onError(new KtkjError("401", e.getMessage()));
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //加入到订阅列表
    public static void addSubscription(CompositeDisposable disposables, Disposable disposable) {
        if (disposable == null) return;
        if (disposables != null) {
            disposables.add(disposable);
        }

    }

    //取消指定的订阅
    public static void disposeSubscription(CompositeDisposable disposables, Disposable disposable) {
        if (disposables != null) {
            disposables.delete(disposable);
        }
    }

    //取消所有的订阅
    public static void disposeAllSubscription(CompositeDisposable disposables) {
        if (disposables != null) {
            Log.e("xb", "DISSIZE:  " + disposables.size());
            disposables.clear();
        }
    }

    public static <T> List<T> convertEntities(String jsonString, Class<T> entityclass) {
        List<T> entities = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonArray Jarray = parser.parse(jsonString).getAsJsonArray();
            for (JsonElement element : Jarray) {
                entities.add(gson.fromJson(element, entityclass));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }
    public static void setCookies(OkHttpClient.Builder builder) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        builder.cookieJar(new JavaNetCookieJar(cookieManager));
    }

    public static void setCookies(OkHttpClient.Builder builder,Context content) {
        CookieManager cookieManager = new java.net.CookieManager(new InDiskCookieStore(content),CookiePolicy.ACCEPT_ALL);
        builder.cookieJar(new JavaNetCookieJar(cookieManager));
    }
}
