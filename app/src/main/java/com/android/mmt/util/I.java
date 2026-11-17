package com.android.mmt.util;

import android.content.Context;
import android.content.DialogInterface;
import com.android.mmt.util.K;

/* loaded from: classes.dex */
public final /* synthetic */ class I implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5899i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f5900j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Context f5901k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f5902l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ K.a f5903m;

    public /* synthetic */ I(int i2, int i4, Context context, K.a aVar) {
        this.f5900j = i2;
        this.f5902l = i4;
        this.f5901k = context;
        this.f5903m = aVar;
    }

    public /* synthetic */ I(int i2, Context context, int i4, K.a aVar) {
        this.f5900j = i2;
        this.f5901k = context;
        this.f5902l = i4;
        this.f5903m = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        switch (this.f5899i) {
            case 0:
                K.a(this.f5900j, this.f5902l, this.f5901k, this.f5903m, dialogInterface);
                break;
            default:
                K.b(this.f5900j, this.f5901k, this.f5902l, this.f5903m, dialogInterface);
                break;
        }
    }
}
