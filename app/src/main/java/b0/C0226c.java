package b0;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.k;
import androidx.core.view.o;
import androidx.core.view.w;

/* renamed from: b0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0226c implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f4365a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225b f4366b;

    C0226c(C0225b c0225b) {
        this.f4366b = c0225b;
    }

    @Override // androidx.core.view.k
    public final w a(View view, w wVar) {
        w wVarG = o.g(view, wVar);
        if (wVarG.k()) {
            return wVarG;
        }
        Rect rect = this.f4365a;
        rect.left = wVarG.f();
        rect.top = wVarG.h();
        rect.right = wVarG.g();
        rect.bottom = wVarG.e();
        int childCount = this.f4366b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            w wVarC = o.c(this.f4366b.getChildAt(i2), wVarG);
            rect.left = Math.min(wVarC.f(), rect.left);
            rect.top = Math.min(wVarC.h(), rect.top);
            rect.right = Math.min(wVarC.g(), rect.right);
            rect.bottom = Math.min(wVarC.e(), rect.bottom);
        }
        int i4 = rect.left;
        int i5 = rect.top;
        int i6 = rect.right;
        int i7 = rect.bottom;
        w.a aVar = new w.a(wVarG);
        aVar.c(y.b.a(i4, i5, i6, i7));
        return aVar.a();
    }
}
