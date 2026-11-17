package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Trace;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import androidx.savedstate.SavedStateRegistry;
import e.C0296a;
import e.InterfaceC0297b;
import java.util.concurrent.atomic.AtomicInteger;
import t.C0384b;
import v.ActivityC0395b;

/* loaded from: classes.dex */
public class ComponentActivity extends ActivityC0395b implements x, androidx.savedstate.b, androidx.activity.c, androidx.activity.result.d {

    /* renamed from: j, reason: collision with root package name */
    final C0296a f2216j = new C0296a();

    /* renamed from: k, reason: collision with root package name */
    private final l f2217k;

    /* renamed from: l, reason: collision with root package name */
    final androidx.savedstate.a f2218l;

    /* renamed from: m, reason: collision with root package name */
    private w f2219m;

    /* renamed from: n, reason: collision with root package name */
    private final OnBackPressedDispatcher f2220n;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.activity.result.c f2221o;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e2;
                }
            }
        }
    }

    final class b extends androidx.activity.result.c {
        b() {
        }
    }

    final class c implements SavedStateRegistry.b {
        c() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        @SuppressLint({"SyntheticAccessor"})
        public final Bundle a() {
            Bundle bundle = new Bundle();
            ComponentActivity.this.f2221o.d(bundle);
            return bundle;
        }
    }

    final class d implements InterfaceC0297b {
        d() {
        }

        @Override // e.InterfaceC0297b
        @SuppressLint({"SyntheticAccessor"})
        public final void a() {
            Bundle bundleA = ComponentActivity.this.e().a("android:support:activity-result");
            if (bundleA != null) {
                ComponentActivity.this.f2221o.c(bundleA);
            }
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        w f2228a;

        e() {
        }
    }

    public ComponentActivity() {
        l lVar = new l(this);
        this.f2217k = lVar;
        this.f2218l = androidx.savedstate.a.a(this);
        this.f2220n = new OnBackPressedDispatcher(new a());
        new AtomicInteger();
        this.f2221o = new b();
        lVar.a(new i() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.i
            public final void g(k kVar, g.b bVar) {
                if (bVar == g.b.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        lVar.a(new i() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.i
            public final void g(k kVar, g.b bVar) {
                if (bVar == g.b.ON_DESTROY) {
                    ComponentActivity.this.f2216j.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.q().a();
                }
            }
        });
        lVar.a(new i() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.i
            public final void g(k kVar, g.b bVar) {
                ComponentActivity.this.r();
                ComponentActivity.this.a().c(this);
            }
        });
        e().d("android:support:activity-result", new c());
        o(new d());
    }

    private void s() {
        C0384b.u(getWindow().getDecorView(), this);
        C0384b.v(getWindow().getDecorView(), this);
        C0384b.w(getWindow().getDecorView(), this);
    }

    @Override // v.ActivityC0395b, androidx.lifecycle.k
    public final g a() {
        return this.f2217k;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        s();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher c() {
        return this.f2220n;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry e() {
        return this.f2218l.b();
    }

    @Override // androidx.activity.result.d
    public final androidx.activity.result.c f() {
        return this.f2221o;
    }

    public final void o(InterfaceC0297b interfaceC0297b) {
        this.f2216j.a(interfaceC0297b);
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onActivityResult(int i2, int i4, Intent intent) {
        if (this.f2221o.b(i2, i4, intent)) {
            return;
        }
        super.onActivityResult(i2, i4, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f2220n.b();
    }

    @Override // v.ActivityC0395b, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f2218l.c(bundle);
        this.f2216j.c(this);
        super.onCreate(bundle);
        t.b(this);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.f2221o.b(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        w wVar = this.f2219m;
        if (wVar == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            wVar = eVar.f2228a;
        }
        if (wVar == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f2228a = wVar;
        return eVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v.ActivityC0395b, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        l lVar = this.f2217k;
        if (lVar instanceof l) {
            lVar.l();
        }
        super.onSaveInstanceState(bundle);
        this.f2218l.d(bundle);
    }

    @Override // androidx.lifecycle.x
    public final w q() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        r();
        return this.f2219m;
    }

    final void r() {
        if (this.f2219m == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.f2219m = eVar.f2228a;
            }
            if (this.f2219m == null) {
                this.f2219m = new w();
            }
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (Y.a.a()) {
                Trace.beginSection("reportFullyDrawn() for " + getComponentName());
            }
            super.reportFullyDrawn();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        s();
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i4, int i5, int i6) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i4, i5, i6);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i4, int i5, int i6, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i4, i5, i6, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        s();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        s();
        super.setContentView(view, layoutParams);
    }
}
