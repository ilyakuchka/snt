package s1;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f7862a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f7863b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f7864c;

    public i() {
    }

    public final void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f7862a = cls;
        this.f7863b = cls2;
        this.f7864c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f7862a.equals(iVar.f7862a) && this.f7863b.equals(iVar.f7863b) && j.b(this.f7864c, iVar.f7864c);
    }

    public final int hashCode() {
        int iHashCode = (this.f7863b.hashCode() + (this.f7862a.hashCode() * 31)) * 31;
        Class<?> cls = this.f7864c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("MultiClassKey{first=");
        sbD.append(this.f7862a);
        sbD.append(", second=");
        sbD.append(this.f7863b);
        sbD.append('}');
        return sbD.toString();
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
