package r3;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mmt.R;
import o0.RunnableC0359b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f7701a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f7702b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f7703c;
    private TextView d;

    public c(Context context) {
        this.f7701a = context;
    }

    public final View b() {
        return this.f7702b;
    }

    public final void c() {
        LinearLayout linearLayout = new LinearLayout(this.f7701a);
        this.f7702b = linearLayout;
        linearLayout.setImportantForAccessibility(2);
        this.f7702b.setEnabled(false);
        this.f7702b.setOrientation(1);
        this.f7702b.post(new RunnableC0359b(this, 4));
        TextView textView = new TextView(this.f7701a, null, R.attr.expandTitleTheme);
        this.f7703c = textView;
        textView.setId(R.id.action_bar_title_expand);
        this.f7702b.addView(this.f7703c, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.f7701a, null, R.attr.expandSubtitleTheme);
        this.d = textView2;
        textView2.setId(R.id.action_bar_subtitle_expand);
        this.d.setVisibility(8);
        this.f7702b.addView(this.d, new LinearLayout.LayoutParams(-2, -2));
        Resources resources = this.f7701a.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.action_bar_subtitle_top_margin);
        layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.action_bar_subtitle_bottom_margin);
    }

    public final void d() {
        this.f7703c.setTextAppearance(R.style.Miuix_AppCompat_TextAppearance_WindowTitle_Expand);
        this.d.setTextAppearance(R.style.Miuix_AppCompat_TextAppearance_WindowTitle_Subtitle_Expand);
    }

    public final void e(boolean z4) {
        this.f7702b.setEnabled(z4);
    }

    public final void f(View.OnClickListener onClickListener) {
        this.f7702b.setOnClickListener(onClickListener);
    }

    public final void g(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
        }
    }

    public final void h(int i2) {
        this.d.setVisibility(i2);
    }

    public final void i(CharSequence charSequence) {
        if (charSequence != null) {
            this.f7703c.setText(charSequence);
        }
    }

    public final void j() {
        this.f7703c.setVisibility(0);
    }

    public final void k(int i2) {
        this.f7702b.setVisibility(i2);
    }
}
