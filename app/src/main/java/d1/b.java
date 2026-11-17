package d1;

import V0.h;
import android.net.Uri;
import c1.n;
import c1.o;
import c1.r;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class b implements n<Uri, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f6142b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    private final n<c1.f, InputStream> f6143a;

    public static class a implements o<Uri, InputStream> {
        @Override // c1.o
        public final n<Uri, InputStream> a(r rVar) {
            return new b(rVar.c(c1.f.class, InputStream.class));
        }
    }

    public b(n<c1.f, InputStream> nVar) {
        this.f6143a = nVar;
    }

    @Override // c1.n
    public final n.a<InputStream> a(Uri uri, int i2, int i4, h hVar) {
        return this.f6143a.a(new c1.f(uri.toString()), i2, i4, hVar);
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        return f6142b.contains(uri.getScheme());
    }
}
