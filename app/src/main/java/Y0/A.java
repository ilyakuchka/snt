package Y0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
final class A {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1895a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f1896b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((x) message.obj).d();
            return true;
        }
    }

    A() {
    }

    final synchronized void a(x<?> xVar, boolean z4) {
        if (this.f1895a || z4) {
            this.f1896b.obtainMessage(1, xVar).sendToTarget();
        } else {
            this.f1895a = true;
            xVar.d();
            this.f1895a = false;
        }
    }
}
