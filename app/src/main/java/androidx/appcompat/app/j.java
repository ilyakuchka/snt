package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.s;
import androidx.appcompat.app.s.d;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.A;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.B;
import androidx.appcompat.widget.C0187h;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.U;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.X;
import androidx.appcompat.widget.Y;
import androidx.core.view.t;
import androidx.core.view.w;
import androidx.lifecycle.g;
import h.InterfaceC0329a;
import i.C0333a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import l.b;
import l.f;
import t.C0384b;
import v.C0394a;
import v.C0396c;
import w.C0405a;

/* loaded from: classes.dex */
final class j extends androidx.appcompat.app.i implements f.a, LayoutInflater.Factory2 {

    /* renamed from: i0, reason: collision with root package name */
    private static final q.g<String, Integer> f2328i0 = new q.g<>();

    /* renamed from: j0, reason: collision with root package name */
    private static final int[] f2329j0 = {R.attr.windowBackground};

    /* renamed from: k0, reason: collision with root package name */
    private static final boolean f2330k0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: l0, reason: collision with root package name */
    private static final boolean f2331l0 = true;

    /* renamed from: A, reason: collision with root package name */
    t f2332A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f2333B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f2334C;

    /* renamed from: D, reason: collision with root package name */
    ViewGroup f2335D;

    /* renamed from: E, reason: collision with root package name */
    private TextView f2336E;

    /* renamed from: F, reason: collision with root package name */
    private View f2337F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f2338G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f2339H;

    /* renamed from: I, reason: collision with root package name */
    boolean f2340I;

    /* renamed from: J, reason: collision with root package name */
    boolean f2341J;

    /* renamed from: K, reason: collision with root package name */
    boolean f2342K;
    boolean L;
    boolean M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f2343N;

    /* renamed from: O, reason: collision with root package name */
    private i[] f2344O;
    private i P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f2345Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f2346R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f2347S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f2348T;

    /* renamed from: U, reason: collision with root package name */
    boolean f2349U;

    /* renamed from: V, reason: collision with root package name */
    private int f2350V;

    /* renamed from: W, reason: collision with root package name */
    private int f2351W;

    /* renamed from: X, reason: collision with root package name */
    private boolean f2352X;

    /* renamed from: Y, reason: collision with root package name */
    private boolean f2353Y;

    /* renamed from: Z, reason: collision with root package name */
    private g f2354Z;

    /* renamed from: a0, reason: collision with root package name */
    private e f2355a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f2356b0;

    /* renamed from: c0, reason: collision with root package name */
    int f2357c0;

    /* renamed from: d0, reason: collision with root package name */
    private final Runnable f2358d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f2359e0;

    /* renamed from: f0, reason: collision with root package name */
    private Rect f2360f0;

    /* renamed from: g0, reason: collision with root package name */
    private Rect f2361g0;

    /* renamed from: h0, reason: collision with root package name */
    private p f2362h0;

    /* renamed from: l, reason: collision with root package name */
    final Object f2363l;

    /* renamed from: m, reason: collision with root package name */
    final Context f2364m;

    /* renamed from: n, reason: collision with root package name */
    Window f2365n;

    /* renamed from: o, reason: collision with root package name */
    private d f2366o;
    final InterfaceC0329a p;

    /* renamed from: q, reason: collision with root package name */
    s f2367q;

    /* renamed from: r, reason: collision with root package name */
    l.g f2368r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f2369s;

    /* renamed from: t, reason: collision with root package name */
    private A f2370t;
    private b u;

    /* renamed from: v, reason: collision with root package name */
    private C0056j f2371v;

    /* renamed from: w, reason: collision with root package name */
    l.b f2372w;

    /* renamed from: x, reason: collision with root package name */
    ActionBarContextView f2373x;

    /* renamed from: y, reason: collision with root package name */
    PopupWindow f2374y;

    /* renamed from: z, reason: collision with root package name */
    Runnable f2375z;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar = j.this;
            if ((jVar.f2357c0 & 1) != 0) {
                jVar.K(0);
            }
            j jVar2 = j.this;
            if ((jVar2.f2357c0 & 4096) != 0) {
                jVar2.K(108);
            }
            j jVar3 = j.this;
            jVar3.f2356b0 = false;
            jVar3.f2357c0 = 0;
        }
    }

    private final class b implements l.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z4) {
            j.this.F(fVar);
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            Window.Callback callbackQ = j.this.Q();
            if (callbackQ == null) {
                return true;
            }
            callbackQ.onMenuOpened(108, fVar);
            return true;
        }
    }

    class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f2378a;

        final class a extends C0384b {
            a() {
            }

            @Override // androidx.core.view.u
            public final void a() {
                j.this.f2373x.setVisibility(8);
                j jVar = j.this;
                PopupWindow popupWindow = jVar.f2374y;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (jVar.f2373x.getParent() instanceof View) {
                    View view = (View) j.this.f2373x.getParent();
                    int i2 = androidx.core.view.o.d;
                    view.requestApplyInsets();
                }
                j.this.f2373x.l();
                j.this.f2332A.f(null);
                j jVar2 = j.this;
                jVar2.f2332A = null;
                ViewGroup viewGroup = jVar2.f2335D;
                int i4 = androidx.core.view.o.d;
                viewGroup.requestApplyInsets();
            }
        }

        public c(b.a aVar) {
            this.f2378a = aVar;
        }

        @Override // l.b.a
        public final boolean a(l.b bVar, Menu menu) {
            return this.f2378a.a(bVar, menu);
        }

        @Override // l.b.a
        public final boolean b(l.b bVar, MenuItem menuItem) {
            return this.f2378a.b(bVar, menuItem);
        }

        @Override // l.b.a
        public final void c(l.b bVar) {
            this.f2378a.c(bVar);
            j jVar = j.this;
            if (jVar.f2374y != null) {
                jVar.f2365n.getDecorView().removeCallbacks(j.this.f2375z);
            }
            j jVar2 = j.this;
            if (jVar2.f2373x != null) {
                jVar2.L();
                j jVar3 = j.this;
                t tVarA = androidx.core.view.o.a(jVar3.f2373x);
                tVarA.a(0.0f);
                jVar3.f2332A = tVarA;
                j.this.f2332A.f(new a());
            }
            InterfaceC0329a interfaceC0329a = j.this.p;
            if (interfaceC0329a != null) {
                interfaceC0329a.i();
            }
            j jVar4 = j.this;
            jVar4.f2372w = null;
            ViewGroup viewGroup = jVar4.f2335D;
            int i2 = androidx.core.view.o.d;
            viewGroup.requestApplyInsets();
        }

        @Override // l.b.a
        public final boolean d(l.b bVar, Menu menu) {
            ViewGroup viewGroup = j.this.f2335D;
            int i2 = androidx.core.view.o.d;
            viewGroup.requestApplyInsets();
            return this.f2378a.d(bVar, menu);
        }
    }

    class d extends l.i {
        d(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            f.a aVar = new f.a(j.this.f2364m, callback);
            l.b bVarC0 = j.this.c0(aVar);
            if (bVarC0 != null) {
                return aVar.e(bVarC0);
            }
            return null;
        }

        @Override // l.i, android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return j.this.J(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // l.i, android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || j.this.V(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
        }

        @Override // l.i, android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.f)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // l.i, android.view.Window.Callback
        public final boolean onMenuOpened(int i2, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            super.onMenuOpened(i2, menu);
            j.this.W(i2);
            return true;
        }

        @Override // l.i, android.view.Window.Callback
        public final void onPanelClosed(int i2, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            super.onPanelClosed(i2, menu);
            j.this.X(i2);
        }

        @Override // l.i, android.view.Window.Callback
        public final boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.f fVar = menu instanceof androidx.appcompat.view.menu.f ? (androidx.appcompat.view.menu.f) menu : null;
            if (i2 == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.N(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i2, view, menu);
            if (fVar != null) {
                fVar.N(false);
            }
            return zOnPreparePanel;
        }

        @Override // l.i, android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            androidx.appcompat.view.menu.f fVar = j.this.P(0).f2393h;
            if (fVar != null) {
                super.onProvideKeyboardShortcuts(list, fVar, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            }
        }

        @Override // l.i, android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // l.i, android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            return (j.this.T() && i2 == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i2);
        }
    }

    private class e extends f {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f2382c;

        e(Context context) {
            super();
            this.f2382c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.j.f
        final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.j.f
        public final void c() {
            j.this.B();
        }

        public final int e() {
            return this.f2382c.isPowerSaveMode() ? 2 : 1;
        }
    }

    abstract class f {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f2383a;

        final class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                f.this.c();
            }
        }

        f() {
        }

        final void a() {
            BroadcastReceiver broadcastReceiver = this.f2383a;
            if (broadcastReceiver != null) {
                try {
                    j.this.f2364m.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f2383a = null;
            }
        }

        abstract IntentFilter b();

        abstract void c();

        final void d() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f2383a == null) {
                this.f2383a = new a();
            }
            j.this.f2364m.registerReceiver(this.f2383a, intentFilterB);
        }
    }

    private class g extends f {

        /* renamed from: c, reason: collision with root package name */
        private final r f2386c;

        g(r rVar) {
            super();
            this.f2386c = rVar;
        }

        @Override // androidx.appcompat.app.j.f
        final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.j.f
        public final void c() {
            j.this.B();
        }

        public final int e() {
            return this.f2386c.c() ? 2 : 1;
        }
    }

    private class h extends ContentFrameLayout {
        public h(Context context) {
            super(context, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return j.this.J(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x2 = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (x2 < -5 || y2 < -5 || x2 > getWidth() + 5 || y2 > getHeight() + 5) {
                    j jVar = j.this;
                    jVar.G(jVar.P(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i2) {
            setBackgroundDrawable(C0333a.a(getContext(), i2));
        }
    }

    protected static final class i {

        /* renamed from: a, reason: collision with root package name */
        int f2388a;

        /* renamed from: b, reason: collision with root package name */
        int f2389b;

        /* renamed from: c, reason: collision with root package name */
        int f2390c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f2391e;

        /* renamed from: f, reason: collision with root package name */
        View f2392f;
        View g;

        /* renamed from: h, reason: collision with root package name */
        androidx.appcompat.view.menu.f f2393h;

        /* renamed from: i, reason: collision with root package name */
        androidx.appcompat.view.menu.d f2394i;

        /* renamed from: j, reason: collision with root package name */
        l.d f2395j;

        /* renamed from: k, reason: collision with root package name */
        boolean f2396k;

        /* renamed from: l, reason: collision with root package name */
        boolean f2397l;

        /* renamed from: m, reason: collision with root package name */
        boolean f2398m;

        /* renamed from: n, reason: collision with root package name */
        boolean f2399n = false;

        /* renamed from: o, reason: collision with root package name */
        boolean f2400o;
        Bundle p;

        i(int i2) {
            this.f2388a = i2;
        }

        final void a(androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.d dVar;
            androidx.appcompat.view.menu.f fVar2 = this.f2393h;
            if (fVar == fVar2) {
                return;
            }
            if (fVar2 != null) {
                fVar2.B(this.f2394i);
            }
            this.f2393h = fVar;
            if (fVar == null || (dVar = this.f2394i) == null) {
                return;
            }
            fVar.b(dVar);
        }
    }

    /* renamed from: androidx.appcompat.app.j$j, reason: collision with other inner class name */
    private final class C0056j implements l.a {
        C0056j() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z4) {
            androidx.appcompat.view.menu.f fVarQ = fVar.q();
            boolean z5 = fVarQ != fVar;
            j jVar = j.this;
            if (z5) {
                fVar = fVarQ;
            }
            i iVarO = jVar.O(fVar);
            if (iVarO != null) {
                if (!z5) {
                    j.this.G(iVarO, z4);
                } else {
                    j.this.E(iVarO.f2388a, iVarO, fVarQ);
                    j.this.G(iVarO, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            Window.Callback callbackQ;
            if (fVar != fVar.q()) {
                return true;
            }
            j jVar = j.this;
            if (!jVar.f2340I || (callbackQ = jVar.Q()) == null || j.this.f2349U) {
                return true;
            }
            callbackQ.onMenuOpened(108, fVar);
            return true;
        }
    }

    j(Activity activity, InterfaceC0329a interfaceC0329a) {
        this(activity, null, interfaceC0329a, activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean C(boolean z4) throws PackageManager.NameNotFoundException {
        boolean z5;
        boolean z6 = false;
        if (this.f2349U) {
            return false;
        }
        int i2 = this.f2350V;
        if (i2 == -100) {
            i2 = -100;
        }
        Configuration configurationH = H(this.f2364m, U(this.f2364m, i2), null);
        boolean z7 = true;
        if (this.f2353Y || !(this.f2363l instanceof Activity)) {
            this.f2353Y = true;
            z5 = this.f2352X;
        } else {
            PackageManager packageManager = this.f2364m.getPackageManager();
            if (packageManager == null) {
                z5 = false;
            } else {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f2364m, this.f2363l.getClass()), 269221888);
                    this.f2352X = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    this.f2352X = false;
                }
                this.f2353Y = true;
                z5 = this.f2352X;
            }
        }
        int i4 = this.f2364m.getResources().getConfiguration().uiMode & 48;
        int i5 = configurationH.uiMode & 48;
        if (i4 != i5 && z4 && !z5 && this.f2346R && (f2330k0 || this.f2347S)) {
            Object obj = this.f2363l;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                Activity activity = (Activity) this.f2363l;
                int i6 = C0394a.f7922c;
                activity.recreate();
                z6 = true;
            }
        }
        if (z6 || i4 == i5) {
            z7 = z6;
        } else {
            Resources resources = this.f2364m.getResources();
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.uiMode = i5 | (resources.getConfiguration().uiMode & (-49));
            resources.updateConfiguration(configuration, null);
            int i7 = this.f2351W;
            if (i7 != 0) {
                this.f2364m.setTheme(i7);
                this.f2364m.getTheme().applyStyle(this.f2351W, true);
            }
            if (z5) {
                Object obj2 = this.f2363l;
                if (obj2 instanceof Activity) {
                    Activity activity2 = (Activity) obj2;
                    if (activity2 instanceof androidx.lifecycle.k) {
                        if (((androidx.lifecycle.k) activity2).a().b().d(g.c.STARTED)) {
                            activity2.onConfigurationChanged(configuration);
                        }
                    } else if (this.f2348T) {
                        activity2.onConfigurationChanged(configuration);
                    }
                }
            }
        }
        if (z7) {
            Object obj3 = this.f2363l;
            if (obj3 instanceof androidx.appcompat.app.h) {
                Objects.requireNonNull((androidx.appcompat.app.h) obj3);
            }
        }
        if (i2 == 0) {
            Context context = this.f2364m;
            if (this.f2354Z == null) {
                this.f2354Z = new g(r.a(context));
            }
            this.f2354Z.d();
        } else {
            g gVar = this.f2354Z;
            if (gVar != null) {
                gVar.a();
            }
        }
        if (i2 == 3) {
            Context context2 = this.f2364m;
            if (this.f2355a0 == null) {
                this.f2355a0 = new e(context2);
            }
            this.f2355a0.d();
        } else {
            e eVar = this.f2355a0;
            if (eVar != null) {
                eVar.a();
            }
        }
        return z7;
    }

    private void D(Window window) {
        if (this.f2365n != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof d) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        d dVar = new d(callback);
        this.f2366o = dVar;
        window.setCallback(dVar);
        U uT = U.t(this.f2364m, null, f2329j0);
        Drawable drawableG = uT.g(0);
        if (drawableG != null) {
            window.setBackgroundDrawable(drawableG);
        }
        uT.v();
        this.f2365n = window;
    }

    private Configuration H(Context context, int i2, Configuration configuration) {
        int i4 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private void M() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        if (this.f2334C) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = this.f2364m.obtainStyledAttributes(Y1.a.f2122o);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            v(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            v(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            v(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            v(10);
        }
        this.L = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        N();
        this.f2365n.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2364m);
        if (this.M) {
            viewGroup = this.f2342K ? (ViewGroup) layoutInflaterFrom.inflate(com.android.mmt.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.android.mmt.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.L) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.android.mmt.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f2341J = false;
            this.f2340I = false;
        } else if (this.f2340I) {
            TypedValue typedValue = new TypedValue();
            this.f2364m.getTheme().resolveAttribute(com.android.mmt.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new l.d(this.f2364m, typedValue.resourceId) : this.f2364m).inflate(com.android.mmt.R.layout.abc_screen_toolbar, (ViewGroup) null);
            A a2 = (A) viewGroup.findViewById(com.android.mmt.R.id.decor_content_parent);
            this.f2370t = a2;
            a2.e(Q());
            if (this.f2341J) {
                this.f2370t.m(109);
            }
            if (this.f2338G) {
                this.f2370t.m(2);
            }
            if (this.f2339H) {
                this.f2370t.m(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder sbD = D2.e.d("AppCompat does not support the current theme features: { windowActionBar: ");
            sbD.append(this.f2340I);
            sbD.append(", windowActionBarOverlay: ");
            sbD.append(this.f2341J);
            sbD.append(", android:windowIsFloating: ");
            sbD.append(this.L);
            sbD.append(", windowActionModeOverlay: ");
            sbD.append(this.f2342K);
            sbD.append(", windowNoTitle: ");
            sbD.append(this.M);
            sbD.append(" }");
            throw new IllegalArgumentException(sbD.toString());
        }
        androidx.core.view.o.l(viewGroup, new k(this));
        if (this.f2370t == null) {
            this.f2336E = (TextView) viewGroup.findViewById(com.android.mmt.R.id.title);
        }
        int i2 = Y.f2971b;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e4) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e4);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.android.mmt.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f2365n.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f2365n.setContentView(viewGroup);
        contentFrameLayout.g(new l(this));
        this.f2335D = viewGroup;
        Object obj = this.f2363l;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f2369s;
        if (!TextUtils.isEmpty(title)) {
            A a5 = this.f2370t;
            if (a5 != null) {
                a5.c(title);
            } else {
                s sVar = this.f2367q;
                if (sVar != null) {
                    sVar.z(title);
                } else {
                    TextView textView = this.f2336E;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f2335D.findViewById(R.id.content);
        View decorView = this.f2365n.getDecorView();
        contentFrameLayout2.h(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes2 = this.f2364m.obtainStyledAttributes(Y1.a.f2122o);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.e());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.f());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.c());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.d());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.a());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.b());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f2334C = true;
        i iVarP = P(0);
        if (this.f2349U || iVarP.f2393h != null) {
            return;
        }
        S(108);
    }

    private void N() {
        if (this.f2365n == null) {
            Object obj = this.f2363l;
            if (obj instanceof Activity) {
                D(((Activity) obj).getWindow());
            }
        }
        if (this.f2365n == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void R() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        M();
        if (this.f2340I && this.f2367q == null) {
            Object obj = this.f2363l;
            if (obj instanceof Activity) {
                this.f2367q = new s((Activity) this.f2363l, this.f2341J);
            } else if (obj instanceof Dialog) {
                this.f2367q = new s((Dialog) this.f2363l);
            }
            s sVar = this.f2367q;
            if (sVar != null) {
                sVar.w(this.f2359e0);
            }
        }
    }

    private void S(int i2) {
        this.f2357c0 = (1 << i2) | this.f2357c0;
        if (this.f2356b0) {
            return;
        }
        View decorView = this.f2365n.getDecorView();
        Runnable runnable = this.f2358d0;
        int i4 = androidx.core.view.o.d;
        decorView.postOnAnimation(runnable);
        this.f2356b0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Y(i iVar, KeyEvent keyEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (iVar.f2398m || this.f2349U) {
            return;
        }
        if (iVar.f2388a == 0) {
            if ((this.f2364m.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackQ = Q();
        if (callbackQ != null && !callbackQ.onMenuOpened(iVar.f2388a, iVar.f2393h)) {
            G(iVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2364m.getSystemService("window");
        if (windowManager != null && a0(iVar, keyEvent)) {
            ViewGroup viewGroup = iVar.f2391e;
            if (viewGroup != null && !iVar.f2399n) {
                View view = iVar.g;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                }
                iVar.f2397l = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
                layoutParams2.gravity = iVar.f2390c;
                layoutParams2.windowAnimations = iVar.d;
                windowManager.addView(iVar.f2391e, layoutParams2);
                iVar.f2398m = true;
            }
            if (viewGroup == null) {
                R();
                s sVar = this.f2367q;
                Context contextC = sVar != null ? sVar.c() : null;
                if (contextC == null) {
                    contextC = this.f2364m;
                }
                TypedValue typedValue = new TypedValue();
                Resources.Theme themeNewTheme = contextC.getResources().newTheme();
                themeNewTheme.setTo(contextC.getTheme());
                themeNewTheme.resolveAttribute(com.android.mmt.R.attr.actionBarPopupTheme, typedValue, true);
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    themeNewTheme.applyStyle(i4, true);
                }
                themeNewTheme.resolveAttribute(com.android.mmt.R.attr.panelMenuListTheme, typedValue, true);
                int i5 = typedValue.resourceId;
                if (i5 != 0) {
                    themeNewTheme.applyStyle(i5, true);
                } else {
                    themeNewTheme.applyStyle(com.android.mmt.R.style.Theme_AppCompat_CompactMenu, true);
                }
                l.d dVar = new l.d(contextC, 0);
                dVar.getTheme().setTo(themeNewTheme);
                iVar.f2395j = dVar;
                TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(Y1.a.f2122o);
                iVar.f2389b = typedArrayObtainStyledAttributes.getResourceId(86, 0);
                iVar.d = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                typedArrayObtainStyledAttributes.recycle();
                iVar.f2391e = new h(iVar.f2395j);
                iVar.f2390c = 81;
            } else if (iVar.f2399n && viewGroup.getChildCount() > 0) {
                iVar.f2391e.removeAllViews();
            }
            View view2 = iVar.g;
            if (view2 == null) {
                if (iVar.f2393h != null) {
                    if (this.f2371v == null) {
                        this.f2371v = new C0056j();
                    }
                    C0056j c0056j = this.f2371v;
                    if (iVar.f2394i == null) {
                        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(iVar.f2395j);
                        iVar.f2394i = dVar2;
                        dVar2.d(c0056j);
                        iVar.f2393h.b(iVar.f2394i);
                    }
                    View view3 = (View) iVar.f2394i.h(iVar.f2391e);
                    iVar.f2392f = view3;
                    if (view3 != null) {
                    }
                    if (z4) {
                        if (iVar.f2392f != null && (iVar.g != null || iVar.f2394i.f().getCount() > 0)) {
                            ViewGroup.LayoutParams layoutParams3 = iVar.f2392f.getLayoutParams();
                            if (layoutParams3 == null) {
                                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            iVar.f2391e.setBackgroundResource(iVar.f2389b);
                            ViewParent parent = iVar.f2392f.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(iVar.f2392f);
                            }
                            iVar.f2391e.addView(iVar.f2392f, layoutParams3);
                            if (!iVar.f2392f.hasFocus()) {
                                iVar.f2392f.requestFocus();
                            }
                        }
                    }
                    iVar.f2399n = true;
                    return;
                }
                z4 = false;
                if (z4) {
                }
                iVar.f2399n = true;
                return;
            }
            iVar.f2392f = view2;
            z4 = true;
            if (z4) {
            }
            iVar.f2399n = true;
            return;
            i2 = -2;
            iVar.f2397l = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i2, -2, 0, 0, 1002, 8519680, -3);
            layoutParams22.gravity = iVar.f2390c;
            layoutParams22.windowAnimations = iVar.d;
            windowManager.addView(iVar.f2391e, layoutParams22);
            iVar.f2398m = true;
        }
    }

    private boolean Z(i iVar, int i2, KeyEvent keyEvent) {
        androidx.appcompat.view.menu.f fVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((iVar.f2396k || a0(iVar, keyEvent)) && (fVar = iVar.f2393h) != null) {
            return fVar.performShortcut(i2, keyEvent, 1);
        }
        return false;
    }

    private boolean a0(i iVar, KeyEvent keyEvent) {
        A a2;
        A a5;
        Resources.Theme themeNewTheme;
        A a6;
        A a7;
        if (this.f2349U) {
            return false;
        }
        if (iVar.f2396k) {
            return true;
        }
        i iVar2 = this.P;
        if (iVar2 != null && iVar2 != iVar) {
            G(iVar2, false);
        }
        Window.Callback callbackQ = Q();
        if (callbackQ != null) {
            iVar.g = callbackQ.onCreatePanelView(iVar.f2388a);
        }
        int i2 = iVar.f2388a;
        boolean z4 = i2 == 0 || i2 == 108;
        if (z4 && (a7 = this.f2370t) != null) {
            a7.h();
        }
        if (iVar.g == null) {
            androidx.appcompat.view.menu.f fVar = iVar.f2393h;
            if (fVar == null || iVar.f2400o) {
                if (fVar == null) {
                    Context context = this.f2364m;
                    int i4 = iVar.f2388a;
                    if ((i4 == 0 || i4 == 108) && this.f2370t != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.android.mmt.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(com.android.mmt.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(com.android.mmt.R.attr.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            l.d dVar = new l.d(context, 0);
                            dVar.getTheme().setTo(themeNewTheme);
                            context = dVar;
                        }
                    }
                    androidx.appcompat.view.menu.f fVar2 = new androidx.appcompat.view.menu.f(context);
                    fVar2.E(this);
                    iVar.a(fVar2);
                    if (iVar.f2393h == null) {
                        return false;
                    }
                }
                if (z4 && (a5 = this.f2370t) != null) {
                    if (this.u == null) {
                        this.u = new b();
                    }
                    a5.a(iVar.f2393h, this.u);
                }
                iVar.f2393h.P();
                if (!callbackQ.onCreatePanelMenu(iVar.f2388a, iVar.f2393h)) {
                    iVar.a(null);
                    if (z4 && (a2 = this.f2370t) != null) {
                        a2.a(null, this.u);
                    }
                    return false;
                }
                iVar.f2400o = false;
            }
            iVar.f2393h.P();
            Bundle bundle = iVar.p;
            if (bundle != null) {
                iVar.f2393h.C(bundle);
                iVar.p = null;
            }
            if (!callbackQ.onPreparePanel(0, iVar.g, iVar.f2393h)) {
                if (z4 && (a6 = this.f2370t) != null) {
                    a6.a(null, this.u);
                }
                iVar.f2393h.O();
                return false;
            }
            iVar.f2393h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            iVar.f2393h.O();
        }
        iVar.f2396k = true;
        iVar.f2397l = false;
        this.P = iVar;
        return true;
    }

    private void d0() {
        if (this.f2334C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // androidx.appcompat.app.i
    public final void A(CharSequence charSequence) {
        this.f2369s = charSequence;
        A a2 = this.f2370t;
        if (a2 != null) {
            a2.c(charSequence);
            return;
        }
        s sVar = this.f2367q;
        if (sVar != null) {
            sVar.z(charSequence);
            return;
        }
        TextView textView = this.f2336E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean B() {
        return C(true);
    }

    final void E(int i2, i iVar, Menu menu) {
        if (menu == null) {
            if (iVar == null && i2 >= 0) {
                i[] iVarArr = this.f2344O;
                if (i2 < iVarArr.length) {
                    iVar = iVarArr[i2];
                }
            }
            if (iVar != null) {
                menu = iVar.f2393h;
            }
        }
        if ((iVar == null || iVar.f2398m) && !this.f2349U) {
            this.f2366o.a().onPanelClosed(i2, menu);
        }
    }

    final void F(androidx.appcompat.view.menu.f fVar) {
        if (this.f2343N) {
            return;
        }
        this.f2343N = true;
        this.f2370t.n();
        Window.Callback callbackQ = Q();
        if (callbackQ != null && !this.f2349U) {
            callbackQ.onPanelClosed(108, fVar);
        }
        this.f2343N = false;
    }

    final void G(i iVar, boolean z4) {
        ViewGroup viewGroup;
        A a2;
        if (z4 && iVar.f2388a == 0 && (a2 = this.f2370t) != null && a2.d()) {
            F(iVar.f2393h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2364m.getSystemService("window");
        if (windowManager != null && iVar.f2398m && (viewGroup = iVar.f2391e) != null) {
            windowManager.removeView(viewGroup);
            if (z4) {
                E(iVar.f2388a, iVar, null);
            }
        }
        iVar.f2396k = false;
        iVar.f2397l = false;
        iVar.f2398m = false;
        iVar.f2392f = null;
        iVar.f2399n = true;
        if (this.P == iVar) {
            this.P = null;
        }
    }

    final void I() {
        A a2 = this.f2370t;
        if (a2 != null) {
            a2.n();
        }
        if (this.f2374y != null) {
            this.f2365n.getDecorView().removeCallbacks(this.f2375z);
            if (this.f2374y.isShowing()) {
                try {
                    this.f2374y.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f2374y = null;
        }
        L();
        androidx.appcompat.view.menu.f fVar = P(0).f2393h;
        if (fVar != null) {
            fVar.e(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final boolean J(KeyEvent keyEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        boolean z5;
        boolean zF;
        boolean zA0;
        Object obj = this.f2363l;
        if (((obj instanceof androidx.core.view.f) || (obj instanceof o)) && this.f2365n.getDecorView() != null) {
            int i2 = androidx.core.view.o.d;
        }
        if (keyEvent.getKeyCode() == 82 && this.f2366o.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                this.f2345Q = (keyEvent.getFlags() & 128) != 0;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                i iVarP = P(0);
                if (iVarP.f2398m) {
                    return true;
                }
                a0(iVarP, keyEvent);
                return true;
            }
        } else if (keyCode == 4) {
            boolean z6 = this.f2345Q;
            this.f2345Q = false;
            i iVarP2 = P(0);
            if (iVarP2.f2398m) {
                if (z6) {
                    return true;
                }
                G(iVarP2, true);
                return true;
            }
            l.b bVar = this.f2372w;
            if (bVar != null) {
                bVar.c();
            } else {
                R();
                s sVar = this.f2367q;
                if (sVar != null) {
                    B b2 = sVar.f2431e;
                    if (b2 == null || !b2.t()) {
                        z5 = false;
                    } else {
                        sVar.f2431e.collapseActionView();
                        z5 = true;
                    }
                    if (z5) {
                    }
                    if (z4) {
                        return true;
                    }
                }
                z4 = false;
                if (z4) {
                }
            }
            z4 = true;
            if (z4) {
            }
        } else if (keyCode == 82) {
            if (this.f2372w != null) {
                return true;
            }
            i iVarP3 = P(0);
            A a2 = this.f2370t;
            if (a2 == null || !a2.i() || ViewConfiguration.get(this.f2364m).hasPermanentMenuKey()) {
                boolean z7 = iVarP3.f2398m;
                if (z7 || iVarP3.f2397l) {
                    G(iVarP3, true);
                    zF = z7;
                } else if (iVarP3.f2396k) {
                    if (iVarP3.f2400o) {
                        iVarP3.f2396k = false;
                        zA0 = a0(iVarP3, keyEvent);
                    } else {
                        zA0 = true;
                    }
                    if (zA0) {
                        Y(iVarP3, keyEvent);
                        zF = true;
                    }
                } else {
                    zF = false;
                }
            } else if (this.f2370t.d()) {
                zF = this.f2370t.f();
            } else if (!this.f2349U && a0(iVarP3, keyEvent)) {
                zF = this.f2370t.g();
            }
            if (!zF) {
                return true;
            }
            AudioManager audioManager = (AudioManager) this.f2364m.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
                return true;
            }
            Log.w("AppCompatDelegate", "Couldn't get audio manager");
            return true;
        }
        return false;
    }

    final void K(int i2) {
        i iVarP = P(i2);
        if (iVarP.f2393h != null) {
            Bundle bundle = new Bundle();
            iVarP.f2393h.D(bundle);
            if (bundle.size() > 0) {
                iVarP.p = bundle;
            }
            iVarP.f2393h.P();
            iVarP.f2393h.clear();
        }
        iVarP.f2400o = true;
        iVarP.f2399n = true;
        if ((i2 == 108 || i2 == 0) && this.f2370t != null) {
            i iVarP2 = P(0);
            iVarP2.f2396k = false;
            a0(iVarP2, null);
        }
    }

    final void L() {
        t tVar = this.f2332A;
        if (tVar != null) {
            tVar.b();
        }
    }

    final i O(Menu menu) {
        i[] iVarArr = this.f2344O;
        int length = iVarArr != null ? iVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            i iVar = iVarArr[i2];
            if (iVar != null && iVar.f2393h == menu) {
                return iVar;
            }
        }
        return null;
    }

    protected final i P(int i2) {
        i[] iVarArr = this.f2344O;
        if (iVarArr == null || iVarArr.length <= i2) {
            i[] iVarArr2 = new i[i2 + 1];
            if (iVarArr != null) {
                System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
            }
            this.f2344O = iVarArr2;
            iVarArr = iVarArr2;
        }
        i iVar = iVarArr[i2];
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(i2);
        iVarArr[i2] = iVar2;
        return iVar2;
    }

    final Window.Callback Q() {
        return this.f2365n.getCallback();
    }

    public final boolean T() {
        return this.f2333B;
    }

    final int U(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                if (this.f2354Z == null) {
                    this.f2354Z = new g(r.a(context));
                }
                return this.f2354Z.e();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.f2355a0 == null) {
                    this.f2355a0 = new e(context);
                }
                return this.f2355a0.e();
            }
        }
        return i2;
    }

    final boolean V(int i2, KeyEvent keyEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean zPerformShortcut;
        Menu menuE;
        R();
        s sVar = this.f2367q;
        if (sVar != null) {
            s.d dVar = sVar.f2434i;
            if (dVar == null || (menuE = dVar.e()) == null) {
                zPerformShortcut = false;
            } else {
                androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) menuE;
                fVar.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
                zPerformShortcut = fVar.performShortcut(i2, keyEvent, 0);
            }
            if (zPerformShortcut) {
                return true;
            }
        }
        i iVar = this.P;
        if (iVar != null && Z(iVar, keyEvent.getKeyCode(), keyEvent)) {
            i iVar2 = this.P;
            if (iVar2 != null) {
                iVar2.f2397l = true;
            }
            return true;
        }
        if (this.P == null) {
            i iVarP = P(0);
            a0(iVarP, keyEvent);
            boolean Z4 = Z(iVarP, keyEvent.getKeyCode(), keyEvent);
            iVarP.f2396k = false;
            if (Z4) {
                return true;
            }
        }
        return false;
    }

    final void W(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i2 == 108) {
            R();
            s sVar = this.f2367q;
            if (sVar != null) {
                sVar.p(true);
            }
        }
    }

    final void X(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i2 == 108) {
            R();
            s sVar = this.f2367q;
            if (sVar != null) {
                sVar.p(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            i iVarP = P(i2);
            if (iVarP.f2398m) {
                G(iVarP, false);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        i iVarO;
        Window.Callback callbackQ = Q();
        if (callbackQ == null || this.f2349U || (iVarO = O(fVar.q())) == null) {
            return false;
        }
        return callbackQ.onMenuItemSelected(iVarO.f2388a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f fVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        A a2 = this.f2370t;
        if (a2 == null || !a2.i() || (ViewConfiguration.get(this.f2364m).hasPermanentMenuKey() && !this.f2370t.b())) {
            i iVarP = P(0);
            iVarP.f2399n = true;
            G(iVarP, false);
            Y(iVarP, null);
            return;
        }
        Window.Callback callbackQ = Q();
        if (this.f2370t.d()) {
            this.f2370t.f();
            if (this.f2349U) {
                return;
            }
            callbackQ.onPanelClosed(108, P(0).f2393h);
            return;
        }
        if (callbackQ == null || this.f2349U) {
            return;
        }
        if (this.f2356b0 && (1 & this.f2357c0) != 0) {
            this.f2365n.getDecorView().removeCallbacks(this.f2358d0);
            ((a) this.f2358d0).run();
        }
        i iVarP2 = P(0);
        androidx.appcompat.view.menu.f fVar2 = iVarP2.f2393h;
        if (fVar2 == null || iVarP2.f2400o || !callbackQ.onPreparePanel(0, iVarP2.g, fVar2)) {
            return;
        }
        callbackQ.onMenuOpened(108, iVarP2.f2393h);
        this.f2370t.g();
    }

    final boolean b0() {
        ViewGroup viewGroup;
        if (this.f2334C && (viewGroup = this.f2335D) != null) {
            int i2 = androidx.core.view.o.d;
            if (viewGroup.isLaidOut()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final l.b c0(b.a aVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        InterfaceC0329a interfaceC0329a;
        ViewGroup viewGroup;
        Context dVar;
        InterfaceC0329a interfaceC0329a2;
        l.b bVar = this.f2372w;
        if (bVar != null) {
            bVar.c();
        }
        c cVar = new c(aVar);
        R();
        s sVar = this.f2367q;
        boolean z4 = true;
        if (sVar != null) {
            s.d dVar2 = sVar.f2434i;
            if (dVar2 != null) {
                dVar2.c();
            }
            sVar.f2430c.z(false);
            sVar.f2432f.l();
            s.d dVar3 = sVar.new d(sVar.f2432f.getContext(), cVar);
            if (dVar3.t()) {
                sVar.f2434i = dVar3;
                dVar3.k();
                sVar.f2432f.i(dVar3);
                sVar.o(true);
                sVar.f2432f.sendAccessibilityEvent(32);
            } else {
                dVar3 = null;
            }
            this.f2372w = dVar3;
            if (dVar3 != null && (interfaceC0329a2 = this.p) != null) {
                interfaceC0329a2.b();
            }
        }
        if (this.f2372w == null) {
            L();
            l.b bVar2 = this.f2372w;
            if (bVar2 != null) {
                bVar2.c();
            }
            InterfaceC0329a interfaceC0329a3 = this.p;
            if (interfaceC0329a3 != null && !this.f2349U) {
                try {
                    interfaceC0329a3.h();
                } catch (AbstractMethodError unused) {
                }
            }
            if (this.f2373x == null) {
                if (this.L) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f2364m.getTheme();
                    theme.resolveAttribute(com.android.mmt.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f2364m.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new l.d(this.f2364m, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f2364m;
                    }
                    this.f2373x = new ActionBarContextView(dVar, null);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, com.android.mmt.R.attr.actionModePopupWindowStyle);
                    this.f2374y = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    this.f2374y.setContentView(this.f2373x);
                    this.f2374y.setWidth(-1);
                    dVar.getTheme().resolveAttribute(com.android.mmt.R.attr.actionBarSize, typedValue, true);
                    this.f2373x.e(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f2374y.setHeight(-2);
                    this.f2375z = new m(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f2335D.findViewById(com.android.mmt.R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        R();
                        s sVar2 = this.f2367q;
                        Context contextC = sVar2 != null ? sVar2.c() : null;
                        if (contextC == null) {
                            contextC = this.f2364m;
                        }
                        viewStubCompat.b(LayoutInflater.from(contextC));
                        this.f2373x = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f2373x != null) {
                L();
                this.f2373x.l();
                l.e eVar = new l.e(this.f2373x.getContext(), this.f2373x, cVar);
                if (cVar.a(eVar, eVar.e())) {
                    eVar.k();
                    this.f2373x.i(eVar);
                    this.f2372w = eVar;
                    if (!this.f2334C || (viewGroup = this.f2335D) == null) {
                        z4 = false;
                        if (z4) {
                            this.f2373x.setAlpha(1.0f);
                            this.f2373x.setVisibility(0);
                            this.f2373x.sendAccessibilityEvent(32);
                            if (this.f2373x.getParent() instanceof View) {
                                View view = (View) this.f2373x.getParent();
                                int i2 = androidx.core.view.o.d;
                                view.requestApplyInsets();
                            }
                        } else {
                            this.f2373x.setAlpha(0.0f);
                            t tVarA = androidx.core.view.o.a(this.f2373x);
                            tVarA.a(1.0f);
                            this.f2332A = tVarA;
                            tVarA.f(new n(this));
                        }
                        if (this.f2374y != null) {
                            this.f2365n.getDecorView().post(this.f2375z);
                        }
                    } else {
                        int i4 = androidx.core.view.o.d;
                        if (!viewGroup.isLaidOut()) {
                        }
                        if (z4) {
                        }
                        if (this.f2374y != null) {
                        }
                    }
                } else {
                    this.f2372w = null;
                }
            }
            if (this.f2372w != null && (interfaceC0329a = this.p) != null) {
                interfaceC0329a.b();
            }
            this.f2372w = this.f2372w;
        }
        return this.f2372w;
    }

    @Override // androidx.appcompat.app.i
    public final void d(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        M();
        ((ViewGroup) this.f2335D.findViewById(R.id.content)).addView(view, layoutParams);
        this.f2366o.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.i
    public final Context e(Context context) {
        this.f2346R = true;
        int i2 = this.f2350V;
        if (i2 == -100) {
            i2 = -100;
        }
        int iU = U(context, i2);
        Configuration configuration = null;
        if (f2331l0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(H(context, iU, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof l.d) {
            try {
                ((l.d) context).a(H(context, iU, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f2330k0) {
            return context;
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = new Configuration();
            configuration.fontScale = 0.0f;
            if (configuration3.diff(configuration4) != 0) {
                float f4 = configuration3.fontScale;
                float f5 = configuration4.fontScale;
                if (f4 != f5) {
                    configuration.fontScale = f5;
                }
                int i4 = configuration3.mcc;
                int i5 = configuration4.mcc;
                if (i4 != i5) {
                    configuration.mcc = i5;
                }
                int i6 = configuration3.mnc;
                int i7 = configuration4.mnc;
                if (i6 != i7) {
                    configuration.mnc = i7;
                }
                LocaleList locales = configuration3.getLocales();
                LocaleList locales2 = configuration4.getLocales();
                if (!locales.equals(locales2)) {
                    configuration.setLocales(locales2);
                    configuration.locale = configuration4.locale;
                }
                int i8 = configuration3.touchscreen;
                int i9 = configuration4.touchscreen;
                if (i8 != i9) {
                    configuration.touchscreen = i9;
                }
                int i10 = configuration3.keyboard;
                int i11 = configuration4.keyboard;
                if (i10 != i11) {
                    configuration.keyboard = i11;
                }
                int i12 = configuration3.keyboardHidden;
                int i13 = configuration4.keyboardHidden;
                if (i12 != i13) {
                    configuration.keyboardHidden = i13;
                }
                int i14 = configuration3.navigation;
                int i15 = configuration4.navigation;
                if (i14 != i15) {
                    configuration.navigation = i15;
                }
                int i16 = configuration3.navigationHidden;
                int i17 = configuration4.navigationHidden;
                if (i16 != i17) {
                    configuration.navigationHidden = i17;
                }
                int i18 = configuration3.orientation;
                int i19 = configuration4.orientation;
                if (i18 != i19) {
                    configuration.orientation = i19;
                }
                int i20 = configuration3.screenLayout & 15;
                int i21 = configuration4.screenLayout & 15;
                if (i20 != i21) {
                    configuration.screenLayout |= i21;
                }
                int i22 = configuration3.screenLayout & 192;
                int i23 = configuration4.screenLayout & 192;
                if (i22 != i23) {
                    configuration.screenLayout |= i23;
                }
                int i24 = configuration3.screenLayout & 48;
                int i25 = configuration4.screenLayout & 48;
                if (i24 != i25) {
                    configuration.screenLayout |= i25;
                }
                int i26 = configuration3.screenLayout & 768;
                int i27 = configuration4.screenLayout & 768;
                if (i26 != i27) {
                    configuration.screenLayout |= i27;
                }
                int i28 = configuration3.colorMode & 3;
                int i29 = configuration4.colorMode & 3;
                if (i28 != i29) {
                    configuration.colorMode |= i29;
                }
                int i30 = configuration3.colorMode & 12;
                int i31 = configuration4.colorMode & 12;
                if (i30 != i31) {
                    configuration.colorMode |= i31;
                }
                int i32 = configuration3.uiMode & 15;
                int i33 = configuration4.uiMode & 15;
                if (i32 != i33) {
                    configuration.uiMode |= i33;
                }
                int i34 = configuration3.uiMode & 48;
                int i35 = configuration4.uiMode & 48;
                if (i34 != i35) {
                    configuration.uiMode |= i35;
                }
                int i36 = configuration3.screenWidthDp;
                int i37 = configuration4.screenWidthDp;
                if (i36 != i37) {
                    configuration.screenWidthDp = i37;
                }
                int i38 = configuration3.screenHeightDp;
                int i39 = configuration4.screenHeightDp;
                if (i38 != i39) {
                    configuration.screenHeightDp = i39;
                }
                int i40 = configuration3.smallestScreenWidthDp;
                int i41 = configuration4.smallestScreenWidthDp;
                if (i40 != i41) {
                    configuration.smallestScreenWidthDp = i41;
                }
                int i42 = configuration3.densityDpi;
                int i43 = configuration4.densityDpi;
                if (i42 != i43) {
                    configuration.densityDpi = i43;
                }
            }
        }
        Configuration configurationH = H(context, iU, configuration);
        l.d dVar = new l.d(context, com.android.mmt.R.style.Theme_AppCompat_Empty);
        dVar.a(configurationH);
        boolean z4 = false;
        try {
            z4 = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z4) {
            dVar.getTheme().rebase();
        }
        return dVar;
    }

    final int e0(w wVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        boolean z5;
        int color;
        int iH = wVar.h();
        ActionBarContextView actionBarContextView = this.f2373x;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z4 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2373x.getLayoutParams();
            if (this.f2373x.isShown()) {
                if (this.f2360f0 == null) {
                    this.f2360f0 = new Rect();
                    this.f2361g0 = new Rect();
                }
                Rect rect = this.f2360f0;
                Rect rect2 = this.f2361g0;
                rect.set(wVar.f(), wVar.h(), wVar.g(), wVar.e());
                Y.a(this.f2335D, rect, rect2);
                int i2 = rect.top;
                int i4 = rect.left;
                int i5 = rect.right;
                w wVarE = androidx.core.view.o.e(this.f2335D);
                int iF = wVarE == null ? 0 : wVarE.f();
                int iG = wVarE == null ? 0 : wVarE.g();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z5 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z5 = true;
                }
                if (i2 <= 0 || this.f2337F != null) {
                    View view = this.f2337F;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != iF || marginLayoutParams2.rightMargin != iG) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = iF;
                            marginLayoutParams2.rightMargin = iG;
                            this.f2337F.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f2364m);
                    this.f2337F = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iF;
                    layoutParams.rightMargin = iG;
                    this.f2335D.addView(this.f2337F, -1, layoutParams);
                }
                View view3 = this.f2337F;
                z4 = view3 != null;
                if (z4 && view3.getVisibility() != 0) {
                    View view4 = this.f2337F;
                    int i8 = androidx.core.view.o.d;
                    if ((view4.getWindowSystemUiVisibility() & 8192) != 0) {
                        Context context = this.f2364m;
                        int i9 = C0405a.f7979b;
                        color = context.getColor(com.android.mmt.R.color.abc_decor_view_status_guard_light);
                    } else {
                        Context context2 = this.f2364m;
                        int i10 = C0405a.f7979b;
                        color = context2.getColor(com.android.mmt.R.color.abc_decor_view_status_guard);
                    }
                    view4.setBackgroundColor(color);
                }
                if (!this.f2342K && z4) {
                    iH = 0;
                }
                z = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z4 = false;
            } else {
                z = false;
                z4 = false;
            }
            if (z) {
                this.f2373x.setLayoutParams(marginLayoutParams);
            }
        }
        View view5 = this.f2337F;
        if (view5 != null) {
            view5.setVisibility(z4 ? 0 : 8);
        }
        return iH;
    }

    @Override // androidx.appcompat.app.i
    public final <T extends View> T f(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        M();
        return (T) this.f2365n.findViewById(i2);
    }

    @Override // androidx.appcompat.app.i
    public final int g() {
        return this.f2350V;
    }

    @Override // androidx.appcompat.app.i
    public final MenuInflater h() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f2368r == null) {
            R();
            s sVar = this.f2367q;
            this.f2368r = new l.g(sVar != null ? sVar.c() : this.f2364m);
        }
        return this.f2368r;
    }

    @Override // androidx.appcompat.app.i
    public final androidx.appcompat.app.a i() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        R();
        return this.f2367q;
    }

    @Override // androidx.appcompat.app.i
    public final void j() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2364m);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof j) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.i
    public final void k() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        R();
        S(0);
    }

    @Override // androidx.appcompat.app.i
    public final void l(Configuration configuration) throws IllegalAccessException, NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f2340I && this.f2334C) {
            R();
            s sVar = this.f2367q;
            if (sVar != null) {
                sVar.t();
            }
        }
        C0187h.b().f(this.f2364m);
        C(false);
    }

    @Override // androidx.appcompat.app.i
    public final void m() throws PackageManager.NameNotFoundException {
        this.f2346R = true;
        C(false);
        N();
        Object obj = this.f2363l;
        if (obj instanceof Activity) {
            String strC = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    strC = C0396c.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (strC != null) {
                s sVar = this.f2367q;
                if (sVar == null) {
                    this.f2359e0 = true;
                } else {
                    sVar.w(true);
                }
            }
            androidx.appcompat.app.i.c(this);
        }
        this.f2347S = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    @Override // androidx.appcompat.app.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n() {
        if (this.f2363l instanceof Activity) {
            androidx.appcompat.app.i.t(this);
        }
        if (this.f2356b0) {
            this.f2365n.getDecorView().removeCallbacks(this.f2358d0);
        }
        this.f2348T = false;
        this.f2349U = true;
        if (this.f2350V != -100) {
            Object obj = this.f2363l;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f2328i0.put(this.f2363l.getClass().getName(), Integer.valueOf(this.f2350V));
            } else {
                f2328i0.remove(this.f2363l.getClass().getName());
            }
        }
        g gVar = this.f2354Z;
        if (gVar != null) {
            gVar.a();
        }
        e eVar = this.f2355a0;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // androidx.appcompat.app.i
    public final void o() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        M();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.f2362h0 == null) {
            String string = this.f2364m.obtainStyledAttributes(Y1.a.f2122o).getString(116);
            if (string == null) {
                this.f2362h0 = new p();
            } else {
                try {
                    this.f2362h0 = (p) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f2362h0 = new p();
                }
            }
        }
        p pVar = this.f2362h0;
        int i2 = X.f2969a;
        return pVar.a(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.i
    public final void p() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        R();
        s sVar = this.f2367q;
        if (sVar != null) {
            sVar.y(true);
        }
    }

    @Override // androidx.appcompat.app.i
    public final void q() {
    }

    @Override // androidx.appcompat.app.i
    public final void r() {
        this.f2348T = true;
        B();
    }

    @Override // androidx.appcompat.app.i
    public final void s() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.f2348T = false;
        R();
        s sVar = this.f2367q;
        if (sVar != null) {
            sVar.y(false);
        }
    }

    @Override // androidx.appcompat.app.i
    public final boolean v(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i2 = 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        if (this.M && i2 == 108) {
            return false;
        }
        if (this.f2340I && i2 == 1) {
            this.f2340I = false;
        }
        if (i2 == 1) {
            d0();
            this.M = true;
            return true;
        }
        if (i2 == 2) {
            d0();
            this.f2338G = true;
            return true;
        }
        if (i2 == 5) {
            d0();
            this.f2339H = true;
            return true;
        }
        if (i2 == 10) {
            d0();
            this.f2342K = true;
            return true;
        }
        if (i2 == 108) {
            d0();
            this.f2340I = true;
            return true;
        }
        if (i2 != 109) {
            return this.f2365n.requestFeature(i2);
        }
        d0();
        this.f2341J = true;
        return true;
    }

    @Override // androidx.appcompat.app.i
    public final void w(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        M();
        ViewGroup viewGroup = (ViewGroup) this.f2335D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2364m).inflate(i2, viewGroup);
        this.f2366o.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.i
    public final void x(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        M();
        ViewGroup viewGroup = (ViewGroup) this.f2335D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2366o.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.i
    public final void y(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        M();
        ViewGroup viewGroup = (ViewGroup) this.f2335D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2366o.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.i
    public final void z(int i2) {
        this.f2351W = i2;
    }

    j(Dialog dialog, InterfaceC0329a interfaceC0329a) {
        this(dialog.getContext(), dialog.getWindow(), interfaceC0329a, dialog);
    }

    private j(Context context, Window window, InterfaceC0329a interfaceC0329a, Object obj) {
        q.g<String, Integer> gVar;
        Integer orDefault;
        androidx.appcompat.app.h hVar;
        this.f2332A = null;
        this.f2333B = true;
        this.f2350V = -100;
        this.f2358d0 = new a();
        this.f2364m = context;
        this.p = interfaceC0329a;
        this.f2363l = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (context instanceof androidx.appcompat.app.h) {
                    hVar = (androidx.appcompat.app.h) context;
                    break;
                } else if (!(context instanceof ContextWrapper)) {
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            hVar = null;
            if (hVar != null) {
                this.f2350V = hVar.z().g();
            }
        }
        if (this.f2350V == -100 && (orDefault = (gVar = f2328i0).getOrDefault(this.f2363l.getClass().getName(), null)) != null) {
            this.f2350V = orDefault.intValue();
            gVar.remove(this.f2363l.getClass().getName());
        }
        if (window != null) {
            D(window);
        }
        C0187h.g();
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
