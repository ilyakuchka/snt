package Q0;

import Q0.ViewOnClickListenerC0169b;
import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.mmt.R;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public final class w extends ViewOnClickListenerC0169b<L0.a> implements C0414a.c {

    /* renamed from: I, reason: collision with root package name */
    private ImageView f1177I;

    /* renamed from: J, reason: collision with root package name */
    private TextView f1178J;

    /* renamed from: K, reason: collision with root package name */
    private TextView f1179K;
    private LinearLayout L;
    private ImageView M;

    /* renamed from: N, reason: collision with root package name */
    private ImageView f1180N;

    /* renamed from: O, reason: collision with root package name */
    private ImageView f1181O;
    private TextView P;

    /* renamed from: Q, reason: collision with root package name */
    private View f1182Q;

    /* renamed from: R, reason: collision with root package name */
    protected int f1183R;

    /* renamed from: S, reason: collision with root package name */
    private C0416c f1184S;

    /* renamed from: T, reason: collision with root package name */
    private char[] f1185T;

    /* renamed from: U, reason: collision with root package name */
    private Runnable f1186U;

    final class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            w.this.I(C0416c.v(((L0.a) w.this.f1090E).f()));
        }
    }

    public w(View view, ViewOnClickListenerC0169b.InterfaceC0031b<L0.a> interfaceC0031b, ViewOnClickListenerC0169b.a aVar) {
        super(view, interfaceC0031b, aVar);
        this.f1185T = new char[64];
        this.f1186U = new a();
        this.f1177I = (ImageView) view.findViewById(R.id.unread_indicator);
        this.f1178J = (TextView) view.findViewById(R.id.from);
        this.f1179K = (TextView) view.findViewById(R.id.subject);
        this.P = (TextView) view.findViewById(R.id.date);
        this.f1182Q = view.findViewById(R.id.end_holder);
        this.f1183R = (int) view.getContext().getResources().getDimension(R.dimen.multi_checkbox_size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(C0416c c0416c) {
        boolean z4;
        String strW = c0416c.G().size() == 1 ? c0416c.G().get(0).W() : null;
        if (C0414a.T() != 2) {
            z4 = true;
        } else {
            if (!TextUtils.isEmpty(strW)) {
                synchronized (c0416c) {
                }
            }
            z4 = false;
        }
        if (z4) {
            c0416c.Q(false, true);
        }
        C0414a.n0(this);
        C0414a.J(this, strW);
        this.f1178J.setText(this.f1185T, 0, c0416c.G().g(this.f1185T));
        if (c0416c.G().size() < 1 || !TextUtils.isEmpty(c0416c.G().get(0).b0())) {
            return;
        }
        this.f1178J.setContentDescription(PhoneNumberUtils.createTtsSpannable(strW));
    }

    @Override // Q0.ViewOnClickListenerC0169b
    protected final void E(boolean z4, float f4) {
        if (z4) {
            C();
            this.f1088C.setAlpha(f4);
            float f5 = (0.2f * f4) + 0.8f;
            this.f1088C.setScaleX(f5);
            this.f1088C.setScaleY(f5);
            this.f1088C.setVisibility(0);
            ConstraintLayout.a aVar = (ConstraintLayout.a) this.f1182Q.getLayoutParams();
            aVar.setMarginEnd((int) (this.f1183R * f4));
            this.f1182Q.setLayoutParams(aVar);
            return;
        }
        CheckBox checkBox = this.f1088C;
        if (checkBox != null) {
            float f6 = 1.0f - f4;
            checkBox.setAlpha(f6);
            float f7 = 1.0f - (f4 * 0.2f);
            this.f1088C.setScaleX(f7);
            this.f1088C.setScaleY(f7);
            this.f1088C.setVisibility(0);
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f1182Q.getLayoutParams();
            aVar2.setMarginEnd((int) (this.f1183R * f6));
            this.f1182Q.setLayoutParams(aVar2);
        }
    }

    @Override // Q0.ViewOnClickListenerC0169b
    protected final void F(boolean z4, boolean z5) {
        super.F(z4, true);
        this.f1178J.setActivated(false);
        this.f1179K.setActivated(false);
    }

    public final void H(int i2, L0.a aVar, boolean z4, boolean z5, boolean z6) {
        B(i2, aVar, z4, z6);
        this.f1184S = C0416c.v(aVar.f());
        boolean z7 = !(aVar.h() == 1);
        this.f1177I.setVisibility(z7 ? 0 : 8);
        if (z7) {
            this.f1177I.setImageResource(R.drawable.unread);
        }
        I(this.f1184S);
        TextView textView = this.f1179K;
        textView.setText(C0416c.t(textView.getContext(), P0.r.e(aVar.i(), aVar.j())));
        this.P.setVisibility(0);
        this.P.setText(C3.c.c(this.f1089D.getContext(), aVar.b()));
        boolean zO = aVar.o();
        boolean zP = aVar.p();
        boolean zQ = aVar.q();
        Context context = this.f1089D.getContext();
        if (zO || zP || zQ) {
            if (this.L == null) {
                ViewStub viewStub = (ViewStub) this.f1089D.findViewById(R.id.indicator_container);
                if (viewStub != null) {
                    viewStub.inflate();
                }
                this.L = (LinearLayout) this.f1089D.findViewById(R.id.indicator_container);
            }
            this.L.removeAllViews();
            if (zO) {
                if (this.M == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.conversation_list_item_indicator, (ViewGroup) this.L, false);
                    this.M = imageView;
                    imageView.setContentDescription(context.getString(R.string.type_attachment));
                    this.M.setImageResource(R.drawable.conversation_attachment_indicator);
                }
                this.L.addView(this.M);
            }
            if (zP) {
                if (this.f1180N == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(context).inflate(R.layout.conversation_list_item_indicator, (ViewGroup) this.L, false);
                    this.f1180N = imageView2;
                    imageView2.setContentDescription(context.getString(R.string.draft));
                    this.f1180N.setImageResource(R.drawable.conversation_draft_indicator);
                }
                this.L.addView(this.f1180N);
            }
            if (zQ) {
                if (this.f1181O == null) {
                    ImageView imageView3 = (ImageView) LayoutInflater.from(context).inflate(R.layout.conversation_list_item_indicator, (ViewGroup) this.L, false);
                    this.f1181O = imageView3;
                    imageView3.setContentDescription(context.getString(R.string.failed_to_send));
                    this.f1181O.setImageResource(R.drawable.conversation_error_indicator);
                }
                this.L.addView(this.f1181O);
            }
        } else {
            LinearLayout linearLayout = this.L;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
        }
        this.f1089D.setSelected(false);
        super.F(z4 && z5, false);
        this.f1178J.setActivated(false);
        this.f1179K.setActivated(false);
    }

    @Override // x0.C0414a.c
    public final void t(C0414a c0414a) {
        C0416c c0416c;
        C0415b c0415bG;
        if (c0414a == null || (c0416c = this.f1184S) == null || (c0415bG = c0416c.G()) == null || !c0415bG.contains(c0414a)) {
            return;
        }
        S2.e.a().removeCallbacks(this.f1186U);
        S2.e.a().post(this.f1186U);
    }
}
