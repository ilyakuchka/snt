package P0;

import android.app.Activity;
import android.view.LayoutInflater;
import com.android.mmt.R;
import com.android.mmt.ui.P;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    private miuix.appcompat.app.g f902a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f903b;

    public K(Activity activity) {
        this.f903b = activity;
        if (((LayoutInflater) activity.getSystemService("layout_inflater")) == null) {
            return;
        }
        v vVar = new v(this.f903b, null);
        g.a aVar = new g.a(this.f903b);
        aVar.x(R.string.select_message_send_sim);
        aVar.m(android.R.string.cancel, new I(this));
        aVar.p(new H(this));
        aVar.b(vVar, new J(this, vVar));
        miuix.appcompat.app.g gVarA = aVar.a();
        this.f902a = gVarA;
        gVarA.setCanceledOnTouchOutside(true);
    }

    static void a(K k2, int i2) {
        k2.b();
        ((P) k2.f903b).f1(i2);
    }

    public final void b() {
        miuix.appcompat.app.g gVar;
        Activity activity = this.f903b;
        if (activity == null || activity.isDestroyed() || this.f903b.isFinishing() || (gVar = this.f902a) == null) {
            return;
        }
        gVar.dismiss();
        this.f902a = null;
    }

    public final boolean c() {
        miuix.appcompat.app.g gVar = this.f902a;
        return gVar != null && gVar.isShowing();
    }

    public final void d() {
        this.f902a.show();
    }
}
