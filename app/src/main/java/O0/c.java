package O0;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.util.Log;
import com.android.mmt.MmsApp;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ d f766i;

    c(d dVar) {
        this.f766i = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String id;
        Log.i("MessagingChannelManager", "delete all excess channels");
        ArrayList arrayList = new ArrayList();
        arrayList.add("Mms_Default");
        if (this.f766i.k()) {
            arrayList.add(d.b(this.f766i, "Channel_Msg_Slot1"));
            arrayList.add(d.b(this.f766i, "Channel_Msg_Slot2"));
        } else {
            arrayList.add(d.b(this.f766i, "Channel_Msg_Default"));
        }
        NotificationManager notificationManager = (NotificationManager) MmsApp.c().getSystemService("notification");
        for (NotificationChannel notificationChannel : notificationManager.getNotificationChannels()) {
            if (!arrayList.contains(notificationChannel.getId()) && (id = notificationChannel.getId()) != null && !id.startsWith("mipush|")) {
                try {
                    Log.i("MessagingChannelManager", "deleteNotificationChannel:" + id);
                    notificationManager.deleteNotificationChannel(id);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
