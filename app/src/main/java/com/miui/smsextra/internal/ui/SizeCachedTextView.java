package com.miui.smsextra.internal.ui;

import android.content.Context;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class SizeCachedTextView extends AppCompatTextView {

    /* renamed from: j, reason: collision with root package name */
    private static Map<WeakReference<Object>, SparseArray<SoftReference<Object>>> f6133j = new ArrayMap();

    /* renamed from: i, reason: collision with root package name */
    private boolean f6134i;

    public SizeCachedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6134i = true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected final void onMeasure(int i2, int i4) {
        if (!this.f6134i) {
            super.onMeasure(i2, i4);
            return;
        }
        super.onMeasure(i2, i4);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        getText();
        getMeasuredWidth();
        getMeasuredHeight();
    }
}
