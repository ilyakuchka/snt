package androidx.startup;

import X.b;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.lifecycle.ProcessLifecycleInitializer;
import com.android.mmt.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {
    private static volatile a d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f4294e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f4297c;

    /* renamed from: b, reason: collision with root package name */
    final Set<Class<? extends X.a<?>>> f4296b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map<Class<?>, Object> f4295a = new HashMap();

    a(Context context) {
        this.f4297c = context.getApplicationContext();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Object>] */
    private <T> T b(Class<? extends X.a<?>> cls, Set<Class<?>> set) {
        T t2;
        if (Y.a.a()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } finally {
                Trace.endSection();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f4295a.containsKey(cls)) {
            t2 = (T) this.f4295a.get(cls);
        } else {
            set.add(cls);
            try {
                X.a<?> aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends X.a<?>>> listA = aVarNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends X.a<?>> cls2 : listA) {
                        if (!this.f4295a.containsKey(cls2)) {
                            b(cls2, set);
                        }
                    }
                }
                t2 = (T) aVarNewInstance.b(this.f4297c);
                set.remove(cls);
                this.f4295a.put(cls, t2);
            } catch (Throwable th) {
                throw new b(th);
            }
        }
        return t2;
    }

    public static a c(Context context) {
        if (d == null) {
            synchronized (f4294e) {
                if (d == null) {
                    d = new a(context);
                }
            }
        }
        return d;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.HashSet, java.util.Set<java.lang.Class<? extends X.a<?>>>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.HashSet, java.util.Set<java.lang.Class<? extends X.a<?>>>] */
    final void a(Bundle bundle) throws ClassNotFoundException {
        String string = this.f4297c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (X.a.class.isAssignableFrom(cls)) {
                            this.f4296b.add(cls);
                        }
                    }
                }
                Iterator it = this.f4296b.iterator();
                while (it.hasNext()) {
                    b((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new b(e2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashSet, java.util.Set<java.lang.Class<? extends X.a<?>>>] */
    public final boolean d() {
        return this.f4296b.contains(ProcessLifecycleInitializer.class);
    }
}
