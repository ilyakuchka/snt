package n3;

import android.util.Property;

/* renamed from: n3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0355a<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    final String f7493a;

    public AbstractC0355a(String str) {
        super(Float.class, str);
        this.f7493a = str;
    }

    public abstract float a(T t2);

    public abstract void b(T t2, float f4);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public final Float get(Object obj) {
        return obj == 0 ? Float.valueOf(0.0f) : Float.valueOf(a(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public final void set(Object obj, Float f4) {
        Float f5 = f4;
        if (obj != 0) {
            b(obj, f5.floatValue());
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "{mPropertyName='" + this.f7493a + "'}";
    }
}
