package B0;

import a4.e;
import f0.C0303b;
import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.DOMException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private XMLReader f15a;

    /* renamed from: b, reason: collision with root package name */
    private a f16b;

    public b() throws C0303b {
        System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
        try {
            this.f15a = XMLReaderFactory.createXMLReader();
            a aVar = new a();
            this.f16b = aVar;
            this.f15a.setContentHandler(aVar);
        } catch (SAXException e2) {
            throw new C0303b(e2);
        }
    }

    public final e a(InputStream inputStream) throws SAXException, DOMException, IOException {
        this.f16b.b();
        this.f15a.parse(new InputSource(inputStream));
        A0.e eVar = (A0.e) this.f16b.a();
        eVar.A();
        eVar.n();
        return eVar;
    }
}
