package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.cardview.widget.CardView;

/* loaded from: classes.dex */
final class a {
    a() {
    }

    private c a(b bVar) {
        return (c) ((CardView.a) bVar).a();
    }

    public final float b(b bVar) {
        return a(bVar).c();
    }

    public final void c(b bVar, Context context, ColorStateList colorStateList, float f4, float f5, float f6) {
        CardView.a aVar = (CardView.a) bVar;
        aVar.c(new c(colorStateList, f4));
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(f5);
        a(aVar).d(f6, CardView.this.c(), aVar.b());
        if (!CardView.this.c()) {
            aVar.d(0, 0, 0, 0);
            return;
        }
        float fB = a(aVar).b();
        float fB2 = b(aVar);
        int iCeil = (int) Math.ceil(d.a(fB, fB2, aVar.b()));
        int iCeil2 = (int) Math.ceil(d.b(fB, fB2, aVar.b()));
        aVar.d(iCeil, iCeil2, iCeil, iCeil2);
    }
}
