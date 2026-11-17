package S2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import com.android.mmt.R;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f1363a;

    /* renamed from: b, reason: collision with root package name */
    public static Matcher f1364b;

    /* renamed from: c, reason: collision with root package name */
    public static Matcher f1365c;

    public static Object a(Class cls, String str, Class[] clsArr, Object... objArr) throws NoSuchMethodException, SecurityException {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception e2) {
            Log.e("ReflectUtil", "Failed to call static method:" + str, e2);
            return null;
        }
    }

    public static final void b(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                Y1.a.a(th, th2);
            }
        }
    }

    public static void c(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static synchronized String e(String str) {
        if (f1363a == null) {
            Pattern patternCompile = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
            f1363a = patternCompile;
            f1364b = patternCompile.matcher(str);
        } else {
            f1364b.reset(str);
        }
        if (f1364b.matches()) {
            str = f1364b.group(2);
            f1364b.reset();
        }
        return str;
    }

    public static Class f() {
        try {
            return Class.forName("android.os.SystemProperties");
        } catch (Exception e2) {
            Log.e("ReflectUtil", "Cant find class android.os.SystemProperties", e2);
            return null;
        }
    }

    public static int g(Context context, int i2) {
        if (i2 == 1) {
            return context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_window_extra_padding_horizontal_small);
        }
        if (i2 == 2) {
            return context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_window_extra_padding_horizontal_large);
        }
        if (i2 != 3) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_window_extra_padding_horizontal_huge);
    }

    public static synchronized boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strE = e(str);
        if (f1365c == null) {
            f1365c = Patterns.EMAIL_ADDRESS.matcher(strE);
        } else {
            if (TextUtils.isEmpty(strE)) {
                return false;
            }
            f1365c.reset(strE);
        }
        boolean zMatches = f1365c.matches();
        f1365c.reset();
        return zMatches;
    }

    public static boolean i(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static boolean j(int i2) {
        return i2 >= 0 && i2 <= 3;
    }

    public static void k(ViewGroup viewGroup, View view, int i2, int i4, int i5, int i6) {
        boolean z4 = viewGroup.getLayoutDirection() == 1;
        int width = viewGroup.getWidth();
        int i7 = z4 ? width - i5 : i2;
        if (z4) {
            i5 = width - i2;
        }
        view.layout(i7, i4, i5, i6);
    }

    public static HashSet l(Object... objArr) {
        HashSet hashSet = new HashSet(((objArr.length * 4) / 3) + 1);
        Collections.addAll(hashSet, objArr);
        return hashSet;
    }
}
