package G3;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.preference.DialogPreference;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private c f209a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.preference.b f210b;

    public f(c cVar, androidx.preference.b bVar) {
        this.f209a = cVar;
        this.f210b = bVar;
    }

    public final Dialog a() {
        Context contextB = this.f210b.B();
        DialogPreference dialogPreferenceI1 = this.f210b.i1();
        g.a aVar = new g.a(contextB);
        a aVar2 = new a(contextB, aVar);
        aVar2.m(dialogPreferenceI1.z0());
        aVar2.e(dialogPreferenceI1.w0());
        aVar2.j(dialogPreferenceI1.B0(), this.f210b);
        aVar2.h(dialogPreferenceI1.A0(), this.f210b);
        View viewB = this.f209a.b(contextB);
        if (viewB != null) {
            this.f209a.c(viewB);
            aVar2.n(viewB);
        } else {
            aVar2.f(dialogPreferenceI1.y0());
        }
        this.f209a.a(aVar);
        miuix.appcompat.app.g gVarA = aVar.a();
        if (this.f209a.d()) {
            gVarA.getWindow().setSoftInputMode(5);
        }
        return gVarA;
    }
}
