package com.android.mmt.ui;

import P0.InterfaceC0163i;
import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public class AdvancedValueListPreference extends ValueListPreference {

    /* renamed from: i0, reason: collision with root package name */
    private int f4662i0;

    /* renamed from: j0, reason: collision with root package name */
    private InterfaceC0163i f4663j0;

    public AdvancedValueListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4662i0 = 0;
    }

    @Override // com.android.mmt.ui.ValueListPreference, androidx.preference.Preference
    public final void N(androidx.preference.h hVar) {
        super.N(hVar);
        TextView textView = (TextView) hVar.B(R.id.title);
        TextView textView2 = (TextView) hVar.B(R.id.summary);
        ImageView imageView = (ImageView) hVar.B(R.id.icon);
        if (imageView != null) {
            imageView.setMinimumWidth(0);
            int iH = this.f4663j0.h(this.f4662i0);
            if (iH != 0) {
                imageView.setBackgroundResource(iH);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        textView.setVisibility(0);
        textView.setText(this.f4663j0.n(this.f4662i0));
        String strM = this.f4663j0.m(this.f4662i0);
        if (TextUtils.isEmpty(strM)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(strM);
            textView2.setVisibility(0);
        }
    }

    public final int O0() {
        return this.f4662i0;
    }

    public final void P0(InterfaceC0163i interfaceC0163i, int i2) {
        this.f4663j0 = interfaceC0163i;
        this.f4662i0 = i2;
    }

    public final void Q0(InterfaceC0163i interfaceC0163i, int i2) {
        this.f4663j0 = interfaceC0163i;
        this.f4662i0 = i2;
        H();
    }

    public AdvancedValueListPreference(Context context) {
        super(context);
        this.f4662i0 = 0;
    }
}
