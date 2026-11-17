package g0;

import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

/* renamed from: g0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0307c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6247a;

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f6248b = {"*", "us-ascii", "iso-8859-1", "iso-8859-2", "iso-8859-3", "iso-8859-4", "iso-8859-5", "iso-8859-6", "iso-8859-7", "iso-8859-8", "iso-8859-9", "shift_JIS", "euc-jp", "euc-kr", "iso-2022-jp", "iso-2022-jp-2", "utf-8", "gbk", "gb18030", "gb2312", "big5", "iso-10646-ucs-2", "utf-16", "hz-gb-2312"};

    /* renamed from: c, reason: collision with root package name */
    private static final SparseArray<String> f6249c = new SparseArray<>();
    private static final q.g<String, Integer> d = new q.g<>();

    static {
        int[] iArr = {0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 18, 38, 39, 40, 106, 113, 114, 2025, 2026, 1000, 1015, 2085};
        f6247a = iArr;
        int length = iArr.length - 1;
        for (int i2 = 0; i2 <= length; i2++) {
            SparseArray<String> sparseArray = f6249c;
            int[] iArr2 = f6247a;
            int i4 = iArr2[i2];
            String[] strArr = f6248b;
            sparseArray.put(i4, strArr[i2]);
            d.put(strArr[i2], Integer.valueOf(iArr2[i2]));
        }
    }

    public static int a(String str) throws UnsupportedEncodingException {
        Integer orDefault = d.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault.intValue();
        }
        throw new UnsupportedEncodingException();
    }

    public static String b(int i2) throws UnsupportedEncodingException {
        String str = f6249c.get(i2);
        if (str != null) {
            return str;
        }
        throw new UnsupportedEncodingException();
    }
}
