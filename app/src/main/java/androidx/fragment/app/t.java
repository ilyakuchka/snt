package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import t.C0384b;
import w.C0405a;

/* loaded from: classes.dex */
public abstract class t<E> extends O.d {

    /* renamed from: i, reason: collision with root package name */
    private final Activity f3579i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f3580j;

    /* renamed from: k, reason: collision with root package name */
    private final Handler f3581k;

    /* renamed from: l, reason: collision with root package name */
    final w f3582l;

    t(ActivityC0219o activityC0219o) {
        Handler handler = new Handler();
        this.f3582l = new x();
        this.f3579i = activityC0219o;
        C0384b.i(activityC0219o, "context == null");
        this.f3580j = activityC0219o;
        this.f3581k = handler;
    }

    final Activity i() {
        return this.f3579i;
    }

    final Context j() {
        return this.f3580j;
    }

    final Handler k() {
        return this.f3581k;
    }

    public abstract E l();

    public abstract LayoutInflater m();

    public final void n(@SuppressLint({"UnknownNullness"}) Intent intent) {
        Context context = this.f3580j;
        int i2 = C0405a.f7979b;
        context.startActivity(intent, null);
    }

    public abstract void o();
}
