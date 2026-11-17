package y0;

import java.util.Vector;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* renamed from: y0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0423d implements NamedNodeMap {

    /* renamed from: a, reason: collision with root package name */
    private Vector<Node> f8153a = new Vector<>();

    @Override // org.w3c.dom.NamedNodeMap
    public final int getLength() {
        return this.f8153a.size();
    }

    @Override // org.w3c.dom.NamedNodeMap
    public final Node getNamedItem(String str) {
        for (int i2 = 0; i2 < this.f8153a.size(); i2++) {
            if (str.equals(this.f8153a.elementAt(i2).getNodeName())) {
                return this.f8153a.elementAt(i2);
            }
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public final Node getNamedItemNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public final Node item(int i2) {
        if (i2 < this.f8153a.size()) {
            return this.f8153a.elementAt(i2);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public final Node removeNamedItem(String str) throws DOMException {
        Node namedItem = getNamedItem(str);
        if (namedItem == null) {
            throw new DOMException((short) 8, "Not found");
        }
        this.f8153a.remove(namedItem);
        return namedItem;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public final Node removeNamedItemNS(String str, String str2) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public final Node setNamedItem(Node node) throws DOMException {
        Node namedItem = getNamedItem(node.getNodeName());
        if (namedItem != null) {
            this.f8153a.remove(namedItem);
        }
        this.f8153a.add(node);
        return namedItem;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public final Node setNamedItemNS(Node node) throws DOMException {
        return null;
    }
}
