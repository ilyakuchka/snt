package c1;

import W0.d;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c1.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class e<Data> implements n<File, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final d<Data> f4394a;

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final d<Data> f4395a;

        public a(d<Data> dVar) {
            this.f4395a = dVar;
        }

        @Override // c1.o
        public final n<File, Data> a(r rVar) {
            return new e(this.f4395a);
        }
    }

    public static class b extends a<ParcelFileDescriptor> {

        final class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // c1.e.d
            public final Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // c1.e.d
            public final ParcelFileDescriptor b(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // c1.e.d
            public final void c(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }
        }

        public b() {
            super(new a());
        }
    }

    private static final class c<Data> implements W0.d<Data> {

        /* renamed from: i, reason: collision with root package name */
        private final File f4396i;

        /* renamed from: j, reason: collision with root package name */
        private final d<Data> f4397j;

        /* renamed from: k, reason: collision with root package name */
        private Data f4398k;

        c(File file, d<Data> dVar) {
            this.f4396i = file;
            this.f4397j = dVar;
        }

        @Override // W0.d
        public final Class<Data> a() {
            return this.f4397j.a();
        }

        @Override // W0.d
        public final void b() {
            Data data = this.f4398k;
            if (data != null) {
                try {
                    this.f4397j.c(data);
                } catch (IOException unused) {
                }
            }
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [Data, java.lang.Object] */
        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super Data> aVar) {
            try {
                Data dataB = this.f4397j.b(this.f4396i);
                this.f4398k = dataB;
                aVar.f(dataB);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
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

    public interface d<Data> {
        Class<Data> a();

        Data b(File file) throws FileNotFoundException;

        void c(Data data) throws IOException;
    }

    /* renamed from: c1.e$e, reason: collision with other inner class name */
    public static class C0085e extends a<InputStream> {

        /* renamed from: c1.e$e$a */
        final class a implements d<InputStream> {
            a() {
            }

            @Override // c1.e.d
            public final Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // c1.e.d
            public final InputStream b(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // c1.e.d
            public final void c(InputStream inputStream) throws IOException {
                inputStream.close();
            }
        }

        public C0085e() {
            super(new a());
        }
    }

    public e(d<Data> dVar) {
        this.f4394a = dVar;
    }

    @Override // c1.n
    public final n.a a(File file, int i2, int i4, V0.h hVar) {
        File file2 = file;
        return new n.a(new r1.b(file2), new c(file2, this.f4394a));
    }

    @Override // c1.n
    public final /* bridge */ /* synthetic */ boolean b(File file) {
        return true;
    }
}
