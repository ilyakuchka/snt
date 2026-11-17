package T0;

import android.annotation.TargetApi;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    private final File f1526i;

    /* renamed from: j, reason: collision with root package name */
    private final File f1527j;

    /* renamed from: k, reason: collision with root package name */
    private final File f1528k;

    /* renamed from: l, reason: collision with root package name */
    private final File f1529l;

    /* renamed from: n, reason: collision with root package name */
    private long f1531n;

    /* renamed from: q, reason: collision with root package name */
    private BufferedWriter f1533q;

    /* renamed from: s, reason: collision with root package name */
    private int f1535s;
    private long p = 0;

    /* renamed from: r, reason: collision with root package name */
    private final LinkedHashMap<String, d> f1534r = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: t, reason: collision with root package name */
    private long f1536t = 0;
    final ThreadPoolExecutor u = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());

    /* renamed from: v, reason: collision with root package name */
    private final Callable<Void> f1537v = new CallableC0037a();

    /* renamed from: m, reason: collision with root package name */
    private final int f1530m = 1;

    /* renamed from: o, reason: collision with root package name */
    private final int f1532o = 1;

    /* renamed from: T0.a$a, reason: collision with other inner class name */
    final class CallableC0037a implements Callable<Void> {
        CallableC0037a() {
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f1533q == null) {
                    return null;
                }
                a.this.w0();
                if (a.this.p0()) {
                    a.this.u0();
                    a.this.f1535s = 0;
                }
                return null;
            }
        }
    }

    private static final class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f1539a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f1540b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1541c;

        c(d dVar) {
            this.f1539a = dVar;
            this.f1540b = dVar.f1545e ? null : new boolean[a.this.f1532o];
        }

        public final void a() throws IOException {
            a.f0(a.this, this, false);
        }

        public final void b() {
            if (this.f1541c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public final void e() throws IOException {
            a.f0(a.this, this, true);
            this.f1541c = true;
        }

        public final File f() throws IOException {
            File file;
            synchronized (a.this) {
                if (this.f1539a.f1546f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f1539a.f1545e) {
                    this.f1540b[0] = true;
                }
                file = this.f1539a.d[0];
                if (!a.this.f1526i.exists()) {
                    a.this.f1526i.mkdirs();
                }
            }
            return file;
        }
    }

    private final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f1542a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f1543b;

        /* renamed from: c, reason: collision with root package name */
        File[] f1544c;
        File[] d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1545e;

        /* renamed from: f, reason: collision with root package name */
        private c f1546f;
        private long g;

        d(String str) {
            this.f1542a = str;
            this.f1543b = new long[a.this.f1532o];
            this.f1544c = new File[a.this.f1532o];
            this.d = new File[a.this.f1532o];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f1532o; i2++) {
                sb.append(i2);
                this.f1544c[i2] = new File(a.this.f1526i, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(a.this.f1526i, sb.toString());
                sb.setLength(length);
            }
        }

        static void h(d dVar, String[] strArr) throws IOException {
            if (strArr.length != a.this.f1532o) {
                dVar.j(strArr);
                throw null;
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    dVar.f1543b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    dVar.j(strArr);
                    throw null;
                }
            }
        }

        private IOException j(String[] strArr) throws IOException {
            StringBuilder sbD = D2.e.d("unexpected journal line: ");
            sbD.append(Arrays.toString(strArr));
            throw new IOException(sbD.toString());
        }

        public final String i() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f1543b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }
    }

    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final File[] f1548a;

        e(File[] fileArr) {
            this.f1548a = fileArr;
        }

        public final File a() {
            return this.f1548a[0];
        }
    }

    private a(File file, long j2) {
        this.f1526i = file;
        this.f1527j = new File(file, "journal");
        this.f1528k = new File(file, "journal.tmp");
        this.f1529l = new File(file, "journal.bkp");
        this.f1531n = j2;
    }

    static void f0(a aVar, c cVar, boolean z4) throws IOException {
        synchronized (aVar) {
            d dVar = cVar.f1539a;
            if (dVar.f1546f != cVar) {
                throw new IllegalStateException();
            }
            if (z4 && !dVar.f1545e) {
                for (int i2 = 0; i2 < aVar.f1532o; i2++) {
                    if (!cVar.f1540b[i2]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                    if (!dVar.d[i2].exists()) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i4 = 0; i4 < aVar.f1532o; i4++) {
                File file = dVar.d[i4];
                if (!z4) {
                    l0(file);
                } else if (file.exists()) {
                    File file2 = dVar.f1544c[i4];
                    file.renameTo(file2);
                    long j2 = dVar.f1543b[i4];
                    long length = file2.length();
                    dVar.f1543b[i4] = length;
                    aVar.p = (aVar.p - j2) + length;
                }
            }
            aVar.f1535s++;
            dVar.f1546f = null;
            if (dVar.f1545e || z4) {
                dVar.f1545e = true;
                aVar.f1533q.append((CharSequence) "CLEAN");
                aVar.f1533q.append(' ');
                aVar.f1533q.append((CharSequence) dVar.f1542a);
                aVar.f1533q.append((CharSequence) dVar.i());
                aVar.f1533q.append('\n');
                if (z4) {
                    long j4 = aVar.f1536t;
                    aVar.f1536t = 1 + j4;
                    dVar.g = j4;
                }
            } else {
                aVar.f1534r.remove(dVar.f1542a);
                aVar.f1533q.append((CharSequence) "REMOVE");
                aVar.f1533q.append(' ');
                aVar.f1533q.append((CharSequence) dVar.f1542a);
                aVar.f1533q.append('\n');
            }
            n0(aVar.f1533q);
            if (aVar.p > aVar.f1531n || aVar.p0()) {
                aVar.u.submit(aVar.f1537v);
            }
        }
    }

    private void j0() {
        if (this.f1533q == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void k0(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private static void l0(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    private static void n0(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p0() {
        int i2 = this.f1535s;
        return i2 >= 2000 && i2 >= this.f1534r.size();
    }

    public static a q0(File file, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                v0(file2, file3, false);
            }
        }
        a aVar = new a(file, j2);
        if (aVar.f1527j.exists()) {
            try {
                aVar.s0();
                aVar.r0();
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.close();
                T0.c.a(aVar.f1526i);
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, j2);
        aVar2.u0();
        return aVar2;
    }

    private void r0() throws IOException {
        l0(this.f1528k);
        Iterator<d> it = this.f1534r.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f1546f == null) {
                while (i2 < this.f1532o) {
                    this.p += next.f1543b[i2];
                    i2++;
                }
            } else {
                next.f1546f = null;
                while (i2 < this.f1532o) {
                    l0(next.f1544c[i2]);
                    l0(next.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void s0() throws IOException {
        T0.b bVar = new T0.b(new FileInputStream(this.f1527j), T0.c.f1555a);
        try {
            String strE0 = bVar.e0();
            String strE02 = bVar.e0();
            String strE03 = bVar.e0();
            String strE04 = bVar.e0();
            String strE05 = bVar.e0();
            if (!"libcore.io.DiskLruCache".equals(strE0) || !"1".equals(strE02) || !Integer.toString(this.f1530m).equals(strE03) || !Integer.toString(this.f1532o).equals(strE04) || !"".equals(strE05)) {
                throw new IOException("unexpected journal header: [" + strE0 + ", " + strE02 + ", " + strE04 + ", " + strE05 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    t0(bVar.e0());
                    i2++;
                } catch (EOFException unused) {
                    this.f1535s = i2 - this.f1534r.size();
                    if (bVar.I()) {
                        u0();
                    } else {
                        this.f1533q = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1527j, true), T0.c.f1555a));
                    }
                    try {
                        bVar.close();
                        return;
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                bVar.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private void t0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException(D2.e.c("unexpected journal line: ", str));
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f1534r.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        d dVar = this.f1534r.get(strSubstring);
        if (dVar == null) {
            dVar = new d(strSubstring);
            this.f1534r.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f1545e = true;
            dVar.f1546f = null;
            d.h(dVar, strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f1546f = new c(dVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException(D2.e.c("unexpected journal line: ", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u0() throws IOException {
        BufferedWriter bufferedWriter = this.f1533q;
        if (bufferedWriter != null) {
            k0(bufferedWriter);
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1528k), T0.c.f1555a));
        try {
            bufferedWriter2.write("libcore.io.DiskLruCache");
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f1530m));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f1532o));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (d dVar : this.f1534r.values()) {
                if (dVar.f1546f != null) {
                    bufferedWriter2.write("DIRTY " + dVar.f1542a + '\n');
                } else {
                    bufferedWriter2.write("CLEAN " + dVar.f1542a + dVar.i() + '\n');
                }
            }
            k0(bufferedWriter2);
            if (this.f1527j.exists()) {
                v0(this.f1527j, this.f1529l, true);
            }
            v0(this.f1528k, this.f1527j, false);
            this.f1529l.delete();
            this.f1533q = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1527j, true), T0.c.f1555a));
        } catch (Throwable th) {
            k0(bufferedWriter2);
            throw th;
        }
    }

    private static void v0(File file, File file2, boolean z4) throws IOException {
        if (z4) {
            l0(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() throws IOException {
        while (this.p > this.f1531n) {
            String key = this.f1534r.entrySet().iterator().next().getKey();
            synchronized (this) {
                j0();
                d dVar = this.f1534r.get(key);
                if (dVar != null && dVar.f1546f == null) {
                    for (int i2 = 0; i2 < this.f1532o; i2++) {
                        File file = dVar.f1544c[i2];
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        this.p -= dVar.f1543b[i2];
                        dVar.f1543b[i2] = 0;
                    }
                    this.f1535s++;
                    this.f1533q.append((CharSequence) "REMOVE");
                    this.f1533q.append(' ');
                    this.f1533q.append((CharSequence) key);
                    this.f1533q.append('\n');
                    this.f1534r.remove(key);
                    if (p0()) {
                        this.u.submit(this.f1537v);
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f1533q == null) {
            return;
        }
        Iterator it = new ArrayList(this.f1534r.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f1546f != null) {
                dVar.f1546f.a();
            }
        }
        w0();
        k0(this.f1533q);
        this.f1533q = null;
    }

    public final c m0(String str) throws IOException {
        c cVar;
        synchronized (this) {
            j0();
            d dVar = this.f1534r.get(str);
            cVar = null;
            if (dVar == null) {
                dVar = new d(str);
                this.f1534r.put(str, dVar);
            } else if (dVar.f1546f != null) {
            }
            cVar = new c(dVar);
            dVar.f1546f = cVar;
            this.f1533q.append((CharSequence) "DIRTY");
            this.f1533q.append(' ');
            this.f1533q.append((CharSequence) str);
            this.f1533q.append('\n');
            n0(this.f1533q);
        }
        return cVar;
    }

    public final synchronized e o0(String str) throws IOException {
        j0();
        d dVar = this.f1534r.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f1545e) {
            return null;
        }
        for (File file : dVar.f1544c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f1535s++;
        this.f1533q.append((CharSequence) "READ");
        this.f1533q.append(' ');
        this.f1533q.append((CharSequence) str);
        this.f1533q.append('\n');
        if (p0()) {
            this.u.submit(this.f1537v);
        }
        return new e(dVar.f1544c);
    }
}
