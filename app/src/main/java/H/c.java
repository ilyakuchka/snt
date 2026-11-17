package H;

import android.graphics.Paint;
import android.widget.TextView;
import t.C0384b;

/* loaded from: classes.dex */
public final class c {
    public static void a(TextView textView, int i2) {
        C0384b.g(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i4 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i4)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i4);
        }
    }

    public static void b(TextView textView, int i2) {
        C0384b.g(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }
}
