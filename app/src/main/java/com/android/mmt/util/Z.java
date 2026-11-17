package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class Z implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f5934i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5935j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Context f5936k;

    Z(String str, b0.a aVar, Context context) {
        this.f5934i = str;
        this.f5935j = aVar;
        this.f5936k = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra(this.f5934i, this.f5935j.f5943c);
        b0.c(this.f5936k, intent);
    }
}
