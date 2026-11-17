package A0;

import org.w3c.dom.DOMException;

/* loaded from: classes.dex */
public final class k extends f implements a4.j {
    k(e eVar, String str) {
        super(eVar, str);
    }

    private int A(String str, boolean z4) {
        if (str.endsWith("px")) {
            return Integer.parseInt(str.substring(0, str.indexOf("px")));
        }
        if (str.endsWith("%")) {
            return (int) Math.round(Integer.parseInt(str.substring(0, str.length() - 1)) * 0.01d * (z4 ? ((a4.e) getOwnerDocument()).n().w().g() : ((a4.e) getOwnerDocument()).n().w().k()));
        }
        return Integer.parseInt(str);
    }

    @Override // a4.j
    public final void b(int i2) throws DOMException {
        setAttribute("top", String.valueOf(i2));
    }

    @Override // a4.j
    public final void c(String str) throws DOMException {
        if (str.equalsIgnoreCase("fill") || str.equalsIgnoreCase("meet") || str.equalsIgnoreCase("scroll") || str.equalsIgnoreCase("slice")) {
            setAttribute("fit", str.toLowerCase());
        } else {
            setAttribute("fit", "hidden");
        }
    }

    @Override // a4.a
    public final void e(int i2) throws DOMException {
        setAttribute("height", String.valueOf(i2) + "px");
    }

    @Override // a4.a
    public final int g() {
        try {
            int iA = A(getAttribute("width"), true);
            return iA == 0 ? ((a4.e) getOwnerDocument()).n().w().g() : iA;
        } catch (NumberFormatException unused) {
            int iG = ((a4.e) getOwnerDocument()).n().w().g();
            try {
                iG -= A(getAttribute("left"), true);
            } catch (NumberFormatException unused2) {
            }
            try {
                return iG - A(getAttribute("right"), true);
            } catch (NumberFormatException unused3) {
                return iG;
            }
        }
    }

    @Override // a4.f
    public final String getId() {
        return getAttribute("id");
    }

    @Override // a4.j
    public final int h() {
        try {
            try {
                return A(getAttribute("top"), false);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } catch (NumberFormatException unused2) {
            return (((a4.e) this.getOwnerDocument()).n().w().k() - this.A(this.getAttribute("bottom"), false)) - this.A(this.getAttribute("height"), false);
        }
    }

    @Override // a4.f
    public final void i(String str) throws DOMException {
        setAttribute("id", str);
    }

    @Override // a4.j
    public final int j() {
        try {
            try {
                return A(getAttribute("left"), true);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } catch (NumberFormatException unused2) {
            return (((a4.e) this.getOwnerDocument()).n().w().g() - this.A(this.getAttribute("right"), true)) - this.A(this.getAttribute("width"), true);
        }
    }

    @Override // a4.a
    public final int k() {
        try {
            int iA = A(getAttribute("height"), false);
            return iA == 0 ? ((a4.e) getOwnerDocument()).n().w().k() : iA;
        } catch (NumberFormatException unused) {
            int iK = ((a4.e) getOwnerDocument()).n().w().k();
            try {
                iK -= A(getAttribute("top"), false);
            } catch (NumberFormatException unused2) {
            }
            try {
                return iK - A(getAttribute("bottom"), false);
            } catch (NumberFormatException unused3) {
                return iK;
            }
        }
    }

    @Override // a4.a
    public final void o(int i2) throws DOMException {
        setAttribute("width", String.valueOf(i2) + "px");
    }

    @Override // a4.j
    public final String t() {
        String attribute = getAttribute("fit");
        return "fill".equalsIgnoreCase(attribute) ? "fill" : "meet".equalsIgnoreCase(attribute) ? "meet" : "scroll".equalsIgnoreCase(attribute) ? "scroll" : "slice".equalsIgnoreCase(attribute) ? "slice" : "hidden";
    }

    public final String toString() {
        return super.toString() + ": id=" + getId() + ", width=" + g() + ", height=" + k() + ", left=" + j() + ", top=" + h();
    }

    @Override // a4.j
    public final void y(int i2) throws DOMException {
        setAttribute("left", String.valueOf(i2));
    }

    @Override // a4.a
    public final String z() {
        return getAttribute("backgroundColor");
    }
}
