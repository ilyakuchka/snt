package f1;

import Y0.x;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import f1.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: f, reason: collision with root package name */
    public static final V0.g<V0.b> f6194f = V0.g.d("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", V0.b.f1752i);
    public static final V0.g<V0.i> g = V0.g.d("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", V0.i.f1764i);

    /* renamed from: h, reason: collision with root package name */
    public static final V0.g<Boolean> f6195h;

    /* renamed from: i, reason: collision with root package name */
    public static final V0.g<Boolean> f6196i;

    /* renamed from: j, reason: collision with root package name */
    private static final b f6197j;

    /* renamed from: k, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f6198k;

    /* renamed from: a, reason: collision with root package name */
    private final Z0.d f6199a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f6200b;

    /* renamed from: c, reason: collision with root package name */
    private final Z0.b f6201c;
    private final List<ImageHeaderParser> d;

    /* renamed from: e, reason: collision with root package name */
    private final p f6202e = p.a();

    final class a implements b {
        a() {
        }

        @Override // f1.k.b
        public final void a(Z0.d dVar, Bitmap bitmap) {
        }

        @Override // f1.k.b
        public final void b() {
        }
    }

    public interface b {
        void a(Z0.d dVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        V0.g<j> gVar = j.f6193f;
        Boolean bool = Boolean.FALSE;
        f6195h = V0.g.d("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f6196i = V0.g.d("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f6197j = new a();
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        int i2 = s1.j.f7867c;
        f6198k = new ArrayDeque(0);
    }

    public k(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, Z0.d dVar, Z0.b bVar) {
        this.d = list;
        Objects.requireNonNull(displayMetrics, "Argument must not be null");
        this.f6200b = displayMetrics;
        Objects.requireNonNull(dVar, "Argument must not be null");
        this.f6199a = dVar;
        Objects.requireNonNull(bVar, "Argument must not be null");
        this.f6201c = bVar;
    }

    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.ArrayDeque, java.util.Queue<android.graphics.BitmapFactory$Options>] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayDeque, java.util.Queue<android.graphics.BitmapFactory$Options>] */
    private x<Bitmap> b(q qVar, int i2, int i4, V0.h hVar, b bVar) throws IOException {
        ?? r14;
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.f6201c.d(65536, byte[].class);
        synchronized (k.class) {
            r14 = f6198k;
            synchronized (r14) {
                options = (BitmapFactory.Options) r14.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                l(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        V0.b bVar2 = (V0.b) hVar.c(f6194f);
        V0.i iVar = (V0.i) hVar.c(g);
        j jVar = (j) hVar.c(j.f6193f);
        boolean zBooleanValue = ((Boolean) hVar.c(f6195h)).booleanValue();
        V0.g<Boolean> gVar = f6196i;
        try {
            d dVarF = d.f(e(qVar, options2, jVar, bVar2, iVar, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), i2, i4, zBooleanValue, bVar), this.f6199a);
            l(options2);
            synchronized (r14) {
                r14.offer(options2);
            }
            this.f6201c.c(bArr);
            return dVarF;
        } catch (Throwable th) {
            l(options2);
            ?? r2 = f6198k;
            synchronized (r2) {
                r2.offer(options2);
                this.f6201c.c(bArr);
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0388 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap e(q qVar, BitmapFactory.Options options, j jVar, V0.b bVar, V0.i iVar, boolean z4, int i2, int i4, boolean z5, b bVar2) throws IOException {
        int i5;
        int i6;
        int iRound;
        String str;
        String str2;
        String str3;
        int i7;
        int i8;
        int i9;
        String str4;
        boolean zB;
        boolean z6;
        String str5;
        boolean zHasAlpha;
        boolean z7;
        int i10;
        int i11;
        int i12;
        Bitmap bitmapF;
        ColorSpace colorSpace;
        Bitmap.Config config;
        int i13;
        String str6;
        int i14;
        int iFloor;
        int iFloor2;
        int i15;
        int i16;
        int iH;
        int i17;
        int i18 = s1.f.f7857b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int[] iArrI = i(qVar, options, bVar2, this.f6199a);
        boolean z8 = false;
        int i19 = iArrI[0];
        int i20 = iArrI[1];
        String str7 = options.outMimeType;
        if (i19 != -1 && i20 != -1) {
            z8 = z4;
        }
        int iD = qVar.d();
        switch (iD) {
            case 3:
            case 4:
                i5 = 180;
                break;
            case 5:
            case 6:
                i5 = 90;
                break;
            case 7:
            case 8:
                i5 = 270;
                break;
            default:
                i5 = 0;
                break;
        }
        boolean zF = t.f(iD);
        if (i2 == Integer.MIN_VALUE) {
            i6 = iD;
            iRound = j(i5) ? i20 : i19;
        } else {
            i6 = iD;
            iRound = i2;
        }
        int iRound2 = i4 == Integer.MIN_VALUE ? j(i5) ? i19 : i20 : i4;
        ImageHeaderParser.ImageType imageTypeB = qVar.b();
        Z0.d dVar = this.f6199a;
        String str8 = ", target density: ";
        boolean z9 = z8;
        String str9 = "x";
        if (i19 <= 0) {
            str = "Downsampler";
            str2 = ", density: ";
            str3 = "]";
            i7 = i20;
            i8 = i19;
            i9 = 3;
        } else {
            if (i20 > 0) {
                if (j(i5)) {
                    i13 = i19;
                    str6 = "]";
                    i14 = i20;
                } else {
                    i13 = i20;
                    str6 = "]";
                    i14 = i19;
                }
                float fB = jVar.b(i14, i13, iRound, iRound2);
                if (fB <= 0.0f) {
                    throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + jVar + ", source: [" + i19 + "x" + i20 + "], target: [" + iRound + "x" + iRound2 + str6);
                }
                int i21 = i5;
                int iA = jVar.a(i14, i13, iRound, iRound2);
                if (iA == 0) {
                    throw new IllegalArgumentException("Cannot round with null rounding");
                }
                float f4 = i14;
                float f5 = i13;
                int i22 = i14 / ((int) ((fB * f4) + 0.5d));
                int i23 = i13 / ((int) ((fB * f5) + 0.5d));
                int iMax = Math.max(1, Integer.highestOneBit(iA == 1 ? Math.max(i22, i23) : Math.min(i22, i23)));
                if (iA == 1 && iMax < 1.0f / fB) {
                    iMax <<= 1;
                }
                options.inSampleSize = iMax;
                if (imageTypeB == ImageHeaderParser.ImageType.JPEG) {
                    float fMin = Math.min(iMax, 8);
                    iFloor = (int) Math.ceil(f4 / fMin);
                    iFloor2 = (int) Math.ceil(f5 / fMin);
                    int i24 = iMax / 8;
                    if (i24 > 0) {
                        iFloor /= i24;
                        iFloor2 /= i24;
                    }
                } else if (imageTypeB == ImageHeaderParser.ImageType.PNG || imageTypeB == ImageHeaderParser.ImageType.PNG_A) {
                    float f6 = iMax;
                    iFloor = (int) Math.floor(f4 / f6);
                    iFloor2 = (int) Math.floor(f5 / f6);
                } else if (imageTypeB == ImageHeaderParser.ImageType.WEBP || imageTypeB == ImageHeaderParser.ImageType.WEBP_A) {
                    float f7 = iMax;
                    iFloor = Math.round(f4 / f7);
                    iFloor2 = Math.round(f5 / f7);
                } else {
                    if (i14 % iMax == 0 && i13 % iMax == 0) {
                        i15 = i14 / iMax;
                        i16 = i13 / iMax;
                        double dB = jVar.b(i15, i16, iRound, iRound2);
                        options.inTargetDensity = (int) (((dB / (r10 / r1)) * ((int) ((h(dB) * dB) + 0.5d))) + 0.5d);
                        iH = h(dB);
                        options.inDensity = iH;
                        i17 = options.inTargetDensity;
                        if (i17 <= 0 && iH > 0 && i17 != iH) {
                            options.inTargetDensity = 0;
                            options.inDensity = 0;
                        } else {
                            options.inScaled = true;
                        }
                        str = "Downsampler";
                        if (Log.isLoggable(str, 2)) {
                            str2 = ", density: ";
                            str8 = ", target density: ";
                            i7 = i20;
                            str9 = "x";
                            i8 = i19;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Calculate scaling, source: [");
                            i8 = i19;
                            sb.append(i8);
                            str9 = "x";
                            sb.append(str9);
                            i7 = i20;
                            sb.append(i7);
                            sb.append("], degreesToRotate: ");
                            sb.append(i21);
                            sb.append(", target: [");
                            sb.append(iRound);
                            sb.append(str9);
                            sb.append(iRound2);
                            sb.append("], power of two scaled: [");
                            sb.append(i15);
                            sb.append(str9);
                            sb.append(i16);
                            sb.append("], exact scale factor: ");
                            sb.append(fB);
                            sb.append(", power of 2 sample size: ");
                            sb.append(iMax);
                            sb.append(", adjusted scale factor: ");
                            sb.append(dB);
                            str8 = ", target density: ";
                            sb.append(str8);
                            sb.append(options.inTargetDensity);
                            str2 = ", density: ";
                            sb.append(str2);
                            sb.append(options.inDensity);
                            Log.v(str, sb.toString());
                        }
                        i9 = 3;
                        int i25 = i9;
                        str4 = str;
                        zB = this.f6202e.b(iRound, iRound2, z9, zF);
                        if (zB) {
                            options.inPreferredConfig = Bitmap.Config.HARDWARE;
                            z6 = false;
                            options.inMutable = false;
                        } else {
                            z6 = false;
                        }
                        if (!zB) {
                            str5 = str8;
                            if (bVar != V0.b.f1752i) {
                                try {
                                    zHasAlpha = qVar.b().hasAlpha();
                                } catch (IOException e2) {
                                    if (Log.isLoggable(str4, i25)) {
                                        Log.d(str4, "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
                                    }
                                    zHasAlpha = z6;
                                }
                                Bitmap.Config config2 = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                                options.inPreferredConfig = config2;
                                if (config2 == Bitmap.Config.RGB_565) {
                                    z7 = true;
                                    options.inDither = true;
                                }
                            } else {
                                z7 = true;
                                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                            }
                            i10 = options.inSampleSize;
                            if (i8 >= 0 || i7 < 0 || !z5) {
                                i11 = options.inTargetDensity;
                                if (i11 > 0 || (i12 = options.inDensity) <= 0 || i11 == i12) {
                                    z7 = z6;
                                }
                                float f8 = z7 ? i11 / options.inDensity : 1.0f;
                                float f9 = i10;
                                int iCeil = (int) Math.ceil(i8 / f9);
                                int iCeil2 = (int) Math.ceil(i7 / f9);
                                iRound = Math.round(iCeil * f8);
                                iRound2 = Math.round(iCeil2 * f8);
                                if (Log.isLoggable(str4, 2)) {
                                    Log.v(str4, "Calculated target [" + iRound + str9 + iRound2 + "] for source [" + i8 + str9 + i7 + "], sampleSize: " + i10 + ", targetDensity: " + options.inTargetDensity + str2 + options.inDensity + ", density multiplier: " + f8);
                                }
                            }
                            if (iRound > 0 && iRound2 > 0) {
                                Z0.d dVar2 = this.f6199a;
                                config = options.inPreferredConfig;
                                if (config != Bitmap.Config.HARDWARE) {
                                    Bitmap.Config config3 = options.outConfig;
                                    if (config3 != null) {
                                        config = config3;
                                    }
                                    options.inBitmap = dVar2.c(iRound, iRound2, config);
                                }
                            }
                            if (iVar == V0.i.f1765j && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                                z6 = true;
                            }
                            options.inPreferredColorSpace = ColorSpace.get(!z6 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
                            bitmapF = f(qVar, options, bVar2, this.f6199a);
                            bVar2.a(this.f6199a, bitmapF);
                            if (Log.isLoggable(str4, 2)) {
                                StringBuilder sbD = D2.e.d("Decoded ");
                                sbD.append(g(bitmapF));
                                sbD.append(" from [");
                                sbD.append(i8);
                                sbD.append(str9);
                                sbD.append(i7);
                                sbD.append("] ");
                                sbD.append(str7);
                                sbD.append(" with inBitmap ");
                                sbD.append(g(options.inBitmap));
                                sbD.append(" for [");
                                sbD.append(i2);
                                sbD.append(str9);
                                sbD.append(i4);
                                sbD.append("], sample size: ");
                                sbD.append(options.inSampleSize);
                                sbD.append(str2);
                                sbD.append(options.inDensity);
                                sbD.append(str5);
                                sbD.append(options.inTargetDensity);
                                sbD.append(", thread: ");
                                sbD.append(Thread.currentThread().getName());
                                sbD.append(", duration: ");
                                sbD.append(s1.f.a(jElapsedRealtimeNanos));
                                Log.v(str4, sbD.toString());
                            }
                            Bitmap bitmapG = null;
                            if (bitmapF != null) {
                                bitmapF.setDensity(this.f6200b.densityDpi);
                                bitmapG = t.g(this.f6199a, bitmapF, i6);
                                if (!bitmapF.equals(bitmapG)) {
                                    this.f6199a.e(bitmapF);
                                }
                            }
                            return bitmapG;
                        }
                        str5 = str8;
                        z7 = true;
                        i10 = options.inSampleSize;
                        if (i8 >= 0) {
                            i11 = options.inTargetDensity;
                            if (i11 > 0) {
                                z7 = z6;
                                float f82 = z7 ? i11 / options.inDensity : 1.0f;
                                float f92 = i10;
                                int iCeil3 = (int) Math.ceil(i8 / f92);
                                int iCeil22 = (int) Math.ceil(i7 / f92);
                                iRound = Math.round(iCeil3 * f82);
                                iRound2 = Math.round(iCeil22 * f82);
                                if (Log.isLoggable(str4, 2)) {
                                }
                            }
                        }
                        if (iRound > 0) {
                            Z0.d dVar22 = this.f6199a;
                            config = options.inPreferredConfig;
                            if (config != Bitmap.Config.HARDWARE) {
                            }
                        }
                        if (iVar == V0.i.f1765j) {
                            z6 = true;
                        }
                        options.inPreferredColorSpace = ColorSpace.get(!z6 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
                        bitmapF = f(qVar, options, bVar2, this.f6199a);
                        bVar2.a(this.f6199a, bitmapF);
                        if (Log.isLoggable(str4, 2)) {
                        }
                        Bitmap bitmapG2 = null;
                        if (bitmapF != null) {
                        }
                        return bitmapG2;
                    }
                    int[] iArrI2 = i(qVar, options, bVar2, dVar);
                    iFloor = iArrI2[0];
                    iFloor2 = iArrI2[1];
                }
                i16 = iFloor2;
                i15 = iFloor;
                double dB2 = jVar.b(i15, i16, iRound, iRound2);
                options.inTargetDensity = (int) (((dB2 / (r10 / r1)) * ((int) ((h(dB2) * dB2) + 0.5d))) + 0.5d);
                iH = h(dB2);
                options.inDensity = iH;
                i17 = options.inTargetDensity;
                if (i17 <= 0) {
                    if (i17 <= 0 && iH > 0 && i17 != iH) {
                    }
                    str = "Downsampler";
                    if (Log.isLoggable(str, 2)) {
                    }
                    i9 = 3;
                }
                int i252 = i9;
                str4 = str;
                zB = this.f6202e.b(iRound, iRound2, z9, zF);
                if (zB) {
                }
                if (!zB) {
                }
                z7 = true;
                i10 = options.inSampleSize;
                if (i8 >= 0) {
                }
                if (iRound > 0) {
                }
                if (iVar == V0.i.f1765j) {
                }
                options.inPreferredColorSpace = ColorSpace.get(!z6 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
                bitmapF = f(qVar, options, bVar2, this.f6199a);
                bVar2.a(this.f6199a, bitmapF);
                if (Log.isLoggable(str4, 2)) {
                }
                Bitmap bitmapG22 = null;
                if (bitmapF != null) {
                }
                return bitmapG22;
            }
            i9 = 3;
            str = "Downsampler";
            str2 = ", density: ";
            str3 = "]";
            i7 = i20;
            i8 = i19;
        }
        if (Log.isLoggable(str, i9)) {
            Log.d(str, "Unable to determine dimensions for: " + imageTypeB + " with target [" + iRound + "x" + iRound2 + str3);
        }
        int i2522 = i9;
        str4 = str;
        zB = this.f6202e.b(iRound, iRound2, z9, zF);
        if (zB) {
        }
        if (!zB) {
        }
        z7 = true;
        i10 = options.inSampleSize;
        if (i8 >= 0) {
        }
        if (iRound > 0) {
        }
        if (iVar == V0.i.f1765j) {
        }
        options.inPreferredColorSpace = ColorSpace.get(!z6 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        bitmapF = f(qVar, options, bVar2, this.f6199a);
        bVar2.a(this.f6199a, bitmapF);
        if (Log.isLoggable(str4, 2)) {
        }
        Bitmap bitmapG222 = null;
        if (bitmapF != null) {
        }
        return bitmapG222;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap f(q qVar, BitmapFactory.Options options, b bVar, Z0.d dVar) throws IOException {
        Bitmap bitmapF;
        if (!options.inJustDecodeBounds) {
            bVar.b();
            qVar.c();
        }
        int i2 = options.outWidth;
        int i4 = options.outHeight;
        String str = options.outMimeType;
        t.d().lock();
        try {
            try {
                bitmapF = qVar.a(options);
            } catch (IllegalArgumentException e2) {
                IOException iOExceptionK = k(e2, i2, i4, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOExceptionK);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw iOExceptionK;
                }
                try {
                    dVar.e(bitmap);
                    options.inBitmap = null;
                    bitmapF = f(qVar, options, bVar, dVar);
                } catch (IOException unused) {
                    throw iOExceptionK;
                }
            }
            return bitmapF;
        } finally {
            t.d().unlock();
        }
    }

    @TargetApi(19)
    private static String g(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder sbD = D2.e.d(" (");
        sbD.append(bitmap.getAllocationByteCount());
        sbD.append(")");
        String string = sbD.toString();
        StringBuilder sbD2 = D2.e.d("[");
        sbD2.append(bitmap.getWidth());
        sbD2.append("x");
        sbD2.append(bitmap.getHeight());
        sbD2.append("] ");
        sbD2.append(bitmap.getConfig());
        sbD2.append(string);
        return sbD2.toString();
    }

    private static int h(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int[] i(q qVar, BitmapFactory.Options options, b bVar, Z0.d dVar) throws IOException {
        options.inJustDecodeBounds = true;
        f(qVar, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static boolean j(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static IOException k(IllegalArgumentException illegalArgumentException, int i2, int i4, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i4 + ", outMimeType: " + str + ", inBitmap: " + g(options.inBitmap), illegalArgumentException);
    }

    private static void l(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final x<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i4, V0.h hVar) throws IOException {
        return b(new q.b(parcelFileDescriptor, this.d, this.f6201c), i2, i4, hVar, f6197j);
    }

    public final x<Bitmap> c(InputStream inputStream, int i2, int i4, V0.h hVar) throws IOException {
        return b(new q.a(inputStream, this.d, this.f6201c), i2, i4, hVar, f6197j);
    }

    public final x<Bitmap> d(InputStream inputStream, int i2, int i4, V0.h hVar, b bVar) throws IOException {
        return b(new q.a(inputStream, this.d, this.f6201c), i2, i4, hVar, bVar);
    }
}
