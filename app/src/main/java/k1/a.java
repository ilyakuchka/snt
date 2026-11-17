package k1;

import V0.h;
import Y0.x;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class a implements d<Bitmap, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f6437a = Bitmap.CompressFormat.JPEG;

    /* renamed from: b, reason: collision with root package name */
    private final int f6438b = 100;

    @Override // k1.d
    public final x<byte[]> d(x<Bitmap> xVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xVar.get().compress(this.f6437a, this.f6438b, byteArrayOutputStream);
        xVar.d();
        return new g1.b(byteArrayOutputStream.toByteArray());
    }
}
