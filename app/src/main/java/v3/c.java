package v3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuPresenter;

/* loaded from: classes.dex */
public final class c implements PopupWindow.OnDismissListener {

    /* renamed from: i, reason: collision with root package name */
    private MenuBuilder f7964i;

    /* renamed from: j, reason: collision with root package name */
    private MenuPresenter.Callback f7965j;

    /* renamed from: k, reason: collision with root package name */
    private d f7966k;

    public c(MenuBuilder menuBuilder) {
        this.f7964i = menuBuilder;
    }

    public final void a() {
        d dVar = this.f7966k;
        if (dVar != null) {
            dVar.dismiss();
            this.f7966k = null;
        }
    }

    public final void b(MenuPresenter.Callback callback) {
        this.f7965j = callback;
    }

    public final void c(View view, float f4, float f5) {
        d dVar = new d(this.f7964i.getContext(), this.f7964i, this);
        this.f7966k = dVar;
        dVar.p(view, (ViewGroup) view.getParent(), f4, f5);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        MenuPresenter.Callback callback = this.f7965j;
        if (callback != null) {
            callback.onCloseMenu(this.f7964i, true);
        }
        this.f7964i.clearAll();
    }
}
