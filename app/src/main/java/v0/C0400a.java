package v0;

/* renamed from: v0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0400a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile InterfaceC0402c f7960a;

    C0400a() {
    }

    public static InterfaceC0402c a() {
        if (f7960a == null) {
            synchronized (C0401b.class) {
                if (f7960a == null) {
                    f7960a = new C0403d();
                }
            }
        }
        return f7960a;
    }
}
