package miuix.appcompat.internal.view.menu.action;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuItemImpl;
import miuix.appcompat.internal.view.menu.MenuView;
import z3.C0432b;

/* loaded from: classes.dex */
public abstract class c extends LinearLayout implements MenuBuilder.ItemInvoker, MenuView {

    /* renamed from: i, reason: collision with root package name */
    private MenuBuilder f7054i;

    /* renamed from: j, reason: collision with root package name */
    private miuix.appcompat.internal.view.menu.action.b f7055j;

    /* renamed from: k, reason: collision with root package name */
    private b f7056k;

    public static class a extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f7057a;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(a aVar) {
            super((LinearLayout.LayoutParams) aVar);
            this.f7057a = aVar.f7057a;
        }

        public a() {
            super(-2, -2);
            this.f7057a = false;
        }
    }

    class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        this.f7056k = new b();
        setLayoutAnimation(null);
    }

    protected final float a(float f4, boolean z4, boolean z5) {
        int i2;
        if (z4 && z5) {
            return 1.0f;
        }
        if (z4) {
            i2 = (int) ((1.0f - f4) * 10.0f);
        } else {
            if (!z5) {
                return 1.0f;
            }
            i2 = (int) (f4 * 10.0f);
        }
        return i2 / 10.0f;
    }

    protected final float b(float f4, boolean z4, boolean z5) {
        float fE = e();
        if (z4 && z5) {
            f4 = ((double) f4) < 0.5d ? f4 * 2.0f : (1.0f - f4) * 2.0f;
        } else if (z5) {
            f4 = 1.0f - f4;
        }
        return f4 * fE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final a generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a ? new a((a) layoutParams) : generateDefaultLayoutParams();
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public abstract int e();

    public final miuix.appcompat.internal.view.menu.action.b f() {
        return this.f7055j;
    }

    public boolean filterLeftoverView(int i2) {
        View childAt = getChildAt(i2);
        childAt.clearAnimation();
        removeView(childAt);
        return true;
    }

    public void g(float f4, boolean z4, boolean z5) {
        int i2 = C0432b.f8169a;
        setAlpha(a(f4, z4, z5));
        float fB = b(f4, z4, z5);
        if (!z4 || !z5 || getTranslationY() != 0.0f) {
            setTranslationY(fB);
        }
        b bVar = this.f7056k;
        for (int i4 = 0; i4 < c.this.getChildCount(); i4++) {
            c.this.getChildAt(i4).setTranslationY(fB);
        }
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView
    public final int getWindowAnimations() {
        return 0;
    }

    public final void h(miuix.appcompat.internal.view.menu.action.b bVar) {
        this.f7055j = bVar;
    }

    public boolean hasBackgroundView() {
        return false;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView
    public final void initialize(MenuBuilder menuBuilder) {
        this.f7054i = menuBuilder;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuBuilder.ItemInvoker
    public final boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.f7054i.performItemAction(menuItemImpl, 0);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        miuix.appcompat.internal.view.menu.action.b bVar = this.f7055j;
        if (bVar != null) {
            bVar.updateMenuView(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7055j.k(false);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i4) {
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i2, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }
}
