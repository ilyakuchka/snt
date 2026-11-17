package G0;

import P0.M;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import f0.C0303b;
import g0.C0318n;
import g0.C0319o;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import k0.C0341b;

/* loaded from: classes.dex */
public final class i extends m {

    /* renamed from: w, reason: collision with root package name */
    private static final Set<String> f157w = new HashSet(Arrays.asList("image/jpeg"));

    /* renamed from: s, reason: collision with root package name */
    private int f158s;

    /* renamed from: t, reason: collision with root package name */
    private int f159t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private SoftReference<Drawable> f160v;

    public i(Context context, Uri uri, n nVar) throws C0303b, C0341b {
        super(context, uri);
        this.f160v = new SoftReference<>(null);
        M m2 = new M(this.f166j, uri);
        String strB = m2.b();
        this.f171o = strB;
        if (TextUtils.isEmpty(strB)) {
            throw new C0303b("Type of media is unknown.");
        }
        C(m2.f());
        this.f158s = m2.g();
        this.f159t = m2.c();
        this.u = m2.e();
        ((b) f.d()).b(this.f171o);
    }

    @SuppressLint({"LogTagMismatch"})
    private Drawable E(Uri uri) {
        int i2;
        int i4;
        int i5 = this.f158s;
        int i6 = this.f159t;
        int i7 = 1;
        while (true) {
            i2 = i5 / i7;
            if (i2 <= 480 && (i4 = i6 / i7) <= 480) {
                break;
            }
            i7 *= 2;
        }
        if (Log.isLoggable("Mms:app", 2)) {
            Log.v("Mms/image", "createThumbnailBitmap: scale=" + i7 + ", w=" + i2 + ", h=" + i4);
        }
        try {
            try {
                T2.c cVar = new T2.c();
                if (cVar.a(this.f166j, uri)) {
                    return cVar;
                }
                Bitmap bitmapA = new M(this.f166j, uri).a(i7);
                if (bitmapA == null) {
                    return null;
                }
                return new BitmapDrawable(this.f166j.getResources(), bitmapA);
            } catch (OutOfMemoryError e2) {
                throw e2;
            }
        } catch (C0303b e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    @Override // G0.k
    @SuppressLint({"LogTagMismatch"})
    protected final void A(int i2, long j2) throws Throwable {
        M m2 = new M(this.f166j, u());
        int i4 = k0.d.i();
        int iH = k0.d.h();
        int i5 = this.f173r;
        if (m2.c() > m2.g()) {
            iH = i4;
            i4 = iH;
        }
        if (Log.isLoggable("Mms:app", 2)) {
            StringBuilder sbC = C2.c.c("resizeMedia size: ", i5, " image.getWidth(): ");
            sbC.append(m2.g());
            sbC.append(" widthLimit: ");
            sbC.append(i4);
            sbC.append(" image.getHeight(): ");
            sbC.append(m2.c());
            sbC.append(" heightLimit: ");
            sbC.append(iH);
            sbC.append(" image.getContentType(): ");
            sbC.append(m2.b());
            Log.v("Mms/image", sbC.toString());
        }
        if (i5 != 0 && i5 <= i2 && m2.g() <= i4 && m2.c() <= iH && f157w.contains(m2.b())) {
            if (Log.isLoggable("Mms:app", 2)) {
                Log.v("Mms/image", "resizeMedia - already sized");
                return;
            }
            return;
        }
        C0318n c0318nD = m2.d(i4, iH, i2);
        if (c0318nD == null) {
            StringBuilder sbD = D2.e.d("Not enough memory to turn image into part: ");
            sbD.append(u());
            throw new k0.c(sbD.toString());
        }
        this.f171o = new String(c0318nD.g());
        String str = this.f170n;
        byte[] bytes = str.getBytes();
        c0318nD.o(bytes);
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf != -1) {
            bytes = str.substring(0, iLastIndexOf).getBytes();
        }
        c0318nD.n(bytes);
        C0319o c0319oE = C0319o.e(this.f166j.getApplicationContext());
        this.f173r = c0318nD.h().length;
        if (Log.isLoggable("Mms:app", 2)) {
            StringBuilder sbD2 = D2.e.d("resizeMedia mSize: ");
            sbD2.append(this.f173r);
            Log.v("Mms/image", sbD2.toString());
        }
        D(c0319oE.q(c0318nD, j2));
    }

    public final Drawable F() {
        Uri uriU = u();
        Drawable drawableE = this.f160v.get();
        if (drawableE == null) {
            try {
                drawableE = E(uriU);
                if (drawableE != null) {
                    this.f160v = new SoftReference<>(drawableE);
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return drawableE;
    }

    public final int G() {
        return this.u;
    }

    public i(Context context, String str, String str2, Uri uri, n nVar) throws C0303b {
        super(context, "img", str, str2, uri);
        this.f160v = new SoftReference<>(null);
        M m2 = new M(this.f166j, uri);
        this.f158s = m2.g();
        this.f159t = m2.c();
        this.u = m2.e();
    }
}
