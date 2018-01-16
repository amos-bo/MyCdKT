package com.ktcd.malc.utilslibrary.tools;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/6/14.
 */

public class GsonUtils {

    public static String beanToJSONString(Object bean) {
        return new Gson().toJson(bean);
    }

    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }

}
