package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class a0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f5937i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5938j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Context f5939k;

    a0(String str, b0.a aVar, Context context) {
        this.f5937i = str;
        this.f5938j = aVar;
        this.f5939k = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra(this.f5937i, this.f5938j.f5943c);
        b0.c(this.f5939k, intent);
    }
}
