package x0;

import android.net.Uri;
import com.android.mmt.util.O;

/* loaded from: classes.dex */
final class i implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Uri f8102i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f8103j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ String[] f8104k = null;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ j f8105l;

    i(j jVar, Uri uri, String str) {
        this.f8105l = jVar;
        this.f8102i = uri;
        this.f8103j = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f8105l;
        O.c(jVar.f8112c, jVar.f8111b, this.f8102i, this.f8103j, this.f8104k);
    }
}
