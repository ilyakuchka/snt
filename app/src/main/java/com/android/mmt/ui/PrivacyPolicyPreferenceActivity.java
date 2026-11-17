package com.android.mmt.ui;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class PrivacyPolicyPreferenceActivity extends miuix.appcompat.app.h {

    public static class a extends G3.g implements Preference.d, Preference.e {

        /* renamed from: u0, reason: collision with root package name */
        public static final /* synthetic */ int f5321u0 = 0;

        /* renamed from: o0, reason: collision with root package name */
        private Preference f5322o0;
        private Preference p0;
        private Preference q0;

        /* renamed from: r0, reason: collision with root package name */
        private CheckBoxPreference f5323r0;

        /* renamed from: s0, reason: collision with root package name */
        private AsyncTask<Void, Object, Void> f5324s0;

        /* renamed from: t0, reason: collision with root package name */
        private miuix.appcompat.app.h f5325t0;

        @SuppressLint({"LongLogTag"})
        private void m1(String str) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                intent.setData(Uri.parse(str));
                b1(intent);
            } catch (ActivityNotFoundException e2) {
                Log.e("PolicyFragment", "getUserNotice: " + str, e2);
            }
        }

        @Override // androidx.preference.Preference.d
        @SuppressLint({"LongLogTag"})
        public final boolean b(Preference preference, Object obj) {
            if (preference == this.f5323r0) {
                if (((Boolean) obj).booleanValue()) {
                    androidx.preference.g.c(this.f5325t0).edit().putBoolean("privacy_authority", true).apply();
                    Log.d("PolicyFragment", "mPrivacyAuthorityPref is check ");
                } else {
                    miuix.appcompat.app.h hVar = this.f5325t0;
                    AsyncTask<Void, Object, Void> asyncTask = this.f5324s0;
                    if (asyncTask != null) {
                        asyncTask.cancel(true);
                    }
                    if (this.f5324s0 == null) {
                        B0 b02 = new B0(this, hVar);
                        this.f5324s0 = b02;
                        b02.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                    Log.d("PolicyFragment", "mPrivacyAuthorityPref is not check");
                }
            }
            return true;
        }

        @Override // androidx.preference.c
        public final void g1(String str) {
            i1(R.xml.privacy_policy_preferences, str);
            this.f5325t0 = (miuix.appcompat.app.h) x();
            Preference preferenceR = r("pref_key_mx_privacy_policy");
            this.f5322o0 = preferenceR;
            preferenceR.l0(this);
            Preference preferenceR2 = r("pref_key_smart_msg_privacy_policy");
            this.p0 = preferenceR2;
            preferenceR2.l0(this);
            Preference preferenceR3 = r("pref_key_privacy_policy");
            this.q0 = preferenceR3;
            preferenceR3.l0(this);
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) r("pref_key_privacy_authority");
            this.f5323r0 = checkBoxPreference;
            checkBoxPreference.k0(this);
            e1().C0(this.q0);
            e1().C0(this.f5323r0);
        }

        @Override // androidx.preference.c, androidx.fragment.app.Fragment
        public final void i0() {
            super.i0();
            AsyncTask<Void, Object, Void> asyncTask = this.f5324s0;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                this.f5324s0 = null;
            }
        }

        @Override // androidx.preference.Preference.e
        public final boolean k(Preference preference) {
            if (preference == this.f5322o0) {
                m1(String.format("https://privacy.mi.com/websms/%s/", S2.b.a()));
                return true;
            }
            if (preference == this.p0) {
                m1(String.format("https://privacy.mi.com/smart-sms/%s/", S2.b.a()));
                return true;
            }
            if (preference != this.q0) {
                return false;
            }
            try {
                throw null;
            } catch (ActivityNotFoundException e2) {
                Log.e("PolicyFragment", "getUserNotice", e2);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.w wVarU = u();
        androidx.fragment.app.E eF = wVarU.f();
        if (((a) wVarU.T("PolicyFragment")) == null) {
            eF.b(android.R.id.content, new a(), "PolicyFragment");
        }
        eF.h();
        wVarU.P();
    }
}
