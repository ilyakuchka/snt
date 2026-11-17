package com.android.mmt.ui;

import android.content.Intent;
import android.view.View;
import com.android.mmt.transaction.TransactionService;

/* renamed from: com.android.mmt.ui.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0251k0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0243g0 f5659i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ MessageListItem f5660j;

    ViewOnClickListenerC0251k0(MessageListItem messageListItem, C0243g0 c0243g0) {
        this.f5660j = messageListItem;
        this.f5659i = c0243g0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f5660j.f4953j, (Class<?>) TransactionService.class);
        intent.putExtra("uri", this.f5659i.v().toString());
        intent.putExtra("type", 1);
        this.f5660j.f4953j.startService(intent);
    }
}
