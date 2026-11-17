package v3;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import z3.C0431a;

/* loaded from: classes.dex */
public final class d extends miuix.internal.widget.d {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f7967a;

    /* renamed from: b, reason: collision with root package name */
    private View f7968b;

    /* renamed from: c, reason: collision with root package name */
    private C0404a f7969c;
    private View d;

    /* renamed from: e, reason: collision with root package name */
    private float f7970e;

    /* renamed from: f, reason: collision with root package name */
    private float f7971f;
    private MenuBuilder g;

    /* renamed from: h, reason: collision with root package name */
    private MenuItem f7972h;

    /* renamed from: i, reason: collision with root package name */
    private int f7973i;

    final class a implements AdapterView.OnItemClickListener {

        /* renamed from: v3.d$a$a, reason: collision with other inner class name */
        final class C0140a implements PopupWindow.OnDismissListener {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ SubMenu f7975i;

            C0140a(SubMenu subMenu) {
                this.f7975i = subMenu;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                d.this.setOnDismissListener(null);
                d.this.update(this.f7975i);
                d dVar = d.this;
                d.m(dVar, dVar.d, d.this.f7970e, d.this.f7971f);
            }
        }

        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            MenuItem item = d.this.f7969c.getItem(i2);
            d.this.g.performItemAction(item, 0);
            if (item.hasSubMenu()) {
                d.this.setOnDismissListener(new C0140a(item.getSubMenu()));
            }
            d.this.dismiss();
        }
    }

    public d(Context context, MenuBuilder menuBuilder, PopupWindow.OnDismissListener onDismissListener) {
        super(context);
        this.g = menuBuilder;
        C0404a c0404a = new C0404a(context, this.g);
        this.f7969c = c0404a;
        MenuItem menuItemF = c0404a.f();
        this.f7972h = menuItemF;
        if (menuItemF == null) {
            this.f7968b.setVisibility(8);
        } else {
            TextView textView = (TextView) this.f7968b.findViewById(R.id.text1);
            textView.setText(this.f7972h.getTitle());
            Drawable drawableE = C0431a.e(context, com.android.mmt.R.attr.contextMenuSeparateItemBackground);
            if (drawableE != null) {
                textView.setBackground(drawableE);
            }
            this.f7968b.setOnClickListener(new e(this));
        }
        setAdapter(this.f7969c);
        setOnItemClickListener(new a());
        if (onDismissListener != null) {
            setOnDismissListener(onDismissListener);
        }
        this.f7973i = context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_context_menu_window_margin_screen);
    }

    static void m(d dVar, View view, float f4, float f5) {
        dVar.setWidth(dVar.computePopupContentWidth());
        dVar.setHeight(-2);
        dVar.f7968b.setVisibility(8);
        dVar.q(view, f4, f5);
        dVar.mContentView.forceLayout();
    }

    private int o() {
        ListView listView = (ListView) this.mContentView.findViewById(R.id.list);
        if (listView == null) {
            this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.mContentView.getMeasuredHeight() + 0;
        }
        ListAdapter adapter = listView.getAdapter();
        int measuredHeight = 0;
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += view.getMeasuredHeight();
        }
        return measuredHeight;
    }

    private void q(View view, float f4, float f5) {
        int measuredHeight;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = iArr[0] + ((int) f4);
        int i2 = iArr[1] + ((int) f5);
        View rootView = view.getRootView();
        boolean z4 = width <= getWidth();
        boolean z5 = width >= rootView.getWidth() - getWidth();
        int iO = o();
        float fO = i2 - (o() / 2);
        if (fO < rootView.getHeight() * 0.1f) {
            fO = rootView.getHeight() * 0.1f;
        }
        if (this.f7968b.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f7968b.getLayoutParams();
            int i4 = (layoutParams == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) ? 0 : ((ViewGroup.MarginLayoutParams) this.f7968b.getLayoutParams()).topMargin + 0;
            this.f7968b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight = this.f7968b.getMeasuredHeight() + i4;
        } else {
            measuredHeight = 0;
        }
        float f6 = iO + measuredHeight;
        if (fO + f6 > rootView.getHeight() * 0.9f) {
            fO = (rootView.getHeight() * 0.9f) - f6;
        }
        if (fO < rootView.getHeight() * 0.1f) {
            fO = rootView.getHeight() * 0.1f;
            setHeight((int) (rootView.getHeight() * 0.79999995f));
        }
        if (z4) {
            width = this.f7973i;
        } else if (z5) {
            width = (rootView.getWidth() - this.f7973i) - getWidth();
        }
        showAtLocation(view, 0, width, (int) fO);
        miuix.internal.widget.d.changeWindowBackground(this.mRootView.getRootView());
    }

    @Override // miuix.internal.widget.d
    protected final int checkMaxHeight(View view) {
        return this.mMaxAllowedHeight;
    }

    public final void p(View view, ViewGroup viewGroup, float f4, float f5) {
        this.d = view;
        this.f7970e = f4;
        this.f7971f = f5;
        if (prepareShow(view, viewGroup)) {
            this.f7968b.setElevation(this.mElevation);
            setPopupShadowAlpha(this.f7968b);
            q(view, f4, f5);
        }
    }

    @Override // miuix.internal.widget.d
    protected final void prepareContentView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f7967a = linearLayout;
        linearLayout.setOrientation(1);
        this.f7968b = LayoutInflater.from(context).inflate(com.android.mmt.R.layout.miuix_appcompat_popup_menu_item, (ViewGroup) null, false);
        Drawable drawableE = C0431a.e(context, com.android.mmt.R.attr.immersionWindowBackground);
        if (drawableE != null) {
            drawableE.getPadding(this.mBackgroundPadding);
            this.mRootView.setBackground(drawableE);
            this.f7968b.setBackground(drawableE.getConstantState().newDrawable());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_context_menu_separate_item_margin_top), 0, 0);
        this.f7967a.addView(this.mRootView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f7967a.addView(this.f7968b, layoutParams);
        setBackgroundDrawable(null);
        super.setPopupWindowContentView(this.f7967a);
    }

    public final void update(Menu menu) {
        this.f7969c.e(menu);
    }
}
