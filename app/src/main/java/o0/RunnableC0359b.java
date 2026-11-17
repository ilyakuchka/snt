package o0;

import android.R;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import miuix.appcompat.widget.Spinner;
import z3.C0431a;

/* renamed from: o0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0359b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7512i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f7513j;

    public /* synthetic */ RunnableC0359b(Object obj, int i2) {
        this.f7512i = i2;
        this.f7513j = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7512i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                ((SearchActionModeView) this.f7513j).lambda$onAnimationEnd$0();
                break;
            case 4:
                r3.c cVar = (r3.c) this.f7513j;
                cVar.f7702b.setBackground(C0431a.e(cVar.f7701a, R.attr.actionBarItemBackground));
                break;
            default:
                Spinner.a((Spinner) this.f7513j);
                break;
        }
    }
}
