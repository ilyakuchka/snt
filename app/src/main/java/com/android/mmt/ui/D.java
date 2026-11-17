package com.android.mmt.ui;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.ActivityC0219o;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.ui.O0;
import x0.C0414a;
import x0.C0416c;

/* loaded from: classes.dex */
final class D implements O0.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0269z f4751a;

    D(C0269z c0269z) {
        this.f4751a = c0269z;
    }

    @Override // com.android.mmt.ui.O0.d
    public final void a(RecyclerView recyclerView, View view, int i2) {
        C0414a c0414a;
        StringBuilder sbC = C2.c.c("item click, position ", i2, " header");
        sbC.append(this.f4751a.f5795h0.N0());
        Log.v("ConversationFragment", sbC.toString());
        C0269z c0269z = this.f4751a;
        if (view == c0269z.f5793f0) {
            c0269z.A1();
            C0269z c0269z2 = this.f4751a;
            ActivityC0219o activityC0219o = c0269z2.f5790c0;
            int i4 = FlatMessageListActivity.f4821w;
            Intent intent = new Intent(activityC0219o, (Class<?>) FlatMessageListActivity.class);
            intent.putExtra("fragment", "bookmark");
            c0269z2.b1(intent);
            return;
        }
        if (i2 < c0269z.f5795h0.N0()) {
            return;
        }
        this.f4751a.A1();
        C0269z c0269z3 = this.f4751a;
        C0416c c0416cU = C0416c.u(this.f4751a.f5790c0, (Cursor) c0269z3.f5797j0.G(i2 - c0269z3.f5795h0.N0()));
        long jI = c0416cU.I();
        if (jI == -100) {
            try {
                Intent intent2 = new Intent("miui.intent.action.SET_FIREWALL");
                intent2.putExtra("antispam_action_source", "action_source_sms");
                this.f4751a.f5790c0.startActivity(intent2);
                return;
            } catch (Exception e2) {
                Log.e("ConversationFragment", "open blocked ", e2);
                return;
            }
        }
        Log.d("ConversationFragment", "onListItemClick: pos=" + i2 + ", view=" + view + ", tid=" + jI);
        if (this.f4751a.p0) {
            synchronized (c0416cU) {
            }
        }
        if (c0416cU.G() != null && c0416cU.G().size() > 0 && (c0414a = c0416cU.G().get(0)) != null) {
            synchronized (c0414a) {
            }
            synchronized (c0416cU) {
            }
        }
        this.f4751a.b1(ComposeMessageRouterActivity.a(this.f4751a.f5790c0, jI));
    }
}
