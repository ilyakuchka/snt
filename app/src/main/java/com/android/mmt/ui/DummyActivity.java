package com.android.mmt.ui;

import android.content.Intent;
import android.os.Bundle;
import com.android.mmt.transaction.NotificationAssistService;

/* loaded from: classes.dex */
public class DummyActivity extends miuix.appcompat.app.h {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        intent.setClass(this, NotificationAssistService.class);
        startService(intent);
        finish();
        overridePendingTransition(0, 0);
    }
}
