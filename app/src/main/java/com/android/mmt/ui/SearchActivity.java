package com.android.mmt.ui;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public class SearchActivity extends miuix.appcompat.app.h {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            ComposeMessageRouterActivity.e(this, intent);
        }
        finish();
    }
}
