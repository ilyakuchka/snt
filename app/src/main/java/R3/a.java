package R3;

import L3.s;
import X3.f;
import f3.c;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final f f1316a;

    /* renamed from: b, reason: collision with root package name */
    private long f1317b = 262144;

    public a(f fVar) {
        this.f1316a = fVar;
    }

    public final s a() throws IOException {
        s.a aVar = new s.a();
        while (true) {
            String strT = this.f1316a.t(this.f1317b);
            this.f1317b -= strT.length();
            if (strT.length() == 0) {
                return aVar.c();
            }
            int iR = i3.f.r(strT, ':', 1, false, 4);
            if (iR != -1) {
                String strSubstring = strT.substring(0, iR);
                c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = strT.substring(iR + 1);
                c.c(strSubstring2, "this as java.lang.String).substring(startIndex)");
                aVar.b(strSubstring, strSubstring2);
            } else if (strT.charAt(0) == ':') {
                String strSubstring3 = strT.substring(1);
                c.c(strSubstring3, "this as java.lang.String).substring(startIndex)");
                aVar.b("", strSubstring3);
            } else {
                aVar.b("", strT);
            }
        }
    }

    public final String b() throws IOException {
        String strT = this.f1316a.t(this.f1317b);
        this.f1317b -= strT.length();
        return strT;
    }
}
