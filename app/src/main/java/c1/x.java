package c1;

import android.net.Uri;
import c1.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class x<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f4459b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    private final n<f, Data> f4460a;

    public static class a implements o<Uri, InputStream> {
        @Override // c1.o
        public final n<Uri, InputStream> a(r rVar) {
            return new x(rVar.c(f.class, InputStream.class));
        }
    }

    public x(n<f, Data> nVar) {
        this.f4460a = nVar;
    }

    @Override // c1.n
    public final n.a a(Uri uri, int i2, int i4, V0.h hVar) {
        return this.f4460a.a(new f(uri.toString()), i2, i4, hVar);
    }

    @Override // c1.n
    public final boolean b(Uri uri) {
        return f4459b.contains(uri.getScheme());
    }
}
