package B0;

import a4.e;
import a4.f;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/* loaded from: classes.dex */
public final class c {
    public static void a(e eVar, OutputStream outputStream) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"), 2048);
            b(bufferedWriter, eVar.getDocumentElement());
            bufferedWriter.flush();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private static void b(Writer writer, Element element) throws IOException {
        writer.write(60);
        writer.write(element.getTagName());
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Attr attr = (Attr) attributes.item(i2);
                StringBuilder sbD = D2.e.d(" ");
                sbD.append(attr.getName());
                writer.write(sbD.toString());
                writer.write("=\"" + attr.getValue() + "\"");
            }
        }
        f fVar = (f) element.getFirstChild();
        if (fVar == null) {
            writer.write("/>");
            return;
        }
        writer.write(62);
        do {
            b(writer, fVar);
            fVar = (f) fVar.getNextSibling();
        } while (fVar != null);
        writer.write("</");
        writer.write(element.getTagName());
        writer.write(62);
    }
}
