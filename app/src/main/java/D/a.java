package D;

import D2.e;
import android.annotation.SuppressLint;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a implements Spannable {

    /* renamed from: D.a$a, reason: collision with other inner class name */
    public static final class C0001a {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f75a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f76b;

        /* renamed from: c, reason: collision with root package name */
        private final int f77c;
        private final int d;

        public C0001a(PrecomputedText.Params params) {
            this.f75a = params.getTextPaint();
            this.f76b = params.getTextDirection();
            this.f77c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
        }

        public final boolean a(C0001a c0001a) {
            if (this.f77c == c0001a.f77c && this.d == c0001a.d && this.f75a.getTextSize() == c0001a.f75a.getTextSize() && this.f75a.getTextScaleX() == c0001a.f75a.getTextScaleX() && this.f75a.getTextSkewX() == c0001a.f75a.getTextSkewX() && this.f75a.getLetterSpacing() == c0001a.f75a.getLetterSpacing() && TextUtils.equals(this.f75a.getFontFeatureSettings(), c0001a.f75a.getFontFeatureSettings()) && this.f75a.getFlags() == c0001a.f75a.getFlags() && this.f75a.getTextLocales().equals(c0001a.f75a.getTextLocales())) {
                return this.f75a.getTypeface() == null ? c0001a.f75a.getTypeface() == null : this.f75a.getTypeface().equals(c0001a.f75a.getTypeface());
            }
            return false;
        }

        public final int b() {
            return this.f77c;
        }

        public final int c() {
            return this.d;
        }

        public final TextDirectionHeuristic d() {
            return this.f76b;
        }

        public final TextPaint e() {
            return this.f75a;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0001a)) {
                return false;
            }
            C0001a c0001a = (C0001a) obj;
            return a(c0001a) && this.f76b == c0001a.f76b;
        }

        public final int hashCode() {
            return Objects.hash(Float.valueOf(this.f75a.getTextSize()), Float.valueOf(this.f75a.getTextScaleX()), Float.valueOf(this.f75a.getTextSkewX()), Float.valueOf(this.f75a.getLetterSpacing()), Integer.valueOf(this.f75a.getFlags()), this.f75a.getTextLocales(), this.f75a.getTypeface(), Boolean.valueOf(this.f75a.isElegantTextHeight()), this.f76b, Integer.valueOf(this.f77c), Integer.valueOf(this.d));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sbD = e.d("textSize=");
            sbD.append(this.f75a.getTextSize());
            sb.append(sbD.toString());
            sb.append(", textScaleX=" + this.f75a.getTextScaleX());
            sb.append(", textSkewX=" + this.f75a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f75a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f75a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f75a.getTextLocales());
            sb.append(", typeface=" + this.f75a.getTypeface());
            sb.append(", variationSettings=" + this.f75a.getFontVariationSettings());
            sb.append(", textDir=" + this.f76b);
            sb.append(", breakStrategy=" + this.f77c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public final <T> T[] getSpans(int i2, int i4, Class<T> cls) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i2, int i4, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public final void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public final void setSpan(Object obj, int i2, int i4, int i5) {
        if (!(obj instanceof MetricAffectingSpan)) {
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i4) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        throw null;
    }
}
