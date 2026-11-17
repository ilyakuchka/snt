package i3;

/* loaded from: classes.dex */
class b {
    public static final boolean a(char c2, char c4, boolean z4) {
        if (c2 == c4) {
            return true;
        }
        if (!z4) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c4);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final boolean b(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }
}
