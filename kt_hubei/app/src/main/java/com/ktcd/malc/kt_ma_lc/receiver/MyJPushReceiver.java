////package com.ktcd.malc.kt_ma_lc.receiver;
////
////import android.app.PendingIntent;
////import android.content.BroadcastReceiver;
////import android.content.Context;
////import android.content.Intent;
////import android.os.Bundle;
////
////import com.google.gson.Gson;
////import com.ktcd.malc.kt_ma_lc.activity.HomeTabActivity;
////import com.ktcd.malc.kt_ma_lc.model.JpushParm;
////
////
////import cn.jpush.android.api.JPushInterface;
////
/////**
//// * @author amos_bo 284285624@qq.com
//// * @ClassName: MyJPushReceiver
//// * @Description: 接送推送消息
//// * @date 2015年11月4日 下午4:10:59
//// */
////public class MyJPushReceiver extends BroadcastReceiver {
////
//////    private static JPushDataInfo mJpushDataInfo;
//////    private static JPushResult mJPushResult;
////
////      private static JpushParm mJpushParm;
////    @Override
////    public void onReceive(Context context, Intent intent) {
////        Bundle bundle = intent.getExtras();
////        if (bundle != null) {
////            if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals( intent
////                    .getAction() )) {
////                System.out.println( "收到了自定义消息。消息内容是：" + bundle.getString(
////                        JPushInterface.EXTRA_MESSAGE ) );
////                System.out.println( "EXTRA_EXTRA。消息内容是：" + bundle.getString(
////                        JPushInterface.EXTRA_EXTRA ) );
////                // 自定义消息不会展示在通知栏，完全要开发者写代码去处理
////                Gson gson=new Gson();
////                mJpushParm=gson.fromJson(bundle.getString(JPushInterface.EXTRA_EXTRA ), JpushParm.class);
////            } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(
////                    intent.getAction() )) {
////                System.out.println( "收到了通知" );
////                // 在这里可以做些统计，或者做些其他工作
////            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(
////                    intent.getAction() )) {
////
////                Intent intentSecnd = new Intent(context, HomeTabActivity.class);
////                intentSecnd.putExtra("id",mJpushParm.businessId);
////                Intent[] intents = new Intent[1];
////                intents[0] = intentSecnd;
////                PendingIntent mPendingIntent = PendingIntent.getActivities(context, 0,
////                        intents, 0 );
////                try {
////                    mPendingIntent.send();
////                } catch (PendingIntent.CanceledException e) {
////                    e.printStackTrace();
////                }
//
//
//
////                if (TextUtils.isEmpty(""+mJpushDataInfo.TypeID)){
////                    return;
////                }
////                switch (mJpushDataInfo.TypeID) {
////                    //任务通知
////                    case 0:
////                        break;
////                    //公告通知
////                    case 1:
////                        break;
////                    case 3:
////                        break;
////                    //客户动态
////                    case 2:
////                        Bundle mybundle2 = new Bundle();
////                        if (!StringUtils.isEmpty( mJpushDataInfo.Param1 )) {
////                            mybundle2.putInt( "CustomerID", Integer.parseInt
////                                    ( mJpushDataInfo.Param1 ) );
////                            mybundle2.putInt( "PAGE_NUMBER", Integer.parseInt
////                                    ( mJpushDataInfo.Param2 ) );
////                            startActivites(context,CustomerDetailActivity.class,mybundle2);
////                        }
////                        break;
////                }
//            }
//        }
//    }
//
////    private void startActivites(Context context,  Class<?> activity,Bundle bundle) {
////        Intent intentIndex = new Intent(context, GuideMainActivity.class );
////        Intent intentSecnd = new Intent(context,activity);
////        intentSecnd.putExtras(bundle);
////        Intent[] intents = new Intent[2];
////        intents[0] = intentIndex;
////        intents[1] = intentSecnd;
////        PendingIntent mPendingIntent = PendingIntent.getActivities(context, 0,
////                intents, 0 );
////        try {
////            mPendingIntent.send();
////        } catch (PendingIntent.CanceledException e) {
////            e.printStackTrace();
////        }
//    }
//}
