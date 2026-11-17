package a1;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final int f2201a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2202b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f2203c;
    private final int d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Context f2204a;

        /* renamed from: b, reason: collision with root package name */
        ActivityManager f2205b;

        /* renamed from: c, reason: collision with root package name */
        b f2206c;

        /* renamed from: e, reason: collision with root package name */
        float f2207e;
        float d = 2.0f;

        /* renamed from: f, reason: collision with root package name */
        int f2208f = 4194304;

        public a(Context context) {
            this.f2207e = 1;
            this.f2204a = context;
            this.f2205b = (ActivityManager) context.getSystemService("activity");
            this.f2206c = new b(context.getResources().getDisplayMetrics());
            if (this.f2205b.isLowRamDevice()) {
                this.f2207e = 0.0f;
            }
        }

        public final j a() {
            return new j(this);
        }

        public final a b(int i2) {
            this.f2208f = i2;
            return this;
        }

        public final a c() {
            this.f2207e = 0.1f;
            return this;
        }

        public final a d() {
            this.d = 0.1f;
            return this;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f2209a;

        b(DisplayMetrics displayMetrics) {
            this.f2209a = displayMetrics;
        }

        public final int a() {
            return this.f2209a.heightPixels;
        }

        public final int b() {
            return this.f2209a.widthPixels;
        }
    }

    j(a aVar) {
        this.f2203c = aVar.f2204a;
        int i2 = aVar.f2205b.isLowRamDevice() ? aVar.f2208f / 2 : aVar.f2208f;
        this.d = i2;
        int iRound = Math.round(r1.getMemoryClass() * 1024 * 1024 * (aVar.f2205b.isLowRamDevice() ? 0.33f : 0.4f));
        float fB = aVar.f2206c.b() * aVar.f2206c.a() * 4;
        int iRound2 = Math.round(aVar.f2207e * fB);
        int iRound3 = Math.round(fB * aVar.d);
        int i4 = iRound - i2;
        int i5 = iRound3 + iRound2;
        if (i5 <= i4) {
            this.f2202b = iRound3;
            this.f2201a = iRound2;
        } else {
            float f4 = i4;
            float f5 = aVar.f2207e;
            float f6 = aVar.d;
            float f7 = f4 / (f5 + f6);
            this.f2202b = Math.round(f6 * f7);
            this.f2201a = Math.round(f7 * aVar.f2207e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sbD = D2.e.d("Calculation complete, Calculated memory cache size: ");
            sbD.append(d(this.f2202b));
            sbD.append(", pool size: ");
            sbD.append(d(this.f2201a));
            sbD.append(", byte array size: ");
            sbD.append(d(i2));
            sbD.append(", memory class limited? ");
            sbD.append(i5 > iRound);
            sbD.append(", max size: ");
            sbD.append(d(iRound));
            sbD.append(", memoryClass: ");
            sbD.append(aVar.f2205b.getMemoryClass());
            sbD.append(", isLowMemoryDevice: ");
            sbD.append(aVar.f2205b.isLowRamDevice());
            Log.d("MemorySizeCalculator", sbD.toString());
        }
    }

    private String d(int i2) {
        return Formatter.formatFileSize(this.f2203c, i2);
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.f2201a;
    }

    public final int c() {
        return this.f2202b;
    }
}
