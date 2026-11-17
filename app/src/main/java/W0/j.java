package W0;

import W0.e;
import f1.r;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class j implements e<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final r f1810a;

    public static final class a implements e.a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Z0.b f1811a;

        public a(Z0.b bVar) {
            this.f1811a = bVar;
        }

        @Override // W0.e.a
        public final Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // W0.e.a
        public final e<InputStream> b(InputStream inputStream) {
            return new j(inputStream, this.f1811a);
        }
    }

    public j(InputStream inputStream, Z0.b bVar) {
        r rVar = new r(inputStream, bVar);
        this.f1810a = rVar;
        rVar.mark(5242880);
    }

    @Override // W0.e
    public final void b() {
        this.f1810a.I();
    }

    public final void c() {
        this.f1810a.H();
    }

    @Override // W0.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final InputStream a() throws IOException {
        this.f1810a.reset();
        return this.f1810a;
    }
}
