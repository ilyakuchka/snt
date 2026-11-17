package f1;

import Y0.x;
import android.graphics.Bitmap;
import f1.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class s implements V0.j<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final k f6224a;

    /* renamed from: b, reason: collision with root package name */
    private final Z0.b f6225b;

    static class a implements k.b {

        /* renamed from: a, reason: collision with root package name */
        private final r f6226a;

        /* renamed from: b, reason: collision with root package name */
        private final s1.d f6227b;

        a(r rVar, s1.d dVar) {
            this.f6226a = rVar;
            this.f6227b = dVar;
        }

        @Override // f1.k.b
        public final void a(Z0.d dVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionF = this.f6227b.f();
            if (iOExceptionF != null) {
                if (bitmap == null) {
                    throw iOExceptionF;
                }
                dVar.e(bitmap);
                throw iOExceptionF;
            }
        }

        @Override // f1.k.b
        public final void b() {
            this.f6226a.H();
        }
    }

    public s(k kVar, Z0.b bVar) {
        this.f6224a = kVar;
        this.f6225b = bVar;
    }

    @Override // V0.j
    public final boolean a(InputStream inputStream, V0.h hVar) throws IOException {
        Objects.requireNonNull(this.f6224a);
        return true;
    }

    @Override // V0.j
    public final x<Bitmap> b(InputStream inputStream, int i2, int i4, V0.h hVar) throws IOException {
        boolean z4;
        r rVar;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof r) {
            rVar = (r) inputStream2;
            z4 = false;
        } else {
            z4 = true;
            rVar = new r(inputStream2, this.f6225b);
        }
        s1.d dVarH = s1.d.H(rVar);
        try {
            return this.f6224a.d(new s1.h(dVarH), i2, i4, hVar, new a(rVar, dVarH));
        } finally {
            dVarH.I();
            if (z4) {
                rVar.I();
            }
        }
    }
}
