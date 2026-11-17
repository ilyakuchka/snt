package x0;

import android.text.TextUtils;
import com.android.mmt.util.C0292y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import x0.f;

/* renamed from: x0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0415b extends ArrayList<C0414a> {

    /* renamed from: i, reason: collision with root package name */
    private Set<C0414a> f8042i = new HashSet();

    public static C0415b i(String str) {
        C0415b c0415b = new C0415b();
        Iterator it = ((ArrayList) f.e(str)).iterator();
        while (it.hasNext()) {
            f.b bVar = (f.b) it.next();
            if (bVar != null && !TextUtils.isEmpty(bVar.f8094b)) {
                C0414a c0414aO = C0414a.O(bVar.f8094b);
                c0414aO.t0(bVar.f8093a);
                c0414aO.q0(bVar.f8095c);
                c0415b.add(c0414aO);
            }
        }
        return c0415b;
    }

    public static C0415b k(Iterable<String> iterable) {
        C0415b c0415b = new C0415b();
        for (String str : iterable) {
            if (!TextUtils.isEmpty(str)) {
                c0415b.add(C0414a.O(str));
            }
        }
        return c0415b;
    }

    public static C0415b l(String str, boolean z4) {
        C0415b c0415b = new C0415b();
        for (String str2 : str.split(";")) {
            if (!TextUtils.isEmpty(str2)) {
                C0414a c0414aO = C0414a.O(str2);
                if (z4) {
                    c0414aO.s0(str2);
                }
                c0415b.add(c0414aO);
            }
        }
        return c0415b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        C0414a c0414a = (C0414a) obj;
        this.f8042i.add(c0414a);
        super.add(i2, c0414a);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends C0414a> collection) {
        Iterator<? extends C0414a> it = collection.iterator();
        while (it.hasNext()) {
            this.f8042i.add(it.next());
        }
        return super.addAll(collection);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f8042i.clear();
        super.clear();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final boolean add(C0414a c0414a) {
        this.f8042i.add(c0414a);
        return super.add(c0414a);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0415b.class != obj.getClass()) {
            return false;
        }
        return this.f8042i.equals(((C0415b) obj).f8042i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[PHI: r1
      0x0026: PHI (r1v3 int) = (r1v1 int), (r1v5 int) binds: [B:6:0x0012, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g(char[] cArr) {
        Iterator<C0414a> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C0414a next = it.next();
            if (i2 > 0) {
                int length = i2 + 2 > cArr.length ? cArr.length - i2 : 2;
                ", ".getChars(0, length, cArr, i2);
                i2 += length;
                if (i2 == cArr.length) {
                    break;
                }
                String strQ = next.Q();
                int length2 = strQ.length();
                if (i2 + length2 > cArr.length) {
                    length2 = cArr.length - i2;
                }
                strQ.getChars(0, length2, cArr, i2);
                i2 += length2;
                if (i2 == cArr.length) {
                    break;
                }
            }
        }
        return i2;
    }

    public final String h(String str) {
        String[] strArr = new String[size()];
        Iterator<C0414a> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = it.next().U();
            i2++;
        }
        return TextUtils.join(str, strArr);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        return this.f8042i.hashCode();
    }

    public final String[] n(boolean z4) {
        ArrayList arrayList = new ArrayList();
        Iterator<C0414a> it = iterator();
        while (it.hasNext()) {
            String strW = it.next().W();
            if (z4) {
                strW = C0292y.e(strW);
            }
            if (!TextUtils.isEmpty(strW) && !arrayList.contains(strW)) {
                arrayList.add(strW);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void o(boolean z4, boolean z5) {
        Iterator<C0414a> it = iterator();
        while (it.hasNext()) {
            it.next().m0(z4, z5);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final C0414a remove(int i2) {
        C0414a c0414a = (C0414a) super.remove(i2);
        this.f8042i.remove(c0414a);
        return c0414a;
    }

    public final String q() {
        return TextUtils.join(";", n(false));
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<?> collection) {
        this.f8042i.removeAll(collection);
        return super.removeAll(collection);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<x0.a>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        C0414a c0414a = (C0414a) obj;
        C0414a c0414a2 = (C0414a) super.set(i2, c0414a);
        this.f8042i.remove(c0414a2);
        this.f8042i.add(c0414a);
        return c0414a2;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size(); i2++) {
            arrayList.add(get(i2).R());
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i4 = 0; i4 < size(); i4++) {
            if (i4 != 0) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        this.f8042i.remove(obj);
        return super.remove(obj);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.HashSet, java.util.Set<x0.a>] */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends C0414a> collection) {
        Iterator<? extends C0414a> it = collection.iterator();
        while (it.hasNext()) {
            this.f8042i.add(it.next());
        }
        return super.addAll(i2, collection);
    }
}
