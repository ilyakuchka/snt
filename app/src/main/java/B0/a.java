package B0;

import A0.e;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import y0.C0422c;

/* loaded from: classes.dex */
public final class a extends DefaultHandler {

    /* renamed from: a, reason: collision with root package name */
    private e f13a;

    /* renamed from: b, reason: collision with root package name */
    private Node f14b;

    public final a4.e a() {
        return this.f13a;
    }

    public final void b() {
        e eVar = new e();
        this.f13a = eVar;
        this.f14b = eVar;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i2, int i4) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        this.f14b = this.f14b.getParentNode();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) throws DOMException {
        Element elementCreateElement = this.f13a.createElement(str2);
        if (attributes != null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                ((C0422c) elementCreateElement).setAttribute(attributes.getLocalName(i2), attributes.getValue(i2));
            }
        }
        this.f14b.appendChild(elementCreateElement);
        this.f14b = elementCreateElement;
    }
}
