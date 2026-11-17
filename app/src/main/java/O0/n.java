package O0;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.provider.Telephony;
import android.text.TextUtils;
import com.android.mmt.R;
import com.android.mmt.transaction.TransactionService;
import com.android.mmt.util.C0270b;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;
import f0.C0303b;
import g0.C0308d;
import g0.C0310f;
import g0.C0312h;
import g0.C0317m;
import g0.C0319o;
import g0.C0320p;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class n extends BroadcastReceiver {

    private class a extends AsyncTask<Intent, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private Context f807a;

        /* renamed from: b, reason: collision with root package name */
        private BroadcastReceiver.PendingResult f808b;

        public a(Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f807a = context;
            this.f808b = pendingResult;
        }

        private void a(long j2, C0310f c0310f) {
            if (j2 < 0) {
                W2.a.b("PushReceiver", "update delivery status is failed for msgId < 0");
                return;
            }
            Uri uri = Uri.parse(Telephony.Mms.CONTENT_URI + "/" + j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("st", Integer.valueOf(((C0308d) c0310f).f()));
            Context context = this.f807a;
            if (O.g(context, context.getContentResolver(), uri, contentValues, null, null) <= 0) {
                W2.a.b("PushReceiver", "update delivery status is failed for msgId is " + j2);
            }
        }

        @Override // android.os.AsyncTask
        protected final Void doInBackground(Intent[] intentArr) {
            Intent intent = intentArr[0];
            C0310f c0310fA = new C0317m(intent.getByteArrayExtra("data")).a();
            if (c0310fA == null) {
                W2.a.b("PushReceiver", "Invalid PUSH data");
            } else {
                C0319o c0319oE = C0319o.e(this.f807a);
                ContentResolver contentResolver = this.f807a.getContentResolver();
                int iA = c0310fA.a();
                try {
                    if (iA == 130) {
                        C0312h c0312h = (C0312h) c0310fA;
                        if (k0.d.s()) {
                            byte[] bArrE = c0312h.e();
                            if (61 == bArrE[bArrE.length - 1]) {
                                byte[] bArrK = c0312h.k();
                                byte[] bArr = new byte[bArrE.length + bArrK.length];
                                System.arraycopy(bArrE, 0, bArr, 0, bArrE.length);
                                System.arraycopy(bArrK, 0, bArr, bArrE.length, bArrK.length);
                                c0312h.l(bArr);
                            }
                        }
                        if (n.b(this.f807a, c0312h)) {
                            W2.a.f("PushReceiver", "Skip downloading duplicate message: " + new String(c0312h.e()));
                        } else {
                            int iT = C0287t.t(intent);
                            long jM = C0287t.m(iT);
                            if (jM < 0) {
                                W2.a.b("PushReceiver", "Cannot get sim id for slot " + iT);
                            } else {
                                Uri uriBuild = c0319oE.n(c0310fA, Telephony.Mms.Inbox.CONTENT_URI, (int) jM, C0287t.n(iT)).buildUpon().build();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("sub_id", Long.valueOf(jM));
                                O.g(this.f807a, contentResolver, uriBuild, contentValues, null, null);
                                Intent intent2 = new Intent(this.f807a, (Class<?>) TransactionService.class);
                                intent2.putExtra("uri", uriBuild.toString());
                                intent2.putExtra("type", 0);
                                C0270b.b(this.f807a, intent2);
                            }
                        }
                    } else if (iA == 134 || iA == 136) {
                        long[] jArrA = n.a(this.f807a, c0310fA, iA);
                        if (jArrA[0] == -1) {
                            W2.a.b("PushReceiver", "delivery or read orig ind threadId == -1");
                        } else {
                            if (c0319oE.n(c0310fA, Telephony.Mms.Inbox.CONTENT_URI, -1, null) == null) {
                                W2.a.b("PushReceiver", "delivery or read orig ind gen uri is null");
                            }
                            if (iA == 134) {
                                a(jArrA[1], c0310fA);
                            }
                        }
                    } else {
                        W2.a.b("PushReceiver", "Received unrecognized PDU.");
                    }
                } catch (C0303b e2) {
                    W2.a.c("PushReceiver", "Failed to save the data from PUSH: type=" + iA, e2);
                } catch (RuntimeException e4) {
                    W2.a.c("PushReceiver", "Unexpected RuntimeException.", e4);
                }
                W2.a.f("PushReceiver", "PUSH Intent processed.");
            }
            return null;
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Void r12) {
            super.onPostExecute(r12);
            this.f808b.finish();
        }
    }

    private class b extends AsyncTask<Intent, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private Context f809a;

        /* renamed from: b, reason: collision with root package name */
        private String f810b;

        /* renamed from: c, reason: collision with root package name */
        private StringBuilder f811c;
        private BroadcastReceiver.PendingResult d;

        public b(Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f809a = context;
            this.d = pendingResult;
        }

        private void a(String str) {
            if (this.f811c.length() > 0) {
                this.f811c.append('\n');
            } else {
                this.f811c.append(this.f809a.getResources().getString(R.string.wap_push_title));
            }
            this.f811c.append(str);
        }

        private void b(Node node) {
            Node namedItem;
            String nodeValue;
            for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                b(firstChild);
            }
            if (node.getNodeType() == 3) {
                a(node.getNodeValue());
            }
            NamedNodeMap attributes = node.getAttributes();
            if (attributes == null || (namedItem = attributes.getNamedItem("href")) == null || (nodeValue = namedItem.getNodeValue()) == null || nodeValue.length() <= 0) {
                return;
            }
            a(nodeValue);
        }

        @Override // android.os.AsyncTask
        protected final Void doInBackground(Intent[] intentArr) throws Throwable {
            W2.a.a("PushReceiver", "ReceiveWapPushTask doInBackground");
            Intent intent = intentArr[0];
            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
            this.f810b = intent.getStringExtra("address");
            int iT = C0287t.t(intent);
            long jM = C0287t.m(iT);
            if (jM < 0) {
                W2.a.b("PushReceiver", "Cannot get sim id for slot " + iT);
                return null;
            }
            if (TextUtils.isEmpty(this.f810b)) {
                this.f810b = this.f809a.getResources().getString(R.string.wap_push_title);
            }
            Document documentA = new E0.d(this.f809a).a(new ByteArrayInputStream(byteArrayExtra));
            if (documentA == null) {
                return null;
            }
            this.f811c = new StringBuilder();
            b(documentA);
            if (this.f811c.length() <= 0) {
                return null;
            }
            long jH = C0287t.h(this.f809a, this.f810b);
            ContentValues contentValues = new ContentValues();
            contentValues.put("address", this.f810b);
            contentValues.put("protocol", (Integer) 0);
            contentValues.put("read", (Integer) 0);
            contentValues.put("status", (Integer) (-1));
            contentValues.put("body", this.f811c.toString());
            contentValues.put("sub_id", Long.valueOf(jM));
            contentValues.put("thread_id", Long.valueOf(jH));
            Context context = this.f809a;
            O.d(context, context.getContentResolver(), Uri.parse("content://sms/inbox"), contentValues);
            com.android.mmt.transaction.d.o(jH);
            return null;
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Void r12) {
            super.onPostExecute(r12);
            this.d.finish();
        }
    }

    static long[] a(Context context, C0310f c0310f, int i2) {
        String strR = i2 == 134 ? C0319o.r(((C0308d) c0310f).e()) : C0319o.r(((C0320p) c0310f).e());
        StringBuilder sb = new StringBuilder(40);
        sb.append("m_id");
        sb.append('=');
        sb.append(DatabaseUtils.sqlEscapeString(strR));
        sb.append(" AND ");
        sb.append("m_type");
        sb.append('=');
        sb.append(128);
        long[] jArr = {-1, -1};
        Cursor cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, new String[]{"thread_id", "_id"}, sb.toString(), null, null);
        if (cursorE != null) {
            try {
                if (cursorE.getCount() == 1 && cursorE.moveToFirst()) {
                    jArr[0] = cursorE.getLong(0);
                    jArr[1] = cursorE.getLong(1);
                }
            } finally {
                cursorE.close();
            }
        }
        return jArr;
    }

    static boolean b(Context context, C0312h c0312h) {
        Cursor cursorE;
        byte[] bArrE = c0312h.e();
        if (bArrE == null || (cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, new String[]{"_id"}, "ct_l = ?", new String[]{new String(bArrE)}, null)) == null) {
            return false;
        }
        try {
            return cursorE.getCount() > 0;
        } finally {
            cursorE.close();
        }
    }

    protected final boolean c(Context context, Intent intent) {
        if ("android.provider.Telephony.WAP_PUSH_DELIVER".equals(intent.getAction())) {
            W2.a.f("PushReceiver", "Received PUSH Intent: " + intent);
            String type = intent.getType();
            if ("application/vnd.wap.mms-message".equals(type)) {
                ((PowerManager) context.getSystemService("power")).newWakeLock(1, "Mms:MMS PushReceiver").acquire(5000L);
                new a(context, goAsync()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, intent);
                return true;
            }
            if (("application/vnd.wap.sic".equals(type) || "application/vnd.wap.slc".equals(type)) && androidx.preference.g.c(context).getBoolean("pref_key_allow_si_sl_push", true)) {
                new b(context, goAsync()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, intent);
                return true;
            }
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c(context, intent);
    }
}
