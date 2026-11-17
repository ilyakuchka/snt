package androidx.core.view;

import android.view.View;
import androidx.core.view.o;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class s extends o.c<Boolean> {
    s() {
        super(R.id.tag_accessibility_heading, Boolean.class, 0, 28);
    }

    @Override // androidx.core.view.o.c
    final Boolean b(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    @Override // androidx.core.view.o.c
    final void c(View view, Boolean bool) {
        view.setAccessibilityHeading(bool.booleanValue());
    }

    @Override // androidx.core.view.o.c
    final boolean f(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
