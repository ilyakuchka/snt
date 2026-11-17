package com.android.mmt.ui;

import android.widget.CompoundButton;
import com.android.mmt.R;
import com.android.mmt.ui.C0243g0;

/* renamed from: com.android.mmt.ui.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0253l0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0243g0 f5670a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0243g0.a f5671b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MessageListItem f5672c;

    C0253l0(MessageListItem messageListItem, C0243g0 c0243g0, C0243g0.a aVar) {
        this.f5672c = messageListItem;
        this.f5670a = c0243g0;
        this.f5671b = aVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        if (z4) {
            this.f5670a.a(this.f5671b.f5598b);
        } else {
            this.f5670a.a0(this.f5671b.f5598b);
        }
        int size = this.f5670a.b0().size();
        this.f5672c.f4976x.f4988b.setText(this.f5672c.f4953j.getString(R.string.group_resend_message, Integer.valueOf(size)));
        this.f5672c.f4976x.f4988b.setEnabled(size > 0);
    }
}
