package W3;

import Z2.m;
import i3.f;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class d implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1821a = new d();

    private d() {
    }

    private final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale locale = Locale.US;
        f3.c.c(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        f3.c.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> c(X509Certificate x509Certificate, int i2) throws CertificateParsingException {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return m.f2185i;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && f3.c.a(list.get(0), Integer.valueOf(i2)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return m.f2185i;
        }
    }

    private final boolean d(String str) {
        int i2;
        int length = str.length();
        int length2 = str.length();
        if (!(length2 >= 0)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + length2 + " < 0").toString());
        }
        if (!(length2 <= str.length())) {
            StringBuilder sbC = C2.c.c("endIndex > string.length: ", length2, " > ");
            sbC.append(str.length());
            throw new IllegalArgumentException(sbC.toString().toString());
        }
        long j2 = 0;
        int i4 = 0;
        while (i4 < length2) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    i2 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i2 = 3;
                } else {
                    int i5 = i4 + 1;
                    char cCharAt2 = i5 < length2 ? str.charAt(i5) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i4 = i5;
                    } else {
                        j2 += 4;
                        i4 += 2;
                    }
                }
                j2 += i2;
            }
            i4++;
        }
        return length == ((int) j2);
    }

    public final List<String> a(X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listC = c(x509Certificate, 7);
        List<String> listC2 = c(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listC2.size() + listC.size());
        arrayList.addAll(listC);
        arrayList.addAll(listC2);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        boolean zA;
        int length;
        f3.c.d(str, "host");
        f3.c.d(x509Certificate, "certificate");
        if (M3.c.a(str)) {
            String strB = M3.a.b(str);
            List<String> listC = c(x509Certificate, 7);
            if (!listC.isEmpty()) {
                Iterator<T> it = listC.iterator();
                while (it.hasNext()) {
                    if (f3.c.a(strB, M3.a.b((String) it.next()))) {
                        return true;
                    }
                }
            }
        } else {
            String strB2 = b(str);
            List<String> listC2 = c(x509Certificate, 2);
            if (!listC2.isEmpty()) {
                for (String strH : listC2) {
                    d dVar = f1821a;
                    if ((strB2.length() == 0) || f.A(strB2, ".", false) || strB2.endsWith("..")) {
                        zA = false;
                    } else if (!(strH == null || strH.length() == 0) && !f.A(strH, ".", false) && !strH.endsWith("..")) {
                        String strH2 = !strB2.endsWith(".") ? f3.c.h(strB2, ".") : strB2;
                        if (!strH.endsWith(".")) {
                            strH = f3.c.h(strH, ".");
                        }
                        String strB3 = dVar.b(strH);
                        if (!f.g(strB3, "*")) {
                            zA = f3.c.a(strH2, strB3);
                        } else if (f.A(strB3, "*.", false) && f.r(strB3, '*', 1, false, 4) == -1 && strH2.length() >= strB3.length() && !f3.c.a("*.", strB3)) {
                            String strSubstring = strB3.substring(1);
                            f3.c.c(strSubstring, "this as java.lang.String).substring(startIndex)");
                            if (strH2.endsWith(strSubstring) && ((length = strH2.length() - strSubstring.length()) <= 0 || f.t(strH2, '.', length - 1, 4) == -1)) {
                                zA = true;
                            }
                        }
                    }
                    if (zA) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        f3.c.d(str, "host");
        f3.c.d(sSLSession, "session");
        if (!d(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return e(str, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
