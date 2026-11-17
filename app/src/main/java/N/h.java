package N;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class h<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final h f652e;

    /* renamed from: a, reason: collision with root package name */
    public final List<T> f653a;

    /* renamed from: b, reason: collision with root package name */
    public final int f654b;

    /* renamed from: c, reason: collision with root package name */
    public final int f655c;
    public final int d;

    static abstract class a<T> {
        a() {
        }

        public abstract void a(int i2, h<T> hVar);
    }

    static {
        Collections.emptyList();
        f652e = new h(Collections.emptyList(), 0);
    }

    h(List<T> list, int i2, int i4, int i5) {
        this.f653a = list;
        this.f654b = i2;
        this.f655c = i4;
        this.d = i5;
    }

    static <T> h<T> a() {
        return f652e;
    }

    public final boolean b() {
        return this == f652e;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Result ");
        sbD.append(this.f654b);
        sbD.append(", ");
        sbD.append(this.f653a);
        sbD.append(", ");
        sbD.append(this.f655c);
        sbD.append(", offset ");
        sbD.append(this.d);
        return sbD.toString();
    }

    h(List<T> list, int i2) {
        this.f653a = list;
        this.f654b = 0;
        this.f655c = 0;
        this.d = i2;
    }
}
