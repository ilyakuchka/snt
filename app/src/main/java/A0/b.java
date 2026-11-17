package A0;

import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public abstract class b extends c implements a4.c {
    b(a4.f fVar) {
        super(fVar);
    }

    @Override // A0.d, a4.d
    public final float l() {
        float fL = super.l();
        if (fL == 0.0f) {
            NodeList elementsByTagName = e.this.A().getElementsByTagName("par");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                a4.d dVar = (a4.d) elementsByTagName.item(i2);
                if (dVar.l() < 0.0f) {
                    return -1.0f;
                }
                fL += dVar.l();
            }
        }
        return fL;
    }
}
