package c1;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c1.n;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class a<Data> implements n<Uri, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f4381a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0082a<Data> f4382b;

    /* renamed from: c1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0082a<Data> {
        W0.d<Data> b(AssetManager assetManager, String str);
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0082a<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f4383a;

        public b(AssetManager assetManager) {
            this.f4383a = assetManager;
        }

        @Override // c1.o
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f4383a, this);
        }

        @Override // c1.a.InterfaceC0082a
        public final W0.d<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            return new W0.h(assetManager, str, 0);
        }
    }

    public static class c implements o<Uri, InputStream>, InterfaceC0082a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f4384a;

        public c(AssetManager assetManager) {
            this.f4384a = assetManager;
        }

        @Override // c1.o
        public final n<Uri, InputStream> a(r rVar) {
            return new a(this.f4384a, this);
        }

        @Override // c1.a.InterfaceC0082a
        public final W0.d<InputStream> b(AssetManager assetManager, String str) {
            return new W0.h(assetManager, str, 1);
        }
    }

    public a(AssetManager assetManager, InterfaceC0082a<Data> interfaceC0082a) {
        this.f4381a = assetManager;
        this.f4382b = interfaceC0082a;
    }

    @Override // c1.n
    public final n.a a(Uri uri, int i2, int i4, V0.h hVar) {
        Uri uri2 = uri;
        return new n.a(new r1.b(uri2), this.f4382b.b(this.f4381a, uri2.toString().substring(22)));
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        Uri uri2 = uri;
        return "file".equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && "android_asset".equals(uri2.getPathSegments().get(0));
    }
}
