package com.android.mmt.ui;

import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class S implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ArrayList f5333i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f5334j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ String f5335k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ Runnable f5336l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ miuix.appcompat.app.g f5337m;

    /* renamed from: n, reason: collision with root package name */
    final /* synthetic */ P f5338n;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            miuix.appcompat.app.g gVar = S.this.f5337m;
            if (gVar == null || !com.android.mmt.util.e0.e(gVar.getOwnerActivity())) {
                return;
            }
            S.this.f5337m.dismiss();
        }
    }

    S(P p, ArrayList arrayList, String str, String str2, Runnable runnable, miuix.appcompat.app.g gVar) {
        this.f5338n = p;
        this.f5333i = arrayList;
        this.f5334j = str;
        this.f5335k = str2;
        this.f5336l = runnable;
        this.f5337m = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f5333i;
        if (arrayList != null && arrayList.size() > 0) {
            this.f5338n.f5252f0.h(this.f5334j, (Uri) ((Parcelable) this.f5333i.get(0)), true);
        }
        if (!TextUtils.isEmpty(this.f5335k)) {
            this.f5338n.f5241U.h0(this.f5335k);
        }
        this.f5338n.f5273y0.removeCallbacks(this.f5336l);
        this.f5338n.f5273y0.post(new a());
    }
}
