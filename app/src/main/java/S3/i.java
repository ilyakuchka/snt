package S3;

import S3.f;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i extends O3.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ f.d f1460e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f1461f = false;
    final /* synthetic */ q g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, f.d dVar, q qVar) {
        super(str, true);
        this.f1460e = dVar;
        this.g = qVar;
    }

    @Override // O3.a
    public final long f() {
        long jC;
        int i2;
        l[] lVarArr;
        f.d dVar = this.f1460e;
        boolean z4 = this.f1461f;
        q qVar = this.g;
        Objects.requireNonNull(dVar);
        f3.c.d(qVar, "settings");
        f3.e eVar = new f3.e();
        m mVarE0 = dVar.f1437j.E0();
        f fVar = dVar.f1437j;
        synchronized (mVarE0) {
            synchronized (fVar) {
                q qVarA0 = fVar.A0();
                if (!z4) {
                    q qVar2 = new q();
                    qVar2.g(qVarA0);
                    qVar2.g(qVar);
                    qVar = qVar2;
                }
                eVar.f6243i = qVar;
                jC = qVar.c() - qVarA0.c();
                i2 = 0;
                if (jC == 0 || fVar.C0().isEmpty()) {
                    lVarArr = null;
                } else {
                    Object[] array = ((LinkedHashMap) fVar.C0()).values().toArray(new l[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                    lVarArr = (l[]) array;
                }
                fVar.P0(eVar.f6243i);
                fVar.f1421s.i(new g(f3.c.h(fVar.v0(), " onSettings"), fVar, eVar), 0L);
            }
            try {
                fVar.E0().f(eVar.f6243i);
            } catch (IOException e2) {
                b bVar = b.PROTOCOL_ERROR;
                fVar.t0(bVar, bVar, e2);
            }
        }
        if (lVarArr == null) {
            return -1L;
        }
        int length = lVarArr.length;
        while (i2 < length) {
            l lVar = lVarArr[i2];
            i2++;
            synchronized (lVar) {
                lVar.a(jC);
            }
        }
        return -1L;
    }
}
