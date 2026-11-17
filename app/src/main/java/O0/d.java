package O0;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;

@TargetApi(26)
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private static d f767b = new d();

    /* renamed from: a, reason: collision with root package name */
    private MmsApp f768a = (MmsApp) MmsApp.c();

    private d() {
    }

    static String b(d dVar, String str) {
        String string = Settings.System.getString(dVar.f768a.getContentResolver(), str);
        return TextUtils.isEmpty(string) ? str : string;
    }

    public static d g() {
        return f767b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    @TargetApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String h(int i2) {
        String str;
        if (!C0287t.A(i2)) {
            i();
            return "Mms_Default";
        }
        if (!k()) {
            str = "Channel_Msg_Default";
        } else if (i2 == 0) {
            str = "Channel_Msg_Slot1";
        } else if (i2 == 1) {
            str = "Channel_Msg_Slot2";
        }
        String string = Settings.System.getString(this.f768a.getContentResolver(), str);
        if (TextUtils.isEmpty(string)) {
            string = str;
        }
        MmsApp mmsApp = this.f768a;
        Uri uri = com.android.mmt.transaction.d.f4609m;
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(mmsApp, 2);
        if (j(string, actualDefaultRingtoneUri)) {
            StringBuilder sbD = D2.e.d(str);
            sbD.append(System.currentTimeMillis());
            string = sbD.toString();
            Log.i("MessagingChannelManager", "create new message channelId =" + string);
            e(string, actualDefaultRingtoneUri);
            Settings.System.putString(this.f768a.getContentResolver(), str, string);
        }
        Q2.c.a(new c(this));
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    public void i() {
        if (j("Mms_Default", null)) {
            e("Mms_Default", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return C0287t.y() && Settings.System.getInt(this.f768a.getContentResolver(), "sms_received_sound_use_uniform", -1) == 0;
    }

    @TargetApi(26)
    public final String e(String str, Uri uri) {
        NotificationManager notificationManager = (NotificationManager) MmsApp.c().getSystemService("notification");
        String str2 = a.a(str).f763a;
        String str3 = a.a(str).f764b;
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 4);
        notificationChannel.setDescription(str3);
        notificationChannel.enableLights(true);
        if (uri != null) {
            notificationChannel.setSound(uri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        } else {
            notificationChannel.setSound(null, null);
        }
        if ("Mms_Default".equals(str)) {
            notificationChannel.enableVibration(false);
        } else {
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("Channel_Msg_Group", MmsApp.c().getString(R.string.notification_group_name)));
            notificationChannel.setGroup("Channel_Msg_Group");
        }
        notificationManager.createNotificationChannel(notificationChannel);
        return str;
    }

    @TargetApi(26)
    public final String f(int i2, int i4) {
        if (i2 == 0) {
            throw null;
        }
        int i5 = i2 - 1;
        if (i5 == 0) {
            return h(i4);
        }
        if (i5 != 1) {
            i();
            return "Mms_Default";
        }
        if (j("Mms_Default", null)) {
            e("Mms_Default", null);
        }
        return "Mms_Default";
    }

    @TargetApi(26)
    public final boolean j(String str, Uri uri) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        NotificationChannel notificationChannel = ((NotificationManager) MmsApp.c().getSystemService("notification")).getNotificationChannel(str);
        boolean z4 = notificationChannel == null;
        if (!z4) {
            z4 = !TextUtils.equals(String.valueOf(notificationChannel.getSound()), String.valueOf(uri));
        }
        Log.i("MessagingChannelManager", "needCreateChannel: " + z4);
        return z4;
    }
}
