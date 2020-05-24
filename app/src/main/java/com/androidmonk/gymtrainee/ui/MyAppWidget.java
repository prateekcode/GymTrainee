package com.androidmonk.gymtrainee.ui;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.androidmonk.gymtrainee.R;

public class MyAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++){
            int appWidgetId = appWidgetIds[i];
            Intent intent = new Intent(context, FavoriteActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            views.setOnClickPendingIntent(R.id.widget_btn, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }

    }
}
