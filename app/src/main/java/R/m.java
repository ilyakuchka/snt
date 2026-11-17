package R;

import R.g;
import R.l;
import java.util.Set;
import n.C0352a;

/* loaded from: classes.dex */
final class m extends g.c {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f1298b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(l lVar, String[] strArr) {
        super(strArr);
        this.f1298b = lVar;
    }

    @Override // R.g.c
    public final void a(Set<String> set) {
        C0352a c0352aK = C0352a.k();
        Runnable runnable = this.f1298b.u;
        if (c0352aK.m()) {
            ((l.b) runnable).run();
        } else {
            c0352aK.n(runnable);
        }
    }
}
