package v3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.EventLog;
import android.view.ContextMenu;
import android.view.View;
import miuix.appcompat.internal.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public final class b extends MenuBuilder implements ContextMenu {

    /* renamed from: a, reason: collision with root package name */
    c f7963a;

    public b(Context context) {
        super(context);
    }

    public final c a(View view, IBinder iBinder, float f4, float f5) {
        if (view != null) {
            view.createContextMenu(this);
        }
        if (getVisibleItems().size() <= 0) {
            return null;
        }
        EventLog.writeEvent(50001, 1);
        c cVar = new c(this);
        this.f7963a = cVar;
        cVar.c(view, f4, f5);
        return this.f7963a;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuBuilder, android.view.Menu
    public final void close() {
        super.close();
        c cVar = this.f7963a;
        if (cVar != null) {
            cVar.a();
            this.f7963a = null;
        }
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderIcon(Drawable drawable) {
        return (ContextMenu) super.setHeaderIconInt(drawable);
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderTitle(CharSequence charSequence) {
        return (ContextMenu) super.setHeaderTitleInt(charSequence);
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderView(View view) {
        return (ContextMenu) super.setHeaderViewInt(view);
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderIcon(int i2) {
        return (ContextMenu) super.setHeaderIconInt(i2);
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderTitle(int i2) {
        return (ContextMenu) super.setHeaderTitleInt(i2);
    }
}
