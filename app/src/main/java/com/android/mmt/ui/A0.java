package com.android.mmt.ui;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.android.mmt.ui.PhraseActivity;

/* loaded from: classes.dex */
final class A0 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ PhraseActivity f4656i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ PhraseActivity.b f4657j;

    A0(PhraseActivity.b bVar, PhraseActivity phraseActivity) {
        this.f4657j = bVar;
        this.f4656i = phraseActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        String string = this.f4657j.d.getText().toString();
        if (this.f4657j.f5314b) {
            this.f4657j.f5314b = false;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f4656i.f5307v.c(string);
            return;
        }
        if (TextUtils.isEmpty(string)) {
            this.f4657j.g();
        } else {
            this.f4656i.f5307v.g(((Integer) this.f4657j.f5313a.second).intValue(), string);
        }
    }
}
