package v3;

import android.view.View;

/* loaded from: classes.dex */
final class e implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ d f7977i;

    e(d dVar) {
        this.f7977i = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7977i.g.performItemAction(this.f7977i.f7972h, 0);
        this.f7977i.dismiss();
    }
}
