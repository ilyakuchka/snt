package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import t.C0384b;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: b0, reason: collision with root package name */
    private final a f3814b0;

    /* renamed from: c0, reason: collision with root package name */
    private CharSequence f3815c0;

    /* renamed from: d0, reason: collision with root package name */
    private CharSequence f3816d0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            if (SwitchPreference.this.e(Boolean.valueOf(z4))) {
                SwitchPreference.this.x0(z4);
            } else {
                compoundButton.setChecked(!z4);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, 0);
        this.f3814b0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7886r, i2, 0);
        A0(x.e.d(typedArrayObtainStyledAttributes, 7, 0));
        z0(x.e.d(typedArrayObtainStyledAttributes, 6, 1));
        this.f3815c0 = x.e.d(typedArrayObtainStyledAttributes, 9, 3);
        H();
        this.f3816d0 = x.e.d(typedArrayObtainStyledAttributes, 8, 4);
        H();
        y0(typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false)));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D0(View view) {
        boolean z4 = view instanceof Switch;
        if (z4) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3822W);
        }
        if (z4) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.f3815c0);
            r4.setTextOff(this.f3816d0);
            r4.setOnCheckedChangeListener(this.f3814b0);
        }
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) {
        super.N(hVar);
        D0(hVar.B(R.id.switch_widget));
        C0(hVar);
    }

    @Override // androidx.preference.Preference
    protected final void X(View view) {
        super.X(view);
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            D0(view.findViewById(R.id.switch_widget));
            B0(view.findViewById(R.id.summary));
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, x.e.a(context, com.android.mmt.R.attr.switchPreferenceStyle, R.attr.switchPreferenceStyle), 0);
    }
}
