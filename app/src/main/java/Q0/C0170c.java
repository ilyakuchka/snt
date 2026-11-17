package Q0;

import Q0.C0168a;
import Q0.ViewOnClickListenerC0169b;
import Q0.q;
import Q0.z;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.android.mmt.R;
import com.android.mmt.util.e0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: Q0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0170c extends z {

    /* renamed from: z0, reason: collision with root package name */
    public static final /* synthetic */ int f1094z0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    private C0032c f1095y0;

    /* renamed from: Q0.c$a */
    final class a implements ViewOnClickListenerC0169b.InterfaceC0031b<L0.a> {
        a() {
        }

        @Override // Q0.ViewOnClickListenerC0169b.InterfaceC0031b
        public final void a(View view, int i2, Object obj) {
            C0170c c0170c = C0170c.this;
            c0170c.f1132g0 = view;
            c0170c.f1130e0 = i2;
            c0170c.f1131f0 = (L0.a) obj;
            view.setSelected(true);
        }

        @Override // Q0.ViewOnClickListenerC0169b.InterfaceC0031b
        public final /* bridge */ /* synthetic */ void b(Object obj) {
        }
    }

    /* renamed from: Q0.c$b */
    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f1097i;

        b(List list) {
            this.f1097i = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0170c.this.n1().h().q(this.f1097i, 0);
        }
    }

    /* renamed from: Q0.c$c, reason: collision with other inner class name */
    private class C0032c extends z.c {
        C0032c(C0170c c0170c) {
            super(c0170c);
        }
    }

    /* renamed from: Q0.c$d */
    protected class d extends C0168a.ActionModeCallbackC0030a implements ViewOnClickListenerC0169b.a {
        private S0.a<L0.a> d;

        /* renamed from: e, reason: collision with root package name */
        private int f1099e;

        public d(S0.a<L0.a> aVar) {
            super();
            this.f1099e = 0;
            this.d = aVar;
            aVar.X(this);
            if (this.f1099e > 0) {
                return;
            }
            Q2.c.a(new g(this));
        }

        private void e(int i2) {
            ((ActionMode) this.f1084a).setTitle(i2 == 0 ? C0170c.this.Q(R.string.miuix_appcompat_action_mode_title_empty) : C0170c.this.N().getQuantityString(R.plurals.miuix_appcompat_items_selected, i2, Integer.valueOf(i2)));
            boolean zH = e0.h();
            if (this.d.R()) {
                this.f1084a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_light);
            } else {
                this.f1084a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_select_all_light);
            }
            boolean z4 = i2 > 0;
            int size = this.f1085b.size();
            for (int i4 = 0; i4 < size; i4++) {
                MenuItem item = this.f1085b.getItem(i4);
                if (item.getItemId() == R.id.mark_as_un_blocked) {
                    item.setEnabled(z4);
                }
            }
        }

        @Override // Q0.ViewOnClickListenerC0169b.a
        public final void g(int i2, boolean z4) {
            this.d.G(i2);
            e(this.d.O());
        }

        @Override // Q0.C0168a.ActionModeCallbackC0030a, android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == 16908314) {
                if (this.f1099e <= 0) {
                    Q2.c.a(new g(this));
                }
                this.d.K();
                e(this.d.O());
            } else if (itemId != R.id.delete) {
                if (itemId == R.id.mark_as_un_blocked) {
                    Q2.c.a(new RunnableC0173f(this, actionMode));
                }
            } else if (this.d.O() > 0) {
                Q2.c.a(new RunnableC0171d(this));
            }
            super.onActionItemClicked(actionMode, menuItem);
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // Q0.C0168a.ActionModeCallbackC0030a, android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            super.onCreateActionMode(actionMode, menu);
            this.d.W(true);
            ((miuix.view.b) actionMode).addAnimationListener(C0170c.this.f1144u0);
            this.d.M();
            C0170c.this.x().getMenuInflater().inflate(R.menu.blocked_conversation_multi_select_menu, menu);
            this.f1085b.removeItem(R.id.action_copy_to_sdcard);
            this.f1085b.removeItem(R.id.action_select_copy_text);
            this.f1085b.removeItem(R.id.action_show_delivery_status);
            e(0);
            Objects.requireNonNull(C0170c.this);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.d.N();
            Objects.requireNonNull(C0170c.this);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    @Override // Q0.q, androidx.fragment.app.Fragment
    public final boolean d0(MenuItem menuItem) {
        L0.a aVar = this.f1131f0;
        if (aVar == null) {
            super.d0(menuItem);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(aVar.f()));
        int itemId = menuItem.getItemId();
        if (itemId == 3) {
            this.f1132g0.setSelected(false);
            c1();
            this.f1138m0.J(this.f1130e0);
        } else {
            if (itemId != 4) {
                this.f1131f0 = null;
                super.d0(menuItem);
                return false;
            }
            Q2.c.a(new b(arrayList));
        }
        this.f1131f0 = null;
        this.f1132g0.setSelected(false);
        super.d0(menuItem);
        return false;
    }

    @Override // Q0.z, Q0.q
    protected final void j1() {
        super.j1();
        n1().o(this);
        n1().j().g(this, new p(this, 2));
        A1();
    }

    @Override // Q0.q
    public final C0168a.ActionModeCallbackC0030a k1() {
        return new d(this.f1138m0);
    }

    @Override // Q0.q
    protected final int m1() {
        if (n1() != null) {
            return n1().f();
        }
        return 768;
    }

    @Override // Q0.q
    public final ViewOnClickListenerC0169b.InterfaceC0031b o1() {
        return new a();
    }

    @Override // Q0.z, Q0.q, androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.f1131f0 == null) {
            Log.w("SecretConversation", "dispatchTouchEvent: mLastLongClickBugleConversation is null");
        } else {
            contextMenu.add(0, 4, 0, N().getString(R.string.confirm_no_block_positive));
            contextMenu.add(0, 3, 131072, N().getString(R.string.menu_multi_select));
        }
    }

    @Override // Q0.z, Q0.q
    protected final int p1() {
        return R.layout.fragment_conversation_blocked;
    }

    @Override // Q0.q
    protected final q.m q1() {
        if (this.f1095y0 == null) {
            this.f1095y0 = new C0032c(this);
        }
        return this.f1095y0;
    }

    @Override // Q0.q
    protected final void y1() {
    }
}
