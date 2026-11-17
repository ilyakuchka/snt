package com.android.mmt.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.R;

/* renamed from: com.android.mmt.ui.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0237d0 implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f5555a;

    C0237d0(P p) {
        this.f5555a = p;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        if (this.f5555a.G0()) {
            this.f5555a.q0();
            return true;
        }
        Toast.makeText(MmsApp.c(), R.string.cannot_send_message, 1).show();
        return false;
    }
}
