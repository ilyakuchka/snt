package com.android.mmt.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.mmt.R;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.ui.NewMessagePopupActivity;

/* loaded from: classes.dex */
public final class x0 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private NewMessagePopupActivity.NewMessagePopupFragment.h f5770a;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f5772c;
    private float d;

    /* renamed from: b, reason: collision with root package name */
    private String f5771b = "BUBBLE";

    /* renamed from: e, reason: collision with root package name */
    private C0247i0.d f5773e = new a();

    final class a implements C0247i0.d {
        a() {
        }

        @Override // com.android.mmt.ui.C0247i0.d
        public final C0243g0 a(int i2) {
            return x0.this.c(i2);
        }

        @Override // com.android.mmt.ui.C0247i0.d
        public final C0243g0 b(int i2) {
            return x0.this.c(i2 - 1);
        }

        @Override // com.android.mmt.ui.C0247i0.d
        public final C0243g0 c(int i2) {
            return x0.this.c(i2 + 1);
        }
    }

    x0(Activity activity) {
        this.f5772c = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0243g0 c(int i2) {
        if (i2 < 0 || i2 >= this.f5770a.f5192c.size()) {
            return null;
        }
        return this.f5770a.f5192c.get(i2);
    }

    private boolean d() {
        NewMessagePopupActivity.NewMessagePopupFragment.h hVar = this.f5770a;
        return hVar == null || hVar.f5192c == null;
    }

    public final void e(float f4) {
        this.d = f4;
    }

    public final void f(NewMessagePopupActivity.NewMessagePopupFragment.h hVar) {
        this.f5770a = hVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (d()) {
            return 0;
        }
        return this.f5770a.f5192c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i2) {
        if (d()) {
            return -1;
        }
        return C0247i0.R(this.f5771b, true, 0, this.f5773e, i2);
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (d()) {
            return null;
        }
        MessageListItem messageListItem = (MessageListItem) view;
        C0243g0 c0243g0 = this.f5770a.f5192c.get(i2);
        if (messageListItem == null) {
            messageListItem = (MessageListItem) this.f5772c.inflate(R.layout.message_list_item_bubble, viewGroup, false);
            messageListItem.q(c0243g0);
        }
        messageListItem.L(c0243g0, false, false, false, null, null);
        float f4 = this.d;
        if (f4 != 0.0f) {
            messageListItem.M(f4);
        }
        return messageListItem;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 13;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        for (int i2 = 0; i2 < getCount(); i2++) {
            C0243g0 c0243g0C = c(i2);
            if (c0243g0C != null) {
                c0243g0C.c0();
            }
        }
        super.notifyDataSetChanged();
    }
}
