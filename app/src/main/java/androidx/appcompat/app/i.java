package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import q.C0366b;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: i, reason: collision with root package name */
    private static final C0366b<WeakReference<i>> f2325i = new C0366b<>(0);

    /* renamed from: j, reason: collision with root package name */
    private static final Object f2326j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f2327k = 0;

    i() {
    }

    static void c(i iVar) {
        synchronized (f2326j) {
            u(iVar);
            f2325i.add(new WeakReference<>(iVar));
        }
    }

    static void t(i iVar) {
        synchronized (f2326j) {
            u(iVar);
        }
    }

    private static void u(i iVar) {
        synchronized (f2326j) {
            Iterator<WeakReference<i>> it = f2325i.iterator();
            while (it.hasNext()) {
                i iVar2 = it.next().get();
                if (iVar2 == iVar || iVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void A(CharSequence charSequence);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public Context e(Context context) {
        return context;
    }

    public abstract <T extends View> T f(int i2);

    public int g() {
        return -100;
    }

    public abstract MenuInflater h();

    public abstract a i();

    public abstract void j();

    public abstract void k();

    public abstract void l(Configuration configuration);

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract boolean v(int i2);

    public abstract void w(int i2);

    public abstract void x(View view);

    public abstract void y(View view, ViewGroup.LayoutParams layoutParams);

    public void z(int i2) {
    }
}
