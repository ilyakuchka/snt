package com.android.mmt.ui;

import P0.InterfaceC0163i;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.Preference;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class AdvancedEditorPreference extends Preference {

    /* renamed from: W, reason: collision with root package name */
    private int f4660W;

    /* renamed from: X, reason: collision with root package name */
    private InterfaceC0163i f4661X;

    public AdvancedEditorPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4660W = 0;
        i0(R.layout.advanced_editor_preference);
    }

    @Override // androidx.preference.Preference
    public final void N(androidx.preference.h hVar) {
        super.N(hVar);
        TextView textView = (TextView) hVar.B(R.id.simName);
        TextView textView2 = (TextView) hVar.B(R.id.simNumber);
        ImageView imageView = (ImageView) hVar.B(R.id.simIcon);
        if (imageView != null) {
            int iH = this.f4661X.h(this.f4660W);
            if (iH != 0) {
                imageView.setBackgroundResource(iH);
                imageView.setContentDescription(this.f4660W == 0 ? i().getString(R.string.sim_card1) : i().getString(R.string.sim_card2));
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        textView.setText(this.f4661X.n(this.f4660W));
        String strM = this.f4661X.m(this.f4660W);
        if (TextUtils.isEmpty(strM)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(strM);
            textView2.setVisibility(0);
        }
    }

    public final int w0() {
        return this.f4660W;
    }

    public final void x0(InterfaceC0163i interfaceC0163i, int i2) {
        this.f4661X = interfaceC0163i;
        this.f4660W = i2;
    }

    public final void y0(InterfaceC0163i interfaceC0163i, int i2) {
        this.f4661X = interfaceC0163i;
        this.f4660W = i2;
        H();
    }

    public AdvancedEditorPreference(Context context) {
        this(context, null);
    }
}
