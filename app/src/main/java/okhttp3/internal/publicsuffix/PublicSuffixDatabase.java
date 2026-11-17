package okhttp3.internal.publicsuffix;

import M3.c;
import S2.d;
import T3.h;
import X3.f;
import X3.k;
import X3.n;
import Z2.g;
import Z2.j;
import Z2.m;
import h3.C0332a;
import h3.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    public static final a f7569e = new a();

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f7570f = {42};
    private static final List<String> g = g.g("*");

    /* renamed from: h, reason: collision with root package name */
    private static final PublicSuffixDatabase f7571h = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f7572a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f7573b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    private byte[] f7574c;
    private byte[] d;

    public static final class a {
        public static final String a(byte[] bArr, byte[][] bArr2, int i2) {
            int i4;
            boolean z4;
            int i5;
            int i6;
            a aVar = PublicSuffixDatabase.f7569e;
            int length = bArr.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = (i7 + length) / 2;
                while (i8 > -1 && bArr[i8] != 10) {
                    i8--;
                }
                int i9 = i8 + 1;
                int i10 = 1;
                while (true) {
                    i4 = i9 + i10;
                    if (bArr[i4] == 10) {
                        break;
                    }
                    i10++;
                }
                int i11 = i4 - i9;
                int i12 = i2;
                boolean z5 = false;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    if (z5) {
                        i5 = 46;
                        z4 = false;
                    } else {
                        byte b2 = bArr2[i12][i13];
                        byte[] bArr3 = c.f596a;
                        int i15 = b2 & 255;
                        z4 = z5;
                        i5 = i15;
                    }
                    byte b4 = bArr[i9 + i14];
                    byte[] bArr4 = c.f596a;
                    i6 = i5 - (b4 & 255);
                    if (i6 != 0) {
                        break;
                    }
                    i14++;
                    i13++;
                    if (i14 == i11) {
                        break;
                    }
                    if (bArr2[i12].length != i13) {
                        z5 = z4;
                    } else {
                        if (i12 == bArr2.length - 1) {
                            break;
                        }
                        i12++;
                        i13 = -1;
                        z5 = true;
                    }
                }
                if (i6 >= 0) {
                    if (i6 <= 0) {
                        int i16 = i11 - i14;
                        int length2 = bArr2[i12].length - i13;
                        int length3 = bArr2.length;
                        for (int i17 = i12 + 1; i17 < length3; i17++) {
                            length2 += bArr2[i17].length;
                        }
                        if (length2 >= i16) {
                            if (length2 <= i16) {
                                Charset charset = StandardCharsets.UTF_8;
                                f3.c.c(charset, "UTF_8");
                                return new String(bArr, i9, i11, charset);
                            }
                        }
                    }
                    i7 = i4 + 1;
                }
                length = i9 - 1;
            }
            return null;
        }
    }

    private final void c() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        f fVarC = n.c(new k(n.g(resourceAsStream)));
        try {
            byte[] bArrZ = fVarC.Z(fVarC.readInt());
            byte[] bArrZ2 = fVarC.Z(fVarC.readInt());
            d.b(fVarC, null);
            synchronized (this) {
                f3.c.b(bArrZ);
                this.f7574c = bArrZ;
                f3.c.b(bArrZ2);
                this.d = bArrZ2;
            }
            this.f7573b.countDown();
        } finally {
        }
    }

    private final List<String> d(String str) {
        int i2 = 0;
        List<String> listY = i3.f.y(str, new char[]{'.'});
        if (listY.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        if (!f3.c.a(listY.get(listY.size() - 1), "")) {
            return listY;
        }
        int size = listY.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (!(size >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + size + " is less than zero.").toString());
        }
        if (size == 0) {
            return m.f2185i;
        }
        if (size >= listY.size()) {
            return g.m(listY);
        }
        if (size == 1) {
            return g.g(g.e(listY));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = listY.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == size) {
                break;
            }
        }
        return g.j(arrayList);
    }

    public final String b(String str) throws InterruptedException {
        String strA;
        String strA2;
        String strA3;
        List<String> listY;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        f3.c.c(unicode, "unicodeDomain");
        List<String> listD = d(unicode);
        int i2 = 0;
        if (this.f7572a.get() || !this.f7572a.compareAndSet(false, true)) {
            try {
                this.f7573b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z4 = false;
            while (true) {
                try {
                    try {
                        c();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z4 = true;
                    } catch (IOException e2) {
                        h.a aVar = h.f1639a;
                        h.f1640b.i("Failed to read public suffix list", 5, e2);
                        if (z4) {
                        }
                    }
                } catch (Throwable th) {
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z4) {
                Thread.currentThread().interrupt();
            }
        }
        if (!(this.f7574c != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size3 = listD.size();
        byte[][] bArr = new byte[size3][];
        for (int i4 = 0; i4 < size3; i4++) {
            String str2 = listD.get(i4);
            Charset charset = StandardCharsets.UTF_8;
            f3.c.c(charset, "UTF_8");
            byte[] bytes = str2.getBytes(charset);
            f3.c.c(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i4] = bytes;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                strA = null;
                break;
            }
            int i6 = i5 + 1;
            byte[] bArr2 = this.f7574c;
            if (bArr2 == null) {
                f3.c.i("publicSuffixListBytes");
                throw null;
            }
            strA = a.a(bArr2, bArr, i5);
            if (strA != null) {
                break;
            }
            i5 = i6;
        }
        if (size3 > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            int i7 = 0;
            while (i7 < length) {
                int i8 = i7 + 1;
                bArr3[i7] = f7570f;
                byte[] bArr4 = this.f7574c;
                if (bArr4 == null) {
                    f3.c.i("publicSuffixListBytes");
                    throw null;
                }
                strA2 = a.a(bArr4, bArr3, i7);
                if (strA2 != null) {
                    break;
                }
                i7 = i8;
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            int i9 = size3 - 1;
            int i10 = 0;
            while (i10 < i9) {
                int i11 = i10 + 1;
                byte[] bArr5 = this.d;
                if (bArr5 == null) {
                    f3.c.i("publicSuffixExceptionListBytes");
                    throw null;
                }
                strA3 = a.a(bArr5, bArr, i10);
                if (strA3 != null) {
                    break;
                }
                i10 = i11;
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            listY = i3.f.y(f3.c.h("!", strA3), new char[]{'.'});
        } else if (strA == null && strA2 == null) {
            listY = g;
        } else {
            List<String> listY2 = strA == null ? null : i3.f.y(strA, new char[]{'.'});
            if (listY2 == null) {
                listY2 = m.f2185i;
            }
            listY = strA2 == null ? null : i3.f.y(strA2, new char[]{'.'});
            if (listY == null) {
                listY = m.f2185i;
            }
            if (listY2.size() > listY.size()) {
                listY = listY2;
            }
        }
        if (listD.size() == listY.size() && listY.get(0).charAt(0) != '!') {
            return null;
        }
        if (listY.get(0).charAt(0) == '!') {
            size = listD.size();
            size2 = listY.size();
        } else {
            size = listD.size();
            size2 = listY.size() + 1;
        }
        int i12 = size - size2;
        h3.c jVar = new j(d(str));
        if (!(i12 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i12 + " is less than zero.").toString());
        }
        if (i12 != 0) {
            jVar = jVar instanceof b ? ((b) jVar).a(i12) : new C0332a(jVar, i12);
        }
        f3.c.d(jVar, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : jVar) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ".");
            }
            i3.f.o(sb, obj, null);
        }
        sb.append((CharSequence) "");
        String string = sb.toString();
        f3.c.c(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }
}
