package miuix.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.Objects;

/* loaded from: classes.dex */
public class j extends Fragment implements l {

    /* renamed from: c0, reason: collision with root package name */
    private k f6696c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f6697d0 = true;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f6698e0 = true;

    @Override // androidx.fragment.app.Fragment
    public final View T() {
        k kVar = this.f6696c0;
        if (kVar == null) {
            return null;
        }
        return kVar.z();
    }

    @Override // androidx.fragment.app.Fragment
    public final void T0() {
        super.T0();
        if (!this.f6697d0) {
            this.f6697d0 = true;
            k kVar = this.f6696c0;
            if (kVar == null || kVar.l() || X() || !W()) {
                return;
            }
            this.f6696c0.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void U0(boolean z4) {
        k kVar;
        super.U0(z4);
        if (this.f6698e0 != z4) {
            this.f6698e0 = z4;
            if (X() || !W() || (kVar = this.f6696c0) == null) {
                return;
            }
            kVar.b();
        }
    }

    public final h c1() {
        return this.f6696c0.f6668i;
    }

    public final void d1() {
        this.f6696c0.E();
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        super.e0(bundle);
        k kVar = new k(this);
        this.f6696c0 = kVar;
        Objects.requireNonNull(kVar);
    }

    @Override // miuix.appcompat.app.l
    public final boolean g(Menu menu) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f6696c0.B(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void h0() {
        super.h0();
        this.f6696c0.f();
    }

    @Override // miuix.appcompat.app.l
    public final Context i() {
        return this.f6696c0.i();
    }

    @Override // androidx.fragment.app.Fragment
    public void i0() {
        super.i0();
        this.f6696c0.C();
    }

    @Override // androidx.fragment.app.Fragment
    public final void l0(boolean z4) {
        k kVar;
        if (z4 || (kVar = this.f6696c0) == null) {
            return;
        }
        kVar.b();
    }

    public View o(LayoutInflater layoutInflater) {
        return null;
    }

    @Override // miuix.appcompat.app.l
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f6696c0.f6671l = null;
    }

    @Override // miuix.appcompat.app.l
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f6696c0.f6671l = actionMode;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        miuix.appcompat.internal.app.widget.d dVar;
        super.onConfigurationChanged(configuration);
        k kVar = this.f6696c0;
        if (kVar.f6674o && kVar.f6672m && (dVar = (miuix.appcompat.internal.app.widget.d) kVar.g()) != null) {
            dVar.L();
        }
    }

    @Override // miuix.appcompat.app.l
    public final boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f6697d0 && !this.f6696c0.l() && this.f6698e0 && !X() && W();
    }

    @Override // androidx.fragment.app.Fragment
    public final void p0() {
        super.p0();
        k kVar = this.f6696c0;
        if (kVar.f6674o && kVar.f6672m) {
        }
    }

    @Override // miuix.appcompat.app.l
    public final void s() {
        if (this.f6697d0) {
            Objects.requireNonNull(this.f6696c0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void s0() {
        miuix.appcompat.internal.app.widget.d dVar;
        super.s0();
        k kVar = this.f6696c0;
        kVar.f();
        if (kVar.f6674o && kVar.f6672m && (dVar = (miuix.appcompat.internal.app.widget.d) kVar.g()) != null) {
            dVar.O(false);
        }
    }
}
