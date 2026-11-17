package miuix.androidbasewidget.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Switch;
import miuix.androidbasewidget.widget.c;
import z3.C0431a;

/* loaded from: classes.dex */
public class PasswordWidgetManager extends c.a {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private Context mContext;
    private boolean mIsChecked;
    private c mMaster;
    private Drawable mWidgetDrawable;

    public PasswordWidgetManager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mIsChecked = false;
        Drawable drawableE = C0431a.e(context, com.android.mmt.R.attr.miuixAppcompatVisibilityIcon);
        this.mWidgetDrawable = drawableE;
        if (drawableE == null) {
            if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
                this.mWidgetDrawable = context.getResources().getDrawable(com.android.mmt.R.drawable.miuix_appcompat_ic_visibility_selector_dark);
            } else {
                this.mWidgetDrawable = context.getResources().getDrawable(com.android.mmt.R.drawable.miuix_appcompat_ic_visibility_selector_light);
            }
        }
    }

    @Override // miuix.androidbasewidget.widget.c.a
    public Drawable[] getWidgetDrawables() {
        return new Drawable[]{this.mWidgetDrawable};
    }

    @Override // miuix.androidbasewidget.widget.c.a
    public void onAttached(c cVar) {
    }

    @Override // miuix.androidbasewidget.widget.c.a
    protected void onPopulateNodeForVirtualView(int i2, F.b bVar) {
        bVar.C(true);
        bVar.D(this.mIsChecked);
        bVar.E(Switch.class.getName());
        bVar.I(this.mContext.getString(com.android.mmt.R.string.miuix_show_password));
    }

    @Override // miuix.androidbasewidget.widget.c.a
    public void onWidgetClick(int i2) {
        boolean z4 = !this.mIsChecked;
        this.mIsChecked = z4;
        this.mWidgetDrawable.setState(z4 ? CHECKED_STATE_SET : new int[0]);
    }
}
