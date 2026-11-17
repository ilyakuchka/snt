package com.android.mmt.util;

import android.content.DialogInterface;
import android.view.View;

/* loaded from: classes.dex */
final class D implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f5844i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ miuix.appcompat.app.g f5845j;

    D(DialogInterface.OnClickListener onClickListener, miuix.appcompat.app.g gVar) {
        this.f5844i = onClickListener;
        this.f5845j = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogInterface.OnClickListener onClickListener = this.f5844i;
        if (onClickListener != null) {
            onClickListener.onClick(this.f5845j, 0);
        }
    }
}
