package com.android.mmt.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.Objects;

/* renamed from: com.android.mmt.util.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0279k extends ListView {

    /* renamed from: i, reason: collision with root package name */
    private int f6031i;

    /* renamed from: com.android.mmt.util.k$a */
    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Objects.requireNonNull(C0279k.this);
                Objects.requireNonNull(C0279k.this);
                Objects.requireNonNull(C0279k.this);
                int unused = C0279k.this.f6031i;
                Objects.requireNonNull(C0279k.this);
                throw null;
            }
            if (i2 != 2) {
                return;
            }
            Objects.requireNonNull(C0279k.this);
            Objects.requireNonNull(C0279k.this);
            Objects.requireNonNull(C0279k.this);
            int unused2 = C0279k.this.f6031i;
            Objects.requireNonNull(C0279k.this);
            throw null;
        }
    }

    /* renamed from: com.android.mmt.util.k$b */
    public interface b {
        void a();
    }

    /* renamed from: com.android.mmt.util.k$c */
    public interface c {
    }

    static {
        ViewConfiguration.getDoubleTapTimeout();
    }

    public C0279k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6031i = -1;
        new a();
    }

    public final void b() {
        int count = getAdapter().getCount() - getFooterViewsCount();
        if (count > 0) {
            setSelectionFromTop(count - 1, -100000);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }
}
