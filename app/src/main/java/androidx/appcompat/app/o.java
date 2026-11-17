package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.android.mmt.R;
import h.InterfaceC0329a;

/* loaded from: classes.dex */
public class o extends Dialog implements InterfaceC0329a {

    /* renamed from: i, reason: collision with root package name */
    private i f2407i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.core.view.f f2408j;

    final class a implements androidx.core.view.f {
        a() {
        }

        public final boolean a(KeyEvent keyEvent) {
            return o.this.d(keyEvent);
        }
    }

    public o(Context context, int i2) {
        super(context, c(context, i2));
        this.f2408j = new a();
        i iVarA = a();
        iVarA.z(c(context, i2));
        iVarA.m();
    }

    private static int c(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final i a() {
        if (this.f2407i == null) {
            int i2 = i.f2327k;
            this.f2407i = new j(this, this);
        }
        return this.f2407i;
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    @Override // h.InterfaceC0329a
    public final void b() {
    }

    final boolean d(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        a().n();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        androidx.core.view.f fVar = this.f2408j;
        if (fVar == null) {
            return false;
        }
        return ((a) fVar).a(keyEvent);
    }

    @Override // android.app.Dialog
    public final <T extends View> T findViewById(int i2) {
        return (T) a().f(i2);
    }

    @Override // h.InterfaceC0329a
    public final void h() {
    }

    @Override // h.InterfaceC0329a
    public final void i() {
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        a().k();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        a().j();
        super.onCreate(bundle);
        a().m();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().s();
    }

    @Override // android.app.Dialog
    public final void setContentView(int i2) {
        a().w(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().A(charSequence);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        a().x(view);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().y(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        a().A(getContext().getString(i2));
    }
}
