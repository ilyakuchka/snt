package com.android.mmt.util;

import P0.ActivityC0156b;
import Q0.C0170c;
import android.os.Bundle;
import android.view.Menu;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class BlockedParticipantsActivity extends ActivityC0156b {

    /* renamed from: v, reason: collision with root package name */
    C0170c f5842v;

    @Override // android.app.Activity
    public final void onContextMenuClosed(Menu menu) {
        C0170c c0170c = this.f5842v;
        if (c0170c instanceof C0170c) {
            c0170c.s1(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        miuix.appcompat.app.b bVarK = K();
        bVarK.m(R.string.block_messaging_entry_title);
        bVarK.i();
        androidx.fragment.app.w wVarU = u();
        androidx.fragment.app.E eF = wVarU.f();
        C0170c c0170c = (C0170c) wVarU.T("SecretConversation");
        this.f5842v = c0170c;
        if (c0170c == null) {
            C0170c c0170c2 = new C0170c();
            this.f5842v = c0170c2;
            eF.b(android.R.id.content, c0170c2, "SecretConversation");
        }
        eF.h();
        wVarU.P();
    }
}
