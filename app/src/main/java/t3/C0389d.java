package t3;

import android.content.Context;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.View;
import android.widget.EditText;
import java.lang.ref.WeakReference;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import miuix.appcompat.internal.app.widget.i;

/* renamed from: t3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0389d extends C0387b implements miuix.view.e {
    public C0389d(Context context, ActionMode.Callback callback) {
        super(context, callback);
    }

    @Override // miuix.view.e
    public final EditText b() {
        return ((SearchActionModeView) this.f7907j.get()).getSearchInput();
    }

    @Override // miuix.view.e
    public final void c(View view) {
        ((SearchActionModeView) this.f7907j.get()).setAnimateView(view);
    }

    @Override // miuix.view.e
    public final void e(View view) {
        ((SearchActionModeView) this.f7907j.get()).setResultView(view);
    }

    @Override // miuix.view.e
    public final void h(View view) {
        ((SearchActionModeView) this.f7907j.get()).setAnchorView(view);
    }

    public final void l(Rect rect) {
        WeakReference<i> weakReference = this.f7907j;
        SearchActionModeView searchActionModeView = weakReference != null ? (SearchActionModeView) weakReference.get() : null;
        if (searchActionModeView != null) {
            searchActionModeView.rePaddingAndRelayout(rect);
        }
    }
}
