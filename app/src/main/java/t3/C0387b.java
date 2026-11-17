package t3;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import miuix.appcompat.internal.app.widget.i;
import miuix.appcompat.internal.view.menu.MenuBuilder;

/* renamed from: t3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0387b extends ActionMode implements MenuBuilder.Callback, miuix.view.a {

    /* renamed from: i, reason: collision with root package name */
    protected Context f7906i;

    /* renamed from: j, reason: collision with root package name */
    protected WeakReference<i> f7907j;

    /* renamed from: k, reason: collision with root package name */
    private ActionMode.Callback f7908k;

    /* renamed from: l, reason: collision with root package name */
    private MenuBuilder f7909l;

    /* renamed from: m, reason: collision with root package name */
    private a f7910m;

    /* renamed from: n, reason: collision with root package name */
    boolean f7911n = false;

    /* renamed from: t3.b$a */
    public interface a {
        void a();
    }

    public C0387b(Context context, ActionMode.Callback callback) {
        this.f7906i = context;
        this.f7908k = callback;
        MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
        this.f7909l = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
    }

    @Override // miuix.view.a
    public final void a(boolean z4) {
    }

    @Override // miuix.view.a
    public final void f(boolean z4, float f4) {
    }

    @Override // android.view.ActionMode
    public void finish() {
        if (this.f7911n) {
            return;
        }
        this.f7911n = true;
        this.f7907j.get().closeMode();
        a aVar = this.f7910m;
        if (aVar != null) {
            aVar.a();
        }
        ActionMode.Callback callback = this.f7908k;
        if (callback != null) {
            callback.onDestroyActionMode(this);
            this.f7908k = null;
        }
    }

    @Override // miuix.view.a
    public final void g(boolean z4) {
        ActionMode.Callback callback;
        if (z4 || (callback = this.f7908k) == null) {
            return;
        }
        callback.onDestroyActionMode(this);
        this.f7908k = null;
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        throw new UnsupportedOperationException("getCustomView not supported");
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return this.f7909l;
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return new MenuInflater(this.f7906i);
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        throw new UnsupportedOperationException("getSubtitle not supported");
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        throw new UnsupportedOperationException("getTitle not supported");
    }

    public boolean i() {
        this.f7909l.stopDispatchingItemsChanged();
        try {
            return this.f7908k.onCreateActionMode(this, this.f7909l);
        } finally {
            this.f7909l.startDispatchingItemsChanged();
        }
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f7909l.stopDispatchingItemsChanged();
        try {
            this.f7908k.onPrepareActionMode(this, this.f7909l);
        } finally {
            this.f7909l.startDispatchingItemsChanged();
        }
    }

    public final void j(a aVar) {
        this.f7910m = aVar;
    }

    public final void k(i iVar) {
        iVar.addAnimationListener(this);
        this.f7907j = new WeakReference<>(iVar);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        ActionMode.Callback callback = this.f7908k;
        return callback != null && callback.onActionItemClicked(this, menuItem);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        if (this.f7908k == null) {
            return;
        }
        invalidate();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        throw new UnsupportedOperationException("setCustomView not supported");
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        throw new UnsupportedOperationException("setSubTitle not supported");
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        throw new UnsupportedOperationException("setTitle not supported");
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        throw new UnsupportedOperationException("setSubTitle not supported");
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        throw new UnsupportedOperationException("setTitle not supported");
    }
}
