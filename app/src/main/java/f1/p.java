package f1;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Objects;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: e, reason: collision with root package name */
    private static final File f6207e = new File("/proc/self/fd");

    /* renamed from: f, reason: collision with root package name */
    private static volatile p f6208f;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6209a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6210b;

    /* renamed from: c, reason: collision with root package name */
    private int f6211c;
    private boolean d = true;

    p() {
        String str;
        String str2 = Build.MODEL;
        if (str2 != null && str2.length() >= 7) {
            String strSubstring = str2.substring(0, 7);
            Objects.requireNonNull(strSubstring);
            switch (strSubstring.hashCode()) {
                case -1398613787:
                    str = "SM-A520";
                    break;
                case -1398431166:
                    str = "SM-G930";
                    break;
                case -1398431161:
                    str = "SM-G935";
                    break;
                case -1398431073:
                    str = "SM-G960";
                    break;
                case -1398431068:
                    str = "SM-G965";
                    break;
                case -1398343746:
                    str = "SM-J720";
                    break;
                case -1398222624:
                    str = "SM-N935";
                    break;
            }
            strSubstring.equals(str);
        }
        this.f6209a = true;
        this.f6210b = 20000;
    }

    public static p a() {
        if (f6208f == null) {
            synchronized (p.class) {
                if (f6208f == null) {
                    f6208f = new p();
                }
            }
        }
        return f6208f;
    }

    public final boolean b(int i2, int i4, boolean z4, boolean z5) {
        boolean z6;
        if (!z4 || !this.f6209a || z5 || i2 < 0 || i4 < 0) {
            return false;
        }
        synchronized (this) {
            int i5 = this.f6211c + 1;
            this.f6211c = i5;
            if (i5 >= 50) {
                this.f6211c = 0;
                int length = f6207e.list().length;
                boolean z7 = length < this.f6210b;
                this.d = z7;
                if (!z7 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f6210b);
                }
            }
            z6 = this.d;
        }
        return z6;
    }
}
