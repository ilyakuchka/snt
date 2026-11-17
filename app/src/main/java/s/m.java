package s;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    HashSet<m> f7828a = new HashSet<>(2);

    /* renamed from: b, reason: collision with root package name */
    int f7829b = 0;

    public final void a(m mVar) {
        this.f7828a.add(mVar);
    }

    public final void b() {
        this.f7829b = 1;
        Iterator<m> it = this.f7828a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public final void c() {
        this.f7829b = 0;
        Iterator<m> it = this.f7828a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public final boolean d() {
        return this.f7829b == 1;
    }

    public void e() {
    }
}
