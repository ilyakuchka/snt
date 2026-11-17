package x0;

import com.android.mmt.MmsApp;
import x0.C0416c;

/* loaded from: classes.dex */
final class h implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0416c f8099i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f8100j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ j f8101k;

    h(j jVar, C0416c c0416c, String str) {
        this.f8101k = jVar;
        this.f8099i = c0416c;
        this.f8100j = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MmsApp.g(true);
            long jQ = this.f8099i.q();
            j.b(this.f8101k, this.f8099i, this.f8100j);
            if (jQ != 0) {
                C0416c c0416c = this.f8099i;
                c0416c.i0();
                C0416c.d.e(c0416c);
            }
        } finally {
            MmsApp.g(false);
        }
    }
}
