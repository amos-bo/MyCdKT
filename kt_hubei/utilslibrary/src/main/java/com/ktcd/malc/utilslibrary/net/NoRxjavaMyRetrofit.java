//package com.ktcd.malc.utilslibrary.net;
//
//import android.content.Context;
//import android.util.Log;
//import android.widget.Toast;
//
//
//import com.google.gson.Gson;
//import com.ktcd.malc.utilslibrary.tools.GsonUtils;
//import com.ktcd.malc.utilslibrary.tools.LogUtils;
//import com.ktcd.malc.utilslibrary.tools.PhoneUtils;
//import com.ktcd.malc.utilslibrary.tools.ToastUtils;
//
//import org.reactivestreams.Subscription;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import io.reactivex.Observable;
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.annotations.NonNull;
//import io.reactivex.annotations.Nullable;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;
//import okhttp3.Interceptor;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//import okhttp3.ResponseBody;
//import okhttp3.logging.HttpLoggingInterceptor;
//import okio.BufferedSink;
//import retrofit2.Call;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//
///**
// * Created by Administrator on 2017/6/6.
// */
//
//public class MyRetrofit {
//
//    public static final String TAG = "MyRetrofit";
//
//    private static Retrofit mRetrofit;
//    private static HashMap<String, Call<BaseResponse>> mCallList;
//    private static HttpLoggingInterceptor mHttpLoggingInterceptor;
//    private static OkHttpClient mOkHttpClient;
//    private static BaseRequestApi mBaseRequestApi;
//    //操作失败
//    public static String ERROR_CODE = "LINKAGECOMMAND-0002";
//    //操作成功
//    public static String SUCCESS_CODE = "LINKAGECOMMAND-0000";
//    //入参不正确
//    public static String ERROR_REQUESTPARMS = "LINKAGECOMMAND-0001";
//
//    /***
//     *
//     * @param context 只用于POST JSON对象使用
//     * @param action 地址后缀
//     * @param obj    发送数据的对象
//     * @param callBack
//     * @param <T>    返回类型Bean
//     */
//    public static <T extends Serializable> void StartNet(Context context, String action, Object obj, ResponseCallBack<T> callBack) {
//        if (!PhoneUtils.isNetworkAvailable(context)) {
//            ToastUtils.showMessage(context, "请您先检测网络连接是否良好");
//            return;
//        }
//        if (mCallList == null) {
//            mCallList = new HashMap<>();
//        }
//        initRetrofit();
//        initBasePostRequestApi(action, obj, callBack);
//    }
//
//    /***
//     *
//     * @param context
//     * @param isPOST 是否为POST或GET请求
//     * @param action 地址后缀
//     * @param map    拼在URL中的键值对
//     * @param callBack
//     * @param <T>    返回类型Bean
//     */
//
//    public static <T extends Serializable> void StartQueryNet(Context context, boolean isPOST, String action, Map<String, String> map, ResponseCallBack<T> callBack) {
//        if (!PhoneUtils.isNetworkAvailable(context)) {
//            ToastUtils.showMessage(context, "请您先检测网络连接是否良好");
//            return;
//        }
//        if (mCallList == null) {
//            mCallList = new HashMap<>();
//        }
//        initRetrofit();
//        initBaseQueryRequestApi(isPOST, action, map, callBack);
//    }
//
//    /**
//     * @param context   上下文
//     * @param action    上传地址
//     * @param obj       JSON对象
//     * @param filesList 上传文件路径
//     * @param callBack
//     * @param <T>       返回数据类型
//     */
//    public static <T extends Serializable> void StartUpLoadFilesAndJsonObj(Context context, String action, Object obj, List<String> filesList, ResponseCallBack<T> callBack) {
//        if (!PhoneUtils.isNetworkAvailable(context)) {
//            ToastUtils.showMessage(context, "请您先检测网络连接是否良好");
//            return;
//        }
//        if (mCallList == null) {
//            mCallList = new HashMap<>();
//        }
//        initRetrofit();
//        upDateFilesAndJson(action, obj, filesList, callBack);
//    }
//
//
//    private static void initRetrofit() {
//        if (mOkHttpClient == null) {
//            initLog();
//            if (mRetrofit == null) {
//                mRetrofit = new Retrofit.Builder().client(mOkHttpClient)
//                        .baseUrl(PathUrl.ROOT_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//            }
//        }
//    }
//
//    private static <T extends Serializable> void initBasePostRequestApi(final String action, Object obj, final ResponseCallBack<T> callBack) {
//        if (mBaseRequestApi == null) {
//            mBaseRequestApi = mRetrofit.create(BaseRequestApi.class);
//        }
//        Call<BaseResponse> call = mBaseRequestApi.getBasePostRequestData(action, obj);
//        mCallList.put(action, call);
//        callBack.onLoad();
//        call.enqueue(new retrofit2.Callback<BaseResponse>() {
//            @Override
//            public void onResponse(retrofit2.Call<BaseResponse> call, retrofit2.Response<BaseResponse> response) {
//                if (response.body().code != null) {
//                    if (response.body().code.equals(MyRetrofit.SUCCESS_CODE)) {
//                        try {
//                            Class<T> mClass = callBack.initGenericClass();
//                            callBack.onSuccess(GsonUtils.parseJsonWithGson(GsonUtils.beanToJSONString(response.body().data), mClass));
//                        } catch (Exception e) {
//                            throw new IllegalArgumentException("Bean类型不匹配");
//                        }
//                    } else {
//                        callBack.onError(new KtkjError(response.body().code, response.body().msg));
//                    }
//                } else {
//                    callBack.onError(new KtkjError("-101", "返回状态码为空"));
//                }
//                mCallList.remove(action);
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<BaseResponse> call, Throwable t) {
//                callBack.onError(new KtkjError("-100", "服务器异常，未知错误"));
//                mCallList.remove(action);
//            }
//        });
//    }
//
//    private static <T extends Serializable> void initBaseQueryRequestApi(Boolean isPost, final String action, Map<String, String> map, final ResponseCallBack<T> callBack) {
//        if (mBaseRequestApi == null) {
//            mBaseRequestApi = mRetrofit.create(BaseRequestApi.class);
//        }
//        Call<BaseResponse> call;
//        if (isPost) {
//            call = mBaseRequestApi.getBasePostQueryRequestData(action, map);
//        } else {
//            call = mBaseRequestApi.getBaseGetQueryRequestData(action, map);
//        }
//        callBack.onLoad();
//        mCallList.put(action, call);
//        call.enqueue(new retrofit2.Callback<BaseResponse>() {
//            @Override
//            public void onResponse(retrofit2.Call<BaseResponse> call, retrofit2.Response<BaseResponse> response) {
//                if (response.body().code != null) {
//                    if (response.body().code.equals(MyRetrofit.SUCCESS_CODE)) {
//                        try {
//                            Class<T> mClass = callBack.initGenericClass();
//                            callBack.onSuccess(GsonUtils.parseJsonWithGson(GsonUtils.beanToJSONString(response.body().data), mClass));
//                        } catch (Exception e) {
//                            throw new IllegalArgumentException("Bean类型不匹配");
//                        }
//                    } else {
//                        callBack.onError(new KtkjError(response.body().code, response.body().msg));
//                    }
//                } else {
//                    callBack.onError(new KtkjError("-101", "返回状态码为空"));
//                }
//                mCallList.remove(action);
//                Log.e("xb", "mCallList: " + mCallList.size());
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<BaseResponse> call, Throwable t) {
//                callBack.onError(new KtkjError("-100", "服务器异常，未知错误"));
//                mCallList.remove(action);
//            }
//        });
//    }
//
//
//    private static void initLog() {
//        if (mHttpLoggingInterceptor == null || mOkHttpClient == null) {
//            //新建log拦截器
//            mHttpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//                @Override
//                public void log(String message) {
//                    Log.e("OkHttpLog", "OkHttpMessage:" + message);
//                }
//            });
//            mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            mOkHttpClient = new OkHttpClient.Builder().addInterceptor(mHttpLoggingInterceptor).build();
//        }
//    }
//
//    /***
//     *
//     * @param urlPath
//     * @param jsonObject
//     * @param mFilesList
//     * @param callBack
//     * @param <T>
//     */
//    private static <T extends Serializable> void upDateFilesAndJson(final String urlPath, Object jsonObject, List<String> mFilesList, final ResponseCallBack<T> callBack) {
//        if (mBaseRequestApi == null) {
//            mBaseRequestApi = mRetrofit.create(BaseRequestApi.class);
//        }
//        Map<String, RequestBody> photos = new HashMap<>();
//        for (String requestFile : mFilesList) {
//            File file = new File(requestFile);
//            RequestBody photo = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            photos.put("files\"; filename=\"" + file.getName(), photo);
//        }
//        Call<BaseResponse> call = mBaseRequestApi.upFilesAndJson(urlPath, RequestBody.create(MediaType.parse("multipart/form-data"), GsonUtils.beanToJSONString(jsonObject)), photos);
//        callBack.onLoad();
//        mCallList.put(urlPath, call);
//
//        call.enqueue(new retrofit2.Callback<BaseResponse>() {
//            @Override
//            public void onResponse(retrofit2.Call<BaseResponse> call, retrofit2.Response<BaseResponse> response) {
//                if (response.body().code != null) {
//                    if (response.body().code.equals(MyRetrofit.SUCCESS_CODE)) {
//                        try {
//                            Class<T> mClass = callBack.initGenericClass();
//                            callBack.onSuccess(GsonUtils.parseJsonWithGson(GsonUtils.beanToJSONString(response.body().data), mClass));
//                        } catch (Exception e) {
//                            throw new IllegalArgumentException("Bean类型不匹配");
//                        }
//                    } else {
//                        callBack.onError(new KtkjError(response.body().code, response.body().msg));
//                    }
//                } else {
//                    callBack.onError(new KtkjError("-101", "返回状态码为空"));
//                }
//                mCallList.remove(urlPath);
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<BaseResponse> call, Throwable t) {
//                callBack.onError(new KtkjError("-100", "服务器异常，未知错误"));
//                mCallList.remove(urlPath);
//            }
//        });
//    }
//
//    /**
//     * 取消所有网络请求
//     */
//    public static void callAllCancel() {
//        if (mCallList != null) {
//            Iterator<Map.Entry<String, Call<BaseResponse>>> it = mCallList.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry<String, Call<BaseResponse>> entry = it.next();
//                if (entry.getValue() != null) {
//                    if (!entry.getValue().isCanceled()) {
//                        entry.getValue().cancel();
//                    }
//                }
//            }
//            mCallList.clear();
//        }
//    }
//
//    /**
//     * 根据动作取消指定网络请求
//     */
//    public static void callByActionCancel(String action) {
//        if (mCallList != null) {
//            Call<BaseResponse> call = mCallList.get(action);
//            if (call != null) {
//                if (!call.isCanceled()) {
//                    call.cancel();
//                    mCallList.remove(action);
//                } else {
//                    mCallList.remove(action);
//                }
//            }
//        }
//    }
//
//}
