package c1;

import W0.d;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import c1.n;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class j implements n<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4410a;

    public static final class a implements o<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4411a;

        public a(Context context) {
            this.f4411a = context;
        }

        @Override // c1.o
        public final n<Uri, File> a(r rVar) {
            return new j(this.f4411a);
        }
    }

    private static class b implements W0.d<File> {

        /* renamed from: k, reason: collision with root package name */
        private static final String[] f4412k = {"_data"};

        /* renamed from: i, reason: collision with root package name */
        private final Context f4413i;

        /* renamed from: j, reason: collision with root package name */
        private final Uri f4414j;

        b(Context context, Uri uri) {
            this.f4413i = context;
            this.f4414j = uri;
        }

        @Override // W0.d
        public final Class<File> a() {
            return File.class;
        }

        @Override // W0.d
        public final void b() {
        }

        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super File> aVar) {
            Cursor cursorQuery = this.f4413i.getContentResolver().query(this.f4414j, f4412k, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            StringBuilder sbD = D2.e.d("Failed to find file path for: ");
            sbD.append(this.f4414j);
            aVar.e(new FileNotFoundException(sbD.toString()));
        }

        @Override // W0.d
        public final void cancel() {
        }

        @Override // W0.d
        public final V0.a d() {
            return V0.a.f1747i;
        }
    }

    public j(Context context) {
        this.f4410a = context;
    }

    @Override // c1.n
    public final n.a<File> a(Uri uri, int i2, int i4, V0.h hVar) {
        Uri uri2 = uri;
        return new n.a<>(new r1.b(uri2), new b(this.f4410a, uri2));
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        return Y1.a.g(uri);
    }
}
