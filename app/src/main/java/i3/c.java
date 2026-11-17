package i3;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f6338a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f6339b;

    /* renamed from: c, reason: collision with root package name */
    private static Charset f6340c;
    private static Charset d;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        f3.c.c(charsetForName, "forName(\"UTF-8\")");
        f6339b = charsetForName;
        f3.c.c(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        f3.c.c(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        f3.c.c(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        f3.c.c(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        f3.c.c(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }

    public static final Charset a() {
        Charset charset = d;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        f3.c.c(charsetForName, "forName(\"UTF-32BE\")");
        d = charsetForName;
        return charsetForName;
    }

    public static final Charset b() {
        Charset charset = f6340c;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        f3.c.c(charsetForName, "forName(\"UTF-32LE\")");
        f6340c = charsetForName;
        return charsetForName;
    }
}
