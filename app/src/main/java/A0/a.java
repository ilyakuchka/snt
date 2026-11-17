package A0;

import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;
import y0.C0425f;

/* loaded from: classes.dex */
public abstract class a extends c implements a4.b {
    a(a4.f fVar) {
        super(fVar);
    }

    public final void e() throws DOMException {
        this.f0a.setAttribute("endsync", "last");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    @Override // A0.d, a4.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float l() throws DOMException {
        float fL = super.l();
        if (fL != 0.0f) {
            return fL;
        }
        String attribute = this.f0a.getAttribute("endsync");
        if (attribute != null && attribute.length() != 0) {
            if (!"first".equals(attribute) && !"last".equals(attribute) && !"all".equals(attribute) && !"media".equals(attribute)) {
                e();
            }
            if ("last".equals(attribute)) {
                NodeList childNodes = i.this.getChildNodes();
                int i2 = 0;
                float f4 = -1.0f;
                loop0: while (true) {
                    C0425f c0425f = (C0425f) childNodes;
                    if (i2 >= c0425f.getLength()) {
                        return f4;
                    }
                    o oVarA = ((a4.d) c0425f.item(i2)).a();
                    for (int i4 = 0; i4 < oVarA.a(); i4++) {
                        a4.m mVarB = oVarA.b(i4);
                        if (mVarB.d() == 0) {
                            break loop0;
                        }
                        if (mVarB.a()) {
                            float fC = (float) mVarB.c();
                            if (fC > f4) {
                                f4 = fC;
                            }
                        }
                    }
                    i2++;
                }
            }
            return -1.0f;
        }
        e();
        attribute = "last";
        if ("last".equals(attribute)) {
        }
        return -1.0f;
    }
}
