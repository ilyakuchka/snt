package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class b implements Q.b {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView.e f4125a;

    public b(RecyclerView.e eVar) {
        this.f4125a = eVar;
    }

    @Override // Q.b
    public final void a(int i2, int i4) {
        this.f4125a.u(i2, i4);
    }

    @Override // Q.b
    public final void b(int i2, int i4) {
        this.f4125a.t(i2, i4);
    }

    @Override // Q.b
    public final void c(int i2, int i4) {
        this.f4125a.r(i2, i4);
    }

    @Override // Q.b
    public final void d(int i2, int i4, Object obj) {
        this.f4125a.s(i2, i4, obj);
    }
}
