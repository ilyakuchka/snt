package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private boolean f2635i;

    /* renamed from: j, reason: collision with root package name */
    private View f2636j;

    /* renamed from: k, reason: collision with root package name */
    private View f2637k;

    /* renamed from: l, reason: collision with root package name */
    Drawable f2638l;

    /* renamed from: m, reason: collision with root package name */
    Drawable f2639m;

    /* renamed from: n, reason: collision with root package name */
    Drawable f2640n;

    /* renamed from: o, reason: collision with root package name */
    boolean f2641o;
    boolean p;

    /* renamed from: q, reason: collision with root package name */
    private int f2642q;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0181b c0181b = new C0181b(this);
        int i2 = androidx.core.view.o.d;
        setBackground(c0181b);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2114f);
        this.f2638l = typedArrayObtainStyledAttributes.getDrawable(20);
        this.f2639m = typedArrayObtainStyledAttributes.getDrawable(22);
        this.f2642q = typedArrayObtainStyledAttributes.getDimensionPixelSize(37, -1);
        boolean z4 = true;
        if (getId() == R.id.split_action_bar) {
            this.f2641o = true;
            this.f2640n = typedArrayObtainStyledAttributes.getDrawable(21);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f2641o ? this.f2638l != null || this.f2639m != null : this.f2640n != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
    }

    public final void a(boolean z4) {
        this.f2635i = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2638l;
        if (drawable != null && drawable.isStateful()) {
            this.f2638l.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2639m;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2639m.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2640n;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2640n.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2638l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2639m;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2640n;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2636j = findViewById(R.id.action_bar);
        this.f2637k = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2635i || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        boolean z5 = false;
        boolean z6 = true;
        if (this.f2641o) {
            Drawable drawable = this.f2640n;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            if (z6) {
                return;
            }
            invalidate();
            return;
        }
        if (this.f2638l == null) {
            z6 = false;
        } else if (this.f2636j.getVisibility() == 0) {
            this.f2638l.setBounds(this.f2636j.getLeft(), this.f2636j.getTop(), this.f2636j.getRight(), this.f2636j.getBottom());
        } else {
            View view = this.f2637k;
            if (view == null || view.getVisibility() != 0) {
                this.f2638l.setBounds(0, 0, 0, 0);
            } else {
                this.f2638l.setBounds(this.f2637k.getLeft(), this.f2637k.getTop(), this.f2637k.getRight(), this.f2637k.getBottom());
            }
        }
        this.p = false;
        z5 = z6;
        z6 = z5;
        if (z6) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i4) {
        int i5;
        if (this.f2636j == null && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE && (i5 = this.f2642q) >= 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i4)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i4);
        if (this.f2636j == null) {
            return;
        }
        View.MeasureSpec.getMode(i4);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public final void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z4 = i2 == 0;
        Drawable drawable = this.f2638l;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f2639m;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f2640n;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    protected final boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2638l && !this.f2641o) || (drawable == this.f2639m && this.p) || ((drawable == this.f2640n && this.f2641o) || super.verifyDrawable(drawable));
    }
}
