package P0;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.android.mmt.R;
import com.android.mmt.ui.P;
import com.android.mmt.util.C0287t;
import java.util.ArrayList;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private miuix.appcompat.app.g f966a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f967b;

    public z(Activity activity) {
        this.f967b = activity;
        if (((LayoutInflater) activity.getSystemService("layout_inflater")) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String strK = C0287t.k(0);
        if (!TextUtils.isEmpty(strK)) {
            H0.a aVar = new H0.a();
            aVar.f258c = strK;
            aVar.f257b = C0287t.n(0);
            aVar.f256a = 0;
            arrayList.add(aVar);
        }
        String strK2 = C0287t.k(1);
        if (!TextUtils.isEmpty(strK2)) {
            H0.a aVar2 = new H0.a();
            aVar2.f258c = strK2;
            aVar2.f257b = C0287t.n(1);
            aVar2.f256a = 1;
            arrayList.add(aVar2);
        }
        v vVar = new v(this.f967b, arrayList);
        g.a aVar3 = new g.a(this.f967b);
        aVar3.x(R.string.select_message_send_sim);
        aVar3.m(android.R.string.cancel, new x(this));
        aVar3.p(new w(this));
        aVar3.b(vVar, new y(this, vVar));
        miuix.appcompat.app.g gVarA = aVar3.a();
        this.f966a = gVarA;
        gVarA.setCanceledOnTouchOutside(true);
    }

    static void a(z zVar, int i2) {
        zVar.b();
        ((P) zVar.f967b).f1(i2);
    }

    public final void b() {
        miuix.appcompat.app.g gVar;
        Activity activity = this.f967b;
        if (activity == null || activity.isDestroyed() || this.f967b.isFinishing() || (gVar = this.f966a) == null) {
            return;
        }
        gVar.dismiss();
        this.f966a = null;
    }

    public final boolean c() {
        miuix.appcompat.app.g gVar = this.f966a;
        return gVar != null && gVar.isShowing();
    }

    public final void d() {
        this.f966a.show();
    }
}
