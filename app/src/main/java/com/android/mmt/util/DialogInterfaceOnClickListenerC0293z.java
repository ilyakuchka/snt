package com.android.mmt.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;

/* renamed from: com.android.mmt.util.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0293z implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6057i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f6058j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Activity f6059k;

    public /* synthetic */ DialogInterfaceOnClickListenerC0293z(Activity activity, boolean z4) {
        this.f6059k = activity;
        this.f6058j = z4;
    }

    public /* synthetic */ DialogInterfaceOnClickListenerC0293z(boolean z4, Activity activity) {
        this.f6058j = z4;
        this.f6059k = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        switch (this.f6057i) {
            case 0:
                Activity activity = this.f6059k;
                boolean z4 = this.f6058j;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", activity.getPackageName(), null));
                intent.addFlags(268435456);
                activity.startActivity(intent);
                if (z4) {
                    Process.killProcess(Process.myPid());
                    break;
                }
                break;
            default:
                boolean z5 = this.f6058j;
                Activity activity2 = this.f6059k;
                if (z5) {
                    activity2.moveTaskToBack(true);
                    Process.killProcess(Process.myPid());
                    break;
                }
                break;
        }
    }
}
