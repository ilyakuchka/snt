package com.android.mmt.ui;

import P0.InterfaceC0163i;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.util.Log;
import androidx.preference.Preference;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;

/* loaded from: classes.dex */
public class SelectCardPreferenceActivity extends miuix.appcompat.app.h {

    public static class a extends G3.g implements InterfaceC0163i {

        /* renamed from: o0, reason: collision with root package name */
        private AdvancedEditorPreference f5422o0;
        private AdvancedEditorPreference p0;
        private String q0;

        /* renamed from: r0, reason: collision with root package name */
        private Context f5423r0;

        /* renamed from: s0, reason: collision with root package name */
        private SubscriptionManager.OnSubscriptionsChangedListener f5424s0 = new C0099a();

        /* renamed from: com.android.mmt.ui.SelectCardPreferenceActivity$a$a, reason: collision with other inner class name */
        final class C0099a extends SubscriptionManager.OnSubscriptionsChangedListener {
            C0099a() {
            }

            @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
            public final void onSubscriptionsChanged() {
                if (C0287t.y()) {
                    Log.d("SelectCardPreference", "onChange update sim state");
                    a.j1(a.this);
                } else {
                    Log.d("SelectCardPreference", "onChange not multi sim is inserted");
                    a.this.x().finish();
                }
            }
        }

        static void j1(a aVar) {
            AdvancedEditorPreference advancedEditorPreference = aVar.f5422o0;
            if (advancedEditorPreference != null) {
                advancedEditorPreference.y0(aVar, 0);
            }
            AdvancedEditorPreference advancedEditorPreference2 = aVar.p0;
            if (advancedEditorPreference2 != null) {
                advancedEditorPreference2.y0(aVar, 1);
            }
        }

        private boolean k1(int i2) {
            int iJ = C0287t.j(i2);
            if (iJ == 2) {
                return false;
            }
            if (iJ == 1) {
                String strO = C0287t.o(i2);
                if ("46003".equals(strO) || "46005".equals(strO) || "46011".equals(strO)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.preference.c
        public final void g1(String str) {
            i1(R.xml.multi_cards_editor_preference, str);
            this.f5423r0 = B();
            Intent intent = x().getIntent();
            miuix.appcompat.app.b bVarK = ((miuix.appcompat.app.h) x()).K();
            if (bVarK != null) {
                bVarK.g(true);
                String stringExtra = intent.getStringExtra("preference_title");
                if (stringExtra != null) {
                    bVarK.n(stringExtra);
                }
            }
            this.q0 = intent.getStringExtra("preference_key");
            this.f5422o0 = (AdvancedEditorPreference) r("pref_key_sim1");
            this.p0 = (AdvancedEditorPreference) r("pref_key_sim2");
            AdvancedEditorPreference advancedEditorPreference = this.f5422o0;
            if (advancedEditorPreference != null) {
                advancedEditorPreference.x0(this, 0);
                this.f5422o0.d0(k1(0));
            }
            AdvancedEditorPreference advancedEditorPreference2 = this.p0;
            if (advancedEditorPreference2 != null) {
                advancedEditorPreference2.x0(this, 1);
                this.p0.d0(k1(1));
            }
            C0287t.H(this.f5424s0);
        }

        @Override // P0.InterfaceC0163i
        public final int h(int i2) {
            return C0287t.l(i2);
        }

        @Override // androidx.fragment.app.Fragment
        public final void h0() {
            C0287t.M(this.f5424s0);
            super.h0();
        }

        @Override // G3.g, androidx.preference.c, androidx.preference.g.c
        public final boolean j(Preference preference) {
            if ("pref_key_edit_sim_smsc_address".equals(this.q0)) {
                C0287t.L(this.f5423r0, ((AdvancedEditorPreference) preference).w0());
            }
            return super.j(preference);
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
        if (((a) wVarU.T("SelectCardPreference")) == null) {
            eF.b(android.R.id.content, new a(), "SelectCardPreference");
        }
        eF.h();
        wVarU.P();
    }
}
