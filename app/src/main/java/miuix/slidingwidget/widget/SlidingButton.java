package miuix.slidingwidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Switch;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.android.mmt.R;
import java.util.Objects;
import t.C0384b;

/* loaded from: classes.dex */
public class SlidingButton extends AppCompatCheckBox {

    /* renamed from: l, reason: collision with root package name */
    private a f7362l;

    public SlidingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.slidingButtonStyle);
        a aVar = new a(this);
        this.f7362l = aVar;
        aVar.t();
        this.f7362l.s();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.d, R.attr.slidingButtonStyle, R.style.Widget_SlidingButton_DayNight);
        try {
            this.f7362l.u(context, typedArrayObtainStyledAttributes);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.f7362l;
        if (aVar != null) {
            aVar.D();
        }
    }

    @Override // android.view.View
    public final float getAlpha() {
        a aVar = this.f7362l;
        return aVar != null ? aVar.o() : super.getAlpha();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        a aVar = this.f7362l;
        if (aVar != null) {
            aVar.v();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        a aVar = this.f7362l;
        if (aVar == null) {
            super.onDraw(canvas);
        } else {
            aVar.w(canvas);
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f7362l;
        if (aVar != null) {
            Objects.requireNonNull(aVar);
        } else {
            Log.w("SlidingButton", "mHelper is null, cannot handle hover event");
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(true);
        accessibilityNodeInfo.setClassName(Switch.class.getName());
        if (getContext() == null || getContext().getResources() == null) {
            return;
        }
        accessibilityNodeInfo.setStateDescription(isChecked() ? getContext().getResources().getString(R.string.accessibility_sliding_button_state_description_on) : getContext().getResources().getString(R.string.accessibility_sliding_button_state_description_off));
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i2, int i4) {
        setMeasuredDimension(this.f7362l.q(), this.f7362l.p());
        this.f7362l.C();
    }

    @Override // android.view.View
    protected final boolean onSetAlpha(int i2) {
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        a aVar = this.f7362l;
        if (aVar == null) {
            return true;
        }
        aVar.x(motionEvent);
        return true;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        super.performClick();
        a aVar = this.f7362l;
        if (aVar == null) {
            return true;
        }
        Objects.requireNonNull(aVar);
        return true;
    }

    @Override // android.view.View
    public final void setAlpha(float f4) {
        super.setAlpha(f4);
        a aVar = this.f7362l;
        if (aVar != null) {
            aVar.z(f4);
        }
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public final void setButtonDrawable(Drawable drawable) {
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void setChecked(boolean z4) {
        if (isChecked() != z4) {
            super.setChecked(z4);
            boolean zIsChecked = isChecked();
            a aVar = this.f7362l;
            if (aVar != null) {
                aVar.A(zIsChecked);
            }
        }
    }

    @Override // android.view.View
    public final void setLayerType(int i2, Paint paint) {
        super.setLayerType(i2, paint);
        a aVar = this.f7362l;
        if (aVar != null) {
            aVar.B(i2);
        }
    }

    @Override // android.view.View
    public final void setPressed(boolean z4) {
        super.setPressed(z4);
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected final boolean verifyDrawable(Drawable drawable) {
        a aVar;
        return super.verifyDrawable(drawable) || ((aVar = this.f7362l) != null && aVar.F(drawable));
    }
}
