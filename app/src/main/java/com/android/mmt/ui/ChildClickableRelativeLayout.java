package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class ChildClickableRelativeLayout extends RelativeLayout {

    /* renamed from: i, reason: collision with root package name */
    private boolean f4696i;

    public ChildClickableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4696i = true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f4696i;
    }
}
