package com.android.mmt.ui;

import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.android.mmt.ui.PhraseActivity;

/* loaded from: classes.dex */
final class z0 implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PhraseActivity f5832a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PhraseActivity.b f5833b;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (z0.this.f5833b.f5317f.get() != null) {
                z0 z0Var = z0.this;
                PhraseActivity phraseActivity = z0Var.f5832a;
                EditText editText = z0Var.f5833b.d;
                editText.requestFocus();
                ((InputMethodManager) phraseActivity.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }
    }

    z0(PhraseActivity.b bVar, PhraseActivity phraseActivity) {
        this.f5833b = bVar;
        this.f5832a = phraseActivity;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        this.f5833b.d.postDelayed(new a(), 100L);
    }
}
