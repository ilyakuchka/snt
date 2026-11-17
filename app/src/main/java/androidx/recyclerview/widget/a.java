package androidx.recyclerview.widget;

import androidx.recyclerview.widget.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class a implements p.a {
    final InterfaceC0073a d;

    /* renamed from: a, reason: collision with root package name */
    private E.b<b> f4117a = new E.c(30);

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f4118b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<b> f4119c = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f4121f = 0;

    /* renamed from: e, reason: collision with root package name */
    final p f4120e = new p(this);

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0073a {
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f4122a;

        /* renamed from: b, reason: collision with root package name */
        int f4123b;

        /* renamed from: c, reason: collision with root package name */
        Object f4124c;
        int d;

        b(int i2, int i4, int i5, Object obj) {
            this.f4122a = i2;
            this.f4123b = i4;
            this.d = i5;
            this.f4124c = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f4122a;
            if (i2 != bVar.f4122a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.d - this.f4123b) == 1 && this.d == bVar.f4123b && this.f4123b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.f4123b != bVar.f4123b) {
                return false;
            }
            Object obj2 = this.f4124c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f4124c)) {
                    return false;
                }
            } else if (bVar.f4124c != null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.f4122a * 31) + this.f4123b) * 31) + this.d;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i2 = this.f4122a;
            sb.append(i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f4123b);
            sb.append("c:");
            sb.append(this.d);
            sb.append(",p:");
            sb.append(this.f4124c);
            sb.append("]");
            return sb.toString();
        }
    }

    a(InterfaceC0073a interfaceC0073a) {
        this.d = interfaceC0073a;
    }

    private boolean a(int i2) {
        int size = this.f4119c.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.f4119c.get(i4);
            int i5 = bVar.f4122a;
            if (i5 == 8) {
                if (f(bVar.d, i4 + 1) == i2) {
                    return true;
                }
            } else if (i5 == 1) {
                int i6 = bVar.f4123b;
                int i7 = bVar.d + i6;
                while (i6 < i7) {
                    if (f(i6, i4 + 1) == i2) {
                        return true;
                    }
                    i6++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void d(b bVar) {
        int i2;
        int i4 = bVar.f4122a;
        if (i4 == 1 || i4 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iS = s(bVar.f4123b, i4);
        int i5 = bVar.f4123b;
        int i6 = bVar.f4122a;
        if (i6 == 2) {
            i2 = 0;
        } else {
            if (i6 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i2 = 1;
        }
        int i7 = 1;
        for (int i8 = 1; i8 < bVar.d; i8++) {
            int iS2 = s((i2 * i8) + bVar.f4123b, bVar.f4122a);
            int i9 = bVar.f4122a;
            if (i9 == 2 ? iS2 == iS : i9 == 4 && iS2 == iS + 1) {
                i7++;
            } else {
                b bVarI = i(i9, iS, i7, bVar.f4124c);
                e(bVarI, i5);
                bVarI.f4124c = null;
                this.f4117a.a(bVarI);
                if (bVar.f4122a == 4) {
                    i5 += i7;
                }
                i7 = 1;
                iS = iS2;
            }
        }
        Object obj = bVar.f4124c;
        bVar.f4124c = null;
        this.f4117a.a(bVar);
        if (i7 > 0) {
            b bVarI2 = i(bVar.f4122a, iS, i7, obj);
            e(bVarI2, i5);
            bVarI2.f4124c = null;
            this.f4117a.a(bVarI2);
        }
    }

    private void n(b bVar) {
        this.f4119c.add(bVar);
        int i2 = bVar.f4122a;
        if (i2 == 1) {
            ((u) this.d).d(bVar.f4123b, bVar.d);
            return;
        }
        if (i2 == 2) {
            u uVar = (u) this.d;
            uVar.f4262a.Y(bVar.f4123b, bVar.d, false);
            uVar.f4262a.f3957o0 = true;
            return;
        }
        if (i2 == 4) {
            ((u) this.d).c(bVar.f4123b, bVar.d, bVar.f4124c);
        } else if (i2 == 8) {
            ((u) this.d).e(bVar.f4123b, bVar.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int s(int i2, int i4) {
        int i5;
        int i6;
        for (int size = this.f4119c.size() - 1; size >= 0; size--) {
            b bVar = this.f4119c.get(size);
            int i7 = bVar.f4122a;
            if (i7 == 8) {
                int i8 = bVar.f4123b;
                int i9 = bVar.d;
                if (i8 < i9) {
                    i6 = i8;
                    i5 = i9;
                } else {
                    i5 = i8;
                    i6 = i9;
                }
                if (i2 < i6 || i2 > i5) {
                    if (i2 < i8) {
                        if (i4 == 1) {
                            bVar.f4123b = i8 + 1;
                            bVar.d = i9 + 1;
                        } else if (i4 == 2) {
                            bVar.f4123b = i8 - 1;
                            bVar.d = i9 - 1;
                        }
                    }
                } else if (i6 == i8) {
                    if (i4 == 1) {
                        bVar.d = i9 + 1;
                    } else if (i4 == 2) {
                        bVar.d = i9 - 1;
                    }
                    i2++;
                } else {
                    if (i4 == 1) {
                        bVar.f4123b = i8 + 1;
                    } else if (i4 == 2) {
                        bVar.f4123b = i8 - 1;
                    }
                    i2--;
                }
            } else {
                int i10 = bVar.f4123b;
                if (i10 <= i2) {
                    if (i7 == 1) {
                        i2 -= bVar.d;
                    } else if (i7 == 2) {
                        i2 += bVar.d;
                    }
                } else if (i4 == 1) {
                    bVar.f4123b = i10 + 1;
                } else if (i4 == 2) {
                    bVar.f4123b = i10 - 1;
                }
            }
        }
        for (int size2 = this.f4119c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f4119c.get(size2);
            if (bVar2.f4122a == 8) {
                int i11 = bVar2.d;
                if (i11 == bVar2.f4123b || i11 < 0) {
                    this.f4119c.remove(size2);
                    p(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.f4119c.remove(size2);
                p(bVar2);
            }
        }
        return i2;
    }

    final void b() {
        int size = this.f4119c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((u) this.d).a(this.f4119c.get(i2));
        }
        q(this.f4119c);
        this.f4121f = 0;
    }

    final void c() {
        b();
        int size = this.f4118b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f4118b.get(i2);
            int i4 = bVar.f4122a;
            if (i4 == 1) {
                ((u) this.d).a(bVar);
                ((u) this.d).d(bVar.f4123b, bVar.d);
            } else if (i4 == 2) {
                ((u) this.d).a(bVar);
                InterfaceC0073a interfaceC0073a = this.d;
                int i5 = bVar.f4123b;
                int i6 = bVar.d;
                u uVar = (u) interfaceC0073a;
                uVar.f4262a.Y(i5, i6, true);
                RecyclerView recyclerView = uVar.f4262a;
                recyclerView.f3957o0 = true;
                recyclerView.f3953m0.f4037c += i6;
            } else if (i4 == 4) {
                ((u) this.d).a(bVar);
                ((u) this.d).c(bVar.f4123b, bVar.d, bVar.f4124c);
            } else if (i4 == 8) {
                ((u) this.d).a(bVar);
                ((u) this.d).e(bVar.f4123b, bVar.d);
            }
        }
        q(this.f4118b);
        this.f4121f = 0;
    }

    final void e(b bVar, int i2) {
        ((u) this.d).a(bVar);
        int i4 = bVar.f4122a;
        if (i4 != 2) {
            if (i4 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            ((u) this.d).c(i2, bVar.d, bVar.f4124c);
            return;
        }
        InterfaceC0073a interfaceC0073a = this.d;
        int i5 = bVar.d;
        u uVar = (u) interfaceC0073a;
        uVar.f4262a.Y(i2, i5, true);
        RecyclerView recyclerView = uVar.f4262a;
        recyclerView.f3957o0 = true;
        recyclerView.f3953m0.f4037c += i5;
    }

    final int f(int i2, int i4) {
        int size = this.f4119c.size();
        while (i4 < size) {
            b bVar = this.f4119c.get(i4);
            int i5 = bVar.f4122a;
            if (i5 == 8) {
                int i6 = bVar.f4123b;
                if (i6 == i2) {
                    i2 = bVar.d;
                } else {
                    if (i6 < i2) {
                        i2--;
                    }
                    if (bVar.d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i7 = bVar.f4123b;
                if (i7 > i2) {
                    continue;
                } else if (i5 == 2) {
                    int i8 = bVar.d;
                    if (i2 < i7 + i8) {
                        return -1;
                    }
                    i2 -= i8;
                } else if (i5 == 1) {
                    i2 += bVar.d;
                }
            }
            i4++;
        }
        return i2;
    }

    final boolean g(int i2) {
        return (this.f4121f & i2) != 0;
    }

    final boolean h() {
        return this.f4118b.size() > 0;
    }

    public final b i(int i2, int i4, int i5, Object obj) {
        b bVarB = this.f4117a.b();
        if (bVarB == null) {
            return new b(i2, i4, i5, obj);
        }
        bVarB.f4122a = i2;
        bVarB.f4123b = i4;
        bVarB.d = i5;
        bVarB.f4124c = obj;
        return bVarB;
    }

    final boolean j(int i2, int i4, Object obj) {
        if (i4 < 1) {
            return false;
        }
        this.f4118b.add(i(4, i2, i4, obj));
        this.f4121f |= 4;
        return this.f4118b.size() == 1;
    }

    final boolean k(int i2, int i4) {
        if (i4 < 1) {
            return false;
        }
        this.f4118b.add(i(1, i2, i4, null));
        this.f4121f |= 1;
        return this.f4118b.size() == 1;
    }

    final boolean l(int i2, int i4) {
        if (i2 == i4) {
            return false;
        }
        this.f4118b.add(i(8, i2, i4, null));
        this.f4121f |= 8;
        return this.f4118b.size() == 1;
    }

    final boolean m(int i2, int i4) {
        if (i4 < 1) {
            return false;
        }
        this.f4118b.add(i(2, i2, i4, null));
        this.f4121f |= 2;
        return this.f4118b.size() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x013f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void o() {
        boolean z4;
        boolean z5;
        b bVarI;
        int i2;
        int i4;
        b bVarI2;
        boolean z6;
        boolean z7;
        int i5;
        int i6;
        int i7;
        b bVarI3;
        p pVar = this.f4120e;
        ArrayList<b> arrayList = this.f4118b;
        Objects.requireNonNull(pVar);
        while (true) {
            int size = arrayList.size() - 1;
            boolean z8 = false;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (arrayList.get(size).f4122a == 8) {
                    if (z8) {
                        break;
                    }
                } else {
                    z8 = true;
                }
                size--;
            }
            if (size == -1) {
                break;
            }
            int i8 = size + 1;
            b bVar = arrayList.get(size);
            b bVar2 = arrayList.get(i8);
            int i9 = bVar2.f4122a;
            if (i9 == 1) {
                int i10 = bVar.d;
                int i11 = bVar2.f4123b;
                int i12 = i10 < i11 ? -1 : 0;
                int i13 = bVar.f4123b;
                if (i13 < i11) {
                    i12++;
                }
                if (i11 <= i13) {
                    bVar.f4123b = i13 + bVar2.d;
                }
                int i14 = bVar2.f4123b;
                if (i14 <= i10) {
                    bVar.d = i10 + bVar2.d;
                }
                bVar2.f4123b = i14 + i12;
                arrayList.set(size, bVar2);
                arrayList.set(i8, bVar);
            } else if (i9 == 2) {
                int i15 = bVar.f4123b;
                int i16 = bVar.d;
                if (i15 < i16) {
                    if (bVar2.f4123b == i15 && bVar2.d == i16 - i15) {
                        z7 = true;
                        z6 = false;
                        i5 = bVar2.f4123b;
                        if (i16 >= i5) {
                        }
                        i6 = bVar.f4123b;
                        i7 = bVar2.f4123b;
                        if (i6 > i7) {
                        }
                        bVarI3 = null;
                        if (z7) {
                        }
                    } else {
                        z7 = false;
                        z6 = z7;
                        i5 = bVar2.f4123b;
                        if (i16 >= i5) {
                            bVar2.f4123b = i5 - 1;
                        } else {
                            int i17 = bVar2.d;
                            if (i16 < i5 + i17) {
                                bVar2.d = i17 - 1;
                                bVar.f4122a = 2;
                                bVar.d = 1;
                                if (bVar2.d == 0) {
                                    arrayList.remove(i8);
                                    a aVar = (a) pVar.f4257a;
                                    Objects.requireNonNull(aVar);
                                    bVar2.f4124c = null;
                                    aVar.f4117a.a(bVar2);
                                }
                            }
                        }
                        i6 = bVar.f4123b;
                        i7 = bVar2.f4123b;
                        if (i6 > i7) {
                            bVar2.f4123b = i7 + 1;
                        } else {
                            int i18 = i7 + bVar2.d;
                            if (i6 < i18) {
                                bVarI3 = ((a) pVar.f4257a).i(2, i6 + 1, i18 - i6, null);
                                bVar2.d = bVar.f4123b - bVar2.f4123b;
                            }
                            if (z7) {
                                arrayList.set(size, bVar2);
                                arrayList.remove(i8);
                                a aVar2 = (a) pVar.f4257a;
                                Objects.requireNonNull(aVar2);
                                bVar.f4124c = null;
                                aVar2.f4117a.a(bVar);
                            } else {
                                if (z6) {
                                    if (bVarI3 != null) {
                                        int i19 = bVar.f4123b;
                                        if (i19 > bVarI3.f4123b) {
                                            bVar.f4123b = i19 - bVarI3.d;
                                        }
                                        int i20 = bVar.d;
                                        if (i20 > bVarI3.f4123b) {
                                            bVar.d = i20 - bVarI3.d;
                                        }
                                    }
                                    int i21 = bVar.f4123b;
                                    if (i21 > bVar2.f4123b) {
                                        bVar.f4123b = i21 - bVar2.d;
                                    }
                                    int i22 = bVar.d;
                                    if (i22 > bVar2.f4123b) {
                                        bVar.d = i22 - bVar2.d;
                                    }
                                } else {
                                    if (bVarI3 != null) {
                                        int i23 = bVar.f4123b;
                                        if (i23 >= bVarI3.f4123b) {
                                            bVar.f4123b = i23 - bVarI3.d;
                                        }
                                        int i24 = bVar.d;
                                        if (i24 >= bVarI3.f4123b) {
                                            bVar.d = i24 - bVarI3.d;
                                        }
                                    }
                                    int i25 = bVar.f4123b;
                                    if (i25 >= bVar2.f4123b) {
                                        bVar.f4123b = i25 - bVar2.d;
                                    }
                                    int i26 = bVar.d;
                                    if (i26 >= bVar2.f4123b) {
                                        bVar.d = i26 - bVar2.d;
                                    }
                                }
                                arrayList.set(size, bVar2);
                                if (bVar.f4123b != bVar.d) {
                                    arrayList.set(i8, bVar);
                                } else {
                                    arrayList.remove(i8);
                                }
                                if (bVarI3 != null) {
                                    arrayList.add(size, bVarI3);
                                }
                            }
                        }
                        bVarI3 = null;
                        if (z7) {
                        }
                    }
                } else if (bVar2.f4123b == i16 + 1 && bVar2.d == i15 - i16) {
                    z7 = true;
                    z6 = z7;
                    i5 = bVar2.f4123b;
                    if (i16 >= i5) {
                    }
                    i6 = bVar.f4123b;
                    i7 = bVar2.f4123b;
                    if (i6 > i7) {
                    }
                    bVarI3 = null;
                    if (z7) {
                    }
                } else {
                    z6 = true;
                    z7 = false;
                    i5 = bVar2.f4123b;
                    if (i16 >= i5) {
                    }
                    i6 = bVar.f4123b;
                    i7 = bVar2.f4123b;
                    if (i6 > i7) {
                    }
                    bVarI3 = null;
                    if (z7) {
                    }
                }
            } else if (i9 == 4) {
                int i27 = bVar.d;
                int i28 = bVar2.f4123b;
                if (i27 < i28) {
                    bVar2.f4123b = i28 - 1;
                } else {
                    int i29 = bVar2.d;
                    if (i27 < i28 + i29) {
                        bVar2.d = i29 - 1;
                        bVarI = ((a) pVar.f4257a).i(4, bVar.f4123b, 1, bVar2.f4124c);
                    }
                    i2 = bVar.f4123b;
                    i4 = bVar2.f4123b;
                    if (i2 > i4) {
                        bVar2.f4123b = i4 + 1;
                    } else {
                        int i30 = i4 + bVar2.d;
                        if (i2 < i30) {
                            int i31 = i30 - i2;
                            bVarI2 = ((a) pVar.f4257a).i(4, i2 + 1, i31, bVar2.f4124c);
                            bVar2.d -= i31;
                        }
                        arrayList.set(i8, bVar);
                        if (bVar2.d > 0) {
                            arrayList.set(size, bVar2);
                        } else {
                            arrayList.remove(size);
                            a aVar3 = (a) pVar.f4257a;
                            Objects.requireNonNull(aVar3);
                            bVar2.f4124c = null;
                            aVar3.f4117a.a(bVar2);
                        }
                        if (bVarI != null) {
                            arrayList.add(size, bVarI);
                        }
                        if (bVarI2 != null) {
                            arrayList.add(size, bVarI2);
                        }
                    }
                    bVarI2 = null;
                    arrayList.set(i8, bVar);
                    if (bVar2.d > 0) {
                    }
                    if (bVarI != null) {
                    }
                    if (bVarI2 != null) {
                    }
                }
                bVarI = null;
                i2 = bVar.f4123b;
                i4 = bVar2.f4123b;
                if (i2 > i4) {
                }
                bVarI2 = null;
                arrayList.set(i8, bVar);
                if (bVar2.d > 0) {
                }
                if (bVarI != null) {
                }
                if (bVarI2 != null) {
                }
            }
        }
        int size2 = this.f4118b.size();
        for (int i32 = 0; i32 < size2; i32++) {
            b bVarI4 = this.f4118b.get(i32);
            int i33 = bVarI4.f4122a;
            if (i33 == 1) {
                n(bVarI4);
            } else if (i33 == 2) {
                int i34 = bVarI4.f4123b;
                int i35 = bVarI4.d + i34;
                int i36 = i34;
                boolean z9 = -1;
                int i37 = 0;
                while (i36 < i35) {
                    if (((u) this.d).b(i36) != null || a(i36)) {
                        if (z9) {
                            z4 = false;
                        } else {
                            d(i(2, i34, i37, null));
                            z4 = true;
                        }
                        z5 = true;
                    } else {
                        if (z9) {
                            n(i(2, i34, i37, null));
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z5 = false;
                    }
                    if (z4) {
                        i36 -= i37;
                        i35 -= i37;
                        i37 = 1;
                    } else {
                        i37++;
                    }
                    i36++;
                    z9 = z5;
                }
                if (i37 != bVarI4.d) {
                    bVarI4.f4124c = null;
                    this.f4117a.a(bVarI4);
                    bVarI4 = i(2, i34, i37, null);
                }
                if (z9) {
                    n(bVarI4);
                } else {
                    d(bVarI4);
                }
            } else if (i33 == 4) {
                int i38 = bVarI4.f4123b;
                int i39 = bVarI4.d + i38;
                boolean z10 = -1;
                int i40 = i38;
                int i41 = 0;
                while (i38 < i39) {
                    if (((u) this.d).b(i38) != null || a(i38)) {
                        if (!z10) {
                            d(i(4, i40, i41, bVarI4.f4124c));
                            i40 = i38;
                            i41 = 0;
                        }
                        z10 = true;
                    } else {
                        if (z10) {
                            n(i(4, i40, i41, bVarI4.f4124c));
                            i40 = i38;
                            i41 = 0;
                        }
                        z10 = false;
                    }
                    i41++;
                    i38++;
                }
                if (i41 != bVarI4.d) {
                    Object obj = bVarI4.f4124c;
                    bVarI4.f4124c = null;
                    this.f4117a.a(bVarI4);
                    bVarI4 = i(4, i40, i41, obj);
                }
                if (z10) {
                    n(bVarI4);
                } else {
                    d(bVarI4);
                }
            } else if (i33 == 8) {
                n(bVarI4);
            }
        }
        this.f4118b.clear();
    }

    public final void p(b bVar) {
        bVar.f4124c = null;
        this.f4117a.a(bVar);
    }

    final void q(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            p(list.get(i2));
        }
        list.clear();
    }

    final void r() {
        q(this.f4118b);
        q(this.f4119c);
        this.f4121f = 0;
    }
}
