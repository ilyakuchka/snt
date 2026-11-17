package c1;

import W0.d;
import c1.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b<Data> implements n<byte[], Data> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0084b<Data> f4385a;

    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: c1.b$a$a, reason: collision with other inner class name */
        final class C0083a implements InterfaceC0084b<ByteBuffer> {
            C0083a() {
            }

            @Override // c1.b.InterfaceC0084b
            public final Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // c1.b.InterfaceC0084b
            public final ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // c1.o
        public final n<byte[], ByteBuffer> a(r rVar) {
            return new b(new C0083a());
        }
    }

    /* renamed from: c1.b$b, reason: collision with other inner class name */
    public interface InterfaceC0084b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    private static class c<Data> implements W0.d<Data> {

        /* renamed from: i, reason: collision with root package name */
        private final byte[] f4386i;

        /* renamed from: j, reason: collision with root package name */
        private final InterfaceC0084b<Data> f4387j;

        c(byte[] bArr, InterfaceC0084b<Data> interfaceC0084b) {
            this.f4386i = bArr;
            this.f4387j = interfaceC0084b;
        }

        @Override // W0.d
        public final Class<Data> a() {
            return this.f4387j.a();
        }

        @Override // W0.d
        public final void b() {
        }

        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super Data> aVar) {
            aVar.f(this.f4387j.b(this.f4386i));
        }

        @Override // W0.d
        public final void cancel() {
        }

        @Override // W0.d
        public final V0.a d() {
            return V0.a.f1747i;
        }
    }

    public static class d implements o<byte[], InputStream> {

        final class a implements InterfaceC0084b<InputStream> {
            a() {
            }

            @Override // c1.b.InterfaceC0084b
            public final Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // c1.b.InterfaceC0084b
            public final InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // c1.o
        public final n<byte[], InputStream> a(r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0084b<Data> interfaceC0084b) {
        this.f4385a = interfaceC0084b;
    }

    @Override // c1.n
    public final n.a a(byte[] bArr, int i2, int i4, V0.h hVar) {
        byte[] bArr2 = bArr;
        return new n.a(new r1.b(bArr2), new c(bArr2, this.f4385a));
    }

    @Override // c1.n
    public final /* bridge */ /* synthetic */ boolean b(byte[] bArr) {
        return true;
    }
}
