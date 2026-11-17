package i3;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    private final Pattern f6350i;

    public e(String str) {
        Pattern patternCompile = Pattern.compile(str);
        f3.c.c(patternCompile, "compile(pattern)");
        this.f6350i = patternCompile;
    }

    public final boolean a(CharSequence charSequence) {
        f3.c.d(charSequence, "input");
        return this.f6350i.matcher(charSequence).matches();
    }

    public final String b(CharSequence charSequence) {
        String strReplaceAll = this.f6350i.matcher(charSequence).replaceAll("");
        f3.c.c(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    public final String toString() {
        String string = this.f6350i.toString();
        f3.c.c(string, "nativePattern.toString()");
        return string;
    }
}
