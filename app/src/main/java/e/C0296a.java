package e;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: e.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0296a {

    /* renamed from: a, reason: collision with root package name */
    private final Set<InterfaceC0297b> f6164a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f6165b;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set<e.b>, java.util.concurrent.CopyOnWriteArraySet] */
    public final void a(InterfaceC0297b interfaceC0297b) {
        if (this.f6165b != null) {
            interfaceC0297b.a();
        }
        this.f6164a.add(interfaceC0297b);
    }

    public final void b() {
        this.f6165b = null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set<e.b>, java.util.concurrent.CopyOnWriteArraySet] */
    public final void c(Context context) {
        this.f6165b = context;
        Iterator it = this.f6164a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0297b) it.next()).a();
        }
    }
}
