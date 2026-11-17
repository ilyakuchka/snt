package com.android.mmt.ui;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import java.util.Objects;

/* renamed from: com.android.mmt.ui.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnTouchListenerC0235c0 implements View.OnTouchListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ P f5553i;

    ViewOnTouchListenerC0235c0(P p) {
        this.f5553i = p;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f5553i.k1();
        Objects.requireNonNull(this.f5553i);
        if (this.f5553i.f5252f0.x()) {
            Objects.requireNonNull(this.f5553i);
        }
        if (!TextUtils.isEmpty(this.f5553i.f5235N.getText())) {
            ViewParent parent = view.getParent();
            while (!(parent instanceof ScrollView)) {
                parent = parent.getParent();
            }
            parent.requestDisallowInterceptTouchEvent(true);
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }
}
