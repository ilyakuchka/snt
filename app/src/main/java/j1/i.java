package j1;

import V0.j;
import Y0.x;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements j<InputStream, c> {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f6403a;

    /* renamed from: b, reason: collision with root package name */
    private final j<ByteBuffer, c> f6404b;

    /* renamed from: c, reason: collision with root package name */
    private final Z0.b f6405c;

    public i(List<ImageHeaderParser> list, j<ByteBuffer, c> jVar, Z0.b bVar) {
        this.f6403a = list;
        this.f6404b = jVar;
        this.f6405c = bVar;
    }

    @Override // V0.j
    public final boolean a(InputStream inputStream, V0.h hVar) throws IOException {
        return !((Boolean) hVar.c(h.f6402b)).booleanValue() && com.bumptech.glide.load.a.e(this.f6403a, inputStream, this.f6405c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // V0.j
    public final x<c> b(InputStream inputStream, int i2, int i4, V0.h hVar) throws IOException {
        byte[] byteArray;
        InputStream inputStream2 = inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i5 = inputStream2.read(bArr);
                if (i5 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i5);
            }
            byteArrayOutputStream.flush();
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            }
            byteArray = null;
        }
        if (byteArray == null) {
            return null;
        }
        return this.f6404b.b(ByteBuffer.wrap(byteArray), i2, i4, hVar);
    }
}
