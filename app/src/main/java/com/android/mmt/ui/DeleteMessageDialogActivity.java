package com.android.mmt.ui;

import P0.ActivityC0156b;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public class DeleteMessageDialogActivity extends ActivityC0156b {

    /* renamed from: v, reason: collision with root package name */
    private miuix.appcompat.app.g f4754v;

    /* renamed from: w, reason: collision with root package name */
    private Uri f4755w;

    /* renamed from: x, reason: collision with root package name */
    private int f4756x;

    /* renamed from: y, reason: collision with root package name */
    private long f4757y;

    final class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            DeleteMessageDialogActivity deleteMessageDialogActivity = DeleteMessageDialogActivity.this;
            int i4 = deleteMessageDialogActivity.f4756x;
            long j2 = DeleteMessageDialogActivity.this.f4757y;
            if (j2 != -1) {
                C0.a.b(j2);
            } else {
                ((NotificationManager) deleteMessageDialogActivity.getSystemService("notification")).cancel(i4);
            }
            C0.a.a();
            Q2.c.a(new I(this, 0));
            DeleteMessageDialogActivity.this.finish();
        }
    }

    final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            DeleteMessageDialogActivity.this.finish();
        }
    }

    final class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            DeleteMessageDialogActivity.this.finish();
        }
    }

    private void R(Intent intent) {
        this.f4755w = intent.getData();
        intent.getBooleanExtra("is_verification_code", false);
        this.f4756x = intent.getIntExtra("extra_notification_id", -1);
        intent.getStringExtra("extra_address");
        this.f4757y = intent.getLongExtra("extra_threadid", -1L);
    }

    @Override // P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        R(getIntent());
        miuix.appcompat.app.g gVarA = com.android.mmt.util.e0.a(this, new a(), new b(), false, false);
        this.f4754v = gVarA;
        gVarA.setOnCancelListener(new c());
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        miuix.appcompat.app.g gVar = this.f4754v;
        if (gVar != null && gVar.isShowing()) {
            this.f4754v.dismiss();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onNewIntent(Intent intent) {
        R(intent);
        super.onNewIntent(intent);
    }
}
