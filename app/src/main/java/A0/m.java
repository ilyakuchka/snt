package A0;

import org.w3c.dom.DOMException;

/* loaded from: classes.dex */
public final class m extends f implements a4.l {
    m(e eVar, String str) {
        super(eVar, str);
    }

    private int A(String str) {
        if (str.endsWith("px")) {
            str = str.substring(0, str.indexOf("px"));
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // a4.a
    public final void e(int i2) throws DOMException {
        setAttribute("height", String.valueOf(i2) + "px");
    }

    @Override // a4.a
    public final int g() {
        return A(getAttribute("width"));
    }

    @Override // a4.a
    public final int k() {
        return A(getAttribute("height"));
    }

    @Override // a4.a
    public final void m(String str) throws DOMException {
        setAttribute("backgroundColor", str);
    }

    @Override // a4.a
    public final void o(int i2) throws DOMException {
        setAttribute("width", String.valueOf(i2) + "px");
    }
}
