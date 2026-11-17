package miuix.view;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class HapticCompat {

    /* renamed from: a, reason: collision with root package name */
    private static List<d> f7449a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f7450b = Executors.newSingleThreadExecutor();

    private static class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private final WeakReference<View> f7451i;

        /* renamed from: j, reason: collision with root package name */
        private final int f7452j;

        public a(View view, int i2) {
            this.f7451i = new WeakReference<>(view);
            this.f7452j = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = this.f7451i.get();
            if (view == null || !view.isAttachedToWindow()) {
                return;
            }
            try {
                HapticCompat.performHapticFeedback(view, this.f7452j);
            } catch (Exception unused) {
            }
        }
    }

    static {
        String[] strArr = {"miuix.view.LinearVibrator", "miuix.view.ExtendedVibrator"};
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            Log.i("HapticCompat", "loading provider: " + str);
            try {
                Class.forName(str, true, HapticCompat.class.getClassLoader());
            } catch (ClassNotFoundException e2) {
                Log.w("HapticCompat", String.format("load provider %s failed.", str), e2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<miuix.view.d>] */
    @Keep
    public static boolean performHapticFeedback(View view, int i2) {
        if (i2 < 268435456) {
            Log.i("HapticCompat", String.format("perform haptic: 0x%08x", Integer.valueOf(i2)));
            return view.performHapticFeedback(i2);
        }
        int i4 = c.f7467r;
        if (i2 > i4) {
            Log.w("HapticCompat", String.format("illegal feedback constant, should be in range [0x%08x..0x%08x]", 268435456, Integer.valueOf(i4)));
            return false;
        }
        Iterator it = f7449a.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).performHapticFeedback(view, i2)) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public static void performHapticFeedbackAsync(View view, int i2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            f7450b.execute(new a(view, i2));
        } else {
            performHapticFeedback(view, i2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<miuix.view.d>] */
    @Keep
    static void registerProvider(d dVar) {
        f7449a.add(dVar);
    }
}
