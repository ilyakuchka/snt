package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.o;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class r extends o.c<CharSequence> {
    r(Class cls) {
        super(R.id.tag_state_description, cls, 64, 30);
    }

    @Override // androidx.core.view.o.c
    final CharSequence b(View view) {
        return view.getStateDescription();
    }

    @Override // androidx.core.view.o.c
    final void c(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }

    @Override // androidx.core.view.o.c
    final boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
