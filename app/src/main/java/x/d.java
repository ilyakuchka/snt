package x;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class d {
    public static Handler c() {
        return new Handler(Looper.getMainLooper());
    }

    public final void a() {
        c().post(new c(this));
    }

    public final void b(Typeface typeface) {
        c().post(new RunnableC0413b(this, typeface));
    }

    public abstract void d(Typeface typeface);
}
