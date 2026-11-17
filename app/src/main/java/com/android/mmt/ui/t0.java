package com.android.mmt.ui;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes.dex */
final class t0 implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ NewMessageActivity f5760i;

    t0(NewMessageActivity newMessageActivity) {
        this.f5760i = newMessageActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Cursor cursor = (Cursor) this.f5760i.f5117d1.getItem(i2);
        this.f5760i.f5104Q0.setText("");
        if (NewMessageActivity.y1(this.f5760i, cursor.getString(3))) {
            this.f5760i.s2();
        }
    }
}
