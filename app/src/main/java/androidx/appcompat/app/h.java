package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.X;
import androidx.fragment.app.ActivityC0219o;
import h.InterfaceC0329a;
import t.C0384b;
import v.C0394a;
import v.C0396c;
import v.m;

/* loaded from: classes.dex */
public final class h extends ActivityC0219o implements InterfaceC0329a, m.a {
    private i u;

    public h() {
        e().d("androidx:appcompat", new f(this));
        o(new g(this));
    }

    private void s() {
        C0384b.u(getWindow().getDecorView(), this);
        C0384b.v(getWindow().getDecorView(), this);
        C0384b.w(getWindow().getDecorView(), this);
    }

    public final a A() {
        return z().i();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        z().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected final void attachBaseContext(Context context) {
        super.attachBaseContext(z().e(context));
    }

    @Override // h.InterfaceC0329a
    public final void b() {
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        A();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // v.ActivityC0395b, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        A();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final <T extends View> T findViewById(int i2) {
        return (T) z().f(i2);
    }

    @Override // v.m.a
    public final Intent g() {
        return C0396c.a(this);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        return z().h();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i2 = X.f2969a;
        return super.getResources();
    }

    @Override // h.InterfaceC0329a
    public final void h() {
    }

    @Override // h.InterfaceC0329a
    public final void i() {
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        z().k();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        z().l(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        super.onDestroy();
        z().n();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        Intent intentA;
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a aVarA = A();
        if (menuItem.getItemId() == 16908332 && aVarA != null && (aVarA.a() & 4) != 0 && (intentA = C0396c.a(this)) != null) {
            if (!shouldUpRecreateTask(intentA)) {
                navigateUpTo(intentA);
                return true;
            }
            v.m mVarG = v.m.g(this);
            mVarG.d(this);
            mVarG.h();
            try {
                int i4 = C0394a.f7922c;
                finishAffinity();
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        z().o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        z().p();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStart() {
        super.onStart();
        z().r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onStop() {
        super.onStop();
        z().s();
    }

    @Override // android.app.Activity
    protected final void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        z().A(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        A();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i2) {
        s();
        z().w(i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        super.setTheme(i2);
        z().z(i2);
    }

    @Override // androidx.fragment.app.ActivityC0219o
    public final void y() {
        z().k();
    }

    public final i z() {
        if (this.u == null) {
            int i2 = i.f2327k;
            this.u = new j(this, this);
        }
        return this.u;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view) {
        s();
        z().x(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        z().y(view, layoutParams);
    }
}
