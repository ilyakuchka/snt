package miuix.appcompat.internal.app.widget;

import F.b;
import android.view.View;
import com.android.mmt.R;
import miuix.appcompat.internal.app.widget.ScrollingTabContainerView;

/* loaded from: classes.dex */
final class m extends androidx.core.view.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrollingTabContainerView.TabView f7001a;

    m(ScrollingTabContainerView.TabView tabView) {
        this.f7001a = tabView;
    }

    @Override // androidx.core.view.a
    public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        bVar.V(view.isSelected());
        if (view.isSelected()) {
            bVar.F(false);
            bVar.y(b.a.d);
        } else {
            bVar.F(true);
            bVar.X(this.f7001a.getContext().getResources().getString(R.string.accessibility_tab_statedesc_unselect));
        }
    }
}
