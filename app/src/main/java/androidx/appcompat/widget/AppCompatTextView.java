package androidx.appcompat.widget;

import D.a;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import i.C0333a;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView {
    private final C0184e mBackgroundTintHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<D.a> mPrecomputedTextFuture;
    private final C0201w mTextClassifierHelper;
    private final C0202x mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<D.a> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                Objects.requireNonNull(future.get());
                setText((CharSequence) null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.mBackgroundTintHelper;
        if (c0184e != null) {
            c0184e.a();
        }
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0184e c0184e = this.mBackgroundTintHelper;
        if (c0184e != null) {
            return c0184e.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0184e c0184e = this.mBackgroundTintHelper;
        if (c0184e != null) {
            return c0184e.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    public a.C0001a getTextMetricsParamsCompat() {
        return new a.C0001a(getTextMetricsParams());
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        Objects.requireNonNull(this.mTextHelper);
        C0189j.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            Objects.requireNonNull(c0202x);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i4) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i2, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        super.onTextChanged(charSequence, i2, i4, i5);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i4, int i5, int i6) throws IllegalArgumentException {
        super.setAutoSizeTextTypeUniformWithConfiguration(i2, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        super.setAutoSizeTextTypeWithDefaults(i2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.mBackgroundTintHelper;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.mBackgroundTintHelper;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        super.setFirstBaselineToTopHeight(i2);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        super.setLastBaselineToBottomHeight(i2);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        H.c.b(this, i2);
    }

    public void setPrecomputedText(D.a aVar) {
        Objects.requireNonNull(aVar);
        setText((CharSequence) null);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0184e c0184e = this.mBackgroundTintHelper;
        if (c0184e != null) {
            c0184e.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0184e c0184e = this.mBackgroundTintHelper;
        if (c0184e != null) {
            c0184e.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.i(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.j(mode);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.h(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<D.a> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(a.C0001a c0001a) {
        TextDirectionHeuristic textDirectionHeuristicD = c0001a.d();
        int i2 = 1;
        if (textDirectionHeuristicD != TextDirectionHeuristics.FIRSTSTRONG_RTL && textDirectionHeuristicD != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            if (textDirectionHeuristicD == TextDirectionHeuristics.ANYRTL_LTR) {
                i2 = 2;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.LTR) {
                i2 = 3;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.RTL) {
                i2 = 4;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.LOCALE) {
                i2 = 5;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i2 = 6;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i2 = 7;
            }
        }
        setTextDirection(i2);
        getPaint().set(c0001a.e());
        setBreakStrategy(c0001a.b());
        setHyphenationFrequency(c0001a.c());
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f4) {
        super.setTextSize(i2, f4);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i2) {
        if (this.mIsSetTypefaceProcessing) {
            return;
        }
        Typeface typefaceCreate = null;
        if (typeface != null && i2 > 0) {
            Context context = getContext();
            int i4 = y.c.f8146c;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i2);
        }
        this.mIsSetTypefaceProcessing = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i2);
        } finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Q.a(context);
        this.mIsSetTypefaceProcessing = false;
        O.a(this, getContext());
        C0184e c0184e = new C0184e(this);
        this.mBackgroundTintHelper = c0184e;
        c0184e.d(attributeSet, i2);
        C0202x c0202x = new C0202x(this);
        this.mTextHelper = c0202x;
        c0202x.f(attributeSet, i2);
        c0202x.b();
        this.mTextClassifierHelper = new C0201w(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? C0333a.a(context, i2) : null, i4 != 0 ? C0333a.a(context, i4) : null, i5 != 0 ? C0333a.a(context, i5) : null, i6 != 0 ? C0333a.a(context, i6) : null);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? C0333a.a(context, i2) : null, i4 != 0 ? C0333a.a(context, i4) : null, i5 != 0 ? C0333a.a(context, i5) : null, i6 != 0 ? C0333a.a(context, i6) : null);
        C0202x c0202x = this.mTextHelper;
        if (c0202x != null) {
            c0202x.b();
        }
    }
}
