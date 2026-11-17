package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class o extends RecyclerView.u {

    /* renamed from: k, reason: collision with root package name */
    protected PointF f4253k;

    /* renamed from: l, reason: collision with root package name */
    private final float f4254l;

    /* renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f4251i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f4252j = new DecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    protected int f4255m = 0;

    /* renamed from: n, reason: collision with root package name */
    protected int f4256n = 0;

    public o(Context context) {
        this.f4254l = 25.0f / context.getResources().getDisplayMetrics().densityDpi;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.u
    protected final void i(int i2, int i4, RecyclerView.u.a aVar) {
        if (b() == 0) {
            m();
            return;
        }
        int i5 = this.f4255m;
        int i6 = i5 - i2;
        if (i5 * i6 <= 0) {
            i6 = 0;
        }
        this.f4255m = i6;
        int i7 = this.f4256n;
        int i8 = i7 - i4;
        int i9 = i7 * i8 > 0 ? i8 : 0;
        this.f4256n = i9;
        if (i6 == 0 && i9 == 0) {
            PointF pointFA = a(d());
            if (pointFA != null) {
                if (pointFA.x != 0.0f || pointFA.y != 0.0f) {
                    float f4 = pointFA.y;
                    float fSqrt = (float) Math.sqrt((f4 * f4) + (r4 * r4));
                    float f5 = pointFA.x / fSqrt;
                    pointFA.x = f5;
                    float f6 = pointFA.y / fSqrt;
                    pointFA.y = f6;
                    this.f4253k = pointFA;
                    this.f4255m = (int) (f5 * 10000.0f);
                    this.f4256n = (int) (f6 * 10000.0f);
                    aVar.d((int) (this.f4255m * 1.2f), (int) (this.f4256n * 1.2f), (int) (((int) Math.ceil(Math.abs(10000) * this.f4254l)) * 1.2f), this.f4251i);
                    return;
                }
            }
            aVar.b(d());
            m();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    @Override // androidx.recyclerview.widget.RecyclerView.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void j(View view, RecyclerView.u.a aVar) {
        int i2;
        int iN;
        int i4;
        PointF pointF = this.f4253k;
        int iN2 = 0;
        if (pointF != null) {
            float f4 = pointF.x;
            i2 = f4 == 0.0f ? 0 : f4 > 0.0f ? 1 : -1;
        }
        RecyclerView.l lVarC = c();
        if (lVarC == null || !lVarC.h()) {
            iN = 0;
        } else {
            RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
            iN = n(lVarC.F(view) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, lVarC.G(view) + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, lVarC.P(), lVarC.W() - lVarC.Q(), i2);
        }
        PointF pointF2 = this.f4253k;
        if (pointF2 != null) {
            float f5 = pointF2.y;
            i4 = f5 == 0.0f ? 0 : f5 > 0.0f ? 1 : -1;
        }
        RecyclerView.l lVarC2 = c();
        if (lVarC2 != null && lVarC2.i()) {
            RecyclerView.m mVar2 = (RecyclerView.m) view.getLayoutParams();
            iN2 = n(lVarC2.H(view) - ((ViewGroup.MarginLayoutParams) mVar2).topMargin, lVarC2.D(view) + ((ViewGroup.MarginLayoutParams) mVar2).bottomMargin, lVarC2.R(), lVarC2.J() - lVarC2.O(), i4);
        }
        int iCeil = (int) Math.ceil(((int) Math.ceil(Math.abs((int) Math.sqrt((iN2 * iN2) + (iN * iN))) * this.f4254l)) / 0.3356d);
        if (iCeil > 0) {
            aVar.d(-iN, -iN2, iCeil, this.f4252j);
        }
    }

    public final int n(int i2, int i4, int i5, int i6, int i7) {
        if (i7 == -1) {
            return i5 - i2;
        }
        if (i7 != 0) {
            if (i7 == 1) {
                return i6 - i4;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i8 = i5 - i2;
        if (i8 > 0) {
            return i8;
        }
        int i9 = i6 - i4;
        if (i9 < 0) {
            return i9;
        }
        return 0;
    }
}
