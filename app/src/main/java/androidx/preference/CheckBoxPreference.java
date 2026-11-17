package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import t.C0384b;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: b0, reason: collision with root package name */
    private final a f3723b0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            if (CheckBoxPreference.this.e(Boolean.valueOf(z4))) {
                CheckBoxPreference.this.x0(z4);
            } else {
                compoundButton.setChecked(!z4);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D0(View view) {
        boolean z4 = view instanceof CompoundButton;
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3822W);
        }
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f3723b0);
        }
    }

    @Override // androidx.preference.Preference
    public void N(h hVar) {
        super.N(hVar);
        D0(hVar.B(R.id.checkbox));
        C0(hVar);
    }

    @Override // androidx.preference.Preference
    protected final void X(View view) {
        super.X(view);
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            D0(view.findViewById(R.id.checkbox));
            B0(view.findViewById(R.id.summary));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
        this.f3723b0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7877h, i2, i4);
        A0(x.e.d(typedArrayObtainStyledAttributes, 5, 0));
        z0(x.e.d(typedArrayObtainStyledAttributes, 4, 1));
        y0(typedArrayObtainStyledAttributes.getBoolean(3, typedArrayObtainStyledAttributes.getBoolean(2, false)));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, x.e.a(context, com.android.mmt.R.attr.checkBoxPreferenceStyle, R.attr.checkBoxPreferenceStyle));
    }

    public CheckBoxPreference(Context context) {
        this(context, null);
    }
}
