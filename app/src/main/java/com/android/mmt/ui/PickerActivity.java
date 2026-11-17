package com.android.mmt.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class PickerActivity extends miuix.appcompat.app.h {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.picker_activity);
        miuix.appcompat.app.b bVarK = K();
        int intExtra = getIntent().getIntExtra("pick_type", 0);
        if (intExtra != 0) {
            throw new IllegalArgumentException(D2.e.b("Unknown pick type ", intExtra));
        }
        androidx.fragment.app.w wVarU = u();
        androidx.fragment.app.E eF = wVarU.f();
        if (((C0252l) wVarU.T("BookmarkFragment")) == null) {
            eF.b(R.id.picker_container, new C0252l(), "BookmarkFragment");
        }
        eF.h();
        wVarU.P();
        bVarK.m(R.string.bookmark_list_title);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super.onKeyDown(i2, keyEvent);
        }
        com.android.mmt.util.C.e(this);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }
}
