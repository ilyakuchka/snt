package d1;

import V0.h;
import android.content.Context;
import android.net.Uri;
import c1.n;
import c1.o;
import c1.r;
import f1.v;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class d implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6146a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f6147a;

        public a(Context context) {
            this.f6147a = context;
        }

        @Override // c1.o
        public final n<Uri, InputStream> a(r rVar) {
            return new d(this.f6147a);
        }
    }

    public d(Context context) {
        this.f6146a = context.getApplicationContext();
    }

    @Override // c1.n
    public final n.a<InputStream> a(Uri uri, int i2, int i4, h hVar) {
        Uri uri2 = uri;
        if (i2 != Integer.MIN_VALUE && i4 != Integer.MIN_VALUE && i2 <= 512 && i4 <= 384) {
            Long l2 = (Long) hVar.c(v.d);
            if (l2 != null && l2.longValue() == -1) {
                return new n.a<>(new r1.b(uri2), X0.b.g(this.f6146a, uri2));
            }
        }
        return null;
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        Uri uri2 = uri;
        return Y1.a.g(uri2) && uri2.getPathSegments().contains("video");
    }
}
