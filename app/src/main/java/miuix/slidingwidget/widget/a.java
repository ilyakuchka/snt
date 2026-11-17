package miuix.slidingwidget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import androidx.appcompat.widget.Y;
import com.android.mmt.R;
import m3.C0351c;
import miuix.smooth.SmoothContainerDrawable;
import miuix.view.HapticCompat;
import n3.AbstractC0355a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: A, reason: collision with root package name */
    private C0351c f7365A;

    /* renamed from: B, reason: collision with root package name */
    private C0351c f7366B;

    /* renamed from: C, reason: collision with root package name */
    private C0351c f7367C;

    /* renamed from: D, reason: collision with root package name */
    private C0351c f7368D;

    /* renamed from: E, reason: collision with root package name */
    private C0351c f7369E;

    /* renamed from: F, reason: collision with root package name */
    private C0351c f7370F;

    /* renamed from: J, reason: collision with root package name */
    private float f7374J;

    /* renamed from: K, reason: collision with root package name */
    private Drawable f7375K;
    private Drawable L;

    /* renamed from: W, reason: collision with root package name */
    private int f7384W;

    /* renamed from: X, reason: collision with root package name */
    private int f7385X;

    /* renamed from: Y, reason: collision with root package name */
    private int f7386Y;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f7388a;

    /* renamed from: b, reason: collision with root package name */
    private int f7390b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f7391c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private int f7392e;

    /* renamed from: f, reason: collision with root package name */
    private int f7393f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f7394h;

    /* renamed from: i, reason: collision with root package name */
    private int f7395i;

    /* renamed from: j, reason: collision with root package name */
    private int f7396j;

    /* renamed from: k, reason: collision with root package name */
    private int f7397k;

    /* renamed from: l, reason: collision with root package name */
    private int f7398l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7399m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7400n;

    /* renamed from: o, reason: collision with root package name */
    private int f7401o;

    /* renamed from: q, reason: collision with root package name */
    private StateListDrawable f7402q;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f7405t;
    private Drawable u;

    /* renamed from: v, reason: collision with root package name */
    private CompoundButton f7406v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7407w;

    /* renamed from: x, reason: collision with root package name */
    private C0351c f7408x;

    /* renamed from: y, reason: collision with root package name */
    private C0351c f7409y;

    /* renamed from: z, reason: collision with root package name */
    private C0351c f7410z;
    private Rect p = new Rect();

    /* renamed from: r, reason: collision with root package name */
    private boolean f7403r = false;

    /* renamed from: s, reason: collision with root package name */
    private AbstractC0355a<CompoundButton> f7404s = new C0126a();

    /* renamed from: G, reason: collision with root package name */
    private float f7371G = 1.0f;

    /* renamed from: H, reason: collision with root package name */
    private float f7372H = 0.0f;

    /* renamed from: I, reason: collision with root package name */
    private float f7373I = 0.1f;
    private boolean M = false;

    /* renamed from: N, reason: collision with root package name */
    private int f7376N = -1;

    /* renamed from: O, reason: collision with root package name */
    private int f7377O = -1;
    private boolean P = false;

    /* renamed from: Q, reason: collision with root package name */
    private float f7378Q = -1.0f;

    /* renamed from: R, reason: collision with root package name */
    private AbstractC0355a<CompoundButton> f7379R = new b();

    /* renamed from: S, reason: collision with root package name */
    private miuix.internal.view.c f7380S = new miuix.internal.view.c(this, 1);

    /* renamed from: T, reason: collision with root package name */
    private AbstractC0355a<CompoundButton> f7381T = new c();

    /* renamed from: U, reason: collision with root package name */
    private AbstractC0355a<CompoundButton> f7382U = new d();

    /* renamed from: V, reason: collision with root package name */
    private AbstractC0355a<CompoundButton> f7383V = new e();

    /* renamed from: Z, reason: collision with root package name */
    private float f7387Z = 1.0f;

    /* renamed from: a0, reason: collision with root package name */
    private float[] f7389a0 = {0.0f, 0.0f};

    /* renamed from: miuix.slidingwidget.widget.a$a, reason: collision with other inner class name */
    final class C0126a extends AbstractC0355a<CompoundButton> {
        C0126a() {
            super("SliderOffset");
        }

        @Override // n3.AbstractC0355a
        public final float a(CompoundButton compoundButton) {
            return a.this.r();
        }

        @Override // n3.AbstractC0355a
        public final void b(CompoundButton compoundButton, float f4) {
            a.this.E((int) f4);
        }
    }

    final class b extends AbstractC0355a<CompoundButton> {
        b() {
            super("SliderScale");
        }

        @Override // n3.AbstractC0355a
        public final float a(CompoundButton compoundButton) {
            return a.this.f7371G;
        }

        @Override // n3.AbstractC0355a
        public final void b(CompoundButton compoundButton, float f4) {
            a.this.f7371G = f4;
        }
    }

    final class c extends AbstractC0355a<CompoundButton> {
        c() {
            super("SliderShadowAlpha");
        }

        @Override // n3.AbstractC0355a
        public final float a(CompoundButton compoundButton) {
            return a.this.f7372H;
        }

        @Override // n3.AbstractC0355a
        public final void b(CompoundButton compoundButton, float f4) {
            a.this.f7372H = f4;
        }
    }

    final class d extends AbstractC0355a<CompoundButton> {
        d() {
            super("StrokeAlpha");
        }

        @Override // n3.AbstractC0355a
        public final float a(CompoundButton compoundButton) {
            return a.this.f7373I;
        }

        @Override // n3.AbstractC0355a
        public final void b(CompoundButton compoundButton, float f4) {
            a.this.f7373I = f4;
        }
    }

    final class e extends AbstractC0355a<CompoundButton> {
        e() {
            super("MaskCheckedSlideBarAlpha");
        }

        @Override // n3.AbstractC0355a
        public final float a(CompoundButton compoundButton) {
            return a.this.f7374J;
        }

        @Override // n3.AbstractC0355a
        public final void b(CompoundButton compoundButton, float f4) {
            a.this.f7374J = f4;
        }
    }

    final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            aVar.f7407w = aVar.f7396j >= a.this.f7395i;
        }
    }

    public a(CompoundButton compoundButton) {
        this.f7374J = 1.0f;
        this.f7406v = compoundButton;
        this.f7407w = compoundButton.isChecked();
        if (this.f7406v.isChecked()) {
            return;
        }
        this.f7374J = 0.0f;
    }

    private void m(boolean z4) {
        if (z4 != this.f7406v.isChecked()) {
            this.f7406v.setChecked(z4);
            C0351c c0351c = this.f7370F;
            if (c0351c == null || !c0351c.g()) {
                boolean z5 = this.f7407w;
                this.f7396j = z5 ? this.f7395i : 0;
                this.f7390b = z5 ? 255 : 0;
            }
            if (this.M) {
                this.f7396j = this.f7376N;
                this.f7390b = this.f7377O;
                this.f7374J = this.f7378Q;
                this.f7407w = this.P;
                this.M = false;
                this.f7376N = -1;
                this.f7377O = -1;
                this.f7378Q = -1.0f;
            }
            if (this.f7407w) {
                if (this.f7369E.g()) {
                    this.f7369E.d();
                }
                if (!this.f7368D.g() && !z4) {
                    this.f7374J = 1.0f;
                }
            }
            if (!this.f7407w) {
                if (this.f7368D.g()) {
                    this.f7368D.d();
                }
                if (!this.f7369E.g() && z4) {
                    this.f7374J = 0.0f;
                }
            }
        }
        int i2 = z4 ? this.f7395i : 0;
        f fVar = new f();
        C0351c c0351c2 = this.f7370F;
        if (c0351c2 != null && c0351c2.g()) {
            this.f7370F.d();
        }
        if (z4 != this.f7406v.isChecked()) {
            return;
        }
        C0351c c0351c3 = new C0351c(this.f7406v, this.f7404s, i2);
        this.f7370F = c0351c3;
        c0351c3.p().e(986.96f);
        this.f7370F.p().c(0.7f);
        this.f7370F.c(this.f7380S);
        this.f7370F.b(new miuix.slidingwidget.widget.b(fVar));
        this.f7370F.n();
        if (z4) {
            if (!this.f7368D.g()) {
                this.f7368D.n();
            }
            if (this.f7369E.g()) {
                this.f7369E.d();
                return;
            }
            return;
        }
        if (!this.f7369E.g()) {
            this.f7369E.n();
        }
        if (this.f7368D.g()) {
            this.f7368D.d();
        }
    }

    private Drawable n(Drawable drawable) {
        SmoothContainerDrawable smoothContainerDrawable = new SmoothContainerDrawable();
        smoothContainerDrawable.d(this.f7406v.getLayerType());
        smoothContainerDrawable.c(this.f7384W);
        smoothContainerDrawable.b(drawable);
        int i2 = this.f7386Y;
        int i4 = this.f7385X;
        smoothContainerDrawable.setBounds(new Rect(i2, i4, this.f7392e - i2, this.f7393f - i4));
        return smoothContainerDrawable;
    }

    private void y() {
        if (this.f7408x.g()) {
            this.f7408x.d();
        }
        if (!this.f7409y.g()) {
            this.f7409y.n();
        }
        if (this.f7410z.g()) {
            this.f7410z.d();
        }
        if (!this.f7365A.g()) {
            this.f7365A.n();
        }
        if (this.f7366B.g()) {
            this.f7366B.d();
        }
        if (this.f7406v.isChecked() || this.f7367C.g()) {
            return;
        }
        this.f7367C.n();
    }

    public final void A(boolean z4) {
        this.f7376N = this.f7396j;
        this.f7377O = this.f7390b;
        this.f7378Q = this.f7374J;
        this.P = this.f7407w;
        this.M = true;
        this.f7407w = z4;
        this.f7396j = z4 ? this.f7395i : 0;
        this.f7390b = z4 ? 255 : 0;
        this.f7374J = z4 ? 1.0f : 0.0f;
        C0351c c0351c = this.f7370F;
        if (c0351c != null && c0351c.g()) {
            this.f7370F.d();
        }
        if (this.f7369E.g()) {
            this.f7369E.d();
        }
        if (this.f7368D.g()) {
            this.f7368D.d();
        }
        this.f7406v.invalidate();
    }

    public final void B(int i2) {
        Drawable drawable = this.f7405t;
        if (drawable instanceof SmoothContainerDrawable) {
            ((SmoothContainerDrawable) drawable).d(i2);
        }
        Drawable drawable2 = this.u;
        if (drawable2 instanceof SmoothContainerDrawable) {
            ((SmoothContainerDrawable) drawable2).d(i2);
        }
    }

    public final void C() {
        ViewParent parent = this.f7406v.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).setClipChildren(false);
        }
    }

    public final void D() {
        Drawable drawable = this.f7388a;
        if (drawable != null) {
            drawable.setState(this.f7406v.getDrawableState());
            this.f7402q.setState(this.f7406v.getDrawableState());
        }
    }

    public final void E(int i2) {
        this.f7396j = i2;
        this.f7406v.invalidate();
    }

    public final boolean F(Drawable drawable) {
        return drawable == this.f7402q;
    }

    public final float o() {
        return this.f7387Z;
    }

    public final int p() {
        return this.f7393f;
    }

    public final int q() {
        return this.f7392e;
    }

    public final int r() {
        return this.f7396j;
    }

    public final void s() {
        C0351c c0351c = new C0351c(this.f7406v, this.f7379R, 1.61f);
        this.f7408x = c0351c;
        c0351c.p().e(986.96f);
        this.f7408x.p().c(0.6f);
        this.f7408x.i(0.002f);
        this.f7408x.c(this.f7380S);
        C0351c c0351c2 = new C0351c(this.f7406v, this.f7379R, 1.0f);
        this.f7409y = c0351c2;
        c0351c2.p().e(986.96f);
        this.f7409y.p().c(0.6f);
        this.f7409y.i(0.002f);
        this.f7409y.c(this.f7380S);
        C0351c c0351c3 = new C0351c(this.f7406v, this.f7381T, 1.0f);
        this.f7410z = c0351c3;
        c0351c3.p().e(986.96f);
        this.f7410z.p().c(0.99f);
        this.f7410z.i(0.00390625f);
        this.f7410z.c(this.f7380S);
        C0351c c0351c4 = new C0351c(this.f7406v, this.f7381T, 0.0f);
        this.f7365A = c0351c4;
        c0351c4.p().e(986.96f);
        this.f7365A.p().c(0.99f);
        this.f7365A.i(0.00390625f);
        this.f7365A.c(this.f7380S);
        C0351c c0351c5 = new C0351c(this.f7406v, this.f7382U, 0.15f);
        this.f7366B = c0351c5;
        c0351c5.p().e(986.96f);
        this.f7366B.p().c(0.99f);
        this.f7366B.i(0.00390625f);
        this.f7366B.c(this.f7380S);
        C0351c c0351c6 = new C0351c(this.f7406v, this.f7382U, 0.1f);
        this.f7367C = c0351c6;
        c0351c6.p().e(986.96f);
        this.f7367C.p().c(0.99f);
        this.f7367C.i(0.00390625f);
        this.f7367C.c(this.f7380S);
        C0351c c0351c7 = new C0351c(this.f7406v, this.f7383V, 1.0f);
        this.f7368D = c0351c7;
        c0351c7.p().e(438.64f);
        this.f7368D.p().c(0.99f);
        this.f7368D.i(0.00390625f);
        this.f7368D.c(this.f7380S);
        C0351c c0351c8 = new C0351c(this.f7406v, this.f7383V, 0.0f);
        this.f7369E = c0351c8;
        c0351c8.p().e(986.96f);
        this.f7369E.p().c(0.99f);
        this.f7369E.i(0.00390625f);
        this.f7369E.c(this.f7380S);
    }

    public final void t() {
        this.f7375K = this.f7406v.getResources().getDrawable(R.drawable.miuix_appcompat_sliding_btn_slider_shadow);
        this.L = this.f7406v.getResources().getDrawable(R.drawable.miuix_appcompat_sliding_btn_slider_stroke_light);
    }

    public final void u(Context context, TypedArray typedArray) throws Resources.NotFoundException {
        Resources resources = this.f7406v.getResources();
        this.f7384W = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_frame_corner_radius);
        this.f7385X = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_mask_vertical_padding);
        this.f7386Y = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_mask_horizontal_padding);
        this.f7406v.setDrawingCacheEnabled(false);
        this.f7401o = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f7388a = typedArray.getDrawable(6);
        this.f7391c = typedArray.getDrawable(5);
        this.f7406v.setBackground(typedArray.getDrawable(0));
        Color.parseColor("#FF0D84FF");
        this.d = typedArray.getColor(7, context.getColor(R.color.miuix_appcompat_sliding_button_bar_on_light));
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_frame_vertical_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_frame_horizontal_padding);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_height);
        int dimensionPixelSize4 = (dimensionPixelSize2 * 2) + resources.getDimensionPixelSize(R.dimen.miuix_appcompat_sliding_button_width);
        this.f7392e = dimensionPixelSize4;
        this.f7393f = (dimensionPixelSize * 2) + dimensionPixelSize3;
        this.g = Math.min(dimensionPixelSize4, this.f7388a.getIntrinsicWidth());
        this.f7394h = Math.min(this.f7393f, this.f7388a.getIntrinsicHeight());
        this.f7395i = this.f7392e - this.g;
        this.f7396j = 0;
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(2, typedValue);
        TypedValue typedValue2 = new TypedValue();
        typedArray.getValue(3, typedValue2);
        Drawable drawable = typedArray.getDrawable(2);
        Drawable drawable2 = typedArray.getDrawable(3);
        if (typedValue.type == typedValue2.type && typedValue.data == typedValue2.data && typedValue.resourceId == typedValue2.resourceId) {
            drawable2 = drawable;
        }
        if (drawable2 != null && drawable != null) {
            drawable2.setTint(this.d);
            Drawable drawableN = n(drawable2);
            Drawable drawableN2 = n(drawable);
            this.f7405t = drawableN;
            this.u = drawableN2;
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.setBounds(0, 0, this.f7392e, this.f7393f);
            stateListDrawable.setCallback(this.f7406v);
            this.f7402q = stateListDrawable;
        }
        D();
        if (this.f7406v.isChecked()) {
            E(this.f7395i);
        }
        resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_sliding_button_slider_max_offset);
    }

    public final void v() {
        StateListDrawable stateListDrawable = this.f7402q;
        if (stateListDrawable != null) {
            stateListDrawable.jumpToCurrentState();
        }
    }

    public final void w(Canvas canvas) {
        int intrinsicWidth;
        int intrinsicHeight;
        int i2 = (int) ((this.f7406v.isEnabled() ? 255 : 127) * this.f7387Z);
        float f4 = i2 / 255.0f;
        int i4 = (int) ((1.0f - this.f7374J) * 255.0f * f4);
        if (i4 > 0) {
            this.u.setAlpha(i4);
            this.u.draw(canvas);
        }
        int i5 = (int) (this.f7374J * 255.0f * f4);
        if (i5 > 0) {
            this.f7405t.setAlpha(i5);
            this.f7405t.draw(canvas);
        }
        boolean zB = Y.b(this.f7406v);
        int i6 = zB ? (this.f7392e - this.f7396j) - this.g : this.f7396j;
        float[] fArr = this.f7389a0;
        int i7 = i6 + ((int) fArr[0]);
        int i8 = (zB ? this.f7392e - this.f7396j : this.g + this.f7396j) + ((int) fArr[0]);
        int i9 = this.f7393f;
        int i10 = this.f7394h;
        int i11 = ((i9 - i10) / 2) + ((int) fArr[1]);
        int i12 = i10 + i11;
        int i13 = (i8 + i7) / 2;
        int i14 = (i12 + i11) / 2;
        int i15 = (int) (this.f7372H * 255.0f);
        if (i15 != 0) {
            Drawable drawable = this.f7375K;
            if (drawable instanceof BitmapDrawable) {
                intrinsicWidth = ((BitmapDrawable) drawable).getBitmap().getWidth();
                intrinsicHeight = ((BitmapDrawable) this.f7375K).getBitmap().getHeight();
            } else {
                intrinsicWidth = drawable.getIntrinsicWidth();
                intrinsicHeight = this.f7375K.getIntrinsicHeight();
            }
            int i16 = intrinsicWidth / 2;
            int i17 = intrinsicHeight / 2;
            this.f7375K.setBounds(i13 - i16, i14 - i17, i16 + i13, i17 + i14);
            this.f7375K.setAlpha(i15);
            this.f7375K.draw(canvas);
        }
        canvas.save();
        float f5 = this.f7371G;
        canvas.scale(f5, f5, i13, i14);
        if (this.f7407w) {
            this.f7388a.setAlpha(i2);
            this.f7388a.setBounds(i7, i11, i8, i12);
            this.f7388a.draw(canvas);
        } else {
            this.f7391c.setAlpha(i2);
            this.f7391c.setBounds(i7, i11, i8, i12);
            this.f7391c.draw(canvas);
        }
        this.L.setAlpha((int) (this.f7373I * 255.0f * f4));
        this.L.setBounds(i7, i11, i8, i12);
        this.L.draw(canvas);
        canvas.restore();
    }

    final void x(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        Rect rect = this.p;
        boolean zB = Y.b(this.f7406v);
        rect.set(zB ? (this.f7392e - this.f7396j) - this.g : this.f7396j, 0, zB ? this.f7392e - this.f7396j : this.f7396j + this.g, this.f7393f);
        if (action == 0) {
            if (rect.contains(x2, y2)) {
                this.f7399m = true;
                this.f7406v.setPressed(true);
                if (this.f7409y.g()) {
                    this.f7409y.d();
                }
                if (!this.f7408x.g()) {
                    this.f7408x.n();
                }
                if (!this.f7410z.g()) {
                    this.f7410z.n();
                }
                if (!this.f7406v.isChecked() && !this.f7366B.g()) {
                    this.f7366B.n();
                }
                int i2 = this.f7396j;
                if (i2 > 0 && i2 < this.f7395i) {
                    z = false;
                }
                this.f7403r = z;
            } else {
                this.f7399m = false;
            }
            this.f7397k = x2;
            this.f7398l = x2;
            this.f7400n = false;
            return;
        }
        if (action == 1) {
            this.f7406v.playSoundEffect(0);
            y();
            if (this.f7399m && this.f7400n) {
                z = this.f7396j >= this.f7395i / 2;
                this.f7407w = z;
                m(z);
                if (rect.contains(x2, y2)) {
                    HapticCompat.performHapticFeedback(this.f7406v, miuix.view.c.f7457f);
                }
            } else {
                m(!this.f7406v.isChecked());
                HapticCompat.performHapticFeedback(this.f7406v, miuix.view.c.f7457f);
            }
            this.f7399m = false;
            this.f7400n = false;
            this.f7406v.setPressed(false);
            return;
        }
        if (action != 2) {
            if (action != 3) {
                return;
            }
            y();
            if (this.f7399m) {
                z = this.f7396j >= this.f7395i / 2;
                this.f7407w = z;
                m(z);
            }
            this.f7399m = false;
            this.f7400n = false;
            this.f7406v.setPressed(false);
            return;
        }
        if (this.f7399m) {
            int i4 = x2 - this.f7397k;
            if (Y.b(this.f7406v)) {
                i4 = -i4;
            }
            int i5 = this.f7396j + i4;
            this.f7396j = i5;
            if (i5 < 0) {
                this.f7396j = 0;
            } else {
                int i6 = this.f7395i;
                if (i5 > i6) {
                    this.f7396j = i6;
                }
            }
            int i7 = this.f7396j;
            boolean z4 = i7 == 0 || i7 == this.f7395i;
            if (z4 && !this.f7403r) {
                HapticCompat.performHapticFeedback(this.f7406v, miuix.view.c.f7457f);
            }
            this.f7403r = z4;
            E(this.f7396j);
            this.f7397k = x2;
            if (Math.abs(x2 - this.f7398l) >= this.f7401o) {
                this.f7400n = true;
                this.f7406v.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public final void z(float f4) {
        this.f7387Z = f4;
    }
}
