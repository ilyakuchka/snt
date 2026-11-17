package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.F;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements m.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: i, reason: collision with root package name */
    h f2457i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f2458j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f2459k;

    /* renamed from: l, reason: collision with root package name */
    f.b f2460l;

    /* renamed from: m, reason: collision with root package name */
    private F f2461m;

    /* renamed from: n, reason: collision with root package name */
    b f2462n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2463o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f2464q;

    /* renamed from: r, reason: collision with root package name */
    private int f2465r;

    private class a extends F {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.F
        public final m.b b() {
            b bVar = ActionMenuItemView.this.f2462n;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.F
        protected final boolean c() {
            m.b bVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            f.b bVar = actionMenuItemView.f2460l;
            return bVar != null && bVar.a(actionMenuItemView.f2457i) && (bVarB = b()) != null && bVarB.isShowing();
        }
    }

    public static abstract class b {
        public abstract m.b a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f2458j);
        if (this.f2459k != null && (!this.f2457i.v() || !this.f2463o)) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        setText(z6 ? this.f2458j : null);
        CharSequence contentDescription = this.f2457i.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z6 ? null : this.f2457i.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f2457i.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            setTooltipText(z6 ? null : this.f2457i.getTitle());
        } else {
            setTooltipText(tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean a() {
        return d();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public final void b(h hVar) {
        this.f2457i = hVar;
        Drawable icon = hVar.getIcon();
        this.f2459k = icon;
        if (icon != null) {
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            int i2 = this.f2465r;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            icon.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(icon, null, null, null);
        h();
        this.f2458j = hVar.h(this);
        h();
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.f2461m == null) {
            this.f2461m = new a();
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean c() {
        return d() && this.f2457i.getIcon() == null;
    }

    public final boolean d() {
        return !TextUtils.isEmpty(getText());
    }

    public final void e(f.b bVar) {
        this.f2460l = bVar;
    }

    public final void f(b bVar) {
        this.f2462n = bVar;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public final h getItemData() {
        return this.f2457i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        f.b bVar = this.f2460l;
        if (bVar != null) {
            bVar.a(this.f2457i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2463o = g();
        h();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected final void onMeasure(int i2, int i4) {
        int i5;
        boolean zD = d();
        if (zD && (i5 = this.f2464q) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i4);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.p) : this.p;
        if (mode != 1073741824 && this.p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i4);
        }
        if (zD || this.f2459k == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2459k.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        F f4;
        if (this.f2457i.hasSubMenu() && (f4 = this.f2461m) != null && f4.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public final boolean prefersCondensedTitle() {
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i2, int i4, int i5, int i6) {
        this.f2464q = i2;
        super.setPadding(i2, i4, i5, i6);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f2463o = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2115h, 0, 0);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f2465r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f2464q = -1;
        setSaveEnabled(false);
    }
}
