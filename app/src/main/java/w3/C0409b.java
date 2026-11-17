package w3;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: w3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0409b {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Class<?>, e<?>> f7986a;

    /* renamed from: b, reason: collision with root package name */
    private static final d<StringBuilder> f7987b;

    /* renamed from: w3.b$a */
    final class a extends c<StringBuilder> {
        a() {
        }

        @Override // w3.C0409b.c
        public final StringBuilder a() {
            return new StringBuilder();
        }

        @Override // w3.C0409b.c
        public final void b(StringBuilder sb) {
            sb.setLength(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w3.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0142b<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        private final c<T> f7988a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7989b;

        /* renamed from: c, reason: collision with root package name */
        private e f7990c;
        private final Object d;

        /* renamed from: w3.b$b$a */
        final class a {
            a() {
            }

            protected final void finalize() throws Throwable {
                try {
                    AbstractC0142b.this.b();
                } finally {
                    super.finalize();
                }
            }
        }

        public AbstractC0142b(c<T> cVar, int i2) {
            a aVar = new a();
            this.d = aVar;
            if (i2 < 1) {
                this.f7989b = aVar.hashCode();
                throw new IllegalArgumentException("manager cannot be null and size cannot less then 1");
            }
            this.f7988a = cVar;
            this.f7989b = i2;
            T tA = cVar.a();
            if (tA == null) {
                throw new IllegalStateException("manager create instance cannot return null");
            }
            this.f7990c = C0409b.e(tA.getClass(), i2);
            c(tA);
        }

        public T a() {
            e eVar = this.f7990c;
            if (eVar == null) {
                throw new IllegalStateException("Cannot acquire object after close()");
            }
            T tA = (T) eVar.a();
            if (tA == null && (tA = this.f7988a.a()) == null) {
                throw new IllegalStateException("manager create instance cannot return null");
            }
            Objects.requireNonNull(this.f7988a);
            return tA;
        }

        public void b() {
            e eVar = this.f7990c;
            if (eVar != null) {
                C0409b.d(eVar, this.f7989b);
                this.f7990c = null;
            }
        }

        protected final void c(T t2) {
            if (this.f7990c == null) {
                throw new IllegalStateException("Cannot release object after close()");
            }
            this.f7988a.b(t2);
            if (this.f7990c.b(t2)) {
                return;
            }
            Objects.requireNonNull(this.f7988a);
        }
    }

    /* renamed from: w3.b$c */
    public static abstract class c<T> {
        public abstract T a();

        public void b(T t2) {
        }
    }

    /* renamed from: w3.b$d */
    public interface d<T> {
    }

    /* renamed from: w3.b$e */
    private static class e<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f7992a;

        /* renamed from: b, reason: collision with root package name */
        private volatile SoftReference<T>[] f7993b;

        /* renamed from: c, reason: collision with root package name */
        private volatile int f7994c = 0;
        private volatile int d;

        e(Class<T> cls, int i2) {
            this.f7992a = cls;
            this.d = i2;
            this.f7993b = new SoftReference[i2];
        }

        public final synchronized T a() {
            int i2 = this.f7994c;
            SoftReference<T>[] softReferenceArr = this.f7993b;
            while (i2 != 0) {
                i2--;
                if (softReferenceArr[i2] != null) {
                    T t2 = softReferenceArr[i2].get();
                    softReferenceArr[i2] = null;
                    if (t2 != null) {
                        this.f7994c = i2;
                        return t2;
                    }
                }
            }
            return null;
        }

        public final synchronized boolean b(T t2) {
            int i2;
            int i4 = this.f7994c;
            SoftReference<T>[] softReferenceArr = this.f7993b;
            if (i4 < this.d) {
                softReferenceArr[i4] = new SoftReference<>(t2);
                this.f7994c = i4 + 1;
                return true;
            }
            for (0; i2 < i4; i2 + 1) {
                i2 = (softReferenceArr[i2] == null || softReferenceArr[i2].get() == null) ? 0 : i2 + 1;
                softReferenceArr[i2] = new SoftReference<>(t2);
                return true;
            }
            return false;
        }

        public final synchronized void c(int i2) {
            int i4 = i2 + this.d;
            if (i4 <= 0) {
                synchronized (C0409b.f7986a) {
                    C0409b.f7986a.remove(this.f7992a);
                }
                return;
            }
            this.d = i4;
            SoftReference<T>[] softReferenceArr = this.f7993b;
            int i5 = this.f7994c;
            if (i4 > softReferenceArr.length) {
                SoftReference<T>[] softReferenceArr2 = new SoftReference[i4];
                System.arraycopy(softReferenceArr, 0, softReferenceArr2, 0, i5);
                this.f7993b = softReferenceArr2;
            }
        }
    }

    /* renamed from: w3.b$f */
    public static class f<T> extends AbstractC0142b<T> {
        f(c<T> cVar, int i2) {
            super(cVar, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void d(Object obj) {
            c(obj);
        }
    }

    static {
        new HashMap();
        f7986a = new HashMap<>();
        f7987b = new f(new a(), 4);
    }

    public static f b(c cVar) {
        return new f(cVar, 1);
    }

    public static d<StringBuilder> c() {
        return f7987b;
    }

    static <T> void d(e<T> eVar, int i2) {
        synchronized (f7986a) {
            eVar.c(-i2);
        }
    }

    static <T> e<T> e(Class<T> cls, int i2) {
        e<T> eVar;
        HashMap<Class<?>, e<?>> map = f7986a;
        synchronized (map) {
            eVar = (e) map.get(cls);
            if (eVar == null) {
                eVar = new e<>(cls, i2);
                map.put(cls, eVar);
            } else {
                eVar.c(i2);
            }
        }
        return eVar;
    }
}
