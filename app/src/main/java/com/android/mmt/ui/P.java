package com.android.mmt.ui;

import O0.f;
import P0.ActivityC0156b;
import P0.InterfaceC0164j;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.H;
import com.android.mmt.ui.P;
import com.android.mmt.ui.SizeAwareLinearLayout;
import com.android.mmt.util.C0273e;
import com.android.mmt.util.C0287t;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import miuix.appcompat.app.g;
import s0.C0380a;
import t.C0384b;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;
import x0.C0417d;
import x0.j;

/* loaded from: classes.dex */
public abstract class P extends ActivityC0156b implements j.b, View.OnClickListener, SizeAwareLinearLayout.a, InterfaceC0164j, C0414a.c {

    /* renamed from: N0, reason: collision with root package name */
    public static final /* synthetic */ int f5210N0 = 0;

    /* renamed from: A, reason: collision with root package name */
    protected boolean f5211A;

    /* renamed from: B, reason: collision with root package name */
    protected boolean f5213B;

    /* renamed from: B0, reason: collision with root package name */
    private SharedPreferences f5214B0;

    /* renamed from: C, reason: collision with root package name */
    protected FrameLayout f5215C;

    /* renamed from: D, reason: collision with root package name */
    protected SizeAwareLinearLayout f5217D;

    /* renamed from: E, reason: collision with root package name */
    protected View f5219E;

    /* renamed from: F, reason: collision with root package name */
    protected View f5221F;

    /* renamed from: G, reason: collision with root package name */
    protected View f5223G;

    /* renamed from: H, reason: collision with root package name */
    protected TextView f5225H;

    /* renamed from: I, reason: collision with root package name */
    protected H f5227I;

    /* renamed from: J, reason: collision with root package name */
    private H.a f5229J;

    /* renamed from: K, reason: collision with root package name */
    protected EditText f5231K;
    protected View L;
    protected AttachmentView M;

    /* renamed from: N, reason: collision with root package name */
    protected EditText f5235N;

    /* renamed from: O, reason: collision with root package name */
    protected TextView f5236O;
    protected View P;

    /* renamed from: Q, reason: collision with root package name */
    protected View f5237Q;

    /* renamed from: R, reason: collision with root package name */
    protected View f5238R;

    /* renamed from: S, reason: collision with root package name */
    protected View f5239S;

    /* renamed from: T, reason: collision with root package name */
    protected View f5240T;

    /* renamed from: U, reason: collision with root package name */
    protected x0.j f5241U;

    /* renamed from: V, reason: collision with root package name */
    protected ImageButton f5242V;

    /* renamed from: W, reason: collision with root package name */
    private TextView f5243W;

    /* renamed from: X, reason: collision with root package name */
    private ImageView f5244X;

    /* renamed from: Y, reason: collision with root package name */
    protected P0.D f5245Y;

    /* renamed from: Z, reason: collision with root package name */
    protected C0416c f5246Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f5247a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f5248b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f5249c0;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f5250d0;

    /* renamed from: e0, reason: collision with root package name */
    protected InputMethodManager f5251e0;

    /* renamed from: f0, reason: collision with root package name */
    protected C0230a f5252f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f5253g0;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f5254h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f5255i0;

    /* renamed from: j0, reason: collision with root package name */
    protected Dialog f5256j0;

    /* renamed from: k0, reason: collision with root package name */
    private miuix.appcompat.app.g f5257k0;

    /* renamed from: l0, reason: collision with root package name */
    private miuix.appcompat.app.g f5258l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f5259m0;

    /* renamed from: o0, reason: collision with root package name */
    private int f5261o0;
    private P0.z p0;
    protected int q0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f5262r0;

    /* renamed from: s0, reason: collision with root package name */
    protected int f5263s0;

    /* renamed from: t0, reason: collision with root package name */
    private long f5264t0;

    /* renamed from: u0, reason: collision with root package name */
    private long f5265u0;

    /* renamed from: v0, reason: collision with root package name */
    private P f5267v0;

    /* renamed from: w, reason: collision with root package name */
    protected int f5268w;

    /* renamed from: w0, reason: collision with root package name */
    protected Long f5269w0;

    /* renamed from: x, reason: collision with root package name */
    protected int f5270x;

    /* renamed from: z, reason: collision with root package name */
    protected int f5274z;

    /* renamed from: v, reason: collision with root package name */
    private final HashSet<Integer> f5266v = new HashSet<>();

    /* renamed from: y, reason: collision with root package name */
    protected int f5272y = 0;

    /* renamed from: n0, reason: collision with root package name */
    private int f5260n0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f5271x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    protected Handler f5273y0 = new v(this);

    /* renamed from: z0, reason: collision with root package name */
    private x f5275z0 = new x(this);

    /* renamed from: A0, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f5212A0 = new e();

    /* renamed from: C0, reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f5216C0 = new l();

    /* renamed from: D0, reason: collision with root package name */
    private Runnable f5218D0 = new s();

    /* renamed from: E0, reason: collision with root package name */
    protected final TextWatcher f5220E0 = new b();

    /* renamed from: F0, reason: collision with root package name */
    private Runnable f5222F0 = new c();

    /* renamed from: G0, reason: collision with root package name */
    private Toast f5224G0 = null;

    /* renamed from: H0, reason: collision with root package name */
    private final View.OnKeyListener f5226H0 = new k();

    /* renamed from: I0, reason: collision with root package name */
    private final TextWatcher f5228I0 = new m();

    /* renamed from: J0, reason: collision with root package name */
    private Runnable f5230J0 = new o();

    /* renamed from: K0, reason: collision with root package name */
    protected SubscriptionManager.OnSubscriptionsChangedListener f5232K0 = new w(this);

    /* renamed from: L0, reason: collision with root package name */
    protected f.h f5233L0 = new u(this);

    /* renamed from: M0, reason: collision with root package name */
    private BroadcastReceiver f5234M0 = new p();

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            P.this.w0();
        }
    }

    final class b implements TextWatcher {
        b() {
            System.currentTimeMillis();
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                P.this.p0();
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            P.this.f5235N.getText().toString();
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            String string = charSequence.toString();
            if (TextUtils.isEmpty(string) || string.length() <= 2000) {
                P.this.onUserInteraction();
                P.this.f5241U.a0(charSequence);
                P.j0(P.this);
                P.this.X0();
                return;
            }
            P p = P.this;
            Toast.makeText(p, p.getString(R.string.exceed_message_text_limitation), 1).show();
            P.this.f5235N.setText(string.substring(0, 2000));
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.v("MsgEditableActivityBase", "run updateSendButtonState");
            P.this.m1();
        }
    }

    final class d implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f5279i;

        d(boolean z4) {
            this.f5279i = z4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            P p = P.this;
            boolean z4 = this.f5279i;
            Objects.requireNonNull(p);
            Toast.makeText(p, z4 ? R.string.converting_to_picture_message : R.string.converting_to_text_message, 0).show();
            P.this.l1(this.f5279i);
            P.this.W0();
            P.this.f5252f0.D();
        }
    }

    final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Objects.requireNonNull(P.this);
            P p = P.this;
            if (p.f5213B) {
                return;
            }
            p.f5273y0.post(p.f5275z0);
        }
    }

    final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            P p = P.this;
            p.M.j(p.f5241U);
            P.this.f5252f0.D();
            P.this.t0();
        }
    }

    final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            P p = P.this;
            p.S0();
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(p.getBaseContext(), R.anim.disappear);
            animationLoadAnimation.setDuration(0L);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC0231a0(p));
            p.findViewById(R.id.message_content_panel).startAnimation(animationLoadAnimation);
        }
    }

    final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (P.this.f5247a0) {
                P.this.finish();
            }
        }
    }

    final class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            P.this.f5253g0 = false;
            if (P.this.f5224G0 == null) {
                P p = P.this;
                p.f5224G0 = Toast.makeText(p, R.string.too_many_unsent_mms, 1);
            }
            P.this.f5224G0.show();
        }
    }

    final class j implements View.OnTouchListener {
        j() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            P.this.k1();
            Objects.requireNonNull(P.this);
            if (!P.this.f5252f0.x()) {
                return false;
            }
            Objects.requireNonNull(P.this);
            return false;
        }
    }

    final class k implements View.OnKeyListener {
        k() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i2 != 67 || P.this.f5231K.length() != 0) {
                return false;
            }
            P.this.i1(false);
            EditText editText = P.this.f5235N;
            if (editText != null) {
                editText.requestFocus();
            }
            P.this.f5241U.Z(null, true);
            return true;
        }
    }

    final class l implements SharedPreferences.OnSharedPreferenceChangeListener {
        l() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            P.this.T0(str);
        }
    }

    final class m implements TextWatcher {

        /* renamed from: i, reason: collision with root package name */
        private CharSequence f5289i = null;

        /* renamed from: j, reason: collision with root package name */
        private int f5290j = 0;

        /* renamed from: k, reason: collision with root package name */
        private boolean f5291k = true;

        /* renamed from: l, reason: collision with root package name */
        private Toast f5292l = null;

        m() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            boolean zBooleanValue;
            this.f5291k = true;
            boolean z4 = false;
            for (int i2 = 0; i2 < editable.length(); i2++) {
                if (editable.charAt(i2) > 127) {
                    try {
                        zBooleanValue = ((Boolean) Class.forName("com.android.internal.telephony.GsmAlphabet").getDeclaredMethod("isGsmSeptets", Character.TYPE).invoke(null, Character.valueOf(editable.charAt(i2)))).booleanValue();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        zBooleanValue = false;
                    }
                    if (!zBooleanValue) {
                        this.f5291k = false;
                    }
                }
            }
            if ((!this.f5291k && editable.length() > 13) || (this.f5291k && editable.length() > 40)) {
                z4 = true;
            }
            if (z4) {
                int i4 = this.f5291k ? R.string.english_subject_limit : R.string.non_english_subject_limit;
                Toast toast = this.f5292l;
                if (toast == null) {
                    this.f5292l = Toast.makeText(P.this, i4, 1);
                } else {
                    toast.setText(i4);
                }
                this.f5292l.show();
                P p = P.this;
                p.f5231K.removeTextChangedListener(p.f5228I0);
                P.this.f5231K.setText(this.f5289i);
                P.this.f5231K.setSelection(this.f5290j);
                P p4 = P.this;
                p4.f5231K.addTextChangedListener(p4.f5228I0);
            }
            if (P.this.H0()) {
                P p5 = P.this;
                p5.f5241U.Z(p5.f5231K.getText(), true);
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            this.f5289i = charSequence.subSequence(0, charSequence.length());
            this.f5290j = i2 + i4;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final class n implements H.a {
        n() {
        }

        public final void a() {
            P.this.f5225H.setClickable(true);
        }
    }

    final class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.v("MsgEditableActivityBase", "run mSwitchMsgTypeRunnable");
            if (P.this.z0() == null) {
                Log.v("MsgEditableActivityBase", "mSwitchMsgTypeRunnable recipients is null");
            } else {
                P.this.X0();
            }
        }
    }

    final class p extends BroadcastReceiver {
        p() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                P p = P.this;
                intent.getBooleanExtra("state", false);
                Objects.requireNonNull(p);
                P.this.X0();
                return;
            }
            x0.j jVar = P.this.f5241U;
            if (jVar == null || !jVar.G()) {
                return;
            }
            if ("com.miui.fullscreen_state_change".equals(action)) {
                if ("toHome".equals(intent.getStringExtra("state"))) {
                    P.this.f5249c0 = true;
                }
            } else if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) && "homekey".equals(intent.getStringExtra("reason"))) {
                P.this.f5249c0 = true;
            }
        }
    }

    final class q implements DialogInterface.OnClickListener {
        q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (P.this.f5257k0 != null) {
                P.this.f5257k0.dismiss();
                P.this.f5257k0 = null;
            }
        }
    }

    final class r implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ IntentFilter f5298i;

        r(IntentFilter intentFilter) {
            this.f5298i = intentFilter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (P.this.isFinishing() || P.this.isDestroyed()) {
                return;
            }
            C0384b.t(P.this.f5267v0, P.this.f5234M0, this.f5298i);
            P.this.f5271x0 = true;
        }
    }

    final class s implements Runnable {
        s() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            P p = P.this;
            C0416c c0416c = p.f5246Z;
            if (c0416c != null) {
                p.M0(c0416c.G());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class t implements DialogInterface.OnClickListener {
        t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            P.this.f5241U.r();
            dialogInterface.dismiss();
            if (P.this.isFinishing() || P.this.isDestroyed()) {
                return;
            }
            P.this.f5273y0.postDelayed(new I(this, 1), 200L);
        }
    }

    private static class u implements f.h {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<P> f5302a;

        public u(P p) {
            this.f5302a = new WeakReference<>(p);
        }

        @Override // O0.f.h
        public final void a() {
            P p = this.f5302a.get();
            if (com.android.mmt.util.e0.e(p)) {
                Log.d("MsgEditableActivityBase", "update sim state change");
                p.f5262r0 = false;
                p.q1();
                p.X0();
            }
        }
    }

    private static class v extends com.android.mmt.util.f0<P> {
        v(P p) {
            super(p);
        }

        @Override // com.android.mmt.util.f0
        public final void a(P p, Message message) {
            P p4 = p;
            StringBuilder sbD = D2.e.d("handle msg on main thread, msg: ");
            sbD.append(message.what);
            Log.v("MsgEditableActivityBase", sbD.toString());
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 3) {
                    C0415b c0415bZ0 = p4.z0();
                    if (c0415bZ0 == null) {
                        return;
                    }
                    if (!c0415bZ0.contains(C0414a.O((String) message.obj))) {
                        Log.w("MsgEditableActivityBase", "recipient is no longer in list");
                        return;
                    } else {
                        message.getData().getLong("capability");
                        p4.W0();
                        return;
                    }
                }
                if (i2 != 4) {
                    if (i2 != 5) {
                        return;
                    }
                    p4.W0();
                    return;
                }
            }
            message.getData().getLong("capability");
            if (message.what == 1) {
                p4.W0();
            }
        }
    }

    private static class w extends SubscriptionManager.OnSubscriptionsChangedListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<P> f5303a;

        public w(P p) {
            this.f5303a = new WeakReference<>(p);
        }

        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
        public final void onSubscriptionsChanged() {
            P p = this.f5303a.get();
            if (com.android.mmt.util.e0.e(p)) {
                boolean z4 = true;
                if (C0287t.y()) {
                    long jM = C0287t.m(0);
                    long jM2 = C0287t.m(1);
                    if (p.f5264t0 == jM && p.f5265u0 == jM2) {
                        z4 = false;
                    } else {
                        p.f5264t0 = jM;
                        p.f5265u0 = jM2;
                    }
                } else {
                    p.f5264t0 = -1L;
                    p.f5265u0 = -1L;
                }
                if (!z4) {
                    p.n1();
                    return;
                }
                Log.d("MsgEditableActivityBase", "update sim info change");
                p.f5262r0 = false;
                p.q1();
                p.X0();
                p.L0();
                p.r0();
            }
        }
    }

    private static class x implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<P> f5304i;

        x(P p) {
            this.f5304i = new WeakReference<>(p);
        }

        @Override // java.lang.Runnable
        public final void run() throws NoSuchMethodException, SecurityException {
            int iIntValue;
            P p = this.f5304i.get();
            if (p == null) {
                Log.e("MsgEditableActivityBase", "updateSoftinput error,activity is null");
                return;
            }
            if (p.f5221F != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) p.getSystemService("input_method");
                try {
                    Method method = inputMethodManager.getClass().getMethod("getInputMethodWindowVisibleHeight", new Class[0]);
                    method.setAccessible(true);
                    iIntValue = ((Integer) method.invoke(inputMethodManager, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.e("CompatUtil", "reflection error", e2);
                    iIntValue = -1;
                }
                StringBuilder sbC = C2.c.c("UpdateSoftinputTask: ", iIntValue, " | ");
                sbC.append(p.f5261o0);
                Log.d("MsgEditableActivityBase", sbC.toString());
                if (iIntValue != p.f5261o0) {
                    p.f5261o0 = iIntValue;
                    View view = p.f5221F;
                    view.setPadding(view.getPaddingStart(), p.f5221F.getPaddingTop(), p.f5221F.getPaddingEnd(), p.f5211A ? 0 : iIntValue);
                    p.r1(iIntValue);
                }
            }
        }
    }

    private void B0() {
        if (this.P != null) {
            boolean zG0 = G0();
            this.P.setBackgroundResource(!this.f5259m0 && zG0 ? R.drawable.ic_send_btn_n : R.drawable.ic_send_btn_disable);
            this.P.setFocusable(zG0);
            this.P.setContentDescription(getString(R.string.send_sms));
            this.P.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"LogTagMismatch"})
    public void Y0() {
        if (Log.isLoggable("Mms:app", 2)) {
            Log.v("MsgEditableActivityBase", "resetMessage");
        }
        this.M.setVisibility(8);
        this.f5243W.setVisibility(8);
        this.f5225H.setVisibility(8);
        i1(false);
        this.f5235N.requestFocus();
        this.f5235N.removeTextChangedListener(this.f5220E0);
        TextKeyListener.clear(this.f5235N.getText());
        x0.j jVar = new x0.j(this);
        this.f5241U = jVar;
        jVar.U(this.f5246Z);
        t0();
        this.f5252f0.D();
        this.f5235N.addTextChangedListener(this.f5220E0);
        if (this.f5254h0) {
            C0();
        }
        this.f5253g0 = false;
    }

    private void b1(boolean z4, int i2) throws ClassNotFoundException {
        String str;
        if (z4 && Boolean.parseBoolean(S2.c.a("ril.cdma.inecmmode", ""))) {
            try {
                Class<?> cls = Class.forName("com.android.internal.telephony.TelephonyIntents");
                str = (String) cls.getField("ACTION_SHOW_NOTICE_ECM_BLOCK_OTHERS").get(cls);
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "android.intent.action.ACTION_SHOW_NOTICE_ECM_BLOCK_OTHERS";
            }
            try {
                startActivityForResult(new Intent(str, (Uri) null), 1);
                this.f5260n0 = i2;
                return;
            } catch (ActivityNotFoundException e4) {
                Log.e("MsgEditableActivityBase", "Cannot find EmergencyCallbackModeExitDialog", e4);
            }
        }
        if (this.f5253g0) {
            return;
        }
        String strZ = this.f5241U.z();
        this.f5241U.Y();
        Objects.requireNonNull(this.f5241U);
        this.f5241U.S(strZ, i2);
        this.f5253g0 = true;
    }

    private void g1(int i2) {
        String string = getString(R.string.dialog_sim_locked_message);
        g.a aVar = new g.a(this);
        StringBuilder sbD = D2.e.d("SIM");
        sbD.append(i2 + 1);
        aVar.y(sbD.toString());
        aVar.k(string);
        aVar.c(false);
        aVar.u(getString(R.string.dialog_sim_locked_confirm), new q());
        this.f5257k0 = aVar.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"LogTagMismatch"})
    public void i1(boolean z4) {
        if (Log.isLoggable("Mms:app", 2)) {
            Log.v("MsgEditableActivityBase", "showSubjectEditor: " + z4);
        }
        if (this.f5231K == null) {
            if (!z4) {
                return;
            }
            EditText editText = (EditText) findViewById(R.id.subject);
            this.f5231K = editText;
            editText.setOnTouchListener(new j());
            this.f5231K.setTextSize(0, P0.G.b().c());
            this.L = findViewById(R.id.subject_divider);
        }
        this.f5231K.setOnKeyListener(z4 ? this.f5226H0 : null);
        if (z4) {
            this.f5231K.removeTextChangedListener(this.f5228I0);
            this.f5231K.addTextChangedListener(this.f5228I0);
        } else {
            this.f5231K.removeTextChangedListener(this.f5228I0);
        }
        this.f5231K.setVisibility(z4 ? 0 : 8);
        this.f5231K.setText(this.f5241U.v());
        this.L.setVisibility(z4 ? 0 : 8);
        invalidateOptionsMenu();
    }

    static void j0(P p4) {
        p4.l1(p4.f5241U.P());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(boolean z4) {
        if (z4) {
            this.f5236O.setText(R.string.mms);
        } else {
            if (TextUtils.isEmpty(this.f5241U.w())) {
                return;
            }
            this.f5236O.setText(P0.r.k(this.f5241U.w()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        if (com.android.mmt.util.e0.d(this.f5267v0) == 5) {
            this.f5235N.setMaxLines(getResources().getInteger(R.integer.mms_text_editor_max_lines_godzillaui));
        } else {
            this.f5235N.setMaxLines(getResources().getInteger(R.integer.mms_text_editor_max_lines));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (C0287t.A(this.q0)) {
            if (C0287t.E(this.q0)) {
                g1(this.q0);
                return;
            } else {
                a1(this.q0);
                return;
            }
        }
        C0();
        Objects.requireNonNull(H0.b.a());
        P0.z zVar = new P0.z(this);
        this.p0 = zVar;
        zVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        P0.z zVar = this.p0;
        if (zVar != null && zVar.c()) {
            this.p0.b();
            this.p0 = null;
        }
        P0.D d2 = this.f5245Y;
        if (d2 != null) {
            d2.e();
            this.f5245Y.dismiss();
            this.f5245Y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(int i2) {
        if (!this.f5211A && i2 >= this.f5270x && this.f5274z != i2) {
            this.f5274z = i2;
            androidx.preference.g.c(this).edit().putInt("last_input_method_height", i2).apply();
        }
        boolean z4 = i2 >= this.f5270x && !this.f5213B;
        if (z4 != this.f5250d0 && !z4) {
            p0();
        }
        if (z4 && !this.f5250d0 && F0()) {
            s0();
        }
        this.f5250d0 = z4;
    }

    private void s1(boolean z4) {
        if (z4) {
            getWindow().setSoftInputMode(16);
        } else if ("cetus".equals(Build.DEVICE)) {
            getWindow().setSoftInputMode(50);
        } else {
            getWindow().setSoftInputMode(48);
        }
    }

    protected final boolean A0() {
        x0.j jVar = this.f5241U;
        if (jVar != null) {
            return jVar.A() || this.f5241U.D();
        }
        return false;
    }

    protected final void C0() {
        View viewFindFocus = this.f5217D.findFocus();
        if (viewFindFocus == null) {
            viewFindFocus = this.f5215C;
        }
        this.f5251e0.hideSoftInputFromWindow(viewFindFocus.getWindowToken(), 0);
    }

    protected void D0() throws Resources.NotFoundException {
        this.f5221F = findViewById(R.id.bottom_panel);
        this.f5223G = findViewById(R.id.bottom_editor);
        View viewFindViewById = findViewById(R.id.editor_container);
        this.f5239S = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.embedded_text_editor);
        this.f5235N = editText;
        editText.addTextChangedListener(this.f5220E0);
        this.f5235N.setOnTouchListener(new ViewOnTouchListenerC0235c0(this));
        this.f5235N.setOnEditorActionListener(new C0237d0(this));
        this.f5235N.setHintTextColor(getResources().getColor(R.color.hint_edit_text_color_light));
        p0();
        this.f5236O = (TextView) findViewById(R.id.text_counter);
        if (C0287t.x()) {
            this.f5264t0 = C0287t.m(0);
            this.f5265u0 = C0287t.m(1);
        } else {
            this.f5264t0 = -1L;
            this.f5265u0 = -1L;
        }
        q1();
        View viewFindViewById2 = findViewById(R.id.send_button);
        this.P = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        AttachmentView attachmentView = (AttachmentView) findViewById(R.id.attachment_view);
        this.M = attachmentView;
        attachmentView.setOnClickListener(new ViewOnClickListenerC0239e0(this));
        this.M.g(new HandlerC0241f0(this));
        this.f5243W = (TextView) findViewById(R.id.audio_name);
        Objects.requireNonNull(this.M);
        ImageButton imageButton = (ImageButton) findViewById(R.id.switch_btn);
        this.f5242V = imageButton;
        imageButton.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.timed_desc);
        this.f5225H = textView;
        textView.setOnClickListener(new N(this));
        findViewById(R.id.text_focuser).setOnClickListener(new O(this));
        findViewById(R.id.editor_audio_container);
        this.f5240T = findViewById(R.id.send_button_group);
        s1(this.f5211A);
        this.f5237Q = findViewById(R.id.message_content_panel);
        Button button = (Button) findViewById(R.id.home);
        if (button != null) {
            button.setOnClickListener(new a());
        }
        View viewFindViewById3 = findViewById(android.R.id.content);
        this.f5238R = viewFindViewById3;
        viewFindViewById3.getViewTreeObserver().addOnGlobalLayoutListener(this.f5212A0);
        if (this.f5219E != null) {
            Resources resources = getResources();
            int dimensionPixelSize = (int) ((resources.getDisplayMetrics().density + 0.5d) * 20.0d);
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                dimensionPixelSize = resources.getDimensionPixelSize(identifier);
            }
            this.f5272y = dimensionPixelSize;
            View view = this.f5219E;
            view.setPadding(view.getPaddingLeft(), this.f5219E.getPaddingTop() + this.f5272y, this.f5219E.getPaddingRight(), this.f5219E.getPaddingBottom());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x021e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void E0() throws UnsupportedEncodingException {
        boolean z4;
        String strDecode;
        boolean z5;
        String str;
        String str2;
        boolean z6;
        boolean z7;
        Bundle extras;
        boolean z8;
        boolean z9;
        Intent intent = getIntent();
        getIntent().getStringExtra("media_type");
        this.f5241U = new x0.j(this);
        Intent intent2 = getIntent();
        if (intent2.getBooleanExtra("forwarded_message", false)) {
            Uri uri = (Uri) intent2.getParcelableExtra("msg_uri");
            if (Log.isLoggable("Mms:app", 3)) {
                Log.d("MsgEditableActivityBase", "handle forwarded message " + uri);
            }
            if (uri != null) {
                x0.j jVarH = x0.j.H(this, uri, true);
                this.f5241U = jVarH;
                jVarH.Z(intent2.getStringExtra("subject"), false);
            } else {
                this.f5241U.a0(intent2.getStringExtra("sms_body"));
            }
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z10 = !z4;
        Uri data = intent.getData();
        if (data == null) {
            strDecode = null;
        } else {
            String schemeSpecificPart = data.getSchemeSpecificPart();
            if (schemeSpecificPart.contains("?")) {
                String[] strArrSplit = schemeSpecificPart.substring(schemeSpecificPart.indexOf(63) + 1).split("&");
                int length = strArrSplit.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str3 = strArrSplit[i2];
                    if (str3.startsWith("body=")) {
                        try {
                            strDecode = URLDecoder.decode(str3.substring(5), "UTF-8");
                            break;
                        } catch (UnsupportedEncodingException unused) {
                            continue;
                        }
                    }
                }
                strDecode = null;
            }
        }
        if (!TextUtils.isEmpty(strDecode)) {
            this.f5241U.a0(strDecode);
            z10 = false;
        }
        String stringExtra = intent.getStringExtra("sms_body");
        if (TextUtils.isEmpty(stringExtra)) {
            z5 = z10;
        } else {
            this.f5241U.a0(stringExtra);
            z5 = false;
        }
        String stringExtra2 = intent.getStringExtra("subject");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f5241U.Z(stringExtra2, false);
        }
        this.f5247a0 = intent.getBooleanExtra("exit_on_sent", false);
        this.f5241U.U(this.f5246Z);
        Bundle extras2 = intent.getExtras();
        if (extras2 != null) {
            String type = intent.getType();
            String action = intent.getAction();
            if (!"android.intent.action.SEND".equals(action)) {
                if ("android.intent.action.SEND_MULTIPLE".equals(action) && extras2.containsKey("android.intent.extra.STREAM")) {
                    ArrayList parcelableArrayList = extras2.getParcelableArrayList("android.intent.extra.STREAM");
                    String string = extras2.containsKey("android.intent.extra.TEXT") ? extras2.getString("android.intent.extra.TEXT") : null;
                    g.a aVar = new g.a(this);
                    aVar.h();
                    aVar.x(R.string.adding_attachments_title);
                    aVar.j(R.string.adding_attachments);
                    miuix.appcompat.app.g gVarA = aVar.a();
                    Q q2 = new Q(gVarA);
                    str = "MsgEditableActivityBase";
                    this.f5273y0.postDelayed(q2, 1000L);
                    str2 = "android.intent.extra.TEXT";
                    Q2.c.a(new S(this, parcelableArrayList, type, string, q2, gVarA));
                } else {
                    str = "MsgEditableActivityBase";
                    str2 = "android.intent.extra.TEXT";
                    if ("android.intent.action.SEND_MSG".equals(action)) {
                        Uri data2 = intent.getData();
                        if (C0416c.j(data2)) {
                            this.f5252f0.h(type, data2, false);
                        }
                    }
                }
                z6 = true;
                if (z6) {
                    z5 = false;
                }
                extras = intent.getExtras();
                if (extras == null) {
                    z8 = false;
                } else {
                    String type2 = intent.getType();
                    if ("android.intent.action.SENDTO".equals(intent.getAction())) {
                        if (extras.containsKey("android.intent.extra.STREAM")) {
                            this.f5252f0.h(type2, (Uri) extras.getParcelable("android.intent.extra.STREAM"), false);
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (extras.containsKey(str2)) {
                            this.f5241U.a0(extras.getString(str2));
                            z9 = true;
                        }
                        if (z9) {
                            z8 = true;
                        }
                    }
                }
                if (z8) {
                    z5 = false;
                }
                if (z5 && this.f5246Z.L()) {
                    if (Log.isLoggable("Mms:app", 2)) {
                        Log.v(str, "loadDraft: call WorkingMessage.loadDraft");
                    }
                    Q2.c.a(new T(this, new x0.j(this)));
                }
                if (C0287t.y()) {
                    if (!this.f5262r0 && this.f5246Z.C() > 0) {
                        Objects.requireNonNull(this.f5246Z);
                        this.f5263s0 = 0;
                    }
                    p1(this, this.q0, this.f5263s0);
                }
                u0();
                t0();
                this.M.j(this.f5241U);
                this.f5254h0 = getResources().getConfiguration().orientation == 2;
            }
            String strA = G0.d.b(this).a(intent);
            if (TextUtils.isEmpty(strA)) {
                if (extras2.containsKey("android.intent.extra.STREAM")) {
                    try {
                        this.f5252f0.h(type, (Uri) extras2.getParcelable("android.intent.extra.STREAM"), false);
                    } catch (SecurityException e2) {
                        Toast.makeText(MmsApp.c(), R.string.fail_to_add_attachment, 0).show();
                        e2.printStackTrace();
                    }
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (extras2.containsKey("android.intent.extra.TEXT")) {
                    this.f5241U.a0(extras2.getString("android.intent.extra.TEXT"));
                    z7 = true;
                }
                if (!z7) {
                    str = "MsgEditableActivityBase";
                    str2 = "android.intent.extra.TEXT";
                }
            } else {
                this.f5241U.a0(strA);
            }
            z6 = true;
            z6 = false;
            if (z6) {
            }
            extras = intent.getExtras();
            if (extras == null) {
            }
            if (z8) {
            }
            if (z5) {
                if (Log.isLoggable("Mms:app", 2)) {
                }
                Q2.c.a(new T(this, new x0.j(this)));
            }
            if (C0287t.y()) {
            }
            u0();
            t0();
            this.M.j(this.f5241U);
            this.f5254h0 = getResources().getConfiguration().orientation == 2;
        }
        z6 = false;
        str = "MsgEditableActivityBase";
        str2 = "android.intent.extra.TEXT";
        if (z6) {
        }
        extras = intent.getExtras();
        if (extras == null) {
        }
        if (z8) {
        }
        if (z5) {
        }
        if (C0287t.y()) {
        }
        u0();
        t0();
        this.M.j(this.f5241U);
        this.f5254h0 = getResources().getConfiguration().orientation == 2;
    }

    protected final boolean F0() {
        return this.f5252f0.x();
    }

    public abstract boolean G0();

    protected final boolean H0() {
        EditText editText = this.f5231K;
        return editText != null && editText.getVisibility() == 0;
    }

    protected final boolean I0(View view) {
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    public final void J0() {
        runOnUiThread(new f());
    }

    public final void K0(int i2, Uri uri) {
        runOnUiThread(new U(this, i2, uri));
    }

    protected abstract void L0();

    protected void M0(C0415b c0415b) {
    }

    public final void N0() {
        Z0(false);
        runOnUiThread(new i());
    }

    protected void O0() {
        this.f5267v0 = this;
        this.f5269w0 = Long.valueOf(getIntent().getLongExtra("thread_id", -1L));
        getIntent().getIntExtra("FROM_WHERE", 3);
        C0416c c0416cV = C0416c.v(this.f5269w0.longValue());
        this.f5246Z = c0416cV;
        c0416cV.G().o(false, true);
    }

    public final void P0() {
        runOnUiThread(new g());
    }

    public final void Q0(boolean z4) {
        runOnUiThread(new d(z4));
    }

    protected void R0() {
    }

    protected void S0() {
    }

    protected void T0(String str) {
        if ("pref_key_card_format_miui".equals(str)) {
            this.f5252f0.B();
        }
    }

    protected void U0() {
    }

    protected void V0() {
        C0();
        finish();
    }

    protected final void W0() {
        Handler handler = this.f5273y0;
        if (handler == null) {
            Log.v("MsgEditableActivityBase", "postSwitchMsgType mHandler is null");
        } else {
            handler.removeCallbacks(this.f5230J0);
            this.f5273y0.postDelayed(this.f5230J0, 10L);
        }
    }

    public final void X0() {
        Handler handler = this.f5273y0;
        if (handler == null) {
            Log.v("MsgEditableActivityBase", "postUpdateSendButtonState mHandler is null");
        } else {
            handler.removeCallbacks(this.f5222F0);
            this.f5273y0.postDelayed(this.f5222F0, 10L);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    protected void Z0(boolean z4) {
        if (this.f5241U.E()) {
            this.f5249c0 = false;
            return;
        }
        if (!this.f5248b0 && !this.f5241U.G()) {
            if (Log.isLoggable("Mms:app", 2)) {
                Log.v("MsgEditableActivityBase", "saveDraft: not worth saving, discard WorkingMessage and bail");
            }
            this.f5241U.r();
            this.f5249c0 = false;
            return;
        }
        if (Log.isLoggable("Mms:app", 2)) {
            Log.v("MsgEditableActivityBase", "saveDraft: call WorkingMessage.saveDraft");
        }
        this.f5241U.R(z4);
        if (this.f5249c0) {
            this.f5249c0 = false;
            runOnUiThread(new Runnable() { // from class: P0.l
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = P.f5210N0;
                    S2.f.a(C0.a.c().getString(R.string.message_saved_as_draft));
                }
            });
        }
    }

    public abstract void a1(int i2);

    public final void c1(Dialog dialog) {
        this.f5256j0 = dialog;
    }

    @Override // P0.InterfaceC0164j
    public void d(float f4) {
        EditText editText = this.f5235N;
        if (editText != null) {
            editText.setTextSize(0, f4);
        }
        EditText editText2 = this.f5231K;
        if (editText2 != null) {
            editText2.setTextSize(0, f4);
        }
    }

    public final void d1() {
        long jX = this.f5241U.x();
        if (jX == 0) {
            jX = System.currentTimeMillis() + 600000;
        }
        if (isFinishing()) {
            return;
        }
        H h2 = this.f5227I;
        if (h2 != null) {
            h2.dismiss();
        }
        this.f5227I = new H(this);
        this.f5225H.setClickable(false);
        if (this.f5229J == null) {
            this.f5229J = new n();
        }
        this.f5227I.p(this.f5229J);
        this.f5227I.q(jX);
        this.f5227I.show();
    }

    public final void e1(int i2) {
        this.f5255i0 = i2;
        ((ViewGroup.MarginLayoutParams) this.f5217D.getLayoutParams()).topMargin = this.f5255i0;
        this.f5217D.requestLayout();
    }

    public final void f1(int i2) {
        this.f5263s0 = 0;
        Log.v("MsgEditableActivityBase", "setUseSubSimOrderId slotId = " + i2);
        if (C0287t.E(i2)) {
            g1(i2);
            return;
        }
        this.q0 = i2;
        if (C0287t.A(i2)) {
            p1(this, i2, 0);
            P0.D d2 = this.f5245Y;
            if (d2 != null) {
                d2.n(i2);
                this.f5245Y.o(0);
            }
            W0();
        }
    }

    protected final boolean h1() {
        View viewFindFocus = this.f5215C.findFocus();
        if (viewFindFocus == null) {
            if (I0(this.f5235N)) {
                this.f5235N.requestFocus();
                viewFindFocus = this.f5235N;
            } else if (I0(this.f5231K)) {
                this.f5231K.requestFocus();
                viewFindFocus = this.f5231K;
            }
        }
        if (viewFindFocus == null) {
            return false;
        }
        this.f5251e0.showSoftInput(viewFindFocus, 0);
        return true;
    }

    public void j() {
        if (isDestroyed()) {
            return;
        }
        runOnUiThread(new h());
    }

    public final void j1() {
        if (H0()) {
            this.f5241U.Z(null, true);
            i1(false);
            this.f5235N.requestFocus();
        } else {
            this.f5241U.Z("", true);
            i1(true);
            this.f5231K.requestFocus();
            B0();
        }
        W0();
    }

    protected void k1() {
    }

    public void l() {
        if (!this.f5250d0 || TextUtils.isEmpty(this.f5235N.getText()) || this.f5237Q.getBottom() <= this.f5239S.getBottom()) {
            return;
        }
        EditText editText = this.f5235N;
        editText.setHeight(editText.getHeight() - (this.f5237Q.getBottom() - this.f5239S.getBottom()));
    }

    public final void m1() {
        B0();
    }

    public final void n0() {
        this.f5225H.setVisibility(8);
        this.f5241U.b0(0L);
        this.f5241U.c0("");
        W0();
    }

    protected final void n1() {
        String strK = C0287t.k(0);
        if (!TextUtils.isEmpty(strK)) {
            P0.D.k(0, strK);
        }
        String strK2 = C0287t.k(1);
        if (TextUtils.isEmpty(strK2)) {
            return;
        }
        P0.D.k(1, strK2);
    }

    protected final void o0(int i2) throws ClassNotFoundException {
        b1(true, i2);
    }

    protected final void o1(int i2) {
        this.f5263s0 = 0;
        if (i2 == 0) {
            this.f5244X.setImageResource(R.drawable.msg_edit_sim1);
            this.f5244X.setContentDescription(getString(R.string.sim_card1));
        } else if (i2 != 1) {
            this.f5244X.setImageResource(R.drawable.msg_edit_default);
            this.f5244X.setContentDescription(getString(R.string.select_sim));
        } else {
            this.f5244X.setImageResource(R.drawable.msg_edit_sim2);
            this.f5244X.setContentDescription(getString(R.string.sim_card2));
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i4, Intent intent) throws ClassNotFoundException {
        super.onActivityResult(i2, i4, intent);
        this.f5248b0 = false;
        x0.j jVar = this.f5241U;
        if (jVar != null && jVar.F()) {
            this.f5241U.O();
        }
        if (i2 != 1) {
            this.f5252f0.z(i2, i4, intent);
            return;
        }
        if (intent != null ? intent.getBooleanExtra("exit_ecm_result", false) : false) {
            b1(false, this.f5260n0);
        }
        this.f5260n0 = -1;
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.M.f()) {
            return;
        }
        if (!F0()) {
            w0();
        } else if (this.f5252f0.y()) {
            s0();
        } else {
            this.f5252f0.q(true);
        }
    }

    public void onClick(View view) {
        boolean z4 = true;
        switch (view.getId()) {
            case R.id.editor_container /* 2131362004 */:
                EditText editText = this.f5235N;
                if (editText != null) {
                    editText.requestFocus();
                    this.f5273y0.postDelayed(new Y(this, true), 200L);
                    return;
                }
                return;
            case R.id.send_button /* 2131362271 */:
                if (!this.f5241U.P() || z0().size() <= 50) {
                    z4 = false;
                } else {
                    g.a aVar = new g.a(this);
                    aVar.h();
                    aVar.x(R.string.cannot_send_message);
                    aVar.j(R.string.recipients_over_size);
                    aVar.t(R.string.yes, null);
                    aVar.A();
                }
                if (!z4) {
                    Objects.requireNonNull(this.f5241U);
                    if (((z0() == null || z0().size() <= 0) ? 0 : z0().size()) <= 0) {
                        Toast.makeText(this, R.string.select_phone_number, 0).show();
                        return;
                    } else if (G0()) {
                        q0();
                    }
                }
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.restartInput(y0());
                    return;
                }
                return;
            case R.id.send_slot_id /* 2131362273 */:
                Objects.requireNonNull(this.f5246Z);
                if (C0287t.y() || this.f5246Z.I() == 0 || this.f5246Z.C() <= 0) {
                    P0.D d2 = this.f5245Y;
                    boolean z5 = d2 == null || !d2.isShowing();
                    P0.D d4 = this.f5245Y;
                    if (d4 != null || z5) {
                        if (d4 == null) {
                            P0.D d5 = new P0.D(this, this.q0, this.f5263s0);
                            this.f5245Y = d5;
                            d5.i(new V(this));
                            this.f5245Y.j(new W(this));
                            this.f5245Y.l(new X(this));
                        }
                        if (z5) {
                            this.f5245Y.h(this.f5221F);
                            return;
                        } else {
                            this.f5245Y.dismiss();
                            return;
                        }
                    }
                    return;
                }
                return;
            case R.id.switch_btn /* 2131362341 */:
                if (F0()) {
                    synchronized (this.f5266v) {
                        this.f5266v.remove(0);
                    }
                    if (!h1() || this.f5211A) {
                        s0();
                    }
                } else {
                    C0();
                    View view2 = this.f5221F;
                    view2.setPadding(view2.getPaddingStart(), this.f5221F.getPaddingTop(), this.f5221F.getPaddingEnd(), 0);
                    if (this.f5250d0) {
                        synchronized (this.f5266v) {
                            this.f5266v.add(0);
                        }
                    } else {
                        v0();
                    }
                }
                U0();
                return;
            default:
                return;
        }
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z4 = configuration.orientation == 2;
        if (this.f5254h0 != z4) {
            this.f5254h0 = z4;
            AttachmentView attachmentView = this.M;
            if (attachmentView != null) {
                attachmentView.j(this.f5241U);
            }
        }
    }

    @Override // P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        this.f5267v0 = this;
        if (getIntent().getBooleanExtra("showUI", false)) {
            ((KeyguardManager) getSystemService("keyguard")).requestDismissKeyguard(this, null);
        }
        int intExtra = getIntent().getIntExtra("call_slot_id", -1);
        if (C0287t.A(intExtra)) {
            this.q0 = intExtra;
            this.f5262r0 = true;
        }
        super.onCreate(bundle);
        this.f5270x = getResources().getDimensionPixelSize(R.dimen.soft_keyboard_min_height);
        this.f5268w = getResources().getDimensionPixelSize(R.dimen.message_content_panel_min_height);
        this.f5274z = androidx.preference.g.c(this).getInt("last_input_method_height", -1);
        int i2 = getResources().getDisplayMetrics().heightPixels / 2;
        this.f5211A = C0384b.q(this);
        setContentView(x0());
        FrameLayout frameLayout = (FrameLayout) findViewById(android.R.id.content);
        this.f5215C = frameLayout;
        SizeAwareLinearLayout sizeAwareLinearLayout = (SizeAwareLinearLayout) frameLayout.findViewById(R.id.msg_content);
        this.f5217D = sizeAwareLinearLayout;
        sizeAwareLinearLayout.a(this);
        this.f5252f0 = new C0230a(this);
        this.f5251e0 = (InputMethodManager) getSystemService("input_method");
        int i4 = P0.r.f937c;
        getTheme().resolveAttribute(android.R.attr.textCursorDrawable, new TypedValue(), true);
        this.f5219E = this.f5215C.findViewById(R.id.contact_panel);
        this.f5235N = (EditText) findViewById(R.id.embedded_text_editor);
        D0();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("com.miui.fullscreen_state_change");
        this.f5215C.post(new r(intentFilter));
        if (C0287t.x()) {
            C0287t.H(this.f5232K0);
        } else {
            O0.f.j().s(this.f5233L0);
        }
        Settings.Global.getInt(getContentResolver(), "airplane_mode_on", 0);
        this.f5259m0 = com.android.mmt.util.c0.a(this);
        SharedPreferences sharedPreferencesC = androidx.preference.g.c(this);
        this.f5214B0 = sharedPreferencesC;
        sharedPreferencesC.registerOnSharedPreferenceChangeListener(this.f5216C0);
        if (this.f5259m0) {
            Y1.a.d("sms function disabled, disable text editor", new Object[0]);
            this.f5235N.setEnabled(false);
        }
        if ("cetus".equals(Build.DEVICE)) {
            this.f5217D.setOnDragListener(new ViewOnDragListenerC0233b0(this));
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected void onDestroy() {
        EditText editText = this.f5235N;
        if (editText != null) {
            editText.removeTextChangedListener(this.f5220E0);
        }
        H h2 = this.f5227I;
        if (h2 != null && h2.isShowing()) {
            this.f5227I.dismiss();
        }
        if (this.f5271x0) {
            unregisterReceiver(this.f5234M0);
        }
        if (C0287t.x()) {
            C0287t.M(this.f5232K0);
        } else {
            O0.f.j().t(this.f5233L0);
        }
        Handler handler = this.f5273y0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        SharedPreferences sharedPreferences = this.f5214B0;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.f5216C0);
        }
        AttachmentView attachmentView = this.M;
        if (attachmentView != null) {
            attachmentView.c();
        }
        if (this.f5212A0 != null) {
            this.f5238R.getViewTreeObserver().removeOnGlobalLayoutListener(this.f5212A0);
        }
        miuix.appcompat.app.g gVar = this.f5257k0;
        if (gVar != null && gVar.isShowing()) {
            this.f5257k0.dismiss();
        }
        miuix.appcompat.app.g gVar2 = this.f5258l0;
        if (gVar2 != null && gVar2.isShowing()) {
            this.f5258l0.dismiss();
        }
        C0417d.c().a();
        H h4 = this.f5227I;
        if (h4 != null) {
            h4.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super.onKeyDown(i2, keyEvent);
        }
        com.android.mmt.util.C.e(this);
        return true;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onMultiWindowModeChanged(boolean z4) {
        super.onMultiWindowModeChanged(z4);
        P0.D d2 = this.f5245Y;
        if (d2 != null && d2.isShowing()) {
            this.f5245Y.dismiss();
        }
        this.f5211A = z4;
        if (F0()) {
            v0();
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        com.android.mmt.util.A.c(this, strArr);
        for (int i4 : iArr) {
            if (i4 != 0) {
                return;
            }
        }
        if (i2 == 1022) {
            C0230a c0230a = this.f5252f0;
            if (c0230a != null) {
                c0230a.t();
                return;
            }
            return;
        }
        if (i2 == 1023) {
            C0230a c0230a2 = this.f5252f0;
            if (c0230a2 != null) {
                c0230a2.s();
                return;
            }
            return;
        }
        if (i2 == 1024) {
            C0230a c0230a3 = this.f5252f0;
            if (c0230a3 != null) {
                c0230a3.r();
                return;
            }
            return;
        }
        if (i2 == 1025) {
            C0273e.c(this.f5267v0);
            return;
        }
        if (i2 == 1026) {
            C0273e.e(this.f5267v0);
        } else {
            if (i2 != 1027) {
                if (i2 != 1028) {
                    return;
                }
                this.f5241U.g0();
                throw null;
            }
            C0273e.b(this.f5267v0);
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        if (this.f5241U.E()) {
            this.f5246Z.q();
            this.f5241U.i0();
        }
        this.f5273y0.postDelayed(this.f5275z0, 200L);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected void onStart() {
        super.onStart();
        x0.j jVar = this.f5241U;
        if (jVar != null) {
            jVar.g0();
        }
        C0415b c0415bG = this.f5246Z.G();
        c0415bG.o(false, true);
        String strW = null;
        if (c0415bG.size() == 1 && c0415bG.get(0) != null) {
            strW = c0415bG.get(0).W();
        }
        C0414a.J(this, strW);
        P0.G.b().e(this, this);
        P0.G.b().g();
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected void onStop() {
        Z0(true);
        Objects.requireNonNull(C0380a.b(MmsApp.c()));
        C0414a.n0(this);
        Handler handler = this.f5273y0;
        if (handler != null) {
            handler.removeCallbacks(this.f5218D0);
        }
        Dialog dialog = this.f5256j0;
        if (dialog != null && dialog.isShowing()) {
            this.f5256j0.dismiss();
        }
        this.f5256j0 = null;
        P0.G.a(this);
        r0();
        View view = this.f5221F;
        if (view != null) {
            view.setPadding(view.getPaddingStart(), this.f5221F.getPaddingTop(), this.f5221F.getPaddingEnd(), 0);
            C0();
            this.f5261o0 = 0;
        }
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        this.f5213B = !z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(SizeAwareLinearLayout sizeAwareLinearLayout, int i2, int i4) {
        synchronized (this.f5266v) {
            Iterator<Integer> it = this.f5266v.iterator();
            while (it.hasNext()) {
                if (it.next().intValue() == 0) {
                    v0();
                }
            }
            this.f5266v.clear();
        }
        boolean z4 = true;
        if (Settings.Global.getInt(getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
            int identifier = getResources().getIdentifier("rounded_corner_radius_bottom", "dimen", "android");
            if ((identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0) < 60) {
            }
        } else {
            z4 = false;
        }
        if (z4) {
            this.f5221F.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.bottom_editor_panel_min_height_big_corner));
            this.f5239S.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.mms_editor_height_big_corner));
        } else {
            this.f5221F.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.bottom_editor_panel_min_height));
            this.f5239S.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.mms_editor_height));
        }
        int dimension = (int) this.f5267v0.getResources().getDimension(z4 ? R.dimen.bottom_editor_margin_left_big_corner : R.dimen.bottom_editor_margin_left);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f5223G.getLayoutParams();
        layoutParams.setMarginStart(dimension);
        this.f5223G.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f5240T.getLayoutParams();
        layoutParams2.setMarginStart(dimension);
        this.f5240T.setLayoutParams(layoutParams2);
        int paddingBottom = this.f5221F.getPaddingBottom();
        if (this.f5254h0 && this.f5250d0) {
            this.M.c();
        }
        int i5 = R.drawable.ic_bottom_menu_mode_n;
        ImageButton imageButton = this.f5242V;
        if (!F0()) {
            i5 = R.drawable.insert_attachment_button_n;
        }
        imageButton.setImageResource(i5);
        int iN = this.f5252f0.n(i2, paddingBottom);
        int minimumHeight = this.f5221F.getMinimumHeight();
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = sizeAwareLinearLayout.getMeasuredHeight();
        }
        if (F0()) {
            size -= iN;
        }
        if (size >= minimumHeight) {
            minimumHeight = size;
        }
        this.f5221F.measure(i2, View.MeasureSpec.makeMeasureSpec(minimumHeight, Integer.MIN_VALUE));
        if (this.f5221F.getMeasuredHeight() < minimumHeight) {
            this.f5221F.getLayoutParams().height = -2;
        } else {
            this.f5221F.getLayoutParams().height = minimumHeight;
        }
        this.f5235N.setMinHeight(0);
        if (this.f5235N.getLineCount() > 2 || this.f5241U.A() || this.f5241U.v() != null) {
            this.f5236O.setVisibility(0);
        } else {
            this.f5236O.setVisibility(8);
        }
        int measuredHeight = this.f5268w - this.f5237Q.getMeasuredHeight();
        if (measuredHeight > 0) {
            EditText editText = this.f5235N;
            editText.setMinHeight(editText.getMeasuredHeight() + measuredHeight);
        }
    }

    protected final void p1(Context context, int i2, int i4) {
        if (i4 <= 0) {
            o1(i2);
            return;
        }
        if (i2 == 0) {
            this.f5244X.setImageResource(R.drawable.msg_edit_sub_sim1);
            this.f5244X.setContentDescription(getString(R.string.sub_sim_card));
        } else if (i2 != 1) {
            this.f5244X.setImageResource(R.drawable.msg_edit_default);
            this.f5244X.setContentDescription(getString(R.string.select_sim));
        } else {
            this.f5244X.setImageResource(R.drawable.msg_edit_sub_sim2);
            this.f5244X.setContentDescription(getString(R.string.sub_sim_card));
        }
    }

    protected final int q1() {
        ViewStub viewStub;
        int iQ = -1;
        if (!C0287t.y()) {
            if (!this.f5262r0) {
                this.q0 = C0287t.f();
            }
            int i2 = -1 != this.q0 ? 1 : 0;
            ImageView imageView = this.f5244X;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            View view = this.f5239S;
            view.setPaddingRelative(view.getPaddingStart(), this.f5239S.getPaddingTop(), (int) getResources().getDimension(R.dimen.mms_editor_margin_right), this.f5239S.getPaddingBottom());
            return i2;
        }
        if (!this.f5262r0) {
            if (C0287t.x() && C0287t.y()) {
                try {
                    iQ = C0287t.q(SubscriptionManager.getDefaultSmsSubscriptionId());
                } catch (SecurityException e2) {
                    com.android.mmt.util.A.f(e2);
                }
            }
            this.q0 = iQ;
        }
        if (this.f5244X == null && (viewStub = (ViewStub) findViewById(R.id.send_slot_id)) != null) {
            ImageView imageView2 = (ImageView) viewStub.inflate();
            this.f5244X = imageView2;
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = this.f5244X;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
            View view2 = this.f5239S;
            view2.setPaddingRelative(view2.getPaddingStart(), this.f5239S.getPaddingTop(), 0, this.f5239S.getPaddingBottom());
        }
        n1();
        return 2;
    }

    protected final void s0() {
        this.f5252f0.l();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void startActivityForResult(Intent intent, int i2) {
        if (i2 >= 0) {
            this.f5248b0 = true;
        }
        try {
            super.startActivityForResult(intent, i2);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(MmsApp.c(), getString(R.string.activity_not_found_uri), 0).show();
        }
    }

    @Override // x0.C0414a.c
    public final void t(C0414a c0414a) {
        Handler handler;
        C0416c c0416c = this.f5246Z;
        if (c0416c == null || c0414a == null || !c0416c.G().contains(c0414a) || (handler = this.f5273y0) == null) {
            return;
        }
        handler.removeCallbacks(this.f5218D0);
        this.f5273y0.post(this.f5218D0);
    }

    protected final void t0() {
        if (this.f5241U.x() > 0) {
            this.f5225H.setVisibility(0);
        } else {
            this.f5225H.setVisibility(8);
        }
        this.f5225H.setText(this.f5241U.y());
        this.f5235N.setVisibility(0);
        if (this.f5241U.A()) {
            this.f5235N.setHint("");
        }
        CharSequence charSequenceW = this.f5241U.w();
        if (charSequenceW == null) {
            this.f5235N.setText("");
        } else if (!TextUtils.equals(this.f5235N.getText(), charSequenceW)) {
            this.f5235N.setTextKeepState(charSequenceW);
            EditText editText = this.f5235N;
            editText.setSelection(editText.getText().length());
        }
        l1(this.f5241U.P());
        W0();
    }

    protected abstract boolean t1();

    protected final void u0() {
        i1(this.f5241U.C(false));
    }

    protected final void v0() {
        y0();
        this.f5252f0.m(this.f5211A ? 0 : this.f5274z);
    }

    protected void w0() {
        if (!this.f5241U.G()) {
            V0();
            return;
        }
        if (!t1()) {
            this.f5249c0 = true;
            V0();
            return;
        }
        miuix.appcompat.app.g gVarA = this.f5258l0;
        t tVar = new t();
        if (gVarA == null || !gVarA.isShowing()) {
            g.a aVar = new g.a(this);
            aVar.h();
            aVar.x(R.string.discard_message);
            aVar.j(R.string.discard_message_reason);
            aVar.t(R.string.yes, tVar);
            aVar.m(R.string.no, null);
            gVarA = aVar.A();
        }
        this.f5258l0 = gVarA;
    }

    protected abstract int x0();

    public final EditText y0() {
        EditText editText = this.f5231K;
        if (editText != null && editText.hasFocus()) {
            return this.f5231K;
        }
        if (this.f5235N.hasFocus()) {
            return this.f5235N;
        }
        this.f5235N.requestFocus();
        return this.f5235N;
    }

    protected abstract C0415b z0();
}
