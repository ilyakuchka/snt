package com.android.mmt.ui;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class ExpandableTextView extends StaticTextView {

    /* renamed from: i, reason: collision with root package name */
    private boolean f4779i;

    /* renamed from: j, reason: collision with root package name */
    private int f4780j;

    /* renamed from: k, reason: collision with root package name */
    private int f4781k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f4782l;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f4783m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f4784n;

    /* renamed from: o, reason: collision with root package name */
    private MessageListItem f4785o;
    private Drawable p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f4786q;

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private Rect d() {
        int measuredHeight = getMeasuredHeight();
        int lineHeight = (int) ((getLineHeight() - getLineSpacingExtra()) / getLineSpacingMultiplier());
        int width = (getWidth() + getCompoundPaddingLeft()) - lineHeight;
        int i2 = measuredHeight - this.f4781k;
        return new Rect(width, Math.abs(i2 - lineHeight), lineHeight + width, i2);
    }

    public final void e(MessageListItem messageListItem) {
        this.f4785o = messageListItem;
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4783m == 2) {
            if (this.p == null) {
                Drawable drawable = getContext().getDrawable(com.android.mmt.R.drawable.dropdown_indicator_down_n);
                this.p = drawable;
                drawable.setBounds(d());
            }
            this.p.draw(canvas);
            return;
        }
        if (this.f4783m == 3) {
            if (this.f4786q == null) {
                Drawable drawable2 = getContext().getDrawable(com.android.mmt.R.drawable.dropdown_indicator_up_n);
                this.f4786q = drawable2;
                drawable2.setBounds(d());
            }
            this.f4786q.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onMeasure(int i2, int i4) {
        boolean z4;
        Layout layout;
        int i5;
        super.onMeasure(i2, i4);
        if (this.f4783m == 1) {
            return;
        }
        boolean z5 = this.f4783m == 3;
        if (this.f4779i) {
            if ((z5 || TextUtils.equals(getText(), this.f4784n)) && (!z5 || TextUtils.equals(getText(), this.f4782l))) {
                return;
            }
            setHorizontallyScrolling(false);
            Layout layout2 = getLayout();
            if (layout2 == null) {
                z4 = getLineCount() > getMaxLines();
            } else {
                int lineCount = layout2.getLineCount();
                if (lineCount > 0) {
                    z4 = layout2.getEllipsisCount(lineCount + (-1)) > 0;
                    if (!z4) {
                        z4 = getLineCount() > getMaxLines();
                    }
                    if (!z4) {
                        for (int i6 = 0; i6 < lineCount; i6++) {
                            z4 = layout2.getEllipsisCount(i6) > 0;
                            if (z4) {
                                break;
                            }
                        }
                    }
                } else if (getLineCount() > getMaxLines()) {
                }
            }
            this.f4783m = z4 ? 2 : 0;
            if (this.f4781k < 0) {
                this.f4781k = getPaddingBottom();
            }
            if (this.f4783m > 1) {
                if (getPaddingBottom() != getLineHeight() + this.f4781k) {
                    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.f4781k);
                }
            } else if (getPaddingBottom() != this.f4781k) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.f4781k);
            }
            if (this.f4780j > 0) {
                int maxLines = getMaxLines();
                int i7 = this.f4780j;
                if (maxLines != i7) {
                    setMaxLines(i7);
                }
            }
            this.f4782l = getText();
            this.p = null;
            this.f4786q = null;
            int measuredWidth = getMeasuredWidth();
            if (TextUtils.isEmpty(this.f4782l) || (layout = getLayout()) == null) {
                return;
            }
            if (layout.getLineCount() <= this.f4780j) {
                CharSequence charSequence = this.f4782l;
                this.f4784n = charSequence;
                setText(charSequence);
                setMaxLines(Integer.MAX_VALUE);
                return;
            }
            TextPaint paint = getPaint();
            Layout layout3 = getLayout();
            int lineStart = layout3.getLineStart(this.f4780j - 1);
            int lineEnd = layout3.getLineEnd(this.f4780j - 1);
            if (lineStart < 0) {
                lineStart = 0;
            }
            if (lineEnd > this.f4782l.length()) {
                lineEnd = this.f4782l.length();
            }
            if (lineStart > lineEnd) {
                lineStart = lineEnd;
            }
            float fMeasureText = paint.measureText(this.f4782l, lineStart, lineEnd);
            float lineHeight = (((getLineHeight() - getLineSpacingExtra()) / getLineSpacingMultiplier()) / 2.0f) + getPaint().measureText("\u3000") + getPaint().measureText("...");
            if (fMeasureText + lineHeight > layout3.getWidth()) {
                i5 = 0;
                while (i5 < lineEnd - lineStart && paint.measureText(this.f4782l, lineStart, lineEnd - i5) + lineHeight > layout3.getWidth()) {
                    i5++;
                }
            } else {
                i5 = 0;
            }
            StringBuilder sb = new StringBuilder();
            for (int i8 = 0; i8 < this.f4780j - 1; i8++) {
                int lineStart2 = layout3.getLineStart(i8);
                int lineEnd2 = layout3.getLineEnd(i8);
                CharSequence charSequenceSubSequence = this.f4782l.subSequence(lineStart2, lineEnd2);
                if (this.f4782l.subSequence(lineStart2, lineEnd2).toString().endsWith("\n")) {
                    sb.append(charSequenceSubSequence);
                } else {
                    sb.append(charSequenceSubSequence);
                    sb.append("\n");
                }
            }
            sb.append(this.f4782l.subSequence(lineStart, lineEnd - i5));
            StringBuilder sb2 = new StringBuilder();
            String string = sb.toString();
            if (string.endsWith("\n")) {
                string = string.substring(0, string.length() - 1);
            }
            this.f4784n = C2.c.b(sb2, string, "...");
            int lineCount2 = layout.getLineCount();
            if (lineCount2 >= 1) {
                int i9 = lineCount2 - 1;
                int lineStart3 = layout.getLineStart(i9);
                int lineEnd3 = layout.getLineEnd(i9);
                int i10 = lineStart3 >= 0 ? lineStart3 : 0;
                if (lineEnd3 > this.f4782l.length()) {
                    lineEnd3 = this.f4782l.length();
                }
                if (i10 > lineEnd3) {
                    i10 = lineEnd3;
                }
                if (getPaint().measureText(this.f4782l, i10, lineEnd3) + ((int) ((getLineHeight() - getLineSpacingExtra()) / getLineSpacingMultiplier())) > measuredWidth) {
                    this.f4782l = ((Object) this.f4782l) + "\n";
                }
            }
            MessageListItem messageListItem = this.f4785o;
            if (messageListItem != null) {
                messageListItem.v(this, this.f4784n, this.f4782l);
            }
            this.f4783m = 2;
            setHorizontallyScrolling(true);
            setMaxLines(Integer.MAX_VALUE);
        }
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, R.attr.textViewStyle);
        this.f4781k = -1;
        this.f4782l = null;
        this.f4783m = 0;
        this.f4784n = null;
        this.p = null;
        this.f4786q = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Y1.a.f2090H, R.attr.textViewStyle, 0);
            typedArrayObtainStyledAttributes.getInt(0, 100);
            this.f4779i = typedArrayObtainStyledAttributes.getBoolean(1, true);
            this.f4780j = getMaxLines();
            typedArrayObtainStyledAttributes.recycle();
            setEllipsize(null);
        }
    }
}
