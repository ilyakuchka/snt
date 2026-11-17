package androidx.fragment.app;

import androidx.lifecycle.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class E {

    /* renamed from: b, reason: collision with root package name */
    int f3384b;

    /* renamed from: c, reason: collision with root package name */
    int f3385c;
    int d;

    /* renamed from: e, reason: collision with root package name */
    int f3386e;

    /* renamed from: f, reason: collision with root package name */
    int f3387f;
    boolean g;

    /* renamed from: i, reason: collision with root package name */
    String f3389i;

    /* renamed from: j, reason: collision with root package name */
    int f3390j;

    /* renamed from: k, reason: collision with root package name */
    CharSequence f3391k;

    /* renamed from: l, reason: collision with root package name */
    int f3392l;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f3393m;

    /* renamed from: n, reason: collision with root package name */
    ArrayList<String> f3394n;

    /* renamed from: o, reason: collision with root package name */
    ArrayList<String> f3395o;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<a> f3383a = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    boolean f3388h = true;
    boolean p = false;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f3396a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f3397b;

        /* renamed from: c, reason: collision with root package name */
        int f3398c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        int f3399e;

        /* renamed from: f, reason: collision with root package name */
        int f3400f;
        g.c g;

        /* renamed from: h, reason: collision with root package name */
        g.c f3401h;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f3396a = i2;
            this.f3397b = fragment;
            g.c cVar = g.c.RESUMED;
            this.g = cVar;
            this.f3401h = cVar;
        }
    }

    E() {
    }

    public final E b(int i2, Fragment fragment, String str) {
        k(i2, fragment, str, 1);
        return this;
    }

    public final E c(Fragment fragment) {
        k(0, fragment, "com.bumptech.glide.manager", 1);
        return this;
    }

    final void d(a aVar) {
        this.f3383a.add(aVar);
        aVar.f3398c = this.f3384b;
        aVar.d = this.f3385c;
        aVar.f3399e = this.d;
        aVar.f3400f = this.f3386e;
    }

    public final E e() {
        if (!this.f3388h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.g = true;
        this.f3389i = null;
        return this;
    }

    public final E f(Fragment fragment) {
        d(new a(7, fragment));
        return this;
    }

    public abstract int g();

    public abstract int h();

    public abstract E i(Fragment fragment);

    public final E j() {
        if (this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f3388h = false;
        return this;
    }

    abstract void k(int i2, Fragment fragment, String str, int i4);

    public abstract E l(Fragment fragment);

    public abstract boolean m();

    public abstract E n(Fragment fragment);

    public final E o(int i2, Fragment fragment, String str) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        k(i2, fragment, str, 2);
        return this;
    }

    public abstract E p(Fragment fragment);
}
