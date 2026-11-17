package androidx.lifecycle;

import androidx.lifecycle.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Deprecated
/* loaded from: classes.dex */
final class b {

    /* renamed from: c, reason: collision with root package name */
    static b f3670c = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, a> f3671a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f3672b = new HashMap();

    @Deprecated
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map<g.b, List<C0064b>> f3673a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<C0064b, g.b> f3674b;

        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.HashMap, java.util.Map<androidx.lifecycle.g$b, java.util.List<androidx.lifecycle.b$b>>] */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashMap, java.util.Map<androidx.lifecycle.g$b, java.util.List<androidx.lifecycle.b$b>>] */
        a(Map<C0064b, g.b> map) {
            this.f3674b = map;
            for (Map.Entry<C0064b, g.b> entry : map.entrySet()) {
                g.b value = entry.getValue();
                List arrayList = (List) this.f3673a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f3673a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void b(List<C0064b> list, k kVar, g.b bVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    C0064b c0064b = list.get(size);
                    Objects.requireNonNull(c0064b);
                    try {
                        int i2 = c0064b.f3675a;
                        if (i2 == 0) {
                            c0064b.f3676b.invoke(obj, new Object[0]);
                        } else if (i2 == 1) {
                            c0064b.f3676b.invoke(obj, kVar);
                        } else if (i2 == 2) {
                            c0064b.f3676b.invoke(obj, kVar, bVar);
                        }
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException(e2);
                    } catch (InvocationTargetException e4) {
                        throw new RuntimeException("Failed to call observer method", e4.getCause());
                    }
                }
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<androidx.lifecycle.g$b, java.util.List<androidx.lifecycle.b$b>>] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashMap, java.util.Map<androidx.lifecycle.g$b, java.util.List<androidx.lifecycle.b$b>>] */
        final void a(k kVar, g.b bVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b((List) this.f3673a.get(bVar), kVar, bVar, obj);
            b((List) this.f3673a.get(g.b.ON_ANY), kVar, bVar, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0064b {

        /* renamed from: a, reason: collision with root package name */
        final int f3675a;

        /* renamed from: b, reason: collision with root package name */
        final Method f3676b;

        C0064b(int i2, Method method) throws SecurityException {
            this.f3675a = i2;
            this.f3676b = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0064b)) {
                return false;
            }
            C0064b c0064b = (C0064b) obj;
            return this.f3675a == c0064b.f3675a && this.f3676b.getName().equals(c0064b.f3676b.getName());
        }

        public final int hashCode() {
            return this.f3676b.getName().hashCode() + (this.f3675a * 31);
        }
    }

    b() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, androidx.lifecycle.b$a>] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Boolean>] */
    private a a(Class<?> cls, Method[] methodArr) throws SecurityException {
        int i2;
        Class<?> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null) {
            map.putAll(b(superclass).f3674b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0064b, g.b> entry : b(cls2).f3674b.entrySet()) {
                d(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e2) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
            }
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            q qVar = (q) method.getAnnotation(q.class);
            if (qVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(k.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                g.b bVarValue = qVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(g.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (bVarValue != g.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                d(map, new C0064b(i2, method), bVarValue, cls);
                z4 = true;
            }
        }
        a aVar = new a(map);
        this.f3671a.put(cls, aVar);
        this.f3672b.put(cls, Boolean.valueOf(z4));
        return aVar;
    }

    private void d(Map<C0064b, g.b> map, C0064b c0064b, g.b bVar, Class<?> cls) {
        g.b bVar2 = map.get(c0064b);
        if (bVar2 == null || bVar == bVar2) {
            if (bVar2 == null) {
                map.put(c0064b, bVar);
                return;
            }
            return;
        }
        Method method = c0064b.f3676b;
        StringBuilder sbD = D2.e.d("Method ");
        sbD.append(method.getName());
        sbD.append(" in ");
        sbD.append(cls.getName());
        sbD.append(" already declared with different @OnLifecycleEvent value: previous value ");
        sbD.append(bVar2);
        sbD.append(", new value ");
        sbD.append(bVar);
        throw new IllegalArgumentException(sbD.toString());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, androidx.lifecycle.b$a>] */
    final a b(Class<?> cls) {
        a aVar = (a) this.f3671a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Boolean>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Boolean>] */
    final boolean c(Class<?> cls) throws SecurityException {
        Boolean bool = (Boolean) this.f3672b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (((q) method.getAnnotation(q.class)) != null) {
                    a(cls, declaredMethods);
                    return true;
                }
            }
            this.f3672b.put(cls, Boolean.FALSE);
            return false;
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }
}
