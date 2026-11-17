package O3;

import Y2.h;
import e3.InterfaceC0299a;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ InterfaceC0299a<h> f848e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, InterfaceC0299a interfaceC0299a) {
        super(str, true);
        this.f848e = interfaceC0299a;
    }

    @Override // O3.a
    public final long f() {
        this.f848e.a();
        return -1L;
    }
}
