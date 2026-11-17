package Y0;

import Y0.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class v<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final E.b<List<Throwable>> f2059a;

    /* renamed from: b, reason: collision with root package name */
    private final List<? extends k<Data, ResourceType, Transcode>> f2060b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2061c;

    public v(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<k<Data, ResourceType, Transcode>> list, E.b<List<Throwable>> bVar) {
        this.f2059a = bVar;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f2060b = list;
        StringBuilder sbD = D2.e.d("Failed LoadPath{");
        sbD.append(cls.getSimpleName());
        sbD.append("->");
        sbD.append(cls2.getSimpleName());
        sbD.append("->");
        sbD.append(cls3.getSimpleName());
        sbD.append("}");
        this.f2061c = sbD.toString();
    }

    public final x<Transcode> a(W0.e<Data> eVar, V0.h hVar, int i2, int i4, k.a<ResourceType> aVar) throws s {
        List<Throwable> listB = this.f2059a.b();
        Objects.requireNonNull(listB, "Argument must not be null");
        List<Throwable> list = listB;
        try {
            int size = this.f2060b.size();
            x<Transcode> xVarA = null;
            for (int i5 = 0; i5 < size; i5++) {
                try {
                    xVarA = this.f2060b.get(i5).a(eVar, i2, i4, hVar, aVar);
                } catch (s e2) {
                    list.add(e2);
                }
                if (xVarA != null) {
                    break;
                }
            }
            if (xVarA != null) {
                return xVarA;
            }
            throw new s(this.f2061c, new ArrayList(list));
        } finally {
            this.f2059a.a(list);
        }
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("LoadPath{decodePaths=");
        sbD.append(Arrays.toString(this.f2060b.toArray()));
        sbD.append('}');
        return sbD.toString();
    }
}
