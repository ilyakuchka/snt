package com.android.mmt.ui;

import O0.f;
import P0.ActivityC0156b;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.util.C0275g;
import com.android.mmt.util.C0287t;
import t.C0384b;

/* loaded from: classes.dex */
public class MessagingPreferenceActivity extends ActivityC0156b {

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f5045v = 0;

    public static class a extends G3.g implements Preference.e, Preference.d {

        /* renamed from: y0, reason: collision with root package name */
        private static String f5046y0 = "com.android.cellbroadcastreceiver";

        /* renamed from: o0, reason: collision with root package name */
        private CheckBoxPreference f5047o0;
        private Preference p0;
        private Preference q0;

        /* renamed from: r0, reason: collision with root package name */
        private PreferenceCategory f5048r0;

        /* renamed from: s0, reason: collision with root package name */
        private CheckBoxPreference f5049s0;

        /* renamed from: t0, reason: collision with root package name */
        private PreferenceCategory f5050t0;

        /* renamed from: u0, reason: collision with root package name */
        private Preference f5051u0;

        /* renamed from: v0, reason: collision with root package name */
        private miuix.appcompat.app.h f5052v0;

        /* renamed from: w0, reason: collision with root package name */
        private SubscriptionManager.OnSubscriptionsChangedListener f5053w0 = new C0095a();

        /* renamed from: x0, reason: collision with root package name */
        private f.h f5054x0 = new b();

        /* renamed from: com.android.mmt.ui.MessagingPreferenceActivity$a$a, reason: collision with other inner class name */
        final class C0095a extends SubscriptionManager.OnSubscriptionsChangedListener {
            C0095a() {
            }

            @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
            public final void onSubscriptionsChanged() {
                Log.d("MessagingPreference", "update sim info change");
            }
        }

        final class b implements f.h {
            b() {
            }

            @Override // O0.f.h
            public final void a() {
                Log.d("MessagingPreference", "update sim info change");
            }
        }

        @Override // androidx.preference.Preference.d
        public final boolean b(Preference preference, Object obj) {
            if (preference == this.f5047o0) {
                Settings.System.putInt(this.f5052v0.getContentResolver(), "pref_key_enable_notification_body", ((Boolean) obj).booleanValue() ? 1 : 0);
                return true;
            }
            if (preference == null || preference != this.f5049s0) {
                return true;
            }
            MmsApp.f4463s = ((Boolean) obj).booleanValue();
            return true;
        }

        @Override // G3.g, androidx.preference.c, androidx.fragment.app.Fragment
        public final View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewG0 = super.g0(layoutInflater, viewGroup, bundle);
            RecyclerView recyclerView = (RecyclerView) viewG0.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                recyclerView.setOverScrollMode(2);
            }
            return viewG0;
        }

        @Override // androidx.preference.c
        public final void g1(String str) {
            PreferenceCategory preferenceCategory;
            i1(R.xml.preferences, str);
            this.f5052v0 = (miuix.appcompat.app.h) x();
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) r("pref_key_enable_notification_body");
            this.f5047o0 = checkBoxPreference;
            checkBoxPreference.k0(this);
            this.f5048r0 = (PreferenceCategory) r("pref_key_notification_settings");
            this.p0 = r("pref_key_delivery_reports");
            Preference preferenceR = r("pref_key_send_delivery_reports");
            this.q0 = preferenceR;
            if (preferenceR != null) {
                this.f5048r0.C0(preferenceR);
            }
            Preference preference = this.p0;
            if (preference != null) {
                boolean z4 = true;
                preference.c0(Boolean.valueOf(C0275g.c() || C0384b.j("IN")));
                SharedPreferences sharedPreferences = this.f5052v0.getSharedPreferences("com.android.mmt_preferences", 0);
                CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.p0;
                if (!C0275g.c() && !C0384b.j("IN")) {
                    z4 = false;
                }
                checkBoxPreference2.x0(sharedPreferences.getBoolean("pref_key_delivery_reports", z4));
            }
            this.f5050t0 = (PreferenceCategory) r("pref_other_settings");
            CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) r("pref_key_use_gsm_alphabet");
            this.f5049s0 = checkBoxPreference3;
            checkBoxPreference3.k0(this);
            if (!C0275g.a() && (preferenceCategory = this.f5050t0) != null) {
                preferenceCategory.C0(this.f5049s0);
            }
            Preference preferenceR2 = r("pref_cell_broadcast");
            this.f5051u0 = preferenceR2;
            int i2 = C0275g.f5975b;
            preferenceR2.l0(this);
            if (C0287t.x()) {
                C0287t.H(this.f5053w0);
            } else {
                O0.f.j().s(this.f5054x0);
            }
        }

        @Override // androidx.fragment.app.Fragment
        public final void h0() {
            if (C0287t.x()) {
                C0287t.M(this.f5053w0);
            } else {
                O0.f.j().t(this.f5054x0);
            }
            super.h0();
        }

        @Override // androidx.fragment.app.Fragment
        public final void j0() {
            super.j0();
            this.f5052v0 = null;
        }

        @Override // androidx.preference.Preference.e
        public final boolean k(Preference preference) {
            boolean z4 = false;
            if (preference == this.p0 || preference == this.q0 || preference != this.f5051u0) {
                return false;
            }
            if (Build.DEVICE.equals("ice")) {
                f5046y0 = "com.android.cellbroadcastreceiver";
            } else {
                f5046y0 = "com.google.android.cellbroadcastreceiver";
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            try {
                if (MmsApp.c().getApplicationContext().getPackageManager().getApplicationEnabledSetting(f5046y0) != 2) {
                    z4 = true;
                }
            } catch (Exception unused) {
                Log.e("MessagingPreference", "com.android.cellbroadcastreceiver not found");
            }
            if (z4) {
                Log.i("MessagingPreference", " hasAndroidCellBroadcast ");
                intent.setComponent(new ComponentName(f5046y0, "com.android.cellbroadcastreceiver.CellBroadcastListActivity"));
            } else {
                Log.i("MessagingPreference", " isMtk");
                intent.setComponent(new ComponentName("com.mediatek.cellbroadcastreceiver", "com.mediatek.cellbroadcastreceiver.CellBroadcastListActivity"));
            }
            try {
                b1(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }

        @Override // androidx.fragment.app.Fragment
        public final void p0() {
            super.p0();
            if (c1() != null && K2.a.f334e) {
                c1().t0();
            }
            this.f5047o0.x0(P0.r.t(this.f5052v0));
        }
    }

    public static boolean O(long j2) {
        int iQ = C0287t.q(j2);
        if (iQ != -1) {
            String strO = C0287t.o(iQ);
            if ((C0275g.b() && ("27205".equals(strO) || "27202".equals(strO))) || "26806".equals(strO)) {
                return true;
            }
        }
        return C0275g.f();
    }

    public static boolean P() {
        return C0275g.c() || C0384b.j("IN");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.w wVarU = u();
        androidx.fragment.app.E eF = wVarU.f();
        if (((a) wVarU.T("MessagingPreference")) == null) {
            eF.b(android.R.id.content, new a(), "MessagingPreference");
        }
        eF.h();
        wVarU.P();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }
}
