package miuix.androidbasewidget.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Y;

/* loaded from: classes.dex */
public class CheckedTextView extends a {

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f6605m = {R.attr.state_checked};

    /* renamed from: k, reason: collision with root package name */
    private Drawable f6606k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6607l;

    public CheckedTextView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        this.f6607l = true;
        getContext().getResources().getDimension(com.android.mmt.R.dimen.miuix_appcompat_checked_text_view_addition_margin);
    }

    @Override // androidx.appcompat.widget.C0185f, android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f6606k != null) {
            this.f6606k.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.CheckedTextView
    public final Drawable getCheckMarkDrawable() {
        return this.f6606k;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6606k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        getContext().getResources().getDimension(com.android.mmt.R.dimen.miuix_appcompat_checked_text_view_addition_margin);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6605m);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        Drawable checkMarkDrawable;
        int width;
        int scrollX;
        if (this.f6607l && (checkMarkDrawable = getCheckMarkDrawable()) != null) {
            int intrinsicWidth = checkMarkDrawable.getCurrent().getIntrinsicWidth();
            if (Y.b(this)) {
                width = getPaddingStart();
                scrollX = getScrollX();
            } else {
                width = (getWidth() - getPaddingEnd()) - intrinsicWidth;
                scrollX = getScrollX();
            }
            int i2 = scrollX + width;
            int paddingTop = getPaddingTop();
            int paddingTop2 = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int intrinsicHeight = checkMarkDrawable.getIntrinsicHeight();
            if (checkMarkDrawable.getCurrent() instanceof NinePatchDrawable) {
                intrinsicHeight = (getHeight() - paddingTop) - getPaddingBottom();
            } else {
                int gravity = getGravity() & 112;
                if (gravity == 16) {
                    paddingTop = ((((getHeight() - paddingTop2) - paddingBottom) - intrinsicHeight) / 2) + paddingTop2;
                } else if (gravity == 80) {
                    paddingTop = getHeight() - intrinsicHeight;
                }
            }
            checkMarkDrawable.setBounds(i2, paddingTop, intrinsicWidth + i2, intrinsicHeight + paddingTop);
            checkMarkDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onMeasure(int i2, int i4) {
        int size = View.MeasureSpec.getSize(i2);
        Drawable checkMarkDrawable = getCheckMarkDrawable();
        int i5 = 0;
        int intrinsicWidth = checkMarkDrawable == null ? 0 : checkMarkDrawable.getCurrent().getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            i5 = intrinsicWidth;
        } else if (TextUtils.isEmpty(getText())) {
            this.f6607l = true;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(intrinsicWidth, View.MeasureSpec.getMode(i2)), i4);
            setMeasuredDimension(intrinsicWidth, getMeasuredHeight());
            return;
        } else if (size - getPaddingEnd() < intrinsicWidth * 2) {
            this.f6607l = false;
        } else {
            this.f6607l = true;
            i5 = intrinsicWidth;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size - i5, View.MeasureSpec.getMode(i2)), i4);
        if (i5 == 0) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + i5, getMeasuredHeight());
    }

    @Override // android.widget.CheckedTextView
    public final void setCheckMarkDrawable(Drawable drawable) {
        Drawable drawable2 = this.f6606k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f6606k);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(getVisibility() == 0, false);
            drawable.setState(f6605m);
            setMinHeight(drawable.getIntrinsicHeight());
            drawable.setState(getDrawableState());
        }
        this.f6606k = drawable;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6606k;
    }
}
