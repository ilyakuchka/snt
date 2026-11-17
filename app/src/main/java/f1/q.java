package f1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
interface q {

    public static final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        private final W0.j f6212a;

        /* renamed from: b, reason: collision with root package name */
        private final Z0.b f6213b;

        /* renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f6214c;

        a(InputStream inputStream, List<ImageHeaderParser> list, Z0.b bVar) {
            Objects.requireNonNull(bVar, "Argument must not be null");
            this.f6213b = bVar;
            Objects.requireNonNull(list, "Argument must not be null");
            this.f6214c = list;
            this.f6212a = new W0.j(inputStream, bVar);
        }

        @Override // f1.q
        public final Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f6212a.a(), null, options);
        }

        @Override // f1.q
        public final ImageHeaderParser.ImageType b() throws IOException {
            return com.bumptech.glide.load.a.e(this.f6214c, this.f6212a.a(), this.f6213b);
        }

        @Override // f1.q
        public final void c() {
            this.f6212a.c();
        }

        @Override // f1.q
        public final int d() throws IOException {
            return com.bumptech.glide.load.a.b(this.f6214c, this.f6212a.a(), this.f6213b);
        }
    }

    public static final class b implements q {

        /* renamed from: a, reason: collision with root package name */
        private final Z0.b f6215a;

        /* renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f6216b;

        /* renamed from: c, reason: collision with root package name */
        private final W0.l f6217c;

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, Z0.b bVar) {
            Objects.requireNonNull(bVar, "Argument must not be null");
            this.f6215a = bVar;
            Objects.requireNonNull(list, "Argument must not be null");
            this.f6216b = list;
            this.f6217c = new W0.l(parcelFileDescriptor);
        }

        @Override // f1.q
        public final Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f6217c.a().getFileDescriptor(), null, options);
        }

        @Override // f1.q
        public final ImageHeaderParser.ImageType b() throws IOException {
            return com.bumptech.glide.load.a.d(this.f6216b, this.f6217c, this.f6215a);
        }

        @Override // f1.q
        public final void c() {
        }

        @Override // f1.q
        public final int d() throws IOException {
            return com.bumptech.glide.load.a.a(this.f6216b, this.f6217c, this.f6215a);
        }
    }

    Bitmap a(BitmapFactory.Options options) throws IOException;

    ImageHeaderParser.ImageType b() throws IOException;

    void c();

    int d() throws IOException;
}
