package com.android.mmt;

import K0.b;
import android.os.Process;
import android.provider.Settings;
import com.android.mmt.util.C0288u;
import com.android.mmt.util.P;
import java.util.Objects;
import k0.d;
import u0.C0391c;
import x0.C0416c;

/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ MmsApp f4486i;

    a(MmsApp mmsApp) {
        this.f4486i = mmsApp;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Process.setThreadPriority(10);
        b.a().c();
        C0416c.N();
        Settings.Global.getInt(this.f4486i.getContentResolver(), "airplane_mode_on", 0);
        boolean z4 = MmsApp.f4463s;
        d.v(MmsApp.f4461q);
        C0288u.h();
        MmsApp unused = MmsApp.f4461q;
        MmsApp unused2 = MmsApp.f4461q;
        C0391c.c();
        Objects.requireNonNull(P.a());
        M0.d.b().f(1500L);
    }
}
