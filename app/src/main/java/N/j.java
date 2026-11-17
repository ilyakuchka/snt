package N;

import N.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.x;
import androidx.recyclerview.widget.k;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class j<T, VH extends RecyclerView.x> extends RecyclerView.e<VH> {

    /* renamed from: c, reason: collision with root package name */
    final N.a<T> f687c;
    private final a.b<T> d;

    final class a implements a.b<T> {
        a() {
        }

        @Override // N.a.b
        public final void a(i iVar) {
            j.this.H(iVar);
            Objects.requireNonNull(j.this);
        }
    }

    protected j(k.d<T> dVar) {
        a aVar = new a();
        this.d = aVar;
        N.a<T> aVar2 = new N.a<>(this, dVar);
        this.f687c = aVar2;
        aVar2.a(aVar);
    }

    protected T G(int i2) {
        return this.f687c.b(i2);
    }

    @Deprecated
    public void H(i<T> iVar) {
    }

    public void I(i<T> iVar) {
        this.f687c.f(iVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int j() {
        return this.f687c.c();
    }
}
