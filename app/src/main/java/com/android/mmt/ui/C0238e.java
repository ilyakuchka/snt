package com.android.mmt.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import java.util.Objects;

/* renamed from: com.android.mmt.ui.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0238e implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0230a f5556i;

    C0238e(C0230a c0230a) {
        this.f5556i = c0230a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        String str = (String) this.f5556i.f5517n.getItem(i2);
        P p = this.f5556i.f5506a;
        Objects.requireNonNull(p);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.f5235N.getText().insert(p.f5235N.getSelectionStart(), str);
        p.h1();
    }
}
