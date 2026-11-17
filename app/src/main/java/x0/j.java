package x0;

import G0.k;
import G0.o;
import G0.p;
import G0.q;
import G0.r;
import G0.s;
import a.C0178a;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.ProgressBar;
import c0.C0228a;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.P;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0292y;
import com.android.mmt.util.L;
import com.android.mmt.util.O;
import d0.C0294a;
import f0.C0303b;
import g0.C0309e;
import g0.C0313i;
import g0.C0319o;
import g0.t;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k0.C0341b;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: s, reason: collision with root package name */
    private static boolean f8106s = k0.d.m();

    /* renamed from: t, reason: collision with root package name */
    private static final String[] f8107t = {"_id", "m_size"};
    private static final ExecutorService u = Executors.newCachedThreadPool();

    /* renamed from: v, reason: collision with root package name */
    private static final String[] f8108v = {"_id", "sub", "sub_cs"};

    /* renamed from: w, reason: collision with root package name */
    private static final String[] f8109w = {"body", "date"};

    /* renamed from: a, reason: collision with root package name */
    protected WeakReference<Activity> f8110a;

    /* renamed from: b, reason: collision with root package name */
    protected ContentResolver f8111b;

    /* renamed from: c, reason: collision with root package name */
    protected MmsApp f8112c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    protected int f8113e;

    /* renamed from: f, reason: collision with root package name */
    protected C0416c f8114f;
    protected CharSequence g;

    /* renamed from: h, reason: collision with root package name */
    protected p f8115h;

    /* renamed from: i, reason: collision with root package name */
    protected Uri f8116i;

    /* renamed from: j, reason: collision with root package name */
    protected CharSequence f8117j;

    /* renamed from: l, reason: collision with root package name */
    protected volatile boolean f8119l;

    /* renamed from: m, reason: collision with root package name */
    protected volatile boolean f8120m;

    /* renamed from: n, reason: collision with root package name */
    protected b f8121n;

    /* renamed from: o, reason: collision with root package name */
    private List<String> f8122o;
    private boolean p;

    /* renamed from: r, reason: collision with root package name */
    private String f8124r;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f8118k = false;

    /* renamed from: q, reason: collision with root package name */
    private long f8123q = 0;

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f8125i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f8126j;

        a(String str, long j2) {
            this.f8125i = str;
            this.f8126j = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar = j.this;
            O.c(jVar.f8112c, jVar.f8111b, Telephony.Mms.Draft.CONTENT_URI, this.f8125i, null);
            D0.b.a(this.f8126j, 1, null);
        }
    }

    public interface b {
        void j();
    }

    public j(b bVar) {
        Application applicationC = MmsApp.c();
        this.f8112c = (MmsApp) applicationC;
        this.f8111b = applicationC.getContentResolver();
        this.f8121n = bVar;
        if (bVar != null) {
            this.f8110a = new WeakReference<>((P) bVar);
        }
        this.f8113e = 0;
        this.g = "";
    }

    public static j H(b bVar, Uri uri, boolean z4) {
        if (!uri.toString().startsWith(Telephony.Mms.Draft.CONTENT_URI.toString()) && !z4) {
            P p = (P) bVar;
            Objects.requireNonNull(p);
            C0319o c0319oE = C0319o.e(p.getApplicationContext());
            if (Log.isLoggable("Mms:app", 2)) {
                Y1.a.c("load: moving %s to drafts", uri);
            }
            try {
                uri = c0319oE.m(uri, Telephony.Mms.Draft.CONTENT_URI);
            } catch (C0303b unused) {
                Y1.a.d("Can't move %s to drafts", uri);
                return null;
            }
        }
        j jVar = new j(bVar);
        if (jVar.K(uri, z4, false)) {
            return jVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static t L(C0416c c0416c, CharSequence charSequence) {
        String[] strArrN = c0416c.G().n(true);
        t tVar = new t();
        C0309e[] c0309eArrD = C0309e.d(strArrN);
        if (c0309eArrD != null) {
            tVar.u(c0309eArrD);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            tVar.m(new C0309e(charSequence.toString()));
        }
        tVar.k(System.currentTimeMillis() / 1000);
        return tVar;
    }

    private void M() throws UnsupportedEncodingException {
        g0();
        if (P()) {
            s();
            f0();
        }
    }

    private void X(int i2, Uri uri, boolean z4) throws C0303b {
        if (i2 != 4) {
            throw new k0.e("setOrAppendFileAttachment type=" + i2 + ", uri=" + uri);
        }
        r rVar = new r(this.f8112c.getApplicationContext(), uri);
        if (z4) {
            this.f8115h.q(rVar);
            return;
        }
        this.f8115h.E();
        this.f8115h.q(rVar);
        o oVarW = this.f8115h.get(0);
        oVarW.H();
        oVarW.I();
        oVarW.G();
        for (int size = this.f8115h.size() - 1; size >= 1; size--) {
            this.f8115h.remove(size);
        }
    }

    static boolean a(j jVar) {
        WeakReference<Activity> weakReference = jVar.f8110a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    static void b(j jVar, C0416c c0416c, String str) {
        Objects.requireNonNull(jVar);
        long jI = c0416c.I();
        if (jI <= 0) {
            return;
        }
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("thread_id", Long.valueOf(jI));
        contentValues.put("body", str);
        contentValues.put("type", (Integer) 3);
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        Uri uriD = O.d(jVar.f8112c, jVar.f8111b, Telephony.Sms.CONTENT_URI, contentValues);
        jVar.k(c0416c);
        D0.b.a(jI, 0, uriD);
    }

    static void d(j jVar, long j2) {
        O.c(jVar.f8112c, jVar.f8111b, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, j2), "type=3", null);
        D0.b.a(j2, 0, null);
    }

    private static String e0(int i2) {
        if (i2 == 0) {
            return "<none>";
        }
        StringBuilder sb = new StringBuilder();
        if ((i2 & 1) > 0) {
            sb.append("RECIPIENTS_REQUIRE_MMS | ");
        }
        if ((i2 & 2) > 0) {
            sb.append("HAS_SUBJECT | ");
        }
        if ((i2 & 4) > 0) {
            sb.append("HAS_ATTACHMENT | ");
        }
        if ((i2 & 8) > 0) {
            sb.append("LENGTH_REQUIRES_MMS | ");
        }
        if ((i2 & 16) > 0) {
            sb.append("FORCE_MMS | ");
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }

    private void f0() throws UnsupportedEncodingException {
        byte[] bytes;
        p pVar = this.f8115h;
        if (pVar == null || pVar.size() != 1) {
            return;
        }
        o oVarW = this.f8115h.get(0);
        CharSequence charSequence = this.g;
        int i2 = P0.r.f937c;
        if (TextUtils.isEmpty(charSequence)) {
            bytes = null;
        } else {
            try {
                bytes = charSequence.toString().getBytes("utf-8");
            } catch (UnsupportedEncodingException e2) {
                Log.e("Mms", "Unsupported encoding: utf-8", e2);
                bytes = charSequence.toString().getBytes();
            }
        }
        oVarW.p(new q(this.f8112c, "text/plain", "text_0.txt", 106, bytes, this.f8115h.z().y()));
    }

    private void i(int i2, Uri uri) throws C0303b, IOException {
        k aVar;
        if (i2 == 0) {
            return;
        }
        p pVar = this.f8115h;
        o oVarW = pVar.get(pVar.size() - 1);
        if (i2 == 1) {
            aVar = new G0.i(this.f8112c, uri, this.f8115h.z().u());
        } else if (i2 == 2) {
            aVar = new s(this.f8112c, uri, this.f8115h.z().u());
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException("changeMedia type=" + i2 + ", uri=" + uri);
            }
            aVar = new G0.a(this.f8112c, uri);
        }
        oVarW.p(aVar);
        if (i2 == 2 || i2 == 3) {
            oVarW.K(aVar.r());
        }
    }

    private void j(Uri uri, String str) {
        Q2.c.a(new i(this, uri, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(Uri uri, C0319o c0319o, p pVar, t tVar, int i2) {
        if (Log.isLoggable("Mms:app", 2)) {
            Y1.a.c("updateDraftMmsMessage uri=%s", uri);
        }
        if (uri == null) {
            Log.e("WorkingMessage", "updateDraftMmsMessage null uri");
            return;
        }
        c0319o.s(uri, tVar);
        C0313i c0313iI = pVar.I();
        try {
            c0319o.u(uri, c0313iI, i2);
        } catch (C0303b unused) {
            Log.e("WorkingMessage", "updateDraftMmsMessage: cannot update message " + uri);
        }
        pVar.H(c0313iI);
    }

    private void k(C0416c c0416c) {
        this.f8119l = false;
        long jI = c0416c.I();
        if (jI > 0) {
            Q2.c.a(new a("thread_id = " + jI, jI));
            this.f8116i = null;
            return;
        }
        Uri uri = this.f8116i;
        if (uri != null) {
            j(uri, null);
            this.f8116i = null;
        }
    }

    private void n(int i2, Uri uri) throws C0303b, C0341b, IOException {
        k aVar;
        this.f8115h.E();
        o oVarW = this.f8115h.get(0);
        if (oVarW == null) {
            Log.w("Mms", "changeMedia: no slides!");
            return;
        }
        if (i2 == 1) {
            aVar = new G0.i(this.f8112c, uri, this.f8115h.z().u());
        } else if (i2 == 2) {
            aVar = new s(this.f8112c, uri, this.f8115h.z().u());
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException("changeMedia type=" + i2 + ", uri=" + uri);
            }
            aVar = new G0.a(this.f8112c, uri);
        }
        k kVarV = oVarW.A() ? oVarW.v() : oVarW.z() ? oVarW.t() : oVarW.C() ? oVarW.y() : null;
        if (kVarV != null) {
            int iS = aVar instanceof G0.i ? 0 : aVar.s();
            int iS2 = kVarV instanceof G0.i ? 0 : kVarV.s();
            if (iS > iS2) {
                this.f8115h.r(iS - iS2);
            }
        }
        oVarW.H();
        oVarW.I();
        oVarW.G();
        this.f8113e = 0;
        if (i2 == 0) {
            return;
        }
        oVarW.p(aVar);
        if (i2 == 2 || i2 == 3) {
            oVarW.K(aVar.r());
        }
    }

    private void p(boolean z4) {
        boolean z5;
        int iG = this.f8115h.G();
        int size = this.f8115h.size();
        if (size + iG == 0) {
            N(false);
        } else if (iG > 1 || size > 1) {
            this.f8113e = 5;
        } else {
            if (iG != 1) {
                z5 = false;
            } else {
                if (!this.f8115h.x().get(0).s()) {
                    throw new IllegalStateException("Unknown attachment file type");
                }
                z5 = true;
            }
            o oVarW = this.f8115h.get(0);
            if (z5) {
                if (oVarW.A() || oVarW.z() || oVarW.C()) {
                    this.f8113e = 5;
                } else {
                    this.f8113e = 4;
                }
            } else if (oVarW.A() && oVarW.z()) {
                this.f8113e = 5;
            } else if (oVarW.A()) {
                this.f8113e = 1;
            } else if (oVarW.C()) {
                this.f8113e = 2;
            } else if (oVarW.z()) {
                this.f8113e = 3;
            }
        }
        k0(4, A(), z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri q(C0319o c0319o, t tVar, p pVar, int i2) {
        if (pVar == null) {
            return null;
        }
        try {
            C0313i c0313iI = pVar.I();
            tVar.j(c0313iI);
            Uri uriN = c0319o.n(tVar, Telephony.Mms.Draft.CONTENT_URI, i2, null);
            pVar.H(c0313iI);
            return uriN;
        } catch (SQLiteException e2) {
            if (!O.b(e2)) {
                O.a(this.f8112c, e2);
            }
            return null;
        } catch (C0303b | SecurityException unused) {
            return null;
        }
    }

    private void s() {
        if (this.f8115h != null) {
            return;
        }
        p pVarT = p.t(this.f8112c);
        pVarT.add(new o(pVarT));
        this.f8115h = pVarT;
    }

    public final boolean A() {
        int i2 = this.f8113e;
        return i2 < 32 && i2 > 0;
    }

    public final boolean B() {
        return this.f8113e == 5;
    }

    public final boolean C(boolean z4) {
        CharSequence charSequence;
        boolean z5 = (this.d & 2) != 0;
        if (z4 && z5 && ((charSequence = this.f8117j) == null || TextUtils.getTrimmedLength(charSequence) <= 0)) {
            return false;
        }
        return z5;
    }

    public final boolean D() {
        CharSequence charSequence = this.g;
        return charSequence != null && charSequence.length() > 0;
    }

    public final boolean E() {
        return this.f8118k;
    }

    public final boolean F() {
        return (this.d & 16) > 0;
    }

    public final boolean G() {
        return D() || C(true) || A() || B() || F();
    }

    public final boolean I(C0416c c0416c) {
        Cursor cursorE;
        Uri uriWithAppendedId;
        boolean z4;
        if (c0416c.I() <= 0) {
            return false;
        }
        long jI = c0416c.I();
        if (jI <= 0 || !c0416c.L()) {
            this.g = "";
        } else {
            Uri uriWithAppendedId2 = ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, jI);
            this.g = "";
            cursorE = O.e(this.f8112c, this.f8111b, uriWithAppendedId2, f8109w, "type=3", null, null);
            if (cursorE != null) {
                try {
                    if (cursorE.moveToFirst()) {
                        this.g = cursorE.getString(0);
                        this.f8123q = 0L;
                        this.f8124r = t(this.f8112c, 0L);
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } finally {
                }
            } else {
                z4 = false;
            }
            if (z4 && c0416c.C() == 0) {
                l(c0416c);
                o(c0416c);
            }
            if (Log.isLoggable("Mms:app", 2)) {
                Y1.a.c("readDraftSmsMessage haveDraft: ", Boolean.valueOf(!TextUtils.isEmpty(this.g)));
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.f8120m = true;
            return true;
        }
        StringBuilder sb = new StringBuilder();
        MmsApp mmsApp = this.f8112c;
        ContentResolver contentResolver = mmsApp.getContentResolver();
        StringBuilder sbD = D2.e.d("thread_id = ");
        sbD.append(c0416c.I());
        cursorE = O.e(mmsApp, contentResolver, Telephony.Mms.Draft.CONTENT_URI, f8108v, sbD.toString(), null, null);
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    uriWithAppendedId = ContentUris.withAppendedId(Telephony.Mms.Draft.CONTENT_URI, cursorE.getLong(0));
                    String strD = P0.r.d(cursorE, 1, 2);
                    this.f8123q = 0L;
                    this.f8124r = t(mmsApp, 0L);
                    if (strD != null) {
                        sb.append(strD);
                    }
                    if (Log.isLoggable("Mms:app", 2)) {
                        Y1.a.c("readDraftMmsMessage uri: ", uriWithAppendedId);
                    }
                } else {
                    uriWithAppendedId = null;
                }
            } finally {
            }
        } else {
            uriWithAppendedId = null;
        }
        if (uriWithAppendedId == null || !K(uriWithAppendedId, false, false)) {
            return false;
        }
        if (sb.length() > 0) {
            Z(sb.toString(), false);
        }
        W(m(), false);
        return true;
    }

    public final boolean J(Uri uri, boolean z4) {
        return K(uri, z4, false);
    }

    public final boolean K(Uri uri, boolean z4, boolean z5) {
        o oVarW;
        if (Log.isLoggable("Mms:app", 2)) {
            Y1.a.c("loadFromUri %s", uri);
        }
        try {
            p pVarS = p.s(this.f8112c, uri);
            this.f8115h = pVarS;
            if (z4) {
                this.f8116i = null;
                pVarS.d();
            } else {
                this.f8116i = uri;
            }
            this.f8119l = true;
            if (this.f8115h.size() == 1 && (oVarW = this.f8115h.get(0)) != null && oVarW.B()) {
                this.g = oVarW.x().H();
            }
            p(z5);
            return true;
        } catch (C0303b unused) {
            Y1.a.d("Couldn't load URI %s", uri);
            return false;
        }
    }

    public final void N(boolean z4) {
        b bVar;
        this.f8113e = 0;
        p pVar = this.f8115h;
        if (pVar != null && pVar.size() > 1) {
            this.g = "";
        }
        this.f8115h = null;
        Uri uri = this.f8116i;
        if (uri != null) {
            j(uri, null);
            this.f8116i = null;
        }
        k0(4, false, z4);
        if (!z4 || (bVar = this.f8121n) == null) {
            return;
        }
        ((P) bVar).J0();
    }

    public final void O() {
        k0(16, false, false);
    }

    public final boolean P() {
        return this.d > 0;
    }

    public final Uri Q(boolean z4) {
        if (this.f8118k) {
            Y1.a.l("saveAsMms mDiscarded: true mConversation: returning NULL uri and bailing", new Object[0]);
            return null;
        }
        k0(16, true, z4);
        M();
        try {
            MmsApp.g(true);
            this.f8114f.q();
            this.f8114f.Z(true);
            C0319o c0319oE = C0319o.e(this.f8112c);
            t tVarL = L(this.f8114f, this.f8117j);
            Uri uri = this.f8116i;
            if (uri == null) {
                this.f8116i = q(c0319oE, tVarL, this.f8115h, -1);
            } else {
                j0(uri, c0319oE, this.f8115h, tVarL, -1);
            }
            this.f8119l = true;
            MmsApp.g(false);
            return this.f8116i;
        } catch (Throwable th) {
            MmsApp.g(false);
            throw th;
        }
    }

    public final void R(boolean z4) {
        if (this.f8118k) {
            Y1.a.l("saveDraft mDiscarded: true mConversation: skipping saving draft and bailing", new Object[0]);
            return;
        }
        if (this.f8114f == null) {
            throw new IllegalStateException("saveDraft() called with no conversation");
        }
        M();
        if (P()) {
            Q2.c.a(new g(this, this.f8114f, z4));
            this.f8119l = true;
            this.f8114f.Z(true);
            return;
        }
        String string = this.g.toString();
        if (TextUtils.isEmpty(string)) {
            k(this.f8114f);
            return;
        }
        Q2.c.a(new h(this, this.f8114f, string));
        this.f8120m = true;
        this.f8114f.Z(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S(String str, int i2) {
        c cVar;
        boolean z4;
        if (Log.isLoggable("Mms:transaction", 2)) {
            Y1.a.c("send", new Object[0]);
        }
        if (!C(true)) {
            Z(null, true);
        }
        M();
        C0416c c0416c = this.f8114f;
        String string = this.g.toString();
        if (P()) {
            if (k0.d.u() == null) {
                C0341b c0341b = new C0341b("WorkingMessage.send MMS sending failure. mms_config.xml is missing uaProfUrl setting.  uaProfUrl is required for MMS service, but can be absent for SMS.");
                Log.e("WorkingMessage", "WorkingMessage.send MMS sending failure. mms_config.xml is missing uaProfUrl setting.  uaProfUrl is required for MMS service, but can be absent for SMS.", c0341b);
                throw c0341b;
            }
            cVar = new c(c0416c, this.f8115h);
        } else if (k0.d.f() != null) {
            String[] strArrN = c0416c.G().n(false);
            int length = strArrN.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (S2.d.h(strArrN[i4]) || C0292y.a(strArrN[i4])) {
                    if (SmsMessage.calculateLength(strArrN[i4] + " " + string, false)[0] > 1) {
                        k0(1, true, true);
                        s();
                        f0();
                        z4 = true;
                        break;
                    }
                }
            }
            z4 = false;
            if (z4) {
                cVar = new c(c0416c, this.g.toString(), str);
            }
        } else {
            z4 = false;
            if (z4) {
            }
        }
        cVar.b(i2);
        cVar.a(this.p);
        cVar.executeOnExecutor(u, new Void[0]);
        f.i(c0416c.G());
        this.f8118k = true;
    }

    public final int T(int i2, Uri uri, boolean z4) {
        if (Log.isLoggable("Mms:app", 2)) {
            Y1.a.c("setAttachment type=%d uri %s", Integer.valueOf(i2), uri);
        }
        s();
        int i4 = -1;
        try {
            if (i2 == 4) {
                X(i2, uri, z4);
            } else if (z4) {
                i(i2, uri);
            } else {
                n(i2, uri);
            }
        } catch (C0303b | UnsupportedOperationException | C0341b unused) {
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (k0.c unused2) {
            i4 = -2;
        } catch (k0.e unused3) {
            i4 = -3;
        }
        i4 = 0;
        if (i4 == 0) {
            this.f8113e = i2;
        }
        b bVar = this.f8121n;
        if (bVar != null) {
            ((P) bVar).J0();
        }
        if (z4 || !m()) {
            k0(4, A(), true);
        } else {
            W(true, false);
        }
        p(false);
        return i4;
    }

    public final void U(C0416c c0416c) {
        boolean z4;
        this.f8114f = c0416c;
        Iterator<C0414a> it = c0416c.G().iterator();
        while (true) {
            if (!it.hasNext()) {
                z4 = false;
                break;
            } else if (it.next().i0()) {
                z4 = true;
                break;
            }
        }
        if (k0.d.f() != null) {
            k0(1, false, false);
        } else {
            k0(1, z4, false);
        }
    }

    public final void V(boolean z4) {
        if (k0.d.f() != null) {
            k0(1, false, true);
        } else {
            k0(1, z4, true);
        }
    }

    public final void W(boolean z4, boolean z5) {
        k0(8, z4, z5);
    }

    public final void Y() {
        this.p = false;
    }

    public final void Z(CharSequence charSequence, boolean z4) {
        this.f8117j = charSequence;
        k0(2, charSequence != null, z4);
    }

    public final void a0(CharSequence charSequence) {
        this.g = charSequence;
        W(m(), true);
    }

    public final void b0(long j2) {
        this.f8123q = j2;
    }

    public final void c0(String str) {
        this.f8124r = str;
    }

    public final void d0(List<String> list) {
        this.f8122o = list;
        int size = list.size();
        if (size == 0 || size != 1) {
            return;
        }
        list.get(0);
    }

    public final void g0() {
        List<String> list = this.f8122o;
        if (list != null) {
            C0415b c0415bK = C0415b.k(list);
            if (!c0415bK.equals(this.f8114f.G())) {
                if (this.f8114f.I() != 0) {
                    l(this.f8114f);
                    L0.b.a(this.f8114f.I(), true);
                }
                C0416c.j0(this.f8114f, c0415bK);
            }
            this.f8122o = null;
        }
    }

    public final void h0(String str) {
        if (this.f8115h == null) {
            Y1.a.d("error: slideshow is null, create an empty one", new Object[0]);
            s();
        }
        for (int i2 = 0; i2 < this.f8115h.size(); i2++) {
            o oVarW = this.f8115h.get(i2);
            if (oVarW != null && !oVarW.B()) {
                WeakReference<Activity> weakReference = this.f8110a;
                if ((weakReference == null || weakReference.get() == null) ? false : true) {
                    q qVar = new q(this.f8110a.get(), "text/plain", "text_" + i2 + ".txt", 106, new byte[0], this.f8115h.z().y());
                    qVar.I(str);
                    oVarW.p(qVar);
                    return;
                }
            }
        }
    }

    public final void i0() {
        this.f8118k = false;
    }

    protected final void k0(int i2, boolean z4, boolean z5) {
        b bVar;
        b bVar2;
        if (f8106s) {
            int i4 = this.d;
            if (z4) {
                this.d = i4 | i2;
            } else {
                this.d = (~i2) & i4;
            }
            if (this.d == 16 && (i4 & (-17)) > 0) {
                this.d = 0;
            }
            if (z5) {
                if (i4 == 0 && this.d != 0 && (bVar2 = this.f8121n) != null) {
                    ((P) bVar2).Q0(true);
                } else if (i4 != 0 && this.d == 0 && (bVar = this.f8121n) != null) {
                    ((P) bVar).Q0(false);
                }
            }
            if (i4 == this.d || !Log.isLoggable("Mms:app", 2)) {
                return;
            }
            Object[] objArr = new Object[3];
            objArr[0] = z4 ? "+" : "-";
            objArr[1] = e0(i2);
            objArr[2] = e0(this.d);
            Y1.a.c("updateState: %s%s = %s", objArr);
        }
    }

    public final void l(C0416c c0416c) {
        this.f8120m = false;
        long jI = c0416c.I();
        if (jI > 0) {
            j(ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, jI), "type=3");
            D0.b.a(jI, 0, null);
        }
    }

    public final boolean m() {
        C0416c c0416c = this.f8114f;
        if (c0416c != null && c0416c.G() != null) {
            this.f8114f.G().q();
        }
        return !k0.d.n() && this.f8114f != null && this.f8113e == 0 && D() && SmsMessage.calculateLength(this.g, MmsApp.f4463s)[0] >= k0.d.r();
    }

    public final void o(C0416c c0416c) {
        if (c0416c.C() == 0) {
            c0416c.k();
        }
        c0416c.Z(false);
    }

    public final synchronized void r() {
        Y1.a.c("[WorkingMessage] discard", new Object[0]);
        if (this.f8118k) {
            return;
        }
        this.f8118k = true;
        if (this.f8119l) {
            k(this.f8114f);
            o(this.f8114f);
        }
        if (this.f8120m) {
            l(this.f8114f);
            o(this.f8114f);
        }
    }

    public final String t(Context context, long j2) {
        if (j2 <= 0) {
            return "";
        }
        String dateTime = DateUtils.formatDateTime(context, j2, (DateFormat.is24HourFormat(context) ? 128 : 64) | 21);
        return TextUtils.isEmpty(dateTime) ? "" : dateTime;
    }

    public final p u() {
        return this.f8115h;
    }

    public final CharSequence v() {
        return this.f8117j;
    }

    public final CharSequence w() {
        return this.g;
    }

    public final long x() {
        return this.f8123q;
    }

    public final String y() {
        return this.f8124r;
    }

    public final String z() {
        List<String> list = this.f8122o;
        if (list == null) {
            return null;
        }
        return C0415b.k(list).q();
    }

    private class c extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private Dialog f8128a;

        /* renamed from: b, reason: collision with root package name */
        private C0416c f8129b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8130c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f8131e;

        /* renamed from: f, reason: collision with root package name */
        private int f8132f;
        private Uri g;

        /* renamed from: h, reason: collision with root package name */
        private C0319o f8133h;

        /* renamed from: i, reason: collision with root package name */
        private p f8134i;

        /* renamed from: j, reason: collision with root package name */
        private String f8135j;

        /* renamed from: k, reason: collision with root package name */
        private String f8136k;

        public c(C0416c c0416c, p pVar) {
            this.f8129b = c0416c;
            this.g = j.this.f8116i;
            this.f8133h = C0319o.e(j.this.f8112c);
            this.f8134i = pVar;
            this.f8130c = true;
        }

        public final void a(boolean z4) {
            this.f8131e = z4;
        }

        public final void b(int i2) {
            this.f8132f = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected final Void doInBackground(Void[] voidArr) throws Throwable {
            String str;
            q qVarX;
            p pVar = this.f8134i;
            Cursor cursor = null;
            if (pVar != null) {
                if (pVar.size() == 1 && (qVarX = pVar.get(0).x()) != null) {
                    qVarX.E();
                }
                t tVarL = j.L(this.f8129b, j.this.f8117j);
                C0416c c0416c = this.f8129b;
                Uri uriQ = this.g;
                C0319o c0319o = this.f8133h;
                p pVar2 = this.f8134i;
                C0294a.a(j.this.f8112c);
                try {
                    j jVar = j.this;
                    Cursor cursorE = O.e(jVar.f8112c, jVar.f8111b, Telephony.Mms.Outbox.CONTENT_URI, j.f8107t, null, null, null);
                    if (cursorE != null) {
                        try {
                            long jK = k0.d.k() * k0.d.j();
                            long j2 = 0;
                            while (cursorE.moveToNext()) {
                                j2 += cursorE.getLong(1);
                            }
                            if (j2 >= jK) {
                                j jVar2 = j.this;
                                jVar2.f8118k = false;
                                b bVar = jVar2.f8121n;
                                if (bVar != null) {
                                    ((P) bVar).N0();
                                }
                                cursorE.close();
                            } else {
                                if (cursorE != null) {
                                    cursorE.close();
                                }
                                b bVar2 = j.this.f8121n;
                                if (bVar2 != null) {
                                    ((P) bVar2).P0();
                                }
                                try {
                                    MmsApp.g(true);
                                    long jQ = c0416c.q();
                                    if (Log.isLoggable("Mms:app", 2)) {
                                        Y1.a.c("sendMmsWorker: update draft MMS message " + uriQ, new Object[0]);
                                    }
                                    String[] strArrN = c0416c.G().n(true);
                                    if (strArrN.length == 1) {
                                        str = "WorkingMessage";
                                        String strK0 = C0416c.k0(j.this.f8112c, c0416c.I(), strArrN[0]);
                                        if (!strK0.equals(strArrN[0])) {
                                            strArrN[0] = strK0;
                                            C0309e[] c0309eArrD = C0309e.d(strArrN);
                                            if (c0309eArrD != null) {
                                                tVarL.u(c0309eArrD);
                                            }
                                        }
                                    } else {
                                        str = "WorkingMessage";
                                    }
                                    int iM = (int) C0287t.m(this.f8132f);
                                    if (uriQ == null) {
                                        uriQ = j.this.q(c0319o, tVarL, pVar2, iM);
                                    } else {
                                        j.this.j0(uriQ, c0319o, pVar2, tVarL, iM);
                                    }
                                    MmsApp.g(false);
                                    int i2 = -1;
                                    if (uriQ == null) {
                                        b bVar3 = j.this.f8121n;
                                        if (bVar3 != null) {
                                            ((P) bVar3).K0(-1, null);
                                        }
                                    } else {
                                        j.d(j.this, jQ);
                                        try {
                                            pVar2.v(uriQ);
                                            i2 = 0;
                                        } catch (C0303b unused) {
                                        } catch (k0.c unused2) {
                                            i2 = -2;
                                        }
                                        if (i2 != 0) {
                                            j jVar3 = j.this;
                                            Objects.requireNonNull(jVar3);
                                            ContentValues contentValues = new ContentValues(1);
                                            contentValues.put("err_type", (Integer) 10);
                                            O.g(jVar3.f8112c, jVar3.f8111b, Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues, "msg_id=" + ContentUris.parseId(uriQ), null);
                                            b bVar4 = j.this.f8121n;
                                            if (bVar4 != null) {
                                                ((P) bVar4).K0(i2, uriQ);
                                            }
                                        } else {
                                            Y1.a.c("sendMmsWorker sending message: threadId=%d", Long.valueOf(jQ));
                                            try {
                                                new O0.e(j.this.f8112c, uriQ, pVar2.y(), j.this.f8123q, this.f8132f).a();
                                                L.d().b(j.this.f8112c, jQ);
                                            } catch (Exception e2) {
                                                Log.e(str, "Failed to send message: " + uriQ + ", threadId=" + jQ, e2);
                                            }
                                            this.d = true;
                                        }
                                    }
                                } catch (Throwable th) {
                                    MmsApp.g(false);
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorE;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                C0416c c0416c2 = this.f8129b;
                String str2 = this.f8135j;
                String str3 = this.f8136k;
                C0294a.a(j.this.f8112c);
                b bVar5 = j.this.f8121n;
                if (bVar5 != null) {
                    ((P) bVar5).P0();
                }
                long jI = c0416c2.I();
                long jQ2 = c0416c2.q();
                String strQ = c0416c2.G().q();
                if ((jI != 0 && jI != jQ2) || (!strQ.equals(str3) && !TextUtils.isEmpty(str3))) {
                    String str4 = (jI == 0 || jI == jQ2) ? "Recipients in window: " : "WorkingMessage.preSendSmsWorker threadId changed or recipients changed. origThreadId: " + jI + " new threadId: " + jQ2 + " also mConversation.getThreadId(): " + j.this.f8114f.I();
                    if (j.a(j.this)) {
                        j.this.f8110a.get();
                        Y1.a.m(str4);
                    }
                }
                String[] strArrSplit = TextUtils.split(strQ, ";");
                Log.d("Mms:transaction", "sendSmsWorker sending message: threadId=" + jQ2);
                j jVar4 = j.this;
                try {
                    new O0.s(jVar4.f8112c, strArrSplit, str2, jQ2, jVar4.f8123q, this.f8132f).a();
                    L.e().b(j.this.f8112c, jQ2);
                } catch (Exception e4) {
                    Log.e("WorkingMessage", "Failed to send SMS message, threadId=" + jQ2, e4);
                }
                this.d = true;
                j.d(j.this, jQ2);
            }
            C0415b c0415bG = this.f8129b.G();
            if (!c0415bG.isEmpty()) {
                c0415bG.get(0);
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f8129b.G().n(false)));
            C0228a c0228a = new C0228a(j.this.f8112c);
            try {
                int size = arrayList.size();
                if (size <= 50) {
                    c0228a.a(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    for (int i5 = 0; i5 < size; i5++) {
                        i4++;
                        arrayList2.add((String) arrayList.get(i5));
                        if (i4 > 50) {
                            c0228a.a(arrayList2);
                            arrayList2.clear();
                            i4 = 0;
                        }
                    }
                    if (i4 > 0) {
                        c0228a.a(arrayList2);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f8129b.Z(false);
            return null;
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Void r32) {
            Dialog dialog;
            b bVar;
            if (j.a(j.this)) {
                Activity activity = j.this.f8110a.get();
                if (this.d && (bVar = j.this.f8121n) != null) {
                    bVar.j();
                }
                b bVar2 = j.this.f8121n;
                if (bVar2 != null && ((P) bVar2).isDestroyed()) {
                    this.f8130c = false;
                    this.f8128a = null;
                }
                if (this.f8130c && (dialog = this.f8128a) != null && dialog.isShowing()) {
                    this.f8128a.dismiss();
                    this.f8128a = null;
                }
                if (activity instanceof P) {
                    ((P) activity).c1(null);
                }
            }
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
            if (j.a(j.this)) {
                Activity activity = j.this.f8110a.get();
                if (this.f8130c) {
                    Objects.requireNonNull(j.this);
                    Dialog dialog = new Dialog(activity, R.style.loading_dialog);
                    dialog.setContentView(R.layout.loading_dialog);
                    dialog.setCancelable(false);
                    dialog.getWindow().setLayout(-2, -2);
                    dialog.getWindow().setGravity(17);
                    dialog.getWindow().setFlags(8, 8);
                    C0178a.p(((ProgressBar) dialog.findViewById(R.id.progress)).getIndeterminateDrawable());
                    this.f8128a = dialog;
                    if (activity instanceof P) {
                        ((P) activity).c1(dialog);
                    }
                    this.f8128a.show();
                }
            }
        }

        public c(C0416c c0416c, String str, String str2) {
            this.f8129b = c0416c;
            this.f8135j = str;
            this.f8136k = str2;
            this.f8130c = c0416c.G().size() > 1;
        }
    }
}
