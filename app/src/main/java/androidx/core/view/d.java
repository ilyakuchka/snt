package androidx.core.view;

import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3302a;

    private d(Object obj) {
        this.f3302a = obj;
    }

    static d a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new d(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f3302a, ((d) obj).f3302a);
    }

    public final int hashCode() {
        Object obj = this.f3302a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("DisplayCutoutCompat{");
        sbD.append(this.f3302a);
        sbD.append("}");
        return sbD.toString();
    }
}
