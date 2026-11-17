package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class DispatchFrameLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private int f4761i;

    /* renamed from: j, reason: collision with root package name */
    private int f4762j;

    /* renamed from: k, reason: collision with root package name */
    private int f4763k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4764l;

    public DispatchFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        this.f4763k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void a() {
        this.f4764l = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f4764l) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (action == 0) {
            this.f4761i = x2;
            this.f4762j = y2;
        } else if (action == 1) {
            int i2 = this.f4761i - x2;
            int i4 = this.f4762j - y2;
            int i5 = this.f4763k;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
