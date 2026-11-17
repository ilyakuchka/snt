package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f3715a = new HashMap();

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    final void a() {
        Map<String, Object> map = this.f3715a;
        if (map != null) {
            synchronized (map) {
                for (Object obj : this.f3715a.values()) {
                    if (obj instanceof Closeable) {
                        try {
                            ((Closeable) obj).close();
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
            }
        }
        c();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    final Object b() {
        Object obj;
        Map<String, Object> map = this.f3715a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f3715a.get("androidx.lifecycle.savedstate.vm.tag");
        }
        return obj;
    }

    protected void c() {
    }
}
