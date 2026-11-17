package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public class I implements m.b {

    /* renamed from: C, reason: collision with root package name */
    final Handler f2764C;

    /* renamed from: E, reason: collision with root package name */
    private Rect f2766E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f2767F;

    /* renamed from: G, reason: collision with root package name */
    PopupWindow f2768G;

    /* renamed from: i, reason: collision with root package name */
    private Context f2769i;

    /* renamed from: j, reason: collision with root package name */
    private ListAdapter f2770j;

    /* renamed from: k, reason: collision with root package name */
    D f2771k;

    /* renamed from: n, reason: collision with root package name */
    private int f2774n;

    /* renamed from: o, reason: collision with root package name */
    private int f2775o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2776q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2777r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f2778s;

    /* renamed from: v, reason: collision with root package name */
    private DataSetObserver f2780v;

    /* renamed from: w, reason: collision with root package name */
    private View f2781w;

    /* renamed from: x, reason: collision with root package name */
    private AdapterView.OnItemClickListener f2782x;

    /* renamed from: l, reason: collision with root package name */
    private int f2772l = -2;

    /* renamed from: m, reason: collision with root package name */
    private int f2773m = -2;
    private int p = 1002;

    /* renamed from: t, reason: collision with root package name */
    private int f2779t = 0;
    int u = Integer.MAX_VALUE;

    /* renamed from: y, reason: collision with root package name */
    final e f2783y = new e();

    /* renamed from: z, reason: collision with root package name */
    private final d f2784z = new d();

    /* renamed from: A, reason: collision with root package name */
    private final c f2762A = new c();

    /* renamed from: B, reason: collision with root package name */
    private final a f2763B = new a();

    /* renamed from: D, reason: collision with root package name */
    private final Rect f2765D = new Rect();

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            D d = I.this.f2771k;
            if (d != null) {
                d.c(true);
                d.requestLayout();
            }
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            if (I.this.isShowing()) {
                I.this.f();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            I.this.dismiss();
        }
    }

    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i2, int i4, int i5) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                if ((I.this.f2768G.getInputMethodMode() == 2) || I.this.f2768G.getContentView() == null) {
                    return;
                }
                I i4 = I.this;
                i4.f2764C.removeCallbacks(i4.f2783y);
                I.this.f2783y.run();
            }
        }
    }

    private class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = I.this.f2768G) != null && popupWindow.isShowing() && x2 >= 0 && x2 < I.this.f2768G.getWidth() && y2 >= 0 && y2 < I.this.f2768G.getHeight()) {
                I i2 = I.this;
                i2.f2764C.postDelayed(i2.f2783y, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            I i4 = I.this;
            i4.f2764C.removeCallbacks(i4.f2783y);
            return false;
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            D d = I.this.f2771k;
            if (d != null) {
                int i2 = androidx.core.view.o.d;
                if (!d.isAttachedToWindow() || I.this.f2771k.getCount() <= I.this.f2771k.getChildCount()) {
                    return;
                }
                int childCount = I.this.f2771k.getChildCount();
                I i4 = I.this;
                if (childCount <= i4.u) {
                    i4.f2768G.setInputMethodMode(2);
                    I.this.f();
                }
            }
        }
    }

    public I(Context context, AttributeSet attributeSet, int i2, int i4) {
        this.f2769i = context;
        this.f2764C = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2125s, i2, i4);
        this.f2774n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f2775o = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2776q = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C0193n c0193n = new C0193n(context, attributeSet, i2, i4);
        this.f2768G = c0193n;
        c0193n.setInputMethodMode(1);
    }

    @Override // m.b
    public final void dismiss() {
        this.f2768G.dismiss();
        this.f2768G.setContentView(null);
        this.f2771k = null;
        this.f2764C.removeCallbacks(this.f2783y);
    }

    @Override // m.b
    public final void f() {
        int i2;
        int iMakeMeasureSpec;
        int paddingBottom;
        D d2;
        if (this.f2771k == null) {
            D dI = i(this.f2769i, !this.f2767F);
            this.f2771k = dI;
            dI.setAdapter(this.f2770j);
            this.f2771k.setOnItemClickListener(this.f2782x);
            this.f2771k.setFocusable(true);
            this.f2771k.setFocusableInTouchMode(true);
            this.f2771k.setOnItemSelectedListener(new H(this));
            this.f2771k.setOnScrollListener(this.f2762A);
            this.f2768G.setContentView(this.f2771k);
        }
        Drawable background = this.f2768G.getBackground();
        if (background != null) {
            background.getPadding(this.f2765D);
            Rect rect = this.f2765D;
            int i4 = rect.top;
            i2 = rect.bottom + i4;
            if (!this.f2776q) {
                this.f2775o = -i4;
            }
        } else {
            this.f2765D.setEmpty();
            i2 = 0;
        }
        int maxAvailableHeight = this.f2768G.getMaxAvailableHeight(this.f2781w, this.f2775o, this.f2768G.getInputMethodMode() == 2);
        if (this.f2772l == -1) {
            paddingBottom = maxAvailableHeight + i2;
        } else {
            int i5 = this.f2773m;
            if (i5 == -2) {
                int i6 = this.f2769i.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.f2765D;
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6 - (rect2.left + rect2.right), Integer.MIN_VALUE);
            } else if (i5 != -1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else {
                int i7 = this.f2769i.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.f2765D;
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7 - (rect3.left + rect3.right), 1073741824);
            }
            int iA = this.f2771k.a(iMakeMeasureSpec, maxAvailableHeight + 0);
            paddingBottom = iA + (iA > 0 ? this.f2771k.getPaddingBottom() + this.f2771k.getPaddingTop() + i2 + 0 : 0);
        }
        boolean z4 = this.f2768G.getInputMethodMode() == 2;
        this.f2768G.setWindowLayoutType(this.p);
        if (this.f2768G.isShowing()) {
            View view = this.f2781w;
            int i8 = androidx.core.view.o.d;
            if (view.isAttachedToWindow()) {
                int width = this.f2773m;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f2781w.getWidth();
                }
                int i9 = this.f2772l;
                if (i9 == -1) {
                    if (!z4) {
                        paddingBottom = -1;
                    }
                    if (z4) {
                        this.f2768G.setWidth(this.f2773m == -1 ? -1 : 0);
                        this.f2768G.setHeight(0);
                    } else {
                        this.f2768G.setWidth(this.f2773m == -1 ? -1 : 0);
                        this.f2768G.setHeight(-1);
                    }
                } else if (i9 != -2) {
                    paddingBottom = i9;
                }
                this.f2768G.setOutsideTouchable(true);
                this.f2768G.update(this.f2781w, this.f2774n, this.f2775o, width < 0 ? -1 : width, paddingBottom < 0 ? -1 : paddingBottom);
                return;
            }
            return;
        }
        int width2 = this.f2773m;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f2781w.getWidth();
        }
        int i10 = this.f2772l;
        if (i10 == -1) {
            paddingBottom = -1;
        } else if (i10 != -2) {
            paddingBottom = i10;
        }
        this.f2768G.setWidth(width2);
        this.f2768G.setHeight(paddingBottom);
        this.f2768G.setIsClippedToScreen(true);
        this.f2768G.setOutsideTouchable(true);
        this.f2768G.setTouchInterceptor(this.f2784z);
        if (this.f2778s) {
            this.f2768G.setOverlapAnchor(this.f2777r);
        }
        this.f2768G.setEpicenterBounds(this.f2766E);
        this.f2768G.showAsDropDown(this.f2781w, this.f2774n, this.f2775o, this.f2779t);
        this.f2771k.setSelection(-1);
        if ((!this.f2767F || this.f2771k.isInTouchMode()) && (d2 = this.f2771k) != null) {
            d2.c(true);
            d2.requestLayout();
        }
        if (this.f2767F) {
            return;
        }
        this.f2764C.post(this.f2763B);
    }

    public final Drawable getBackground() {
        return this.f2768G.getBackground();
    }

    public final int getHorizontalOffset() {
        return this.f2774n;
    }

    public final int getVerticalOffset() {
        if (this.f2776q) {
            return this.f2775o;
        }
        return 0;
    }

    @Override // m.b
    public final ListView h() {
        return this.f2771k;
    }

    D i(Context context, boolean z4) {
        return new D(context, z4);
    }

    @Override // m.b
    public final boolean isShowing() {
        return this.f2768G.isShowing();
    }

    public final int j() {
        return this.f2773m;
    }

    public final boolean k() {
        return this.f2767F;
    }

    public final void l(View view) {
        this.f2781w = view;
    }

    public final void m() {
        this.f2768G.setAnimationStyle(0);
    }

    public final void n(int i2) {
        Drawable background = this.f2768G.getBackground();
        if (background == null) {
            this.f2773m = i2;
            return;
        }
        background.getPadding(this.f2765D);
        Rect rect = this.f2765D;
        this.f2773m = rect.left + rect.right + i2;
    }

    public final void o(int i2) {
        this.f2779t = i2;
    }

    public final void p(Rect rect) {
        this.f2766E = rect != null ? new Rect(rect) : null;
    }

    public final void q() {
        this.f2768G.setInputMethodMode(2);
    }

    public final void r() {
        this.f2767F = true;
        this.f2768G.setFocusable(true);
    }

    public final void s(PopupWindow.OnDismissListener onDismissListener) {
        this.f2768G.setOnDismissListener(onDismissListener);
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2780v;
        if (dataSetObserver == null) {
            this.f2780v = new b();
        } else {
            ListAdapter listAdapter2 = this.f2770j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2770j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2780v);
        }
        D d2 = this.f2771k;
        if (d2 != null) {
            d2.setAdapter(this.f2770j);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.f2768G.setBackgroundDrawable(drawable);
    }

    public final void setHorizontalOffset(int i2) {
        this.f2774n = i2;
    }

    public final void setVerticalOffset(int i2) {
        this.f2775o = i2;
        this.f2776q = true;
    }

    public final void t(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2782x = onItemClickListener;
    }

    public final void u() {
        this.f2778s = true;
        this.f2777r = true;
    }
}
