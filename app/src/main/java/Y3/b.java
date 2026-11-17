package Y3;

import f3.c;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2140a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c2) {
        if ('0' <= c2 && c2 <= '9') {
            return c2 - '0';
        }
        char c4 = 'a';
        if (!('a' <= c2 && c2 <= 'f')) {
            c4 = 'A';
            if (!('A' <= c2 && c2 <= 'F')) {
                throw new IllegalArgumentException(c.h("Unexpected hex digit: ", Character.valueOf(c2)));
            }
        }
        return (c2 - c4) + 10;
    }

    public static final char[] b() {
        return f2140a;
    }
}
