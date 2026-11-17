package miuix.appcompat.internal.app.widget;

import android.content.Context;
import android.widget.TextView;
import com.android.mmt.R;
import s3.C0381a;

/* loaded from: classes.dex */
public final class o extends ScrollingTabContainerView {
    public o(Context context) {
        super(context);
        l(-2);
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int f() {
        return R.attr.actionBarTabTextSecondaryStyle;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int g() {
        return R.layout.miuix_appcompat_action_bar_tabbar_collapse_secondary;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int h() {
        return -2;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int i() {
        return R.layout.miuix_appcompat_action_bar_tab_secondary;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int j() {
        return getContext().getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_tab_secondary_margin);
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final void p(TextView textView) {
        C0381a.a(textView);
    }
}
