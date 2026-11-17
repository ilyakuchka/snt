package x0;

import android.util.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: x0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0417d {

    /* renamed from: b, reason: collision with root package name */
    private static volatile C0417d f8080b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f8081a = new ArrayMap();

    private C0417d() {
    }

    public static C0417d c() {
        if (f8080b == null) {
            synchronized (C0417d.class) {
                if (f8080b == null) {
                    f8080b = new C0417d();
                }
            }
        }
        return f8080b;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Object>] */
    public final void a() {
        this.f8081a.clear();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.Object>] */
    public final Object b() {
        WeakReference weakReference = (WeakReference) this.f8081a.get("key_slide_data");
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
