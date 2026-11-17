package l1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class o implements h {

    /* renamed from: i, reason: collision with root package name */
    private final Set<p1.f<?>> f6547i = Collections.newSetFromMap(new WeakHashMap());

    @Override // l1.h
    public final void a() {
        Iterator it = ((ArrayList) s1.j.e(this.f6547i)).iterator();
        while (it.hasNext()) {
            ((p1.f) it.next()).a();
        }
    }

    @Override // l1.h
    public final void d() {
        Iterator it = ((ArrayList) s1.j.e(this.f6547i)).iterator();
        while (it.hasNext()) {
            ((p1.f) it.next()).d();
        }
    }

    @Override // l1.h
    public final void e() {
        Iterator it = ((ArrayList) s1.j.e(this.f6547i)).iterator();
        while (it.hasNext()) {
            ((p1.f) it.next()).e();
        }
    }

    public final void l() {
        this.f6547i.clear();
    }

    public final List<p1.f<?>> m() {
        return s1.j.e(this.f6547i);
    }

    public final void n(p1.f<?> fVar) {
        this.f6547i.add(fVar);
    }

    public final void o(p1.f<?> fVar) {
        this.f6547i.remove(fVar);
    }
}
