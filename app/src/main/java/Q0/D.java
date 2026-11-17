package Q0;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class D extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f1068a;

    D(F f4) {
        this.f1068a = f4;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        RecyclerView recyclerView;
        int i2 = message.what;
        if (2 == i2) {
            this.f1068a.f1141r0 = true;
            return;
        }
        if (1 == i2 && (recyclerView = this.f1068a.f1136k0) != null && ((LinearLayoutManager) recyclerView.P()).Y0() == 0) {
            try {
                try {
                    if (this.f1068a.f1074D0) {
                        sendEmptyMessageDelayed(2, 100L);
                    }
                    Method declaredMethod = Activity.class.getDeclaredMethod(this.f1068a.f1074D0 ? "notifyRemoveSnapshotQs" : "notifyTakeSnapshotQs", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f1068a.x(), new Object[0]);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.f1068a.f1074D0 = false;
            }
        }
    }
}
