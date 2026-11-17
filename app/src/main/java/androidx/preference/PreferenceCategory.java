package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, x.e.a(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle), 0);
    }

    @Override // androidx.preference.Preference
    public final boolean E() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void N(h hVar) {
        super.N(hVar);
        hVar.f4055i.setAccessibilityHeading(true);
    }

    @Override // androidx.preference.Preference
    @Deprecated
    public final void R() {
    }

    @Override // androidx.preference.Preference
    public final boolean s0() {
        return !super.E();
    }
}
