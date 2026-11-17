package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class SizeAwareLinearLayout extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private a f5432i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5433j;

    interface a {
        void l();

        void p(SizeAwareLinearLayout sizeAwareLinearLayout, int i2, int i4);
    }

    public SizeAwareLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5432i = null;
        this.f5433j = false;
    }

    public final void a(a aVar) {
        this.f5432i = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        a aVar;
        super.onLayout(z4, i2, i4, i5, i6);
        if (this.f5433j || (aVar = this.f5432i) == null) {
            return;
        }
        this.f5433j = true;
        aVar.l();
        this.f5433j = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i4) {
        a aVar;
        if (!this.f5433j && (aVar = this.f5432i) != null) {
            this.f5433j = true;
            aVar.p(this, i2, i4);
            this.f5433j = false;
        }
        super.onMeasure(i2, i4);
    }
}
