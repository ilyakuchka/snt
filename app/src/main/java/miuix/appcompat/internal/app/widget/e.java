package miuix.appcompat.internal.app.widget;

import android.view.View;
import t3.C0387b;

/* loaded from: classes.dex */
final class e implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ d f6977i;

    e(d dVar) {
        this.f6977i = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0387b c0387b = this.f6977i.f6949a;
        if (c0387b != null) {
            c0387b.finish();
        }
    }
}
