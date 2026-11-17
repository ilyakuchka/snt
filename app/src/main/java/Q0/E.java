package Q0;

import android.view.View;
import com.android.mmt.ui.ComposeMessageRouterActivity;

/* loaded from: classes.dex */
final class E implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ F f1069i;

    E(F f4) {
        this.f1069i = f4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        F f4 = this.f1069i;
        int i2 = F.f1070F0;
        ComposeMessageRouterActivity.e(f4.x(), ComposeMessageRouterActivity.a(f4.x(), 0L));
    }
}
