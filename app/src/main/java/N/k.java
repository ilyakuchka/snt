package N;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class k<T> extends AbstractList<T> {

    /* renamed from: r, reason: collision with root package name */
    private static final ArrayList f689r = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private int f690i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList<List<T>> f691j;

    /* renamed from: k, reason: collision with root package name */
    private int f692k;

    /* renamed from: l, reason: collision with root package name */
    private int f693l;

    /* renamed from: m, reason: collision with root package name */
    private int f694m;

    /* renamed from: n, reason: collision with root package name */
    private int f695n;

    /* renamed from: o, reason: collision with root package name */
    private int f696o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f697q;

    interface a {
        void d(int i2);

        void g(int i2, int i4);
    }

    k() {
        this.f690i = 0;
        this.f691j = new ArrayList<>();
        this.f692k = 0;
        this.f693l = 0;
        this.f694m = 0;
        this.f695n = 0;
        this.f696o = 1;
        this.p = 0;
        this.f697q = 0;
    }

    private void x(int i2, List<T> list, int i4, int i5) {
        this.f690i = i2;
        this.f691j.clear();
        this.f691j.add(list);
        this.f692k = i4;
        this.f693l = i5;
        int size = list.size();
        this.f694m = size;
        this.f695n = size;
        this.f696o = list.size();
        this.p = 0;
        this.f697q = 0;
    }

    public final void A(int i2, List<T> list, a aVar) {
        int size = list.size();
        if (size != this.f696o) {
            int size2 = size();
            int i4 = this.f696o;
            boolean z4 = false;
            boolean z5 = i2 == size2 - (size2 % i4) && size < i4;
            if (this.f692k == 0 && this.f691j.size() == 1 && size > this.f696o) {
                z4 = true;
            }
            if (!z4 && !z5) {
                throw new IllegalArgumentException("page introduces incorrect tiling");
            }
            if (z4) {
                this.f696o = size;
            }
        }
        int i5 = i2 / this.f696o;
        d(i5, i5);
        int i6 = i5 - (this.f690i / this.f696o);
        List<T> list2 = this.f691j.get(i6);
        if (list2 != null && list2 != f689r) {
            throw new IllegalArgumentException("Invalid position " + i2 + ": data already loaded");
        }
        this.f691j.set(i6, list);
        this.f694m += size;
        if (aVar != null) {
            aVar.g(i2, size);
        }
    }

    final void B(List<T> list, a aVar) {
        int size = list.size();
        if (size == 0) {
            ((d) aVar).f622y = 2;
            return;
        }
        int i2 = this.f696o;
        if (i2 > 0 && size != i2) {
            if (this.f691j.size() != 1 || size <= this.f696o) {
                this.f696o = -1;
            } else {
                this.f696o = size;
            }
        }
        this.f691j.add(0, list);
        this.f694m += size;
        this.f695n += size;
        int iMin = Math.min(this.f690i, size);
        int i4 = size - iMin;
        if (iMin != 0) {
            this.f690i -= iMin;
        }
        this.f693l -= i4;
        this.p += size;
        ((d) aVar).C(this.f690i, iMin, i4);
    }

    final k<T> C() {
        return new k<>(this);
    }

    final void D(int i2, List list, int i4, int i5, a aVar) {
        int i6 = this.f695n / 2;
        A(i2, list, aVar);
    }

    final void d(int i2, int i4) {
        int i5;
        int i6 = this.f690i / this.f696o;
        if (i2 < i6) {
            int i7 = 0;
            while (true) {
                i5 = i6 - i2;
                if (i7 >= i5) {
                    break;
                }
                this.f691j.add(0, null);
                i7++;
            }
            int i8 = i5 * this.f696o;
            this.f695n += i8;
            this.f690i -= i8;
        } else {
            i2 = i6;
        }
        if (i4 >= this.f691j.size() + i2) {
            int iMin = Math.min(this.f692k, ((i4 + 1) - (this.f691j.size() + i2)) * this.f696o);
            for (int size = this.f691j.size(); size <= i4 - i2; size++) {
                ArrayList<List<T>> arrayList = this.f691j;
                arrayList.add(arrayList.size(), null);
            }
            this.f695n += iMin;
            this.f692k -= iMin;
        }
    }

    public final void g(int i2, int i4, int i5, a aVar) {
        int i6 = this.f696o;
        if (i5 != i6) {
            if (i5 < i6) {
                throw new IllegalArgumentException("Page size cannot be reduced");
            }
            if (this.f691j.size() != 1 || this.f692k != 0) {
                throw new IllegalArgumentException("Page size can change only if last page is only one present");
            }
            this.f696o = i5;
        }
        int size = size();
        int i7 = this.f696o;
        int i8 = ((size + i7) - 1) / i7;
        int iMax = Math.max((i2 - i4) / i7, 0);
        int iMin = Math.min((i2 + i4) / this.f696o, i8 - 1);
        d(iMax, iMin);
        int i9 = this.f690i / this.f696o;
        while (iMax <= iMin) {
            int i10 = iMax - i9;
            if (this.f691j.get(i10) == null) {
                this.f691j.set(i10, f689r);
                aVar.d(iMax);
            }
            iMax++;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            StringBuilder sbC = C2.c.c("Index: ", i2, ", Size: ");
            sbC.append(size());
            throw new IndexOutOfBoundsException(sbC.toString());
        }
        int i4 = i2 - this.f690i;
        if (i4 >= 0 && i4 < this.f695n) {
            int i5 = this.f696o;
            int i6 = 0;
            if (i5 > 0) {
                i6 = i4 / i5;
                i4 %= i5;
            } else {
                int size = this.f691j.size();
                while (i6 < size) {
                    int size2 = this.f691j.get(i6).size();
                    if (size2 > i4) {
                        break;
                    }
                    i4 -= size2;
                    i6++;
                }
            }
            List<T> list = this.f691j.get(i6);
            if (list != null && list.size() != 0) {
                return list.get(i4);
            }
        }
        return null;
    }

    final void h(List<T> list, a aVar) {
        int size = list.size();
        if (size == 0) {
            ((d) aVar).f623z = 2;
            return;
        }
        if (this.f696o > 0) {
            int size2 = this.f691j.get(r1.size() - 1).size();
            int i2 = this.f696o;
            if (size2 != i2 || size > i2) {
                this.f696o = -1;
            }
        }
        this.f691j.add(list);
        this.f694m += size;
        this.f695n += size;
        int iMin = Math.min(this.f692k, size);
        int i4 = size - iMin;
        if (iMin != 0) {
            this.f692k -= iMin;
        }
        this.f697q += size;
        ((d) aVar).B((this.f690i + this.f695n) - size, iMin, i4);
    }

    final int i() {
        int i2 = this.f690i;
        int size = this.f691j.size();
        for (int i4 = 0; i4 < size; i4++) {
            List<T> list = this.f691j.get(i4);
            if (list != null && list != f689r) {
                break;
            }
            i2 += this.f696o;
        }
        return i2;
    }

    final int k() {
        List<T> list;
        int i2 = this.f692k;
        int size = this.f691j.size();
        while (true) {
            size--;
            if (size < 0 || !((list = this.f691j.get(size)) == null || list == f689r)) {
                break;
            }
            i2 += this.f696o;
        }
        return i2;
    }

    final T l() {
        return this.f691j.get(0).get(0);
    }

    final T n() {
        return this.f691j.get(r1.size() - 1).get(r1.size() - 1);
    }

    final int o() {
        return this.f690i;
    }

    final int p() {
        return (this.f695n / 2) + this.f690i + this.f693l;
    }

    final int q() {
        return this.f697q;
    }

    final int r() {
        return this.p;
    }

    final int s() {
        return this.f691j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f690i + this.f695n + this.f692k;
    }

    final int t() {
        return this.f693l;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sbD = D2.e.d("leading ");
        sbD.append(this.f690i);
        sbD.append(", storage ");
        sbD.append(this.f695n);
        sbD.append(", trailing ");
        sbD.append(this.f692k);
        StringBuilder sb = new StringBuilder(sbD.toString());
        for (int i2 = 0; i2 < this.f691j.size(); i2++) {
            sb.append(" ");
            sb.append(this.f691j.get(i2));
        }
        return sb.toString();
    }

    final int u() {
        return this.f695n;
    }

    final int v() {
        return this.f692k;
    }

    public final boolean w(int i2, int i4) {
        List<T> list;
        int i5 = this.f690i / i2;
        return i4 >= i5 && i4 < this.f691j.size() + i5 && (list = this.f691j.get(i4 - i5)) != null && list != f689r;
    }

    final void y(int i2, List<T> list, int i4, int i5, a aVar) {
        x(i2, list, i4, i5);
        ((d) aVar).A(size());
    }

    final void z(int i2, List<T> list, int i4, int i5, int i6, a aVar) {
        int size = ((i6 - 1) + list.size()) / i6;
        int i7 = 0;
        while (i7 < size) {
            int i8 = i7 * i6;
            int i9 = i7 + 1;
            List<T> listSubList = list.subList(i8, Math.min(list.size(), i9 * i6));
            if (i7 == 0) {
                x(i2, listSubList, (list.size() + i4) - listSubList.size(), i5);
            } else {
                A(i8 + i2, listSubList, null);
            }
            i7 = i9;
        }
        ((p) aVar).w(0, size());
    }

    private k(k<T> kVar) {
        this.f690i = kVar.f690i;
        this.f691j = new ArrayList<>(kVar.f691j);
        this.f692k = kVar.f692k;
        this.f693l = kVar.f693l;
        this.f694m = kVar.f694m;
        this.f695n = kVar.f695n;
        this.f696o = kVar.f696o;
        this.p = kVar.p;
        this.f697q = kVar.f697q;
    }
}
