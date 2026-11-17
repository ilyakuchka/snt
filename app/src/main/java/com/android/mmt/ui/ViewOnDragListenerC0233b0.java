package com.android.mmt.ui;

import android.content.ClipData;
import android.net.Uri;
import android.view.DragEvent;
import android.view.View;
import v.C0394a;

/* renamed from: com.android.mmt.ui.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnDragListenerC0233b0 implements View.OnDragListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f5550a;

    ViewOnDragListenerC0233b0(P p) {
        this.f5550a = p;
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        if (dragEvent.getAction() == 3) {
            P p = this.f5550a;
            int i2 = C0394a.f7922c;
            if (androidx.core.view.e.a(p, dragEvent) == null) {
                return false;
            }
            ClipData.Item itemAt = dragEvent.getClipData().getItemAt(0);
            if (itemAt != null) {
                Uri uri = itemAt.getUri();
                if (uri == null || "".equals(uri.toString())) {
                    StringBuilder sb = new StringBuilder(((Object) this.f5550a.f5235N.getText()) + "");
                    sb.append(itemAt.getText() != null ? itemAt.getText() : "");
                    this.f5550a.f5235N.setText(sb);
                } else {
                    this.f5550a.f5241U.T(1, uri, false);
                }
            }
        }
        return true;
    }
}
