package d1;

import V0.g;
import V0.h;
import W0.i;
import c1.m;
import c1.n;
import c1.o;
import c1.r;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class a implements n<c1.f, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    public static final g<Integer> f6139b = g.d("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    private final m<c1.f, c1.f> f6140a;

    /* renamed from: d1.a$a, reason: collision with other inner class name */
    public static class C0109a implements o<c1.f, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final m<c1.f, c1.f> f6141a = new m<>();

        @Override // c1.o
        public final n<c1.f, InputStream> a(r rVar) {
            return new a(this.f6141a);
        }
    }

    public a(m<c1.f, c1.f> mVar) {
        this.f6140a = mVar;
    }

    @Override // c1.n
    public final n.a<InputStream> a(c1.f fVar, int i2, int i4, h hVar) {
        c1.f fVar2 = fVar;
        m<c1.f, c1.f> mVar = this.f6140a;
        if (mVar != null) {
            c1.f fVar3 = (c1.f) mVar.a(fVar2);
            if (fVar3 == null) {
                this.f6140a.b(fVar2, fVar2);
            } else {
                fVar2 = fVar3;
            }
        }
        return new n.a<>(fVar2, new i(fVar2, ((Integer) hVar.c(f6139b)).intValue()));
    }

    @Override // c1.n
    public final /* bridge */ /* synthetic */ boolean b(c1.f fVar) {
        return true;
    }
}
