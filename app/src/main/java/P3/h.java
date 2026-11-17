package P3;

import L3.r;
import e3.InterfaceC0299a;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class h extends f3.d implements InterfaceC0299a<List<? extends X509Certificate>> {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ f f1039i;

    h(f fVar) {
        this.f1039i = fVar;
    }

    @Override // e3.InterfaceC0299a
    public final List<? extends X509Certificate> a() {
        r rVar = this.f1039i.f1024e;
        f3.c.b(rVar);
        List<Certificate> listD = rVar.d();
        ArrayList arrayList = new ArrayList(Z2.g.d(listD));
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add((X509Certificate) ((Certificate) it.next()));
        }
        return arrayList;
    }
}
