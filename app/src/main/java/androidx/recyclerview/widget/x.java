package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class x extends RecyclerView.i {
    boolean g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean a(RecyclerView.x xVar, RecyclerView.x xVar2, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i2;
        int i4;
        int i5 = cVar.f3986a;
        int i6 = cVar.f3987b;
        if (xVar2.y()) {
            int i7 = cVar.f3986a;
            i4 = cVar.f3987b;
            i2 = i7;
        } else {
            i2 = cVar2.f3986a;
            i4 = cVar2.f3987b;
        }
        return o(xVar, xVar2, i5, i6, i2, i4);
    }

    public abstract void n(RecyclerView.x xVar);

    public abstract boolean o(RecyclerView.x xVar, RecyclerView.x xVar2, int i2, int i4, int i5, int i6);

    public abstract boolean p(RecyclerView.x xVar, int i2, int i4, int i5, int i6);

    public abstract void q(RecyclerView.x xVar);
}
