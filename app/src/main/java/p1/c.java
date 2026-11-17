package p1;

import android.graphics.drawable.Drawable;
import s1.j;

/* loaded from: classes.dex */
public abstract class c<T> implements f<T> {

    /* renamed from: i, reason: collision with root package name */
    private final int f7576i;

    /* renamed from: j, reason: collision with root package name */
    private final int f7577j;

    /* renamed from: k, reason: collision with root package name */
    private o1.b f7578k;

    public c() {
        if (!j.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f7576i = Integer.MIN_VALUE;
        this.f7577j = Integer.MIN_VALUE;
    }

    @Override // l1.h
    public final void a() {
    }

    @Override // p1.f
    public final void b(o1.b bVar) {
        this.f7578k = bVar;
    }

    @Override // p1.f
    public final void c(Drawable drawable) {
    }

    @Override // l1.h
    public final void d() {
    }

    @Override // l1.h
    public final void e() {
    }

    @Override // p1.f
    public final void f(e eVar) {
        eVar.e(this.f7576i, this.f7577j);
    }

    @Override // p1.f
    public final void g(e eVar) {
    }

    @Override // p1.f
    public final void h(Drawable drawable) {
    }

    @Override // p1.f
    public final o1.b i() {
        return this.f7578k;
    }
}
