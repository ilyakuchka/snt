package a1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import t1.a;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final s1.g<V0.f, String> f2210a = new s1.g<>(1000);

    /* renamed from: b, reason: collision with root package name */
    private final E.b<b> f2211b = t1.a.a(10, new a());

    final class a implements a.b<b> {
        a() {
        }

        @Override // t1.a.b
        public final b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static final class b implements a.d {

        /* renamed from: i, reason: collision with root package name */
        final MessageDigest f2212i;

        /* renamed from: j, reason: collision with root package name */
        private final t1.d f2213j = t1.d.a();

        b(MessageDigest messageDigest) {
            this.f2212i = messageDigest;
        }

        @Override // t1.a.d
        public final t1.d f() {
            return this.f2213j;
        }
    }

    public final String a(V0.f fVar) {
        String strB;
        synchronized (this.f2210a) {
            strB = this.f2210a.b(fVar);
        }
        if (strB == null) {
            b bVarB = this.f2211b.b();
            Objects.requireNonNull(bVarB, "Argument must not be null");
            b bVar = bVarB;
            try {
                fVar.a(bVar.f2212i);
                strB = s1.j.j(bVar.f2212i.digest());
            } finally {
                this.f2211b.a(bVar);
            }
        }
        synchronized (this.f2210a) {
            this.f2210a.f(fVar, strB);
        }
        return strB;
    }
}
