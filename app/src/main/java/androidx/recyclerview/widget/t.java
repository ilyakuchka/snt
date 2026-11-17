package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.d;

/* loaded from: classes.dex */
final class t implements d.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f4261a;

    t(RecyclerView recyclerView) {
        this.f4261a = recyclerView;
    }

    public final View a(int i2) {
        return this.f4261a.getChildAt(i2);
    }

    public final int b() {
        return this.f4261a.getChildCount();
    }

    public final int c(View view) {
        return this.f4261a.indexOfChild(view);
    }

    public final void d(int i2) {
        View childAt = this.f4261a.getChildAt(i2);
        if (childAt != null) {
            this.f4261a.r(childAt);
            childAt.clearAnimation();
        }
        this.f4261a.removeViewAt(i2);
    }
}
