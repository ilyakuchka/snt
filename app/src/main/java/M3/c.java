package M3;

import L3.A;
import L3.B;
import L3.C;
import L3.s;
import L3.t;
import L3.w;
import L3.z;
import X3.g;
import X3.p;
import X3.y;
import Z2.d;
import Z2.m;
import i3.e;
import i3.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f596a;

    /* renamed from: b, reason: collision with root package name */
    public static final s f597b = s.f478j.e(new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final B f598c;
    private static final p d;

    /* renamed from: e, reason: collision with root package name */
    public static final TimeZone f599e;

    /* renamed from: f, reason: collision with root package name */
    private static final e f600f;
    public static final String g;

    static {
        byte[] bArr = new byte[0];
        f596a = bArr;
        f598c = (B) C.f385i.a(bArr, null);
        z.f560a.a(bArr, null, 0, 0);
        p.a aVar = p.f1868k;
        g.a aVar2 = g.f1847l;
        d = aVar.b(aVar2.a("efbbbf"), aVar2.a("feff"), aVar2.a("fffe"), aVar2.a("0000ffff"), aVar2.a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        f3.c.b(timeZone);
        f599e = timeZone;
        f600f = new e("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        g = f.v(f.u(w.class.getName(), "okhttp3."));
    }

    public static final String A(String str, int i2, int i4) {
        int iO = o(str, i2, i4);
        String strSubstring = str.substring(iO, p(str, iO, i4));
        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final Throwable B(Exception exc, List<? extends Exception> list) {
        f3.c.d(exc, "<this>");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            Y1.a.a(exc, it.next());
        }
        return exc;
    }

    public static final boolean a(String str) {
        f3.c.d(str, "<this>");
        return f600f.a(str);
    }

    public static final boolean b(t tVar, t tVar2) {
        f3.c.d(tVar, "<this>");
        f3.c.d(tVar2, "other");
        return f3.c.a(tVar.g(), tVar2.g()) && tVar.j() == tVar2.j() && f3.c.a(tVar.p(), tVar2.p());
    }

    public static final int c() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(30000L);
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException(f3.c.h("timeout", " too large.").toString());
        }
        if (millis != 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(f3.c.h("timeout", " too small.").toString());
    }

    public static final void d(long j2, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j2 || j2 - j4 < j5) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void e(Closeable closeable) throws IOException {
        f3.c.d(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void f(Socket socket) throws IOException {
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e4) {
            if (!f3.c.a(e4.getMessage(), "bio == null")) {
                throw e4;
            }
        } catch (Exception unused) {
        }
    }

    public static final int g(String str, char c2, int i2, int i4) {
        f3.c.d(str, "<this>");
        while (i2 < i4) {
            int i5 = i2 + 1;
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2 = i5;
        }
        return i4;
    }

    public static final int h(String str, String str2, int i2, int i4) {
        f3.c.d(str, "<this>");
        while (i2 < i4) {
            int i5 = i2 + 1;
            if (f.r(str2, str.charAt(i2), 0, false, 2) >= 0) {
                return i2;
            }
            i2 = i5;
        }
        return i4;
    }

    public static final boolean i(y yVar) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        f3.c.d(yVar, "<this>");
        f3.c.d(timeUnit, "timeUnit");
        try {
            return v(yVar, 100);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String j(String str, Object... objArr) {
        f3.c.d(str, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        f3.c.c(str2, "format(locale, format, *args)");
        return str2;
    }

    public static final boolean k(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        f3.c.d(strArr, "<this>");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = strArr[i2];
                    i2++;
                    Iterator itF = f3.c.f(strArr2);
                    while (itF.hasNext()) {
                        if (comparator.compare(str, (String) itF.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long l(A a2) {
        String strD = a2.i0().d("Content-Length");
        if (strD != null) {
            try {
                return Long.parseLong(strD);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> m(T... tArr) {
        f3.c.d(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        f3.c.d(objArrCopyOf, "elements");
        List<T> listUnmodifiableList = Collections.unmodifiableList(objArrCopyOf.length > 0 ? d.a(objArrCopyOf) : m.f2185i);
        f3.c.c(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int n(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (f3.c.e(cCharAt, 31) <= 0 || f3.c.e(cCharAt, 127) >= 0) {
                return i2;
            }
            i2 = i4;
        }
        return -1;
    }

    public static final int o(String str, int i2, int i4) {
        while (i2 < i4) {
            int i5 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                return i2;
            }
            i2 = i5;
        }
        return i4;
    }

    public static final int p(String str, int i2, int i4) {
        int i5 = i4 - 1;
        if (i2 <= i5) {
            while (true) {
                int i6 = i5 - 1;
                char cCharAt = str.charAt(i5);
                if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                    return i5 + 1;
                }
                if (i5 == i2) {
                    break;
                }
                i5 = i6;
            }
        }
        return i2;
    }

    public static final String[] q(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        f3.c.d(strArr2, "other");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            int length2 = strArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 < length2) {
                    String str2 = strArr2[i4];
                    i4++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public static final boolean r(String str) {
        f3.c.d(str, "name");
        return f.q(str, "Authorization") || f.q(str, "Cookie") || f.q(str, "Proxy-Authorization") || f.q(str, "Set-Cookie");
    }

    public static final int s(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        char c4 = 'a';
        if (!('a' <= c2 && c2 < 'g')) {
            c4 = 'A';
            if (!('A' <= c2 && c2 < 'G')) {
                return -1;
            }
        }
        return (c2 - c4) + 10;
    }

    public static final Charset t(X3.f fVar, Charset charset) throws IOException {
        f3.c.d(fVar, "<this>");
        f3.c.d(charset, "default");
        int iE = fVar.E(d);
        if (iE == -1) {
            return charset;
        }
        if (iE == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            f3.c.c(charset2, "UTF_8");
            return charset2;
        }
        if (iE == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            f3.c.c(charset3, "UTF_16BE");
            return charset3;
        }
        if (iE == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            f3.c.c(charset4, "UTF_16LE");
            return charset4;
        }
        if (iE == 3) {
            i3.c cVar = i3.c.f6338a;
            return i3.c.a();
        }
        if (iE != 4) {
            throw new AssertionError();
        }
        i3.c cVar2 = i3.c.f6338a;
        return i3.c.b();
    }

    public static final int u(X3.f fVar) throws IOException {
        f3.c.d(fVar, "<this>");
        return (fVar.readByte() & 255) | ((fVar.readByte() & 255) << 16) | ((fVar.readByte() & 255) << 8);
    }

    public static final boolean v(y yVar, int i2) throws IOException {
        boolean z4;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        f3.c.d(yVar, "<this>");
        f3.c.d(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = yVar.c().e() ? yVar.c().c() - jNanoTime : Long.MAX_VALUE;
        yVar.c().d(Math.min(jC, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            X3.d dVar = new X3.d();
            while (yVar.U(dVar, 8192L) != -1) {
                dVar.f();
            }
            z4 = true;
        } catch (InterruptedIOException unused) {
            z4 = false;
            if (jC == Long.MAX_VALUE) {
            }
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                yVar.c().a();
            } else {
                yVar.c().d(jNanoTime + jC);
            }
            throw th;
        }
        if (jC == Long.MAX_VALUE) {
            yVar.c().a();
        } else {
            yVar.c().d(jNanoTime + jC);
        }
        return z4;
    }

    public static final s w(List<S3.c> list) {
        s.a aVar = new s.a();
        for (S3.c cVar : list) {
            aVar.b(cVar.f1378a.q(), cVar.f1379b.q());
        }
        return aVar.c();
    }

    public static final String x(t tVar, boolean z4) {
        String strG;
        f3.c.d(tVar, "<this>");
        if (f.g(tVar.g(), ":")) {
            strG = '[' + tVar.g() + ']';
        } else {
            strG = tVar.g();
        }
        if (!z4) {
            int iJ = tVar.j();
            String strP = tVar.p();
            f3.c.d(strP, "scheme");
            if (iJ == (f3.c.a(strP, "http") ? 80 : f3.c.a(strP, "https") ? 443 : -1)) {
                return strG;
            }
        }
        return strG + ':' + tVar.j();
    }

    public static final <T> List<T> y(List<? extends T> list) {
        f3.c.d(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(Z2.g.n(list));
        f3.c.c(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int z(String str, int i2) {
        Long lValueOf;
        if (str == null) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        if (lValueOf == null) {
            return i2;
        }
        long jLongValue = lValueOf.longValue();
        if (jLongValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }
}
