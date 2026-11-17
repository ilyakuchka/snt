package g3;

/* renamed from: g3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0326c extends C0324a {

    /* renamed from: l, reason: collision with root package name */
    public static final a f6308l = new a();

    /* renamed from: m, reason: collision with root package name */
    private static final C0326c f6309m = new C0326c(1, 0);

    /* renamed from: g3.c$a */
    public static final class a {
    }

    public C0326c(int i2, int i4) {
        super(i2, i4, 1);
    }

    @Override // g3.C0324a
    public final boolean equals(Object obj) {
        if (obj instanceof C0326c) {
            if (!isEmpty() || !((C0326c) obj).isEmpty()) {
                C0326c c0326c = (C0326c) obj;
                if (d() != c0326c.d() || g() != c0326c.g()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // g3.C0324a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return g() + (d() * 31);
    }

    @Override // g3.C0324a
    public final boolean isEmpty() {
        return d() > g();
    }

    @Override // g3.C0324a
    public final String toString() {
        return d() + ".." + g();
    }
}
