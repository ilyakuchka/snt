package x0;

import a.C0178a;
import android.content.ContentUris;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.R;
import com.android.mmt.util.C0292y;
import com.android.mmt.util.O;
import j3.C0338a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import k3.C0344a;
import t.C0384b;

/* renamed from: x0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0414a {

    /* renamed from: v, reason: collision with root package name */
    private static b f8009v;

    /* renamed from: y, reason: collision with root package name */
    private static boolean f8012y;

    /* renamed from: a, reason: collision with root package name */
    private long f8014a;

    /* renamed from: b, reason: collision with root package name */
    public int f8015b;

    /* renamed from: c, reason: collision with root package name */
    private String f8016c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private String f8017e;

    /* renamed from: f, reason: collision with root package name */
    private String f8018f = "";
    private String g;

    /* renamed from: h, reason: collision with root package name */
    private String f8019h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8020i;

    /* renamed from: j, reason: collision with root package name */
    private long f8021j;

    /* renamed from: k, reason: collision with root package name */
    private long f8022k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f8023l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f8024m;

    /* renamed from: n, reason: collision with root package name */
    private long f8025n;

    /* renamed from: o, reason: collision with root package name */
    private int f8026o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private String f8027q;

    /* renamed from: r, reason: collision with root package name */
    private Uri f8028r;

    /* renamed from: s, reason: collision with root package name */
    public String f8029s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8030t;
    public String u;

    /* renamed from: w, reason: collision with root package name */
    private static final String[] f8010w = {"12520"};

    /* renamed from: x, reason: collision with root package name */
    private static final WeakHashMap<c, Object> f8011x = new WeakHashMap<>();

    /* renamed from: z, reason: collision with root package name */
    public static String f8013z = null;

    /* renamed from: A, reason: collision with root package name */
    private static final char[] f8008A = {',', ';'};

    /* renamed from: x0.a$a, reason: collision with other inner class name */
    final class C0144a extends Thread {
        C0144a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws RemoteException, OperationApplicationException {
            C0414a.f8009v.m();
        }
    }

    /* renamed from: x0.a$b */
    private static class b {

        /* renamed from: f, reason: collision with root package name */
        private static final Uri f8031f;
        private static final String[] g;

        /* renamed from: h, reason: collision with root package name */
        private static final String[] f8032h;

        /* renamed from: i, reason: collision with root package name */
        private static final Uri f8033i;

        /* renamed from: j, reason: collision with root package name */
        private static final String[] f8034j;

        /* renamed from: b, reason: collision with root package name */
        private final Context f8036b;

        /* renamed from: a, reason: collision with root package name */
        private final C0145a f8035a = new C0145a();

        /* renamed from: c, reason: collision with root package name */
        private AtomicInteger f8037c = new AtomicInteger(0);
        public final ConcurrentHashMap<String, ArrayList<C0414a>> d = new ConcurrentHashMap<>();

        /* renamed from: e, reason: collision with root package name */
        public ConcurrentHashMap f8038e = new ConcurrentHashMap();

        /* renamed from: x0.a$b$a, reason: collision with other inner class name */
        private static class C0145a {

            /* renamed from: a, reason: collision with root package name */
            Thread f8039a;

            /* renamed from: b, reason: collision with root package name */
            private final ArrayList<C0414a> f8040b = new ArrayList<>();

            /* renamed from: x0.a$b$a$a, reason: collision with other inner class name */
            final class RunnableC0146a implements Runnable {
                RunnableC0146a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C0414a c0414a;
                    while (true) {
                        synchronized (C0145a.this.f8040b) {
                            if (C0145a.this.f8040b.size() == 0) {
                                try {
                                    C0145a.this.f8040b.wait();
                                } catch (InterruptedException unused) {
                                    return;
                                }
                            }
                            c0414a = C0145a.this.f8040b.size() > 0 ? (C0414a) C0145a.this.f8040b.remove(0) : null;
                        }
                        if (c0414a != null) {
                            C0414a.f8009v.s(c0414a);
                        }
                    }
                }
            }

            public C0145a() {
                Thread thread = new Thread(new RunnableC0146a());
                this.f8039a = thread;
                thread.setName("SingleContactLoader");
                this.f8039a.setPriority(1);
                this.f8039a.start();
            }

            public final void b(C0414a c0414a) {
                synchronized (this.f8040b) {
                    if (c0414a != null) {
                        int size = this.f8040b.size();
                        boolean z4 = false;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            C0414a c0414a2 = this.f8040b.get(i2);
                            if (c0414a.equals(c0414a2)) {
                                if (c0414a == c0414a2) {
                                    z4 = true;
                                    break;
                                }
                                Log.e("Contact", "TaskQueue push c != contact but equals is true");
                            }
                            i2++;
                        }
                        if (!z4) {
                            this.f8040b.add(c0414a);
                            this.f8040b.notify();
                        }
                    }
                }
            }
        }

        static {
            Uri uri = ContactsContract.Data.CONTENT_URI;
            f8031f = uri;
            g = new String[]{"_id", "data1", "display_name", "contact_id", "photo_id", "send_to_voicemail", "account_type"};
            f8032h = new String[]{"_id", "display_name"};
            f8033i = uri;
            f8034j = new String[]{"_id", "data4", "contact_id", "display_name", "photo_id", "send_to_voicemail", "data1"};
        }

        b(Context context) {
            this.f8036b = context;
        }

        static void a(b bVar, C0414a c0414a, boolean z4, boolean z5) {
            boolean z6;
            Objects.requireNonNull(bVar);
            synchronized (c0414a) {
                while (z4) {
                    if (!c0414a.f8024m) {
                        break;
                    } else {
                        try {
                            c0414a.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                z6 = true;
                if (c0414a.f8024m || !(z5 || c0414a.f8023l)) {
                    z6 = false;
                } else {
                    c0414a.f8023l = false;
                    c0414a.f8024m = true;
                }
            }
            if (z6) {
                if (z4) {
                    bVar.s(c0414a);
                } else {
                    bVar.f8035a.b(c0414a);
                }
            }
        }

        private void d(C0414a c0414a) {
            f.f().c(c0414a);
        }

        private boolean e(C0414a c0414a, C0414a c0414a2) {
            if (c0414a.f8015b != c0414a2.f8015b || c0414a.f8014a != c0414a2.f8014a || c0414a.f8022k != c0414a2.f8022k || c0414a.p != c0414a2.p) {
                return true;
            }
            String strU = c0414a.U();
            if (strU == null) {
                strU = "";
            }
            String strU2 = c0414a2.U();
            if (!strU.equals(strU2 != null ? strU2 : "") || c0414a.f8025n != c0414a2.f8025n || c0414a.f8026o != c0414a2.f8026o || !TextUtils.equals(c0414a.e0(), c0414a2.e0())) {
                return true;
            }
            String str = c0414a.d;
            String str2 = c0414a2.d;
            return str == null ? str2 != null : str.equals(str2) ^ true;
        }

        private boolean f(C0414a c0414a, Cursor cursor) {
            synchronized (c0414a) {
                c0414a.f8015b = 2;
                c0414a.f8014a = cursor.getLong(0);
                c0414a.f8022k = cursor.getLong(2);
                c0414a.p = cursor.getInt(5) == 1;
                c0414a.f8025n = cursor.getLong(4);
                String string = cursor.getString(1);
                if (TextUtils.isEmpty(string)) {
                    string = cursor.getString(3);
                }
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                c0414a.f8017e = string;
                return true;
            }
        }

        private void g(C0414a c0414a, Cursor cursor) {
            synchronized (c0414a) {
                boolean z4 = true;
                c0414a.f8015b = 1;
                c0414a.f8014a = cursor.getLong(0);
                c0414a.f8027q = cursor.getString(6);
                c0414a.f8017e = cursor.getString(2);
                c0414a.f8022k = cursor.getLong(3);
                c0414a.f8025n = cursor.getLong(4);
                if (cursor.getInt(5) != 1) {
                    z4 = false;
                }
                c0414a.p = z4;
            }
        }

        private void h(C0414a c0414a, e eVar) {
            synchronized (c0414a) {
                boolean z4 = true;
                c0414a.f8015b = 1;
                c0414a.f8014a = eVar.f8082a;
                c0414a.f8027q = eVar.f8083b;
                c0414a.f8017e = eVar.f8084c;
                c0414a.f8022k = eVar.d;
                c0414a.f8025n = eVar.f8085e;
                if (eVar.f8086f != 1) {
                    z4 = false;
                }
                c0414a.p = z4;
            }
        }

        private C0414a l(String str) {
            boolean z4 = S2.d.h(str) || C0292y.a(str);
            String strR = z4 ? str : r(str);
            ArrayList<C0414a> arrayList = this.d.get(strR);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    C0414a c0414a = arrayList.get(i2);
                    if (c0414a != null) {
                        String strW = c0414a.W();
                        if (!z4) {
                            String str2 = C0414a.f8013z;
                            if (C0178a.b(str, strW)) {
                                return c0414a;
                            }
                        } else if (str.equals(strW)) {
                            return c0414a;
                        }
                    }
                }
            } else {
                arrayList = new ArrayList<>();
                this.d.put(strR, arrayList);
            }
            C0414a c0414a2 = new C0414a(str);
            synchronized (arrayList) {
                arrayList.add(c0414a2);
            }
            return c0414a2;
        }

        private String n(String str) {
            if (str.length() >= 12) {
                String[] strArr = C0414a.f8010w;
                String strSubstring = str.substring(0, 5);
                int i2 = 0;
                while (true) {
                    if (i2 >= 1) {
                        i2 = -1;
                        break;
                    }
                    if (Objects.equals(strArr[i2], strSubstring)) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    return str.substring(5);
                }
            }
            return str;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean p(String str) {
            if (!S2.d.h(str)) {
                if (PhoneNumberUtils.isWellFormedSmsAddress(str) && !C0292y.a(str)) {
                    String strExtractNetworkPortion = PhoneNumberUtils.extractNetworkPortion(str);
                    boolean z4 = TextUtils.isEmpty(strExtractNetworkPortion) || strExtractNetworkPortion.length() < 3;
                    if (!z4) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean q(String str) {
            return C0292y.d(str) || C0292y.c(str);
        }

        private String r(String str) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || sb.length() >= 5) {
                    break;
                }
                char cCharAt = str.charAt(length);
                if (Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            return sb.length() < 5 ? str : sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00cb, code lost:
        
            g(r7, r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void s(C0414a c0414a) {
            C0414a c0414a2;
            Cursor cursorF;
            boolean z4;
            if (c0414a == null) {
                return;
            }
            int i2 = 1;
            if (c0414a.f8026o == 3) {
                c0414a2 = new C0414a();
                c0414a2.f8015b = 3;
                Context context = this.f8036b;
                cursorF = O.f(context, context.getContentResolver(), ContactsContract.Profile.CONTENT_URI, f8032h, null, null, null);
                if (cursorF == null) {
                    StringBuilder sbD = D2.e.d("getContactInfoForSelf() returned NULL cursor! contact uri used ");
                    sbD.append(ContactsContract.Profile.CONTENT_URI);
                    Log.w("Contact", sbD.toString());
                } else {
                    try {
                        if (cursorF.moveToFirst()) {
                            synchronized (c0414a2) {
                                c0414a2.f8017e = cursorF.getString(1);
                                if (TextUtils.isEmpty(c0414a2.f8017e)) {
                                    c0414a2.f8017e = this.f8036b.getString(R.string.messagelist_sender_self);
                                }
                                c0414a2.f8018f = c0414a2.f8017e;
                            }
                        }
                    } finally {
                    }
                }
            } else if (q(c0414a.f8016c)) {
                String str = c0414a.f8016c;
                C0414a c0414a3 = new C0414a(str);
                c0414a3.f8015b = 1;
                c0414a3.f8028r = Uri.fromParts("tel", str, null);
                if (!TextUtils.isEmpty(str)) {
                    Context context2 = this.f8036b;
                    cursorF = O.f(context2, context2.getContentResolver(), f8031f, g, "data1 =? ", new String[]{str}, "length(data1)");
                    if (cursorF != null) {
                        try {
                            cursorF.moveToPosition(-1);
                            while (true) {
                                if (cursorF.moveToNext()) {
                                    if (str.equals(cursorF.getString(1))) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } finally {
                        }
                    }
                }
                c0414a2 = c0414a3;
            } else if (p(c0414a.f8016c)) {
                String str2 = c0414a.f8016c;
                C0414a c0414a4 = new C0414a(str2);
                c0414a4.f8015b = 2;
                c0414a4.f8028r = Uri.fromParts("mailto", str2, null);
                Context context3 = this.f8036b;
                cursorF = O.f(context3, context3.getContentResolver(), f8033i, f8034j, "UPPER(data1)=UPPER(?) AND mimetype='vnd.android.cursor.item/email_v2'", new String[]{str2}, null);
                if (cursorF != null) {
                    while (cursorF.moveToNext() && !f(c0414a4, cursorF)) {
                        try {
                        } finally {
                        }
                    }
                    cursorF.close();
                }
                c0414a2 = c0414a4;
            } else {
                String str3 = c0414a.f8016c;
                long j2 = c0414a.f8014a;
                C0414a c0414a5 = new C0414a(str3);
                if (!TextUtils.isEmpty(null)) {
                    str3 = null;
                }
                c0414a5.f8015b = 1;
                c0414a5.f8028r = Uri.fromParts("tel", str3, null);
                String strN = n(str3);
                String callerIDMinMatch = PhoneNumberUtils.toCallerIDMinMatch(strN);
                if (!TextUtils.isEmpty(strN) && !TextUtils.isEmpty(callerIDMinMatch)) {
                    Context context4 = this.f8036b;
                    cursorF = O.f(context4, context4.getContentResolver(), f8031f, g, " Data._ID IN  (SELECT data_id FROM phone_lookup WHERE min_match = ?)", new String[]{callerIDMinMatch}, "length(data1)");
                    if (cursorF != null) {
                        try {
                            cursorF.moveToPosition(-1);
                            ArrayList arrayList = new ArrayList();
                            while (cursorF.moveToNext()) {
                                String strN2 = n(cursorF.getString(i2));
                                if (strN2 != null) {
                                    for (char c2 : C0414a.f8008A) {
                                        if (strN2.indexOf(c2) != -1) {
                                            z4 = true;
                                            break;
                                        }
                                    }
                                }
                                z4 = false;
                                if (!z4) {
                                    String str4 = C0414a.f8013z;
                                    if (C0178a.b(strN, strN2)) {
                                        e eVar = new e();
                                        eVar.f8082a = cursorF.getLong(0);
                                        eVar.f8083b = cursorF.getString(6);
                                        eVar.f8084c = cursorF.getString(2);
                                        eVar.d = cursorF.getLong(3);
                                        eVar.f8085e = cursorF.getLong(4);
                                        eVar.f8086f = cursorF.getInt(5);
                                        arrayList.add(eVar);
                                    }
                                }
                                i2 = 1;
                            }
                            if (!arrayList.isEmpty()) {
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        h(c0414a5, (e) arrayList.get(0));
                                        break;
                                    }
                                    e eVar2 = (e) it.next();
                                    if (eVar2 != null && j2 != -1 && eVar2.f8082a == j2) {
                                        h(c0414a5, eVar2);
                                        break;
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                }
                c0414a2 = c0414a5;
            }
            synchronized (c0414a) {
                if (e(c0414a, c0414a2)) {
                    c0414a.f8016c = c0414a2.f8016c;
                    c0414a.d = c0414a2.d;
                    c0414a.f8019h = c0414a2.f8019h;
                    c0414a.f8022k = c0414a2.f8022k;
                    c0414a.f8025n = c0414a2.f8025n;
                    c0414a.f8026o = c0414a2.f8026o;
                    c0414a.f8014a = c0414a2.f8014a;
                    c0414a.f8015b = c0414a2.f8015b;
                    c0414a.f8017e = c0414a2.f8017e;
                    c0414a.f8018f = c0414a2.f8017e;
                    c0414a.p = c0414a2.p;
                    c0414a.f8027q = c0414a2.f8027q;
                    c0414a.g = c0414a2.g;
                    c0414a.f8028r = c0414a2.f8028r;
                    if (!TextUtils.isEmpty(c0414a.f8016c)) {
                        synchronized (C0414a.f8011x) {
                            for (Map.Entry entry : C0414a.f8011x.entrySet()) {
                                c cVar = (c) entry.getKey();
                                Object value = entry.getValue();
                                if ((value != null && c0414a.f8016c.equals(value)) || value == null) {
                                    cVar.t(c0414a);
                                }
                            }
                        }
                    }
                }
                d(c0414a);
                c0414a.f8024m = false;
                c0414a.notifyAll();
            }
        }

        public final C0414a i(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            return l(str);
        }

        public final C0414a j(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            return l(str);
        }

        public final List<C0414a> k(Parcelable[] parcelableArr) {
            Cursor cursorF;
            if (parcelableArr.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z4 = true;
            for (Parcelable parcelable : parcelableArr) {
                Uri uri = (Uri) parcelable;
                if ("content".equals(uri.getScheme())) {
                    if (z4) {
                        sb.append(uri.getLastPathSegment());
                        z4 = false;
                    } else {
                        sb.append(',');
                        sb.append(uri.getLastPathSegment());
                    }
                }
            }
            if (z4) {
                return null;
            }
            if (sb.length() > 0) {
                StringBuilder sbD = D2.e.d("_id IN (");
                sbD.append(sb.toString());
                sbD.append(")");
                String string = sbD.toString();
                Context context = this.f8036b;
                cursorF = O.f(context, context.getContentResolver(), f8031f, g, string, null, null);
            } else {
                cursorF = null;
            }
            if (cursorF == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursorF.moveToNext()) {
                try {
                    C0414a c0414aO = C0414a.O(cursorF.getString(1));
                    g(c0414aO, cursorF);
                    arrayList.add(c0414aO);
                } finally {
                    cursorF.close();
                }
            }
            return arrayList;
        }

        final void m() throws RemoteException, OperationApplicationException {
            int count;
            int count2;
            ConcurrentHashMap concurrentHashMap;
            C0414a.u0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashSet hashSet = new HashSet();
            Context context = this.f8036b;
            Cursor cursorE = O.e(context, context.getContentResolver(), Uri.withAppendedPath(Telephony.MmsSms.CONTENT_URI, "canonical-addresses"), null, null, null, null);
            if (cursorE != null) {
                int columnIndex = cursorE.getColumnIndex("address");
                try {
                    cursorE.moveToPosition(-1);
                    while (cursorE.moveToNext()) {
                        String string = cursorE.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            Y1.a.d("loadAll: Unexpected empty number in recipient query.", new Object[0]);
                        } else {
                            C0414a c0414aL = l(string);
                            if (!TextUtils.isEmpty(c0414aL.W()) && !c0414aL.f8024m) {
                                hashSet.add(c0414aL);
                            }
                        }
                    }
                } finally {
                    cursorE.close();
                }
            }
            Context context2 = this.f8036b;
            Cursor cursorF = O.f(context2, context2.getContentResolver(), ContactsContract.Data.CONTENT_URI, g, "mimetype='vnd.android.cursor.item/phone_v2'", null, "length(data1)");
            if (cursorF != null) {
                try {
                    count = cursorF.getCount();
                    cursorF.moveToPosition(-1);
                    while (cursorF.moveToNext()) {
                        String string2 = cursorF.getString(1);
                        if (TextUtils.isEmpty(string2)) {
                            Y1.a.d("loadAll: Unexpected empty number in phone query.", new Object[0]);
                        } else {
                            String strN = n(string2);
                            ArrayList<C0414a> arrayList = this.d.get(r(strN));
                            if (arrayList != null) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    C0414a c0414a = arrayList.get(i2);
                                    if (hashSet.contains(c0414a)) {
                                        String strW = c0414a.W();
                                        if (q(strW)) {
                                            if (strW != null && strW.equals(strN)) {
                                                synchronized (c0414a) {
                                                    if (!c0414a.f8024m) {
                                                        c0414a.f8023l = false;
                                                        g(c0414a, cursorF);
                                                    }
                                                }
                                                if (!c0414a.f8024m) {
                                                    d(c0414a);
                                                }
                                                hashSet.remove(c0414a);
                                            }
                                        } else if (p(strW)) {
                                            continue;
                                        } else {
                                            String strN2 = n(strW);
                                            String str = C0414a.f8013z;
                                            if (C0178a.b(strN2, strN)) {
                                                synchronized (c0414a) {
                                                    if (!c0414a.f8024m) {
                                                        c0414a.f8023l = false;
                                                        g(c0414a, cursorF);
                                                    }
                                                }
                                                if (!c0414a.f8024m) {
                                                    d(c0414a);
                                                }
                                                hashSet.remove(c0414a);
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                } finally {
                }
            } else {
                count = 0;
            }
            Context context3 = this.f8036b;
            cursorF = O.f(context3, context3.getContentResolver(), ContactsContract.Data.CONTENT_URI, f8034j, "mimetype='vnd.android.cursor.item/email_v2'", null, null);
            if (cursorF != null) {
                try {
                    count2 = cursorF.getCount();
                    cursorF.moveToPosition(-1);
                    while (cursorF.moveToNext()) {
                        String string3 = cursorF.getString(6);
                        if (TextUtils.isEmpty(string3)) {
                            Y1.a.d("loadAll: Unexpected empty email in email query.", new Object[0]);
                        } else {
                            ArrayList<C0414a> arrayList2 = this.d.get(string3);
                            if (arrayList2 != null) {
                                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                                    C0414a c0414a2 = arrayList2.get(i4);
                                    if (hashSet.contains(c0414a2) && p(c0414a2.W())) {
                                        synchronized (c0414a2) {
                                            if (!c0414a2.f8024m) {
                                                c0414a2.f8023l = false;
                                                f(c0414a2, cursorF);
                                            }
                                        }
                                        if (!c0414a2.f8024m) {
                                            d(c0414a2);
                                        }
                                        hashSet.remove(c0414a2);
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                } finally {
                }
            } else {
                count2 = 0;
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                C0414a c0414a3 = (C0414a) it.next();
                String strW2 = c0414a3.W();
                boolean zQ = q(strW2);
                if ((zQ || !p(strW2)) && (concurrentHashMap = this.f8038e) != null && !concurrentHashMap.containsKey(strW2) && (zQ || c0414a3.j0())) {
                    this.f8038e.put(strW2, new C0384b());
                }
                arrayList3.add(strW2);
            }
            arrayList3.size();
            hashSet.iterator();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                C0414a c0414a4 = (C0414a) it2.next();
                synchronized (c0414a4) {
                    c0414a4.f8023l = false;
                    C0414a.H(c0414a4);
                    d(c0414a4);
                }
            }
            f.f().j();
            Y1.a.c("Contact cache loading time = %d. %d phone contacts, %d email contacts, %d sp contacts and %d cleared", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), Integer.valueOf(count), Integer.valueOf(count2), 0, Integer.valueOf(hashSet.size()));
            this.f8037c.set(2);
        }

        final C0415b o(String str) {
            C0415b c0415b = new C0415b();
            Context context = this.f8036b;
            Cursor cursorF = O.f(context, context.getContentResolver(), ContactsContract.Data.CONTENT_URI, g, "mimetype=? AND (display_name LIKE ? OR data1 LIKE ?)", new String[]{"vnd.android.cursor.item/phone_v2", str, str}, "length(data1)");
            if (cursorF != null) {
                try {
                    cursorF.moveToPosition(-1);
                    while (cursorF.moveToNext()) {
                        String string = cursorF.getString(1);
                        if (TextUtils.isEmpty(string)) {
                            Y1.a.d("loadAll: Unexpected empty number in phone query.", new Object[0]);
                        } else {
                            C0414a c0414aL = l(string);
                            synchronized (c0414aL) {
                                c0414aL.f8023l = false;
                                g(c0414aL, cursorF);
                            }
                            c0415b.add(c0414aL);
                        }
                    }
                } finally {
                    cursorF.close();
                }
            }
            return c0415b;
        }
    }

    /* renamed from: x0.a$c */
    public interface c {
        void t(C0414a c0414a);
    }

    C0414a(String str) {
        h0(str);
    }

    static void H(C0414a c0414a) {
        c0414a.f8014a = -1L;
        c0414a.f8015b = 0;
        c0414a.f8017e = null;
        c0414a.f8022k = 0L;
        c0414a.f8025n = 0L;
        c0414a.p = false;
        c0414a.f8027q = null;
    }

    public static void I(c cVar) {
        WeakHashMap<c, Object> weakHashMap = f8011x;
        synchronized (weakHashMap) {
            weakHashMap.put(cVar, null);
        }
    }

    public static void J(c cVar, String str) {
        WeakHashMap<c, Object> weakHashMap = f8011x;
        synchronized (weakHashMap) {
            weakHashMap.put(cVar, str);
        }
    }

    public static void K() {
        if (f8009v.f8037c.get() != 1) {
            f8009v.f8037c.set(1);
            C0144a c0144a = new C0144a();
            c0144a.setName("AllContactsLoader");
            c0144a.setPriority(1);
            c0144a.start();
        }
    }

    public static String M(String str, String str2) {
        if (str == null) {
            return str2;
        }
        return str + " <" + str2 + ">";
    }

    public static C0414a N(String str) {
        return f8009v.j(str);
    }

    public static C0414a O(String str) {
        return f8009v.i(str);
    }

    public static List<C0414a> P(Parcelable[] parcelableArr) {
        return f8009v.k(parcelableArr);
    }

    public static int T() {
        return f8009v.f8037c.get();
    }

    public static void g0(Context context) {
        Context applicationContext = context.getApplicationContext();
        f8009v = new b(applicationContext);
        f.h(applicationContext);
    }

    private void h0(String str) {
        if (!f8012y) {
            u0();
        }
        this.f8014a = -1L;
        this.f8015b = 0;
        this.f8026o = 0;
        this.f8017e = "";
        this.f8020i = false;
        s0(str);
        this.f8022k = 0L;
        this.f8025n = 0L;
        this.f8023l = true;
        this.p = false;
        this.g = "";
    }

    public static boolean l0(C0414a c0414a) {
        return "com.android.contacts.sim".equals(c0414a.f8027q);
    }

    public static void n0(c cVar) {
        WeakHashMap<c, Object> weakHashMap = f8011x;
        synchronized (weakHashMap) {
            weakHashMap.remove(cVar);
        }
    }

    public static void o0() {
        b bVar = f8009v;
        bVar.d.clear();
        ConcurrentHashMap concurrentHashMap = bVar.f8038e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public static C0415b p0(String str) {
        return f8009v.o(str);
    }

    public static void u0() {
        try {
            f8013z = C0344a.a();
        } catch (NullPointerException unused) {
            f8013z = "00";
        }
        f8012y = true;
    }

    public final boolean L() {
        return this.f8022k > 0;
    }

    public final synchronized String Q() {
        if (TextUtils.isEmpty(this.f8018f)) {
            return U();
        }
        return this.f8018f;
    }

    public final synchronized String R() {
        return this.f8019h;
    }

    public final synchronized Uri S() {
        if (L()) {
            return ContentUris.withAppendedId(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, this.f8014a);
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("mailto");
        builder.encodedOpaquePart(this.f8016c);
        return builder.build();
    }

    public final synchronized String U() {
        if (TextUtils.isEmpty(this.f8017e)) {
            return this.f8016c;
        }
        return this.f8017e;
    }

    public final synchronized String V() {
        return M(this.f8017e, this.f8016c);
    }

    public final String W() {
        return this.f8016c;
    }

    public final String X() {
        return this.d;
    }

    public final Uri Y() {
        return this.f8028r;
    }

    public final long Z() {
        return this.f8022k;
    }

    public final synchronized Uri a0() {
        if (L()) {
            return ContentUris.withAppendedId(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, this.f8014a);
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("tel");
        builder.encodedOpaquePart(this.f8016c);
        return builder.build();
    }

    public final String b0() {
        return this.f8017e;
    }

    public final long c0() {
        return this.f8021j;
    }

    public final boolean d0() {
        return this.p;
    }

    public final String e0() {
        return TextUtils.isEmpty(this.g) ? "" : this.g;
    }

    public final boolean equals(Object obj) {
        try {
            if (obj instanceof C0414a) {
                C0414a c0414a = (C0414a) obj;
                String str = this.f8019h;
                return str == null ? c0414a.f8019h == null : str.equals(c0414a.f8019h);
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public final synchronized Uri f0() {
        return ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, this.f8022k);
    }

    public final int hashCode() {
        return this.f8019h.hashCode();
    }

    public final boolean i0() {
        return this.f8026o == 2;
    }

    public final boolean j0() {
        if (this.f8030t) {
            return !TextUtils.isEmpty(this.f8029s);
        }
        if (f8012y && this.f8026o == 1) {
            return !TextUtils.isEmpty(this.f8029s);
        }
        return false;
    }

    public final boolean k0() {
        return this.f8020i;
    }

    public final C0414a m0(boolean z4, boolean z5) {
        b.a(f8009v, this, z4, z5);
        return this;
    }

    public final synchronized void q0(String str) {
        this.f8018f = str;
    }

    public final void r0() {
        this.f8020i = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034 A[Catch: all -> 0x00b3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:19:0x0034, B:22:0x0048, B:24:0x004e, B:26:0x0060, B:27:0x0065, B:29:0x006b, B:31:0x0073, B:32:0x007a, B:33:0x007d, B:37:0x0095, B:39:0x00a6, B:41:0x00ac, B:42:0x00af, B:36:0x0091, B:25:0x0051, B:38:0x009d, B:11:0x0019, B:13:0x001f, B:16:0x002e), top: B:48:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d A[Catch: all -> 0x00b3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:19:0x0034, B:22:0x0048, B:24:0x004e, B:26:0x0060, B:27:0x0065, B:29:0x006b, B:31:0x0073, B:32:0x007a, B:33:0x007d, B:37:0x0095, B:39:0x00a6, B:41:0x00ac, B:42:0x00af, B:36:0x0091, B:25:0x0051, B:38:0x009d, B:11:0x0019, B:13:0x001f, B:16:0x002e), top: B:48:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac A[Catch: all -> 0x00b3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:19:0x0034, B:22:0x0048, B:24:0x004e, B:26:0x0060, B:27:0x0065, B:29:0x006b, B:31:0x0073, B:32:0x007a, B:33:0x007d, B:37:0x0095, B:39:0x00a6, B:41:0x00ac, B:42:0x00af, B:36:0x0091, B:25:0x0051, B:38:0x009d, B:11:0x0019, B:13:0x001f, B:16:0x002e), top: B:48:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void s0(String str) {
        boolean z4;
        String str2 = this.f8016c;
        if (str2 == null || !str2.equals(str)) {
            this.f8016c = str;
            int i2 = C0292y.f6056e;
            if (!TextUtils.isEmpty(str)) {
                for (int i4 = 0; i4 < str.length(); i4++) {
                    if ("0123456789+. -#*()".indexOf(str.charAt(i4)) != -1) {
                    }
                }
                z4 = true;
                if (z4) {
                    this.f8019h = str;
                    this.f8029s = str;
                    this.f8030t = false;
                    this.u = null;
                } else {
                    this.f8026o = 1;
                    C0338a c0338aI = C0338a.i(str, f8013z);
                    String strE = c0338aI.e();
                    String strG = c0338aI.g();
                    if (strG == null) {
                        strG = "";
                    }
                    String str3 = TextUtils.isEmpty(strG) ? this.f8016c : strG + strE;
                    StringBuilder sb = new StringBuilder();
                    for (int i5 = 0; i5 < str3.length(); i5++) {
                        char cCharAt = str3.charAt(i5);
                        if (cCharAt > ' ') {
                            sb.append(Character.toUpperCase(cCharAt));
                        }
                    }
                    this.f8019h = sb.toString();
                    this.u = c0338aI.d();
                    this.f8029s = TextUtils.isEmpty(str) ? str : c0338aI.f();
                    this.f8030t = true;
                    c0338aI.j();
                }
                if (C0292y.b(str)) {
                    this.f8026o = 2;
                }
                this.f8020i = true;
            }
            z4 = false;
            if (z4) {
            }
            if (C0292y.b(str)) {
            }
            this.f8020i = true;
        }
    }

    public final synchronized void t0(long j2) {
        this.f8021j = j2;
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        String str = this.f8016c;
        if (str == null) {
            str = "null";
        }
        objArr[0] = str;
        String str2 = this.f8017e;
        if (str2 == null) {
            str2 = "null";
        }
        objArr[1] = str2;
        String str3 = this.f8018f;
        objArr[2] = str3 != null ? str3 : "null";
        objArr[3] = Long.valueOf(this.f8022k);
        objArr[4] = Integer.valueOf(hashCode());
        objArr[5] = Long.valueOf(this.f8014a);
        return String.format("{ number=%s, name=%s, cached name = %s, person_id=%d, hash=%d, method_id=%d }", objArr);
    }

    C0414a() {
        h0("Self_Item_Key");
        this.f8026o = 3;
    }
}
