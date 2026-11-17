package X3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class p extends Z2.b<g> implements RandomAccess {

    /* renamed from: k, reason: collision with root package name */
    public static final a f1868k = new a();

    /* renamed from: i, reason: collision with root package name */
    private final g[] f1869i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f1870j;

    public static final class a {
        private final void a(long j2, d dVar, int i2, List<? extends g> list, int i4, int i5, List<Integer> list2) throws IOException {
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            long j4;
            d dVar2;
            long j5;
            int i11 = i2;
            if (!(i4 < i5)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i4 < i5) {
                int i12 = i4;
                while (true) {
                    int i13 = i12 + 1;
                    if (!(list.get(i12).h() >= i11)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i13 >= i5) {
                        break;
                    } else {
                        i12 = i13;
                    }
                }
            }
            g gVar = list.get(i4);
            g gVar2 = list.get(i5 - 1);
            if (i11 == gVar.h()) {
                int iIntValue = list2.get(i4).intValue();
                int i14 = i4 + 1;
                g gVar3 = list.get(i14);
                i6 = i14;
                i7 = iIntValue;
                gVar = gVar3;
            } else {
                i6 = i4;
                i7 = -1;
            }
            if (gVar.k(i11) == gVar2.k(i11)) {
                int iMin = Math.min(gVar.h(), gVar2.h());
                if (i11 < iMin) {
                    int i15 = i11;
                    i8 = 0;
                    while (true) {
                        int i16 = i15 + 1;
                        if (gVar.k(i15) != gVar2.k(i15)) {
                            break;
                        }
                        i8++;
                        if (i16 >= iMin) {
                            break;
                        } else {
                            i15 = i16;
                        }
                    }
                } else {
                    i8 = 0;
                }
                long j6 = 4;
                long jN0 = (dVar.n0() / j6) + j2 + 2 + i8 + 1;
                dVar.w0(-i8);
                dVar.w0(i7);
                int i17 = i11 + i8;
                if (i11 < i17) {
                    while (true) {
                        int i18 = i11 + 1;
                        dVar.w0(gVar.k(i11) & 255);
                        if (i18 >= i17) {
                            break;
                        } else {
                            i11 = i18;
                        }
                    }
                }
                if (i6 + 1 == i5) {
                    if (!(i17 == list.get(i6).h())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    dVar.w0(list2.get(i6).intValue());
                    return;
                } else {
                    d dVar3 = new d();
                    dVar.w0(((int) ((dVar3.n0() / j6) + jN0)) * (-1));
                    a(jN0, dVar3, i17, list, i6, i5, list2);
                    dVar.t0(dVar3);
                    return;
                }
            }
            int i19 = i6 + 1;
            int i20 = 1;
            if (i19 < i5) {
                while (true) {
                    int i21 = i19 + 1;
                    if (list.get(i19 - 1).k(i11) != list.get(i19).k(i11)) {
                        i20++;
                    }
                    if (i21 >= i5) {
                        break;
                    } else {
                        i19 = i21;
                    }
                }
            }
            long j7 = 4;
            long jN02 = (i20 * 2) + (dVar.n0() / j7) + j2 + 2;
            dVar.w0(i20);
            dVar.w0(i7);
            if (i6 < i5) {
                int i22 = i6;
                while (true) {
                    int i23 = i22 + 1;
                    byte bK = list.get(i22).k(i11);
                    if (i22 == i6 || bK != list.get(i22 - 1).k(i11)) {
                        dVar.w0(bK & 255);
                    }
                    if (i23 >= i5) {
                        break;
                    } else {
                        i22 = i23;
                    }
                }
            }
            d dVar4 = new d();
            while (i6 < i5) {
                byte bK2 = list.get(i6).k(i11);
                int i24 = i6 + 1;
                if (i24 < i5) {
                    int i25 = i24;
                    while (true) {
                        int i26 = i25 + 1;
                        if (bK2 != list.get(i25).k(i11)) {
                            i9 = i25;
                            break;
                        } else if (i26 >= i5) {
                            break;
                        } else {
                            i25 = i26;
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i5;
                }
                if (i24 == i9 && i11 + 1 == list.get(i6).h()) {
                    dVar.w0(list2.get(i6).intValue());
                    i10 = i9;
                    j5 = j7;
                    j4 = jN02;
                    dVar2 = dVar4;
                } else {
                    dVar.w0(((int) ((dVar4.n0() / j7) + jN02)) * (-1));
                    i10 = i9;
                    j4 = jN02;
                    dVar2 = dVar4;
                    j5 = j7;
                    a(jN02, dVar4, i11 + 1, list, i6, i10, list2);
                }
                dVar4 = dVar2;
                i6 = i10;
                j7 = j5;
                jN02 = j4;
            }
            dVar.t0(dVar4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:90:0x0168, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final p b(g... gVarArr) throws IOException {
            int i2;
            int i4 = 0;
            if (gVarArr.length == 0) {
                return new p(new g[0], new int[]{0, -1});
            }
            List<? extends g> listF = Z2.d.f(gVarArr);
            ArrayList arrayList = (ArrayList) listF;
            if (arrayList.size() > 1) {
                Collections.sort(listF);
            }
            ArrayList arrayList2 = new ArrayList(gVarArr.length);
            for (g gVar : gVarArr) {
                arrayList2.add(-1);
            }
            Object[] array = arrayList2.toArray(new Integer[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Integer[] numArr = (Integer[]) array;
            List<Integer> listI = Z2.g.i(Arrays.copyOf(numArr, numArr.length));
            int length = gVarArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                g gVar2 = gVarArr[i5];
                int i7 = i6 + 1;
                int size = arrayList.size();
                int size2 = arrayList.size();
                if (size < 0) {
                    throw new IllegalArgumentException("fromIndex (0) is greater than toIndex (" + size + ").");
                }
                if (size > size2) {
                    throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
                }
                int i8 = size - 1;
                int i9 = 0;
                while (true) {
                    if (i9 > i8) {
                        i2 = -(i9 + 1);
                        break;
                    }
                    i2 = (i9 + i8) >>> 1;
                    Comparable comparable = (Comparable) arrayList.get(i2);
                    int iCompareTo = comparable == gVar2 ? 0 : comparable == null ? -1 : gVar2 == null ? 1 : comparable.compareTo(gVar2);
                    if (iCompareTo < 0) {
                        i9 = i2 + 1;
                    } else if (iCompareTo > 0) {
                        i8 = i2 - 1;
                    }
                }
                listI.set(i2, Integer.valueOf(i6));
                i5++;
                i6 = i7;
            }
            if (!(((g) arrayList.get(0)).h() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i10 = 0;
            while (i10 < arrayList.size()) {
                g gVar3 = (g) arrayList.get(i10);
                int i11 = i10 + 1;
                int i12 = i11;
                while (i12 < arrayList.size()) {
                    g gVar4 = (g) arrayList.get(i12);
                    Objects.requireNonNull(gVar4);
                    f3.c.d(gVar3, "prefix");
                    if (!gVar4.m(gVar3, gVar3.h())) {
                        break;
                    }
                    if (!(gVar4.h() != gVar3.h())) {
                        throw new IllegalArgumentException(f3.c.h("duplicate option: ", gVar4).toString());
                    }
                    if (listI.get(i12).intValue() > listI.get(i10).intValue()) {
                        arrayList.remove(i12);
                        listI.remove(i12);
                    } else {
                        i12++;
                    }
                }
                i10 = i11;
            }
            d dVar = new d();
            a(0L, dVar, 0, listF, 0, arrayList.size(), listI);
            int[] iArr = new int[(int) (dVar.n0() / 4)];
            while (!dVar.V()) {
                iArr[i4] = dVar.readInt();
                i4++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(gVarArr, gVarArr.length);
            f3.c.c(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new p((g[]) objArrCopyOf, iArr);
        }
    }

    public p(g[] gVarArr, int[] iArr) {
        this.f1869i = gVarArr;
        this.f1870j = iArr;
    }

    @Override // Z2.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof g) {
            return super.contains((g) obj);
        }
        return false;
    }

    @Override // Z2.a
    public final int d() {
        return this.f1869i.length;
    }

    public final g[] g() {
        return this.f1869i;
    }

    @Override // Z2.b, java.util.List
    public final Object get(int i2) {
        return this.f1869i[i2];
    }

    public final int[] h() {
        return this.f1870j;
    }

    @Override // Z2.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof g) {
            return super.indexOf((g) obj);
        }
        return -1;
    }

    @Override // Z2.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof g) {
            return super.lastIndexOf((g) obj);
        }
        return -1;
    }
}
