package Q3;

import L3.x;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes.dex */
public final class i {
    public static final a d = new a();

    /* renamed from: a, reason: collision with root package name */
    public final x f1221a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1222b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1223c;

    public static final class a {
        public final i a(String str) throws NumberFormatException, IOException {
            String strSubstring;
            x xVar = x.f545k;
            f3.c.d(str, "statusLine");
            int i2 = 9;
            if (i3.f.A(str, "HTTP/1.", false)) {
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException(f3.c.h("Unexpected status line: ", str));
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt != 0) {
                    if (iCharAt != 1) {
                        throw new ProtocolException(f3.c.h("Unexpected status line: ", str));
                    }
                    xVar = x.f546l;
                }
            } else {
                if (!i3.f.A(str, "ICY ", false)) {
                    throw new ProtocolException(f3.c.h("Unexpected status line: ", str));
                }
                i2 = 4;
            }
            int i4 = i2 + 3;
            if (str.length() < i4) {
                throw new ProtocolException(f3.c.h("Unexpected status line: ", str));
            }
            try {
                String strSubstring2 = str.substring(i2, i4);
                f3.c.c(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i5 = Integer.parseInt(strSubstring2);
                if (str.length() <= i4) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i4) != ' ') {
                        throw new ProtocolException(f3.c.h("Unexpected status line: ", str));
                    }
                    strSubstring = str.substring(i2 + 4);
                    f3.c.c(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new i(xVar, i5, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(f3.c.h("Unexpected status line: ", str));
            }
        }
    }

    public i(x xVar, int i2, String str) {
        this.f1221a = xVar;
        this.f1222b = i2;
        this.f1223c = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f1221a == x.f545k) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f1222b);
        sb.append(' ');
        sb.append(this.f1223c);
        String string = sb.toString();
        f3.c.c(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
