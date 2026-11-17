package y0;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0420a extends AbstractC0424e implements Attr {

    /* renamed from: e, reason: collision with root package name */
    private String f8149e;

    /* renamed from: f, reason: collision with root package name */
    private String f8150f;

    protected C0420a(AbstractC0421b abstractC0421b, String str) {
        super(abstractC0421b);
        this.f8149e = str;
    }

    @Override // org.w3c.dom.Attr
    public final String getName() {
        return this.f8149e;
    }

    @Override // y0.AbstractC0424e, org.w3c.dom.Node
    public final Node getNextSibling() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final String getNodeName() {
        return this.f8149e;
    }

    @Override // org.w3c.dom.Node
    public final short getNodeType() {
        return (short) 2;
    }

    @Override // org.w3c.dom.Attr
    public final Element getOwnerElement() {
        return null;
    }

    @Override // y0.AbstractC0424e, org.w3c.dom.Node
    public final Node getParentNode() {
        return null;
    }

    @Override // y0.AbstractC0424e, org.w3c.dom.Node
    public final Node getPreviousSibling() {
        return null;
    }

    @Override // org.w3c.dom.Attr
    public final TypeInfo getSchemaTypeInfo() {
        return null;
    }

    @Override // org.w3c.dom.Attr
    public final boolean getSpecified() {
        return this.f8150f != null;
    }

    @Override // org.w3c.dom.Attr
    public final String getValue() {
        return this.f8150f;
    }

    @Override // org.w3c.dom.Attr
    public final boolean isId() {
        return false;
    }

    @Override // y0.AbstractC0424e, org.w3c.dom.Node
    public final void setNodeValue(String str) throws DOMException {
        this.f8150f = str;
    }

    @Override // org.w3c.dom.Attr
    public final void setValue(String str) throws DOMException {
        this.f8150f = str;
    }
}
