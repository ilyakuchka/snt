package com.android.mmt.ui;

import android.content.Context;
import android.provider.Telephony;
import android.view.View;

/* renamed from: com.android.mmt.ui.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0257n0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ long f5677i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ long f5678j;

    /* renamed from: com.android.mmt.ui.n0$a */
    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f5679i;

        a(Context context) {
            this.f5679i = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f5679i.getContentResolver().delete(Telephony.Sms.CONTENT_URI, "thread_id=? AND date=? AND type=5", new String[]{String.valueOf(ViewOnClickListenerC0257n0.this.f5677i), String.valueOf(ViewOnClickListenerC0257n0.this.f5678j)});
        }
    }

    ViewOnClickListenerC0257n0(long j2, long j4) {
        this.f5677i = j2;
        this.f5678j = j4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Q2.c.a(new a(view.getContext()));
    }
}
