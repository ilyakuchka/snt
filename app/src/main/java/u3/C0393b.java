package u3;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mmt.R;
import z3.C0432b;

/* renamed from: u3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0393b {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f7920a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f7921b;

    public C0393b(LinearLayout linearLayout) {
        Context context = linearLayout.getContext();
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        View.inflate(context, R.layout.miuix_appcompat_action_menu_item_child_layout, linearLayout);
        this.f7920a = (ImageView) linearLayout.findViewById(R.id.action_menu_item_child_icon);
        this.f7921b = (TextView) linearLayout.findViewById(R.id.action_menu_item_child_text);
        this.f7920a.setForceDarkAllowed(false);
        a(context.getResources().getConfiguration());
    }

    public final void a(Configuration configuration) {
        if (configuration.orientation != 1) {
            this.f7921b.getContext();
            int i2 = C0432b.f8169a;
            this.f7921b.setVisibility(8);
        } else {
            this.f7921b.setVisibility(0);
        }
        this.f7921b.setTextSize(0, this.f7921b.getContext().getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_small_text_size));
    }

    public final void b(boolean z4) {
        this.f7920a.setEnabled(z4);
        this.f7921b.setEnabled(z4);
    }

    public final void c(Drawable drawable) {
        if (this.f7920a.getDrawable() != drawable) {
            this.f7920a.setImageDrawable(drawable);
        }
    }

    public final void d(CharSequence charSequence) {
        this.f7921b.setText(charSequence);
    }
}
