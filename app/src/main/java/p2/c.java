package p2;

import V0.d;
import V0.h;
import V0.k;
import Y0.x;
import android.os.Bundle;
import android.util.Log;
import f2.a;
import g1.b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c implements d, k, k1.d, a {

    /* renamed from: a, reason: collision with root package name */
    public final int f7586a;

    public /* synthetic */ c(int i2) {
        this.f7586a = i2;
    }

    @Override // V0.k
    public V0.c a(h hVar) {
        return V0.c.SOURCE;
    }

    @Override // V0.d
    public boolean b(Object obj, File file, h hVar) throws Throwable {
        switch (this.f7586a) {
            case 1:
                try {
                    s1.a.c((ByteBuffer) obj, file);
                    break;
                } catch (IOException e2) {
                    if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                        return false;
                    }
                    Log.d("ByteBufferEncoder", "Failed to write data", e2);
                    return false;
                }
            default:
                try {
                    s1.a.c(((j1.c) ((x) obj).get()).b(), file);
                    break;
                } catch (IOException e4) {
                    if (!Log.isLoggable("GifEncoder", 5)) {
                        return false;
                    }
                    Log.w("GifEncoder", "Failed to encode GIF drawable data", e4);
                    return false;
                }
        }
        return false;
    }

    @Override // f2.a
    public void c(Bundle bundle) {
    }

    @Override // k1.d
    public x d(x xVar, h hVar) {
        return new b(s1.a.b(((j1.c) xVar.get()).b()));
    }
}
