package c1;

import W0.d;
import android.util.Base64;
import c1.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final a<Data> f4389a;

    public interface a<Data> {
    }

    private static final class b<Data> implements W0.d<Data> {

        /* renamed from: i, reason: collision with root package name */
        private final String f4390i;

        /* renamed from: j, reason: collision with root package name */
        private final a<Data> f4391j;

        /* renamed from: k, reason: collision with root package name */
        /* JADX INFO: Incorrect field signature: TData; */
        private ByteArrayInputStream f4392k;

        b(String str, a<Data> aVar) {
            this.f4390i = str;
            this.f4391j = aVar;
        }

        @Override // W0.d
        public final Class<Data> a() {
            Objects.requireNonNull((c.a) this.f4391j);
            return InputStream.class;
        }

        @Override // W0.d
        public final void b() throws IOException {
            try {
                a<Data> aVar = this.f4391j;
                ByteArrayInputStream byteArrayInputStream = this.f4392k;
                Objects.requireNonNull((c.a) aVar);
                byteArrayInputStream.close();
            } catch (IOException unused) {
            }
        }

        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super Data> aVar) {
            try {
                Object objA = ((c.a) this.f4391j).a(this.f4390i);
                this.f4392k = (ByteArrayInputStream) objA;
                aVar.f(objA);
            } catch (IllegalArgumentException e2) {
                aVar.e(e2);
            }
        }

        @Override // W0.d
        public final void cancel() {
        }

        @Override // W0.d
        public final V0.a d() {
            return V0.a.f1747i;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final a<InputStream> f4393a = new a();

        final class a implements a<InputStream> {
            a() {
            }

            public final Object a(String str) throws IllegalArgumentException {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // c1.o
        public final n<Model, InputStream> a(r rVar) {
            return new d(this.f4393a);
        }
    }

    public d(a<Data> aVar) {
        this.f4389a = aVar;
    }

    @Override // c1.n
    public final n.a<Data> a(Model model, int i2, int i4, V0.h hVar) {
        return new n.a<>(new r1.b(model), new b(model.toString(), this.f4389a));
    }

    @Override // c1.n
    public final boolean b(Model model) {
        return model.toString().startsWith("data:image");
    }
}
