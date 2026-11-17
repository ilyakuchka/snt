package W2;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseLongArray;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1818a = 0;

    static {
        new SparseLongArray();
        new SparseArray();
        new AtomicInteger(1);
    }

    public static void a(String str, String str2) {
        e(1, str + ", " + str2);
    }

    public static void b(String str, String str2) {
        e(4, str + ", " + str2);
    }

    public static void c(String str, String str2, Throwable th) {
        Log.v(null, str + ", " + str2, th);
    }

    public static void d(String str) {
        e(0, "SendMessageService, " + str);
    }

    public static void e(int i2, String str) {
        if (i2 >= 0) {
            Log.v(null, str);
        }
    }

    public static void f(String str, String str2) {
        e(1, str + ", " + str2);
    }
}
