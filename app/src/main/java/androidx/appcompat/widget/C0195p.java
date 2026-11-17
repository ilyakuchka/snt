package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.android.mmt.R;

/* renamed from: androidx.appcompat.widget.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0195p extends RatingBar {

    /* renamed from: i, reason: collision with root package name */
    private final C0194o f3039i;

    public C0195p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        O.a(this, getContext());
        C0194o c0194o = new C0194o(this);
        this.f3039i = c0194o;
        c0194o.b(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected final synchronized void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        Bitmap bitmapA = this.f3039i.a();
        if (bitmapA != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapA.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }
}
