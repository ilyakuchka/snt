package com.android.mmt.util;

import android.view.View;
import com.android.mmt.ui.O0;

/* renamed from: com.android.mmt.util.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0281m implements O0.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EditableListViewV2 f6034a;

    C0281m(EditableListViewV2 editableListViewV2) {
        this.f6034a = editableListViewV2;
    }

    @Override // com.android.mmt.ui.O0.e
    public final boolean a(View view, int i2) {
        if (this.f6034a.S0(i2) || this.f6034a.R0(i2)) {
            return true;
        }
        if (!this.f6034a.f5855S0.r(EditableListViewV2.a1(this.f6034a, i2))) {
            return true;
        }
        this.f6034a.f5867e1 = i2;
        this.f6034a.f5868f1 = view;
        if (this.f6034a.f5869g1) {
            return false;
        }
        this.f6034a.D1(i2);
        return true;
    }
}
