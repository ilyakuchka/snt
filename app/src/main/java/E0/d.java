package E0;

import D2.e;
import android.content.Context;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private DataInputStream f101a;

    /* renamed from: b, reason: collision with root package name */
    private Document f102b;

    /* renamed from: c, reason: collision with root package name */
    private String f103c = "UNKNOWN";
    private byte d = -1;

    /* renamed from: e, reason: collision with root package name */
    private String f104e;

    /* renamed from: f, reason: collision with root package name */
    private String f105f;
    private b g;

    /* renamed from: h, reason: collision with root package name */
    Context f106h;

    public d(Context context) {
        this.f106h = context;
    }

    private void b() throws ParserConfigurationException, DOMException, IOException {
        byte b2 = this.f101a.readByte();
        String strD = this.g.d((byte) (b2 & 63));
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document documentCreateDocument = documentBuilderNewDocumentBuilder.getDOMImplementation().createDocument("", strD, documentBuilderNewDocumentBuilder.getDOMImplementation().createDocumentType(strD, this.f103c, a.a().d(this.f103c)));
            this.f102b = documentCreateDocument;
            boolean z4 = true;
            if ((b2 & (-128)) == -128) {
                d(documentCreateDocument.getDocumentElement());
            }
            if ((b2 & 64) != 64) {
                z4 = false;
            }
            if (z4) {
                e(this.f102b.getDocumentElement());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d(Element element) throws DOMException, IOException, NumberFormatException {
        byte b2 = this.f101a.readByte();
        String str = "";
        while (true) {
            if (b2 == 1) {
                return;
            }
            if (b2 == 3) {
                byte b4 = this.f101a.readByte();
                byte[] bArr = new byte[1024];
                int i2 = 0;
                while (b4 != 0) {
                    bArr[i2] = b4;
                    b4 = this.f101a.readByte();
                    i2++;
                }
                String attribute = element.getAttribute(str);
                if (attribute.equals("null")) {
                    attribute = "";
                }
                StringBuffer stringBuffer = new StringBuffer(attribute);
                stringBuffer.append(new String(bArr, 0, i2, this.f104e));
                element.setAttribute(str, stringBuffer.toString());
            } else {
                if (b2 == 2) {
                    String attribute2 = element.getAttribute(str);
                    if (attribute2.equals("null")) {
                        attribute2 = "";
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(attribute2);
                    byte b5 = this.f101a.readByte();
                    while ((b5 & (-128)) == 128) {
                        stringBuffer2.append(Integer.toString((byte) (b5 & 127), 2));
                        b5 = this.f101a.readByte();
                    }
                    String string = Integer.toString(b5, 2);
                    while (string.length() < 7) {
                        string = e.c("0", string);
                    }
                    stringBuffer2.append(string);
                    element.setAttribute(str, "&#" + Integer.parseInt(stringBuffer2.toString(), 2) + ";");
                } else {
                    if (b2 == -125) {
                        byte b6 = this.f101a.readByte();
                        String attribute3 = element.getAttribute(str);
                        int iIndexOf = this.f105f.indexOf(new String(new char[]{0}), b6);
                        StringBuilder sbD = e.d(attribute3);
                        sbD.append(this.f105f.substring(b6, iIndexOf));
                        element.setAttribute(str, sbD.toString());
                    } else {
                        if (b2 >= 0) {
                            String[] strArrA = this.g.a(b2);
                            str = strArrA[0];
                            String strTrim = strArrA[1] != null ? strArrA[1].trim() : "";
                            Attr attrCreateAttribute = this.f102b.createAttribute(str);
                            attrCreateAttribute.setValue(strTrim);
                            element.setAttributeNode(attrCreateAttribute);
                        } else {
                            if (b2 < 0) {
                                StringBuilder sbD2 = e.d(element.getAttribute(str));
                                sbD2.append(this.g.b(b2));
                                element.setAttribute(str, sbD2.toString());
                            }
                        }
                    }
                }
            }
            b2 = this.f101a.readByte();
        }
    }

    private void e(Element element) throws DOMException, IOException, NumberFormatException {
        byte b2 = this.f101a.readByte();
        while (true) {
            if (b2 == 1) {
                return;
            }
            byte b4 = (byte) (b2 & 63);
            if (b2 == 3) {
                byte b5 = this.f101a.readByte();
                byte[] bArr = new byte[1024];
                int i2 = 0;
                while (b5 != 0) {
                    bArr[i2] = b5;
                    b5 = this.f101a.readByte();
                    i2++;
                }
                element.appendChild(this.f102b.createTextNode(new String(bArr, 0, i2, this.f104e)));
            } else if (b4 == 2) {
                StringBuffer stringBuffer = new StringBuffer();
                byte b6 = this.f101a.readByte();
                while ((b6 & (-128)) == 128) {
                    stringBuffer.append(Integer.toString((byte) (b6 & 127), 2));
                    b6 = this.f101a.readByte();
                }
                String string = Integer.toString(b6, 2);
                while (string.length() < 7) {
                    string = e.c("0", string);
                }
                stringBuffer.append(string);
                element.appendChild(this.f102b.createTextNode(Integer.toString(Integer.parseInt(stringBuffer.toString(), 2))));
            } else if (b2 == -61) {
                int i4 = this.f101a.readByte();
                byte[] bArr2 = new byte[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    bArr2[i5] = this.f101a.readByte();
                }
                byte b7 = this.f101a.readByte();
                while (b7 != 1) {
                    b7 = this.f101a.readByte();
                }
                new String(bArr2, this.f104e);
                element.appendChild(this.f102b.createTextNode(""));
            } else if (b2 == -125) {
                byte b8 = this.f101a.readByte();
                element.appendChild(this.f102b.createTextNode(this.f105f.substring(b8, this.f105f.indexOf(new String(new char[]{0}), b8))));
            } else if (b4 == 0) {
                b.g(this.f101a.readByte());
            } else {
                Element elementCreateElement = this.f102b.createElement(this.g.d(b4));
                element.appendChild(elementCreateElement);
                if ((b2 & (-128)) == -128) {
                    d(elementCreateElement);
                }
                if ((b2 & 64) == 64) {
                    e(elementCreateElement);
                    b2 = this.f101a.readByte();
                }
            }
            b2 = this.f101a.readByte();
        }
    }

    public final Document a(InputStream inputStream) {
        this.f101a = new DataInputStream(inputStream);
        try {
            this.f102b = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!c()) {
            return null;
        }
        b();
        return this.f102b;
    }

    public final boolean c() throws IOException {
        this.f101a.readByte();
        byte b2 = this.f101a.readByte();
        if (b2 == 0) {
            this.d = this.f101a.readByte();
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while ((b2 & 128) == 128) {
                String binaryString = Integer.toBinaryString(b2 & 127);
                if (binaryString.length() < 7) {
                    int length = 7 - binaryString.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        stringBuffer.append('0');
                    }
                }
                stringBuffer.append(binaryString);
                b2 = this.f101a.readByte();
            }
            String binaryString2 = Integer.toBinaryString(b2 & 127);
            if (binaryString2.length() < 7) {
                int length2 = 7 - binaryString2.length();
                for (int i4 = 0; i4 < length2; i4++) {
                    stringBuffer.append('0');
                }
            }
            stringBuffer.append(binaryString2);
            this.f103c = a.a().b(Integer.valueOf(stringBuffer.toString(), 2).intValue());
        }
        this.f104e = c.b(this.f106h).a(this.f101a.readByte());
        int i5 = this.f101a.readByte();
        if (i5 < 0) {
            return false;
        }
        byte[] bArr = new byte[i5];
        if (this.f101a.read(bArr, 0, i5) < i5) {
            return false;
        }
        try {
            String str = new String(bArr, this.f104e);
            this.f105f = str;
            if (this.d != -1) {
                int iIndexOf = str.indexOf(new String(new char[]{0}), this.d);
                if (iIndexOf == -1) {
                    this.f103c = this.f105f.substring(this.d);
                } else {
                    this.f103c = this.f105f.substring(this.d, iIndexOf);
                }
            }
            this.g = new b(a.a().c(this.f103c), this.f106h);
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }
}
