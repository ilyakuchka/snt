package miuix.androidbasewidget.widget;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Y;
import androidx.core.view.o;
import java.lang.ref.WeakReference;
import java.util.List;
import miuix.view.HapticCompat;

/* loaded from: classes.dex */
public class ClearableEditText extends miuix.androidbasewidget.widget.b {
    private static final int[] u = {R.attr.state_empty};

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f6608v = 0;
    private Drawable p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6609q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6610r;

    /* renamed from: s, reason: collision with root package name */
    private b f6611s;

    /* renamed from: t, reason: collision with root package name */
    private a f6612t;

    private class a extends J.a {

        /* renamed from: l, reason: collision with root package name */
        private final Rect f6613l;

        /* renamed from: m, reason: collision with root package name */
        private final View f6614m;

        public a(View view) {
            super(view);
            this.f6613l = new Rect();
            this.f6614m = view;
        }

        @Override // J.a
        protected final int d(float f4) {
            if (!ClearableEditText.this.f6610r) {
                return Integer.MIN_VALUE;
            }
            int intrinsicWidth = ClearableEditText.this.p == null ? 0 : ClearableEditText.this.p.getIntrinsicWidth();
            boolean z4 = true;
            if (!Y.b(ClearableEditText.this) ? f4 <= (ClearableEditText.this.getWidth() - (ClearableEditText.this.getPaddingRight() * 2)) - intrinsicWidth : f4 >= (ClearableEditText.this.getPaddingLeft() * 2) + intrinsicWidth) {
                z4 = false;
            }
            return z4 ? 0 : Integer.MIN_VALUE;
        }

        @Override // J.a
        protected final void e(List list) {
            if (ClearableEditText.this.f6610r) {
                list.add(0);
            }
        }

        @Override // J.a
        protected final boolean h(int i2, int i4) {
            if (i2 == Integer.MIN_VALUE || i4 != 16) {
                return false;
            }
            ClearableEditText clearableEditText = ClearableEditText.this;
            int i5 = ClearableEditText.f6608v;
            clearableEditText.setText("");
            HapticCompat.performHapticFeedback(clearableEditText, miuix.view.c.d);
            View view = this.f6614m;
            if (view == null || !ClearableEditText.this.j(view.getContext())) {
                return true;
            }
            this.f6614m.sendAccessibilityEvent(32768);
            return true;
        }

        @Override // J.a
        protected final void i(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(ClearableEditText.this.getResources().getString(com.android.mmt.R.string.clearable_edittext_clear_description));
        }

        @Override // J.a
        protected final void j(F.b bVar) {
            if (ClearableEditText.this.f6610r) {
                bVar.E(ClearableEditText.class.getName());
            }
        }

        @Override // J.a
        protected final void k(F.b bVar) {
            bVar.Y();
            bVar.I(ClearableEditText.this.getResources().getString(com.android.mmt.R.string.clearable_edittext_clear_description));
            bVar.a(16);
            bVar.E(Button.class.getName());
            Rect rect = this.f6613l;
            this.f6614m.getLocalVisibleRect(rect);
            int intrinsicWidth = ClearableEditText.this.p == null ? 0 : ClearableEditText.this.p.getIntrinsicWidth();
            if (Y.b(ClearableEditText.this)) {
                rect.right -= (ClearableEditText.this.getWidth() - intrinsicWidth) - (ClearableEditText.this.getPaddingLeft() * 2);
            } else {
                rect.left = ((ClearableEditText.this.getWidth() - (ClearableEditText.this.getPaddingRight() * 2)) - intrinsicWidth) + rect.left;
            }
            bVar.A(this.f6613l);
            bVar.F(true);
        }
    }

    static class b implements TextWatcher {

        /* renamed from: i, reason: collision with root package name */
        WeakReference<ClearableEditText> f6616i;

        b(ClearableEditText clearableEditText) {
            this.f6616i = new WeakReference<>(clearableEditText);
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            ClearableEditText clearableEditText = this.f6616i.get();
            if (clearableEditText == null) {
                return;
            }
            if (clearableEditText.f6610r != (editable.length() > 0)) {
                clearableEditText.f6610r = !clearableEditText.f6610r;
                clearableEditText.refreshDrawableState();
                if (clearableEditText.f6612t != null) {
                    clearableEditText.f6612t.f();
                }
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.android.mmt.R.attr.clearableEditTextStyle);
        this.f6611s = new b(this);
        this.p = getCompoundDrawablesRelative()[2];
        a aVar = new a(this);
        this.f6612t = aVar;
        o.j(this, aVar);
        setForceDarkAllowed(false);
        Editable text = getText();
        if (text != null) {
            if (this.f6610r != (text.length() > 0)) {
                this.f6610r = !this.f6610r;
                refreshDrawableState();
            }
        }
    }

    private boolean k(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3 && this.f6609q) {
                    this.f6609q = false;
                }
            } else if (isEnabled() && this.f6609q) {
                setText("");
                HapticCompat.performHapticFeedback(this, miuix.view.c.d);
                if (j(getContext())) {
                    sendAccessibilityEvent(32768);
                }
                this.f6609q = false;
                return true;
            }
        } else if (isEnabled() && this.f6610r) {
            this.f6609q = true;
        }
        return this.f6609q;
    }

    @Override // android.view.View
    protected final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f6612t;
        if (aVar != null && this.f6610r && aVar.c(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zK;
        if (this.f6610r) {
            Drawable drawable = this.p;
            int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
            if (Y.b(this)) {
                if (motionEvent.getX() < getPaddingLeft() + intrinsicWidth) {
                    zK = k(motionEvent);
                }
            } else if (motionEvent.getX() > (getWidth() - getPaddingRight()) - intrinsicWidth) {
                zK = k(motionEvent);
            }
        } else {
            this.f6609q = false;
            zK = false;
        }
        return zK || super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.C0188i, android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.p != null) {
            this.p.setState(getDrawableState());
            invalidate();
        }
    }

    public final boolean j(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        addTextChangedListener(this.f6611s);
    }

    @Override // android.widget.TextView, android.view.View
    protected final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (!this.f6610r) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, u);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeTextChangedListener(this.f6611s);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        Editable text = getText();
        if (text != null) {
            if (this.f6610r != (text.length() > 0)) {
                this.f6610r = !this.f6610r;
                refreshDrawableState();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            throw new IllegalStateException("ClearableEditText can only set drawables by setCompoundDrawablesRelative()");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.p = drawable3;
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView, android.view.View
    protected final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }
}
