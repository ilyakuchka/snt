package T2;

import T2.b;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* loaded from: classes.dex */
final class a extends Handler {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f1556f = 0;

    /* renamed from: a, reason: collision with root package name */
    private Handler f1557a;

    /* renamed from: b, reason: collision with root package name */
    private e f1558b;

    /* renamed from: c, reason: collision with root package name */
    private long f1559c;
    b.C0038b d;

    /* renamed from: e, reason: collision with root package name */
    HandlerThread f1560e;

    public a(HandlerThread handlerThread, e eVar, Handler handler) {
        super(handlerThread.getLooper());
        this.f1560e = handlerThread;
        this.f1559c = 1048576L;
        this.f1558b = eVar;
        this.f1557a = handler;
    }

    protected final void finalize() throws Throwable {
        this.f1560e.quit();
        super.finalize();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            b.C0038b c0038bB = b.b(this.f1558b, this.f1559c, message.arg1);
            b.C0038b c0038b = this.d;
            c0038b.f1567a = c0038bB.f1567a;
            c0038b.f1568b = c0038bB.f1568b;
            this.f1557a.sendEmptyMessage(1);
        }
    }
}
