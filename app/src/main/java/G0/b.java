package G0;

import j0.C0337b;
import java.util.ArrayList;
import k0.C0341b;

/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f136a = C0337b.b();

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<String> f137b = C0337b.a();

    /* renamed from: c, reason: collision with root package name */
    private static final ArrayList<String> f138c = C0337b.c();

    public final void a(String str) throws C0341b {
        if (str == null) {
            throw new C0341b("Null content type to be check");
        }
        if (!f137b.contains(str)) {
            throw new k0.e(D2.e.c("Unsupported audio content type : ", str));
        }
    }

    public final void b(String str) throws C0341b {
        if (str == null) {
            throw new C0341b("Null content type to be check");
        }
        if (!f136a.contains(str)) {
            throw new k0.e(D2.e.c("Unsupported image content type : ", str));
        }
    }

    public final void c(String str) throws C0341b {
        if (str == null) {
            throw new C0341b("Null content type to be check");
        }
        if (!f138c.contains(str)) {
            throw new k0.e(D2.e.c("Unsupported video content type : ", str));
        }
    }
}
