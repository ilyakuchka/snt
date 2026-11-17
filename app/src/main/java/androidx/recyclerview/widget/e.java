package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e extends x {

    /* renamed from: s, reason: collision with root package name */
    private static TimeInterpolator f4136s;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<RecyclerView.x> f4137h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<RecyclerView.x> f4138i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<C0074e> f4139j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<d> f4140k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.x>> f4141l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    ArrayList<ArrayList<C0074e>> f4142m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    ArrayList<ArrayList<d>> f4143n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    ArrayList<RecyclerView.x> f4144o = new ArrayList<>();
    ArrayList<RecyclerView.x> p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    ArrayList<RecyclerView.x> f4145q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    ArrayList<RecyclerView.x> f4146r = new ArrayList<>();

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f4147i;

        a(ArrayList arrayList) {
            this.f4147i = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = this.f4147i.iterator();
            while (it.hasNext()) {
                C0074e c0074e = (C0074e) it.next();
                e eVar = e.this;
                RecyclerView.x xVar = c0074e.f4158a;
                int i2 = c0074e.f4159b;
                int i4 = c0074e.f4160c;
                int i5 = c0074e.d;
                int i6 = c0074e.f4161e;
                Objects.requireNonNull(eVar);
                View view = xVar.f4055i;
                int i7 = i5 - i2;
                int i8 = i6 - i4;
                if (i7 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i8 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                eVar.p.add(xVar);
                viewPropertyAnimatorAnimate.setDuration(eVar.i()).setListener(new h(eVar, xVar, i7, view, i8, viewPropertyAnimatorAnimate)).start();
            }
            this.f4147i.clear();
            e.this.f4142m.remove(this.f4147i);
        }
    }

    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f4149i;

        b(ArrayList arrayList) {
            this.f4149i = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = this.f4149i.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                e eVar = e.this;
                Objects.requireNonNull(eVar);
                RecyclerView.x xVar = dVar.f4153a;
                View view = xVar == null ? null : xVar.f4055i;
                RecyclerView.x xVar2 = dVar.f4154b;
                View view2 = xVar2 != null ? xVar2.f4055i : null;
                if (view != null) {
                    ViewPropertyAnimator duration = view.animate().setDuration(eVar.h());
                    eVar.f4146r.add(dVar.f4153a);
                    duration.translationX(dVar.f4156e - dVar.f4155c);
                    duration.translationY(dVar.f4157f - dVar.d);
                    duration.alpha(0.0f).setListener(new i(eVar, dVar, duration, view)).start();
                }
                if (view2 != null) {
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
                    eVar.f4146r.add(dVar.f4154b);
                    viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(eVar.h()).alpha(1.0f).setListener(new j(eVar, dVar, viewPropertyAnimatorAnimate, view2)).start();
                }
            }
            this.f4149i.clear();
            e.this.f4143n.remove(this.f4149i);
        }
    }

    final class c implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f4151i;

        c(ArrayList arrayList) {
            this.f4151i = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = this.f4151i.iterator();
            while (it.hasNext()) {
                RecyclerView.x xVar = (RecyclerView.x) it.next();
                e eVar = e.this;
                Objects.requireNonNull(eVar);
                View view = xVar.f4055i;
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                eVar.f4144o.add(xVar);
                viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(eVar.g()).setListener(new g(eVar, xVar, view, viewPropertyAnimatorAnimate)).start();
            }
            this.f4151i.clear();
            e.this.f4141l.remove(this.f4151i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.x f4153a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.x f4154b;

        /* renamed from: c, reason: collision with root package name */
        public int f4155c;
        public int d;

        /* renamed from: e, reason: collision with root package name */
        public int f4156e;

        /* renamed from: f, reason: collision with root package name */
        public int f4157f;

        d(RecyclerView.x xVar, RecyclerView.x xVar2, int i2, int i4, int i5, int i6) {
            this.f4153a = xVar;
            this.f4154b = xVar2;
            this.f4155c = i2;
            this.d = i4;
            this.f4156e = i5;
            this.f4157f = i6;
        }

        public final String toString() {
            StringBuilder sbD = D2.e.d("ChangeInfo{oldHolder=");
            sbD.append(this.f4153a);
            sbD.append(", newHolder=");
            sbD.append(this.f4154b);
            sbD.append(", fromX=");
            sbD.append(this.f4155c);
            sbD.append(", fromY=");
            sbD.append(this.d);
            sbD.append(", toX=");
            sbD.append(this.f4156e);
            sbD.append(", toY=");
            sbD.append(this.f4157f);
            sbD.append('}');
            return sbD.toString();
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$e, reason: collision with other inner class name */
    private static class C0074e {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.x f4158a;

        /* renamed from: b, reason: collision with root package name */
        public int f4159b;

        /* renamed from: c, reason: collision with root package name */
        public int f4160c;
        public int d;

        /* renamed from: e, reason: collision with root package name */
        public int f4161e;

        C0074e(RecyclerView.x xVar, int i2, int i4, int i5, int i6) {
            this.f4158a = xVar;
            this.f4159b = i2;
            this.f4160c = i4;
            this.d = i5;
            this.f4161e = i6;
        }
    }

    private void t(List<d> list, RecyclerView.x xVar) {
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            d dVar = list.get(size);
            if (u(dVar, xVar) && dVar.f4153a == null && dVar.f4154b == null) {
                list.remove(dVar);
            }
        }
    }

    private boolean u(d dVar, RecyclerView.x xVar) {
        if (dVar.f4154b == xVar) {
            dVar.f4154b = null;
        } else {
            if (dVar.f4153a != xVar) {
                return false;
            }
            dVar.f4153a = null;
        }
        xVar.f4055i.setAlpha(1.0f);
        xVar.f4055i.setTranslationX(0.0f);
        xVar.f4055i.setTranslationY(0.0f);
        c(xVar);
        return true;
    }

    private void v(RecyclerView.x xVar) {
        if (f4136s == null) {
            f4136s = new ValueAnimator().getInterpolator();
        }
        xVar.f4055i.animate().setInterpolator(f4136s);
        e(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final void e(RecyclerView.x xVar) {
        View view = xVar.f4055i;
        view.animate().cancel();
        int size = this.f4139j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f4139j.get(size).f4158a == xVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(xVar);
                this.f4139j.remove(size);
            }
        }
        t(this.f4140k, xVar);
        if (this.f4137h.remove(xVar)) {
            view.setAlpha(1.0f);
            c(xVar);
        }
        if (this.f4138i.remove(xVar)) {
            view.setAlpha(1.0f);
            c(xVar);
        }
        for (int size2 = this.f4143n.size() - 1; size2 >= 0; size2--) {
            ArrayList<d> arrayList = this.f4143n.get(size2);
            t(arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.f4143n.remove(size2);
            }
        }
        for (int size3 = this.f4142m.size() - 1; size3 >= 0; size3--) {
            ArrayList<C0074e> arrayList2 = this.f4142m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f4158a == xVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f4142m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f4141l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.x> arrayList3 = this.f4141l.get(size5);
            if (arrayList3.remove(xVar)) {
                view.setAlpha(1.0f);
                c(xVar);
                if (arrayList3.isEmpty()) {
                    this.f4141l.remove(size5);
                }
            }
        }
        this.f4145q.remove(xVar);
        this.f4144o.remove(xVar);
        this.f4146r.remove(xVar);
        this.p.remove(xVar);
        s();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final void f() {
        int size = this.f4139j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0074e c0074e = this.f4139j.get(size);
            View view = c0074e.f4158a.f4055i;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(c0074e.f4158a);
            this.f4139j.remove(size);
        }
        int size2 = this.f4137h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            c(this.f4137h.get(size2));
            this.f4137h.remove(size2);
        }
        int size3 = this.f4138i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.x xVar = this.f4138i.get(size3);
            xVar.f4055i.setAlpha(1.0f);
            c(xVar);
            this.f4138i.remove(size3);
        }
        int size4 = this.f4140k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            d dVar = this.f4140k.get(size4);
            RecyclerView.x xVar2 = dVar.f4153a;
            if (xVar2 != null) {
                u(dVar, xVar2);
            }
            RecyclerView.x xVar3 = dVar.f4154b;
            if (xVar3 != null) {
                u(dVar, xVar3);
            }
        }
        this.f4140k.clear();
        if (!k()) {
            return;
        }
        int size5 = this.f4142m.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<C0074e> arrayList = this.f4142m.get(size5);
            int size6 = arrayList.size();
            while (true) {
                size6--;
                if (size6 >= 0) {
                    C0074e c0074e2 = arrayList.get(size6);
                    View view2 = c0074e2.f4158a.f4055i;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(c0074e2.f4158a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f4142m.remove(arrayList);
                    }
                }
            }
        }
        int size7 = this.f4141l.size();
        while (true) {
            size7--;
            if (size7 < 0) {
                break;
            }
            ArrayList<RecyclerView.x> arrayList2 = this.f4141l.get(size7);
            int size8 = arrayList2.size();
            while (true) {
                size8--;
                if (size8 >= 0) {
                    RecyclerView.x xVar4 = arrayList2.get(size8);
                    xVar4.f4055i.setAlpha(1.0f);
                    c(xVar4);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f4141l.remove(arrayList2);
                    }
                }
            }
        }
        int size9 = this.f4143n.size();
        while (true) {
            size9--;
            if (size9 < 0) {
                r(this.f4145q);
                r(this.p);
                r(this.f4144o);
                r(this.f4146r);
                d();
                return;
            }
            ArrayList<d> arrayList3 = this.f4143n.get(size9);
            int size10 = arrayList3.size();
            while (true) {
                size10--;
                if (size10 >= 0) {
                    d dVar2 = arrayList3.get(size10);
                    RecyclerView.x xVar5 = dVar2.f4153a;
                    if (xVar5 != null) {
                        u(dVar2, xVar5);
                    }
                    RecyclerView.x xVar6 = dVar2.f4154b;
                    if (xVar6 != null) {
                        u(dVar2, xVar6);
                    }
                    if (arrayList3.isEmpty()) {
                        this.f4143n.remove(arrayList3);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean k() {
        return (this.f4138i.isEmpty() && this.f4140k.isEmpty() && this.f4139j.isEmpty() && this.f4137h.isEmpty() && this.p.isEmpty() && this.f4145q.isEmpty() && this.f4144o.isEmpty() && this.f4146r.isEmpty() && this.f4142m.isEmpty() && this.f4141l.isEmpty() && this.f4143n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final void l() {
        boolean z4 = !this.f4137h.isEmpty();
        boolean z5 = !this.f4139j.isEmpty();
        boolean z6 = !this.f4140k.isEmpty();
        boolean z7 = !this.f4138i.isEmpty();
        if (z4 || z5 || z7 || z6) {
            Iterator<RecyclerView.x> it = this.f4137h.iterator();
            while (it.hasNext()) {
                RecyclerView.x next = it.next();
                View view = next.f4055i;
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                this.f4145q.add(next);
                viewPropertyAnimatorAnimate.setDuration(j()).alpha(0.0f).setListener(new f(this, next, viewPropertyAnimatorAnimate, view)).start();
            }
            this.f4137h.clear();
            if (z5) {
                ArrayList<C0074e> arrayList = new ArrayList<>();
                arrayList.addAll(this.f4139j);
                this.f4142m.add(arrayList);
                this.f4139j.clear();
                a aVar = new a(arrayList);
                if (z4) {
                    View view2 = arrayList.get(0).f4158a.f4055i;
                    long j2 = j();
                    int i2 = androidx.core.view.o.d;
                    view2.postOnAnimationDelayed(aVar, j2);
                } else {
                    aVar.run();
                }
            }
            if (z6) {
                ArrayList<d> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f4140k);
                this.f4143n.add(arrayList2);
                this.f4140k.clear();
                b bVar = new b(arrayList2);
                if (z4) {
                    View view3 = arrayList2.get(0).f4153a.f4055i;
                    long j4 = j();
                    int i4 = androidx.core.view.o.d;
                    view3.postOnAnimationDelayed(bVar, j4);
                } else {
                    bVar.run();
                }
            }
            if (z7) {
                ArrayList<RecyclerView.x> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f4138i);
                this.f4141l.add(arrayList3);
                this.f4138i.clear();
                c cVar = new c(arrayList3);
                if (!z4 && !z5 && !z6) {
                    cVar.run();
                    return;
                }
                long jMax = Math.max(z5 ? i() : 0L, z6 ? h() : 0L) + (z4 ? j() : 0L);
                View view4 = arrayList3.get(0).f4055i;
                int i5 = androidx.core.view.o.d;
                view4.postOnAnimationDelayed(cVar, jMax);
            }
        }
    }

    @Override // androidx.recyclerview.widget.x
    public final void n(RecyclerView.x xVar) {
        v(xVar);
        xVar.f4055i.setAlpha(0.0f);
        this.f4138i.add(xVar);
    }

    @Override // androidx.recyclerview.widget.x
    public final boolean o(RecyclerView.x xVar, RecyclerView.x xVar2, int i2, int i4, int i5, int i6) {
        if (xVar == xVar2) {
            return p(xVar, i2, i4, i5, i6);
        }
        float translationX = xVar.f4055i.getTranslationX();
        float translationY = xVar.f4055i.getTranslationY();
        float alpha = xVar.f4055i.getAlpha();
        v(xVar);
        xVar.f4055i.setTranslationX(translationX);
        xVar.f4055i.setTranslationY(translationY);
        xVar.f4055i.setAlpha(alpha);
        v(xVar2);
        xVar2.f4055i.setTranslationX(-((int) ((i5 - i2) - translationX)));
        xVar2.f4055i.setTranslationY(-((int) ((i6 - i4) - translationY)));
        xVar2.f4055i.setAlpha(0.0f);
        this.f4140k.add(new d(xVar, xVar2, i2, i4, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.x
    public final boolean p(RecyclerView.x xVar, int i2, int i4, int i5, int i6) {
        View view = xVar.f4055i;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i4 + ((int) xVar.f4055i.getTranslationY());
        v(xVar);
        int i7 = i5 - translationX;
        int i8 = i6 - translationY;
        if (i7 == 0 && i8 == 0) {
            c(xVar);
            return false;
        }
        if (i7 != 0) {
            view.setTranslationX(-i7);
        }
        if (i8 != 0) {
            view.setTranslationY(-i8);
        }
        this.f4139j.add(new C0074e(xVar, translationX, translationY, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.x
    public final void q(RecyclerView.x xVar) {
        v(xVar);
        this.f4137h.add(xVar);
    }

    final void r(List<RecyclerView.x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f4055i.animate().cancel();
        }
    }

    final void s() {
        if (k()) {
            return;
        }
        d();
    }
}
