package G0;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class l {

    /* renamed from: i, reason: collision with root package name */
    protected ArrayList<h> f174i = new ArrayList<>();

    protected final void g() {
        Iterator<h> it = this.f174i.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public final void h(h hVar) {
        if (this.f174i.contains(hVar)) {
            return;
        }
        this.f174i.add(hVar);
        i(hVar);
    }

    protected void i(h hVar) {
    }

    public final void k() {
        l();
        this.f174i.clear();
    }

    protected void l() {
    }

    public final void n(h hVar) {
        this.f174i.remove(hVar);
        o(hVar);
    }

    protected void o(h hVar) {
    }
}
