package com.android.mmt.util;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.ui.O0;
import com.android.mmt.util.EditableListViewV2;

/* renamed from: com.android.mmt.util.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0282n implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ EditableListViewV2.g f6035i;

    /* renamed from: com.android.mmt.util.n$a */
    final class a implements O0.d {
        a() {
        }

        @Override // com.android.mmt.ui.O0.d
        public final void a(RecyclerView recyclerView, View view, int i2) {
            int iA1 = EditableListViewV2.a1(EditableListViewV2.this, i2);
            if (iA1 == -1 || !view.isEnabled()) {
                return;
            }
            EditableListViewV2.h.o(EditableListViewV2.this.f5855S0, view, iA1);
        }
    }

    RunnableC0282n(EditableListViewV2.g gVar) {
        this.f6035i = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6035i.f5879b.U0(new a());
        EditableListViewV2.this.setLongClickable(false);
    }
}
