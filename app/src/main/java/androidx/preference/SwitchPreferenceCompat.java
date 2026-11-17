package androidx.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: b0, reason: collision with root package name */
    private final a f3818b0;

    /* renamed from: c0, reason: collision with root package name */
    private CharSequence f3819c0;

    /* renamed from: d0, reason: collision with root package name */
    private CharSequence f3820d0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            if (SwitchPreferenceCompat.this.e(Boolean.valueOf(z4))) {
                SwitchPreferenceCompat.this.x0(z4);
            } else {
                compoundButton.setChecked(!z4);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, R.attr.switchPreferenceCompatStyle, 0);
        this.f3818b0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7887s, R.attr.switchPreferenceCompatStyle, 0);
        A0(x.e.d(typedArrayObtainStyledAttributes, 7, 0));
        z0(x.e.d(typedArrayObtainStyledAttributes, 6, 1));
        this.f3819c0 = x.e.d(typedArrayObtainStyledAttributes, 9, 3);
        H();
        this.f3820d0 = x.e.d(typedArrayObtainStyledAttributes, 8, 4);
        H();
        y0(typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false)));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D0(View view) throws Resources.NotFoundException {
        boolean z4 = view instanceof SwitchCompat;
        if (z4) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3822W);
        }
        if (z4) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.f(this.f3819c0);
            switchCompat.e(this.f3820d0);
            switchCompat.setOnCheckedChangeListener(this.f3818b0);
        }
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) throws Resources.NotFoundException {
        super.N(hVar);
        D0(hVar.B(R.id.switchWidget));
        C0(hVar);
    }

    @Override // androidx.preference.Preference
    protected final void X(View view) throws Resources.NotFoundException {
        super.X(view);
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            D0(view.findViewById(R.id.switchWidget));
            B0(view.findViewById(android.R.id.summary));
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle, 0);
    }
}
