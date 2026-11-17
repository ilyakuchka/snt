package x0;

import android.content.ContentValues;
import android.net.Uri;
import com.android.mmt.MmsApp;
import com.android.mmt.util.O;
import g0.C0319o;
import g0.t;

/* loaded from: classes.dex */
final class g implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0416c f8096i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f8097j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ j f8098k;

    g(j jVar, C0416c c0416c, boolean z4) {
        this.f8098k = jVar;
        this.f8096i = c0416c;
        this.f8097j = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MmsApp.g(true);
            C0319o c0319oE = C0319o.e(this.f8098k.f8112c);
            t tVarL = j.L(this.f8096i, this.f8098k.f8117j);
            j jVar = this.f8098k;
            Uri uri = jVar.f8116i;
            if (uri == null) {
                jVar.f8116i = jVar.q(c0319oE, tVarL, jVar.f8115h, -1);
            } else {
                jVar.j0(uri, c0319oE, jVar.f8115h, tVarL, -1);
            }
            if (this.f8097j && this.f8096i.C() == 0) {
                this.f8096i.k();
            }
            j jVar2 = this.f8098k;
            long jQ = this.f8096i.q();
            if (jVar2.f8116i != null && jQ >= 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("thread_id", Long.valueOf(jQ));
                O.g(jVar2.f8112c, jVar2.f8111b, jVar2.f8116i, contentValues, null, null);
            }
            this.f8096i.Z(true);
            this.f8098k.l(this.f8096i);
            D0.b.a(this.f8098k.f8114f.I(), 1, this.f8098k.f8116i);
        } finally {
            MmsApp.g(false);
        }
    }
}
