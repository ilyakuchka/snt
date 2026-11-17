package y0;

import java.util.NoSuchElementException;
import java.util.Vector;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import z0.C0428a;

/* renamed from: y0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0424e implements Node, Z3.b {

    /* renamed from: a, reason: collision with root package name */
    private Node f8154a;

    /* renamed from: c, reason: collision with root package name */
    AbstractC0421b f8156c;

    /* renamed from: b, reason: collision with root package name */
    private final Vector<Node> f8155b = new Vector<>();
    private final C0428a d = new C0428a(this);

    protected AbstractC0424e(AbstractC0421b abstractC0421b) {
        this.f8156c = abstractC0421b;
    }

    @Override // org.w3c.dom.Node
    public final Node appendChild(Node node) throws DOMException {
        ((AbstractC0424e) node).f8154a = this;
        this.f8155b.remove(node);
        this.f8155b.add(node);
        return node;
    }

    @Override // org.w3c.dom.Node
    public final Node cloneNode(boolean z4) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final short compareDocumentPosition(Node node) throws DOMException {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final String getBaseURI() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final NodeList getChildNodes() {
        return new C0425f(this, null, false);
    }

    @Override // org.w3c.dom.Node
    public final Object getFeature(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final Node getFirstChild() {
        try {
            return this.f8155b.firstElement();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @Override // org.w3c.dom.Node
    public final Node getLastChild() {
        try {
            return this.f8155b.lastElement();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @Override // org.w3c.dom.Node
    public final String getLocalName() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final String getNamespaceURI() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getNextSibling() {
        Node node = this.f8154a;
        if (node == null || this == node.getLastChild()) {
            return null;
        }
        Vector<Node> vector = ((AbstractC0424e) this.f8154a).f8155b;
        return vector.elementAt(vector.indexOf(this) + 1);
    }

    @Override // org.w3c.dom.Node
    public final String getNodeValue() throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final Document getOwnerDocument() {
        return this.f8156c;
    }

    @Override // org.w3c.dom.Node
    public Node getParentNode() {
        return this.f8154a;
    }

    @Override // org.w3c.dom.Node
    public final String getPrefix() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getPreviousSibling() {
        Node node = this.f8154a;
        if (node == null || this == node.getFirstChild()) {
            return null;
        }
        return ((AbstractC0424e) this.f8154a).f8155b.elementAt(r0.indexOf(this) - 1);
    }

    @Override // org.w3c.dom.Node
    public final String getTextContent() throws DOMException {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public final Object getUserData(String str) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public final boolean hasChildNodes() {
        return !this.f8155b.isEmpty();
    }

    @Override // org.w3c.dom.Node
    public final Node insertBefore(Node node, Node node2) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final boolean isDefaultNamespace(String str) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public final boolean isEqualNode(Node node) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public final boolean isSameNode(Node node) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public final boolean isSupported(String str, String str2) {
        return false;
    }

    @Override // org.w3c.dom.Node
    public final String lookupNamespaceURI(String str) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final String lookupPrefix(String str) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final void normalize() {
    }

    @Override // org.w3c.dom.Node
    public final Node removeChild(Node node) throws DOMException {
        if (!this.f8155b.contains(node)) {
            throw new DOMException((short) 8, "Child does not exist");
        }
        this.f8155b.remove(node);
        ((AbstractC0424e) node).f8154a = null;
        return null;
    }

    @Override // org.w3c.dom.Node
    public final Node replaceChild(Node node, Node node2) throws DOMException {
        if (!this.f8155b.contains(node2)) {
            throw new DOMException((short) 8, "Old child does not exist");
        }
        try {
            this.f8155b.remove(node);
        } catch (DOMException unused) {
        }
        Vector<Node> vector = this.f8155b;
        vector.setElementAt(node, vector.indexOf(node2));
        ((AbstractC0424e) node).f8154a = this;
        ((AbstractC0424e) node2).f8154a = null;
        return node2;
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String str) throws DOMException {
    }

    @Override // org.w3c.dom.Node
    public final void setPrefix(String str) throws DOMException {
    }

    @Override // org.w3c.dom.Node
    public final void setTextContent(String str) throws DOMException {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public final Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
        throw new DOMException((short) 9, null);
    }

    @Override // Z3.b
    public final void v(String str, Z3.a aVar) {
        this.d.v(str, aVar);
    }
}
