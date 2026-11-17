package com.android.mmt.ui;

import android.app.Activity;
import android.content.ContentUris;
import android.provider.Telephony;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.C0252l;
import f0.C0303b;
import g0.C0313i;
import g0.C0318n;
import j0.C0337b;
import miuix.appcompat.app.g;

/* renamed from: com.android.mmt.ui.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class AsyncTaskC0250k extends Q2.d<Object, Void, String, Activity> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0252l.a f5658b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC0250k(C0252l.a aVar, Activity activity) {
        super(activity);
        this.f5658b = aVar;
    }

    @Override // Q2.d
    protected final Object a(Object obj) throws Throwable {
        C0313i c0313iB;
        C0243g0 c0243g0 = this.f5658b.f5668a;
        if (c0243g0 == null) {
            return null;
        }
        long jZ = c0243g0.z();
        try {
            c0313iB = G0.p.B(MmsApp.c(), ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, jZ));
        } catch (C0303b e2) {
            e2.printStackTrace();
            c0313iB = null;
        }
        if (c0313iB == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int iH = c0313iB.h();
        for (int i2 = 0; i2 < iH; i2++) {
            C0318n c0318nC = c0313iB.c(i2);
            String str = new String(c0318nC.g());
            if (C0337b.f(str) || C0337b.h(str) || C0337b.d(str) || str.equals("application/ogg")) {
                String strZ = P0.r.z(MmsApp.c(), c0318nC, Long.toHexString(jZ));
                if (strZ == null) {
                    return null;
                }
                sb.append("\n");
                sb.append(strZ);
            }
        }
        return sb.toString();
    }

    @Override // Q2.d
    protected final void b(Activity activity, String str) {
        Activity activity2 = activity;
        String str2 = str;
        if (activity2.isFinishing() || activity2.isDestroyed()) {
            return;
        }
        g.a aVar = new g.a(activity2);
        aVar.x(R.string.copy_to_sdcard);
        aVar.h();
        if (str2 != null) {
            aVar.k(C0252l.this.R(R.string.copy_to_sdcard_success, str2));
        } else {
            aVar.j(R.string.copy_to_sdcard_fail);
        }
        aVar.o(null);
        aVar.A();
    }
}
