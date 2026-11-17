package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.o;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class q extends o.c<CharSequence> {
    q(Class cls) {
        super(R.id.tag_accessibility_pane_title, cls, 8, 28);
    }

    @Override // androidx.core.view.o.c
    final CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    @Override // androidx.core.view.o.c
    final void c(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    @Override // androidx.core.view.o.c
    final boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
