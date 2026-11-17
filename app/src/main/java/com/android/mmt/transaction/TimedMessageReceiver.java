package com.android.mmt.transaction;

import P0.r;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.android.mmt.util.O;

/* loaded from: classes.dex */
public class TimedMessageReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f4548a = Uri.parse("content://sms/sent");

    /* renamed from: b, reason: collision with root package name */
    private static final Uri f4549b = Uri.parse("content://mms/sent");

    public static void a(Context context) {
        long jMin;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Cursor cursorE = O.e(context, context.getContentResolver(), f4548a, new String[]{"date"}, "timed > 0", null, "date ASC");
        if (cursorE != null) {
            try {
                jMin = cursorE.moveToFirst() ? cursorE.getLong(0) : Long.MAX_VALUE;
            } finally {
            }
        } else {
            jMin = Long.MAX_VALUE;
        }
        cursorE = O.e(context, context.getContentResolver(), f4549b, new String[]{"date_full"}, "timed > 0", null, "date_full ASC");
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    jMin = Math.min(cursorE.getLong(0), jMin);
                }
            } finally {
            }
        }
        if (jMin < Long.MAX_VALUE) {
            Y1.a.k("Scheduled next timed message at %d (%s)", Long.valueOf(jMin), r.r(context, jMin, false));
            Intent intent = new Intent(context, (Class<?>) TimedMessageReceiver.class);
            intent.setAction("com.android.mmt.transaction.TIMED_MESSAGE");
            alarmManager.set(0, jMin, PendingIntent.getBroadcast(context, 0, intent, 335544320));
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("com.android.mmt.transaction.TIMED_MESSAGE".equals(intent.getAction())) {
            int i2 = SendMessageService.f4514k;
            Intent intent2 = new Intent(context, (Class<?>) SendMessageService.class);
            intent2.setAction("com.android.mmt.transaction.ACTION_SEND_TIMED_MESSAGE");
            context.startService(intent2);
        }
    }
}
