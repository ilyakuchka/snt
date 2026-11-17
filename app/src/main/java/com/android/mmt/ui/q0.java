package com.android.mmt.ui;

import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
final class q0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ MessageOriginalTextActivity f5690i;

    q0(MessageOriginalTextActivity messageOriginalTextActivity) {
        this.f5690i = messageOriginalTextActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5690i.f5021I) {
            MessageOriginalTextActivity messageOriginalTextActivity = this.f5690i;
            P0.r.y(messageOriginalTextActivity, messageOriginalTextActivity.f5022J, this.f5690i.f5023K, false);
        } else {
            MessageOriginalTextActivity messageOriginalTextActivity2 = this.f5690i;
            P0.r.y(messageOriginalTextActivity2, messageOriginalTextActivity2.f5022J, this.f5690i.f5023K, true);
        }
        Objects.requireNonNull(this.f5690i);
        MessageOriginalTextActivity.V(this.f5690i);
    }
}
