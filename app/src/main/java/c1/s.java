package c1;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c1.n;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class s<Data> implements n<Integer, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f4443a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f4444b;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4445a;

        public a(Resources resources) {
            this.f4445a = resources;
        }

        @Override // c1.o
        public final n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f4445a, rVar.c(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4446a;

        public b(Resources resources) {
            this.f4446a = resources;
        }

        @Override // c1.o
        public final n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f4446a, rVar.c(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4447a;

        public c(Resources resources) {
            this.f4447a = resources;
        }

        @Override // c1.o
        public final n<Integer, InputStream> a(r rVar) {
            return new s(this.f4447a, rVar.c(Uri.class, InputStream.class));
        }
    }

    public static class d implements o<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f4448a;

        public d(Resources resources) {
            this.f4448a = resources;
        }

        @Override // c1.o
        public final n<Integer, Uri> a(r rVar) {
            return new s(this.f4448a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f4444b = resources;
        this.f4443a = nVar;
    }

    @Override // c1.n
    public final n.a a(Integer num, int i2, int i4, V0.h hVar) {
        Uri uri;
        Integer num2 = num;
        try {
            uri = Uri.parse("android.resource://" + this.f4444b.getResourcePackageName(num2.intValue()) + '/' + this.f4444b.getResourceTypeName(num2.intValue()) + '/' + this.f4444b.getResourceEntryName(num2.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num2, e2);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.f4443a.a(uri, i2, i4, hVar);
    }

    @Override // c1.n
    public final /* bridge */ /* synthetic */ boolean b(Integer num) {
        return true;
    }
}
