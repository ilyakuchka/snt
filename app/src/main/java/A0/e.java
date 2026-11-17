package A0;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import y0.AbstractC0421b;

/* loaded from: classes.dex */
public final class e extends AbstractC0421b implements a4.e {

    /* renamed from: e, reason: collision with root package name */
    a4.c f1e;

    final class a extends b {
        a(a4.f fVar) {
            super(fVar);
        }

        @Override // A0.d
        final a4.d c() {
            return null;
        }
    }

    public final a4.f A() throws DOMException {
        a4.f documentElement = getDocumentElement();
        Node nextSibling = C().getNextSibling();
        if (nextSibling == null || !(nextSibling instanceof a4.f)) {
            nextSibling = createElement("body");
            documentElement.appendChild(nextSibling);
        }
        a4.f fVar = (a4.f) nextSibling;
        this.f1e = new a(fVar);
        return fVar;
    }

    @Override // org.w3c.dom.Document
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final a4.f getDocumentElement() throws DOMException {
        Node firstChild = getFirstChild();
        if (firstChild == null || !(firstChild instanceof a4.f)) {
            firstChild = createElement("smil");
            appendChild(firstChild);
        }
        return (a4.f) firstChild;
    }

    public final a4.f C() throws DOMException {
        a4.f documentElement = getDocumentElement();
        Node firstChild = documentElement.getFirstChild();
        if (firstChild == null || !(firstChild instanceof a4.f)) {
            firstChild = createElement("head");
            documentElement.appendChild(firstChild);
        }
        return (a4.f) firstChild;
    }

    @Override // a4.d
    public final o a() {
        return ((d) this.f1e).a();
    }

    @Override // org.w3c.dom.Document
    public final Element createElement(String str) throws DOMException {
        String lowerCase = str.toLowerCase();
        return (lowerCase.equals("text") || lowerCase.equals("img") || lowerCase.equals("video")) ? new l(this, lowerCase) : lowerCase.equals("audio") ? new h(this, lowerCase) : lowerCase.equals("layout") ? new g(this, lowerCase) : lowerCase.equals("root-layout") ? new m(this, lowerCase) : lowerCase.equals("region") ? new k(this, lowerCase) : lowerCase.equals("ref") ? new j(this, lowerCase) : lowerCase.equals("par") ? new i(this, lowerCase) : new f(this, lowerCase);
    }

    @Override // a4.d
    public final o f() {
        return ((d) this.f1e).f();
    }

    @Override // a4.d
    public final float l() {
        return ((b) this.f1e).l();
    }

    @Override // a4.e
    public final a4.g n() throws DOMException {
        a4.f fVarC = C();
        Node firstChild = fVarC.getFirstChild();
        while (firstChild != null && !(firstChild instanceof a4.g)) {
            firstChild = firstChild.getNextSibling();
        }
        if (firstChild == null) {
            firstChild = new g(this, "layout");
            fVarC.appendChild(firstChild);
        }
        return (a4.g) firstChild;
    }

    @Override // a4.d
    public final void p(float f4) throws DOMException {
        ((d) this.f1e).p(f4);
    }

    @Override // a4.d
    public final short x() {
        return ((d) this.f1e).x();
    }
}
