package S3;

import T3.h;
import java.io.IOException;

/* loaded from: classes.dex */
public final class h extends O3.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ f f1458e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f1459f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String str, f fVar, l lVar) {
        super(str, true);
        this.f1458e = fVar;
        this.f1459f = lVar;
    }

    @Override // O3.a
    public final long f() {
        try {
            this.f1458e.x0().b(this.f1459f);
            return -1L;
        } catch (IOException e2) {
            h.a aVar = T3.h.f1639a;
            T3.h.f1640b.i(f3.c.h("Http2Connection.Listener failure for ", this.f1458e.v0()), 4, e2);
            try {
                this.f1459f.d(b.PROTOCOL_ERROR, e2);
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }
}
