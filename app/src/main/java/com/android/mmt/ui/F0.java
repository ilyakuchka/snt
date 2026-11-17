package com.android.mmt.ui;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.util.AbstractHandlerC0272d;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.EditableListViewV2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class F0 extends Fragment {
    public static float p0;

    /* renamed from: c0, reason: collision with root package name */
    private miuix.appcompat.app.h f4802c0;

    /* renamed from: d0, reason: collision with root package name */
    private ContentResolver f4803d0;

    /* renamed from: e0, reason: collision with root package name */
    private EditableListViewV2 f4804e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f4805f0;

    /* renamed from: g0, reason: collision with root package name */
    private ProgressBar f4806g0;

    /* renamed from: j0, reason: collision with root package name */
    private int f4809j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f4810k0;

    /* renamed from: h0, reason: collision with root package name */
    private C0247i0 f4807h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    private c f4808i0 = null;

    /* renamed from: l0, reason: collision with root package name */
    private int f4811l0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    private Uri f4812m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    private int f4813n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    private final ContentObserver f4814o0 = new a(new Handler());

    final class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4) {
            Log.d("SimMessagesFragment", "sim message change");
            F0.this.p1();
        }
    }

    private class b implements EditableListViewV2.f {

        /* renamed from: a, reason: collision with root package name */
        private miuix.view.b f4816a;

        /* renamed from: b, reason: collision with root package name */
        private EditableListViewV2.j f4817b;

        /* renamed from: c, reason: collision with root package name */
        private Menu f4818c;

        final class a implements DialogInterface.OnClickListener {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ SortedSet f4819i;

            a(SortedSet sortedSet) {
                this.f4819i = sortedSet;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                F0.this.q1(2);
                F0.n1(F0.this, this.f4819i);
                dialogInterface.dismiss();
            }
        }

        b() {
        }

        private void c(boolean z4) {
            miuix.appcompat.app.b bVarK = F0.this.f4802c0.K();
            if (bVarK != null) {
                if (!z4) {
                    z4 = bVarK.q() <= 1;
                }
                bVarK.x(z4);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00ab  */
        @Override // com.android.mmt.util.EditableListViewV2.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(EditableListViewV2.j jVar) throws Resources.NotFoundException {
            String strQ;
            F0.this.f4807h0.Y(jVar.a());
            this.f4817b = jVar;
            int iB = jVar.b();
            if (iB == 0) {
                strQ = F0.this.Q(R.string.miuix_appcompat_action_mode_title_empty);
                this.f4818c.findItem(R.id.delete).setEnabled(false);
                this.f4818c.findItem(R.id.copy_to_phone).setEnabled(false);
                this.f4818c.findItem(R.id.forward).setEnabled(false);
            } else {
                String quantityString = F0.this.N().getQuantityString(R.plurals.miuix_appcompat_items_selected, this.f4817b.b(), Integer.valueOf(this.f4817b.b()));
                this.f4818c.findItem(R.id.delete).setEnabled(true);
                if (iB == 1) {
                    TreeSet treeSet = (TreeSet) this.f4817b.d();
                    if (treeSet.size() > 0) {
                        Cursor cursor = (Cursor) F0.this.f4807h0.G(((Integer) treeSet.iterator().next()).intValue());
                        boolean z4 = TextUtils.isEmpty(cursor.getString(cursor.getColumnIndexOrThrow("address"))) ? false : true;
                        this.f4818c.findItem(R.id.copy_to_phone).setEnabled(z4);
                        this.f4818c.findItem(R.id.forward).setEnabled(true);
                    }
                } else {
                    this.f4818c.findItem(R.id.copy_to_phone).setEnabled(false);
                    this.f4818c.findItem(R.id.forward).setEnabled(false);
                }
                strQ = quantityString;
            }
            ((ActionMode) this.f4816a).setTitle(strQ);
            boolean zH = com.android.mmt.util.e0.h();
            if (this.f4817b.e()) {
                this.f4816a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_light);
            } else {
                this.f4816a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_select_all_light);
            }
        }

        @Override // com.android.mmt.util.EditableListViewV2.f
        public final void b(View view, boolean z4, boolean z5) {
            if (z5) {
                F0.this.f4807h0.n();
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.button1:
                    actionMode.finish();
                    break;
                case android.R.id.button2:
                    if (!this.f4817b.e()) {
                        this.f4817b.c();
                        break;
                    } else {
                        this.f4817b.f();
                        break;
                    }
                case R.id.copy_to_phone /* 2131361976 */:
                    TreeSet treeSet = (TreeSet) this.f4817b.d();
                    if (treeSet.size() > 0) {
                        F0.l1(F0.this, (Cursor) F0.this.f4807h0.G(((Integer) treeSet.iterator().next()).intValue()));
                        actionMode.finish();
                        break;
                    }
                    break;
                case R.id.delete /* 2131361986 */:
                    SortedSet<Integer> sortedSetD = this.f4817b.d();
                    F0 f02 = F0.this;
                    F0.d1(f02, new a(sortedSetD), f02.N().getString(R.string.confirm_delete_SIM_message));
                    break;
                case R.id.forward /* 2131362030 */:
                    TreeSet treeSet2 = (TreeSet) this.f4817b.d();
                    if (treeSet2.size() > 0) {
                        F0.m1(F0.this, (Cursor) F0.this.f4807h0.G(((Integer) treeSet2.iterator().next()).intValue()));
                        actionMode.finish();
                        break;
                    }
                    break;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            this.f4818c = menu;
            F0.this.f4802c0.getMenuInflater().inflate(R.menu.manage_sim_messages, menu);
            F0.this.f4807h0.K();
            this.f4817b = F0.this.f4804e0.F1();
            this.f4816a = (miuix.view.b) actionMode;
            actionMode.setTitle(R.string.miuix_appcompat_action_mode_title_empty);
            boolean zH = com.android.mmt.util.e0.h();
            this.f4816a.d(android.R.id.button1, zH ? R.drawable.miuix_appcompat_action_mode_title_button_cancel_dark : R.drawable.miuix_appcompat_action_mode_title_button_cancel_light);
            this.f4816a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_select_all_light);
            F0.this.f4802c0.getWindow().findViewById(R.id.view_pager);
            c(true);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            F0.this.f4802c0.getWindow().findViewById(R.id.view_pager);
            c(false);
            F0.this.f4807h0.L();
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    private class c extends AbstractHandlerC0272d {
        public c(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void b(int i2, Object obj, int i4) {
            if (i2 != 1) {
                return;
            }
            F0.k1(F0.this);
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void c(int i2, Object obj, Cursor cursor) throws Throwable {
            boolean z4 = true;
            if (!F0.this.Z()) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } finally {
                        Log.d("SimMessagesFragment", "onQueryComplete cursor close");
                    }
                }
                F0.this.q1(1);
                return;
            }
            if (cursor == null) {
                F0.this.f4813n0 = 0;
                F0.this.q1(1);
                Log.d("SimMessagesFragment", "cursor is null");
                return;
            }
            try {
                if (cursor.moveToFirst()) {
                    z4 = false;
                } else {
                    F0.this.f4813n0 = 0;
                    F0.this.q1(1);
                    try {
                        Log.d("SimMessagesFragment", "cursor is empty");
                    } catch (Throwable th) {
                        th = th;
                        if (z4) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (z4) {
                    cursor.close();
                }
                if (z4) {
                    return;
                }
                if (F0.this.f4807h0 == null) {
                    F0 f02 = F0.this;
                    f02.f4807h0 = new C0247i0(f02.f4802c0, cursor, F0.this.f4804e0);
                    F0.this.f4807h0.a0(new Handler());
                    F0.this.f4804e0.p0(F0.this.f4807h0);
                    F0.this.q1(0);
                    F0.this.f4807h0.c0(F0.p0);
                } else {
                    F0.this.f4807h0.e(cursor);
                    F0.this.q1(0);
                }
                F0 f03 = F0.this;
                f03.f4813n0 = f03.f4807h0.j();
                Log.d("SimMessagesFragment", "onQueryComplete change cursor");
            } catch (Throwable th2) {
                th = th2;
                z4 = false;
            }
        }
    }

    static void d1(F0 f02, DialogInterface.OnClickListener onClickListener, CharSequence charSequence) {
        g.a aVar = new g.a(f02.f4802c0);
        aVar.x(R.string.confirm_dialog_title);
        aVar.c(true);
        aVar.t(R.string.yes, onClickListener);
        aVar.m(R.string.no, null);
        aVar.k(charSequence);
        aVar.A();
    }

    static /* synthetic */ int k1(F0 f02) {
        int i2 = f02.f4809j0 - 1;
        f02.f4809j0 = i2;
        return i2;
    }

    static void l1(F0 f02, Cursor cursor) {
        Objects.requireNonNull(f02);
        String string = cursor.getString(cursor.getColumnIndexOrThrow("address"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("date")));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
        boolean z4 = true;
        if (i2 != 1 && i2 != 3) {
            z4 = false;
        }
        int i4 = R.string.restored_to_phone_memory;
        try {
            Uri uri = z4 ? Telephony.Sms.Inbox.CONTENT_URI : Telephony.Sms.Sent.CONTENT_URI;
            C0287t.a(f02.f4802c0, uri.buildUpon().appendQueryParameter("check_duplication", "1").build(), string, string2, Long.valueOf(z4 ? lValueOf.longValue() : System.currentTimeMillis()), false, -1L, C0287t.m(f02.f4811l0));
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(f02.f4802c0, e2);
            i4 = R.string.restore_to_phone_memory_failed;
        }
        Toast.makeText(MmsApp.c(), i4, 0).show();
    }

    static void m1(F0 f02, Cursor cursor) {
        Objects.requireNonNull(f02);
        String string = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        Intent intent = new Intent(f02.f4802c0, (Class<?>) NewMessageActivity.class);
        intent.putExtra("exit_on_sent", true);
        intent.putExtra("sms_body", string);
        intent.putExtra("forwarded_message", true);
        f02.b1(intent);
        f02.f4802c0.overridePendingTransition(R.anim.push_up_in, android.R.anim.fade_out);
    }

    static void n1(F0 f02, Set set) {
        Cursor cursor = f02.f4807h0.d;
        if (cursor != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (cursor.moveToPosition(((Integer) it.next()).intValue())) {
                    arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("index_on_icc")));
                }
            }
            HashSet hashSet = new HashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext() && !f02.f4802c0.isFinishing()) {
                String str = (String) it2.next();
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : TextUtils.split(str, ";")) {
                        if (!TextUtils.isEmpty(str2)) {
                            f02.f4809j0++;
                            hashSet.add(str2);
                        }
                    }
                }
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                String str3 = (String) it3.next();
                f02.f4808i0.e(1, null, C0287t.x() ? f02.f4812m0.buildUpon().appendQueryParameter("msgIndex", str3).build() : f02.f4812m0.buildUpon().appendPath(str3).build(), null, null);
            }
        }
        f02.f4804e0.E1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        q1(2);
        try {
            this.f4808i0.a(0);
            this.f4808i0.f(0, null, this.f4812m0, null, null, null);
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(this.f4802c0, e2);
            q1(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(int i2) {
        if (this.f4810k0 == i2) {
            return;
        }
        this.f4810k0 = i2;
        if (i2 == 0) {
            this.f4804e0.setVisibility(0);
            this.f4805f0.setVisibility(8);
            this.f4806g0.setVisibility(8);
            this.f4804e0.requestFocus();
            return;
        }
        if (i2 == 1) {
            this.f4804e0.setVisibility(8);
            this.f4805f0.setVisibility(0);
            this.f4806g0.setVisibility(8);
        } else {
            if (i2 != 2) {
                Log.e("SimMessagesFragment", "Invalid State");
                return;
            }
            this.f4804e0.setVisibility(8);
            this.f4805f0.setVisibility(8);
            this.f4806g0.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        miuix.appcompat.app.h hVar = (miuix.appcompat.app.h) x();
        this.f4802c0 = hVar;
        this.f4803d0 = hVar.getContentResolver();
        this.f4808i0 = new c(this.f4803d0);
        View viewInflate = layoutInflater.inflate(R.layout.sim_list, (ViewGroup) null);
        this.f4804e0 = (EditableListViewV2) viewInflate.findViewById(R.id.messages);
        B();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.q1(1);
        this.f4804e0.u0(linearLayoutManager);
        this.f4805f0 = (TextView) viewInflate.findViewById(R.id.empty_message);
        this.f4806g0 = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        this.f4804e0.K1(new b());
        int i2 = z().getInt("slot_id");
        this.f4811l0 = i2;
        if (i2 == 0) {
            this.f4812m0 = Uri.parse("content://sms/icc_subId/0");
        } else if (i2 == 1) {
            this.f4812m0 = Uri.parse("content://sms/icc_subId/1");
        }
        p1();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void i0() {
        C0247i0 c0247i0 = this.f4807h0;
        if (c0247i0 != null && c0247i0.d != null) {
            c0247i0.e(null);
            this.f4807h0.V();
        }
        EditableListViewV2 editableListViewV2 = this.f4804e0;
        if (editableListViewV2 != null) {
            editableListViewV2.E1();
            this.f4804e0.C1();
        }
        super.i0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void n0() {
        this.f4803d0.unregisterContentObserver(this.f4814o0);
        super.n0();
    }

    public final int o1() {
        return this.f4813n0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void p0() {
        super.p0();
        if (this.f4810k0 == 1) {
            Log.d("SimMessagesFragment", "onResume state is show empty");
            p1();
        }
        this.f4803d0.registerContentObserver(this.f4812m0, true, this.f4814o0);
    }
}
