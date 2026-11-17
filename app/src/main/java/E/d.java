package E;

/* loaded from: classes.dex */
public final class d<T> extends c<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Object f90c;

    public d(int i2) {
        super(i2);
        this.f90c = new Object();
    }

    @Override // E.c, E.b
    public final boolean a(T t2) {
        boolean zA;
        synchronized (this.f90c) {
            zA = super.a(t2);
        }
        return zA;
    }

    @Override // E.c, E.b
    public final T b() {
        T t2;
        synchronized (this.f90c) {
            t2 = (T) super.b();
        }
        return t2;
    }
}
