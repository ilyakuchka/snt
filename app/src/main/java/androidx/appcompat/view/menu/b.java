package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
abstract class b {

    /* renamed from: a, reason: collision with root package name */
    final Context f2491a;

    /* renamed from: b, reason: collision with root package name */
    private q.g<A.b, MenuItem> f2492b;

    /* renamed from: c, reason: collision with root package name */
    private q.g<A.c, SubMenu> f2493c;

    b(Context context) {
        this.f2491a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof A.b)) {
            return menuItem;
        }
        A.b bVar = (A.b) menuItem;
        if (this.f2492b == null) {
            this.f2492b = new q.g<>();
        }
        MenuItem orDefault = this.f2492b.getOrDefault(menuItem, null);
        if (orDefault != null) {
            return orDefault;
        }
        i iVar = new i(this.f2491a, bVar);
        this.f2492b.put(bVar, iVar);
        return iVar;
    }

    final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof A.c)) {
            return subMenu;
        }
        A.c cVar = (A.c) subMenu;
        if (this.f2493c == null) {
            this.f2493c = new q.g<>();
        }
        SubMenu orDefault = this.f2493c.getOrDefault(cVar, null);
        if (orDefault != null) {
            return orDefault;
        }
        q qVar = new q(this.f2491a, cVar);
        this.f2493c.put(cVar, qVar);
        return qVar;
    }

    final void e() {
        q.g<A.b, MenuItem> gVar = this.f2492b;
        if (gVar != null) {
            gVar.clear();
        }
        q.g<A.c, SubMenu> gVar2 = this.f2493c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    final void f(int i2) {
        if (this.f2492b == null) {
            return;
        }
        int i4 = 0;
        while (i4 < this.f2492b.size()) {
            if (this.f2492b.h(i4).getGroupId() == i2) {
                this.f2492b.j(i4);
                i4--;
            }
            i4++;
        }
    }

    final void g(int i2) {
        if (this.f2492b == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f2492b.size(); i4++) {
            if (this.f2492b.h(i4).getItemId() == i2) {
                this.f2492b.j(i4);
                return;
            }
        }
    }
}
