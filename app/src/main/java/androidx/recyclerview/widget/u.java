package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;

/* loaded from: classes.dex */
final class u implements a.InterfaceC0073a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f4262a;

    u(RecyclerView recyclerView) {
        this.f4262a = recyclerView;
    }

    final void a(a.b bVar) {
        int i2 = bVar.f4122a;
        if (i2 == 1) {
            this.f4262a.u.k0(bVar.f4123b, bVar.d);
            return;
        }
        if (i2 == 2) {
            this.f4262a.u.n0(bVar.f4123b, bVar.d);
        } else if (i2 == 4) {
            this.f4262a.u.o0(bVar.f4123b, bVar.d);
        } else {
            if (i2 != 8) {
                return;
            }
            this.f4262a.u.m0(bVar.f4123b, bVar.d);
        }
    }

    public final RecyclerView.x b(int i2) {
        RecyclerView recyclerView = this.f4262a;
        int iH = recyclerView.f3952m.h();
        int i4 = 0;
        RecyclerView.x xVar = null;
        while (true) {
            if (i4 >= iH) {
                break;
            }
            RecyclerView.x xVarN = RecyclerView.N(recyclerView.f3952m.g(i4));
            if (xVarN != null && !xVarN.n() && xVarN.f4057k == i2) {
                if (!recyclerView.f3952m.l(xVarN.f4055i)) {
                    xVar = xVarN;
                    break;
                }
                xVar = xVarN;
            }
            i4++;
        }
        if (xVar == null || this.f4262a.f3952m.l(xVar.f4055i)) {
            return null;
        }
        return xVar;
    }

    public final void c(int i2, int i4, Object obj) {
        int i5;
        int i6;
        RecyclerView recyclerView = this.f4262a;
        int iH = recyclerView.f3952m.h();
        int i7 = i4 + i2;
        for (int i8 = 0; i8 < iH; i8++) {
            View viewG = recyclerView.f3952m.g(i8);
            RecyclerView.x xVarN = RecyclerView.N(viewG);
            if (xVarN != null && !xVarN.y() && (i6 = xVarN.f4057k) >= i2 && i6 < i7) {
                xVarN.e(2);
                xVarN.d(obj);
                ((RecyclerView.m) viewG.getLayoutParams()).f4010c = true;
            }
        }
        RecyclerView.q qVar = recyclerView.f3946j;
        int size = qVar.f4018c.size();
        while (true) {
            size--;
            if (size < 0) {
                this.f4262a.p0 = true;
                return;
            }
            RecyclerView.x xVar = qVar.f4018c.get(size);
            if (xVar != null && (i5 = xVar.f4057k) >= i2 && i5 < i7) {
                xVar.e(2);
                qVar.g(size);
            }
        }
    }

    public final void d(int i2, int i4) {
        RecyclerView recyclerView = this.f4262a;
        int iH = recyclerView.f3952m.h();
        for (int i5 = 0; i5 < iH; i5++) {
            RecyclerView.x xVarN = RecyclerView.N(recyclerView.f3952m.g(i5));
            if (xVarN != null && !xVarN.y() && xVarN.f4057k >= i2) {
                xVarN.r(i4, false);
                recyclerView.f3953m0.f4039f = true;
            }
        }
        RecyclerView.q qVar = recyclerView.f3946j;
        int size = qVar.f4018c.size();
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView.x xVar = qVar.f4018c.get(i6);
            if (xVar != null && xVar.f4057k >= i2) {
                xVar.r(i4, true);
            }
        }
        recyclerView.requestLayout();
        this.f4262a.f3957o0 = true;
    }

    public final void e(int i2, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        RecyclerView recyclerView = this.f4262a;
        int iH = recyclerView.f3952m.h();
        int i12 = -1;
        if (i2 < i4) {
            i6 = i2;
            i5 = i4;
            i7 = -1;
        } else {
            i5 = i2;
            i6 = i4;
            i7 = 1;
        }
        for (int i13 = 0; i13 < iH; i13++) {
            RecyclerView.x xVarN = RecyclerView.N(recyclerView.f3952m.g(i13));
            if (xVarN != null && (i11 = xVarN.f4057k) >= i6 && i11 <= i5) {
                if (i11 == i2) {
                    xVarN.r(i4 - i2, false);
                } else {
                    xVarN.r(i7, false);
                }
                recyclerView.f3953m0.f4039f = true;
            }
        }
        RecyclerView.q qVar = recyclerView.f3946j;
        if (i2 < i4) {
            i9 = i2;
            i8 = i4;
        } else {
            i8 = i2;
            i9 = i4;
            i12 = 1;
        }
        int size = qVar.f4018c.size();
        for (int i14 = 0; i14 < size; i14++) {
            RecyclerView.x xVar = qVar.f4018c.get(i14);
            if (xVar != null && (i10 = xVar.f4057k) >= i9 && i10 <= i8) {
                if (i10 == i2) {
                    xVar.r(i4 - i2, false);
                } else {
                    xVar.r(i12, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.f4262a.f3957o0 = true;
    }
}
