package d1;

import V0.h;
import c1.n;
import c1.o;
import c1.r;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public final class f implements n<URL, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final n<c1.f, InputStream> f6163a;

    public static class a implements o<URL, InputStream> {
        @Override // c1.o
        public final n<URL, InputStream> a(r rVar) {
            return new f(rVar.c(c1.f.class, InputStream.class));
        }
    }

    public f(n<c1.f, InputStream> nVar) {
        this.f6163a = nVar;
    }

    @Override // c1.n
    public final n.a<InputStream> a(URL url, int i2, int i4, h hVar) {
        return this.f6163a.a(new c1.f(url), i2, i4, hVar);
    }

    @Override // c1.n
    public final /* bridge */ /* synthetic */ boolean b(URL url) {
        return true;
    }
}
