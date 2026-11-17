package O0;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.util.C0278j;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.L;
import com.android.mmt.util.O;
import f0.C0303b;
import g0.C0305a;
import g0.C0312h;
import g0.C0314j;
import g0.C0317m;
import g0.C0319o;
import g0.C0322r;
import java.io.IOException;

/* loaded from: classes.dex */
public final class j extends com.android.mmt.transaction.l implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    private Uri f802s;

    /* renamed from: t, reason: collision with root package name */
    private C0312h f803t;
    private String u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f804v;

    public j(Context context, v vVar, String str) {
        super(context, vVar);
        Uri uri = Uri.parse(str);
        this.f802s = uri;
        this.f4642m.c(uri);
        try {
            C0312h c0312h = (C0312h) C0319o.e(context.getApplicationContext()).h(this.f802s);
            this.f803t = c0312h;
            this.f4641l = new String(c0312h.k());
            this.u = new String(this.f803t.e());
        } catch (C0303b e2) {
            W2.a.e(4, Y1.a.h("Failed to load NotificationInd from: %s\nStack:%s", str, Log.getStackTraceString(e2)));
            throw new IllegalArgumentException();
        }
    }

    private void n(int i2) throws C0303b, IOException {
        C0305a c0305a = new C0305a(this.f803t.k(), i2);
        StringBuilder sbD = D2.e.d("sendAcknowledge: NotifyMMSC = ");
        sbD.append(k0.d.o());
        Log.i("NotificationTransaction", sbD.toString());
        if (k0.d.o()) {
            l(new C0314j(this.f4640k, c0305a).l(), this.u);
        } else {
            k(new C0314j(this.f4640k, c0305a).l(), null);
        }
    }

    @Override // com.android.mmt.transaction.l
    public final int g() {
        return 0;
    }

    @Override // com.android.mmt.transaction.l
    public final void h() {
        C0278j.c().h(this.f802s, 128, this.p);
        this.f4640k.getContentResolver().notifyChange(Telephony.MmsSms.CONTENT_CONVERSATIONS_URI, null);
    }

    @Override // com.android.mmt.transaction.l
    public final void i() {
        C0278j c0278jC = C0278j.c();
        this.f804v = c0278jC.f(this.p);
        Uri uri = this.f802s;
        int i2 = P0.r.f937c;
        MmsApp.c();
        if (P0.r.m(uri) != 0) {
            this.f804v = false;
        }
        c0278jC.h(this.f802s, this.f804v ? 129 : 128, this.p);
        this.f4640k.getContentResolver().notifyChange(Telephony.MmsSms.CONTENT_CONVERSATIONS_URI, null);
    }

    @Override // com.android.mmt.transaction.l
    public final void j() {
        Q2.c.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0167 A[Catch: all -> 0x01b9, TryCatch #2 {all -> 0x01b9, blocks: (B:41:0x0147, B:49:0x016c, B:45:0x0159, B:47:0x0161, B:48:0x0167), top: B:97:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0192  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        byte[] bArrF;
        int i2;
        com.android.mmt.transaction.l.f4638q = Long.valueOf(this.f802s.getLastPathSegment()).longValue();
        com.android.mmt.transaction.l.f4639r = 0;
        int i4 = 131;
        try {
            Y1.a.k("Notification transaction launched: %s", this);
            if (this.f804v) {
                C0287t.q(this.p);
                this.f804v = ((TelephonyManager) MmsApp.c().getSystemService(TelephonyManager.class)).getDataState() != 3;
            }
            if (!this.f804v) {
                this.f4642m.c(this.f802s);
                if (!this.f804v) {
                    this.f4642m.d(1);
                }
                if (this.f4642m.b() != 1) {
                    this.f4642m.d(2);
                    W2.a.e(4, Y1.a.h("Transaction failed.", new Object[0]));
                }
                c();
                if (this.f804v) {
                    return;
                }
                try {
                    n(131);
                    return;
                } catch (Throwable th) {
                    Y1.a.k("Exception: %s", Log.getStackTraceString(th));
                    return;
                }
            }
            Y1.a.k("Content-Location: %s", this.u);
            try {
                bArrF = f(this.u);
            } catch (IOException unused) {
                this.f4642m.d(2);
                bArrF = null;
            }
            try {
                if (bArrF != null) {
                    C0322r c0322r = (C0322r) new C0317m(bArrF).a();
                    i2 = 132;
                    if (c0322r != null) {
                        if (c0322r.a() != 132) {
                            W2.a.e(4, Y1.a.h("Invalid M-RETRIEVE.CONF PDU for type is not right.", new Object[0]));
                            this.f4642m.d(2);
                        } else {
                            C0319o c0319oE = C0319o.e(this.f4640k.getApplicationContext());
                            Uri uri = Telephony.Mms.Inbox.CONTENT_URI;
                            long j2 = this.p;
                            Uri uriN = c0319oE.n(c0322r, uri, (int) j2, C0287t.n(C0287t.q(j2)));
                            Context context = this.f4640k;
                            O.c(context, context.getContentResolver(), this.f802s, null, null);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("sub_id", Long.valueOf(this.p));
                            contentValues.put("m_size", Long.valueOf(this.f803t.i()));
                            Context context2 = this.f4640k;
                            O.g(context2, context2.getContentResolver(), uriN, contentValues, null, null);
                            this.f802s = uriN;
                            i2 = 129;
                        }
                        Y1.a.k("status=%x", Integer.valueOf(i2));
                        if (i2 != 129) {
                            this.f4642m.d(1);
                        } else if (i2 == 131 && this.f4642m.b() == 0) {
                            this.f4642m.d(1);
                        }
                        n(i2);
                        L.d().h(this.f4640k, this.f802s);
                        this.f4642m.c(this.f802s);
                        if (!this.f804v) {
                            this.f4642m.d(1);
                        }
                        if (this.f4642m.b() != 1) {
                            this.f4642m.d(2);
                            W2.a.e(4, Y1.a.h("Transaction failed.", new Object[0]));
                        }
                        c();
                        if (this.f804v) {
                            try {
                                n(i2);
                                return;
                            } catch (Throwable th2) {
                                Y1.a.k("Exception: %s", Log.getStackTraceString(th2));
                                return;
                            }
                        }
                        return;
                    }
                    W2.a.e(4, Y1.a.h("Invalid M-RETRIEVE.CONF PDU for pdu is null", new Object[0]));
                    this.f4642m.d(2);
                } else {
                    W2.a.e(4, "getPdu result is null maybe read in stream error");
                    this.f4642m.d(2);
                }
                Y1.a.k("status=%x", Integer.valueOf(i2));
                if (i2 != 129) {
                }
                n(i2);
                L.d().h(this.f4640k, this.f802s);
                this.f4642m.c(this.f802s);
                if (!this.f804v) {
                }
                if (this.f4642m.b() != 1) {
                }
                c();
                if (this.f804v) {
                }
            } catch (Throwable th3) {
                th = th3;
                i4 = i2;
                try {
                    Y1.a.k("Exception: %s", Log.getStackTraceString(th));
                    this.f4642m.c(this.f802s);
                    if (!this.f804v) {
                        this.f4642m.d(1);
                    }
                    if (this.f4642m.b() != 1) {
                        this.f4642m.d(2);
                        W2.a.e(4, Y1.a.h("Transaction failed.", new Object[0]));
                    }
                    c();
                    if (this.f804v) {
                        return;
                    }
                    try {
                        n(i4);
                        return;
                    } catch (Throwable th4) {
                        Y1.a.k("Exception: %s", Log.getStackTraceString(th4));
                        return;
                    }
                } finally {
                }
            }
            i2 = 131;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public j(Context context, v vVar, C0312h c0312h) {
        super(context, vVar);
        try {
            C0319o c0319oE = C0319o.e(context.getApplicationContext());
            Uri uri = Telephony.Mms.Inbox.CONTENT_URI;
            long j2 = this.p;
            this.f802s = c0319oE.n(c0312h, uri, (int) j2, C0287t.n(C0287t.q(j2)));
            this.f803t = c0312h;
            this.f4641l = new String(c0312h.k());
        } catch (C0303b e2) {
            W2.a.e(4, Y1.a.h("Failed to save NotificationInd in constructor.\nStack:%s", Log.getStackTraceString(e2)));
            throw new IllegalArgumentException();
        }
    }
}
