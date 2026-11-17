package r3;

import android.R;
import z3.C0431a;

/* renamed from: r3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0377a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7693i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ C0378b f7694j;

    public /* synthetic */ RunnableC0377a(C0378b c0378b, int i2) {
        this.f7693i = i2;
        this.f7694j = c0378b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7693i) {
            case 0:
                C0378b c0378b = this.f7694j;
                c0378b.f7696b.setBackground(C0431a.e(c0378b.f7695a, R.attr.actionBarItemBackground));
                break;
            case 1:
                this.f7694j.d.setBackgroundResource(com.android.mmt.R.drawable.miuix_appcompat_action_bar_subtitle_bg_land);
                break;
            case 2:
                C0378b.d(this.f7694j);
                break;
            default:
                C0378b.b(this.f7694j);
                break;
        }
    }
}
