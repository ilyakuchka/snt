package X3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f1884a = new u();

    /* renamed from: b, reason: collision with root package name */
    private static final t f1885b = new t(new byte[0], 0, 0, false);

    /* renamed from: c, reason: collision with root package name */
    private static final int f1886c;
    private static final AtomicReference<t>[] d;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f1886c = iHighestOneBit;
        AtomicReference<t>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i2 = 0; i2 < iHighestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        d = atomicReferenceArr;
    }

    private u() {
    }

    private final AtomicReference<t> a() {
        return d[(int) (Thread.currentThread().getId() & (f1886c - 1))];
    }

    public static final void b(t tVar) {
        AtomicReference<t> atomicReferenceA;
        t tVar2;
        if (!(tVar.f1883f == null && tVar.g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (tVar.d || (tVar2 = (atomicReferenceA = f1884a.a()).get()) == f1885b) {
            return;
        }
        int i2 = tVar2 == null ? 0 : tVar2.f1881c;
        if (i2 >= 65536) {
            return;
        }
        tVar.f1883f = tVar2;
        tVar.f1880b = 0;
        tVar.f1881c = i2 + 8192;
        if (atomicReferenceA.compareAndSet(tVar2, tVar)) {
            return;
        }
        tVar.f1883f = null;
    }

    public static final t c() {
        AtomicReference<t> atomicReferenceA = f1884a.a();
        t tVar = f1885b;
        t andSet = atomicReferenceA.getAndSet(tVar);
        if (andSet == tVar) {
            return new t();
        }
        if (andSet == null) {
            atomicReferenceA.set(null);
            return new t();
        }
        atomicReferenceA.set(andSet.f1883f);
        andSet.f1883f = null;
        andSet.f1881c = 0;
        return andSet;
    }
}
