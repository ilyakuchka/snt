package O0;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<l> f805i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private Iterator<l> f806j;

    public final void a(l lVar) {
        this.f805i.add(lVar);
    }

    public final void b(l lVar) {
        Iterator<l> it = this.f806j;
        if (it != null) {
            it.remove();
        } else {
            this.f805i.remove(lVar);
        }
    }

    public final void c() {
        this.f806j = this.f805i.iterator();
        while (true) {
            try {
                if (!this.f806j.hasNext()) {
                    return;
                } else {
                    this.f806j.next().a(this);
                }
            } finally {
                this.f806j = null;
            }
        }
    }
}
