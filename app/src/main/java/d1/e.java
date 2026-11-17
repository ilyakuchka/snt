package d1;

import V0.h;
import W0.d;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import c1.n;
import c1.o;
import c1.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class e<DataT> implements n<Uri, DataT> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6148a;

    /* renamed from: b, reason: collision with root package name */
    private final n<File, DataT> f6149b;

    /* renamed from: c, reason: collision with root package name */
    private final n<Uri, DataT> f6150c;
    private final Class<DataT> d;

    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f6151a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<DataT> f6152b;

        a(Context context, Class<DataT> cls) {
            this.f6151a = context;
            this.f6152b = cls;
        }

        @Override // c1.o
        public final n<Uri, DataT> a(r rVar) {
            return new e(this.f6151a, rVar.c(File.class, this.f6152b), rVar.c(Uri.class, this.f6152b), this.f6152b);
        }
    }

    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    private static final class d<DataT> implements W0.d<DataT> {

        /* renamed from: s, reason: collision with root package name */
        private static final String[] f6153s = {"_data"};

        /* renamed from: i, reason: collision with root package name */
        private final Context f6154i;

        /* renamed from: j, reason: collision with root package name */
        private final n<File, DataT> f6155j;

        /* renamed from: k, reason: collision with root package name */
        private final n<Uri, DataT> f6156k;

        /* renamed from: l, reason: collision with root package name */
        private final Uri f6157l;

        /* renamed from: m, reason: collision with root package name */
        private final int f6158m;

        /* renamed from: n, reason: collision with root package name */
        private final int f6159n;

        /* renamed from: o, reason: collision with root package name */
        private final h f6160o;
        private final Class<DataT> p;

        /* renamed from: q, reason: collision with root package name */
        private volatile boolean f6161q;

        /* renamed from: r, reason: collision with root package name */
        private volatile W0.d<DataT> f6162r;

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i4, h hVar, Class<DataT> cls) {
            this.f6154i = context.getApplicationContext();
            this.f6155j = nVar;
            this.f6156k = nVar2;
            this.f6157l = uri;
            this.f6158m = i2;
            this.f6159n = i4;
            this.f6160o = hVar;
            this.p = cls;
        }

        private W0.d<DataT> e() throws Throwable {
            n.a<DataT> aVarA;
            Cursor cursor = null;
            if (Environment.isExternalStorageLegacy()) {
                n<File, DataT> nVar = this.f6155j;
                Uri uri = this.f6157l;
                try {
                    Cursor cursorQuery = this.f6154i.getContentResolver().query(uri, f6153s, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                                if (TextUtils.isEmpty(string)) {
                                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                                }
                                File file = new File(string);
                                cursorQuery.close();
                                aVarA = nVar.a(file, this.f6158m, this.f6159n, this.f6160o);
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                aVarA = this.f6156k.a(this.f6154i.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? MediaStore.setRequireOriginal(this.f6157l) : this.f6157l, this.f6158m, this.f6159n, this.f6160o);
            }
            if (aVarA != null) {
                return aVarA.f4421c;
            }
            return null;
        }

        @Override // W0.d
        public final Class<DataT> a() {
            return this.p;
        }

        @Override // W0.d
        public final void b() {
            W0.d<DataT> dVar = this.f6162r;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super DataT> aVar) throws Throwable {
            try {
                W0.d<DataT> dVarE = e();
                if (dVarE == null) {
                    aVar.e(new IllegalArgumentException("Failed to build fetcher for: " + this.f6157l));
                    return;
                }
                this.f6162r = dVarE;
                if (this.f6161q) {
                    cancel();
                } else {
                    dVarE.c(fVar, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.e(e2);
            }
        }

        @Override // W0.d
        public final void cancel() {
            this.f6161q = true;
            W0.d<DataT> dVar = this.f6162r;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // W0.d
        public final V0.a d() {
            return V0.a.f1747i;
        }
    }

    e(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f6148a = context.getApplicationContext();
        this.f6149b = nVar;
        this.f6150c = nVar2;
        this.d = cls;
    }

    @Override // c1.n
    public final n.a a(Uri uri, int i2, int i4, h hVar) {
        Uri uri2 = uri;
        return new n.a(new r1.b(uri2), new d(this.f6148a, this.f6149b, this.f6150c, uri2, i2, i4, hVar, this.d));
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        return Y1.a.g(uri);
    }
}
