package com.android.mmt.ui;

import android.content.Intent;
import android.view.View;

/* renamed from: com.android.mmt.ui.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0236d implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0230a f5554i;

    ViewOnClickListenerC0236d(C0230a c0230a) {
        this.f5554i = c0230a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f5554i.f5506a, (Class<?>) PhraseActivity.class);
        intent.setAction("android.intent.action.PICK_ACTIVITY");
        this.f5554i.f5506a.startActivityForResult(intent, 113);
    }
}
