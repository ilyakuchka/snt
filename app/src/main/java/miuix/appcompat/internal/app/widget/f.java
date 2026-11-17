package miuix.appcompat.internal.app.widget;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6978i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ActionBarView f6979j;

    public /* synthetic */ f(ActionBarView actionBarView, int i2) {
        this.f6978i = i2;
        this.f6979j = actionBarView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6978i) {
            case 0:
                ActionBarView.r(this.f6979j);
                break;
            case 1:
                ActionBarView.o(this.f6979j);
                break;
            case 2:
                ActionBarView.q(this.f6979j);
                break;
            case 3:
                ActionBarView.n(this.f6979j);
                break;
            default:
                ActionBarView.p(this.f6979j);
                break;
        }
    }
}
