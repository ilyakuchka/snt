package com.android.mmt.ui;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0289v;
import miuix.appcompat.app.g;

/* renamed from: com.android.mmt.ui.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0266w implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ r f5766i;

    /* renamed from: com.android.mmt.ui.w$a */
    final class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (C0287t.x()) {
                C0289v.c(ViewOnClickListenerC0266w.this.f5766i.getApplicationContext(), ViewOnClickListenerC0266w.this.f5766i.f5721q1 + 1);
            } else {
                C0289v.c(ViewOnClickListenerC0266w.this.f5766i.getApplicationContext(), 1);
            }
            StringBuilder sbD = D2.e.d("mms block slotId:");
            sbD.append(ViewOnClickListenerC0266w.this.f5766i.f5721q1);
            Log.d("ConversationBase", sbD.toString());
            ViewOnClickListenerC0266w.this.f5766i.g2(false);
        }
    }

    ViewOnClickListenerC0266w(r rVar) {
        this.f5766i = rVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g.a aVar = new g.a(this.f5766i.f5723s1);
        aVar.h();
        aVar.c(true);
        aVar.x(R.string.mms_block_alert_title);
        aVar.j(R.string.mms_block_alert_message);
        aVar.t(R.string.mms_block_alert_ok, new a());
        aVar.m(R.string.no, null);
        aVar.A();
    }
}
