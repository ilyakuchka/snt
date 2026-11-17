package com.android.mmt.ui;

import F.b;
import android.os.Bundle;
import android.view.View;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class D0 extends androidx.core.view.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4752a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScreenView f4753b;

    D0(ScreenView screenView, int i2) {
        this.f4753b = screenView;
        this.f4752a = i2;
    }

    @Override // androidx.core.view.a
    public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        bVar.S(this.f4753b.getResources().getString(R.string.page_indicator));
        bVar.b(new b.a(4096));
        bVar.b(new b.a(8192));
        bVar.b(b.a.f119i);
        bVar.R(b.d.a(this.f4753b.i(), this.f4753b.f5369t));
    }

    @Override // androidx.core.view.a
    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        if (i2 == 4096) {
            int i4 = this.f4752a;
            if (i4 > 0) {
                this.f4753b.u(i4 - 1, 0, false);
                this.f4753b.f5363m.getChildAt(this.f4752a).setSelected(false);
                this.f4753b.f5363m.getChildAt(this.f4752a - 1).setSelected(true);
            }
            return true;
        }
        if (i2 != 8192) {
            return false;
        }
        if (this.f4752a < this.f4753b.i() - 1) {
            this.f4753b.u(this.f4752a + 1, 0, false);
            this.f4753b.f5363m.getChildAt(this.f4752a).setSelected(false);
            this.f4753b.f5363m.getChildAt(this.f4752a + 1).setSelected(true);
        }
        return true;
    }
}
