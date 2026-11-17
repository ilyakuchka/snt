package y0;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* renamed from: y0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0421b extends AbstractC0424e implements Document {
    public AbstractC0421b() {
        super(null);
    }

    @Override // org.w3c.dom.Document
    public final Node adoptNode(Node node) throws DOMException {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Document
    public final Attr createAttribute(String str) throws DOMException {
        return new C0420a(this, str);
    }

    @Override // org.w3c.dom.Document
    public final Attr createAttributeNS(String str, String str2) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final CDATASection createCDATASection(String str) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final Comment createComment(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final DocumentFragment createDocumentFragment() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final Element createElementNS(String str, String str2) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final EntityReference createEntityReference(String str) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final ProcessingInstruction createProcessingInstruction(String str, String str2) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final Text createTextNode(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final DocumentType getDoctype() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final String getDocumentURI() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final DOMConfiguration getDomConfig() {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Document
    public final Element getElementById(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final NodeList getElementsByTagName(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final NodeList getElementsByTagNameNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final DOMImplementation getImplementation() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final String getInputEncoding() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public final String getNodeName() {
        return "#document";
    }

    @Override // org.w3c.dom.Node
    public final short getNodeType() {
        return (short) 9;
    }

    @Override // org.w3c.dom.Document
    public final boolean getStrictErrorChecking() {
        return true;
    }

    @Override // org.w3c.dom.Document
    public final String getXmlEncoding() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final boolean getXmlStandalone() {
        return false;
    }

    @Override // org.w3c.dom.Document
    public final String getXmlVersion() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final Node importNode(Node node, boolean z4) throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Document
    public final void normalizeDocument() {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Document
    public final Node renameNode(Node node, String str, String str2) throws DOMException {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Document
    public final void setDocumentURI(String str) {
    }

    @Override // org.w3c.dom.Document
    public final void setStrictErrorChecking(boolean z4) {
    }

    @Override // org.w3c.dom.Document
    public final void setXmlStandalone(boolean z4) throws DOMException {
    }

    @Override // org.w3c.dom.Document
    public final void setXmlVersion(String str) throws DOMException {
    }
}
