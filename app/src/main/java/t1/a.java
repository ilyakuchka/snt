package t1;

import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final e<Object> f7900a = new C0139a();

    /* renamed from: t1.a$a, reason: collision with other inner class name */
    final class C0139a implements e<Object> {
        C0139a() {
        }

        @Override // t1.a.e
        public final void a(Object obj) {
        }
    }

    public interface b<T> {
        T a();
    }

    private static final class c<T> implements E.b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final b<T> f7901a;

        /* renamed from: b, reason: collision with root package name */
        private final e<T> f7902b;

        /* renamed from: c, reason: collision with root package name */
        private final E.b<T> f7903c;

        c(E.b<T> bVar, b<T> bVar2, e<T> eVar) {
            this.f7903c = bVar;
            this.f7901a = bVar2;
            this.f7902b = eVar;
        }

        @Override // E.b
        public final boolean a(T t2) {
            if (t2 instanceof d) {
                ((d) t2).f().b(true);
            }
            this.f7902b.a(t2);
            return this.f7903c.a(t2);
        }

        @Override // E.b
        public final T b() {
            T tB = this.f7903c.b();
            if (tB == null) {
                tB = this.f7901a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder sbD = D2.e.d("Created new ");
                    sbD.append(tB.getClass());
                    Log.v("FactoryPools", sbD.toString());
                }
            }
            if (tB instanceof d) {
                tB.f().b(false);
            }
            return (T) tB;
        }
    }

    public interface d {
        t1.d f();
    }

    public interface e<T> {
        void a(T t2);
    }

    public static <T extends d> E.b<T> a(int i2, b<T> bVar) {
        return new c(new E.d(i2), bVar, f7900a);
    }

    public static <T> E.b<List<T>> b() {
        return new c(new E.d(20), new t1.b(), new t1.c());
    }
}
