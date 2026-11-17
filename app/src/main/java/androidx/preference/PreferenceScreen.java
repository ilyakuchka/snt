package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.c;
import androidx.preference.g;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: e0, reason: collision with root package name */
    private boolean f3796e0;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, x.e.a(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle), 0);
        this.f3796e0 = true;
    }

    public final boolean G0() {
        return this.f3796e0;
    }

    @Override // androidx.preference.Preference
    protected final void O() {
        g.b bVarG;
        if (n() != null || l() != null || A0() == 0 || (bVarG = x().g()) == null) {
            return;
        }
        c cVar = (c) bVarG;
        if (cVar.x() instanceof c.f) {
            ((c.f) cVar.x()).a();
        }
    }
}
