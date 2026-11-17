package R;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class k implements V.e, V.d {

    /* renamed from: q, reason: collision with root package name */
    static final TreeMap<Integer, k> f1280q = new TreeMap<>();

    /* renamed from: i, reason: collision with root package name */
    private volatile String f1281i;

    /* renamed from: j, reason: collision with root package name */
    final long[] f1282j;

    /* renamed from: k, reason: collision with root package name */
    final double[] f1283k;

    /* renamed from: l, reason: collision with root package name */
    final String[] f1284l;

    /* renamed from: m, reason: collision with root package name */
    final byte[][] f1285m;

    /* renamed from: n, reason: collision with root package name */
    private final int[] f1286n;

    /* renamed from: o, reason: collision with root package name */
    final int f1287o;
    int p;

    private k(int i2) {
        this.f1287o = i2;
        int i4 = i2 + 1;
        this.f1286n = new int[i4];
        this.f1282j = new long[i4];
        this.f1283k = new double[i4];
        this.f1284l = new String[i4];
        this.f1285m = new byte[i4][];
    }

    public static k I(String str, int i2) {
        TreeMap<Integer, k> treeMap = f1280q;
        synchronized (treeMap) {
            Map.Entry<Integer, k> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (entryCeilingEntry == null) {
                k kVar = new k(i2);
                kVar.f1281i = str;
                kVar.p = i2;
                return kVar;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            k value = entryCeilingEntry.getValue();
            value.f1281i = str;
            value.p = i2;
            return value;
        }
    }

    @Override // V.e
    public final void H(V.d dVar) {
        for (int i2 = 1; i2 <= this.p; i2++) {
            int i4 = this.f1286n[i2];
            if (i4 == 1) {
                dVar.L(i2);
            } else if (i4 == 2) {
                dVar.v(i2, this.f1282j[i2]);
            } else if (i4 == 3) {
                dVar.O(i2, this.f1283k[i2]);
            } else if (i4 == 4) {
                dVar.u(i2, this.f1284l[i2]);
            } else if (i4 == 5) {
                dVar.J(i2, this.f1285m[i2]);
            }
        }
    }

    @Override // V.d
    public final void J(int i2, byte[] bArr) {
        this.f1286n[i2] = 5;
        this.f1285m[i2] = bArr;
    }

    @Override // V.d
    public final void L(int i2) {
        this.f1286n[i2] = 1;
    }

    @Override // V.d
    public final void O(int i2, double d) {
        this.f1286n[i2] = 3;
        this.f1283k[i2] = d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void e0(k kVar) {
        int i2 = kVar.p + 1;
        System.arraycopy(kVar.f1286n, 0, this.f1286n, 0, i2);
        System.arraycopy(kVar.f1282j, 0, this.f1282j, 0, i2);
        System.arraycopy(kVar.f1284l, 0, this.f1284l, 0, i2);
        System.arraycopy(kVar.f1285m, 0, this.f1285m, 0, i2);
        System.arraycopy(kVar.f1283k, 0, this.f1283k, 0, i2);
    }

    @Override // V.e
    public final String f() {
        return this.f1281i;
    }

    public final int f0() {
        return this.p;
    }

    public final void g0() {
        TreeMap<Integer, k> treeMap = f1280q;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f1287o), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i2;
                }
            }
        }
    }

    @Override // V.d
    public final void u(int i2, String str) {
        this.f1286n[i2] = 4;
        this.f1284l[i2] = str;
    }

    @Override // V.d
    public final void v(int i2, long j2) {
        this.f1286n[i2] = 2;
        this.f1282j[i2] = j2;
    }
}
