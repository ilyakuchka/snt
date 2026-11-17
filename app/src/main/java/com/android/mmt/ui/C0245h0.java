package com.android.mmt.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.android.mmt.ui.h0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0245h0 implements RecyclerView.r {
    C0245h0() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public final void a(RecyclerView.x xVar) {
        View view = xVar.f4055i;
        if (view instanceof MessageListItem) {
            ((MessageListItem) view).R();
        }
    }
}
