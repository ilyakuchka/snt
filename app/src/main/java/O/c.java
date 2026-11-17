package O;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.e;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class c extends androidx.preference.b {

    /* renamed from: A0, reason: collision with root package name */
    boolean f753A0;

    /* renamed from: B0, reason: collision with root package name */
    CharSequence[] f754B0;

    /* renamed from: C0, reason: collision with root package name */
    CharSequence[] f755C0;

    /* renamed from: z0, reason: collision with root package name */
    Set<String> f756z0 = new HashSet();

    final class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public final void onClick(DialogInterface dialogInterface, int i2, boolean z4) {
            if (z4) {
                c cVar = c.this;
                cVar.f753A0 |= cVar.f756z0.add(cVar.f755C0[i2].toString());
            } else {
                c cVar2 = c.this;
                cVar2.f753A0 |= cVar2.f756z0.remove(cVar2.f755C0[i2].toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        if (bundle != null) {
            this.f756z0.clear();
            this.f756z0.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f753A0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f754B0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f755C0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) i1();
        if (multiSelectListPreference.E0() == null || multiSelectListPreference.F0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f756z0.clear();
        this.f756z0.addAll(multiSelectListPreference.G0());
        this.f753A0 = false;
        this.f754B0 = multiSelectListPreference.E0();
        this.f755C0 = multiSelectListPreference.F0();
    }

    @Override // androidx.preference.b
    public final void m1(boolean z4) {
        if (z4 && this.f753A0) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) i1();
            if (multiSelectListPreference.e(this.f756z0)) {
                multiSelectListPreference.H0(this.f756z0);
            }
        }
        this.f753A0 = false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    @Override // androidx.preference.b
    protected void n1(e.a aVar) {
        int length = this.f755C0.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.f756z0.contains(this.f755C0[i2].toString());
        }
        aVar.g(this.f754B0, zArr, new a());
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public final void q0(Bundle bundle) {
        super.q0(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f756z0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f753A0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f754B0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f755C0);
    }
}
