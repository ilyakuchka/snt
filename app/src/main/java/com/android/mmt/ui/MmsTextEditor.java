package com.android.mmt.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class MmsTextEditor extends EditText {

    /* renamed from: i, reason: collision with root package name */
    private P f5073i;

    public MmsTextEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!(context instanceof P)) {
            throw new IllegalArgumentException("MmsTextEditor can only be used by MessageEditableActivityBase");
        }
        this.f5073i = (P) context;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 67 && getSelectionStart() == 0 && getSelectionEnd() == 0) {
            if (this.f5073i.f5241U.A()) {
                this.f5073i.f5241U.N(true);
                return true;
            }
            if (this.f5073i.f5241U.x() != 0) {
                this.f5073i.n0();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
