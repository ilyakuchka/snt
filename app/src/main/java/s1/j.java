package s1;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f7865a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f7866b = new char[64];

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f7867c = 0;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7868a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f7868a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7868a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7868a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7868a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7868a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!h()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int c(int i2, int i4, Bitmap.Config config) {
        int i5 = i2 * i4;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i6 = a.f7868a[config.ordinal()];
        int i7 = 4;
        if (i6 == 1) {
            i7 = 1;
        } else if (i6 == 2 || i6 == 3) {
            i7 = 2;
        } else if (i6 == 4) {
            i7 = 8;
        }
        return i5 * i7;
    }

    @TargetApi(19)
    public static int d(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static <T> List<T> e(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t2 : collection) {
            if (t2 != null) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static int f(Object obj, int i2) {
        return (i2 * 31) + (obj == null ? 0 : obj.hashCode());
    }

    public static boolean g() {
        return !h();
    }

    public static boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean i(int i2, int i4) {
        if (i2 > 0 || i2 == Integer.MIN_VALUE) {
            return i4 > 0 || i4 == Integer.MIN_VALUE;
        }
        return false;
    }

    public static String j(byte[] bArr) {
        String str;
        char[] cArr = f7866b;
        synchronized (cArr) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i4 = bArr[i2] & 255;
                int i5 = i2 * 2;
                char[] cArr2 = f7865a;
                cArr[i5] = cArr2[i4 >>> 4];
                cArr[i5 + 1] = cArr2[i4 & 15];
            }
            str = new String(cArr);
        }
        return str;
    }
}
