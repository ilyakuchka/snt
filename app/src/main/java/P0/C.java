package P0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
final class C extends AnimatorListenerAdapter {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ D f866i;

    C(D d) {
        this.f866i = d;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        try {
            super/*android.widget.PopupWindow*/.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f866i.f873E = false;
    }
}
