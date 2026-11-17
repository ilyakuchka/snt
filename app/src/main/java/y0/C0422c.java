package y0;

import java.util.Objects;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

/* renamed from: y0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0422c extends AbstractC0424e implements Element {

    /* renamed from: e, reason: collision with root package name */
    private String f8151e;

    /* renamed from: f, reason: collision with root package name */
    private C0423d f8152f;

    protected C0422c(AbstractC0421b abstractC0421b, String str) {
        super(abstractC0421b);
        this.f8152f = new C0423d();
        this.f8151e = str;
    }

    @Override // org.w3c.dom.Element
    public final String getAttribute(String str) {
        Attr attributeNode = getAttributeNode(str);
        return attributeNode != null ? attributeNode.getValue() : "";
    }

    @Override // org.w3c.dom.Element
    public final String getAttributeNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Element
    public final Attr getAttributeNode(String str) {
        return (Attr) this.f8152f.getNamedItem(str);
    }

    @Override // org.w3c.dom.Element
    public final Attr getAttributeNodeNS(String str, String str2) {
        return null;
    }

    @Override // y0.AbstractC0424e, org.w3c.dom.Node
    public final NamedNodeMap getAttributes() {
        return this.f8152f;
    }

    @Override // org.w3c.dom.Element
    public final NodeList getElementsByTagName(String str) {
        return new C0425f(this, str, true);
    }

    @Override // org.w3c.dom.Element
    public final NodeList getElementsByTagNameNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final String getNodeName() {
        return this.f8151e;
    }

    @Override // org.w3c.dom.Node
    public final short getNodeType() {
        return (short) 1;
    }

    @Override // org.w3c.dom.Element
    public final TypeInfo getSchemaTypeInfo() {
        return null;
    }

    @Override // org.w3c.dom.Element
    public final String getTagName() {
        return this.f8151e;
    }

    @Override // org.w3c.dom.Element
    public final boolean hasAttribute(String str) {
        return getAttributeNode(str) != null;
    }

    @Override // org.w3c.dom.Element
    public final boolean hasAttributeNS(String str, String str2) {
        return false;
    }

    @Override // y0.AbstractC0424e, org.w3c.dom.Node
    public final boolean hasAttributes() {
        return this.f8152f.getLength() > 0;
    }

    @Override // org.w3c.dom.Element
    public final void removeAttribute(String str) throws DOMException {
    }

    @Override // org.w3c.dom.Element
    public final void removeAttributeNS(String str, String str2) throws DOMException {
    }

    @Override // org.w3c.dom.Element
    public final Attr removeAttributeNode(Attr attr) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Element
    public final void setAttribute(String str, String str2) throws DOMException {
        Attr attributeNode = getAttributeNode(str);
        if (attributeNode == null) {
            AbstractC0421b abstractC0421b = this.f8156c;
            Objects.requireNonNull(abstractC0421b);
            attributeNode = new C0420a(abstractC0421b, str);
        }
        attributeNode.setNodeValue(str2);
        this.f8152f.setNamedItem(attributeNode);
    }

    @Override // org.w3c.dom.Element
    public final void setAttributeNS(String str, String str2, String str3) throws DOMException {
    }

    @Override // org.w3c.dom.Element
    public final Attr setAttributeNode(Attr attr) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Element
    public final Attr setAttributeNodeNS(Attr attr) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Element
    public final void setIdAttribute(String str, boolean z4) throws DOMException {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Element
    public final void setIdAttributeNS(String str, String str2, boolean z4) throws DOMException {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Element
    public final void setIdAttributeNode(Attr attr, boolean z4) throws DOMException {
        throw new DOMException((short) 9, null);
    }
}
