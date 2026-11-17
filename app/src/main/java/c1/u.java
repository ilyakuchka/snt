package c1;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import c1.n;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class u<Data> implements n<String, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f4450a;

    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // c1.o
        public final n<String, AssetFileDescriptor> a(r rVar) {
            return new u(rVar.c(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // c1.o
        public final n<String, ParcelFileDescriptor> a(r rVar) {
            return new u(rVar.c(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<String, InputStream> {
        @Override // c1.o
        public final n<String, InputStream> a(r rVar) {
            return new u(rVar.c(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f4450a = nVar;
    }

    @Override // c1.n
    public final n.a a(String str, int i2, int i4, V0.h hVar) {
        Uri uriFromFile;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            uriFromFile = null;
        } else if (str2.charAt(0) == '/') {
            uriFromFile = Uri.fromFile(new File(str2));
        } else {
            Uri uri = Uri.parse(str2);
            uriFromFile = uri.getScheme() == null ? Uri.fromFile(new File(str2)) : uri;
        }
        if (uriFromFile == null || !this.f4450a.b(uriFromFile)) {
            return null;
        }
        return this.f4450a.a(uriFromFile, i2, i4, hVar);
    }

    @Override // c1.n
    public final /* bridge */ /* synthetic */ boolean b(String str) {
        return true;
    }
}
