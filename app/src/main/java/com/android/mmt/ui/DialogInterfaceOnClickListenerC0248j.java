package com.android.mmt.ui;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.net.Uri;
import android.provider.Telephony;
import com.android.mmt.ui.C0252l;
import java.util.Objects;

/* renamed from: com.android.mmt.ui.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0248j implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0252l.a f5655i;

    DialogInterfaceOnClickListenerC0248j(C0252l.a aVar) {
        this.f5655i = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        C0254m c0254m = C0252l.this.f5661f0;
        C0243g0 c0243g0 = this.f5655i.f5668a;
        Objects.requireNonNull(c0254m);
        Uri uriWithAppendedId = ContentUris.withAppendedId(c0243g0.Z() ? Telephony.Sms.CONTENT_URI : Telephony.Mms.CONTENT_URI, c0243g0.z());
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("locked", (Integer) 0);
        c0254m.f4871h.g(uriWithAppendedId, contentValues);
        c0254m.N();
    }
}
