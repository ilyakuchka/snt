package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.app.Fragment;
import com.android.mmt.R;

/* renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0220p {
    static a a(Context context, Fragment fragment, boolean z4, boolean z5) {
        Fragment.b bVar = fragment.f3420R;
        boolean z6 = false;
        int i2 = bVar == null ? 0 : bVar.g;
        int iK = z5 ? z4 ? fragment.K() : fragment.L() : z4 ? fragment.C() : fragment.D();
        fragment.Q0(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.f3417N;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.f3417N.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.f3417N;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        if (iK == 0 && i2 != 0) {
            iK = i2 != 4097 ? i2 != 4099 ? i2 != 8194 ? -1 : z4 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z4 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z4 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
        }
        if (iK != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iK));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iK);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                    z6 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z6) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iK);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e4) {
                    if (zEquals) {
                        throw e4;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iK);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: androidx.fragment.app.p$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f3566a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f3567b;

        a(Animation animation) {
            this.f3566a = animation;
            this.f3567b = null;
        }

        a(Animator animator) {
            this.f3566a = null;
            this.f3567b = animator;
        }
    }

    /* renamed from: androidx.fragment.app.p$b */
    static class b extends AnimationSet implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private final ViewGroup f3568i;

        /* renamed from: j, reason: collision with root package name */
        private final View f3569j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f3570k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f3571l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f3572m;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3572m = true;
            this.f3568i = viewGroup;
            this.f3569j = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public final boolean getTransformation(long j2, Transformation transformation) {
            this.f3572m = true;
            if (this.f3570k) {
                return !this.f3571l;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f3570k = true;
                androidx.core.view.n.a(this.f3568i, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f3570k || !this.f3572m) {
                this.f3568i.endViewTransition(this.f3569j);
                this.f3571l = true;
            } else {
                this.f3572m = false;
                this.f3568i.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public final boolean getTransformation(long j2, Transformation transformation, float f4) {
            this.f3572m = true;
            if (this.f3570k) {
                return !this.f3571l;
            }
            if (!super.getTransformation(j2, transformation, f4)) {
                this.f3570k = true;
                androidx.core.view.n.a(this.f3568i, this);
            }
            return true;
        }
    }
}
