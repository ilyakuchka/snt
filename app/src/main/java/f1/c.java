package f1;

import Y0.x;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c implements V0.k<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    public static final V0.g<Integer> f6174b = V0.g.d("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c, reason: collision with root package name */
    public static final V0.g<Bitmap.CompressFormat> f6175c = V0.g.c();

    /* renamed from: a, reason: collision with root package name */
    private final Z0.b f6176a;

    public c(Z0.b bVar) {
        this.f6176a = bVar;
    }

    @Override // V0.k
    public final V0.c a(V0.h hVar) {
        return V0.c.TRANSFORMED;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|2|(2:5|(1:7)(1:8))|9|46|10|11|(2:49|12)|(5:53|13|(2:15|16)(1:17)|18|19)|50|32|33|34|(1:36)|37|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075 A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #1 {, blocks: (B:10:0x0026, B:32:0x006b, B:34:0x006f, B:36:0x0075, B:40:0x00bf, B:41:0x00c2), top: B:46:0x0026 }] */
    @Override // V0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(Object obj, File file, V0.h hVar) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap = (Bitmap) ((x) obj).get();
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) hVar.c(f6175c);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        int i2 = s1.f.f7857b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int iIntValue = ((Integer) hVar.c(f6174b)).intValue();
        boolean z4 = false;
        OutputStream cVar = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            cVar = this.f6176a != null ? new W0.c(fileOutputStream, this.f6176a) : fileOutputStream;
            bitmap.compress(compressFormat, iIntValue, cVar);
            cVar.close();
            z4 = true;
        } catch (IOException e4) {
            e = e4;
            cVar = fileOutputStream;
            if (Log.isLoggable("BitmapEncoder", 3)) {
                Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
            }
            if (cVar != null) {
                cVar.close();
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
            }
            return z4;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
            }
            throw th;
        }
        cVar.close();
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + s1.j.d(bitmap) + " in " + s1.f.a(jElapsedRealtimeNanos) + ", options format: " + hVar.c(f6175c) + ", hasAlpha: " + bitmap.hasAlpha());
        }
        return z4;
    }
}
