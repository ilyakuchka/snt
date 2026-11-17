package T2;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import r.C0374g;

/* loaded from: classes.dex */
public final class e extends InputStream {

    /* renamed from: i, reason: collision with root package name */
    private final Object f1615i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final int f1616j;

    /* renamed from: k, reason: collision with root package name */
    private final Context f1617k;

    /* renamed from: l, reason: collision with root package name */
    private final Uri f1618l;

    /* renamed from: m, reason: collision with root package name */
    private final String f1619m;

    /* renamed from: n, reason: collision with root package name */
    private volatile InputStream f1620n;

    /* renamed from: o, reason: collision with root package name */
    private IOException f1621o;
    private Throwable p;

    final class a {
        a() {
        }

        protected final void finalize() throws Throwable {
            try {
                if (e.this.p != null) {
                    Log.e("ResettableInputStream", "InputStream is opened but never closed here", e.this.p);
                }
                e.this.close();
            } finally {
                super.finalize();
            }
        }
    }

    public e(Context context, Uri uri) {
        if ("file".equals(uri.getScheme())) {
            this.f1616j = 1;
            this.f1619m = uri.getPath();
            this.f1617k = null;
            this.f1618l = null;
            return;
        }
        this.f1616j = 2;
        this.f1617k = context;
        this.f1618l = uri;
        this.f1619m = null;
    }

    private void H() throws IOException {
        IOException iOException = this.f1621o;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f1620n != null) {
            return;
        }
        synchronized (this.f1615i) {
            try {
                if (this.f1620n != null) {
                    return;
                }
                int iB = C0374g.b(this.f1616j);
                if (iB == 0) {
                    this.f1620n = new FileInputStream(this.f1619m);
                } else if (iB == 1) {
                    this.f1620n = this.f1617k.getContentResolver().openInputStream(this.f1618l);
                } else {
                    if (iB == 2) {
                        throw null;
                    }
                    if (iB != 3) {
                        throw new IllegalStateException("Unkown type " + C2.c.g(this.f1616j));
                    }
                    this.f1620n = new ByteArrayInputStream(null);
                }
                this.p = new Throwable();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        H();
        return this.f1620n.available();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f1620n == null) {
            return;
        }
        synchronized (this.f1615i) {
            if (this.f1620n == null) {
                return;
            }
            try {
                this.f1620n.close();
            } finally {
                this.p = null;
                this.f1620n = null;
                this.f1621o = null;
            }
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        try {
            H();
            this.f1620n.mark(i2);
        } catch (IOException e2) {
            this.f1621o = e2;
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        try {
            H();
            return this.f1620n.markSupported();
        } catch (IOException e2) {
            this.f1621o = e2;
            return super.markSupported();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        H();
        return this.f1620n.read();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (this.f1620n != null) {
            if (this.f1620n instanceof FileInputStream) {
                ((FileInputStream) this.f1620n).getChannel().position(0L);
                return;
            }
            if (!(this.f1620n instanceof AssetManager.AssetInputStream) && !(this.f1620n instanceof ByteArrayInputStream)) {
                close();
            }
            this.f1620n.reset();
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j2) throws IOException {
        H();
        return this.f1620n.skip(j2);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        H();
        return this.f1620n.read(bArr);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i4) throws IOException {
        H();
        return this.f1620n.read(bArr, i2, i4);
    }
}
