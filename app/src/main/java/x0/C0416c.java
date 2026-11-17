package x0;

import P0.r;
import a.C0178a;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LongSparseArray;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.util.AbstractHandlerC0272d;
import com.android.mmt.util.C0271c;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import t0.C0385a;

/* renamed from: x0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0416c {

    /* renamed from: B, reason: collision with root package name */
    private static ContentValues f8044B;

    /* renamed from: C, reason: collision with root package name */
    private static boolean f8045C;

    /* renamed from: D, reason: collision with root package name */
    private static Thread f8046D;

    /* renamed from: E, reason: collision with root package name */
    private static Thread f8047E;

    /* renamed from: F, reason: collision with root package name */
    private static Thread f8048F;

    /* renamed from: G, reason: collision with root package name */
    private static e f8049G;

    /* renamed from: a, reason: collision with root package name */
    private final Context f8058a;

    /* renamed from: b, reason: collision with root package name */
    private long f8059b;

    /* renamed from: c, reason: collision with root package name */
    private C0415b f8060c;
    private long d;

    /* renamed from: e, reason: collision with root package name */
    private String f8061e;

    /* renamed from: f, reason: collision with root package name */
    private int f8062f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private long f8063h;

    /* renamed from: i, reason: collision with root package name */
    private String f8064i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8065j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8066k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8067l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8068m;

    /* renamed from: n, reason: collision with root package name */
    private Object f8069n;

    /* renamed from: o, reason: collision with root package name */
    private Object f8070o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8071q;

    /* renamed from: r, reason: collision with root package name */
    public static final Uri f8050r = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true").build();

    /* renamed from: s, reason: collision with root package name */
    private static final Uri f8051s = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true").build();

    /* renamed from: t, reason: collision with root package name */
    private static final Uri f8052t = C0385a.b.f7898e;
    private static final Uri u = Uri.parse("content://sms/seen");

    /* renamed from: v, reason: collision with root package name */
    private static final Uri f8053v = Uri.parse("content://mms/seen");

    /* renamed from: w, reason: collision with root package name */
    private static final String[] f8054w = {"_id", "date", "message_count", "recipient_ids", "snippet", "snippet_cs", "read", "error", "has_attachment"};

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f8055x = {"blocked_threads._id", "recipient_ids", "date", "message_count", "snippet", "snippet_cs", "read"};

    /* renamed from: y, reason: collision with root package name */
    private static final String[] f8056y = {"transport_type", "_id", "read", "sub_id"};

    /* renamed from: z, reason: collision with root package name */
    private static final String[] f8057z = {"_id", "read"};

    /* renamed from: A, reason: collision with root package name */
    private static final String[] f8043A = {"count(*)"};

    /* renamed from: x0.c$a */
    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f8072i;

        a(Context context) {
            this.f8072i = context;
        }

        @Override // java.lang.Runnable
        public final void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            com.android.mmt.transaction.d.q();
            C0416c.d(this.f8072i);
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            C0416c.e(this.f8072i);
            if (Thread.currentThread().isInterrupted() || Thread.currentThread().isInterrupted()) {
                return;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sbD = D2.e.d("update all seen: ");
            sbD.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
            sbD.append("ms");
            Log.d("Mms/conv", sbD.toString());
            com.android.mmt.transaction.d.m();
        }
    }

    /* renamed from: x0.c$b */
    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f8073i;

        b(Context context) {
            this.f8073i = context;
        }

        @Override // java.lang.Runnable
        public final void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            com.android.mmt.transaction.d.q();
            ContentResolver contentResolver = this.f8073i.getContentResolver();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Cursor cursorE = O.e(this.f8073i, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, C0416c.f8043A, "seen=0 AND advanced_seen=0", null, null);
            if (cursorE != null) {
                try {
                    int i2 = cursorE.moveToFirst() ? cursorE.getInt(0) : 0;
                    cursorE.close();
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    if (i2 > 0) {
                        ContentValues contentValues = new ContentValues(2);
                        contentValues.put("seen", (Integer) 1);
                        O.g(this.f8073i, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, contentValues, "seen = 0 AND advanced_seen=0", null);
                    }
                    StringBuilder sbC = C2.c.c("count:", i2, ",update notified non-sp sms:");
                    sbC.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    sbC.append("ms");
                    Log.d("Mms/conv", sbC.toString());
                } finally {
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            cursorE = O.e(this.f8073i, contentResolver, Telephony.Mms.Inbox.CONTENT_URI, C0416c.f8043A, "seen=0 AND advanced_seen=0", null, null);
            if (cursorE != null) {
                try {
                    int i4 = cursorE.moveToFirst() ? cursorE.getInt(0) : 0;
                    cursorE.close();
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    if (i4 > 0) {
                        ContentValues contentValues2 = new ContentValues(2);
                        contentValues2.put("seen", (Integer) 1);
                        O.g(this.f8073i, contentResolver, Telephony.Mms.Inbox.CONTENT_URI, contentValues2, "seen=0 AND advanced_seen=0", null);
                    }
                    StringBuilder sbC2 = C2.c.c("count:", i4, ",update notified non-sp mms:");
                    sbC2.append(System.currentTimeMillis() - jCurrentTimeMillis2);
                    sbC2.append("ms");
                    Log.d("Mms/conv", sbC2.toString());
                } finally {
                }
            }
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            cursorE = O.e(this.f8073i, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, C0416c.f8043A, "seen=0 AND advanced_seen=1", null, null);
            if (cursorE != null) {
                try {
                    int i5 = cursorE.moveToFirst() ? cursorE.getInt(0) : 0;
                    if (i5 > 0) {
                        ContentValues contentValues3 = new ContentValues(2);
                        contentValues3.put("seen", (Integer) 1);
                        O.g(this.f8073i, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, contentValues3, "seen=0 AND advanced_seen=1", null);
                    }
                    StringBuilder sbC3 = C2.c.c("count:", i5, ",update notified sp sms:");
                    sbC3.append(System.currentTimeMillis() - jCurrentTimeMillis3);
                    sbC3.append("ms");
                    Log.d("Mms/conv", sbC3.toString());
                } finally {
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            cursorE = O.e(this.f8073i, contentResolver, Telephony.Mms.Inbox.CONTENT_URI, C0416c.f8043A, "seen=0 AND advanced_seen=1", null, null);
            if (cursorE != null) {
                try {
                    int i6 = cursorE.moveToFirst() ? cursorE.getInt(0) : 0;
                    cursorE.close();
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    if (i6 > 0) {
                        ContentValues contentValues4 = new ContentValues(2);
                        contentValues4.put("seen", (Integer) 1);
                        O.g(this.f8073i, contentResolver, Telephony.Mms.Inbox.CONTENT_URI, contentValues4, "seen=0 AND advanced_seen=1", null);
                    }
                    StringBuilder sbC4 = C2.c.c("count:", i6, ",update notified sp mms:");
                    sbC4.append(System.currentTimeMillis() - jCurrentTimeMillis4);
                    sbC4.append("ms");
                    Log.d("Mms/conv", sbC4.toString());
                } finally {
                }
            }
            if (Thread.currentThread().isInterrupted() || Thread.currentThread().isInterrupted() || Thread.currentThread().isInterrupted()) {
                return;
            }
            long jCurrentTimeMillis5 = System.currentTimeMillis();
            com.android.mmt.transaction.d.m();
            Log.d("Mms/conv", "update notified sp update all notification:" + (System.currentTimeMillis() - jCurrentTimeMillis5) + "ms");
        }
    }

    /* renamed from: x0.c$c, reason: collision with other inner class name */
    final class RunnableC0147c implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f8074i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f8075j;

        RunnableC0147c(Context context, int i2) {
            this.f8074i = context;
            this.f8075j = i2;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public final void run() throws SecurityException, IllegalArgumentException {
            int i2;
            String str;
            String str2;
            String str3;
            Process.setThreadPriority(10);
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            com.android.mmt.transaction.d.q();
            ContentResolver contentResolver = this.f8074i.getContentResolver();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Uri uriWithAppendedId = Telephony.Sms.Inbox.CONTENT_URI;
            if (this.f8075j > 1) {
                uriWithAppendedId = ContentUris.withAppendedId(C0416c.u, this.f8075j);
            }
            Uri uri = uriWithAppendedId;
            Cursor cursorE = O.e(this.f8074i, contentResolver, uri, C0416c.f8043A, "(advanced_seen=1 OR advanced_seen=2)", null, null);
            if (cursorE != null) {
                try {
                    int i4 = cursorE.moveToFirst() ? cursorE.getInt(0) : 0;
                    cursorE.close();
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    if (i4 > 0) {
                        ContentValues contentValues = new ContentValues(2);
                        contentValues.put("seen", (Integer) 1);
                        i2 = i4;
                        str = "seen";
                        str2 = "Mms/conv";
                        O.g(this.f8074i, contentResolver, uri, contentValues, "(advanced_seen=1 OR advanced_seen=2)", null);
                    } else {
                        i2 = i4;
                        str = "seen";
                        str2 = "Mms/conv";
                    }
                    StringBuilder sbC = C2.c.c("count:", i2, ",update ad_seen sp sms:");
                    sbC.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    sbC.append("ms");
                    Log.d(str2, sbC.toString());
                } catch (Throwable th) {
                    cursorE.close();
                    throw th;
                }
            } else {
                str = "seen";
                str2 = "Mms/conv";
            }
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Uri uriWithAppendedId2 = Telephony.Mms.Inbox.CONTENT_URI;
            if (this.f8075j > 1) {
                uriWithAppendedId2 = ContentUris.withAppendedId(C0416c.f8053v, this.f8075j);
            }
            Uri uri2 = uriWithAppendedId2;
            String str4 = str2;
            Cursor cursorE2 = O.e(this.f8074i, contentResolver, uri2, C0416c.f8043A, "(advanced_seen=1 OR advanced_seen=2)", null, null);
            if (cursorE2 != null) {
                try {
                    int i5 = cursorE2.moveToFirst() ? cursorE2.getInt(0) : 0;
                    cursorE2.close();
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    if (i5 > 0) {
                        ContentValues contentValues2 = new ContentValues(2);
                        contentValues2.put(str, (Integer) 1);
                        O.g(this.f8074i, contentResolver, uri2, contentValues2, "(advanced_seen=1 OR advanced_seen=2)", null);
                    }
                    StringBuilder sbC2 = C2.c.c("count:", i5, ",update ad_seen sp mms:");
                    sbC2.append(System.currentTimeMillis() - jCurrentTimeMillis2);
                    sbC2.append("ms");
                    str3 = str4;
                    Log.d(str3, sbC2.toString());
                } catch (Throwable th2) {
                    cursorE2.close();
                    throw th2;
                }
            } else {
                str3 = str4;
            }
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            com.android.mmt.transaction.d.m();
            Log.d(str3, "update ad_seen sp update all notification:" + (System.currentTimeMillis() - jCurrentTimeMillis3) + "ms");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0.c$d */
    static class d {

        /* renamed from: c, reason: collision with root package name */
        private static d f8076c = new d();

        /* renamed from: a, reason: collision with root package name */
        private final LongSparseArray<C0416c> f8077a = new LongSparseArray<>(10);

        /* renamed from: b, reason: collision with root package name */
        private final Map<C0415b, C0416c> f8078b = new ArrayMap(10);

        /* renamed from: x0.c$d$a */
        final class a implements Comparator<C0416c> {
            a() {
            }

            @Override // java.util.Comparator
            public final int compare(C0416c c0416c, C0416c c0416c2) {
                return Long.signum(c0416c2.z() - c0416c.z());
            }
        }

        private d() {
        }

        static C0416c a(long j2) {
            C0416c c0416c;
            synchronized (f8076c) {
                c0416c = f8076c.f8077a.get(j2);
            }
            return c0416c;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.util.ArrayMap, java.util.Map<x0.b, x0.c>] */
        static C0416c b(C0415b c0415b) {
            C0416c c0416c;
            synchronized (f8076c) {
                c0416c = (C0416c) f8076c.f8078b.get(c0415b);
            }
            return c0416c;
        }

        public static d c() {
            return f8076c;
        }

        static void d(Set<Long> set) {
            synchronized (f8076c) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < f8076c.f8077a.size(); i2++) {
                    C0416c c0416cValueAt = f8076c.f8077a.valueAt(i2);
                    if (!set.contains(Long.valueOf(c0416cValueAt.I()))) {
                        arrayList.add(Long.valueOf(c0416cValueAt.I()));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f(((Long) it.next()).longValue());
                }
            }
        }

        /* JADX WARN: Type inference failed for: r1v10, types: [android.util.ArrayMap, java.util.Map<x0.b, x0.c>] */
        /* JADX WARN: Type inference failed for: r1v16, types: [android.util.ArrayMap, java.util.Map<x0.b, x0.c>] */
        static void e(C0416c c0416c) {
            synchronized (f8076c) {
                if (c0416c.I() == 0) {
                    throw new IllegalStateException("cannot put a conversation with threadId = 0 into cache");
                }
                if (c0416c.I() < 0) {
                    C0416c c0416c2 = f8076c.f8077a.get(c0416c.I());
                    if (c0416c2 != null && c0416c2 != c0416c) {
                        Y1.a.d("cache already contains conversation for thread %d", Long.valueOf(c0416c.I()));
                    }
                    f8076c.f8077a.put(c0416c.I(), c0416c);
                    c0416c.p = true;
                    return;
                }
                C0416c c0416c3 = f8076c.f8077a.get(c0416c.I());
                if (c0416c3 != null && c0416c3 != c0416c) {
                    Y1.a.d("cache already contains conversation for thread %d", Long.valueOf(c0416c.I()));
                }
                C0416c c0416c4 = (C0416c) f8076c.f8078b.get(c0416c.G());
                if (c0416c4 != null && c0416c4 != c0416c) {
                    Y1.a.d("cache already contains conversation for recipeints %s", c0416c.G());
                }
                f8076c.f8077a.put(c0416c.I(), c0416c);
                f8076c.f8078b.put(c0416c.G(), c0416c);
                c0416c.p = true;
            }
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.util.ArrayMap, java.util.Map<x0.b, x0.c>] */
        static void f(long j2) {
            synchronized (f8076c) {
                C0416c c0416c = f8076c.f8077a.get(j2);
                if (c0416c == null) {
                    Y1.a.c("Failed removing thread %d", Long.valueOf(j2));
                } else {
                    c0416c.p = false;
                    if (f8076c.f8078b.remove(c0416c.G()) == null) {
                        Y1.a.d("Failed removing thread %d from mRecipientsConversationMap", Long.valueOf(j2));
                    }
                    f8076c.f8077a.delete(j2);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.util.ArrayMap, java.util.Map<x0.b, x0.c>] */
        /* JADX WARN: Type inference failed for: r1v6, types: [android.util.ArrayMap, java.util.Map<x0.b, x0.c>] */
        static void g(C0416c c0416c) {
            synchronized (f8076c) {
                if (f8076c.f8078b.remove(c0416c.G()) != null) {
                    f8076c.f8078b.put(c0416c.G(), c0416c);
                }
                f8076c.f8077a.put(c0416c.I(), c0416c);
            }
        }

        static ArrayList<C0416c> h(Context context, String str) {
            String lowerCase = str.toLowerCase();
            ArrayList<C0416c> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            synchronized (f8076c) {
                for (int i2 = 0; i2 < f8076c.f8077a.size(); i2++) {
                    C0416c c0416cValueAt = f8076c.f8077a.valueAt(i2);
                    C0415b c0415bG = c0416cValueAt.G();
                    if (c0415bG.size() == 1) {
                        C0414a c0414a = c0415bG.get(0);
                        if (c0414a.W().toLowerCase().indexOf(lowerCase) != -1 || c0414a.U().toLowerCase().indexOf(lowerCase) != -1) {
                            arrayList2.add(Long.valueOf(c0416cValueAt.I()));
                        }
                    }
                }
            }
            if (arrayList2.size() - 1 >= 0) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sbD = D2.e.d("_id IN ( ");
                sbD.append(TextUtils.join(",", arrayList2));
                sbD.append(")");
                sb.append(sbD.toString());
                Cursor cursorE = O.e(context, context.getContentResolver(), C0416c.f8051s, new String[]{"_id"}, sb.toString(), null, null);
                if (cursorE != null) {
                    try {
                        cursorE.moveToPosition(-1);
                        while (cursorE.moveToNext()) {
                            synchronized (f8076c) {
                                C0416c c0416c = f8076c.f8077a.get(cursorE.getLong(0));
                                if (c0416c != null) {
                                    arrayList.add(c0416c);
                                }
                            }
                        }
                    } finally {
                        cursorE.close();
                    }
                }
            }
            Collections.sort(arrayList, new a());
            return arrayList;
        }
    }

    /* renamed from: x0.c$e */
    private static class e implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private AtomicInteger f8079i = new AtomicInteger(0);

        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0416c.a(MmsApp.c());
            this.f8079i.set(2);
        }
    }

    private C0416c(Context context) {
        this.f8061e = "";
        this.f8069n = new Object();
        this.f8070o = new Object();
        this.p = false;
        this.f8071q = false;
        this.f8058a = context.getApplicationContext();
        this.f8060c = new C0415b();
        this.f8059b = 0L;
    }

    private static long D(Context context, C0415b c0415b) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder("[");
        Iterator<C0414a> it = c0415b.iterator();
        while (it.hasNext()) {
            C0414a c0414aO = C0414a.O(it.next().W());
            if (sb.length() > 1) {
                sb.append(",");
            }
            hashSet.add(c0414aO.W());
            sb.append("(cached)");
        }
        sb.append("]");
        return C0287t.i(context, hashSet);
    }

    public static void N() {
        if (f8049G == null) {
            f8049G = new e();
        }
        if (f8049G.f8079i.get() != 1) {
            f8049G.f8079i.set(1);
            Q2.c.a(f8049G);
        }
    }

    private boolean P(long j2) {
        Cursor cursorE;
        if (this.f8071q) {
            Context context = this.f8058a;
            cursorE = O.e(context, context.getContentResolver(), ContentUris.withAppendedId(f8052t, j2), f8055x, null, null, null);
        } else {
            Context context2 = this.f8058a;
            cursorE = O.e(context2, context2.getContentResolver(), f8050r, f8054w, "_id=" + j2, null, null);
        }
        if (cursorE == null) {
            Y1.a.d("loadFromThreadId: Can't find thread ID %d", Long.valueOf(j2));
            return false;
        }
        try {
            if (!cursorE.moveToFirst()) {
                Y1.a.d("loadFromThreadId: Can't find thread ID %d, no such record", Long.valueOf(j2));
                return false;
            }
            if (this.f8071q) {
                r(this.f8058a, this, cursorE);
            } else {
                s(this.f8058a, this, cursorE);
            }
            if (j2 != this.f8059b) {
                Y1.a.d("loadFromThreadId: fillFromCursor returned different thread_id! threadId=" + j2 + ", mThreadId=" + this.f8059b, new Object[0]);
            }
            return true;
        } finally {
            cursorE.close();
        }
    }

    private static void R(Context context, HashSet<Long> hashSet, Uri uri, String str) {
        C0416c c0416cA;
        Cursor cursorE = null;
        try {
            cursorE = O.e(context, context.getContentResolver(), uri, f8054w, str, null, "date DESC");
            if (cursorE != null) {
                while (cursorE.moveToNext()) {
                    long j2 = cursorE.getLong(cursorE.getColumnIndexOrThrow("_id"));
                    hashSet.add(Long.valueOf(j2));
                    synchronized (d.c()) {
                        c0416cA = d.a(j2);
                    }
                    if (c0416cA == null) {
                        C0416c c0416c = new C0416c(context, cursorE);
                        try {
                            synchronized (d.c()) {
                                d.e(c0416c);
                            }
                        } catch (IllegalStateException unused) {
                            Y1.a.d("Tried to add duplicate Conversation to Cache", new Object[0]);
                        }
                    } else {
                        s(context, c0416cA, cursorE);
                    }
                }
            }
        } finally {
            if (cursorE != null) {
                cursorE.close();
            }
        }
    }

    public static void S(Context context) {
        Thread thread = f8047E;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = new Thread(new a(context));
        f8047E = thread2;
        thread2.start();
    }

    public static void U(Context context) {
        Thread thread = f8046D;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = new Thread(new b(context));
        f8046D = thread2;
        thread2.start();
    }

    public static void V(Context context, int i2) {
        if (i2 <= 0) {
            return;
        }
        Thread thread = f8048F;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = new Thread(new RunnableC0147c(context, i2));
        f8048F = thread2;
        thread2.start();
    }

    public static ArrayList<C0416c> X(Context context, String str) {
        return d.h(context, str);
    }

    private static void Y(Context context, long j2) {
        String str = "m_type = 132 AND read = 0 AND rr = 128";
        if (j2 != -1) {
            str = "m_type = 132 AND read = 0 AND rr = 128 AND thread_id = " + j2;
        }
        Cursor cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.Inbox.CONTENT_URI, new String[]{"_id", "m_id", "sub_id"}, str, null, null);
        if (cursorE != null) {
            try {
                if (cursorE.getCount() != 0) {
                    while (cursorE.moveToNext()) {
                        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, cursorE.getLong(0));
                        Y1.a.c("sendMmsReadReport: uri = " + uriWithAppendedId, new Object[0]);
                        O0.e.b(context, C0271c.a(context, uriWithAppendedId), cursorE.getString(1), 128, cursorE.getLong(2));
                    }
                    return;
                }
            } finally {
                cursorE.close();
            }
        }
        if (cursorE != null) {
        }
    }

    static void a(Context context) {
        if (Log.isLoggable("Mms:threadcache", 2)) {
            Y1.a.c("cacheAllThreads: begin", new Object[0]);
        }
        synchronized (d.c()) {
            if (f8045C) {
                return;
            }
            f8045C = true;
            HashSet hashSet = new HashSet();
            Uri uri = f8050r;
            R(context, hashSet, uri, null);
            R(context, hashSet, uri.buildUpon().appendQueryParameter("caller_is_syncadapter", "1").build(), "message_count=0");
            synchronized (d.c()) {
                f8045C = false;
            }
            d.d(hashSet);
        }
    }

    static void d(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorE = O.e(context, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, f8043A, "seen=0", null, null);
        if (cursorE != null) {
            try {
                i = cursorE.moveToFirst() ? cursorE.getInt(0) : 0;
            } finally {
                cursorE.close();
            }
        }
        if (i == 0 || Thread.currentThread().isInterrupted()) {
            return;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("seen", (Integer) 1);
        O.g(context, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, contentValues, "seen=0", null);
    }

    static void e(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorE = O.e(context, contentResolver, Telephony.Mms.Inbox.CONTENT_URI, f8043A, "seen=0", null, null);
        if (cursorE != null) {
            try {
                i = cursorE.moveToFirst() ? cursorE.getInt(0) : 0;
            } finally {
                cursorE.close();
            }
        }
        if (i == 0 || Thread.currentThread().isInterrupted()) {
            return;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("seen", (Integer) 1);
        O.g(context, contentResolver, Telephony.Mms.Inbox.CONTENT_URI, contentValues, "seen=0", null);
    }

    public static void e0(AbstractHandlerC0272d abstractHandlerC0272d, boolean z4, int i2) {
        abstractHandlerC0272d.a(1701);
        Uri.Builder builderBuildUpon = f8051s.buildUpon();
        if (z4) {
            builderBuildUpon.appendQueryParameter("threads_list_type", String.valueOf(0));
        }
        if (i2 != 0) {
            builderBuildUpon.appendQueryParameter("placeholder", String.valueOf(i2));
        }
        abstractHandlerC0272d.f(1701, null, builderBuildUpon.build(), f8054w, null, "date DESC");
    }

    public static void f0(AbstractHandlerC0272d abstractHandlerC0272d) {
        abstractHandlerC0272d.a(1701);
        abstractHandlerC0272d.f(1701, null, f8051s.buildUpon().appendQueryParameter("threads_list_type", String.valueOf(1)).build(), f8054w, null, "date DESC");
    }

    public static void g0(AbstractHandlerC0272d abstractHandlerC0272d) {
        abstractHandlerC0272d.a(1903);
        abstractHandlerC0272d.f(1903, -1L, Telephony.MmsSms.CONTENT_LOCKED_URI, null, null, " date DESC");
    }

    public static void h0(AbstractHandlerC0272d abstractHandlerC0272d, Collection collection) {
        abstractHandlerC0272d.a(1802);
        abstractHandlerC0272d.f(1802, collection, Telephony.MmsSms.CONTENT_LOCKED_URI, null, "thread_id IN (" + TextUtils.join(",", collection) + ")", null);
    }

    private static void i() {
        if (f8044B == null) {
            ContentValues contentValues = new ContentValues(2);
            f8044B = contentValues;
            contentValues.put("read", (Integer) 1);
            f8044B.put("seen", (Integer) 1);
        }
    }

    public static boolean j(Uri uri) {
        String scheme = uri.getScheme();
        return "content".equals(scheme) || "file".equals(scheme);
    }

    public static void j0(C0416c c0416c, C0415b c0415b) {
        if (c0416c == null) {
            return;
        }
        if (!c0416c.p) {
            c0416c.d0(c0415b);
            return;
        }
        d.f(c0416c.f8059b);
        c0416c.f8060c = c0415b;
        d.e(c0416c);
    }

    public static String k0(Context context, long j2, String str) throws NumberFormatException {
        if (j2 <= 0) {
            return str;
        }
        Cursor cursorE = O.e(context, context.getContentResolver(), f8050r, f8054w, "_id=" + j2, null, null);
        if (cursorE == null) {
            Y1.a.d("verifySingleRecipient threadId: " + j2 + " resulted in NULL cursor", new Object[0]);
            return str;
        }
        try {
            if (!cursorE.moveToFirst()) {
                Y1.a.d("verifySingleRecipient threadId: " + j2 + " can't moveToFirst", new Object[0]);
                return str;
            }
            String string = cursorE.getString(cursorE.getColumnIndexOrThrow("recipient_ids"));
            cursorE.close();
            String[] strArrSplit = string.split(" ");
            if (strArrSplit.length != 1) {
                return str;
            }
            String strG = f.g(context, strArrSplit[0]);
            if (TextUtils.isEmpty(strG) || C0178a.b(str, strG)) {
                return str;
            }
            if (context instanceof Activity) {
                Y1.a.m("verifySingleRecipient for threadId: " + j2);
            }
            if (Log.isLoggable("Mms:threadcache", 2)) {
                Y1.a.c("verifySingleRecipient for threadId: " + j2, new Object[0]);
            }
            return strG;
        } finally {
            cursorE.close();
        }
    }

    public static void l() {
        synchronized (d.c()) {
            d.d(new HashSet());
            f8045C = false;
        }
    }

    public static C0416c m(Context context) {
        return new C0416c(context);
    }

    public static C0416c n(Context context, long j2) {
        return new C0416c(context, j2);
    }

    public static C0416c o(Context context, Uri uri) {
        if (uri.getPathSegments().size() >= 2) {
            try {
                return new C0416c(context, Long.parseLong(uri.getPathSegments().get(1)));
            } catch (NumberFormatException unused) {
                Y1.a.d("Invalid URI: %s", uri);
            }
        }
        if (j(uri)) {
            return new C0416c(context);
        }
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int iIndexOf = schemeSpecificPart.indexOf(63);
        if (iIndexOf != -1) {
            schemeSpecificPart = schemeSpecificPart.substring(0, iIndexOf);
        }
        return p(context, C0415b.l(schemeSpecificPart, true));
    }

    public static C0416c p(Context context, C0415b c0415b) {
        if (c0415b.size() < 1) {
            return new C0416c(context);
        }
        C0416c c0416c = new C0416c(context, D(context, c0415b));
        if (c0416c.f8059b == 0) {
            c0416c.d0(c0415b);
        }
        return c0416c;
    }

    private static void r(Context context, C0416c c0416c, Cursor cursor) {
        synchronized (c0416c) {
            c0416c.f8071q = true;
            c0416c.f8059b = cursor.getLong(0);
            c0416c.d = cursor.getLong(2);
            c0416c.f8061e = "";
            c0416c.f8062f = cursor.getInt(3);
            c0416c.f8064i = t(context, r.d(cursor, 5, 6));
        }
        C0415b c0415bI = C0415b.i(cursor.getString(1));
        synchronized (c0416c) {
            if (c0416c.p && !c0415bI.equals(c0416c.f8060c)) {
                throw new IllegalStateException(String.format("Unexpected recipient change in conversation %d", Long.valueOf(c0416c.f8059b)));
            }
            c0416c.f8060c = c0415bI;
        }
    }

    private static void s(Context context, C0416c c0416c, Cursor cursor) {
        synchronized (c0416c) {
            c0416c.f8059b = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            c0416c.d = cursor.getLong(cursor.getColumnIndexOrThrow("date"));
            c0416c.f8061e = "";
            c0416c.f8062f = cursor.getInt(cursor.getColumnIndexOrThrow("message_count"));
            c0416c.f8064i = t(context, r.d(cursor, cursor.getColumnIndexOrThrow("snippet"), cursor.getColumnIndexOrThrow("snippet_cs")));
            c0416c.f8066k = cursor.getInt(cursor.getColumnIndexOrThrow("error")) != 0;
            c0416c.f8065j = cursor.getInt(cursor.getColumnIndexOrThrow("has_attachment")) != 0;
        }
        C0415b c0415bI = C0415b.i(cursor.getString(cursor.getColumnIndexOrThrow("recipient_ids")));
        synchronized (c0416c) {
            if (!c0416c.p || c0415bI.equals(c0416c.f8060c)) {
                c0416c.f8060c = c0415bI;
            } else {
                Y1.a.c("Unexpected recipient change in conversation %d from %s to %s", Long.valueOf(c0416c.f8059b), c0416c.f8060c, c0415bI);
                d.f(c0416c.f8059b);
                c0416c.f8060c = c0415bI;
                d.e(c0416c);
            }
        }
    }

    public static String t(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return context.getString(R.string.no_subject_view);
        }
        String strTrim = str.trim();
        return "[audio]".equals(strTrim) ? context.getString(R.string.snippet_audio) : "[picture]".equals(strTrim) ? context.getString(R.string.snippet_picture) : strTrim.startsWith("[timed]") ? strTrim.replace("[timed]", context.getString(R.string.snippet_timed)) : strTrim;
    }

    public static C0416c u(Context context, Cursor cursor) {
        C0416c c0416cA;
        long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        if (j2 > 0 && (c0416cA = d.a(j2)) != null) {
            s(context, c0416cA, cursor);
            return c0416cA;
        }
        C0416c c0416c = new C0416c(context, cursor);
        try {
            d.e(c0416c);
        } catch (IllegalStateException unused) {
            Y1.a.d("Tried to add duplicate Conversation to Cache", new Object[0]);
        }
        return c0416c;
    }

    public static C0416c v(long j2) {
        C0416c c0416cA = d.a(j2);
        if (c0416cA == null) {
            c0416cA = new C0416c(MmsApp.c(), j2);
            try {
                d.e(c0416cA);
            } catch (IllegalStateException unused) {
                Y1.a.d("Tried to add duplicate Conversation to Cache", new Object[0]);
                d.g(c0416cA);
            }
        } else if (c0416cA.f8062f == 0) {
            Y1.a.c("cached conversation has no messages, update: %d", Long.valueOf(j2));
            c0416cA.i0();
        }
        return c0416cA;
    }

    public static C0416c w(Uri uri) {
        if (uri.getPathSegments().size() >= 2) {
            try {
                return v(Long.parseLong(uri.getPathSegments().get(1)));
            } catch (NumberFormatException unused) {
                Y1.a.d("Invalid URI: %s", uri);
            }
        }
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int iIndexOf = schemeSpecificPart.indexOf(63);
        if (iIndexOf != -1) {
            schemeSpecificPart = schemeSpecificPart.substring(0, iIndexOf);
        }
        return x(C0415b.l(schemeSpecificPart, true));
    }

    public static C0416c x(C0415b c0415b) {
        if (c0415b.size() < 1) {
            return new C0416c(MmsApp.c());
        }
        C0416c c0416cB = d.b(c0415b);
        if (c0416cB != null) {
            if (c0416cB.f8062f != 0) {
                return c0416cB;
            }
            Y1.a.c("cached conversation has no messages, update", new Object[0]);
            c0416cB.i0();
            return c0416cB;
        }
        long jD = D(MmsApp.c(), c0415b);
        C0416c c0416c = new C0416c(MmsApp.c(), jD);
        if (c0416c.f8059b == 0) {
            c0416c.d0(c0415b);
            return c0416c;
        }
        if (!c0416c.f8060c.equals(c0415b)) {
            Y1.a.d(String.format("Conversation.get: new conv %d 's recipients %s don't match input recpients %s", Long.valueOf(jD), c0416c.f8060c, c0415b), new Object[0]);
        }
        try {
            d.e(c0416c);
            return c0416c;
        } catch (IllegalStateException unused) {
            Y1.a.d("Tried to add duplicate Conversation to Cache", new Object[0]);
            return c0416c;
        }
    }

    public final String A() {
        if (TextUtils.isEmpty(this.f8061e)) {
            this.f8061e = C3.c.c(this.f8058a, this.d);
        }
        return this.f8061e;
    }

    public final ContentProviderOperation B() {
        Uri uriJ = J();
        if (uriJ != null) {
            i();
        }
        return ContentProviderOperation.newUpdate(uriJ).withValues(f8044B).withSelection("(read=0 OR seen=0)", null).build();
    }

    public final int C() {
        return this.f8062f;
    }

    public final long E() {
        long j2;
        synchronized (this.f8070o) {
            j2 = this.f8063h;
        }
        return j2;
    }

    public final boolean F() {
        return this.g;
    }

    public final C0415b G() {
        return this.f8060c;
    }

    public final String H() {
        return this.f8064i;
    }

    public final long I() {
        return this.f8059b;
    }

    public final synchronized Uri J() {
        long j2 = this.f8059b;
        if (j2 <= 0) {
            return null;
        }
        return ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, j2);
    }

    public final boolean K() {
        return this.f8065j;
    }

    public final synchronized boolean L() {
        if (this.f8059b <= 0) {
            return false;
        }
        L0.a aVarT = BugleDatabase.y().x().t(this.f8059b);
        if (aVarT != null) {
            this.f8067l = aVarT.p();
        }
        return this.f8067l;
    }

    public final boolean M() {
        return this.f8066k;
    }

    public final boolean O() {
        return this.f8068m;
    }

    public final void Q(boolean z4, boolean z5) {
        this.f8060c.o(z4, z5);
    }

    public final void T() {
        boolean z4;
        synchronized (this.f8069n) {
            Uri uriJ = J();
            if (uriJ != null) {
                i();
                Context context = this.f8058a;
                Cursor cursorE = O.e(context, context.getContentResolver(), uriJ, f8056y, "(read=0 OR seen=0)", null, null);
                if (cursorE != null) {
                    try {
                        boolean z5 = cursorE.getCount() > 0;
                        cursorE.close();
                        z4 = z5;
                    } catch (Throwable th) {
                        cursorE.close();
                        throw th;
                    }
                } else {
                    z4 = true;
                }
                if (z4) {
                    Y(this.f8058a, this.f8059b);
                    Y1.a.c("markAsRead: update read/seen for thread uri: %s", uriJ);
                    Context context2 = this.f8058a;
                    O.g(context2, context2.getContentResolver(), uriJ, f8044B, "(read=0 OR seen=0)", null);
                    BugleDatabase.y().x().s(new ArrayList(Arrays.asList(Long.valueOf(this.f8059b))));
                }
                W(z4);
            }
        }
    }

    public final void W(boolean z4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            synchronized (this.f8070o) {
                this.f8063h = jCurrentTimeMillis;
            }
        }
        if (z4) {
            long j2 = this.f8059b;
            if (j2 > 0) {
                com.android.mmt.transaction.d.s(j2);
            }
        }
    }

    public final synchronized void Z(boolean z4) {
        if (this.f8059b <= 0) {
            return;
        }
        this.f8067l = z4;
    }

    public final synchronized void a0(boolean z4) {
        this.f8068m = z4;
    }

    public final synchronized void b0() {
        synchronized (this.f8070o) {
            this.f8063h = 0L;
        }
    }

    public final void c0(boolean z4) {
        this.g = z4;
    }

    public final synchronized void d0(C0415b c0415b) {
        if (this.p && !this.f8067l) {
            throw new IllegalStateException(String.format("Unexpected recipient change in cached conversation %d", Long.valueOf(this.f8059b)));
        }
        this.f8060c = c0415b;
        this.f8059b = 0L;
    }

    public final synchronized boolean equals(Object obj) {
        try {
        } catch (ClassCastException unused) {
            return false;
        }
        return this.f8060c.equals(((C0416c) obj).f8060c);
    }

    public final synchronized int hashCode() {
        return this.f8060c.hashCode();
    }

    public final void i0() {
        long j2 = this.f8059b;
        if (j2 <= 0) {
            return;
        }
        P(j2);
    }

    public final synchronized void k() {
        d.f(this.f8059b);
        this.f8059b = 0L;
    }

    public final synchronized long q() {
        if (this.f8059b <= 0 || this.f8062f == 0) {
            this.f8059b = D(this.f8058a, this.f8060c);
        }
        return this.f8059b;
    }

    public final synchronized String toString() {
        return String.format("%s (tid %d)", this.f8060c.toString(), Long.valueOf(this.f8059b));
    }

    public final String y() {
        StringBuilder sb = new StringBuilder();
        Iterator<C0414a> it = this.f8060c.iterator();
        while (it.hasNext()) {
            C0414a next = it.next();
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(next.U());
        }
        return sb.toString();
    }

    public final long z() {
        return this.d;
    }

    private C0416c(Context context, long j2) {
        this.f8061e = "";
        this.f8069n = new Object();
        this.f8070o = new Object();
        this.p = false;
        this.f8071q = false;
        this.f8058a = context.getApplicationContext();
        if (P(j2)) {
            return;
        }
        this.f8060c = new C0415b();
        this.f8059b = 0L;
    }

    private C0416c(Context context, Cursor cursor) {
        this.f8061e = "";
        this.f8069n = new Object();
        this.f8070o = new Object();
        this.p = false;
        this.f8071q = false;
        this.f8058a = context.getApplicationContext();
        s(context, this, cursor);
    }
}
