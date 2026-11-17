package P0;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;
import java.util.Objects;
import t.C0384b;

/* loaded from: classes.dex */
public final class D extends PopupWindow implements View.OnClickListener {

    /* renamed from: G, reason: collision with root package name */
    private static String f867G;

    /* renamed from: H, reason: collision with root package name */
    private static String f868H;

    /* renamed from: A, reason: collision with root package name */
    private View f869A;

    /* renamed from: B, reason: collision with root package name */
    private TextView f870B;

    /* renamed from: C, reason: collision with root package name */
    private View f871C;

    /* renamed from: D, reason: collision with root package name */
    private int f872D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f873E;

    /* renamed from: F, reason: collision with root package name */
    private float f874F;

    /* renamed from: i, reason: collision with root package name */
    private Context f875i;

    /* renamed from: j, reason: collision with root package name */
    private View f876j;

    /* renamed from: k, reason: collision with root package name */
    private View f877k;

    /* renamed from: l, reason: collision with root package name */
    private View f878l;

    /* renamed from: m, reason: collision with root package name */
    private View f879m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f880n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f881o;
    private TextView p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f882q;

    /* renamed from: r, reason: collision with root package name */
    private View f883r;

    /* renamed from: s, reason: collision with root package name */
    private K f884s;

    /* renamed from: t, reason: collision with root package name */
    private int f885t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f886v;

    /* renamed from: w, reason: collision with root package name */
    private View.OnClickListener f887w;

    /* renamed from: x, reason: collision with root package name */
    private View.OnClickListener f888x;

    /* renamed from: y, reason: collision with root package name */
    private View.OnClickListener f889y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f890z;

    public D(Context context, int i2, int i4) {
        super(-1, -2);
        setOutsideTouchable(true);
        setInputMethodMode(2);
        setFocusable(true);
        this.f875i = context;
        this.f885t = i2;
        this.u = i4;
        this.f886v = false;
        this.f887w = null;
        this.f888x = null;
        this.f889y = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.message_edit_bottom_sim_button_panel, (ViewGroup) null);
        this.f883r = viewInflate;
        View viewFindViewById = viewInflate.findViewById(R.id.sim_button1);
        this.f876j = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.f880n = (TextView) this.f883r.findViewById(R.id.sim_button1_text);
        this.f890z = (TextView) this.f883r.findViewById(R.id.sim_button1_number);
        String strN = C0287t.n(0);
        if (strN == null || strN.isEmpty()) {
            this.f890z.setVisibility(8);
        } else {
            this.f890z.setText(strN);
        }
        View viewFindViewById2 = this.f883r.findViewById(R.id.sub_sim_button1);
        this.f877k = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.f881o = (TextView) this.f883r.findViewById(R.id.sub_sim_button1_text);
        this.f869A = this.f883r.findViewById(R.id.sim_button1_choose);
        View viewFindViewById3 = this.f883r.findViewById(R.id.sim_button2);
        this.f878l = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this);
        this.p = (TextView) this.f883r.findViewById(R.id.sim_button2_text);
        this.f870B = (TextView) this.f883r.findViewById(R.id.sim_button2_number);
        String strN2 = C0287t.n(1);
        if (strN2 == null || strN2.isEmpty()) {
            this.f870B.setVisibility(8);
        } else {
            this.f870B.setText(strN2);
        }
        View viewFindViewById4 = this.f883r.findViewById(R.id.sub_sim_button2);
        this.f879m = viewFindViewById4;
        viewFindViewById4.setOnClickListener(this);
        this.f882q = (TextView) this.f883r.findViewById(R.id.sub_sim_button2_text);
        this.f871C = this.f883r.findViewById(R.id.sim_button2_choose);
        setContentView(this.f883r);
        m();
        if (this.u <= 0) {
            n(this.f885t);
        }
        o(this.u);
    }

    static void b(D d, Activity activity, float f4) {
        Objects.requireNonNull(d);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f4;
        if (f4 == 1.0f) {
            activity.getWindow().clearFlags(2);
        } else {
            activity.getWindow().addFlags(2);
        }
        activity.getWindow().setAttributes(attributes);
    }

    public static void k(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 0) {
            f867G = str;
        } else if (i2 != 1) {
            return;
        }
        f868H = str;
    }

    private void m() {
        TextView textView;
        TextView textView2;
        if (!C0287t.y()) {
            int iF = C0287t.f();
            if (iF == 0) {
                this.f878l.setVisibility(8);
            } else if (1 == iF) {
                this.f876j.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(f867G) && (textView2 = this.f880n) != null) {
            textView2.setText(f867G);
            this.f880n.setContentDescription(this.f880n.getResources().getString(R.string.sim_card1) + "，" + f867G);
        }
        if (TextUtils.isEmpty(f868H) || (textView = this.p) == null) {
            return;
        }
        textView.setText(f868H);
        this.p.setContentDescription(this.p.getResources().getString(R.string.sim_card2) + "，" + f868H);
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        this.f874F = ((Activity) this.f875i).getWindow().getAttributes().alpha;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f883r, "ScaleX", 1.0f, 0.9f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f883r, "ScaleY", 1.0f, 0.9f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f883r, "Alpha", 1.0f, 0.0f);
        this.f883r.setPivotX(r4.getMeasuredWidth() / 2);
        this.f883r.setPivotY(r4.getMeasuredHeight() / 2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f874F, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new B(this));
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        animatorSet.addListener(new C(this));
        animatorSet.start();
        if (this.f873E) {
            return;
        }
        super.dismiss();
    }

    public final void e() {
        K k2 = this.f884s;
        if (k2 == null || !k2.c()) {
            return;
        }
        this.f884s.b();
        this.f884s = null;
    }

    public final int f() {
        return this.f885t;
    }

    public final int g() {
        return this.u;
    }

    public final void h(View view) {
        m();
        if (this.f872D == 0) {
            this.f883r.measure(0, 0);
            this.f872D = this.f883r.getMeasuredHeight();
        }
        this.f874F = ((Activity) this.f875i).getWindow().getAttributes().alpha;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f883r, "ScaleX", 0.9f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f883r, "ScaleY", 0.9f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f883r, "Alpha", 0.0f, 1.0f);
        this.f883r.setPivotX(r5.getMeasuredWidth() / 2);
        this.f883r.setPivotY(r5.getMeasuredHeight() / 2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f874F, 0.7f);
        valueAnimatorOfFloat.addUpdateListener(new A(this));
        if (C0384b.q((Activity) this.f875i)) {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        } else {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        }
        animatorSet.start();
        this.f873E = true;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int measuredWidth = view.getMeasuredWidth();
        int i2 = iArr[0];
        int i4 = iArr[1];
        int dimension = (int) this.f875i.getResources().getDimension(R.dimen.sim_button_container_margin_end);
        int measuredWidth2 = this.f883r.getMeasuredWidth();
        int i5 = (((i2 + measuredWidth) - 0) - measuredWidth2) - dimension;
        showAtLocation(view, 0, i5, (i4 - this.f872D) - 0);
        int i6 = this.f872D;
        update(i5, (i4 - i6) - 0, measuredWidth2, i6);
        if (this.f876j.isSelected()) {
            this.f869A.setVisibility(0);
            this.f871C.setVisibility(8);
        } else if (this.f878l.isSelected()) {
            this.f869A.setVisibility(8);
            this.f871C.setVisibility(0);
        } else {
            this.f869A.setVisibility(8);
            this.f871C.setVisibility(8);
        }
        setWidth(-2);
        setHeight(-2);
    }

    public final void i(View.OnClickListener onClickListener) {
        if (this.f887w != onClickListener) {
            this.f887w = onClickListener;
        }
    }

    public final void j(View.OnClickListener onClickListener) {
        if (this.f888x != onClickListener) {
            this.f888x = onClickListener;
        }
    }

    public final void l(View.OnClickListener onClickListener) {
        if (this.f889y != onClickListener) {
            this.f889y = onClickListener;
        }
    }

    public final void n(int i2) {
        if (i2 > -1) {
            this.f877k.setSelected(false);
            this.f879m.setSelected(false);
            this.u = 0;
            this.f881o.setText(R.string.sub_sim_card);
            this.f882q.setText(R.string.sub_sim_card);
        }
        if (i2 == 0) {
            this.f876j.setSelected(true);
            this.f878l.setSelected(false);
        } else {
            if (i2 != 1) {
                return;
            }
            this.f876j.setSelected(false);
            this.f878l.setSelected(true);
        }
    }

    public final void o(int i2) {
        if (!this.f886v) {
            this.f877k.setVisibility(8);
            this.f879m.setVisibility(8);
            return;
        }
        if (i2 > 0) {
            this.f876j.setSelected(false);
            this.f878l.setSelected(false);
        }
        this.f877k.setVisibility(8);
        this.f879m.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.sim_button1 /* 2131362290 */:
                this.f885t = 0;
                n(0);
                View.OnClickListener onClickListener = this.f887w;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                dismiss();
                break;
            case R.id.sim_button2 /* 2131362294 */:
                this.f885t = 1;
                n(1);
                View.OnClickListener onClickListener2 = this.f888x;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                dismiss();
                break;
            case R.id.sub_sim_button1 /* 2131362328 */:
            case R.id.sub_sim_button2 /* 2131362330 */:
                Activity activity = (Activity) this.f875i;
                Objects.requireNonNull(H0.b.a());
                K k2 = new K(activity);
                this.f884s = k2;
                k2.d();
                break;
        }
    }
}
