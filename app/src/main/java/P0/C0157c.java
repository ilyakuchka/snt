package P0;

import android.content.Context;
import android.view.MenuItem;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.List;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuDialogHelper;

/* renamed from: P0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0157c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f913a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Runnable> f914b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private b f915c;

    /* renamed from: P0.c$a */
    final class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ((Runnable) ((ArrayList) C0157c.this.f914b).get(menuItem.getItemId())).run();
            return true;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
        public final void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: P0.c$b */
    private static class b extends MenuBuilder {
        public b(Context context) {
            super(context);
        }

        public final MenuBuilder a() {
            return super.setHeaderTitleInt(R.string.select_link_title);
        }

        public final MenuBuilder b(CharSequence charSequence) {
            return super.setHeaderTitleInt(charSequence);
        }
    }

    public C0157c(Context context) {
        this.f913a = context;
        b bVar = new b(context);
        this.f915c = bVar;
        bVar.setCallback(new a());
    }

    public final void b(int i2, Runnable runnable) {
        c(this.f913a.getString(i2), runnable);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<java.lang.Runnable>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<java.lang.Runnable>] */
    public final void c(String str, Runnable runnable) {
        this.f915c.add(0, this.f914b.size(), 0, str);
        this.f914b.add(runnable);
    }

    public final void d() {
        this.f915c.a();
    }

    public final void e(String str) {
        this.f915c.b(str);
    }

    public final void f() {
        b bVar = this.f915c;
        if (bVar.getVisibleItems().size() > 0) {
            new MenuDialogHelper(bVar).show(null);
        }
    }
}
