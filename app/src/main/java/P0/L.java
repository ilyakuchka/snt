package P0;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;

/* loaded from: classes.dex */
public final class L extends TextAppearanceSpan {

    /* renamed from: i, reason: collision with root package name */
    private boolean f904i;

    public L(Context context, int i2) {
        super(context, i2);
    }

    public final void a() {
        this.f904i = true;
    }

    @Override // android.text.style.TextAppearanceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        if (this.f904i) {
            textPaint.setUnderlineText(true);
        }
    }

    @Override // android.text.style.TextAppearanceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        float textSize = textPaint.getTextSize();
        super.updateMeasureState(textPaint);
        if (textSize <= 0.0f || getTextSize() <= 0) {
            return;
        }
        textPaint.setTextSize(textSize);
    }
}
