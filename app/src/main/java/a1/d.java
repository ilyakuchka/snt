package a1;

import a1.a;
import java.io.File;

/* loaded from: classes.dex */
public class d implements a.InterfaceC0052a {

    /* renamed from: a, reason: collision with root package name */
    private final long f2193a = 262144000;

    /* renamed from: b, reason: collision with root package name */
    private final a f2194b;

    public interface a {
    }

    public d(a aVar) {
        this.f2194b = aVar;
    }

    public final a1.a a() {
        f fVar = (f) this.f2194b;
        File cacheDir = fVar.f2199a.getCacheDir();
        if (cacheDir == null) {
            cacheDir = null;
        } else if (fVar.f2200b != null) {
            cacheDir = new File(cacheDir, fVar.f2200b);
        }
        if (cacheDir == null) {
            return null;
        }
        if (cacheDir.mkdirs() || (cacheDir.exists() && cacheDir.isDirectory())) {
            return new e(cacheDir, this.f2193a);
        }
        return null;
    }
}
