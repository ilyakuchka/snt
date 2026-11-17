package Y0;

import a1.a;
import java.io.File;

/* loaded from: classes.dex */
final class g<DataType> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final V0.d<DataType> f1924a;

    /* renamed from: b, reason: collision with root package name */
    private final DataType f1925b;

    /* renamed from: c, reason: collision with root package name */
    private final V0.h f1926c;

    g(V0.d<DataType> dVar, DataType datatype, V0.h hVar) {
        this.f1924a = dVar;
        this.f1925b = datatype;
        this.f1926c = hVar;
    }

    @Override // a1.a.b
    public final boolean a(File file) {
        return this.f1924a.b(this.f1925b, file, this.f1926c);
    }
}
