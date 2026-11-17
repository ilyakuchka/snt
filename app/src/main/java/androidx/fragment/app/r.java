package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final t<?> f3577a;

    private r(t<?> tVar) {
        this.f3577a = tVar;
    }

    public static r b(t<?> tVar) {
        return new r(tVar);
    }

    public final void a() {
        t<?> tVar = this.f3577a;
        tVar.f3582l.d(tVar, tVar, null);
    }

    public final void c() {
        this.f3577a.f3582l.k();
    }

    public final void d(Configuration configuration) {
        this.f3577a.f3582l.m(configuration);
    }

    public final boolean e(MenuItem menuItem) {
        return this.f3577a.f3582l.n(menuItem);
    }

    public final void f() {
        this.f3577a.f3582l.o();
    }

    public final boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f3577a.f3582l.p(menu, menuInflater);
    }

    public final void h() {
        this.f3577a.f3582l.q();
    }

    public final void i() {
        this.f3577a.f3582l.s();
    }

    public final void j(boolean z4) {
        this.f3577a.f3582l.t(z4);
    }

    public final boolean k(MenuItem menuItem) {
        return this.f3577a.f3582l.v(menuItem);
    }

    public final void l(Menu menu) {
        this.f3577a.f3582l.w(menu);
    }

    public final void m() {
        this.f3577a.f3582l.y();
    }

    public final void n(boolean z4) {
        this.f3577a.f3582l.z(z4);
    }

    public final boolean o(Menu menu) {
        return this.f3577a.f3582l.A(menu);
    }

    public final void p() {
        this.f3577a.f3582l.C();
    }

    public final void q() {
        this.f3577a.f3582l.D();
    }

    public final void r() {
        this.f3577a.f3582l.F();
    }

    public final boolean s() {
        return this.f3577a.f3582l.M(true);
    }

    public final w t() {
        return this.f3577a.f3582l;
    }

    public final void u() {
        this.f3577a.f3582l.q0();
    }

    public final View v(View view, String str, Context context, AttributeSet attributeSet) {
        return ((u) this.f3577a.f3582l.b0()).onCreateView(view, str, context, attributeSet);
    }

    public final void w(Parcelable parcelable) {
        t<?> tVar = this.f3577a;
        if (!(tVar instanceof androidx.lifecycle.x)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        tVar.f3582l.x0(parcelable);
    }

    public final Parcelable x() {
        return this.f3577a.f3582l.y0();
    }
}
