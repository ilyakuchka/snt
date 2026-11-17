package l1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final Set<h> f6516a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private boolean f6517b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6518c;

    a() {
    }

    @Override // l1.g
    public final void a(h hVar) {
        this.f6516a.add(hVar);
        if (this.f6518c) {
            hVar.e();
        } else if (this.f6517b) {
            hVar.d();
        } else {
            hVar.a();
        }
    }

    @Override // l1.g
    public final void b(h hVar) {
        this.f6516a.remove(hVar);
    }

    final void c() {
        this.f6518c = true;
        Iterator it = ((ArrayList) s1.j.e(this.f6516a)).iterator();
        while (it.hasNext()) {
            ((h) it.next()).e();
        }
    }

    final void d() {
        this.f6517b = true;
        Iterator it = ((ArrayList) s1.j.e(this.f6516a)).iterator();
        while (it.hasNext()) {
            ((h) it.next()).d();
        }
    }

    final void e() {
        this.f6517b = false;
        Iterator it = ((ArrayList) s1.j.e(this.f6516a)).iterator();
        while (it.hasNext()) {
            ((h) it.next()).a();
        }
    }
}
