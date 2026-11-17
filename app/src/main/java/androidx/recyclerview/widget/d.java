package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    final b f4131a;

    /* renamed from: b, reason: collision with root package name */
    final a f4132b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List<View> f4133c = new ArrayList();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        long f4134a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f4135b;

        a() {
        }

        private void c() {
            if (this.f4135b == null) {
                this.f4135b = new a();
            }
        }

        final void a(int i2) {
            if (i2 < 64) {
                this.f4134a &= ~(1 << i2);
                return;
            }
            a aVar = this.f4135b;
            if (aVar != null) {
                aVar.a(i2 - 64);
            }
        }

        final int b(int i2) {
            a aVar = this.f4135b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f4134a);
                }
                return Long.bitCount(((1 << i2) - 1) & this.f4134a);
            }
            if (i2 < 64) {
                return Long.bitCount(((1 << i2) - 1) & this.f4134a);
            }
            return Long.bitCount(this.f4134a) + aVar.b(i2 - 64);
        }

        final boolean d(int i2) {
            if (i2 < 64) {
                return ((1 << i2) & this.f4134a) != 0;
            }
            c();
            return this.f4135b.d(i2 - 64);
        }

        final void e(int i2, boolean z4) {
            if (i2 >= 64) {
                c();
                this.f4135b.e(i2 - 64, z4);
                return;
            }
            long j2 = this.f4134a;
            boolean z5 = (Long.MIN_VALUE & j2) != 0;
            long j4 = (1 << i2) - 1;
            this.f4134a = ((j2 & (~j4)) << 1) | (j2 & j4);
            if (z4) {
                h(i2);
            } else {
                a(i2);
            }
            if (z5 || this.f4135b != null) {
                c();
                this.f4135b.e(0, z5);
            }
        }

        final boolean f(int i2) {
            if (i2 >= 64) {
                c();
                return this.f4135b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j4 = this.f4134a;
            boolean z4 = (j4 & j2) != 0;
            long j5 = j4 & (~j2);
            this.f4134a = j5;
            long j6 = j2 - 1;
            this.f4134a = (j5 & j6) | Long.rotateRight((~j6) & j5, 1);
            a aVar = this.f4135b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f4135b.f(0);
            }
            return z4;
        }

        final void g() {
            this.f4134a = 0L;
            a aVar = this.f4135b;
            if (aVar != null) {
                aVar.g();
            }
        }

        final void h(int i2) {
            if (i2 < 64) {
                this.f4134a |= 1 << i2;
            } else {
                c();
                this.f4135b.h(i2 - 64);
            }
        }

        public final String toString() {
            if (this.f4135b == null) {
                return Long.toBinaryString(this.f4134a);
            }
            return this.f4135b.toString() + "xx" + Long.toBinaryString(this.f4134a);
        }
    }

    interface b {
    }

    d(b bVar) {
        this.f4131a = bVar;
    }

    private int f(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int iB = ((t) this.f4131a).b();
        int i4 = i2;
        while (i4 < iB) {
            int iB2 = i2 - (i4 - this.f4132b.b(i4));
            if (iB2 == 0) {
                while (this.f4132b.d(i4)) {
                    i4++;
                }
                return i4;
            }
            i4 += iB2;
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    private void j(View view) {
        this.f4133c.add(view);
        t tVar = (t) this.f4131a;
        Objects.requireNonNull(tVar);
        RecyclerView.x xVarN = RecyclerView.N(view);
        if (xVarN != null) {
            xVarN.s(tVar.f4261a);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    private boolean q(View view) {
        if (!this.f4133c.remove(view)) {
            return false;
        }
        t tVar = (t) this.f4131a;
        Objects.requireNonNull(tVar);
        RecyclerView.x xVarN = RecyclerView.N(view);
        if (xVarN == null) {
            return true;
        }
        xVarN.u(tVar.f4261a);
        return true;
    }

    final void a(View view, int i2, boolean z4) {
        int iB = i2 < 0 ? ((t) this.f4131a).b() : f(i2);
        this.f4132b.e(iB, z4);
        if (z4) {
            j(view);
        }
        t tVar = (t) this.f4131a;
        tVar.f4261a.addView(view, iB);
        RecyclerView recyclerView = tVar.f4261a;
        Objects.requireNonNull(recyclerView);
        RecyclerView.x xVarN = RecyclerView.N(view);
        RecyclerView.e eVar = recyclerView.f3963t;
        if (eVar == null || xVarN == null) {
            return;
        }
        eVar.B(xVarN);
    }

    final void b(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z4) {
        int iB = i2 < 0 ? ((t) this.f4131a).b() : f(i2);
        this.f4132b.e(iB, z4);
        if (z4) {
            j(view);
        }
        t tVar = (t) this.f4131a;
        Objects.requireNonNull(tVar);
        RecyclerView.x xVarN = RecyclerView.N(view);
        if (xVarN != null) {
            if (!xVarN.p() && !xVarN.y()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + xVarN + tVar.f4261a.C());
            }
            xVarN.f4063r &= -257;
        }
        tVar.f4261a.attachViewToParent(view, iB, layoutParams);
    }

    final void c(int i2) {
        RecyclerView.x xVarN;
        int iF = f(i2);
        this.f4132b.f(iF);
        t tVar = (t) this.f4131a;
        View viewA = tVar.a(iF);
        if (viewA != null && (xVarN = RecyclerView.N(viewA)) != null) {
            if (xVarN.p() && !xVarN.y()) {
                throw new IllegalArgumentException("called detach on an already detached child " + xVarN + tVar.f4261a.C());
            }
            xVarN.e(256);
        }
        tVar.f4261a.detachViewFromParent(iF);
    }

    final View d(int i2) {
        return ((t) this.f4131a).a(f(i2));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    final int e() {
        return ((t) this.f4131a).b() - this.f4133c.size();
    }

    final View g(int i2) {
        return ((t) this.f4131a).a(i2);
    }

    final int h() {
        return ((t) this.f4131a).b();
    }

    final void i(View view) {
        int iC = ((t) this.f4131a).c(view);
        if (iC >= 0) {
            this.f4132b.h(iC);
            j(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    final int k(View view) {
        int iC = ((t) this.f4131a).c(view);
        if (iC == -1 || this.f4132b.d(iC)) {
            return -1;
        }
        return iC - this.f4132b.b(iC);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    final boolean l(View view) {
        return this.f4133c.contains(view);
    }

    final void m(View view) {
        int iC = ((t) this.f4131a).c(view);
        if (iC < 0) {
            return;
        }
        if (this.f4132b.f(iC)) {
            q(view);
        }
        ((t) this.f4131a).d(iC);
    }

    final void n(int i2) {
        int iF = f(i2);
        View viewA = ((t) this.f4131a).a(iF);
        if (viewA == null) {
            return;
        }
        if (this.f4132b.f(iF)) {
            q(viewA);
        }
        ((t) this.f4131a).d(iF);
    }

    final boolean o(View view) {
        int iC = ((t) this.f4131a).c(view);
        if (iC == -1) {
            q(view);
            return true;
        }
        if (!this.f4132b.d(iC)) {
            return false;
        }
        this.f4132b.f(iC);
        q(view);
        ((t) this.f4131a).d(iC);
        return true;
    }

    final void p(View view) {
        int iC = ((t) this.f4131a).c(view);
        if (iC < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f4132b.d(iC)) {
            this.f4132b.a(iC);
            q(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    public final String toString() {
        return this.f4132b.toString() + ", hidden list:" + this.f4133c.size();
    }
}
