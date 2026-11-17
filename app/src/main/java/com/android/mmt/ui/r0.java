package com.android.mmt.ui;

import android.text.ClipboardManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
final class r0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ MessageOriginalTextActivity f5755i;

    r0(MessageOriginalTextActivity messageOriginalTextActivity) {
        this.f5755i = messageOriginalTextActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MessageOriginalTextActivity messageOriginalTextActivity = this.f5755i;
        String str = messageOriginalTextActivity.f5020H;
        int i2 = P0.r.f937c;
        try {
            ((ClipboardManager) messageOriginalTextActivity.getSystemService("clipboard")).setText(str);
            Toast.makeText(messageOriginalTextActivity, R.string.copy_message_text_success, 0).show();
        } catch (Exception e2) {
            Log.e("Mms", "onContextItemSelected: copyMessageTextToClipboard body failed", e2);
        }
        Objects.requireNonNull(this.f5755i);
        MessageOriginalTextActivity.V(this.f5755i);
    }
}
