//package com.ktcd.malc.kt_ma_lc.applicatoin;
//
//import android.content.Context;
//import android.content.ContextWrapper;
//import android.content.pm.PackageManager.NameNotFoundException;
//
//public class AppContext extends ContextWrapper {
//
//    private static AppContext sInstance;
//
//    public static void init(Context context) {
//
//        if (sInstance == null) {
//            try {
//                sInstance = new AppContext(context.createPackageContext(context.getPackageName(),
//                        Context.CONTEXT_INCLUDE_CODE));
//            } catch (NameNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public static AppContext getInstance() {
//
//        return sInstance;
//    }
//
//    private AppContext(Context context) {
//
//        super(context);
//    }
//}
