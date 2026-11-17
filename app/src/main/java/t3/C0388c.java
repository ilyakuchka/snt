package t3;

import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.View;
import com.android.mmt.R;
import miuix.appcompat.internal.app.widget.ActionBarContextView;
import miuix.appcompat.internal.app.widget.i;

/* renamed from: t3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0388c extends C0387b implements miuix.view.b {

    /* renamed from: o, reason: collision with root package name */
    private boolean f7912o;

    public C0388c(Context context, ActionMode.Callback callback) {
        super(context, callback);
        this.f7912o = true;
    }

    @Override // miuix.view.b
    public final void addAnimationListener(miuix.view.a aVar) {
        this.f7907j.get().addAnimationListener(aVar);
    }

    @Override // miuix.view.b
    public final void d(int i2, int i4) {
        ((ActionBarContextView) this.f7907j.get()).P(i2, i4);
    }

    @Override // t3.C0387b, android.view.ActionMode
    public final void finish() {
        super.finish();
        if (this.f7912o) {
            String string = TextUtils.isEmpty(null) ? this.f7906i.getResources().getString(R.string.miuix_appcompat_accessibility_finish_edit_action_mode) : null;
            i iVar = this.f7907j.get();
            if (iVar instanceof ActionBarContextView) {
                ((ActionBarContextView) iVar).announceForAccessibility(string);
            }
        }
    }

    @Override // t3.C0387b, android.view.ActionMode
    public final CharSequence getTitle() {
        return ((ActionBarContextView) this.f7907j.get()).A();
    }

    @Override // t3.C0387b
    public final boolean i() {
        boolean zI = super.i();
        if (this.f7912o && zI) {
            String string = TextUtils.isEmpty(null) ? this.f7906i.getResources().getString(R.string.miuix_appcompat_accessibility_start_edit_action_mode) : null;
            i iVar = this.f7907j.get();
            if (iVar instanceof ActionBarContextView) {
                ((ActionBarContextView) iVar).announceForAccessibility(string);
            }
        }
        return zI;
    }

    @Override // t3.C0387b, android.view.ActionMode
    public final void setCustomView(View view) {
    }

    @Override // t3.C0387b, android.view.ActionMode
    public final void setSubtitle(int i2) {
    }

    @Override // t3.C0387b, android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
    }

    @Override // t3.C0387b, android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        ((ActionBarContextView) this.f7907j.get()).T(charSequence);
    }

    @Override // t3.C0387b, android.view.ActionMode
    public final void setTitle(int i2) {
        setTitle(this.f7906i.getResources().getString(i2));
    }
}
