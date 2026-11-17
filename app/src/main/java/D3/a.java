package D3;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;
import w3.C0409b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Locale f86a = Locale.getDefault();

    /* renamed from: b, reason: collision with root package name */
    private static char f87b = new DecimalFormatSymbols(f86a).getZeroDigit();

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(int i2, int i4) {
        Locale locale = Locale.getDefault();
        Objects.requireNonNull(locale, "locale == null");
        if (!locale.equals(f86a)) {
            f87b = new DecimalFormatSymbols(locale).getZeroDigit();
            f86a = locale;
        }
        char c2 = f87b;
        StringBuilder sb = (StringBuilder) ((C0409b.f) C0409b.c()).a();
        if (i4 < 0) {
            i4 = -i4;
            i2--;
            sb.append('-');
        }
        if (i4 >= 10000) {
            String string = Integer.toString(i4);
            for (int length = string.length(); length < i2; length++) {
                sb.append('0');
            }
            sb.append(string);
        } else {
            for (int i5 = i4 >= 1000 ? 4 : i4 >= 100 ? 3 : i4 >= 10 ? 2 : 1; i5 < i2; i5++) {
                sb.append('0');
            }
            sb.append(i4);
        }
        String string2 = sb.toString();
        ((C0409b.f) C0409b.c()).d(sb);
        if (c2 == '0') {
            return string2;
        }
        int length2 = string2.length();
        int i6 = c2 - '0';
        StringBuilder sb2 = (StringBuilder) ((C0409b.f) C0409b.c()).a();
        for (int i7 = 0; i7 < length2; i7++) {
            char cCharAt = string2.charAt(i7);
            if (cCharAt >= '0' && cCharAt <= '9') {
                cCharAt = (char) (cCharAt + i6);
            }
            sb2.append(cCharAt);
        }
        String string3 = sb2.toString();
        ((C0409b.f) C0409b.c()).d(sb2);
        return string3;
    }
}
