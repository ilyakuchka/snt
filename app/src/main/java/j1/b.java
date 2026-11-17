package j1;

import U0.a;
import android.graphics.Bitmap;

/* loaded from: classes.dex */
public final class b implements a.InterfaceC0041a {

    /* renamed from: a, reason: collision with root package name */
    private final Z0.d f6368a;

    /* renamed from: b, reason: collision with root package name */
    private final Z0.b f6369b;

    public b(Z0.d dVar, Z0.b bVar) {
        this.f6368a = dVar;
        this.f6369b = bVar;
    }

    public final Bitmap a(int i2, int i4, Bitmap.Config config) {
        return this.f6368a.c(i2, i4, config);
    }

    public final byte[] b(int i2) {
        Z0.b bVar = this.f6369b;
        return bVar == null ? new byte[i2] : (byte[]) bVar.d(i2, byte[].class);
    }

    public final int[] c(int i2) {
        Z0.b bVar = this.f6369b;
        return bVar == null ? new int[i2] : (int[]) bVar.d(i2, int[].class);
    }

    public final void d(Bitmap bitmap) {
        this.f6368a.e(bitmap);
    }

    public final void e(byte[] bArr) {
        Z0.b bVar = this.f6369b;
        if (bVar == null) {
            return;
        }
        bVar.c(bArr);
    }

    public final void f(int[] iArr) {
        Z0.b bVar = this.f6369b;
        if (bVar == null) {
            return;
        }
        bVar.c(iArr);
    }
}
