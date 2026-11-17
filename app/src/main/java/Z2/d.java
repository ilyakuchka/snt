package Z2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d extends f {
    public static List a(Object[] objArr) {
        List listAsList = Arrays.asList(objArr);
        f3.c.c(listAsList, "asList(this)");
        return listAsList;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i4, int i5) {
        f3.c.d(bArr, "<this>");
        f3.c.d(bArr2, "destination");
        System.arraycopy(bArr, i4, bArr2, i2, i5 - i4);
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int i2, int i4) {
        f3.c.d(bArr, "<this>");
        int length = bArr.length;
        if (i4 <= length) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i4);
            f3.c.c(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
            return bArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + length + ").");
    }

    public static char d(char[] cArr) {
        f3.c.d(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List e(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new c(objArr, false)) : g.g(objArr[0]) : m.f2185i;
    }

    public static List f(Object[] objArr) {
        return new ArrayList(new c(objArr, false));
    }
}
