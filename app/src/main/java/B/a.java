package B;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0000a f11b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12c;

    /* renamed from: B.a$a, reason: collision with other inner class name */
    public interface InterfaceC0000a {
        void a();
    }

    public final void a() {
        synchronized (this) {
            if (this.f10a) {
                return;
            }
            this.f10a = true;
            this.f12c = true;
            InterfaceC0000a interfaceC0000a = this.f11b;
            if (interfaceC0000a != null) {
                try {
                    interfaceC0000a.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f12c = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            synchronized (this) {
                this.f12c = false;
                notifyAll();
            }
        }
    }

    public final void b(InterfaceC0000a interfaceC0000a) {
        synchronized (this) {
            while (this.f12c) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f11b == interfaceC0000a) {
                return;
            }
            this.f11b = interfaceC0000a;
            if (this.f10a) {
                interfaceC0000a.a();
            }
        }
    }
}
