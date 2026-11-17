package L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import t.C0384b;

/* loaded from: classes.dex */
public final class s implements Iterable<Y2.d<? extends String, ? extends String>> {

    /* renamed from: j, reason: collision with root package name */
    public static final b f478j = new b();

    /* renamed from: i, reason: collision with root package name */
    private final String[] f479i;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f480a = new ArrayList(20);

        public final a a(String str, String str2) {
            f3.c.d(str2, "value");
            b.a(str);
            b.b(str2, str);
            b(str, str2);
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        public final a b(String str, String str2) {
            f3.c.d(str, "name");
            f3.c.d(str2, "value");
            this.f480a.add(str);
            this.f480a.add(i3.f.D(str2).toString());
            return this;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        public final s c() {
            Object[] array = this.f480a.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new s((String[]) array);
        }

        public final List<String> d() {
            return this.f480a;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        public final a e(String str) {
            int i2 = 0;
            while (i2 < this.f480a.size()) {
                if (i3.f.q(str, (String) this.f480a.get(i2))) {
                    this.f480a.remove(i2);
                    this.f480a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public final a f(String str, String str2) {
            f3.c.d(str2, "value");
            b.a(str);
            b.b(str2, str);
            e(str);
            b(str, str2);
            return this;
        }
    }

    public static final class b {
        public static final /* synthetic */ void a(String str) {
            s.f478j.c(str);
        }

        public static final /* synthetic */ void b(String str, String str2) {
            s.f478j.d(str, str2);
        }

        private final void c(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i4 = i2 + 1;
                char cCharAt = str.charAt(i2);
                if (!('!' <= cCharAt && cCharAt < 127)) {
                    throw new IllegalArgumentException(M3.c.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), str).toString());
                }
                i2 = i4;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void d(String str, String str2) {
            boolean z4;
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i4 = i2 + 1;
                char cCharAt = str.charAt(i2);
                if (cCharAt == '\t') {
                    z4 = true;
                } else {
                    if (!(' ' <= cCharAt && cCharAt < 127)) {
                        z4 = false;
                    }
                }
                if (!z4) {
                    throw new IllegalArgumentException(f3.c.h(M3.c.j("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i2), str2), M3.c.r(str2) ? "" : f3.c.h(": ", str)).toString());
                }
                i2 = i4;
            }
        }

        public final s e(String... strArr) {
            int i2 = 0;
            if (!(strArr.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                if (!(strArr2[i4] != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                strArr2[i4] = i3.f.D(strArr2[i4]).toString();
                i4 = i5;
            }
            int iO = C0384b.o(0, strArr2.length - 1, 2);
            if (iO >= 0) {
                while (true) {
                    int i6 = i2 + 2;
                    String str = strArr2[i2];
                    String str2 = strArr2[i2 + 1];
                    c(str);
                    d(str2, str);
                    if (i2 == iO) {
                        break;
                    }
                    i2 = i6;
                }
            }
            return new s(strArr2);
        }
    }

    public s(String[] strArr) {
        this.f479i = strArr;
    }

    public final String d(String str) {
        f3.c.d(str, "name");
        String[] strArr = this.f479i;
        int length = strArr.length - 2;
        int iO = C0384b.o(length, 0, -2);
        if (iO <= length) {
            while (true) {
                int i2 = length - 2;
                if (i3.f.q(str, strArr[length])) {
                    return strArr[length + 1];
                }
                if (length == iO) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s) && Arrays.equals(this.f479i, ((s) obj).f479i);
    }

    public final String g(int i2) {
        return this.f479i[i2 * 2];
    }

    public final Set<String> h() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        f3.c.c(comparator, "CASE_INSENSITIVE_ORDER");
        TreeSet treeSet = new TreeSet(comparator);
        int length = this.f479i.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            treeSet.add(g(i2));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        f3.c.c(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f479i);
    }

    public final a i() {
        a aVar = new a();
        List<String> listD = aVar.d();
        String[] strArr = this.f479i;
        f3.c.d(listD, "<this>");
        f3.c.d(strArr, "elements");
        listD.addAll(Z2.d.a(strArr));
        return aVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<Y2.d<? extends String, ? extends String>> iterator() {
        int length = this.f479i.length / 2;
        Y2.d[] dVarArr = new Y2.d[length];
        for (int i2 = 0; i2 < length; i2++) {
            dVarArr[i2] = new Y2.d(g(i2), k(i2));
        }
        return f3.c.f(dVarArr);
    }

    public final String k(int i2) {
        return this.f479i[(i2 * 2) + 1];
    }

    public final List<String> l(String str) {
        f3.c.d(str, "name");
        int length = this.f479i.length / 2;
        ArrayList arrayList = null;
        int i2 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            if (i3.f.q(str, g(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(k(i2));
            }
            i2 = i4;
        }
        if (arrayList == null) {
            return Z2.m.f2185i;
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        f3.c.c(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public final int size() {
        return this.f479i.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f479i.length / 2;
        int i2 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            String strG = g(i2);
            String strK = k(i2);
            sb.append(strG);
            sb.append(": ");
            if (M3.c.r(strG)) {
                strK = "██";
            }
            sb.append(strK);
            sb.append("\n");
            i2 = i4;
        }
        String string = sb.toString();
        f3.c.c(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
