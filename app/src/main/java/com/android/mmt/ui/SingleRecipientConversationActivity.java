package com.android.mmt.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.android.mmt.R;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.util.EditableListViewV2;
import java.util.Iterator;
import java.util.Objects;
import miuix.appcompat.app.g;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class SingleRecipientConversationActivity extends r {
    public static final /* synthetic */ int N1 = 0;
    protected P0.F H1;
    private miuix.appcompat.app.g I1;
    private boolean J1;

    /* renamed from: K1, reason: collision with root package name */
    private String f5428K1 = "";
    private Runnable L1;
    private Runnable M1;

    final class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4) {
        }
    }

    final class b implements EditableListViewV2.l {
        b() {
        }

        @Override // com.android.mmt.util.EditableListViewV2.l
        public final void a(int i2) {
            Log.v("SingleRecipientCA", "onDoubleClick " + i2);
            int iM0 = i2 - SingleRecipientConversationActivity.this.f5694P0.M0();
            if (iM0 < 0 || iM0 >= SingleRecipientConversationActivity.this.f5694P0.getChildCount() || !(SingleRecipientConversationActivity.this.f5694P0.getChildAt(iM0) instanceof MessageListItem)) {
                return;
            }
            ((MessageListItem) SingleRecipientConversationActivity.this.f5694P0.getChildAt(iM0)).K();
        }

        @Override // com.android.mmt.util.EditableListViewV2.l
        public final void b(int i2) {
            Log.v("SingleRecipientCA", "onSingleClick " + i2);
            int iM0 = i2 - SingleRecipientConversationActivity.this.f5694P0.M0();
            if (iM0 < 0 || iM0 >= SingleRecipientConversationActivity.this.f5694P0.getChildCount() || !(SingleRecipientConversationActivity.this.f5694P0.getChildAt(iM0) instanceof MessageListItem)) {
                return;
            }
            ((MessageListItem) SingleRecipientConversationActivity.this.f5694P0.getChildAt(iM0)).J();
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SingleRecipientConversationActivity singleRecipientConversationActivity = SingleRecipientConversationActivity.this;
            int i2 = SingleRecipientConversationActivity.N1;
            Objects.requireNonNull(singleRecipientConversationActivity);
            SingleRecipientConversationActivity.l2(singleRecipientConversationActivity);
        }
    }

    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BugleDatabase.y().x().h(SingleRecipientConversationActivity.this.f5246Z.I());
        }
    }

    public SingleRecipientConversationActivity() {
        new a(this.f5273y0);
        this.L1 = new c();
        this.M1 = new d();
    }

    static void k2(SingleRecipientConversationActivity singleRecipientConversationActivity) {
        Q2.c.a(singleRecipientConversationActivity.L1);
    }

    static void l2(SingleRecipientConversationActivity singleRecipientConversationActivity) {
        S2.f.a(String.format(singleRecipientConversationActivity.getString(R.string.add_to_block_by_number), singleRecipientConversationActivity.z0().get(0).W()));
    }

    @Override // com.android.mmt.ui.r, com.android.mmt.ui.P
    protected final void D0() {
        this.H1 = new P0.F(this, K(), this.f5709e1);
        super.D0();
        this.f5713i1 = 0;
        e1(0);
    }

    @Override // com.android.mmt.ui.P
    protected final void T0(String str) {
        C0247i0 c0247i0;
        if (!"pref_key_show_template".equals(str) && !"pref_key_smart_sms_state".equals(str)) {
            if ("pref_key_card_format_miui".equals(str)) {
                this.f5252f0.B();
            }
        } else {
            if (isFinishing() || (c0247i0 = this.f5695Q0) == null) {
                return;
            }
            Objects.requireNonNull(c0247i0);
        }
    }

    @Override // com.android.mmt.ui.P
    protected final void U0() {
    }

    @Override // com.android.mmt.ui.r
    protected final void X1() {
        if (this.J1) {
            return;
        }
        this.J1 = true;
    }

    @Override // com.android.mmt.ui.r
    protected final void Z1() {
        super.Z1();
        Y1();
        if (z0() != null && z0().size() > 0) {
            this.f5695Q0.d0(z0().get(0).W());
        }
        this.f5694P0.M1(new b());
    }

    @Override // com.android.mmt.ui.r
    protected final void a2(long j2) {
        super.a2(j2);
        Intent intent = getIntent();
        Uri uri = com.android.mmt.transaction.d.f4609m;
        if (intent != null && intent.getBooleanExtra("failed_download_flag", false)) {
            com.android.mmt.transaction.d.r(531);
        }
    }

    @Override // com.android.mmt.ui.r
    @SuppressLint({"LogTagMismatch"})
    protected final void h2() {
        Log.v("SingleRecipientCA", "querying message list");
        C0416c c0416c = this.f5246Z;
        if (c0416c == null) {
            Log.i("SingleRecipientCA", "mConversation is null");
            return;
        }
        Uri uriJ = c0416c.J();
        if (uriJ == null) {
            Log.i("SingleRecipientCA", "conversation uri is null, it is a new conv");
            return;
        }
        if (Log.isLoggable("Mms:app", 2)) {
            Log.v("SingleRecipientCA", "startMsgListQuery for " + uriJ);
        }
        this.f5702X0.a(9527);
        try {
            this.f5702X0.f(9527, null, uriJ, C0247i0.M, null, null);
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(getApplicationContext(), e2);
        }
    }

    @Override // com.android.mmt.ui.r
    protected final void j2(C0415b c0415b) {
        if (this.f5708d1) {
            this.f5709e1 = c0415b;
        } else {
            this.H1.b(c0415b);
        }
    }

    @Override // com.android.mmt.ui.r, com.android.mmt.ui.P, P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        O0();
        super.onCreate(bundle);
        System.currentTimeMillis();
        N();
    }

    @Override // com.android.mmt.ui.r, com.android.mmt.ui.P, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        Runnable runnable = this.L1;
        if (runnable != null) {
            Q2.c.b(runnable);
        }
        Runnable runnable2 = this.M1;
        if (runnable2 != null) {
            Q2.c.b(runnable2);
        }
        if (z0() != null) {
            z0().size();
        }
        super.onDestroy();
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908310) {
            if (itemId != 16908332) {
                return super.onMenuItemSelected(i2, menuItem);
            }
            w0();
            return true;
        }
        P0.F f4 = this.H1;
        if (f4 != null) {
            f4.a();
        }
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 1) {
            String string = getString(R.string.block_number_message);
            if (this.I1 == null) {
                g.a aVar = new g.a(this.f5723s1);
                aVar.x(R.string.menu_sms_block);
                aVar.k(string);
                aVar.m(R.string.no, null);
                aVar.t(R.string.yes, new J0(this));
                this.I1 = aVar.a();
            }
            this.I1.show();
        }
        return true;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onPause() {
        super.onPause();
        com.android.mmt.transaction.d.B(0L);
        P0.D d2 = this.f5245Y;
        if (d2 != null) {
            d2.dismiss();
        }
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0, 1, 0, R.string.menu_sms_block);
        return true;
    }

    @Override // com.android.mmt.ui.r, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onResume() {
        super.onResume();
        C0415b c0415bZ0 = z0();
        if (c0415bZ0 != null && !c0415bZ0.isEmpty()) {
            Iterator<C0414a> it = c0415bZ0.iterator();
            while (it.hasNext()) {
                it.next();
                W0();
            }
        }
        com.android.mmt.transaction.d.B(this.f5246Z.I());
    }

    @Override // com.android.mmt.ui.P
    protected final int x0() {
        return R.layout.single_recipient_conversation_activity;
    }
}
