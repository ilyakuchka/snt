package f1;

import Y0.x;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f implements V0.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6180a;

    /* renamed from: b, reason: collision with root package name */
    private final k f6181b;

    public /* synthetic */ f(k kVar, int i2) {
        this.f6180a = i2;
        this.f6181b = kVar;
    }

    @Override // V0.j
    public final boolean a(Object obj, V0.h hVar) {
        switch (this.f6180a) {
            case 0:
                Objects.requireNonNull(this.f6181b);
                break;
            default:
                Objects.requireNonNull(this.f6181b);
                break;
        }
        return true;
    }

    @Override // V0.j
    public final x b(Object obj, int i2, int i4, V0.h hVar) {
        switch (this.f6180a) {
            case 0:
                return this.f6181b.c(s1.a.d((ByteBuffer) obj), i2, i4, hVar);
            default:
                return this.f6181b.a((ParcelFileDescriptor) obj, i2, i4, hVar);
        }
    }
}
