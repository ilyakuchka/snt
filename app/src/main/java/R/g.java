package R;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import o.C0358b;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f1236l = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b, reason: collision with root package name */
    final String[] f1238b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Set<String>> f1239c;
    final i d;
    volatile V.f g;

    /* renamed from: h, reason: collision with root package name */
    private b f1242h;

    /* renamed from: i, reason: collision with root package name */
    private final f f1243i;

    /* renamed from: e, reason: collision with root package name */
    AtomicBoolean f1240e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f1241f = false;

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"RestrictedApi"})
    final C0358b<c, d> f1244j = new C0358b<>();

    /* renamed from: k, reason: collision with root package name */
    Runnable f1245k = new a();

    /* renamed from: a, reason: collision with root package name */
    final HashMap<String, Integer> f1237a = new HashMap<>();

    final class a implements Runnable {
        a() {
        }

        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor cursorU = g.this.d.u(new V.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (cursorU.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(cursorU.getInt(0)));
                } catch (Throwable th) {
                    cursorU.close();
                    throw th;
                }
            }
            cursorU.close();
            if (!hashSet.isEmpty()) {
                g.this.g.B();
            }
            return hashSet;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lock lockI = g.this.d.i();
            lockI.lock();
            Set<Integer> setA = null;
            try {
                try {
                } catch (SQLiteException | IllegalStateException e2) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                }
                if (g.this.e()) {
                    if (g.this.f1240e.compareAndSet(true, false)) {
                        if (g.this.d.o()) {
                            return;
                        }
                        i iVar = g.this.d;
                        if (iVar.g) {
                            V.b bVarT = iVar.k().T();
                            bVarT.G();
                            try {
                                setA = a();
                                bVarT.y();
                                bVarT.i();
                            } catch (Throwable th) {
                                bVarT.i();
                                throw th;
                            }
                        } else {
                            setA = a();
                        }
                        if (setA == null || setA.isEmpty()) {
                            return;
                        }
                        synchronized (g.this.f1244j) {
                            Iterator<Map.Entry<c, d>> it = g.this.f1244j.iterator();
                            while (it.hasNext()) {
                                it.next().getValue().a(setA);
                            }
                        }
                    }
                }
            } finally {
                lockI.unlock();
                Objects.requireNonNull(g.this);
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final long[] f1247a;

        /* renamed from: b, reason: collision with root package name */
        final boolean[] f1248b;

        /* renamed from: c, reason: collision with root package name */
        final int[] f1249c;
        boolean d;

        /* renamed from: e, reason: collision with root package name */
        boolean f1250e;

        b(int i2) {
            long[] jArr = new long[i2];
            this.f1247a = jArr;
            boolean[] zArr = new boolean[i2];
            this.f1248b = zArr;
            this.f1249c = new int[i2];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        final int[] a() {
            synchronized (this) {
                if (this.d && !this.f1250e) {
                    int length = this.f1247a.length;
                    int i2 = 0;
                    while (true) {
                        int i4 = 1;
                        if (i2 >= length) {
                            this.f1250e = true;
                            this.d = false;
                            return this.f1249c;
                        }
                        boolean z4 = this.f1247a[i2] > 0;
                        boolean[] zArr = this.f1248b;
                        if (z4 != zArr[i2]) {
                            int[] iArr = this.f1249c;
                            if (!z4) {
                                i4 = 2;
                            }
                            iArr[i2] = i4;
                        } else {
                            this.f1249c[i2] = 0;
                        }
                        zArr[i2] = z4;
                        i2++;
                    }
                }
                return null;
            }
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String[] f1251a;

        public c(String[] strArr) {
            this.f1251a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract void a(Set<String> set);
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        final int[] f1252a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f1253b;

        /* renamed from: c, reason: collision with root package name */
        final c f1254c;
        private final Set<String> d;

        d(c cVar, int[] iArr, String[] strArr) {
            this.f1254c = cVar;
            this.f1252a = iArr;
            this.f1253b = strArr;
            if (iArr.length != 1) {
                this.d = null;
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(strArr[0]);
            this.d = Collections.unmodifiableSet(hashSet);
        }

        final void a(Set<Integer> set) {
            int length = this.f1252a.length;
            Set<String> hashSet = null;
            for (int i2 = 0; i2 < length; i2++) {
                if (set.contains(Integer.valueOf(this.f1252a[i2]))) {
                    if (length == 1) {
                        hashSet = this.d;
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet<>(length);
                        }
                        hashSet.add(this.f1253b[i2]);
                    }
                }
            }
            if (hashSet != null) {
                this.f1254c.a(hashSet);
            }
        }
    }

    static class e extends c {

        /* renamed from: b, reason: collision with root package name */
        final g f1255b;

        /* renamed from: c, reason: collision with root package name */
        final WeakReference<c> f1256c;

        e(g gVar, c cVar) {
            super(cVar.f1251a);
            this.f1255b = gVar;
            this.f1256c = new WeakReference<>(cVar);
        }

        @Override // R.g.c
        public final void a(Set<String> set) {
            c cVar = this.f1256c.get();
            if (cVar == null) {
                this.f1255b.h(this);
            } else {
                cVar.a(set);
            }
        }
    }

    public g(i iVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.d = iVar;
        this.f1242h = new b(strArr.length);
        this.f1239c = map2;
        this.f1243i = new f(iVar);
        int length = strArr.length;
        this.f1238b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f1237a.put(lowerCase, Integer.valueOf(i2));
            String str2 = map.get(strArr[i2]);
            if (str2 != null) {
                this.f1238b[i2] = str2.toLowerCase(locale);
            } else {
                this.f1238b[i2] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = value.toLowerCase(locale2);
            if (this.f1237a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> map3 = this.f1237a;
                map3.put(lowerCase3, map3.get(lowerCase2));
            }
        }
    }

    private static void c(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private String[] i(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f1239c.containsKey(lowerCase)) {
                hashSet.addAll(this.f1239c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void j(V.b bVar, int i2) throws SQLException {
        bVar.s("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.f1238b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = f1236l;
        for (int i4 = 0; i4 < 3; i4++) {
            String str2 = strArr[i4];
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            c(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i2);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.s(sb.toString());
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void a(c cVar) {
        d dVarN;
        boolean z4;
        String[] strArrI = i(cVar.f1251a);
        int length = strArrI.length;
        int[] iArr = new int[length];
        int length2 = strArrI.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Integer num = this.f1237a.get(strArrI[i2].toLowerCase(Locale.US));
            if (num == null) {
                StringBuilder sbD = D2.e.d("There is no table with name ");
                sbD.append(strArrI[i2]);
                throw new IllegalArgumentException(sbD.toString());
            }
            iArr[i2] = num.intValue();
        }
        d dVar = new d(cVar, iArr, strArrI);
        synchronized (this.f1244j) {
            dVarN = this.f1244j.n(cVar, dVar);
        }
        if (dVarN == null) {
            b bVar = this.f1242h;
            synchronized (bVar) {
                z4 = false;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr[i4];
                    long[] jArr = bVar.f1247a;
                    long j2 = jArr[i5];
                    jArr[i5] = 1 + j2;
                    if (j2 == 0) {
                        bVar.d = true;
                        z4 = true;
                    }
                }
            }
            if (z4) {
                k();
            }
        }
    }

    public final void b(c cVar) {
        a(new e(this, cVar));
    }

    public final LiveData d(String[] strArr, Callable callable) {
        f fVar = this.f1243i;
        String[] strArrI = i(strArr);
        for (String str : strArrI) {
            if (!this.f1237a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(D2.e.c("There is no table with name ", str));
            }
        }
        return fVar.a(strArrI, callable);
    }

    final boolean e() {
        if (!this.d.t()) {
            return false;
        }
        if (!this.f1241f) {
            this.d.k().T();
        }
        if (this.f1241f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    final void f(V.b bVar) {
        synchronized (this) {
            if (this.f1241f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.s("PRAGMA temp_store = MEMORY;");
            bVar.s("PRAGMA recursive_triggers='ON';");
            bVar.s("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            l(bVar);
            this.g = bVar.C("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f1241f = true;
        }
    }

    public final void g() {
        k();
        ((a) this.f1245k).run();
    }

    @SuppressLint({"RestrictedApi"})
    public final void h(c cVar) {
        d dVarO;
        boolean z4;
        synchronized (this.f1244j) {
            dVarO = this.f1244j.o(cVar);
        }
        if (dVarO != null) {
            b bVar = this.f1242h;
            int[] iArr = dVarO.f1252a;
            synchronized (bVar) {
                z4 = false;
                for (int i2 : iArr) {
                    long[] jArr = bVar.f1247a;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        bVar.d = true;
                        z4 = true;
                    }
                }
            }
            if (z4) {
                k();
            }
        }
    }

    final void k() {
        if (this.d.t()) {
            l(this.d.k().T());
        }
    }

    final void l(V.b bVar) {
        if (bVar.b0()) {
            return;
        }
        while (true) {
            try {
                Lock lockI = this.d.i();
                lockI.lock();
                try {
                    int[] iArrA = this.f1242h.a();
                    if (iArrA == null) {
                        lockI.unlock();
                        return;
                    }
                    int length = iArrA.length;
                    if (bVar.p()) {
                        bVar.G();
                    } else {
                        bVar.j();
                    }
                    for (int i2 = 0; i2 < length; i2++) {
                        try {
                            int i4 = iArrA[i2];
                            if (i4 == 1) {
                                j(bVar, i2);
                            } else if (i4 == 2) {
                                String str = this.f1238b[i2];
                                StringBuilder sb = new StringBuilder();
                                String[] strArr = f1236l;
                                for (int i5 = 0; i5 < 3; i5++) {
                                    String str2 = strArr[i5];
                                    sb.setLength(0);
                                    sb.append("DROP TRIGGER IF EXISTS ");
                                    c(sb, str, str2);
                                    bVar.s(sb.toString());
                                }
                            }
                        } catch (Throwable th) {
                            bVar.i();
                            throw th;
                        }
                    }
                    bVar.y();
                    bVar.i();
                    b bVar2 = this.f1242h;
                    synchronized (bVar2) {
                        bVar2.f1250e = false;
                    }
                    lockI.unlock();
                } catch (Throwable th2) {
                    lockI.unlock();
                    throw th2;
                }
            } catch (SQLiteException | IllegalStateException e2) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                return;
            }
        }
    }
}
