package g1;

import Y0.x;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b implements x<byte[]> {

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f6300i;

    public b(byte[] bArr) {
        Objects.requireNonNull(bArr, "Argument must not be null");
        this.f6300i = bArr;
    }

    @Override // Y0.x
    public final int b() {
        return this.f6300i.length;
    }

    @Override // Y0.x
    public final Class<byte[]> c() {
        return byte[].class;
    }

    @Override // Y0.x
    public final void d() {
    }

    @Override // Y0.x
    public final byte[] get() {
        return this.f6300i;
    }
}
