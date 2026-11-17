package com.android.mmt.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class FlatMessageListActivity extends miuix.appcompat.app.h {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f4821w = 0;

    /* renamed from: v, reason: collision with root package name */
    private ViewGroup f4822v = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.flat_message_list_activity);
        String stringExtra = getIntent().getStringExtra("fragment");
        androidx.fragment.app.w wVarU = u();
        Fragment c0252l = (miuix.appcompat.app.j) wVarU.T(stringExtra);
        if (c0252l == null && "bookmark".equals(stringExtra)) {
            c0252l = new C0252l();
        }
        if (c0252l != null) {
            if (c0252l.z() == null) {
                c0252l.R0(getIntent().getExtras());
            } else {
                c0252l.z().clear();
                c0252l.z().putAll(getIntent().getExtras());
            }
            androidx.fragment.app.E eF = wVarU.f();
            eF.o(R.id.content, c0252l, stringExtra);
            eF.h();
            wVarU.P();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super.onKeyDown(i2, keyEvent);
        }
        com.android.mmt.util.C.e(this);
        return true;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onResume() {
        super.onResume();
        if (this.f4822v != null) {
            this.f4822v = null;
        }
    }
}
