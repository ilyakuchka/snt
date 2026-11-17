package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.android.mmt.R;
import java.util.ArrayList;
import t.C0384b;

/* renamed from: androidx.fragment.app.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0221q extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<View> f3573i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<View> f3574j;

    /* renamed from: k, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f3575k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3576l;

    C0221q(Context context, AttributeSet attributeSet, w wVar) {
        super(context, attributeSet);
        this.f3576l = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7876f);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentS = wVar.S(id);
        if (classAttribute != null && fragmentS == null) {
            if (id <= 0) {
                throw new IllegalStateException(C2.c.a("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? D2.e.c(" with tag ", string) : ""));
            }
            Fragment fragmentA = wVar.Y().a(context.getClassLoader(), classAttribute);
            fragmentA.m0();
            C0205a c0205a = new C0205a(wVar);
            c0205a.p = true;
            fragmentA.f3417N = this;
            c0205a.k(getId(), fragmentA, string, 1);
            if (c0205a.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            c0205a.f3388h = false;
            c0205a.f3495q.N(c0205a);
        }
        wVar.r0(this);
    }

    private void a(View view) {
        ArrayList<View> arrayList = this.f3574j;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f3573i == null) {
            this.f3573i = new ArrayList<>();
        }
        this.f3573i.add(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected final boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z4) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z4);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    final void b(boolean z4) {
        this.f3576l = z4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        androidx.core.view.w wVarO = androidx.core.view.w.o(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f3575k;
        androidx.core.view.w wVarO2 = onApplyWindowInsetsListener != null ? androidx.core.view.w.o(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets), null) : androidx.core.view.o.g(this, wVarO);
        if (!wVarO2.k()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                androidx.core.view.o.c(getChildAt(i2), wVarO2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        if (this.f3576l && this.f3573i != null) {
            for (int i2 = 0; i2 < this.f3573i.size(); i2++) {
                super.drawChild(canvas, this.f3573i.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected final boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList<View> arrayList;
        if (!this.f3576l || (arrayList = this.f3573i) == null || arrayList.size() <= 0 || !this.f3573i.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f3574j;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f3573i;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f3576l = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected final void removeDetachedView(View view, boolean z4) {
        if (z4) {
            a(view);
        }
        super.removeDetachedView(view, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i2, int i4) {
        for (int i5 = i2; i5 < i2 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViews(i2, i4);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i2, int i4) {
        for (int i5 = i2; i5 < i2 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViewsInLayout(i2, i4);
    }

    @Override // android.view.ViewGroup
    public final void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public final void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f3575k = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f3574j == null) {
                this.f3574j = new ArrayList<>();
            }
            this.f3574j.add(view);
        }
        super.startViewTransition(view);
    }
}
