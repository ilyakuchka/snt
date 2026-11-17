package E3;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.ArrayMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, C0003a> f107a = new ArrayMap();

    /* renamed from: E3.a$a, reason: collision with other inner class name */
    private static class C0003a {

        /* renamed from: a, reason: collision with root package name */
        final HandlerThread f108a;

        /* renamed from: b, reason: collision with root package name */
        int f109b = 1;

        C0003a() {
            HandlerThread handlerThread = new HandlerThread("NumberPicker_sound_play");
            this.f108a = handlerThread;
            handlerThread.start();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.util.ArrayMap, java.util.Map<java.lang.String, E3.a$a>] */
    public static synchronized Looper a() {
        C0003a c0003a;
        ?? r2 = f107a;
        c0003a = (C0003a) r2.get("NumberPicker_sound_play");
        if (c0003a == null) {
            c0003a = new C0003a();
            r2.put("NumberPicker_sound_play", c0003a);
        } else {
            c0003a.f109b++;
        }
        return c0003a.f108a.getLooper();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.util.ArrayMap, java.util.Map<java.lang.String, E3.a$a>] */
    public static synchronized void b() {
        ?? r2 = f107a;
        C0003a c0003a = (C0003a) r2.get("NumberPicker_sound_play");
        if (c0003a != null) {
            int i2 = c0003a.f109b - 1;
            c0003a.f109b = i2;
            if (i2 == 0) {
                r2.remove("NumberPicker_sound_play");
                c0003a.f108a.quitSafely();
            }
        }
    }
}
