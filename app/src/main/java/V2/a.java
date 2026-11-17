package V2;

import D2.e;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.mmt.ui.ComposeMessageRouterActivity;
import x0.C0414a;

/* loaded from: classes.dex */
public final class a extends b {
    public a(long j2, C0414a c0414a, long j4, String str) {
        super(j2, c0414a, j4);
    }

    @Override // V2.b
    public final Intent a(Context context) {
        return ComposeMessageRouterActivity.a(context, this.f1766a);
    }

    @Override // V2.b
    public final void b() {
    }

    @Override // V2.b
    public final Uri c() {
        C0414a c0414a = this.f1767b;
        if (c0414a != null) {
            return c0414a.Y();
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass() && this.f1766a == ((a) obj).f1766a;
    }

    public final int hashCode() {
        StringBuilder sbD = e.d("MmsThread");
        sbD.append(this.f1766a);
        return sbD.toString().hashCode();
    }
}
