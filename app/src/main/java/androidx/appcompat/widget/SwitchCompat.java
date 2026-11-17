package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import k.C0339a;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: U, reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f2867U = new a();

    /* renamed from: V, reason: collision with root package name */
    private static final int[] f2868V = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    private int f2869A;

    /* renamed from: B, reason: collision with root package name */
    private float f2870B;

    /* renamed from: C, reason: collision with root package name */
    private float f2871C;

    /* renamed from: D, reason: collision with root package name */
    private VelocityTracker f2872D;

    /* renamed from: E, reason: collision with root package name */
    private int f2873E;

    /* renamed from: F, reason: collision with root package name */
    float f2874F;

    /* renamed from: G, reason: collision with root package name */
    private int f2875G;

    /* renamed from: H, reason: collision with root package name */
    private int f2876H;

    /* renamed from: I, reason: collision with root package name */
    private int f2877I;

    /* renamed from: J, reason: collision with root package name */
    private int f2878J;

    /* renamed from: K, reason: collision with root package name */
    private int f2879K;
    private int L;
    private int M;

    /* renamed from: N, reason: collision with root package name */
    private final TextPaint f2880N;

    /* renamed from: O, reason: collision with root package name */
    private ColorStateList f2881O;
    private StaticLayout P;

    /* renamed from: Q, reason: collision with root package name */
    private StaticLayout f2882Q;

    /* renamed from: R, reason: collision with root package name */
    private C0339a f2883R;

    /* renamed from: S, reason: collision with root package name */
    ObjectAnimator f2884S;

    /* renamed from: T, reason: collision with root package name */
    private final Rect f2885T;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f2886i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f2887j;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f2888k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2889l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2890m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f2891n;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f2892o;
    private PorterDuff.Mode p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2893q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2894r;

    /* renamed from: s, reason: collision with root package name */
    private int f2895s;

    /* renamed from: t, reason: collision with root package name */
    private int f2896t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f2897v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f2898w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f2899x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f2900y;

    /* renamed from: z, reason: collision with root package name */
    private int f2901z;

    final class a extends Property<SwitchCompat, Float> {
        a() {
            super(Float.class, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f2874F);
        }

        @Override // android.util.Property
        public final void set(SwitchCompat switchCompat, Float f4) {
            switchCompat.g(f4.floatValue());
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.android.mmt.R.attr.switchStyle);
    }

    private int a() {
        return (int) (((Y.b(this) ? 1.0f - this.f2874F : this.f2874F) * b()) + 0.5f);
    }

    private int b() {
        Drawable drawable = this.f2891n;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f2885T;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f2886i;
        Rect rectB = drawable2 != null ? C.b(drawable2) : C.f2715a;
        return ((((this.f2875G - this.f2877I) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    private Layout c(CharSequence charSequence) {
        C0339a c0339a = this.f2883R;
        if (c0339a != null) {
            charSequence = c0339a.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.f2880N, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public final void d(Typeface typeface) {
        if ((this.f2880N.getTypeface() == null || this.f2880N.getTypeface().equals(typeface)) && (this.f2880N.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f2880N.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i2;
        int i4;
        Rect rect = this.f2885T;
        int i5 = this.f2878J;
        int i6 = this.f2879K;
        int i7 = this.L;
        int i8 = this.M;
        int iA = a() + i5;
        Drawable drawable = this.f2886i;
        Rect rectB = drawable != null ? C.b(drawable) : C.f2715a;
        Drawable drawable2 = this.f2891n;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i9 = rect.left;
            iA += i9;
            if (rectB != null) {
                int i10 = rectB.left;
                if (i10 > i9) {
                    i5 += i10 - i9;
                }
                int i11 = rectB.top;
                int i12 = rect.top;
                i2 = i11 > i12 ? (i11 - i12) + i6 : i6;
                int i13 = rectB.right;
                int i14 = rect.right;
                if (i13 > i14) {
                    i7 -= i13 - i14;
                }
                int i15 = rectB.bottom;
                int i16 = rect.bottom;
                if (i15 > i16) {
                    i4 = i8 - (i15 - i16);
                }
                this.f2891n.setBounds(i5, i2, i7, i4);
            } else {
                i2 = i6;
            }
            i4 = i8;
            this.f2891n.setBounds(i5, i2, i7, i4);
        }
        Drawable drawable3 = this.f2886i;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i17 = iA - rect.left;
            int i18 = iA + this.f2877I + rect.right;
            this.f2886i.setBounds(i17, i6, i18, i8);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i17, i6, i18, i8);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f2886i;
        if (drawable != null) {
            drawable.setHotspot(f4, f5);
        }
        Drawable drawable2 = this.f2891n;
        if (drawable2 != null) {
            drawable2.setHotspot(f4, f5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2886i;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f2891n;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(CharSequence charSequence) throws Resources.NotFoundException {
        this.f2899x = charSequence;
        requestLayout();
        if (isChecked()) {
            return;
        }
        CharSequence string = this.f2899x;
        if (string == null) {
            string = getResources().getString(com.android.mmt.R.string.abc_capital_off);
        }
        androidx.core.view.o.m(this, string);
    }

    public final void f(CharSequence charSequence) throws Resources.NotFoundException {
        this.f2898w = charSequence;
        requestLayout();
        if (isChecked()) {
            CharSequence string = this.f2898w;
            if (string == null) {
                string = getResources().getString(com.android.mmt.R.string.abc_capital_on);
            }
            androidx.core.view.o.m(this, string);
        }
    }

    final void g(float f4) {
        this.f2874F = f4;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public final int getCompoundPaddingLeft() {
        if (!Y.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2875G;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.u : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public final int getCompoundPaddingRight() {
        if (Y.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2875G;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.u : compoundPaddingRight;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2886i;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2891n;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f2884S;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f2884S.end();
        this.f2884S = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2868V);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f2885T;
        Drawable drawable = this.f2891n;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.f2879K;
        int i4 = this.M;
        int i5 = i2 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f2886i;
        if (drawable != null) {
            if (!this.f2897v || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = C.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = (this.f2874F > 0.5f ? 1 : (this.f2874F == 0.5f ? 0 : -1)) > 0 ? this.P : this.f2882Q;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f2881O;
            if (colorStateList != null) {
                this.f2880N.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f2880N.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i5 + i6) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z4, i2, i4, i5, i6);
        int iMax2 = 0;
        if (this.f2886i != null) {
            Rect rect = this.f2885T;
            Drawable drawable = this.f2891n;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = C.b(this.f2886i);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        if (Y.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f2875G + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f2875G) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i7 = this.f2876H;
            int i8 = height2 - (i7 / 2);
            height = i7 + i8;
            paddingTop = i8;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.f2876H + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.f2876H;
        }
        this.f2878J = paddingLeft;
        this.f2879K = paddingTop;
        this.M = height;
        this.L = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i4) {
        int intrinsicWidth;
        int intrinsicHeight;
        int iMax;
        if (this.f2900y) {
            if (this.P == null) {
                this.P = (StaticLayout) c(this.f2898w);
            }
            if (this.f2882Q == null) {
                this.f2882Q = (StaticLayout) c(this.f2899x);
            }
        }
        Rect rect = this.f2885T;
        Drawable drawable = this.f2886i;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f2886i.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2886i.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        if (this.f2900y) {
            iMax = (this.f2895s * 2) + Math.max(this.P.getWidth(), this.f2882Q.getWidth());
        } else {
            iMax = 0;
        }
        this.f2877I = Math.max(iMax, intrinsicWidth);
        Drawable drawable2 = this.f2891n;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f2891n.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax2 = rect.left;
        int iMax3 = rect.right;
        Drawable drawable3 = this.f2886i;
        if (drawable3 != null) {
            Rect rectB = C.b(drawable3);
            iMax2 = Math.max(iMax2, rectB.left);
            iMax3 = Math.max(iMax3, rectB.right);
        }
        int iMax4 = Math.max(this.f2896t, (this.f2877I * 2) + iMax2 + iMax3);
        int iMax5 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f2875G = iMax4;
        this.f2876H = iMax5;
        super.onMeasure(i2, i4);
        if (getMeasuredHeight() < iMax5) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax5);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f2898w : this.f2899x;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        boolean z4;
        this.f2872D.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z5 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.f2901z == 2) {
                    this.f2901z = 0;
                    boolean z6 = motionEvent.getAction() == 1 && isEnabled();
                    boolean zIsChecked = isChecked();
                    if (z6) {
                        this.f2872D.computeCurrentVelocity(1000);
                        float xVelocity = this.f2872D.getXVelocity();
                        z4 = Math.abs(xVelocity) <= ((float) this.f2873E) ? this.f2874F > 0.5f : !(!Y.b(this) ? xVelocity > 0.0f : xVelocity < 0.0f);
                    } else {
                        z4 = zIsChecked;
                    }
                    if (z4 != zIsChecked) {
                        playSoundEffect(0);
                    }
                    setChecked(z4);
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.f2901z = 0;
                this.f2872D.clear();
            } else if (actionMasked == 2) {
                int i2 = this.f2901z;
                if (i2 == 1) {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    if (Math.abs(x2 - this.f2870B) > this.f2869A || Math.abs(y2 - this.f2871C) > this.f2869A) {
                        this.f2901z = 2;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        this.f2870B = x2;
                        this.f2871C = y2;
                        return true;
                    }
                } else if (i2 == 2) {
                    float x4 = motionEvent.getX();
                    int iB = b();
                    float f4 = x4 - this.f2870B;
                    float f5 = iB != 0 ? f4 / iB : f4 > 0.0f ? 1.0f : -1.0f;
                    if (Y.b(this)) {
                        f5 = -f5;
                    }
                    float f6 = this.f2874F;
                    float f7 = f5 + f6;
                    float f8 = f7 >= 0.0f ? f7 > 1.0f ? 1.0f : f7 : 0.0f;
                    if (f8 != f6) {
                        this.f2870B = x4;
                        g(f8);
                    }
                    return true;
                }
            } else if (actionMasked == 3) {
            }
        } else {
            float x5 = motionEvent.getX();
            float y4 = motionEvent.getY();
            if (isEnabled()) {
                if (this.f2886i != null) {
                    int iA = a();
                    this.f2886i.getPadding(this.f2885T);
                    int i4 = this.f2879K;
                    int i5 = this.f2869A;
                    int i6 = i4 - i5;
                    int i7 = (this.f2878J + iA) - i5;
                    int i8 = this.f2877I + i7;
                    Rect rect = this.f2885T;
                    int i9 = i8 + rect.left + rect.right + i5;
                    int i10 = this.M + i5;
                    if (x5 > i7 && x5 < i9 && y4 > i6 && y4 < i10) {
                        z5 = true;
                    }
                }
                if (z5) {
                    this.f2901z = 1;
                    this.f2870B = x5;
                    this.f2871C = y4;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) throws Resources.NotFoundException {
        super.setChecked(z4);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            CharSequence string = this.f2898w;
            if (string == null) {
                string = getResources().getString(com.android.mmt.R.string.abc_capital_on);
            }
            androidx.core.view.o.m(this, string);
        } else {
            CharSequence string2 = this.f2899x;
            if (string2 == null) {
                string2 = getResources().getString(com.android.mmt.R.string.abc_capital_off);
            }
            androidx.core.view.o.m(this, string2);
        }
        if (getWindowToken() != null) {
            int i2 = androidx.core.view.o.d;
            if (isLaidOut()) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f2867U, zIsChecked ? 1.0f : 0.0f);
                this.f2884S = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(250L);
                this.f2884S.setAutoCancel(true);
                this.f2884S.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.f2884S;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        g(zIsChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2886i || drawable == this.f2891n;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        Drawable drawable;
        Drawable drawable2;
        super(context, attributeSet, i2);
        this.f2887j = null;
        this.f2888k = null;
        this.f2889l = false;
        this.f2890m = false;
        this.f2892o = null;
        this.p = null;
        this.f2893q = false;
        this.f2894r = false;
        this.f2872D = VelocityTracker.obtain();
        this.f2885T = new Rect();
        O.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f2880N = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = Y1.a.f2083A;
        U u = U.u(context, attributeSet, iArr, i2, 0);
        androidx.core.view.o.i(this, context, iArr, attributeSet, u.q(), i2);
        Drawable drawableF = u.f(2);
        this.f2886i = drawableF;
        if (drawableF != null) {
            drawableF.setCallback(this);
        }
        Drawable drawableF2 = u.f(11);
        this.f2891n = drawableF2;
        if (drawableF2 != null) {
            drawableF2.setCallback(this);
        }
        this.f2898w = u.o(0);
        this.f2899x = u.o(1);
        this.f2900y = u.a(3, true);
        this.f2895s = u.e(8, 0);
        this.f2896t = u.e(5, 0);
        this.u = u.e(6, 0);
        this.f2897v = u.a(4, false);
        ColorStateList colorStateListC = u.c(9);
        if (colorStateListC != null) {
            this.f2887j = colorStateListC;
            this.f2889l = true;
        }
        PorterDuff.Mode modeC = C.c(u.j(10, -1), null);
        if (this.f2888k != modeC) {
            this.f2888k = modeC;
            this.f2890m = true;
        }
        boolean z4 = this.f2889l;
        if ((z4 || this.f2890m) && (drawable = this.f2886i) != null && (z4 || this.f2890m)) {
            Drawable drawableMutate = drawable.mutate();
            this.f2886i = drawableMutate;
            if (this.f2889l) {
                drawableMutate.setTintList(this.f2887j);
            }
            if (this.f2890m) {
                this.f2886i.setTintMode(this.f2888k);
            }
            if (this.f2886i.isStateful()) {
                this.f2886i.setState(getDrawableState());
            }
        }
        ColorStateList colorStateListC2 = u.c(12);
        if (colorStateListC2 != null) {
            this.f2892o = colorStateListC2;
            this.f2893q = true;
        }
        PorterDuff.Mode modeC2 = C.c(u.j(13, -1), null);
        if (this.p != modeC2) {
            this.p = modeC2;
            this.f2894r = true;
        }
        boolean z5 = this.f2893q;
        if ((z5 || this.f2894r) && (drawable2 = this.f2891n) != null && (z5 || this.f2894r)) {
            Drawable drawableMutate2 = drawable2.mutate();
            this.f2891n = drawableMutate2;
            if (this.f2893q) {
                drawableMutate2.setTintList(this.f2892o);
            }
            if (this.f2894r) {
                this.f2891n.setTintMode(this.p);
            }
            if (this.f2891n.isStateful()) {
                this.f2891n.setState(getDrawableState());
            }
        }
        int iM = u.m(7, 0);
        if (iM != 0) {
            U uS = U.s(context, iM, Y1.a.f2084B);
            ColorStateList colorStateListC3 = uS.c(3);
            if (colorStateListC3 != null) {
                this.f2881O = colorStateListC3;
            } else {
                this.f2881O = getTextColors();
            }
            int iE = uS.e(0, 0);
            if (iE != 0) {
                float f4 = iE;
                if (f4 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f4);
                    requestLayout();
                }
            }
            int iJ = uS.j(1, -1);
            int iJ2 = uS.j(2, -1);
            Typeface typeface = iJ != 1 ? iJ != 2 ? iJ != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (iJ2 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(iJ2) : Typeface.create(typeface, iJ2);
                d(typefaceDefaultFromStyle);
                int i4 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & iJ2;
                textPaint.setFakeBoldText((i4 & 1) != 0);
                textPaint.setTextSkewX((i4 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                d(typeface);
            }
            if (uS.a(14, false)) {
                this.f2883R = new C0339a(getContext());
            } else {
                this.f2883R = null;
            }
            uS.v();
        }
        new C0202x(this).f(attributeSet, i2);
        u.v();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2869A = viewConfiguration.getScaledTouchSlop();
        this.f2873E = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }
}
