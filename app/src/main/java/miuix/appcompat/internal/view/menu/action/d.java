package miuix.appcompat.internal.view.menu.action;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.android.mmt.R;
import u3.C0393b;

/* loaded from: classes.dex */
final class d extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private C0393b f7059i;

    /* renamed from: j, reason: collision with root package name */
    private a f7060j;

    interface a {
    }

    public d(Context context, int i2) {
        super(context, null, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, Y1.a.f2105Z, i2, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        CharSequence text = typedArrayObtainStyledAttributes.getText(0);
        typedArrayObtainStyledAttributes.recycle();
        C0393b c0393b = new C0393b(this);
        this.f7059i = c0393b;
        c0393b.c(drawable);
        this.f7059i.d(text);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
    }

    public final void a(a aVar) {
        this.f7060j = aVar;
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f7059i.a(getContext().getResources().getConfiguration());
        setPaddingRelative(getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_button_bg_top_padding), getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_button_bg_bottom_padding));
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        ViewGroup viewGroup = this;
        while (viewGroup != null && viewGroup.getVisibility() == 0) {
            ViewParent parent = viewGroup.getParent();
            viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        if (!(viewGroup == null)) {
            return true;
        }
        playSoundEffect(0);
        a aVar = this.f7060j;
        if (aVar != null) {
            b.a(((miuix.appcompat.internal.view.menu.action.a) aVar).f7034a);
        }
        return true;
    }

    @Override // android.view.View
    public final void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.f7059i.b(z4);
    }
}
