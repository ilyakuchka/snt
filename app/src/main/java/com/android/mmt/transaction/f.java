package com.android.mmt.transaction;

import android.content.Context;
import com.android.mmt.MmsApp;
import java.io.IOException;

/* loaded from: classes.dex */
final class f implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f4626i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ int f4627j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ CharSequence f4628k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ long f4629l;

    f(Context context, int i2, CharSequence charSequence, long j2) {
        this.f4626i = context;
        this.f4627j = i2;
        this.f4628k = charSequence;
        this.f4629l = j2;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        if (androidx.preference.g.c(MmsApp.c()).getBoolean("pref_key_delivery_ringtone", true)) {
            d.e(this.f4626i);
        }
        d.f(this.f4628k, this.f4629l);
    }
}
