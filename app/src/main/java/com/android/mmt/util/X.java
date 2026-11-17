package com.android.mmt.util;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.android.mmt.R;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class X implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f5930i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5931j;

    X(Context context, b0.a aVar) {
        this.f5930i = context;
        this.f5931j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((ClipboardManager) this.f5930i.getSystemService("clipboard")).setText(this.f5931j.f5943c);
        Context context = this.f5930i;
        Toast.makeText(context, context.getResources().getString(R.string.context_menu_copy_notice), 0).show();
    }
}
