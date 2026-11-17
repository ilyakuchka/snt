package com.android.mmt.ui;

import P0.InterfaceC0163i;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.util.Log;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;

/* loaded from: classes.dex */
public class MultiSimPreferenceAcitvity extends miuix.appcompat.app.h {

    public static class a extends G3.g implements InterfaceC0163i {

        /* renamed from: o0, reason: collision with root package name */
        private AdvancedCheckBoxPreference f5074o0;
        private AdvancedCheckBoxPreference p0;
        private Context q0;

        /* renamed from: r0, reason: collision with root package name */
        private SubscriptionManager.OnSubscriptionsChangedListener f5075r0 = new C0096a();

        /* renamed from: com.android.mmt.ui.MultiSimPreferenceAcitvity$a$a, reason: collision with other inner class name */
        final class C0096a extends SubscriptionManager.OnSubscriptionsChangedListener {
            C0096a() {
            }

            @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
            public final void onSubscriptionsChanged() {
                if (C0287t.y()) {
                    Log.d("MultiSimPreferenceFg", "onChange update sim state");
                    a.j1(a.this);
                } else {
                    Log.d("MultiSimPreferenceFg", "onChange not multi sim is inserted");
                    a.this.x().finish();
                }
            }
        }

        static void j1(a aVar) {
            AdvancedCheckBoxPreference advancedCheckBoxPreference = aVar.f5074o0;
            if (advancedCheckBoxPreference != null) {
                advancedCheckBoxPreference.F0(aVar, 0);
            }
            AdvancedCheckBoxPreference advancedCheckBoxPreference2 = aVar.p0;
            if (advancedCheckBoxPreference2 != null) {
                advancedCheckBoxPreference2.F0(aVar, 1);
            }
        }

        @Override // androidx.preference.c
        public final void g1(String str) {
            i1(R.xml.multi_card_selection, str);
            this.q0 = B();
            Intent intent = x().getIntent();
            miuix.appcompat.app.b bVarK = ((miuix.appcompat.app.h) x()).K();
            if (bVarK != null) {
                bVarK.g(true);
                String stringExtra = intent.getStringExtra("preference_title");
                if (stringExtra != null) {
                    bVarK.n(stringExtra);
                }
            }
            String stringExtra2 = intent.getStringExtra("preference_key");
            this.f5074o0 = (AdvancedCheckBoxPreference) r("pref_key_sim1");
            this.p0 = (AdvancedCheckBoxPreference) r("pref_key_sim2");
            this.f5074o0.E0(this, 0);
            this.p0.E0(this, 1);
            SharedPreferences sharedPreferences = this.q0.getSharedPreferences("com.android.mmt_preferences", 0);
            long jM = C0287t.m(0);
            long jM2 = C0287t.m(1);
            this.f5074o0.h0(C0287t.b(jM, stringExtra2));
            this.p0.h0(C0287t.b(jM2, stringExtra2));
            if ("pref_key_mms_retrieval_during_roaming".equals(stringExtra2)) {
                this.f5074o0.d0(sharedPreferences.getBoolean(C0287t.b(jM, "pref_key_mms_auto_retrieval"), true));
                this.p0.d0(sharedPreferences.getBoolean(C0287t.b(jM2, "pref_key_mms_auto_retrieval"), true));
                AdvancedCheckBoxPreference advancedCheckBoxPreference = this.f5074o0;
                advancedCheckBoxPreference.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference.o(), MessagingPreferenceActivity.O(jM)));
                AdvancedCheckBoxPreference advancedCheckBoxPreference2 = this.p0;
                advancedCheckBoxPreference2.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference2.o(), MessagingPreferenceActivity.O(jM2)));
            } else if ("pref_key_mms_retrieval_during_national_roaming".equals(stringExtra2)) {
                this.f5074o0.d0(sharedPreferences.getBoolean(C0287t.b(jM, "pref_key_mms_auto_retrieval"), true));
                this.p0.d0(sharedPreferences.getBoolean(C0287t.b(jM2, "pref_key_mms_auto_retrieval"), true));
                AdvancedCheckBoxPreference advancedCheckBoxPreference3 = this.f5074o0;
                advancedCheckBoxPreference3.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference3.o(), true));
                AdvancedCheckBoxPreference advancedCheckBoxPreference4 = this.p0;
                advancedCheckBoxPreference4.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference4.o(), true));
            } else if ("pref_key_mms_retrieval_during_international_roaming".equals(stringExtra2)) {
                this.f5074o0.d0(sharedPreferences.getBoolean(C0287t.b(jM, "pref_key_mms_auto_retrieval"), true));
                this.p0.d0(sharedPreferences.getBoolean(C0287t.b(jM2, "pref_key_mms_auto_retrieval"), true));
                AdvancedCheckBoxPreference advancedCheckBoxPreference5 = this.f5074o0;
                advancedCheckBoxPreference5.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference5.o(), false));
                AdvancedCheckBoxPreference advancedCheckBoxPreference6 = this.p0;
                advancedCheckBoxPreference6.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference6.o(), false));
            } else if ("pref_key_mms_auto_retrieval".equals(stringExtra2)) {
                AdvancedCheckBoxPreference advancedCheckBoxPreference7 = this.f5074o0;
                advancedCheckBoxPreference7.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference7.o(), true));
                AdvancedCheckBoxPreference advancedCheckBoxPreference8 = this.p0;
                advancedCheckBoxPreference8.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference8.o(), true));
            } else if ("pref_key_delivery_reports".equals(stringExtra2)) {
                boolean zP = MessagingPreferenceActivity.P();
                AdvancedCheckBoxPreference advancedCheckBoxPreference9 = this.f5074o0;
                advancedCheckBoxPreference9.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference9.o(), zP));
                AdvancedCheckBoxPreference advancedCheckBoxPreference10 = this.p0;
                advancedCheckBoxPreference10.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference10.o(), zP));
            } else {
                AdvancedCheckBoxPreference advancedCheckBoxPreference11 = this.f5074o0;
                advancedCheckBoxPreference11.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference11.o(), false));
                AdvancedCheckBoxPreference advancedCheckBoxPreference12 = this.p0;
                advancedCheckBoxPreference12.x0(sharedPreferences.getBoolean(advancedCheckBoxPreference12.o(), false));
            }
            C0287t.H(this.f5075r0);
        }

        @Override // P0.InterfaceC0163i
        public final int h(int i2) {
            return C0287t.l(i2);
        }

        @Override // androidx.fragment.app.Fragment
        public final void h0() {
            C0287t.M(this.f5075r0);
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
        if (((a) wVarU.T("MultiSimPreferenceFg")) == null) {
            eF.b(android.R.id.content, new a(), "MultiSimPreferenceFg");
        }
        eF.h();
        wVarU.P();
    }
}
