package com.android.mmt.ui;

import O0.f;
import P0.ActivityC0156b;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.util.Log;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.android.mmt.R;
import com.android.mmt.util.C0275g;
import com.android.mmt.util.C0287t;
import java.lang.ref.WeakReference;
import miuix.appcompat.app.g;
import o0.C0361d;
import t.C0384b;

/* loaded from: classes.dex */
public class MessagingAdvancedPreferenceActivity extends ActivityC0156b {

    public static class a extends G3.g implements Preference.d, Preference.e {

        /* renamed from: o0, reason: collision with root package name */
        private Preference f5033o0;
        private Preference p0;
        private Preference q0;

        /* renamed from: r0, reason: collision with root package name */
        private Preference f5034r0;

        /* renamed from: s0, reason: collision with root package name */
        private Preference f5035s0;

        /* renamed from: t0, reason: collision with root package name */
        private PreferenceCategory f5036t0;

        /* renamed from: u0, reason: collision with root package name */
        private Preference f5037u0;

        /* renamed from: v0, reason: collision with root package name */
        private Preference f5038v0;

        /* renamed from: w0, reason: collision with root package name */
        private PreferenceCategory f5039w0;

        /* renamed from: x0, reason: collision with root package name */
        private Preference f5040x0;

        /* renamed from: y0, reason: collision with root package name */
        private Preference f5041y0;

        /* renamed from: z0, reason: collision with root package name */
        private int f5042z0 = 0;

        /* renamed from: A0, reason: collision with root package name */
        private final SubscriptionManager.OnSubscriptionsChangedListener f5031A0 = new b(this);

        /* renamed from: B0, reason: collision with root package name */
        private final f.h f5032B0 = new C0094a(this);

        /* renamed from: com.android.mmt.ui.MessagingAdvancedPreferenceActivity$a$a, reason: collision with other inner class name */
        private static class C0094a implements f.h {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f5043a;

            public C0094a(a aVar) {
                this.f5043a = new WeakReference<>(aVar);
            }

            @Override // O0.f.h
            public final void a() {
                a aVar = this.f5043a.get();
                if (aVar == null || !com.android.mmt.util.e0.e(aVar.x())) {
                    return;
                }
                Log.d("MsgAdvancedPreference", "update sim info change");
                aVar.o1();
            }
        }

        private static class b extends SubscriptionManager.OnSubscriptionsChangedListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f5044a;

            b(a aVar) {
                this.f5044a = new WeakReference<>(aVar);
            }

            @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
            public final void onSubscriptionsChanged() {
                a aVar = this.f5044a.get();
                if (aVar == null || !com.android.mmt.util.e0.e(aVar.x())) {
                    return;
                }
                Log.d("MsgAdvancedPreference", "update sim info change");
                aVar.o1();
            }
        }

        private void k1() {
            Intent intent = new Intent(B(), (Class<?>) ManageSimMessages.class);
            intent.putExtra("slot_id", 0);
            b1(intent);
        }

        private void l1(Preference preference, boolean z4) {
            Preference preference2;
            if (this.f5042z0 > 1) {
                Intent intent = new Intent(B(), (Class<?>) MultiSimPreferenceAcitvity.class);
                intent.putExtra("preference_key", preference.o());
                intent.putExtra("preference_title", preference.A());
                b1(intent);
                return;
            }
            if (preference == this.p0) {
                Preference preference3 = this.q0;
                if (preference3 != null) {
                    preference3.d0(z4);
                } else {
                    if (this.f5034r0 == null || (preference2 = this.f5035s0) == null) {
                        return;
                    }
                    preference2.d0(z4);
                    this.f5034r0.d0(z4);
                }
            }
        }

        private void m1() {
            boolean z4;
            Context contextB = B();
            int i2 = C0287t.f6041f;
            Intent intent = new Intent();
            intent.setClassName("com.android.phone", "com.android.phone.settings.SmscAddressPreferenceActivity");
            if (contextB.getPackageManager().resolveActivity(intent, 65536) != null) {
                contextB.startActivity(intent);
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                return;
            }
            int i4 = this.f5042z0;
            if (i4 == 1) {
                C0287t.L(B(), C0287t.f());
            } else if (i4 > 1) {
                Intent intent2 = new Intent(B(), (Class<?>) SelectCardPreferenceActivity.class);
                intent2.putExtra("preference_key", this.f5037u0.o());
                intent2.putExtra("preference_title", this.f5037u0.A());
                b1(intent2);
            }
        }

        private void n1() {
            if (C0275g.d()) {
                String strV = P0.r.v(B());
                g.a aVar = new g.a(B());
                aVar.x(R.string.pref_title_storage_status);
                aVar.k(strV);
                aVar.t(android.R.string.ok, null);
                aVar.c(true);
                aVar.A();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:73:0x02ad  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void o1() {
            boolean zW;
            Preference preference;
            this.f5042z0 = C0287t.d();
            StringBuilder sbD = D2.e.d("updateSimState sim count is ");
            sbD.append(this.f5042z0);
            Log.d("MsgAdvancedPreference", sbD.toString());
            this.f5036t0.B0();
            this.f5033o0 = null;
            this.p0 = null;
            this.q0 = null;
            e1().C0(this.f5036t0);
            int iF = C0287t.f();
            StringBuilder sbD2 = D2.e.d("updateMmsRelatedPrefs slotId is ");
            sbD2.append(String.valueOf(iF));
            Log.d("MsgAdvancedPreference", sbD2.toString());
            boolean z4 = false;
            if (this.f5042z0 == 0 || iF == -1 || !k0.d.m()) {
                Log.d("MsgAdvancedPreference", "updateMmsRelatedPreference nothing");
            } else {
                long jM = C0287t.m(iF);
                SharedPreferences sharedPreferences = B().getSharedPreferences("com.android.mmt_preferences", 0);
                e1().w0(this.f5036t0);
                String strB = "pref_key_mms_read_reports";
                if (this.f5042z0 > 1) {
                    Preference preference2 = new Preference(d1().b());
                    this.f5033o0 = preference2;
                    preference2.l0(this);
                } else {
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(d1().b());
                    checkBoxPreference.y0(false);
                    int i2 = MessagingPreferenceActivity.f5045v;
                    checkBoxPreference.c0(Boolean.FALSE);
                    if (C0287t.x()) {
                        strB = C0287t.b(jM, "pref_key_mms_read_reports");
                        checkBoxPreference.x0(sharedPreferences.getBoolean(strB, false));
                    }
                    this.f5033o0 = checkBoxPreference;
                    checkBoxPreference.k0(this);
                }
                this.f5033o0.q0(R.string.pref_title_mms_read_reports);
                this.f5033o0.h0(strB);
                this.f5036t0.w0(this.f5033o0);
                String strB2 = "pref_key_mms_auto_retrieval";
                if (this.f5042z0 > 1) {
                    Preference preference3 = new Preference(d1().b());
                    this.p0 = preference3;
                    preference3.l0(this);
                } else {
                    CheckBoxPreference checkBoxPreference2 = new CheckBoxPreference(d1().b());
                    checkBoxPreference2.c0(Boolean.TRUE);
                    if (C0287t.x()) {
                        strB2 = C0287t.b(jM, "pref_key_mms_auto_retrieval");
                        checkBoxPreference2.x0(sharedPreferences.getBoolean(strB2, true));
                    }
                    this.p0 = checkBoxPreference2;
                    checkBoxPreference2.k0(this);
                }
                this.p0.q0(R.string.pref_title_mms_auto_retrieval);
                this.p0.h0(strB2);
                this.f5036t0.w0(this.p0);
                if (C0384b.j("PL")) {
                    this.q0 = null;
                    String strB3 = "pref_key_mms_retrieval_during_international_roaming";
                    if (this.f5042z0 > 1) {
                        Preference preference4 = new Preference(d1().b());
                        this.f5035s0 = preference4;
                        preference4.l0(this);
                    } else {
                        CheckBoxPreference checkBoxPreference3 = new CheckBoxPreference(d1().b());
                        checkBoxPreference3.c0(Boolean.FALSE);
                        if (C0287t.x()) {
                            strB3 = C0287t.b(jM, "pref_key_mms_retrieval_during_international_roaming");
                            checkBoxPreference3.x0(sharedPreferences.getBoolean(strB3, false));
                        }
                        this.f5035s0 = checkBoxPreference3;
                        checkBoxPreference3.k0(this);
                    }
                    this.f5035s0.q0(R.string.pref_title_mms_retrieval_during_international_roaming);
                    this.f5035s0.h0(strB3);
                    this.f5036t0.w0(this.f5035s0);
                    String strB4 = "pref_key_mms_retrieval_during_national_roaming";
                    if (this.f5042z0 > 1) {
                        Preference preference5 = new Preference(d1().b());
                        this.f5034r0 = preference5;
                        preference5.l0(this);
                    } else {
                        CheckBoxPreference checkBoxPreference4 = new CheckBoxPreference(d1().b());
                        checkBoxPreference4.c0(Boolean.TRUE);
                        if (C0287t.x()) {
                            strB4 = C0287t.b(jM, "pref_key_mms_retrieval_during_national_roaming");
                            checkBoxPreference4.x0(sharedPreferences.getBoolean(strB4, true));
                        }
                        this.f5034r0 = checkBoxPreference4;
                        checkBoxPreference4.k0(this);
                    }
                    this.f5034r0.q0(R.string.pref_title_mms_retrieval_during_national_roaming);
                    this.f5034r0.h0(strB4);
                    this.f5036t0.w0(this.f5034r0);
                } else {
                    this.f5034r0 = null;
                    this.f5035s0 = null;
                    String strB5 = "pref_key_mms_retrieval_during_roaming";
                    if (this.f5042z0 > 1) {
                        Preference preference6 = new Preference(d1().b());
                        this.q0 = preference6;
                        preference6.l0(this);
                    } else {
                        CheckBoxPreference checkBoxPreference5 = new CheckBoxPreference(d1().b());
                        checkBoxPreference5.c0(Boolean.valueOf(MessagingPreferenceActivity.O(jM)));
                        if (C0287t.x()) {
                            strB5 = C0287t.b(jM, "pref_key_mms_retrieval_during_roaming");
                            checkBoxPreference5.x0(sharedPreferences.getBoolean(strB5, MessagingPreferenceActivity.O(jM)));
                        }
                        this.q0 = checkBoxPreference5;
                        checkBoxPreference5.k0(this);
                    }
                    this.q0.q0(R.string.pref_title_mms_retrieval_during_roaming);
                    this.q0.h0(strB5);
                    this.f5036t0.w0(this.q0);
                }
                Preference preference7 = this.p0;
                if (preference7 != null && (preference7 instanceof CheckBoxPreference)) {
                    CheckBoxPreference checkBoxPreference6 = (CheckBoxPreference) preference7;
                    Preference preference8 = this.q0;
                    if (preference8 != null) {
                        preference8.d0(checkBoxPreference6.w0());
                    } else if (this.f5034r0 != null && (preference = this.f5035s0) != null) {
                        preference.d0(checkBoxPreference6.w0());
                        this.f5034r0.d0(checkBoxPreference6.w0());
                    }
                }
            }
            this.f5039w0.C0(this.f5037u0);
            if (C0.a.c().getResources().getBoolean(R.bool.enable_smsc_setting)) {
                int i4 = this.f5042z0;
                if (i4 == 1) {
                    zW = C0287t.w(C0287t.o(C0287t.f()));
                } else {
                    if (i4 > 1) {
                        if (C0287t.w(C0287t.o(0))) {
                            zW = C0287t.w(C0287t.o(1));
                        } else {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        this.f5039w0.w0(this.f5037u0);
                    }
                }
                z4 = !zW;
                if (z4) {
                }
            }
            this.f5039w0.C0(this.f5038v0);
            if (this.f5042z0 >= 1) {
                this.f5039w0.w0(this.f5038v0);
            }
            this.f5039w0.C0(this.f5040x0);
            if (C0275g.d()) {
                this.f5039w0.w0(this.f5040x0);
            }
        }

        @Override // androidx.preference.Preference.d
        public final boolean b(Preference preference, Object obj) {
            if (preference == null) {
                return true;
            }
            if (preference == this.f5038v0) {
                k1();
                return true;
            }
            if (preference == this.f5037u0) {
                m1();
                return true;
            }
            if (preference == this.f5040x0) {
                n1();
                return true;
            }
            if (preference != this.f5033o0 && preference != this.p0 && preference != this.q0 && preference != this.f5034r0 && preference != this.f5035s0) {
                return true;
            }
            l1(preference, ((Boolean) obj).booleanValue());
            return true;
        }

        @Override // androidx.preference.c
        public final void g1(String str) {
            i1(R.xml.advanced_preferences, str);
            this.f5039w0 = (PreferenceCategory) r("pref_key_other_settings");
            r("pref_key_allow_si_sl_push");
            Preference preferenceR = r("pref_key_edit_sim_smsc_address");
            this.f5037u0 = preferenceR;
            preferenceR.l0(this);
            Preference preferenceR2 = r("pref_key_manage_sim_messages");
            this.f5038v0 = preferenceR2;
            preferenceR2.l0(this);
            this.f5036t0 = (PreferenceCategory) r("pref_key_mms_settings");
            this.f5040x0 = r("pref_key_storage_status");
            this.f5041y0 = r("pref_key_ad");
            this.f5040x0.k0(this);
            o1();
            if (C0361d.a()) {
                this.f5041y0.r0(false);
            } else {
                this.f5041y0.r0(true);
            }
            if (!C0287t.x()) {
                O0.f.j().s(this.f5032B0);
            } else {
                B();
                C0287t.H(this.f5031A0);
            }
        }

        @Override // androidx.fragment.app.Fragment
        public final void h0() {
            if (C0287t.x()) {
                B();
                C0287t.M(this.f5031A0);
            } else {
                O0.f.j().t(this.f5032B0);
            }
            super.h0();
        }

        @Override // androidx.preference.Preference.e
        public final boolean k(Preference preference) {
            if (preference == null) {
                return true;
            }
            if (preference == this.f5038v0) {
                k1();
            } else if (preference == this.f5037u0) {
                m1();
            } else if (preference == this.f5040x0) {
                n1();
            } else if (preference == this.f5033o0 || preference == this.p0 || preference == this.q0 || preference == this.f5034r0 || preference == this.f5035s0) {
                l1(preference, false);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.w wVarU = u();
        androidx.fragment.app.E eF = wVarU.f();
        if (((a) wVarU.T("MsgAdvancedPreference")) == null) {
            eF.b(android.R.id.content, new a(), "MsgAdvancedPreference");
        }
        eF.h();
        wVarU.P();
    }
}
