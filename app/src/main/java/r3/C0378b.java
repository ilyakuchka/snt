package r3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mmt.R;
import z3.C0432b;

/* renamed from: r3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0378b {

    /* renamed from: a, reason: collision with root package name */
    private Context f7695a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f7696b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f7697c;
    private TextView d;

    /* renamed from: e, reason: collision with root package name */
    private float f7698e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7699f = false;
    private float g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7700h = true;

    public C0378b(Context context) {
        this.f7695a = context;
    }

    public static void b(C0378b c0378b) {
        Resources resources = c0378b.f7695a.getResources();
        c0378b.f7696b.setOrientation(1);
        c0378b.d.setTextAppearance(c0378b.f7695a, R.style.Miuix_AppCompat_TextAppearance_WindowTitle_Subtitle);
        c0378b.d.setBackground(null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0378b.d.getLayoutParams();
        layoutParams.setMarginStart(0);
        layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.action_bar_subtitle_top_margin);
        layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.action_bar_subtitle_bottom_margin);
        c0378b.d.setPadding(0, 0, 0, 0);
        c0378b.d.setLayoutParams(layoutParams);
        c0378b.f7700h = true;
        c0378b.o(c0378b.h());
    }

    public static void d(C0378b c0378b) {
        Resources resources = c0378b.f7695a.getResources();
        c0378b.f7696b.setOrientation(0);
        c0378b.d.setTextAppearance(c0378b.f7695a, R.style.Miuix_AppCompat_TextAppearance_WindowTitle);
        c0378b.d.setBackgroundResource(R.drawable.miuix_appcompat_action_bar_subtitle_bg_land);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0378b.d.getLayoutParams();
        layoutParams.setMarginStart(resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_subtitle_start_margin));
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        c0378b.d.setLayoutParams(layoutParams);
        c0378b.f7700h = false;
    }

    public final boolean e(String str) {
        if (this.f7699f) {
            this.g = this.f7697c.getPaint().measureText(str);
            this.f7699f = false;
        }
        return this.g <= ((float) this.f7697c.getMeasuredWidth());
    }

    public final Rect f() {
        Rect rect = new Rect();
        this.f7696b.getHitRect(rect);
        return rect;
    }

    public final View g() {
        return this.f7696b;
    }

    public final float h() {
        float f4 = this.f7698e;
        Resources resources = this.f7695a.getResources();
        int iMin = (Math.min(this.f7696b.getMeasuredHeight() - this.f7697c.getMeasuredHeight(), this.d.getMeasuredHeight()) - this.d.getPaddingTop()) - this.d.getPaddingBottom();
        if (iMin <= 0) {
            return f4;
        }
        TextPaint textPaint = new TextPaint(this.d.getPaint());
        textPaint.setTextSize(f4);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        int iCeil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        float f5 = f4 / 2.0f;
        float f6 = resources.getDisplayMetrics().scaledDensity;
        while (iCeil > iMin && f4 >= f5) {
            f4 -= f6;
            textPaint.setTextSize(f4);
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            iCeil = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
        }
        return f4;
    }

    public final int i() {
        return this.f7696b.getVisibility();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        Resources resources = this.f7695a.getResources();
        int i2 = 0;
        int i4 = 1;
        boolean z4 = resources.getConfiguration().orientation == 2;
        int i5 = C0432b.f8169a;
        int i6 = z4 ? 1 : 0;
        this.f7700h = i6 ^ 1;
        this.f7698e = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_subtitle_text_size);
        LinearLayout linearLayout = new LinearLayout(this.f7695a);
        this.f7696b = linearLayout;
        linearLayout.setImportantForAccessibility(2);
        Context context = this.f7695a;
        int i7 = R.attr.collapseTitleTheme;
        this.f7697c = new TextView(context, null, R.attr.collapseTitleTheme);
        if (i6 == 0) {
            i7 = R.attr.collapseSubtitleTheme;
        }
        this.d = new TextView(this.f7695a, null, i7);
        this.f7696b.setEnabled(false);
        this.f7696b.setOrientation(i6 ^ 1);
        this.f7696b.post(new RunnableC0377a(this, i2));
        this.f7697c.setId(R.id.action_bar_title);
        this.f7696b.addView(this.f7697c, new LinearLayout.LayoutParams(-2, -2));
        this.d.setId(R.id.action_bar_subtitle);
        this.d.setVisibility(8);
        if (i6 != 0) {
            this.d.post(new RunnableC0377a(this, i4));
        }
        this.f7696b.addView(this.d, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        if (i6 != 0) {
            layoutParams.setMarginStart(resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_subtitle_start_margin));
        } else {
            layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.action_bar_subtitle_top_margin);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.action_bar_subtitle_bottom_margin);
        }
    }

    public final void k(Configuration configuration) {
        int i2 = C0432b.f8169a;
        int i4 = 2;
        if (configuration.orientation == 2) {
            this.d.post(new RunnableC0377a(this, i4));
        } else {
            this.d.post(new RunnableC0377a(this, 3));
        }
    }

    public final void l(boolean z4) {
        this.f7696b.setEnabled(z4);
    }

    public final void m(View.OnClickListener onClickListener) {
        this.f7696b.setOnClickListener(onClickListener);
    }

    public final void n(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
        }
    }

    public final void o(float f4) {
        if (this.f7700h) {
            this.d.setTextSize(0, f4);
        }
    }

    public final void p(int i2) {
        if (this.d.getVisibility() != i2) {
            this.d.setVisibility(i2);
        }
    }

    public final void q(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f7697c.getText())) {
            return;
        }
        this.f7697c.setText(charSequence);
        this.f7699f = true;
    }

    public final void r(int i2) {
        if (this.f7697c.getVisibility() != i2) {
            this.f7697c.setVisibility(i2);
        }
    }

    public final void s(int i2) {
        this.f7696b.setVisibility(i2);
    }

    public final void t(boolean z4) {
        ViewGroup viewGroup = (ViewGroup) this.f7697c.getParent();
        if (viewGroup instanceof LinearLayout) {
            ((LinearLayout) viewGroup).setGravity((z4 ? 1 : 8388611) | 16);
        }
        this.f7697c.setGravity((z4 ? 1 : 8388611) | 16);
        this.f7697c.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setGravity((z4 ? 1 : 8388611) | 16);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
    }
}
