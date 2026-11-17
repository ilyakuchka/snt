package O;

import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;

@Deprecated
/* loaded from: classes.dex */
public final class e extends v {

    /* renamed from: c, reason: collision with root package name */
    final RecyclerView f758c;
    final v.a d;

    /* renamed from: e, reason: collision with root package name */
    final androidx.core.view.a f759e;

    final class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
            Preference preferenceI;
            e.this.d.onInitializeAccessibilityNodeInfo(view, bVar);
            int iL = e.this.f758c.L(view);
            RecyclerView.e eVarI = e.this.f758c.I();
            if ((eVarI instanceof androidx.preference.d) && (preferenceI = ((androidx.preference.d) eVarI).I(iL)) != null) {
                preferenceI.R();
            }
        }

        @Override // androidx.core.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return e.this.d.performAccessibilityAction(view, i2, bundle);
        }
    }

    public e(RecyclerView recyclerView) {
        super(recyclerView);
        this.d = (v.a) super.a();
        this.f759e = new a();
        this.f758c = recyclerView;
    }

    @Override // androidx.recyclerview.widget.v
    public final androidx.core.view.a a() {
        return this.f759e;
    }
}
