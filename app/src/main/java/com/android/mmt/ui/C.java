package com.android.mmt.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;

/* loaded from: classes.dex */
final class C implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f4688i;

    C(Context context) {
        this.f4688i = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Settings.System.putInt(this.f4688i.getContentResolver(), "mms_upload_old_msg_state", 0);
        Settings.System.putString(this.f4688i.getContentResolver(), "mms_upload_old_msg_accounts", null);
    }
}
