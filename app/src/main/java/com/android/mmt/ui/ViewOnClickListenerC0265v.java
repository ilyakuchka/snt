package com.android.mmt.ui;

import android.content.DialogInterface;
import android.view.View;
import com.android.mmt.R;
import miuix.appcompat.app.g;

/* renamed from: com.android.mmt.ui.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0265v implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ r f5763i;

    /* renamed from: com.android.mmt.ui.v$a */
    final class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    ViewOnClickListenerC0265v(r rVar) {
        this.f5763i = rVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = String.format(this.f5763i.f5723s1.getResources().getString(R.string.security_alert_dialog_desc), this.f5763i.z0().get(0).W());
        g.a aVar = new g.a(this.f5763i.f5723s1);
        aVar.h();
        aVar.c(true);
        aVar.x(R.string.security_alert_dialog_title);
        aVar.k(str);
        aVar.t(android.R.string.ok, new a());
        aVar.m(R.string.no, null);
        aVar.A();
    }
}
