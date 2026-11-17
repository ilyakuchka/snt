package com.android.mmt.ui;

import android.content.DialogInterface;
import com.android.mmt.util.C0273e;

/* renamed from: com.android.mmt.ui.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0242g implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0230a f5561i;

    DialogInterfaceOnClickListenerC0242g(C0230a c0230a) {
        this.f5561i = c0230a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        if (i2 == 0) {
            if (com.android.mmt.util.A.k(this.f5561i.f5506a, O2.a.a() ? new String[]{"android.permission.CAMERA", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"} : new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"}, 1023)) {
                return;
            }
            this.f5561i.s();
        } else {
            if (i2 != 1) {
                return;
            }
            if (com.android.mmt.util.A.k(this.f5561i.f5506a, O2.a.a() ? new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1026)) {
                return;
            }
            C0273e.e(this.f5561i.f5506a);
        }
    }
}
