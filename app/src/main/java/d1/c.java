package d1;

import V0.h;
import android.content.Context;
import android.net.Uri;
import c1.n;
import c1.o;
import c1.r;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6144a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f6145a;

        public a(Context context) {
            this.f6145a = context;
        }

        @Override // c1.o
        public final n<Uri, InputStream> a(r rVar) {
            return new c(this.f6145a);
        }
    }

    public c(Context context) {
        this.f6144a = context.getApplicationContext();
    }

    @Override // c1.n
    public final n.a<InputStream> a(Uri uri, int i2, int i4, h hVar) {
        Uri uri2 = uri;
        if (i2 != Integer.MIN_VALUE && i4 != Integer.MIN_VALUE && i2 <= 512 && i4 <= 384) {
            return new n.a<>(new r1.b(uri2), X0.b.f(this.f6144a, uri2));
        }
        return null;
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        Uri uri2 = uri;
        return Y1.a.g(uri2) && !uri2.getPathSegments().contains("video");
    }
}
