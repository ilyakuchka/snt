package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* loaded from: classes.dex */
final class q extends s {
    q(RecyclerView.l lVar) {
        super(lVar);
    }

    @Override // androidx.recyclerview.widget.s
    public final int b(View view) {
        return this.f4258a.G(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int c(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        Objects.requireNonNull(this.f4258a);
        Rect rect = ((RecyclerView.m) view.getLayoutParams()).f4009b;
        return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int d(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        Objects.requireNonNull(this.f4258a);
        Rect rect = ((RecyclerView.m) view.getLayoutParams()).f4009b;
        return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int e(View view) {
        return this.f4258a.F(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int f() {
        return this.f4258a.W();
    }

    @Override // androidx.recyclerview.widget.s
    public final int g() {
        return this.f4258a.W() - this.f4258a.Q();
    }

    @Override // androidx.recyclerview.widget.s
    public final int h() {
        return this.f4258a.Q();
    }

    @Override // androidx.recyclerview.widget.s
    public final int i() {
        return this.f4258a.X();
    }

    @Override // androidx.recyclerview.widget.s
    public final int j() {
        return this.f4258a.K();
    }

    @Override // androidx.recyclerview.widget.s
    public final int k() {
        return this.f4258a.P();
    }

    @Override // androidx.recyclerview.widget.s
    public final int l() {
        return (this.f4258a.W() - this.f4258a.P()) - this.f4258a.Q();
    }

    @Override // androidx.recyclerview.widget.s
    public final int n(View view) {
        this.f4258a.V(view, this.f4260c);
        return this.f4260c.right;
    }

    @Override // androidx.recyclerview.widget.s
    public final int o(View view) {
        this.f4258a.V(view, this.f4260c);
        return this.f4260c.left;
    }

    @Override // androidx.recyclerview.widget.s
    public final void p(int i2) {
        this.f4258a.d0(i2);
    }
}
