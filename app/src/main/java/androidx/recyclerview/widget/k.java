package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<g> f4184a = new a();

    static class a implements Comparator<g> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(g gVar, g gVar2) {
            g gVar3 = gVar;
            g gVar4 = gVar2;
            int i2 = gVar3.f4196a - gVar4.f4196a;
            return i2 == 0 ? gVar3.f4197b - gVar4.f4197b : i2;
        }
    }

    public static abstract class b {
        public abstract boolean a(int i2, int i4);

        public abstract boolean b(int i2, int i4);

        public void c(int i2, int i4) {
        }

        public abstract int d();

        public abstract int e();
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final List<g> f4185a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f4186b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f4187c;
        private final b d;

        /* renamed from: e, reason: collision with root package name */
        private final int f4188e;

        /* renamed from: f, reason: collision with root package name */
        private final int f4189f;
        private final boolean g;

        c(b bVar, List list, int[] iArr, int[] iArr2) {
            this.f4185a = list;
            this.f4186b = iArr;
            this.f4187c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.d = bVar;
            int iE = bVar.e();
            this.f4188e = iE;
            int iD = bVar.d();
            this.f4189f = iD;
            this.g = true;
            g gVar = list.isEmpty() ? null : (g) list.get(0);
            if (gVar == null || gVar.f4196a != 0 || gVar.f4197b != 0) {
                g gVar2 = new g();
                gVar2.f4196a = 0;
                gVar2.f4197b = 0;
                gVar2.d = false;
                gVar2.f4198c = 0;
                gVar2.f4199e = false;
                list.add(0, gVar2);
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                g gVar3 = this.f4185a.get(size);
                int i2 = gVar3.f4196a;
                int i4 = gVar3.f4198c;
                int i5 = i2 + i4;
                int i6 = gVar3.f4197b + i4;
                if (this.g) {
                    while (iE > i5) {
                        int i7 = iE - 1;
                        if (this.f4186b[i7] == 0) {
                            c(iE, iD, size, false);
                        }
                        iE = i7;
                    }
                    while (iD > i6) {
                        int i8 = iD - 1;
                        if (this.f4187c[i8] == 0) {
                            c(iE, iD, size, true);
                        }
                        iD = i8;
                    }
                }
                for (int i9 = 0; i9 < gVar3.f4198c; i9++) {
                    int i10 = gVar3.f4196a + i9;
                    int i11 = gVar3.f4197b + i9;
                    int i12 = this.d.a(i10, i11) ? 1 : 2;
                    this.f4186b[i10] = (i11 << 5) | i12;
                    this.f4187c[i11] = (i10 << 5) | i12;
                }
                iE = gVar3.f4196a;
                iD = gVar3.f4197b;
            }
        }

        private boolean c(int i2, int i4, int i5, boolean z4) {
            int i6;
            int i7;
            int i8;
            if (z4) {
                i4--;
                i7 = i2;
                i6 = i4;
            } else {
                i6 = i2 - 1;
                i7 = i6;
            }
            while (i5 >= 0) {
                g gVar = this.f4185a.get(i5);
                int i9 = gVar.f4196a;
                int i10 = gVar.f4198c;
                int i11 = i9 + i10;
                int i12 = gVar.f4197b + i10;
                if (z4) {
                    for (int i13 = i7 - 1; i13 >= i11; i13--) {
                        if (this.d.b(i13, i6)) {
                            i8 = this.d.a(i13, i6) ? 8 : 4;
                            this.f4187c[i6] = (i13 << 5) | 16;
                            this.f4186b[i13] = (i6 << 5) | i8;
                            return true;
                        }
                    }
                } else {
                    for (int i14 = i4 - 1; i14 >= i12; i14--) {
                        if (this.d.b(i6, i14)) {
                            i8 = this.d.a(i6, i14) ? 8 : 4;
                            int i15 = i2 - 1;
                            this.f4186b[i15] = (i14 << 5) | 16;
                            this.f4187c[i14] = (i15 << 5) | i8;
                            return true;
                        }
                    }
                }
                i7 = gVar.f4196a;
                i4 = gVar.f4197b;
                i5--;
            }
            return false;
        }

        private static e d(List<e> list, int i2, boolean z4) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.f4190a == i2 && eVar.f4192c == z4) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f4191b += z4 ? 1 : -1;
                        size++;
                    }
                    return eVar;
                }
                size--;
            }
            return null;
        }

        public final int a(int i2) {
            if (i2 >= 0) {
                int[] iArr = this.f4186b;
                if (i2 < iArr.length) {
                    int i4 = iArr[i2];
                    if ((i4 & 31) == 0) {
                        return -1;
                    }
                    return i4 >> 5;
                }
            }
            StringBuilder sbC = C2.c.c("Index out of bounds - passed position = ", i2, ", old list size = ");
            sbC.append(this.f4186b.length);
            throw new IndexOutOfBoundsException(sbC.toString());
        }

        public final void b(Q.b bVar) {
            int i2;
            g gVar;
            Q.a aVar = bVar instanceof Q.a ? (Q.a) bVar : new Q.a(bVar);
            ArrayList arrayList = new ArrayList();
            int i4 = this.f4188e;
            int i5 = this.f4189f;
            int size = this.f4185a.size() - 1;
            while (size >= 0) {
                g gVar2 = this.f4185a.get(size);
                int i6 = gVar2.f4198c;
                int i7 = gVar2.f4196a + i6;
                int i8 = gVar2.f4197b + i6;
                int i9 = 4;
                if (i7 < i4) {
                    int i10 = i4 - i7;
                    if (this.g) {
                        int i11 = i10 - 1;
                        while (i11 >= 0) {
                            int[] iArr = this.f4186b;
                            int i12 = i7 + i11;
                            int i13 = iArr[i12] & 31;
                            if (i13 == 0) {
                                i2 = size;
                                gVar = gVar2;
                                int i14 = 1;
                                aVar.a(i12, 1);
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((e) it.next()).f4191b -= i14;
                                    i14 = 1;
                                }
                            } else if (i13 == i9 || i13 == 8) {
                                int i15 = iArr[i12] >> 5;
                                e eVarD = d(arrayList, i15, false);
                                i2 = size;
                                gVar = gVar2;
                                aVar.c(i12, eVarD.f4191b - 1);
                                if (i13 == 4) {
                                    int i16 = eVarD.f4191b - 1;
                                    this.d.c(i12, i15);
                                    aVar.d(i16, 1, null);
                                }
                            } else {
                                if (i13 != 16) {
                                    StringBuilder sbC = C2.c.c("unknown flag for pos ", i12, " ");
                                    sbC.append(Long.toBinaryString(i13));
                                    throw new IllegalStateException(sbC.toString());
                                }
                                arrayList.add(new e(i12, i12, true));
                                i2 = size;
                                gVar = gVar2;
                            }
                            i11--;
                            i9 = 4;
                            size = i2;
                            gVar2 = gVar;
                        }
                    } else {
                        aVar.a(i7, i10);
                    }
                }
                int i17 = size;
                g gVar3 = gVar2;
                if (i8 < i5) {
                    int i18 = i5 - i8;
                    if (this.g) {
                        while (true) {
                            i18--;
                            if (i18 < 0) {
                                break;
                            }
                            int[] iArr2 = this.f4187c;
                            int i19 = i8 + i18;
                            int i20 = iArr2[i19] & 31;
                            if (i20 == 0) {
                                int i21 = 1;
                                aVar.b(i7, 1);
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    ((e) it2.next()).f4191b += i21;
                                    i21 = 1;
                                }
                            } else if (i20 == 4 || i20 == 8) {
                                int i22 = iArr2[i19] >> 5;
                                aVar.c(d(arrayList, i22, true).f4191b, i7);
                                if (i20 == 4) {
                                    this.d.c(i22, i19);
                                    aVar.d(i7, 1, null);
                                }
                            } else {
                                if (i20 != 16) {
                                    StringBuilder sbC2 = C2.c.c("unknown flag for pos ", i19, " ");
                                    sbC2.append(Long.toBinaryString(i20));
                                    throw new IllegalStateException(sbC2.toString());
                                }
                                arrayList.add(new e(i19, i7, false));
                            }
                        }
                    } else {
                        aVar.b(i7, i18);
                    }
                }
                int i23 = i6 - 1;
                while (i23 >= 0) {
                    int[] iArr3 = this.f4186b;
                    g gVar4 = gVar3;
                    int i24 = gVar4.f4196a + i23;
                    if ((iArr3[i24] & 31) == 2) {
                        this.d.c(i24, gVar4.f4197b + i23);
                        aVar.d(i24, 1, null);
                    }
                    i23--;
                    gVar3 = gVar4;
                }
                g gVar5 = gVar3;
                i4 = gVar5.f4196a;
                i5 = gVar5.f4197b;
                size = i17 - 1;
            }
            aVar.e();
        }
    }

    public static abstract class d<T> {
        public abstract boolean a(T t2, T t4);

        public abstract boolean b(T t2, T t4);
    }

    private static class e {

        /* renamed from: a, reason: collision with root package name */
        int f4190a;

        /* renamed from: b, reason: collision with root package name */
        int f4191b;

        /* renamed from: c, reason: collision with root package name */
        boolean f4192c;

        public e(int i2, int i4, boolean z4) {
            this.f4190a = i2;
            this.f4191b = i4;
            this.f4192c = z4;
        }
    }

    static class f {

        /* renamed from: a, reason: collision with root package name */
        int f4193a;

        /* renamed from: b, reason: collision with root package name */
        int f4194b;

        /* renamed from: c, reason: collision with root package name */
        int f4195c;
        int d;

        public f() {
        }

        public f(int i2, int i4) {
            this.f4193a = 0;
            this.f4194b = i2;
            this.f4195c = 0;
            this.d = i4;
        }
    }

    static class g {

        /* renamed from: a, reason: collision with root package name */
        int f4196a;

        /* renamed from: b, reason: collision with root package name */
        int f4197b;

        /* renamed from: c, reason: collision with root package name */
        int f4198c;
        boolean d;

        /* renamed from: e, reason: collision with root package name */
        boolean f4199e;

        g() {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:27:0x00b8
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public static androidx.recyclerview.widget.k.c a(androidx.recyclerview.widget.k.b r27) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.a(androidx.recyclerview.widget.k$b):androidx.recyclerview.widget.k$c");
    }
}
