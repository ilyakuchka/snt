package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.G;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class AlertController {

    /* renamed from: A, reason: collision with root package name */
    NestedScrollView f2254A;

    /* renamed from: C, reason: collision with root package name */
    private Drawable f2256C;

    /* renamed from: D, reason: collision with root package name */
    private ImageView f2257D;

    /* renamed from: E, reason: collision with root package name */
    private TextView f2258E;

    /* renamed from: F, reason: collision with root package name */
    private TextView f2259F;

    /* renamed from: G, reason: collision with root package name */
    private View f2260G;

    /* renamed from: H, reason: collision with root package name */
    ListAdapter f2261H;

    /* renamed from: J, reason: collision with root package name */
    private int f2263J;

    /* renamed from: K, reason: collision with root package name */
    private int f2264K;
    int L;
    int M;

    /* renamed from: N, reason: collision with root package name */
    int f2265N;

    /* renamed from: O, reason: collision with root package name */
    int f2266O;
    private boolean P;

    /* renamed from: Q, reason: collision with root package name */
    Handler f2267Q;

    /* renamed from: a, reason: collision with root package name */
    private final Context f2269a;

    /* renamed from: b, reason: collision with root package name */
    final o f2270b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f2271c;
    private final int d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f2272e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f2273f;
    RecycleListView g;

    /* renamed from: h, reason: collision with root package name */
    private View f2274h;

    /* renamed from: i, reason: collision with root package name */
    private int f2275i;

    /* renamed from: j, reason: collision with root package name */
    private int f2276j;

    /* renamed from: k, reason: collision with root package name */
    private int f2277k;

    /* renamed from: l, reason: collision with root package name */
    private int f2278l;

    /* renamed from: m, reason: collision with root package name */
    private int f2279m;

    /* renamed from: o, reason: collision with root package name */
    Button f2281o;
    private CharSequence p;

    /* renamed from: q, reason: collision with root package name */
    Message f2282q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f2283r;

    /* renamed from: s, reason: collision with root package name */
    Button f2284s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f2285t;
    Message u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f2286v;

    /* renamed from: w, reason: collision with root package name */
    Button f2287w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f2288x;

    /* renamed from: y, reason: collision with root package name */
    Message f2289y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f2290z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2280n = false;

    /* renamed from: B, reason: collision with root package name */
    private int f2255B = 0;

    /* renamed from: I, reason: collision with root package name */
    int f2262I = -1;

    /* renamed from: R, reason: collision with root package name */
    private final View.OnClickListener f2268R = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: i, reason: collision with root package name */
        private final int f2291i;

        /* renamed from: j, reason: collision with root package name */
        private final int f2292j;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2129x);
            this.f2292j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.f2291i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }

        public final void a(boolean z4, boolean z5) {
            if (z5 && z4) {
                return;
            }
            setPadding(getPaddingLeft(), z4 ? getPaddingTop() : this.f2291i, getPaddingRight(), z5 ? getPaddingBottom() : this.f2292j);
        }
    }

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f2281o || (message3 = alertController.f2282q) == null) ? (view != alertController.f2284s || (message2 = alertController.u) == null) ? (view != alertController.f2287w || (message = alertController.f2289y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f2267Q.obtainMessage(1, alertController2.f2270b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2294a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f2295b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f2296c;
        public CharSequence d;

        /* renamed from: e, reason: collision with root package name */
        public View f2297e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f2298f;
        public CharSequence g;

        /* renamed from: h, reason: collision with root package name */
        public DialogInterface.OnClickListener f2299h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f2300i;

        /* renamed from: j, reason: collision with root package name */
        public DialogInterface.OnClickListener f2301j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnKeyListener f2302k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence[] f2303l;

        /* renamed from: m, reason: collision with root package name */
        public ListAdapter f2304m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f2305n;

        /* renamed from: o, reason: collision with root package name */
        public View f2306o;
        public boolean[] p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f2307q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f2308r;

        /* renamed from: s, reason: collision with root package name */
        public int f2309s = -1;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f2310t;

        public b(Context context) {
            this.f2294a = context;
            this.f2295b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f2311a;

        public c(DialogInterface dialogInterface) {
            this.f2311a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f2311a.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i2, CharSequence[] charSequenceArr) {
            super(context, i2, R.id.text1, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, o oVar, Window window) {
        this.f2269a = context;
        this.f2270b = oVar;
        this.f2271c = window;
        this.f2267Q = new c(oVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, Y1.a.f2117j, com.android.mmt.R.attr.alertDialogStyle, 0);
        this.f2263J = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f2264K = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.f2265N = typedArrayObtainStyledAttributes.getResourceId(10, 0);
        this.f2266O = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(9, true);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        oVar.a().v(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private ViewGroup d(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        int i2;
        View view;
        ListAdapter listAdapter;
        View viewFindViewById;
        this.f2270b.setContentView(this.f2264K == 0 ? this.f2263J : this.f2263J);
        View viewFindViewById2 = this.f2271c.findViewById(com.android.mmt.R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(com.android.mmt.R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(com.android.mmt.R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(com.android.mmt.R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(com.android.mmt.R.id.customPanel);
        View viewInflate = this.f2274h;
        if (viewInflate == null) {
            viewInflate = this.f2275i != 0 ? LayoutInflater.from(this.f2269a).inflate(this.f2275i, viewGroup, false) : null;
        }
        boolean z4 = viewInflate != null;
        if (!z4 || !a(viewInflate)) {
            this.f2271c.setFlags(131072, 131072);
        }
        if (z4) {
            FrameLayout frameLayout = (FrameLayout) this.f2271c.findViewById(com.android.mmt.R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.f2280n) {
                frameLayout.setPadding(this.f2276j, this.f2277k, this.f2278l, this.f2279m);
            }
            if (this.g != null) {
                ((LinearLayout.LayoutParams) ((G.a) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(com.android.mmt.R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(com.android.mmt.R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(com.android.mmt.R.id.buttonPanel);
        ViewGroup viewGroupD = d(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupD2 = d(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupD3 = d(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) this.f2271c.findViewById(com.android.mmt.R.id.scrollView);
        this.f2254A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f2254A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupD2.findViewById(R.id.message);
        this.f2259F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f2273f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                this.f2254A.removeView(this.f2259F);
                if (this.g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) this.f2254A.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(this.f2254A);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(this.g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupD2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupD3.findViewById(R.id.button1);
        this.f2281o = button;
        button.setOnClickListener(this.f2268R);
        if (TextUtils.isEmpty(this.p) && this.f2283r == null) {
            this.f2281o.setVisibility(8);
            i2 = 0;
        } else {
            this.f2281o.setText(this.p);
            Drawable drawable = this.f2283r;
            if (drawable != null) {
                int i4 = this.d;
                drawable.setBounds(0, 0, i4, i4);
                this.f2281o.setCompoundDrawables(this.f2283r, null, null, null);
            }
            this.f2281o.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroupD3.findViewById(R.id.button2);
        this.f2284s = button2;
        button2.setOnClickListener(this.f2268R);
        if (TextUtils.isEmpty(this.f2285t) && this.f2286v == null) {
            this.f2284s.setVisibility(8);
        } else {
            this.f2284s.setText(this.f2285t);
            Drawable drawable2 = this.f2286v;
            if (drawable2 != null) {
                int i5 = this.d;
                drawable2.setBounds(0, 0, i5, i5);
                this.f2284s.setCompoundDrawables(this.f2286v, null, null, null);
            }
            this.f2284s.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroupD3.findViewById(R.id.button3);
        this.f2287w = button3;
        button3.setOnClickListener(this.f2268R);
        if (TextUtils.isEmpty(this.f2288x) && this.f2290z == null) {
            this.f2287w.setVisibility(8);
            view = null;
        } else {
            this.f2287w.setText(this.f2288x);
            Drawable drawable3 = this.f2290z;
            if (drawable3 != null) {
                int i6 = this.d;
                drawable3.setBounds(0, 0, i6, i6);
                view = null;
                this.f2287w.setCompoundDrawables(this.f2290z, null, null, null);
            } else {
                view = null;
            }
            this.f2287w.setVisibility(0);
            i2 |= 4;
        }
        Context context = this.f2269a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.mmt.R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i2 == 1) {
                b(this.f2281o);
            } else if (i2 == 2) {
                b(this.f2284s);
            } else if (i2 == 4) {
                b(this.f2287w);
            }
        }
        if (!(i2 != 0)) {
            viewGroupD3.setVisibility(8);
        }
        if (this.f2260G != null) {
            viewGroupD.addView(this.f2260G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f2271c.findViewById(com.android.mmt.R.id.title_template).setVisibility(8);
        } else {
            this.f2257D = (ImageView) this.f2271c.findViewById(R.id.icon);
            if ((!TextUtils.isEmpty(this.f2272e)) && this.P) {
                TextView textView2 = (TextView) this.f2271c.findViewById(com.android.mmt.R.id.alertTitle);
                this.f2258E = textView2;
                textView2.setText(this.f2272e);
                int i7 = this.f2255B;
                if (i7 != 0) {
                    this.f2257D.setImageResource(i7);
                } else {
                    Drawable drawable4 = this.f2256C;
                    if (drawable4 != null) {
                        this.f2257D.setImageDrawable(drawable4);
                    } else {
                        this.f2258E.setPadding(this.f2257D.getPaddingLeft(), this.f2257D.getPaddingTop(), this.f2257D.getPaddingRight(), this.f2257D.getPaddingBottom());
                        this.f2257D.setVisibility(8);
                    }
                }
            } else {
                this.f2271c.findViewById(com.android.mmt.R.id.title_template).setVisibility(8);
                this.f2257D.setVisibility(8);
                viewGroupD.setVisibility(8);
            }
        }
        boolean z5 = viewGroup.getVisibility() != 8;
        boolean z6 = (viewGroupD == null || viewGroupD.getVisibility() == 8) ? 0 : 1;
        boolean z7 = viewGroupD3.getVisibility() != 8;
        if (!z7 && (viewFindViewById = viewGroupD2.findViewById(com.android.mmt.R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (z6 != 0) {
            NestedScrollView nestedScrollView2 = this.f2254A;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (this.f2273f == null && this.g == null) ? view : viewGroupD.findViewById(com.android.mmt.R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupD2.findViewById(com.android.mmt.R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        RecycleListView recycleListView = this.g;
        if (recycleListView instanceof RecycleListView) {
            recycleListView.a(z6, z7);
        }
        if (!z5) {
            View view2 = this.g;
            if (view2 == null) {
                view2 = this.f2254A;
            }
            if (view2 != null) {
                int i8 = z7 ? 2 : 0;
                View viewFindViewById11 = this.f2271c.findViewById(com.android.mmt.R.id.scrollIndicatorUp);
                View viewFindViewById12 = this.f2271c.findViewById(com.android.mmt.R.id.scrollIndicatorDown);
                int i9 = androidx.core.view.o.d;
                view2.setScrollIndicators(z6 | i8, 3);
                if (viewFindViewById11 != null) {
                    viewGroupD2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupD2.removeView(viewFindViewById12);
                }
            }
        }
        RecycleListView recycleListView2 = this.g;
        if (recycleListView2 == null || (listAdapter = this.f2261H) == null) {
            return;
        }
        recycleListView2.setAdapter(listAdapter);
        int i10 = this.f2262I;
        if (i10 > -1) {
            recycleListView2.setItemChecked(i10, true);
            recycleListView2.setSelection(i10);
        }
    }

    public final void e(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.f2267Q.obtainMessage(i2, onClickListener) : null;
        if (i2 == -3) {
            this.f2288x = charSequence;
            this.f2289y = messageObtainMessage;
            this.f2290z = null;
        } else if (i2 == -2) {
            this.f2285t = charSequence;
            this.u = messageObtainMessage;
            this.f2286v = null;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.p = charSequence;
            this.f2282q = messageObtainMessage;
            this.f2283r = null;
        }
    }

    public final void f(View view) {
        this.f2260G = view;
    }

    public final void g(Drawable drawable) {
        this.f2256C = drawable;
        this.f2255B = 0;
        ImageView imageView = this.f2257D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f2257D.setImageDrawable(drawable);
            }
        }
    }

    public final void h(CharSequence charSequence) {
        this.f2273f = charSequence;
        TextView textView = this.f2259F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void i(CharSequence charSequence) {
        this.f2272e = charSequence;
        TextView textView = this.f2258E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void j(View view) {
        this.f2274h = view;
        this.f2275i = 0;
        this.f2280n = false;
    }
}
