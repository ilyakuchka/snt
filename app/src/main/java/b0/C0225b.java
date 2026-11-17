package b0;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.o;
import androidx.fragment.app.Fragment;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* renamed from: b0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0225b extends ViewGroup {

    /* renamed from: a0, reason: collision with root package name */
    static final int[] f4312a0 = {R.attr.layout_gravity};

    /* renamed from: b0, reason: collision with root package name */
    private static final Comparator<e> f4313b0 = new a();

    /* renamed from: c0, reason: collision with root package name */
    private static final Interpolator f4314c0 = new InterpolatorC0077b();

    /* renamed from: A, reason: collision with root package name */
    private boolean f4315A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f4316B;

    /* renamed from: C, reason: collision with root package name */
    private int f4317C;

    /* renamed from: D, reason: collision with root package name */
    private int f4318D;

    /* renamed from: E, reason: collision with root package name */
    private int f4319E;

    /* renamed from: F, reason: collision with root package name */
    private float f4320F;

    /* renamed from: G, reason: collision with root package name */
    private float f4321G;

    /* renamed from: H, reason: collision with root package name */
    private float f4322H;

    /* renamed from: I, reason: collision with root package name */
    private float f4323I;

    /* renamed from: J, reason: collision with root package name */
    private int f4324J;

    /* renamed from: K, reason: collision with root package name */
    private VelocityTracker f4325K;
    private int L;
    private int M;

    /* renamed from: N, reason: collision with root package name */
    private int f4326N;

    /* renamed from: O, reason: collision with root package name */
    private int f4327O;
    private EdgeEffect P;

    /* renamed from: Q, reason: collision with root package name */
    private EdgeEffect f4328Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f4329R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f4330S;

    /* renamed from: T, reason: collision with root package name */
    private int f4331T;

    /* renamed from: U, reason: collision with root package name */
    private List<h> f4332U;

    /* renamed from: V, reason: collision with root package name */
    private final Runnable f4333V;

    /* renamed from: W, reason: collision with root package name */
    private int f4334W;

    /* renamed from: i, reason: collision with root package name */
    private int f4335i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList<e> f4336j;

    /* renamed from: k, reason: collision with root package name */
    private final e f4337k;

    /* renamed from: l, reason: collision with root package name */
    private final Rect f4338l;

    /* renamed from: m, reason: collision with root package name */
    AbstractC0224a f4339m;

    /* renamed from: n, reason: collision with root package name */
    int f4340n;

    /* renamed from: o, reason: collision with root package name */
    private int f4341o;
    private Parcelable p;

    /* renamed from: q, reason: collision with root package name */
    private Scroller f4342q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4343r;

    /* renamed from: s, reason: collision with root package name */
    private i f4344s;

    /* renamed from: t, reason: collision with root package name */
    private float f4345t;
    private float u;

    /* renamed from: v, reason: collision with root package name */
    private int f4346v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f4347w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f4348x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f4349y;

    /* renamed from: z, reason: collision with root package name */
    private int f4350z;

    /* renamed from: b0.b$a */
    static class a implements Comparator<e> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(e eVar, e eVar2) {
            return eVar.f4353b - eVar2.f4353b;
        }
    }

    /* renamed from: b0.b$b, reason: collision with other inner class name */
    static class InterpolatorC0077b implements Interpolator {
        InterpolatorC0077b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    }

    /* renamed from: b0.b$c */
    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            C0225b.this.C(0);
            C0225b.this.t();
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: b0.b$d */
    public @interface d {
    }

    /* renamed from: b0.b$e */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        Fragment f4352a;

        /* renamed from: b, reason: collision with root package name */
        int f4353b;

        /* renamed from: c, reason: collision with root package name */
        boolean f4354c;
        float d;

        /* renamed from: e, reason: collision with root package name */
        float f4355e;

        e() {
        }
    }

    /* renamed from: b0.b$g */
    class g extends androidx.core.view.a {
        g() {
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AbstractC0224a abstractC0224a;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(C0225b.class.getName());
            AbstractC0224a abstractC0224a2 = C0225b.this.f4339m;
            accessibilityEvent.setScrollable(abstractC0224a2 != null && abstractC0224a2.c() > 1);
            if (accessibilityEvent.getEventType() != 4096 || (abstractC0224a = C0225b.this.f4339m) == null) {
                return;
            }
            accessibilityEvent.setItemCount(abstractC0224a.c());
            accessibilityEvent.setFromIndex(C0225b.this.f4340n);
            accessibilityEvent.setToIndex(C0225b.this.f4340n);
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.E(C0225b.class.getName());
            AbstractC0224a abstractC0224a = C0225b.this.f4339m;
            bVar.U(abstractC0224a != null && abstractC0224a.c() > 1);
            if (C0225b.this.canScrollHorizontally(1)) {
                bVar.a(4096);
            }
            if (C0225b.this.canScrollHorizontally(-1)) {
                bVar.a(8192);
            }
        }

        @Override // androidx.core.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) throws Resources.NotFoundException {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            if (i2 == 4096) {
                if (!C0225b.this.canScrollHorizontally(1)) {
                    return false;
                }
                C0225b c0225b = C0225b.this;
                c0225b.z(c0225b.f4340n + 1);
                return true;
            }
            if (i2 != 8192 || !C0225b.this.canScrollHorizontally(-1)) {
                return false;
            }
            C0225b c0225b2 = C0225b.this;
            c0225b2.z(c0225b2.f4340n - 1);
            return true;
        }
    }

    /* renamed from: b0.b$h */
    public interface h {
        void a(int i2);

        void b(int i2);

        void c(int i2, float f4);
    }

    /* renamed from: b0.b$i */
    private class i extends DataSetObserver {
        i() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() throws Resources.NotFoundException {
            C0225b.this.f();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() throws Resources.NotFoundException {
            C0225b.this.f();
        }
    }

    /* renamed from: b0.b$j */
    public static class j extends I.a {
        public static final Parcelable.Creator<j> CREATOR = new a();

        /* renamed from: k, reason: collision with root package name */
        int f4362k;

        /* renamed from: l, reason: collision with root package name */
        Parcelable f4363l;

        /* renamed from: m, reason: collision with root package name */
        ClassLoader f4364m;

        /* renamed from: b0.b$j$a */
        static class a implements Parcelable.ClassLoaderCreator<j> {
            a() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final j createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new j(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new j[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new j(parcel, null);
            }
        }

        public j(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            StringBuilder sbD = D2.e.d("FragmentPager.SavedState{");
            sbD.append(Integer.toHexString(System.identityHashCode(this)));
            sbD.append(" position=");
            sbD.append(this.f4362k);
            sbD.append("}");
            return sbD.toString();
        }

        @Override // I.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4362k);
            parcel.writeParcelable(this.f4363l, i2);
        }

        j(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? j.class.getClassLoader() : classLoader;
            this.f4362k = parcel.readInt();
            this.f4363l = parcel.readParcelable(classLoader);
            this.f4364m = classLoader;
        }
    }

    public C0225b(Context context) {
        super(context);
        this.f4336j = new ArrayList<>();
        this.f4337k = new e();
        this.f4338l = new Rect();
        this.f4341o = -1;
        this.p = null;
        this.f4345t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.f4350z = 1;
        this.f4324J = -1;
        this.f4329R = true;
        this.f4333V = new c();
        this.f4334W = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.f4342q = new Scroller(context2, f4314c0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f4 = context2.getResources().getDisplayMetrics().density;
        this.f4319E = viewConfiguration.getScaledPagingTouchSlop();
        this.L = (int) (400.0f * f4);
        this.M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.P = new EdgeEffect(context2);
        this.f4328Q = new EdgeEffect(context2);
        this.f4326N = (int) (25.0f * f4);
        this.f4327O = (int) (2.0f * f4);
        this.f4317C = (int) (f4 * 16.0f);
        o.j(this, new g());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        o.l(this, new C0226c(this));
    }

    private void D(boolean z4) {
        if (this.f4348x != z4) {
            this.f4348x = z4;
        }
    }

    private void e(boolean z4) throws Resources.NotFoundException {
        boolean z5 = this.f4334W == 2;
        if (z5) {
            D(false);
            if (!this.f4342q.isFinished()) {
                this.f4342q.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4342q.getCurrX();
                int currY = this.f4342q.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        r(currX);
                    }
                }
            }
        }
        this.f4349y = false;
        for (int i2 = 0; i2 < this.f4336j.size(); i2++) {
            e eVar = this.f4336j.get(i2);
            if (eVar.f4354c) {
                eVar.f4354c = false;
                z5 = true;
            }
        }
        if (z5) {
            if (!z4) {
                ((c) this.f4333V).run();
                return;
            }
            Runnable runnable = this.f4333V;
            int i4 = o.d;
            postOnAnimation(runnable);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<b0.b$h>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<b0.b$h>] */
    private void g(int i2) {
        ?? r02 = this.f4332U;
        if (r02 != 0) {
            int size = r02.size();
            for (int i4 = 0; i4 < size; i4++) {
                h hVar = (h) this.f4332U.get(i4);
                if (hVar != null) {
                    hVar.b(i2);
                }
            }
        }
    }

    private Rect h(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int i() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private e l() {
        int i2;
        int i4 = i();
        float f4 = 0.0f;
        float scrollX = i4 > 0 ? getScrollX() / i4 : 0.0f;
        float f5 = i4 > 0 ? 0 / i4 : 0.0f;
        e eVar = null;
        int i5 = 0;
        int i6 = -1;
        boolean z4 = true;
        float f6 = 0.0f;
        while (i5 < this.f4336j.size()) {
            e eVar2 = this.f4336j.get(i5);
            if (!z4 && eVar2.f4353b != (i2 = i6 + 1)) {
                eVar2 = this.f4337k;
                eVar2.f4355e = f4 + f6 + f5;
                eVar2.f4353b = i2;
                Objects.requireNonNull(this.f4339m);
                eVar2.d = 1.0f;
                i5--;
            }
            f4 = eVar2.f4355e;
            float f7 = eVar2.d + f4 + f5;
            if (!z4 && scrollX < f4) {
                return eVar;
            }
            if (scrollX < f7 || i5 == this.f4336j.size() - 1) {
                return eVar2;
            }
            i6 = eVar2.f4353b;
            f6 = eVar2.d;
            i5++;
            z4 = false;
            eVar = eVar2;
        }
        return eVar;
    }

    private void o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4324J) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f4320F = motionEvent.getX(i2);
            this.f4324J = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f4325K;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean r(int i2) {
        if (this.f4336j.size() == 0) {
            if (this.f4329R) {
                return false;
            }
            this.f4330S = false;
            n(0, 0.0f, 0);
            if (this.f4330S) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        e eVarL = l();
        int i4 = i();
        int i5 = i4 + 0;
        float f4 = i4;
        int i6 = eVarL.f4353b;
        float f5 = ((i2 / f4) - eVarL.f4355e) / (eVarL.d + (0 / f4));
        this.f4330S = false;
        n(i6, f5, (int) (i5 * f5));
        if (this.f4330S) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean s(float f4) {
        boolean z4;
        boolean z5;
        float f5 = this.f4320F - f4;
        this.f4320F = f4;
        float scrollX = getScrollX() + f5;
        float fI = i();
        float f6 = this.f4345t * fI;
        float f7 = this.u * fI;
        boolean z6 = false;
        e eVar = this.f4336j.get(0);
        ArrayList<e> arrayList = this.f4336j;
        e eVar2 = arrayList.get(arrayList.size() - 1);
        if (eVar.f4353b != 0) {
            f6 = eVar.f4355e * fI;
            z4 = false;
        } else {
            z4 = true;
        }
        if (eVar2.f4353b != this.f4339m.c() - 1) {
            f7 = eVar2.f4355e * fI;
            z5 = false;
        } else {
            z5 = true;
        }
        if (scrollX < f6) {
            if (z4) {
                this.P.onPull(Math.abs(f6 - scrollX) / fI);
                z6 = true;
            }
            scrollX = f6;
        } else if (scrollX > f7) {
            if (z5) {
                this.f4328Q.onPull(Math.abs(scrollX - f7) / fI);
                z6 = true;
            }
            scrollX = f7;
        }
        int i2 = (int) scrollX;
        this.f4320F = (scrollX - i2) + this.f4320F;
        scrollTo(i2, getScrollY());
        r(i2);
        return z6;
    }

    private void v() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean w() {
        this.f4324J = -1;
        this.f4315A = false;
        this.f4316B = false;
        VelocityTracker velocityTracker = this.f4325K;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4325K = null;
        }
        this.P.onRelease();
        this.f4328Q.onRelease();
        return this.P.isFinished() || this.f4328Q.isFinished();
    }

    private void x(int i2, boolean z4, int i4, boolean z5) throws Resources.NotFoundException {
        int scrollX;
        int iAbs;
        e eVarM = m(i2);
        int iMax = eVarM != null ? (int) (Math.max(this.f4345t, Math.min(eVarM.f4355e, this.u)) * i()) : 0;
        if (!z4) {
            if (z5) {
                g(i2);
            }
            e(false);
            scrollTo(iMax, 0);
            r(iMax);
            return;
        }
        if (getChildCount() == 0) {
            D(false);
        } else {
            Scroller scroller = this.f4342q;
            if ((scroller == null || scroller.isFinished()) ? false : true) {
                scrollX = this.f4343r ? this.f4342q.getCurrX() : this.f4342q.getStartX();
                this.f4342q.abortAnimation();
                D(false);
            } else {
                scrollX = getScrollX();
            }
            int i5 = scrollX;
            int scrollY = getScrollY();
            int i6 = iMax - i5;
            int i7 = 0 - scrollY;
            if (i6 == 0 && i7 == 0) {
                e(false);
                t();
                C(0);
            } else {
                D(true);
                C(2);
                int i8 = i();
                int i9 = i8 / 2;
                float f4 = i8;
                float f5 = i9;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i6) * 1.0f) / f4) - 0.5f) * 0.47123894f)) * f5) + f5;
                int iAbs2 = Math.abs(i4);
                if (iAbs2 > 0) {
                    iAbs = Math.round(Math.abs(fSin / iAbs2) * 1000.0f) * 4;
                } else {
                    Objects.requireNonNull(this.f4339m);
                    iAbs = (int) (((Math.abs(i6) / ((f4 * 1.0f) + 0)) + 1.0f) * 100.0f);
                }
                int iMin = Math.min(iAbs, 600);
                this.f4343r = false;
                this.f4342q.startScroll(i5, scrollY, i6, i7, iMin);
                int i10 = o.d;
                postInvalidateOnAnimation();
            }
        }
        if (z5) {
            g(i2);
        }
    }

    public final void A(int i2, boolean z4) throws Resources.NotFoundException {
        this.f4349y = false;
        B(i2, z4, false, 0);
    }

    final void B(int i2, boolean z4, boolean z5, int i4) throws Resources.NotFoundException {
        AbstractC0224a abstractC0224a = this.f4339m;
        if (abstractC0224a == null || abstractC0224a.c() <= 0) {
            D(false);
            return;
        }
        if (!z5 && this.f4340n == i2 && this.f4336j.size() != 0) {
            D(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f4339m.c()) {
            i2 = this.f4339m.c() - 1;
        }
        int i5 = this.f4350z;
        int i6 = this.f4340n;
        if (i2 > i6 + i5 || i2 < i6 - i5) {
            for (int i7 = 0; i7 < this.f4336j.size(); i7++) {
                this.f4336j.get(i7).f4354c = true;
            }
        }
        boolean z6 = this.f4340n != i2;
        if (!this.f4329R) {
            u(i2);
            x(i2, z4, i4, z6);
        } else {
            this.f4340n = i2;
            if (z6) {
                g(i2);
            }
            requestLayout();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<b0.b$h>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<b0.b$h>] */
    final void C(int i2) {
        if (this.f4334W == i2) {
            return;
        }
        this.f4334W = i2;
        ?? r02 = this.f4332U;
        if (r02 != 0) {
            int size = r02.size();
            for (int i4 = 0; i4 < size; i4++) {
                h hVar = (h) this.f4332U.get(i4);
                if (hVar != null) {
                    hVar.a(i2);
                }
            }
        }
    }

    final e a(int i2, int i4) {
        e eVar = new e();
        eVar.f4353b = i2;
        eVar.f4352a = (Fragment) this.f4339m.e(this, i2);
        Objects.requireNonNull(this.f4339m);
        eVar.d = 1.0f;
        if (i4 < 0 || i4 >= this.f4336j.size()) {
            this.f4336j.add(eVar);
        } else {
            this.f4336j.add(i4, eVar);
        }
        return eVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i2, int i4) {
        e eVarK;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() == 0 && (eVarK = k(childAt)) != null && eVarK.f4353b == this.f4340n) {
                    childAt.addFocusables(arrayList, i2, i4);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i4 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> arrayList) {
        e eVarK;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (eVarK = k(childAt)) != null && eVarK.f4353b == this.f4340n) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = new f();
        }
        f fVar = (f) layoutParams;
        boolean z4 = fVar.f4356a | (view.getClass().getAnnotation(d.class) != null);
        fVar.f4356a = z4;
        if (!this.f4347w) {
            super.addView(view, i2, layoutParams);
        } else {
            if (z4) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            fVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<b0.b$h>] */
    public final void b(h hVar) {
        if (this.f4332U == null) {
            this.f4332U = new ArrayList();
        }
        this.f4332U.add(hVar);
    }

    public final boolean c(int i2) throws Resources.NotFoundException {
        boolean zRequestFocus;
        boolean z4;
        View viewFindFocus = findFocus();
        boolean zP = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z4 = false;
                    break;
                }
                if (parent == this) {
                    z4 = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z4) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                StringBuilder sbD = D2.e.d("arrowScroll tried to find focus based on non-child current focused view ");
                sbD.append(sb.toString());
                Log.e("ViewPager", sbD.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i2 == 17) {
                zRequestFocus = (viewFindFocus == null || h(this.f4338l, viewFindNextFocus).left < h(this.f4338l, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : p();
            } else if (i2 == 66) {
                zRequestFocus = (viewFindFocus == null || h(this.f4338l, viewFindNextFocus).left > h(this.f4338l, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : q();
            }
            zP = zRequestFocus;
        } else if (i2 == 17 || i2 == 1) {
            zP = p();
        } else if (i2 == 66 || i2 == 2) {
            zP = q();
        }
        if (zP) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return zP;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i2) {
        if (this.f4339m == null) {
            return false;
        }
        int i4 = i();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) i4) * this.f4345t)) : i2 > 0 && scrollX < ((int) (((float) i4) * this.u));
    }

    @Override // android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() throws Resources.NotFoundException {
        this.f4343r = true;
        if (this.f4342q.isFinished() || !this.f4342q.computeScrollOffset()) {
            e(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f4342q.getCurrX();
        int currY = this.f4342q.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!r(currX)) {
                this.f4342q.abortAnimation();
                scrollTo(0, currY);
            }
        }
        int i2 = o.d;
        postInvalidateOnAnimation();
    }

    protected final boolean d(View view, boolean z4, int i2, int i4, int i5) {
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom() && d(childAt, true, i2, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z4 && view.canScrollHorizontally(-i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) throws Resources.NotFoundException {
        boolean zP;
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (keyEvent.getAction() != 0) {
                zP = false;
                if (!zP) {
                    return false;
                }
            } else {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 21) {
                    zP = keyEvent.hasModifiers(2) ? p() : c(17);
                } else if (keyCode == 22) {
                    zP = keyEvent.hasModifiers(2) ? q() : c(66);
                } else if (keyCode == 61) {
                    if (keyEvent.hasNoModifiers()) {
                        zP = c(2);
                    } else if (keyEvent.hasModifiers(1)) {
                        zP = c(1);
                    }
                }
                if (!zP) {
                }
            }
        }
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        e eVarK;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (eVarK = k(childAt)) != null && eVarK.f4353b == this.f4340n && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        AbstractC0224a abstractC0224a;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (abstractC0224a = this.f4339m) != null && abstractC0224a.c() > 1)) {
            if (!this.P.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.f4345t * width);
                this.P.setSize(height, width);
                zDraw = false | this.P.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f4328Q.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.u + 1.0f)) * width2);
                this.f4328Q.setSize(height2, width2);
                zDraw |= this.f4328Q.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.P.finish();
            this.f4328Q.finish();
        }
        if (zDraw) {
            int i2 = o.d;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
    }

    final void f() throws Resources.NotFoundException {
        int iC = this.f4339m.c();
        this.f4335i = iC;
        boolean z4 = this.f4336j.size() < (this.f4350z * 2) + 1 && this.f4336j.size() < iC;
        int iMax = this.f4340n;
        int i2 = 0;
        boolean z5 = false;
        while (i2 < this.f4336j.size()) {
            e eVar = this.f4336j.get(i2);
            int iD = this.f4339m.d(eVar.f4352a);
            if (iD != -1) {
                if (iD == -2) {
                    this.f4336j.remove(i2);
                    i2--;
                    if (!z5) {
                        Objects.requireNonNull(this.f4339m);
                        z5 = true;
                    }
                    this.f4339m.a(eVar.f4352a);
                    int i4 = this.f4340n;
                    if (i4 == eVar.f4353b) {
                        iMax = Math.max(0, Math.min(i4, (-1) + iC));
                    }
                } else {
                    int i5 = eVar.f4353b;
                    if (i5 != iD) {
                        if (i5 == this.f4340n) {
                            iMax = iD;
                        }
                        eVar.f4353b = iD;
                    }
                }
                z4 = true;
            }
            i2++;
        }
        if (z5) {
            this.f4339m.b();
        }
        Collections.sort(this.f4336j, f4313b0);
        if (z4) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                f fVar = (f) getChildAt(i6).getLayoutParams();
                if (!fVar.f4356a) {
                    fVar.f4358c = 0.0f;
                }
            }
            B(iMax, false, true, 0);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f();
    }

    @Override // android.view.ViewGroup
    protected final int getChildDrawingOrder(int i2, int i4) {
        throw null;
    }

    public final int j() {
        return this.f4340n;
    }

    final e k(View view) {
        for (int i2 = 0; i2 < this.f4336j.size(); i2++) {
            e eVar = this.f4336j.get(i2);
            if (this.f4339m.f(view, eVar.f4352a)) {
                return eVar;
            }
        }
        return null;
    }

    final e m(int i2) {
        for (int i4 = 0; i4 < this.f4336j.size(); i4++) {
            e eVar = this.f4336j.get(i4);
            if (eVar.f4353b == i2) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.util.ArrayList, java.util.List<b0.b$h>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<b0.b$h>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void n(int i2, float f4, int i4) {
        int iMax;
        int width;
        int left;
        if (this.f4331T > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f4356a) {
                    int i6 = fVar.f4357b & 7;
                    if (i6 != 1) {
                        if (i6 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i6 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i7 = iMax;
                    width = paddingLeft;
                    paddingLeft = i7;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = width;
                }
            }
        }
        ?? r14 = this.f4332U;
        if (r14 != 0) {
            int size = r14.size();
            for (int i8 = 0; i8 < size; i8++) {
                h hVar = (h) this.f4332U.get(i8);
                if (hVar != null) {
                    hVar.c(i2, f4);
                }
            }
        }
        this.f4330S = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4329R = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        removeCallbacks(this.f4333V);
        Scroller scroller = this.f4342q;
        if (scroller != null && !scroller.isFinished()) {
            this.f4342q.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            w();
            return false;
        }
        if (action != 0) {
            if (this.f4315A) {
                return true;
            }
            if (this.f4316B) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.f4322H = x2;
            this.f4320F = x2;
            float y2 = motionEvent.getY();
            this.f4323I = y2;
            this.f4321G = y2;
            this.f4324J = motionEvent.getPointerId(0);
            this.f4316B = false;
            this.f4343r = true;
            this.f4342q.computeScrollOffset();
            if (this.f4334W != 2 || Math.abs(this.f4342q.getFinalX() - this.f4342q.getCurrX()) <= this.f4327O) {
                e(false);
                this.f4315A = false;
            } else {
                this.f4342q.abortAnimation();
                this.f4349y = false;
                t();
                this.f4315A = true;
                v();
                C(1);
            }
        } else if (action == 2) {
            int i2 = this.f4324J;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x4 = motionEvent.getX(iFindPointerIndex);
                float f4 = x4 - this.f4320F;
                float fAbs = Math.abs(f4);
                float y4 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y4 - this.f4323I);
                if (f4 != 0.0f) {
                    float f5 = this.f4320F;
                    if (!((f5 < ((float) this.f4318D) && f4 > 0.0f) || (f5 > ((float) (getWidth() - this.f4318D)) && f4 < 0.0f)) && d(this, false, (int) f4, (int) x4, (int) y4)) {
                        this.f4320F = x4;
                        this.f4321G = y4;
                        this.f4316B = true;
                        return false;
                    }
                }
                float f6 = this.f4319E;
                if (fAbs > f6 && fAbs * 0.5f > fAbs2) {
                    this.f4315A = true;
                    v();
                    C(1);
                    float f7 = this.f4322H;
                    float f8 = this.f4319E;
                    this.f4320F = f4 > 0.0f ? f7 + f8 : f7 - f8;
                    this.f4321G = y4;
                    D(true);
                } else if (fAbs2 > f6) {
                    this.f4316B = true;
                }
                if (this.f4315A && s(x4)) {
                    int i4 = o.d;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            o(motionEvent);
        }
        if (this.f4325K == null) {
            this.f4325K = VelocityTracker.obtain();
        }
        this.f4325K.addMovement(motionEvent);
        return this.f4315A;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) throws Resources.NotFoundException {
        boolean z5;
        e eVarK;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i7 = i5 - i2;
        int i8 = i6 - i4;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f4356a) {
                    int i11 = fVar.f4357b;
                    int i12 = i11 & 7;
                    int i13 = i11 & 112;
                    if (i12 != 1) {
                        if (i12 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i12 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i7 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i13 == 16) {
                            if (i13 == 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i13 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i14 = paddingLeft + scrollX;
                            childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, childAt.getMeasuredHeight() + paddingTop);
                            i9++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i15 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i15;
                        int i142 = paddingLeft + scrollX;
                        childAt.layout(i142, paddingTop, childAt.getMeasuredWidth() + i142, childAt.getMeasuredHeight() + paddingTop);
                        i9++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i16 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i16;
                    if (i13 == 16) {
                    }
                    int i152 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i152;
                    int i1422 = paddingLeft + scrollX;
                    childAt.layout(i1422, paddingTop, childAt.getMeasuredWidth() + i1422, childAt.getMeasuredHeight() + paddingTop);
                    i9++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i17 = (i7 - paddingLeft) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                f fVar2 = (f) childAt2.getLayoutParams();
                if (!fVar2.f4356a && (eVarK = k(childAt2)) != null) {
                    float f4 = i17;
                    int i19 = ((int) (eVarK.f4355e * f4)) + paddingLeft;
                    if (fVar2.d) {
                        fVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f4 * fVar2.f4358c), 1073741824), View.MeasureSpec.makeMeasureSpec((i8 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i19, paddingTop, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f4331T = i9;
        if (this.f4329R) {
            z5 = false;
            x(this.f4340n, false, 0, false);
        } else {
            z5 = false;
        }
        this.f4329R = z5;
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) throws Resources.NotFoundException {
        f fVar;
        f fVar2;
        int i5;
        setMeasuredDimension(View.getDefaultSize(0, i2), View.getDefaultSize(0, i4));
        int measuredWidth = getMeasuredWidth();
        this.f4318D = Math.min(measuredWidth / 10, this.f4317C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z4 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (fVar2 = (f) childAt.getLayoutParams()) != null && fVar2.f4356a) {
                int i8 = fVar2.f4357b;
                int i9 = i8 & 7;
                int i10 = i8 & 112;
                boolean z5 = i10 == 48 || i10 == 80;
                if (i9 != 3 && i9 != 5) {
                    z4 = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z5) {
                    i5 = Integer.MIN_VALUE;
                    i11 = 1073741824;
                } else {
                    i5 = z4 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i12 = ((ViewGroup.LayoutParams) fVar2).width;
                if (i12 != -2) {
                    if (i12 == -1) {
                        i12 = paddingLeft;
                    }
                    i11 = 1073741824;
                } else {
                    i12 = paddingLeft;
                }
                int i13 = ((ViewGroup.LayoutParams) fVar2).height;
                if (i13 == -2) {
                    i13 = measuredHeight;
                    i7 = i5;
                } else if (i13 == -1) {
                    i13 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i12, i11), View.MeasureSpec.makeMeasureSpec(i13, i7));
                if (z5) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z4) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f4346v = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f4347w = true;
        t();
        this.f4347w = false;
        int childCount2 = getChildCount();
        for (int i14 = 0; i14 < childCount2; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8 && ((fVar = (f) childAt2.getLayoutParams()) == null || !fVar.f4356a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * fVar.f4358c), 1073741824), this.f4346v);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i4;
        int i5;
        e eVarK;
        int childCount = getChildCount();
        int i6 = -1;
        if ((i2 & 2) != 0) {
            i6 = childCount;
            i4 = 0;
            i5 = 1;
        } else {
            i4 = childCount - 1;
            i5 = -1;
        }
        while (i4 != i6) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (eVarK = k(childAt)) != null && eVarK.f4353b == this.f4340n && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i5;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.a());
        if (this.f4339m != null) {
            B(jVar.f4362k, false, true, 0);
        } else {
            this.f4341o = jVar.f4362k;
            this.p = jVar.f4363l;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        j jVar = new j(super.onSaveInstanceState());
        jVar.f4362k = this.f4340n;
        AbstractC0224a abstractC0224a = this.f4339m;
        if (abstractC0224a != null) {
            Objects.requireNonNull(abstractC0224a);
            jVar.f4363l = null;
        }
        return jVar;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i2, int i4, int i5, int i6) throws Resources.NotFoundException {
        super.onSizeChanged(i2, i4, i5, i6);
        if (i2 != i5) {
            if (i5 > 0 && !this.f4336j.isEmpty()) {
                if (!this.f4342q.isFinished()) {
                    this.f4342q.setFinalX(this.f4340n * i());
                    return;
                } else {
                    scrollTo((int) ((getScrollX() / (((i5 - getPaddingLeft()) - getPaddingRight()) + 0)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + 0)), getScrollY());
                    return;
                }
            }
            e eVarM = m(this.f4340n);
            int iMin = (int) ((eVarM != null ? Math.min(eVarM.f4355e, this.u) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (iMin != getScrollX()) {
                e(false);
                scrollTo(iMin, getScrollY());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        AbstractC0224a abstractC0224a;
        boolean zW = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (abstractC0224a = this.f4339m) == null || abstractC0224a.c() == 0) {
            return false;
        }
        if (this.f4325K == null) {
            this.f4325K = VelocityTracker.obtain();
        }
        this.f4325K.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f4342q.abortAnimation();
            this.f4349y = false;
            t();
            float x2 = motionEvent.getX();
            this.f4322H = x2;
            this.f4320F = x2;
            float y2 = motionEvent.getY();
            this.f4323I = y2;
            this.f4321G = y2;
            this.f4324J = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f4320F = motionEvent.getX(actionIndex);
                        this.f4324J = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        o(motionEvent);
                        this.f4320F = motionEvent.getX(motionEvent.findPointerIndex(this.f4324J));
                    }
                } else if (this.f4315A) {
                    x(this.f4340n, true, 0, false);
                    zW = w();
                }
            } else if (!this.f4315A) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f4324J);
                if (iFindPointerIndex == -1) {
                    zW = w();
                } else {
                    float x4 = motionEvent.getX(iFindPointerIndex);
                    float fAbs = Math.abs(x4 - this.f4320F);
                    float y4 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y4 - this.f4321G);
                    if (fAbs > this.f4319E && fAbs > fAbs2) {
                        this.f4315A = true;
                        v();
                        float f4 = this.f4322H;
                        this.f4320F = x4 - f4 > 0.0f ? f4 + this.f4319E : f4 - this.f4319E;
                        this.f4321G = y4;
                        C(1);
                        D(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.f4315A) {
                    }
                }
            } else if (this.f4315A) {
                zW = false | s(motionEvent.getX(motionEvent.findPointerIndex(this.f4324J)));
            }
        } else if (this.f4315A) {
            VelocityTracker velocityTracker = this.f4325K;
            velocityTracker.computeCurrentVelocity(1000, this.M);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f4324J);
            this.f4349y = true;
            int i2 = i();
            int scrollX = getScrollX();
            e eVarL = l();
            float f5 = i2;
            int iMax = eVarL.f4353b;
            float f6 = ((scrollX / f5) - eVarL.f4355e) / (eVarL.d + (0 / f5));
            if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.f4324J)) - this.f4322H)) <= this.f4326N || Math.abs(xVelocity) <= this.L) {
                iMax += (int) (f6 + (iMax >= this.f4340n ? 0.4f : 0.6f));
            } else if (xVelocity <= 0) {
                iMax++;
            }
            if (this.f4336j.size() > 0) {
                iMax = Math.max(this.f4336j.get(0).f4353b, Math.min(iMax, this.f4336j.get(r1.size() - 1).f4353b));
            }
            B(iMax, true, true, xVelocity);
            zW = w();
        }
        if (zW) {
            int i4 = o.d;
            postInvalidateOnAnimation();
        }
        return true;
    }

    final boolean p() throws Resources.NotFoundException {
        int i2 = this.f4340n;
        if (i2 <= 0) {
            return false;
        }
        A(i2 - 1, true);
        return true;
    }

    final boolean q() throws Resources.NotFoundException {
        AbstractC0224a abstractC0224a = this.f4339m;
        if (abstractC0224a == null || this.f4340n >= abstractC0224a.c() - 1) {
            return false;
        }
        A(this.f4340n + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f4347w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    final void t() throws Resources.NotFoundException {
        u(this.f4340n);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec A[PHI: r4 r6 r12
      0x00ec: PHI (r4v20 int) = (r4v19 int), (r4v8 int), (r4v22 int) binds: [B:59:0x00e1, B:56:0x00cb, B:50:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r6v6 int) = (r6v1 int), (r6v5 int), (r6v8 int) binds: [B:59:0x00e1, B:56:0x00cb, B:50:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r12v5 float) = (r12v3 float), (r12v4 float), (r12v2 float) binds: [B:59:0x00e1, B:56:0x00cb, B:50:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0182 A[PHI: r1 r10
      0x0182: PHI (r1v16 float) = (r1v14 float), (r1v15 float), (r1v13 float) binds: [B:93:0x0177, B:90:0x015d, B:84:0x0141] A[DONT_GENERATE, DONT_INLINE]
      0x0182: PHI (r10v30 int) = (r10v28 int), (r10v29 int), (r10v27 int) binds: [B:93:0x0177, B:90:0x015d, B:84:0x0141] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void u(int i2) throws Resources.NotFoundException {
        e eVarM;
        String hexString;
        e eVarA;
        e eVarK;
        e eVarK2;
        int i4;
        int i5;
        e eVar;
        e eVar2;
        int i6 = this.f4340n;
        if (i6 != i2) {
            eVarM = m(i6);
            this.f4340n = i2;
        } else {
            eVarM = null;
        }
        if (this.f4339m == null || this.f4349y || getWindowToken() == null) {
            return;
        }
        Objects.requireNonNull(this.f4339m);
        int i7 = this.f4350z;
        int iMax = Math.max(0, this.f4340n - i7);
        int iC = this.f4339m.c();
        int iMin = Math.min(iC - 1, this.f4340n + i7);
        if (iC != this.f4335i) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            StringBuilder sbD = D2.e.d("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
            sbD.append(this.f4335i);
            sbD.append(", found: ");
            sbD.append(iC);
            sbD.append(" Pager id: ");
            sbD.append(hexString);
            sbD.append(" Pager class: ");
            sbD.append(C0225b.class);
            sbD.append(" Problematic adapter: ");
            sbD.append(this.f4339m.getClass());
            throw new IllegalStateException(sbD.toString());
        }
        int i8 = 0;
        while (true) {
            if (i8 >= this.f4336j.size()) {
                break;
            }
            eVarA = this.f4336j.get(i8);
            int i9 = eVarA.f4353b;
            int i10 = this.f4340n;
            if (i9 >= i10) {
                if (i9 != i10) {
                    break;
                }
            } else {
                i8++;
            }
        }
        if (eVarA == null && iC > 0) {
            eVarA = a(this.f4340n, i8);
        }
        if (eVarA != null) {
            int i11 = i8 - 1;
            e eVar3 = i11 >= 0 ? this.f4336j.get(i11) : null;
            int i12 = i();
            float paddingLeft = i12 <= 0 ? 0.0f : (2.0f - eVarA.d) + (getPaddingLeft() / i12);
            float f4 = 0.0f;
            for (int i13 = this.f4340n - 1; i13 >= 0; i13--) {
                if (f4 >= paddingLeft && i13 < iMax) {
                    if (eVar3 == null) {
                        break;
                    }
                    if (i13 == eVar3.f4353b && !eVar3.f4354c) {
                        this.f4336j.remove(i11);
                        this.f4339m.a(eVar3.f4352a);
                        i11--;
                        i8--;
                        if (i11 >= 0) {
                            eVar3 = this.f4336j.get(i11);
                        }
                    }
                } else if (eVar3 == null || i13 != eVar3.f4353b) {
                    f4 += a(i13, i11 + 1).d;
                    i8++;
                    eVar3 = i11 >= 0 ? this.f4336j.get(i11) : null;
                } else {
                    f4 += eVar3.d;
                    i11--;
                    if (i11 >= 0) {
                        eVar3 = this.f4336j.get(i11);
                    }
                }
            }
            float f5 = eVarA.d;
            int i14 = i8 + 1;
            if (f5 < 2.0f) {
                e eVar4 = i14 < this.f4336j.size() ? this.f4336j.get(i14) : null;
                float paddingRight = i12 <= 0 ? 0.0f : (getPaddingRight() / i12) + 2.0f;
                int i15 = i14;
                for (int i16 = this.f4340n + 1; i16 < iC; i16++) {
                    if (f5 >= paddingRight && i16 > iMin) {
                        if (eVar4 == null) {
                            break;
                        }
                        if (i16 == eVar4.f4353b && !eVar4.f4354c) {
                            this.f4336j.remove(i15);
                            this.f4339m.a(eVar4.f4352a);
                            if (i15 < this.f4336j.size()) {
                                eVar4 = this.f4336j.get(i15);
                            }
                        }
                    } else if (eVar4 == null || i16 != eVar4.f4353b) {
                        e eVarA2 = a(i16, i15);
                        i15++;
                        f5 += eVarA2.d;
                        eVar4 = i15 < this.f4336j.size() ? this.f4336j.get(i15) : null;
                    } else {
                        f5 += eVar4.d;
                        i15++;
                        if (i15 < this.f4336j.size()) {
                            eVar4 = this.f4336j.get(i15);
                        }
                    }
                }
            }
            int iC2 = this.f4339m.c();
            int i17 = i();
            float f6 = i17 > 0 ? 0 / i17 : 0.0f;
            if (eVarM != null) {
                int i18 = eVarM.f4353b;
                int i19 = eVarA.f4353b;
                if (i18 < i19) {
                    float f7 = eVarM.f4355e + eVarM.d + f6;
                    int i20 = 0;
                    while (true) {
                        i18++;
                        if (i18 > eVarA.f4353b || i20 >= this.f4336j.size()) {
                            break;
                        }
                        e eVar5 = this.f4336j.get(i20);
                        while (true) {
                            eVar2 = eVar5;
                            if (i18 <= eVar2.f4353b || i20 >= this.f4336j.size() - 1) {
                                break;
                            }
                            i20++;
                            eVar5 = this.f4336j.get(i20);
                        }
                        while (i18 < eVar2.f4353b) {
                            Objects.requireNonNull(this.f4339m);
                            f7 += 1.0f + f6;
                            i18++;
                        }
                        eVar2.f4355e = f7;
                        f7 += eVar2.d + f6;
                    }
                } else if (i18 > i19) {
                    int size = this.f4336j.size() - 1;
                    float f8 = eVarM.f4355e;
                    while (true) {
                        i18--;
                        if (i18 < eVarA.f4353b || size < 0) {
                            break;
                        }
                        e eVar6 = this.f4336j.get(size);
                        while (true) {
                            eVar = eVar6;
                            if (i18 >= eVar.f4353b || size <= 0) {
                                break;
                            }
                            size--;
                            eVar6 = this.f4336j.get(size);
                        }
                        while (i18 > eVar.f4353b) {
                            Objects.requireNonNull(this.f4339m);
                            f8 -= 1.0f + f6;
                            i18--;
                        }
                        f8 -= eVar.d + f6;
                        eVar.f4355e = f8;
                    }
                }
            }
            int size2 = this.f4336j.size();
            float f9 = eVarA.f4355e;
            int i21 = eVarA.f4353b;
            int i22 = i21 - 1;
            this.f4345t = i21 == 0 ? f9 : -3.4028235E38f;
            int i23 = iC2 - 1;
            this.u = i21 == i23 ? (eVarA.d + f9) - 1.0f : Float.MAX_VALUE;
            int i24 = i8 - 1;
            while (i24 >= 0) {
                e eVar7 = this.f4336j.get(i24);
                while (true) {
                    i5 = eVar7.f4353b;
                    if (i22 <= i5) {
                        break;
                    }
                    i22--;
                    Objects.requireNonNull(this.f4339m);
                    f9 -= 1.0f + f6;
                }
                f9 -= eVar7.d + f6;
                eVar7.f4355e = f9;
                if (i5 == 0) {
                    this.f4345t = f9;
                }
                i24--;
                i22--;
            }
            float f10 = eVarA.f4355e + eVarA.d + f6;
            int i25 = eVarA.f4353b;
            while (true) {
                i25++;
                if (i14 >= size2) {
                    break;
                }
                e eVar8 = this.f4336j.get(i14);
                while (true) {
                    i4 = eVar8.f4353b;
                    if (i25 >= i4) {
                        break;
                    }
                    i25++;
                    Objects.requireNonNull(this.f4339m);
                    f10 += 1.0f + f6;
                }
                if (i4 == i23) {
                    this.u = (eVar8.d + f10) - 1.0f;
                }
                eVar8.f4355e = f10;
                f10 += eVar8.d + f6;
                i14++;
            }
            this.f4339m.h(eVarA.f4352a);
        }
        this.f4339m.b();
        int childCount = getChildCount();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            f fVar = (f) childAt.getLayoutParams();
            Objects.requireNonNull(fVar);
            if (!fVar.f4356a && fVar.f4358c == 0.0f && (eVarK2 = k(childAt)) != null) {
                fVar.f4358c = eVarK2.d;
                fVar.f4359e = eVarK2.f4353b;
            }
        }
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            if (viewFindFocus != null) {
                while (true) {
                    Object parent = viewFindFocus.getParent();
                    if (parent == this) {
                        eVarK = k(viewFindFocus);
                        break;
                    } else if (parent == null || !(parent instanceof View)) {
                        break;
                    } else {
                        viewFindFocus = (View) parent;
                    }
                }
                eVarK = null;
            } else {
                eVarK = null;
            }
            if (eVarK == null || eVarK.f4353b != this.f4340n) {
                for (int i27 = 0; i27 < getChildCount(); i27++) {
                    View childAt2 = getChildAt(i27);
                    e eVarK3 = k(childAt2);
                    if (eVarK3 != null && eVarK3.f4353b == this.f4340n && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == null;
    }

    public final void y(AbstractC0224a abstractC0224a) throws Resources.NotFoundException {
        AbstractC0224a abstractC0224a2 = this.f4339m;
        if (abstractC0224a2 != null) {
            abstractC0224a2.i(null);
            Objects.requireNonNull(this.f4339m);
            for (int i2 = 0; i2 < this.f4336j.size(); i2++) {
                e eVar = this.f4336j.get(i2);
                AbstractC0224a abstractC0224a3 = this.f4339m;
                int i4 = eVar.f4353b;
                abstractC0224a3.a(eVar.f4352a);
            }
            this.f4339m.b();
            this.f4336j.clear();
            int i5 = 0;
            while (i5 < getChildCount()) {
                if (!((f) getChildAt(i5).getLayoutParams()).f4356a) {
                    removeViewAt(i5);
                    i5--;
                }
                i5++;
            }
            this.f4340n = 0;
            scrollTo(0, 0);
        }
        this.f4339m = abstractC0224a;
        this.f4335i = 0;
        if (this.f4344s == null) {
            this.f4344s = new i();
        }
        this.f4339m.i(this.f4344s);
        this.f4349y = false;
        boolean z4 = this.f4329R;
        this.f4329R = true;
        this.f4335i = this.f4339m.c();
        if (this.f4341o >= 0) {
            Objects.requireNonNull(this.f4339m);
            B(this.f4341o, false, true, 0);
            this.f4341o = -1;
            this.p = null;
            return;
        }
        if (z4) {
            requestLayout();
        } else {
            t();
        }
    }

    public final void z(int i2) throws Resources.NotFoundException {
        this.f4349y = false;
        B(i2, !this.f4329R, false, 0);
    }

    /* renamed from: b0.b$f */
    public static class f extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4356a;

        /* renamed from: b, reason: collision with root package name */
        public int f4357b;

        /* renamed from: c, reason: collision with root package name */
        float f4358c;
        boolean d;

        /* renamed from: e, reason: collision with root package name */
        int f4359e;

        public f() {
            super(-1, -1);
            this.f4358c = 0.0f;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4358c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0225b.f4312a0);
            this.f4357b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }
}
