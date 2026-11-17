package com.android.mmt.ui;

import android.view.ActionMode;

/* renamed from: com.android.mmt.ui.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0263t implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ActionMode f5759i;

    RunnableC0263t(ActionMode actionMode) {
        this.f5759i = actionMode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5759i.finish();
    }
}
