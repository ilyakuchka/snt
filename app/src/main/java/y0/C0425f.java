package y0;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: y0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0425f implements NodeList {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Node> f8157a;

    /* renamed from: b, reason: collision with root package name */
    private Node f8158b;

    /* renamed from: c, reason: collision with root package name */
    private String f8159c;
    private boolean d;

    public C0425f(Node node, String str, boolean z4) {
        this.f8158b = node;
        this.f8159c = str;
        this.d = z4;
    }

    private void a(Node node) {
        if (node == this.f8158b) {
            this.f8157a = new ArrayList<>();
        } else if (this.f8159c == null || node.getNodeName().equals(this.f8159c)) {
            this.f8157a.add(node);
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (this.d) {
                a(firstChild);
            } else if (this.f8159c == null || firstChild.getNodeName().equals(this.f8159c)) {
                this.f8157a.add(firstChild);
            }
        }
    }

    @Override // org.w3c.dom.NodeList
    public final int getLength() {
        a(this.f8158b);
        return this.f8157a.size();
    }

    @Override // org.w3c.dom.NodeList
    public final Node item(int i2) {
        a(this.f8158b);
        try {
            return this.f8157a.get(i2);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }
}
