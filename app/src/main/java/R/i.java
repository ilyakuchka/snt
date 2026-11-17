package R;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.util.Log;
import com.android.mmt.storage.bugle.BugleDatabase;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import n.C0352a;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    protected volatile V.b f1257a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f1258b;

    /* renamed from: c, reason: collision with root package name */
    private Executor f1259c;
    private V.c d;

    /* renamed from: e, reason: collision with root package name */
    private final g f1260e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1261f;
    boolean g;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    protected List<b> f1262h;

    /* renamed from: j, reason: collision with root package name */
    private R.a f1264j;

    /* renamed from: l, reason: collision with root package name */
    private final Map<Class<?>, Object> f1266l;

    /* renamed from: i, reason: collision with root package name */
    private final ReentrantReadWriteLock f1263i = new ReentrantReadWriteLock();

    /* renamed from: k, reason: collision with root package name */
    private final ThreadLocal<Integer> f1265k = new ThreadLocal<>();

    public static class a<T extends i> {

        /* renamed from: c, reason: collision with root package name */
        private final Context f1269c;
        private ArrayList<b> d;

        /* renamed from: e, reason: collision with root package name */
        private Executor f1270e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f1271f;
        private boolean g;

        /* renamed from: i, reason: collision with root package name */
        private Set<Integer> f1273i;

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f1267a = BugleDatabase.class;

        /* renamed from: b, reason: collision with root package name */
        private final String f1268b = "bugle";

        /* renamed from: h, reason: collision with root package name */
        private final c f1272h = new c();

        a(Context context) {
            this.f1269c = context;
        }

        public final a<T> a(b bVar) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(bVar);
            return this;
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashSet, java.util.Set<java.lang.Integer>] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.HashSet, java.util.Set<java.lang.Integer>] */
        public final a<T> b(S.a... aVarArr) {
            if (this.f1273i == null) {
                this.f1273i = new HashSet();
            }
            for (S.a aVar : aVarArr) {
                this.f1273i.add(Integer.valueOf(aVar.f1339a));
                this.f1273i.add(Integer.valueOf(aVar.f1340b));
            }
            this.f1272h.a(aVarArr);
            return this;
        }

        public final a<T> c() {
            this.g = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public final T d() {
            Executor executor;
            String str;
            if (this.f1269c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.f1267a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            Executor executor2 = this.f1270e;
            if (executor2 == null && this.f1271f == null) {
                Executor executorJ = C0352a.j();
                this.f1271f = executorJ;
                this.f1270e = executorJ;
            } else if (executor2 != null && this.f1271f == null) {
                this.f1271f = executor2;
            } else if (executor2 == null && (executor = this.f1271f) != null) {
                this.f1270e = executor;
            }
            W.c cVar = new W.c();
            Context context = this.f1269c;
            String str2 = this.f1268b;
            c cVar2 = this.f1272h;
            ArrayList<b> arrayList = this.d;
            boolean z4 = this.g;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            R.c cVar3 = new R.c(context, str2, cVar, cVar2, arrayList, z4, (activityManager == null || activityManager.isLowRamDevice()) ? 2 : 3, this.f1270e, this.f1271f);
            Class<T> cls = this.f1267a;
            String name = cls.getPackage().getName();
            String canonicalName = cls.getCanonicalName();
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String str3 = canonicalName.replace('.', '_') + "_Impl";
            try {
                if (name.isEmpty()) {
                    str = str3;
                } else {
                    str = name + "." + str3;
                }
                T t2 = (T) Class.forName(str, true, cls.getClassLoader()).newInstance();
                t2.p(cVar3);
                return t2;
            } catch (ClassNotFoundException unused) {
                StringBuilder sbD = D2.e.d("cannot find implementation for ");
                sbD.append(cls.getCanonicalName());
                sbD.append(". ");
                sbD.append(str3);
                sbD.append(" does not exist");
                throw new RuntimeException(sbD.toString());
            } catch (IllegalAccessException unused2) {
                StringBuilder sbD2 = D2.e.d("Cannot access the constructor");
                sbD2.append(cls.getCanonicalName());
                throw new RuntimeException(sbD2.toString());
            } catch (InstantiationException unused3) {
                StringBuilder sbD3 = D2.e.d("Failed to create an instance of ");
                sbD3.append(cls.getCanonicalName());
                throw new RuntimeException(sbD3.toString());
            }
        }
    }

    public static abstract class b {
        public void a() {
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, S.a>> f1274a = new HashMap<>();

        public final void a(S.a... aVarArr) {
            for (S.a aVar : aVarArr) {
                int i2 = aVar.f1339a;
                int i4 = aVar.f1340b;
                TreeMap<Integer, S.a> treeMap = this.f1274a.get(Integer.valueOf(i2));
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    this.f1274a.put(Integer.valueOf(i2), treeMap);
                }
                S.a aVar2 = treeMap.get(Integer.valueOf(i4));
                if (aVar2 != null) {
                    Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
                }
                treeMap.put(Integer.valueOf(i4), aVar);
            }
        }

        public final List<S.a> b(int i2, int i4) {
            boolean z4;
            if (i2 == i4) {
                return Collections.emptyList();
            }
            boolean z5 = i4 > i2;
            ArrayList arrayList = new ArrayList();
            do {
                if (z5) {
                    if (i2 >= i4) {
                        return arrayList;
                    }
                } else if (i2 <= i4) {
                    return arrayList;
                }
                TreeMap<Integer, S.a> treeMap = this.f1274a.get(Integer.valueOf(i2));
                if (treeMap == null) {
                    break;
                }
                Iterator<Integer> it = (z5 ? treeMap.descendingKeySet() : treeMap.keySet()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z4 = false;
                        break;
                    }
                    int iIntValue = it.next().intValue();
                    if (!z5 ? iIntValue < i4 || iIntValue >= i2 : iIntValue > i4 || iIntValue <= i2) {
                        arrayList.add(treeMap.get(Integer.valueOf(iIntValue)));
                        z4 = true;
                        i2 = iIntValue;
                        break;
                    }
                }
            } while (z4);
            return null;
        }
    }

    public i() {
        Collections.synchronizedMap(new HashMap());
        this.f1260e = f();
        this.f1266l = new HashMap();
    }

    private void q() {
        a();
        V.b bVarT = this.d.T();
        this.f1260e.l(bVarT);
        if (bVarT.p()) {
            bVarT.G();
        } else {
            bVarT.j();
        }
    }

    private void r() {
        this.d.T().i();
        if (o()) {
            return;
        }
        g gVar = this.f1260e;
        if (gVar.f1240e.compareAndSet(false, true)) {
            gVar.d.f1258b.execute(gVar.f1245k);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T w(Class<T> cls, V.c cVar) {
        if (cls.isInstance(cVar)) {
            return cVar;
        }
        if (cVar instanceof d) {
            return (T) w(cls, ((d) cVar).f());
        }
        return null;
    }

    public final void a() {
        if (this.f1261f) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!o() && this.f1265k.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public final void c() {
        a();
        q();
    }

    public abstract void d();

    public final V.f e(String str) {
        a();
        b();
        return this.d.T().C(str);
    }

    protected abstract g f();

    protected abstract V.c g(R.c cVar);

    @Deprecated
    public final void h() {
        r();
    }

    final Lock i() {
        return this.f1263i.readLock();
    }

    public final g j() {
        return this.f1260e;
    }

    public final V.c k() {
        return this.d;
    }

    public final Executor l() {
        return this.f1258b;
    }

    protected Map<Class<?>, List<Class<?>>> m() {
        return Collections.emptyMap();
    }

    public final Executor n() {
        return this.f1259c;
    }

    public final boolean o() {
        return this.d.T().b0();
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Object>] */
    public final void p(R.c cVar) {
        V.c cVarG = g(cVar);
        this.d = cVarG;
        n nVar = (n) w(n.class, cVarG);
        if (nVar != null) {
            nVar.I(cVar);
        }
        if (((R.b) w(R.b.class, this.d)) != null) {
            Objects.requireNonNull(this.f1260e);
            throw null;
        }
        boolean z4 = cVar.f1231h == 3;
        this.d.setWriteAheadLoggingEnabled(z4);
        this.f1262h = cVar.f1229e;
        this.f1258b = cVar.f1232i;
        this.f1259c = new p(cVar.f1233j);
        this.f1261f = cVar.g;
        this.g = z4;
        Map<Class<?>, List<Class<?>>> mapM = m();
        BitSet bitSet = new BitSet();
        for (Map.Entry<Class<?>, List<Class<?>>> entry : mapM.entrySet()) {
            Class<?> key = entry.getKey();
            for (Class<?> cls : entry.getValue()) {
                int size = cVar.f1230f.size() - 1;
                while (true) {
                    if (size < 0) {
                        size = -1;
                        break;
                    } else {
                        if (cls.isAssignableFrom(cVar.f1230f.get(size).getClass())) {
                            bitSet.set(size);
                            break;
                        }
                        size--;
                    }
                }
                if (size < 0) {
                    throw new IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                }
                this.f1266l.put(cls, cVar.f1230f.get(size));
            }
        }
        for (int size2 = cVar.f1230f.size() - 1; size2 >= 0; size2--) {
            if (!bitSet.get(size2)) {
                throw new IllegalArgumentException("Unexpected type converter " + cVar.f1230f.get(size2) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
        }
    }

    protected final void s(V.b bVar) {
        this.f1260e.f(bVar);
    }

    public final boolean t() {
        R.a aVar = this.f1264j;
        if (aVar != null) {
            return aVar.a();
        }
        V.b bVar = this.f1257a;
        return bVar != null && bVar.isOpen();
    }

    public final Cursor u(V.e eVar) {
        a();
        b();
        return this.d.T().R(eVar);
    }

    @Deprecated
    public final void v() {
        this.d.T().y();
    }
}
