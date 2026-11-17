package com.android.mmt.ui;

import O0.f;
import P0.InterfaceC0164j;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;
import java.lang.ref.WeakReference;
import java.util.Objects;
import miuix.appcompat.internal.app.widget.d;
import miuix.appcompat.internal.app.widget.d.C0119d;

/* loaded from: classes.dex */
public class ManageSimMessages extends miuix.appcompat.app.h implements InterfaceC0164j {

    /* renamed from: v, reason: collision with root package name */
    private miuix.appcompat.app.b f4907v;

    /* renamed from: w, reason: collision with root package name */
    private c f4908w = new c(this);

    /* renamed from: x, reason: collision with root package name */
    private final SubscriptionManager.OnSubscriptionsChangedListener f4909x = new b(this);

    /* renamed from: y, reason: collision with root package name */
    private final f.h f4910y = new a(this);

    private static class a implements f.h {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ManageSimMessages> f4911a;

        public a(ManageSimMessages manageSimMessages) {
            this.f4911a = new WeakReference<>(manageSimMessages);
        }

        @Override // O0.f.h
        public final void a() {
            ManageSimMessages manageSimMessages = this.f4911a.get();
            if (com.android.mmt.util.e0.e(manageSimMessages)) {
                Log.d("ManageSimMessages", "update sim info change");
                if (C0287t.C()) {
                    return;
                }
                manageSimMessages.finish();
            }
        }
    }

    private static class b extends SubscriptionManager.OnSubscriptionsChangedListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ManageSimMessages> f4912a;

        b(ManageSimMessages manageSimMessages) {
            this.f4912a = new WeakReference<>(manageSimMessages);
        }

        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
        public final void onSubscriptionsChanged() {
            ManageSimMessages manageSimMessages = this.f4912a.get();
            if (com.android.mmt.util.e0.e(manageSimMessages)) {
                Log.d("ManageSimMessages", "update sim info change");
                manageSimMessages.R();
            }
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public Context f4913a;

        /* renamed from: b, reason: collision with root package name */
        public int f4914b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4915c;
        public boolean d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4916e;

        /* renamed from: f, reason: collision with root package name */
        public String f4917f;
        public String g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f4918h;

        public c(Context context) {
            this.f4913a = context;
        }

        private boolean a(String str, String str2) {
            return str != null && str.equals(str2);
        }

        private String b(int i2) {
            String strK = C0287t.k(i2);
            if (TextUtils.isEmpty(strK)) {
                return this.f4913a.getResources().getString(C0287t.x() ? i2 == 1 ? R.string.sim_card2 : R.string.sim_card1 : R.string.sim_manage_messages_title);
            }
            return strK;
        }

        public final void c(int i2, int i4) {
            this.f4918h = false;
            if (i2 == 0) {
                String strB = b(i2);
                if (!a(strB, this.f4917f)) {
                    this.f4918h = true;
                }
                this.f4917f = strB;
                return;
            }
            if (i2 == 1) {
                String strB2 = b(i2);
                if (!a(strB2, this.g)) {
                    this.f4918h = true;
                }
                this.g = strB2;
                return;
            }
            if (i2 == -1) {
                String strB3 = b(0);
                if (!a(strB3, this.f4917f)) {
                    this.f4918h = true;
                }
                this.f4917f = strB3;
                String strB4 = b(1);
                if (!a(strB4, this.g)) {
                    this.f4918h = true;
                }
                this.g = strB4;
            }
        }
    }

    private int P(int i2) {
        if (i2 != 0 && i2 == 1) {
            return this.f4907v.q() - 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        c cVar = this.f4908w;
        cVar.f4914b = 0;
        cVar.f4916e = false;
        boolean zD = C0287t.D(0);
        if (cVar.f4915c != zD) {
            cVar.f4916e = true;
        }
        cVar.f4915c = zD;
        if (zD) {
            cVar.f4914b++;
        }
        boolean zD2 = C0287t.D(1);
        if (cVar.d != zD2) {
            cVar.f4916e = true;
        }
        cVar.d = zD2;
        if (zD2) {
            cVar.f4914b++;
        }
        StringBuilder sbD = D2.e.d("updateSimState sim count is ");
        sbD.append(cVar.f4914b);
        Log.d("ManageSimMessages", sbD.toString());
        c cVar2 = this.f4908w;
        if (cVar2.f4914b == 0) {
            Log.d("ManageSimMessages", "updateSimState sim count == 0");
            finish();
            return;
        }
        if (cVar2.f4916e) {
            androidx.fragment.app.w wVarU = u();
            androidx.fragment.app.E eF = wVarU.f();
            if (this.f4907v.q() > 0) {
                this.f4907v.s();
            }
            if (this.f4908w.f4915c) {
                Bundle bundle = new Bundle();
                bundle.putInt("slot_id", 0);
                miuix.appcompat.app.b bVar = this.f4907v;
                miuix.appcompat.internal.app.widget.d dVar = (miuix.appcompat.internal.app.widget.d) bVar;
                Objects.requireNonNull(dVar);
                d.C0119d c0119d = dVar.new C0119d();
                c0119d.g("");
                bVar.o("sim0", c0119d, F0.class, bundle);
                Log.d("ManageSimMessages", "updateFragments add sim0 fragment");
            }
            if (this.f4908w.d) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("slot_id", 1);
                miuix.appcompat.app.b bVar2 = this.f4907v;
                miuix.appcompat.internal.app.widget.d dVar2 = (miuix.appcompat.internal.app.widget.d) bVar2;
                Objects.requireNonNull(dVar2);
                d.C0119d c0119d2 = dVar2.new C0119d();
                c0119d2.g("");
                bVar2.o("sim1", c0119d2, F0.class, bundle2);
                Log.d("ManageSimMessages", "updateFragments add sim1 fragment");
            }
            miuix.appcompat.app.b bVar3 = this.f4907v;
            bVar3.x(bVar3.q() <= 1);
            eF.h();
            wVarU.P();
        }
        Q(0);
        Q(1);
    }

    public final void Q(int i2) {
        if (i2 == 0) {
            if (this.f4908w.f4915c) {
                int iP = P(i2);
                this.f4908w.c(i2, ((F0) this.f4907v.p(iP)).o1());
                if (this.f4908w.f4918h) {
                    if (this.f4907v.q() > 1) {
                        this.f4907v.b(iP).g(this.f4908w.f4917f);
                    } else {
                        this.f4907v.n(this.f4908w.f4917f);
                    }
                    Log.d("ManageSimMessages", "update sim info for slotId 0");
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 1 && this.f4908w.d) {
            int iP2 = P(i2);
            this.f4908w.c(i2, ((F0) this.f4907v.p(iP2)).o1());
            if (this.f4908w.f4918h) {
                if (this.f4907v.q() > 1) {
                    this.f4907v.b(iP2).g(this.f4908w.g);
                } else {
                    this.f4907v.n(this.f4908w.g);
                }
                Log.d("ManageSimMessages", "update sim info for slotId 1");
            }
        }
    }

    @Override // P0.InterfaceC0164j
    public final void d(float f4) {
        F0.p0 = f4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        miuix.appcompat.app.b bVarK = K();
        this.f4907v = bVarK;
        bVarK.v(this);
        R();
        int iT = C0287t.t(getIntent());
        if (iT == 0) {
            if (this.f4908w.f4915c) {
                int iP = P(iT);
                miuix.appcompat.app.b bVar = this.f4907v;
                bVar.f(bVar.b(iP));
                Log.d("ManageSimMessages", "set selected is slotId 0");
            }
        } else if (iT == 1 && this.f4908w.d) {
            int iP2 = P(iT);
            miuix.appcompat.app.b bVar2 = this.f4907v;
            bVar2.f(bVar2.b(iP2));
            Log.d("ManageSimMessages", "set selected is slotId 1");
        }
        com.android.mmt.transaction.d.r(234);
        if (C0287t.x()) {
            C0287t.H(this.f4909x);
        } else {
            O0.f.j().s(this.f4910y);
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        if (C0287t.x()) {
            C0287t.M(this.f4909x);
        } else {
            O0.f.j().t(this.f4910y);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onStart() {
        super.onStart();
        P0.G.b().e(this, this);
        P0.G.b().g();
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onStop() {
        super.onStop();
        P0.G.b();
        P0.G.a(this);
    }
}
