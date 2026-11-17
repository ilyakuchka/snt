package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
final class K extends Writer {

    /* renamed from: j, reason: collision with root package name */
    private StringBuilder f3479j = new StringBuilder(128);

    /* renamed from: i, reason: collision with root package name */
    private final String f3478i = "FragmentManager";

    K() {
    }

    private void f() {
        if (this.f3479j.length() > 0) {
            Log.d(this.f3478i, this.f3479j.toString());
            StringBuilder sb = this.f3479j;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        f();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c2 = cArr[i2 + i5];
            if (c2 == '\n') {
                f();
            } else {
                this.f3479j.append(c2);
            }
        }
    }
}
