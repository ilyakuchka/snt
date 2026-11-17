package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.e;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.l;

/* loaded from: classes.dex */
final class g implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, l.a {

    /* renamed from: i, reason: collision with root package name */
    private f f2562i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.appcompat.app.e f2563j;

    /* renamed from: k, reason: collision with root package name */
    d f2564k;

    public g(f fVar) {
        this.f2562i = fVar;
    }

    @Override // androidx.appcompat.view.menu.l.a
    public final void a(f fVar, boolean z4) {
        androidx.appcompat.app.e eVar;
        if ((z4 || fVar == this.f2562i) && (eVar = this.f2563j) != null) {
            eVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.l.a
    public final boolean b(f fVar) {
        return false;
    }

    public final void c() {
        f fVar = this.f2562i;
        e.a aVar = new e.a(fVar.n());
        d dVar = new d(aVar.b());
        this.f2564k = dVar;
        dVar.d(this);
        this.f2562i.b(this.f2564k);
        aVar.c(this.f2564k.f(), this);
        View view = fVar.f2554o;
        if (view != null) {
            aVar.d(view);
        } else {
            aVar.e(fVar.f2553n);
            aVar.m(fVar.f2552m);
        }
        aVar.i(this);
        androidx.appcompat.app.e eVarA = aVar.a();
        this.f2563j = eVarA;
        eVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f2563j.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        this.f2563j.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f2562i.y(((d.a) this.f2564k.f()).getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f2564k.a(this.f2562i, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f2563j.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f2563j.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f2562i.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f2562i.performShortcut(i2, keyEvent, 0);
    }
}
