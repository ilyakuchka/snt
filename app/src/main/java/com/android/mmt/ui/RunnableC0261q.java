package com.android.mmt.ui;

import android.app.Application;
import android.content.ContentValues;
import android.provider.Telephony;
import com.android.mmt.MmsApp;

/* renamed from: com.android.mmt.ui.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0261q implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ StringBuilder f5687i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ ContentValues f5688j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ StringBuilder f5689k;

    RunnableC0261q(StringBuilder sb, ContentValues contentValues, StringBuilder sb2) {
        this.f5687i = sb;
        this.f5688j = contentValues;
        this.f5689k = sb2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Application applicationC = MmsApp.c();
        if (this.f5687i.length() > 0) {
            com.android.mmt.util.O.g(applicationC, applicationC.getContentResolver(), Telephony.Sms.CONTENT_URI, this.f5688j, this.f5687i.toString(), null);
        }
        if (this.f5689k.length() > 0) {
            com.android.mmt.util.O.g(applicationC, applicationC.getContentResolver(), Telephony.Mms.CONTENT_URI, this.f5688j, this.f5689k.toString(), null);
        }
    }
}
