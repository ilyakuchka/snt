package com.android.mmt.ui;

import android.content.DialogInterface;
import android.view.ActionMode;

/* renamed from: com.android.mmt.ui.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0268y implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ActionMode f5775i;

    DialogInterfaceOnClickListenerC0268y(ActionMode actionMode) {
        this.f5775i = actionMode;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5775i.finish();
    }
}
