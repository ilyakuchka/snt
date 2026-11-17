package androidx.lifecycle;

import androidx.lifecycle.g;
import java.util.HashMap;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements i {

    /* renamed from: a, reason: collision with root package name */
    private final f[] f3645a;

    CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.f3645a = fVarArr;
    }

    @Override // androidx.lifecycle.i
    public final void g(k kVar, g.b bVar) {
        new HashMap();
        for (f fVar : this.f3645a) {
            fVar.a();
        }
        for (f fVar2 : this.f3645a) {
            fVar2.a();
        }
    }
}
