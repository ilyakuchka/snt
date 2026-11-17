package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class w {
    static int a(RecyclerView.v vVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z4) {
        if (lVar.A() == 0 || vVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z4) {
            return Math.abs(lVar.S(view) - lVar.S(view2)) + 1;
        }
        return Math.min(sVar.l(), sVar.b(view2) - sVar.e(view));
    }

    static int b(RecyclerView.v vVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z4, boolean z5) {
        if (lVar.A() == 0 || vVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z5 ? Math.max(0, (vVar.b() - Math.max(lVar.S(view), lVar.S(view2))) - 1) : Math.max(0, Math.min(lVar.S(view), lVar.S(view2)));
        if (z4) {
            return Math.round((iMax * (Math.abs(sVar.b(view2) - sVar.e(view)) / (Math.abs(lVar.S(view) - lVar.S(view2)) + 1))) + (sVar.k() - sVar.e(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.v vVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z4) {
        if (lVar.A() == 0 || vVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z4) {
            return vVar.b();
        }
        return (int) (((sVar.b(view2) - sVar.e(view)) / (Math.abs(lVar.S(view) - lVar.S(view2)) + 1)) * vVar.b());
    }
}
