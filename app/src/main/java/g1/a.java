package g1;

import W0.e;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a implements e<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f6299a;

    /* renamed from: g1.a$a, reason: collision with other inner class name */
    public static class C0110a implements e.a<ByteBuffer> {
        @Override // W0.e.a
        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // W0.e.a
        public final e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f6299a = byteBuffer;
    }

    @Override // W0.e
    public final ByteBuffer a() throws IOException {
        this.f6299a.position(0);
        return this.f6299a;
    }

    @Override // W0.e
    public final void b() {
    }
}
