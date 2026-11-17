package androidx.recyclerview.widget;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class m implements Runnable {

    /* renamed from: m, reason: collision with root package name */
    static final ThreadLocal<m> f4231m = new ThreadLocal<>();

    /* renamed from: n, reason: collision with root package name */
    static Comparator<c> f4232n = new a();

    /* renamed from: j, reason: collision with root package name */
    long f4234j;

    /* renamed from: k, reason: collision with root package name */
    long f4235k;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<RecyclerView> f4233i = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<c> f4236l = new ArrayList<>();

    static class a implements Comparator<c> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        
            if (r5 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        
            if (r5 != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
        
            return 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        
            return -1;
         */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int compare(c cVar, c cVar2) {
            c cVar3 = cVar;
            c cVar4 = cVar2;
            RecyclerView recyclerView = cVar3.d;
            if ((recyclerView == null) == (cVar4.d == null)) {
                boolean z4 = cVar3.f4240a;
                if (z4 == cVar4.f4240a) {
                    int i2 = cVar4.f4241b - cVar3.f4241b;
                    if (i2 == 0 && (i2 = cVar3.f4242c - cVar4.f4242c) == 0) {
                        return 0;
                    }
                    return i2;
                }
            }
        }
    }

    static class b implements RecyclerView.l.c {

        /* renamed from: a, reason: collision with root package name */
        int f4237a;

        /* renamed from: b, reason: collision with root package name */
        int f4238b;

        /* renamed from: c, reason: collision with root package name */
        int[] f4239c;
        int d;

        b() {
        }

        public final void a(int i2, int i4) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i5 = this.d * 2;
            int[] iArr = this.f4239c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f4239c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i5 >= iArr.length) {
                int[] iArr3 = new int[i5 * 2];
                this.f4239c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f4239c;
            iArr4[i5] = i2;
            iArr4[i5 + 1] = i4;
            this.d++;
        }

        final void b(RecyclerView recyclerView, boolean z4) {
            this.d = 0;
            int[] iArr = this.f4239c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.l lVar = recyclerView.u;
            if (recyclerView.f3963t == null || lVar == null || !lVar.Z()) {
                return;
            }
            if (z4) {
                if (!recyclerView.f3950l.h()) {
                    lVar.m(recyclerView.f3963t.j(), this);
                }
            } else if (!recyclerView.S()) {
                lVar.l(this.f4237a, this.f4238b, recyclerView.f3953m0, this);
            }
            int i2 = this.d;
            if (i2 > lVar.f3998l) {
                lVar.f3998l = i2;
                lVar.f3999m = z4;
                recyclerView.f3946j.n();
            }
        }

        final boolean c(int i2) {
            if (this.f4239c != null) {
                int i4 = this.d * 2;
                for (int i5 = 0; i5 < i4; i5 += 2) {
                    if (this.f4239c[i5] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4240a;

        /* renamed from: b, reason: collision with root package name */
        public int f4241b;

        /* renamed from: c, reason: collision with root package name */
        public int f4242c;
        public RecyclerView d;

        /* renamed from: e, reason: collision with root package name */
        public int f4243e;

        c() {
        }
    }

    m() {
    }

    private RecyclerView.x c(RecyclerView recyclerView, int i2, long j2) {
        boolean z4;
        int iH = recyclerView.f3952m.h();
        int i4 = 0;
        while (true) {
            if (i4 >= iH) {
                z4 = false;
                break;
            }
            RecyclerView.x xVarN = RecyclerView.N(recyclerView.f3952m.g(i4));
            if (xVarN.f4057k == i2 && !xVarN.m()) {
                z4 = true;
                break;
            }
            i4++;
        }
        if (z4) {
            return null;
        }
        RecyclerView.q qVar = recyclerView.f3946j;
        try {
            recyclerView.Z();
            RecyclerView.x xVarL = qVar.l(i2, j2);
            if (xVarL != null) {
                if (!xVarL.l() || xVarL.m()) {
                    qVar.a(xVarL, false);
                } else {
                    qVar.h(xVarL.f4055i);
                }
            }
            return xVarL;
        } finally {
            recyclerView.a0(false);
        }
    }

    final void a(RecyclerView recyclerView, int i2, int i4) {
        if (recyclerView.isAttachedToWindow() && this.f4234j == 0) {
            this.f4234j = System.nanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.f3951l0;
        bVar.f4237a = i2;
        bVar.f4238b = i4;
    }

    final void b(long j2) {
        c cVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        c cVar2;
        int size = this.f4233i.size();
        int i2 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView3 = this.f4233i.get(i4);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.f3951l0.b(recyclerView3, false);
                i2 += recyclerView3.f3951l0.d;
            }
        }
        this.f4236l.ensureCapacity(i2);
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView4 = this.f4233i.get(i6);
            if (recyclerView4.getWindowVisibility() == 0) {
                b bVar = recyclerView4.f3951l0;
                int iAbs = Math.abs(bVar.f4238b) + Math.abs(bVar.f4237a);
                for (int i7 = 0; i7 < bVar.d * 2; i7 += 2) {
                    if (i5 >= this.f4236l.size()) {
                        cVar2 = new c();
                        this.f4236l.add(cVar2);
                    } else {
                        cVar2 = this.f4236l.get(i5);
                    }
                    int[] iArr = bVar.f4239c;
                    int i8 = iArr[i7 + 1];
                    cVar2.f4240a = i8 <= iAbs;
                    cVar2.f4241b = iAbs;
                    cVar2.f4242c = i8;
                    cVar2.d = recyclerView4;
                    cVar2.f4243e = iArr[i7];
                    i5++;
                }
            }
        }
        Collections.sort(this.f4236l, f4232n);
        for (int i9 = 0; i9 < this.f4236l.size() && (recyclerView = (cVar = this.f4236l.get(i9)).d) != null; i9++) {
            RecyclerView.x xVarC = c(recyclerView, cVar.f4243e, cVar.f4240a ? Long.MAX_VALUE : j2);
            if (xVarC != null && xVarC.f4056j != null && xVarC.l() && !xVarC.m() && (recyclerView2 = xVarC.f4056j.get()) != null) {
                if (recyclerView2.f3925J && recyclerView2.f3952m.h() != 0) {
                    recyclerView2.g0();
                }
                b bVar2 = recyclerView2.f3951l0;
                bVar2.b(recyclerView2, true);
                if (bVar2.d != 0) {
                    try {
                        Trace.beginSection("RV Nested Prefetch");
                        RecyclerView.v vVar = recyclerView2.f3953m0;
                        RecyclerView.e eVar = recyclerView2.f3963t;
                        vVar.d = 1;
                        vVar.f4038e = eVar.j();
                        vVar.g = false;
                        vVar.f4040h = false;
                        vVar.f4041i = false;
                        for (int i10 = 0; i10 < bVar2.d * 2; i10 += 2) {
                            c(recyclerView2, bVar2.f4239c[i10], j2);
                        }
                    } finally {
                        Trace.endSection();
                    }
                } else {
                    continue;
                }
            }
            cVar.f4240a = false;
            cVar.f4241b = 0;
            cVar.f4242c = 0;
            cVar.d = null;
            cVar.f4243e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Trace.beginSection("RV Prefetch");
            if (this.f4233i.isEmpty()) {
                return;
            }
            int size = this.f4233i.size();
            long jMax = 0;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView recyclerView = this.f4233i.get(i2);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f4235k);
        } finally {
            this.f4234j = 0L;
            Trace.endSection();
        }
    }
}
