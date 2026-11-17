package com.android.mmt.ui;

import P0.InterfaceC0163i;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.util.Log;
import androidx.preference.Preference;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;

/* loaded from: classes.dex */
public class SelectCardListPreferenceActivity extends miuix.appcompat.app.h {

    public static class a extends G3.g implements InterfaceC0163i, Preference.d {

        /* renamed from: o0, reason: collision with root package name */
        private AdvancedValueListPreference f5418o0;
        private AdvancedValueListPreference p0;
        private String q0;

        /* renamed from: r0, reason: collision with root package name */
        private Context f5419r0;

        /* renamed from: s0, reason: collision with root package name */
        private SubscriptionManager.OnSubscriptionsChangedListener f5420s0 = new C0098a();

        /* renamed from: com.android.mmt.ui.SelectCardListPreferenceActivity$a$a, reason: collision with other inner class name */
        final class C0098a extends SubscriptionManager.OnSubscriptionsChangedListener {
            C0098a() {
            }

            @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
            public final void onSubscriptionsChanged() {
                if (C0287t.y()) {
                    Log.d("SelectCardListFg", "onChange update sim state");
                    a.j1(a.this);
                } else {
                    Log.d("SelectCardListFg", "onChange not multi sim is inserted");
                    a.this.x().finish();
                }
            }
        }

        static void j1(a aVar) {
            AdvancedValueListPreference advancedValueListPreference = aVar.f5418o0;
            if (advancedValueListPreference != null) {
                advancedValueListPreference.Q0(aVar, 0);
            }
            AdvancedValueListPreference advancedValueListPreference2 = aVar.p0;
            if (advancedValueListPreference2 != null) {
                advancedValueListPreference2.Q0(aVar, 1);
            }
        }

        public static void k1(Context context, ValueListPreference valueListPreference, String str) throws NumberFormatException {
            int i2 = Integer.parseInt(str);
            if (i2 == 0) {
                i2 = 0;
            } else if (i2 == 172800) {
                i2 = 1;
            }
            valueListPreference.N0(context.getResources().getStringArray(R.array.entries_mms_validity_period)[i2]);
        }

        public static void l1(Context context, ValueListPreference valueListPreference, String str) throws NumberFormatException {
            int i2 = Integer.parseInt(str);
            char c2 = 0;
            if (i2 != -1) {
                if (i2 == 60) {
                    c2 = 1;
                } else if (i2 == 360) {
                    c2 = 2;
                } else if (i2 == 720) {
                    c2 = 3;
                } else if (i2 == 1440) {
                    c2 = 4;
                } else if (i2 == 635040) {
                    c2 = 5;
                }
            }
            valueListPreference.N0(context.getResources().getStringArray(R.array.entries_sms_validity_period)[c2]);
        }

        private void m1(AdvancedValueListPreference advancedValueListPreference, SharedPreferences sharedPreferences) throws NumberFormatException {
            String strB = C0287t.b(C0287t.m(advancedValueListPreference.O0()), this.q0);
            advancedValueListPreference.h0(strB);
            advancedValueListPreference.n0();
            if ("pref_key_mms_validity_period".equals(this.q0)) {
                advancedValueListPreference.J0(advancedValueListPreference.i().getResources().getTextArray(R.array.entries_mms_validity_period));
                advancedValueListPreference.K0(R.array.entries_mms_validity_period_value);
                advancedValueListPreference.M0(R.string.pref_title_mms_validity_period);
                k1(this.f5419r0, advancedValueListPreference, sharedPreferences.getString(strB, "0"));
                return;
            }
            if ("pref_key_sms_validity_period".equals(this.q0)) {
                advancedValueListPreference.J0(advancedValueListPreference.i().getResources().getTextArray(R.array.entries_sms_validity_period));
                advancedValueListPreference.K0(R.array.entries_sms_validity_period_value);
                advancedValueListPreference.M0(R.string.pref_title_sms_validity_period);
                l1(this.f5419r0, advancedValueListPreference, sharedPreferences.getString(advancedValueListPreference.o(), "-1"));
            }
        }

        @Override // androidx.preference.Preference.d
        public final boolean b(Preference preference, Object obj) throws NumberFormatException {
            if ("pref_key_mms_validity_period".equals(this.q0)) {
                k1(this.f5419r0, (ValueListPreference) preference, (String) obj);
                return true;
            }
            l1(this.f5419r0, (ValueListPreference) preference, (String) obj);
            return true;
        }

        @Override // androidx.preference.c
        public final void g1(String str) throws NumberFormatException {
            i1(R.xml.multi_cards_value_list_preference, str);
            this.f5419r0 = B();
            miuix.appcompat.app.b bVarK = ((miuix.appcompat.app.h) x()).K();
            if (bVarK != null) {
                bVarK.g(true);
            }
            Intent intent = x().getIntent();
            this.q0 = intent.getStringExtra("preference_key");
            x().setTitle(intent.getStringExtra("preference_title"));
            this.f5418o0 = (AdvancedValueListPreference) r("pref_key_sim1");
            this.p0 = (AdvancedValueListPreference) r("pref_key_sim2");
            SharedPreferences sharedPreferences = this.f5419r0.getSharedPreferences("com.android.mmt_preferences", 0);
            AdvancedValueListPreference advancedValueListPreference = this.f5418o0;
            if (advancedValueListPreference != null) {
                advancedValueListPreference.P0(this, 0);
                m1(this.f5418o0, sharedPreferences);
                this.f5418o0.k0(this);
            }
            AdvancedValueListPreference advancedValueListPreference2 = this.p0;
            if (advancedValueListPreference2 != null) {
                advancedValueListPreference2.P0(this, 1);
                m1(this.p0, sharedPreferences);
                this.p0.k0(this);
            }
            C0287t.H(this.f5420s0);
        }

        @Override // P0.InterfaceC0163i
        public final int h(int i2) {
            return C0287t.l(i2);
        }

        @Override // androidx.fragment.app.Fragment
        public final void h0() {
            C0287t.M(this.f5420s0);
            super.h0();
        }

        @Override // P0.InterfaceC0163i
        public final String m(int i2) {
            return C0287t.n(i2);
        }

        @Override // P0.InterfaceC0163i
        public final String n(int i2) {
            return C0287t.k(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.w wVarU = u();
        androidx.fragment.app.E eF = wVarU.f();
        if (((a) wVarU.T("SelectCardListFg")) == null) {
            eF.b(android.R.id.content, new a(), "SelectCardListFg");
        }
        eF.h();
        wVarU.P();
    }
}
