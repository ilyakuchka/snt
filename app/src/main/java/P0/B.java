package P0;

import android.animation.ValueAnimator;
import android.app.Activity;

/* loaded from: classes.dex */
final class B implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ D f865i;

    B(D d) {
        this.f865i = d;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        D d = this.f865i;
        D.b(d, (Activity) d.f875i, fFloatValue);
    }
}
