package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: h0, reason: collision with root package name */
    private final ArrayAdapter f3731h0;

    /* renamed from: i0, reason: collision with root package name */
    private Spinner f3732i0;

    /* renamed from: j0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f3733j0;

    final class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (i2 >= 0) {
                String string = DropDownPreference.this.H0()[i2].toString();
                if (string.equals(DropDownPreference.this.I0()) || !DropDownPreference.this.e(string)) {
                    return;
                }
                DropDownPreference.this.L0(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle, 0);
    }

    private void M0() {
        this.f3731h0.clear();
        if (F0() != null) {
            for (CharSequence charSequence : F0()) {
                this.f3731h0.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected final void H() {
        super.H();
        ArrayAdapter arrayAdapter = this.f3731h0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.ListPreference
    public final void J0(CharSequence[] charSequenceArr) {
        super.J0(charSequenceArr);
        M0();
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) {
        Spinner spinner = (Spinner) hVar.f4055i.findViewById(R.id.spinner);
        this.f3732i0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f3731h0);
        this.f3732i0.setOnItemSelectedListener(this.f3733j0);
        Spinner spinner2 = this.f3732i0;
        String strI0 = I0();
        CharSequence[] charSequenceArrH0 = H0();
        int i2 = -1;
        if (strI0 != null && charSequenceArrH0 != null) {
            int length = charSequenceArrH0.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                if (charSequenceArrH0[length].equals(strI0)) {
                    i2 = length;
                    break;
                }
                length--;
            }
        }
        spinner2.setSelection(i2);
        super.N(hVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected final void O() {
        this.f3732i0.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle, 0);
        this.f3733j0 = new a();
        this.f3731h0 = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        M0();
    }
}
