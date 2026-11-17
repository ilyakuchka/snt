package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.l f4258a;

    /* renamed from: b, reason: collision with root package name */
    private int f4259b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    final Rect f4260c = new Rect();

    s(RecyclerView.l lVar) {
        this.f4258a = lVar;
    }

    public static s a(RecyclerView.l lVar, int i2) {
        if (i2 == 0) {
            return new q(lVar);
        }
        if (i2 == 1) {
            return new r(lVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public final int m() {
        if (Integer.MIN_VALUE == this.f4259b) {
            return 0;
        }
        return l() - this.f4259b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i2);

    public final void q() {
        this.f4259b = l();
    }
}
