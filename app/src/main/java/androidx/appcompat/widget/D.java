package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.mmt.R;
import j.C0335a;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class D extends ListView {

    /* renamed from: i, reason: collision with root package name */
    private final Rect f2723i;

    /* renamed from: j, reason: collision with root package name */
    private int f2724j;

    /* renamed from: k, reason: collision with root package name */
    private int f2725k;

    /* renamed from: l, reason: collision with root package name */
    private int f2726l;

    /* renamed from: m, reason: collision with root package name */
    private int f2727m;

    /* renamed from: n, reason: collision with root package name */
    private int f2728n;

    /* renamed from: o, reason: collision with root package name */
    private Field f2729o;
    private a p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2730q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2731r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f2732s;

    /* renamed from: t, reason: collision with root package name */
    private H.b f2733t;
    b u;

    private static class a extends C0335a {

        /* renamed from: j, reason: collision with root package name */
        private boolean f2734j;

        a(Drawable drawable) {
            super(drawable);
            this.f2734j = true;
        }

        final void b(boolean z4) {
            this.f2734j = z4;
        }

        @Override // j.C0335a, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            if (this.f2734j) {
                super.draw(canvas);
            }
        }

        @Override // j.C0335a, android.graphics.drawable.Drawable
        public final void setHotspot(float f4, float f5) {
            if (this.f2734j) {
                super.setHotspot(f4, f5);
            }
        }

        @Override // j.C0335a, android.graphics.drawable.Drawable
        public final void setHotspotBounds(int i2, int i4, int i5, int i6) {
            if (this.f2734j) {
                super.setHotspotBounds(i2, i4, i5, i6);
            }
        }

        @Override // j.C0335a, android.graphics.drawable.Drawable
        public final boolean setState(int[] iArr) {
            if (this.f2734j) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // j.C0335a, android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z4, boolean z5) {
            if (this.f2734j) {
                return super.setVisible(z4, z5);
            }
            return false;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            D d = D.this;
            d.u = null;
            d.drawableStateChanged();
        }
    }

    D(Context context, boolean z4) throws NoSuchFieldException, SecurityException {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f2723i = new Rect();
        this.f2724j = 0;
        this.f2725k = 0;
        this.f2726l = 0;
        this.f2727m = 0;
        this.f2731r = z4;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2729o = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        Drawable selector = getSelector();
        if (selector != null && this.f2732s && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int a(int i2, int i4) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return measuredHeight;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i5 = 0;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i7 = layoutParams.height;
            view.measure(i2, i7 > 0 ? View.MeasureSpec.makeMeasureSpec(i7, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i6 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return i4;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(MotionEvent motionEvent, int i2) throws IllegalAccessException, IllegalArgumentException {
        boolean z4;
        View childAt;
        View childAt2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z5 = true;
        if (actionMasked == 1) {
            z4 = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z4 = true;
                    z5 = false;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (z4 || z5) {
                    this.f2732s = false;
                    setPressed(false);
                    drawableStateChanged();
                    childAt2 = getChildAt(this.f2728n - getFirstVisiblePosition());
                    if (childAt2 != null) {
                        childAt2.setPressed(false);
                    }
                }
                if (z4) {
                    H.b bVar = this.f2733t;
                    if (bVar != null) {
                        bVar.f(false);
                    }
                } else {
                    if (this.f2733t == null) {
                        this.f2733t = new H.b(this);
                    }
                    this.f2733t.f(true);
                    this.f2733t.onTouch(this, motionEvent);
                }
                return z4;
            }
            z4 = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
        if (iFindPointerIndex >= 0) {
            int x2 = (int) motionEvent.getX(iFindPointerIndex);
            int y2 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x2, y2);
            if (iPointToPosition != -1) {
                View childAt3 = getChildAt(iPointToPosition - getFirstVisiblePosition());
                float f4 = x2;
                float f5 = y2;
                this.f2732s = true;
                drawableHotspotChanged(f4, f5);
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                int i4 = this.f2728n;
                if (i4 != -1 && (childAt = getChildAt(i4 - getFirstVisiblePosition())) != null && childAt != childAt3 && childAt.isPressed()) {
                    childAt.setPressed(false);
                }
                this.f2728n = iPointToPosition;
                childAt3.drawableHotspotChanged(f4 - childAt3.getLeft(), f5 - childAt3.getTop());
                if (!childAt3.isPressed()) {
                    childAt3.setPressed(true);
                }
                Drawable selector = getSelector();
                boolean z6 = (selector == null || iPointToPosition == -1) ? false : true;
                if (z6) {
                    selector.setVisible(false, false);
                }
                Rect rect = this.f2723i;
                rect.set(childAt3.getLeft(), childAt3.getTop(), childAt3.getRight(), childAt3.getBottom());
                rect.left -= this.f2724j;
                rect.top -= this.f2725k;
                rect.right += this.f2726l;
                rect.bottom += this.f2727m;
                try {
                    boolean z7 = this.f2729o.getBoolean(this);
                    if (childAt3.isEnabled() != z7) {
                        this.f2729o.set(this, Boolean.valueOf(!z7));
                        if (iPointToPosition != -1) {
                            refreshDrawableState();
                        }
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
                if (z6) {
                    Rect rect2 = this.f2723i;
                    float fExactCenterX = rect2.exactCenterX();
                    float fExactCenterY = rect2.exactCenterY();
                    selector.setVisible(getVisibility() == 0, false);
                    selector.setHotspot(fExactCenterX, fExactCenterY);
                }
                Drawable selector2 = getSelector();
                if (selector2 != null && iPointToPosition != -1) {
                    selector2.setHotspot(f4, f5);
                }
                a aVar = this.p;
                if (aVar != null) {
                    aVar.b(false);
                }
                refreshDrawableState();
                if (actionMasked == 1) {
                    performItemClick(childAt3, iPointToPosition, getItemIdAtPosition(iPointToPosition));
                }
                z5 = false;
                z4 = true;
            }
        }
        if (z4) {
            this.f2732s = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f2728n - getFirstVisiblePosition());
            if (childAt2 != null) {
            }
        }
        if (z4) {
        }
        return z4;
    }

    final void c(boolean z4) {
        this.f2730q = z4;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.f2723i.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f2723i);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected final void drawableStateChanged() {
        if (this.u != null) {
            return;
        }
        super.drawableStateChanged();
        a aVar = this.p;
        if (aVar != null) {
            aVar.b(true);
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f2731r || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f2731r || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f2731r || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f2731r && this.f2730q) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        this.u = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.u == null) {
            b bVar = new b();
            this.u = bVar;
            post(bVar);
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                d();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2728n = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.u;
        if (bVar != null) {
            D d = D.this;
            d.u = null;
            d.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.p = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2724j = rect.left;
        this.f2725k = rect.top;
        this.f2726l = rect.right;
        this.f2727m = rect.bottom;
    }
}
