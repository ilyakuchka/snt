package G0;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import k0.C0341b;

/* loaded from: classes.dex */
public final class o extends l implements List<k>, Z3.a {

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList<k> f181j;

    /* renamed from: k, reason: collision with root package name */
    private k f182k;

    /* renamed from: l, reason: collision with root package name */
    private k f183l;

    /* renamed from: m, reason: collision with root package name */
    private k f184m;

    /* renamed from: n, reason: collision with root package name */
    private k f185n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f186o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f187q;

    /* renamed from: r, reason: collision with root package name */
    private int f188r;

    /* renamed from: s, reason: collision with root package name */
    private int f189s;

    /* renamed from: t, reason: collision with root package name */
    private p f190t;

    public o(p pVar) {
        this.f181j = new ArrayList<>();
        this.f186o = true;
        this.p = true;
        this.f187q = true;
        this.f188r = 5000;
        this.f190t = pVar;
    }

    private void D(k kVar) throws IllegalStateException, C0341b {
        if (kVar == null) {
            return;
        }
        if (kVar.y()) {
            String str = kVar.f171o;
            if (TextUtils.isEmpty(str) || "text/plain".equals(str) || "text/html".equals(str)) {
                E(this.f182k, kVar);
                this.f182k = kVar;
                return;
            } else {
                StringBuilder sbD = D2.e.d("[SlideModel] content type ");
                sbD.append(kVar.f171o);
                sbD.append(" isn't supported (as text)");
                Log.w("Mms/slideshow", sbD.toString());
                return;
            }
        }
        if (kVar.f169m.equals("img")) {
            if (this.f186o) {
                E(this.f183l, kVar);
                this.f183l = kVar;
                this.f187q = false;
                return;
            } else {
                StringBuilder sbD2 = D2.e.d("[SlideModel] content type ");
                sbD2.append(kVar.f171o);
                sbD2.append(" - can't add image in this state");
                Log.w("Mms/slideshow", sbD2.toString());
                return;
            }
        }
        if (kVar.f169m.equals("audio")) {
            if (this.p) {
                E(this.f184m, kVar);
                this.f184m = kVar;
                this.f187q = false;
                return;
            } else {
                StringBuilder sbD3 = D2.e.d("[SlideModel] content type ");
                sbD3.append(kVar.f171o);
                sbD3.append(" - can't add audio in this state");
                Log.w("Mms/slideshow", sbD3.toString());
                return;
            }
        }
        if (kVar.z()) {
            if (this.f187q) {
                E(this.f185n, kVar);
                this.f185n = kVar;
                this.f186o = false;
                this.p = false;
                return;
            }
            StringBuilder sbD4 = D2.e.d("[SlideModel] content type ");
            sbD4.append(kVar.f171o);
            sbD4.append(" - can't add video in this state");
            Log.w("Mms/slideshow", sbD4.toString());
        }
    }

    private void E(k kVar, k kVar2) throws C0341b {
        p pVar;
        p pVar2;
        Objects.requireNonNull(kVar2);
        int i2 = kVar2 instanceof i ? 0 : kVar2.f173r;
        if (kVar == null) {
            p pVar3 = this.f190t;
            if (pVar3 != null) {
                pVar3.r(i2);
            }
            this.f181j.add(kVar2);
            if (i2 > 0) {
                this.f189s += i2;
            }
            if (i2 > 0 && (pVar2 = this.f190t) != null) {
                this.f190t.F(pVar2.y() + i2);
            }
        } else {
            int i4 = kVar instanceof i ? 0 : kVar.f173r;
            if (i2 > i4) {
                p pVar4 = this.f190t;
                if (pVar4 != null) {
                    pVar4.r(i2 - i4);
                }
                int i5 = i2 - i4;
                if (i5 > 0) {
                    this.f189s += i5;
                }
                if (i5 > 0 && (pVar = this.f190t) != null) {
                    this.f190t.F(pVar.y() + i5);
                }
            } else {
                int i6 = i4 - i2;
                r(i6);
                q(i6);
            }
            ArrayList<k> arrayList = this.f181j;
            arrayList.set(arrayList.indexOf(kVar), kVar2);
            kVar.k();
        }
        Iterator<h> it = this.f174i.iterator();
        while (it.hasNext()) {
            kVar2.h(it.next());
        }
    }

    private boolean F(Object obj) {
        if (!this.f181j.remove(obj)) {
            return false;
        }
        if (obj instanceof q) {
            this.f182k = null;
        } else if (obj instanceof i) {
            this.f183l = null;
            this.f187q = true;
        } else if (obj instanceof a) {
            this.f184m = null;
            this.f187q = true;
        } else if (obj instanceof s) {
            this.f185n = null;
            this.f186o = true;
            this.p = true;
        }
        k kVar = (k) obj;
        Objects.requireNonNull(kVar);
        int i2 = kVar instanceof i ? 0 : kVar.f173r;
        r(i2);
        q(i2);
        ((l) obj).k();
        return true;
    }

    public final boolean A() {
        return this.f183l != null;
    }

    public final boolean B() {
        return this.f182k != null;
    }

    public final boolean C() {
        return this.f185n != null;
    }

    public final boolean G() {
        boolean zRemove = remove(this.f184m);
        if (!z() && !C()) {
            this.f188r = 5000;
        }
        return zRemove;
    }

    public final boolean H() {
        return remove(this.f183l);
    }

    public final boolean I() {
        boolean zRemove = remove(this.f185n);
        if (!z() && !C()) {
            this.f188r = 5000;
        }
        return zRemove;
    }

    public final void J(p pVar) {
        this.f190t = pVar;
    }

    public final void K(int i2) {
        if (i2 <= 0) {
            return;
        }
        int i4 = this.f188r;
        if (i2 > i4 || i4 == 5000) {
            this.f188r = i2;
        }
    }

    @Override // java.util.List
    public final void add(int i2, k kVar) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends k> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        if (this.f181j.size() > 0) {
            Iterator<k> it = this.f181j.iterator();
            while (it.hasNext()) {
                k next = it.next();
                next.k();
                int i2 = next.f173r;
                r(i2);
                q(i2);
            }
            this.f181j.clear();
            this.f182k = null;
            this.f183l = null;
            this.f184m = null;
            this.f185n = null;
            this.f186o = true;
            this.p = true;
            this.f187q = true;
            g();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f181j.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.f181j.containsAll(collection);
    }

    @Override // java.util.List
    public final k get(int i2) {
        if (this.f181j.size() == 0) {
            return null;
        }
        return this.f181j.get(i2);
    }

    @Override // G0.l
    protected final void i(h hVar) {
        Iterator<k> it = this.f181j.iterator();
        while (it.hasNext()) {
            it.next().h(hVar);
        }
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f181j.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f181j.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<k> iterator() {
        return this.f181j.iterator();
    }

    @Override // G0.l
    protected final void l() {
        Iterator<k> it = this.f181j.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f181j.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<k> listIterator() {
        return this.f181j.listIterator();
    }

    @Override // G0.l
    protected final void o(h hVar) {
        Iterator<k> it = this.f181j.iterator();
        while (it.hasNext()) {
            it.next().n(hVar);
        }
    }

    public final void p(k kVar) {
        D(kVar);
        g();
    }

    public final void q(int i2) {
        p pVar;
        if (i2 <= 0 || (pVar = this.f190t) == null) {
            return;
        }
        int iY = pVar.y() - i2;
        if (iY < 0) {
            iY = 0;
        }
        this.f190t.F(iY);
    }

    public final void r(int i2) {
        if (i2 > 0) {
            int i4 = this.f189s - i2;
            this.f189s = i4;
            if (i4 < 0) {
                this.f189s = 0;
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        if (obj == null || !(obj instanceof k) || !F(obj)) {
            return false;
        }
        g();
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    public final k s(int i2) {
        if (this.f181j.size() == 0) {
            return null;
        }
        return this.f181j.get(i2);
    }

    @Override // java.util.List
    public final k set(int i2, k kVar) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f181j.size();
    }

    @Override // java.util.List
    public final List<k> subList(int i2, int i4) {
        return this.f181j.subList(i2, i4);
    }

    public final a t() {
        return (a) this.f184m;
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.f181j.toArray();
    }

    public final int u() {
        return this.f188r;
    }

    public final i v() {
        return (i) this.f183l;
    }

    public final int w() {
        return this.f189s;
    }

    public final q x() {
        return (q) this.f182k;
    }

    public final s y() {
        return (s) this.f185n;
    }

    public final boolean z() {
        return this.f184m != null;
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection<? extends k> collection) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final ListIterator<k> listIterator(int i2) {
        return this.f181j.listIterator(i2);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) this.f181j.toArray(tArr);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        p((k) obj);
        return true;
    }

    @Override // java.util.List
    public final k remove(int i2) {
        k kVar = this.f181j.get(i2);
        if (kVar != null && F(kVar)) {
            g();
        }
        return kVar;
    }

    public o(int i2, ArrayList<k> arrayList) throws IllegalStateException, C0341b {
        this.f181j = new ArrayList<>();
        this.f186o = true;
        this.p = true;
        this.f187q = true;
        this.f188r = i2;
        Iterator<k> it = arrayList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            k next = it.next();
            D(next);
            int i5 = next.f168l;
            if (i5 > i4) {
                i4 = i5;
            }
        }
        K(i4);
    }
}
