package l1;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Set<o1.b> f6537a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final List<o1.b> f6538b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f6539c;

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<o1.b>] */
    public final boolean a(o1.b bVar) {
        boolean z4 = true;
        if (bVar == null) {
            return true;
        }
        boolean zRemove = this.f6537a.remove(bVar);
        if (!this.f6538b.remove(bVar) && !zRemove) {
            z4 = false;
        }
        if (z4) {
            bVar.clear();
        }
        return z4;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<o1.b>] */
    public final void b() {
        Iterator it = ((ArrayList) s1.j.e(this.f6537a)).iterator();
        while (it.hasNext()) {
            a((o1.b) it.next());
        }
        this.f6538b.clear();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<o1.b>] */
    public final void c() {
        this.f6539c = true;
        Iterator it = ((ArrayList) s1.j.e(this.f6537a)).iterator();
        while (it.hasNext()) {
            o1.b bVar = (o1.b) it.next();
            if (bVar.isRunning()) {
                bVar.a();
                this.f6538b.add(bVar);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<o1.b>] */
    public final void d() {
        Iterator it = ((ArrayList) s1.j.e(this.f6537a)).iterator();
        while (it.hasNext()) {
            o1.b bVar = (o1.b) it.next();
            if (!bVar.c() && !bVar.d()) {
                bVar.clear();
                if (this.f6539c) {
                    this.f6538b.add(bVar);
                } else {
                    bVar.b();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<o1.b>] */
    public final void e() {
        this.f6539c = false;
        Iterator it = ((ArrayList) s1.j.e(this.f6537a)).iterator();
        while (it.hasNext()) {
            o1.b bVar = (o1.b) it.next();
            if (!bVar.c() && !bVar.isRunning()) {
                bVar.b();
            }
        }
        this.f6538b.clear();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<o1.b>] */
    public final void f(o1.b bVar) {
        this.f6537a.add(bVar);
        if (!this.f6539c) {
            bVar.b();
            return;
        }
        bVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f6538b.add(bVar);
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f6537a.size() + ", isPaused=" + this.f6539c + "}";
    }
}
