package Q0;

import Q0.q;
import android.content.ContentUris;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import com.android.mmt.util.AbstractHandlerC0272d;
import java.util.Iterator;
import x0.C0416c;

/* loaded from: classes.dex */
final class u implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ q.j f1172i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ q.k f1173j;

    u(q.k kVar, q.j jVar) {
        this.f1173j = kVar;
        this.f1172i = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractHandlerC0272d abstractHandlerC0272d = this.f1173j.f1158j;
        q.j jVar = this.f1172i;
        boolean zS = q.this.f1138m0.S();
        Uri uri = C0416c.f8050r;
        String str = jVar.c() ? null : "locked=0";
        if (zS) {
            StringBuilder sbD = D2.e.d("thread_id IN (");
            sbD.append(TextUtils.join(",", jVar.d()));
            sbD.append(")");
            String string = sbD.toString();
            Iterator<Long> it = jVar.d().iterator();
            while (it.hasNext()) {
                h0.c.e().g(ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, it.next().longValue()));
            }
            abstractHandlerC0272d.e(1801, jVar, Telephony.Threads.CONTENT_URI, DatabaseUtils.concatenateWhere(string, str), null);
            return;
        }
        boolean z4 = jVar.d() != null && jVar.d().size() > 1;
        String[] strArr = new String[jVar.d().size()];
        for (int i2 = 0; i2 < jVar.d().size(); i2++) {
            strArr[i2] = jVar.d().get(i2) + "";
            h0.c.e().g(ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, jVar.d().get(i2).longValue()));
        }
        abstractHandlerC0272d.e(1801, jVar, z4 ? Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("multidelete", "true").build() : ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, jVar.d().get(0).longValue()), str, z4 ? strArr : null);
    }
}
