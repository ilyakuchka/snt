package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Group extends a {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.a
    protected final void b(AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        super.b(attributeSet);
    }

    @Override // androidx.constraintlayout.widget.a
    public final void e() {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.f3178k0.g0(0);
        aVar.f3178k0.M(0);
    }

    @Override // androidx.constraintlayout.widget.a
    public final void f(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i2 = 0; i2 < this.f3194j; i2++) {
            View view = constraintLayout.f3123i.get(this.f3193i[i2]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setElevation(elevation);
                }
            }
        }
    }
}
