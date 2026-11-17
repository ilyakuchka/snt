package com.android.mmt.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public class PermissionCheckActivity extends miuix.appcompat.app.h {

    /* renamed from: v, reason: collision with root package name */
    private PermissionCheckActivity f5305v;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PermissionCheckActivity.O(PermissionCheckActivity.this);
        }
    }

    static void O(PermissionCheckActivity permissionCheckActivity) {
        Objects.requireNonNull(permissionCheckActivity);
        String[] strArrA = com.android.mmt.util.A.a(com.android.mmt.util.A.f5835a);
        if (strArrA.length != 0) {
            com.android.mmt.util.A.k(permissionCheckActivity.f5305v, strArrA, 1);
            return;
        }
        Intent intent = new Intent(permissionCheckActivity, (Class<?>) MmsTabActivity.class);
        intent.setFlags(603979776);
        permissionCheckActivity.startActivity(intent);
        permissionCheckActivity.finish();
    }

    private boolean P() {
        if (!com.android.mmt.util.A.i()) {
            return false;
        }
        Intent intent = new Intent(this, (Class<?>) MmsTabActivity.class);
        intent.setFlags(603979776);
        startActivity(intent);
        finish();
        return true;
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5305v = this;
        if (P()) {
            return;
        }
        setContentView(R.layout.mms_main_screen);
        new Handler().post(new a());
    }

    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (com.android.mmt.util.A.a(strArr).length == strArr.length) {
                com.android.mmt.util.A.b(this, R.string.permission_retry_dialog_msg, true);
                return;
            }
            if (com.android.mmt.util.A.i()) {
                finish();
            }
            Process.killProcess(Process.myPid());
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onResume() {
        super.onResume();
        P();
    }
}
