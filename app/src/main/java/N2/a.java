package N2;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class a extends DialogInterfaceOnCancelListenerC0216l {

    /* renamed from: r0, reason: collision with root package name */
    private String f726r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f727s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f728t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f729u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f730v0;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        Bundle bundleZ = z();
        if (bundleZ != null) {
            this.f726r0 = bundleZ.getString("MESSAGE_TYPE");
            this.f727s0 = bundleZ.getString("TITLE");
            this.f728t0 = bundleZ.getString("POSITIVE_MESSAGE");
            this.f729u0 = bundleZ.getString("NEGATIVE_MESSAGE");
            this.f730v0 = bundleZ.getBoolean("CANCELABLE");
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
    public final Dialog e1(Bundle bundle) {
        g.a aVar = new g.a(x());
        aVar.c(this.f730v0);
        aVar.k(this.f726r0);
        aVar.y(this.f727s0);
        aVar.u(this.f728t0, null);
        aVar.n(this.f729u0, null);
        return aVar.a();
    }
}
