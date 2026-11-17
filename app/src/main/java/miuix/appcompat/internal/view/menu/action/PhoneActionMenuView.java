package miuix.appcompat.internal.view.menu.action;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import miuix.appcompat.internal.view.menu.action.c;
import w3.C0408a;
import z3.C0432b;

/* loaded from: classes.dex */
public class PhoneActionMenuView extends c {

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f7022y = {R.attr.background, com.android.mmt.R.attr.expandBackground, com.android.mmt.R.attr.splitActionBarOverlayHeight};

    /* renamed from: l, reason: collision with root package name */
    private Context f7023l;

    /* renamed from: m, reason: collision with root package name */
    private View f7024m;

    /* renamed from: n, reason: collision with root package name */
    private View f7025n;

    /* renamed from: o, reason: collision with root package name */
    private int f7026o;
    private Drawable p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f7027q;

    /* renamed from: r, reason: collision with root package name */
    private int f7028r;

    /* renamed from: s, reason: collision with root package name */
    private int f7029s;

    /* renamed from: t, reason: collision with root package name */
    private Rect f7030t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private int f7031v;

    /* renamed from: w, reason: collision with root package name */
    private int f7032w;

    /* renamed from: x, reason: collision with root package name */
    private int f7033x;

    public PhoneActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7026o = 1;
        this.f7031v = 0;
        this.f7032w = 0;
        this.f7033x = 0;
        super.setBackground(null);
        this.f7023l = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7022y);
        this.f7027q = typedArrayObtainStyledAttributes.getDrawable(0);
        this.p = typedArrayObtainStyledAttributes.getDrawable(1);
        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        typedArrayObtainStyledAttributes.recycle();
        i();
        View view = new View(context);
        this.f7025n = view;
        addView(view);
        setChildrenDrawingOrderEnabled(true);
        this.f7031v = context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_action_button_max_width);
        this.f7032w = context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_action_button_gap);
    }

    private void i() {
        if (this.f7030t == null) {
            this.f7030t = new Rect();
        }
        Drawable drawable = this.f7024m == null ? this.f7027q : this.p;
        if (drawable == null) {
            this.f7030t.setEmpty();
        } else {
            drawable.getPadding(this.f7030t);
        }
    }

    private boolean j(View view) {
        return view == this.f7024m || view == this.f7025n;
    }

    @Override // miuix.appcompat.internal.view.menu.action.c
    public final int e() {
        int i2 = this.f7029s;
        if (i2 == 0) {
            return 0;
        }
        return (i2 + this.f7030t.top) - this.u;
    }

    @Override // miuix.appcompat.internal.view.menu.action.c, miuix.appcompat.internal.view.menu.MenuView
    public final boolean filterLeftoverView(int i2) {
        c.a aVar;
        View childAt = getChildAt(i2);
        if (!(!j(childAt) && ((aVar = (c.a) childAt.getLayoutParams()) == null || !aVar.f7057a))) {
            return false;
        }
        super.filterLeftoverView(i2);
        return true;
    }

    @Override // miuix.appcompat.internal.view.menu.action.c
    public final void g(float f4, boolean z4, boolean z5) {
        int i2 = C0432b.f8169a;
        setAlpha(a(f4, z4, z5));
        float fB = b(f4, z4, z5);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (!j(childAt)) {
                childAt.setTranslationY(fB);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected final int getChildDrawingOrder(int i2, int i4) {
        int iIndexOfChild = indexOfChild(this.f7024m);
        int iIndexOfChild2 = indexOfChild(this.f7025n);
        if (i4 == 0) {
            if (iIndexOfChild != -1) {
                return iIndexOfChild;
            }
            if (iIndexOfChild2 != -1) {
                return iIndexOfChild2;
            }
        } else if (i4 == 1 && iIndexOfChild != -1 && iIndexOfChild2 != -1) {
            return iIndexOfChild2;
        }
        int i5 = 0;
        while (i5 < i2) {
            if (i5 != iIndexOfChild && i5 != iIndexOfChild2) {
                int i6 = i5 < iIndexOfChild ? i5 + 1 : i5;
                if (i5 < iIndexOfChild2) {
                    i6++;
                }
                if (i6 == i4) {
                    return i5;
                }
            }
            i5++;
        }
        return super.getChildDrawingOrder(i2, i4);
    }

    @Override // miuix.appcompat.internal.view.menu.action.c, miuix.appcompat.internal.view.menu.MenuView
    public final boolean hasBackgroundView() {
        return getChildAt(0) == this.f7025n || getChildAt(1) == this.f7025n;
    }

    public final boolean k() {
        int i2 = this.f7026o;
        return i2 == 2 || i2 == 3;
    }

    @Override // miuix.appcompat.internal.view.menu.action.c, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f7032w = this.f7023l.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_action_button_gap);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int i7;
        int i8 = i5 - i2;
        int i9 = i6 - i4;
        View view = this.f7024m;
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            S2.d.k(this, this.f7024m, 0, 0, i8, measuredHeight);
            i7 = measuredHeight - this.f7030t.top;
        } else {
            i7 = 0;
        }
        S2.d.k(this, this.f7025n, 0, i7, i8, i9);
        int childCount = getChildCount();
        int measuredWidth = (i8 - this.f7028r) >> 1;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (!j(childAt)) {
                S2.d.k(this, childAt, measuredWidth, i7, childAt.getMeasuredWidth() + measuredWidth, i9);
                measuredWidth = childAt.getMeasuredWidth() + this.f7032w + measuredWidth;
            }
        }
    }

    @Override // miuix.appcompat.internal.view.menu.action.c, android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        if (indexOfChild(this.f7024m) != -1) {
            childCount2--;
        }
        if (indexOfChild(this.f7025n) != -1) {
            childCount2--;
        }
        this.f7033x = childCount2;
        if (childCount == 0 || childCount2 == 0) {
            this.f7029s = 0;
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int iMin = Math.min(size / this.f7033x, this.f7031v);
        this.f7031v = iMin;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        int iMin2 = 0;
        int measuredHeight = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (!j(childAt)) {
                measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i4, 0);
                iMin2 += Math.min(childAt.getMeasuredWidth(), this.f7031v);
                measuredHeight = Math.max(measuredHeight, childAt.getMeasuredHeight());
            }
        }
        int i6 = this.f7032w;
        int i7 = this.f7033x - 1;
        if ((i6 * i7) + iMin2 > size) {
            this.f7032w = 0;
        }
        int i8 = (i7 * this.f7032w) + iMin2;
        this.f7028r = i8;
        this.f7029s = measuredHeight;
        View view = this.f7024m;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin = C0408a.a(this.f7023l);
            marginLayoutParams.bottomMargin = this.f7029s;
            measureChildWithMargins(this.f7024m, i2, 0, i4, 0);
            Math.max(i8, this.f7024m.getMeasuredWidth());
            measuredHeight += this.f7024m.getMeasuredHeight();
            int i9 = this.f7026o;
            if (i9 == 3) {
                this.f7024m.setTranslationY(0.0f);
            } else if (i9 == 1) {
                this.f7024m.setTranslationY(measuredHeight);
            }
        }
        if (this.f7024m == null) {
            measuredHeight += this.f7030t.top;
        }
        this.f7025n.setBackground(this.f7026o == 1 ? this.f7027q : this.p);
        setMeasuredDimension(size, measuredHeight);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float y2 = motionEvent.getY();
        View view = this.f7024m;
        return y2 > (view == null ? 0.0f : view.getTranslationY()) || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setAlpha(float f4) {
        super.setAlpha(f4);
    }

    @Override // android.view.View
    public final void setBackground(Drawable drawable) {
        if (this.f7027q != drawable) {
            this.f7027q = drawable;
            i();
        }
    }
}
