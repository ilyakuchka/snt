package O0;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ d f765i;

    b(d dVar) {
        this.f765i = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("MessagingChannelManager", "manageAllChannel: ");
        ArrayList arrayList = new ArrayList();
        arrayList.add("Mms_Default");
        if (this.f765i.k()) {
            arrayList.add(d.b(this.f765i, "Channel_Msg_Slot1"));
            arrayList.add(d.b(this.f765i, "Channel_Msg_Slot2"));
        } else {
            arrayList.add(d.b(this.f765i, "Channel_Msg_Default"));
        }
        NotificationManager notificationManager = (NotificationManager) MmsApp.c().getSystemService("notification");
        for (NotificationChannel notificationChannel : notificationManager.getNotificationChannels()) {
            if (arrayList.contains(notificationChannel.getId())) {
                arrayList.remove(notificationChannel.getId());
            } else {
                notificationManager.deleteNotificationChannel(notificationChannel.getId());
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("Channel_Msg_Default")) {
                        this.f765i.h(0);
                    } else if (str.startsWith("Channel_Msg_Slot1")) {
                        this.f765i.h(0);
                    } else if (str.startsWith("Channel_Msg_Slot2")) {
                        this.f765i.h(1);
                    } else if (str.startsWith("Mms_Default")) {
                        this.f765i.i();
                    }
                }
            }
        }
    }
}
