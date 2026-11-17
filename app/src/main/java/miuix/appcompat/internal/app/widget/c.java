package miuix.appcompat.internal.app.widget;

import android.R;
import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import miuix.appcompat.internal.app.widget.c;
import z3.C0432b;

/* loaded from: classes.dex */
abstract class c extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    protected miuix.appcompat.internal.view.menu.action.c f6931i;

    /* renamed from: j, reason: collision with root package name */
    protected miuix.appcompat.internal.view.menu.action.b f6932j;

    /* renamed from: k, reason: collision with root package name */
    protected ActionBarContainer f6933k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f6934l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f6935m;

    /* renamed from: n, reason: collision with root package name */
    protected int f6936n;

    /* renamed from: o, reason: collision with root package name */
    protected int f6937o;
    int p;

    /* renamed from: q, reason: collision with root package name */
    private int f6938q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6939r;

    protected static class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<View> f6940a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private float f6941b;

        /* renamed from: c, reason: collision with root package name */
        private int f6942c;
        private int d;

        /* renamed from: e, reason: collision with root package name */
        private final ValueAnimator f6943e;

        a() {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f6943e = valueAnimator;
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: miuix.appcompat.internal.app.widget.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    c.a aVar = this.f6930i;
                    Objects.requireNonNull(aVar);
                    aVar.g(((Float) valueAnimator2.getAnimatedValue(View.TRANSLATION_X.getName())).intValue(), ((Float) valueAnimator2.getAnimatedValue(View.TRANSLATION_Y.getName())).intValue());
                    aVar.e(((Float) valueAnimator2.getAnimatedValue(View.ALPHA.getName())).floatValue());
                }
            });
            valueAnimator.setInterpolator(new DecelerateInterpolator(1.5f));
            valueAnimator.setDuration(200L);
        }

        public final void a(float f4, int i2, Animator.AnimatorListener animatorListener) {
            if (this.f6943e.isStarted()) {
                this.f6943e.cancel();
            }
            float f5 = 0;
            float f6 = i2;
            this.f6943e.setValues(PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.f6942c, f5), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.d, f6));
            this.f6943e.setValues(PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.f6942c, f5), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.d, f6), PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, this.f6941b, f4));
            this.f6943e.removeAllListeners();
            if (animatorListener != null) {
                this.f6943e.addListener(animatorListener);
            }
            this.f6943e.start();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        public final void b(View view) {
            if (this.f6940a.contains(view)) {
                return;
            }
            this.f6940a.add(view);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        public final void c() {
            Iterator it = this.f6940a.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setEnabled(false);
            }
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        public final void d() {
            Iterator it = this.f6940a.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setEnabled(true);
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        public final void e(float f4) {
            this.f6941b = f4;
            Iterator it = this.f6940a.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(f4);
            }
        }

        public final void f(float f4, int i2) {
            e(f4);
            g(0, i2);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        public final void g(int i2, int i4) {
            this.f6942c = i2;
            this.d = i4;
            Iterator it = this.f6940a.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                view.setTranslationX(i2);
                view.setTranslationY(i4);
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<android.view.View>] */
        public final void h(int i2) {
            Iterator it = this.f6940a.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setVisibility(i2);
            }
        }
    }

    c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    int a() {
        return R.attr.actionBarStyle;
    }

    public int b() {
        return this.f6938q;
    }

    public boolean c() {
        return this.f6939r;
    }

    protected final int d(View view, int i2, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i4);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i5);
    }

    protected void e(int i2, int i4) {
    }

    protected void f(int i2, int i4) {
    }

    protected final int g(View view, int i2, int i4, int i5, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = ((i5 - measuredHeight) / 2) + i4;
        if (!z4) {
            i6 = (this.f6936n - measuredHeight) / 2;
        }
        int i7 = i6;
        S2.d.k(this, view, i2, i7, i2 + measuredWidth, i7 + measuredHeight);
        return measuredWidth;
    }

    protected final int h(View view, int i2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = (this.f6936n - measuredHeight) / 2;
        S2.d.k(this, view, i2 - measuredWidth, i4, i2, i4 + measuredHeight);
        return measuredWidth;
    }

    public void i(int i2) {
        j(0, false);
    }

    public void j(int i2, boolean z4) {
        boolean z5;
        int i4;
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getContext();
            int i5 = C0432b.f8169a;
            z5 = true;
        } else {
            z5 = false;
        }
        if ((!z5 || i2 == 0) && this.f6939r && (i4 = this.p) != i2) {
            if (z4) {
                e(i4, i2);
                return;
            }
            this.p = i2;
            if (i2 == 0) {
                this.f6938q = 0;
            } else if (i2 == 1) {
                this.f6938q = 1;
            }
            f(i4, i2);
            requestLayout();
        }
    }

    public void k(boolean z4) {
        this.f6939r = z4;
    }

    public void l(boolean z4) {
        this.f6934l = z4;
    }

    public boolean m() {
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        return bVar != null && bVar.s();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, Y1.a.f2098S, a(), 0);
        this.f6936n = typedArrayObtainStyledAttributes.getLayoutDimension(4, 0);
        requestLayout();
        this.f6937o = typedArrayObtainStyledAttributes.getLayoutDimension(2, 0);
        requestLayout();
        typedArrayObtainStyledAttributes.recycle();
        if (this.f6935m) {
            l(getContext().getResources().getBoolean(com.android.mmt.R.bool.abc_split_action_bar_is_narrow));
        }
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        if (bVar != null) {
            bVar.o(configuration);
        }
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getContext();
            int i2 = C0432b.f8169a;
            i(0);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            super.setVisibility(i2);
        }
    }

    c(Context context, AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        super(context, attributeSet, i2);
        this.p = 1;
        this.f6938q = 1;
        this.f6939r = true;
        context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_action_bar_title_collapse_padding_vertical);
        context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_action_bar_subtitle_collapse_padding_vertical);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2098S, R.attr.actionBarStyle, 0);
        int i4 = typedArrayObtainStyledAttributes.getInt(34, 1);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(49, true);
        typedArrayObtainStyledAttributes.recycle();
        if (i4 == 0) {
            this.p = 0;
            this.f6938q = 0;
        } else if (getContext().getResources().getConfiguration().orientation == 2) {
            getContext();
            int i5 = C0432b.f8169a;
            this.p = 0;
            this.f6938q = 0;
        } else {
            this.p = 1;
            this.f6938q = 1;
        }
        this.f6939r = z4;
    }
}
