package com.android.mmt.transaction;

import O0.u;
import O0.v;
import O0.w;
import P0.r;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.Telephony;
import android.telephony.PhoneStateListener;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.ui.C0243g0;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.util.A;
import com.android.mmt.util.C0270b;
import com.android.mmt.util.C0276h;
import com.android.mmt.util.C0278j;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.H;
import com.android.mmt.util.O;
import f0.C0303b;
import g0.C0310f;
import g0.C0312h;
import g0.C0317m;
import g0.C0319o;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/* loaded from: classes.dex */
public class TransactionService extends Service implements O0.l {

    /* renamed from: I, reason: collision with root package name */
    public static final /* synthetic */ int f4550I = 0;

    /* renamed from: m, reason: collision with root package name */
    private HandlerThread f4563m;

    /* renamed from: n, reason: collision with root package name */
    private Handler f4564n;
    private ConnectivityManager p;

    /* renamed from: q, reason: collision with root package name */
    private C0276h f4566q;
    private l u;

    /* renamed from: v, reason: collision with root package name */
    private l f4570v;

    /* renamed from: x, reason: collision with root package name */
    private PowerManager.WakeLock f4572x;

    /* renamed from: y, reason: collision with root package name */
    private PhoneStateListener f4573y;

    /* renamed from: z, reason: collision with root package name */
    private PhoneStateListener f4574z;

    /* renamed from: i, reason: collision with root package name */
    private int f4559i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f4560j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f4561k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f4562l = 0;

    /* renamed from: o, reason: collision with root package name */
    private Handler f4565o = new Handler();

    /* renamed from: r, reason: collision with root package name */
    private int f4567r = -1;

    /* renamed from: s, reason: collision with root package name */
    private long f4568s = -1;

    /* renamed from: t, reason: collision with root package name */
    private LinkedHashSet<l> f4569t = new LinkedHashSet<>();

    /* renamed from: w, reason: collision with root package name */
    private boolean f4571w = false;

    /* renamed from: A, reason: collision with root package name */
    private int f4551A = 0;

    /* renamed from: B, reason: collision with root package name */
    private int f4552B = 0;

    /* renamed from: C, reason: collision with root package name */
    private Object f4553C = new Object();

    /* renamed from: D, reason: collision with root package name */
    private boolean f4554D = false;

    /* renamed from: E, reason: collision with root package name */
    private Runnable f4555E = new a();

    /* renamed from: F, reason: collision with root package name */
    private Runnable f4556F = new b();

    /* renamed from: G, reason: collision with root package name */
    private C0276h.d f4557G = new c();

    /* renamed from: H, reason: collision with root package name */
    private Runnable f4558H = new d();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (TransactionService.this.f4551A == 0 && TransactionService.this.f4552B == 0) {
                StringBuilder sbD = D2.e.d("get slot0 new mReConnectWhenCallIdle : ");
                sbD.append(TransactionService.this.f4554D);
                Y1.a.k(sbD.toString(), new Object[0]);
                if (TransactionService.this.f4554D) {
                    TransactionService.this.f4554D = false;
                    TransactionService.this.N();
                }
            }
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (TransactionService.this.f4551A == 0 && TransactionService.this.f4552B == 0) {
                StringBuilder sbD = D2.e.d("get slot1 new mReConnectWhenCallIdle : ");
                sbD.append(TransactionService.this.f4554D);
                Y1.a.k(sbD.toString(), new Object[0]);
                if (TransactionService.this.f4554D) {
                    TransactionService.this.f4554D = false;
                    TransactionService.this.N();
                }
            }
        }
    }

    final class c implements C0276h.d {
        c() {
        }

        @Override // com.android.mmt.util.C0276h.d
        public final void a() {
            TransactionService transactionService = TransactionService.this;
            transactionService.Y(transactionService.f4558H);
        }
    }

    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TransactionService.this.X(0);
        }
    }

    final class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TransactionService.this.f4571w = false;
            Y1.a.k("requestRetryConnect end", new Object[0]);
            TransactionService.this.N();
        }
    }

    final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Y1.a.k("resetDownloadState", new Object[0]);
            TransactionService transactionService = TransactionService.this;
            int i2 = TransactionService.f4550I;
            Objects.requireNonNull(transactionService);
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("st", (Integer) 128);
            O.g(transactionService, transactionService.getContentResolver(), Telephony.Mms.Inbox.CONTENT_URI, contentValues, "m_type=130", null);
        }
    }

    final class g implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f4581i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f4582j;

        g(int i2, int i4) {
            this.f4581i = i2;
            this.f4582j = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Y1.a.k("Posting enqueueAllMessages", new Object[0]);
            TransactionService.this.f4567r = this.f4581i;
            TransactionService.e(TransactionService.this, this.f4582j);
        }
    }

    final class h implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f4584i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ u f4585j;

        h(int i2, u uVar) {
            this.f4584i = i2;
            this.f4585j = uVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TransactionService.this.f4567r = this.f4584i;
            TransactionService.f(TransactionService.this, this.f4585j);
        }
    }

    final class i implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ l f4587i;

        i(l lVar) {
            this.f4587i = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            Cursor cursorE;
            Y1.a.k("Update transaction %s", this.f4587i);
            if (this.f4587i != TransactionService.this.u) {
                Y1.a.d("Expecting %s to update but it is actually %s", TransactionService.this.u, this.f4587i);
            }
            Intent intent = new Intent("android.intent.action.TRANSACTION_COMPLETED_ACTION");
            w wVar = this.f4587i.f4642m;
            int iB = wVar.b();
            intent.putExtra("state", iB);
            intent.putExtra("uri", wVar.a());
            if (iB == 1) {
                Y1.a.k("Transaction complete: %s", this.f4587i);
                int iG = this.f4587i.g();
                if (iG == 0 || iG == 1) {
                    Uri uriA = wVar.a();
                    if (uriA != null && (cursorE = O.e(MmsApp.c(), MmsApp.c().getContentResolver(), uriA, new String[]{"thread_id"}, null, null, null)) != null) {
                        try {
                            j = cursorE.moveToFirst() ? cursorE.getLong(0) : -1L;
                        } finally {
                            cursorE.close();
                        }
                    }
                    D0.b.f80a = true;
                    Log.d("NewMessageInjector", "onMessageReceived: 1 | " + uriA);
                    Cursor cursorQuery = MmsApp.c().getContentResolver().query(uriA, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            L0.a aVar = new L0.a();
                            cursorQuery.moveToFirst();
                            C0243g0 c0243g0 = new C0243g0(MmsApp.c(), L0.c.c(1), cursorQuery, new C0247i0.c(cursorQuery, false), 0);
                            aVar.z(c0243g0.H());
                            aVar.s(c0243g0.m());
                            if (c0243g0.U()) {
                                aVar.C(c0243g0.F());
                                if (c0243g0.w() == 1) {
                                    aVar.w(false);
                                } else {
                                    aVar.w(true);
                                }
                            } else {
                                aVar.C(c0243g0.g());
                            }
                            BugleDatabase.y().x().F(aVar, true, 1);
                        } catch (C0303b e2) {
                            e2.printStackTrace();
                        }
                    }
                    MmsApp.c();
                    int i2 = r.f937c;
                    if ((BugleDatabase.y().x().u(j) != null ? (char) 3 : (char) 0) <= 1) {
                        com.android.mmt.transaction.d.o(j);
                    }
                    com.android.mmt.transaction.d.D();
                } else if (iG == 2) {
                    H.b().f();
                }
                TransactionService.this.f4569t.remove(this.f4587i);
                TransactionService.j(TransactionService.this);
            } else if (iB != 2) {
                Y1.a.k("Transaction state unknown: %s. result=%d", this.f4587i, Integer.valueOf(iB));
            } else {
                Y1.a.k("Transaction failed: %s", this.f4587i);
                TransactionService.this.V(wVar.a(), this.f4587i.p, false, false, true);
                TransactionService.this.f4569t.remove(this.f4587i);
                TransactionService.l(TransactionService.this);
            }
            this.f4587i.h();
            this.f4587i.b(TransactionService.this);
            TransactionService.this.u = null;
            TransactionService.this.sendBroadcast(intent);
            TransactionService.this.N();
        }
    }

    final class j implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f4589i;

        j(int i2) {
            this.f4589i = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(TransactionService.this, this.f4589i, 1).show();
        }
    }

    static /* synthetic */ int F(TransactionService transactionService) {
        int i2 = transactionService.f4560j + 1;
        transactionService.f4560j = i2;
        return i2;
    }

    static void I(TransactionService transactionService, l lVar) {
        Objects.requireNonNull(transactionService);
        if (lVar != null) {
            Y1.a.k("markTransactionFailureAndRemove transaction : %s", lVar);
            transactionService.V(lVar.f4642m.a(), lVar.p, false, false, true);
            transactionService.f4569t.remove(lVar);
            transactionService.f4562l++;
        }
    }

    static long K(TransactionService transactionService, long j2) {
        Iterator<l> it = transactionService.f4569t.iterator();
        while (it.hasNext()) {
            long j4 = it.next().p;
            if (j4 != j2) {
                return j4;
            }
        }
        return j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
    
        if (((r5.f4551A == 0 && r5.f4552B == 0) ? false : true) != false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean L(int i2) {
        int iQ;
        NetworkInfo networkInfo;
        boolean z4;
        if (O0.f.j().m()) {
            Y1.a.k("checkMobileNetwork isMmsAllowed is true", new Object[0]);
            if (C0287t.x()) {
                try {
                    iQ = C0287t.q(SubscriptionManager.getDefaultDataSubscriptionId());
                } catch (SecurityException e2) {
                    A.f(e2);
                    iQ = -1;
                }
            } else {
                iQ = 0;
            }
            if (i2 == iQ) {
                NetworkInfo networkInfo2 = this.p.getNetworkInfo(2);
                if ((networkInfo2 == null || !networkInfo2.isAvailable()) && ((networkInfo = this.p.getNetworkInfo(0)) == null || !networkInfo.isAvailable())) {
                    z4 = false;
                }
                Y1.a.k("isNetworkAvaliable is " + z4, new Object[0]);
                if (!z4) {
                    O0.f.j().u(i2);
                    return true;
                }
                if (!this.f4554D) {
                    if (!z4) {
                        b0();
                    }
                }
                this.f4554D = true;
                Y1.a.k("checkMobile during call", new Object[0]);
                O0.f.j().u(i2);
                return true;
            }
            Y1.a.k("isNetworkAvailable not preferred data slotId", new Object[0]);
            z4 = true;
            Y1.a.k("isNetworkAvaliable is " + z4, new Object[0]);
            if (!z4) {
            }
        } else {
            Y1.a.k("checkMobileNetwork isMmsAllowed is false", new Object[0]);
            this.f4554D = false;
        }
        O0.f.j().o(i2);
        return false;
    }

    private void M() {
        if (this.u != null || !this.f4569t.isEmpty()) {
            Y1.a.d("no pending messages in database but in memory", new Object[0]);
            return;
        }
        O(true);
        a0(this.f4567r);
        Y1.a.c("TrasctionService stopped.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        l next;
        if (this.f4571w) {
            Y1.a.k("mIsWaitingReConnect is true", new Object[0]);
            return;
        }
        l lVar = this.u;
        if (lVar != null) {
            Y1.a.k("while there is already one processing, transaction=%s", lVar);
            return;
        }
        if (this.f4569t.isEmpty()) {
            if (this.f4554D) {
                Y1.a.k("not on finish when calling", new Object[0]);
                return;
            }
            Y1.a.c("Finished all transactions in queue. %d success, %d failure.", Integer.valueOf(this.f4561k), Integer.valueOf(this.f4562l));
            if (this.f4562l > 0 && T()) {
                Y1.a.k("scheduleNextRetry isRetry", new Object[0]);
                ((AlarmManager) getSystemService("alarm")).set(1, System.currentTimeMillis() + 45000, PendingIntent.getService(this, 0, new Intent("android.intent.action.ACTION_ONALARM", null, this, TransactionService.class), 1140850688));
            }
            this.f4562l = 0;
            O(true);
            a0(this.f4567r);
            Y1.a.c("TrasctionService stopped.", new Object[0]);
            return;
        }
        if (this.f4570v == null) {
            if (this.f4568s != -1) {
                Iterator<l> it = this.f4569t.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        O(false);
                        next = this.f4569t.iterator().next();
                        break;
                    } else {
                        l next2 = it.next();
                        if (next2.p == this.f4568s) {
                            next = next2;
                            break;
                        }
                    }
                }
            } else {
                next = this.f4569t.iterator().next();
            }
            this.f4570v = next;
        }
        int iQ = C0287t.q(this.f4570v.p);
        boolean zD = C0287t.D(iQ);
        if (!zD || !L(iQ)) {
            Y1.a.k("transaction is not available in case of no slotId", new Object[0]);
            O0.f.j().o(iQ);
            U(this.f4570v.p, !zD, false, zD);
            this.f4559i = 0;
            this.f4560j = 0;
            this.f4570v = null;
            X(5000);
            return;
        }
        if (this.f4570v.g() == 0 && !((O0.j) this.f4570v).f804v) {
            Y1.a.k("notification trasaction should download is false", new Object[0]);
            l lVar2 = this.f4570v;
            this.f4568s = lVar2.p;
            W(lVar2, iQ);
            this.f4570v = null;
            this.f4559i = 0;
            this.f4560j = 0;
            return;
        }
        Y1.a.k(D2.e.b("startUsingNetworkFeature slotId = ", iQ), new Object[0]);
        int iL = this.f4566q.l(iQ);
        this.f4568s = this.f4570v.p;
        Y1.a.k(D2.e.b("connectAndProcessNextTransaction: result=", iL), new Object[0]);
        if (iL == 0) {
            W(this.f4570v, iQ);
            this.f4570v = null;
            this.f4559i = 0;
            this.f4560j = 0;
            return;
        }
        if (iL == 1) {
            this.f4572x.acquire();
            sendBroadcast(new Intent("com.android.mmt.transaction.START"));
            this.f4571w = true;
            Y1.a.k("requestRetryConnectForStarted start", new Object[0]);
            Z(new p(this), C0287t.x() ? 12000 : 5000);
            return;
        }
        b0();
        if (!((this.f4551A == 0 && this.f4552B == 0) ? false : true)) {
            this.f4571w = true;
            Y1.a.k("requestRetryConnectForFailed start", new Object[0]);
            Z(new o(this), 5000);
        } else {
            this.f4554D = true;
            U(this.f4568s, false, true, true);
            this.f4559i = 0;
            this.f4560j = 0;
            this.f4570v = null;
            X(5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z4) {
        C0276h c0276h;
        try {
            Y1.a.k("endMmsConnectivity", new Object[0]);
            int iQ = C0287t.q(this.f4568s);
            Y1.a.k("mLastSimId = %d ", Long.valueOf(this.f4568s));
            if (C0287t.D(iQ)) {
                C0276h c0276h2 = this.f4566q;
                if (c0276h2 != null) {
                    c0276h2.m(iQ);
                }
            } else {
                C0276h c0276h3 = this.f4566q;
                if (c0276h3 != null) {
                    try {
                        c0276h3.m(0);
                        if (C0287t.x()) {
                            this.f4566q.m(1);
                        }
                    } catch (Exception e2) {
                        Y1.a.d("endMmsConnectivity e ", e2);
                    }
                }
            }
            if (z4 && (c0276h = this.f4566q) != null) {
                c0276h.f();
                Y1.a.k("call clearRequests", new Object[0]);
            }
            sendBroadcast(new Intent("com.android.mmt.transaction.STOP"));
        } finally {
            this.f4572x.release();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.android.mmt.transaction.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean P(u uVar, long j2, int i2) {
        O0.j jVar;
        String strA = uVar.a();
        v vVar = strA != null ? new v(strA, uVar.b(), uVar.c()) : new v(this, i2);
        ?? E2 = uVar.e();
        try {
            try {
            } catch (C0303b unused) {
                jVar = null;
            }
        } catch (C0303b unused2) {
        }
        if (E2 == 0) {
            String strF = uVar.f();
            if (strF != null) {
                jVar = new O0.j(this, vVar, strF);
                try {
                    jVar.p = j2;
                } catch (C0303b unused3) {
                }
                E2 = jVar;
                if (E2 != 0) {
                    return false;
                }
                if (!this.f4569t.contains(E2)) {
                    this.f4569t.add(E2);
                    Y1.a.k("Enqueued transaction: %s", new Object[]{E2});
                }
                E2.i();
                return true;
            }
            C0310f c0310fA = new C0317m(uVar.d()).a();
            if (c0310fA == null || c0310fA.a() != 130) {
                Y1.a.d("Invalid PUSH data.", new Object[0]);
                return false;
            }
            O0.j jVar2 = new O0.j(this, vVar, (C0312h) c0310fA);
            jVar2.p = j2;
            E2 = jVar2;
        } else if (E2 == 1) {
            int i4 = r.f937c;
            O0.p pVar = new O0.p(this, vVar, uVar.f());
            pVar.p = j2;
            E2 = pVar;
        } else if (E2 == 2) {
            O0.q qVar = new O0.q(this, vVar, uVar.f());
            qVar.p = j2;
            E2 = qVar;
        } else {
            if (E2 != 3) {
                Y1.a.l("Invalid transaction type: %d", Integer.valueOf((int) E2));
                return false;
            }
            O0.o oVar = new O0.o(this, vVar, uVar.f());
            oVar.p = j2;
            E2 = oVar;
        }
        if (E2 != 0) {
        }
    }

    private int Q(long j2) {
        Cursor cursorE = O.e(this, getContentResolver(), Telephony.Mms.Outbox.CONTENT_URI, null, "_id=" + j2, null, null);
        try {
            int i2 = cursorE.moveToFirst() ? cursorE.getInt(cursorE.getColumnIndexOrThrow("resp_st")) : 0;
            if (i2 != 0) {
                Y1.a.l("Response status is: %d", Integer.valueOf(i2));
            }
            return i2;
        } finally {
            cursorE.close();
        }
    }

    private long R(String str) {
        long j2;
        if (C0287t.x()) {
            Cursor cursorE = O.e(this, getContentResolver(), Uri.parse(str), new String[]{"sub_id"}, null, null, null);
            if (cursorE != null) {
                try {
                    j2 = cursorE.moveToFirst() ? cursorE.getInt(0) : -1L;
                } finally {
                    cursorE.close();
                }
            }
        } else {
            j2 = 0;
        }
        Log.e("sirius", "sirius getSimId: " + j2);
        return j2;
    }

    private static int S(int i2) {
        if (i2 == 128) {
            return 2;
        }
        if (i2 == 130) {
            return 1;
        }
        if (i2 == 135) {
            return 3;
        }
        Y1.a.l("Unrecognized MESSAGE_TYPE: %d", Integer.valueOf(i2));
        return -1;
    }

    public static boolean T() {
        Cursor cursorF;
        int i2;
        O0.f fVarJ = O0.f.j();
        Objects.requireNonNull(fVarJ);
        boolean z4 = true;
        boolean zL = C0287t.x() ? fVarJ.l(0) && fVarJ.l(1) : fVarJ.l(0);
        Y1.a.k("isListening allowed is " + zL, new Object[0]);
        if (zL) {
            Y1.a.k("for listen mms available, not retry", new Object[0]);
            return false;
        }
        if (!O0.f.j().m()) {
            Y1.a.k("mms is not allowed", new Object[0]);
            return false;
        }
        try {
            cursorF = C0319o.e(MmsApp.c().getApplicationContext()).f();
        } catch (SecurityException e2) {
            A.g(e2);
            cursorF = null;
        }
        if (cursorF == null) {
            return false;
        }
        while (true) {
            try {
                if (!cursorF.moveToNext()) {
                    z4 = false;
                    break;
                }
                if (1 != S(cursorF.getInt(cursorF.getColumnIndexOrThrow("msg_type"))) || ((i2 = cursorF.getInt(cursorF.getColumnIndexOrThrow("err_type"))) < 10 && i2 > 0)) {
                    if (cursorF.getInt(cursorF.getColumnIndexOrThrow("retry_index")) < 5) {
                        break;
                    }
                }
            } catch (Throwable th) {
                cursorF.close();
                throw th;
            }
        }
        cursorF.close();
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(long j2, boolean z4, boolean z5, boolean z6) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<l> it = this.f4569t.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.p == j2) {
                linkedHashSet.add(next);
            }
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            l lVar = (l) it2.next();
            V(lVar.f4642m.a(), j2, z4, z5, z6);
            this.f4569t.remove(lVar);
            this.f4562l++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0190, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V(Uri uri, long j2, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        ContentValues contentValues;
        int i2;
        long j4;
        long id = ContentUris.parseId(uri);
        Uri.Builder builderBuildUpon = Telephony.MmsSms.PendingMessages.CONTENT_URI.buildUpon();
        builderBuildUpon.appendQueryParameter("protocol", "mms");
        builderBuildUpon.appendQueryParameter("message", String.valueOf(id));
        Cursor cursorE = O.e(this, getContentResolver(), builderBuildUpon.build(), null, null, null, null);
        if (cursorE != null) {
            try {
                int i4 = 1;
                if (cursorE.getCount() == 1 && cursorE.moveToFirst()) {
                    int i5 = cursorE.getInt(cursorE.getColumnIndexOrThrow("msg_type"));
                    int i6 = cursorE.getInt(cursorE.getColumnIndexOrThrow("retry_index"));
                    if (!z5) {
                        i6++;
                    }
                    int i7 = i6;
                    ContentValues contentValues2 = new ContentValues(4);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    boolean z8 = i5 == 130;
                    int iQ = Q(id);
                    int i8 = R.string.service_not_activated;
                    if (iQ != 130) {
                        if (iQ == 132) {
                            i8 = R.string.invalid_destination;
                        } else if (iQ == 134) {
                            i8 = R.string.service_network_problem;
                        } else if (iQ == 194) {
                            i8 = R.string.service_message_not_found;
                        } else if (iQ != 225) {
                            if (iQ != 228) {
                                if (!z4) {
                                    i8 = 0;
                                }
                            }
                        }
                    }
                    if (i8 != 0) {
                        if (z6) {
                            this.f4565o.post(new j(i8));
                        }
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (i7 >= 5 || !z7) {
                        Y1.a.k("onTransactionFailure: retry for %s is reached limit. Abort.", uri);
                        if (z8) {
                            contentValues = contentValues2;
                            i2 = i7;
                            cursorE = O.e(this, getContentResolver(), uri, new String[]{"thread_id"}, null, null, null);
                            if (cursorE != null) {
                                j4 = cursorE.moveToFirst() ? cursorE.getLong(0) : -1L;
                                cursorE.close();
                            } else {
                                j4 = -1;
                            }
                            if (j4 != -1) {
                                com.android.mmt.transaction.d.w(j4);
                            }
                            C0278j.c().h(uri, 135, j2);
                        } else {
                            contentValues = contentValues2;
                            i2 = i7;
                            ContentValues contentValues3 = new ContentValues(1);
                            contentValues3.put("read", (Integer) 0);
                            O.g(this, getContentResolver(), uri, contentValues3, null, null);
                            com.android.mmt.transaction.d.z();
                        }
                        i4 = 10;
                    } else {
                        if (z8) {
                            C0278j.c().h(uri, 130, j2);
                        }
                        contentValues = contentValues2;
                        i2 = i7;
                    }
                    ContentValues contentValues4 = contentValues;
                    contentValues4.put("err_type", Integer.valueOf(i4));
                    contentValues4.put("retry_index", Integer.valueOf(i2));
                    contentValues4.put("last_try", Long.valueOf(jCurrentTimeMillis));
                    long j5 = cursorE.getLong(cursorE.getColumnIndexOrThrow("_id"));
                    O.g(this, getContentResolver(), Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues4, "_id=" + j5, null);
                } else {
                    Y1.a.k("Cannot found correct pending status for: %d", Long.valueOf(id));
                }
            } finally {
            }
        }
    }

    private void W(l lVar, int i2) {
        l lVar2 = this.f4570v;
        String strG = this.f4566q.g(i2);
        Objects.requireNonNull(lVar2);
        if (!TextUtils.isEmpty(strG)) {
            lVar2.f4643n.e(lVar2.f4640k, strG, i2);
        }
        this.f4570v.m(C0276h.h(i2));
        this.u = lVar;
        this.f4571w = false;
        Y1.a.k("Processing next transaction: %s", lVar);
        sendBroadcast(new Intent("com.android.mmt.transaction.START"));
        this.u.a(this);
        this.u.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i2) {
        this.f4571w = true;
        Y1.a.k("requestRetryConnect start", new Object[0]);
        Z(new e(), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Y(Runnable runnable) {
        Handler handler = this.f4564n;
        if (handler != null) {
            handler.post(runnable);
        } else {
            Y1.a.d("Attempt to post runnable while handler thread is dead.", new Object[0]);
        }
    }

    private synchronized void Z(Runnable runnable, int i2) {
        Handler handler = this.f4564n;
        if (handler != null) {
            handler.postDelayed(runnable, i2);
        } else {
            Y1.a.d("Attempt to post delayed runnable while handler thread is dead.", new Object[0]);
        }
    }

    private void a0(int i2) {
        if (this.f4554D) {
            Y1.a.k("need wait call end, no stop.", new Object[0]);
        } else {
            Y1.a.k("stop TransactionService.", new Object[0]);
            stopSelf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        synchronized (this.f4553C) {
            this.f4551A = C0287t.c(0);
            if (C0287t.x()) {
                this.f4552B = C0287t.c(1);
            }
        }
        StringBuilder sbD = D2.e.d("whether is during call and mPhoneState = ");
        sbD.append(this.f4551A);
        sbD.append(" and mPhoneState2 = ");
        sbD.append(this.f4552B);
        Y1.a.k(sbD.toString(), new Object[0]);
    }

    static void e(TransactionService transactionService, int i2) {
        Cursor cursorF;
        int i4;
        Objects.requireNonNull(transactionService);
        try {
            cursorF = C0319o.e(transactionService.getApplicationContext()).f();
        } catch (SecurityException e2) {
            A.g(e2);
            cursorF = null;
        }
        if (cursorF == null) {
            Y1.a.l("enqueueAllMessages: pending messages = null", new Object[0]);
            transactionService.M();
            return;
        }
        try {
            int count = cursorF.getCount();
            Y1.a.k("enqueueAllMessages: Pending transaction count=%d", Integer.valueOf(count));
            if (count == 0) {
                transactionService.M();
            } else {
                int columnIndexOrThrow = cursorF.getColumnIndexOrThrow("msg_id");
                int columnIndexOrThrow2 = cursorF.getColumnIndexOrThrow("msg_type");
                while (cursorF.moveToNext()) {
                    int iS = S(cursorF.getInt(columnIndexOrThrow2));
                    if (iS != -1 && (iS != 1 || ((i4 = cursorF.getInt(cursorF.getColumnIndexOrThrow("err_type"))) < 10 && i4 > 0))) {
                        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, cursorF.getLong(columnIndexOrThrow));
                        String string = uriWithAppendedId.toString();
                        u uVar = new u(iS, string);
                        long jR = transactionService.R(string);
                        int iQ = C0287t.q(jR);
                        if (i2 == -1 || i2 == iQ) {
                            if (!C0287t.D(iQ)) {
                                Y1.a.d("sim id is not inserted to slot", new Object[0]);
                                O0.f.j().o(iQ);
                                transactionService.V(uriWithAppendedId, jR, true, false, false);
                            } else if (transactionService.L(iQ)) {
                                transactionService.P(uVar, jR, iQ);
                            }
                        }
                    }
                }
                transactionService.N();
            }
        } finally {
            cursorF.close();
        }
    }

    static void f(TransactionService transactionService, u uVar) {
        Objects.requireNonNull(transactionService);
        String strF = uVar.f();
        long jR = transactionService.R(strF);
        int iQ = C0287t.q(jR);
        if (!C0287t.D(iQ)) {
            Y1.a.d("sim id is not inserted to slot", new Object[0]);
            O0.f.j().o(iQ);
            transactionService.V(Uri.parse(strF), jR, true, false, false);
        } else {
            if (transactionService.L(iQ)) {
                transactionService.P(uVar, jR, iQ);
            } else {
                transactionService.f4565o.post(new q(transactionService, uVar.e()));
            }
            transactionService.N();
        }
    }

    static /* synthetic */ int j(TransactionService transactionService) {
        int i2 = transactionService.f4561k + 1;
        transactionService.f4561k = i2;
        return i2;
    }

    static /* synthetic */ int l(TransactionService transactionService) {
        int i2 = transactionService.f4562l + 1;
        transactionService.f4562l = i2;
        return i2;
    }

    static /* synthetic */ int q(TransactionService transactionService) {
        int i2 = transactionService.f4559i + 1;
        transactionService.f4559i = i2;
        return i2;
    }

    @Override // O0.l
    public final void a(O0.k kVar) {
        Y1.a.k("Posting transaction update", new Object[0]);
        Y(new i((l) kVar));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        Y1.a.c("Creating TransactionService...", new Object[0]);
        C0270b.a(this);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "Mms:MMS Connectivity");
        this.f4572x = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        this.p = (ConnectivityManager) getSystemService("connectivity");
        HandlerThread handlerThread = new HandlerThread("TransactionService");
        this.f4563m = handlerThread;
        handlerThread.start();
        this.f4564n = new Handler(this.f4563m.getLooper());
        this.f4566q = new C0276h(this.p, this.f4563m, this.f4557G);
        this.f4561k = 0;
        this.f4562l = 0;
        m mVar = new m(this);
        this.f4573y = mVar;
        C0287t.F(0, mVar, 32);
        if (C0287t.x()) {
            n nVar = new n(this);
            this.f4574z = nVar;
            C0287t.F(1, nVar, 32);
        }
        Y1.a.k("register Phone Call Listener.", new Object[0]);
        Y(new f());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Y1.a.c("Destroying TransactionService", new Object[0]);
        synchronized (this) {
            this.f4563m.quit();
            this.f4564n = null;
            Y1.a.k("Requested killing handler thread.", new Object[0]);
        }
        C0287t.F(0, this.f4573y, 0);
        this.f4573y = null;
        PhoneStateListener phoneStateListener = this.f4574z;
        if (phoneStateListener != null) {
            C0287t.F(1, phoneStateListener, 0);
            this.f4574z = null;
        }
        Y1.a.k("unregister Phone Call Listener.", new Object[0]);
        if (this.u != null) {
            Y1.a.d("TransactionService exiting with transaction still processing", new Object[0]);
            try {
                Objects.requireNonNull(this.u);
                com.android.mmt.transaction.c.a(0L);
                O(true);
            } catch (Exception unused) {
            }
        }
        this.u = null;
        C0276h c0276h = this.f4566q;
        if (c0276h != null) {
            c0276h.e();
            this.f4566q = null;
            Y1.a.k("mConnMgrHelper clear and set null", new Object[0]);
        }
        if (this.f4569t.isEmpty()) {
            return;
        }
        Y1.a.d("TransactionService exiting with transaction in queue", new Object[0]);
        this.f4569t.clear();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i4) {
        int iT;
        Y1.a.c("onStartService: startId=%d", Integer.valueOf(i4));
        C0270b.a(this);
        if (intent != null && !"android.intent.action.ACTION_ONALARM".equals(intent.getAction()) && !"android.intent.action.ACTION_WAKEUP".equals(intent.getAction()) && intent.getExtras() != null) {
            u uVar = new u(intent.getExtras());
            Y1.a.k("Posting enqueueSingleMessage", new Object[0]);
            Y(new h(i4, uVar));
            return 2;
        }
        Y1.a.k("Posting enqueueAllMessages", new Object[0]);
        if (intent == null || !"android.intent.action.ACTION_WAKEUP".equals(intent.getAction())) {
            iT = -1;
        } else {
            iT = C0287t.t(intent);
            Y1.a.k(D2.e.b("onStartCommand ACTION_WAKEUP slotId ", iT), new Object[0]);
        }
        Y(new g(i4, iT));
        return 2;
    }
}
