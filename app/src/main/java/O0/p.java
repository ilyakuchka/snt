package O0;

import a.C0178a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.util.C0278j;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.L;
import com.android.mmt.util.O;
import f0.C0303b;
import g0.C0305a;
import g0.C0309e;
import g0.C0314j;
import g0.C0317m;
import g0.C0319o;
import g0.C0322r;
import java.io.IOException;

/* loaded from: classes.dex */
public final class p extends com.android.mmt.transaction.l implements Runnable {

    /* renamed from: x, reason: collision with root package name */
    static final String[] f813x = {"ct_l", "locked", "m_size"};

    /* renamed from: s, reason: collision with root package name */
    private final Uri f814s;

    /* renamed from: t, reason: collision with root package name */
    private final Uri f815t;
    private final String u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f816v;

    /* renamed from: w, reason: collision with root package name */
    private long f817w;

    public p(Context context, v vVar, String str) throws C0303b {
        super(context, vVar);
        if (!str.startsWith("content://")) {
            throw new IllegalArgumentException("Initializing from X-Mms-Content-Location is abandoned!");
        }
        Uri uri = Uri.parse(str);
        this.f814s = uri;
        this.f815t = uri;
        this.f4642m.c(uri);
        Cursor cursorE = O.e(context, context.getContentResolver(), uri, f813x, null, null, null);
        this.f816v = false;
        if (cursorE != null) {
            try {
                boolean z4 = true;
                if (cursorE.getCount() == 1 && cursorE.moveToFirst()) {
                    if (cursorE.getInt(1) != 1) {
                        z4 = false;
                    }
                    this.f816v = z4;
                    this.f817w = cursorE.getLong(2);
                    String string = cursorE.getString(0);
                    cursorE.close();
                    this.u = string;
                    this.f4641l = string;
                    return;
                }
            } finally {
                cursorE.close();
            }
        }
        throw new C0303b("Cannot get X-Mms-Content-Location from: " + uri);
    }

    private boolean n(Context context, C0322r c0322r) {
        byte[] bArrO = c0322r.o();
        if (bArrO != null) {
            String str = new String(bArrO);
            StringBuilder sbD = D2.e.d("(m_id = ? AND m_type = ?) AND sub_id=");
            sbD.append(this.p);
            Cursor cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, new String[]{"_id"}, sbD.toString(), new String[]{str, String.valueOf(132)}, null);
            if (cursorE != null) {
                try {
                    if (cursorE.getCount() > 0) {
                        return true;
                    }
                } finally {
                    cursorE.close();
                }
            }
        }
        return false;
    }

    private void o(C0322r c0322r) throws C0303b, IOException {
        byte[] bArrP = c0322r.p();
        if (bArrP != null) {
            C0305a c0305a = new C0305a(bArrP);
            String strF = C0178a.f(this.f4640k, (int) this.p);
            if (TextUtils.isEmpty(strF)) {
                Log.e("RetrieveTransaction", "lineNumber is empty");
                strF = "";
            }
            c0305a.b(new C0309e(strF));
            Log.i("RetrieveTransaction", "sendAcknowledge: NotifyMMSC = " + k0.d.o());
            if (k0.d.o()) {
                l(new C0314j(this.f4640k, c0305a).l(), this.u);
            } else {
                k(new C0314j(this.f4640k, c0305a).l(), null);
            }
        }
    }

    @Override // com.android.mmt.transaction.l
    public final int g() {
        return 1;
    }

    @Override // com.android.mmt.transaction.l
    public final void h() {
        C0278j.c().h(this.f815t, 128, this.p);
        this.f4640k.getContentResolver().notifyChange(Telephony.MmsSms.CONTENT_CONVERSATIONS_URI, null);
    }

    @Override // com.android.mmt.transaction.l
    public final void i() {
        C0278j.c().h(this.f815t, 129, this.p);
        this.f4640k.getContentResolver().notifyChange(Telephony.MmsSms.CONTENT_CONVERSATIONS_URI, null);
    }

    @Override // com.android.mmt.transaction.l
    public final void j() {
        Q2.c.a(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strH;
        byte[] bArrF;
        com.android.mmt.transaction.l.f4638q = Long.valueOf(this.f815t.getLastPathSegment()).longValue();
        com.android.mmt.transaction.l.f4639r = 0;
        try {
            bArrF = f(this.u);
        } catch (Throwable th) {
            try {
                W2.a.e(4, Y1.a.h("Exception: %s", Log.getStackTraceString(th)));
                if (this.f4642m.b() != 1) {
                    this.f4642m.d(2);
                    this.f4642m.c(this.f815t);
                    strH = Y1.a.h("Retrieval failed.", new Object[0]);
                }
            } catch (Throwable th2) {
                if (this.f4642m.b() != 1) {
                    this.f4642m.d(2);
                    this.f4642m.c(this.f815t);
                    W2.a.e(4, Y1.a.h("Retrieval failed.", new Object[0]));
                }
                c();
                throw th2;
            }
        }
        if (bArrF == null) {
            throw new C0303b("Invalid M-Retrieve.conf resp data.");
        }
        C0322r c0322r = (C0322r) new C0317m(bArrF).a();
        if (c0322r == null) {
            throw new C0303b("Invalid M-Retrieve.conf PDU.");
        }
        Uri uri = null;
        if (n(this.f4640k, c0322r)) {
            Context context = this.f4640k;
            O.c(context, context.getContentResolver(), this.f815t, null, null);
            this.f4642m.d(2);
            this.f4642m.c(this.f815t);
        } else {
            C0319o c0319oE = C0319o.e(this.f4640k.getApplicationContext());
            if (P0.r.m(this.f815t) > 1) {
                this.f814s.buildUpon().build();
            }
            Uri uri2 = Telephony.Mms.Inbox.CONTENT_URI;
            long j2 = this.p;
            Uri uriN = c0319oE.n(c0322r, uri2, (int) j2, C0287t.n(C0287t.q(j2)));
            Context context2 = this.f4640k;
            O.c(context2, context2.getContentResolver(), this.f815t, null, null);
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_size", Long.valueOf(this.f817w));
            Context context3 = this.f4640k;
            O.g(context3, context3.getContentResolver(), uriN, contentValues, null, null);
            this.f4642m.d(1);
            this.f4642m.c(uriN);
            Context context4 = this.f4640k;
            String str = this.u;
            boolean z4 = this.f816v;
            ContentValues contentValues2 = new ContentValues(2);
            contentValues2.put("ct_l", str);
            contentValues2.put("locked", Integer.valueOf(z4 ? 1 : 0));
            O.g(context4, context4.getContentResolver(), uriN, contentValues2, null, null);
            uri = uriN;
        }
        L.d().h(this.f4640k, uri);
        o(c0322r);
        if (this.f4642m.b() != 1) {
            this.f4642m.d(2);
            this.f4642m.c(this.f815t);
            strH = Y1.a.h("Retrieval failed.", new Object[0]);
            W2.a.e(4, strH);
        }
        c();
    }
}
