package miuix.appcompat.internal.app.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.widget.TextView;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class n extends TextView {

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f7002i;

    /* renamed from: j, reason: collision with root package name */
    private int f7003j;

    /* renamed from: k, reason: collision with root package name */
    private int f7004k;

    /* renamed from: l, reason: collision with root package name */
    private ValueAnimator f7005l;

    /* renamed from: m, reason: collision with root package name */
    private int f7006m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7007n;

    final class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            n.this.f7006m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            n.this.invalidate();
        }
    }

    final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            n nVar = n.this;
            nVar.f7006m = nVar.getWidth();
        }
    }

    public n(Context context, int i2) {
        super(context, null, i2);
        b();
    }

    private void b() {
        ColorStateList textColors = getTextColors();
        this.f7002i = textColors;
        this.f7003j = textColors.getColorForState(TextView.ENABLED_STATE_SET, getResources().getColor(R.color.miuix_appcompat_action_bar_tab_text_color_normal_light));
        this.f7004k = this.f7002i.getColorForState(TextView.ENABLED_SELECTED_STATE_SET, getResources().getColor(R.color.miuix_appcompat_action_bar_tab_text_color_selected_light));
    }

    public final void c(boolean z4) {
        int width;
        int width2;
        ValueAnimator valueAnimator = this.f7005l;
        if (valueAnimator == null) {
            this.f7005l = new ValueAnimator();
        } else {
            valueAnimator.cancel();
        }
        this.f7007n = z4;
        if (z4) {
            width2 = getWidth();
            width = 0;
        } else {
            width = getWidth();
            width2 = 0;
        }
        this.f7005l.setIntValues(width, width2);
        this.f7005l.setDuration(200L);
        this.f7005l.addUpdateListener(new a());
        this.f7005l.addListener(new b());
        this.f7005l.start();
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        int scrollX;
        ValueAnimator valueAnimator = this.f7005l;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            super.onDraw(canvas);
            return;
        }
        int i2 = ((!this.f7007n || isSelected()) && (this.f7007n || !isSelected())) ? this.f7004k : this.f7003j;
        setTextColor(i2);
        boolean z4 = getLayoutDirection() == 1;
        int scrollX2 = this.f7006m;
        int height = getHeight();
        if (z4) {
            scrollX = getScrollX() + 0;
            scrollX2 += getScrollX();
        } else {
            scrollX = 0;
        }
        canvas.save();
        canvas.clipRect(scrollX, 0, scrollX2, height);
        super.onDraw(canvas);
        canvas.restore();
        int i4 = this.f7003j;
        if (i2 == i4) {
            i2 = this.f7004k;
        } else if (i2 == this.f7004k) {
            i2 = i4;
        }
        setTextColor(i2);
        int scrollX3 = this.f7006m;
        int width = getWidth();
        if (z4) {
            scrollX3 += getScrollX();
            width += getScrollX();
        }
        canvas.save();
        canvas.clipRect(scrollX3, 0, width, height);
        super.onDraw(canvas);
        canvas.restore();
        setTextColor(this.f7002i);
    }

    @Override // android.widget.TextView
    public final void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        b();
    }
}
