package androidx.preference;

import androidx.preference.Preference;
import java.util.Objects;

/* loaded from: classes.dex */
final class e implements Preference.e {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ PreferenceGroup f3858i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ d f3859j;

    e(d dVar, PreferenceGroup preferenceGroup) {
        this.f3859j = dVar;
        this.f3858i = preferenceGroup;
    }

    @Override // androidx.preference.Preference.e
    public final boolean k(Preference preference) {
        this.f3858i.E0(Integer.MAX_VALUE);
        this.f3859j.L();
        Objects.requireNonNull(this.f3858i);
        return true;
    }
}
