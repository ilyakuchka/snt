package Q0;

import N.i;
import Q0.C0168a;
import Q0.ViewOnClickListenerC0169b;
import a.C0178a;
import android.app.NotificationManager;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Telephony;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.C0223a;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.BlankView;
import com.android.mmt.ui.ComposeMessageRouterActivity;
import com.android.mmt.util.AbstractHandlerC0272d;
import com.android.mmt.util.P;
import com.android.mmt.util.e0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import miuix.appcompat.app.g;
import x0.C0416c;

/* loaded from: classes.dex */
public abstract class q extends C0168a {

    /* renamed from: v0, reason: collision with root package name */
    public static final /* synthetic */ int f1129v0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f1130e0;

    /* renamed from: f0, reason: collision with root package name */
    protected L0.a f1131f0;

    /* renamed from: g0, reason: collision with root package name */
    protected View f1132g0;

    /* renamed from: h0, reason: collision with root package name */
    private y f1133h0;

    /* renamed from: i0, reason: collision with root package name */
    protected View f1134i0;

    /* renamed from: j0, reason: collision with root package name */
    protected BlankView f1135j0;

    /* renamed from: k0, reason: collision with root package name */
    protected RecyclerView f1136k0;

    /* renamed from: l0, reason: collision with root package name */
    protected LinearLayoutManager f1137l0;

    /* renamed from: m0, reason: collision with root package name */
    protected S0.c f1138m0;

    /* renamed from: n0, reason: collision with root package name */
    protected l f1139n0;

    /* renamed from: o0, reason: collision with root package name */
    private miuix.appcompat.app.g f1140o0;
    private boolean p0;
    private boolean q0;

    /* renamed from: t0, reason: collision with root package name */
    protected int f1143t0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f1141r0 = true;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f1142s0 = false;

    /* renamed from: u0, reason: collision with root package name */
    protected miuix.view.a f1144u0 = new a();

    final class a implements miuix.view.a {
        a() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
            q.this.f1138m0.W(true);
            int childCount = q.this.f1136k0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Object objM = q.this.f1136k0.M(q.this.f1136k0.getChildAt(i2));
                if (objM instanceof S0.b) {
                    ((S0.b) objM).b(z4);
                }
            }
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
            int childCount = q.this.f1136k0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Object objM = q.this.f1136k0.M(q.this.f1136k0.getChildAt(i2));
                if (objM instanceof S0.b) {
                    ((S0.b) objM).c(z4, f4);
                }
            }
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
            q.this.f1138m0.W(false);
            int childCount = q.this.f1136k0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Object objM = q.this.f1136k0.M(q.this.f1136k0.getChildAt(i2));
                if (objM instanceof S0.b) {
                    ((S0.b) objM).a(z4);
                }
            }
            q.this.f1138m0.n();
            if (q.this.f1142s0) {
                q.this.f1136k0.y0(0);
                q.this.f1142s0 = false;
            }
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            q.this.l1();
        }
    }

    final class c extends i.c {
        c() {
        }

        @Override // N.i.c
        public final void a(Object obj) {
            P.a().b(true);
        }
    }

    final class d extends LinearLayoutManager {
        d(Context context) {
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
        public final boolean i() {
            return q.this.f1141r0 && super.i();
        }
    }

    final class e extends RecyclerView.o {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public final void a(RecyclerView recyclerView, int i2) {
            P.a().b(i2 == 0);
        }
    }

    final class f implements ViewOnClickListenerC0169b.InterfaceC0031b<L0.a> {
        f() {
        }

        @Override // Q0.ViewOnClickListenerC0169b.InterfaceC0031b
        public final void a(View view, int i2, Object obj) {
            q qVar = q.this;
            qVar.f1132g0 = view;
            qVar.f1130e0 = i2;
            qVar.f1131f0 = (L0.a) obj;
            view.setSelected(true);
        }

        @Override // Q0.ViewOnClickListenerC0169b.InterfaceC0031b
        public final void b(Object obj) {
            L0.a aVar = (L0.a) obj;
            Intent intentA = ComposeMessageRouterActivity.a(q.this.x(), aVar.f());
            intentA.putExtra("conversation_message_count", aVar.g());
            intentA.putExtra("FROM_WHERE", 2);
            ComposeMessageRouterActivity.e(q.this.x(), intentA);
        }
    }

    final class g implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f1149i;

        g(List list) {
            this.f1149i = list;
        }

        @Override // java.lang.Runnable
        public final void run() throws RemoteException, OperationApplicationException {
            q.this.n1().h().s(this.f1149i);
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("read", (Integer) 1);
            contentValues.put("seen", (Integer) 1);
            ContentResolver contentResolver = MmsApp.c().getContentResolver();
            for (Long l2 : this.f1149i) {
                if (l2.longValue() >= 0) {
                    arrayList.add(((i) q.this.e1()).h(l2, contentValues));
                    if (arrayList.size() > 50) {
                        ((i) q.this.e1()).i(contentResolver, arrayList);
                    }
                    com.android.mmt.transaction.d.s(l2.longValue());
                }
            }
            if (arrayList.size() > 0) {
                ((i) q.this.e1()).i(contentResolver, arrayList);
            }
        }
    }

    final class h implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ L0.a f1151i;

        h(L0.a aVar) {
            this.f1151i = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(this.f1151i.f()));
            C0416c.h0(q.this.f1139n0, arrayList);
        }
    }

    protected class i extends C0168a.ActionModeCallbackC0030a implements ViewOnClickListenerC0169b.a {
        private S0.a<L0.a> d;

        /* renamed from: e, reason: collision with root package name */
        private int f1153e;

        public i(S0.a<L0.a> aVar) {
            super();
            this.f1153e = 0;
            this.d = aVar;
            aVar.X(this);
            if (this.f1153e > 0) {
                return;
            }
            Q2.c.a(new t(this));
        }

        static void e(final i iVar) {
            L0.d dVarH = q.this.n1().h();
            final List<Long> listC = iVar.d.S() ? dVarH.C(iVar.d.Q()) : dVarH.B(iVar.d.Q());
            dVarH.s(listC);
            final ArrayList arrayList = new ArrayList();
            final ContentValues contentValues = new ContentValues(2);
            contentValues.put("read", (Integer) 1);
            contentValues.put("seen", (Integer) 1);
            final int i2 = 1;
            Q2.c.a(new Runnable() { // from class: m0.d
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i2) throws Resources.NotFoundException {
            String quantityString;
            if (i2 == 0) {
                quantityString = q.this.Q(R.string.miuix_appcompat_action_mode_title_empty);
                this.f1085b.findItem(R.id.delete).setEnabled(false);
            } else {
                quantityString = q.this.N().getQuantityString(R.plurals.miuix_appcompat_items_selected, i2, Integer.valueOf(i2));
                this.f1085b.findItem(R.id.delete).setEnabled(true);
            }
            ((ActionMode) this.f1084a).setTitle(quantityString);
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
                int itemId = item.getItemId();
                if (itemId == R.id.delete) {
                    item.setEnabled(z4);
                } else if (itemId == R.id.mark_as_read) {
                    item.setEnabled(z4);
                }
            }
        }

        @Override // Q0.ViewOnClickListenerC0169b.a
        public final void g(int i2, boolean z4) throws Resources.NotFoundException {
            this.d.G(i2);
            j(this.d.O());
        }

        public final ContentProviderOperation h(Long l2, ContentValues contentValues) {
            return ContentProviderOperation.newUpdate(ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, l2.longValue())).withValues(contentValues).withSelection("(read=0 OR seen=0)", null).build();
        }

        public final void i(ContentResolver contentResolver, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
            if (contentResolver != null) {
                try {
                    contentResolver.applyBatch("mms-sms", arrayList);
                    arrayList.clear();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // Q0.C0168a.ActionModeCallbackC0030a, android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) throws Resources.NotFoundException {
            int itemId = menuItem.getItemId();
            if (itemId == 16908314) {
                if (this.f1153e <= 0) {
                    Q2.c.a(new t(this));
                }
                this.d.K();
                j(this.d.O());
            } else if (itemId != R.id.delete) {
                if (itemId == R.id.mark_as_read) {
                    Q2.c.a(new s(this, actionMode));
                }
            } else if (this.d.O() > 0) {
                Q2.c.a(new r(this));
            }
            super.onActionItemClicked(actionMode, menuItem);
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // Q0.C0168a.ActionModeCallbackC0030a, android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) throws Resources.NotFoundException {
            super.onCreateActionMode(actionMode, menu);
            this.d.W(true);
            ((miuix.view.b) actionMode).addAnimationListener(q.this.f1144u0);
            this.d.M();
            q.this.x().getMenuInflater().inflate(R.menu.conversation_multi_select_menu, menu);
            this.f1085b.removeItem(R.id.action_copy_to_sdcard);
            this.f1085b.removeItem(R.id.action_select_copy_text);
            this.f1085b.removeItem(R.id.action_show_delivery_status);
            j(0);
            q.this.t1(true);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.d.N();
            q.this.t1(false);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1155a;

        /* renamed from: b, reason: collision with root package name */
        private List<Long> f1156b;

        public j(List<Long> list, boolean z4) {
            this.f1156b = list;
            this.f1155a = z4;
        }

        public final boolean c() {
            return this.f1155a;
        }

        public final List<Long> d() {
            return this.f1156b;
        }
    }

    public class k implements DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        private final List<Long> f1157i;

        /* renamed from: j, reason: collision with root package name */
        private final AbstractHandlerC0272d f1158j;

        /* renamed from: k, reason: collision with root package name */
        private final Context f1159k;

        /* renamed from: l, reason: collision with root package name */
        private a f1160l;

        private class a extends AsyncTask<Void, Void, Boolean> {

            /* renamed from: a, reason: collision with root package name */
            private final boolean f1162a;

            /* renamed from: b, reason: collision with root package name */
            private final List<Long> f1163b;

            public a(boolean z4, List<Long> list) {
                this.f1162a = z4;
                this.f1163b = list;
            }

            @Override // android.os.AsyncTask
            protected final Boolean doInBackground(Void[] voidArr) {
                k kVar = k.this;
                boolean z4 = this.f1162a;
                q.this.n1().h().l(this.f1163b, z4);
                k.b(k.this, this.f1162a);
                return true;
            }

            @Override // android.os.AsyncTask
            protected final void onPostExecute(Boolean bool) {
                if (bool.booleanValue()) {
                    k kVar = k.this;
                    q.this.f1139n0.b(1801, new j(kVar.f1157i, this.f1162a), 0);
                }
            }
        }

        public k(List<Long> list, AbstractHandlerC0272d abstractHandlerC0272d, Context context) {
            this.f1157i = list;
            this.f1158j = abstractHandlerC0272d;
            this.f1159k = context;
        }

        static void b(k kVar, boolean z4) {
            List<Long> list = kVar.f1157i;
            j jVar = new j(list, z4);
            if (list.size() > 0) {
                P0.r.x(kVar.f1159k, kVar.f1157i, new u(kVar, jVar));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            q.this.w1(true);
            boolean zG = ((miuix.appcompat.app.g) dialogInterface).g();
            a aVar = this.f1160l;
            if (aVar != null && !aVar.isCancelled()) {
                this.f1160l.cancel(true);
            }
            this.f1160l = (a) new a(zG, this.f1157i).execute(new Void[0]);
            dialogInterface.dismiss();
        }
    }

    protected class l extends AbstractHandlerC0272d {

        final class a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Object f1165i;

            a(Object obj) {
                this.f1165i = obj;
            }

            @Override // java.lang.Runnable
            public final void run() {
                NotificationManager notificationManager = (NotificationManager) MmsApp.c().getSystemService("notification");
                j jVar = (j) this.f1165i;
                if (jVar.f1156b != null) {
                    Iterator it = jVar.f1156b.iterator();
                    while (it.hasNext()) {
                        long jLongValue = ((Long) it.next()).longValue();
                        if (jLongValue > 0) {
                            C0178a.a(notificationManager, P0.r.o((int) jLongValue), C0223a.f4309b);
                        }
                    }
                } else {
                    notificationManager.cancelAll();
                }
                com.android.mmt.transaction.d.E();
                if (!jVar.f1155a && jVar.f1156b != null && jVar.f1156b.size() > 0) {
                    Iterator it2 = jVar.f1156b.iterator();
                    while (it2.hasNext()) {
                        L0.b.a(((Long) it2.next()).longValue(), true);
                    }
                }
                C0416c.g0(q.this.f1139n0);
                Objects.requireNonNull(P.a());
                M0.d.b().f(1000L);
            }
        }

        final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                q.this.d1();
                q.this.w1(false);
            }
        }

        public l(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void b(int i2, Object obj, int i4) {
            if (i2 != 1801) {
                return;
            }
            Q2.c.a(new a(obj));
            C0416c.N();
            S2.e.a().post(new b());
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
        @Override // com.android.mmt.util.AbstractHandlerC0272d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void c(int i2, Object obj, Cursor cursor) throws Resources.NotFoundException {
            boolean z4;
            String quantityString;
            boolean z5 = false;
            if (i2 != 1802) {
                if (i2 != 1903) {
                    return;
                }
                String strA = com.android.mmt.util.C.a(MmsApp.c());
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            boolean z6 = cursor.moveToFirst();
                            cursor.close();
                            z5 = z6;
                        }
                    } finally {
                    }
                }
                androidx.preference.g.c(MmsApp.c()).edit().putBoolean("bookmark_visible", z5).apply();
                androidx.preference.g.c(MmsApp.c()).edit().putString("bookmark_snippet", strA).apply();
                return;
            }
            if (cursor != null) {
                try {
                    z4 = cursor.getCount() > 0;
                } finally {
                }
            } else {
                z4 = false;
            }
            q qVar = q.this;
            List list = (List) obj;
            k kVar = qVar.new k(list, qVar.f1139n0, qVar.x());
            if (list == null) {
                quantityString = MmsApp.c().getString(R.string.confirm_delete_all_conversations);
            } else {
                int size = list.size();
                quantityString = MmsApp.c().getResources().getQuantityString(R.plurals.confirm_delete_conversation, size, Integer.valueOf(size));
            }
            Context contextB = qVar.B();
            if (contextB == null) {
                return;
            }
            g.a aVar = new g.a(contextB);
            if (z4) {
                aVar.d(MmsApp.c().getString(R.string.delete_unlocked));
            }
            aVar.x(R.string.confirm_dialog_title);
            aVar.c(true);
            aVar.t(R.string.delete, kVar);
            aVar.m(R.string.no, null);
            aVar.k(quantityString);
            aVar.A();
        }
    }

    protected class m extends androidx.lifecycle.u {
        public void d() {
        }

        public void e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(boolean z4) {
        if (!z4) {
            miuix.appcompat.app.g gVar = this.f1140o0;
            if (gVar != null) {
                gVar.dismiss();
                this.f1140o0 = null;
                return;
            }
            return;
        }
        miuix.appcompat.app.g gVar2 = this.f1140o0;
        if (gVar2 == null || !gVar2.isShowing()) {
            miuix.appcompat.app.g gVarC = e0.c(B(), R.string.batch_deleting_progress_message);
            this.f1140o0 = gVarC;
            gVarC.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void a0(Bundle bundle) {
        super.a0(bundle);
        this.p0 = true;
        StringBuilder sbD = D2.e.d("lazyInit: mIsViewCreated:");
        sbD.append(this.p0);
        sbD.append(" mIsDataLoaded:");
        sbD.append(this.q0);
        Log.d("ConversationBaseF", sbD.toString());
        if (!this.p0 || this.q0) {
            return;
        }
        r1();
        this.q0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean d0(MenuItem menuItem) {
        L0.a aVar = this.f1131f0;
        if (aVar == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(aVar.f()));
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            Q2.c.a(new g(arrayList));
        } else if (itemId == 2) {
            Q2.c.a(new h(aVar));
        } else {
            if (itemId != 3) {
                this.f1131f0 = null;
                return false;
            }
            c1();
            this.f1138m0.J(this.f1130e0);
        }
        this.f1131f0 = null;
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1134i0 = layoutInflater.inflate(p1(), viewGroup, false);
        if (this.f1139n0 == null) {
            this.f1139n0 = new l(B().getContentResolver());
        }
        j1();
        Q2.c.a(new b());
        return this.f1134i0;
    }

    @Override // androidx.fragment.app.Fragment
    public void i0() {
        q1().d();
        w1(false);
        super.i0();
    }

    protected void j1() {
        if (this.f1133h0 == null) {
            y yVar = new y(m1());
            this.f1133h0 = yVar;
            yVar.l(new c());
        }
        d dVar = new d(B());
        this.f1137l0 = dVar;
        dVar.q1(1);
        RecyclerView recyclerView = (RecyclerView) this.f1134i0.findViewById(android.R.id.list);
        this.f1136k0 = recyclerView;
        recyclerView.u0(this.f1137l0);
        this.f1136k0.s0(null);
        this.f1136k0.setOverScrollMode(2);
        this.f1136k0.r0();
        this.f1136k0.i(new e());
        S0.c cVar = new S0.c(new o(), m1());
        this.f1138m0 = cVar;
        cVar.Y(o1());
        this.f1138m0.e0();
        this.f1136k0.p0(this.f1138m0);
        f1(k1());
        this.f1133h0.g().g(U(), new p(this, 0));
        this.f1133h0.i().g(U(), new p(this, 1));
        this.f1136k0.setOnCreateContextMenuListener(this);
    }

    public C0168a.ActionModeCallbackC0030a k1() {
        return new i(this.f1138m0);
    }

    protected void l1() {
    }

    protected abstract int m1();

    protected final y n1() {
        return this.f1133h0;
    }

    public ViewOnClickListenerC0169b.InterfaceC0031b o1() {
        return new f();
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (this.f1131f0 == null) {
            Log.w("ConversationBaseF", "dispatchTouchEvent: mLastLongClickBugleConversation is null");
            return;
        }
        contextMenu.add(0, 0, 0, N().getString(R.string.sp_mark_as_read_menu_title));
        contextMenu.add(0, 2, 0, N().getString(R.string.delete));
        contextMenu.add(0, 3, 131072, N().getString(R.string.menu_multi_select));
    }

    @Override // androidx.fragment.app.Fragment
    public void p0() {
        super.p0();
        q1().e();
        y1();
    }

    protected int p1() {
        return R.layout.fragment_conversation_base;
    }

    protected m q1() {
        return new m();
    }

    @Override // androidx.fragment.app.Fragment
    public void r0() {
        super.r0();
    }

    protected void r1() {
    }

    @Override // androidx.fragment.app.Fragment
    public void s0() {
        super.s0();
    }

    public final void s1(Menu menu) {
        View view = this.f1132g0;
        if (view != null) {
            view.setSelected(false);
        }
    }

    protected void t1(boolean z4) {
    }

    protected void u1(int i2) {
    }

    public void v1() {
    }

    protected void x1(boolean z4) {
        if (!z4) {
            this.f1136k0.setVisibility(0);
            BlankView blankView = this.f1135j0;
            if (blankView != null) {
                blankView.setVisibility(8);
                this.f1135j0 = null;
                return;
            }
            return;
        }
        if (this.f1135j0 == null) {
            View viewFindViewById = this.f1134i0.findViewById(R.id.blank_view);
            if (viewFindViewById instanceof ViewStub) {
                this.f1135j0 = (BlankView) ((ViewStub) viewFindViewById).inflate();
            } else {
                BlankView blankView2 = (BlankView) viewFindViewById;
                this.f1135j0 = blankView2;
                blankView2.setVisibility(0);
            }
        }
        this.f1136k0.setVisibility(8);
    }

    protected abstract void y1();
}
