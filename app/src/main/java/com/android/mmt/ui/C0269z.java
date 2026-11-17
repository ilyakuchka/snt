package com.android.mmt.ui;

import P0.C0158d;
import a.C0178a;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.C0223a;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.F;
import com.android.mmt.util.AbstractHandlerC0272d;
import com.android.mmt.util.C0279k;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.EditableListViewV2;
import com.android.mmt.util.K;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import miuix.appcompat.app.g;
import x0.C0414a;
import x0.C0416c;

/* renamed from: com.android.mmt.ui.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0269z extends Fragment {

    /* renamed from: L0, reason: collision with root package name */
    private static miuix.appcompat.app.g f5778L0;

    /* renamed from: A0, reason: collision with root package name */
    private boolean f5779A0;

    /* renamed from: B0, reason: collision with root package name */
    private miuix.appcompat.app.g f5780B0;

    /* renamed from: C0, reason: collision with root package name */
    private HandlerThread f5781C0;

    /* renamed from: D0, reason: collision with root package name */
    private Handler f5782D0;

    /* renamed from: E0, reason: collision with root package name */
    boolean f5783E0;

    /* renamed from: F0, reason: collision with root package name */
    private Handler f5784F0;

    /* renamed from: G0, reason: collision with root package name */
    private C0279k.c f5785G0;

    /* renamed from: H0, reason: collision with root package name */
    private final F.b f5786H0;

    /* renamed from: I0, reason: collision with root package name */
    protected final View.OnKeyListener f5787I0;

    /* renamed from: J0, reason: collision with root package name */
    private miuix.view.a f5788J0;

    /* renamed from: K0, reason: collision with root package name */
    private SubscriptionManager.OnSubscriptionsChangedListener f5789K0;

    /* renamed from: c0, reason: collision with root package name */
    protected ActivityC0219o f5790c0;

    /* renamed from: d0, reason: collision with root package name */
    protected View f5791d0;

    /* renamed from: e0, reason: collision with root package name */
    protected View f5792e0;

    /* renamed from: f0, reason: collision with root package name */
    protected View f5793f0;

    /* renamed from: g0, reason: collision with root package name */
    protected View f5794g0;

    /* renamed from: h0, reason: collision with root package name */
    protected EditableListViewV2 f5795h0;

    /* renamed from: i0, reason: collision with root package name */
    protected TextView f5796i0;

    /* renamed from: j0, reason: collision with root package name */
    protected F f5797j0;

    /* renamed from: k0, reason: collision with root package name */
    protected m f5798k0;

    /* renamed from: l0, reason: collision with root package name */
    protected LinearLayoutManager f5799l0;

    /* renamed from: m0, reason: collision with root package name */
    protected boolean f5800m0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f5801n0;

    /* renamed from: o0, reason: collision with root package name */
    protected boolean f5802o0;
    protected boolean p0;
    protected String q0;

    /* renamed from: r0, reason: collision with root package name */
    private View f5803r0;

    /* renamed from: s0, reason: collision with root package name */
    private View f5804s0;

    /* renamed from: t0, reason: collision with root package name */
    private BlankView f5805t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f5806u0;

    /* renamed from: v0, reason: collision with root package name */
    protected int f5807v0;

    /* renamed from: w0, reason: collision with root package name */
    private Cursor f5808w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f5809x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f5810y0;

    /* renamed from: z0, reason: collision with root package name */
    private AsyncTask<Void, Set<Long>, Void> f5811z0;

    /* renamed from: com.android.mmt.ui.z$a */
    final class a extends Handler {

        /* renamed from: com.android.mmt.ui.z$a$a, reason: collision with other inner class name */
        final class C0106a implements K.a {
            C0106a() {
            }

            @Override // com.android.mmt.util.K.a
            public final void a() {
                if (com.android.mmt.util.C.b(C0269z.this.f5790c0)) {
                    C0269z.this.z1();
                }
            }

            @Override // com.android.mmt.util.K.a
            public final void b() {
            }
        }

        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            NetworkInfo activeNetworkInfo;
            StringBuilder sbD = D2.e.d("handle msg on main thread, msg: ");
            sbD.append(message.what);
            Log.v("ConversationFragment", sbD.toString());
            int i2 = message.what;
            boolean z4 = false;
            if (i2 == 520) {
                com.android.mmt.util.K.h(C0269z.this.f5790c0);
            } else {
                if (i2 == 1001) {
                    ActivityC0219o activityC0219o = C0269z.this.f5790c0;
                    if (C0287t.C() && (activeNetworkInfo = ((ConnectivityManager) activityC0219o.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                        z4 = true;
                    }
                    if (z4) {
                        C0269z c0269z = C0269z.this;
                        C0269z.c1(c0269z, c0269z.f5790c0);
                        return;
                    }
                    return;
                }
                if (i2 == 1003) {
                    C0269z.this.H1(true);
                    return;
                }
                if (i2 == 1005) {
                    if (MmsApp.f()) {
                        C0269z.this.f5784F0.removeMessages(1005);
                        C0269z.this.f5784F0.sendEmptyMessageDelayed(1005, 1000L);
                        return;
                    } else {
                        m mVar = C0269z.this.f5798k0;
                        Uri uri = C0416c.f8050r;
                        mVar.e(1803, null, Telephony.Threads.OBSOLETE_THREADS_URI, null, null);
                        return;
                    }
                }
                if (i2 != 1008) {
                    if (C0269z.this.f5790c0.isFinishing()) {
                        return;
                    }
                    Objects.requireNonNull(C0269z.this);
                    if (!(r0 instanceof E0)) {
                        ActivityC0219o activityC0219o2 = C0269z.this.f5790c0;
                        C0106a c0106a = new C0106a();
                        if (activityC0219o2 != null) {
                            com.android.mmt.util.K.g(activityC0219o2, message.what, c0106a, 1);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            ActivityC0219o activityC0219o3 = C0269z.this.f5790c0;
            if (activityC0219o3 != null && !activityC0219o3.isFinishing() && !C0269z.this.f5790c0.isDestroyed()) {
                C0269z.t1(C0269z.this, false);
            }
            C0269z.this.f5784F0.sendMessage(C0269z.this.f5782D0.obtainMessage(1007));
        }
    }

    /* renamed from: com.android.mmt.ui.z$b */
    final class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i2 != 67) {
                return false;
            }
            long jB1 = C0269z.this.f5799l0.b1();
            if (jB1 <= 0) {
                return true;
            }
            C0269z.B1(jB1, C0269z.this.f5798k0);
            return true;
        }
    }

    /* renamed from: com.android.mmt.ui.z$c */
    final class c implements miuix.view.a {
        c() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
            int iA = C0269z.this.f5799l0.A();
            for (int i2 = 0; i2 < iA; i2++) {
                KeyEvent.Callback callbackZ = C0269z.this.f5799l0.z(i2);
                if (callbackZ instanceof S0.b) {
                    ((S0.b) callbackZ).b(z4);
                }
            }
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
            int iA = C0269z.this.f5799l0.A();
            for (int i2 = 0; i2 < iA; i2++) {
                KeyEvent.Callback callbackZ = C0269z.this.f5799l0.z(i2);
                if (callbackZ instanceof S0.b) {
                    ((S0.b) callbackZ).c(z4, f4);
                }
            }
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
            int iA = C0269z.this.f5799l0.A();
            for (int i2 = 0; i2 < iA; i2++) {
                KeyEvent.Callback callbackZ = C0269z.this.f5799l0.z(i2);
                if (callbackZ instanceof C0279k.b) {
                    ((C0279k.b) callbackZ).a();
                }
            }
            C0269z.this.f5797j0.O(false);
        }
    }

    /* renamed from: com.android.mmt.ui.z$d */
    final class d extends SubscriptionManager.OnSubscriptionsChangedListener {
        d() {
        }

        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
        public final void onSubscriptionsChanged() {
            if (C0287t.z() != C0287t.y()) {
                C0287t.N(true);
                C0269z.this.H1(false);
            }
        }
    }

    /* renamed from: com.android.mmt.ui.z$e */
    final class e implements C0279k.c {
        e() {
        }
    }

    /* renamed from: com.android.mmt.ui.z$f */
    final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0269z c0269z = C0269z.this;
            ((MmsTabActivity) c0269z.f5790c0).b0(c0269z.f5792e0);
        }
    }

    /* renamed from: com.android.mmt.ui.z$g */
    final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (C0269z.this.x() != null) {
                C0269z.w1(C0269z.this, 1);
            }
        }
    }

    /* renamed from: com.android.mmt.ui.z$h */
    final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0269z c0269z = C0269z.this;
            if (!c0269z.f5802o0 && com.android.mmt.util.c0.a(c0269z.f5790c0)) {
                Y1.a.d("sms function disabled, disable floating button", new Object[0]);
                C0269z.this.f5804s0.setEnabled(false);
            }
        }
    }

    /* renamed from: com.android.mmt.ui.z$i */
    final class i extends Handler {
        i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            StringBuilder sbD = D2.e.d("handle msg on Worker thread, msg: ");
            sbD.append(message.what);
            Log.v("ConversationFragment", sbD.toString());
            if (message.what != 1006) {
                return;
            }
            C0269z c0269z = C0269z.this;
            com.android.mmt.util.K.c(c0269z.f5790c0, c0269z.f5782D0, C0269z.this.f5784F0);
        }
    }

    /* renamed from: com.android.mmt.ui.z$j */
    final class j implements F.b {
        j() {
        }
    }

    /* renamed from: com.android.mmt.ui.z$k */
    public static class k implements DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        private final Collection<Long> f5823i;

        /* renamed from: j, reason: collision with root package name */
        private final AbstractHandlerC0272d f5824j;

        /* renamed from: k, reason: collision with root package name */
        private final Context f5825k;

        /* renamed from: com.android.mmt.ui.z$k$a */
        final class a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean f5826i;

            a(boolean z4) {
                this.f5826i = z4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                miuix.appcompat.app.g unused = C0269z.f5778L0 = com.android.mmt.util.e0.c(k.this.f5825k, R.string.batch_deleting_progress_message);
                C0269z.f5778L0.show();
                if (k.this.f5823i == null) {
                    AbstractHandlerC0272d abstractHandlerC0272d = k.this.f5824j;
                    boolean z4 = this.f5826i;
                    Uri uri = C0416c.f8050r;
                    String str = z4 ? null : "locked=0";
                    h0.c.e().g(Telephony.Threads.CONTENT_URI);
                    abstractHandlerC0272d.e(1801, null, Telephony.Threads.CONTENT_URI, str, null);
                    return;
                }
                AbstractHandlerC0272d abstractHandlerC0272d2 = k.this.f5824j;
                boolean z5 = this.f5826i;
                Collection collection = k.this.f5823i;
                Uri uri2 = C0416c.f8050r;
                String str2 = z5 ? null : "locked=0";
                StringBuilder sbD = D2.e.d("thread_id IN (");
                sbD.append(TextUtils.join(",", collection));
                sbD.append(")");
                String string = sbD.toString();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    h0.c.e().g(ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, ((Long) it.next()).longValue()));
                }
                abstractHandlerC0272d2.e(1801, collection, Telephony.Threads.CONTENT_URI, DatabaseUtils.concatenateWhere(string, str2), null);
            }
        }

        public k(Collection<Long> collection, AbstractHandlerC0272d abstractHandlerC0272d, Context context) {
            this.f5823i = collection;
            this.f5824j = abstractHandlerC0272d;
            this.f5825k = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            P0.r.x(this.f5825k, this.f5823i, new a(((miuix.appcompat.app.g) dialogInterface).g()));
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.android.mmt.ui.z$l */
    public class l implements EditableListViewV2.f {

        /* renamed from: a, reason: collision with root package name */
        private miuix.view.b f5828a;

        /* renamed from: b, reason: collision with root package name */
        private EditableListViewV2.j f5829b;

        /* renamed from: c, reason: collision with root package name */
        private Menu f5830c;

        public l() {
        }

        private void c(int i2) throws Resources.NotFoundException {
            String quantityString;
            boolean z4 = i2 > 0;
            if (i2 == 0) {
                quantityString = C0269z.this.Q(R.string.miuix_appcompat_action_mode_title_empty);
                this.f5830c.findItem(R.id.delete).setEnabled(false);
            } else {
                quantityString = C0269z.this.f5790c0.getResources().getQuantityString(R.plurals.miuix_appcompat_items_selected, this.f5829b.b(), Integer.valueOf(this.f5829b.b()));
                this.f5830c.findItem(R.id.delete).setEnabled(true);
            }
            ((ActionMode) this.f5828a).setTitle(quantityString);
            boolean zH = com.android.mmt.util.e0.h();
            if (this.f5829b.e()) {
                this.f5828a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_light);
            } else {
                this.f5828a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_select_all_light);
            }
            int size = this.f5830c.size();
            for (int i4 = 0; i4 < size; i4++) {
                MenuItem item = this.f5830c.getItem(i4);
                int itemId = item.getItemId();
                if (itemId == R.id.delete) {
                    item.setEnabled(z4);
                } else if (itemId == R.id.mark_as_read) {
                    item.setEnabled(z4);
                }
            }
        }

        @Override // com.android.mmt.util.EditableListViewV2.f
        public final void a(EditableListViewV2.j jVar) throws Resources.NotFoundException {
            if (C0269z.this.x() == null) {
                return;
            }
            HashSet<Long> hashSetA = jVar.a();
            C0269z.this.f5797j0.P(hashSetA);
            C0269z.this.f5797j0.M(hashSetA);
            this.f5829b = jVar;
            c(jVar.b());
        }

        @Override // com.android.mmt.util.EditableListViewV2.f
        public final void b(View view, boolean z4, boolean z5) {
            if (z5) {
                C0269z.this.f5797j0.n();
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.button1:
                    actionMode.finish();
                    break;
                case android.R.id.button2:
                    if (!this.f5829b.e()) {
                        this.f5829b.c();
                        break;
                    } else {
                        this.f5829b.f();
                        break;
                    }
                case R.id.delete /* 2131361986 */:
                    HashSet<Long> hashSetA = this.f5829b.a();
                    if (hashSetA.size() > 0) {
                        C0416c.h0(C0269z.this.f5798k0, hashSetA);
                        break;
                    }
                    break;
                case R.id.mark_as_read /* 2131362091 */:
                    HashSet<Long> hashSetA2 = this.f5829b.a();
                    C0269z c0269z = C0269z.this;
                    C0269z.r1(c0269z, c0269z.f5790c0, hashSetA2);
                    actionMode.finish();
                    break;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) throws Resources.NotFoundException {
            this.f5830c = menu;
            miuix.view.b bVar = (miuix.view.b) actionMode;
            bVar.addAnimationListener(C0269z.this.f5788J0);
            C0269z.this.f5790c0.getMenuInflater().inflate(R.menu.conversation_multi_select_menu, menu);
            C0269z.this.f5797j0.J();
            C0269z.this.f5797j0.O(true);
            this.f5829b = C0269z.this.f5795h0.F1();
            this.f5828a = bVar;
            boolean zH = com.android.mmt.util.e0.h();
            actionMode.setTitle(R.string.miuix_appcompat_action_mode_title_empty);
            this.f5828a.d(android.R.id.button1, zH ? R.drawable.miuix_appcompat_action_mode_title_button_cancel_dark : R.drawable.miuix_appcompat_action_mode_title_button_cancel_light);
            this.f5828a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_select_all_light);
            new HashSet(0);
            c(0);
            C0269z.this.G1(false);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            C0269z.this.f5797j0.K();
            C0269z.this.G1(true);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* renamed from: com.android.mmt.ui.z$m */
    protected final class m extends AbstractHandlerC0272d {

        /* renamed from: com.android.mmt.ui.z$m$a */
        final class a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Collection f5831i;

            a(Collection collection) {
                this.f5831i = collection;
            }

            @Override // java.lang.Runnable
            public final void run() {
                NotificationManager notificationManager = (NotificationManager) MmsApp.c().getSystemService("notification");
                Collection collection = this.f5831i;
                if (collection != null) {
                    Iterator it = collection.iterator();
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
            }
        }

        public m(ContentResolver contentResolver) {
            super(contentResolver);
        }

        private void h() {
            if (C0269z.this.x() != null) {
                C0269z c0269z = C0269z.this;
                if (!c0269z.f5801n0) {
                    View view = c0269z.f5793f0;
                    if (view != null) {
                        c0269z.f5795h0.T0(view);
                        C0269z.this.f5800m0 = false;
                        return;
                    }
                    return;
                }
                if (c0269z.f5793f0 == null) {
                    c0269z.f5793f0 = c0269z.x().getLayoutInflater().inflate(R.layout.conversation_list_item_bookmark, (ViewGroup) C0269z.this.f5795h0, false);
                }
                C0269z c0269z2 = C0269z.this;
                if (!c0269z2.f5800m0) {
                    c0269z2.f5795h0.K0(c0269z2.f5793f0);
                    C0269z.this.f5800m0 = true;
                }
                ((TextView) C0269z.this.f5793f0.findViewById(R.id.subject)).setText(C0269z.this.q0);
            }
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void b(int i2, Object obj, int i4) {
            if (i2 != 1801) {
                return;
            }
            C0269z.this.f5795h0.E1();
            C0416c.N();
            Q2.c.a(new a((Collection) obj));
            if (C0269z.f5778L0 != null) {
                C0269z.f5778L0.dismiss();
                miuix.appcompat.app.g unused = C0269z.f5778L0 = null;
            }
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void c(int i2, Object obj, Cursor cursor) throws Resources.NotFoundException {
            boolean z4;
            String quantityString;
            Log.v("ConversationFragment", "onQueryComplete token is " + i2);
            if (i2 == 1701) {
                C0269z c0269z = C0269z.this;
                F f4 = c0269z.f5797j0;
                if (f4 == null) {
                    Log.v("ConversationFragment", "not init list adapter");
                    C0269z c0269z2 = C0269z.this;
                    Objects.requireNonNull(c0269z2);
                    if (cursor != null) {
                        C0269z.f1(c0269z2);
                        C0269z.this.f5808w0 = cursor;
                        return;
                    }
                    return;
                }
                f4.Q(c0269z.p0);
                C0269z c0269z3 = C0269z.this;
                c0269z3.f5797j0.T(c0269z3.f5807v0);
                if (C0269z.this.f5779A0) {
                    if (cursor != null) {
                    }
                    Log.v("ConversationFragment", "query cursor close for stop");
                } else {
                    C0269z.this.f5797j0.e(cursor);
                    C0269z.f1(C0269z.this);
                    h();
                }
                C0269z.this.f5797j0.W();
                if (!C0269z.this.f5806u0 || C0269z.this.f5790c0.isFinishing()) {
                    return;
                }
                C0269z.this.f5806u0 = false;
                C0269z.this.F1();
                C0269z c0269z4 = C0269z.this;
                if (c0269z4.f5790c0 instanceof MmsTabActivity) {
                    c0269z4.f5784F0.removeMessages(1005);
                    C0269z.this.f5784F0.sendEmptyMessageDelayed(1005, 0L);
                    return;
                }
                return;
            }
            int i4 = 0;
            if (i2 == 1704) {
                if (cursor != null) {
                    try {
                        if (C0269z.this.x() != null) {
                            if (cursor.getCount() > 0 && cursor.moveToPosition(0)) {
                                i4 = cursor.getInt(0);
                            }
                            C0269z.w1(C0269z.this, i4);
                            androidx.preference.g.c(MmsApp.c()).edit().putInt("last_message_count", i4).apply();
                        }
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (i2 == 1802) {
                if (cursor != null) {
                    try {
                        z4 = cursor.getCount() > 0;
                    } finally {
                    }
                } else {
                    z4 = false;
                }
                Collection collection = (Collection) obj;
                C0269z c0269z5 = C0269z.this;
                m mVar = c0269z5.f5798k0;
                ActivityC0219o activityC0219o = c0269z5.f5790c0;
                k kVar = new k(collection, mVar, activityC0219o);
                if (collection == null) {
                    quantityString = activityC0219o.getString(R.string.confirm_delete_all_conversations);
                } else {
                    int size = collection.size();
                    quantityString = activityC0219o.getResources().getQuantityString(R.plurals.confirm_delete_conversation, size, Integer.valueOf(size));
                }
                g.a aVar = new g.a(activityC0219o);
                if (z4) {
                    aVar.d(activityC0219o.getString(R.string.delete_unlocked));
                }
                aVar.x(R.string.confirm_dialog_title);
                aVar.c(true);
                aVar.t(R.string.delete, kVar);
                aVar.m(R.string.no, null);
                aVar.k(quantityString);
                aVar.A();
                return;
            }
            if (i2 == 1901) {
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            C0269z.this.f5809x0 = cursor.getInt(0);
                            C0269z c0269z6 = C0269z.this;
                            F f5 = c0269z6.f5797j0;
                            if (f5 != null) {
                                f5.U(c0269z6.f5809x0);
                                C0269z c0269z7 = C0269z.this;
                                C0269z.n1(c0269z7, 1, c0269z7.f5809x0);
                            }
                        }
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (i2 == 1903) {
                C0269z.this.f5801n0 = false;
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                            C0269z.this.f5801n0 = true;
                        }
                        cursor.close();
                        h();
                    } finally {
                    }
                }
                androidx.preference.g.c(MmsApp.c()).edit().putBoolean("bookmark_visible", C0269z.this.f5801n0).apply();
                androidx.preference.g.c(MmsApp.c()).edit().putString("bookmark_snippet", C0269z.this.q0).apply();
                return;
            }
            if (i2 != 1904) {
                Log.e("ConversationFragment", "onQueryComplete called with unknown token " + i2);
                return;
            }
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        C0269z.this.f5810y0 = cursor.getInt(0);
                        C0269z c0269z8 = C0269z.this;
                        F f6 = c0269z8.f5797j0;
                        if (f6 != null) {
                            f6.V(c0269z8.f5810y0);
                            C0269z c0269z9 = C0269z.this;
                            C0269z.n1(c0269z9, 2, c0269z9.f5810y0);
                        }
                    }
                } finally {
                }
            }
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void d(int i2) {
            if (i2 != 1804) {
                return;
            }
            C0269z.this.f5795h0.E1();
            C0269z.this.H1(false);
        }
    }

    public C0269z() {
        Uri.withAppendedPath(Telephony.MmsSms.CONTENT_URI, "searchCount");
        this.f5807v0 = 0;
        this.f5779A0 = false;
        this.f5781C0 = null;
        this.f5782D0 = null;
        this.f5783E0 = true;
        this.f5784F0 = new a();
        this.f5785G0 = new e();
        this.f5786H0 = new j();
        this.f5787I0 = new b();
        this.f5788J0 = new c();
        this.f5789K0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1() {
        m mVar = this.f5798k0;
        if (mVar != null) {
            mVar.a(1701);
            this.f5798k0.a(1704);
            this.f5798k0.a(1801);
            this.f5798k0.a(1802);
            this.f5798k0.a(1901);
            this.f5798k0.a(1903);
            this.f5798k0.a(1904);
            this.f5798k0.a(1803);
        }
    }

    public static void B1(long j2, AbstractHandlerC0272d abstractHandlerC0272d) {
        ArrayList arrayList;
        if (j2 != -1) {
            arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j2));
        } else {
            arrayList = null;
        }
        C0416c.h0(abstractHandlerC0272d, arrayList);
    }

    private void C1() {
        View view = this.f5803r0;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f5803r0 = null;
    }

    static void c1(C0269z c0269z, Context context) {
        NetworkInfo activeNetworkInfo;
        Objects.requireNonNull(c0269z);
        if (Settings.System.getInt(context.getContentResolver(), "mms_upload_old_msg_state", 0) == 1 && C0287t.C() && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            String string = Settings.System.getString(context.getContentResolver(), "mms_upload_old_msg_accounts");
            miuix.appcompat.app.g gVar = c0269z.f5780B0;
            if (gVar != null && gVar.isShowing()) {
                c0269z.f5780B0.dismiss();
            }
            g.a aVar = new g.a(context);
            aVar.x(R.string.found_old_messages_title);
            aVar.k(c0269z.R(R.string.found_old_messages, string, null));
            aVar.h();
            aVar.c(true);
            aVar.t(R.string.yes, new B(context));
            aVar.m(R.string.no, new C(context));
            c0269z.f5780B0 = aVar.A();
        }
    }

    static void f1(C0269z c0269z) {
        Cursor cursor = c0269z.f5808w0;
        if (cursor != null) {
            cursor.close();
            c0269z.f5808w0 = null;
        }
    }

    static void n1(C0269z c0269z, int i2, int i4) {
        for (int i5 = 0; i5 < c0269z.f5799l0.A(); i5++) {
            ConversationListItem conversationListItemL = F.L(c0269z.f5799l0.z(i5));
            if (conversationListItemL != null) {
                if (i2 == 1 && conversationListItemL.y()) {
                    if (conversationListItemL.I(i4)) {
                        conversationListItemL.requestLayout();
                        conversationListItemL.invalidate();
                        return;
                    }
                    return;
                }
                if (i2 == 2 && conversationListItemL.w()) {
                    if (conversationListItemL.I(i4)) {
                        conversationListItemL.requestLayout();
                        conversationListItemL.invalidate();
                        return;
                    }
                    return;
                }
            }
        }
    }

    static void r1(C0269z c0269z, Context context, Set set) {
        if (c0269z.f5811z0 != null) {
            Log.e("ConversationFragment", "add black list task is running");
            return;
        }
        A a2 = new A(c0269z, context, set);
        c0269z.f5811z0 = a2;
        a2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static void t1(C0269z c0269z, boolean z4) {
        View view;
        Objects.requireNonNull(c0269z);
        if (!z4) {
            c0269z.C1();
            return;
        }
        Log.i("ConversationFragment", "globalBanner");
        if (c0269z.f5803r0 == null) {
            View viewInflate = LayoutInflater.from(c0269z.f5790c0).inflate(R.layout.global_recommend_bar, (ViewGroup) null, false);
            View viewFindViewById = viewInflate.findViewById(R.id.recommend_content);
            c0269z.f5803r0 = viewFindViewById;
            viewFindViewById.setVisibility(8);
            c0269z.f5795h0.T0(null);
            boolean zT0 = c0269z.f5795h0.T0(c0269z.f5793f0);
            c0269z.f5795h0.K0(viewInflate);
            if (zT0 && (view = c0269z.f5793f0) != null) {
                c0269z.f5795h0.K0(view);
            }
        }
        if (c0269z.f5803r0.getVisibility() != 0 || c0269z.f5783E0) {
            TextView textView = (TextView) c0269z.f5803r0.findViewById(R.id.recommend_message);
            Y1.a.e((TextView) c0269z.f5803r0.findViewById(R.id.recommend_mg0), textView);
            c0269z.f5803r0.setVisibility(0);
            c0269z.f5783E0 = false;
            BlankView blankView = c0269z.f5805t0;
            if (blankView != null) {
                blankView.setVisibility(8);
                c0269z.f5805t0 = null;
            }
            ((DispatchFrameLayout) c0269z.f5791d0.findViewById(R.id.content)).a();
        }
    }

    static void w1(C0269z c0269z, int i2) {
        c0269z.f5796i0.setHint(R.string.search_hint);
        c0269z.f5794g0 = c0269z.f5791d0.findViewById(R.id.empty_view);
        if (c0269z.f5805t0 == null) {
            View viewFindViewById = c0269z.f5791d0.findViewById(R.id.blank_view);
            if (viewFindViewById instanceof ViewStub) {
                c0269z.f5805t0 = (BlankView) ((ViewStub) viewFindViewById).inflate();
            } else {
                c0269z.f5805t0 = (BlankView) viewFindViewById;
            }
        }
        if (i2 != 0) {
            c0269z.f5794g0.setVisibility(8);
            c0269z.f5805t0.setVisibility(8);
            c0269z.f5795h0.setVisibility(0);
            c0269z.f5805t0 = null;
            ((DispatchFrameLayout) c0269z.f5791d0.findViewById(R.id.content)).a();
            return;
        }
        View view = c0269z.f5803r0;
        if (view == null || view.getVisibility() != 0) {
            c0269z.f5794g0.setVisibility(0);
            c0269z.f5805t0.setVisibility(0);
        } else {
            c0269z.f5805t0.setVisibility(8);
            c0269z.f5805t0.setVisibility(8);
        }
        c0269z.f5795h0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        D1(this.f5790c0);
        this.f5784F0.removeMessages(1003);
        this.f5784F0.sendEmptyMessageDelayed(1003, 10L);
        if (this.f5790c0 instanceof MmsTabActivity) {
            this.f5784F0.removeMessages(1001);
            this.f5784F0.sendEmptyMessageDelayed(1001, 1500L);
        }
        if (this.f5790c0 instanceof MmsTabActivity) {
            C0414a.K();
        }
    }

    protected void D1(Context context) {
        this.p0 = com.android.mmt.util.C.d(context);
        if (androidx.preference.g.c(context).getBoolean("pref_key_show_blocked_messages", true)) {
            this.f5807v0 |= 1;
        } else {
            this.f5807v0 &= -2;
        }
    }

    protected final void E1() {
        this.f5790c0.getApplicationContext();
        C0287t.H(this.f5789K0);
        HandlerThread handlerThread = new HandlerThread("Conv Thread", 10);
        this.f5781C0 = handlerThread;
        handlerThread.start();
        this.f5782D0 = new i(this.f5781C0.getLooper());
    }

    protected void F1() {
        if (this.p0) {
            C0416c.U(this.f5790c0.getApplicationContext());
        } else {
            C0416c.S(this.f5790c0.getApplicationContext());
        }
    }

    public final void G1(boolean z4) {
        View view = this.f5804s0;
        if (view == null) {
            return;
        }
        if (z4) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    protected void H1(boolean z4) {
        try {
            m mVar = this.f5798k0;
            if (mVar == null) {
                return;
            }
            mVar.a(1701);
            C0416c.e0(this.f5798k0, this.p0, this.f5807v0);
            if (z4) {
                this.f5798k0.a(1903);
                C0416c.g0(this.f5798k0);
            }
        } catch (SQLiteException e2) {
            com.android.mmt.util.O.a(this.f5790c0, e2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5790c0 = x();
        this.f5791d0 = layoutInflater.inflate(R.layout.conversation_list_screen, viewGroup, false);
        B();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        this.f5799l0 = linearLayoutManager;
        linearLayoutManager.q1(1);
        EditableListViewV2 editableListViewV2 = (EditableListViewV2) this.f5791d0.findViewById(android.R.id.list);
        this.f5795h0 = editableListViewV2;
        editableListViewV2.setOnKeyListener(this.f5787I0);
        this.f5795h0.K1(new l());
        this.f5795h0.u0(this.f5799l0);
        this.f5795h0.s0(new androidx.recyclerview.widget.e());
        F f4 = new F(this.f5790c0, null, true, true);
        this.f5797j0 = f4;
        f4.U(this.f5809x0);
        this.f5797j0.V(this.f5810y0);
        this.f5795h0.p0(this.f5797j0);
        this.f5795h0.v0(this.f5797j0);
        this.f5795h0.U0(new D(this));
        View viewFindViewById = this.f5791d0.findViewById(R.id.header_view);
        this.f5792e0 = viewFindViewById;
        viewFindViewById.setOnClickListener(new f());
        C1();
        this.f5793f0 = null;
        this.f5800m0 = false;
        this.f5801n0 = false;
        this.f5796i0 = (TextView) this.f5792e0.findViewById(android.R.id.input);
        this.f5784F0.post(new g());
        Cursor cursor = this.f5808w0;
        if (cursor != null) {
            this.f5797j0.e(cursor);
            this.f5797j0.W();
            this.f5808w0 = null;
            Log.i("Mms", Y1.a.h("using cached thread list cursor", new Object[0]));
        }
        E1();
        View viewFindViewById2 = this.f5791d0.findViewById(R.id.fab);
        this.f5804s0 = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new E(this));
        this.f5802o0 = false;
        S2.e.a().postDelayed(new h(), 1000L);
        this.f5801n0 = com.android.mmt.util.C.c(x());
        this.q0 = com.android.mmt.util.C.a(x());
        return this.f5791d0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void i0() {
        AsyncTask<Void, Set<Long>, Void> asyncTask = this.f5811z0;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.f5811z0 = null;
        miuix.appcompat.app.g gVar = f5778L0;
        if (gVar != null) {
            gVar.dismiss();
        }
        f5778L0 = null;
        this.f5781C0.quit();
        this.f5781C0 = null;
        this.f5784F0.removeMessages(1003);
        this.f5784F0.removeMessages(1001);
        this.f5784F0.removeMessages(1005);
        this.f5784F0.removeMessages(1007);
        com.android.mmt.util.K.d(this.f5784F0);
        this.f5797j0.e(null);
        Cursor cursor = this.f5808w0;
        if (cursor != null) {
            cursor.close();
            this.f5808w0 = null;
        }
        this.f5790c0.getApplicationContext();
        C0287t.M(this.f5789K0);
        this.f5797j0.X();
        this.f5802o0 = true;
        super.i0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void n0() {
        this.f5783E0 = true;
        super.n0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        for (int i2 = 0; i2 < this.f5799l0.A(); i2++) {
            View viewZ = this.f5799l0.z(i2);
            if (F.L(viewZ) != null && F.L(viewZ).H()) {
                break;
            }
        }
        this.f5797j0.R(this.f5786H0);
        this.f5806u0 = true;
        this.f5779A0 = false;
        z1();
    }

    @Override // androidx.fragment.app.Fragment
    public final void s0() {
        super.s0();
        this.f5797j0.R(null);
        for (int i2 = 0; i2 < this.f5799l0.A(); i2++) {
            View viewZ = this.f5799l0.z(i2);
            if (viewZ instanceof ConversationListItem) {
                ((ConversationListItem) viewZ).F();
            } else if (viewZ instanceof C0158d) {
                Objects.requireNonNull((C0158d) viewZ);
                throw null;
            }
        }
        Handler handler = this.f5784F0;
        if (handler != null) {
            handler.removeMessages(1001);
            this.f5784F0.removeMessages(1003);
            this.f5784F0.removeMessages(1007);
            com.android.mmt.util.K.d(this.f5784F0);
        }
        this.f5779A0 = true;
        A1();
    }

    @Override // androidx.fragment.app.Fragment
    public final void t0(Bundle bundle) {
        this.f5797j0.N();
        this.f5797j0.S(this.f5785G0);
    }
}
