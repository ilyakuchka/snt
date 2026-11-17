package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.C0220p;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.N;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import q.C0365a;
import r.C0374g;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0207c extends N {

    /* renamed from: androidx.fragment.app.c$a */
    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f3510i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ N.b f3511j;

        a(List list, N.b bVar) {
            this.f3510i = list;
            this.f3511j = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f3510i.contains(this.f3511j)) {
                this.f3510i.remove(this.f3511j);
                C0207c c0207c = C0207c.this;
                N.b bVar = this.f3511j;
                Objects.requireNonNull(c0207c);
                P.a(bVar.e(), bVar.f().f3418O);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.c$b */
    static class b extends C0063c {

        /* renamed from: c, reason: collision with root package name */
        private boolean f3513c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private C0220p.a f3514e;

        b(N.b bVar, B.a aVar, boolean z4) {
            super(bVar, aVar);
            this.d = false;
            this.f3513c = z4;
        }

        final C0220p.a e(Context context) {
            if (this.d) {
                return this.f3514e;
            }
            C0220p.a aVarA = C0220p.a(context, b().f(), b().e() == 2, this.f3513c);
            this.f3514e = aVarA;
            this.d = true;
            return aVarA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    static class C0063c {

        /* renamed from: a, reason: collision with root package name */
        private final N.b f3515a;

        /* renamed from: b, reason: collision with root package name */
        private final B.a f3516b;

        C0063c(N.b bVar, B.a aVar) {
            this.f3515a = bVar;
            this.f3516b = aVar;
        }

        final void a() {
            this.f3515a.d(this.f3516b);
        }

        final N.b b() {
            return this.f3515a;
        }

        final B.a c() {
            return this.f3516b;
        }

        final boolean d() {
            int iC = P.c(this.f3515a.f().f3418O);
            int iE = this.f3515a.e();
            return iC == iE || !(iC == 2 || iE == 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.c$d */
    static class d extends C0063c {

        /* renamed from: c, reason: collision with root package name */
        private final Object f3517c;
        private final boolean d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f3518e;

        d(N.b bVar, B.a aVar, boolean z4, boolean z5) {
            Object objO;
            Object objM;
            super(bVar, aVar);
            if (bVar.e() == 2) {
                if (z4) {
                    objM = bVar.f().M();
                } else {
                    Objects.requireNonNull(bVar.f());
                    objM = null;
                }
                this.f3517c = objM;
                if (z4) {
                    Fragment.b bVar2 = bVar.f().f3420R;
                } else {
                    Fragment.b bVar3 = bVar.f().f3420R;
                }
                this.d = true;
            } else {
                if (z4) {
                    objO = bVar.f().O();
                } else {
                    Objects.requireNonNull(bVar.f());
                    objO = null;
                }
                this.f3517c = objO;
                this.d = true;
            }
            if (!z5) {
                this.f3518e = null;
            } else if (z4) {
                this.f3518e = bVar.f().P();
            } else {
                Objects.requireNonNull(bVar.f());
                this.f3518e = null;
            }
        }

        private I f(Object obj) {
            if (obj == null) {
                return null;
            }
            I i2 = F.f3403b;
            if (obj instanceof Transition) {
                return i2;
            }
            I i4 = F.f3404c;
            if (i4 != null && i4.d(obj)) {
                return i4;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        final I e() {
            I iF = f(this.f3517c);
            I iF2 = f(this.f3518e);
            if (iF == null || iF2 == null || iF == iF2) {
                return iF != null ? iF : iF2;
            }
            StringBuilder sbD = D2.e.d("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            sbD.append(b().f());
            sbD.append(" returned Transition ");
            sbD.append(this.f3517c);
            sbD.append(" which uses a different Transition  type than its shared element transition ");
            sbD.append(this.f3518e);
            throw new IllegalArgumentException(sbD.toString());
        }

        public final Object g() {
            return this.f3518e;
        }

        final Object h() {
            return this.f3517c;
        }

        public final boolean i() {
            return this.f3518e != null;
        }

        final boolean j() {
            return this.d;
        }
    }

    C0207c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x06b8 A[LOOP:6: B:220:0x06b2->B:222:0x06b8, LOOP_END] */
    @Override // androidx.fragment.app.N
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void f(List<N.b> list, boolean z4) {
        ArrayList arrayList;
        HashMap map;
        ArrayList arrayList2;
        String str;
        HashMap map2;
        ArrayList arrayList3;
        boolean z5;
        String str2;
        N.b bVar;
        N.b bVar2;
        Iterator it;
        ArrayList<View> arrayList4;
        Object obj;
        View view;
        N.b bVar3;
        ArrayList<View> arrayList5;
        N.b bVar4;
        ArrayList<View> arrayList6;
        Object obj2;
        HashMap map3;
        ArrayList arrayList7;
        N.b bVar5;
        ArrayList<View> arrayList8;
        View view2;
        HashMap map4;
        N.b bVar6;
        ArrayList arrayList9;
        ArrayList arrayList10;
        C0365a c0365a;
        ArrayList<View> arrayList11;
        Rect rect;
        View view3;
        HashMap map5;
        ArrayList<View> arrayList12;
        ArrayList<String> arrayList13;
        ArrayList<String> arrayList14;
        ArrayList<String> arrayList15;
        ArrayList<String> arrayList16;
        int i2;
        View view4;
        View orDefault;
        View orDefault2;
        Iterator it2;
        Iterator it3;
        Iterator it4;
        C0207c c0207c = this;
        ArrayList arrayList17 = (ArrayList) list;
        Iterator it5 = arrayList17.iterator();
        N.b bVar7 = null;
        N.b bVar8 = null;
        while (it5.hasNext()) {
            N.b bVar9 = (N.b) it5.next();
            int iC = P.c(bVar9.f().f3418O);
            int iB = C0374g.b(bVar9.e());
            if (iB != 0) {
                if (iB != 1) {
                    if (iB == 2 || iB == 3) {
                    }
                } else if (iC != 2) {
                    bVar8 = bVar9;
                }
            }
            if (iC == 2 && bVar7 == null) {
                bVar7 = bVar9;
            }
        }
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = new ArrayList();
        ArrayList arrayList20 = new ArrayList(list);
        Iterator it6 = arrayList17.iterator();
        while (it6.hasNext()) {
            N.b bVar10 = (N.b) it6.next();
            B.a aVar = new B.a();
            bVar10.j(aVar);
            arrayList18.add(new b(bVar10, aVar, z4));
            B.a aVar2 = new B.a();
            bVar10.j(aVar2);
            arrayList19.add(new d(bVar10, aVar2, z4, !z4 ? bVar10 != bVar8 : bVar10 != bVar7));
            bVar10.a(c0207c.new a(arrayList20, bVar10));
        }
        HashMap map6 = new HashMap();
        Iterator it7 = arrayList19.iterator();
        I i4 = null;
        while (it7.hasNext()) {
            d dVar = (d) it7.next();
            if (!dVar.d()) {
                I iE = dVar.e();
                if (i4 == null) {
                    i4 = iE;
                } else if (iE != null && i4 != iE) {
                    StringBuilder sbD = D2.e.d("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    sbD.append(dVar.b().f());
                    sbD.append(" returned Transition ");
                    sbD.append(dVar.h());
                    sbD.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(sbD.toString());
                }
            }
        }
        if (i4 != null) {
            View view5 = new View(k().getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList21 = new ArrayList<>();
            ArrayList<View> arrayList22 = new ArrayList<>();
            C0365a c0365a2 = new C0365a();
            Iterator it8 = arrayList19.iterator();
            Object obj3 = null;
            String str3 = "FragmentManager";
            arrayList = arrayList18;
            N.b bVar11 = bVar7;
            N.b bVar12 = bVar8;
            View view6 = null;
            boolean z6 = false;
            while (it8.hasNext()) {
                d dVar2 = (d) it8.next();
                if (!dVar2.i() || bVar11 == null || bVar12 == null) {
                    bVar6 = bVar11;
                    arrayList9 = arrayList19;
                    arrayList10 = arrayList20;
                    c0365a = c0365a2;
                    arrayList11 = arrayList22;
                    rect = rect2;
                    view3 = view5;
                    map5 = map6;
                    arrayList12 = arrayList21;
                    bVar12 = bVar12;
                } else {
                    Object objS = i4.s(i4.e(dVar2.g()));
                    arrayList10 = arrayList20;
                    Fragment.b bVar13 = bVar8.f().f3420R;
                    if (bVar13 == null || (arrayList13 = bVar13.f3453h) == null) {
                        arrayList13 = new ArrayList<>();
                    }
                    N.b bVar14 = bVar12;
                    Fragment.b bVar15 = bVar7.f().f3420R;
                    if (bVar15 == null || (arrayList14 = bVar15.f3453h) == null) {
                        arrayList14 = new ArrayList<>();
                    }
                    bVar6 = bVar11;
                    Fragment.b bVar16 = bVar7.f().f3420R;
                    if (bVar16 == null || (arrayList15 = bVar16.f3454i) == null) {
                        arrayList15 = new ArrayList<>();
                    }
                    HashMap map7 = map6;
                    arrayList9 = arrayList19;
                    int i5 = 0;
                    while (i5 < arrayList15.size()) {
                        int iIndexOf = arrayList13.indexOf(arrayList15.get(i5));
                        ArrayList<String> arrayList23 = arrayList15;
                        if (iIndexOf != -1) {
                            arrayList13.set(iIndexOf, arrayList14.get(i5));
                        }
                        i5++;
                        arrayList15 = arrayList23;
                    }
                    Fragment.b bVar17 = bVar8.f().f3420R;
                    if (bVar17 == null || (arrayList16 = bVar17.f3454i) == null) {
                        arrayList16 = new ArrayList<>();
                    }
                    if (z4) {
                        Objects.requireNonNull(bVar7.f());
                        Objects.requireNonNull(bVar8.f());
                    } else {
                        Objects.requireNonNull(bVar7.f());
                        Objects.requireNonNull(bVar8.f());
                    }
                    int i6 = 0;
                    for (int size = arrayList13.size(); i6 < size; size = size) {
                        c0365a2.put(arrayList13.get(i6), arrayList16.get(i6));
                        i6++;
                    }
                    C0365a<String, View> c0365a3 = new C0365a<>();
                    c0207c.q(c0365a3, bVar7.f().f3418O);
                    c0365a3.m(arrayList13);
                    c0365a2.m(c0365a3.keySet());
                    C0365a<String, View> c0365a4 = new C0365a<>();
                    c0207c.q(c0365a4, bVar8.f().f3418O);
                    c0365a4.m(arrayList16);
                    c0365a4.m(c0365a2.values());
                    F.b(c0365a2, c0365a4);
                    c0207c.r(c0365a3, c0365a2.keySet());
                    c0207c.r(c0365a4, c0365a2.values());
                    if (c0365a2.isEmpty()) {
                        arrayList21.clear();
                        arrayList22.clear();
                        obj3 = null;
                        c0365a = c0365a2;
                        arrayList11 = arrayList22;
                        arrayList12 = arrayList21;
                        rect = rect2;
                        view3 = view5;
                        bVar12 = bVar14;
                        map5 = map7;
                    } else {
                        C0365a c0365a5 = c0365a2;
                        F.a(bVar8.f(), bVar7.f(), z4);
                        androidx.core.view.n.a(k(), new RunnableC0212h(bVar8, bVar7, z4, c0365a4));
                        arrayList21.addAll(c0365a3.values());
                        if (arrayList13.isEmpty()) {
                            i2 = 0;
                            view4 = null;
                            orDefault = view6;
                        } else {
                            i2 = 0;
                            view4 = null;
                            orDefault = c0365a3.getOrDefault(arrayList13.get(0), null);
                            i4.n(objS, orDefault);
                        }
                        arrayList22.addAll(c0365a4.values());
                        if (!arrayList16.isEmpty() && (orDefault2 = c0365a4.getOrDefault(arrayList16.get(i2), view4)) != null) {
                            androidx.core.view.n.a(k(), new RunnableC0213i(i4, orDefault2, rect2));
                            z6 = true;
                        }
                        i4.q(objS, view5, arrayList21);
                        c0365a = c0365a5;
                        arrayList11 = arrayList22;
                        arrayList12 = arrayList21;
                        rect = rect2;
                        view3 = view5;
                        i4.l(objS, null, null, null, null, objS, arrayList11);
                        Boolean bool = Boolean.TRUE;
                        map5 = map7;
                        map5.put(bVar7, bool);
                        map5.put(bVar8, bool);
                        bVar6 = bVar7;
                        obj3 = objS;
                        view6 = orDefault;
                        bVar12 = bVar8;
                    }
                }
                arrayList21 = arrayList12;
                rect2 = rect;
                map6 = map5;
                arrayList20 = arrayList10;
                bVar11 = bVar6;
                c0365a2 = c0365a;
                arrayList22 = arrayList11;
                view5 = view3;
                arrayList19 = arrayList9;
            }
            N.b bVar18 = bVar12;
            N.b bVar19 = bVar11;
            ArrayList arrayList24 = arrayList19;
            ArrayList arrayList25 = arrayList20;
            C0365a c0365a6 = c0365a2;
            ArrayList<View> arrayList26 = arrayList22;
            Rect rect3 = rect2;
            View view7 = view5;
            HashMap map8 = map6;
            ArrayList<View> arrayList27 = arrayList21;
            ArrayList arrayList28 = new ArrayList();
            Iterator it9 = arrayList24.iterator();
            Object objI = null;
            Object objI2 = null;
            while (it9.hasNext()) {
                d dVar3 = (d) it9.next();
                if (dVar3.d()) {
                    map8.put(dVar3.b(), Boolean.FALSE);
                    dVar3.a();
                } else {
                    Object objE = i4.e(dVar3.h());
                    N.b bVarB = dVar3.b();
                    if (obj3 != null) {
                        bVar2 = bVar19;
                        bVar = bVar18;
                        boolean z7 = bVarB == bVar2 || bVarB == bVar;
                        if (objE != null) {
                            if (!z7) {
                                map8.put(bVarB, Boolean.FALSE);
                                dVar3.a();
                            }
                            it = it9;
                            view = view7;
                            obj = obj3;
                            bVar3 = bVar;
                            map4 = map8;
                            view2 = view6;
                            arrayList7 = arrayList25;
                            arrayList6 = arrayList26;
                            arrayList5 = arrayList27;
                            bVar4 = bVar2;
                        } else {
                            HashMap map9 = map8;
                            ArrayList<View> arrayList29 = new ArrayList<>();
                            it = it9;
                            c0207c.p(arrayList29, bVarB.f().f3418O);
                            if (!z7) {
                                arrayList4 = arrayList26;
                                if (arrayList29.isEmpty()) {
                                    i4.a(objE, view7);
                                    arrayList5 = arrayList27;
                                    arrayList6 = arrayList4;
                                    view = view7;
                                    obj = obj3;
                                    bVar3 = bVar;
                                    bVar4 = bVar2;
                                    bVar5 = bVarB;
                                    obj2 = objE;
                                    arrayList8 = arrayList29;
                                    arrayList7 = arrayList25;
                                    map3 = map9;
                                } else {
                                    i4.b(objE, arrayList29);
                                    obj = obj3;
                                    view = view7;
                                    bVar3 = bVar;
                                    arrayList5 = arrayList27;
                                    bVar4 = bVar2;
                                    arrayList6 = arrayList4;
                                    obj2 = objE;
                                    map3 = map9;
                                    i4.l(objE, objE, arrayList29, null, null, null, null);
                                    if (bVarB.e() == 3) {
                                        arrayList7 = arrayList25;
                                        bVar5 = bVarB;
                                        arrayList7.remove(bVar5);
                                        arrayList8 = arrayList29;
                                        ArrayList<View> arrayList30 = new ArrayList<>(arrayList8);
                                        arrayList30.remove(bVar5.f().f3418O);
                                        i4.k(obj2, bVar5.f().f3418O, arrayList30);
                                        androidx.core.view.n.a(k(), new RunnableC0214j(arrayList8));
                                    } else {
                                        arrayList7 = arrayList25;
                                        bVar5 = bVarB;
                                        arrayList8 = arrayList29;
                                    }
                                }
                                if (bVar5.e() == 2) {
                                    arrayList28.addAll(arrayList8);
                                    if (z6) {
                                        i4.m(obj2, rect3);
                                    }
                                    view2 = view6;
                                } else {
                                    view2 = view6;
                                    i4.n(obj2, view2);
                                }
                                map4 = map3;
                                map4.put(bVar5, Boolean.TRUE);
                                if (dVar3.j()) {
                                    objI2 = i4.i(objI2, obj2, null);
                                } else {
                                    objI = i4.i(objI, obj2, null);
                                }
                            } else if (bVarB == bVar2) {
                                arrayList29.removeAll(arrayList27);
                                arrayList4 = arrayList26;
                                if (arrayList29.isEmpty()) {
                                }
                                if (bVar5.e() == 2) {
                                }
                                map4 = map3;
                                map4.put(bVar5, Boolean.TRUE);
                                if (dVar3.j()) {
                                }
                            } else {
                                arrayList4 = arrayList26;
                                arrayList29.removeAll(arrayList4);
                                if (arrayList29.isEmpty()) {
                                }
                                if (bVar5.e() == 2) {
                                }
                                map4 = map3;
                                map4.put(bVar5, Boolean.TRUE);
                                if (dVar3.j()) {
                                }
                            }
                        }
                        it9 = it;
                        obj3 = obj;
                        bVar18 = bVar3;
                        view6 = view2;
                        arrayList25 = arrayList7;
                        view7 = view;
                        c0207c = this;
                        bVar19 = bVar4;
                        map8 = map4;
                        arrayList27 = arrayList5;
                        arrayList26 = arrayList6;
                    } else {
                        bVar = bVar18;
                        bVar2 = bVar19;
                    }
                    if (objE != null) {
                    }
                    it9 = it;
                    obj3 = obj;
                    bVar18 = bVar3;
                    view6 = view2;
                    arrayList25 = arrayList7;
                    view7 = view;
                    c0207c = this;
                    bVar19 = bVar4;
                    map8 = map4;
                    arrayList27 = arrayList5;
                    arrayList26 = arrayList6;
                }
            }
            Object obj4 = obj3;
            map = map8;
            arrayList2 = arrayList25;
            N.b bVar20 = bVar18;
            ArrayList<View> arrayList31 = arrayList26;
            ArrayList<View> arrayList32 = arrayList27;
            N.b bVar21 = bVar19;
            Object objH = i4.h(objI2, objI, obj4);
            Iterator it10 = arrayList24.iterator();
            while (it10.hasNext()) {
                d dVar4 = (d) it10.next();
                if (!dVar4.d()) {
                    Object objH2 = dVar4.h();
                    N.b bVarB2 = dVar4.b();
                    boolean z8 = obj4 != null && (bVarB2 == bVar21 || bVarB2 == bVar20);
                    if (objH2 != null || z8) {
                        ViewGroup viewGroupK = k();
                        int i7 = androidx.core.view.o.d;
                        if (viewGroupK.isLaidOut()) {
                            str2 = str3;
                            Objects.requireNonNull(dVar4.b());
                            i4.o(objH, new RunnableC0215k(dVar4));
                        } else {
                            if (w.k0(2)) {
                                StringBuilder sbD2 = D2.e.d("SpecialEffectsController: Container ");
                                sbD2.append(k());
                                sbD2.append(" has not been laid out. Completing operation ");
                                sbD2.append(bVarB2);
                                str2 = str3;
                                Log.v(str2, sbD2.toString());
                            } else {
                                str2 = str3;
                            }
                            dVar4.a();
                        }
                    } else {
                        str2 = str3;
                    }
                    str3 = str2;
                }
            }
            str = str3;
            ViewGroup viewGroupK2 = k();
            int i8 = androidx.core.view.o.d;
            if (viewGroupK2.isLaidOut()) {
                F.c(arrayList28, 4);
                ArrayList<String> arrayListJ = i4.j(arrayList31);
                i4.c(k(), objH);
                map2 = map;
                arrayList3 = arrayList2;
                i4.p(k(), arrayList32, arrayList31, arrayListJ, c0365a6);
                F.c(arrayList28, 0);
                i4.r(obj4, arrayList32, arrayList31);
                z5 = false;
            }
            boolean zContainsValue = map2.containsValue(Boolean.TRUE);
            ViewGroup viewGroupK3 = k();
            Context context = viewGroupK3.getContext();
            ArrayList arrayList33 = new ArrayList();
            it2 = arrayList.iterator();
            boolean z9 = z5;
            while (it2.hasNext()) {
                b bVar22 = (b) it2.next();
                if (bVar22.d()) {
                    bVar22.a();
                } else {
                    C0220p.a aVarE = bVar22.e(context);
                    if (aVarE == null) {
                        bVar22.a();
                    } else {
                        Animator animator = aVarE.f3567b;
                        if (animator == null) {
                            arrayList33.add(bVar22);
                        } else {
                            N.b bVarB3 = bVar22.b();
                            Fragment fragmentF = bVarB3.f();
                            if (Boolean.TRUE.equals(map2.get(bVarB3))) {
                                if (w.k0(2)) {
                                    Log.v(str, "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                                }
                                bVar22.a();
                            } else {
                                boolean z10 = bVarB3.e() == 3 ? true : z5;
                                if (z10) {
                                    arrayList3.remove(bVarB3);
                                }
                                View view8 = fragmentF.f3418O;
                                viewGroupK3.startViewTransition(view8);
                                animator.addListener(new C0208d(viewGroupK3, view8, z10, bVarB3, bVar22));
                                animator.setTarget(view8);
                                animator.start();
                                bVar22.c().b(new C0209e(animator));
                                z9 = true;
                                z5 = z5;
                                map2 = map2;
                            }
                        }
                    }
                }
            }
            it3 = arrayList33.iterator();
            while (it3.hasNext()) {
                b bVar23 = (b) it3.next();
                N.b bVarB4 = bVar23.b();
                Fragment fragmentF2 = bVarB4.f();
                if (zContainsValue) {
                    if (w.k0(2)) {
                        Log.v(str, "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                    }
                    bVar23.a();
                } else if (z9) {
                    if (w.k0(2)) {
                        Log.v(str, "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                    }
                    bVar23.a();
                } else {
                    View view9 = fragmentF2.f3418O;
                    C0220p.a aVarE2 = bVar23.e(context);
                    Objects.requireNonNull(aVarE2);
                    Animation animation = aVarE2.f3566a;
                    Objects.requireNonNull(animation);
                    if (bVarB4.e() != 1) {
                        view9.startAnimation(animation);
                        bVar23.a();
                    } else {
                        viewGroupK3.startViewTransition(view9);
                        C0220p.b bVar24 = new C0220p.b(animation, viewGroupK3, view9);
                        bVar24.setAnimationListener(new AnimationAnimationListenerC0210f(viewGroupK3, view9, bVar23));
                        view9.startAnimation(bVar24);
                    }
                    bVar23.c().b(new C0211g(view9, viewGroupK3, bVar23));
                }
            }
            it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                N.b bVar25 = (N.b) it4.next();
                P.a(bVar25.e(), bVar25.f().f3418O);
            }
            arrayList3.clear();
        }
        Iterator it11 = arrayList19.iterator();
        while (it11.hasNext()) {
            d dVar5 = (d) it11.next();
            map6.put(dVar5.b(), Boolean.FALSE);
            dVar5.a();
        }
        map = map6;
        arrayList = arrayList18;
        arrayList2 = arrayList20;
        str = "FragmentManager";
        z5 = false;
        map2 = map;
        arrayList3 = arrayList2;
        boolean zContainsValue2 = map2.containsValue(Boolean.TRUE);
        ViewGroup viewGroupK32 = k();
        Context context2 = viewGroupK32.getContext();
        ArrayList arrayList332 = new ArrayList();
        it2 = arrayList.iterator();
        boolean z92 = z5;
        while (it2.hasNext()) {
        }
        it3 = arrayList332.iterator();
        while (it3.hasNext()) {
        }
        it4 = arrayList3.iterator();
        while (it4.hasNext()) {
        }
        arrayList3.clear();
    }

    final void p(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isTransitionGroup()) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                p(arrayList, childAt);
            }
        }
    }

    final void q(Map<String, View> map, View view) {
        int i2 = androidx.core.view.o.d;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    q(map, childAt);
                }
            }
        }
    }

    final void r(C0365a<String, View> c0365a, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = c0365a.entrySet().iterator();
        while (it.hasNext()) {
            View value = it.next().getValue();
            int i2 = androidx.core.view.o.d;
            if (!collection.contains(value.getTransitionName())) {
                it.remove();
            }
        }
    }
}
