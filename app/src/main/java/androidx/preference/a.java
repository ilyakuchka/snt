package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class a extends Preference {

    /* renamed from: W, reason: collision with root package name */
    private long f3828W;

    a(Context context, List<Preference> list, long j2) {
        super(context);
        i0(R.layout.expand_button);
        f0();
        q0(R.string.expand_button_title);
        m0(999);
        ArrayList arrayList = new ArrayList();
        CharSequence string = null;
        for (Preference preference : list) {
            CharSequence charSequenceA = preference.A();
            boolean z4 = preference instanceof PreferenceGroup;
            if (z4 && !TextUtils.isEmpty(charSequenceA)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.s())) {
                if (z4) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequenceA)) {
                string = string == null ? charSequenceA : i().getString(R.string.summary_collapsed_preference_list, string, charSequenceA);
            }
        }
        o0(string);
        this.f3828W = j2 + 1000000;
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) {
        super.N(hVar);
        hVar.E(false);
    }

    @Override // androidx.preference.Preference
    final long m() {
        return this.f3828W;
    }
}
