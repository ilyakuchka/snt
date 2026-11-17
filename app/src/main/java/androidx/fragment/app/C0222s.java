package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* renamed from: androidx.fragment.app.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0222s {

    /* renamed from: a, reason: collision with root package name */
    private static final q.g<ClassLoader, q.g<String, Class<?>>> f3578a = new q.g<>();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        q.g<ClassLoader, q.g<String, Class<?>>> gVar = f3578a;
        q.g<String, Class<?>> orDefault = gVar.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new q.g<>();
            gVar.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 != null) {
            return orDefault2;
        }
        Class<?> cls = Class.forName(str, false, classLoader);
        orDefault.put(str, cls);
        return cls;
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e2) {
            throw new Fragment.c(C2.c.a("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e2);
        } catch (ClassNotFoundException e4) {
            throw new Fragment.c(C2.c.a("Unable to instantiate fragment ", str, ": make sure class name exists"), e4);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }
}
