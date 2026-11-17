package Z0;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class l implements j {
    private static final Bitmap.Config[] d;

    /* renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f2164e;

    /* renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f2165f;
    private static final Bitmap.Config[] g;

    /* renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f2166h;

    /* renamed from: a, reason: collision with root package name */
    private final c f2167a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final g<b, Bitmap> f2168b = new g<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f2169c = new HashMap();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2170a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f2170a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2170a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2170a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2170a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class b implements k {

        /* renamed from: a, reason: collision with root package name */
        private final c f2171a;

        /* renamed from: b, reason: collision with root package name */
        int f2172b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f2173c;

        public b(c cVar) {
            this.f2171a = cVar;
        }

        @Override // Z0.k
        public final void a() {
            this.f2171a.c(this);
        }

        public final void b(int i2, Bitmap.Config config) {
            this.f2172b = i2;
            this.f2173c = config;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f2172b == bVar.f2172b && s1.j.b(this.f2173c, bVar.f2173c);
        }

        public final int hashCode() {
            int i2 = this.f2172b * 31;
            Bitmap.Config config = this.f2173c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public final String toString() {
            return l.c(this.f2172b, this.f2173c);
        }
    }

    static class c extends Z0.c<b> {
        c() {
        }

        @Override // Z0.c
        protected final k a() {
            return new b(this);
        }

        public final b d(int i2, Bitmap.Config config) {
            b bVarB = b();
            bVarB.b(i2, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        d = configArr;
        f2164e = configArr;
        f2165f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f2166h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapD = d(bitmap.getConfig());
        Integer num2 = navigableMapD.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapD.remove(num);
                return;
            } else {
                navigableMapD.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    static String c(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<android.graphics.Bitmap$Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashMap, java.util.Map<android.graphics.Bitmap$Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>>] */
    private NavigableMap<Integer, Integer> d(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f2169c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f2169c.put(config, treeMap);
        return treeMap;
    }

    public final Bitmap b(int i2, int i4, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iC = s1.j.c(i2, i4, config);
        b bVarD = this.f2167a.d(iC, config);
        int i5 = 0;
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            configArr = f2164e;
        } else {
            int i6 = a.f2170a[config.ordinal()];
            configArr = i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? new Bitmap.Config[]{config} : f2166h : g : f2165f : d;
        }
        int length = configArr.length;
        while (true) {
            if (i5 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i5];
            Integer numCeilingKey = d(config2).ceilingKey(Integer.valueOf(iC));
            if (numCeilingKey == null || numCeilingKey.intValue() > iC * 8) {
                i5++;
            } else if (numCeilingKey.intValue() != iC || (config2 != null ? !config2.equals(config) : config != null)) {
                this.f2167a.c(bVarD);
                bVarD = this.f2167a.d(numCeilingKey.intValue(), config2);
            }
        }
        Bitmap bitmapA = this.f2168b.a(bVarD);
        if (bitmapA != null) {
            a(Integer.valueOf(bVarD.f2172b), bitmapA);
            bitmapA.reconfigure(i2, i4, config);
        }
        return bitmapA;
    }

    public final String e(Bitmap bitmap) {
        return c(s1.j.d(bitmap), bitmap.getConfig());
    }

    public final void f(Bitmap bitmap) {
        b bVarD = this.f2167a.d(s1.j.d(bitmap), bitmap.getConfig());
        this.f2168b.b(bVarD, bitmap);
        NavigableMap<Integer, Integer> navigableMapD = d(bitmap.getConfig());
        Integer num = navigableMapD.get(Integer.valueOf(bVarD.f2172b));
        navigableMapD.put(Integer.valueOf(bVarD.f2172b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final Bitmap g() {
        Bitmap bitmapD = this.f2168b.d();
        if (bitmapD != null) {
            a(Integer.valueOf(s1.j.d(bitmapD)), bitmapD);
        }
        return bitmapD;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.HashMap, java.util.Map<android.graphics.Bitmap$Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.HashMap, java.util.Map<android.graphics.Bitmap$Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>>] */
    public final String toString() {
        StringBuilder sbD = D2.e.d("SizeConfigStrategy{groupedMap=");
        sbD.append(this.f2168b);
        sbD.append(", sortedSizes=(");
        for (Map.Entry entry : this.f2169c.entrySet()) {
            sbD.append(entry.getKey());
            sbD.append('[');
            sbD.append(entry.getValue());
            sbD.append("], ");
        }
        if (!this.f2169c.isEmpty()) {
            sbD.replace(sbD.length() - 2, sbD.length(), "");
        }
        sbD.append(")}");
        return sbD.toString();
    }
}
