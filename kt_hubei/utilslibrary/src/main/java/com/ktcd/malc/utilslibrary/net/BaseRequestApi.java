package com.ktcd.malc.utilslibrary.net;

import java.io.Serializable;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

import static android.R.attr.path;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface  BaseRequestApi  {
//    @Headers({"Content-Type: text/html","Accept: application/json"})
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("{action}")
    Observable<BaseResponse> getBasePostRequestData(@Path(value = "action",encoded =true) String action, @Body Object requestParam);

    @GET("{action}")
    Observable<BaseResponse> getBaseGetQueryRequestData(@Path(value = "action",encoded =true) String action,@QueryMap Map<String, String> map);
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("{action}")
    Observable<BaseResponse> getBasePostQueryRequestData(@Path(value = "action",encoded =true) String action,@FieldMap Map<String, String> map);

    @Multipart
    @POST()
    Observable<BaseResponse> upFilesAndJson(@Url String pathUrl,@Part("feedbackRaterId") RequestBody jsonObject, @PartMap Map<String, RequestBody> params);

    @GET
    Observable<BaseResponse> getBaseGetQueryRequestDataByAllPath(@Url String pathUrl,@QueryMap Map<String, String> map);

    @POST
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<BaseResponse> getBasePostQueryRequestDataByAllPath(@Url String pathUrl,@FieldMap Map<String, String> map);

    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST
    @FormUrlEncoded
    Observable<BaseResponse> getBasePostJsonRequestData(@Url String action, @FieldMap Map<String, String> map);
}
