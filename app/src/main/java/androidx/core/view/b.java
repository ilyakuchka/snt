package androidx.core.view;

import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private a f3293a;

    public interface a {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public final void h() {
        this.f3293a = null;
    }

    public void i(a aVar) {
        if (this.f3293a != null) {
            StringBuilder sbD = D2.e.d("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sbD.append(getClass().getSimpleName());
            sbD.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", sbD.toString());
        }
        this.f3293a = aVar;
    }
}
