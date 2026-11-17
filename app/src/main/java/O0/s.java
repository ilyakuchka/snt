package O0;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.Telephony;
import android.util.Log;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.transaction.TimedMessageReceiver;
import com.android.mmt.ui.MessagingPreferenceActivity;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;
import f0.C0303b;
import java.util.HashSet;

/* loaded from: classes.dex */
public class s {

    /* renamed from: j, reason: collision with root package name */
    private static final Uri f825j = Uri.parse("content://sms/queued");

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f826k = {"reply_path_present", "service_center"};

    /* renamed from: a, reason: collision with root package name */
    protected final Context f827a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f828b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f829c;
    protected final String d;

    /* renamed from: e, reason: collision with root package name */
    protected final String f830e;

    /* renamed from: f, reason: collision with root package name */
    protected final long f831f;
    protected long g;

    /* renamed from: h, reason: collision with root package name */
    private final long f832h;

    /* renamed from: i, reason: collision with root package name */
    protected final int f833i;

    /* JADX WARN: Removed duplicated region for block: B:31:0x009e A[PHI: r10
      0x009e: PHI (r10v6 java.lang.String) = (r10v7 java.lang.String), (r10v4 java.lang.String), (r10v8 java.lang.String) binds: [B:25:0x0092, B:26:0x0094, B:30:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s(Context context, String[] strArr, String str, long j2, long j4, int i2) throws Throwable {
        this.f833i = i2;
        this.f827a = context;
        this.d = str;
        Cursor cursor = null;
        string = null;
        string = null;
        String string = null;
        if (strArr != null) {
            int length = strArr.length;
            this.f828b = length;
            String[] strArr2 = new String[length];
            this.f829c = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, length);
        } else {
            this.f828b = 0;
            this.f829c = null;
        }
        this.f832h = j4;
        this.g = System.currentTimeMillis();
        if (j2 == 0) {
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < this.f828b; i4++) {
                hashSet.add(this.f829c[i4]);
            }
            this.f831f = C0287t.i(context, hashSet);
        } else {
            this.f831f = j2;
        }
        long j5 = this.f831f;
        try {
            Context context2 = this.f827a;
            Cursor cursorE = O.e(context2, context2.getContentResolver(), Telephony.Sms.CONTENT_URI, f826k, "thread_id = " + j5, null, "date DESC");
            if (cursorE != null) {
                try {
                    if (cursorE.moveToFirst()) {
                        boolean z4 = 1 == cursorE.getInt(0);
                        W2.a.a("SmsMessageSender", "replyPathPresent is " + z4);
                        if (z4) {
                            string = cursorE.getString(1);
                        }
                        cursorE.close();
                    } else if (cursorE != null) {
                        cursorE.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorE;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else if (cursorE != null) {
            }
            this.f830e = string;
            W2.a.a("SmsMessageSender", "service center is " + string);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() throws C0303b {
        long jM;
        Uri uri;
        long j2;
        int i2;
        Uri uriA;
        long j4;
        boolean z4;
        if (this.d == null || this.f828b == 0) {
            throw new C0303b("Null message body or dest.");
        }
        if (C0287t.A(this.f833i)) {
            jM = C0287t.m(this.f833i);
        } else {
            Y1.a.k("slot id is not valid", new Object[0]);
            jM = 0;
        }
        boolean z5 = androidx.preference.g.c(this.f827a).getBoolean("pref_key_delivery_reports", MessagingPreferenceActivity.P());
        Y1.a.c("是否获取发送报告:%b", Boolean.valueOf(z5));
        long j5 = this.f832h;
        if (j5 > 0) {
            uri = Telephony.Sms.Sent.CONTENT_URI;
        } else {
            uri = f825j;
            j5 = this.g;
        }
        Uri uri2 = uri;
        long j6 = j5;
        System.currentTimeMillis();
        int i4 = 0;
        while (i4 < this.f828b) {
            Uri uri3 = null;
            try {
                int i5 = i4;
                try {
                    j2 = j6;
                    i2 = i5;
                    try {
                        uriA = C0287t.a(this.f827a, uri2, this.f829c[i4], this.d, Long.valueOf(j6), z5, this.f831f, jM);
                    } catch (SQLiteException e2) {
                        e = e2;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    j2 = j6;
                    i2 = i5;
                }
                try {
                    W2.a.a("SmsMessageSender", "message queued, uri:" + uriA);
                } catch (SQLiteException e5) {
                    e = e5;
                    uri3 = uriA;
                    O.a(this.f827a, e);
                    uriA = uri3;
                    if (uriA == null) {
                    }
                    i4 = i2 + 1;
                    j6 = j4;
                }
            } catch (SQLiteException e6) {
                e = e6;
                j2 = j6;
                i2 = i4;
            }
            if (uriA == null) {
                long id = ContentUris.parseId(uriA);
                long j7 = this.f831f;
                String str = this.d;
                if (id < 0) {
                    j4 = j2;
                    z4 = true;
                } else {
                    Log.d("NewMessageInjector", "onMessageSend: 0 | " + id);
                    L0.a aVar = new L0.a();
                    aVar.z(j7);
                    j4 = j2;
                    aVar.s(j4);
                    aVar.C(str);
                    z4 = true;
                    BugleDatabase.y().x().F(aVar, true, 4);
                }
            }
            i4 = i2 + 1;
            j6 = j4;
        }
        if (this.f832h > 0) {
            TimedMessageReceiver.a(this.f827a);
        } else {
            Y1.a.c("广播SmsReceiverService.ACTION_SEND_MESSAGE", new Object[0]);
            C0287t.I(this.f827a, this.f833i);
        }
        return false;
    }
}
