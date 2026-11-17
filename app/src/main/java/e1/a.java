package e1;

import Y0.x;
import java.util.Objects;

/* loaded from: classes.dex */
public class a<T> implements x<T> {

    /* renamed from: i, reason: collision with root package name */
    protected final T f6166i;

    public a(T t2) {
        Objects.requireNonNull(t2, "Argument must not be null");
        this.f6166i = t2;
    }

    @Override // Y0.x
    public final int b() {
        return 1;
    }

    @Override // Y0.x
    public final Class<T> c() {
        return (Class<T>) this.f6166i.getClass();
    }

    @Override // Y0.x
    public final void d() {
    }

    @Override // Y0.x
    public final T get() {
        return this.f6166i;
    }
}
