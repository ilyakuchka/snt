package com.android.mmt.ui;

import P0.InterfaceC0163i;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class AdvancedCheckBoxPreference extends CheckBoxPreference {

    /* renamed from: c0, reason: collision with root package name */
    private int f4658c0;

    /* renamed from: d0, reason: collision with root package name */
    private InterfaceC0163i f4659d0;

    public AdvancedCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4658c0 = 0;
        i0(R.layout.advanced_checkbox_preference);
    }

    public final void E0(InterfaceC0163i interfaceC0163i, int i2) {
        this.f4659d0 = interfaceC0163i;
        this.f4658c0 = i2;
    }

    public final void F0(InterfaceC0163i interfaceC0163i, int i2) {
        this.f4659d0 = interfaceC0163i;
        this.f4658c0 = i2;
        H();
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public final void N(androidx.preference.h hVar) {
        super.N(hVar);
        TextView textView = (TextView) hVar.B(R.id.simName);
        TextView textView2 = (TextView) hVar.B(R.id.simNumber);
        ImageView imageView = (ImageView) hVar.B(R.id.simIcon);
        if (imageView != null) {
            int iH = this.f4659d0.h(this.f4658c0);
            if (iH > 0) {
                imageView.setBackgroundResource(iH);
                imageView.setContentDescription(this.f4658c0 == 0 ? i().getString(R.string.sim_card1) : i().getString(R.string.sim_card2));
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        textView.setText(this.f4659d0.n(this.f4658c0));
        String strM = this.f4659d0.m(this.f4658c0);
        if (TextUtils.isEmpty(strM)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(strM);
            textView2.setVisibility(0);
        }
    }

    public AdvancedCheckBoxPreference(Context context) {
        this(context, null);
    }
}
