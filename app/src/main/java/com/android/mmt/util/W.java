package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.android.mmt.ui.C0243g0;
import com.android.mmt.util.C0277i;
import com.android.mmt.util.b0;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class W implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ b0.a f5927i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ C0243g0 f5928j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Context f5929k;

    W(b0.a aVar, C0243g0 c0243g0, Context context) {
        this.f5927i = aVar;
        this.f5928j = c0243g0;
        this.f5929k = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intentPutExtra;
        ArrayList arrayList = (ArrayList) C0277i.b(this.f5927i.d);
        if (arrayList.size() == 1) {
            C0277i.a aVar = (C0277i.a) arrayList.get(0);
            intentPutExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("allDay", aVar == null ? false : aVar.c()).putExtra("beginTime", aVar != null ? aVar.a().getTime() : 0L).putExtra("endTime", 0);
            if (this.f5928j != null) {
                String str = this.f5928j.l() + ":" + this.f5928j.g();
                if (!TextUtils.isEmpty(str)) {
                    intentPutExtra.putExtra("title", str);
                }
            }
        } else if (arrayList.size() == 2) {
            C0277i.a aVar2 = (C0277i.a) arrayList.get(0);
            C0277i.a aVar3 = (C0277i.a) arrayList.get(1);
            intentPutExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("allDay", aVar2 != null && aVar3 != null && aVar2.c() && aVar3.c()).putExtra("beginTime", aVar2 == null ? 0L : aVar2.a().getTime()).putExtra("endTime", aVar3 != null ? aVar3.a().getTime() : 0L);
            if (this.f5928j != null) {
                String str2 = this.f5928j.l() + ":" + this.f5928j.g();
                if (!TextUtils.isEmpty(str2)) {
                    intentPutExtra.putExtra("title", str2);
                }
            }
        } else {
            intentPutExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("allDay", true).putExtra("beginTime", 0).putExtra("endTime", 0);
            if (this.f5928j != null) {
                String str3 = this.f5928j.l() + ":" + this.f5928j.g();
                if (!TextUtils.isEmpty(str3)) {
                    intentPutExtra.putExtra("title", str3);
                }
            }
        }
        b0.c(this.f5929k, intentPutExtra);
    }
}
