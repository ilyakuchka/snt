package O0;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.transaction.TimedMessageReceiver;
import com.android.mmt.transaction.TransactionService;
import com.android.mmt.ui.C0243g0;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.ui.MessagingPreferenceActivity;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;
import f0.C0302a;
import f0.C0303b;
import g0.C0309e;
import g0.C0310f;
import g0.C0319o;
import g0.C0321q;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Context f769a;

    /* renamed from: b, reason: collision with root package name */
    private final Uri f770b;

    /* renamed from: c, reason: collision with root package name */
    private final long f771c;
    private final long d;

    /* renamed from: e, reason: collision with root package name */
    private final int f772e;

    public e(Context context, Uri uri, long j2, long j4, int i2) {
        this.f769a = context;
        this.f770b = uri;
        this.f771c = j2;
        this.d = j4;
        this.f772e = i2;
    }

    public static void b(Context context, String str, String str2, int i2, long j2) {
        C0309e[] c0309eArr = {new C0309e(106, str)};
        if (str2 == null) {
            str2 = "";
        }
        try {
            C0321q c0321q = new C0321q(new C0309e("insert-address-token".getBytes()), str2.getBytes(), i2, c0309eArr);
            c0321q.e(System.currentTimeMillis() / 1000);
            C0319o.e(context.getApplicationContext()).n(c0321q, Telephony.Mms.Outbox.CONTENT_URI, (int) j2, C0287t.n(C0287t.q(j2)));
            context.startService(new Intent(context, (Class<?>) TransactionService.class));
        } catch (C0302a e2) {
            W2.a.c("MmsMessageSender", "Invalide header value", e2);
        } catch (C0303b e4) {
            W2.a.c("MmsMessageSender", "Persist message failed", e4);
        }
    }

    public final boolean a() throws C0303b {
        long jM = C0287t.m(this.f772e);
        C0319o c0319oE = C0319o.e(this.f769a.getApplicationContext());
        C0310f c0310fH = c0319oE.h(this.f770b);
        if (c0310fH.a() != 128) {
            StringBuilder sbD = D2.e.d("Invalid message: ");
            sbD.append(c0310fH.a());
            throw new C0303b(sbD.toString());
        }
        g0.t tVar = (g0.t) c0310fH;
        SharedPreferences sharedPreferencesC = androidx.preference.g.c(this.f769a);
        tVar.q();
        tVar.l();
        boolean z4 = androidx.preference.g.c(this.f769a).getBoolean("pref_key_delivery_reports", MessagingPreferenceActivity.P());
        Log.i("MmsMessageSender", "MmsSend: requireDelivery = " + z4);
        tVar.p(z4 ? 128 : 129);
        tVar.t(sharedPreferencesC.getBoolean(C0287t.b(jM, "pref_key_mms_read_reports"), false) ? 128 : 129);
        tVar.r("personal".getBytes());
        long jCurrentTimeMillis = System.currentTimeMillis();
        tVar.k(jCurrentTimeMillis / 1000);
        tVar.s(this.f771c);
        c0319oE.s(this.f770b, tVar);
        ContentValues contentValues = new ContentValues();
        if (tVar.f() != -1) {
            contentValues.put("date_ms_part", Long.valueOf(jCurrentTimeMillis % 1000));
        }
        contentValues.put("sub_id", Long.valueOf(jM));
        if (this.d > 0) {
            Context context = this.f769a;
            O.g(context, context.getContentResolver(), this.f770b, contentValues, null, null);
            c0319oE.m(this.f770b, Telephony.Mms.Sent.CONTENT_URI);
            TimedMessageReceiver.a(this.f769a);
        } else {
            Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, ContentUris.parseId(this.f770b));
            c0319oE.m(this.f770b, Telephony.Mms.Outbox.CONTENT_URI);
            Intent intent = new Intent(this.f769a, (Class<?>) TransactionService.class);
            intent.putExtra("uri", uriWithAppendedId.toString());
            intent.putExtra("type", 2);
            this.f769a.startService(intent);
            Log.d("NewMessageInjector", "onMessageSend: " + uriWithAppendedId);
            Cursor cursorQuery = MmsApp.c().getContentResolver().query(uriWithAppendedId, null, null, null, null);
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
                    BugleDatabase.y().x().F(aVar, true, 4);
                } catch (C0303b e2) {
                    e2.printStackTrace();
                }
            }
        }
        return true;
    }
}
