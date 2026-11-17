package O;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.preference.EditTextPreference;
import java.util.Objects;

/* loaded from: classes.dex */
public class a extends androidx.preference.b {

    /* renamed from: A0, reason: collision with root package name */
    private CharSequence f747A0;

    /* renamed from: z0, reason: collision with root package name */
    private EditText f748z0;

    private EditTextPreference o1() {
        return (EditTextPreference) i1();
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        if (bundle == null) {
            this.f747A0 = o1().E0();
        } else {
            this.f747A0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.b
    protected final boolean j1() {
        return true;
    }

    @Override // androidx.preference.b
    protected final void k1(View view) {
        super.k1(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f748z0 = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.f748z0.setText(this.f747A0);
        EditText editText2 = this.f748z0;
        editText2.setSelection(editText2.getText().length());
        Objects.requireNonNull(o1());
    }

    @Override // androidx.preference.b
    public final void m1(boolean z4) {
        if (z4) {
            String string = this.f748z0.getText().toString();
            EditTextPreference editTextPreferenceO1 = o1();
            if (editTextPreferenceO1.e(string)) {
                editTextPreferenceO1.F0(string);
            }
        }
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public final void q0(Bundle bundle) {
        super.q0(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f747A0);
    }
}
