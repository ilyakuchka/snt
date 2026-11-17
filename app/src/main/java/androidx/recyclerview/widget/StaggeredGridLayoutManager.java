package androidx.recyclerview.widget;

import F.b;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.l implements RecyclerView.u.b {

    /* renamed from: A, reason: collision with root package name */
    private BitSet f4071A;

    /* renamed from: F, reason: collision with root package name */
    private boolean f4076F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f4077G;

    /* renamed from: H, reason: collision with root package name */
    private e f4078H;
    private int[] L;

    /* renamed from: r, reason: collision with root package name */
    private int f4082r;

    /* renamed from: s, reason: collision with root package name */
    f[] f4083s;

    /* renamed from: t, reason: collision with root package name */
    s f4084t;
    s u;

    /* renamed from: v, reason: collision with root package name */
    private int f4085v;

    /* renamed from: w, reason: collision with root package name */
    private int f4086w;

    /* renamed from: x, reason: collision with root package name */
    private final n f4087x;

    /* renamed from: y, reason: collision with root package name */
    boolean f4088y;

    /* renamed from: z, reason: collision with root package name */
    boolean f4089z = false;

    /* renamed from: B, reason: collision with root package name */
    int f4072B = -1;

    /* renamed from: C, reason: collision with root package name */
    int f4073C = Integer.MIN_VALUE;

    /* renamed from: D, reason: collision with root package name */
    d f4074D = new d();

    /* renamed from: E, reason: collision with root package name */
    private int f4075E = 2;

    /* renamed from: I, reason: collision with root package name */
    private final Rect f4079I = new Rect();

    /* renamed from: J, reason: collision with root package name */
    private final b f4080J = new b();

    /* renamed from: K, reason: collision with root package name */
    private boolean f4081K = true;
    private final Runnable M = new a();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            StaggeredGridLayoutManager.this.S0();
        }
    }

    class b {

        /* renamed from: a, reason: collision with root package name */
        int f4091a;

        /* renamed from: b, reason: collision with root package name */
        int f4092b;

        /* renamed from: c, reason: collision with root package name */
        boolean f4093c;
        boolean d;

        /* renamed from: e, reason: collision with root package name */
        boolean f4094e;

        /* renamed from: f, reason: collision with root package name */
        int[] f4095f;

        b() {
            b();
        }

        final void a() {
            this.f4092b = this.f4093c ? StaggeredGridLayoutManager.this.f4084t.g() : StaggeredGridLayoutManager.this.f4084t.k();
        }

        final void b() {
            this.f4091a = -1;
            this.f4092b = Integer.MIN_VALUE;
            this.f4093c = false;
            this.d = false;
            this.f4094e = false;
            int[] iArr = this.f4095f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.m {

        /* renamed from: e, reason: collision with root package name */
        f f4096e;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(int i2, int i4) {
            super(i2, i4);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        int f4103i;

        /* renamed from: j, reason: collision with root package name */
        int f4104j;

        /* renamed from: k, reason: collision with root package name */
        int f4105k;

        /* renamed from: l, reason: collision with root package name */
        int[] f4106l;

        /* renamed from: m, reason: collision with root package name */
        int f4107m;

        /* renamed from: n, reason: collision with root package name */
        int[] f4108n;

        /* renamed from: o, reason: collision with root package name */
        List<d.a> f4109o;
        boolean p;

        /* renamed from: q, reason: collision with root package name */
        boolean f4110q;

        /* renamed from: r, reason: collision with root package name */
        boolean f4111r;

        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f4103i);
            parcel.writeInt(this.f4104j);
            parcel.writeInt(this.f4105k);
            if (this.f4105k > 0) {
                parcel.writeIntArray(this.f4106l);
            }
            parcel.writeInt(this.f4107m);
            if (this.f4107m > 0) {
                parcel.writeIntArray(this.f4108n);
            }
            parcel.writeInt(this.p ? 1 : 0);
            parcel.writeInt(this.f4110q ? 1 : 0);
            parcel.writeInt(this.f4111r ? 1 : 0);
            parcel.writeList(this.f4109o);
        }

        e(Parcel parcel) {
            this.f4103i = parcel.readInt();
            this.f4104j = parcel.readInt();
            int i2 = parcel.readInt();
            this.f4105k = i2;
            if (i2 > 0) {
                int[] iArr = new int[i2];
                this.f4106l = iArr;
                parcel.readIntArray(iArr);
            }
            int i4 = parcel.readInt();
            this.f4107m = i4;
            if (i4 > 0) {
                int[] iArr2 = new int[i4];
                this.f4108n = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.p = parcel.readInt() == 1;
            this.f4110q = parcel.readInt() == 1;
            this.f4111r = parcel.readInt() == 1;
            this.f4109o = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f4105k = eVar.f4105k;
            this.f4103i = eVar.f4103i;
            this.f4104j = eVar.f4104j;
            this.f4106l = eVar.f4106l;
            this.f4107m = eVar.f4107m;
            this.f4108n = eVar.f4108n;
            this.p = eVar.p;
            this.f4110q = eVar.f4110q;
            this.f4111r = eVar.f4111r;
            this.f4109o = eVar.f4109o;
        }
    }

    class f {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<View> f4112a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        int f4113b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        int f4114c = Integer.MIN_VALUE;
        int d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f4115e;

        f(int i2) {
            this.f4115e = i2;
        }

        final void a(View view) {
            c cVar = (c) view.getLayoutParams();
            cVar.f4096e = this;
            this.f4112a.add(view);
            this.f4114c = Integer.MIN_VALUE;
            if (this.f4112a.size() == 1) {
                this.f4113b = Integer.MIN_VALUE;
            }
            if (cVar.c() || cVar.b()) {
                this.d = StaggeredGridLayoutManager.this.f4084t.c(view) + this.d;
            }
        }

        final void b() {
            View view = this.f4112a.get(r0.size() - 1);
            c cVarJ = j(view);
            this.f4114c = StaggeredGridLayoutManager.this.f4084t.b(view);
            Objects.requireNonNull(cVarJ);
        }

        final void c() {
            View view = this.f4112a.get(0);
            c cVarJ = j(view);
            this.f4113b = StaggeredGridLayoutManager.this.f4084t.e(view);
            Objects.requireNonNull(cVarJ);
        }

        final void d() {
            this.f4112a.clear();
            this.f4113b = Integer.MIN_VALUE;
            this.f4114c = Integer.MIN_VALUE;
            this.d = 0;
        }

        public final int e() {
            return StaggeredGridLayoutManager.this.f4088y ? g(this.f4112a.size() - 1, -1) : g(0, this.f4112a.size());
        }

        public final int f() {
            return StaggeredGridLayoutManager.this.f4088y ? g(0, this.f4112a.size()) : g(this.f4112a.size() - 1, -1);
        }

        final int g(int i2, int i4) {
            int iK = StaggeredGridLayoutManager.this.f4084t.k();
            int iG = StaggeredGridLayoutManager.this.f4084t.g();
            int i5 = i4 > i2 ? 1 : -1;
            while (i2 != i4) {
                View view = this.f4112a.get(i2);
                int iE = StaggeredGridLayoutManager.this.f4084t.e(view);
                int iB = StaggeredGridLayoutManager.this.f4084t.b(view);
                boolean z4 = iE <= iG;
                boolean z5 = iB >= iK;
                if (z4 && z5 && (iE < iK || iB > iG)) {
                    return StaggeredGridLayoutManager.this.S(view);
                }
                i2 += i5;
            }
            return -1;
        }

        final int h(int i2) {
            int i4 = this.f4114c;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f4112a.size() == 0) {
                return i2;
            }
            b();
            return this.f4114c;
        }

        public final View i(int i2, int i4) {
            View view = null;
            if (i4 != -1) {
                int size = this.f4112a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f4112a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f4088y && staggeredGridLayoutManager.S(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f4088y && staggeredGridLayoutManager2.S(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f4112a.size();
                int i5 = 0;
                while (i5 < size2) {
                    View view3 = this.f4112a.get(i5);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f4088y && staggeredGridLayoutManager3.S(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f4088y && staggeredGridLayoutManager4.S(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i5++;
                    view = view3;
                }
            }
            return view;
        }

        final c j(View view) {
            return (c) view.getLayoutParams();
        }

        final int k(int i2) {
            int i4 = this.f4113b;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f4112a.size() == 0) {
                return i2;
            }
            c();
            return this.f4113b;
        }

        final void l() {
            int size = this.f4112a.size();
            View viewRemove = this.f4112a.remove(size - 1);
            c cVarJ = j(viewRemove);
            cVarJ.f4096e = null;
            if (cVarJ.c() || cVarJ.b()) {
                this.d -= StaggeredGridLayoutManager.this.f4084t.c(viewRemove);
            }
            if (size == 1) {
                this.f4113b = Integer.MIN_VALUE;
            }
            this.f4114c = Integer.MIN_VALUE;
        }

        final void m() {
            View viewRemove = this.f4112a.remove(0);
            c cVarJ = j(viewRemove);
            cVarJ.f4096e = null;
            if (this.f4112a.size() == 0) {
                this.f4114c = Integer.MIN_VALUE;
            }
            if (cVarJ.c() || cVarJ.b()) {
                this.d -= StaggeredGridLayoutManager.this.f4084t.c(viewRemove);
            }
            this.f4113b = Integer.MIN_VALUE;
        }

        final void n(View view) {
            c cVar = (c) view.getLayoutParams();
            cVar.f4096e = this;
            this.f4112a.add(0, view);
            this.f4113b = Integer.MIN_VALUE;
            if (this.f4112a.size() == 1) {
                this.f4114c = Integer.MIN_VALUE;
            }
            if (cVar.c() || cVar.b()) {
                this.d = StaggeredGridLayoutManager.this.f4084t.c(view) + this.d;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i4) {
        this.f4082r = -1;
        this.f4088y = false;
        RecyclerView.l.d dVarT = RecyclerView.l.T(context, attributeSet, i2, i4);
        int i5 = dVarT.f4005a;
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i5 != this.f4085v) {
            this.f4085v = i5;
            s sVar = this.f4084t;
            this.f4084t = this.u;
            this.u = sVar;
            B0();
        }
        int i6 = dVarT.f4006b;
        g(null);
        if (i6 != this.f4082r) {
            this.f4074D.a();
            B0();
            this.f4082r = i6;
            this.f4071A = new BitSet(this.f4082r);
            this.f4083s = new f[this.f4082r];
            for (int i7 = 0; i7 < this.f4082r; i7++) {
                this.f4083s[i7] = new f(i7);
            }
            B0();
        }
        boolean z4 = dVarT.f4007c;
        g(null);
        e eVar = this.f4078H;
        if (eVar != null && eVar.p != z4) {
            eVar.p = z4;
        }
        this.f4088y = z4;
        B0();
        this.f4087x = new n();
        this.f4084t = s.a(this, this.f4085v);
        this.u = s.a(this, 1 - this.f4085v);
    }

    private int R0(int i2) {
        if (A() == 0) {
            return this.f4089z ? 1 : -1;
        }
        return (i2 < b1()) != this.f4089z ? -1 : 1;
    }

    private int T0(RecyclerView.v vVar) {
        if (A() == 0) {
            return 0;
        }
        return w.a(vVar, this.f4084t, Y0(!this.f4081K), X0(!this.f4081K), this, this.f4081K);
    }

    private int U0(RecyclerView.v vVar) {
        if (A() == 0) {
            return 0;
        }
        return w.b(vVar, this.f4084t, Y0(!this.f4081K), X0(!this.f4081K), this, this.f4081K, this.f4089z);
    }

    private int V0(RecyclerView.v vVar) {
        if (A() == 0) {
            return 0;
        }
        return w.c(vVar, this.f4084t, Y0(!this.f4081K), X0(!this.f4081K), this, this.f4081K);
    }

    private int W0(RecyclerView.q qVar, n nVar, RecyclerView.v vVar) {
        int i2;
        f fVar;
        int iC;
        int iC2;
        int iK;
        int iC3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        this.f4071A.set(0, this.f4082r, true);
        if (this.f4087x.f4250i) {
            i2 = nVar.f4247e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i2 = nVar.f4247e == 1 ? nVar.g + nVar.f4245b : nVar.f4248f - nVar.f4245b;
        }
        s1(nVar.f4247e, i2);
        int iG = this.f4089z ? this.f4084t.g() : this.f4084t.k();
        boolean z4 = false;
        while (true) {
            int i8 = nVar.f4246c;
            int i9 = -1;
            if (((i8 < 0 || i8 >= vVar.b()) ? i7 : 1) == 0 || (!this.f4087x.f4250i && this.f4071A.isEmpty())) {
                break;
            }
            View view = qVar.l(nVar.f4246c, Long.MAX_VALUE).f4055i;
            nVar.f4246c += nVar.d;
            c cVar = (c) view.getLayoutParams();
            int iA = cVar.a();
            int[] iArr = this.f4074D.f4097a;
            int i10 = (iArr == null || iA >= iArr.length) ? -1 : iArr[iA];
            if ((i10 == -1 ? 1 : i7) != 0) {
                if (k1(nVar.f4247e)) {
                    i5 = this.f4082r - 1;
                    i6 = -1;
                } else {
                    i9 = this.f4082r;
                    i5 = i7;
                    i6 = 1;
                }
                f fVar2 = null;
                if (nVar.f4247e == 1) {
                    int iK2 = this.f4084t.k();
                    int i11 = Integer.MAX_VALUE;
                    while (i5 != i9) {
                        f fVar3 = this.f4083s[i5];
                        int iH = fVar3.h(iK2);
                        if (iH < i11) {
                            i11 = iH;
                            fVar2 = fVar3;
                        }
                        i5 += i6;
                    }
                } else {
                    int iG2 = this.f4084t.g();
                    int i12 = Integer.MIN_VALUE;
                    while (i5 != i9) {
                        f fVar4 = this.f4083s[i5];
                        int iK3 = fVar4.k(iG2);
                        if (iK3 > i12) {
                            fVar2 = fVar4;
                            i12 = iK3;
                        }
                        i5 += i6;
                    }
                }
                fVar = fVar2;
                d dVar = this.f4074D;
                dVar.b(iA);
                dVar.f4097a[iA] = fVar.f4115e;
            } else {
                fVar = this.f4083s[i10];
            }
            f fVar5 = fVar;
            cVar.f4096e = fVar5;
            if (nVar.f4247e == 1) {
                d(view);
            } else {
                e(view);
            }
            if (this.f4085v == 1) {
                i1(view, RecyclerView.l.B(this.f4086w, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.l.B(J(), K(), O() + R(), ((ViewGroup.MarginLayoutParams) cVar).height, true));
            } else {
                i1(view, RecyclerView.l.B(W(), X(), Q() + P(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.l.B(this.f4086w, K(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false));
            }
            if (nVar.f4247e == 1) {
                int iH2 = fVar5.h(iG);
                iC2 = iH2;
                iC = this.f4084t.c(view) + iH2;
            } else {
                int iK4 = fVar5.k(iG);
                iC = iK4;
                iC2 = iK4 - this.f4084t.c(view);
            }
            if (nVar.f4247e == 1) {
                cVar.f4096e.a(view);
            } else {
                cVar.f4096e.n(view);
            }
            if (h1() && this.f4085v == 1) {
                iC3 = this.u.g() - (((this.f4082r - 1) - fVar5.f4115e) * this.f4086w);
                iK = iC3 - this.u.c(view);
            } else {
                iK = this.u.k() + (fVar5.f4115e * this.f4086w);
                iC3 = this.u.c(view) + iK;
            }
            int i13 = iC3;
            int i14 = iK;
            if (this.f4085v == 1) {
                b0(view, i14, iC2, i13, iC);
            } else {
                b0(view, iC2, i14, iC, i13);
            }
            u1(fVar5, this.f4087x.f4247e, i2);
            m1(qVar, this.f4087x);
            if (this.f4087x.f4249h && view.hasFocusable()) {
                i4 = 0;
                this.f4071A.set(fVar5.f4115e, false);
            } else {
                i4 = 0;
            }
            i7 = i4;
            z4 = true;
        }
        int i15 = i7;
        if (!z4) {
            m1(qVar, this.f4087x);
        }
        int iK5 = this.f4087x.f4247e == -1 ? this.f4084t.k() - e1(this.f4084t.k()) : d1(this.f4084t.g()) - this.f4084t.g();
        return iK5 > 0 ? Math.min(nVar.f4245b, iK5) : i15;
    }

    private void Z0(RecyclerView.q qVar, RecyclerView.v vVar, boolean z4) {
        int iG;
        int iD1 = d1(Integer.MIN_VALUE);
        if (iD1 != Integer.MIN_VALUE && (iG = this.f4084t.g() - iD1) > 0) {
            int i2 = iG - (-q1(-iG, qVar, vVar));
            if (!z4 || i2 <= 0) {
                return;
            }
            this.f4084t.p(i2);
        }
    }

    private void a1(RecyclerView.q qVar, RecyclerView.v vVar, boolean z4) {
        int iK;
        int iE1 = e1(Integer.MAX_VALUE);
        if (iE1 != Integer.MAX_VALUE && (iK = iE1 - this.f4084t.k()) > 0) {
            int iQ1 = iK - q1(iK, qVar, vVar);
            if (!z4 || iQ1 <= 0) {
                return;
            }
            this.f4084t.p(-iQ1);
        }
    }

    private int d1(int i2) {
        int iH = this.f4083s[0].h(i2);
        for (int i4 = 1; i4 < this.f4082r; i4++) {
            int iH2 = this.f4083s[i4].h(i2);
            if (iH2 > iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    private int e1(int i2) {
        int iK = this.f4083s[0].k(i2);
        for (int i4 = 1; i4 < this.f4082r; i4++) {
            int iK2 = this.f4083s[i4].k(i2);
            if (iK2 < iK) {
                iK = iK2;
            }
        }
        return iK;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f1(int i2, int i4, int i5) {
        int i6;
        int i7;
        int iC1 = this.f4089z ? c1() : b1();
        if (i5 != 8) {
            i6 = i2 + i4;
        } else {
            if (i2 >= i4) {
                i6 = i2 + 1;
                i7 = i4;
                this.f4074D.d(i7);
                if (i5 != 1) {
                    this.f4074D.e(i2, i4);
                } else if (i5 == 2) {
                    this.f4074D.f(i2, i4);
                } else if (i5 == 8) {
                    this.f4074D.f(i2, 1);
                    this.f4074D.e(i4, 1);
                }
                if (i6 > iC1) {
                    return;
                }
                if (i7 <= (this.f4089z ? b1() : c1())) {
                    B0();
                    return;
                }
                return;
            }
            i6 = i4 + 1;
        }
        i7 = i2;
        this.f4074D.d(i7);
        if (i5 != 1) {
        }
        if (i6 > iC1) {
        }
    }

    private void i1(View view, int i2, int i4) {
        Rect rect = this.f4079I;
        RecyclerView recyclerView = this.f3990b;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.O(view));
        }
        c cVar = (c) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect2 = this.f4079I;
        int iV1 = v1(i2, i5 + rect2.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect2.right);
        int i6 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect3 = this.f4079I;
        int iV12 = v1(i4, i6 + rect3.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect3.bottom);
        if (L0(view, iV1, iV12, cVar)) {
            view.measure(iV1, iV12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x040f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j1(RecyclerView.q qVar, RecyclerView.v vVar, boolean z4) {
        e eVar;
        boolean z5;
        int iS;
        int i2;
        b bVar = this.f4080J;
        if (!(this.f4078H == null && this.f4072B == -1) && vVar.b() == 0) {
            w0(qVar);
            bVar.b();
            return;
        }
        boolean z6 = true;
        boolean z7 = (bVar.f4094e && this.f4072B == -1 && this.f4078H == null) ? false : true;
        if (z7) {
            bVar.b();
            e eVar2 = this.f4078H;
            if (eVar2 != null) {
                int i4 = eVar2.f4105k;
                if (i4 > 0) {
                    if (i4 == this.f4082r) {
                        for (int i5 = 0; i5 < this.f4082r; i5++) {
                            this.f4083s[i5].d();
                            e eVar3 = this.f4078H;
                            int iG = eVar3.f4106l[i5];
                            if (iG != Integer.MIN_VALUE) {
                                iG += eVar3.f4110q ? this.f4084t.g() : this.f4084t.k();
                            }
                            f fVar = this.f4083s[i5];
                            fVar.f4113b = iG;
                            fVar.f4114c = iG;
                        }
                    } else {
                        eVar2.f4106l = null;
                        eVar2.f4105k = 0;
                        eVar2.f4107m = 0;
                        eVar2.f4108n = null;
                        eVar2.f4109o = null;
                        eVar2.f4103i = eVar2.f4104j;
                    }
                }
                e eVar4 = this.f4078H;
                this.f4077G = eVar4.f4111r;
                boolean z8 = eVar4.p;
                g(null);
                e eVar5 = this.f4078H;
                if (eVar5 != null && eVar5.p != z8) {
                    eVar5.p = z8;
                }
                this.f4088y = z8;
                B0();
                p1();
                e eVar6 = this.f4078H;
                int i6 = eVar6.f4103i;
                if (i6 != -1) {
                    this.f4072B = i6;
                    bVar.f4093c = eVar6.f4110q;
                } else {
                    bVar.f4093c = this.f4089z;
                }
                if (eVar6.f4107m > 1) {
                    d dVar = this.f4074D;
                    dVar.f4097a = eVar6.f4108n;
                    dVar.f4098b = eVar6.f4109o;
                }
            } else {
                p1();
                bVar.f4093c = this.f4089z;
            }
            if (vVar.g || (i2 = this.f4072B) == -1) {
                z5 = false;
                if (!z5) {
                    if (this.f4076F) {
                        int iB = vVar.b();
                        int iA = A();
                        while (true) {
                            iA--;
                            if (iA < 0) {
                                break;
                            }
                            iS = S(z(iA));
                            if (iS >= 0 && iS < iB) {
                                break;
                            }
                        }
                        bVar.f4091a = iS;
                        bVar.f4092b = Integer.MIN_VALUE;
                    } else {
                        int iB2 = vVar.b();
                        int iA2 = A();
                        for (int i7 = 0; i7 < iA2; i7++) {
                            int iS2 = S(z(i7));
                            if (iS2 >= 0 && iS2 < iB2) {
                                iS = iS2;
                                break;
                            }
                        }
                        iS = 0;
                        bVar.f4091a = iS;
                        bVar.f4092b = Integer.MIN_VALUE;
                    }
                }
                bVar.f4094e = true;
            } else if (i2 < 0 || i2 >= vVar.b()) {
                this.f4072B = -1;
                this.f4073C = Integer.MIN_VALUE;
                z5 = false;
                if (!z5) {
                }
                bVar.f4094e = true;
            } else {
                e eVar7 = this.f4078H;
                if (eVar7 == null || eVar7.f4103i == -1 || eVar7.f4105k < 1) {
                    View viewV = v(this.f4072B);
                    if (viewV != null) {
                        bVar.f4091a = this.f4089z ? c1() : b1();
                        if (this.f4073C != Integer.MIN_VALUE) {
                            if (bVar.f4093c) {
                                bVar.f4092b = (this.f4084t.g() - this.f4073C) - this.f4084t.b(viewV);
                            } else {
                                bVar.f4092b = (this.f4084t.k() + this.f4073C) - this.f4084t.e(viewV);
                            }
                        } else if (this.f4084t.c(viewV) > this.f4084t.l()) {
                            bVar.f4092b = bVar.f4093c ? this.f4084t.g() : this.f4084t.k();
                        } else {
                            int iE = this.f4084t.e(viewV) - this.f4084t.k();
                            if (iE < 0) {
                                bVar.f4092b = -iE;
                            } else {
                                int iG2 = this.f4084t.g() - this.f4084t.b(viewV);
                                if (iG2 < 0) {
                                    bVar.f4092b = iG2;
                                } else {
                                    bVar.f4092b = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        int i8 = this.f4072B;
                        bVar.f4091a = i8;
                        int i9 = this.f4073C;
                        if (i9 == Integer.MIN_VALUE) {
                            bVar.f4093c = R0(i8) == 1;
                            bVar.a();
                        } else if (bVar.f4093c) {
                            bVar.f4092b = StaggeredGridLayoutManager.this.f4084t.g() - i9;
                        } else {
                            bVar.f4092b = StaggeredGridLayoutManager.this.f4084t.k() + i9;
                        }
                        bVar.d = true;
                    }
                } else {
                    bVar.f4092b = Integer.MIN_VALUE;
                    bVar.f4091a = this.f4072B;
                }
                z5 = true;
                if (!z5) {
                }
                bVar.f4094e = true;
            }
        }
        if (this.f4078H == null && this.f4072B == -1 && (bVar.f4093c != this.f4076F || h1() != this.f4077G)) {
            this.f4074D.a();
            bVar.d = true;
        }
        if (A() > 0 && ((eVar = this.f4078H) == null || eVar.f4105k < 1)) {
            if (bVar.d) {
                for (int i10 = 0; i10 < this.f4082r; i10++) {
                    this.f4083s[i10].d();
                    int i11 = bVar.f4092b;
                    if (i11 != Integer.MIN_VALUE) {
                        f fVar2 = this.f4083s[i10];
                        fVar2.f4113b = i11;
                        fVar2.f4114c = i11;
                    }
                }
            } else if (z7 || this.f4080J.f4095f == null) {
                for (int i12 = 0; i12 < this.f4082r; i12++) {
                    f fVar3 = this.f4083s[i12];
                    boolean z9 = this.f4089z;
                    int i13 = bVar.f4092b;
                    int iH = z9 ? fVar3.h(Integer.MIN_VALUE) : fVar3.k(Integer.MIN_VALUE);
                    fVar3.d();
                    if (iH != Integer.MIN_VALUE && ((!z9 || iH >= StaggeredGridLayoutManager.this.f4084t.g()) && (z9 || iH <= StaggeredGridLayoutManager.this.f4084t.k()))) {
                        if (i13 != Integer.MIN_VALUE) {
                            iH += i13;
                        }
                        fVar3.f4114c = iH;
                        fVar3.f4113b = iH;
                    }
                }
                b bVar2 = this.f4080J;
                f[] fVarArr = this.f4083s;
                Objects.requireNonNull(bVar2);
                int length = fVarArr.length;
                int[] iArr = bVar2.f4095f;
                if (iArr == null || iArr.length < length) {
                    bVar2.f4095f = new int[StaggeredGridLayoutManager.this.f4083s.length];
                }
                for (int i14 = 0; i14 < length; i14++) {
                    bVar2.f4095f[i14] = fVarArr[i14].k(Integer.MIN_VALUE);
                }
            } else {
                for (int i15 = 0; i15 < this.f4082r; i15++) {
                    f fVar4 = this.f4083s[i15];
                    fVar4.d();
                    int i16 = this.f4080J.f4095f[i15];
                    fVar4.f4113b = i16;
                    fVar4.f4114c = i16;
                }
            }
        }
        t(qVar);
        this.f4087x.f4244a = false;
        int iL = this.u.l();
        this.f4086w = iL / this.f4082r;
        View.MeasureSpec.makeMeasureSpec(iL, this.u.i());
        t1(bVar.f4091a, vVar);
        if (bVar.f4093c) {
            r1(-1);
            W0(qVar, this.f4087x, vVar);
            r1(1);
            n nVar = this.f4087x;
            nVar.f4246c = bVar.f4091a + nVar.d;
            W0(qVar, nVar, vVar);
        } else {
            r1(1);
            W0(qVar, this.f4087x, vVar);
            r1(-1);
            n nVar2 = this.f4087x;
            nVar2.f4246c = bVar.f4091a + nVar2.d;
            W0(qVar, nVar2, vVar);
        }
        if (this.u.i() != 1073741824) {
            float fMax = 0.0f;
            int iA3 = A();
            for (int i17 = 0; i17 < iA3; i17++) {
                View viewZ = z(i17);
                float fC = this.u.c(viewZ);
                if (fC >= fMax) {
                    Objects.requireNonNull((c) viewZ.getLayoutParams());
                    fMax = Math.max(fMax, fC);
                }
            }
            int i18 = this.f4086w;
            int iRound = Math.round(fMax * this.f4082r);
            if (this.u.i() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, this.u.l());
            }
            this.f4086w = iRound / this.f4082r;
            View.MeasureSpec.makeMeasureSpec(iRound, this.u.i());
            if (this.f4086w != i18) {
                for (int i19 = 0; i19 < iA3; i19++) {
                    View viewZ2 = z(i19);
                    c cVar = (c) viewZ2.getLayoutParams();
                    Objects.requireNonNull(cVar);
                    if (h1() && this.f4085v == 1) {
                        int i20 = this.f4082r;
                        int i21 = cVar.f4096e.f4115e;
                        viewZ2.offsetLeftAndRight(((-((i20 - 1) - i21)) * this.f4086w) - ((-((i20 - 1) - i21)) * i18));
                    } else {
                        int i22 = cVar.f4096e.f4115e;
                        int i23 = this.f4086w * i22;
                        int i24 = i22 * i18;
                        if (this.f4085v == 1) {
                            viewZ2.offsetLeftAndRight(i23 - i24);
                        } else {
                            viewZ2.offsetTopAndBottom(i23 - i24);
                        }
                    }
                }
            }
        }
        if (A() > 0) {
            if (this.f4089z) {
                Z0(qVar, vVar, true);
                a1(qVar, vVar, false);
            } else {
                a1(qVar, vVar, true);
                Z0(qVar, vVar, false);
            }
        }
        if (!z4 || vVar.g) {
            z6 = false;
        } else if ((this.f4075E == 0 || A() <= 0 || g1() == null) ? false : true) {
            Runnable runnable = this.M;
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                recyclerView.removeCallbacks(runnable);
            }
            if (!S0()) {
            }
        }
        if (vVar.g) {
            this.f4080J.b();
        }
        this.f4076F = bVar.f4093c;
        this.f4077G = h1();
        if (z6) {
            this.f4080J.b();
            j1(qVar, vVar, false);
        }
    }

    private boolean k1(int i2) {
        if (this.f4085v == 0) {
            return (i2 == -1) != this.f4089z;
        }
        return ((i2 == -1) == this.f4089z) == h1();
    }

    private void m1(RecyclerView.q qVar, n nVar) {
        if (!nVar.f4244a || nVar.f4250i) {
            return;
        }
        if (nVar.f4245b == 0) {
            if (nVar.f4247e == -1) {
                n1(qVar, nVar.g);
                return;
            } else {
                o1(qVar, nVar.f4248f);
                return;
            }
        }
        int i2 = 1;
        if (nVar.f4247e == -1) {
            int i4 = nVar.f4248f;
            int iK = this.f4083s[0].k(i4);
            while (i2 < this.f4082r) {
                int iK2 = this.f4083s[i2].k(i4);
                if (iK2 > iK) {
                    iK = iK2;
                }
                i2++;
            }
            int i5 = i4 - iK;
            n1(qVar, i5 < 0 ? nVar.g : nVar.g - Math.min(i5, nVar.f4245b));
            return;
        }
        int i6 = nVar.g;
        int iH = this.f4083s[0].h(i6);
        while (i2 < this.f4082r) {
            int iH2 = this.f4083s[i2].h(i6);
            if (iH2 < iH) {
                iH = iH2;
            }
            i2++;
        }
        int i7 = iH - nVar.g;
        o1(qVar, i7 < 0 ? nVar.f4248f : Math.min(i7, nVar.f4245b) + nVar.f4248f);
    }

    private void n1(RecyclerView.q qVar, int i2) {
        for (int iA = A() - 1; iA >= 0; iA--) {
            View viewZ = z(iA);
            if (this.f4084t.e(viewZ) < i2 || this.f4084t.o(viewZ) < i2) {
                return;
            }
            c cVar = (c) viewZ.getLayoutParams();
            Objects.requireNonNull(cVar);
            if (cVar.f4096e.f4112a.size() == 1) {
                return;
            }
            cVar.f4096e.l();
            y0(viewZ, qVar);
        }
    }

    private void o1(RecyclerView.q qVar, int i2) {
        while (A() > 0) {
            View viewZ = z(0);
            if (this.f4084t.b(viewZ) > i2 || this.f4084t.n(viewZ) > i2) {
                return;
            }
            c cVar = (c) viewZ.getLayoutParams();
            Objects.requireNonNull(cVar);
            if (cVar.f4096e.f4112a.size() == 1) {
                return;
            }
            cVar.f4096e.m();
            y0(viewZ, qVar);
        }
    }

    private void p1() {
        if (this.f4085v == 1 || !h1()) {
            this.f4089z = this.f4088y;
        } else {
            this.f4089z = !this.f4088y;
        }
    }

    private void r1(int i2) {
        n nVar = this.f4087x;
        nVar.f4247e = i2;
        nVar.d = this.f4089z != (i2 == -1) ? -1 : 1;
    }

    private void s1(int i2, int i4) {
        for (int i5 = 0; i5 < this.f4082r; i5++) {
            if (!this.f4083s[i5].f4112a.isEmpty()) {
                u1(this.f4083s[i5], i2, i4);
            }
        }
    }

    private void t1(int i2, RecyclerView.v vVar) {
        int iL;
        int iL2;
        int i4;
        n nVar = this.f4087x;
        boolean z4 = false;
        nVar.f4245b = 0;
        nVar.f4246c = i2;
        RecyclerView.u uVar = this.g;
        if (!(uVar != null && uVar.f()) || (i4 = vVar.f4035a) == -1) {
            iL = 0;
            iL2 = 0;
        } else {
            if (this.f4089z == (i4 < i2)) {
                iL = this.f4084t.l();
                iL2 = 0;
            } else {
                iL2 = this.f4084t.l();
                iL = 0;
            }
        }
        RecyclerView recyclerView = this.f3990b;
        if (recyclerView != null && recyclerView.f3956o) {
            this.f4087x.f4248f = this.f4084t.k() - iL2;
            this.f4087x.g = this.f4084t.g() + iL;
        } else {
            this.f4087x.g = this.f4084t.f() + iL;
            this.f4087x.f4248f = -iL2;
        }
        n nVar2 = this.f4087x;
        nVar2.f4249h = false;
        nVar2.f4244a = true;
        if (this.f4084t.i() == 0 && this.f4084t.f() == 0) {
            z4 = true;
        }
        nVar2.f4250i = z4;
    }

    private void u1(f fVar, int i2, int i4) {
        int i5 = fVar.d;
        if (i2 == -1) {
            int i6 = fVar.f4113b;
            if (i6 == Integer.MIN_VALUE) {
                fVar.c();
                i6 = fVar.f4113b;
            }
            if (i6 + i5 <= i4) {
                this.f4071A.set(fVar.f4115e, false);
                return;
            }
            return;
        }
        int i7 = fVar.f4114c;
        if (i7 == Integer.MIN_VALUE) {
            fVar.b();
            i7 = fVar.f4114c;
        }
        if (i7 - i5 >= i4) {
            this.f4071A.set(fVar.f4115e, false);
        }
    }

    private int v1(int i2, int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i4) - i5), mode) : i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int C(RecyclerView.q qVar, RecyclerView.v vVar) {
        return this.f4085v == 1 ? this.f4082r : super.C(qVar, vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int C0(int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        return q1(i2, qVar, vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void D0(int i2) {
        e eVar = this.f4078H;
        if (eVar != null && eVar.f4103i != i2) {
            eVar.f4106l = null;
            eVar.f4105k = 0;
            eVar.f4103i = -1;
            eVar.f4104j = -1;
        }
        this.f4072B = i2;
        this.f4073C = Integer.MIN_VALUE;
        B0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int E0(int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        return q1(i2, qVar, vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void I0(Rect rect, int i2, int i4) {
        int iK;
        int iK2;
        int iQ = Q() + P();
        int iO = O() + R();
        if (this.f4085v == 1) {
            iK2 = RecyclerView.l.k(i4, rect.height() + iO, M());
            iK = RecyclerView.l.k(i2, (this.f4086w * this.f4082r) + iQ, N());
        } else {
            iK = RecyclerView.l.k(i2, rect.width() + iQ, N());
            iK2 = RecyclerView.l.k(i4, (this.f4086w * this.f4082r) + iO, M());
        }
        H0(iK, iK2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void O0(RecyclerView recyclerView, int i2) {
        o oVar = new o(recyclerView.getContext());
        oVar.k(i2);
        P0(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean Q0() {
        return this.f4078H == null;
    }

    final boolean S0() {
        int iB1;
        if (A() != 0 && this.f4075E != 0 && this.f3995i) {
            if (this.f4089z) {
                iB1 = c1();
                b1();
            } else {
                iB1 = b1();
                c1();
            }
            if (iB1 == 0 && g1() != null) {
                this.f4074D.a();
                this.f3994h = true;
                B0();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int U(RecyclerView.q qVar, RecyclerView.v vVar) {
        return this.f4085v == 0 ? this.f4082r : super.U(qVar, vVar);
    }

    final View X0(boolean z4) {
        int iK = this.f4084t.k();
        int iG = this.f4084t.g();
        View view = null;
        for (int iA = A() - 1; iA >= 0; iA--) {
            View viewZ = z(iA);
            int iE = this.f4084t.e(viewZ);
            int iB = this.f4084t.b(viewZ);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z4) {
                    return viewZ;
                }
                if (view == null) {
                    view = viewZ;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean Y() {
        return this.f4075E != 0;
    }

    final View Y0(boolean z4) {
        int iK = this.f4084t.k();
        int iG = this.f4084t.g();
        int iA = A();
        View view = null;
        for (int i2 = 0; i2 < iA; i2++) {
            View viewZ = z(i2);
            int iE = this.f4084t.e(viewZ);
            if (this.f4084t.b(viewZ) > iK && iE < iG) {
                if (iE >= iK || !z4) {
                    return viewZ;
                }
                if (view == null) {
                    view = viewZ;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.u.b
    public final PointF a(int i2) {
        int iR0 = R0(i2);
        PointF pointF = new PointF();
        if (iR0 == 0) {
            return null;
        }
        if (this.f4085v == 0) {
            pointF.x = iR0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iR0;
        }
        return pointF;
    }

    final int b1() {
        if (A() == 0) {
            return 0;
        }
        return S(z(0));
    }

    final int c1() {
        int iA = A();
        if (iA == 0) {
            return 0;
        }
        return S(z(iA - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void d0(int i2) {
        super.d0(i2);
        for (int i4 = 0; i4 < this.f4082r; i4++) {
            f fVar = this.f4083s[i4];
            int i5 = fVar.f4113b;
            if (i5 != Integer.MIN_VALUE) {
                fVar.f4113b = i5 + i2;
            }
            int i6 = fVar.f4114c;
            if (i6 != Integer.MIN_VALUE) {
                fVar.f4114c = i6 + i2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void e0(int i2) {
        super.e0(i2);
        for (int i4 = 0; i4 < this.f4082r; i4++) {
            f fVar = this.f4083s[i4];
            int i5 = fVar.f4113b;
            if (i5 != Integer.MIN_VALUE) {
                fVar.f4113b = i5 + i2;
            }
            int i6 = fVar.f4114c;
            if (i6 != Integer.MIN_VALUE) {
                fVar.f4114c = i6 + i2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void f0(RecyclerView recyclerView) {
        Runnable runnable = this.M;
        RecyclerView recyclerView2 = this.f3990b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(runnable);
        }
        for (int i2 = 0; i2 < this.f4082r; i2++) {
            this.f4083s[i2].d();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void g(String str) {
        if (this.f4078H == null) {
            super.g(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005b  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View g0(View view, int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        View viewU;
        int i4;
        if (A() == 0 || (viewU = u(view)) == null) {
            return null;
        }
        p1();
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 == 66 ? this.f4085v == 0 : !(i2 != 130 || this.f4085v != 1)) {
                            i4 = 1;
                        }
                    } else if (this.f4085v == 1) {
                        i4 = -1;
                    }
                    i4 = Integer.MIN_VALUE;
                } else if (this.f4085v != 0) {
                    i4 = Integer.MIN_VALUE;
                }
            } else if (this.f4085v != 1 && h1()) {
            }
        } else if (this.f4085v != 1 && h1()) {
        }
        if (i4 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewU.getLayoutParams();
        Objects.requireNonNull(cVar);
        f fVar = cVar.f4096e;
        int iC1 = i4 == 1 ? c1() : b1();
        t1(iC1, vVar);
        r1(i4);
        n nVar = this.f4087x;
        nVar.f4246c = nVar.d + iC1;
        nVar.f4245b = (int) (this.f4084t.l() * 0.33333334f);
        n nVar2 = this.f4087x;
        nVar2.f4249h = true;
        nVar2.f4244a = false;
        W0(qVar, nVar2, vVar);
        this.f4076F = this.f4089z;
        View viewI = fVar.i(iC1, i4);
        if (viewI != null && viewI != viewU) {
            return viewI;
        }
        if (k1(i4)) {
            for (int i5 = this.f4082r - 1; i5 >= 0; i5--) {
                View viewI2 = this.f4083s[i5].i(iC1, i4);
                if (viewI2 != null && viewI2 != viewU) {
                    return viewI2;
                }
            }
        } else {
            for (int i6 = 0; i6 < this.f4082r; i6++) {
                View viewI3 = this.f4083s[i6].i(iC1, i4);
                if (viewI3 != null && viewI3 != viewU) {
                    return viewI3;
                }
            }
        }
        boolean z4 = (this.f4088y ^ true) == (i4 == -1);
        View viewV = v(z4 ? fVar.e() : fVar.f());
        if (viewV != null && viewV != viewU) {
            return viewV;
        }
        if (k1(i4)) {
            for (int i7 = this.f4082r - 1; i7 >= 0; i7--) {
                if (i7 != fVar.f4115e) {
                    View viewV2 = v(z4 ? this.f4083s[i7].e() : this.f4083s[i7].f());
                    if (viewV2 != null && viewV2 != viewU) {
                        return viewV2;
                    }
                }
            }
        } else {
            for (int i8 = 0; i8 < this.f4082r; i8++) {
                View viewV3 = v(z4 ? this.f4083s[i8].e() : this.f4083s[i8].f());
                if (viewV3 != null && viewV3 != viewU) {
                    return viewV3;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final View g1() {
        int i2;
        boolean z4;
        boolean z5;
        int iA = A() - 1;
        BitSet bitSet = new BitSet(this.f4082r);
        bitSet.set(0, this.f4082r, true);
        char c2 = (this.f4085v == 1 && h1()) ? (char) 1 : (char) 65535;
        if (this.f4089z) {
            i2 = -1;
        } else {
            i2 = iA + 1;
            iA = 0;
        }
        int i4 = iA < i2 ? 1 : -1;
        while (iA != i2) {
            View viewZ = z(iA);
            c cVar = (c) viewZ.getLayoutParams();
            if (bitSet.get(cVar.f4096e.f4115e)) {
                f fVar = cVar.f4096e;
                if (this.f4089z) {
                    int i5 = fVar.f4114c;
                    if (i5 == Integer.MIN_VALUE) {
                        fVar.b();
                        i5 = fVar.f4114c;
                    }
                    if (i5 < this.f4084t.g()) {
                        ArrayList<View> arrayList = fVar.f4112a;
                        Objects.requireNonNull(fVar.j(arrayList.get(arrayList.size() - 1)));
                        z5 = true;
                    }
                    z5 = false;
                } else {
                    int i6 = fVar.f4113b;
                    if (i6 == Integer.MIN_VALUE) {
                        fVar.c();
                        i6 = fVar.f4113b;
                    }
                    if (i6 > this.f4084t.k()) {
                        Objects.requireNonNull(fVar.j(fVar.f4112a.get(0)));
                        z5 = true;
                    }
                    z5 = false;
                }
                if (z5) {
                    return viewZ;
                }
                bitSet.clear(cVar.f4096e.f4115e);
            }
            int i7 = iA + i4;
            if (i7 != i2) {
                View viewZ2 = z(i7);
                if (this.f4089z) {
                    int iB = this.f4084t.b(viewZ);
                    int iB2 = this.f4084t.b(viewZ2);
                    if (iB < iB2) {
                        return viewZ;
                    }
                    z4 = iB == iB2;
                } else {
                    int iE = this.f4084t.e(viewZ);
                    int iE2 = this.f4084t.e(viewZ2);
                    if (iE > iE2) {
                        return viewZ;
                    }
                    if (iE == iE2) {
                    }
                }
                if (z4) {
                    if ((cVar.f4096e.f4115e - ((c) viewZ2.getLayoutParams()).f4096e.f4115e < 0) != (c2 < 0)) {
                        return viewZ;
                    }
                } else {
                    continue;
                }
            }
            iA += i4;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean h() {
        return this.f4085v == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void h0(AccessibilityEvent accessibilityEvent) {
        super.h0(accessibilityEvent);
        if (A() > 0) {
            View viewY0 = Y0(false);
            View viewX0 = X0(false);
            if (viewY0 == null || viewX0 == null) {
                return;
            }
            int iS = S(viewY0);
            int iS2 = S(viewX0);
            if (iS < iS2) {
                accessibilityEvent.setFromIndex(iS);
                accessibilityEvent.setToIndex(iS2);
            } else {
                accessibilityEvent.setFromIndex(iS2);
                accessibilityEvent.setToIndex(iS);
            }
        }
    }

    final boolean h1() {
        return L() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean i() {
        return this.f4085v == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean j(RecyclerView.m mVar) {
        return mVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void j0(RecyclerView.q qVar, RecyclerView.v vVar, View view, F.b bVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            i0(view, bVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f4085v == 0) {
            f fVar = cVar.f4096e;
            bVar.H(b.c.a(fVar == null ? -1 : fVar.f4115e, 1, -1, -1, false));
        } else {
            f fVar2 = cVar.f4096e;
            bVar.H(b.c.a(-1, -1, fVar2 == null ? -1 : fVar2.f4115e, 1, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void k0(int i2, int i4) {
        f1(i2, i4, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void l(int i2, int i4, RecyclerView.v vVar, RecyclerView.l.c cVar) {
        int iH;
        int iK;
        if (this.f4085v != 0) {
            i2 = i4;
        }
        if (A() == 0 || i2 == 0) {
            return;
        }
        l1(i2, vVar);
        int[] iArr = this.L;
        if (iArr == null || iArr.length < this.f4082r) {
            this.L = new int[this.f4082r];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f4082r; i6++) {
            n nVar = this.f4087x;
            if (nVar.d == -1) {
                iH = nVar.f4248f;
                iK = this.f4083s[i6].k(iH);
            } else {
                iH = this.f4083s[i6].h(nVar.g);
                iK = this.f4087x.g;
            }
            int i7 = iH - iK;
            if (i7 >= 0) {
                this.L[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.L, 0, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = this.f4087x.f4246c;
            if (!(i9 >= 0 && i9 < vVar.b())) {
                return;
            }
            ((m.b) cVar).a(this.f4087x.f4246c, this.L[i8]);
            n nVar2 = this.f4087x;
            nVar2.f4246c += nVar2.d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void l0() {
        this.f4074D.a();
        B0();
    }

    final void l1(int i2, RecyclerView.v vVar) {
        int i4;
        int iB1;
        if (i2 > 0) {
            iB1 = c1();
            i4 = 1;
        } else {
            i4 = -1;
            iB1 = b1();
        }
        this.f4087x.f4244a = true;
        t1(iB1, vVar);
        r1(i4);
        n nVar = this.f4087x;
        nVar.f4246c = iB1 + nVar.d;
        nVar.f4245b = Math.abs(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void m0(int i2, int i4) {
        f1(i2, i4, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int n(RecyclerView.v vVar) {
        return T0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void n0(int i2, int i4) {
        f1(i2, i4, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int o(RecyclerView.v vVar) {
        return U0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void o0(int i2, int i4) {
        f1(i2, i4, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int p(RecyclerView.v vVar) {
        return V0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void p0(RecyclerView.q qVar, RecyclerView.v vVar) {
        j1(qVar, vVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int q(RecyclerView.v vVar) {
        return T0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void q0() {
        this.f4072B = -1;
        this.f4073C = Integer.MIN_VALUE;
        this.f4078H = null;
        this.f4080J.b();
    }

    final int q1(int i2, RecyclerView.q qVar, RecyclerView.v vVar) {
        if (A() == 0 || i2 == 0) {
            return 0;
        }
        l1(i2, vVar);
        int iW0 = W0(qVar, this.f4087x, vVar);
        if (this.f4087x.f4245b >= iW0) {
            i2 = i2 < 0 ? -iW0 : iW0;
        }
        this.f4084t.p(-i2);
        this.f4076F = this.f4089z;
        n nVar = this.f4087x;
        nVar.f4245b = 0;
        m1(qVar, nVar);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int r(RecyclerView.v vVar) {
        return U0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int s(RecyclerView.v vVar) {
        return V0(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void s0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f4078H = (e) parcelable;
            B0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final Parcelable t0() {
        int iK;
        int iK2;
        int[] iArr;
        e eVar = this.f4078H;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.p = this.f4088y;
        eVar2.f4110q = this.f4076F;
        eVar2.f4111r = this.f4077G;
        d dVar = this.f4074D;
        if (dVar == null || (iArr = dVar.f4097a) == null) {
            eVar2.f4107m = 0;
        } else {
            eVar2.f4108n = iArr;
            eVar2.f4107m = iArr.length;
            eVar2.f4109o = dVar.f4098b;
        }
        if (A() > 0) {
            eVar2.f4103i = this.f4076F ? c1() : b1();
            View viewX0 = this.f4089z ? X0(true) : Y0(true);
            eVar2.f4104j = viewX0 != null ? S(viewX0) : -1;
            int i2 = this.f4082r;
            eVar2.f4105k = i2;
            eVar2.f4106l = new int[i2];
            for (int i4 = 0; i4 < this.f4082r; i4++) {
                if (this.f4076F) {
                    iK = this.f4083s[i4].h(Integer.MIN_VALUE);
                    if (iK != Integer.MIN_VALUE) {
                        iK2 = this.f4084t.g();
                        iK -= iK2;
                    }
                } else {
                    iK = this.f4083s[i4].k(Integer.MIN_VALUE);
                    if (iK != Integer.MIN_VALUE) {
                        iK2 = this.f4084t.k();
                        iK -= iK2;
                    }
                }
                eVar2.f4106l[i4] = iK;
            }
        } else {
            eVar2.f4103i = -1;
            eVar2.f4104j = -1;
            eVar2.f4105k = 0;
        }
        return eVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void u0(int i2) {
        if (i2 == 0) {
            S0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m w() {
        return this.f4085v == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m x(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m y(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        int[] f4097a;

        /* renamed from: b, reason: collision with root package name */
        List<a> f4098b;

        d() {
        }

        final void a() {
            int[] iArr = this.f4097a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4098b = null;
        }

        final void b(int i2) {
            int[] iArr = this.f4097a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.f4097a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int length = iArr.length;
                while (length <= i2) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f4097a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f4097a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public final a c(int i2) {
            List<a> list = this.f4098b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f4098b.get(size);
                if (aVar.f4099i == i2) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final int d(int i2) {
            int i4;
            int[] iArr = this.f4097a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            if (this.f4098b != null) {
                a aVarC = c(i2);
                if (aVarC != null) {
                    this.f4098b.remove(aVarC);
                }
                int size = this.f4098b.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        i5 = -1;
                        break;
                    }
                    if (this.f4098b.get(i5).f4099i >= i2) {
                        break;
                    }
                    i5++;
                }
                if (i5 != -1) {
                    a aVar = this.f4098b.get(i5);
                    this.f4098b.remove(i5);
                    i4 = aVar.f4099i;
                } else {
                    i4 = -1;
                }
            }
            if (i4 == -1) {
                int[] iArr2 = this.f4097a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f4097a.length;
            }
            int i6 = i4 + 1;
            Arrays.fill(this.f4097a, i2, i6, -1);
            return i6;
        }

        final void e(int i2, int i4) {
            int[] iArr = this.f4097a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i5 = i2 + i4;
            b(i5);
            int[] iArr2 = this.f4097a;
            System.arraycopy(iArr2, i2, iArr2, i5, (iArr2.length - i2) - i4);
            Arrays.fill(this.f4097a, i2, i5, -1);
            List<a> list = this.f4098b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f4098b.get(size);
                int i6 = aVar.f4099i;
                if (i6 >= i2) {
                    aVar.f4099i = i6 + i4;
                }
            }
        }

        final void f(int i2, int i4) {
            int[] iArr = this.f4097a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i5 = i2 + i4;
            b(i5);
            int[] iArr2 = this.f4097a;
            System.arraycopy(iArr2, i5, iArr2, i2, (iArr2.length - i2) - i4);
            int[] iArr3 = this.f4097a;
            Arrays.fill(iArr3, iArr3.length - i4, iArr3.length, -1);
            List<a> list = this.f4098b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f4098b.get(size);
                int i6 = aVar.f4099i;
                if (i6 >= i2) {
                    if (i6 < i5) {
                        this.f4098b.remove(size);
                    } else {
                        aVar.f4099i = i6 - i4;
                    }
                }
            }
        }

        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0072a();

            /* renamed from: i, reason: collision with root package name */
            int f4099i;

            /* renamed from: j, reason: collision with root package name */
            int f4100j;

            /* renamed from: k, reason: collision with root package name */
            int[] f4101k;

            /* renamed from: l, reason: collision with root package name */
            boolean f4102l;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            static class C0072a implements Parcelable.Creator<a> {
                C0072a() {
                }

                @Override // android.os.Parcelable.Creator
                public final a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public final a[] newArray(int i2) {
                    return new a[i2];
                }
            }

            a(Parcel parcel) {
                this.f4099i = parcel.readInt();
                this.f4100j = parcel.readInt();
                this.f4102l = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    this.f4101k = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                StringBuilder sbD = D2.e.d("FullSpanItem{mPosition=");
                sbD.append(this.f4099i);
                sbD.append(", mGapDir=");
                sbD.append(this.f4100j);
                sbD.append(", mHasUnwantedGapAfter=");
                sbD.append(this.f4102l);
                sbD.append(", mGapPerSpan=");
                sbD.append(Arrays.toString(this.f4101k));
                sbD.append('}');
                return sbD.toString();
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f4099i);
                parcel.writeInt(this.f4100j);
                parcel.writeInt(this.f4102l ? 1 : 0);
                int[] iArr = this.f4101k;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f4101k);
                }
            }

            a() {
            }
        }
    }
}
