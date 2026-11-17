package P3;

import L3.C0150a;
import L3.r;
import e3.InterfaceC0299a;
import java.security.cert.Certificate;
import java.util.List;

/* loaded from: classes.dex */
final class g extends f3.d implements InterfaceC0299a<List<? extends Certificate>> {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ L3.g f1036i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ r f1037j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ C0150a f1038k;

    g(L3.g gVar, r rVar, C0150a c0150a) {
        this.f1036i = gVar;
        this.f1037j = rVar;
        this.f1038k = c0150a;
    }

    @Override // e3.InterfaceC0299a
    public final List<? extends Certificate> a() {
        W3.c cVarC = this.f1036i.c();
        f3.c.b(cVarC);
        return cVarC.a(this.f1037j.d(), this.f1038k.l().g());
    }
}
