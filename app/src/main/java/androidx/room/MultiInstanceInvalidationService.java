package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: i, reason: collision with root package name */
    int f4277i = 0;

    /* renamed from: j, reason: collision with root package name */
    final HashMap<Integer, String> f4278j = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    final RemoteCallbackList<androidx.room.a> f4279k = new a();

    /* renamed from: l, reason: collision with root package name */
    private final androidx.room.b f4280l = new b();

    final class a extends RemoteCallbackList<androidx.room.a> {
        a() {
        }

        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(IInterface iInterface, Object obj) {
            MultiInstanceInvalidationService.this.f4278j.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    final class b extends androidx.room.b {
        b() {
        }

        public final void A(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f4279k) {
                String str = MultiInstanceInvalidationService.this.f4278j.get(Integer.valueOf(i2));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = MultiInstanceInvalidationService.this.f4279k.beginBroadcast();
                for (int i4 = 0; i4 < iBeginBroadcast; i4++) {
                    try {
                        int iIntValue = ((Integer) MultiInstanceInvalidationService.this.f4279k.getBroadcastCookie(i4)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f4278j.get(Integer.valueOf(iIntValue));
                        if (i2 != iIntValue && str.equals(str2)) {
                            try {
                                ((androidx.room.a) MultiInstanceInvalidationService.this.f4279k.getBroadcastItem(i4)).t(strArr);
                            } catch (RemoteException e2) {
                                Log.w("ROOM", "Error invoking a remote callback", e2);
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.f4279k.finishBroadcast();
                    }
                }
            }
        }

        public final int B(androidx.room.a aVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f4279k) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.f4277i + 1;
                multiInstanceInvalidationService.f4277i = i2;
                if (multiInstanceInvalidationService.f4279k.register(aVar, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.f4278j.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f4277i--;
                return 0;
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f4280l;
    }
}
