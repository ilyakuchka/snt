package r;

/* renamed from: r.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0373f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f7675a = new Object[256];

    /* renamed from: b, reason: collision with root package name */
    private int f7676b;

    C0373f() {
    }

    public final T a() {
        int i2 = this.f7676b;
        if (i2 <= 0) {
            return null;
        }
        int i4 = i2 - 1;
        Object[] objArr = this.f7675a;
        T t2 = (T) objArr[i4];
        objArr[i4] = null;
        this.f7676b = i2 - 1;
        return t2;
    }

    public final boolean b(T t2) {
        int i2 = this.f7676b;
        Object[] objArr = this.f7675a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t2;
        this.f7676b = i2 + 1;
        return true;
    }

    public final void c(T[] tArr, int i2) {
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            T t2 = tArr[i4];
            int i5 = this.f7676b;
            Object[] objArr = this.f7675a;
            if (i5 < objArr.length) {
                objArr[i5] = t2;
                this.f7676b = i5 + 1;
            }
        }
    }
}
