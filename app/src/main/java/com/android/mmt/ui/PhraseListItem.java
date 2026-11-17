package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class PhraseListItem extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private TextView f5320i;

    public PhraseListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(String str) {
        this.f5320i.setText(str);
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.f5320i = (TextView) findViewById(R.id.phrase_body);
    }
}
