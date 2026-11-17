package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.l implements RecyclerView.u.b {

    /* renamed from: s, reason: collision with root package name */
    private c f3884s;

    /* renamed from: t, reason: collision with root package name */
    s f3885t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f3886v;

    /* renamed from: r, reason: collision with root package name */
    int f3883r = 1;

    /* renamed from: w, reason: collision with root package name */
    boolean f3887w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3888x = false;

    /* renamed from: y, reason: collision with root package name */
    private boolean f3889y = true;

    /* renamed from: z, reason: collision with root package name */
    int f3890z = -1;

    /* renamed from: A, reason: collision with root package name */
    int f3878A = Integer.MIN_VALUE;

    /* renamed from: B, reason: collision with root package name */
    d f3879B = null;

    /* renamed from: C, reason: collision with root package name */
    final a f3880C = new a();

    /* renamed from: D, reason: collision with root package name */
    private final b f3881D = new b();

    /* renamed from: E, reason: collision with root package name */
    private int f3882E = 2;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        s f3891a;

        /* renamed from: b, reason: collision with root package name */
        int f3892b;

        /* renamed from: c, reason: collision with root package name */
        int f3893c;
        boolean d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3894e;

        a() {
            d();
        }

        final void a() {
            this.f3893c = this.d ? this.f3891a.g() : this.f3891a.k();
        }

        public final void b(View view, int i2) {
            if (this.d) {
                this.f3893c = this.f3891a.m() + this.f3891a.b(view);
            } else {
                this.f3893c = this.f3891a.e(view);
            }
            this.f3892b = i2;
        }

        public final void c(View view, int i2) {
            int iM = this.f3891a.m();
            if (iM >= 0) {
                b(view, i2);
                return;
            }
            this.f3892b = i2;
            if (!this.d) {
                int iE = this.f3891a.e(view);
                int iK = iE - this.f3891a.k();
                this.f3893c = iE;
                if (iK > 0) {
                    int iG = (this.f3891a.g() - Math.min(0, (this.f3891a.g() - iM) - this.f3891a.b(view))) - (this.f3891a.c(view) + iE);
                    if (iG < 0) {
                        this.f3893c -= Math.min(iK, -iG);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG2 = (this.f3891a.g() - iM) - this.f3891a.b(view);
            this.f3893c = this.f3891a.g() - iG2;
            if (iG2 > 0) {
                int iC = this.f3893c - this.f3891a.c(view);
                int iK2 = this.f3891a.k();
                int iMin = iC - (Math.min(this.f3891a.e(view) - iK2, 0) + iK2);
                if (iMin < 0) {
                    this.f3893c = Math.min(iG2, -iMin) + this.f3893c;
                }
            }
        }

        final void d() {
            this.f3892b = -1;
            this.f3893c = Integer.MIN_VALUE;
            this.d = false;
            this.f3894e = false;
        }

        public final String toString() {
            StringBuilder sbD = D2.e.d("AnchorInfo{mPosition=");
            sbD.append(this.f3892b);
            sbD.append(", mCoordinate=");
            sbD.append(this.f3893c);
            sbD.append(", mLayoutFromEnd=");
            sbD.append(this.d);
            sbD.append(", mValid=");
            sbD.append(this.f3894e);
            sbD.append('}');
            return sbD.toString();
        }
    }

    protected static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f3895a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3896b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3897c;
        public boolean d;

        protected b() {
        }
    }

    static class c {

        /* renamed from: b, reason: collision with root package name */
        int f3899b;

        /* renamed from: c, reason: collision with root package name */
        int f3900c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        int f3901e;

        /* renamed from: f, reason: collision with root package name */
        int f3902f;
        int g;

        /* renamed from: i, reason: collision with root package name */
        int f3904i;

        /* renamed from: k, reason: collision with root package name */
        boolean f3906k;

        /* renamed from: a, reason: collision with root package name */
        boolean f3898a = true;

        /* renamed from: h, reason: collision with root package name */
        int f3903h = 0;

        /* renamed from: j, reason: collision with root package name */
        List<RecyclerView.x> f3905j = null;

        c() {
        }

        public final void a(View view) {
            int iA;
            int size = this.f3905j.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = this.f3905j.get(i4).f4055i;
                RecyclerView.m mVar = (RecyclerView.m) view3.getLayoutParams();
                if (view3 != view && !mVar.c() && (iA = (mVar.a() - this.d) * this.f3901e) >= 0 && iA < i2) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    } else {
                        i2 = iA;
                    }
                }
            }
            if (view2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.m) view2.getLayoutParams()).a();
            }
        }

        final boolean b(RecyclerView.v vVar) {
            int i2 = this.d;
            return i2 >= 0 && i2 < vVar.b();
        }

        final View c(RecyclerView.q qVar) {
            List<RecyclerView.x> list = this.f3905j;
            if (list == null) {
                View view = qVar.l(this.d, Long.MAX_VALUE).f4055i;
                this.d += this.f3901e;
                return view;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = this.f3905j.get(i2).f4055i;
                RecyclerView.m mVar = (RecyclerView.m) view2.getLayoutParams();
                if (!mVar.c() && this.d == mVar.a()) {
                    a(view2);
                    return view2;
                }
            }
            return null;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        int f3907i;

        /* renamed from: j, reason: collision with root package name */
        int f3908j;

        /* renamed from: k, reason: collision with root package name */
        boolean f3909k;

        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d() {
        }

        final boolean a() {
            return this.f3907i >= 0;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f3907i);
            parcel.writeInt(this.f3908j);
            parcel.writeInt(this.f3909k ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f3907i = parcel.readInt();
            this.f3908j = parcel.readInt();
            this.f3909k = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f3907i = dVar.f3907i;
            this.f3908j = dVar.f3908j;
            this.f3909k = dVar.f3909k;
        }
    }

    public LinearLayoutManager() {
        this.f3886v = false;
        q1(1);
        g(null);
        if (this.f3886v) {
            this.f3886v = false;
            B0();
        }
    }

    private int S0(RecyclerView.v vVar) {
        if (A() == 0) {
            return 0;
        }
        W0();
        return w.a(vVar, this.f3885t, a1(!this.f3889y), Z0(!this.f3889y), this, this.f3889y);
    }

    private int T0(RecyclerView.v vVar) {
        if (A() == 0) {
            return 0;
        }
        W0();
        return w.b(vVar, this.f3885t, a1(!this.f3889y), Z0(!this.f3889y), this, this.f3889y, this.f3887w);
    }

    private int U0(RecyclerView.v vVar) {
        if (A() == 0) {
            return 0;
        }
        W0();
        return w.c(vVar, this.f3885t, a1(!this.f3889y), Z0(!this.f3889y), this, this.f3889y);
    }

    private View Z0(boolean z4) {
        return this.f3887w ? d1(0, A(), z4, true) : d1(A() - 1, -1, z4, true);
    }

    private View a1(boolean z4) {
        return this.f3887w ? d1(A() - 1, -1, z4, true) : d1(0, A(), z4, true);
    }

    private int f1(int i2, RecyclerView.q qVar, RecyclerView.v vVar, boolean z4) {
        int iG;
        int iG2 = this.f3885t.g() - i2;
        if (iG2 <= 0) {
            return 0;
        }
        int i4 = -p1(-iG2, qVar, vVar);
        int i5 = i2 + i4;
        if (!z4 || (iG = this.f3885t.g() - i5) <= 0) {
            return i4;
        }
        this.f3885t.p(iG);
        return iG + i4;
    }

    private int g1(int i2, RecyclerView.q qVar, RecyclerView.v vVar, boolean z4) {
        int iK;
        int iK2 = i2 - this.f3885t.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i4 = -p1(iK2, qVar, vVar);
        int i5 = i2 + i4;
        if (!z4 || (iK = i5 - this.f3885t.k()) <= 0) {
            return i4;
        }
        this.f3885t.p(-iK);
        return i4 - iK;
    }

    private View h1() {
        return z(this.f3887w ? 0 : A() - 1);
    }

    private View i1() {
        return z(this.f3887w ? A() - 1 : 0);
    }

    private void m1(RecyclerView.q qVar, c cVar) {
        if (!cVar.f3898a || cVar.f3906k) {
            return;
        }
        if (cVar.f3902f != -1) {
            int i2 = cVar.g;
            if (i2 < 0) {
                return;
            }
            int iA = A();
            if (!this.f3887w) {
                for (int i4 = 0; i4 < iA; i4++) {
                    View viewZ = z(i4);
                    if (this.f3885t.b(viewZ) > i2 || this.f3885t.n(viewZ) > i2) {
                        n1(qVar, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i5 = iA - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View viewZ2 = z(i6);
                if (this.f3885t.b(viewZ2) > i2 || this.f3885t.n(viewZ2) > i2) {
                    n1(qVar, i5, i6);
                    return;
                }
            }
            return;
        }
        int i7 = cVar.g;
        int iA2 = A();
        if (i7 < 0) {
            return;
        }
        int iF = this.f3885t.f() - i7;
        if (this.f3887w) {
            for (int i8 = 0; i8 < iA2; i8++) {
                View viewZ3 = z(i8);
                if (this.f3885t.e(viewZ3) < iF || this.f3885t.o(viewZ3) < iF) {
                    n1(qVar, 0, i8);
                    return;
                }
            }
            return;
        }
        int i9 = iA2 - 1;
        for (int i10 = i9; i10 >= 0; i10--) {
            View viewZ4 = z(i10);
            if (this.f3885t.e(viewZ4) < iF || this.f3885t.o(viewZ4) < iF) {
                n1(qVar, i9, i10);
                return;
            }
        }
    }

    private void n1(RecyclerView.q qVar, int i2, int i4) {
        if (i2 == i4) {
            return;
        }
        if (i4 <= i2) {
            while (i2 > i4) {
                z0(i2, qVar);
                i2--;
            }
        } else {
            for (int i5 = i4 - 1; i5 >= i2; i5--) {
                z0(i5, qVar);
            }
        }
    }

    private void o1() {
        if (this.f3883r == 1 || !j1()) {
            this.f3887w = this.f3886v;
        } else {
            this.f3887w = !this.f3886v;
        }
    }

    private void s1(int i2, int i4, boolean z4, RecyclerView.v vVar) {
        int iK;
        this.f3884s.f3906k = this.f3885t.i() == 0 && this.f3885t.f() == 0;
        this.f3884s.f3903h = vVar.f4035a != -1 ? this.f3885t.l() : 0;
        c cVar = this.f3884s;
        cVar.f3902f = i2;
        if (i2 == 1) {
            cVar.f3903h = this.f3885t.h() + cVar.f3903h;
            View viewH1 = h1();
            c cVar2 = this.f3884s;
            cVar2.f3901e = this.f3887w ? -1 : 1;
            int iS = S(viewH1);
            c cVar3 = this.f3884s;
            cVar2.d = iS + cVar3.f3901e;
            cVar3.f3899b = this.f3885t.b(viewH1);
            iK = this.f3885t.b(viewH1) - this.f3885t.g();
        } else {
            View viewI1 = i1();
            c cVar4 = this.f3884s;
            cVar4.f3903h = this.f3885t.k() + cVar4.f3903h;
            c cVar5 = this.f3884s;
            cVar5.f3901e = this.f3887w ? 1 : -1;
            int iS2 = S(viewI1);
            c cVar6 = this.f3884s;
            cVar5.d = iS2 + cVar6.f3901e;
            cVar6.f3899b = this.f3885t.e(viewI1);
            iK = (-this.f3885t.e(viewI1)) + this.f3885t.k();
        }
        c cVar7 = this.f3884s;
        cVar7.f3900c = i4;
        if (z4) {
            cVar7.f3900c = i4 - iK;
        }
        cVar7.g = iK;
    }

    private void t1(int i2, int i4) {
        this.f3884s.f3900c = this.f3885t.g() - i4;
        c cVar = this.f3884s;
        cVar.f3901e = this.f3887w ? -1 : 1;
        cVar.d = i2;
        cVar.f3902f = 1;
        cVar.f3899b = i4;
        cVar.g = Integer.MIN_VALUE;
    }

    private void u1(int i2, int i4) {
        this.f3884s.f3900c = i4 - this.f3885t.k();
        c cVar = this.f3884s;
        cVar.d = i2;
        cVar.f3901e = this.f3887w ? 1 : -1;
        cVar.f3902f = -1;
        cVar.f3899b = i4;
        cVar.g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int C0(int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        if (this.f3883r == 1) {
            return 0;
        }
        return p1(i2, qVar, vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void D0(int i2) {
        this.f3890z = i2;
        this.f3878A = Integer.MIN_VALUE;
        d dVar = this.f3879B;
        if (dVar != null) {
            dVar.f3907i = -1;
        }
        B0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int E0(int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        if (this.f3883r == 0) {
            return 0;
        }
        return p1(i2, qVar, vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    final boolean M0() {
        boolean z4;
        if (K() != 1073741824 && X() != 1073741824) {
            int iA = A();
            int i2 = 0;
            while (true) {
                if (i2 >= iA) {
                    z4 = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = z(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z4 = true;
                    break;
                }
                i2++;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void O0(RecyclerView recyclerView, int i2) {
        o oVar = new o(recyclerView.getContext());
        oVar.k(i2);
        P0(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean Q0() {
        return this.f3879B == null && this.u == this.f3888x;
    }

    void R0(RecyclerView.v vVar, c cVar, RecyclerView.l.c cVar2) {
        int i2 = cVar.d;
        if (i2 < 0 || i2 >= vVar.b()) {
            return;
        }
        ((m.b) cVar2).a(i2, Math.max(0, cVar.g));
    }

    final int V0(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.f3883r == 1) ? 1 : Integer.MIN_VALUE : this.f3883r == 0 ? 1 : Integer.MIN_VALUE : this.f3883r == 1 ? -1 : Integer.MIN_VALUE : this.f3883r == 0 ? -1 : Integer.MIN_VALUE : (this.f3883r != 1 && j1()) ? -1 : 1 : (this.f3883r != 1 && j1()) ? 1 : -1;
    }

    final void W0() {
        if (this.f3884s == null) {
            this.f3884s = new c();
        }
    }

    final int X0(RecyclerView.q qVar, c cVar, RecyclerView.v vVar, boolean z4) {
        int i2 = cVar.f3900c;
        int i4 = cVar.g;
        if (i4 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.g = i4 + i2;
            }
            m1(qVar, cVar);
        }
        int i5 = cVar.f3900c + cVar.f3903h;
        b bVar = this.f3881D;
        while (true) {
            if ((!cVar.f3906k && i5 <= 0) || !cVar.b(vVar)) {
                break;
            }
            bVar.f3895a = 0;
            bVar.f3896b = false;
            bVar.f3897c = false;
            bVar.d = false;
            k1(qVar, vVar, cVar, bVar);
            if (!bVar.f3896b) {
                int i6 = cVar.f3899b;
                int i7 = bVar.f3895a;
                cVar.f3899b = (cVar.f3902f * i7) + i6;
                if (!bVar.f3897c || this.f3884s.f3905j != null || !vVar.g) {
                    cVar.f3900c -= i7;
                    i5 -= i7;
                }
                int i8 = cVar.g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + i7;
                    cVar.g = i9;
                    int i10 = cVar.f3900c;
                    if (i10 < 0) {
                        cVar.g = i9 + i10;
                    }
                    m1(qVar, cVar);
                }
                if (z4 && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f3900c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean Y() {
        return true;
    }

    public final int Y0() {
        View viewD1 = d1(0, A(), true, false);
        if (viewD1 == null) {
            return -1;
        }
        return S(viewD1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.u.b
    public final PointF a(int i2) {
        if (A() == 0) {
            return null;
        }
        int i4 = (i2 < S(z(0))) != this.f3887w ? -1 : 1;
        return this.f3883r == 0 ? new PointF(i4, 0.0f) : new PointF(0.0f, i4);
    }

    public final int b1() {
        View viewD1 = d1(0, A(), false, true);
        if (viewD1 == null) {
            return -1;
        }
        return S(viewD1);
    }

    final View c1(int i2, int i4) {
        int i5;
        int i6;
        W0();
        if ((i4 > i2 ? (char) 1 : i4 < i2 ? (char) 65535 : (char) 0) == 0) {
            return z(i2);
        }
        if (this.f3885t.e(z(i2)) < this.f3885t.k()) {
            i5 = 16644;
            i6 = 16388;
        } else {
            i5 = 4161;
            i6 = 4097;
        }
        return this.f3883r == 0 ? this.f3992e.a(i2, i4, i5, i6) : this.f3993f.a(i2, i4, i5, i6);
    }

    final View d1(int i2, int i4, boolean z4, boolean z5) {
        W0();
        int i5 = z4 ? 24579 : 320;
        int i6 = z5 ? 320 : 0;
        return this.f3883r == 0 ? this.f3992e.a(i2, i4, i5, i6) : this.f3993f.a(i2, i4, i5, i6);
    }

    View e1(RecyclerView.q qVar, RecyclerView.v vVar, int i2, int i4, int i5) {
        W0();
        int iK = this.f3885t.k();
        int iG = this.f3885t.g();
        int i6 = i4 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i4) {
            View viewZ = z(i2);
            int iS = S(viewZ);
            if (iS >= 0 && iS < i5) {
                if (((RecyclerView.m) viewZ.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewZ;
                    }
                } else {
                    if (this.f3885t.e(viewZ) < iG && this.f3885t.b(viewZ) >= iK) {
                        return viewZ;
                    }
                    if (view == null) {
                        view = viewZ;
                    }
                }
            }
            i2 += i6;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void f0(RecyclerView recyclerView) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void g(String str) {
        if (this.f3879B == null) {
            super.g(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public View g0(View view, int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        int iV0;
        o1();
        if (A() == 0 || (iV0 = V0(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        W0();
        W0();
        s1(iV0, (int) (this.f3885t.l() * 0.33333334f), false, vVar);
        c cVar = this.f3884s;
        cVar.g = Integer.MIN_VALUE;
        cVar.f3898a = false;
        X0(qVar, cVar, vVar, true);
        View viewC1 = iV0 == -1 ? this.f3887w ? c1(A() - 1, -1) : c1(0, A()) : this.f3887w ? c1(0, A()) : c1(A() - 1, -1);
        View viewI1 = iV0 == -1 ? i1() : h1();
        if (!viewI1.hasFocusable()) {
            return viewC1;
        }
        if (viewC1 == null) {
            return null;
        }
        return viewI1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean h() {
        return this.f3883r == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void h0(AccessibilityEvent accessibilityEvent) {
        super.h0(accessibilityEvent);
        if (A() > 0) {
            accessibilityEvent.setFromIndex(b1());
            View viewD1 = d1(A() - 1, -1, false, true);
            accessibilityEvent.setToIndex(viewD1 != null ? S(viewD1) : -1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean i() {
        return this.f3883r == 1;
    }

    protected final boolean j1() {
        return L() == 1;
    }

    void k1(RecyclerView.q qVar, RecyclerView.v vVar, c cVar, b bVar) {
        int i2;
        int i4;
        int i5;
        int iP;
        int iD;
        View viewC = cVar.c(qVar);
        if (viewC == null) {
            bVar.f3896b = true;
            return;
        }
        RecyclerView.m mVar = (RecyclerView.m) viewC.getLayoutParams();
        if (cVar.f3905j == null) {
            if (this.f3887w == (cVar.f3902f == -1)) {
                d(viewC);
            } else {
                e(viewC);
            }
        } else {
            if (this.f3887w == (cVar.f3902f == -1)) {
                b(viewC);
            } else {
                c(viewC);
            }
        }
        c0(viewC);
        bVar.f3895a = this.f3885t.c(viewC);
        if (this.f3883r == 1) {
            if (j1()) {
                iD = W() - Q();
                iP = iD - this.f3885t.d(viewC);
            } else {
                iP = P();
                iD = this.f3885t.d(viewC) + iP;
            }
            if (cVar.f3902f == -1) {
                int i6 = cVar.f3899b;
                i5 = i6;
                i4 = iD;
                i2 = i6 - bVar.f3895a;
            } else {
                int i7 = cVar.f3899b;
                i2 = i7;
                i4 = iD;
                i5 = bVar.f3895a + i7;
            }
        } else {
            int iR = R();
            int iD2 = this.f3885t.d(viewC) + iR;
            if (cVar.f3902f == -1) {
                int i8 = cVar.f3899b;
                i4 = i8;
                i2 = iR;
                i5 = iD2;
                iP = i8 - bVar.f3895a;
            } else {
                int i9 = cVar.f3899b;
                i2 = iR;
                i4 = bVar.f3895a + i9;
                i5 = iD2;
                iP = i9;
            }
        }
        b0(viewC, iP, i2, i4, i5);
        if (mVar.c() || mVar.b()) {
            bVar.f3897c = true;
        }
        bVar.d = viewC.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void l(int i2, int i4, RecyclerView.v vVar, RecyclerView.l.c cVar) {
        if (this.f3883r != 0) {
            i2 = i4;
        }
        if (A() == 0 || i2 == 0) {
            return;
        }
        W0();
        s1(i2 > 0 ? 1 : -1, Math.abs(i2), true, vVar);
        R0(vVar, this.f3884s, cVar);
    }

    void l1(RecyclerView.q qVar, RecyclerView.v vVar, a aVar, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void m(int i2, RecyclerView.l.c cVar) {
        boolean z4;
        int i4;
        d dVar = this.f3879B;
        if (dVar == null || !dVar.a()) {
            o1();
            z4 = this.f3887w;
            i4 = this.f3890z;
            if (i4 == -1) {
                i4 = z4 ? i2 - 1 : 0;
            }
        } else {
            d dVar2 = this.f3879B;
            z4 = dVar2.f3909k;
            i4 = dVar2.f3907i;
        }
        int i5 = z4 ? -1 : 1;
        for (int i6 = 0; i6 < this.f3882E && i4 >= 0 && i4 < i2; i6++) {
            ((m.b) cVar).a(i4, 0);
            i4 += i5;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int n(RecyclerView.v vVar) {
        return S0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int o(RecyclerView.v vVar) {
        return T0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int p(RecyclerView.v vVar) {
        return U0(vVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b8  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p0(RecyclerView.q qVar, RecyclerView.v vVar) {
        boolean z4;
        boolean z5;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iF1;
        int i9;
        View viewV;
        int iE;
        int iG;
        if (!(this.f3879B == null && this.f3890z == -1) && vVar.b() == 0) {
            w0(qVar);
            return;
        }
        d dVar = this.f3879B;
        if (dVar != null && dVar.a()) {
            this.f3890z = this.f3879B.f3907i;
        }
        W0();
        this.f3884s.f3898a = false;
        o1();
        View viewI = I();
        a aVar = this.f3880C;
        boolean z6 = true;
        if (!aVar.f3894e || this.f3890z != -1 || this.f3879B != null) {
            aVar.d();
            a aVar2 = this.f3880C;
            aVar2.d = this.f3887w ^ this.f3888x;
            if (vVar.g || (i2 = this.f3890z) == -1) {
                z4 = false;
                if (!z4) {
                    if (A() != 0) {
                        View viewI2 = I();
                        if (viewI2 != null) {
                            RecyclerView.m mVar = (RecyclerView.m) viewI2.getLayoutParams();
                            if (!mVar.c() && mVar.a() >= 0 && mVar.a() < vVar.b()) {
                                aVar2.c(viewI2, S(viewI2));
                            } else {
                                if (this.u == this.f3888x) {
                                    View viewE1 = aVar2.d ? this.f3887w ? e1(qVar, vVar, 0, A(), vVar.b()) : e1(qVar, vVar, A() - 1, -1, vVar.b()) : this.f3887w ? e1(qVar, vVar, A() - 1, -1, vVar.b()) : e1(qVar, vVar, 0, A(), vVar.b());
                                    if (viewE1 != null) {
                                        aVar2.b(viewE1, S(viewE1));
                                        if (!vVar.g && Q0()) {
                                            if (this.f3885t.e(viewE1) >= this.f3885t.g() || this.f3885t.b(viewE1) < this.f3885t.k()) {
                                                aVar2.f3893c = aVar2.d ? this.f3885t.g() : this.f3885t.k();
                                            }
                                        }
                                    }
                                }
                                z5 = false;
                                if (!z5) {
                                    aVar2.a();
                                    aVar2.f3892b = this.f3888x ? vVar.b() - 1 : 0;
                                }
                            }
                            z5 = true;
                            if (!z5) {
                            }
                        }
                    } else {
                        z5 = false;
                        if (!z5) {
                        }
                    }
                }
                this.f3880C.f3894e = true;
            } else if (i2 < 0 || i2 >= vVar.b()) {
                this.f3890z = -1;
                this.f3878A = Integer.MIN_VALUE;
                z4 = false;
                if (!z4) {
                }
                this.f3880C.f3894e = true;
            } else {
                aVar2.f3892b = this.f3890z;
                d dVar2 = this.f3879B;
                if (dVar2 != null && dVar2.a()) {
                    boolean z7 = this.f3879B.f3909k;
                    aVar2.d = z7;
                    if (z7) {
                        aVar2.f3893c = this.f3885t.g() - this.f3879B.f3908j;
                    } else {
                        aVar2.f3893c = this.f3885t.k() + this.f3879B.f3908j;
                    }
                } else if (this.f3878A == Integer.MIN_VALUE) {
                    View viewV2 = v(this.f3890z);
                    if (viewV2 == null) {
                        if (A() > 0) {
                            aVar2.d = (this.f3890z < S(z(0))) == this.f3887w;
                        }
                        aVar2.a();
                    } else if (this.f3885t.c(viewV2) > this.f3885t.l()) {
                        aVar2.a();
                    } else if (this.f3885t.e(viewV2) - this.f3885t.k() < 0) {
                        aVar2.f3893c = this.f3885t.k();
                        aVar2.d = false;
                    } else if (this.f3885t.g() - this.f3885t.b(viewV2) < 0) {
                        aVar2.f3893c = this.f3885t.g();
                        aVar2.d = true;
                    } else {
                        aVar2.f3893c = aVar2.d ? this.f3885t.m() + this.f3885t.b(viewV2) : this.f3885t.e(viewV2);
                    }
                } else {
                    boolean z8 = this.f3887w;
                    aVar2.d = z8;
                    if (z8) {
                        aVar2.f3893c = this.f3885t.g() - this.f3878A;
                    } else {
                        aVar2.f3893c = this.f3885t.k() + this.f3878A;
                    }
                }
                z4 = true;
                if (!z4) {
                }
                this.f3880C.f3894e = true;
            }
        } else if (viewI != null && (this.f3885t.e(viewI) >= this.f3885t.g() || this.f3885t.b(viewI) <= this.f3885t.k())) {
            this.f3880C.c(viewI, S(viewI));
        }
        int iL = vVar.f4035a != -1 ? this.f3885t.l() : 0;
        if (this.f3884s.f3904i >= 0) {
            i4 = iL;
            iL = 0;
        } else {
            i4 = 0;
        }
        int iK = this.f3885t.k() + iL;
        int iH = this.f3885t.h() + i4;
        if (vVar.g && (i9 = this.f3890z) != -1 && this.f3878A != Integer.MIN_VALUE && (viewV = v(i9)) != null) {
            if (this.f3887w) {
                iG = this.f3885t.g() - this.f3885t.b(viewV);
                iE = this.f3878A;
            } else {
                iE = this.f3885t.e(viewV) - this.f3885t.k();
                iG = this.f3878A;
            }
            int i10 = iG - iE;
            if (i10 > 0) {
                iK += i10;
            } else {
                iH -= i10;
            }
        }
        a aVar3 = this.f3880C;
        l1(qVar, vVar, aVar3, (!aVar3.d ? this.f3887w : !this.f3887w) ? 1 : -1);
        t(qVar);
        this.f3884s.f3906k = this.f3885t.i() == 0 && this.f3885t.f() == 0;
        Objects.requireNonNull(this.f3884s);
        a aVar4 = this.f3880C;
        if (aVar4.d) {
            u1(aVar4.f3892b, aVar4.f3893c);
            c cVar = this.f3884s;
            cVar.f3903h = iK;
            X0(qVar, cVar, vVar, false);
            c cVar2 = this.f3884s;
            i6 = cVar2.f3899b;
            int i11 = cVar2.d;
            int i12 = cVar2.f3900c;
            if (i12 > 0) {
                iH += i12;
            }
            a aVar5 = this.f3880C;
            t1(aVar5.f3892b, aVar5.f3893c);
            c cVar3 = this.f3884s;
            cVar3.f3903h = iH;
            cVar3.d += cVar3.f3901e;
            X0(qVar, cVar3, vVar, false);
            c cVar4 = this.f3884s;
            i5 = cVar4.f3899b;
            int i13 = cVar4.f3900c;
            if (i13 > 0) {
                u1(i11, i6);
                c cVar5 = this.f3884s;
                cVar5.f3903h = i13;
                X0(qVar, cVar5, vVar, false);
                i6 = this.f3884s.f3899b;
            }
        } else {
            t1(aVar4.f3892b, aVar4.f3893c);
            c cVar6 = this.f3884s;
            cVar6.f3903h = iH;
            X0(qVar, cVar6, vVar, false);
            c cVar7 = this.f3884s;
            i5 = cVar7.f3899b;
            int i14 = cVar7.d;
            int i15 = cVar7.f3900c;
            if (i15 > 0) {
                iK += i15;
            }
            a aVar6 = this.f3880C;
            u1(aVar6.f3892b, aVar6.f3893c);
            c cVar8 = this.f3884s;
            cVar8.f3903h = iK;
            cVar8.d += cVar8.f3901e;
            X0(qVar, cVar8, vVar, false);
            c cVar9 = this.f3884s;
            i6 = cVar9.f3899b;
            int i16 = cVar9.f3900c;
            if (i16 > 0) {
                t1(i14, i5);
                c cVar10 = this.f3884s;
                cVar10.f3903h = i16;
                X0(qVar, cVar10, vVar, false);
                i5 = this.f3884s.f3899b;
            }
        }
        if (A() > 0) {
            if (this.f3887w ^ this.f3888x) {
                int iF12 = f1(i5, qVar, vVar, true);
                i7 = i6 + iF12;
                i8 = i5 + iF12;
                iF1 = g1(i7, qVar, vVar, false);
            } else {
                int iG1 = g1(i6, qVar, vVar, true);
                i7 = i6 + iG1;
                i8 = i5 + iG1;
                iF1 = f1(i8, qVar, vVar, false);
            }
            i6 = i7 + iF1;
            i5 = i8 + iF1;
        }
        if (vVar.f4043k && A() != 0 && !vVar.g && Q0()) {
            List<RecyclerView.x> listE = qVar.e();
            int size = listE.size();
            int iS = S(z(0));
            int i17 = 0;
            int iC = 0;
            int iC2 = 0;
            while (i17 < size) {
                RecyclerView.x xVar = listE.get(i17);
                if (!xVar.n()) {
                    if (((xVar.i() < iS ? z6 : false) != this.f3887w ? (char) 65535 : (char) 1) == 65535) {
                        iC += this.f3885t.c(xVar.f4055i);
                    } else {
                        iC2 += this.f3885t.c(xVar.f4055i);
                    }
                }
                i17++;
                z6 = true;
            }
            this.f3884s.f3905j = listE;
            if (iC > 0) {
                u1(S(i1()), i6);
                c cVar11 = this.f3884s;
                cVar11.f3903h = iC;
                cVar11.f3900c = 0;
                cVar11.a(null);
                X0(qVar, this.f3884s, vVar, false);
            }
            if (iC2 > 0) {
                t1(S(h1()), i5);
                c cVar12 = this.f3884s;
                cVar12.f3903h = iC2;
                cVar12.f3900c = 0;
                cVar12.a(null);
                X0(qVar, this.f3884s, vVar, false);
            }
            this.f3884s.f3905j = null;
        }
        if (vVar.g) {
            this.f3880C.d();
        } else {
            this.f3885t.q();
        }
        this.u = this.f3888x;
    }

    final int p1(int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        if (A() == 0 || i2 == 0) {
            return 0;
        }
        this.f3884s.f3898a = true;
        W0();
        int i4 = i2 > 0 ? 1 : -1;
        int iAbs = Math.abs(i2);
        s1(i4, iAbs, true, vVar);
        c cVar = this.f3884s;
        int iX0 = cVar.g + X0(qVar, cVar, vVar, false);
        if (iX0 < 0) {
            return 0;
        }
        if (iAbs > iX0) {
            i2 = i4 * iX0;
        }
        this.f3885t.p(-i2);
        this.f3884s.f3904i = i2;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int q(RecyclerView.v vVar) {
        return S0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void q0() {
        this.f3879B = null;
        this.f3890z = -1;
        this.f3878A = Integer.MIN_VALUE;
        this.f3880C.d();
    }

    public final void q1(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(D2.e.b("invalid orientation:", i2));
        }
        g(null);
        if (i2 != this.f3883r || this.f3885t == null) {
            s sVarA = s.a(this, i2);
            this.f3885t = sVarA;
            this.f3880C.f3891a = sVarA;
            this.f3883r = i2;
            B0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int r(RecyclerView.v vVar) {
        return T0(vVar);
    }

    public void r1(boolean z4) {
        g(null);
        if (this.f3888x == z4) {
            return;
        }
        this.f3888x = z4;
        B0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int s(RecyclerView.v vVar) {
        return U0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void s0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f3879B = (d) parcelable;
            B0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final Parcelable t0() {
        d dVar = this.f3879B;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (A() > 0) {
            W0();
            boolean z4 = this.u ^ this.f3887w;
            dVar2.f3909k = z4;
            if (z4) {
                View viewH1 = h1();
                dVar2.f3908j = this.f3885t.g() - this.f3885t.b(viewH1);
                dVar2.f3907i = S(viewH1);
            } else {
                View viewI1 = i1();
                dVar2.f3907i = S(viewI1);
                dVar2.f3908j = this.f3885t.e(viewI1) - this.f3885t.k();
            }
        } else {
            dVar2.f3907i = -1;
        }
        return dVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final View v(int i2) {
        int iA = A();
        if (iA == 0) {
            return null;
        }
        int iS = i2 - S(z(0));
        if (iS >= 0 && iS < iA) {
            View viewZ = z(iS);
            if (S(viewZ) == i2) {
                return viewZ;
            }
        }
        return super.v(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m w() {
        return new RecyclerView.m(-2, -2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i4) {
        this.f3886v = false;
        RecyclerView.l.d dVarT = RecyclerView.l.T(context, attributeSet, i2, i4);
        q1(dVarT.f4005a);
        boolean z4 = dVarT.f4007c;
        g(null);
        if (z4 != this.f3886v) {
            this.f3886v = z4;
            B0();
        }
        r1(dVarT.d);
    }
}
