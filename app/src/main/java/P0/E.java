package P0;

import com.android.mmt.ui.I0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<I0> f891a = new ArrayList<>();

    public final void a(I0 i02) {
        this.f891a.add(i02);
    }

    public final I0 b() {
        Iterator<I0> it = this.f891a.iterator();
        I0 i02 = null;
        while (it.hasNext()) {
            I0 next = it.next();
            if (next.y() == 0) {
                i02 = next;
            } else if (next.y() == 3 || next.y() == 2 || next.y() == 1 || next.y() == 4 || next.y() == 5) {
                return next;
            }
        }
        return i02;
    }

    public final I0 c(int i2) {
        if (i2 < this.f891a.size()) {
            return this.f891a.get(i2);
        }
        return null;
    }

    public final int d() {
        return this.f891a.size();
    }

    public final I0 e() {
        Iterator<I0> it = this.f891a.iterator();
        while (it.hasNext()) {
            I0 next = it.next();
            if (next.y() == 0) {
                return next;
            }
        }
        return null;
    }

    public final boolean f() {
        return this.f891a.isEmpty();
    }
}
