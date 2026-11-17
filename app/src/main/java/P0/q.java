package P0;

import android.content.Context;
import android.content.DialogInterface;
import com.android.mmt.R;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
final class q implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f931i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f932j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f933k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnCancelListener f934l;

    q(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        this.f931i = context;
        this.f932j = onClickListener;
        this.f933k = onClickListener2;
        this.f934l = onCancelListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f931i;
        DialogInterface.OnClickListener onClickListener = this.f932j;
        DialogInterface.OnClickListener onClickListener2 = this.f933k;
        DialogInterface.OnCancelListener onCancelListener = this.f934l;
        g.a aVar = new g.a(context);
        aVar.c(true);
        aVar.x(R.string.confirm);
        aVar.j(R.string.message_send_read_report);
        aVar.t(R.string.yes, onClickListener);
        aVar.m(R.string.no, onClickListener2);
        aVar.p(onCancelListener);
        aVar.A();
    }
}
