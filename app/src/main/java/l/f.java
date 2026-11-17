package l;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;
import l.b;

/* loaded from: classes.dex */
public final class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f6466a;

    /* renamed from: b, reason: collision with root package name */
    final b f6467b;

    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f6468a;

        /* renamed from: b, reason: collision with root package name */
        final Context f6469b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<f> f6470c = new ArrayList<>();
        final q.g<Menu, Menu> d = new q.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f6469b = context;
            this.f6468a = callback;
        }

        private Menu f(Menu menu) {
            Menu orDefault = this.d.getOrDefault(menu, null);
            if (orDefault != null) {
                return orDefault;
            }
            n nVar = new n(this.f6469b, (A.a) menu);
            this.d.put(menu, nVar);
            return nVar;
        }

        @Override // l.b.a
        public final boolean a(b bVar, Menu menu) {
            return this.f6468a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // l.b.a
        public final boolean b(b bVar, MenuItem menuItem) {
            return this.f6468a.onActionItemClicked(e(bVar), new androidx.appcompat.view.menu.i(this.f6469b, (A.b) menuItem));
        }

        @Override // l.b.a
        public final void c(b bVar) {
            this.f6468a.onDestroyActionMode(e(bVar));
        }

        @Override // l.b.a
        public final boolean d(b bVar, Menu menu) {
            return this.f6468a.onPrepareActionMode(e(bVar), f(menu));
        }

        public final ActionMode e(b bVar) {
            int size = this.f6470c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.f6470c.get(i2);
                if (fVar != null && fVar.f6467b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f6469b, bVar);
            this.f6470c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f6466a = context;
        this.f6467b = bVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f6467b.c();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f6467b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new n(this.f6466a, (A.a) this.f6467b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f6467b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f6467b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f6467b.h();
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f6467b.i();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f6467b.j();
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f6467b.k();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f6467b.l();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f6467b.m(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f6467b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f6467b.p(obj);
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f6467b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z4) {
        this.f6467b.s(z4);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i2) {
        this.f6467b.n(i2);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i2) {
        this.f6467b.q(i2);
    }
}
