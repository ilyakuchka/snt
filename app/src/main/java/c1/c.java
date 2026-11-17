package c1;

import W0.d;
import android.util.Log;
import c1.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c implements n<File, ByteBuffer> {

    private static final class a implements W0.d<ByteBuffer> {

        /* renamed from: i, reason: collision with root package name */
        private final File f4388i;

        a(File file) {
            this.f4388i = file;
        }

        @Override // W0.d
        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // W0.d
        public final void b() {
        }

        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.f(s1.a.a(this.f4388i));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
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

    public static class b implements o<File, ByteBuffer> {
        @Override // c1.o
        public final n<File, ByteBuffer> a(r rVar) {
            return new c();
        }
    }

    @Override // c1.n
    public final n.a<ByteBuffer> a(File file, int i2, int i4, V0.h hVar) {
        File file2 = file;
        return new n.a<>(new r1.b(file2), new a(file2));
    }

    @Override // c1.n
    public final /* bridge */ /* synthetic */ boolean b(File file) {
        return true;
    }
}
