package E0;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public final class b {
    private static Properties d;

    /* renamed from: e, reason: collision with root package name */
    private static byte f94e;

    /* renamed from: a, reason: collision with root package name */
    private Document f95a;

    /* renamed from: b, reason: collision with root package name */
    private Hashtable[][] f96b;

    /* renamed from: c, reason: collision with root package name */
    Context f97c;

    /* JADX WARN: Removed duplicated region for block: B:50:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(String str, Context context) throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpen = null;
        try {
            try {
                this.f97c = context;
                Properties properties = new Properties();
                InputStream inputStreamOpen2 = context.getAssets().open("jwap_port/tokenRepositoryMappings.properties");
                try {
                    properties.load(inputStreamOpen2);
                    inputStreamOpen = context.getAssets().open(properties.getProperty(str));
                    this.f95a = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStreamOpen);
                    f();
                    e();
                    f94e = (byte) 0;
                    if (inputStreamOpen2 != null) {
                        try {
                            inputStreamOpen2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = inputStreamOpen;
                    inputStreamOpen = inputStreamOpen2;
                    try {
                        e.printStackTrace();
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            throw th;
                        }
                        try {
                            inputStream.close();
                            throw th;
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpen;
                    inputStreamOpen = inputStreamOpen2;
                    if (inputStreamOpen != null) {
                    }
                    if (inputStream != null) {
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                return;
            }
        } catch (Exception e9) {
            e = e9;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        if (inputStreamOpen != null) {
            inputStreamOpen.close();
        }
    }

    private String c(Iterator it, byte b2) {
        byte bByteValue;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            try {
                bByteValue = Integer.valueOf(entry.getValue().toString(), 16).byteValue();
            } catch (Exception unused) {
                System.out.println("token not found!!!, returning literal");
                bByteValue = 4;
            }
            if (bByteValue == b2) {
                return entry.getKey().toString();
            }
        }
        return null;
    }

    private void e() {
        Element element;
        int i2 = 0;
        this.f96b = (Hashtable[][]) Array.newInstance((Class<?>) Hashtable.class, this.f95a.getElementsByTagName("codepage").getLength(), 5);
        int i4 = 0;
        while (i4 < this.f96b.length) {
            NodeList elementsByTagName = this.f95a.getElementsByTagName("codepage");
            int i5 = i2;
            while (true) {
                if (i5 >= elementsByTagName.getLength()) {
                    element = null;
                    break;
                }
                element = (Element) elementsByTagName.item(i5);
                if (Integer.parseInt(element.getAttribute("number").trim()) == i4) {
                    break;
                } else {
                    i5++;
                }
            }
            Hashtable hashtable = new Hashtable();
            NodeList elementsByTagName2 = element.getElementsByTagName("tag");
            for (int i6 = i2; i6 < elementsByTagName2.getLength(); i6++) {
                Element element2 = (Element) elementsByTagName2.item(i6);
                hashtable.put(element2.getAttribute("name").toLowerCase(), element2.getAttribute("token-value"));
            }
            this.f96b[i4][i2] = hashtable;
            Hashtable hashtable2 = new Hashtable();
            Hashtable hashtable3 = new Hashtable();
            NodeList elementsByTagName3 = element.getElementsByTagName("attribute-start");
            for (int i7 = i2; i7 < elementsByTagName3.getLength(); i7++) {
                Element element3 = (Element) elementsByTagName3.item(i7);
                String attribute = element3.getAttribute("name");
                String attribute2 = element3.getAttribute("prefix");
                hashtable2.put((attribute + attribute2).toLowerCase(), element3.getAttribute("token-value"));
                if (hashtable3.containsKey(attribute)) {
                    ((Vector) hashtable3.get(attribute)).addElement(attribute2);
                } else {
                    Vector vector = new Vector();
                    vector.addElement(attribute2);
                    hashtable3.put(attribute, vector);
                }
            }
            Hashtable[][] hashtableArr = this.f96b;
            hashtableArr[i4][1] = hashtable2;
            hashtableArr[i4][2] = hashtable3;
            Hashtable hashtable4 = new Hashtable();
            NodeList elementsByTagName4 = this.f95a.getElementsByTagName("attribute-start");
            int i8 = 0;
            while (true) {
                byte bByteValue = 4;
                if (i8 >= elementsByTagName4.getLength()) {
                    break;
                }
                Element element4 = (Element) elementsByTagName4.item(i8);
                try {
                    bByteValue = Integer.valueOf(element4.getAttribute("token-value"), 16).byteValue();
                } catch (Exception unused) {
                    System.out.println("token not found!!!, returning literal");
                }
                hashtable4.put(String.valueOf((int) bByteValue).toLowerCase(), new String[]{element4.getAttribute("name"), element4.getAttribute("prefix")});
                i8++;
            }
            this.f96b[i4][4] = hashtable4;
            Hashtable hashtable5 = new Hashtable();
            NodeList elementsByTagName5 = element.getElementsByTagName("attribute-value");
            for (int i9 = 0; i9 < elementsByTagName5.getLength(); i9++) {
                Element element5 = (Element) elementsByTagName5.item(i9);
                hashtable5.put(element5.getAttribute("name").toLowerCase(), element5.getAttribute("token-value"));
            }
            this.f96b[i4][3] = hashtable5;
            i4++;
            i2 = 0;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0036 -> B:30:0x0039). Please report as a decompilation issue!!! */
    private void f() throws IOException {
        d = new Properties();
        InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    inputStreamOpen = this.f97c.getAssets().open("jwap_port/urnCodepageMappings.properties");
                    d.load(inputStreamOpen);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void g(byte b2) {
        f94e = b2;
    }

    public final String[] a(byte b2) {
        return (String[]) this.f96b[f94e][4].get(String.valueOf((int) b2));
    }

    public final String b(byte b2) {
        return c(this.f96b[f94e][3].entrySet().iterator(), b2);
    }

    public final String d(byte b2) {
        return c(this.f96b[f94e][0].entrySet().iterator(), b2);
    }
}
