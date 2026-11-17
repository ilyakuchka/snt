package a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimatedRotateDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.telephony.SmsMessage;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0178a {
    public static void a(NotificationManager notificationManager, int i2, UserHandle userHandle) {
        notificationManager.cancelAsUser(null, i2, userHandle);
    }

    public static boolean b(String str, String str2) {
        return PhoneNumberUtils.compareLoosely(str, str2);
    }

    public static PendingIntent c(Context context, Intent intent, UserHandle userHandle) {
        return PendingIntent.getActivityAsUser(context, 0, intent, 67108864, null, userHandle);
    }

    public static int d(Context context, int i2) {
        return ((TelephonyManager) context.getSystemService(TelephonyManager.class)).getCallState(i2);
    }

    public static int e(Context context, int i2) {
        return ((TelephonyManager) context.getSystemService(TelephonyManager.class)).getCurrentPhoneType(i2);
    }

    public static String f(Context context, int i2) {
        return ((TelephonyManager) context.getSystemService(TelephonyManager.class)).getLine1Number(i2);
    }

    public static int g(int i2) {
        return SubscriptionManager.getPhoneId(i2);
    }

    public static String h(SmsMessage smsMessage) {
        return smsMessage.getRecipientAddress();
    }

    public static String i(Context context, int i2) {
        return ((TelephonyManager) context.getSystemService(TelephonyManager.class)).getSimOperator(i2);
    }

    public static String j(int i2, String str) {
        return TelephonyManager.getTelephonyProperty(i2, str, "");
    }

    public static boolean k(Context context, int i2) {
        return ((TelephonyManager) context.getSystemService(TelephonyManager.class)).hasIccCard(i2);
    }

    public static boolean l(Context context, int i2) {
        return ((TelephonyManager) context.getSystemService(TelephonyManager.class)).isNetworkRoaming(i2);
    }

    public static boolean m(SmsMessage smsMessage) {
        return smsMessage.mWrappedSmsMessage == null;
    }

    public static ServiceState n(Bundle bundle) {
        return ServiceState.newFromBundle(bundle);
    }

    public static void o(NotificationManager notificationManager, int i2, Notification notification, UserHandle userHandle) {
        notificationManager.notifyAsUser(null, i2, notification, userHandle);
    }

    public static void p(Drawable drawable) {
        if (drawable instanceof AnimatedRotateDrawable) {
            AnimatedRotateDrawable animatedRotateDrawable = (AnimatedRotateDrawable) drawable;
            animatedRotateDrawable.setFramesCount(60);
            animatedRotateDrawable.setFramesDuration(20);
        }
    }
}
