package A0;

import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class l extends h implements a4.k {

    /* renamed from: h, reason: collision with root package name */
    private a4.j f5h;

    l(e eVar, String str) {
        super(eVar, str);
    }

    @Override // a4.k
    public final a4.j q() {
        if (this.f5h == null) {
            NodeList elementsByTagName = ((a4.e) getOwnerDocument()).n().getElementsByTagName("region");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                a4.j jVar = (a4.j) elementsByTagName.item(i2);
                if (jVar.getId().equals(getAttribute("region"))) {
                    this.f5h = jVar;
                }
            }
        }
        return this.f5h;
    }

    @Override // a4.k
    public final void s(a4.j jVar) throws DOMException {
        setAttribute("region", jVar.getId());
        this.f5h = jVar;
    }
}
