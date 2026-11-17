package com.android.mmt.util;

import android.content.DialogInterface;
import android.view.View;

/* loaded from: classes.dex */
final class E implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f5846i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ miuix.appcompat.app.g f5847j;

    E(DialogInterface.OnClickListener onClickListener, miuix.appcompat.app.g gVar) {
        this.f5846i = onClickListener;
        this.f5847j = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogInterface.OnClickListener onClickListener = this.f5846i;
        if (onClickListener != null) {
            onClickListener.onClick(this.f5847j, 0);
        }
    }
}
