package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Integer> f3702a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends f>>> f3703b = new HashMap();

    private static f a(Constructor<? extends f> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static String b(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.util.List<java.lang.reflect.Constructor<? extends androidx.lifecycle.f>>>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.util.List<java.lang.reflect.Constructor<? extends androidx.lifecycle.f>>>] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.util.List<java.lang.reflect.Constructor<? extends androidx.lifecycle.f>>>] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.util.List<java.lang.reflect.Constructor<? extends androidx.lifecycle.f>>>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Constructor<?> declaredConstructor;
        int length;
        int i2;
        Integer num = (Integer) f3702a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i4 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r4 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r4 != null ? r4.getName() : "";
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String strB = b(canonicalName);
                if (!name.isEmpty()) {
                    strB = name + "." + strB;
                }
                declaredConstructor = Class.forName(strB).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
            if (declaredConstructor != null) {
                f3703b.put(cls, Collections.singletonList(declaredConstructor));
            } else if (!b.f3670c.c(cls)) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (!(superclass != null && j.class.isAssignableFrom(superclass))) {
                    Class<?>[] interfaces = cls.getInterfaces();
                    length = interfaces.length;
                    i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            Class<?> cls2 = interfaces[i2];
                            if (cls2 != null && j.class.isAssignableFrom(cls2)) {
                                if (c(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll((Collection) f3703b.get(cls2));
                            }
                            i2++;
                        } else if (arrayList != null) {
                            f3703b.put(cls, arrayList);
                        }
                    }
                } else if (c(superclass) != 1) {
                    arrayList = new ArrayList((Collection) f3703b.get(superclass));
                    Class<?>[] interfaces2 = cls.getInterfaces();
                    length = interfaces2.length;
                    i2 = 0;
                    while (true) {
                        if (i2 < length) {
                        }
                        i2++;
                    }
                }
            }
            i4 = 2;
        }
        f3702a.put(cls, Integer.valueOf(i4));
        return i4;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, java.util.List<java.lang.reflect.Constructor<? extends androidx.lifecycle.f>>>] */
    static i d(Object obj) {
        boolean z4 = obj instanceof i;
        boolean z5 = obj instanceof e;
        if (z4 && z5) {
            return new FullLifecycleObserverAdapter((e) obj, (i) obj);
        }
        if (z5) {
            return new FullLifecycleObserverAdapter((e) obj, null);
        }
        if (z4) {
            return (i) obj;
        }
        Class<?> cls = obj.getClass();
        if (c(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f3703b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        f[] fVarArr = new f[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            fVarArr[i2] = a((Constructor) list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(fVarArr);
    }
}
