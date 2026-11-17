package Z0;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import t.C0384b;

/* loaded from: classes.dex */
public final class h implements Z0.b {

    /* renamed from: a, reason: collision with root package name */
    private final g<a, Object> f2148a = new g<>();

    /* renamed from: b, reason: collision with root package name */
    private final b f2149b = new b();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f2150c = new HashMap();
    private final Map<Class<?>, Z0.a<?>> d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final int f2151e;

    /* renamed from: f, reason: collision with root package name */
    private int f2152f;

    private static final class a implements k {

        /* renamed from: a, reason: collision with root package name */
        private final b f2153a;

        /* renamed from: b, reason: collision with root package name */
        int f2154b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?> f2155c;

        a(b bVar) {
            this.f2153a = bVar;
        }

        @Override // Z0.k
        public final void a() {
            this.f2153a.c(this);
        }

        final void b(int i2, Class<?> cls) {
            this.f2154b = i2;
            this.f2155c = cls;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2154b == aVar.f2154b && this.f2155c == aVar.f2155c;
        }

        public final int hashCode() {
            int i2 = this.f2154b * 31;
            Class<?> cls = this.f2155c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sbD = D2.e.d("Key{size=");
            sbD.append(this.f2154b);
            sbD.append("array=");
            sbD.append(this.f2155c);
            sbD.append('}');
            return sbD.toString();
        }
    }

    private static final class b extends c<a> {
        b() {
        }

        @Override // Z0.c
        protected final k a() {
            return new a(this);
        }

        final a d(int i2, Class<?> cls) {
            a aVarB = b();
            aVarB.b(i2, cls);
            return aVarB;
        }
    }

    public h(int i2) {
        this.f2151e = i2;
    }

    private void f(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapJ = j(cls);
        Integer num = navigableMapJ.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapJ.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapJ.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private void g(int i2) {
        while (this.f2152f > i2) {
            Object objD = this.f2148a.d();
            C0384b.h(objD);
            Z0.a aVarH = h(objD.getClass());
            this.f2152f -= aVarH.b(objD) * aVarH.c();
            f(aVarH.b(objD), objD.getClass());
            if (Log.isLoggable(aVarH.a(), 2)) {
                String strA = aVarH.a();
                StringBuilder sbD = D2.e.d("evicted: ");
                sbD.append(aVarH.b(objD));
                Log.v(strA, sbD.toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, Z0.a<?>>] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, Z0.a<?>>] */
    private <T> Z0.a<T> h(Class<T> cls) {
        Z0.a<T> fVar = (Z0.a) this.d.get(cls);
        if (fVar == null) {
            if (cls.equals(int[].class)) {
                fVar = new f(1);
            } else {
                if (!cls.equals(byte[].class)) {
                    StringBuilder sbD = D2.e.d("No array pool found for: ");
                    sbD.append(cls.getSimpleName());
                    throw new IllegalArgumentException(sbD.toString());
                }
                fVar = new f(0);
            }
            this.d.put(cls, fVar);
        }
        return fVar;
    }

    private <T> T i(a aVar, Class<T> cls) {
        Z0.a<T> aVarH = h(cls);
        T t2 = (T) this.f2148a.a(aVar);
        if (t2 != null) {
            this.f2152f -= aVarH.b(t2) * aVarH.c();
            f(aVarH.b(t2), cls);
        }
        if (t2 != null) {
            return t2;
        }
        if (Log.isLoggable(aVarH.a(), 2)) {
            String strA = aVarH.a();
            StringBuilder sbD = D2.e.d("Allocated ");
            sbD.append(aVar.f2154b);
            sbD.append(" bytes");
            Log.v(strA, sbD.toString());
        }
        return aVarH.newArray(aVar.f2154b);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>>] */
    private NavigableMap<Integer, Integer> j(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f2150c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f2150c.put(cls, treeMap);
        return treeMap;
    }

    @Override // Z0.b
    public final synchronized void a(int i2) {
        try {
            if (i2 >= 40) {
                synchronized (this) {
                    g(0);
                }
            } else if (i2 >= 20 || i2 == 15) {
                g(this.f2151e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // Z0.b
    public final synchronized void b() {
        g(0);
    }

    @Override // Z0.b
    public final synchronized <T> void c(T t2) {
        Class<?> cls = t2.getClass();
        Z0.a<T> aVarH = h(cls);
        int iB = aVarH.b(t2);
        int iC = aVarH.c() * iB;
        int iIntValue = 1;
        if (iC <= this.f2151e / 2) {
            a aVarD = this.f2149b.d(iB, cls);
            this.f2148a.b(aVarD, t2);
            NavigableMap<Integer, Integer> navigableMapJ = j(cls);
            Integer num = navigableMapJ.get(Integer.valueOf(aVarD.f2154b));
            Integer numValueOf = Integer.valueOf(aVarD.f2154b);
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapJ.put(numValueOf, Integer.valueOf(iIntValue));
            this.f2152f += iC;
            g(this.f2151e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[Catch: all -> 0x0046, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:13:0x0023, B:18:0x002f, B:20:0x0040, B:19:0x003a), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: all -> 0x0046, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:13:0x0023, B:18:0x002f, B:20:0x0040, B:19:0x003a), top: B:26:0x0001 }] */
    @Override // Z0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized <T> T d(int i2, Class<T> cls) {
        Integer numCeilingKey;
        boolean z4;
        numCeilingKey = j(cls).ceilingKey(Integer.valueOf(i2));
        z4 = true;
        if (numCeilingKey == null) {
            z4 = false;
        } else {
            int i4 = this.f2152f;
            if (!(i4 == 0 || this.f2151e / i4 >= 2) && numCeilingKey.intValue() > i2 * 8) {
            }
        }
        return (T) i(!z4 ? this.f2149b.d(numCeilingKey.intValue(), cls) : this.f2149b.d(i2, cls), cls);
    }

    @Override // Z0.b
    public final synchronized Object e() {
        return i(this.f2149b.d(8, byte[].class), byte[].class);
    }
}
