package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ChildClickableFrameLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private boolean f4695i;

    public ChildClickableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4695i = true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f4695i;
    }
}
