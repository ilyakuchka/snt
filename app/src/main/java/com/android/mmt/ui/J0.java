package com.android.mmt.ui;

import android.content.DialogInterface;
import com.android.mmt.storage.bugle.BugleDatabase;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class J0 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ SingleRecipientConversationActivity f4866i;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(J0.this.f4866i.f5246Z.I()));
            BugleDatabase.y().x().q(arrayList, 1);
        }
    }

    J0(SingleRecipientConversationActivity singleRecipientConversationActivity) {
        this.f4866i = singleRecipientConversationActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        SingleRecipientConversationActivity.k2(this.f4866i);
        Q2.c.a(new a());
        this.f4866i.finish();
    }
}
