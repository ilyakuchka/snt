package b3;

import c3.C0229a;
import d3.C0295a;
import f3.c;
import i3.f;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4378a;

    static {
        int i2;
        a aVar;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            i2 = 65542;
        } else {
            int iR = f.r(property, '.', 0, false, 6);
            try {
                if (iR < 0) {
                    i2 = Integer.parseInt(property) * 65536;
                } else {
                    int i4 = iR + 1;
                    int iR2 = f.r(property, '.', i4, false, 4);
                    if (iR2 < 0) {
                        iR2 = property.length();
                    }
                    String strSubstring = property.substring(0, iR);
                    c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String strSubstring2 = property.substring(i4, iR2);
                    c.c(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    i2 = Integer.parseInt(strSubstring2) + (Integer.parseInt(strSubstring) * 65536);
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i2 >= 65544 || i2 < 65536) {
            try {
                Object objNewInstance = C0295a.class.newInstance();
                c.c(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        aVar = (a) objNewInstance;
                    } catch (ClassCastException e2) {
                        ClassLoader classLoader = objNewInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = a.class.getClassLoader();
                        if (c.a(classLoader, classLoader2)) {
                            throw e2;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e2);
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassNotFoundException unused3) {
                Object objNewInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                c.c(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    aVar = (a) objNewInstance2;
                } catch (ClassCastException e4) {
                    ClassLoader classLoader3 = objNewInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = a.class.getClassLoader();
                    if (c.a(classLoader3, classLoader4)) {
                        throw e4;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e4);
                }
            }
        } else if (i2 >= 65543 || i2 < 65536) {
            try {
                Object objNewInstance3 = C0229a.class.newInstance();
                c.c(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        aVar = (a) objNewInstance3;
                    } catch (ClassCastException e5) {
                        ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                        ClassLoader classLoader6 = a.class.getClassLoader();
                        if (c.a(classLoader5, classLoader6)) {
                            throw e5;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e5);
                    }
                } catch (ClassNotFoundException unused4) {
                }
            } catch (ClassNotFoundException unused5) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                c.c(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    aVar = (a) objNewInstance4;
                } catch (ClassCastException e6) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = a.class.getClassLoader();
                    if (c.a(classLoader7, classLoader8)) {
                        throw e6;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e6);
                }
            }
        } else {
            aVar = new a();
        }
        f4378a = aVar;
    }
}
