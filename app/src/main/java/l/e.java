package l;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import l.b;

/* loaded from: classes.dex */
public final class e extends b implements f.a {

    /* renamed from: k, reason: collision with root package name */
    private Context f6461k;

    /* renamed from: l, reason: collision with root package name */
    private ActionBarContextView f6462l;

    /* renamed from: m, reason: collision with root package name */
    private b.a f6463m;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<View> f6464n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6465o;
    private androidx.appcompat.view.menu.f p;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar) {
        this.f6461k = context;
        this.f6462l = actionBarContextView;
        this.f6463m = aVar;
        androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(actionBarContextView.getContext());
        fVar.F();
        this.p = fVar;
        fVar.E(this);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        return this.f6463m.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f fVar) {
        k();
        this.f6462l.r();
    }

    @Override // l.b
    public final void c() {
        if (this.f6465o) {
            return;
        }
        this.f6465o = true;
        this.f6462l.sendAccessibilityEvent(32);
        this.f6463m.c(this);
    }

    @Override // l.b
    public final View d() {
        WeakReference<View> weakReference = this.f6464n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // l.b
    public final Menu e() {
        return this.p;
    }

    @Override // l.b
    public final MenuInflater f() {
        return new g(this.f6462l.getContext());
    }

    @Override // l.b
    public final CharSequence g() {
        return this.f6462l.g();
    }

    @Override // l.b
    public final CharSequence i() {
        return this.f6462l.h();
    }

    @Override // l.b
    public final void k() {
        this.f6463m.d(this, this.p);
    }

    @Override // l.b
    public final boolean l() {
        return this.f6462l.k();
    }

    @Override // l.b
    public final void m(View view) {
        this.f6462l.m(view);
        this.f6464n = view != null ? new WeakReference<>(view) : null;
    }

    @Override // l.b
    public final void n(int i2) {
        this.f6462l.n(this.f6461k.getString(i2));
    }

    @Override // l.b
    public final void o(CharSequence charSequence) {
        this.f6462l.n(charSequence);
    }

    @Override // l.b
    public final void q(int i2) {
        this.f6462l.o(this.f6461k.getString(i2));
    }

    @Override // l.b
    public final void r(CharSequence charSequence) {
        this.f6462l.o(charSequence);
    }

    @Override // l.b
    public final void s(boolean z4) {
        super.s(z4);
        this.f6462l.p(z4);
    }
}
