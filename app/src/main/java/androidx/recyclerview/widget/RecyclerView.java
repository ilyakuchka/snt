package androidx.recyclerview.widget;

import F.b;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.m;
import androidx.recyclerview.widget.y;
import androidx.recyclerview.widget.z;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: C0, reason: collision with root package name */
    private static final int[] f3910C0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: D0, reason: collision with root package name */
    private static final int[] f3911D0 = {R.attr.clipToPadding};

    /* renamed from: E0, reason: collision with root package name */
    private static final Class<?>[] f3912E0;

    /* renamed from: F0, reason: collision with root package name */
    static final Interpolator f3913F0;

    /* renamed from: A, reason: collision with root package name */
    boolean f3914A;

    /* renamed from: A0, reason: collision with root package name */
    private Runnable f3915A0;

    /* renamed from: B, reason: collision with root package name */
    boolean f3916B;

    /* renamed from: B0, reason: collision with root package name */
    private final d f3917B0;

    /* renamed from: C, reason: collision with root package name */
    private int f3918C;

    /* renamed from: D, reason: collision with root package name */
    boolean f3919D;

    /* renamed from: E, reason: collision with root package name */
    boolean f3920E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f3921F;

    /* renamed from: G, reason: collision with root package name */
    private int f3922G;

    /* renamed from: H, reason: collision with root package name */
    boolean f3923H;

    /* renamed from: I, reason: collision with root package name */
    private final AccessibilityManager f3924I;

    /* renamed from: J, reason: collision with root package name */
    boolean f3925J;

    /* renamed from: K, reason: collision with root package name */
    boolean f3926K;
    private int L;
    private int M;

    /* renamed from: N, reason: collision with root package name */
    private h f3927N;

    /* renamed from: O, reason: collision with root package name */
    private EdgeEffect f3928O;
    private EdgeEffect P;

    /* renamed from: Q, reason: collision with root package name */
    private EdgeEffect f3929Q;

    /* renamed from: R, reason: collision with root package name */
    private EdgeEffect f3930R;

    /* renamed from: S, reason: collision with root package name */
    i f3931S;

    /* renamed from: T, reason: collision with root package name */
    private int f3932T;

    /* renamed from: U, reason: collision with root package name */
    private int f3933U;

    /* renamed from: V, reason: collision with root package name */
    private VelocityTracker f3934V;

    /* renamed from: W, reason: collision with root package name */
    private int f3935W;

    /* renamed from: a0, reason: collision with root package name */
    private int f3936a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f3937b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f3938c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f3939d0;

    /* renamed from: e0, reason: collision with root package name */
    private final int f3940e0;

    /* renamed from: f0, reason: collision with root package name */
    private final int f3941f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f3942g0;

    /* renamed from: h0, reason: collision with root package name */
    private float f3943h0;

    /* renamed from: i, reason: collision with root package name */
    private final s f3944i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f3945i0;

    /* renamed from: j, reason: collision with root package name */
    final q f3946j;

    /* renamed from: j0, reason: collision with root package name */
    final w f3947j0;

    /* renamed from: k, reason: collision with root package name */
    private t f3948k;

    /* renamed from: k0, reason: collision with root package name */
    androidx.recyclerview.widget.m f3949k0;

    /* renamed from: l, reason: collision with root package name */
    androidx.recyclerview.widget.a f3950l;

    /* renamed from: l0, reason: collision with root package name */
    m.b f3951l0;

    /* renamed from: m, reason: collision with root package name */
    androidx.recyclerview.widget.d f3952m;

    /* renamed from: m0, reason: collision with root package name */
    final v f3953m0;

    /* renamed from: n, reason: collision with root package name */
    final z f3954n;

    /* renamed from: n0, reason: collision with root package name */
    private List<o> f3955n0;

    /* renamed from: o, reason: collision with root package name */
    boolean f3956o;

    /* renamed from: o0, reason: collision with root package name */
    boolean f3957o0;
    final Runnable p;
    boolean p0;

    /* renamed from: q, reason: collision with root package name */
    final Rect f3958q;
    private j q0;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f3959r;

    /* renamed from: r0, reason: collision with root package name */
    boolean f3960r0;

    /* renamed from: s, reason: collision with root package name */
    final RectF f3961s;

    /* renamed from: s0, reason: collision with root package name */
    androidx.recyclerview.widget.v f3962s0;

    /* renamed from: t, reason: collision with root package name */
    e f3963t;

    /* renamed from: t0, reason: collision with root package name */
    private final int[] f3964t0;
    l u;

    /* renamed from: u0, reason: collision with root package name */
    private androidx.core.view.g f3965u0;

    /* renamed from: v, reason: collision with root package name */
    r f3966v;

    /* renamed from: v0, reason: collision with root package name */
    private final int[] f3967v0;

    /* renamed from: w, reason: collision with root package name */
    final ArrayList<k> f3968w;

    /* renamed from: w0, reason: collision with root package name */
    final int[] f3969w0;

    /* renamed from: x, reason: collision with root package name */
    private final ArrayList<n> f3970x;

    /* renamed from: x0, reason: collision with root package name */
    private final int[] f3971x0;

    /* renamed from: y, reason: collision with root package name */
    private n f3972y;

    /* renamed from: y0, reason: collision with root package name */
    final int[] f3973y0;

    /* renamed from: z, reason: collision with root package name */
    boolean f3974z;

    /* renamed from: z0, reason: collision with root package name */
    final List<x> f3975z0;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f3916B || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f3974z) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f3920E) {
                recyclerView2.f3919D = true;
            } else {
                recyclerView2.p();
            }
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            i iVar = RecyclerView.this.f3931S;
            if (iVar != null) {
                iVar.l();
            }
            RecyclerView.this.f3960r0 = false;
        }
    }

    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    }

    final class d {
        d() {
        }

        public final void a(x xVar, i.c cVar, i.c cVar2) {
            boolean zP;
            int i2;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            Objects.requireNonNull(recyclerView);
            xVar.x(false);
            androidx.recyclerview.widget.x xVar2 = (androidx.recyclerview.widget.x) recyclerView.f3931S;
            Objects.requireNonNull(xVar2);
            if (cVar == null || ((i2 = cVar.f3986a) == (i4 = cVar2.f3986a) && cVar.f3987b == cVar2.f3987b)) {
                xVar2.n(xVar);
                zP = true;
            } else {
                zP = xVar2.p(xVar, i2, cVar.f3987b, i4, cVar2.f3987b);
            }
            if (zP) {
                recyclerView.c0();
            }
        }
    }

    public static abstract class e<VH extends x> {

        /* renamed from: a, reason: collision with root package name */
        private final f f3979a = new f();

        /* renamed from: b, reason: collision with root package name */
        private boolean f3980b = false;

        public boolean A(VH vh) {
            return false;
        }

        public void B(VH vh) {
        }

        public void C(VH vh) {
        }

        public void D(g gVar) {
            this.f3979a.registerObserver(gVar);
        }

        public final void E(boolean z4) {
            if (this.f3979a.a()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f3980b = z4;
        }

        public void F(g gVar) {
            this.f3979a.unregisterObserver(gVar);
        }

        public void a(VH vh) {
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Object>] */
        public final void i(VH vh, int i2) {
            vh.f4057k = i2;
            if (this.f3980b) {
                vh.f4059m = k(i2);
            }
            vh.w(1, 519);
            Trace.beginSection("RV OnBindView");
            vh.j();
            x(vh, i2);
            ?? r2 = vh.f4064s;
            if (r2 != 0) {
                r2.clear();
            }
            vh.f4063r &= -1025;
            ViewGroup.LayoutParams layoutParams = vh.f4055i.getLayoutParams();
            if (layoutParams instanceof m) {
                ((m) layoutParams).f4010c = true;
            }
            Trace.endSection();
        }

        public abstract int j();

        public long k(int i2) {
            return -1L;
        }

        public int l(int i2) {
            return 0;
        }

        public final boolean m() {
            return this.f3980b;
        }

        public final void n() {
            this.f3979a.b();
        }

        public final void o(int i2) {
            this.f3979a.d(i2, 1, null);
        }

        public final void p(int i2, Object obj) {
            this.f3979a.d(i2, 1, obj);
        }

        public final void q(int i2) {
            this.f3979a.e(i2, 1);
        }

        public final void r(int i2, int i4) {
            this.f3979a.c(i2, i4);
        }

        public final void s(int i2, int i4, Object obj) {
            this.f3979a.d(i2, i4, obj);
        }

        public final void t(int i2, int i4) {
            this.f3979a.e(i2, i4);
        }

        public final void u(int i2, int i4) {
            this.f3979a.f(i2, i4);
        }

        public final void v(int i2) {
            this.f3979a.f(i2, 1);
        }

        public void w(RecyclerView recyclerView) {
        }

        public abstract void x(VH vh, int i2);

        public abstract VH y(ViewGroup viewGroup, int i2);

        public void z(RecyclerView recyclerView) {
        }
    }

    static class f extends Observable<g> {
        f() {
        }

        public final boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).g();
            }
        }

        public final void c(int i2, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).k(i2, i4);
            }
        }

        public final void d(int i2, int i4, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).i(i2, i4, obj);
            }
        }

        public final void e(int i2, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).j(i2, i4);
            }
        }

        public final void f(int i2, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).l(i2, i4);
            }
        }
    }

    public static abstract class g {
        public void g() {
        }

        public void h(int i2, int i4) {
        }

        public void i(int i2, int i4, Object obj) {
            h(i2, i4);
        }

        public void j(int i2, int i4) {
        }

        public void k(int i2, int i4) {
        }

        public void l(int i2, int i4) {
        }
    }

    public static class h {
        protected final EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class i {

        /* renamed from: a, reason: collision with root package name */
        private b f3981a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<a> f3982b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private long f3983c = 120;
        private long d = 120;

        /* renamed from: e, reason: collision with root package name */
        private long f3984e = 250;

        /* renamed from: f, reason: collision with root package name */
        private long f3985f = 250;

        public interface a {
            void a();
        }

        interface b {
        }

        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f3986a;

            /* renamed from: b, reason: collision with root package name */
            public int f3987b;

            public final c a(x xVar) {
                View view = xVar.f4055i;
                this.f3986a = view.getLeft();
                this.f3987b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int b(x xVar) {
            int i2 = xVar.f4063r & 14;
            if (xVar.m()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int i4 = xVar.f4058l;
            int iH = xVar.h();
            return (i4 == -1 || iH == -1 || i4 == iH) ? i2 : i2 | 2048;
        }

        public abstract boolean a(x xVar, x xVar2, c cVar, c cVar2);

        public final void c(x xVar) {
            b bVar = this.f3981a;
            if (bVar != null) {
                j jVar = (j) bVar;
                Objects.requireNonNull(jVar);
                xVar.x(true);
                if (xVar.p != null && xVar.f4062q == null) {
                    xVar.p = null;
                }
                xVar.f4062q = null;
                if ((xVar.f4063r & 16) != 0) {
                    return;
                }
                RecyclerView recyclerView = RecyclerView.this;
                View view = xVar.f4055i;
                recyclerView.z0();
                boolean zO = recyclerView.f3952m.o(view);
                if (zO) {
                    x xVarN = RecyclerView.N(view);
                    recyclerView.f3946j.m(xVarN);
                    recyclerView.f3946j.i(xVarN);
                }
                recyclerView.B0(!zO);
                if (zO || !xVar.p()) {
                    return;
                }
                RecyclerView.this.removeDetachedView(xVar.f4055i, false);
            }
        }

        public final void d() {
            int size = this.f3982b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3982b.get(i2).a();
            }
            this.f3982b.clear();
        }

        public abstract void e(x xVar);

        public abstract void f();

        public final long g() {
            return this.f3983c;
        }

        public final long h() {
            return this.f3985f;
        }

        public final long i() {
            return this.f3984e;
        }

        public final long j() {
            return this.d;
        }

        public abstract boolean k();

        public abstract void l();

        final void m(b bVar) {
            this.f3981a = bVar;
        }
    }

    private class j implements i.b {
        j() {
        }
    }

    public static abstract class k {
        public void d(Rect rect, View view, RecyclerView recyclerView) {
            ((m) view.getLayoutParams()).a();
            rect.set(0, 0, 0, 0);
        }

        public void e(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.d f3989a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView f3990b;

        /* renamed from: c, reason: collision with root package name */
        private final a f3991c;
        private final b d;

        /* renamed from: e, reason: collision with root package name */
        y f3992e;

        /* renamed from: f, reason: collision with root package name */
        y f3993f;
        u g;

        /* renamed from: h, reason: collision with root package name */
        boolean f3994h;

        /* renamed from: i, reason: collision with root package name */
        boolean f3995i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f3996j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f3997k;

        /* renamed from: l, reason: collision with root package name */
        int f3998l;

        /* renamed from: m, reason: collision with root package name */
        boolean f3999m;

        /* renamed from: n, reason: collision with root package name */
        private int f4000n;

        /* renamed from: o, reason: collision with root package name */
        private int f4001o;
        private int p;

        /* renamed from: q, reason: collision with root package name */
        private int f4002q;

        final class a implements y.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.y.b
            public final View a(int i2) {
                return l.this.z(i2);
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int b() {
                return l.this.W() - l.this.Q();
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int c() {
                return l.this.P();
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int d(View view) {
                return l.this.G(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int e(View view) {
                return l.this.F(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).leftMargin;
            }
        }

        final class b implements y.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.y.b
            public final View a(int i2) {
                return l.this.z(i2);
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int b() {
                return l.this.J() - l.this.O();
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int c() {
                return l.this.R();
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int d(View view) {
                return l.this.D(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.y.b
            public final int e(View view) {
                return l.this.H(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
        }

        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f4005a;

            /* renamed from: b, reason: collision with root package name */
            public int f4006b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f4007c;
            public boolean d;
        }

        public l() {
            a aVar = new a();
            this.f3991c = aVar;
            b bVar = new b();
            this.d = bVar;
            this.f3992e = new y(aVar);
            this.f3993f = new y(bVar);
            this.f3994h = false;
            this.f3995i = false;
            this.f3996j = true;
            this.f3997k = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int B(int i2, int i4, int i5, int i6, boolean z4) {
            int iMax = Math.max(0, i2 - i5);
            if (z4) {
                if (i6 < 0) {
                    if (i6 != -1 || (i4 != Integer.MIN_VALUE && (i4 == 0 || i4 != 1073741824))) {
                        i4 = 0;
                        i6 = 0;
                    } else {
                        i6 = iMax;
                    }
                }
                i4 = 1073741824;
            } else if (i6 >= 0) {
                i4 = 1073741824;
            } else if (i6 != -1) {
                if (i6 == -2) {
                    if (i4 == Integer.MIN_VALUE || i4 == 1073741824) {
                        i6 = iMax;
                        i4 = Integer.MIN_VALUE;
                    } else {
                        i6 = iMax;
                        i4 = 0;
                    }
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i6, i4);
        }

        public static d T(Context context, AttributeSet attributeSet, int i2, int i4) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2113e, i2, i4);
            dVar.f4005a = typedArrayObtainStyledAttributes.getInt(0, 1);
            dVar.f4006b = typedArrayObtainStyledAttributes.getInt(9, 1);
            dVar.f4007c = typedArrayObtainStyledAttributes.getBoolean(8, false);
            dVar.d = typedArrayObtainStyledAttributes.getBoolean(10, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        private static boolean a0(int i2, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (i5 > 0 && i2 != i5) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        private void f(View view, int i2, boolean z4) {
            x xVarN = RecyclerView.N(view);
            if (z4 || xVarN.n()) {
                this.f3990b.f3954n.a(xVarN);
            } else {
                this.f3990b.f3954n.g(xVarN);
            }
            m mVar = (m) view.getLayoutParams();
            if (xVarN.A() || xVarN.o()) {
                if (xVarN.o()) {
                    xVarN.z();
                } else {
                    xVarN.g();
                }
                this.f3989a.b(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3990b) {
                int iK = this.f3989a.k(view);
                if (i2 == -1) {
                    i2 = this.f3989a.e();
                }
                if (iK == -1) {
                    StringBuilder sbD = D2.e.d("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sbD.append(this.f3990b.indexOfChild(view));
                    sbD.append(this.f3990b.C());
                    throw new IllegalStateException(sbD.toString());
                }
                if (iK != i2) {
                    l lVar = this.f3990b.u;
                    View viewZ = lVar.z(iK);
                    if (viewZ == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iK + lVar.f3990b.toString());
                    }
                    lVar.z(iK);
                    lVar.f3989a.c(iK);
                    m mVar2 = (m) viewZ.getLayoutParams();
                    x xVarN2 = RecyclerView.N(viewZ);
                    if (xVarN2.n()) {
                        lVar.f3990b.f3954n.a(xVarN2);
                    } else {
                        lVar.f3990b.f3954n.g(xVarN2);
                    }
                    lVar.f3989a.b(viewZ, i2, mVar2, xVarN2.n());
                }
            } else {
                this.f3989a.a(view, i2, false);
                mVar.f4010c = true;
                u uVar = this.g;
                if (uVar != null && uVar.f()) {
                    this.g.h(view);
                }
            }
            if (mVar.d) {
                xVarN.f4055i.invalidate();
                mVar.d = false;
            }
        }

        public static int k(int i2, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i4, i5) : size : Math.min(size, Math.max(i4, i5));
        }

        public final int A() {
            androidx.recyclerview.widget.d dVar = this.f3989a;
            if (dVar != null) {
                return dVar.e();
            }
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean A0(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
            boolean z6;
            int[] iArr = new int[2];
            int iP = P();
            int iR = R();
            int iQ = this.p - Q();
            int iO = this.f4002q - O();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i2 = left - iP;
            int iMin = Math.min(0, i2);
            int i4 = top - iR;
            int iMin2 = Math.min(0, i4);
            int i5 = iWidth - iQ;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, iHeight - iO);
            if (L() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i2, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i5);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i4, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (z5) {
                View focusedChild = recyclerView.getFocusedChild();
                if (focusedChild == null) {
                    z6 = false;
                    if (z6) {
                    }
                } else {
                    int iP2 = P();
                    int iR2 = R();
                    int iQ2 = this.p - Q();
                    int iO2 = this.f4002q - O();
                    Rect rect2 = this.f3990b.f3958q;
                    E(focusedChild, rect2);
                    if (rect2.left - i6 < iQ2 && rect2.right - i6 > iP2 && rect2.top - i7 < iO2 && rect2.bottom - i7 > iR2) {
                        z6 = true;
                    }
                    if (z6) {
                    }
                }
            } else if (i6 != 0 || i7 != 0) {
                if (z4) {
                    recyclerView.scrollBy(i6, i7);
                } else {
                    recyclerView.x0(i6, i7);
                }
                return true;
            }
            return false;
        }

        public final void B0() {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int C(q qVar, v vVar) {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView == null || recyclerView.f3963t == null || !h()) {
                return 1;
            }
            return this.f3990b.f3963t.j();
        }

        public int C0(int i2, q qVar, v vVar) {
            return 0;
        }

        public final int D(View view) {
            return view.getBottom() + ((m) view.getLayoutParams()).f4009b.bottom;
        }

        public void D0(int i2) {
        }

        public final void E(View view, Rect rect) {
            Interpolator interpolator = RecyclerView.f3913F0;
            m mVar = (m) view.getLayoutParams();
            Rect rect2 = mVar.f4009b;
            rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public int E0(int i2, q qVar, v vVar) {
            return 0;
        }

        public final int F(View view) {
            return view.getLeft() - ((m) view.getLayoutParams()).f4009b.left;
        }

        final void F0(RecyclerView recyclerView) {
            G0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final int G(View view) {
            return view.getRight() + ((m) view.getLayoutParams()).f4009b.right;
        }

        final void G0(int i2, int i4) {
            this.p = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.f4000n = mode;
            if (mode == 0) {
                Interpolator interpolator = RecyclerView.f3913F0;
            }
            this.f4002q = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f4001o = mode2;
            if (mode2 == 0) {
                Interpolator interpolator2 = RecyclerView.f3913F0;
            }
        }

        public final int H(View view) {
            return view.getTop() - ((m) view.getLayoutParams()).f4009b.top;
        }

        public final void H0(int i2, int i4) {
            this.f3990b.setMeasuredDimension(i2, i4);
        }

        public final View I() {
            View focusedChild;
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f3989a.l(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void I0(Rect rect, int i2, int i4) {
            H0(k(i2, Q() + P() + rect.width(), N()), k(i4, O() + R() + rect.height(), M()));
        }

        public final int J() {
            return this.f4002q;
        }

        final void J0(int i2, int i4) {
            int iA = A();
            if (iA == 0) {
                this.f3990b.q(i2, i4);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MIN_VALUE;
            for (int i9 = 0; i9 < iA; i9++) {
                View viewZ = z(i9);
                Rect rect = this.f3990b.f3958q;
                E(viewZ, rect);
                int i10 = rect.left;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.right;
                if (i11 > i5) {
                    i5 = i11;
                }
                int i12 = rect.top;
                if (i12 < i7) {
                    i7 = i12;
                }
                int i13 = rect.bottom;
                if (i13 > i8) {
                    i8 = i13;
                }
            }
            this.f3990b.f3958q.set(i6, i7, i5, i8);
            I0(this.f3990b.f3958q, i2, i4);
        }

        public final int K() {
            return this.f4001o;
        }

        final void K0(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f3990b = null;
                this.f3989a = null;
                this.p = 0;
                this.f4002q = 0;
            } else {
                this.f3990b = recyclerView;
                this.f3989a = recyclerView.f3952m;
                this.p = recyclerView.getWidth();
                this.f4002q = recyclerView.getHeight();
            }
            this.f4000n = 1073741824;
            this.f4001o = 1073741824;
        }

        public final int L() {
            RecyclerView recyclerView = this.f3990b;
            int i2 = androidx.core.view.o.d;
            return recyclerView.getLayoutDirection();
        }

        final boolean L0(View view, int i2, int i4, m mVar) {
            return (!view.isLayoutRequested() && this.f3996j && a0(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) mVar).width) && a0(view.getHeight(), i4, ((ViewGroup.MarginLayoutParams) mVar).height)) ? false : true;
        }

        public final int M() {
            RecyclerView recyclerView = this.f3990b;
            int i2 = androidx.core.view.o.d;
            return recyclerView.getMinimumHeight();
        }

        boolean M0() {
            return false;
        }

        public final int N() {
            RecyclerView recyclerView = this.f3990b;
            int i2 = androidx.core.view.o.d;
            return recyclerView.getMinimumWidth();
        }

        final boolean N0(View view, int i2, int i4, m mVar) {
            return (this.f3996j && a0(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) mVar).width) && a0(view.getMeasuredHeight(), i4, ((ViewGroup.MarginLayoutParams) mVar).height)) ? false : true;
        }

        public final int O() {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public void O0(RecyclerView recyclerView, int i2) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public final int P() {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final void P0(u uVar) {
            u uVar2 = this.g;
            if (uVar2 != null && uVar != uVar2 && uVar2.f()) {
                this.g.m();
            }
            this.g = uVar;
            uVar.l(this.f3990b, this);
        }

        public final int Q() {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public boolean Q0() {
            return false;
        }

        public final int R() {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public final int S(View view) {
            return ((m) view.getLayoutParams()).a();
        }

        public int U(q qVar, v vVar) {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView == null || recyclerView.f3963t == null || !i()) {
                return 1;
            }
            return this.f3990b.f3963t.j();
        }

        public final void V(View view, Rect rect) {
            Matrix matrix;
            Rect rect2 = ((m) view.getLayoutParams()).f4009b;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (this.f3990b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f3990b.f3961s;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public final int W() {
            return this.p;
        }

        public final int X() {
            return this.f4000n;
        }

        public boolean Y() {
            return false;
        }

        public final boolean Z() {
            return this.f3997k;
        }

        public final void b(View view) {
            f(view, -1, true);
        }

        public final void b0(View view, int i2, int i4, int i5, int i6) {
            m mVar = (m) view.getLayoutParams();
            Rect rect = mVar.f4009b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) mVar).leftMargin, i4 + rect.top + ((ViewGroup.MarginLayoutParams) mVar).topMargin, (i5 - rect.right) - ((ViewGroup.MarginLayoutParams) mVar).rightMargin, (i6 - rect.bottom) - ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public final void c(View view) {
            f(view, 0, true);
        }

        public final void c0(View view) {
            m mVar = (m) view.getLayoutParams();
            Rect rectO = this.f3990b.O(view);
            int i2 = rectO.left + rectO.right + 0;
            int i4 = rectO.top + rectO.bottom + 0;
            int iB = B(this.p, this.f4000n, Q() + P() + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin + i2, ((ViewGroup.MarginLayoutParams) mVar).width, h());
            int iB2 = B(this.f4002q, this.f4001o, O() + R() + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) mVar).height, i());
            if (L0(view, iB, iB2, mVar)) {
                view.measure(iB, iB2);
            }
        }

        public final void d(View view) {
            f(view, -1, false);
        }

        public void d0(int i2) {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                int iE = recyclerView.f3952m.e();
                for (int i4 = 0; i4 < iE; i4++) {
                    recyclerView.f3952m.d(i4).offsetLeftAndRight(i2);
                }
            }
        }

        public final void e(View view) {
            f(view, 0, false);
        }

        public void e0(int i2) {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                int iE = recyclerView.f3952m.e();
                for (int i4 = 0; i4 < iE; i4++) {
                    recyclerView.f3952m.d(i4).offsetTopAndBottom(i2);
                }
            }
        }

        public void f0(RecyclerView recyclerView) {
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView != null) {
                recyclerView.k(str);
            }
        }

        public View g0(View view, int i2, q qVar, v vVar) {
            return null;
        }

        public boolean h() {
            return false;
        }

        public void h0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3990b;
            q qVar = recyclerView.f3946j;
            v vVar = recyclerView.f3953m0;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z4 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f3990b.canScrollVertically(-1) && !this.f3990b.canScrollHorizontally(-1) && !this.f3990b.canScrollHorizontally(1)) {
                z4 = false;
            }
            accessibilityEvent.setScrollable(z4);
            e eVar = this.f3990b.f3963t;
            if (eVar != null) {
                accessibilityEvent.setItemCount(eVar.j());
            }
        }

        public boolean i() {
            return false;
        }

        final void i0(View view, F.b bVar) {
            x xVarN = RecyclerView.N(view);
            if (xVarN == null || xVarN.n() || this.f3989a.l(xVarN.f4055i)) {
                return;
            }
            RecyclerView recyclerView = this.f3990b;
            j0(recyclerView.f3946j, recyclerView.f3953m0, view, bVar);
        }

        public boolean j(m mVar) {
            return mVar != null;
        }

        public void j0(q qVar, v vVar, View view, F.b bVar) {
            bVar.H(b.c.a(i() ? S(view) : 0, 1, h() ? S(view) : 0, 1, false));
        }

        public void k0(int i2, int i4) {
        }

        public void l(int i2, int i4, v vVar, c cVar) {
        }

        public void l0() {
        }

        public void m(int i2, c cVar) {
        }

        public void m0(int i2, int i4) {
        }

        public int n(v vVar) {
            return 0;
        }

        public void n0(int i2, int i4) {
        }

        public int o(v vVar) {
            return 0;
        }

        public void o0(int i2, int i4) {
        }

        public int p(v vVar) {
            return 0;
        }

        public void p0(q qVar, v vVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int q(v vVar) {
            return 0;
        }

        public void q0() {
        }

        public int r(v vVar) {
            return 0;
        }

        public final void r0(int i2, int i4) {
            this.f3990b.q(i2, i4);
        }

        public int s(v vVar) {
            return 0;
        }

        public void s0(Parcelable parcelable) {
        }

        public final void t(q qVar) {
            int iA = A();
            while (true) {
                iA--;
                if (iA < 0) {
                    return;
                }
                View viewZ = z(iA);
                x xVarN = RecyclerView.N(viewZ);
                if (!xVarN.y()) {
                    if (!xVarN.m() || xVarN.n() || this.f3990b.f3963t.m()) {
                        z(iA);
                        this.f3989a.c(iA);
                        qVar.j(viewZ);
                        this.f3990b.f3954n.g(xVarN);
                    } else {
                        if (z(iA) != null) {
                            this.f3989a.n(iA);
                        }
                        qVar.i(xVarN);
                    }
                }
            }
        }

        public Parcelable t0() {
            return null;
        }

        public final View u(View view) {
            View viewE;
            RecyclerView recyclerView = this.f3990b;
            if (recyclerView == null || (viewE = recyclerView.E(view)) == null || this.f3989a.l(viewE)) {
                return null;
            }
            return viewE;
        }

        public void u0(int i2) {
        }

        public View v(int i2) {
            int iA = A();
            for (int i4 = 0; i4 < iA; i4++) {
                View viewZ = z(i4);
                x xVarN = RecyclerView.N(viewZ);
                if (xVarN != null && xVarN.i() == i2 && !xVarN.y() && (this.f3990b.f3953m0.g || !xVarN.n())) {
                    return viewZ;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[PHI: r0
          0x0067: PHI (r0v6 int) = (r0v2 int), (r0v10 int) binds: [B:19:0x0058, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final boolean v0(int i2) {
            int iR;
            int iP;
            RecyclerView recyclerView = this.f3990b;
            q qVar = recyclerView.f3946j;
            if (i2 == 4096) {
                iR = recyclerView.canScrollVertically(1) ? (this.f4002q - R()) - O() : 0;
                if (this.f3990b.canScrollHorizontally(1)) {
                    iP = (this.p - P()) - Q();
                }
            } else if (i2 != 8192) {
                iP = 0;
                iR = 0;
            } else {
                iR = recyclerView.canScrollVertically(-1) ? -((this.f4002q - R()) - O()) : 0;
                iP = this.f3990b.canScrollHorizontally(-1) ? -((this.p - P()) - Q()) : 0;
            }
            if (iR == 0 && iP == 0) {
                return false;
            }
            this.f3990b.x0(iP, iR);
            return true;
        }

        public abstract m w();

        public final void w0(q qVar) {
            int iA = A();
            while (true) {
                iA--;
                if (iA < 0) {
                    return;
                }
                if (!RecyclerView.N(z(iA)).y()) {
                    z0(iA, qVar);
                }
            }
        }

        public m x(Context context, AttributeSet attributeSet) {
            return new m(context, attributeSet);
        }

        final void x0(q qVar) {
            int size = qVar.f4016a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = qVar.f4016a.get(i2).f4055i;
                x xVarN = RecyclerView.N(view);
                if (!xVarN.y()) {
                    xVarN.x(false);
                    if (xVarN.p()) {
                        this.f3990b.removeDetachedView(view, false);
                    }
                    i iVar = this.f3990b.f3931S;
                    if (iVar != null) {
                        iVar.e(xVarN);
                    }
                    xVarN.x(true);
                    x xVarN2 = RecyclerView.N(view);
                    xVarN2.f4066v = null;
                    xVarN2.f4067w = false;
                    xVarN2.g();
                    qVar.i(xVarN2);
                }
            }
            qVar.f4016a.clear();
            ArrayList<x> arrayList = qVar.f4017b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.f3990b.invalidate();
            }
        }

        public m y(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof m ? new m((m) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new m((ViewGroup.MarginLayoutParams) layoutParams) : new m(layoutParams);
        }

        public final void y0(View view, q qVar) {
            this.f3989a.m(view);
            qVar.h(view);
        }

        public final View z(int i2) {
            androidx.recyclerview.widget.d dVar = this.f3989a;
            if (dVar != null) {
                return dVar.d(i2);
            }
            return null;
        }

        public final void z0(int i2, q qVar) {
            View viewZ = z(i2);
            if (z(i2) != null) {
                this.f3989a.n(i2);
            }
            qVar.h(viewZ);
        }
    }

    public interface n {
        boolean a(MotionEvent motionEvent);

        void b();

        void c(MotionEvent motionEvent);
    }

    public static abstract class o {
        public void a(RecyclerView recyclerView, int i2) {
        }

        public void b(RecyclerView recyclerView) {
        }
    }

    public static class p {

        /* renamed from: a, reason: collision with root package name */
        SparseArray<a> f4011a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private int f4012b = 0;

        static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList<x> f4013a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            int f4014b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f4015c = 0;
            long d = 0;

            a() {
            }
        }

        private a c(int i2) {
            a aVar = this.f4011a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f4011a.put(i2, aVar2);
            return aVar2;
        }

        final void a(int i2, long j2) {
            a aVarC = c(i2);
            long j4 = aVarC.d;
            if (j4 != 0) {
                j2 = (j2 / 4) + ((j4 / 4) * 3);
            }
            aVarC.d = j2;
        }

        final void b(int i2, long j2) {
            a aVarC = c(i2);
            long j4 = aVarC.f4015c;
            if (j4 != 0) {
                j2 = (j2 / 4) + ((j4 / 4) * 3);
            }
            aVarC.f4015c = j2;
        }

        final void d(e eVar, e eVar2) {
            if (eVar != null) {
                this.f4012b--;
            }
            if (this.f4012b == 0) {
                for (int i2 = 0; i2 < this.f4011a.size(); i2++) {
                    this.f4011a.valueAt(i2).f4013a.clear();
                }
            }
            if (eVar2 != null) {
                this.f4012b++;
            }
        }

        public final void e(x xVar) {
            int i2 = xVar.f4060n;
            ArrayList<x> arrayList = c(i2).f4013a;
            if (this.f4011a.get(i2).f4014b <= arrayList.size()) {
                return;
            }
            xVar.v();
            arrayList.add(xVar);
        }

        final boolean f(int i2, long j2, long j4) {
            long j5 = c(i2).d;
            return j5 == 0 || j2 + j5 < j4;
        }

        final boolean g(int i2, long j2, long j4) {
            long j5 = c(i2).f4015c;
            return j5 == 0 || j2 + j5 < j4;
        }
    }

    public final class q {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<x> f4016a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<x> f4017b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<x> f4018c;
        private final List<x> d;

        /* renamed from: e, reason: collision with root package name */
        private int f4019e;

        /* renamed from: f, reason: collision with root package name */
        int f4020f;
        p g;

        public q() {
            ArrayList<x> arrayList = new ArrayList<>();
            this.f4016a = arrayList;
            this.f4017b = null;
            this.f4018c = new ArrayList<>();
            this.d = Collections.unmodifiableList(arrayList);
            this.f4019e = 2;
            this.f4020f = 2;
        }

        final void a(x xVar, boolean z4) {
            RecyclerView.m(xVar);
            if (xVar.k(16384)) {
                xVar.w(0, 16384);
                androidx.core.view.o.j(xVar.f4055i, null);
            }
            if (z4) {
                r rVar = RecyclerView.this.f3966v;
                if (rVar != null) {
                    rVar.a(xVar);
                }
                e eVar = RecyclerView.this.f3963t;
                if (eVar != null) {
                    eVar.a(xVar);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f3953m0 != null) {
                    recyclerView.f3954n.h(xVar);
                }
            }
            xVar.f4070z = null;
            d().e(xVar);
        }

        public final void b() {
            this.f4016a.clear();
            f();
        }

        public final int c(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.f3953m0.b()) {
                RecyclerView recyclerView = RecyclerView.this;
                return !recyclerView.f3953m0.g ? i2 : recyclerView.f3950l.f(i2, 0);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.f3953m0.b() + RecyclerView.this.C());
        }

        final p d() {
            if (this.g == null) {
                this.g = new p();
            }
            return this.g;
        }

        public final List<x> e() {
            return this.d;
        }

        final void f() {
            for (int size = this.f4018c.size() - 1; size >= 0; size--) {
                g(size);
            }
            this.f4018c.clear();
            Interpolator interpolator = RecyclerView.f3913F0;
            m.b bVar = RecyclerView.this.f3951l0;
            int[] iArr = bVar.f4239c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            bVar.d = 0;
        }

        final void g(int i2) {
            a(this.f4018c.get(i2), true);
            this.f4018c.remove(i2);
        }

        public final void h(View view) {
            x xVarN = RecyclerView.N(view);
            if (xVarN.p()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (xVarN.o()) {
                xVarN.z();
            } else if (xVarN.A()) {
                xVarN.g();
            }
            i(xVarN);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final void i(x xVar) {
            boolean z4;
            boolean z5;
            boolean z6;
            if (xVar.o() || xVar.f4055i.getParent() != null) {
                StringBuilder sbD = D2.e.d("Scrapped or attached views may not be recycled. isScrap:");
                sbD.append(xVar.o());
                sbD.append(" isAttached:");
                sbD.append(xVar.f4055i.getParent() != null);
                sbD.append(RecyclerView.this.C());
                throw new IllegalArgumentException(sbD.toString());
            }
            if (xVar.p()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + xVar + RecyclerView.this.C());
            }
            if (xVar.y()) {
                StringBuilder sbD2 = D2.e.d("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                sbD2.append(RecyclerView.this.C());
                throw new IllegalArgumentException(sbD2.toString());
            }
            if ((xVar.f4063r & 16) == 0) {
                View view = xVar.f4055i;
                int i2 = androidx.core.view.o.d;
                z4 = view.hasTransientState();
            }
            e eVar = RecyclerView.this.f3963t;
            if (eVar != null && z4 && eVar.A(xVar)) {
                if (this.f4020f <= 0 || xVar.k(526)) {
                    z5 = false;
                } else {
                    int size = this.f4018c.size();
                    if (size >= this.f4020f && size > 0) {
                        g(0);
                        size--;
                    }
                    Interpolator interpolator = RecyclerView.f3913F0;
                    if (size > 0 && !RecyclerView.this.f3951l0.c(xVar.f4057k)) {
                        do {
                            size--;
                            if (size < 0) {
                                break;
                            }
                        } while (RecyclerView.this.f3951l0.c(this.f4018c.get(size).f4057k));
                        size++;
                    }
                    this.f4018c.add(size, xVar);
                    z5 = true;
                }
                if (!z5) {
                    a(xVar, true);
                    z = true;
                }
                z6 = z;
                z = z5;
            } else if ((xVar.f4063r & 16) == 0) {
                View view2 = xVar.f4055i;
                int i4 = androidx.core.view.o.d;
                boolean z7 = !view2.hasTransientState();
                if (!z7) {
                    z6 = false;
                }
            }
            RecyclerView.this.f3954n.h(xVar);
            if (z || z6 || !z4) {
                return;
            }
            xVar.f4070z = null;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final void j(View view) {
            boolean z4;
            boolean z5;
            x xVarN = RecyclerView.N(view);
            if (!xVarN.k(12) && xVarN.q()) {
                i iVar = RecyclerView.this.f3931S;
                if (iVar != null) {
                    androidx.recyclerview.widget.e eVar = (androidx.recyclerview.widget.e) iVar;
                    if (xVarN.j().isEmpty()) {
                        if (!(!eVar.g || xVarN.m())) {
                            z5 = false;
                        }
                        if (!z5) {
                        }
                        if (!z4) {
                        }
                    } else {
                        z5 = true;
                        z4 = !z5;
                        if (!z4) {
                            if (this.f4017b == null) {
                                this.f4017b = new ArrayList<>();
                            }
                            xVarN.f4066v = this;
                            xVarN.f4067w = true;
                            this.f4017b.add(xVarN);
                            return;
                        }
                    }
                }
            }
            if (xVarN.m() && !xVarN.n() && !RecyclerView.this.f3963t.m()) {
                StringBuilder sbD = D2.e.d("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                sbD.append(RecyclerView.this.C());
                throw new IllegalArgumentException(sbD.toString());
            }
            xVarN.f4066v = this;
            xVarN.f4067w = false;
            this.f4016a.add(xVarN);
        }

        public final void k() {
            this.f4019e = 20;
            n();
        }

        /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
            	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
            	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
            */
        /* JADX WARN: Removed duplicated region for block: B:116:0x020e  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x02c3 A[PHI: r5
          0x02c3: PHI (r5v6 androidx.recyclerview.widget.RecyclerView$x) = (r5v3 androidx.recyclerview.widget.RecyclerView$x), (r5v21 androidx.recyclerview.widget.RecyclerView$x) binds: [B:121:0x0232, B:148:0x02bd] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:182:0x039c  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x03bb  */
        /* JADX WARN: Removed duplicated region for block: B:197:0x03e6  */
        /* JADX WARN: Removed duplicated region for block: B:199:0x03ec  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x03fc  */
        /* JADX WARN: Removed duplicated region for block: B:228:0x0482  */
        /* JADX WARN: Removed duplicated region for block: B:229:0x0490  */
        /* JADX WARN: Removed duplicated region for block: B:235:0x04ad A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
        /* JADX WARN: Type inference failed for: r11v6, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        /* JADX WARN: Type inference failed for: r6v7, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final androidx.recyclerview.widget.RecyclerView.x l(int r18, long r19) {
            /*
                Method dump skipped, instructions count: 1259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.q.l(int, long):androidx.recyclerview.widget.RecyclerView$x");
        }

        final void m(x xVar) {
            if (xVar.f4067w) {
                this.f4017b.remove(xVar);
            } else {
                this.f4016a.remove(xVar);
            }
            xVar.f4066v = null;
            xVar.f4067w = false;
            xVar.g();
        }

        final void n() {
            l lVar = RecyclerView.this.u;
            this.f4020f = this.f4019e + (lVar != null ? lVar.f3998l : 0);
            for (int size = this.f4018c.size() - 1; size >= 0 && this.f4018c.size() > this.f4020f; size--) {
                g(size);
            }
        }
    }

    public interface r {
        void a(x xVar);
    }

    private class s extends g {
        s() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void g() {
            RecyclerView.this.k(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3953m0.f4039f = true;
            recyclerView.e0(true);
            if (RecyclerView.this.f3950l.h()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void i(int i2, int i4, Object obj) {
            RecyclerView.this.k(null);
            if (RecyclerView.this.f3950l.j(i2, i4, obj)) {
                m();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void j(int i2, int i4) {
            RecyclerView.this.k(null);
            if (RecyclerView.this.f3950l.k(i2, i4)) {
                m();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void k(int i2, int i4) {
            RecyclerView.this.k(null);
            if (RecyclerView.this.f3950l.l(i2, i4)) {
                m();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void l(int i2, int i4) {
            RecyclerView.this.k(null);
            if (RecyclerView.this.f3950l.m(i2, i4)) {
                m();
            }
        }

        final void m() {
            Interpolator interpolator = RecyclerView.f3913F0;
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f3914A || !recyclerView.f3974z) {
                recyclerView.f3923H = true;
                recyclerView.requestLayout();
            } else {
                Runnable runnable = recyclerView.p;
                int i2 = androidx.core.view.o.d;
                recyclerView.postOnAnimation(runnable);
            }
        }
    }

    public static abstract class u {

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f4025b;

        /* renamed from: c, reason: collision with root package name */
        private l f4026c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f4027e;

        /* renamed from: f, reason: collision with root package name */
        private View f4028f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f4029h;

        /* renamed from: a, reason: collision with root package name */
        private int f4024a = -1;
        private final a g = new a();

        public static class a {
            private int d = -1;

            /* renamed from: f, reason: collision with root package name */
            private boolean f4034f = false;
            private int g = 0;

            /* renamed from: a, reason: collision with root package name */
            private int f4030a = 0;

            /* renamed from: b, reason: collision with root package name */
            private int f4031b = 0;

            /* renamed from: c, reason: collision with root package name */
            private int f4032c = Integer.MIN_VALUE;

            /* renamed from: e, reason: collision with root package name */
            private Interpolator f4033e = null;

            final boolean a() {
                return this.d >= 0;
            }

            public final void b(int i2) {
                this.d = i2;
            }

            final void c(RecyclerView recyclerView) {
                int i2 = this.d;
                if (i2 >= 0) {
                    this.d = -1;
                    recyclerView.W(i2);
                    this.f4034f = false;
                    return;
                }
                if (!this.f4034f) {
                    this.g = 0;
                    return;
                }
                Interpolator interpolator = this.f4033e;
                if (interpolator != null && this.f4032c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                int i4 = this.f4032c;
                if (i4 < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                if (interpolator != null) {
                    recyclerView.f3947j0.e(this.f4030a, this.f4031b, i4, interpolator);
                } else if (i4 == Integer.MIN_VALUE) {
                    recyclerView.f3947j0.d(this.f4030a, this.f4031b);
                } else {
                    w wVar = recyclerView.f3947j0;
                    int i5 = this.f4030a;
                    int i6 = this.f4031b;
                    Objects.requireNonNull(wVar);
                    wVar.e(i5, i6, i4, RecyclerView.f3913F0);
                }
                int i7 = this.g + 1;
                this.g = i7;
                if (i7 > 10) {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f4034f = false;
            }

            public final void d(int i2, int i4, int i5, Interpolator interpolator) {
                this.f4030a = i2;
                this.f4031b = i4;
                this.f4032c = i5;
                this.f4033e = interpolator;
                this.f4034f = true;
            }
        }

        public interface b {
            PointF a(int i2);
        }

        public final PointF a(int i2) {
            Object obj = this.f4026c;
            if (obj instanceof b) {
                return ((b) obj).a(i2);
            }
            StringBuilder sbD = D2.e.d("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sbD.append(b.class.getCanonicalName());
            Log.w("RecyclerView", sbD.toString());
            return null;
        }

        public final int b() {
            return this.f4025b.u.A();
        }

        public final l c() {
            return this.f4026c;
        }

        public final int d() {
            return this.f4024a;
        }

        public final boolean e() {
            return this.d;
        }

        public final boolean f() {
            return this.f4027e;
        }

        final void g(int i2, int i4) {
            PointF pointFA;
            RecyclerView recyclerView = this.f4025b;
            if (!this.f4027e || this.f4024a == -1 || recyclerView == null) {
                m();
            }
            if (this.d && this.f4028f == null && this.f4026c != null && (pointFA = a(this.f4024a)) != null) {
                float f4 = pointFA.x;
                if (f4 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.m0((int) Math.signum(f4), (int) Math.signum(pointFA.y), null);
                }
            }
            this.d = false;
            View view = this.f4028f;
            if (view != null) {
                Objects.requireNonNull(this.f4025b);
                x xVarN = RecyclerView.N(view);
                if ((xVarN != null ? xVarN.i() : -1) == this.f4024a) {
                    View view2 = this.f4028f;
                    v vVar = recyclerView.f3953m0;
                    j(view2, this.g);
                    this.g.c(recyclerView);
                    m();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f4028f = null;
                }
            }
            if (this.f4027e) {
                v vVar2 = recyclerView.f3953m0;
                i(i2, i4, this.g);
                boolean zA = this.g.a();
                this.g.c(recyclerView);
                if (zA) {
                    if (!this.f4027e) {
                        m();
                    } else {
                        this.d = true;
                        recyclerView.f3947j0.c();
                    }
                }
            }
        }

        protected final void h(View view) {
            Objects.requireNonNull(this.f4025b);
            x xVarN = RecyclerView.N(view);
            if ((xVarN != null ? xVarN.i() : -1) == this.f4024a) {
                this.f4028f = view;
            }
        }

        protected abstract void i(int i2, int i4, a aVar);

        protected abstract void j(View view, a aVar);

        public final void k(int i2) {
            this.f4024a = i2;
        }

        final void l(RecyclerView recyclerView, l lVar) {
            if (this.f4029h) {
                StringBuilder sbD = D2.e.d("An instance of ");
                sbD.append(getClass().getSimpleName());
                sbD.append(" was started ");
                sbD.append("more than once. Each instance of");
                sbD.append(getClass().getSimpleName());
                sbD.append(" ");
                sbD.append("is intended to only be used once. You should create a new instance for ");
                sbD.append("each use.");
                Log.w("RecyclerView", sbD.toString());
            }
            this.f4025b = recyclerView;
            this.f4026c = lVar;
            int i2 = this.f4024a;
            if (i2 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f3953m0.f4035a = i2;
            this.f4027e = true;
            this.d = true;
            this.f4028f = recyclerView.u.v(i2);
            this.f4025b.f3947j0.c();
            this.f4029h = true;
        }

        protected final void m() {
            if (this.f4027e) {
                this.f4027e = false;
                androidx.recyclerview.widget.o oVar = (androidx.recyclerview.widget.o) this;
                oVar.f4256n = 0;
                oVar.f4255m = 0;
                oVar.f4253k = null;
                this.f4025b.f3953m0.f4035a = -1;
                this.f4028f = null;
                this.f4024a = -1;
                this.d = false;
                l lVar = this.f4026c;
                if (lVar.g == this) {
                    lVar.g = null;
                }
                this.f4026c = null;
                this.f4025b = null;
            }
        }
    }

    public static class v {

        /* renamed from: a, reason: collision with root package name */
        int f4035a = -1;

        /* renamed from: b, reason: collision with root package name */
        int f4036b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f4037c = 0;
        int d = 1;

        /* renamed from: e, reason: collision with root package name */
        int f4038e = 0;

        /* renamed from: f, reason: collision with root package name */
        boolean f4039f = false;
        boolean g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f4040h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f4041i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f4042j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f4043k = false;

        /* renamed from: l, reason: collision with root package name */
        int f4044l;

        /* renamed from: m, reason: collision with root package name */
        long f4045m;

        /* renamed from: n, reason: collision with root package name */
        int f4046n;

        final void a(int i2) {
            if ((this.d & i2) != 0) {
                return;
            }
            StringBuilder sbD = D2.e.d("Layout state should be one of ");
            sbD.append(Integer.toBinaryString(i2));
            sbD.append(" but it is ");
            sbD.append(Integer.toBinaryString(this.d));
            throw new IllegalStateException(sbD.toString());
        }

        public final int b() {
            return this.g ? this.f4036b - this.f4037c : this.f4038e;
        }

        public final String toString() {
            StringBuilder sbD = D2.e.d("State{mTargetPosition=");
            sbD.append(this.f4035a);
            sbD.append(", mData=");
            sbD.append((Object) null);
            sbD.append(", mItemCount=");
            sbD.append(this.f4038e);
            sbD.append(", mIsMeasuring=");
            sbD.append(this.f4041i);
            sbD.append(", mPreviousLayoutItemCount=");
            sbD.append(this.f4036b);
            sbD.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sbD.append(this.f4037c);
            sbD.append(", mStructureChanged=");
            sbD.append(this.f4039f);
            sbD.append(", mInPreLayout=");
            sbD.append(this.g);
            sbD.append(", mRunSimpleAnimations=");
            sbD.append(this.f4042j);
            sbD.append(", mRunPredictiveAnimations=");
            sbD.append(this.f4043k);
            sbD.append('}');
            return sbD.toString();
        }
    }

    class w implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private int f4047i;

        /* renamed from: j, reason: collision with root package name */
        private int f4048j;

        /* renamed from: k, reason: collision with root package name */
        OverScroller f4049k;

        /* renamed from: l, reason: collision with root package name */
        Interpolator f4050l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f4051m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f4052n;

        w() {
            Interpolator interpolator = RecyclerView.f3913F0;
            this.f4050l = interpolator;
            this.f4051m = false;
            this.f4052n = false;
            this.f4049k = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i2, int i4) {
            int iRound;
            int iAbs = Math.abs(i2);
            int iAbs2 = Math.abs(i4);
            boolean z4 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt(0);
            int iSqrt2 = (int) Math.sqrt((i4 * i4) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z4 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f4 = width;
            float f5 = i5;
            float fSin = (((float) Math.sin((Math.min(1.0f, (iSqrt2 * 1.0f) / f4) - 0.5f) * 0.47123894f)) * f5) + f5;
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fSin / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z4) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f4) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final void b(int i2, int i4) {
            RecyclerView.this.w0(2);
            this.f4048j = 0;
            this.f4047i = 0;
            this.f4049k.fling(0, 0, i2, i4, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            c();
        }

        final void c() {
            if (this.f4051m) {
                this.f4052n = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            RecyclerView recyclerView = RecyclerView.this;
            int i2 = androidx.core.view.o.d;
            recyclerView.postOnAnimation(this);
        }

        public final void d(int i2, int i4) {
            e(i2, i4, a(i2, i4), RecyclerView.f3913F0);
        }

        public final void e(int i2, int i4, int i5, Interpolator interpolator) {
            if (this.f4050l != interpolator) {
                this.f4050l = interpolator;
                this.f4049k = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.w0(2);
            this.f4048j = 0;
            this.f4047i = 0;
            this.f4049k.startScroll(0, 0, i2, i4, i5);
            c();
        }

        public final void f(int i2, int i4) {
            e(i2, i4, a(i2, i4), RecyclerView.f3913F0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ef  */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            int i2;
            int i4;
            int i5;
            int i6;
            int i7;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.u == null) {
                recyclerView.removeCallbacks(this);
                this.f4049k.abortAnimation();
                return;
            }
            ?? r2 = 0;
            this.f4052n = false;
            this.f4051m = true;
            recyclerView.p();
            OverScroller overScroller = this.f4049k;
            u uVar = RecyclerView.this.u.g;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.f3969w0;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i8 = currX - this.f4047i;
                int i9 = currY - this.f4048j;
                this.f4047i = currX;
                this.f4048j = currY;
                if (RecyclerView.this.v(i8, i9, iArr, null, 1)) {
                    i8 -= iArr[0];
                    i9 -= iArr[1];
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (recyclerView2.f3963t != null) {
                    recyclerView2.m0(i8, i9, recyclerView2.f3973y0);
                    int[] iArr2 = RecyclerView.this.f3973y0;
                    i4 = iArr2[0];
                    i2 = iArr2[1];
                    i5 = i8 - i4;
                    i6 = i9 - i2;
                    if (uVar != 0 && !uVar.e() && uVar.f()) {
                        int iB = RecyclerView.this.f3953m0.b();
                        if (iB == 0) {
                            uVar.m();
                        } else if (uVar.d() >= iB) {
                            uVar.k(iB - 1);
                            uVar.g(i8 - i5, i9 - i6);
                        } else {
                            uVar.g(i8 - i5, i9 - i6);
                        }
                    }
                } else {
                    i2 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                }
                if (!RecyclerView.this.f3968w.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.o(i8, i9);
                }
                if (!RecyclerView.this.w(i4, i2, i5, i6) && (i5 != 0 || i6 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i5 == currX) {
                        i7 = 0;
                        if (i6 == currY) {
                            currVelocity = 0;
                            if (RecyclerView.this.getOverScrollMode() != 2) {
                                RecyclerView.this.a(i7, currVelocity);
                            }
                            if ((i7 == 0 || i5 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i6 == currY || overScroller.getFinalY() == 0)) {
                                overScroller.abortAnimation();
                            }
                        } else {
                            if (i6 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i6 <= 0) {
                            }
                            if (RecyclerView.this.getOverScrollMode() != 2) {
                            }
                            if (i7 == 0) {
                                overScroller.abortAnimation();
                            } else {
                                overScroller.abortAnimation();
                            }
                        }
                    } else {
                        if (i5 < 0) {
                            i7 = -currVelocity;
                        } else if (i5 > 0) {
                            i7 = currVelocity;
                        }
                        if (i6 == currY) {
                        }
                    }
                }
                if (i4 != 0 || i2 != 0) {
                    RecyclerView.this.x(i4, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z4 = (i8 == 0 && i9 == 0) || (i8 != 0 && RecyclerView.this.u.h() && i4 == i8) || (i9 != 0 && RecyclerView.this.u.i() && i2 == i9);
                if (overScroller.isFinished() || !(z4 || RecyclerView.this.R(1))) {
                    r2 = 0;
                    RecyclerView.this.w0(0);
                    Interpolator interpolator = RecyclerView.f3913F0;
                    m.b bVar = RecyclerView.this.f3951l0;
                    int[] iArr3 = bVar.f4239c;
                    if (iArr3 != null) {
                        Arrays.fill(iArr3, -1);
                    }
                    bVar.d = 0;
                    RecyclerView.this.C0(1);
                } else {
                    c();
                    RecyclerView recyclerView3 = RecyclerView.this;
                    androidx.recyclerview.widget.m mVar = recyclerView3.f3949k0;
                    if (mVar != null) {
                        mVar.a(recyclerView3, i8, i9);
                    }
                    r2 = 0;
                }
            }
            if (uVar != 0) {
                if (uVar.e()) {
                    uVar.g(r2, r2);
                }
                if (!this.f4052n) {
                    uVar.m();
                }
            }
            this.f4051m = r2;
            if (this.f4052n) {
                c();
            }
        }
    }

    public static abstract class x {

        /* renamed from: A, reason: collision with root package name */
        private static final List<Object> f4054A = Collections.emptyList();

        /* renamed from: i, reason: collision with root package name */
        public final View f4055i;

        /* renamed from: j, reason: collision with root package name */
        WeakReference<RecyclerView> f4056j;

        /* renamed from: r, reason: collision with root package name */
        int f4063r;

        /* renamed from: z, reason: collision with root package name */
        RecyclerView f4070z;

        /* renamed from: k, reason: collision with root package name */
        int f4057k = -1;

        /* renamed from: l, reason: collision with root package name */
        int f4058l = -1;

        /* renamed from: m, reason: collision with root package name */
        long f4059m = -1;

        /* renamed from: n, reason: collision with root package name */
        int f4060n = -1;

        /* renamed from: o, reason: collision with root package name */
        int f4061o = -1;
        x p = null;

        /* renamed from: q, reason: collision with root package name */
        x f4062q = null;

        /* renamed from: s, reason: collision with root package name */
        List<Object> f4064s = null;

        /* renamed from: t, reason: collision with root package name */
        List<Object> f4065t = null;
        private int u = 0;

        /* renamed from: v, reason: collision with root package name */
        q f4066v = null;

        /* renamed from: w, reason: collision with root package name */
        boolean f4067w = false;

        /* renamed from: x, reason: collision with root package name */
        private int f4068x = 0;

        /* renamed from: y, reason: collision with root package name */
        int f4069y = -1;

        public x(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f4055i = view;
        }

        final boolean A() {
            return (this.f4063r & 32) != 0;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Object>] */
        final void d(Object obj) {
            if (obj == null) {
                e(1024);
                return;
            }
            if ((1024 & this.f4063r) == 0) {
                if (this.f4064s == null) {
                    ArrayList arrayList = new ArrayList();
                    this.f4064s = arrayList;
                    this.f4065t = Collections.unmodifiableList(arrayList);
                }
                this.f4064s.add(obj);
            }
        }

        final void e(int i2) {
            this.f4063r = i2 | this.f4063r;
        }

        final void f() {
            this.f4058l = -1;
            this.f4061o = -1;
        }

        final void g() {
            this.f4063r &= -33;
        }

        public final int h() {
            RecyclerView recyclerView = this.f4070z;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.J(this);
        }

        public final int i() {
            int i2 = this.f4061o;
            return i2 == -1 ? this.f4057k : i2;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<java.lang.Object>] */
        final List<Object> j() {
            if ((this.f4063r & 1024) != 0) {
                return f4054A;
            }
            ?? r02 = this.f4064s;
            return (r02 == 0 || r02.size() == 0) ? f4054A : this.f4065t;
        }

        final boolean k(int i2) {
            return (this.f4063r & i2) != 0;
        }

        final boolean l() {
            return (this.f4063r & 1) != 0;
        }

        final boolean m() {
            return (this.f4063r & 4) != 0;
        }

        final boolean n() {
            return (this.f4063r & 8) != 0;
        }

        final boolean o() {
            return this.f4066v != null;
        }

        final boolean p() {
            return (this.f4063r & 256) != 0;
        }

        final boolean q() {
            return (this.f4063r & 2) != 0;
        }

        final void r(int i2, boolean z4) {
            if (this.f4058l == -1) {
                this.f4058l = this.f4057k;
            }
            if (this.f4061o == -1) {
                this.f4061o = this.f4057k;
            }
            if (z4) {
                this.f4061o += i2;
            }
            this.f4057k += i2;
            if (this.f4055i.getLayoutParams() != null) {
                ((m) this.f4055i.getLayoutParams()).f4010c = true;
            }
        }

        final void s(RecyclerView recyclerView) {
            int i2 = this.f4069y;
            if (i2 != -1) {
                this.f4068x = i2;
            } else {
                View view = this.f4055i;
                int i4 = androidx.core.view.o.d;
                this.f4068x = view.getImportantForAccessibility();
            }
            recyclerView.q0(this, 4);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String toString() {
            boolean z4;
            StringBuilder sbD = D2.e.d("ViewHolder{");
            sbD.append(Integer.toHexString(hashCode()));
            sbD.append(" position=");
            sbD.append(this.f4057k);
            sbD.append(" id=");
            sbD.append(this.f4059m);
            sbD.append(", oldPos=");
            sbD.append(this.f4058l);
            sbD.append(", pLpos:");
            sbD.append(this.f4061o);
            StringBuilder sb = new StringBuilder(sbD.toString());
            if (o()) {
                sb.append(" scrap ");
                sb.append(this.f4067w ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m()) {
                sb.append(" invalid");
            }
            if (!l()) {
                sb.append(" unbound");
            }
            boolean z5 = true;
            if ((this.f4063r & 2) != 0) {
                sb.append(" update");
            }
            if (n()) {
                sb.append(" removed");
            }
            if (y()) {
                sb.append(" ignored");
            }
            if (p()) {
                sb.append(" tmpDetached");
            }
            if ((this.f4063r & 16) == 0) {
                View view = this.f4055i;
                int i2 = androidx.core.view.o.d;
                z4 = !view.hasTransientState();
            }
            if (!z4) {
                StringBuilder sbD2 = D2.e.d(" not recyclable(");
                sbD2.append(this.u);
                sbD2.append(")");
                sb.append(sbD2.toString());
            }
            if ((this.f4063r & 512) == 0 && !m()) {
                z5 = false;
            }
            if (z5) {
                sb.append(" undefined adapter position");
            }
            if (this.f4055i.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        final void u(RecyclerView recyclerView) {
            recyclerView.q0(this, this.f4068x);
            this.f4068x = 0;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<java.lang.Object>] */
        final void v() {
            this.f4063r = 0;
            this.f4057k = -1;
            this.f4058l = -1;
            this.f4059m = -1L;
            this.f4061o = -1;
            this.u = 0;
            this.p = null;
            this.f4062q = null;
            ?? r2 = this.f4064s;
            if (r2 != 0) {
                r2.clear();
            }
            this.f4063r &= -1025;
            this.f4068x = 0;
            this.f4069y = -1;
            RecyclerView.m(this);
        }

        final void w(int i2, int i4) {
            this.f4063r = (i2 & i4) | (this.f4063r & (~i4));
        }

        public final void x(boolean z4) {
            int i2 = this.u;
            int i4 = z4 ? i2 - 1 : i2 + 1;
            this.u = i4;
            if (i4 < 0) {
                this.u = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z4 && i4 == 1) {
                this.f4063r |= 16;
            } else if (z4 && i4 == 0) {
                this.f4063r &= -17;
            }
        }

        final boolean y() {
            return (this.f4063r & 128) != 0;
        }

        final void z() {
            this.f4066v.m(this);
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        f3912E0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f3913F0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) throws NoSuchMethodException, SecurityException {
        Constructor constructor;
        super(context, attributeSet, 0);
        this.f3944i = new s();
        this.f3946j = new q();
        this.f3954n = new z();
        this.p = new a();
        this.f3958q = new Rect();
        this.f3959r = new Rect();
        this.f3961s = new RectF();
        this.f3968w = new ArrayList<>();
        this.f3970x = new ArrayList<>();
        this.f3918C = 0;
        this.f3925J = false;
        this.f3926K = false;
        this.L = 0;
        this.M = 0;
        this.f3927N = new h();
        this.f3931S = new androidx.recyclerview.widget.e();
        this.f3932T = 0;
        this.f3933U = -1;
        this.f3942g0 = Float.MIN_VALUE;
        this.f3943h0 = Float.MIN_VALUE;
        boolean z4 = true;
        this.f3945i0 = true;
        this.f3947j0 = new w();
        this.f3951l0 = new m.b();
        this.f3953m0 = new v();
        this.f3957o0 = false;
        this.p0 = false;
        this.q0 = new j();
        this.f3960r0 = false;
        this.f3964t0 = new int[2];
        this.f3967v0 = new int[2];
        this.f3969w0 = new int[2];
        this.f3971x0 = new int[2];
        this.f3973y0 = new int[2];
        this.f3975z0 = new ArrayList();
        this.f3915A0 = new b();
        this.f3917B0 = new d();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3911D0, 0, 0);
            this.f3956o = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f3956o = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3939d0 = viewConfiguration.getScaledTouchSlop();
        this.f3942g0 = viewConfiguration.getScaledHorizontalScrollFactor();
        this.f3943h0 = viewConfiguration.getScaledVerticalScrollFactor();
        this.f3940e0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3941f0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f3931S.m(this.q0);
        this.f3950l = new androidx.recyclerview.widget.a(new androidx.recyclerview.widget.u(this));
        this.f3952m = new androidx.recyclerview.widget.d(new androidx.recyclerview.widget.t(this));
        int i2 = androidx.core.view.o.d;
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f3924I = (AccessibilityManager) getContext().getSystemService("accessibility");
        androidx.recyclerview.widget.v vVar = new androidx.recyclerview.widget.v(this);
        this.f3962s0 = vVar;
        androidx.core.view.o.j(this, vVar);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, Y1.a.f2113e, 0, 0);
            String string = typedArrayObtainStyledAttributes2.getString(7);
            if (typedArrayObtainStyledAttributes2.getInt(1, -1) == -1) {
                setDescendantFocusability(262144);
            }
            char c2 = 3;
            int i4 = 4;
            if (typedArrayObtainStyledAttributes2.getBoolean(2, false)) {
                StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(5);
                Drawable drawable = typedArrayObtainStyledAttributes2.getDrawable(6);
                StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(3);
                Drawable drawable2 = typedArrayObtainStyledAttributes2.getDrawable(4);
                if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                    StringBuilder sbD = D2.e.d("Trying to set fast scroller without both required drawables.");
                    sbD.append(C());
                    throw new IllegalArgumentException(sbD.toString());
                }
                Resources resources = getContext().getResources();
                new androidx.recyclerview.widget.l(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.android.mmt.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.android.mmt.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.android.mmt.R.dimen.fastscroll_margin));
                i4 = 4;
                c2 = 3;
            }
            typedArrayObtainStyledAttributes2.recycle();
            if (string != null) {
                String strTrim = string.trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.charAt(0) == '.') {
                        strTrim = context.getPackageName() + strTrim;
                    } else if (!strTrim.contains(".")) {
                        strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                    }
                    try {
                        Class<? extends U> clsAsSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(strTrim).asSubclass(l.class);
                        Object[] objArr = null;
                        try {
                            constructor = clsAsSubclass.getConstructor(f3912E0);
                            Object[] objArr2 = new Object[i4];
                            objArr2[0] = context;
                            objArr2[1] = attributeSet;
                            objArr2[2] = 0;
                            objArr2[c2] = 0;
                            objArr = objArr2;
                        } catch (NoSuchMethodException e2) {
                            try {
                                constructor = clsAsSubclass.getConstructor(new Class[0]);
                            } catch (NoSuchMethodException e4) {
                                e4.initCause(e2);
                                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strTrim, e4);
                            }
                        }
                        constructor.setAccessible(true);
                        u0((l) constructor.newInstance(objArr));
                    } catch (ClassCastException e5) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strTrim, e5);
                    } catch (ClassNotFoundException e6) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strTrim, e6);
                    } catch (IllegalAccessException e7) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strTrim, e7);
                    } catch (InstantiationException e8) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strTrim, e8);
                    } catch (InvocationTargetException e9) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strTrim, e9);
                    }
                }
            }
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f3910C0, 0, 0);
            z4 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
            typedArrayObtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z4);
    }

    private void E0() {
        u uVar;
        w wVar = this.f3947j0;
        RecyclerView.this.removeCallbacks(wVar);
        wVar.f4049k.abortAnimation();
        l lVar = this.u;
        if (lVar == null || (uVar = lVar.g) == null) {
            return;
        }
        uVar.m();
    }

    private void F(int[] iArr) {
        int iE = this.f3952m.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < iE; i5++) {
            x xVarN = N(this.f3952m.d(i5));
            if (!xVarN.y()) {
                int i6 = xVarN.i();
                if (i6 < i2) {
                    i2 = i6;
                }
                if (i6 > i4) {
                    i4 = i6;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i4;
    }

    static RecyclerView G(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewG = G(viewGroup.getChildAt(i2));
            if (recyclerViewG != null) {
                return recyclerViewG;
            }
        }
        return null;
    }

    static x N(View view) {
        if (view == null) {
            return null;
        }
        return ((m) view.getLayoutParams()).f4008a;
    }

    private androidx.core.view.g Q() {
        if (this.f3965u0 == null) {
            this.f3965u0 = new androidx.core.view.g(this);
        }
        return this.f3965u0;
    }

    private void b0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3933U) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3933U = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.f3937b0 = x2;
            this.f3935W = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.f3938c0 = y2;
            this.f3936a0 = y2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d0() {
        boolean z4;
        if (this.f3925J) {
            this.f3950l.r();
            if (this.f3926K) {
                this.u.l0();
            }
        }
        boolean z5 = true;
        if (this.f3931S != null && this.u.Q0()) {
            this.f3950l.o();
        } else {
            this.f3950l.c();
        }
        boolean z6 = this.f3957o0 || this.p0;
        this.f3953m0.f4042j = this.f3916B && this.f3931S != null && ((z4 = this.f3925J) || z6 || this.u.f3994h) && (!z4 || this.f3963t.m());
        v vVar = this.f3953m0;
        if (vVar.f4042j && z6 && !this.f3925J) {
            if (!(this.f3931S != null && this.u.Q0())) {
            }
        } else {
            z5 = false;
        }
        vVar.f4043k = z5;
    }

    private void f(x xVar) {
        View view = xVar.f4055i;
        boolean z4 = view.getParent() == this;
        this.f3946j.m(M(view));
        if (xVar.p()) {
            this.f3952m.b(view, -1, view.getLayoutParams(), true);
        } else if (z4) {
            this.f3952m.i(view);
        } else {
            this.f3952m.a(view, -1, true);
        }
    }

    private void j0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3958q.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof m) {
            m mVar = (m) layoutParams;
            if (!mVar.f4010c) {
                Rect rect = mVar.f4009b;
                Rect rect2 = this.f3958q;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3958q);
            offsetRectIntoDescendantCoords(view, this.f3958q);
        }
        this.u.A0(this, view, this.f3958q, !this.f3916B, view2 == null);
    }

    private void k0() {
        VelocityTracker velocityTracker = this.f3934V;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        C0(0);
        EdgeEffect edgeEffect = this.f3928O;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f3928O.isFinished();
        }
        EdgeEffect edgeEffect2 = this.P;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.P.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3929Q;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f3929Q.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3930R;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f3930R.isFinished();
        }
        if (zIsFinished) {
            int i2 = androidx.core.view.o.d;
            postInvalidateOnAnimation();
        }
    }

    private void l() {
        k0();
        w0(0);
    }

    static void m(x xVar) {
        WeakReference<RecyclerView> weakReference = xVar.f4056j;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == xVar.f4055i) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            xVar.f4056j = null;
        }
    }

    private void t() {
        View viewE;
        this.f3953m0.a(1);
        D(this.f3953m0);
        this.f3953m0.f4041i = false;
        z0();
        z zVar = this.f3954n;
        zVar.f4272a.clear();
        zVar.f4273b.a();
        Z();
        d0();
        View focusedChild = (this.f3945i0 && hasFocus() && this.f3963t != null) ? getFocusedChild() : null;
        x xVarM = (focusedChild == null || (viewE = E(focusedChild)) == null) ? null : M(viewE);
        if (xVarM == null) {
            v vVar = this.f3953m0;
            vVar.f4045m = -1L;
            vVar.f4044l = -1;
            vVar.f4046n = -1;
        } else {
            this.f3953m0.f4045m = this.f3963t.m() ? xVarM.f4059m : -1L;
            this.f3953m0.f4044l = this.f3925J ? -1 : xVarM.n() ? xVarM.f4058l : xVarM.h();
            v vVar2 = this.f3953m0;
            View focusedChild2 = xVarM.f4055i;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            vVar2.f4046n = id;
        }
        v vVar3 = this.f3953m0;
        vVar3.f4040h = vVar3.f4042j && this.p0;
        this.p0 = false;
        this.f3957o0 = false;
        vVar3.g = vVar3.f4043k;
        vVar3.f4038e = this.f3963t.j();
        F(this.f3964t0);
        if (this.f3953m0.f4042j) {
            int iE = this.f3952m.e();
            for (int i2 = 0; i2 < iE; i2++) {
                x xVarN = N(this.f3952m.d(i2));
                if (!xVarN.y() && (!xVarN.m() || this.f3963t.m())) {
                    i iVar = this.f3931S;
                    i.b(xVarN);
                    xVarN.j();
                    Objects.requireNonNull(iVar);
                    i.c cVar = new i.c();
                    cVar.a(xVarN);
                    this.f3954n.c(xVarN, cVar);
                    if (this.f3953m0.f4040h && xVarN.q() && !xVarN.n() && !xVarN.y() && !xVarN.m()) {
                        this.f3954n.f4273b.e(K(xVarN), xVarN);
                    }
                }
            }
        }
        if (this.f3953m0.f4043k) {
            int iH = this.f3952m.h();
            for (int i4 = 0; i4 < iH; i4++) {
                x xVarN2 = N(this.f3952m.g(i4));
                if (!xVarN2.y() && xVarN2.f4058l == -1) {
                    xVarN2.f4058l = xVarN2.f4057k;
                }
            }
            v vVar4 = this.f3953m0;
            boolean z4 = vVar4.f4039f;
            vVar4.f4039f = false;
            this.u.p0(this.f3946j, vVar4);
            this.f3953m0.f4039f = z4;
            for (int i5 = 0; i5 < this.f3952m.e(); i5++) {
                x xVarN3 = N(this.f3952m.d(i5));
                if (!xVarN3.y()) {
                    z.a orDefault = this.f3954n.f4272a.getOrDefault(xVarN3, null);
                    if (!((orDefault == null || (orDefault.f4274a & 4) == 0) ? false : true)) {
                        i.b(xVarN3);
                        boolean zK = xVarN3.k(8192);
                        i iVar2 = this.f3931S;
                        xVarN3.j();
                        Objects.requireNonNull(iVar2);
                        i.c cVar2 = new i.c();
                        cVar2.a(xVarN3);
                        if (zK) {
                            f0(xVarN3, cVar2);
                        } else {
                            z zVar2 = this.f3954n;
                            z.a orDefault2 = zVar2.f4272a.getOrDefault(xVarN3, null);
                            if (orDefault2 == null) {
                                orDefault2 = z.a.a();
                                zVar2.f4272a.put(xVarN3, orDefault2);
                            }
                            orDefault2.f4274a |= 2;
                            orDefault2.f4275b = cVar2;
                        }
                    }
                }
            }
            n();
        } else {
            n();
        }
        a0(true);
        B0(false);
        this.f3953m0.d = 2;
    }

    private void u() {
        z0();
        Z();
        this.f3953m0.a(6);
        this.f3950l.c();
        this.f3953m0.f4038e = this.f3963t.j();
        v vVar = this.f3953m0;
        vVar.f4037c = 0;
        vVar.g = false;
        this.u.p0(this.f3946j, vVar);
        v vVar2 = this.f3953m0;
        vVar2.f4039f = false;
        this.f3948k = null;
        vVar2.f4042j = vVar2.f4042j && this.f3931S != null;
        vVar2.d = 4;
        a0(true);
        B0(false);
    }

    final void A() {
        if (this.f3929Q != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3927N.a(this);
        this.f3929Q = edgeEffectA;
        if (this.f3956o) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final boolean A0(int i2, int i4) {
        return Q().l(i2, i4);
    }

    final void B() {
        if (this.P != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3927N.a(this);
        this.P = edgeEffectA;
        if (this.f3956o) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    final void B0(boolean z4) {
        if (this.f3918C < 1) {
            this.f3918C = 1;
        }
        if (!z4 && !this.f3920E) {
            this.f3919D = false;
        }
        if (this.f3918C == 1) {
            if (z4 && this.f3919D && !this.f3920E && this.u != null && this.f3963t != null) {
                s();
            }
            if (!this.f3920E) {
                this.f3919D = false;
            }
        }
        this.f3918C--;
    }

    final String C() {
        StringBuilder sbD = D2.e.d(" ");
        sbD.append(super.toString());
        sbD.append(", adapter:");
        sbD.append(this.f3963t);
        sbD.append(", layout:");
        sbD.append(this.u);
        sbD.append(", context:");
        sbD.append(getContext());
        return sbD.toString();
    }

    public final void C0(int i2) {
        Q().m(i2);
    }

    final void D(v vVar) {
        if (this.f3932T != 2) {
            Objects.requireNonNull(vVar);
            return;
        }
        OverScroller overScroller = this.f3947j0.f4049k;
        overScroller.getFinalX();
        overScroller.getCurrX();
        Objects.requireNonNull(vVar);
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final void D0() {
        w0(0);
        E0();
    }

    public final View E(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final x H(int i2) {
        x xVar = null;
        if (this.f3925J) {
            return null;
        }
        int iH = this.f3952m.h();
        for (int i4 = 0; i4 < iH; i4++) {
            x xVarN = N(this.f3952m.g(i4));
            if (xVarN != null && !xVarN.n() && J(xVarN) == i2) {
                if (!this.f3952m.l(xVarN.f4055i)) {
                    return xVarN;
                }
                xVar = xVarN;
            }
        }
        return xVar;
    }

    public final e I() {
        return this.f3963t;
    }

    final int J(x xVar) {
        if (xVar.k(524) || !xVar.l()) {
            return -1;
        }
        androidx.recyclerview.widget.a aVar = this.f3950l;
        int i2 = xVar.f4057k;
        int size = aVar.f4118b.size();
        for (int i4 = 0; i4 < size; i4++) {
            a.b bVar = aVar.f4118b.get(i4);
            int i5 = bVar.f4122a;
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = bVar.f4123b;
                    if (i6 <= i2) {
                        int i7 = bVar.d;
                        if (i6 + i7 > i2) {
                            return -1;
                        }
                        i2 -= i7;
                    } else {
                        continue;
                    }
                } else if (i5 == 8) {
                    int i8 = bVar.f4123b;
                    if (i8 == i2) {
                        i2 = bVar.d;
                    } else {
                        if (i8 < i2) {
                            i2--;
                        }
                        if (bVar.d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f4123b <= i2) {
                i2 += bVar.d;
            }
        }
        return i2;
    }

    final long K(x xVar) {
        return this.f3963t.m() ? xVar.f4059m : xVar.f4057k;
    }

    public final int L(View view) {
        x xVarN = N(view);
        if (xVarN != null) {
            return xVarN.h();
        }
        return -1;
    }

    public final x M(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return N(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    final Rect O(View view) {
        m mVar = (m) view.getLayoutParams();
        if (!mVar.f4010c) {
            return mVar.f4009b;
        }
        if (this.f3953m0.g && (mVar.b() || mVar.f4008a.m())) {
            return mVar.f4009b;
        }
        Rect rect = mVar.f4009b;
        rect.set(0, 0, 0, 0);
        int size = this.f3968w.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3958q.set(0, 0, 0, 0);
            this.f3968w.get(i2).d(this.f3958q, view, this);
            int i4 = rect.left;
            Rect rect2 = this.f3958q;
            rect.left = i4 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        mVar.f4010c = false;
        return rect;
    }

    public final l P() {
        return this.u;
    }

    public final boolean R(int i2) {
        return Q().i(1);
    }

    public final boolean S() {
        return !this.f3916B || this.f3925J || this.f3950l.h();
    }

    public final void T() {
        if (this.f3968w.size() == 0) {
            return;
        }
        l lVar = this.u;
        if (lVar != null) {
            lVar.g("Cannot invalidate item decorations during a scroll or layout");
        }
        X();
        requestLayout();
    }

    final boolean U() {
        AccessibilityManager accessibilityManager = this.f3924I;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public final boolean V() {
        return this.L > 0;
    }

    final void W(int i2) {
        l lVar = this.u;
        if (lVar == null) {
            return;
        }
        lVar.D0(i2);
        awakenScrollBars();
    }

    final void X() {
        int iH = this.f3952m.h();
        for (int i2 = 0; i2 < iH; i2++) {
            ((m) this.f3952m.g(i2).getLayoutParams()).f4010c = true;
        }
        q qVar = this.f3946j;
        int size = qVar.f4018c.size();
        for (int i4 = 0; i4 < size; i4++) {
            m mVar = (m) qVar.f4018c.get(i4).f4055i.getLayoutParams();
            if (mVar != null) {
                mVar.f4010c = true;
            }
        }
    }

    final void Y(int i2, int i4, boolean z4) {
        int i5 = i2 + i4;
        int iH = this.f3952m.h();
        for (int i6 = 0; i6 < iH; i6++) {
            x xVarN = N(this.f3952m.g(i6));
            if (xVarN != null && !xVarN.y()) {
                int i7 = xVarN.f4057k;
                if (i7 >= i5) {
                    xVarN.r(-i4, z4);
                    this.f3953m0.f4039f = true;
                } else if (i7 >= i2) {
                    xVarN.e(8);
                    xVarN.r(-i4, z4);
                    xVarN.f4057k = i2 - 1;
                    this.f3953m0.f4039f = true;
                }
            }
        }
        q qVar = this.f3946j;
        int size = qVar.f4018c.size();
        while (true) {
            size--;
            if (size < 0) {
                requestLayout();
                return;
            }
            x xVar = qVar.f4018c.get(size);
            if (xVar != null) {
                int i8 = xVar.f4057k;
                if (i8 >= i5) {
                    xVar.r(-i4, z4);
                } else if (i8 >= i2) {
                    xVar.e(8);
                    qVar.g(size);
                }
            }
        }
    }

    final void Z() {
        this.L++;
    }

    final void a(int i2, int i4) {
        if (i2 < 0) {
            z();
            this.f3928O.onAbsorb(-i2);
        } else if (i2 > 0) {
            A();
            this.f3929Q.onAbsorb(i2);
        }
        if (i4 < 0) {
            B();
            this.P.onAbsorb(-i4);
        } else if (i4 > 0) {
            y();
            this.f3930R.onAbsorb(i4);
        }
        if (i2 == 0 && i4 == 0) {
            return;
        }
        int i5 = androidx.core.view.o.d;
        postInvalidateOnAnimation();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$x>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$x>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$x>] */
    final void a0(boolean z4) {
        int i2;
        int i4 = this.L - 1;
        this.L = i4;
        if (i4 < 1) {
            this.L = 0;
            if (z4) {
                int i5 = this.f3922G;
                this.f3922G = 0;
                if (i5 != 0) {
                    AccessibilityManager accessibilityManager = this.f3924I;
                    if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                        accessibilityEventObtain.setEventType(2048);
                        accessibilityEventObtain.setContentChangeTypes(i5);
                        sendAccessibilityEventUnchecked(accessibilityEventObtain);
                    }
                }
                for (int size = this.f3975z0.size() - 1; size >= 0; size--) {
                    x xVar = (x) this.f3975z0.get(size);
                    if (xVar.f4055i.getParent() == this && !xVar.y() && (i2 = xVar.f4069y) != -1) {
                        View view = xVar.f4055i;
                        int i6 = androidx.core.view.o.d;
                        view.setImportantForAccessibility(i2);
                        xVar.f4069y = -1;
                    }
                }
                this.f3975z0.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i2, int i4) {
        l lVar = this.u;
        if (lVar != null) {
            Objects.requireNonNull(lVar);
        }
        super.addFocusables(arrayList, i2, i4);
    }

    final void c0() {
        if (this.f3960r0 || !this.f3974z) {
            return;
        }
        Runnable runnable = this.f3915A0;
        int i2 = androidx.core.view.o.d;
        postOnAnimation(runnable);
        this.f3960r0 = true;
    }

    @Override // android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof m) && this.u.j((m) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        l lVar = this.u;
        if (lVar != null && lVar.h()) {
            return this.u.n(this.f3953m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        l lVar = this.u;
        if (lVar != null && lVar.h()) {
            return this.u.o(this.f3953m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        l lVar = this.u;
        if (lVar != null && lVar.h()) {
            return this.u.p(this.f3953m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        l lVar = this.u;
        if (lVar != null && lVar.i()) {
            return this.u.q(this.f3953m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        l lVar = this.u;
        if (lVar != null && lVar.i()) {
            return this.u.r(this.f3953m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        l lVar = this.u;
        if (lVar != null && lVar.i()) {
            return this.u.s(this.f3953m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return Q().a(f4, f5, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return Q().b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i4, int[] iArr, int[] iArr2) {
        return Q().c(i2, i4, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i4, int i5, int i6, int[] iArr) {
        return Q().e(i2, i4, i5, i6, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z4;
        super.draw(canvas);
        int size = this.f3968w.size();
        boolean z5 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.f3968w.get(i2).e(canvas, this);
        }
        EdgeEffect edgeEffect = this.f3928O;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z4 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f3956o ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f3928O;
            z4 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f3956o) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.P;
            z4 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f3929Q;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3956o ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f3929Q;
            z4 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f3930R;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3956o) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f3930R;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z4 |= z5;
            canvas.restoreToCount(iSave4);
        }
        if ((z4 || this.f3931S == null || this.f3968w.size() <= 0 || !this.f3931S.k()) ? z4 : true) {
            int i4 = androidx.core.view.o.d;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    final void e0(boolean z4) {
        this.f3926K = z4 | this.f3926K;
        this.f3925J = true;
        int iH = this.f3952m.h();
        for (int i2 = 0; i2 < iH; i2++) {
            x xVarN = N(this.f3952m.g(i2));
            if (xVarN != null && !xVarN.y()) {
                xVarN.e(6);
            }
        }
        X();
        q qVar = this.f3946j;
        int size = qVar.f4018c.size();
        for (int i4 = 0; i4 < size; i4++) {
            x xVar = qVar.f4018c.get(i4);
            if (xVar != null) {
                xVar.e(6);
                xVar.d(null);
            }
        }
        e eVar = RecyclerView.this.f3963t;
        if (eVar == null || !eVar.m()) {
            qVar.f();
        }
    }

    final void f0(x xVar, i.c cVar) {
        xVar.w(0, 8192);
        if (this.f3953m0.f4040h && xVar.q() && !xVar.n() && !xVar.y()) {
            this.f3954n.f4273b.e(K(xVar), xVar);
        }
        this.f3954n.c(xVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View focusSearch(View view, int i2) {
        View viewG0;
        int i4;
        char c2;
        boolean z4;
        Objects.requireNonNull(this.u);
        boolean z5 = true;
        boolean z6 = (this.f3963t == null || this.u == null || V() || this.f3920E) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (!z6 || (i2 != 2 && i2 != 1)) {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z6) {
                p();
                if (E(view) == null) {
                    return null;
                }
                z0();
                viewG0 = this.u.g0(view, i2, this.f3946j, this.f3953m0);
                B0(false);
            } else {
                viewG0 = viewFindNextFocus;
            }
        } else if (this.u.i()) {
            if (focusFinder.findNextFocus(this, view, i2 == 2 ? 130 : 33) == null) {
                z4 = true;
            }
            if (!z4) {
                if (focusFinder.findNextFocus(this, view, !((this.u.L() != 1) ^ (i2 != 2)) ? 66 : 17) != null) {
                }
            }
            if (z4) {
            }
            viewG0 = focusFinder.findNextFocus(this, view, i2);
        } else {
            z4 = false;
            if (!z4 && this.u.h()) {
                z4 = focusFinder.findNextFocus(this, view, !((this.u.L() != 1) ^ (i2 != 2)) ? 66 : 17) != null;
            }
            if (z4) {
                p();
                if (E(view) == null) {
                    return null;
                }
                z0();
                this.u.g0(view, i2, this.f3946j, this.f3953m0);
                B0(false);
            }
            viewG0 = focusFinder.findNextFocus(this, view, i2);
        }
        if (viewG0 != null && !viewG0.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i2);
            }
            j0(viewG0, null);
            return view;
        }
        if (viewG0 == null || viewG0 == this) {
            z5 = false;
        } else if (E(viewG0) == null) {
            z5 = false;
        } else if (view != null && E(view) != null) {
            this.f3958q.set(0, 0, view.getWidth(), view.getHeight());
            this.f3959r.set(0, 0, viewG0.getWidth(), viewG0.getHeight());
            offsetDescendantRectToMyCoords(view, this.f3958q);
            offsetDescendantRectToMyCoords(viewG0, this.f3959r);
            int i5 = this.u.L() == 1 ? -1 : 1;
            Rect rect = this.f3958q;
            int i6 = rect.left;
            Rect rect2 = this.f3959r;
            int i7 = rect2.left;
            if ((i6 < i7 || rect.right <= i7) && rect.right < rect2.right) {
                i4 = 1;
            } else {
                int i8 = rect.right;
                int i9 = rect2.right;
                i4 = ((i8 > i9 || i6 >= i9) && i6 > i7) ? -1 : 0;
            }
            int i10 = rect.top;
            int i11 = rect2.top;
            if ((i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom) {
                c2 = 1;
            } else {
                int i12 = rect.bottom;
                int i13 = rect2.bottom;
                c2 = ((i12 > i13 || i10 >= i13) && i10 > i11) ? (char) 65535 : (char) 0;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 17) {
                        if (i2 != 33) {
                            if (i2 != 66) {
                                if (i2 != 130) {
                                    throw new IllegalArgumentException("Invalid direction: " + i2 + C());
                                }
                                if (c2 <= 0) {
                                }
                            } else if (i4 <= 0) {
                            }
                        } else if (c2 >= 0) {
                        }
                    } else if (i4 >= 0) {
                    }
                } else if (c2 <= 0 && (c2 != 0 || i4 * i5 < 0)) {
                }
            } else if (c2 >= 0 && (c2 != 0 || i4 * i5 > 0)) {
            }
        }
        return z5 ? viewG0 : super.focusSearch(view, i2);
    }

    public final void g(k kVar) {
        l lVar = this.u;
        if (lVar != null) {
            lVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3968w.isEmpty()) {
            setWillNotDraw(false);
        }
        this.f3968w.add(kVar);
        X();
        requestLayout();
    }

    final void g0() {
        i iVar = this.f3931S;
        if (iVar != null) {
            iVar.f();
        }
        l lVar = this.u;
        if (lVar != null) {
            lVar.w0(this.f3946j);
            this.u.x0(this.f3946j);
        }
        this.f3946j.b();
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        l lVar = this.u;
        if (lVar != null) {
            return lVar.w();
        }
        StringBuilder sbD = D2.e.d("RecyclerView has no LayoutManager");
        sbD.append(C());
        throw new IllegalStateException(sbD.toString());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        l lVar = this.u;
        if (lVar != null) {
            return lVar.x(getContext(), attributeSet);
        }
        StringBuilder sbD = D2.e.d("RecyclerView has no LayoutManager");
        sbD.append(C());
        throw new IllegalStateException(sbD.toString());
    }

    @Override // android.view.View
    public final int getBaseline() {
        l lVar = this.u;
        if (lVar == null) {
            return super.getBaseline();
        }
        Objects.requireNonNull(lVar);
        return -1;
    }

    @Override // android.view.ViewGroup
    protected final int getChildDrawingOrder(int i2, int i4) {
        return super.getChildDrawingOrder(i2, i4);
    }

    @Override // android.view.ViewGroup
    public final boolean getClipToPadding() {
        return this.f3956o;
    }

    public final void h(n nVar) {
        this.f3970x.add(nVar);
    }

    public final void h0(n nVar) {
        this.f3970x.remove(nVar);
        if (this.f3972y == nVar) {
            this.f3972y = null;
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return Q().i(0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$o>] */
    public final void i(o oVar) {
        if (this.f3955n0 == null) {
            this.f3955n0 = new ArrayList();
        }
        this.f3955n0.add(oVar);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$o>] */
    public final void i0(o oVar) {
        ?? r02 = this.f3955n0;
        if (r02 != 0) {
            r02.remove(oVar);
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f3974z;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return Q().j();
    }

    final void j(x xVar, i.c cVar, i.c cVar2) {
        boolean zP;
        f(xVar);
        xVar.x(false);
        androidx.recyclerview.widget.x xVar2 = (androidx.recyclerview.widget.x) this.f3931S;
        Objects.requireNonNull(xVar2);
        int i2 = cVar.f3986a;
        int i4 = cVar.f3987b;
        View view = xVar.f4055i;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3986a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3987b;
        if (xVar.n() || (i2 == left && i4 == top)) {
            xVar2.q(xVar);
            zP = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zP = xVar2.p(xVar, i2, i4, left, top);
        }
        if (zP) {
            c0();
        }
    }

    final void k(String str) {
        if (V()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            StringBuilder sbD = D2.e.d("Cannot call this method while RecyclerView is computing a layout or scrolling");
            sbD.append(C());
            throw new IllegalStateException(sbD.toString());
        }
        if (this.M > 0) {
            StringBuilder sbD2 = D2.e.d("");
            sbD2.append(C());
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(sbD2.toString()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final boolean l0(int i2, int i4, MotionEvent motionEvent) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z4;
        p();
        if (this.f3963t != null) {
            m0(i2, i4, this.f3973y0);
            int[] iArr = this.f3973y0;
            i6 = iArr[0];
            i5 = iArr[1];
            i7 = i2 - i6;
            i8 = i4 - i5;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.f3968w.isEmpty()) {
            invalidate();
        }
        if (Q().f(i6, i5, i7, i8, this.f3967v0, 0)) {
            int i9 = this.f3937b0;
            int[] iArr2 = this.f3967v0;
            this.f3937b0 = i9 - iArr2[0];
            this.f3938c0 -= iArr2[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr2[0], iArr2[1]);
            }
            int[] iArr3 = this.f3971x0;
            int i10 = iArr3[0];
            int[] iArr4 = this.f3967v0;
            iArr3[0] = i10 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    float x2 = motionEvent.getX();
                    float f4 = i7;
                    float y2 = motionEvent.getY();
                    float f5 = i8;
                    if (f4 < 0.0f) {
                        z();
                        this.f3928O.onPull((-f4) / getWidth(), 1.0f - (y2 / getHeight()));
                    } else if (f4 > 0.0f) {
                        A();
                        this.f3929Q.onPull(f4 / getWidth(), y2 / getHeight());
                    } else {
                        z4 = false;
                        if (f5 >= 0.0f) {
                            B();
                            this.P.onPull((-f5) / getHeight(), x2 / getWidth());
                        } else {
                            if (f5 > 0.0f) {
                                y();
                                this.f3930R.onPull(f5 / getHeight(), 1.0f - (x2 / getWidth()));
                            }
                            if (z4 || f4 != 0.0f || f5 != 0.0f) {
                                int i11 = androidx.core.view.o.d;
                                postInvalidateOnAnimation();
                            }
                        }
                        z4 = true;
                        if (z4) {
                            int i112 = androidx.core.view.o.d;
                            postInvalidateOnAnimation();
                        }
                    }
                    z4 = true;
                    if (f5 >= 0.0f) {
                    }
                    z4 = true;
                    if (z4) {
                    }
                }
            }
            o(i2, i4);
        }
        if (i6 != 0 || i5 != 0) {
            x(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i6 == 0 && i5 == 0) ? false : true;
    }

    final void m0(int i2, int i4, int[] iArr) {
        x xVar;
        z0();
        Z();
        Trace.beginSection("RV Scroll");
        D(this.f3953m0);
        int iC0 = i2 != 0 ? this.u.C0(i2, this.f3946j, this.f3953m0) : 0;
        int iE0 = i4 != 0 ? this.u.E0(i4, this.f3946j, this.f3953m0) : 0;
        Trace.endSection();
        int iE = this.f3952m.e();
        for (int i5 = 0; i5 < iE; i5++) {
            View viewD = this.f3952m.d(i5);
            x xVarM = M(viewD);
            if (xVarM != null && (xVar = xVarM.f4062q) != null) {
                View view = xVar.f4055i;
                int left = viewD.getLeft();
                int top = viewD.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        a0(true);
        B0(false);
        if (iArr != null) {
            iArr[0] = iC0;
            iArr[1] = iE0;
        }
    }

    final void n() {
        int iH = this.f3952m.h();
        for (int i2 = 0; i2 < iH; i2++) {
            x xVarN = N(this.f3952m.g(i2));
            if (!xVarN.y()) {
                xVarN.f();
            }
        }
        q qVar = this.f3946j;
        int size = qVar.f4018c.size();
        for (int i4 = 0; i4 < size; i4++) {
            qVar.f4018c.get(i4).f();
        }
        int size2 = qVar.f4016a.size();
        for (int i5 = 0; i5 < size2; i5++) {
            qVar.f4016a.get(i5).f();
        }
        ArrayList<x> arrayList = qVar.f4017b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i6 = 0; i6 < size3; i6++) {
                qVar.f4017b.get(i6).f();
            }
        }
    }

    public final void n0(int i2) {
        if (this.f3920E) {
            return;
        }
        D0();
        l lVar = this.u;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            lVar.D0(i2);
            awakenScrollBars();
        }
    }

    final void o(int i2, int i4) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f3928O;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.f3928O.onRelease();
            zIsFinished = this.f3928O.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3929Q;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.f3929Q.onRelease();
            zIsFinished |= this.f3929Q.isFinished();
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i4 > 0) {
            this.P.onRelease();
            zIsFinished |= this.P.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3930R;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i4 < 0) {
            this.f3930R.onRelease();
            zIsFinished |= this.f3930R.isFinished();
        }
        if (zIsFinished) {
            int i5 = androidx.core.view.o.d;
            postInvalidateOnAnimation();
        }
    }

    public final void o0(androidx.recyclerview.widget.v vVar) {
        this.f3962s0 = vVar;
        androidx.core.view.o.j(this, vVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = 0;
        this.f3974z = true;
        this.f3916B = this.f3916B && !isLayoutRequested();
        l lVar = this.u;
        if (lVar != null) {
            lVar.f3995i = true;
        }
        this.f3960r0 = false;
        ThreadLocal<androidx.recyclerview.widget.m> threadLocal = androidx.recyclerview.widget.m.f4231m;
        androidx.recyclerview.widget.m mVar = threadLocal.get();
        this.f3949k0 = mVar;
        if (mVar == null) {
            this.f3949k0 = new androidx.recyclerview.widget.m();
            int i2 = androidx.core.view.o.d;
            Display display = getDisplay();
            float f4 = 60.0f;
            if (!isInEditMode() && display != null) {
                float refreshRate = display.getRefreshRate();
                if (refreshRate >= 30.0f) {
                    f4 = refreshRate;
                }
            }
            androidx.recyclerview.widget.m mVar2 = this.f3949k0;
            mVar2.f4235k = (long) (1.0E9f / f4);
            threadLocal.set(mVar2);
        }
        this.f3949k0.f4233i.add(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$x>] */
    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f3931S;
        if (iVar != null) {
            iVar.f();
        }
        D0();
        this.f3974z = false;
        l lVar = this.u;
        if (lVar != null) {
            lVar.f3995i = false;
            lVar.f0(this);
        }
        this.f3975z0.clear();
        removeCallbacks(this.f3915A0);
        Objects.requireNonNull(this.f3954n);
        while (z.a.d.b() != null) {
        }
        androidx.recyclerview.widget.m mVar = this.f3949k0;
        if (mVar != null) {
            mVar.f4233i.remove(this);
            this.f3949k0 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f3968w.size();
        for (int i2 = 0; i2 < size; i2++) {
            Objects.requireNonNull(this.f3968w.get(i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f4;
        float axisValue;
        if (this.u != null && !this.f3920E && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f4 = this.u.i() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.u.h() ? motionEvent.getAxisValue(10) : 0.0f;
                if (f4 != 0.0f || axisValue != 0.0f) {
                    l0((int) (axisValue * this.f3942g0), (int) (f4 * this.f3943h0), motionEvent);
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.u.i()) {
                    f4 = -axisValue2;
                    if (f4 != 0.0f) {
                        l0((int) (axisValue * this.f3942g0), (int) (f4 * this.f3943h0), motionEvent);
                    }
                } else {
                    if (this.u.h()) {
                        axisValue = axisValue2;
                        f4 = 0.0f;
                    } else {
                        f4 = 0.0f;
                        axisValue = 0.0f;
                    }
                    if (f4 != 0.0f) {
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        if (this.f3920E) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f3972y = null;
        }
        int size = this.f3970x.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z4 = false;
                break;
            }
            n nVar = this.f3970x.get(i2);
            if (nVar.a(motionEvent) && action != 3) {
                this.f3972y = nVar;
                z4 = true;
                break;
            }
            i2++;
        }
        if (z4) {
            l();
            return true;
        }
        l lVar = this.u;
        if (lVar == null) {
            return false;
        }
        boolean zH = lVar.h();
        boolean zI = this.u.i();
        if (this.f3934V == null) {
            this.f3934V = VelocityTracker.obtain();
        }
        this.f3934V.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f3921F) {
                this.f3921F = false;
            }
            this.f3933U = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.f3937b0 = x2;
            this.f3935W = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.f3938c0 = y2;
            this.f3936a0 = y2;
            if (this.f3932T == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                w0(1);
            }
            int[] iArr = this.f3971x0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i4 = zH;
            if (zI) {
                i4 = (zH ? 1 : 0) | 2;
            }
            A0(i4, 0);
        } else if (actionMasked == 1) {
            this.f3934V.clear();
            C0(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f3933U);
            if (iFindPointerIndex < 0) {
                StringBuilder sbD = D2.e.d("Error processing scroll; pointer index for id ");
                sbD.append(this.f3933U);
                sbD.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", sbD.toString());
                return false;
            }
            int x4 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f3932T != 1) {
                int i5 = x4 - this.f3935W;
                int i6 = y4 - this.f3936a0;
                if (zH == 0 || Math.abs(i5) <= this.f3939d0) {
                    z5 = false;
                } else {
                    this.f3937b0 = x4;
                    z5 = true;
                }
                if (zI && Math.abs(i6) > this.f3939d0) {
                    this.f3938c0 = y4;
                    z5 = true;
                }
                if (z5) {
                    w0(1);
                }
            }
        } else if (actionMasked == 3) {
            l();
        } else if (actionMasked == 5) {
            this.f3933U = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3937b0 = x5;
            this.f3935W = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3938c0 = y5;
            this.f3936a0 = y5;
        } else if (actionMasked == 6) {
            b0(motionEvent);
        }
        return this.f3932T == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        Trace.beginSection("RV OnLayout");
        s();
        Trace.endSection();
        this.f3916B = true;
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        l lVar = this.u;
        if (lVar == null) {
            q(i2, i4);
            return;
        }
        boolean z4 = false;
        if (lVar.Y()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.u.r0(i2, i4);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z4 = true;
            }
            if (z4 || this.f3963t == null) {
                return;
            }
            if (this.f3953m0.d == 1) {
                t();
            }
            this.u.G0(i2, i4);
            this.f3953m0.f4041i = true;
            u();
            this.u.J0(i2, i4);
            if (this.u.M0()) {
                this.u.G0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f3953m0.f4041i = true;
                u();
                this.u.J0(i2, i4);
                return;
            }
            return;
        }
        if (this.f3914A) {
            this.u.r0(i2, i4);
            return;
        }
        if (this.f3923H) {
            z0();
            Z();
            d0();
            a0(true);
            v vVar = this.f3953m0;
            if (vVar.f4043k) {
                vVar.g = true;
            } else {
                this.f3950l.c();
                this.f3953m0.g = false;
            }
            this.f3923H = false;
            B0(false);
        } else if (this.f3953m0.f4043k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        e eVar = this.f3963t;
        if (eVar != null) {
            this.f3953m0.f4038e = eVar.j();
        } else {
            this.f3953m0.f4038e = 0;
        }
        z0();
        this.u.r0(i2, i4);
        B0(false);
        this.f3953m0.g = false;
    }

    @Override // android.view.ViewGroup
    protected final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (V()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof t)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        t tVar = (t) parcelable;
        this.f3948k = tVar;
        super.onRestoreInstanceState(tVar.a());
        l lVar = this.u;
        if (lVar == null || (parcelable2 = this.f3948k.f4023k) == null) {
            return;
        }
        lVar.s0(parcelable2);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        t tVar = new t(super.onSaveInstanceState());
        t tVar2 = this.f3948k;
        if (tVar2 != null) {
            tVar.f4023k = tVar2.f4023k;
        } else {
            l lVar = this.u;
            if (lVar != null) {
                tVar.f4023k = lVar.t0();
            } else {
                tVar.f4023k = null;
            }
        }
        return tVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        if (i2 == i5 && i4 == i6) {
            return;
        }
        this.f3930R = null;
        this.P = null;
        this.f3929Q = null;
        this.f3928O = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        if (this.f3920E || this.f3921F) {
            return false;
        }
        int action = motionEvent.getAction();
        n nVar = this.f3972y;
        if (nVar != null) {
            if (action != 0) {
                nVar.c(motionEvent);
                if (action == 3 || action == 1) {
                    this.f3972y = null;
                }
                z4 = true;
                break;
            }
            this.f3972y = null;
            if (action != 0) {
            }
            z4 = false;
        } else {
            if (action != 0) {
                int size = this.f3970x.size();
                for (int i2 = 0; i2 < size; i2++) {
                    n nVar2 = this.f3970x.get(i2);
                    if (nVar2.a(motionEvent)) {
                        this.f3972y = nVar2;
                        z4 = true;
                        break;
                    }
                }
            }
            z4 = false;
        }
        if (z4) {
            l();
            return true;
        }
        l lVar = this.u;
        if (lVar == null) {
            return false;
        }
        boolean zH = lVar.h();
        boolean zI = this.u.i();
        if (this.f3934V == null) {
            this.f3934V = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.f3971x0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.f3971x0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.f3933U = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.f3937b0 = x2;
            this.f3935W = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.f3938c0 = y2;
            this.f3936a0 = y2;
            int i4 = zH;
            if (zI) {
                i4 = (zH ? 1 : 0) | 2;
            }
            A0(i4, 0);
        } else if (actionMasked == 1) {
            this.f3934V.addMovement(motionEventObtain);
            this.f3934V.computeCurrentVelocity(1000, this.f3941f0);
            float f4 = zH != 0 ? -this.f3934V.getXVelocity(this.f3933U) : 0.0f;
            float f5 = zI ? -this.f3934V.getYVelocity(this.f3933U) : 0.0f;
            if (f4 != 0.0f || f5 != 0.0f) {
                int i5 = (int) f4;
                int i6 = (int) f5;
                l lVar2 = this.u;
                if (lVar2 == null) {
                    Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.f3920E) {
                    boolean zH2 = lVar2.h();
                    boolean zI2 = this.u.i();
                    if (zH2 == 0 || Math.abs(i5) < this.f3940e0) {
                        i5 = 0;
                    }
                    if (!zI2 || Math.abs(i6) < this.f3940e0) {
                        i6 = 0;
                    }
                    if (i5 != 0 || i6 != 0) {
                        float f6 = i5;
                        float f7 = i6;
                        if (!dispatchNestedPreFling(f6, f7)) {
                            boolean z8 = zH2 != 0 || zI2;
                            dispatchNestedFling(f6, f7, z8);
                            int i7 = zH2;
                            if (z8) {
                                if (zI2) {
                                    i7 = (zH2 ? 1 : 0) | 2;
                                }
                                A0(i7, 1);
                                int i8 = this.f3941f0;
                                int iMax = Math.max(-i8, Math.min(i5, i8));
                                int i9 = this.f3941f0;
                                this.f3947j0.b(iMax, Math.max(-i9, Math.min(i6, i9)));
                                z5 = true;
                            }
                            if (!z5) {
                                w0(0);
                            }
                            k0();
                            z7 = true;
                        }
                    }
                }
                z5 = false;
                if (!z5) {
                }
                k0();
                z7 = true;
            }
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f3933U);
            if (iFindPointerIndex < 0) {
                StringBuilder sbD = D2.e.d("Error processing scroll; pointer index for id ");
                sbD.append(this.f3933U);
                sbD.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", sbD.toString());
                return false;
            }
            int x4 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int i10 = this.f3937b0 - x4;
            int i11 = this.f3938c0 - y4;
            if (Q().c(i10, i11, this.f3969w0, this.f3967v0, 0)) {
                int[] iArr3 = this.f3969w0;
                i10 -= iArr3[0];
                i11 -= iArr3[1];
                int[] iArr4 = this.f3967v0;
                motionEventObtain.offsetLocation(iArr4[0], iArr4[1]);
                int[] iArr5 = this.f3971x0;
                int i12 = iArr5[0];
                int[] iArr6 = this.f3967v0;
                iArr5[0] = i12 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.f3932T != 1) {
                if (zH != 0) {
                    int iAbs = Math.abs(i10);
                    int i13 = this.f3939d0;
                    if (iAbs > i13) {
                        i10 = i10 > 0 ? i10 - i13 : i10 + i13;
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (zI) {
                        int iAbs2 = Math.abs(i11);
                        int i14 = this.f3939d0;
                        if (iAbs2 > i14) {
                            i11 = i11 > 0 ? i11 - i14 : i11 + i14;
                            z6 = true;
                        }
                    }
                    if (z6) {
                        w0(1);
                    }
                }
            }
            if (this.f3932T == 1) {
                int[] iArr7 = this.f3967v0;
                this.f3937b0 = x4 - iArr7[0];
                this.f3938c0 = y4 - iArr7[1];
                if (l0(zH != 0 ? i10 : 0, zI ? i11 : 0, motionEventObtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                androidx.recyclerview.widget.m mVar = this.f3949k0;
                if (mVar != null && (i10 != 0 || i11 != 0)) {
                    mVar.a(this, i10, i11);
                }
            }
        } else if (actionMasked == 3) {
            l();
        } else if (actionMasked == 5) {
            this.f3933U = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3937b0 = x5;
            this.f3935W = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3938c0 = y5;
            this.f3936a0 = y5;
        } else if (actionMasked == 6) {
            b0(motionEvent);
        }
        if (!z7) {
            this.f3934V.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    final void p() {
        if (!this.f3916B || this.f3925J) {
            Trace.beginSection("RV FullInvalidate");
            s();
            Trace.endSection();
            return;
        }
        if (this.f3950l.h()) {
            if (!this.f3950l.g(4) || this.f3950l.g(11)) {
                if (this.f3950l.h()) {
                    Trace.beginSection("RV FullInvalidate");
                    s();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection("RV PartialInvalidate");
            z0();
            Z();
            this.f3950l.o();
            if (!this.f3919D) {
                int iE = this.f3952m.e();
                boolean z4 = false;
                int i2 = 0;
                while (true) {
                    if (i2 < iE) {
                        x xVarN = N(this.f3952m.d(i2));
                        if (xVarN != null && !xVarN.y() && xVarN.q()) {
                            z4 = true;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (z4) {
                    s();
                } else {
                    this.f3950l.b();
                }
            }
            B0(true);
            a0(true);
            Trace.endSection();
        }
    }

    public void p0(e eVar) {
        if (this.f3920E) {
            k("Do not setLayoutFrozen in layout or scroll");
            this.f3920E = false;
            if (this.f3919D && this.u != null && this.f3963t != null) {
                requestLayout();
            }
            this.f3919D = false;
        }
        e eVar2 = this.f3963t;
        if (eVar2 != null) {
            eVar2.F(this.f3944i);
            this.f3963t.z(this);
        }
        g0();
        this.f3950l.r();
        e eVar3 = this.f3963t;
        this.f3963t = eVar;
        if (eVar != null) {
            eVar.D(this.f3944i);
            eVar.w(this);
        }
        q qVar = this.f3946j;
        e eVar4 = this.f3963t;
        qVar.b();
        qVar.d().d(eVar3, eVar4);
        this.f3953m0.f4039f = true;
        e0(false);
        requestLayout();
    }

    final void q(int i2, int i4) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int i5 = androidx.core.view.o.d;
        setMeasuredDimension(l.k(i2, paddingRight, getMinimumWidth()), l.k(i4, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$x>] */
    final boolean q0(x xVar, int i2) {
        if (V()) {
            xVar.f4069y = i2;
            this.f3975z0.add(xVar);
            return false;
        }
        View view = xVar.f4055i;
        int i4 = androidx.core.view.o.d;
        view.setImportantForAccessibility(i2);
        return true;
    }

    final void r(View view) {
        x xVarN = N(view);
        e eVar = this.f3963t;
        if (eVar == null || xVarN == null) {
            return;
        }
        eVar.C(xVarN);
    }

    public final void r0() {
        this.f3914A = true;
    }

    @Override // android.view.ViewGroup
    protected final void removeDetachedView(View view, boolean z4) {
        x xVarN = N(view);
        if (xVarN != null) {
            if (xVarN.p()) {
                xVarN.f4063r &= -257;
            } else if (!xVarN.y()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + xVarN + C());
            }
        }
        view.clearAnimation();
        r(view);
        super.removeDetachedView(view, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        u uVar = this.u.g;
        boolean z4 = true;
        if (!(uVar != null && uVar.f()) && !V()) {
            z4 = false;
        }
        if (!z4 && view2 != null) {
            j0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        return this.u.A0(this, view, rect, z4, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        int size = this.f3970x.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3970x.get(i2).b();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f3918C != 0 || this.f3920E) {
            this.f3919D = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x034e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void s() {
        x xVarN;
        View view;
        View viewFindViewById;
        x xVar;
        boolean zP;
        if (this.f3963t == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.u == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        v vVar = this.f3953m0;
        vVar.f4041i = false;
        boolean z4 = true;
        if (vVar.d == 1) {
            t();
            this.u.F0(this);
            u();
        } else {
            androidx.recyclerview.widget.a aVar = this.f3950l;
            if (!((aVar.f4119c.isEmpty() || aVar.f4118b.isEmpty()) ? false : true) && this.u.W() == getWidth() && this.u.J() == getHeight()) {
                this.u.F0(this);
            } else {
                this.u.F0(this);
                u();
            }
        }
        this.f3953m0.a(4);
        z0();
        Z();
        v vVar2 = this.f3953m0;
        vVar2.d = 1;
        View view2 = null;
        if (vVar2.f4042j) {
            for (int iE = this.f3952m.e() - 1; iE >= 0; iE--) {
                x xVarN2 = N(this.f3952m.d(iE));
                if (!xVarN2.y()) {
                    long jK = K(xVarN2);
                    Objects.requireNonNull(this.f3931S);
                    i.c cVar = new i.c();
                    cVar.a(xVarN2);
                    x xVarD = this.f3954n.f4273b.d(jK, null);
                    if (xVarD == null || xVarD.y()) {
                        this.f3954n.b(xVarN2, cVar);
                    } else {
                        z.a orDefault = this.f3954n.f4272a.getOrDefault(xVarD, null);
                        boolean z5 = (orDefault == null || (orDefault.f4274a & 1) == 0) ? false : true;
                        z.a orDefault2 = this.f3954n.f4272a.getOrDefault(xVarN2, null);
                        boolean z6 = (orDefault2 == null || (orDefault2.f4274a & 1) == 0) ? false : true;
                        if (z5 && xVarD == xVarN2) {
                            this.f3954n.b(xVarN2, cVar);
                        } else {
                            i.c cVarF = this.f3954n.f(xVarD);
                            this.f3954n.b(xVarN2, cVar);
                            i.c cVarE = this.f3954n.e(xVarN2);
                            if (cVarF == null) {
                                int iE2 = this.f3952m.e();
                                for (int i2 = 0; i2 < iE2; i2++) {
                                    x xVarN3 = N(this.f3952m.d(i2));
                                    if (xVarN3 != xVarN2 && K(xVarN3) == jK) {
                                        e eVar = this.f3963t;
                                        if (eVar == null || !eVar.m()) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + xVarN3 + " \n View Holder 2:" + xVarN2 + C());
                                        }
                                        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + xVarN3 + " \n View Holder 2:" + xVarN2 + C());
                                    }
                                }
                                Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + xVarD + " cannot be found but it is necessary for " + xVarN2 + C());
                            } else {
                                xVarD.x(false);
                                if (z5) {
                                    f(xVarD);
                                }
                                if (xVarD != xVarN2) {
                                    if (z6) {
                                        f(xVarN2);
                                    }
                                    xVarD.p = xVarN2;
                                    f(xVarD);
                                    this.f3946j.m(xVarD);
                                    xVarN2.x(false);
                                    xVarN2.f4062q = xVarD;
                                }
                                if (this.f3931S.a(xVarD, xVarN2, cVarF, cVarE)) {
                                    c0();
                                }
                            }
                        }
                    }
                }
            }
            z zVar = this.f3954n;
            d dVar = this.f3917B0;
            for (int size = zVar.f4272a.size() - 1; size >= 0; size--) {
                x xVarH = zVar.f4272a.h(size);
                z.a aVarJ = zVar.f4272a.j(size);
                int i4 = aVarJ.f4274a;
                if ((i4 & 3) == 3) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.u.y0(xVarH.f4055i, recyclerView.f3946j);
                } else if ((i4 & 1) != 0) {
                    i.c cVar2 = aVarJ.f4275b;
                    if (cVar2 == null) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.u.y0(xVarH.f4055i, recyclerView2.f3946j);
                    } else {
                        i.c cVar3 = aVarJ.f4276c;
                        RecyclerView.this.f3946j.m(xVarH);
                        RecyclerView.this.j(xVarH, cVar2, cVar3);
                    }
                } else if ((i4 & 14) == 14) {
                    dVar.a(xVarH, aVarJ.f4275b, aVarJ.f4276c);
                } else if ((i4 & 12) == 12) {
                    i.c cVar4 = aVarJ.f4275b;
                    i.c cVar5 = aVarJ.f4276c;
                    Objects.requireNonNull(dVar);
                    xVarH.x(false);
                    RecyclerView recyclerView3 = RecyclerView.this;
                    if (!recyclerView3.f3925J) {
                        androidx.recyclerview.widget.x xVar2 = (androidx.recyclerview.widget.x) recyclerView3.f3931S;
                        Objects.requireNonNull(xVar2);
                        int i5 = cVar4.f3986a;
                        int i6 = cVar5.f3986a;
                        if (i5 == i6 && cVar4.f3987b == cVar5.f3987b) {
                            xVar2.c(xVarH);
                            zP = false;
                        } else {
                            zP = xVar2.p(xVarH, i5, cVar4.f3987b, i6, cVar5.f3987b);
                        }
                        if (zP) {
                            RecyclerView.this.c0();
                        }
                    } else if (recyclerView3.f3931S.a(xVarH, xVarH, cVar4, cVar5)) {
                        RecyclerView.this.c0();
                    }
                } else if ((i4 & 4) != 0) {
                    i.c cVar6 = aVarJ.f4275b;
                    RecyclerView.this.f3946j.m(xVarH);
                    RecyclerView.this.j(xVarH, cVar6, null);
                } else if ((i4 & 8) != 0) {
                    dVar.a(xVarH, aVarJ.f4275b, aVarJ.f4276c);
                }
                z.a.b(aVarJ);
            }
        }
        this.u.x0(this.f3946j);
        v vVar3 = this.f3953m0;
        vVar3.f4036b = vVar3.f4038e;
        this.f3925J = false;
        this.f3926K = false;
        vVar3.f4042j = false;
        vVar3.f4043k = false;
        this.u.f3994h = false;
        ArrayList<x> arrayList = this.f3946j.f4017b;
        if (arrayList != null) {
            arrayList.clear();
        }
        l lVar = this.u;
        if (lVar.f3999m) {
            lVar.f3998l = 0;
            lVar.f3999m = false;
            this.f3946j.n();
        }
        this.u.q0();
        a0(true);
        B0(false);
        z zVar2 = this.f3954n;
        zVar2.f4272a.clear();
        zVar2.f4273b.a();
        int[] iArr = this.f3964t0;
        int i7 = iArr[0];
        int i8 = iArr[1];
        F(iArr);
        int[] iArr2 = this.f3964t0;
        if (iArr2[0] == i7 && iArr2[1] == i8) {
            z4 = false;
        }
        if (z4) {
            x(0, 0);
        }
        if (this.f3945i0 && this.f3963t != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (!isFocused()) {
                if (this.f3952m.l(getFocusedChild())) {
                    if (this.f3953m0.f4045m == -1 || !this.f3963t.m()) {
                        xVarN = null;
                    } else {
                        long j2 = this.f3953m0.f4045m;
                        e eVar2 = this.f3963t;
                        if (eVar2 == null || !eVar2.m()) {
                            xVar = null;
                        } else {
                            int iH = this.f3952m.h();
                            xVar = null;
                            for (int i9 = 0; i9 < iH; i9++) {
                                xVarN = N(this.f3952m.g(i9));
                                if (xVarN != null && !xVarN.n() && xVarN.f4059m == j2) {
                                    if (!this.f3952m.l(xVarN.f4055i)) {
                                        break;
                                    } else {
                                        xVar = xVarN;
                                    }
                                }
                            }
                        }
                        xVarN = xVar;
                    }
                    if (xVarN != null && !this.f3952m.l(xVarN.f4055i) && xVarN.f4055i.hasFocusable()) {
                        view2 = xVarN.f4055i;
                    } else if (this.f3952m.e() > 0) {
                        v vVar4 = this.f3953m0;
                        int i10 = vVar4.f4044l;
                        int i11 = i10 != -1 ? i10 : 0;
                        int iB = vVar4.b();
                        for (int i12 = i11; i12 < iB; i12++) {
                            x xVarH2 = H(i12);
                            if (xVarH2 == null) {
                                break;
                            }
                            if (xVarH2.f4055i.hasFocusable()) {
                                view = xVarH2.f4055i;
                                break;
                            }
                        }
                        for (int iMin = Math.min(iB, i11) - 1; iMin >= 0; iMin--) {
                            x xVarH3 = H(iMin);
                            if (xVarH3 == null) {
                                break;
                            }
                            if (xVarH3.f4055i.hasFocusable()) {
                                view = xVarH3.f4055i;
                                view2 = view;
                            }
                        }
                    }
                    if (view2 != null) {
                        int i13 = this.f3953m0.f4046n;
                        if (i13 != -1 && (viewFindViewById = view2.findViewById(i13)) != null && viewFindViewById.isFocusable()) {
                            view2 = viewFindViewById;
                        }
                        view2.requestFocus();
                    }
                }
            }
        }
        v vVar5 = this.f3953m0;
        vVar5.f4045m = -1L;
        vVar5.f4044l = -1;
        vVar5.f4046n = -1;
    }

    public final void s0(i iVar) {
        i iVar2 = this.f3931S;
        if (iVar2 != null) {
            iVar2.f();
            this.f3931S.m(null);
        }
        this.f3931S = iVar;
        if (iVar != null) {
            iVar.m(this.q0);
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i4) {
        l lVar = this.u;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3920E) {
            return;
        }
        boolean zH = lVar.h();
        boolean zI = this.u.i();
        if (zH || zI) {
            if (!zH) {
                i2 = 0;
            }
            if (!zI) {
                i4 = 0;
            }
            l0(i2, i4, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i4) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (V()) {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.f3922G |= contentChangeTypes != 0 ? contentChangeTypes : 0;
            i = 1;
        }
        if (i != 0) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    @Override // android.view.ViewGroup
    public final void setClipToPadding(boolean z4) {
        if (z4 != this.f3956o) {
            this.f3930R = null;
            this.P = null;
            this.f3929Q = null;
            this.f3928O = null;
        }
        this.f3956o = z4;
        super.setClipToPadding(z4);
        if (this.f3916B) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public final void setNestedScrollingEnabled(boolean z4) {
        Q().k(z4);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return Q().l(i2, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        Q().m(0);
    }

    public final void t0() {
        this.f3946j.k();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
    public final void u0(l lVar) {
        if (lVar == this.u) {
            return;
        }
        D0();
        if (this.u != null) {
            i iVar = this.f3931S;
            if (iVar != null) {
                iVar.f();
            }
            this.u.w0(this.f3946j);
            this.u.x0(this.f3946j);
            this.f3946j.b();
            if (this.f3974z) {
                l lVar2 = this.u;
                lVar2.f3995i = false;
                lVar2.f0(this);
            }
            this.u.K0(null);
            this.u = null;
        } else {
            this.f3946j.b();
        }
        androidx.recyclerview.widget.d dVar = this.f3952m;
        d.a aVar = dVar.f4132b;
        aVar.f4134a = 0L;
        d.a aVar2 = aVar.f4135b;
        if (aVar2 != null) {
            aVar2.g();
        }
        int size = dVar.f4133c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            d.b bVar = dVar.f4131a;
            View view = (View) dVar.f4133c.get(size);
            androidx.recyclerview.widget.t tVar = (androidx.recyclerview.widget.t) bVar;
            Objects.requireNonNull(tVar);
            x xVarN = N(view);
            if (xVarN != null) {
                xVarN.u(tVar.f4261a);
            }
            dVar.f4133c.remove(size);
        }
        androidx.recyclerview.widget.t tVar2 = (androidx.recyclerview.widget.t) dVar.f4131a;
        int iB = tVar2.b();
        for (int i2 = 0; i2 < iB; i2++) {
            View viewA = tVar2.a(i2);
            tVar2.f4261a.r(viewA);
            viewA.clearAnimation();
        }
        tVar2.f4261a.removeAllViews();
        this.u = lVar;
        if (lVar != null) {
            if (lVar.f3990b != null) {
                throw new IllegalArgumentException("LayoutManager " + lVar + " is already attached to a RecyclerView:" + lVar.f3990b.C());
            }
            lVar.K0(this);
            if (this.f3974z) {
                this.u.f3995i = true;
            }
        }
        this.f3946j.n();
        requestLayout();
    }

    public final boolean v(int i2, int i4, int[] iArr, int[] iArr2, int i5) {
        return Q().c(i2, i4, iArr, null, 1);
    }

    public final void v0(r rVar) {
        this.f3966v = rVar;
    }

    public final boolean w(int i2, int i4, int i5, int i6) {
        return Q().f(i2, i4, i5, i6, null, 1);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$o>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$o>] */
    final void w0(int i2) {
        if (i2 == this.f3932T) {
            return;
        }
        this.f3932T = i2;
        if (i2 != 2) {
            E0();
        }
        l lVar = this.u;
        if (lVar != null) {
            lVar.u0(i2);
        }
        ?? r02 = this.f3955n0;
        if (r02 == 0) {
            return;
        }
        int size = r02.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((o) this.f3955n0.get(size)).a(this, i2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$o>] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<androidx.recyclerview.widget.RecyclerView$o>] */
    final void x(int i2, int i4) {
        this.M++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        ?? r12 = this.f3955n0;
        if (r12 != 0) {
            int size = r12.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    ((o) this.f3955n0.get(size)).b(this);
                }
            }
        }
        this.M--;
    }

    public final void x0(int i2, int i4) {
        l lVar = this.u;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3920E) {
            return;
        }
        if (!lVar.h()) {
            i2 = 0;
        }
        if (!this.u.i()) {
            i4 = 0;
        }
        if (i2 == 0 && i4 == 0) {
            return;
        }
        this.f3947j0.f(i2, i4);
    }

    final void y() {
        if (this.f3930R != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3927N.a(this);
        this.f3930R = edgeEffectA;
        if (this.f3956o) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void y0(int i2) {
        if (this.f3920E) {
            return;
        }
        l lVar = this.u;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            lVar.O0(this, i2);
        }
    }

    final void z() {
        if (this.f3928O != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3927N.a(this);
        this.f3928O = edgeEffectA;
        if (this.f3956o) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    final void z0() {
        int i2 = this.f3918C + 1;
        this.f3918C = i2;
        if (i2 != 1 || this.f3920E) {
            return;
        }
        this.f3919D = false;
    }

    public static class m extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        x f4008a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f4009b;

        /* renamed from: c, reason: collision with root package name */
        boolean f4010c;
        boolean d;

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4009b = new Rect();
            this.f4010c = true;
            this.d = false;
        }

        public final int a() {
            return this.f4008a.i();
        }

        public final boolean b() {
            return this.f4008a.q();
        }

        public final boolean c() {
            return this.f4008a.n();
        }

        public m(int i2, int i4) {
            super(i2, i4);
            this.f4009b = new Rect();
            this.f4010c = true;
            this.d = false;
        }

        public m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4009b = new Rect();
            this.f4010c = true;
            this.d = false;
        }

        public m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4009b = new Rect();
            this.f4010c = true;
            this.d = false;
        }

        public m(m mVar) {
            super((ViewGroup.LayoutParams) mVar);
            this.f4009b = new Rect();
            this.f4010c = true;
            this.d = false;
        }
    }

    public static class t extends I.a {
        public static final Parcelable.Creator<t> CREATOR = new a();

        /* renamed from: k, reason: collision with root package name */
        Parcelable f4023k;

        static class a implements Parcelable.ClassLoaderCreator<t> {
            a() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final t createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new t(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new t[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new t(parcel, null);
            }
        }

        t(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4023k = parcel.readParcelable(classLoader == null ? l.class.getClassLoader() : classLoader);
        }

        @Override // I.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f4023k, 0);
        }

        t(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        l lVar = this.u;
        if (lVar != null) {
            return lVar.y(layoutParams);
        }
        StringBuilder sbD = D2.e.d("RecyclerView has no LayoutManager");
        sbD.append(C());
        throw new IllegalStateException(sbD.toString());
    }
}
