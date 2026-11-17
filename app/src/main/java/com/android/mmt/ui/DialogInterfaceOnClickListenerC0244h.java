package com.android.mmt.ui;

import android.content.DialogInterface;
import java.util.Objects;

/* renamed from: com.android.mmt.ui.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0244h implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0230a f5599i;

    DialogInterfaceOnClickListenerC0244h(C0230a c0230a) {
        this.f5599i = c0230a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        Objects.requireNonNull(this.f5599i);
        C0230a.c(this.f5599i);
    }
}
