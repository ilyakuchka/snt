package com.android.mmt.ui;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.transaction.TransactionService;
import com.android.mmt.ui.C0243g0;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.ui.MessageListPullViewV2;
import com.android.mmt.ui.r;
import com.android.mmt.util.AbstractHandlerC0272d;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0289v;
import com.android.mmt.util.EditableListViewV2;
import f0.C0303b;
import g0.C0313i;
import g0.C0318n;
import j0.C0337b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import l0.C0345d;
import miuix.appcompat.app.g;
import n0.InterfaceC0354a;
import r0.C0376a;
import s0.C0380a;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public abstract class r extends P implements MessageListPullViewV2.b {
    protected static miuix.appcompat.app.g G1;
    private int A1;
    private final Handler B1;
    private final C0247i0.f C1;

    /* renamed from: D1, reason: collision with root package name */
    private Runnable f5691D1;
    protected miuix.view.a E1;

    /* renamed from: F1, reason: collision with root package name */
    private final Handler f5692F1;

    /* renamed from: O0, reason: collision with root package name */
    private boolean f5693O0;

    /* renamed from: P0, reason: collision with root package name */
    protected MessageListPullViewV2 f5694P0;

    /* renamed from: Q0, reason: collision with root package name */
    protected C0247i0 f5695Q0;

    /* renamed from: R0, reason: collision with root package name */
    protected View f5696R0;

    /* renamed from: S0, reason: collision with root package name */
    protected View f5697S0;

    /* renamed from: T0, reason: collision with root package name */
    private TextView f5698T0;

    /* renamed from: U0, reason: collision with root package name */
    private TextView f5699U0;

    /* renamed from: V0, reason: collision with root package name */
    private int f5700V0;

    /* renamed from: W0, reason: collision with root package name */
    private boolean f5701W0;

    /* renamed from: X0, reason: collision with root package name */
    protected l f5702X0;

    /* renamed from: Y0, reason: collision with root package name */
    private ContentResolver f5703Y0;

    /* renamed from: Z0, reason: collision with root package name */
    protected long f5704Z0;

    /* renamed from: a1, reason: collision with root package name */
    private int f5705a1;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f5706b1;

    /* renamed from: e1, reason: collision with root package name */
    protected C0415b f5709e1;

    /* renamed from: f1, reason: collision with root package name */
    protected int f5710f1;

    /* renamed from: g1, reason: collision with root package name */
    private String f5711g1;

    /* renamed from: i1, reason: collision with root package name */
    protected int f5713i1;

    /* renamed from: j1, reason: collision with root package name */
    private String f5714j1;

    /* renamed from: l1, reason: collision with root package name */
    private String f5716l1;

    /* renamed from: m1, reason: collision with root package name */
    private boolean f5717m1;

    /* renamed from: n1, reason: collision with root package name */
    private int f5718n1;

    /* renamed from: o1, reason: collision with root package name */
    private int f5719o1;

    /* renamed from: p1, reason: collision with root package name */
    private int f5720p1;

    /* renamed from: q1, reason: collision with root package name */
    private int f5721q1;

    /* renamed from: r1, reason: collision with root package name */
    private ViewGroup f5722r1;

    /* renamed from: s1, reason: collision with root package name */
    protected r f5723s1;

    /* renamed from: t1, reason: collision with root package name */
    protected boolean f5724t1;
    private r0.c u1;
    private ViewTreeObserver.OnGlobalLayoutListener v1;
    private Runnable w1;
    private boolean x1;
    private int y1;
    private Runnable z1;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f5707c1 = false;

    /* renamed from: d1, reason: collision with root package name */
    protected boolean f5708d1 = true;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f5712h1 = false;

    /* renamed from: k1, reason: collision with root package name */
    private boolean f5715k1 = false;

    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                r.y1(r.this, "mms", message);
                return;
            }
            if (i2 == 2) {
                r.y1(r.this, "sms", message);
                return;
            }
            if (i2 != 3) {
                if (i2 == 4 || i2 == 5) {
                    r.x1(r.this, "sms", message);
                    return;
                }
                if (i2 != 7) {
                    if (i2 == 100) {
                        com.android.mmt.util.G.b();
                        return;
                    } else {
                        if (i2 == 101) {
                            com.android.mmt.util.G.c();
                            return;
                        }
                        StringBuilder sbD = D2.e.d("Unknown message: ");
                        sbD.append(message.what);
                        Log.w("ConversationBase", sbD.toString());
                        return;
                    }
                }
            }
            r.x1(r.this, "mms", message);
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.f5246Z.T();
        }
    }

    final class c implements C0247i0.f {
        c() {
        }
    }

    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.f5246Z.i0();
            r.this.h2();
        }
    }

    final class e implements miuix.view.a {
        e() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
            int childCount = r.this.f5694P0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                KeyEvent.Callback childAt = r.this.f5694P0.getChildAt(i2);
                if (childAt instanceof EditableListViewV2.e) {
                    ((EditableListViewV2.e) childAt).b(z4);
                }
            }
            r.this.f5221F.setVisibility(8);
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
            int childCount = r.this.f5694P0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                KeyEvent.Callback childAt = r.this.f5694P0.getChildAt(i2);
                if (childAt instanceof EditableListViewV2.e) {
                    ((EditableListViewV2.e) childAt).c(z4, f4);
                }
            }
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
            int childCount = r.this.f5694P0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                KeyEvent.Callback childAt = r.this.f5694P0.getChildAt(i2);
                if (childAt instanceof EditableListViewV2.e) {
                    ((EditableListViewV2.e) childAt).a(z4);
                }
            }
            r.this.f5695Q0.X(false);
            View view = r.this.f5221F;
            if (z4) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    final class f implements r0.c {
        f() {
        }

        @Override // r0.c
        public final void a(Object obj) {
            r rVar = r.this;
            int i2 = rVar.f5710f1 - 1;
            rVar.f5710f1 = i2;
            if (i2 <= 0) {
                miuix.appcompat.app.g gVar = r.G1;
                if (gVar != null) {
                    gVar.dismiss();
                    r.G1 = null;
                }
                if (obj instanceof n) {
                    Q2.c.a(new RunnableC0260p(obj));
                }
            }
        }
    }

    final class g extends Handler {
        g() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 0) {
                super.handleMessage(message);
                return;
            }
            if (r.this.f5700V0 > 20) {
                r.this.f5718n1 = 21;
                r.J1(r.this);
            } else {
                r rVar = r.this;
                rVar.f5718n1 = rVar.f5700V0 + 1;
                r.this.f5700V0 = 0;
                r.this.f5694P0.P1(false);
            }
            r.this.f5717m1 = true;
            r.this.h2();
            r.this.f5694P0.O1();
        }
    }

    final class h implements ViewTreeObserver.OnGlobalLayoutListener {
        h() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            StringBuilder sbD = D2.e.d("start querying msg onGlobalLayout: ");
            sbD.append(r.this.f5250d0);
            Log.v("ConversationBase", sbD.toString());
            r rVar = r.this;
            rVar.f5273y0.removeCallbacks(rVar.w1);
            r rVar2 = r.this;
            rVar2.f5273y0.postDelayed(rVar2.w1, r.this.f5250d0 ? 0L : 100L);
        }
    }

    final class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("ConversationBase", "post start msg list query");
            r.this.h2();
            if (r.this.f5694P0 != null) {
                Log.d("ConversationBase", "remove global layout listener");
                r.this.f5694P0.getViewTreeObserver().removeGlobalOnLayoutListener(r.this.v1);
            }
            r.this.f5706b1 = false;
        }
    }

    final class j extends RecyclerView.o {
        j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public final void a(RecyclerView recyclerView, int i2) {
            Objects.requireNonNull(r.this);
            r.this.d2(i2);
            r.this.f5695Q0.W(i2);
            r.this.f5694P0.N1(false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public final void b(RecyclerView recyclerView) {
            RecyclerView.l lVarP = recyclerView.P();
            if (lVarP instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) lVarP;
                r.this.f5719o1 = linearLayoutManager.b1();
                r.this.f5720p1 = linearLayoutManager.A();
                int unused = r.this.f5719o1;
                int unused2 = r.this.f5720p1;
            }
        }
    }

    final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            r.this.f5694P0.N1(true);
        }
    }

    protected final class l extends AbstractHandlerC0272d {

        final class a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Object f5736i;

            a(Object obj) {
                this.f5736i = obj;
            }

            @Override // java.lang.Runnable
            public final void run() {
                L0.b.a(((n) this.f5736i).a(), true);
            }
        }

        public l(ContentResolver contentResolver) {
            super(contentResolver);
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void b(int i2, Object obj, int i4) {
            r rVar = r.this;
            int i5 = rVar.f5710f1 - 1;
            rVar.f5710f1 = i5;
            if (i5 <= 0) {
                miuix.appcompat.app.g gVar = r.G1;
                if (gVar != null) {
                    gVar.dismiss();
                    r.G1 = null;
                }
                if (obj instanceof n) {
                    Q2.c.a(new a(obj));
                }
            }
        }

        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void c(int i2, Object obj, Cursor cursor) {
            if (i2 != 9527) {
                return;
            }
            if (!r.this.f5712h1) {
                if (cursor != null) {
                    r.C1(r.this, cursor);
                }
                D0.a.a(r.this.f5269w0.longValue());
            } else if (cursor != null) {
                cursor.close();
            }
            if (r.this.x1) {
                r.this.x1 = false;
                long jI = r.this.f5246Z.I();
                if (jI <= 0) {
                    return;
                }
                Q2.c.a(new RunnableC0267x(jI));
            }
        }
    }

    private class m implements DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        protected List<C0243g0> f5737i;

        /* renamed from: j, reason: collision with root package name */
        public ActionMode f5738j;

        public m(List<C0243g0> list, ActionMode actionMode) {
            this.f5737i = list;
            this.f5738j = actionMode;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
        @Override // android.content.DialogInterface.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onClick(DialogInterface dialogInterface, int i2) {
            String str;
            String string;
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            miuix.appcompat.app.g gVar = (miuix.appcompat.app.g) dialogInterface;
            C0247i0 c0247i0 = r.this.f5695Q0;
            long jS = c0247i0.S(c0247i0.d);
            for (C0243g0 c0243g0 : this.f5737i) {
                if (jS == c0243g0.z()) {
                    Objects.requireNonNull(r.this.f5695Q0);
                }
                if ("mms".equals(c0243g0.I())) {
                    hashSet2.add(Long.valueOf(c0243g0.z()));
                } else if ("sms".equals(c0243g0.I())) {
                    r rVar = r.this;
                    Objects.requireNonNull(rVar);
                    if (rVar instanceof MultipleRecipientsConversationActivity) {
                        hashSet.add(Long.valueOf(c0243g0.m()));
                    } else {
                        hashSet.add(Long.valueOf(c0243g0.z()));
                    }
                }
            }
            if (!gVar.g()) {
                r rVar2 = r.this;
                Objects.requireNonNull(rVar2);
                str = rVar2 instanceof MultipleRecipientsConversationActivity ? "" : "locked = 0";
            }
            r.this.f5710f1 = 0;
            if (!hashSet.isEmpty()) {
                n nVar = new n(r.this.f5246Z.I());
                r rVar3 = r.this;
                Objects.requireNonNull(rVar3);
                if (rVar3 instanceof MultipleRecipientsConversationActivity) {
                    string = String.format("(%s=%s AND (%s IN (%s)))", "thread_id", Long.valueOf(r.this.f5246Z.I()), "date", TextUtils.join(",", hashSet));
                } else {
                    nVar.c(hashSet);
                    StringBuilder sbD = D2.e.d("_id IN (");
                    sbD.append(TextUtils.join(",", hashSet));
                    sbD.append(")");
                    string = sbD.toString();
                }
                r rVar4 = r.this;
                rVar4.f5710f1++;
                rVar4.f5702X0.e(9700, nVar, Telephony.Sms.CONTENT_URI, DatabaseUtils.concatenateWhere(str, string), null);
                new ArrayList().addAll(hashSet);
            }
            if (!hashSet2.isEmpty()) {
                StringBuilder sbD2 = D2.e.d("_id IN (");
                sbD2.append(TextUtils.join(",", hashSet2));
                sbD2.append(")");
                String string2 = sbD2.toString();
                n nVar2 = new n(r.this.f5246Z.I());
                nVar2.c(hashSet2);
                r.this.f5710f1++;
                r0.d.h(nVar2, Telephony.Mms.CONTENT_URI, DatabaseUtils.concatenateWhere(str, string2), r.this.u1, r.this.f5695Q0.M());
            }
            r rVar5 = r.this;
            if (rVar5.f5710f1 > 0) {
                miuix.appcompat.app.g gVarC = com.android.mmt.util.e0.c(rVar5, R.string.batch_deleting_message_progress_message);
                r.G1 = gVarC;
                gVarC.show();
            }
            this.f5738j.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class n {

        /* renamed from: a, reason: collision with root package name */
        private long f5740a;

        /* renamed from: b, reason: collision with root package name */
        private Set<Long> f5741b = new HashSet();

        public n(long j2) {
            this.f5740a = j2;
        }

        public final long a() {
            return this.f5740a;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set<java.lang.Long>] */
        public final void b(long j2) {
            this.f5741b.add(Long.valueOf(j2));
        }

        public final void c(Set<Long> set) {
            this.f5741b.addAll(set);
        }
    }

    private class o implements DialogInterface.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        private final C0243g0 f5742i;

        /* renamed from: j, reason: collision with root package name */
        private final long f5743j;

        /* renamed from: k, reason: collision with root package name */
        private final Uri f5744k;

        /* renamed from: l, reason: collision with root package name */
        private final boolean f5745l;

        /* renamed from: m, reason: collision with root package name */
        private final long f5746m;

        /* renamed from: n, reason: collision with root package name */
        private final boolean f5747n;

        /* renamed from: o, reason: collision with root package name */
        private final ActionMode f5748o;

        public o(C0243g0 c0243g0, ActionMode actionMode) {
            this.f5742i = c0243g0;
            this.f5743j = c0243g0.z();
            this.f5744k = c0243g0.v();
            this.f5745l = c0243g0.T();
            this.f5746m = c0243g0.m();
            this.f5747n = c0243g0.Z();
            this.f5748o = actionMode;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            r.this.i2(this.f5743j);
            r.this.W1(this.f5742i, this.f5743j, this.f5744k, this.f5745l, this.f5746m, this.f5747n);
            dialogInterface.dismiss();
            ActionMode actionMode = this.f5748o;
            if (actionMode != null) {
                actionMode.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public class p implements EditableListViewV2.f {

        /* renamed from: a, reason: collision with root package name */
        private miuix.view.b f5749a;

        /* renamed from: b, reason: collision with root package name */
        private EditableListViewV2.j f5750b;

        /* renamed from: c, reason: collision with root package name */
        private Menu f5751c;

        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                r.this.f5694P0.N1(true);
            }
        }

        protected p() {
        }

        public static void c(p pVar, C0243g0 c0243g0, DialogInterface.OnClickListener onClickListener) throws Throwable {
            String string;
            r rVar = r.this;
            long jZ = c0243g0.z();
            Objects.requireNonNull(rVar);
            C0313i c0313iA = q.a(rVar, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, jZ));
            if (c0313iA == null) {
                string = null;
                break;
            }
            StringBuilder sb = new StringBuilder();
            int iH = c0313iA.h();
            for (int i2 = 0; i2 < iH; i2++) {
                C0318n c0318nC = c0313iA.c(i2);
                String str = new String(c0318nC.g());
                if (C0337b.f(str) || C0337b.h(str) || C0337b.d(str) || str.equals("application/ogg")) {
                    String strZ = P0.r.z(rVar, c0318nC, Long.toHexString(jZ));
                    if (strZ == null) {
                        string = null;
                        break;
                    } else {
                        sb.append("\n");
                        sb.append(strZ);
                    }
                }
            }
            string = sb.toString();
            g.a aVar = new g.a(r.this);
            aVar.x(R.string.copy_to_sdcard);
            aVar.h();
            if (string != null) {
                aVar.k(r.this.getString(R.string.copy_to_sdcard_success, string));
            } else {
                aVar.j(R.string.copy_to_sdcard_fail);
            }
            aVar.o(onClickListener);
            aVar.A();
        }

        private List<C0243g0> d() {
            return r.this.f5695Q0.Q(this.f5750b.d());
        }

        /* JADX WARN: Removed duplicated region for block: B:130:0x02cb  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x02d5  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x02f1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void e(int i2) {
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            ((ActionMode) this.f5749a).setTitle(i2 == 0 ? r.this.getString(R.string.miuix_appcompat_action_mode_title_empty) : r.this.getResources().getQuantityString(R.plurals.miuix_appcompat_items_selected, this.f5750b.b(), Integer.valueOf(this.f5750b.b())));
            boolean zH = com.android.mmt.util.e0.h();
            if (this.f5750b.e()) {
                this.f5749a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_deselect_all_light);
            } else {
                this.f5749a.d(android.R.id.button2, zH ? R.drawable.miuix_appcompat_action_mode_title_button_select_all_dark : R.drawable.miuix_appcompat_action_mode_title_button_select_all_light);
            }
            Objects.requireNonNull(r.this);
            if (i2 > 1) {
                boolean z10 = r.this.z0().size() > 1;
                long jI = r.this.f5246Z.I();
                if (z10) {
                    z5 = true;
                    z6 = true;
                    z7 = false;
                    z8 = false;
                    z9 = false;
                } else {
                    Iterator it = ((ArrayList) d()).iterator();
                    z5 = true;
                    z6 = true;
                    z7 = false;
                    z8 = false;
                    z9 = false;
                    while (it.hasNext()) {
                        C0243g0 c0243g0 = (C0243g0) it.next();
                        if (!c0243g0.T() && c0243g0.H() == jI && c0243g0.P()) {
                            z6 = false;
                        }
                        if (c0243g0.T()) {
                            z9 = true;
                        }
                        if (c0243g0.J()) {
                            z7 = true;
                        }
                        if (c0243g0.P()) {
                            z8 = true;
                        }
                        if (c0243g0.U() && c0243g0.w() == 6) {
                            z5 = false;
                        }
                    }
                }
                int size = this.f5751c.size();
                for (int i4 = 0; i4 < size; i4++) {
                    MenuItem item = this.f5751c.getItem(i4);
                    switch (item.getItemId()) {
                        case R.id.action_copy_message_text /* 2131361851 */:
                            item.setEnabled(z7);
                            break;
                        case R.id.action_copy_to_sim /* 2131361853 */:
                            item.setVisible(false);
                            break;
                        case R.id.action_delete_message /* 2131361854 */:
                            item.setEnabled(true);
                            break;
                        case R.id.action_forward_message /* 2131361856 */:
                            item.setEnabled(z8 && z5);
                            break;
                        case R.id.action_lock_message /* 2131361859 */:
                            if (!z8 || z10) {
                                item.setVisible(true);
                                item.setEnabled(false);
                                break;
                            } else if (z6) {
                                item.setVisible(!z9);
                                item.setEnabled(false);
                                break;
                            } else {
                                item.setVisible(true);
                                item.setEnabled(true);
                                break;
                            }
                        case R.id.action_report_message /* 2131361867 */:
                            item.setVisible(false);
                            break;
                        case R.id.action_select_copy_text /* 2131361868 */:
                            item.setVisible(false);
                            break;
                        case R.id.action_show_delivery_status /* 2131361869 */:
                            item.setVisible(false);
                            break;
                        case R.id.action_unlock_message /* 2131361872 */:
                            if (!z8 || z10) {
                                item.setVisible(false);
                                break;
                            } else if (z6) {
                                item.setVisible(z9);
                                item.setEnabled(true);
                                break;
                            } else {
                                item.setVisible(false);
                                break;
                            }
                        default:
                            item.setEnabled(false);
                            break;
                    }
                }
                return;
            }
            if (i2 != 1) {
                int size2 = this.f5751c.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    MenuItem item2 = this.f5751c.getItem(i5);
                    switch (item2.getItemId()) {
                        case R.id.action_copy_to_sim /* 2131361853 */:
                            item2.setVisible(false);
                            break;
                        case R.id.action_lock_message /* 2131361859 */:
                            item2.setVisible(true);
                            item2.setEnabled(false);
                            break;
                        case R.id.action_report_message /* 2131361867 */:
                            item2.setVisible(false);
                            break;
                        case R.id.action_select_copy_text /* 2131361868 */:
                            item2.setVisible(false);
                            break;
                        case R.id.action_show_delivery_status /* 2131361869 */:
                            item2.setVisible(false);
                            break;
                        case R.id.action_unlock_message /* 2131361872 */:
                            item2.setVisible(false);
                            break;
                        default:
                            item2.setEnabled(false);
                            break;
                    }
                }
                return;
            }
            ArrayList arrayList = (ArrayList) d();
            if (arrayList.size() != 1) {
                StringBuilder sbD = D2.e.d("prepareSingleSelectionMenu: expect size=1 but size=");
                sbD.append(arrayList.size());
                Log.e("ConversationBase", sbD.toString());
                return;
            }
            C0243g0 c0243g02 = (C0243g0) arrayList.get(0);
            if (c0243g02.R() || !c0243g02.P() || r.this.f5246Z.I() != c0243g02.H()) {
                this.f5751c.findItem(R.id.action_unlock_message).setVisible(false);
                this.f5751c.findItem(R.id.action_lock_message).setVisible(true);
                this.f5751c.findItem(R.id.action_lock_message).setEnabled(false);
            } else if (c0243g02.T()) {
                this.f5751c.findItem(R.id.action_unlock_message).setVisible(true);
                this.f5751c.findItem(R.id.action_unlock_message).setEnabled(true);
                this.f5751c.findItem(R.id.action_lock_message).setVisible(false);
            } else if (!c0243g02.T()) {
                this.f5751c.findItem(R.id.action_unlock_message).setVisible(false);
                this.f5751c.findItem(R.id.action_lock_message).setVisible(true);
                this.f5751c.findItem(R.id.action_lock_message).setEnabled(true);
            }
            this.f5751c.findItem(R.id.action_delete_message).setEnabled(true);
            this.f5751c.findItem(R.id.action_copy_message_text).setEnabled(c0243g02.J());
            this.f5751c.findItem(R.id.action_view_message_details).setEnabled(true);
            if (c0243g02.R() && c0243g02.U()) {
                this.f5751c.findItem(R.id.action_show_delivery_status).setVisible(true);
                this.f5751c.findItem(R.id.action_show_delivery_status).setEnabled(true);
            }
            if (c0243g02.U()) {
                r rVar = r.this;
                Objects.requireNonNull(rVar);
                C0313i c0313iA = q.a(rVar, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, c0243g02.z()));
                if (c0313iA == null) {
                    z4 = false;
                    if (z4) {
                        this.f5751c.findItem(R.id.action_copy_to_sdcard).setEnabled(false);
                    } else {
                        this.f5751c.findItem(R.id.action_copy_to_sdcard).setEnabled(true);
                    }
                    this.f5751c.findItem(R.id.action_forward_message).setEnabled((c0243g02.P() || c0243g02.w() == 6) ? false : true);
                    this.f5751c.findItem(R.id.action_copy_to_sim).setVisible(false);
                } else {
                    int iH = c0313iA.h();
                    for (int i6 = 0; i6 < iH; i6++) {
                        String str = new String(c0313iA.c(i6).g());
                        if (Log.isLoggable("Mms:app", 2)) {
                            Log.v("ConversationBase", "[CMA] haveSomethingToCopyToSDCard: part[" + i6 + "] contentType=" + str);
                        }
                        if (C0337b.f(str) || C0337b.h(str) || C0337b.d(str) || str.equals("application/ogg")) {
                            z4 = true;
                            break;
                        }
                    }
                    z4 = false;
                    if (z4) {
                    }
                    if (c0243g02.P()) {
                        this.f5751c.findItem(R.id.action_forward_message).setEnabled((c0243g02.P() || c0243g02.w() == 6) ? false : true);
                        this.f5751c.findItem(R.id.action_copy_to_sim).setVisible(false);
                    }
                }
            } else {
                this.f5751c.findItem(R.id.action_copy_to_sdcard).setEnabled(false);
                this.f5751c.findItem(R.id.action_forward_message).setEnabled(true);
                if (C0287t.d() > 0) {
                    this.f5751c.findItem(R.id.action_copy_to_sim).setVisible(false);
                } else {
                    this.f5751c.findItem(R.id.action_copy_to_sim).setVisible(false);
                }
            }
            MenuItem menuItemFindItem = this.f5751c.findItem(R.id.action_report_message);
            Objects.requireNonNull(r.this);
            menuItemFindItem.setVisible(false);
        }

        @Override // com.android.mmt.util.EditableListViewV2.f
        public final void a(EditableListViewV2.j jVar) {
            this.f5750b = jVar;
            r.this.f5695Q0.Y(jVar.a());
            e(this.f5750b.b());
        }

        @Override // com.android.mmt.util.EditableListViewV2.f
        public final void b(View view, boolean z4, boolean z5) {
            if (z5) {
                r.this.f5695Q0.n();
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
            boolean z4;
            NetworkInfo networkInfo;
            List<C0243g0> listD = d();
            int itemId = menuItem.getItemId();
            ArrayList arrayList = (ArrayList) listD;
            int size = arrayList.size();
            if (size == 0) {
                if (menuItem.getItemId() == 16908313) {
                    actionMode.finish();
                } else if (menuItem.getItemId() != 16908314) {
                    Log.e("ConversationBase", String.format("onMenuItemClick: invalid params, checkedItems.size=%d, menuId=%d", Integer.valueOf(size), Integer.valueOf(itemId)));
                } else if (this.f5750b.e()) {
                    this.f5750b.f();
                } else {
                    this.f5750b.c();
                }
            } else if (size == 1 || itemId == R.id.action_lock_message || itemId == R.id.action_unlock_message || itemId == R.id.action_delete_message || itemId == R.id.action_copy_message_text || itemId == R.id.action_forward_message || itemId == 16908313 || itemId == 16908314 || itemId == R.id.action_report_message || itemId == R.id.action_select_copy_text || itemId == R.id.action_show_delivery_status) {
                final DialogInterfaceOnClickListenerC0268y dialogInterfaceOnClickListenerC0268y = new DialogInterfaceOnClickListenerC0268y(actionMode);
                final C0243g0 c0243g0 = (C0243g0) arrayList.get(0);
                switch (menuItem.getItemId()) {
                    case android.R.id.button1:
                        actionMode.finish();
                        break;
                    case android.R.id.button2:
                        if (!this.f5750b.e()) {
                            this.f5750b.c();
                            break;
                        } else {
                            this.f5750b.f();
                            break;
                        }
                    case R.id.action_copy_message_text /* 2131361851 */:
                        P0.r.c(r.this, listD);
                        actionMode.finish();
                        break;
                    case R.id.action_copy_to_sdcard /* 2131361852 */:
                        final int i2 = 1;
                        Runnable runnable = new Runnable() { // from class: m0.a
                            @Override // java.lang.Runnable
                            public final void run() throws Throwable {
                                switch (i2) {
                                    case 0:
                                        ((C0345d) ((InterfaceC0354a) this)).j((String) c0243g0, (List) dialogInterfaceOnClickListenerC0268y);
                                        break;
                                    case 1:
                                        r.p.c((r.p) this, (C0243g0) c0243g0, (DialogInterface.OnClickListener) dialogInterfaceOnClickListenerC0268y);
                                        break;
                                }
                            }
                        };
                        if (c0243g0.f() != 0) {
                            if (c0243g0.f() != 1) {
                                if (c0243g0.f() != 2) {
                                    r.this.e2(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, runnable);
                                    break;
                                } else {
                                    r.this.e2(new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"}, runnable);
                                    break;
                                }
                            } else {
                                r.this.e2(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"}, runnable);
                                break;
                            }
                        } else {
                            r.this.e2(new String[]{"android.permission.READ_MEDIA_AUDIO"}, runnable);
                            break;
                        }
                    case R.id.action_delete_message /* 2131361854 */:
                        if (1 != size) {
                            m mVar = r.this.new m(listD, actionMode);
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z4 = false;
                                } else if (((C0243g0) it.next()).T()) {
                                    z4 = true;
                                }
                            }
                            r rVar = r.this;
                            Objects.requireNonNull(rVar);
                            g.a aVar = new g.a(rVar);
                            if (z4 && !(rVar instanceof MultipleRecipientsConversationActivity)) {
                                aVar.d(rVar.f5723s1.getString(R.string.delete_unlocked));
                            }
                            aVar.x(R.string.confirm_dialog_title);
                            aVar.c(true);
                            aVar.t(R.string.delete, mVar);
                            aVar.m(R.string.no, null);
                            aVar.k(rVar.f5723s1.getResources().getQuantityString(R.plurals.batch_delete_confirm_dialog_message, size, Integer.valueOf(size)));
                            aVar.A();
                            break;
                        } else {
                            com.android.mmt.util.e0.a(r.this.f5723s1, r.this.new o(c0243g0, actionMode), null, c0243g0.T(), c0243g0.R());
                            break;
                        }
                        break;
                    case R.id.action_forward_message /* 2131361856 */:
                        P0.r.f(r.this, listD);
                        actionMode.finish();
                        break;
                    case R.id.action_lock_message /* 2131361859 */:
                        if (1 == size) {
                            P0.r.y(r.this.f5723s1, c0243g0.I(), c0243g0.z(), true);
                        } else {
                            r.G1(r.this, listD, true);
                        }
                        MessageListPullViewV2 messageListPullViewV2 = r.this.f5694P0;
                        if (messageListPullViewV2 != null && actionMode != null) {
                            messageListPullViewV2.postDelayed(new RunnableC0263t(actionMode), 200L);
                            break;
                        }
                        break;
                    case R.id.action_report_message /* 2131361867 */:
                        ConnectivityManager connectivityManager = (ConnectivityManager) C0.a.c().getSystemService("connectivity");
                        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(2);
                        if (!((networkInfo2 != null && networkInfo2.isAvailable()) || ((networkInfo = connectivityManager.getNetworkInfo(0)) != null && networkInfo.isAvailable()))) {
                            Toast.makeText(MmsApp.c(), R.string.privacy_revoke_nonetwork_title, 0).show();
                            break;
                        } else {
                            if (!com.android.mmt.util.C.b(r.this.f5723s1)) {
                                g.a aVar2 = new g.a(r.this);
                                aVar2.x(R.string.networking_allow_title);
                                aVar2.j(R.string.dialog_complain_tips);
                                aVar2.c(false);
                                aVar2.m(R.string.no, null);
                                aVar2.t(R.string.networking_allow_continue, null);
                                aVar2.A();
                            }
                            actionMode.finish();
                            break;
                        }
                        break;
                    case R.id.action_show_delivery_status /* 2131361869 */:
                        r rVar2 = r.this;
                        Objects.requireNonNull(rVar2);
                        if (c0243g0.U()) {
                            Intent intent = new Intent(rVar2, (Class<?>) StatusReportActivity.class);
                            intent.putExtra("extra_msgID", c0243g0.z());
                            rVar2.startActivity(intent);
                            break;
                        }
                        break;
                    case R.id.action_unlock_message /* 2131361872 */:
                        if (1 == size) {
                            P0.r.y(r.this.f5723s1, c0243g0.I(), c0243g0.z(), false);
                        } else {
                            r.G1(r.this, listD, false);
                        }
                        MessageListPullViewV2 messageListPullViewV22 = r.this.f5694P0;
                        if (messageListPullViewV22 != null && actionMode != null) {
                            messageListPullViewV22.postDelayed(new RunnableC0263t(actionMode), 200L);
                            break;
                        }
                        break;
                    case R.id.action_view_message_details /* 2131361874 */:
                        try {
                            String strJ = P0.r.j(r.this.getApplicationContext(), (Cursor) r.this.f5695Q0.G(((Integer) ((TreeSet) this.f5750b.d()).iterator().next()).intValue()), c0243g0);
                            g.a aVar3 = new g.a(r.this);
                            aVar3.x(R.string.message_details_title);
                            aVar3.k(strJ);
                            aVar3.t(android.R.string.ok, dialogInterfaceOnClickListenerC0268y);
                            aVar3.c(true);
                            aVar3.A();
                            break;
                        } catch (Exception e2) {
                            Log.e("ConversationBase", "onMenuItemClick: get cursor failed", e2);
                            break;
                        }
                }
            } else {
                Log.e("ConversationBase", String.format("onMenuItemClick: invalid params, checkedItems.size=%d, menuId=%d", Integer.valueOf(size), Integer.valueOf(itemId)));
            }
            int itemId2 = menuItem.getItemId();
            if (R.id.action_forward_message != itemId2 && R.id.action_copy_message_text != itemId2 && R.id.action_view_message_details != itemId2 && R.id.action_select_copy_text != itemId2 && R.id.action_show_delivery_status != itemId2) {
                return true;
            }
            actionMode.finish();
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            this.f5751c = menu;
            r.this.f5694P0.L1(false);
            r.this.getMenuInflater().inflate(R.menu.message_list_options_menu, menu);
            MenuItem menuItemFindItem = this.f5751c.findItem(R.id.action_report_message);
            Objects.requireNonNull(r.this);
            menuItemFindItem.setVisible(false);
            r.this.f5694P0.N1(false);
            miuix.view.b bVar = (miuix.view.b) actionMode;
            bVar.addAnimationListener(r.this.E1);
            r.this.f5695Q0.K();
            r.this.f5695Q0.X(true);
            this.f5750b = r.this.f5694P0.F1();
            this.f5749a = bVar;
            bVar.d(android.R.id.button1, com.android.mmt.util.e0.h() ? R.drawable.miuix_appcompat_action_mode_title_button_cancel_dark : R.drawable.miuix_appcompat_action_mode_title_button_cancel_light);
            e(0);
            r.this.s0();
            r.this.C0();
            View view = r.this.f5219E;
            if (view != null) {
                view.setVisibility(8);
            }
            r.this.e1(0);
            r.this.f5696R0.setVisibility(8);
            r.this.f5697S0.setVisibility(8);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            View view = r.this.f5219E;
            if (view != null) {
                view.setVisibility(0);
            }
            r.this.f5694P0.post(new a());
            r.this.f5695Q0.L();
            r rVar = r.this;
            rVar.e1(rVar.f5713i1);
            r.this.f5696R0.setVisibility(0);
            r.this.f5697S0.setVisibility(0);
            r.this.f5694P0.J1(true);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    private static class q {

        /* renamed from: a, reason: collision with root package name */
        private static C0313i f5753a;

        /* renamed from: b, reason: collision with root package name */
        private static Uri f5754b;

        public static C0313i a(Context context, Uri uri) {
            if (uri.equals(f5754b)) {
                return f5753a;
            }
            try {
                C0313i c0313iB = G0.p.B(context, uri);
                f5753a = c0313iB;
                f5754b = uri;
                return c0313iB;
            } catch (C0303b e2) {
                Log.e("ConversationBase", e2.getMessage(), e2);
                return null;
            }
        }
    }

    public r() {
        new ArrayList();
        this.f5722r1 = null;
        this.f5724t1 = true;
        this.u1 = new f();
        this.v1 = new h();
        this.w1 = new i();
        this.y1 = 0;
        this.A1 = -1;
        this.B1 = new a();
        this.C1 = new c();
        this.f5691D1 = new d();
        this.E1 = new e();
        this.f5692F1 = new g();
    }

    static void C1(r rVar, Cursor cursor) {
        Objects.requireNonNull(rVar);
        rVar.U1(cursor);
    }

    static void G1(r rVar, List list, boolean z4) {
        Objects.requireNonNull(rVar);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long jI = rVar.f5246Z.I();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0243g0 c0243g0 = (C0243g0) it.next();
            if (c0243g0.Z()) {
                if (c0243g0.H() == jI) {
                    if (sb.length() == 0) {
                        sb.append("_id");
                        sb.append(" in (");
                    }
                    sb.append(c0243g0.z());
                    sb.append(",");
                }
                arrayList.add(Long.valueOf(c0243g0.z()));
            } else if (c0243g0.U() && c0243g0.P()) {
                if (c0243g0.H() == jI) {
                    if (sb2.length() == 0) {
                        sb2.append("_id");
                        sb2.append(" in (");
                    }
                    sb2.append(c0243g0.z());
                    sb2.append(",");
                }
                arrayList2.add(Long.valueOf(c0243g0.z()));
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1).append(")");
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1).append(")");
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("locked", Integer.valueOf(z4 ? 1 : 0));
        Q2.c.a(new RunnableC0261q(sb, contentValues, sb2));
    }

    static /* synthetic */ int J1(r rVar) {
        int i2 = rVar.f5700V0 - 20;
        rVar.f5700V0 = i2;
        return i2;
    }

    private ContextMenu T1(ContextMenu contextMenu, C0243g0 c0243g0) {
        if (!c0243g0.R() && c0243g0.P() && this.f5246Z.I() == c0243g0.H()) {
            if (c0243g0.T()) {
                contextMenu.add(0, 1, 0, getResources().getString(R.string.menu_unlock));
            } else {
                contextMenu.add(0, 0, 0, getResources().getString(R.string.menu_lock));
            }
        }
        contextMenu.add(0, 4, 0, getResources().getString(R.string.delete));
        contextMenu.add(0, 2, 0, getResources().getString(R.string.copy_message_text));
        if ((c0243g0.U() && c0243g0.P() && c0243g0.w() != 6) || c0243g0.Z()) {
            contextMenu.add(0, 5, 0, getResources().getString(R.string.menu_forward));
        }
        contextMenu.add(0, 6, 0, getResources().getString(R.string.view_message_details));
        return contextMenu;
    }

    private void V1() {
        if (this.f5701W0 && hasWindowFocus()) {
            this.f5246Z.c0(true);
            Q2.c.a(new b());
            this.f5701W0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g2(boolean z4) {
        TextView textView = this.f5699U0;
        if (textView != null) {
            textView.setVisibility(z4 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(long j2) {
        Log.d("ConversationBase", "Stop play audio: " + j2);
        C0376a c0376aM = this.f5695Q0.M();
        if (c0376aM == null || c0376aM.a(j2) == null) {
            return;
        }
        Objects.requireNonNull(c0376aM.a(j2));
        C0380a.b(MmsApp.c()).a();
    }

    static void x1(r rVar, String str, Message message) {
        Objects.requireNonNull(rVar);
        C0243g0 c0243g0P = rVar.f5695Q0.P(str, ((Long) message.obj).longValue(), null, true);
        if (c0243g0P != null) {
            if (c0243g0P.Z()) {
                rVar.f5693O0 = true;
                int i2 = message.what;
                if (i2 == 5) {
                    Iterator<Uri> it = c0243g0P.b0().iterator();
                    while (it.hasNext()) {
                        Uri next = it.next();
                        r rVar2 = rVar.f5723s1;
                        Integer.valueOf(message.arg1).intValue();
                        if (androidx.preference.g.c(rVar2).getBoolean("pref_key_delivery_reports", MessagingPreferenceActivity.P())) {
                            C0287t.G(rVar.f5723s1, next, null, 32);
                        } else {
                            C0287t.G(rVar.f5723s1, next, null, null);
                        }
                    }
                } else if (i2 == 4) {
                    r rVar3 = rVar.f5723s1;
                    Integer.valueOf(message.arg1).intValue();
                    if (androidx.preference.g.c(rVar3).getBoolean("pref_key_delivery_reports", MessagingPreferenceActivity.P())) {
                        C0287t.G(rVar.f5723s1, c0243g0P.v(), null, 32);
                    } else {
                        C0287t.G(rVar.f5723s1, c0243g0P.v(), null, null);
                    }
                } else if (i2 == 6) {
                    C0287t.G(rVar.f5723s1, c0243g0P.v(), 0L, null);
                }
                C0287t.I(rVar.f5723s1, Integer.valueOf(message.arg1).intValue());
                return;
            }
            if (c0243g0P.U()) {
                r rVar4 = rVar.f5723s1;
                Uri uriV = c0243g0P.v();
                long id = ContentUris.parseId(uriV);
                ContentValues contentValues = new ContentValues(4);
                contentValues.put("err_type", (Integer) 0);
                contentValues.put("err_code", (Integer) 0);
                contentValues.put("retry_index", (Integer) 0);
                contentValues.put("last_try", (Integer) 0);
                com.android.mmt.util.O.g(rVar4, rVar4.getContentResolver(), Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues, "msg_id=" + id, null);
                Intent intent = new Intent(rVar4, (Class<?>) TransactionService.class);
                intent.putExtra("uri", uriV.toString());
                intent.putExtra("type", 2);
                rVar4.startService(intent);
            }
        }
    }

    static void y1(r rVar, String str, Message message) {
        Objects.requireNonNull(rVar);
        C0243g0 c0243g0P = rVar.f5695Q0.P(str, ((Long) message.obj).longValue(), null, true);
        if (c0243g0P != null) {
            if (c0243g0P.Z()) {
                synchronized (rVar.f5246Z) {
                    if (rVar.f5246Z.C() <= 1) {
                        rVar.f5246Z.k();
                    }
                }
                com.android.mmt.util.O.c(rVar, rVar.f5703Y0, ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, c0243g0P.z()), null, null);
                rVar.f5241U.a0(c0243g0P.g());
            } else {
                rVar.f5241U.r();
                x0.j jVarH = x0.j.H(rVar, c0243g0P.v(), false);
                rVar.f5241U = jVarH;
                jVarH.U(rVar.f5246Z);
                rVar.M.j(rVar.f5241U);
                rVar.f5241U.Z(c0243g0P.F(), false);
                rVar.u0();
            }
            if (c0243g0P.Q()) {
                rVar.f5695Q0.j();
            }
            rVar.X0();
            rVar.t0();
        }
    }

    @Override // com.android.mmt.ui.P
    protected void D0() {
        super.D0();
        this.f5694P0 = (MessageListPullViewV2) findViewById(R.id.message_list);
        View viewInflate = getLayoutInflater().inflate(R.layout.message_list_footer, (ViewGroup) this.f5694P0, false);
        this.f5694P0.J0(viewInflate);
        this.f5698T0 = (TextView) viewInflate.findViewById(R.id.security_alert);
        String string = getString(R.string.security_alert_desc_highlight);
        SpannableString spannableString = new SpannableString(string);
        P0.L l2 = new P0.L(this, R.style.TextAppearance_SecurityAlert);
        l2.a();
        spannableString.setSpan(l2, 0, string.length(), 33);
        this.f5698T0.append(spannableString);
        this.f5698T0.setOnClickListener(new ViewOnClickListenerC0265v(this));
        this.f5699U0 = (TextView) viewInflate.findViewById(R.id.mms_block_alert);
        String string2 = getString(R.string.mms_block_hint_highlight);
        SpannableString spannableString2 = new SpannableString(string2);
        spannableString2.setSpan(new P0.L(this, R.style.TextAppearance_MmsBlockAlert), 0, string2.length(), 33);
        this.f5699U0.append(spannableString2);
        this.f5699U0.setOnClickListener(new ViewOnClickListenerC0266w(this));
        f2();
        this.f5694P0.i(new j());
        EditText editText = this.f5235N;
        if (editText != null) {
            editText.setOnClickListener(new k());
        }
        this.f5696R0 = findViewById(R.id.message_list_top_foreground);
        this.f5697S0 = findViewById(R.id.message_list_bottom_foreground);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.contact_panel_height) + this.f5272y;
        this.f5713i1 = dimensionPixelSize;
        e1(dimensionPixelSize);
    }

    @Override // com.android.mmt.ui.P
    public final boolean G0() {
        if (A0()) {
            return C0287t.C();
        }
        return false;
    }

    @Override // com.android.mmt.ui.P
    protected final void L0() {
        if (C0287t.y()) {
            this.f5715k1 = true;
            h2();
        }
    }

    @Override // com.android.mmt.ui.P
    protected final void M0(C0415b c0415b) {
        j2(c0415b);
        if (c0415b == null || c0415b.isEmpty() || c0415b.get(0) == null) {
            return;
        }
        synchronized (c0415b.get(0)) {
        }
    }

    @Override // com.android.mmt.ui.P
    protected final void O0() {
        super.O0();
        this.f5709e1 = this.f5246Z.G();
    }

    @Override // com.android.mmt.ui.P
    protected final void R0() {
    }

    @Override // com.android.mmt.ui.P
    protected final void S0() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void U1(Cursor cursor) {
        final int position;
        boolean z4;
        TextView textView;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f5704Z0 != 0) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                if (P0.r.i(cursor.getString(0), cursor.getLong(1)) == this.f5704Z0) {
                    position = cursor.getPosition();
                    break;
                }
            }
            position = -1;
        } else {
            position = -1;
        }
        StringBuilder sbD = D2.e.d("handleNewSelectionPosition cost time is ");
        sbD.append(System.currentTimeMillis() - jCurrentTimeMillis);
        Log.v("ConversationBase", sbD.toString());
        int i2 = 23;
        if (C0287t.y() && this.f5715k1) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (cursor.moveToLast()) {
                int iQ = C0287t.q(cursor.getInt(23));
                if (C0287t.A(iQ)) {
                    this.q0 = iQ;
                }
                this.f5273y0.post(new RunnableC0262s(this, this));
                X0();
            }
            StringBuilder sbD2 = D2.e.d("handleNeedChangeSlotId cost time is ");
            sbD2.append(System.currentTimeMillis() - jCurrentTimeMillis2);
            Log.v("ConversationBase", sbD2.toString());
        }
        this.f5715k1 = false;
        boolean z5 = this.f5695Q0.d == null;
        int count = cursor.getCount() - this.f5695Q0.j();
        if (position != -1) {
            this.f5695Q0.e(cursor);
            MessageListPullViewV2 messageListPullViewV2 = this.f5694P0;
            messageListPullViewV2.n0(messageListPullViewV2.N0() + position);
            this.f5694P0.post(new Runnable() { // from class: com.android.mmt.ui.o
                @Override // java.lang.Runnable
                public final void run() {
                    r rVar = this.f5681i;
                    int i4 = position;
                    MessageListPullViewV2 messageListPullViewV22 = rVar.f5694P0;
                    messageListPullViewV22.n0(messageListPullViewV22.N0() + i4);
                }
            });
        } else if (count > 0 || z5 || this.f5705a1 > 0) {
            this.f5695Q0.e(cursor);
            if (!this.f5717m1) {
                this.f5694P0.L1(true);
            }
        } else {
            this.f5695Q0.e(cursor);
        }
        boolean z6 = this instanceof MultipleRecipientsConversationActivity;
        int i4 = 8;
        if (z6 || this.f5246Z == null) {
            Log.v("ConversationBase", "group, hms and private is not show warning info");
        } else {
            C0415b c0415bZ0 = z0();
            if (this.f5704Z0 == 0 && c0415bZ0 != null && c0415bZ0.size() == 1 && (textView = this.f5698T0) != null) {
                textView.setVisibility(8);
            }
        }
        if (z6 || this.f5246Z == null) {
            Log.v("ConversationBase", "group, hms and private is not show warning info");
        } else if (C0289v.a()) {
            C0415b c0415bZ02 = z0();
            if (this.f5704Z0 == 0 && c0415bZ02 != null && c0415bZ02.size() == 1) {
                C0414a c0414a = c0415bZ02.get(0);
                if (!c0414a.L()) {
                    synchronized (c0414a) {
                    }
                    if (c0414a.f8015b == 4) {
                        g2(false);
                    } else if (!androidx.preference.g.c(getApplicationContext()).getBoolean("already_remind_filter_stranger_mms", false)) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        if (cursor.getCount() <= 0 || !cursor.moveToLast()) {
                            z4 = false;
                        } else {
                            if (!"mms".equals(cursor.getString(0))) {
                                i2 = -1;
                                i4 = -1;
                            }
                            z4 = i4 != -1 && cursor.getInt(i4) == 1;
                            if (i2 == -1 || !z4) {
                                Log.v("ConversationBase", "not mms or inbox");
                            } else {
                                int iQ2 = C0287t.q(cursor.getLong(i2));
                                if (C0287t.A(iQ2)) {
                                    this.f5721q1 = iQ2;
                                } else {
                                    this.f5721q1 = C0287t.f();
                                }
                            }
                        }
                        g2(z4);
                        if (z4) {
                            androidx.preference.g.c(getApplicationContext()).edit().putBoolean("already_remind_filter_stranger_mms", true).apply();
                        }
                        StringBuilder sbD3 = D2.e.d("handleShowMmsBlockAlert cost time is ");
                        sbD3.append(System.currentTimeMillis() - jCurrentTimeMillis3);
                        Log.v("ConversationBase", sbD3.toString());
                    }
                }
            }
        }
        if (this.f5717m1) {
            this.f5694P0.n0(this.f5718n1);
            this.f5717m1 = false;
        }
        if (cursor.getCount() == 0 && !this.f5693O0) {
            this.f5246Z.k();
            finish();
        }
        X1();
        if (cursor.getCount() > 0) {
            this.f5693O0 = false;
        }
        EditText editText = this.f5235N;
        if (editText != null) {
            editText.requestFocus();
        }
    }

    protected final void W1(C0243g0 c0243g0, long j2, Uri uri, boolean z4, long j4, boolean z5) {
        i2(j2);
        n nVar = new n(c0243g0.H());
        nVar.b(c0243g0.z());
        if (!(this instanceof MultipleRecipientsConversationActivity)) {
            r0.d.h(nVar, uri, z4 ? null : "locked=0", this.u1, this.f5695Q0.M());
        } else if (z5) {
            String str = String.format("%s=%s AND %s=%s", "thread_id", Long.valueOf(this.f5246Z.I()), "date", Long.valueOf(j4));
            new ArrayList().add(Long.valueOf(j4));
            this.f5702X0.e(9700, nVar, Telephony.Sms.CONTENT_URI, str, null);
        } else {
            this.f5702X0.e(9700, nVar, uri, null, null);
        }
        C0247i0 c0247i0 = this.f5695Q0;
        if (c0243g0.z() == c0247i0.S(c0247i0.d)) {
            Objects.requireNonNull(this.f5695Q0);
        }
    }

    protected void X1() {
    }

    protected final void Y1() {
        if (this.f5246Z.C() <= 50 || this.f5704Z0 != 0) {
            return;
        }
        this.f5700V0 = this.f5246Z.C() - 50;
        this.f5694P0.P1(true);
    }

    protected void Z1() {
        if (this.f5695Q0 != null) {
            return;
        }
        C0247i0 c0247i0 = new C0247i0(this, null, this.f5694P0, true, this instanceof MultipleRecipientsConversationActivity, this.f5246Z.I(), this.f5714j1, this.f5716l1, this.f5704Z0);
        this.f5695Q0 = c0247i0;
        synchronized (this.f5246Z) {
        }
        c0247i0.Z();
        this.f5695Q0.a0(this.B1);
        this.f5700V0 = 0;
        this.f5694P0.p0(this.f5695Q0);
        this.f5694P0.setFocusable(false);
        this.f5694P0.setVisibility(0);
        this.f5694P0.Q1(this);
    }

    @Override // com.android.mmt.ui.P
    public final void a1(int i2) throws ClassNotFoundException {
        o0(i2);
    }

    protected void a2(long j2) {
        this.f5246Z = C0416c.v(j2);
        Intent intent = getIntent();
        Uri uri = com.android.mmt.transaction.d.f4609m;
        if (intent != null && intent.getBooleanExtra("undelivered_flag", false)) {
            com.android.mmt.transaction.d.r(789);
        }
        Uri data = intent.getData();
        if (data != null) {
            try {
                String queryParameter = data.getQueryParameter("select_id");
                if (queryParameter != null) {
                    this.f5704Z0 = Long.parseLong(queryParameter);
                    this.f5714j1 = data.getQueryParameter("highlight_text");
                    this.f5716l1 = data.getQueryParameter("body_substitution");
                    this.f5694P0.N1(false);
                }
            } catch (NumberFormatException e2) {
                Log.e("ConversationBase", "initialize parseLong ", e2);
            } catch (UnsupportedOperationException e4) {
                Log.e("ConversationBase", "initialize not a typical URI ", e4);
            }
        }
        this.f5705a1 = intent.getIntExtra("new_message_count", 0);
        this.f5706b1 = intent.getBooleanExtra("was_soft_keyboard_on", false);
        Z1();
        E0();
        C0415b c0415bZ0 = z0();
        if (c0415bZ0 == null || c0415bZ0.isEmpty()) {
            Toast.makeText(this, R.string.invalid_conversation, 0).show();
            finish();
        } else {
            m1();
            this.f5717m1 = false;
            this.f5718n1 = 0;
        }
    }

    public final boolean b2() {
        return !this.f5712h1;
    }

    public final void c2() {
        this.f5692F1.sendMessageDelayed(this.f5692F1.obtainMessage(0), 700L);
    }

    @Override // com.android.mmt.ui.P, P0.InterfaceC0164j
    public final void d(float f4) {
        EditText editText = this.f5235N;
        if (editText != null) {
            editText.setTextSize(0, f4);
        }
        EditText editText2 = this.f5231K;
        if (editText2 != null) {
            editText2.setTextSize(0, f4);
        }
        C0247i0 c0247i0 = this.f5695Q0;
        if (c0247i0 != null) {
            c0247i0.c0(f4);
        }
        MessageListPullViewV2 messageListPullViewV2 = this.f5694P0;
        if (messageListPullViewV2 == null || messageListPullViewV2.getVisibility() != 0) {
            return;
        }
        int childCount = this.f5694P0.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f5694P0.getChildAt(i2);
            if (childAt != null && (childAt instanceof MessageListItem)) {
                ((MessageListItem) childAt).M(f4);
            }
        }
    }

    protected final void d2(int i2) {
        if (this.y1 != i2 && i2 == 1) {
            C0();
            s0();
            this.f5694P0.L1(false);
        }
        this.y1 = i2;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f5704Z0 != 0) {
            this.f5704Z0 = 0L;
            this.f5694P0.N1(true);
        }
        Objects.requireNonNull(P0.G.b());
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e2(String[] strArr, Runnable runnable) {
        if (!O2.a.a()) {
            strArr = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        if (com.android.mmt.util.A.k(this, strArr, 1029)) {
            this.z1 = runnable;
        } else {
            runnable.run();
        }
    }

    protected void f2() {
        this.f5694P0.K1(new p());
    }

    protected abstract void h2();

    @Override // com.android.mmt.ui.P, x0.j.b
    public final void j() {
        super.j();
        if (this.f5695Q0.j() == 0) {
            h2();
        }
    }

    protected abstract void j2(C0415b c0415b);

    @Override // com.android.mmt.ui.P
    protected final void k1() {
    }

    @Override // com.android.mmt.ui.P, com.android.mmt.ui.SizeAwareLinearLayout.a
    public final void l() {
        super.l();
        if (this.f5694P0 == null || this.f5221F.getHeight() == this.A1) {
            return;
        }
        int height = this.f5221F.getHeight();
        this.A1 = height;
        this.f5694P0.setPadding(0, 0, 0, height);
        ViewGroup.LayoutParams layoutParams = this.f5694P0.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).bottomMargin = 0;
            this.f5694P0.setLayoutParams(layoutParams);
        }
    }

    @Override // com.android.mmt.ui.P, miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        this.f5707c1 = true;
        MessageListPullViewV2 messageListPullViewV2 = this.f5694P0;
        if (messageListPullViewV2 == null || !messageListPullViewV2.I1()) {
            super.onBackPressed();
        } else {
            this.f5694P0.E1();
        }
    }

    @Override // android.app.Activity
    public final boolean onContextItemSelected(MenuItem menuItem) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        Cursor cursor;
        int iG1 = this.f5694P0.G1();
        if (iG1 < 0) {
            return super.onContextItemSelected(menuItem);
        }
        C0243g0 c0243g0N = this.f5695Q0.N(iG1);
        if (c0243g0N == null) {
            return false;
        }
        switch (menuItem.getItemId()) {
            case 0:
                P0.r.y(this.f5723s1, c0243g0N.I(), c0243g0N.z(), true);
                break;
            case 1:
                P0.r.y(this.f5723s1, c0243g0N.I(), c0243g0N.z(), false);
                break;
            case 2:
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(c0243g0N);
                P0.r.c(this, arrayList);
                break;
            case 4:
                com.android.mmt.util.e0.a(this.f5723s1, new o(c0243g0N, null), null, c0243g0N.T(), c0243g0N.R());
                break;
            case 5:
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(c0243g0N);
                P0.r.f(this, arrayList2);
                break;
            case 6:
                try {
                    cursor = (Cursor) this.f5695Q0.G(iG1);
                } catch (Exception e2) {
                    Log.e("ConversationBase", "onMenuItemClick: get cursor failed", e2);
                    cursor = null;
                }
                if (cursor != null) {
                    String strJ = P0.r.j(getApplicationContext(), cursor, c0243g0N);
                    g.a aVar = new g.a(this);
                    aVar.x(R.string.message_details_title);
                    aVar.k(strJ);
                    aVar.t(android.R.string.ok, null);
                    aVar.c(true);
                    aVar.A();
                    break;
                }
                break;
            case 7:
                if (!com.android.mmt.util.C.b(this.f5723s1)) {
                    g.a aVar2 = new g.a(this);
                    aVar2.x(R.string.networking_allow_title);
                    aVar2.j(R.string.dialog_complain_tips);
                    aVar2.c(false);
                    aVar2.m(R.string.no, null);
                    aVar2.t(R.string.networking_allow_continue, null);
                    aVar2.A();
                    break;
                }
                break;
            case 8:
                this.f5694P0.D1(iG1);
                break;
        }
        this.f5694P0.J1(false);
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.android.mmt.ui.P, P0.ActivityC0156b, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a2(this.f5269w0.longValue());
        this.f5723s1 = this;
        this.f5703Y0 = getContentResolver();
        this.f5702X0 = new l(this.f5703Y0);
        StringBuilder sbD = D2.e.d("loading thread ");
        sbD.append(this.f5269w0);
        Log.v("ConversationBase", sbD.toString());
        if (this.f5269w0.longValue() <= 0) {
            finish();
            return;
        }
        Objects.requireNonNull(this.f5246Z);
        this.f5701W0 = false;
        getApplicationContext();
        C0289v.b();
        if (this.f5724t1) {
            registerForContextMenu(this.f5694P0);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.message_list);
        if (recyclerView != null) {
            recyclerView.setOverScrollMode(2);
            recyclerView.s0(null);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        C0243g0 c0243g0N;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (this.f5694P0.I1() || this.f5694P0.G1() < 0 || (c0243g0N = this.f5695Q0.N(this.f5694P0.G1())) == null) {
            return;
        }
        try {
            T1(contextMenu, c0243g0N);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        contextMenu.add(0, 8, 131072, getResources().getString(R.string.menu_multi_select));
    }

    @Override // com.android.mmt.ui.P, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected void onDestroy() {
        C0247i0 c0247i0 = this.f5695Q0;
        if (c0247i0 != null) {
            c0247i0.e(null);
            this.f5695Q0.V();
        }
        this.f5702X0.a(9700);
        this.f5702X0.a(9701);
        this.f5702X0.a(9702);
        this.f5702X0.a(9527);
        miuix.appcompat.app.g gVar = G1;
        if (gVar != null) {
            gVar.dismiss();
            G1 = null;
        }
        MessageListPullViewV2 messageListPullViewV2 = this.f5694P0;
        if (messageListPullViewV2 != null) {
            unregisterForContextMenu(messageListPullViewV2);
            this.f5694P0.C1();
        }
        H h2 = this.f5227I;
        if (h2 != null) {
            h2.dismiss();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        startActivity(intent);
        finish();
    }

    @Override // com.android.mmt.ui.P, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1029) {
            for (int i4 : iArr) {
                if (i4 != 0) {
                    return;
                }
            }
            Runnable runnable = this.z1;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected void onResume() {
        super.onResume();
        NewMessagePopupActivity.z();
        if (this.f5722r1 != null) {
            this.f5722r1 = null;
        }
    }

    @Override // com.android.mmt.ui.P, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStart() {
        super.onStart();
        this.f5712h1 = false;
        C0287t.N(false);
        this.f5711g1 = "BUBBLE";
        SharedPreferences sharedPreferencesC = androidx.preference.g.c(this);
        String str = this.f5711g1;
        int i2 = P0.r.f937c;
        this.f5695Q0.T(this.f5711g1, TextUtils.equals(str, "BUBBLE") & true, P0.r.g(sharedPreferencesC));
        this.f5695Q0.b0(this.C1);
        if (this.f5706b1) {
            Log.v("ConversationBase", "soft keyboard is popped up, put off querying msg list");
            this.f5694P0.getViewTreeObserver().addOnGlobalLayoutListener(this.v1);
            this.f5694P0.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0264u(this));
        } else {
            this.f5273y0.removeCallbacks(this.w1);
            this.f5273y0.post(this.w1);
        }
        this.x1 = true;
        t0();
        if (this instanceof MultipleRecipientsConversationActivity) {
            j2(z0());
        }
    }

    @Override // com.android.mmt.ui.P, miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStop() {
        C0247i0 c0247i0;
        super.onStop();
        this.f5712h1 = true;
        for (int i2 = 0; i2 < this.f5694P0.getChildCount(); i2++) {
            View childAt = this.f5694P0.getChildAt(i2);
            if (childAt instanceof MessageListItem) {
                ((MessageListItem) childAt).R();
            }
        }
        if (!this.f5707c1 || (c0247i0 = this.f5695Q0) == null) {
            C0247i0 c0247i02 = this.f5695Q0;
            if (c0247i02 != null) {
                c0247i02.b0(null);
            }
        } else {
            c0247i0.e(null);
            this.f5707c1 = false;
        }
        P0.t.d().b(isFinishing());
    }

    @Override // android.app.Activity
    public final void onUserInteraction() {
        V1();
    }

    @Override // com.android.mmt.ui.P, android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z4) {
        if (z4) {
            V1();
        }
        super.onWindowFocusChanged(z4);
    }

    @Override // com.android.mmt.ui.P, com.android.mmt.ui.SizeAwareLinearLayout.a
    public final void p(SizeAwareLinearLayout sizeAwareLinearLayout, int i2, int i4) {
        super.p(sizeAwareLinearLayout, i2, i4);
    }

    @Override // com.android.mmt.ui.P
    protected final boolean t1() {
        return false;
    }

    @Override // com.android.mmt.ui.P
    protected final C0415b z0() {
        C0416c c0416c = this.f5246Z;
        if (c0416c != null) {
            return c0416c.G();
        }
        Log.v("ConversationBase", "getRecipients is null");
        return null;
    }
}
