package P0;

import android.content.Context;
import android.content.DialogInterface;
import java.util.Map;

/* loaded from: classes.dex */
final class n implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Map f924i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ Context f925j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ int f926k = 129;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ Map f927l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Runnable f928m;

    n(Map map, Context context, Map map2, Runnable runnable) {
        this.f924i = map;
        this.f925j = context;
        this.f927l = map2;
        this.f928m = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        for (Map.Entry entry : this.f924i.entrySet()) {
            O0.e.b(this.f925j, (String) entry.getValue(), (String) entry.getKey(), this.f926k, ((Long) this.f927l.get(entry.getKey())).longValue());
        }
        Runnable runnable = this.f928m;
        if (runnable != null) {
            runnable.run();
        }
        dialogInterface.dismiss();
    }
}
