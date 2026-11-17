package com.android.mmt.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class MessageSelectCopyTextActivity extends miuix.appcompat.app.h {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.message_select_copy_text);
        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.message_contact);
        String stringExtra = intent.getStringExtra("extra_contact");
        if (TextUtils.isEmpty(stringExtra)) {
            textView.setVisibility(8);
        } else {
            textView.setText(getResources().getString(R.string.message_contact) + stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("extra_number");
        TextView textView2 = (TextView) findViewById(R.id.message_number);
        if (TextUtils.isEmpty(stringExtra2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(getResources().getString(R.string.message_number) + stringExtra2);
        }
        ((TextView) findViewById(R.id.message_text)).setText(intent.getStringExtra("extra_body"));
    }
}
