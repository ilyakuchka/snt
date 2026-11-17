package O0;

import a.C0178a;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.util.A;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f839e = {"type", "mmsc", "mmsproxy", "mmsport"};

    /* renamed from: a, reason: collision with root package name */
    private String f840a;

    /* renamed from: b, reason: collision with root package name */
    private String f841b;

    /* renamed from: c, reason: collision with root package name */
    private String f842c;
    private int d;

    public v(Context context, int i2) {
        this.d = -1;
        e(context, null, i2);
    }

    public final String a() {
        return this.f840a;
    }

    public final String b() {
        return this.f841b;
    }

    public final int c() {
        return this.d;
    }

    public final boolean d() {
        String str = this.f841b;
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Context context, String str, int i2) {
        String strJ;
        String string;
        boolean z4;
        String string2;
        if (TextUtils.equals(this.f842c, str) && !TextUtils.isEmpty(str)) {
            Log.w("TransactionSettings", " apn name not changed");
            return;
        }
        int i4 = C0287t.f6041f;
        Cursor cursorE = null;
        try {
            strJ = C0178a.j(i2, "gsm.apn.sim.operator.numeric");
            if (TextUtils.isEmpty(strJ)) {
                strJ = C0178a.i(MmsApp.c(), (int) C0287t.m(i2));
                Log.v("MSimUtils", "getSimOperator oper from TelephonyManager is " + strJ);
            } else {
                Log.v("MSimUtils", "getNetworkOperator oper is " + strJ);
            }
        } catch (SecurityException e2) {
            A.f(e2);
            strJ = null;
        }
        if (!TextUtils.isEmpty(strJ)) {
            string = C2.c.a("numeric='", strJ, "'");
            if (!TextUtils.isEmpty(str)) {
                string = string + " AND apn='" + str.trim() + "'";
            }
        } else if (TextUtils.isEmpty(str)) {
            string = null;
        } else {
            StringBuilder sbD = D2.e.d("apn='");
            sbD.append(str.trim());
            sbD.append("'");
            string = sbD.toString();
        }
        if (i2 == 0 || 1 == i2) {
            C0287t.x();
            cursorE = O.e(context, context.getContentResolver(), Telephony.Carriers.CONTENT_URI, f839e, string, null, null);
        }
        if (Log.isLoggable("Mms:transaction", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("TransactionSettings looking for apn: ");
            sb.append(string);
            sb.append(" returned: ");
            sb.append(cursorE == null ? "null cursor" : cursorE.getCount() + " hits");
            W2.a.f("TransactionSettings", sb.toString());
        }
        if (cursorE == null) {
            W2.a.b("TransactionSettings", "Apn is not found in Database!");
            return;
        }
        boolean z5 = false;
        while (cursorE.moveToNext() && !z5) {
            try {
                String string3 = cursorE.getString(0);
                if (!TextUtils.isEmpty(string3)) {
                    for (String str2 : string3.split(",")) {
                        if (!str2.equals("mms") && !str2.equals("*")) {
                        }
                    }
                    z4 = false;
                    if (!z4) {
                        String string4 = cursorE.getString(1);
                        String str3 = "";
                        if (string4 == null) {
                            string4 = "";
                        }
                        String string5 = cursorE.getString(2);
                        if (string5 != null) {
                            str3 = string5;
                        }
                        this.f840a = M2.a.c(string4.trim());
                        this.f841b = M2.a.c(str3.trim());
                        if (!TextUtils.isEmpty(this.f840a)) {
                            z5 = true;
                        }
                        Log.v("TransactionSettings", " mmsc changed " + this.f840a);
                        this.f842c = str;
                        if (d() && (string2 = cursorE.getString(3)) != null) {
                            try {
                                this.d = Integer.parseInt(string2);
                            } catch (NumberFormatException e4) {
                                if (TextUtils.isEmpty(string2)) {
                                    int i5 = W2.a.f1818a;
                                    W2.a.e(2, "TransactionSettings, mms port not set!");
                                } else {
                                    W2.a.c("TransactionSettings", "Bad port number format: " + string2, e4);
                                }
                            }
                        }
                    }
                }
                z4 = true;
                if (!z4) {
                }
            } finally {
                cursorE.close();
            }
        }
        if (z5 && TextUtils.isEmpty(this.f840a)) {
            W2.a.b("TransactionSettings", "Invalid APN setting: MMSC is empty");
        }
    }

    public v(String str, String str2, int i2) {
        this.d = -1;
        this.f840a = str.trim();
        this.f841b = str2;
        this.d = i2;
    }
}
