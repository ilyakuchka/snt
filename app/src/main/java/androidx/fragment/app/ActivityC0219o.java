package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ActivityC0219o extends ComponentActivity {

    /* renamed from: r, reason: collision with root package name */
    boolean f3562r;

    /* renamed from: s, reason: collision with root package name */
    boolean f3563s;
    final r p = r.b(new a());

    /* renamed from: q, reason: collision with root package name */
    final androidx.lifecycle.l f3561q = new androidx.lifecycle.l(this);

    /* renamed from: t, reason: collision with root package name */
    boolean f3564t = true;

    /* renamed from: androidx.fragment.app.o$a */
    class a extends t<ActivityC0219o> implements androidx.lifecycle.x, androidx.activity.c, androidx.activity.result.d, A {
        public a() {
            super(ActivityC0219o.this);
        }

        @Override // androidx.lifecycle.k
        public final androidx.lifecycle.g a() {
            return ActivityC0219o.this.f3561q;
        }

        @Override // androidx.fragment.app.A
        public final void b(Fragment fragment) {
            ActivityC0219o.this.x(fragment);
        }

        @Override // androidx.activity.c
        public final OnBackPressedDispatcher c() {
            return ActivityC0219o.this.c();
        }

        @Override // O.d
        public final View d(int i2) {
            return ActivityC0219o.this.findViewById(i2);
        }

        @Override // androidx.activity.result.d
        public final androidx.activity.result.c f() {
            return ActivityC0219o.this.f();
        }

        @Override // O.d
        public final boolean g() {
            Window window = ActivityC0219o.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.t
        public final ActivityC0219o l() {
            return ActivityC0219o.this;
        }

        @Override // androidx.fragment.app.t
        public final LayoutInflater m() {
            return ActivityC0219o.this.getLayoutInflater().cloneInContext(ActivityC0219o.this);
        }

        @Override // androidx.fragment.app.t
        public final void o() {
            ActivityC0219o.this.y();
        }

        @Override // androidx.lifecycle.x
        public final androidx.lifecycle.w q() {
            return ActivityC0219o.this.q();
        }
    }

    public ActivityC0219o() {
        e().d("android:support:fragments", new C0217m(this));
        o(new C0218n(this));
    }

    private static boolean w(w wVar) {
        g.c cVar = g.c.STARTED;
        boolean zW = false;
        for (Fragment fragment : wVar.Z()) {
            if (fragment != null) {
                t<?> tVar = fragment.f3407B;
                if ((tVar == null ? null : tVar.l()) != null) {
                    zW |= w(fragment.A());
                }
                J j2 = fragment.f3426X;
                if (j2 != null && j2.a().b().d(cVar)) {
                    fragment.f3426X.i();
                    zW = true;
                }
                if (fragment.f3425W.b().d(cVar)) {
                    fragment.f3425W.l();
                    zW = true;
                }
            }
        }
        return zW;
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f3562r);
        printWriter.print(" mResumed=");
        printWriter.print(this.f3563s);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3564t);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.p.t().I(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i4, Intent intent) {
        this.p.u();
        super.onActivityResult(i2, i4, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.p.u();
        super.onConfigurationChanged(configuration);
        this.p.d(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3561q.f(g.b.ON_CREATE);
        this.p.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        return this.p.g(menu, getMenuInflater()) | super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewV = this.p.v(view, str, context, attributeSet);
        return viewV == null ? super.onCreateView(view, str, context, attributeSet) : viewV;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.p.h();
        this.f3561q.f(g.b.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.p.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.p.k(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.p.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4) {
        this.p.j(z4);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.p.u();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.p.l(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f3563s = false;
        this.p.m();
        this.f3561q.f(g.b.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z4) {
        this.p.n(z4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f3561q.f(g.b.ON_RESUME);
        this.p.p();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            return super.onPreparePanel(i2, view, menu);
        }
        return this.p.o(menu) | super.onPreparePanel(0, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.p.u();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.p.u();
        super.onResume();
        this.f3563s = true;
        this.p.s();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.p.u();
        super.onStart();
        this.f3564t = false;
        if (!this.f3562r) {
            this.f3562r = true;
            this.p.c();
        }
        this.p.s();
        this.f3561q.f(g.b.ON_START);
        this.p.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.p.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f3564t = true;
        while (w(u())) {
        }
        this.p.r();
        this.f3561q.f(g.b.ON_STOP);
    }

    public final w u() {
        return this.p.t();
    }

    final void v() {
        while (w(u())) {
        }
    }

    @Deprecated
    public void x(Fragment fragment) {
    }

    @Deprecated
    public void y() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewV = this.p.v(null, str, context, attributeSet);
        return viewV == null ? super.onCreateView(str, context, attributeSet) : viewV;
    }
}
