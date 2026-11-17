package X0;

import W0.d;
import W0.g;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class b implements W0.d<InputStream> {

    /* renamed from: i, reason: collision with root package name */
    private final Uri f1822i;

    /* renamed from: j, reason: collision with root package name */
    private final d f1823j;

    /* renamed from: k, reason: collision with root package name */
    private InputStream f1824k;

    static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f1825b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f1826a;

        a(ContentResolver contentResolver) {
            this.f1826a = contentResolver;
        }

        @Override // X0.c
        public final Cursor a(Uri uri) {
            return this.f1826a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f1825b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* renamed from: X0.b$b, reason: collision with other inner class name */
    static class C0046b implements c {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f1827b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f1828a;

        C0046b(ContentResolver contentResolver) {
            this.f1828a = contentResolver;
        }

        @Override // X0.c
        public final Cursor a(Uri uri) {
            return this.f1828a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f1827b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    b(Uri uri, d dVar) {
        this.f1822i = uri;
        this.f1823j = dVar;
    }

    private static b e(Context context, Uri uri, c cVar) {
        return new b(uri, new d(com.bumptech.glide.c.c(context).i().f(), cVar, com.bumptech.glide.c.c(context).d(), context.getContentResolver()));
    }

    public static b f(Context context, Uri uri) {
        return e(context, uri, new a(context.getContentResolver()));
    }

    public static b g(Context context, Uri uri) {
        return e(context, uri, new C0046b(context.getContentResolver()));
    }

    @Override // W0.d
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // W0.d
    public final void b() throws IOException {
        InputStream inputStream = this.f1824k;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // W0.d
    public final void c(f fVar, d.a<? super InputStream> aVar) throws Throwable {
        try {
            InputStream inputStreamB = this.f1823j.b(this.f1822i);
            int iA = inputStreamB != null ? this.f1823j.a(this.f1822i) : -1;
            if (iA != -1) {
                inputStreamB = new g(inputStreamB, iA);
            }
            this.f1824k = inputStreamB;
            aVar.f(inputStreamB);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
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
