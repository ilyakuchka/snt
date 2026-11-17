package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.android.mmt.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0180a extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    protected final C0058a f2972i;

    /* renamed from: j, reason: collision with root package name */
    protected final Context f2973j;

    /* renamed from: k, reason: collision with root package name */
    protected ActionMenuView f2974k;

    /* renamed from: l, reason: collision with root package name */
    protected C0182c f2975l;

    /* renamed from: m, reason: collision with root package name */
    protected int f2976m;

    /* renamed from: n, reason: collision with root package name */
    protected androidx.core.view.t f2977n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2978o;
    private boolean p;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0058a implements androidx.core.view.u {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2979a = false;

        /* renamed from: b, reason: collision with root package name */
        int f2980b;

        protected C0058a() {
        }

        @Override // androidx.core.view.u
        public final void a() {
            if (this.f2979a) {
                return;
            }
            AbstractC0180a abstractC0180a = AbstractC0180a.this;
            abstractC0180a.f2977n = null;
            AbstractC0180a.super.setVisibility(this.f2980b);
        }

        @Override // androidx.core.view.u
        public final void b(View view) {
            this.f2979a = true;
        }

        @Override // androidx.core.view.u
        public final void c() {
            AbstractC0180a.super.setVisibility(0);
            this.f2979a = false;
        }
    }

    AbstractC0180a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected final int c(View view, int i2, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i4);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - 0);
    }

    protected final int d(View view, int i2, int i4, int i5, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = ((i5 - measuredHeight) / 2) + i4;
        if (z4) {
            view.layout(i2 - measuredWidth, i6, i2, measuredHeight + i6);
        } else {
            view.layout(i2, i6, i2 + measuredWidth, measuredHeight + i6);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public void e(int i2) {
        this.f2976m = i2;
        requestLayout();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, Y1.a.f2114f, R.attr.actionBarStyle, 0);
        e(typedArrayObtainStyledAttributes.getLayoutDimension(37, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0182c c0182c = this.f2975l;
        if (c0182c != null) {
            c0182c.w();
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.p = false;
        }
        if (!this.p) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.p = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.p = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2978o = false;
        }
        if (!this.f2978o) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2978o = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2978o = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            androidx.core.view.t tVar = this.f2977n;
            if (tVar != null) {
                tVar.b();
            }
            super.setVisibility(i2);
        }
    }

    AbstractC0180a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2972i = new C0058a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f2973j = context;
        } else {
            this.f2973j = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
