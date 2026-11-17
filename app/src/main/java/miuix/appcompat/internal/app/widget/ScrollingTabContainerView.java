package miuix.appcompat.internal.app.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import miuix.appcompat.app.b;
import t3.C0386a;
import z3.C0431a;

/* loaded from: classes.dex */
public abstract class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemClickListener, b.a {

    /* renamed from: i, reason: collision with root package name */
    private final LayoutInflater f6901i;

    /* renamed from: j, reason: collision with root package name */
    Runnable f6902j;

    /* renamed from: k, reason: collision with root package name */
    int f6903k;

    /* renamed from: l, reason: collision with root package name */
    int f6904l;

    /* renamed from: m, reason: collision with root package name */
    private a f6905m;

    /* renamed from: n, reason: collision with root package name */
    protected LinearLayout f6906n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6907o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f6908q;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f6909r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6910s;

    /* renamed from: t, reason: collision with root package name */
    private float f6911t;
    private Paint u;

    /* renamed from: v, reason: collision with root package name */
    private int f6912v;

    public static class TabView extends LinearLayout {

        /* renamed from: i, reason: collision with root package name */
        private a.c f6913i;

        /* renamed from: j, reason: collision with root package name */
        private n f6914j;

        /* renamed from: k, reason: collision with root package name */
        private ImageView f6915k;

        /* renamed from: l, reason: collision with root package name */
        private View f6916l;

        /* renamed from: m, reason: collision with root package name */
        private ImageView f6917m;

        /* renamed from: n, reason: collision with root package name */
        private ScrollingTabContainerView f6918n;

        public TabView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            androidx.core.view.o.j(this, new m(this));
        }

        final void a(ScrollingTabContainerView scrollingTabContainerView, a.c cVar) {
            this.f6918n = scrollingTabContainerView;
            this.f6913i = cVar;
            d();
        }

        public final a.c b() {
            return this.f6913i;
        }

        public final TextView c() {
            return this.f6914j;
        }

        public final void d() {
            int intrinsicHeight;
            int lineHeight;
            a.c cVar = this.f6913i;
            cVar.b();
            View view = this.f6916l;
            if (view != null) {
                removeView(view);
                this.f6916l = null;
            }
            Context context = getContext();
            cVar.c();
            CharSequence charSequenceE = cVar.e();
            ImageView imageView = this.f6915k;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.f6915k.setImageDrawable(null);
            }
            if (charSequenceE != null) {
                if (this.f6914j == null) {
                    n nVar = new n(context, this.f6918n.f());
                    nVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    nVar.setLayoutParams(layoutParams);
                    addView(nVar);
                    this.f6914j = nVar;
                }
                this.f6914j.setText(charSequenceE);
                this.f6914j.setVisibility(0);
                if (this.f6917m == null) {
                    ImageView imageView2 = new ImageView(context);
                    imageView2.setImageDrawable(C0431a.e(context, R.attr.actionBarTabBadgeIcon));
                    imageView2.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 48;
                    Drawable background = getBackground();
                    if (background != null && (intrinsicHeight = background.getIntrinsicHeight()) > (lineHeight = this.f6914j.getLineHeight())) {
                        layoutParams2.topMargin = (intrinsicHeight - lineHeight) / 2;
                    }
                    imageView2.setLayoutParams(layoutParams2);
                    addView(imageView2);
                    this.f6917m = imageView2;
                }
            } else {
                n nVar2 = this.f6914j;
                if (nVar2 != null) {
                    nVar2.setVisibility(8);
                    this.f6914j.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f6915k;
            if (imageView3 != null) {
                cVar.a();
                imageView3.setContentDescription(null);
            }
            this.f6918n.p(this.f6914j);
        }

        @Override // android.view.View
        protected final void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            if (this.f6914j != null) {
                ScrollingTabContainerView scrollingTabContainerView = this.f6918n;
                this.f6914j.setTextAppearance(C0431a.b(scrollingTabContainerView.getContext(), scrollingTabContainerView.f()));
            }
            ImageView imageView = this.f6915k;
            if (imageView != null) {
                this.f6913i.c();
                imageView.setImageDrawable(null);
            }
        }
    }

    private static class a implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<ScrollingTabContainerView> f6919i;

        a(ScrollingTabContainerView scrollingTabContainerView) {
            this.f6919i = new WeakReference<>(scrollingTabContainerView);
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WeakReference<ScrollingTabContainerView> weakReference = this.f6919i;
            ScrollingTabContainerView scrollingTabContainerView = weakReference != null ? weakReference.get() : null;
            if (scrollingTabContainerView == null) {
                return;
            }
            ((TabView) view).b().f();
            int childCount = scrollingTabContainerView.f6906n.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = scrollingTabContainerView.f6906n.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private static class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<ScrollingTabContainerView> f6920i;

        /* renamed from: j, reason: collision with root package name */
        private int f6921j;

        b(ScrollingTabContainerView scrollingTabContainerView, int i2) {
            this.f6920i = new WeakReference<>(scrollingTabContainerView);
            this.f6921j = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View childAt;
            WeakReference<ScrollingTabContainerView> weakReference = this.f6920i;
            ScrollingTabContainerView scrollingTabContainerView = weakReference != null ? weakReference.get() : null;
            if (scrollingTabContainerView == null || (childAt = scrollingTabContainerView.f6906n.getChildAt(this.f6921j)) == null) {
                return;
            }
            scrollingTabContainerView.smoothScrollTo(childAt.getLeft() - ((scrollingTabContainerView.getWidth() - childAt.getWidth()) / 2), 0);
            scrollingTabContainerView.f6902j = null;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.u = new Paint();
        this.f6912v = -1;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f6901i = layoutInflaterFrom;
        C0386a c0386aB = C0386a.b(context);
        Bitmap bitmapCreateBitmap = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, Y1.a.f2098S, android.R.attr.actionBarStyle, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(52);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(56, true);
        this.f6910s = z4;
        if (drawable != null) {
            bitmapCreateBitmap = z4 ? Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ALPHA_8) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
        }
        this.f6909r = bitmapCreateBitmap;
        typedArrayObtainStyledAttributes.recycle();
        if (this.f6910s) {
            this.u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        setHorizontalScrollBarEnabled(false);
        this.f6904l = c0386aB.e();
        LinearLayout linearLayout = (LinearLayout) layoutInflaterFrom.inflate(g(), (ViewGroup) this, false);
        this.f6906n = linearLayout;
        addView(linearLayout, new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // miuix.appcompat.app.b.a
    public final void a(int i2) {
    }

    @Override // miuix.appcompat.app.b.a
    public final void b(int i2) {
        TabView tabView = (TabView) this.f6906n.getChildAt(i2);
        if (tabView != null) {
            tabView.sendAccessibilityEvent(4);
        }
        m(i2, 0.0f);
        int i4 = this.f6912v;
        if (i4 != -1) {
            boolean z4 = true;
            if (Math.abs(i4 - i2) == 1) {
                n nVar = (n) ((TabView) this.f6906n.getChildAt(this.f6912v)).c();
                n nVar2 = (n) tabView.c();
                if (nVar != null && nVar2 != null) {
                    if (!(getLayoutDirection() == 1) ? i2 <= this.f6912v : i2 >= this.f6912v) {
                        z4 = false;
                    }
                    nVar.c(z4);
                    nVar2.c(z4);
                }
            }
        }
        this.f6912v = i2;
    }

    @Override // miuix.appcompat.app.b.a
    public final void c(int i2, float f4, boolean z4, boolean z5) {
        m(i2, f4);
    }

    public final void d(a.c cVar, boolean z4) {
        TabView tabView = (TabView) this.f6901i.inflate(i(), (ViewGroup) this.f6906n, false);
        tabView.a(this, cVar);
        tabView.setFocusable(true);
        if (this.f6905m == null) {
            this.f6905m = new a(this);
        }
        tabView.setOnClickListener(this.f6905m);
        if (this.f6906n.getChildCount() != 0) {
            ((LinearLayout.LayoutParams) tabView.getLayoutParams()).setMarginStart(j());
        }
        this.f6906n.addView(tabView);
        if (z4) {
            tabView.setSelected(true);
            this.f6912v = this.f6906n.getChildCount() - 1;
        }
        if (this.f6907o) {
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Bitmap bitmap = this.f6909r;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f6911t, getHeight() - this.f6909r.getHeight(), this.u);
        }
    }

    public final void e(int i2) {
        Runnable runnable = this.f6902j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        b bVar = new b(this, i2);
        this.f6902j = bVar;
        post(bVar);
    }

    abstract int f();

    abstract int g();

    abstract int h();

    abstract int i();

    abstract int j();

    public final void k() {
        this.f6906n.removeAllViews();
        if (this.f6907o) {
            requestLayout();
        }
    }

    public final void l(int i2) {
        if (this.p != i2) {
            this.p = i2;
            requestLayout();
        }
    }

    public final void m(int i2, float f4) {
        float width;
        if (this.f6909r != null) {
            View childAt = this.f6906n.getChildAt(i2);
            if (this.f6906n.getChildAt(i2 + 1) == null) {
                width = childAt.getWidth();
            } else {
                width = (r4.getWidth() + childAt.getWidth()) / 2.0f;
            }
            this.f6911t = (width * f4) + ((childAt.getWidth() - this.f6909r.getWidth()) / 2) + childAt.getLeft();
            invalidate();
        }
    }

    public final void n(int i2) {
        this.f6908q = i2;
        int childCount = this.f6906n.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = this.f6906n.getChildAt(i4);
            boolean z4 = i4 == i2;
            childAt.setSelected(z4);
            if (z4) {
                e(i2);
            }
            i4++;
        }
    }

    public final void o(int i2) {
        ((TabView) this.f6906n.getChildAt(i2)).d();
        if (this.f6907o) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f6902j;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        C0386a c0386aB = C0386a.b(getContext());
        l(h());
        this.f6904l = c0386aB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f6902j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((TabView) view).b().f();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        if (this.f6906n.getChildAt(this.f6908q) != null) {
            m(this.f6908q, 0.0f);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z4 = mode == 1073741824;
        setFillViewport(z4);
        int childCount = this.f6906n.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f6903k = -1;
        } else {
            if (childCount > 2) {
                this.f6903k = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.f6903k = (int) (View.MeasureSpec.getSize(i2) * 0.6f);
            }
            this.f6903k = Math.min(this.f6903k, this.f6904l);
        }
        int i5 = this.p;
        if (i5 != -2) {
            i4 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, i4);
        int measuredWidth2 = getMeasuredWidth();
        if (!z4 || measuredWidth == measuredWidth2) {
            return;
        }
        n(this.f6908q);
    }

    void p(TextView textView) {
    }
}
