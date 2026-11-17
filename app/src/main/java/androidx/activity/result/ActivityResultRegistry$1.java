package androidx.activity.result;

import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;

/* loaded from: classes.dex */
class ActivityResultRegistry$1 implements i {
    @Override // androidx.lifecycle.i
    public final void g(k kVar, g.b bVar) {
        if (g.b.ON_START.equals(bVar) || g.b.ON_STOP.equals(bVar) || g.b.ON_DESTROY.equals(bVar)) {
            throw null;
        }
    }
}
