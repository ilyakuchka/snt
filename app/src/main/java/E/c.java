package E;

/* loaded from: classes.dex */
public class c<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f88a;

    /* renamed from: b, reason: collision with root package name */
    private int f89b;

    public c(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f88a = new Object[i2];
    }

    @Override // E.b
    public boolean a(T t2) {
        int i2;
        boolean z4;
        int i4 = 0;
        while (true) {
            i2 = this.f89b;
            if (i4 >= i2) {
                z4 = false;
                break;
            }
            if (this.f88a[i4] == t2) {
                z4 = true;
                break;
            }
            i4++;
        }
        if (z4) {
            throw new IllegalStateException("Already in the pool!");
        }
        Object[] objArr = this.f88a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t2;
        this.f89b = i2 + 1;
        return true;
    }

    @Override // E.b
    public T b() {
        int i2 = this.f89b;
        if (i2 <= 0) {
            return null;
        }
        int i4 = i2 - 1;
        Object[] objArr = this.f88a;
        T t2 = (T) objArr[i4];
        objArr[i4] = null;
        this.f89b = i2 - 1;
        return t2;
    }
}
