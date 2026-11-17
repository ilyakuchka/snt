package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
final class V implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final m.a f2947i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ W f2948j;

    V(W w2) {
        this.f2948j = w2;
        this.f2947i = new m.a(w2.f2953a.getContext(), w2.f2958h);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        W w2 = this.f2948j;
        Window.Callback callback = w2.f2961k;
        if (callback == null || !w2.f2962l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f2947i);
    }
}
