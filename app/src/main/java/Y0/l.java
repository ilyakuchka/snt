package Y0;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f1981a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final l f1982b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final l f1983c = new c();
    public static final l d = new d();

    final class a extends l {
        a() {
        }

        @Override // Y0.l
        public final boolean a() {
            return false;
        }

        @Override // Y0.l
        public final boolean b() {
            return false;
        }

        @Override // Y0.l
        public final boolean c(V0.a aVar) {
            return false;
        }

        @Override // Y0.l
        public final boolean d(boolean z4, V0.a aVar, V0.c cVar) {
            return false;
        }
    }

    final class b extends l {
        b() {
        }

        @Override // Y0.l
        public final boolean a() {
            return true;
        }

        @Override // Y0.l
        public final boolean b() {
            return false;
        }

        @Override // Y0.l
        public final boolean c(V0.a aVar) {
            return (aVar == V0.a.f1749k || aVar == V0.a.f1751m) ? false : true;
        }

        @Override // Y0.l
        public final boolean d(boolean z4, V0.a aVar, V0.c cVar) {
            return false;
        }
    }

    final class c extends l {
        c() {
        }

        @Override // Y0.l
        public final boolean a() {
            return false;
        }

        @Override // Y0.l
        public final boolean b() {
            return true;
        }

        @Override // Y0.l
        public final boolean c(V0.a aVar) {
            return false;
        }

        @Override // Y0.l
        public final boolean d(boolean z4, V0.a aVar, V0.c cVar) {
            return (aVar == V0.a.f1750l || aVar == V0.a.f1751m) ? false : true;
        }
    }

    final class d extends l {
        d() {
        }

        @Override // Y0.l
        public final boolean a() {
            return true;
        }

        @Override // Y0.l
        public final boolean b() {
            return true;
        }

        @Override // Y0.l
        public final boolean c(V0.a aVar) {
            return aVar == V0.a.f1748j;
        }

        @Override // Y0.l
        public final boolean d(boolean z4, V0.a aVar, V0.c cVar) {
            return ((z4 && aVar == V0.a.f1749k) || aVar == V0.a.f1747i) && cVar == V0.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(V0.a aVar);

    public abstract boolean d(boolean z4, V0.a aVar, V0.c cVar);
}
