package K2;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class f331a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f332b;

    /* renamed from: c, reason: collision with root package name */
    private static Constructor<Class> f333c;
    private static Object d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f334e;

    static {
        try {
            Class<?> clsLoadClass = new PathClassLoader("/system/framework/MiuiBooster.jar", ClassLoader.getSystemClassLoader()).loadClass("com.miui.performance.DeviceLevelUtils");
            f331a = clsLoadClass;
            f333c = clsLoadClass.getConstructor(Context.class);
            f331a.getDeclaredMethod("initDeviceLevel", new Class[0]);
            Class<?> cls = Integer.TYPE;
            f331a.getDeclaredMethod("getDeviceLevel", cls, cls);
            f331a.getDeclaredMethod("getDeviceLevel", cls);
            f331a.getDeclaredMethod("isSupportPrune", new Class[0]);
            ((Integer) a(f331a, "DEVICE_LEVEL_FOR_RAM")).intValue();
            ((Integer) a(f331a, "DEVICE_LEVEL_FOR_CPU")).intValue();
            ((Integer) a(f331a, "DEVICE_LEVEL_FOR_GPU")).intValue();
            ((Integer) a(f331a, "LOW_DEVICE")).intValue();
            ((Integer) a(f331a, "MIDDLE_DEVICE")).intValue();
            ((Integer) a(f331a, "HIGH_DEVICE")).intValue();
            ((Integer) a(f331a, "DEVICE_LEVEL_UNKNOWN")).intValue();
            f334e = ((Boolean) a(f331a, "IS_MIUI_LITE_VERSION")).booleanValue();
            ((Integer) a(f331a, "TOTAL_RAM")).intValue();
        } catch (Exception e2) {
            Log.e("DeviceLevel", "MiDeviceLevelBridge(): Load Class Exception:" + e2);
        }
        if (f332b == null) {
            try {
                Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
                if (application != null) {
                    f332b = application.getApplicationContext();
                }
            } catch (Exception e4) {
                Log.e("DeviceLevel", "android.app.ActivityThread Exception:" + e4);
            }
        }
        if (f332b == null) {
            try {
                Application application2 = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
                if (application2 != null) {
                    f332b = application2.getApplicationContext();
                }
            } catch (Exception e5) {
                Log.e("DeviceLevel", "android.app.AppGlobals Exception:" + e5);
            }
        }
        try {
            Constructor<Class> constructor = f333c;
            if (constructor != null) {
                d = constructor.newInstance(f332b);
            }
        } catch (Exception e6) {
            Log.e("DeviceLevel", "DeviceLevelUtils(): newInstance Exception:" + e6);
            e6.printStackTrace();
        }
    }

    private static <T> T a(Class<?> cls, String str) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }
}
