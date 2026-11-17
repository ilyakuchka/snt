package v;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.view.o;
import androidx.lifecycle.t;

/* renamed from: v.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ActivityC0395b extends Activity implements androidx.lifecycle.k, androidx.core.view.f {

    /* renamed from: i, reason: collision with root package name */
    private androidx.lifecycle.l f7923i = new androidx.lifecycle.l(this);

    public androidx.lifecycle.g a() {
        return this.f7923i;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            int i2 = o.d;
        }
        return k(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            int i2 = o.d;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public final boolean k(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t.b(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f7923i.g();
        super.onSaveInstanceState(bundle);
    }
}
