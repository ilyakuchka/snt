package q;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g<K, V> {

    /* renamed from: l, reason: collision with root package name */
    static Object[] f7627l;

    /* renamed from: m, reason: collision with root package name */
    static int f7628m;

    /* renamed from: n, reason: collision with root package name */
    static Object[] f7629n;

    /* renamed from: o, reason: collision with root package name */
    static int f7630o;

    /* renamed from: i, reason: collision with root package name */
    int[] f7631i;

    /* renamed from: j, reason: collision with root package name */
    Object[] f7632j;

    /* renamed from: k, reason: collision with root package name */
    int f7633k;

    public g() {
        this.f7631i = c.f7613a;
        this.f7632j = c.f7614b;
        this.f7633k = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (g.class) {
                Object[] objArr = f7629n;
                if (objArr != null) {
                    this.f7632j = objArr;
                    f7629n = (Object[]) objArr[0];
                    this.f7631i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f7630o--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f7627l;
                if (objArr2 != null) {
                    this.f7632j = objArr2;
                    f7627l = (Object[]) objArr2[0];
                    this.f7631i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f7628m--;
                    return;
                }
            }
        }
        this.f7631i = new int[i2];
        this.f7632j = new Object[i2 << 1];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f7630o < 10) {
                    objArr[0] = f7629n;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f7629n = objArr;
                    f7630o++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (f7628m < 10) {
                    objArr[0] = f7627l;
                    objArr[1] = iArr;
                    for (int i5 = (i2 << 1) - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f7627l = objArr;
                    f7628m++;
                }
            }
        }
    }

    public final void b(int i2) {
        int i4 = this.f7633k;
        int[] iArr = this.f7631i;
        if (iArr.length < i2) {
            Object[] objArr = this.f7632j;
            a(i2);
            if (this.f7633k > 0) {
                System.arraycopy(iArr, 0, this.f7631i, 0, i4);
                System.arraycopy(objArr, 0, this.f7632j, 0, i4 << 1);
            }
            c(iArr, objArr, i4);
        }
        if (this.f7633k != i4) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.f7633k;
        if (i2 > 0) {
            int[] iArr = this.f7631i;
            Object[] objArr = this.f7632j;
            this.f7631i = c.f7613a;
            this.f7632j = c.f7614b;
            this.f7633k = 0;
            c(iArr, objArr, i2);
        }
        if (this.f7633k > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    final int d(Object obj, int i2) {
        int i4 = this.f7633k;
        if (i4 == 0) {
            return -1;
        }
        try {
            int iA = c.a(this.f7631i, i4, i2);
            if (iA < 0 || obj.equals(this.f7632j[iA << 1])) {
                return iA;
            }
            int i5 = iA + 1;
            while (i5 < i4 && this.f7631i[i5] == i2) {
                if (obj.equals(this.f7632j[i5 << 1])) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = iA - 1; i6 >= 0 && this.f7631i[i6] == i2; i6--) {
                if (obj.equals(this.f7632j[i6 << 1])) {
                    return i6;
                }
            }
            return ~i5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f7633k != gVar.f7633k) {
                return false;
            }
            for (int i2 = 0; i2 < this.f7633k; i2++) {
                K kH = h(i2);
                V vL = l(i2);
                Object orDefault = gVar.getOrDefault(kH, null);
                if (vL == null) {
                    if (orDefault != null || !gVar.containsKey(kH)) {
                        return false;
                    }
                } else if (!vL.equals(orDefault)) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f7633k != map.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f7633k; i4++) {
                K kH2 = h(i4);
                V vL2 = l(i4);
                Object obj2 = map.get(kH2);
                if (vL2 == null) {
                    if (obj2 != null || !map.containsKey(kH2)) {
                        return false;
                    }
                } else if (!vL2.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    final int f() {
        int i2 = this.f7633k;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iA = c.a(this.f7631i, i2, 0);
            if (iA < 0 || this.f7632j[iA << 1] == null) {
                return iA;
            }
            int i4 = iA + 1;
            while (i4 < i2 && this.f7631i[i4] == 0) {
                if (this.f7632j[i4 << 1] == null) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iA - 1; i5 >= 0 && this.f7631i[i5] == 0; i5--) {
                if (this.f7632j[i5 << 1] == null) {
                    return i5;
                }
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    final int g(Object obj) {
        int i2 = this.f7633k * 2;
        Object[] objArr = this.f7632j;
        if (obj == null) {
            for (int i4 = 1; i4 < i2; i4 += 2) {
                if (objArr[i4] == null) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i2; i5 += 2) {
            if (obj.equals(objArr[i5])) {
                return i5 >> 1;
            }
        }
        return -1;
    }

    public final V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final V getOrDefault(Object obj, V v2) {
        int iE = e(obj);
        return iE >= 0 ? (V) this.f7632j[(iE << 1) + 1] : v2;
    }

    public final K h(int i2) {
        return (K) this.f7632j[i2 << 1];
    }

    public int hashCode() {
        int[] iArr = this.f7631i;
        Object[] objArr = this.f7632j;
        int i2 = this.f7633k;
        int i4 = 1;
        int i5 = 0;
        int iHashCode = 0;
        while (i5 < i2) {
            Object obj = objArr[i4];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i5];
            i5++;
            i4 += 2;
        }
        return iHashCode;
    }

    public void i(g<? extends K, ? extends V> gVar) {
        int i2 = gVar.f7633k;
        b(this.f7633k + i2);
        if (this.f7633k != 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                put(gVar.h(i4), gVar.l(i4));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.f7631i, 0, this.f7631i, 0, i2);
            System.arraycopy(gVar.f7632j, 0, this.f7632j, 0, i2 << 1);
            this.f7633k = i2;
        }
    }

    public final boolean isEmpty() {
        return this.f7633k <= 0;
    }

    public V j(int i2) {
        Object[] objArr = this.f7632j;
        int i4 = i2 << 1;
        V v2 = (V) objArr[i4 + 1];
        int i5 = this.f7633k;
        if (i5 <= 1) {
            clear();
        } else {
            int i6 = i5 - 1;
            int[] iArr = this.f7631i;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.f7632j;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i4, i8 << 1);
                }
                Object[] objArr3 = this.f7632j;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i5 > 8 ? i5 + (i5 >> 1) : 8);
                if (i5 != this.f7633k) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f7631i, 0, i2);
                    System.arraycopy(objArr, 0, this.f7632j, 0, i4);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.f7631i, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.f7632j, i4, i11 << 1);
                }
            }
            if (i5 != this.f7633k) {
                throw new ConcurrentModificationException();
            }
            this.f7633k = i6;
        }
        return v2;
    }

    public V k(int i2, V v2) {
        int i4 = (i2 << 1) + 1;
        Object[] objArr = this.f7632j;
        V v4 = (V) objArr[i4];
        objArr[i4] = v2;
        return v4;
    }

    public final V l(int i2) {
        return (V) this.f7632j[(i2 << 1) + 1];
    }

    public V put(K k2, V v2) {
        int i2;
        int iD;
        int i4 = this.f7633k;
        if (k2 == null) {
            iD = f();
            i2 = 0;
        } else {
            int iHashCode = k2.hashCode();
            i2 = iHashCode;
            iD = d(k2, iHashCode);
        }
        if (iD >= 0) {
            int i5 = (iD << 1) + 1;
            Object[] objArr = this.f7632j;
            V v4 = (V) objArr[i5];
            objArr[i5] = v2;
            return v4;
        }
        int i6 = ~iD;
        int[] iArr = this.f7631i;
        if (i4 >= iArr.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            Object[] objArr2 = this.f7632j;
            a(i7);
            if (i4 != this.f7633k) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f7631i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f7632j, 0, objArr2.length);
            }
            c(iArr, objArr2, i4);
        }
        if (i6 < i4) {
            int[] iArr3 = this.f7631i;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.f7632j;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f7633k - i6) << 1);
        }
        int i9 = this.f7633k;
        if (i4 == i9) {
            int[] iArr4 = this.f7631i;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr4 = this.f7632j;
                int i10 = i6 << 1;
                objArr4[i10] = k2;
                objArr4[i10 + 1] = v2;
                this.f7633k = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final V putIfAbsent(K k2, V v2) {
        V orDefault = getOrDefault(k2, null);
        return orDefault == null ? put(k2, v2) : orDefault;
    }

    public final V remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return j(iE);
        }
        return null;
    }

    public final V replace(K k2, V v2) {
        int iE = e(k2);
        if (iE >= 0) {
            return k(iE, v2);
        }
        return null;
    }

    public final int size() {
        return this.f7633k;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f7633k * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f7633k; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K kH = h(i2);
            if (kH != this) {
                sb.append(kH);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vL = l(i2);
            if (vL != this) {
                sb.append(vL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        V vL = l(iE);
        if (obj2 != vL && (obj2 == null || !obj2.equals(vL))) {
            return false;
        }
        j(iE);
        return true;
    }

    public final boolean replace(K k2, V v2, V v4) {
        int iE = e(k2);
        if (iE < 0) {
            return false;
        }
        V vL = l(iE);
        if (vL != v2 && (v2 == null || !v2.equals(vL))) {
            return false;
        }
        k(iE, v4);
        return true;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.f7631i = c.f7613a;
            this.f7632j = c.f7614b;
        } else {
            a(i2);
        }
        this.f7633k = 0;
    }
}
