package O;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.e;
import androidx.preference.ListPreference;

/* loaded from: classes.dex */
public class b extends androidx.preference.b {

    /* renamed from: A0, reason: collision with root package name */
    private CharSequence[] f749A0;

    /* renamed from: B0, reason: collision with root package name */
    private CharSequence[] f750B0;

    /* renamed from: z0, reason: collision with root package name */
    int f751z0;

    final class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            b bVar = b.this;
            bVar.f751z0 = i2;
            bVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        if (bundle != null) {
            this.f751z0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f749A0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f750B0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) i1();
        if (listPreference.F0() == null || listPreference.H0() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f751z0 = listPreference.E0(listPreference.I0());
        this.f749A0 = listPreference.F0();
        this.f750B0 = listPreference.H0();
    }

    @Override // androidx.preference.b
    public final void m1(boolean z4) {
        int i2;
        if (!z4 || (i2 = this.f751z0) < 0) {
            return;
        }
        String string = this.f750B0[i2].toString();
        ListPreference listPreference = (ListPreference) i1();
        if (listPreference.e(string)) {
            listPreference.L0(string);
        }
    }

    @Override // androidx.preference.b
    protected void n1(e.a aVar) {
        aVar.l(this.f749A0, this.f751z0, new a());
        aVar.j(null, null);
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public final void q0(Bundle bundle) {
        super.q0(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f751z0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f749A0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f750B0);
    }
}
