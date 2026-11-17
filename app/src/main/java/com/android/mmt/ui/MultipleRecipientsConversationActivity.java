package com.android.mmt.ui;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;
import com.android.mmt.ui.O0;
import com.android.mmt.ui.r;
import java.util.Iterator;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class MultipleRecipientsConversationActivity extends r {
    private MultipleRecipientsConversationHeader H1;
    private miuix.appcompat.app.b I1;

    final class a implements O0.d {
        a() {
        }

        @Override // com.android.mmt.ui.O0.d
        public final void a(RecyclerView recyclerView, View view, int i2) {
            if (view == null || !(view instanceof MessageListItem)) {
                return;
            }
            ((MessageListItem) view).J();
        }
    }

    private class b extends r.p {
        b() {
            super();
        }

        @Override // com.android.mmt.ui.r.p, android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            super.onCreateActionMode(actionMode, menu);
            if (MultipleRecipientsConversationActivity.this.I1 == null) {
                return true;
            }
            MultipleRecipientsConversationActivity.this.I1.i();
            return true;
        }

        @Override // com.android.mmt.ui.r.p, android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            super.onDestroyActionMode(actionMode);
            if (MultipleRecipientsConversationActivity.this.I1 != null) {
                MultipleRecipientsConversationActivity.this.I1.d();
            }
        }
    }

    @Override // com.android.mmt.ui.r, com.android.mmt.ui.P
    protected final void D0() throws Resources.NotFoundException {
        super.D0();
        MultipleRecipientsConversationHeader multipleRecipientsConversationHeader = (MultipleRecipientsConversationHeader) findViewById(R.id.contact_panel);
        this.H1 = multipleRecipientsConversationHeader;
        multipleRecipientsConversationHeader.setPaddingRelative(multipleRecipientsConversationHeader.getPaddingStart(), 0, this.H1.getPaddingEnd(), this.H1.getPaddingBottom());
        this.I1 = K();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.contact_panel_height);
        this.f5713i1 = dimensionPixelSize;
        e1(dimensionPixelSize);
    }

    @Override // com.android.mmt.ui.r
    protected final void Z1() {
        super.Z1();
        this.f5694P0.U0(new a());
    }

    @Override // com.android.mmt.ui.r
    protected final void a2(long j2) {
        super.a2(j2);
    }

    @Override // com.android.mmt.ui.r
    protected final void f2() {
        this.f5694P0.K1(new b());
    }

    @Override // com.android.mmt.ui.r
    @SuppressLint({"LogTagMismatch"})
    protected final void h2() {
        C0416c c0416c = this.f5246Z;
        if (c0416c == null) {
            Log.i("MultipleRecipientsCA", "mConversation is null");
            return;
        }
        Uri uriJ = c0416c.J();
        if (uriJ == null) {
            return;
        }
        if (Log.isLoggable("Mms:app", 2)) {
            Log.v("MultipleRecipientsCA", "startMsgListQuery MultiRecipientCA for " + uriJ);
        }
        this.f5702X0.a(9527);
        try {
            this.f5702X0.f(9527, null, uriJ, C0247i0.f5605N, null, null);
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(this, e2);
        }
    }

    @Override // com.android.mmt.ui.r
    protected final void j2(C0415b c0415b) {
        this.H1.d(c0415b);
    }

    @Override // com.android.mmt.ui.r, com.android.mmt.ui.P, P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        O0();
        super.onCreate(bundle);
    }

    @Override // com.android.mmt.ui.r, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onResume() {
        super.onResume();
        C0415b c0415bZ0 = z0();
        if (c0415bZ0 == null || c0415bZ0.isEmpty()) {
            return;
        }
        Iterator<C0414a> it = c0415bZ0.iterator();
        while (it.hasNext()) {
            it.next();
            W0();
        }
    }

    @Override // com.android.mmt.ui.P
    protected final int x0() {
        return R.layout.multiple_recipients_conversation_activity;
    }
}
