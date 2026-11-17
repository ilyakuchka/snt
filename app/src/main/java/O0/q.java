package O0;

import a.C0178a;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.util.H;
import com.android.mmt.util.O;
import g0.C0309e;
import g0.C0314j;
import g0.C0317m;
import g0.C0319o;
import g0.C0323s;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class q extends com.android.mmt.transaction.l implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    private final Uri f818s;

    final class a implements m {
        a() {
        }
    }

    public q(Context context, v vVar, String str) {
        super(context, vVar);
        Uri uri = Uri.parse(str);
        this.f818s = uri;
        this.f4642m.c(uri);
        this.f4641l = str;
    }

    @Override // com.android.mmt.transaction.l
    public final int g() {
        return 2;
    }

    @Override // com.android.mmt.transaction.l
    public final void j() {
        Q2.c.a(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strH;
        H hB;
        com.android.mmt.transaction.l.f4638q = Long.valueOf(this.f818s.getLastPathSegment()).longValue();
        com.android.mmt.transaction.l.f4639r = 0;
        try {
            hB = H.b();
        } catch (Throwable th) {
            try {
                W2.a.e(4, Y1.a.h("Exception: %s", Log.getStackTraceString(th)));
                if (this.f4642m.b() != 1) {
                    this.f4642m.d(2);
                    this.f4642m.c(this.f818s);
                    D0.b.b(1, com.android.mmt.transaction.l.f4638q);
                    strH = Y1.a.h("Delivery failed.", new Object[0]);
                }
            } catch (Throwable th2) {
                if (this.f4642m.b() != 1) {
                    this.f4642m.d(2);
                    this.f4642m.c(this.f818s);
                    D0.b.b(1, com.android.mmt.transaction.l.f4638q);
                    W2.a.e(4, Y1.a.h("Delivery failed.", new Object[0]));
                }
                c();
                throw th2;
            }
        }
        if (hB.e() && !hB.d()) {
            W2.a.e(4, Y1.a.h("Sending rate limit surpassed.", new Object[0]));
            if (this.f4642m.b() != 1) {
                this.f4642m.d(2);
                this.f4642m.c(this.f818s);
                D0.b.b(1, com.android.mmt.transaction.l.f4638q);
                W2.a.e(4, Y1.a.h("Delivery failed.", new Object[0]));
            }
            c();
            return;
        }
        C0319o c0319oE = C0319o.e(this.f4640k.getApplicationContext());
        g0.t tVar = (g0.t) c0319oE.h(this.f818s);
        long jCurrentTimeMillis = System.currentTimeMillis();
        tVar.k(jCurrentTimeMillis / 1000);
        ContentValues contentValues = new ContentValues(1);
        if (tVar.o() == null) {
            byte[] bytes = ("T" + Long.toHexString(System.currentTimeMillis())).getBytes();
            Log.w("SendTransaction", " loaded null transaction, generate a new one " + bytes);
            tVar.v(bytes);
            contentValues.put("tr_id", C0319o.r(bytes));
        }
        contentValues.put("date", Long.valueOf(jCurrentTimeMillis / 1000));
        Context context = this.f4640k;
        O.g(context, context.getContentResolver(), this.f818s, contentValues, null, null);
        String strF = C0178a.f(this.f4640k, (int) this.p);
        if (TextUtils.isEmpty(strF)) {
            Log.e("SendTransaction", "lineNumber is empty");
            strF = "";
        }
        tVar.b(new C0309e(strF));
        if (tVar.i() != null) {
            int length = tVar.i().length;
        }
        C0323s c0323s = (C0323s) new C0317m(k(new C0314j(this.f4640k, tVar).l(), new a())).a();
        if (c0323s == null) {
            W2.a.e(4, Y1.a.h("No M-Send.conf received.", new Object[0]));
        }
        byte[] bArrO = tVar.o();
        byte[] bArrG = c0323s.g();
        if (!Arrays.equals(bArrO, bArrG)) {
            W2.a.e(4, Y1.a.h("Inconsistent Transaction-ID: req=%d, conf=%d", bArrO, bArrG));
            if (this.f4642m.b() != 1) {
                this.f4642m.d(2);
                this.f4642m.c(this.f818s);
                D0.b.b(1, com.android.mmt.transaction.l.f4638q);
                W2.a.e(4, Y1.a.h("Delivery failed.", new Object[0]));
            }
            c();
            return;
        }
        ContentValues contentValues2 = new ContentValues(2);
        int iF = c0323s.f();
        contentValues2.put("resp_st", Integer.valueOf(iF));
        contentValues2.put("sub_id", Long.valueOf(this.p));
        if (iF != 128) {
            Context context2 = this.f4640k;
            O.g(context2, context2.getContentResolver(), this.f818s, contentValues2, null, null);
            W2.a.e(4, Y1.a.h("Server returned an error code: %d", Integer.valueOf(iF)));
            if (this.f4642m.b() != 1) {
                this.f4642m.d(2);
                this.f4642m.c(this.f818s);
                D0.b.b(1, com.android.mmt.transaction.l.f4638q);
                W2.a.e(4, Y1.a.h("Delivery failed.", new Object[0]));
            }
            c();
            return;
        }
        contentValues2.put("m_id", C0319o.r(c0323s.e()));
        Context context3 = this.f4640k;
        O.g(context3, context3.getContentResolver(), this.f818s, contentValues2, null, null);
        W2.a.e(1, Y1.a.h("Moved to sent box: %s", this.f818s));
        Uri uriM = c0319oE.m(this.f818s, Telephony.Mms.Sent.CONTENT_URI);
        this.f4642m.d(1);
        this.f4642m.c(uriM);
        if (this.f4642m.b() != 1) {
            this.f4642m.d(2);
            this.f4642m.c(this.f818s);
            D0.b.b(1, com.android.mmt.transaction.l.f4638q);
            strH = Y1.a.h("Delivery failed.", new Object[0]);
            W2.a.e(4, strH);
        }
        c();
    }
}
