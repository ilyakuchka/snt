package com.android.mmt.ui;

import a.C0178a;
import android.content.Intent;
import android.util.Pair;
import com.android.mmt.MmsApp;
import com.android.mmt.util.C0287t;
import java.util.HashSet;

/* loaded from: classes.dex */
final class y0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f5776i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ int f5777j;

    y0(String str, int i2) {
        this.f5776i = str;
        this.f5777j = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f5776i;
        int i2 = this.f5777j;
        HashSet<Pair<String, Pair<String, Integer>>> hashSet = NoConfirmationSendService.f5193m;
        long jM = C0287t.m(i2);
        int iG = C0178a.g((int) jM);
        Intent intent = new Intent("com.android.mmt.intent.action.SEND_AND_REMOVE_PENNDING_MESSAGE");
        intent.putExtra("extra_address", str);
        intent.putExtra("extra_usemx", false);
        intent.putExtra("subscription_id", jM);
        intent.putExtra("phone_id", iG);
        intent.putExtra("slot_id", i2);
        intent.setPackage(MmsApp.c().getPackageName());
        MmsApp.c().startService(intent);
    }
}
