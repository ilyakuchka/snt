package r1;

import D2.e;
import V0.f;
import java.security.MessageDigest;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b implements f {

    /* renamed from: b, reason: collision with root package name */
    private final Object f7692b;

    public b(Object obj) {
        Objects.requireNonNull(obj, "Argument must not be null");
        this.f7692b = obj;
    }

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(this.f7692b.toString().getBytes(f.f1758a));
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f7692b.equals(((b) obj).f7692b);
        }
        return false;
    }

    @Override // V0.f
    public final int hashCode() {
        return this.f7692b.hashCode();
    }

    public final String toString() {
        StringBuilder sbD = e.d("ObjectKey{object=");
        sbD.append(this.f7692b);
        sbD.append('}');
        return sbD.toString();
    }
}
