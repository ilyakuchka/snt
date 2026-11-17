package com.android.mmt.ui;

import android.view.View;
import android.widget.EditText;

/* renamed from: com.android.mmt.ui.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0240f implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f5558i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ C0230a f5559j;

    ViewOnClickListenerC0240f(C0230a c0230a, String str) {
        this.f5559j = c0230a;
        this.f5558i = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editTextY0 = this.f5559j.f5506a.y0();
        editTextY0.getText().insert(editTextY0.getSelectionStart(), this.f5558i);
    }
}
