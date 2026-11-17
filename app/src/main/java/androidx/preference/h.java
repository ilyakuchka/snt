package androidx.preference;

import android.R;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class h extends RecyclerView.x {

    /* renamed from: B, reason: collision with root package name */
    private final SparseArray<View> f3873B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f3874C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f3875D;

    h(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.f3873B = sparseArray;
        sparseArray.put(R.id.title, view.findViewById(R.id.title));
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        sparseArray.put(com.android.mmt.R.id.icon_frame, view.findViewById(com.android.mmt.R.id.icon_frame));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
    }

    public final View B(int i2) {
        View view = this.f3873B.get(i2);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.f4055i.findViewById(i2);
        if (viewFindViewById != null) {
            this.f3873B.put(i2, viewFindViewById);
        }
        return viewFindViewById;
    }

    public final boolean C() {
        return this.f3874C;
    }

    public final boolean D() {
        return this.f3875D;
    }

    public final void E(boolean z4) {
        this.f3874C = z4;
    }

    public final void F(boolean z4) {
        this.f3875D = z4;
    }
}
