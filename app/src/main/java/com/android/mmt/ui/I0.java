package com.android.mmt.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import g0.C0307c;
import g0.C0318n;
import g0.C0319o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class I0 extends C0318n {

    /* renamed from: l, reason: collision with root package name */
    private static Handler f4852l = new Handler(Looper.getMainLooper());
    private int g = -1;

    /* renamed from: h, reason: collision with root package name */
    private Context f4853h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f4854i;

    /* renamed from: j, reason: collision with root package name */
    private a f4855j;

    /* renamed from: k, reason: collision with root package name */
    private List<b> f4856k;

    private static class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<I0> f4857i;

        /* renamed from: j, reason: collision with root package name */
        public AtomicInteger f4858j;

        a(I0 i02) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            this.f4858j = atomicInteger;
            atomicInteger.set(0);
            this.f4857i = new WeakReference<>(i02);
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            WeakReference<I0> weakReference = this.f4857i;
            I0 i02 = weakReference == null ? null : weakReference.get();
            if (i02 == null) {
                Log.d("SimplePduPart", "can't start loading process");
                this.f4858j.set(0);
                return;
            }
            Drawable drawableA = i02.A();
            Log.d("SimplePduPart", "get drawable result: " + drawableA);
            if (drawableA != null) {
                this.f4858j.set(2);
                I0.f4852l.post(new H0(i02, drawableA));
            } else {
                Log.d("SimplePduPart", "load failed");
                this.f4858j.set(0);
            }
        }
    }

    public interface b {
        void a(Drawable drawable);
    }

    I0(Context context) {
        this.f4853h = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0079 A[Catch: OutOfMemoryError -> 0x0082, PHI: r3
      0x0079: PHI (r3v9 java.io.InputStream) = (r3v8 java.io.InputStream), (r3v12 java.io.InputStream), (r3v14 java.io.InputStream) binds: [B:27:0x0074, B:9:0x0025, B:17:0x0050] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #4 {OutOfMemoryError -> 0x0082, blocks: (B:5:0x0007, B:19:0x0068, B:28:0x0079, B:30:0x007e, B:31:0x0081), top: B:47:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable A() throws Throwable {
        InputStream inputStreamOpenInputStream;
        int iMax;
        if (this.f4854i == null) {
            Drawable drawable = null;
            try {
                Uri uriI = i();
                T2.c cVar = new T2.c();
                if (cVar.a(this.f4853h, uriI)) {
                    drawable = cVar;
                } else {
                    try {
                        inputStreamOpenInputStream = this.f4853h.getContentResolver().openInputStream(uriI);
                    } catch (IOException e2) {
                        e = e2;
                        inputStreamOpenInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamOpenInputStream = null;
                        S2.d.c(inputStreamOpenInputStream);
                        throw th;
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                                int i2 = options.outHeight;
                                iMax = i2 > 300 ? i2 / 300 : 1;
                                int i4 = options.outWidth;
                                if (i4 > 300) {
                                    iMax = Math.max(iMax, i4 / 300);
                                }
                                S2.d.c(inputStreamOpenInputStream);
                                inputStreamOpenInputStream = this.f4853h.getContentResolver().openInputStream(uriI);
                            } catch (IOException e4) {
                                e = e4;
                                Log.e("SimplePduPart", "Cannot extract image from data", e);
                                S2.d.c(inputStreamOpenInputStream);
                                this.f4854i = drawable;
                                return this.f4854i;
                            }
                            if (inputStreamOpenInputStream != null) {
                                BitmapFactory.Options options2 = new BitmapFactory.Options();
                                options2.inSampleSize = iMax;
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f4853h.getResources(), BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options2));
                                S2.d.c(inputStreamOpenInputStream);
                                drawable = bitmapDrawable;
                            } else {
                                S2.d.c(inputStreamOpenInputStream);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            S2.d.c(inputStreamOpenInputStream);
                            throw th;
                        }
                    }
                }
            } catch (OutOfMemoryError e5) {
                int i5 = P0.r.f937c;
                String str = Environment.getExternalStorageDirectory() + "/mms_oom_hprof_data";
                try {
                    Debug.dumpHprofData(str);
                    Log.i("Mms", "##### written hprof data to " + str);
                } catch (IOException e6) {
                    Log.e("Mms", "writeHprofDataToFile: caught " + e6);
                }
                Log.e("SimplePduPart", "Not enough memory.", e5);
            }
            this.f4854i = drawable;
        }
        return this.f4854i;
    }

    public final Intent B() {
        String str;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(i(), C0319o.r(g()));
        if (this.g == 1) {
            str = P0.r.b(this.f4853h) ? "com.google.android.apps.photos" : "com.google.android.apps.photosgo";
            intent.putExtra("com.miui.gallery.extra.preview_single_item", true);
        } else {
            str = null;
        }
        String strC = C();
        if (!TextUtils.isEmpty(strC)) {
            intent.putExtra("display_name", strC);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return intent;
    }

    public final String C() {
        byte[] bArrE = e();
        if (bArrE != null && bArrE.length > 0) {
            return new String(bArrE);
        }
        byte[] bArrD = d();
        if (bArrD != null && bArrD.length > 0) {
            return new String(bArrD);
        }
        byte[] bArrJ = j();
        if (bArrJ != null && bArrJ.length > 0) {
            return new String(bArrJ);
        }
        byte[] bArrK = k();
        if (bArrK == null || bArrK.length <= 0) {
            return null;
        }
        return new String(bArrK);
    }

    public final String D() {
        byte[] bArrH;
        if (!E() || (bArrH = h()) == null) {
            return "";
        }
        try {
            return b() == 0 ? new String(bArrH) : new String(bArrH, C0307c.b(b()));
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrH);
        }
    }

    final boolean E() throws IOException {
        if (h() != null) {
            return true;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = this.f4853h.getContentResolver().openInputStream(i());
            if (inputStreamOpenInputStream == null) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            byte[] bArr = new byte[256];
            for (int i2 = inputStreamOpenInputStream.read(bArr); i2 >= 0; i2 = inputStreamOpenInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            try {
                inputStreamOpenInputStream.close();
            } catch (IOException unused2) {
            }
            r(byteArrayOutputStream.toByteArray());
            return true;
        } catch (IOException unused3) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public final void F() {
        if (this.f4855j == null) {
            this.f4855j = new a(this);
        }
        StringBuilder sbD = D2.e.d("load image with runer: ");
        sbD.append(this.f4855j);
        Log.d("SimplePduPart", sbD.toString());
        if (this.f4855j.f4858j.get() != 1) {
            this.f4855j.f4858j.set(1);
            Q2.c.a(this.f4855j);
        }
    }

    public final void G(int i2) {
        this.g = i2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.I0$b>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<com.android.mmt.ui.I0$b>] */
    public final void x(b bVar) {
        if (this.f4856k == null) {
            this.f4856k = new ArrayList();
        }
        if (this.f4856k.contains(bVar)) {
            return;
        }
        this.f4856k.add(bVar);
    }

    public final int y() {
        return this.g;
    }

    public final Drawable z() {
        return this.f4854i;
    }
}
