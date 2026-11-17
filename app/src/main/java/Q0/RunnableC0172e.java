package Q0;

import android.view.ActionMode;

/* renamed from: Q0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0172e implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1102i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ActionMode f1103j;

    public /* synthetic */ RunnableC0172e(ActionMode actionMode, int i2) {
        this.f1102i = i2;
        this.f1103j = actionMode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1102i) {
            case 0:
                this.f1103j.finish();
                break;
            default:
                this.f1103j.finish();
                break;
        }
    }
}
