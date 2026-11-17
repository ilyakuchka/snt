package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w.m;
import com.android.mmt.R;
import t.C0384b;

/* renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0216l extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: c0, reason: collision with root package name */
    private Handler f3541c0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f3549k0;

    /* renamed from: m0, reason: collision with root package name */
    private Dialog f3551m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f3552n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f3553o0;
    private boolean p0;

    /* renamed from: d0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f3542d0 = new a();

    /* renamed from: e0, reason: collision with root package name */
    private DialogInterface.OnDismissListener f3543e0 = new b();

    /* renamed from: f0, reason: collision with root package name */
    private int f3544f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    private int f3545g0 = 0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f3546h0 = true;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f3547i0 = true;

    /* renamed from: j0, reason: collision with root package name */
    private int f3548j0 = -1;

    /* renamed from: l0, reason: collision with root package name */
    private androidx.lifecycle.p<androidx.lifecycle.k> f3550l0 = new c();
    private boolean q0 = false;

    /* renamed from: androidx.fragment.app.l$a */
    final class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0216l.this.f3551m0 != null) {
                DialogInterfaceOnCancelListenerC0216l dialogInterfaceOnCancelListenerC0216l = DialogInterfaceOnCancelListenerC0216l.this;
                dialogInterfaceOnCancelListenerC0216l.onCancel(dialogInterfaceOnCancelListenerC0216l.f3551m0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.l$b */
    final class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0216l.this.f3551m0 != null) {
                DialogInterfaceOnCancelListenerC0216l dialogInterfaceOnCancelListenerC0216l = DialogInterfaceOnCancelListenerC0216l.this;
                dialogInterfaceOnCancelListenerC0216l.onDismiss(dialogInterfaceOnCancelListenerC0216l.f3551m0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.l$c */
    final class c implements androidx.lifecycle.p<androidx.lifecycle.k> {
        c() {
        }

        @Override // androidx.lifecycle.p
        @SuppressLint({"SyntheticAccessor"})
        public final void a(androidx.lifecycle.k kVar) {
            if (kVar == null || !DialogInterfaceOnCancelListenerC0216l.this.f3547i0) {
                return;
            }
            View viewO0 = DialogInterfaceOnCancelListenerC0216l.this.O0();
            if (viewO0.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogInterfaceOnCancelListenerC0216l.this.f3551m0 != null) {
                if (w.k0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogInterfaceOnCancelListenerC0216l.this.f3551m0);
                }
                DialogInterfaceOnCancelListenerC0216l.this.f3551m0.setContentView(viewO0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.l$d */
    final class d extends O.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ O.d f3557a;

        d(O.d dVar) {
            this.f3557a = dVar;
        }

        @Override // O.d
        public final View d(int i2) {
            return this.f3557a.g() ? this.f3557a.d(i2) : DialogInterfaceOnCancelListenerC0216l.this.f1(i2);
        }

        @Override // O.d
        public final boolean g() {
            return this.f3557a.g() || DialogInterfaceOnCancelListenerC0216l.this.g1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void c0(Context context) {
        super.c0(context);
        this.f3427Y.h(this.f3550l0);
        if (this.p0) {
            return;
        }
        this.f3553o0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        super.e0(bundle);
        this.f3541c0 = new Handler();
        this.f3547i0 = this.f3411F == 0;
        if (bundle != null) {
            this.f3544f0 = bundle.getInt("android:style", 0);
            this.f3545g0 = bundle.getInt("android:theme", 0);
            this.f3546h0 = bundle.getBoolean("android:cancelable", true);
            this.f3547i0 = bundle.getBoolean("android:showsDialog", this.f3547i0);
            this.f3548j0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public Dialog e1(Bundle bundle) {
        if (w.k0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(N0(), this.f3545g0);
    }

    final View f1(int i2) {
        Dialog dialog = this.f3551m0;
        if (dialog != null) {
            return dialog.findViewById(i2);
        }
        return null;
    }

    final boolean g1() {
        return this.q0;
    }

    public final void h1(w wVar, String str) {
        this.f3553o0 = false;
        this.p0 = true;
        C0205a c0205a = new C0205a(wVar);
        c0205a.k(0, this, str, 1);
        c0205a.g();
    }

    @Override // androidx.fragment.app.Fragment
    public final void i0() {
        super.i0();
        Dialog dialog = this.f3551m0;
        if (dialog != null) {
            this.f3552n0 = true;
            dialog.setOnDismissListener(null);
            this.f3551m0.dismiss();
            if (!this.f3553o0) {
                onDismiss(this.f3551m0);
            }
            this.f3551m0 = null;
            this.q0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void j0() {
        super.j0();
        if (!this.p0 && !this.f3553o0) {
            this.f3553o0 = true;
        }
        this.f3427Y.l(this.f3550l0);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x006b, TryCatch #0 {all -> 0x006b, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0046, B:27:0x004d, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:28:0x0065), top: B:47:0x001a }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LayoutInflater k0(Bundle bundle) {
        Context contextB;
        LayoutInflater layoutInflaterK0 = super.k0(bundle);
        boolean z4 = this.f3547i0;
        if (!z4 || this.f3549k0) {
            if (w.k0(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (this.f3547i0) {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + str);
                } else {
                    Log.d("FragmentManager", "mShowsDialog = false: " + str);
                }
            }
            return layoutInflaterK0;
        }
        if (z4 && !this.q0) {
            try {
                this.f3549k0 = true;
                Dialog dialogE1 = e1(bundle);
                this.f3551m0 = dialogE1;
                if (this.f3547i0) {
                    int i2 = this.f3544f0;
                    if (i2 == 1 || i2 == 2) {
                        dialogE1.requestWindowFeature(1);
                        contextB = B();
                        if (contextB instanceof Activity) {
                            this.f3551m0.setOwnerActivity((Activity) contextB);
                        }
                        this.f3551m0.setCancelable(this.f3546h0);
                        this.f3551m0.setOnCancelListener(this.f3542d0);
                        this.f3551m0.setOnDismissListener(this.f3543e0);
                        this.q0 = true;
                    } else if (i2 == 3) {
                        Window window = dialogE1.getWindow();
                        if (window != null) {
                            window.addFlags(24);
                        }
                        dialogE1.requestWindowFeature(1);
                        contextB = B();
                        if (contextB instanceof Activity) {
                        }
                        this.f3551m0.setCancelable(this.f3546h0);
                        this.f3551m0.setOnCancelListener(this.f3542d0);
                        this.f3551m0.setOnDismissListener(this.f3543e0);
                        this.q0 = true;
                    } else {
                        contextB = B();
                        if (contextB instanceof Activity) {
                        }
                        this.f3551m0.setCancelable(this.f3546h0);
                        this.f3551m0.setOnCancelListener(this.f3542d0);
                        this.f3551m0.setOnDismissListener(this.f3543e0);
                        this.q0 = true;
                    }
                } else {
                    this.f3551m0 = null;
                }
            } finally {
                this.f3549k0 = false;
            }
        }
        if (w.k0(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.f3551m0;
        return dialog != null ? layoutInflaterK0.cloneInContext(dialog.getContext()) : layoutInflaterK0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f3552n0) {
            return;
        }
        if (w.k0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        if (this.f3553o0) {
            return;
        }
        this.f3553o0 = true;
        this.p0 = false;
        Dialog dialog = this.f3551m0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f3551m0.dismiss();
        }
        this.f3552n0 = true;
        if (this.f3548j0 < 0) {
            C0205a c0205a = new C0205a(I());
            c0205a.n(this);
            c0205a.h();
        } else {
            w wVarI = I();
            int i2 = this.f3548j0;
            if (i2 < 0) {
                throw new IllegalArgumentException(D2.e.b("Bad id: ", i2));
            }
            wVarI.K(wVarI.new m(i2), false);
            this.f3548j0 = -1;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void q0(Bundle bundle) {
        Dialog dialog = this.f3551m0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i2 = this.f3544f0;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i4 = this.f3545g0;
        if (i4 != 0) {
            bundle.putInt("android:theme", i4);
        }
        boolean z4 = this.f3546h0;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f3547i0;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i5 = this.f3548j0;
        if (i5 != -1) {
            bundle.putInt("android:backStackId", i5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        Dialog dialog = this.f3551m0;
        if (dialog != null) {
            this.f3552n0 = false;
            dialog.show();
            View decorView = this.f3551m0.getWindow().getDecorView();
            C0384b.u(decorView, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void s0() {
        super.s0();
        Dialog dialog = this.f3551m0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    final O.d u() {
        return new d(new Fragment.a());
    }

    @Override // androidx.fragment.app.Fragment
    public final void u0(Bundle bundle) {
        Bundle bundle2;
        super.u0(bundle);
        if (this.f3551m0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3551m0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    final void y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.y0(layoutInflater, viewGroup, bundle);
        if (this.f3418O != null || this.f3551m0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3551m0.onRestoreInstanceState(bundle2);
    }
}
