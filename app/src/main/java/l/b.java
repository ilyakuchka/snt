package l;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: i, reason: collision with root package name */
    private Object f6455i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6456j;

    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, MenuItem menuItem);

        void c(b bVar);

        boolean d(b bVar, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public final Object h() {
        return this.f6455i;
    }

    public abstract CharSequence i();

    public final boolean j() {
        return this.f6456j;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i2);

    public abstract void o(CharSequence charSequence);

    public final void p(Object obj) {
        this.f6455i = obj;
    }

    public abstract void q(int i2);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z4) {
        this.f6456j = z4;
    }
}
