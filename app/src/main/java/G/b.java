package G;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0008b f133a;

    private static final class a implements InterfaceC0008b {

        /* renamed from: a, reason: collision with root package name */
        final InputContentInfo f134a;

        a(Object obj) {
            this.f134a = (InputContentInfo) obj;
        }

        @Override // G.b.InterfaceC0008b
        public final void a() {
            this.f134a.requestPermission();
        }

        @Override // G.b.InterfaceC0008b
        public final Object b() {
            return this.f134a;
        }
    }

    /* renamed from: G.b$b, reason: collision with other inner class name */
    private interface InterfaceC0008b {
        void a();

        Object b();
    }

    private b(InterfaceC0008b interfaceC0008b) {
        this.f133a = interfaceC0008b;
    }

    public static b f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new b(new a(obj));
    }

    public final Uri a() {
        return ((a) this.f133a).f134a.getContentUri();
    }

    public final ClipDescription b() {
        return ((a) this.f133a).f134a.getDescription();
    }

    public final Uri c() {
        return ((a) this.f133a).f134a.getLinkUri();
    }

    public final void d() {
        this.f133a.a();
    }

    public final Object e() {
        return this.f133a.b();
    }
}
