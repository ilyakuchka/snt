package a1;

import T0.a;
import a1.a;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private final File f2196b;

    /* renamed from: c, reason: collision with root package name */
    private final long f2197c;

    /* renamed from: e, reason: collision with root package name */
    private T0.a f2198e;
    private final c d = new c();

    /* renamed from: a, reason: collision with root package name */
    private final k f2195a = new k();

    @Deprecated
    protected e(File file, long j2) {
        this.f2196b = file;
        this.f2197c = j2;
    }

    private synchronized T0.a c() throws IOException {
        if (this.f2198e == null) {
            this.f2198e = T0.a.q0(this.f2196b, this.f2197c);
        }
        return this.f2198e;
    }

    @Override // a1.a
    public final void a(V0.f fVar, a.b bVar) {
        String strA = this.f2195a.a(fVar);
        this.d.a(strA);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strA + " for for Key: " + fVar);
            }
            try {
                T0.a aVarC = c();
                if (aVarC.o0(strA) == null) {
                    a.c cVarM0 = aVarC.m0(strA);
                    if (cVarM0 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strA);
                    }
                    try {
                        if (bVar.a(cVarM0.f())) {
                            cVarM0.e();
                        }
                        cVarM0.b();
                    } catch (Throwable th) {
                        cVarM0.b();
                        throw th;
                    }
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
        } finally {
            this.d.b(strA);
        }
    }

    @Override // a1.a
    public final File b(V0.f fVar) {
        String strA = this.f2195a.a(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strA + " for for Key: " + fVar);
        }
        try {
            a.e eVarO0 = c().o0(strA);
            if (eVarO0 != null) {
                return eVarO0.a();
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }
}
