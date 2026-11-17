package com.android.mmt.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class ServiceProviderConversationListActivity extends miuix.appcompat.app.h {

    /* renamed from: v, reason: collision with root package name */
    private E0 f5426v;

    @Override // android.app.Activity
    public final void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        Q0.B b2 = (Q0.B) u().T("ServiceConversation");
        if (b2 != null) {
            b2.s1(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.private_conversation_list_screen);
        androidx.fragment.app.w wVarU = u();
        androidx.fragment.app.E eF = wVarU.f();
        E0 e02 = (E0) wVarU.T("ServiceProviderConversationFragment");
        this.f5426v = e02;
        if (e02 == null) {
            E0 e03 = new E0();
            this.f5426v = e03;
            e03.R0(getIntent().getExtras());
            eF.b(R.id.private_container, this.f5426v, "ServiceProviderConversationFragment");
        }
        miuix.appcompat.app.b bVarK = K();
        bVarK.m(R.string.sp_conversation_title);
        bVarK.j(true);
        eF.h();
        wVarU.P();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super.onKeyDown(i2, keyEvent);
        }
        com.android.mmt.util.C.e(this);
        return true;
    }
}
