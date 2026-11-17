package com.android.mmt.ui;

import android.util.Log;

/* loaded from: classes.dex */
public class UserAgreementActivity extends miuix.appcompat.app.h {
    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onResume() {
        super.onResume();
        Log.d("UserAgreementActivity", "showUserAgreementDialog");
        com.android.mmt.util.K.g(this, 520, new M0(this), 4);
    }
}
