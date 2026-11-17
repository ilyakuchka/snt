package com.android.mmt.ui;

import P0.C0162h;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import t0.C0385a;

/* renamed from: com.android.mmt.ui.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0254m extends K {
    static {
        Uri uri = C0385a.b.f7896b;
    }

    public C0254m(Context context) {
        super(context, C0385a.b.f7897c);
        new P2.a((Activity) this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void x(RecyclerView.x xVar, int i2) {
        C0162h c0162h = (C0162h) xVar;
        super.O(c0162h, i2);
        c0162h.B().O();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final RecyclerView.x y(ViewGroup viewGroup, int i2) {
        C0162h c0162hP = super.P(viewGroup, i2);
        Objects.requireNonNull(c0162hP.B());
        return c0162hP;
    }
}
