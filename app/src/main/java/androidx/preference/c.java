package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import androidx.preference.DialogPreference;
import androidx.preference.g;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public abstract class c extends Fragment implements g.c, g.a, g.b, DialogPreference.a {

    /* renamed from: d0, reason: collision with root package name */
    private g f3838d0;

    /* renamed from: e0, reason: collision with root package name */
    RecyclerView f3839e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f3840f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f3841g0;

    /* renamed from: c0, reason: collision with root package name */
    private final C0071c f3837c0 = new C0071c();

    /* renamed from: h0, reason: collision with root package name */
    private int f3842h0 = R.layout.preference_list_fragment;

    /* renamed from: i0, reason: collision with root package name */
    private Handler f3843i0 = new a();

    /* renamed from: j0, reason: collision with root package name */
    private final Runnable f3844j0 = new b();

    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            c cVar;
            PreferenceScreen preferenceScreenE1;
            if (message.what == 1 && (preferenceScreenE1 = (cVar = c.this).e1()) != null) {
                cVar.f3839e0.p0(cVar.f1(preferenceScreenE1));
                preferenceScreenE1.K();
            }
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = c.this.f3839e0;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* renamed from: androidx.preference.c$c, reason: collision with other inner class name */
    private class C0071c extends RecyclerView.k {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f3847a;

        /* renamed from: b, reason: collision with root package name */
        private int f3848b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3849c = true;

        C0071c() {
        }

        private boolean i(View view, RecyclerView recyclerView) {
            RecyclerView.x xVarM = recyclerView.M(view);
            boolean z4 = false;
            if (!((xVarM instanceof h) && ((h) xVarM).D())) {
                return false;
            }
            boolean z5 = this.f3849c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z5;
            }
            RecyclerView.x xVarM2 = recyclerView.M(recyclerView.getChildAt(iIndexOfChild + 1));
            if ((xVarM2 instanceof h) && ((h) xVarM2).C()) {
                z4 = true;
            }
            return z4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k
        public final void d(Rect rect, View view, RecyclerView recyclerView) {
            if (i(view, recyclerView)) {
                rect.bottom = this.f3848b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k
        public final void e(Canvas canvas, RecyclerView recyclerView) {
            if (this.f3847a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (i(childAt, recyclerView)) {
                    int height = childAt.getHeight() + ((int) childAt.getY());
                    this.f3847a.setBounds(0, height, width, this.f3848b + height);
                    this.f3847a.draw(canvas);
                }
            }
        }

        public final void f(boolean z4) {
            this.f3849c = z4;
        }

        public final void g(Drawable drawable) {
            if (drawable != null) {
                this.f3848b = drawable.getIntrinsicHeight();
            } else {
                this.f3848b = 0;
            }
            this.f3847a = drawable;
            c.this.f3839e0.T();
        }

        public final void h(int i2) {
            this.f3848b = i2;
            c.this.f3839e0.T();
        }
    }

    public interface d {
        boolean a();
    }

    public interface e {
        boolean a();
    }

    public interface f {
        boolean a();
    }

    public final RecyclerView c1() {
        return this.f3839e0;
    }

    public final g d1() {
        return this.f3838d0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        TypedValue typedValue = new TypedValue();
        x().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = R.style.PreferenceThemeOverlay;
        }
        x().getTheme().applyStyle(i2, false);
        g gVar = new g(B());
        this.f3838d0 = gVar;
        gVar.m(this);
        g1(z() != null ? z().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    public final PreferenceScreen e1() {
        return this.f3838d0.i();
    }

    public void f(Preference preference) {
        DialogInterfaceOnCancelListenerC0216l cVar;
        if (!(x() instanceof d ? ((d) x()).a() : false) && I().T("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                String strO = preference.o();
                cVar = new O.a();
                Bundle bundle = new Bundle(1);
                bundle.putString("key", strO);
                cVar.R0(bundle);
            } else if (preference instanceof ListPreference) {
                String strO2 = preference.o();
                cVar = new O.b();
                Bundle bundle2 = new Bundle(1);
                bundle2.putString("key", strO2);
                cVar.R0(bundle2);
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    StringBuilder sbD = D2.e.d("Cannot display dialog for an unknown Preference type: ");
                    sbD.append(preference.getClass().getSimpleName());
                    sbD.append(". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                    throw new IllegalArgumentException(sbD.toString());
                }
                String strO3 = preference.o();
                cVar = new O.c();
                Bundle bundle3 = new Bundle(1);
                bundle3.putString("key", strO3);
                cVar.R0(bundle3);
            }
            cVar.Z0(this);
            cVar.h1(I(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    protected RecyclerView.e f1(PreferenceScreen preferenceScreen) {
        return new androidx.preference.d(preferenceScreen);
    }

    @Override // androidx.fragment.app.Fragment
    public View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = B().obtainStyledAttributes(null, C0384b.f7883n, R.attr.preferenceFragmentCompatStyle, 0);
        this.f3842h0 = typedArrayObtainStyledAttributes.getResourceId(0, this.f3842h0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(3, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(B());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f3842h0, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewH1 = h1(layoutInflaterCloneInContext, viewGroup2);
        if (recyclerViewH1 == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f3839e0 = recyclerViewH1;
        recyclerViewH1.g(this.f3837c0);
        this.f3837c0.g(drawable);
        if (dimensionPixelSize != -1) {
            this.f3837c0.h(dimensionPixelSize);
        }
        this.f3837c0.f(z4);
        if (this.f3839e0.getParent() == null) {
            viewGroup2.addView(this.f3839e0);
        }
        this.f3843i0.post(this.f3844j0);
        return viewInflate;
    }

    public abstract void g1(String str);

    public RecyclerView h1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        RecyclerView recyclerView;
        if (B().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        B();
        recyclerView2.u0(new LinearLayoutManager());
        recyclerView2.o0(new O.e(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    public void i0() {
        this.f3843i0.removeCallbacks(this.f3844j0);
        this.f3843i0.removeMessages(1);
        if (this.f3840f0) {
            this.f3839e0.p0(null);
            PreferenceScreen preferenceScreenE1 = e1();
            if (preferenceScreenE1 != null) {
                preferenceScreenE1.P();
            }
        }
        this.f3839e0 = null;
        super.i0();
    }

    public final void i1(int i2, String str) {
        g gVar = this.f3838d0;
        if (gVar == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        PreferenceScreen preferenceScreenK = gVar.k(B(), i2);
        Object obj = preferenceScreenK;
        if (str != null) {
            Object objX0 = preferenceScreenK.x0(str);
            boolean z4 = objX0 instanceof PreferenceScreen;
            obj = objX0;
            if (!z4) {
                throw new IllegalArgumentException(C2.c.a("Preference object with key ", str, " is not a PreferenceScreen"));
            }
        }
        PreferenceScreen preferenceScreen = (PreferenceScreen) obj;
        if (!this.f3838d0.o(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        this.f3840f0 = true;
        if (!this.f3841g0 || this.f3843i0.hasMessages(1)) {
            return;
        }
        this.f3843i0.obtainMessage(1).sendToTarget();
    }

    public boolean j(Preference preference) {
        if (preference.l() == null) {
            return false;
        }
        if (x() instanceof e ? ((e) x()).a() : false) {
            return true;
        }
        Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        w wVarU = M0().u();
        Bundle bundleK = preference.k();
        Fragment fragmentA = wVarU.Y().a(M0().getClassLoader(), preference.l());
        fragmentA.R0(bundleK);
        fragmentA.Z0(this);
        E eF = wVarU.f();
        eF.o(((View) T().getParent()).getId(), fragmentA, null);
        eF.e();
        eF.g();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void q0(Bundle bundle) {
        PreferenceScreen preferenceScreenE1 = e1();
        if (preferenceScreenE1 != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenE1.h(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.preference.DialogPreference.a
    public final <T extends Preference> T r(CharSequence charSequence) {
        g gVar = this.f3838d0;
        if (gVar == null) {
            return null;
        }
        return (T) gVar.a(charSequence);
    }

    @Override // androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        this.f3838d0.n(this);
        this.f3838d0.l(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void s0() {
        super.s0();
        this.f3838d0.n(null);
        this.f3838d0.l(null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void t0(Bundle bundle) {
        PreferenceScreen preferenceScreenE1;
        Bundle bundle2;
        PreferenceScreen preferenceScreenE12;
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenE12 = e1()) != null) {
            preferenceScreenE12.g(bundle2);
        }
        if (this.f3840f0 && (preferenceScreenE1 = e1()) != null) {
            this.f3839e0.p0(f1(preferenceScreenE1));
            preferenceScreenE1.K();
        }
        this.f3841g0 = true;
    }
}
