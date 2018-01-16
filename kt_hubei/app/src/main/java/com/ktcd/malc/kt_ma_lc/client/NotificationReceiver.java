/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ktcd.malc.kt_ma_lc.client;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.ktcd.malc.kt_ma_lc.activity.HomeTabActivity;
import com.ktcd.malc.kt_ma_lc.activity.OrderDetailsActivity;
import com.ktcd.malc.kt_ma_lc.responseparam.PushParmInfo;
import com.ktcd.malc.utilslibrary.tools.GsonUtils;

/**
 * Broadcast receiver that handles push notification messages from the server.
 * This should be registered as receiver in AndroidManifest.xml.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public final class NotificationReceiver extends BroadcastReceiver {

    private static final String LOGTAG = LogUtil
            .makeLogTag(NotificationReceiver.class);

    //    private NotificationService notificationService;


    public static final String PUSH_NOTIFICATION_TYPE_DIRECTIVE = "directive";

    /**消息推送类型-公告*/
    public static final String PUSH_NOTIFICATION_TYPE_ANNOUNCEMENT = "announcement";

    /**消息推送类型-事件进展*/
    public static final String PUSH_NOTIFICATION_TYPE_EVENT_EVOLUTION = "eventEvolution";

    public NotificationReceiver() {
    }

    //    public NotificationReceiver(NotificationService notificationService) {
    //        this.notificationService = notificationService;
    //    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(LOGTAG, "NotificationReceiver.onReceive()...");
        String action = intent.getAction();
        Log.d(LOGTAG, "action=" + action);

        if (Constants.ACTION_SHOW_NOTIFICATION.equals(action)) {
            String notificationId = intent
                    .getStringExtra(Constants.NOTIFICATION_ID);
            String notificationApiKey = intent
                    .getStringExtra(Constants.NOTIFICATION_API_KEY);
            String notificationTitle = intent
                    .getStringExtra(Constants.NOTIFICATION_TITLE);
            String notificationMessage = intent
                    .getStringExtra(Constants.NOTIFICATION_MESSAGE);
            String notificationUri = intent
                    .getStringExtra(Constants.NOTIFICATION_URI);

            Log.d(LOGTAG, "notificationId=" + notificationId);
            Log.d(LOGTAG, "notificationApiKey=" + notificationApiKey);
            Log.d(LOGTAG, "notificationTitle=" + notificationTitle);
            Log.d(LOGTAG, "notificationMessage=" + notificationMessage);
            Log.d(LOGTAG, "notificationUri=" + notificationUri);
            Notifier notifier = new Notifier(context);
            notifier.notify(notificationId, notificationApiKey,
                    notificationTitle, notificationMessage, notificationUri);
        }
    }

    private void startActivites(Context context, Class<?> activity, Bundle bundle) {
        Intent intentIndex = new Intent(context, HomeTabActivity.class);
        Intent intentSecnd = new Intent(context, activity);
        intentSecnd.putExtras(bundle);
        Intent[] intents = new Intent[2];
        intents[0] = intentIndex;
        intents[1] = intentSecnd;
        PendingIntent mPendingIntent = PendingIntent.getActivities(context, 0,
                intents, 0);
        try {
            mPendingIntent.send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }
}
