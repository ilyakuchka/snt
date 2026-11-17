package a1;

import Y0.m;
import Y0.x;
import a1.i;
import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public final class h extends s1.g<V0.f, x<?>> implements i {
    private i.a d;

    public h(long j2) {
        super(j2);
    }

    @Override // s1.g
    protected final int d(x<?> xVar) {
        x<?> xVar2 = xVar;
        if (xVar2 == null) {
            return 1;
        }
        return xVar2.b();
    }

    @Override // s1.g
    protected final void e(V0.f fVar, x<?> xVar) {
        x<?> xVar2 = xVar;
        i.a aVar = this.d;
        if (aVar == null || xVar2 == null) {
            return;
        }
        ((m) aVar).g(xVar2);
    }

    public final void i(i.a aVar) {
        this.d = aVar;
    }

    @SuppressLint({"InlinedApi"})
    public final void j(int i2) {
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            h(c() / 2);
        }
    }
}
