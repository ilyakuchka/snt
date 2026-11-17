package com.android.mmt.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.ListPreference;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class ValueListPreference extends ListPreference {

    /* renamed from: h0, reason: collision with root package name */
    private String f5494h0;

    public ValueListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i0(R.layout.miuix_preference_text);
    }

    public final void M0(int i2) {
        if (i2 > 0) {
            C0(i2);
        }
        D0();
    }

    @Override // androidx.preference.Preference
    public void N(androidx.preference.h hVar) {
        super.N(hVar);
        TextView textView = (TextView) hVar.B(R.id.text_right);
        if (textView != null) {
            if (TextUtils.isEmpty(this.f5494h0)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.f5494h0);
                textView.setVisibility(0);
            }
        }
        TextView textView2 = (TextView) hVar.B(android.R.id.summary);
        CharSequence charSequenceY = y();
        if (textView2 != null) {
            if (TextUtils.isEmpty(charSequenceY)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) hVar.B(R.id.arrow_right);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView3 = (TextView) hVar.B(android.R.id.title);
        if (textView3 != null) {
            textView3.setSingleLine(false);
            textView3.setMaxLines(2);
        }
    }

    public final void N0(String str) {
        this.f5494h0 = str;
    }

    public ValueListPreference(Context context) {
        this(context, null);
    }
}
