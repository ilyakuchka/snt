package c1;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class t implements V0.d<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Z0.b f4449a;

    public t(Z0.b bVar) {
        this.f4449a = bVar;
    }

    @Override // V0.d
    public final boolean b(InputStream inputStream, File file, V0.h hVar) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStream2 = inputStream;
        byte[] bArr = (byte[]) this.f4449a.d(65536, byte[].class);
        boolean z4 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int i2 = inputStream2.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i2);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream2 = fileOutputStream;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            this.f4449a.c(bArr);
                            return z4;
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f4449a.c(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream.close();
                    z4 = true;
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            } catch (IOException e4) {
                e = e4;
            }
            this.f4449a.c(bArr);
            return z4;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }
}
