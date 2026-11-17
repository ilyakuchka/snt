package Y0;

import Y0.j;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k<DataType, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<DataType> f1977a;

    /* renamed from: b, reason: collision with root package name */
    private final List<? extends V0.j<DataType, ResourceType>> f1978b;

    /* renamed from: c, reason: collision with root package name */
    private final k1.d<ResourceType, Transcode> f1979c;
    private final E.b<List<Throwable>> d;

    /* renamed from: e, reason: collision with root package name */
    private final String f1980e;

    interface a<ResourceType> {
    }

    public k(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends V0.j<DataType, ResourceType>> list, k1.d<ResourceType, Transcode> dVar, E.b<List<Throwable>> bVar) {
        this.f1977a = cls;
        this.f1978b = list;
        this.f1979c = dVar;
        this.d = bVar;
        StringBuilder sbD = D2.e.d("Failed DecodePath{");
        sbD.append(cls.getSimpleName());
        sbD.append("->");
        sbD.append(cls2.getSimpleName());
        sbD.append("->");
        sbD.append(cls3.getSimpleName());
        sbD.append("}");
        this.f1980e = sbD.toString();
    }

    private x<ResourceType> b(W0.e<DataType> eVar, int i2, int i4, V0.h hVar, List<Throwable> list) throws s {
        int size = this.f1978b.size();
        x<ResourceType> xVarB = null;
        for (int i5 = 0; i5 < size; i5++) {
            V0.j<DataType, ResourceType> jVar = this.f1978b.get(i5);
            try {
                if (jVar.a(eVar.a(), hVar)) {
                    xVarB = jVar.b(eVar.a(), i2, i4, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e2);
                }
                list.add(e2);
            }
            if (xVarB != null) {
                break;
            }
        }
        if (xVarB != null) {
            return xVarB;
        }
        throw new s(this.f1980e, new ArrayList(list));
    }

    public final x<Transcode> a(W0.e<DataType> eVar, int i2, int i4, V0.h hVar, a<ResourceType> aVar) throws s {
        List<Throwable> listB = this.d.b();
        Objects.requireNonNull(listB, "Argument must not be null");
        List<Throwable> list = listB;
        try {
            x<ResourceType> xVarB = b(eVar, i2, i4, hVar, list);
            this.d.a(list);
            return this.f1979c.d(((j.b) aVar).a(xVarB), hVar);
        } catch (Throwable th) {
            this.d.a(list);
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("DecodePath{ dataClass=");
        sbD.append(this.f1977a);
        sbD.append(", decoders=");
        sbD.append(this.f1978b);
        sbD.append(", transcoder=");
        sbD.append(this.f1979c);
        sbD.append('}');
        return sbD.toString();
    }
}
