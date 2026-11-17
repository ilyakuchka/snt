package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {

    /* renamed from: i, reason: collision with root package name */
    private final C0184e f2703i;

    /* renamed from: j, reason: collision with root package name */
    private final C0202x f2704j;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f2703i;
        if (c0184e != null) {
            c0184e.a();
        }
        C0202x c0202x = this.f2704j;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public final int getAutoSizeMaxTextSize() {
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public final int getAutoSizeMinTextSize() {
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public final int getAutoSizeStepGranularity() {
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public final int[] getAutoSizeTextAvailableSizes() {
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public final int getAutoSizeTextType() {
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        C0202x c0202x = this.f2704j;
        if (c0202x != null) {
            Objects.requireNonNull(c0202x);
        }
    }

    @Override // android.widget.TextView
    protected final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        super.onTextChanged(charSequence, i2, i4, i5);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i4, int i5, int i6) throws IllegalArgumentException {
        super.setAutoSizeTextTypeUniformWithConfiguration(i2, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeWithDefaults(int i2) {
        super.setAutoSizeTextTypeWithDefaults(i2);
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f2703i;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f2703i;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0202x c0202x = this.f2704j;
        if (c0202x != null) {
            c0202x.h(context, i2);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i2, float f4) {
        super.setTextSize(i2, f4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Q.a(context);
        O.a(this, getContext());
        C0184e c0184e = new C0184e(this);
        this.f2703i = c0184e;
        c0184e.d(attributeSet, i2);
        C0202x c0202x = new C0202x(this);
        this.f2704j = c0202x;
        c0202x.f(attributeSet, i2);
        c0202x.b();
    }
}
