package c1;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c1.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class w<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f4454b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a, reason: collision with root package name */
    private final c<Data> f4455a;

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4456a;

        public a(ContentResolver contentResolver) {
            this.f4456a = contentResolver;
        }

        @Override // c1.o
        public final n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // c1.w.c
        public final W0.d<AssetFileDescriptor> b(Uri uri) {
            return new W0.a(this.f4456a, uri, 0);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4457a;

        public b(ContentResolver contentResolver) {
            this.f4457a = contentResolver;
        }

        @Override // c1.o
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // c1.w.c
        public final W0.d<ParcelFileDescriptor> b(Uri uri) {
            return new W0.a(this.f4457a, uri, 1);
        }
    }

    public interface c<Data> {
        W0.d<Data> b(Uri uri);
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f4458a;

        public d(ContentResolver contentResolver) {
            this.f4458a = contentResolver;
        }

        @Override // c1.o
        public final n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }

        @Override // c1.w.c
        public final W0.d<InputStream> b(Uri uri) {
            return new W0.m(this.f4458a, uri);
        }
    }

    public w(c<Data> cVar) {
        this.f4455a = cVar;
    }

    @Override // c1.n
    public final n.a a(Uri uri, int i2, int i4, V0.h hVar) {
        Uri uri2 = uri;
        return new n.a(new r1.b(uri2), this.f4455a.b(uri2));
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        return f4454b.contains(uri.getScheme());
    }
}
