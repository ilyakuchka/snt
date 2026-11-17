package A0;

import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;
import y0.C0425f;

/* loaded from: classes.dex */
public final class g extends f implements a4.g {
    g(e eVar, String str) {
        super(eVar, str);
    }

    @Override // a4.g
    public final NodeList u() {
        return getElementsByTagName("region");
    }

    @Override // a4.g
    public final a4.l w() throws DOMException {
        C0425f c0425f = (C0425f) getChildNodes();
        int length = c0425f.getLength();
        a4.l lVar = null;
        for (int i2 = 0; i2 < length; i2++) {
            if (c0425f.item(i2).getNodeName().equals("root-layout")) {
                lVar = (a4.l) c0425f.item(i2);
            }
        }
        if (lVar != null) {
            return lVar;
        }
        a4.l lVar2 = (a4.l) ((e) getOwnerDocument()).createElement("root-layout");
        lVar2.o(F0.b.a().b().d());
        lVar2.e(F0.b.a().b().a());
        appendChild(lVar2);
        return lVar2;
    }
}
