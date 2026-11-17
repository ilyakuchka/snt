package C;

import C.f;
import C.j;
import android.os.Handler;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final j.c f21a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f22b;

    c(j.c cVar, Handler handler) {
        this.f21a = cVar;
        this.f22b = handler;
    }

    final void a(f.b bVar) {
        int i2 = bVar.f35b;
        if (!(i2 == 0)) {
            this.f22b.post(new b(this.f21a, i2));
        } else {
            this.f22b.post(new a(this.f21a, bVar.f34a));
        }
    }
}
