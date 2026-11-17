package com.android.mmt.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class L {

    /* renamed from: a, reason: collision with root package name */
    private static b f5906a;

    /* renamed from: b, reason: collision with root package name */
    private static a f5907b;

    public static class a extends L {

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f5908c = {"_id", "thread_id", "date"};

        private void g(Context context, long j2, long j4) {
            Log.v("Recycler", "MMS: deleteMessagesOlderThanDate cntDeleted: " + O.c(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, "thread_id=" + j2 + " AND locked=0 AND date<" + j4, null));
        }

        @Override // com.android.mmt.util.L
        protected final void a(Context context, long j2, int i2) {
            Log.v("Recycler", "MMS: deleteMessagesForThread");
            if (j2 == 0) {
                return;
            }
            Cursor cursor = null;
            try {
                Cursor cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, f5908c, "thread_id=" + j2 + " AND locked=0", null, "date DESC");
                if (cursorE == null) {
                    Log.e("Recycler", "MMS: deleteMessagesForThread got back null cursor");
                    if (cursorE != null) {
                        cursorE.close();
                        return;
                    }
                    return;
                }
                int count = cursorE.getCount();
                int i4 = count - i2;
                Log.v("Recycler", "MMS: deleteMessagesForThread keep: " + i2 + " count: " + count + " numberToDelete: " + i4);
                if (i4 <= 0) {
                    cursorE.close();
                    return;
                }
                cursorE.move(i2);
                long j4 = cursorE.getLong(2);
                cursorE.close();
                g(context, j2, j4);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // com.android.mmt.util.L
        public final int c(Context context) {
            return androidx.preference.g.c(context).getInt("MaxMmsMessagesPerThread", k0.d.d());
        }

        public final void h(Context context, Uri uri) {
            Log.v("Recycler", "MMS: deleteOldMessagesByUri");
            if (L.f(context)) {
                Cursor cursor = null;
                try {
                    String lastPathSegment = uri.getLastPathSegment();
                    Cursor cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.CONTENT_URI, f5908c, "thread_id in (select thread_id from pdu where _id=" + lastPathSegment + ") AND locked=0", null, "date DESC");
                    if (cursorE == null) {
                        Log.e("Recycler", "MMS: deleteOldMessagesInSameThreadAsMessage got back null cursor");
                        if (cursorE != null) {
                            cursorE.close();
                            return;
                        }
                        return;
                    }
                    int count = cursorE.getCount();
                    int i2 = androidx.preference.g.c(context).getInt("MaxMmsMessagesPerThread", k0.d.d());
                    int i4 = count - i2;
                    Log.v("Recycler", "MMS: deleteOldMessagesByUri keep: " + i2 + " count: " + count + " numberToDelete: " + i4);
                    if (i4 <= 0) {
                        cursorE.close();
                        return;
                    }
                    cursorE.move(i2);
                    long j2 = cursorE.getLong(2);
                    long j4 = cursorE.getLong(1);
                    cursorE.close();
                    if (j4 != 0) {
                        g(context, j4, j2);
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
    }

    public static class b extends L {

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f5909c = {"_id", "thread_id", "address", "body", "date", "read", "type", "status"};

        @Override // com.android.mmt.util.L
        protected final void a(Context context, long j2, int i2) throws Throwable {
            Log.v("Recycler", "SMS: deleteMessagesForThread");
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursor = null;
            try {
                Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, j2);
                Log.v("Recycler", "SMS: threadUri keep: " + uriWithAppendedId);
                Cursor cursorE = O.e(context, contentResolver, uriWithAppendedId, f5909c, "locked=0", null, "date DESC");
                try {
                    if (cursorE == null) {
                        Log.e("Recycler", "SMS: deleteMessagesForThread got back null cursor");
                        if (cursorE != null) {
                            cursorE.close();
                            return;
                        }
                        return;
                    }
                    int count = cursorE.getCount();
                    int i4 = count - i2;
                    Log.v("Recycler", "SMS: deleteMessagesForThread keep: " + i2 + " count: " + count + " numberToDelete: " + i4);
                    if (i4 <= 0) {
                        cursorE.close();
                        return;
                    }
                    cursorE.move(i2);
                    long j4 = cursorE.getLong(4);
                    Log.v("Recycler", "SMS: deleteMessagesForThread cntDeleted: " + O.c(context, contentResolver, ContentUris.withAppendedId(Telephony.Sms.Conversations.CONTENT_URI, j2), "locked=0 AND date<" + j4, null));
                    cursorE.close();
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorE;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.android.mmt.util.L
        public final int c(Context context) {
            return androidx.preference.g.c(context).getInt("MaxSmsMessagesPerThread", k0.d.e());
        }
    }

    public static synchronized a d() {
        if (f5907b == null) {
            f5907b = new a();
        }
        return f5907b;
    }

    public static synchronized b e() {
        if (f5906a == null) {
            f5906a = new b();
        }
        return f5906a;
    }

    public static boolean f(Context context) {
        if (C0275g.d() || C0275g.b()) {
            return androidx.preference.g.c(context).getBoolean("pref_key_auto_delete", C0288u.e() ? C0288u.a() : false);
        }
        return false;
    }

    protected abstract void a(Context context, long j2, int i2);

    public final void b(Context context, long j2) {
        Log.v("Recycler", "Recycler.deleteOldMessagesByThreadId this: " + this + " threadId: " + j2);
        if (f(context)) {
            a(context, j2, c(context));
        }
    }

    public abstract int c(Context context);
}
