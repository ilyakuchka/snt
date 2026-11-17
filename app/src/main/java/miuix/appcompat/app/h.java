package miuix.appcompat.app;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ActivityC0219o;
import java.util.Objects;
import miuix.appcompat.internal.app.widget.ActionBarView;

@SuppressLint({"MissingSuperCall"})
/* loaded from: classes.dex */
public class h extends ActivityC0219o {
    private i u = new i(this, new a());

    /* JADX INFO: Access modifiers changed from: private */
    class a implements e {
        a() {
        }

        public final boolean a(int i2, Menu menu) {
            return h.super.onCreatePanelMenu(i2, menu);
        }

        public final boolean b(int i2, View view, Menu menu) {
            return h.super.onPreparePanel(i2, view, menu);
        }
    }

    public final b K() {
        return this.u.g();
    }

    public final int L() {
        return this.u.w();
    }

    public final void M() {
        this.u.L();
    }

    public final void N() {
        this.u.q(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.u.v(view, layoutParams);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        return this.u.h();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        this.u.b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.u.f6671l = null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.u.f6671l = actionMode;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.u.y();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.u.z(configuration);
    }

    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.u.A(bundle);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.u.B(i2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        return this.u.C(i2);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.u.n(i2, menuItem);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected void onPostResume() {
        this.u.D();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.u.E(i2, view, menu);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        this.u.F(bundle);
    }

    @Override // androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.u.G(bundle);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected void onStop() {
        this.u.H();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        ActionBarView actionBarView = this.u.f6669j;
        if (actionBarView != null) {
            actionBarView.I0(charSequence);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        i iVar = this.u;
        Objects.requireNonNull(iVar);
        if (i2 == 0) {
            return iVar.I(callback);
        }
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i2) {
        this.u.J(i2);
    }

    @Override // android.app.Activity
    public final ActionMode startActionMode(ActionMode.Callback callback) {
        return this.u.M(callback);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view) {
        i iVar = this.u;
        Objects.requireNonNull(iVar);
        iVar.K(view, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        i iVar = this.u;
        if (iVar.g() != null) {
            return ((miuix.appcompat.internal.app.widget.d) iVar.g()).P(callback);
        }
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.u.K(view, layoutParams);
    }
}
