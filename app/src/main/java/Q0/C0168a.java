package Q0;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.android.mmt.R;
import com.android.mmt.util.e0;

/* renamed from: Q0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0168a extends Fragment {

    /* renamed from: c0, reason: collision with root package name */
    private ActionModeCallbackC0030a f1082c0;

    /* renamed from: d0, reason: collision with root package name */
    private ActionMode f1083d0;

    /* renamed from: Q0.a$a, reason: collision with other inner class name */
    public class ActionModeCallbackC0030a implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        protected miuix.view.b f1084a;

        /* renamed from: b, reason: collision with root package name */
        protected Menu f1085b;

        public ActionModeCallbackC0030a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() != 16908313) {
                return false;
            }
            C0168a.this.d1();
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            this.f1085b = menu;
            this.f1084a = (miuix.view.b) actionMode;
            boolean zH = e0.h();
            actionMode.setTitle(R.string.miuix_appcompat_action_mode_title_empty);
            this.f1084a.d(android.R.id.button1, zH ? R.drawable.miuix_appcompat_action_mode_title_button_cancel_dark : R.drawable.miuix_appcompat_action_mode_title_button_cancel_light);
            this.f1084a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_select_all_light);
            return true;
        }
    }

    public final void c1() {
        if (this.f1082c0 == null || x() == null) {
            return;
        }
        this.f1083d0 = x().startActionMode(this.f1082c0);
    }

    public final void d1() {
        ActionMode actionMode;
        if (this.f1082c0 == null || (actionMode = this.f1083d0) == null) {
            return;
        }
        actionMode.finish();
        this.f1083d0 = null;
    }

    public final ActionModeCallbackC0030a e1() {
        return this.f1082c0;
    }

    public final void f1(ActionModeCallbackC0030a actionModeCallbackC0030a) {
        this.f1082c0 = actionModeCallbackC0030a;
    }

    @Override // androidx.fragment.app.Fragment
    public final void q0(Bundle bundle) {
    }
}
