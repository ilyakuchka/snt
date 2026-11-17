package g0;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import f0.C0302a;
import f0.C0303b;
import h0.C0331b;
import i0.C0334a;
import j0.C0336a;
import j0.C0337b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import q.C0365a;
import t.C0384b;

/* renamed from: g0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0319o {

    /* renamed from: c, reason: collision with root package name */
    private static C0319o f6284c;
    private static final h0.c d;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f6285e = {129, 130, 137, 151};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f6286f = {"_id", "msg_box", "thread_id", "retr_txt", "sub", "ct_l", "ct_t", "m_cls", "m_id", "resp_txt", "tr_id", "ct_cls", "d_rpt", "m_type", "v", "pri", "rr", "read_status", "rpt_a", "retr_st", "st", "date", "d_tm", "exp", "m_size", "sub_cs", "retr_txt_cs", "read", "seen"};
    private static final String[] g = {"_id", "chset", "cd", "cid", "cl", "ct", "fn", "name", "text"};

    /* renamed from: h, reason: collision with root package name */
    private static final q.g<Uri, Integer> f6287h;

    /* renamed from: i, reason: collision with root package name */
    private static final SparseIntArray f6288i;

    /* renamed from: j, reason: collision with root package name */
    private static final SparseIntArray f6289j;

    /* renamed from: k, reason: collision with root package name */
    private static final SparseIntArray f6290k;

    /* renamed from: l, reason: collision with root package name */
    private static final SparseIntArray f6291l;

    /* renamed from: m, reason: collision with root package name */
    private static final SparseIntArray f6292m;

    /* renamed from: n, reason: collision with root package name */
    private static final SparseArray<String> f6293n;

    /* renamed from: o, reason: collision with root package name */
    private static final SparseArray<String> f6294o;
    private static final SparseArray<String> p;

    /* renamed from: q, reason: collision with root package name */
    private static final SparseArray<String> f6295q;

    /* renamed from: r, reason: collision with root package name */
    private static final SparseArray<String> f6296r;

    /* renamed from: a, reason: collision with root package name */
    private final Context f6297a;

    /* renamed from: b, reason: collision with root package name */
    private final ContentResolver f6298b;

    static {
        q.g<Uri, Integer> gVar = new q.g<>();
        f6287h = gVar;
        gVar.put(Telephony.Mms.Inbox.CONTENT_URI, 1);
        gVar.put(Telephony.Mms.Sent.CONTENT_URI, 2);
        gVar.put(Telephony.Mms.Draft.CONTENT_URI, 3);
        gVar.put(Telephony.Mms.Outbox.CONTENT_URI, 4);
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6288i = sparseIntArray;
        sparseIntArray.put(150, 25);
        sparseIntArray.put(154, 26);
        SparseArray<String> sparseArray = new SparseArray<>();
        f6293n = sparseArray;
        sparseArray.put(150, "sub_cs");
        sparseArray.put(154, "retr_txt_cs");
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f6289j = sparseIntArray2;
        sparseIntArray2.put(154, 3);
        sparseIntArray2.put(150, 4);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        f6294o = sparseArray2;
        sparseArray2.put(154, "retr_txt");
        sparseArray2.put(150, "sub");
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        f6290k = sparseIntArray3;
        sparseIntArray3.put(131, 5);
        sparseIntArray3.put(132, 6);
        sparseIntArray3.put(138, 7);
        sparseIntArray3.put(139, 8);
        sparseIntArray3.put(147, 9);
        sparseIntArray3.put(152, 10);
        SparseArray<String> sparseArray3 = new SparseArray<>();
        p = sparseArray3;
        sparseArray3.put(131, "ct_l");
        sparseArray3.put(132, "ct_t");
        sparseArray3.put(138, "m_cls");
        sparseArray3.put(139, "m_id");
        sparseArray3.put(147, "resp_txt");
        sparseArray3.put(152, "tr_id");
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        f6291l = sparseIntArray4;
        sparseIntArray4.put(186, 11);
        sparseIntArray4.put(134, 12);
        sparseIntArray4.put(140, 13);
        sparseIntArray4.put(141, 14);
        sparseIntArray4.put(143, 15);
        sparseIntArray4.put(144, 16);
        sparseIntArray4.put(155, 17);
        sparseIntArray4.put(145, 18);
        sparseIntArray4.put(153, 19);
        sparseIntArray4.put(149, 20);
        SparseArray<String> sparseArray4 = new SparseArray<>();
        f6295q = sparseArray4;
        sparseArray4.put(186, "ct_cls");
        sparseArray4.put(134, "d_rpt");
        sparseArray4.put(140, "m_type");
        sparseArray4.put(141, "v");
        sparseArray4.put(143, "pri");
        sparseArray4.put(144, "rr");
        sparseArray4.put(155, "read_status");
        sparseArray4.put(145, "rpt_a");
        sparseArray4.put(153, "retr_st");
        sparseArray4.put(149, "st");
        SparseIntArray sparseIntArray5 = new SparseIntArray();
        f6292m = sparseIntArray5;
        sparseIntArray5.put(133, 21);
        sparseIntArray5.put(135, 22);
        sparseIntArray5.put(136, 23);
        sparseIntArray5.put(142, 24);
        SparseArray<String> sparseArray5 = new SparseArray<>();
        f6296r = sparseArray5;
        sparseArray5.put(133, "date");
        sparseArray5.put(135, "d_tm");
        sparseArray5.put(136, "exp");
        sparseArray5.put(142, "m_size");
        d = h0.c.e();
    }

    private C0319o(Context context) {
        this.f6297a = context;
        this.f6298b = context.getContentResolver();
    }

    public static String a(Context context, Uri uri) {
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals("") || scheme.equals("file")) {
            return uri.getPath();
        }
        if (scheme.equals("http")) {
            return uri.toString();
        }
        if (!scheme.equals("content")) {
            throw new IllegalArgumentException("Given Uri scheme is not supported");
        }
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursorQuery == null || cursorQuery.getCount() == 0 || !cursorQuery.moveToFirst()) {
                    throw new IllegalArgumentException("Given Uri could not be found in media store");
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                cursorQuery.close();
                return string;
            } catch (SQLiteException unused) {
                throw new IllegalArgumentException("Given Uri is not formatted in a way so that it can be found in media store.");
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private C0310f b(int i2, C0316l c0316l, C0313i c0313i) throws C0303b {
        switch (i2) {
            case 128:
                return new t(c0316l, c0313i);
            case 129:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
                StringBuilder sbD = D2.e.d("Unsupported PDU type: ");
                sbD.append(Integer.toHexString(i2));
                throw new C0303b(sbD.toString());
            case 130:
                return new C0312h(c0316l);
            case 131:
                return new C0305a(c0316l, 1);
            case 132:
                return new C0322r(c0316l, c0313i);
            case 133:
                return new C0305a(c0316l, 0);
            case 134:
                return new C0308d(c0316l);
            case 135:
                return new C0321q(c0316l);
            case 136:
                return new C0320p(c0316l);
            default:
                StringBuilder sbD2 = D2.e.d("Unrecognized PDU type: ");
                sbD2.append(Integer.toHexString(i2));
                throw new C0303b(sbD2.toString());
        }
    }

    private byte[] c(Cursor cursor, int i2) {
        if (cursor.isNull(i2)) {
            return null;
        }
        return d(cursor.getString(i2));
    }

    public static byte[] d(String str) {
        try {
            return str.getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException e2) {
            Log.e("PduPersister", "ISO_8859_1 must be supported!", e2);
            return new byte[0];
        }
    }

    public static C0319o e(Context context) {
        C0319o c0319o = f6284c;
        if (c0319o == null || !context.equals(c0319o.f6297a)) {
            f6284c = new C0319o(context);
        }
        return f6284c;
    }

    private static void g(C0318n c0318n, ContentValues contentValues) {
        byte[] bArrJ = c0318n.j();
        if (bArrJ != null) {
            contentValues.put("fn", new String(bArrJ));
        }
        byte[] bArrK = c0318n.k();
        if (bArrK != null) {
            contentValues.put("name", new String(bArrK));
        }
        byte[] bArrC = c0318n.c();
        if (bArrC != null) {
            contentValues.put("cd", r(bArrC));
        }
        byte[] bArrD = c0318n.d();
        if (bArrD != null) {
            contentValues.put("cid", r(bArrD));
        }
        byte[] bArrE = c0318n.e();
        if (bArrE != null) {
            contentValues.put("cl", r(bArrE));
        }
    }

    private void i(long j2, C0316l c0316l) {
        Cursor cursorR = C0384b.r(this.f6298b, Uri.parse("content://mms/" + j2 + "/addr"), new String[]{"address", "charset", "type"}, null, null, null);
        if (cursorR != null) {
            while (cursorR.moveToNext()) {
                try {
                    String string = cursorR.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        int i2 = cursorR.getInt(2);
                        if (i2 != 129 && i2 != 130) {
                            if (i2 == 137) {
                                c0316l.h(new C0309e(cursorR.getInt(1), d(string)), i2);
                            } else if (i2 != 151) {
                                Log.e("PduPersister", "Unknown address type: " + i2);
                            }
                        }
                        c0316l.a(new C0309e(cursorR.getInt(1), d(string)), i2);
                    }
                } finally {
                    cursorR.close();
                }
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C0313i j(long j2, int i2) throws C0303b {
        InputStream inputStreamOpenInputStream;
        C0313i c0313i = new C0313i();
        if (i2 == 132 || i2 == 128) {
            Cursor cursorR = C0384b.r(this.f6298b, Uri.parse("content://mms/" + j2 + "/part"), g, null, null, null);
            C0318n[] c0318nArr = null;
            if (cursorR != null) {
                try {
                    if (cursorR.getCount() == 0) {
                        if (cursorR != null) {
                            cursorR.close();
                        }
                        if (c0318nArr != null) {
                            for (C0318n c0318n : c0318nArr) {
                                c0313i.b(c0318n);
                            }
                        }
                    } else {
                        C0318n[] c0318nArr2 = new C0318n[cursorR.getCount()];
                        int i4 = 0;
                        while (cursorR.moveToNext()) {
                            C0318n c0318n2 = new C0318n();
                            Integer numValueOf = !cursorR.isNull(1) ? Integer.valueOf(cursorR.getInt(1)) : null;
                            if (numValueOf != null) {
                                c0318n2.l(numValueOf.intValue());
                            }
                            byte[] bArrC = c(cursorR, 2);
                            if (bArrC != null) {
                                c0318n2.m(bArrC);
                            }
                            byte[] bArrC2 = c(cursorR, 3);
                            if (bArrC2 != null) {
                                c0318n2.n(bArrC2);
                            }
                            byte[] bArrC3 = c(cursorR, 4);
                            if (bArrC3 != null) {
                                c0318n2.o(bArrC3);
                            }
                            byte[] bArrC4 = c(cursorR, 5);
                            if (bArrC4 == null) {
                                throw new C0303b("Content-Type must be set.");
                            }
                            c0318n2.q(bArrC4);
                            byte[] bArrC5 = c(cursorR, 6);
                            if (bArrC5 != null) {
                                c0318n2.t(bArrC5);
                            }
                            byte[] bArrC6 = c(cursorR, 7);
                            if (bArrC6 != null) {
                                c0318n2.u(bArrC6);
                            }
                            Uri uri = Uri.parse("content://mms/part/" + cursorR.getLong(0));
                            c0318n2.s(uri);
                            String strR = r(bArrC4);
                            if (!C0337b.f(strR) && !C0337b.d(strR) && !C0337b.h(strR)) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                if ("text/plain".equals(strR) || "application/smil".equals(strR) || "text/html".equals(strR)) {
                                    String string = cursorR.getString(8);
                                    int iIntValue = numValueOf != null ? numValueOf.intValue() : 106;
                                    if (string == null) {
                                        string = "";
                                    }
                                    byte[] bArrG = new C0309e(iIntValue, string).g();
                                    byteArrayOutputStream.write(bArrG, 0, bArrG.length);
                                } else {
                                    try {
                                        try {
                                            inputStreamOpenInputStream = this.f6298b.openInputStream(uri);
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStreamOpenInputStream = c0318nArr;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                    }
                                    try {
                                        byte[] bArr = new byte[256];
                                        for (int i5 = inputStreamOpenInputStream.read(bArr); i5 >= 0; i5 = inputStreamOpenInputStream.read(bArr)) {
                                            byteArrayOutputStream.write(bArr, 0, i5);
                                        }
                                        try {
                                            inputStreamOpenInputStream.close();
                                        } catch (IOException e4) {
                                            Log.e("PduPersister", "Failed to close stream", e4);
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        c0318nArr = inputStreamOpenInputStream;
                                        Log.e("PduPersister", "Failed to load part data", e);
                                        cursorR.close();
                                        throw new C0303b(e);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (inputStreamOpenInputStream != 0) {
                                            try {
                                                inputStreamOpenInputStream.close();
                                            } catch (IOException e6) {
                                                Log.e("PduPersister", "Failed to close stream", e6);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                c0318n2.r(byteArrayOutputStream.toByteArray());
                            }
                            c0318nArr2[i4] = c0318n2;
                            i4++;
                        }
                        cursorR.close();
                        c0318nArr = c0318nArr2;
                        if (c0318nArr != null) {
                        }
                    }
                } catch (Throwable th3) {
                    cursorR.close();
                    throw th3;
                }
            } else {
                if (cursorR != null) {
                }
                if (c0318nArr != null) {
                }
            }
        }
        return c0313i;
    }

    private void k(Cursor cursor, C0316l c0316l) throws C0302a {
        int size = f6289j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            SparseIntArray sparseIntArray = f6289j;
            int iValueAt = sparseIntArray.valueAt(size);
            int iKeyAt = sparseIntArray.keyAt(size);
            String string = cursor.getString(iValueAt);
            if (string != null && string.length() > 0) {
                c0316l.h(new C0309e(cursor.getInt(f6288i.get(iKeyAt)), d(string)), iKeyAt);
            }
        }
        int size2 = f6290k.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            SparseIntArray sparseIntArray2 = f6290k;
            int iValueAt2 = sparseIntArray2.valueAt(size2);
            int iKeyAt2 = sparseIntArray2.keyAt(size2);
            String string2 = cursor.getString(iValueAt2);
            if (string2 != null) {
                c0316l.l(d(string2), iKeyAt2);
            }
        }
        int size3 = f6291l.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            SparseIntArray sparseIntArray3 = f6291l;
            int iValueAt3 = sparseIntArray3.valueAt(size3);
            int iKeyAt3 = sparseIntArray3.keyAt(size3);
            if (!cursor.isNull(iValueAt3)) {
                c0316l.k(cursor.getInt(iValueAt3), iKeyAt3);
            }
        }
        int size4 = f6292m.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                return;
            }
            SparseIntArray sparseIntArray4 = f6292m;
            int iValueAt4 = sparseIntArray4.valueAt(size4);
            int iKeyAt4 = sparseIntArray4.keyAt(size4);
            if (!cursor.isNull(iValueAt4)) {
                c0316l.j(cursor.getLong(iValueAt4), iKeyAt4);
            }
        }
    }

    private void l(int i2, HashSet<String> hashSet, SparseArray<C0309e[]> sparseArray) {
        C0309e[] c0309eArr = sparseArray.get(i2);
        if (c0309eArr == null) {
            return;
        }
        for (C0309e c0309e : c0309eArr) {
            if (c0309e != null) {
                String strF = c0309e.f();
                if (!hashSet.contains(strF)) {
                    hashSet.add(strF);
                }
            }
        }
    }

    private void o(long j2, int i2, C0309e[] c0309eArr) {
        ContentValues contentValues = new ContentValues(3);
        for (C0309e c0309e : c0309eArr) {
            contentValues.clear();
            contentValues.put("address", r(c0309e.g()));
            contentValues.put("charset", Integer.valueOf(c0309e.e()));
            contentValues.put("type", Integer.valueOf(i2));
            C0384b.p(this.f6298b, Uri.parse("content://mms/" + j2 + "/addr"), contentValues);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072 A[Catch: all -> 0x0180, IOException -> 0x0184, FileNotFoundException -> 0x0188, SQLiteException -> 0x018c, TRY_ENTER, TryCatch #15 {SQLiteException -> 0x018c, FileNotFoundException -> 0x0188, IOException -> 0x0184, all -> 0x0180, blocks: (B:27:0x0072, B:28:0x008d, B:38:0x00a4), top: B:162:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0169 A[Catch: all -> 0x00fe, IOException -> 0x0101, FileNotFoundException -> 0x0104, SQLiteException -> 0x0107, TryCatch #22 {all -> 0x00fe, blocks: (B:42:0x00b0, B:44:0x00b6, B:47:0x00bd, B:49:0x00c5, B:50:0x00c9, B:53:0x00d2, B:54:0x00d6, B:56:0x00dc, B:57:0x00e1, B:58:0x00e6, B:59:0x00e7, B:60:0x00fd, B:69:0x010a, B:78:0x0150, B:79:0x0154, B:81:0x015b, B:83:0x0163, B:84:0x0168, B:119:0x0230, B:120:0x023a, B:123:0x023f, B:124:0x0249, B:127:0x024e, B:128:0x0258, B:85:0x0169, B:86:0x017f), top: B:159:0x0008 }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.OutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v13, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p(C0318n c0318n, Uri uri, String str) throws Throwable {
        InputStream inputStream;
        C0331b c0331b;
        String str2;
        InputStream inputStream2;
        String str3;
        C0331b c0331b2;
        ?? Equals;
        String str4;
        C0331b c0331b3;
        OutputStream outputStreamOpenOutputStream;
        Exception e2;
        String strA;
        C0331b c0331bC;
        ?? r32 = 0;
        r32 = 0;
        inputStreamOpenInputStream = null;
        InputStream inputStreamOpenInputStream = null;
        r32 = 0;
        OutputStream outputStream = null;
        try {
            try {
                try {
                    byte[] bArrH = c0318n.h();
                    int iB = c0318n.b();
                    if ("text/plain".equals(str) || "application/smil".equals(str) || (Equals = "text/html".equals(str)) != 0) {
                        if (bArrH != null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("text", new C0309e(iB, bArrH).f());
                            if (this.f6298b.update(uri, contentValues, null, null) != 1) {
                                throw new C0303b("unable to update " + uri.toString());
                            }
                        }
                        inputStream2 = null;
                        str3 = null;
                        c0331b2 = null;
                    } else {
                        boolean zEquals = "application/vnd.oma.drm.message".equals(str);
                        try {
                            if (zEquals) {
                                if (uri != null) {
                                    try {
                                        strA = a(this.f6297a, uri);
                                        try {
                                            try {
                                                long length = new File(strA).length();
                                                strA = strA;
                                                if (length > 0) {
                                                    return;
                                                }
                                            } catch (Exception e4) {
                                                e2 = e4;
                                                try {
                                                    Log.e("PduPersister", "Can't get file info for: " + c0318n.i(), e2);
                                                    strA = strA;
                                                    c0331bC = C0331b.c(this.f6297a, str);
                                                    str4 = strA;
                                                    c0331b3 = c0331bC;
                                                    if (c0331bC == null) {
                                                    }
                                                    outputStreamOpenOutputStream = this.f6298b.openOutputStream(uri);
                                                    if (outputStreamOpenOutputStream != null) {
                                                    }
                                                } catch (SQLiteException e5) {
                                                    e = e5;
                                                    Log.e("PduPersister", "Failed with SQLiteException.", e);
                                                    throw new C0303b(e);
                                                } catch (FileNotFoundException e6) {
                                                    e = e6;
                                                    Log.e("PduPersister", "Failed to open Input/Output stream.", e);
                                                    throw new C0303b(e);
                                                } catch (IOException e7) {
                                                    e = e7;
                                                    Log.e("PduPersister", "Failed to read/write data.", e);
                                                    throw new C0303b(e);
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = null;
                                            c0331b = null;
                                            str2 = strA;
                                            if (r32 != 0) {
                                                try {
                                                    r32.close();
                                                } catch (IOException e8) {
                                                    Log.e("PduPersister", "IOException while closing: " + r32, e8);
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e9) {
                                                    Log.e("PduPersister", "IOException while closing: " + inputStream, e9);
                                                }
                                            }
                                            if (c0331b == null) {
                                                throw th;
                                            }
                                            c0331b.a(str2);
                                            File file = new File(str2);
                                            ContentValues contentValues2 = new ContentValues(0);
                                            ContentResolver contentResolver = this.f6298b;
                                            StringBuilder sbD = D2.e.d("content://mms/resetFilePerm/");
                                            sbD.append(file.getName());
                                            C0384b.x(contentResolver, Uri.parse(sbD.toString()), contentValues2);
                                            throw th;
                                        }
                                    } catch (Exception e10) {
                                        e2 = e10;
                                        strA = null;
                                    }
                                } else {
                                    strA = null;
                                }
                                c0331bC = C0331b.c(this.f6297a, str);
                                str4 = strA;
                                c0331b3 = c0331bC;
                                if (c0331bC == null) {
                                    throw new C0303b("Mimetype " + str + " can not be converted.");
                                }
                            } else {
                                str4 = null;
                                c0331b3 = null;
                            }
                            outputStreamOpenOutputStream = this.f6298b.openOutputStream(uri);
                            try {
                                if (outputStreamOpenOutputStream != null) {
                                    throw new C0303b("Failed to create output stream on " + uri);
                                }
                                if (bArrH == null) {
                                    Uri uriI = c0318n.i();
                                    if (uriI != null && !uriI.equals(uri)) {
                                        inputStreamOpenInputStream = this.f6298b.openInputStream(uriI);
                                        if (inputStreamOpenInputStream == null) {
                                            throw new C0303b("Failed to create input stream on " + uriI);
                                        }
                                        byte[] bArr = new byte[8192];
                                        while (true) {
                                            int i2 = inputStreamOpenInputStream.read(bArr);
                                            if (i2 == -1) {
                                                break;
                                            }
                                            if (zEquals) {
                                                byte[] bArrB = c0331b3.b(bArr, i2);
                                                if (bArrB == null) {
                                                    throw new C0303b("Error converting drm data.");
                                                }
                                                outputStreamOpenOutputStream.write(bArrB, 0, bArrB.length);
                                            } else {
                                                outputStreamOpenOutputStream.write(bArr, 0, i2);
                                            }
                                        }
                                    }
                                    Log.w("PduPersister", "Can't find data for this part.");
                                    try {
                                        outputStreamOpenOutputStream.close();
                                    } catch (IOException e11) {
                                        Log.e("PduPersister", "IOException while closing: " + outputStreamOpenOutputStream, e11);
                                    }
                                    if (c0331b3 != null) {
                                        c0331b3.a(str4);
                                        File file2 = new File(str4);
                                        ContentValues contentValues3 = new ContentValues(0);
                                        ContentResolver contentResolver2 = this.f6298b;
                                        StringBuilder sbD2 = D2.e.d("content://mms/resetFilePerm/");
                                        sbD2.append(file2.getName());
                                        C0384b.x(contentResolver2, Uri.parse(sbD2.toString()), contentValues3);
                                        return;
                                    }
                                    return;
                                }
                                if (zEquals) {
                                    byte[] bArrB2 = c0331b3.b(bArrH, bArrH.length);
                                    if (bArrB2 == null) {
                                        throw new C0303b("Error converting drm data.");
                                    }
                                    outputStreamOpenOutputStream.write(bArrB2, 0, bArrB2.length);
                                } else {
                                    outputStreamOpenOutputStream.write(bArrH);
                                }
                                inputStream2 = inputStreamOpenInputStream;
                                outputStream = outputStreamOpenOutputStream;
                                str3 = str4;
                                c0331b2 = c0331b3;
                            } catch (SQLiteException e12) {
                                e = e12;
                                Log.e("PduPersister", "Failed with SQLiteException.", e);
                                throw new C0303b(e);
                            } catch (FileNotFoundException e13) {
                                e = e13;
                                Log.e("PduPersister", "Failed to open Input/Output stream.", e);
                                throw new C0303b(e);
                            } catch (IOException e14) {
                                e = e14;
                                Log.e("PduPersister", "Failed to read/write data.", e);
                                throw new C0303b(e);
                            }
                        } catch (SQLiteException e15) {
                            e = e15;
                        } catch (FileNotFoundException e16) {
                            e = e16;
                        } catch (IOException e17) {
                            e = e17;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                            str2 = Equals;
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e18) {
                            Log.e("PduPersister", "IOException while closing: " + outputStream, e18);
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e19) {
                            Log.e("PduPersister", "IOException while closing: " + inputStream2, e19);
                        }
                    }
                    if (c0331b2 != null) {
                        c0331b2.a(str3);
                        File file3 = new File(str3);
                        ContentValues contentValues4 = new ContentValues(0);
                        ContentResolver contentResolver3 = this.f6298b;
                        StringBuilder sbD3 = D2.e.d("content://mms/resetFilePerm/");
                        sbD3.append(file3.getName());
                        C0384b.x(contentResolver3, Uri.parse(sbD3.toString()), contentValues4);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    str2 = null;
                    c0331b = null;
                }
            } catch (SQLiteException e20) {
                e = e20;
            } catch (FileNotFoundException e21) {
                e = e21;
            } catch (IOException e22) {
                e = e22;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            r32 = str;
        }
    }

    public static String r(byte[] bArr) {
        try {
            return new String(bArr, "iso-8859-1");
        } catch (UnsupportedEncodingException e2) {
            Log.e("PduPersister", "ISO_8859_1 must be supported!", e2);
            return "";
        }
    }

    private void t(Uri uri, C0318n c0318n) throws Throwable {
        ContentValues contentValues = new ContentValues(7);
        int iB = c0318n.b();
        if (iB != 0) {
            contentValues.put("chset", Integer.valueOf(iB));
        }
        if (c0318n.g() == null) {
            throw new C0303b("MIME type of the part must be set.");
        }
        String strR = r(c0318n.g());
        contentValues.put("ct", strR);
        g(c0318n, contentValues);
        C0384b.x(this.f6298b, uri, contentValues);
        if (c0318n.h() == null && uri.equals(c0318n.i())) {
            return;
        }
        p(c0318n, uri, strR);
    }

    public final Cursor f() {
        Uri.Builder builderBuildUpon = Telephony.MmsSms.PendingMessages.CONTENT_URI.buildUpon();
        builderBuildUpon.appendQueryParameter("protocol", "mms");
        return C0384b.r(this.f6298b, builderBuildUpon.build(), null, "err_type < ? AND due_time <= ?", new String[]{String.valueOf(10), String.valueOf(2147483647L)}, "due_time");
    }

    public final C0310f h(Uri uri) throws C0303b {
        try {
            h0.c cVar = d;
            synchronized (cVar) {
                if (cVar.f(uri)) {
                    try {
                        cVar.wait();
                    } catch (InterruptedException e2) {
                        Log.e("PduPersister", "load: ", e2);
                    }
                }
                h0.c cVar2 = d;
                h0.d dVarA = cVar2.a(uri);
                if (dVarA != null) {
                    C0310f c0310fB = dVarA.b();
                    synchronized (cVar2) {
                        cVar2.m(uri, false);
                        cVar2.notifyAll();
                    }
                    return c0310fB;
                }
                cVar2.m(uri, true);
                Cursor cursorR = C0384b.r(this.f6298b, uri, f6286f, null, null, null);
                C0316l c0316l = new C0316l();
                long id = ContentUris.parseId(uri);
                if (cursorR != null) {
                    try {
                        if (cursorR.getCount() == 1 && cursorR.moveToFirst()) {
                            int i2 = cursorR.getInt(1);
                            k(cursorR, c0316l);
                            cursorR.close();
                            if (id == -1) {
                                throw new C0303b("Error! ID of the message: -1.");
                            }
                            i(id, c0316l);
                            int iE = c0316l.e(140);
                            C0310f c0310fB2 = b(iE, c0316l, j(id, iE));
                            synchronized (cVar2) {
                                C0336a.c(cVar2.a(uri), "Pdu exists for " + uri);
                                cVar2.j(uri, new h0.d(c0310fB2, i2));
                                cVar2.m(uri, false);
                                cVar2.notifyAll();
                            }
                            return c0310fB2;
                        }
                    } finally {
                        cursorR.close();
                    }
                }
                if (cursorR != null) {
                }
                synchronized (cVar2) {
                    cVar2.m(uri, false);
                    cVar2.notifyAll();
                }
                return null;
            }
        } catch (Throwable th) {
            h0.c cVar3 = d;
            synchronized (cVar3) {
                cVar3.m(uri, false);
                cVar3.notifyAll();
                throw th;
            }
        }
    }

    public final Uri m(Uri uri, Uri uri2) throws C0303b {
        long id = ContentUris.parseId(uri);
        if (id == -1) {
            throw new C0303b("Error! ID of the message: -1.");
        }
        Integer orDefault = f6287h.getOrDefault(uri2, null);
        if (orDefault == null) {
            throw new C0303b("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("msg_box", orDefault);
        C0384b.x(this.f6298b, uri, contentValues);
        return ContentUris.withAppendedId(uri2, id);
    }

    public final Uri n(C0310f c0310f, Uri uri, int i2, String str) throws C0303b {
        long id;
        long jA;
        int i4;
        Uri uriP;
        C0313i c0313iE;
        C0309e[] c0309eArrC;
        if (uri == null) {
            throw new C0303b("Uri may not be null.");
        }
        try {
            id = ContentUris.parseId(uri);
        } catch (NumberFormatException unused) {
            id = -1;
        }
        boolean z4 = id != -1;
        if (!z4 && f6287h.getOrDefault(uri, null) == null) {
            throw new C0303b("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
        }
        h0.c cVar = d;
        synchronized (cVar) {
            if (cVar.f(uri)) {
                try {
                    cVar.wait();
                } catch (InterruptedException e2) {
                    Log.e("PduPersister", "persist1: ", e2);
                }
            }
        }
        d.g(uri);
        C0316l c0316l = c0310f.f6252a;
        ContentValues contentValues = new ContentValues();
        contentValues.put("seen", (Integer) 1);
        int size = f6294o.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            SparseArray<String> sparseArray = f6294o;
            int iKeyAt = sparseArray.keyAt(size);
            C0309e c0309eB = c0316l.b(iKeyAt);
            if (c0309eB != null) {
                String str2 = f6293n.get(iKeyAt);
                contentValues.put(sparseArray.valueAt(size), r(c0309eB.g()));
                contentValues.put(str2, Integer.valueOf(c0309eB.e()));
            }
        }
        int size2 = p.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            SparseArray<String> sparseArray2 = p;
            byte[] bArrF = c0316l.f(sparseArray2.keyAt(size2));
            if (bArrF != null) {
                contentValues.put(sparseArray2.valueAt(size2), r(bArrF));
            }
        }
        int size3 = f6295q.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            SparseArray<String> sparseArray3 = f6295q;
            int iE = c0316l.e(sparseArray3.keyAt(size3));
            if (iE != 0) {
                contentValues.put(sparseArray3.valueAt(size3), Integer.valueOf(iE));
            }
        }
        int size4 = f6296r.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            SparseArray<String> sparseArray4 = f6296r;
            long jD = c0316l.d(sparseArray4.keyAt(size4));
            if (jD != -1) {
                contentValues.put(sparseArray4.valueAt(size4), Long.valueOf(jD));
            }
        }
        int[] iArr = f6285e;
        SparseArray<C0309e[]> sparseArray5 = new SparseArray<>(4);
        int i5 = 0;
        for (int i6 = 4; i5 < i6; i6 = 4) {
            int i7 = iArr[i5];
            if (i7 == 137) {
                C0309e c0309eB2 = c0316l.b(i7);
                c0309eArrC = c0309eB2 != null ? new C0309e[]{c0309eB2} : null;
            } else {
                c0309eArrC = c0316l.c(i7);
            }
            sparseArray5.put(i7, c0309eArrC);
            i5++;
        }
        HashSet<String> hashSet = new HashSet<>();
        int iA = c0310f.a();
        if (iA == 130 || iA == 132 || iA == 128) {
            if (iA == 128) {
                l(151, hashSet, sparseArray5);
            } else if (iA == 130 || iA == 132) {
                l(137, hashSet, sparseArray5);
                C0309e[] c0309eArr = sparseArray5.get(151);
                C0309e[] c0309eArr2 = sparseArray5.get(130);
                ArrayList arrayList = new ArrayList();
                if (c0309eArr != null) {
                    for (C0309e c0309e : c0309eArr) {
                        if (c0309e != null) {
                            arrayList.add(c0309e.f());
                        }
                    }
                }
                if (c0309eArr2 != null) {
                    for (C0309e c0309e2 : c0309eArr2) {
                        if (c0309e2 != null) {
                            arrayList.add(c0309e2.f());
                        }
                    }
                }
                boolean zIsEmpty = TextUtils.isEmpty(str);
                if (!zIsEmpty || arrayList.size() != 1) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        if (zIsEmpty || !PhoneNumberUtils.compare(str3, str)) {
                            if (!hashSet.contains(str3)) {
                                hashSet.add(str3);
                            }
                        }
                    }
                }
            }
            if (hashSet.isEmpty()) {
                Log.w("PduPersister", "PduPersister.persist No recipients; persisting PDU to thread: -1");
                jA = -1;
            } else {
                jA = C0334a.C0113a.a(this.f6297a, hashSet);
            }
            contentValues.put("thread_id", Long.valueOf(jA));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!(c0310f instanceof C0311g) || (c0313iE = ((C0311g) c0310f).e()) == null) {
            i4 = 1;
        } else {
            int iH = c0313iE.h();
            i4 = iH > 2 ? 0 : 1;
            for (int i8 = 0; i8 < iH; i8++) {
                C0318n c0318nC = c0313iE.c(i8);
                q(c0318nC, jCurrentTimeMillis);
                String strR = c0318nC.g() == null ? null : r(c0318nC.g());
                if (strR != null && !"application/smil".equals(strR) && !"text/plain".equals(strR)) {
                    i4 = 0;
                }
            }
        }
        if (j0.c.a()) {
            contentValues.put("text_only", Integer.valueOf(i4));
        }
        if (j0.c.b()) {
            contentValues.put("sub_id", Integer.valueOf(i2));
        } else {
            C0336a.a(i2);
        }
        if (z4) {
            C0384b.x(this.f6298b, uri, contentValues);
            uriP = uri;
        } else {
            uriP = C0384b.p(this.f6298b, uri, contentValues);
            if (uriP == null) {
                throw new C0303b("persist() failed: return null.");
            }
            id = ContentUris.parseId(uriP);
        }
        ContentValues contentValues2 = new ContentValues(1);
        contentValues2.put("mid", Long.valueOf(id));
        C0384b.x(this.f6298b, Uri.parse("content://mms/" + jCurrentTimeMillis + "/part"), contentValues2);
        if (!z4) {
            uriP = Uri.parse(uri + "/" + id);
        }
        int[] iArr2 = f6285e;
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = iArr2[i9];
            C0309e[] c0309eArr3 = sparseArray5.get(i10);
            if (c0309eArr3 != null) {
                o(id, i10, c0309eArr3);
            }
        }
        return uriP;
    }

    public final Uri q(C0318n c0318n, long j2) throws C0303b {
        Uri uri = Uri.parse("content://mms/" + j2 + "/part");
        ContentValues contentValues = new ContentValues(8);
        int iB = c0318n.b();
        if (iB != 0) {
            contentValues.put("chset", Integer.valueOf(iB));
        }
        Uri uriP = null;
        String strR = c0318n.g() == null ? null : r(c0318n.g());
        byte[] bArrH = c0318n.h();
        if (strR == null) {
            throw new C0303b("MIME type of the part must be set.");
        }
        if ("image/jpg".equals(strR)) {
            strR = "image/jpeg";
        }
        if ("text/plain".equals(strR) && bArrH != null && new C0309e(iB, bArrH).f().startsWith("BEGIN:VCARD")) {
            strR = "text/x-vCard";
            c0318n.q("text/x-vCard".getBytes());
            if (Log.isLoggable("PduPersister", 3)) {
                Log.d("PduPersister", "PduPersister.persistPart part: " + uri + " contentType: text/x-vCard changing to vcard");
            }
        }
        contentValues.put("ct", strR);
        if ("application/smil".equals(strR)) {
            contentValues.put("seq", (Integer) (-1));
        }
        g(c0318n, contentValues);
        try {
            uriP = C0384b.p(this.f6298b, uri, contentValues);
        } catch (IllegalStateException e2) {
            Log.e("PduPersister", "SqliteWrapper.insert threw: ", e2);
        }
        if (uriP == null) {
            throw new C0303b("Failed to persist part, return null.");
        }
        p(c0318n, uriP, strR);
        c0318n.s(uriP);
        return uriP;
    }

    public final void s(Uri uri, t tVar) {
        C0309e[] c0309eArrC;
        C0316l c0316l;
        h0.c cVar = d;
        synchronized (cVar) {
            if (cVar.f(uri)) {
                try {
                    cVar.wait();
                } catch (InterruptedException e2) {
                    Log.e("PduPersister", "updateHeaders: ", e2);
                }
            }
        }
        d.g(uri);
        ContentValues contentValues = new ContentValues(10);
        byte[] bArrF = tVar.f6252a.f(132);
        if (bArrF != null) {
            contentValues.put("ct_t", r(bArrF));
        }
        long jF = tVar.f();
        if (jF != -1) {
            contentValues.put("date", Long.valueOf(jF));
        }
        int iE = tVar.f6252a.e(134);
        if (iE != 0) {
            contentValues.put("d_rpt", Integer.valueOf(iE));
        }
        long jD = tVar.f6252a.d(136);
        if (jD != -1) {
            contentValues.put("exp", Long.valueOf(jD));
        }
        byte[] bArrF2 = tVar.f6252a.f(138);
        if (bArrF2 != null) {
            contentValues.put("m_cls", r(bArrF2));
        }
        int iE2 = tVar.f6252a.e(143);
        if (iE2 != 0) {
            contentValues.put("pri", Integer.valueOf(iE2));
        }
        int iE3 = tVar.f6252a.e(144);
        if (iE3 != 0) {
            contentValues.put("rr", Integer.valueOf(iE3));
        }
        byte[] bArrO = tVar.o();
        if (bArrO != null) {
            contentValues.put("tr_id", r(bArrO));
        }
        C0309e c0309eB = tVar.f6252a.b(150);
        if (c0309eB != null) {
            contentValues.put("sub", r(c0309eB.g()));
            contentValues.put("sub_cs", Integer.valueOf(c0309eB.e()));
        } else {
            contentValues.put("sub", "");
        }
        long jD2 = tVar.f6252a.d(142);
        if (jD2 > 0) {
            contentValues.put("m_size", Long.valueOf(jD2));
        }
        C0316l c0316l2 = tVar.f6252a;
        HashSet hashSet = new HashSet();
        int[] iArr = f6285e;
        char c2 = 0;
        int i2 = 0;
        while (i2 < 4) {
            int i4 = iArr[i2];
            if (i4 == 137) {
                C0309e c0309eB2 = c0316l2.b(i4);
                if (c0309eB2 != null) {
                    c0309eArrC = new C0309e[1];
                    c0309eArrC[c2] = c0309eB2;
                } else {
                    c0309eArrC = null;
                }
            } else {
                c0309eArrC = c0316l2.c(i4);
            }
            if (c0309eArrC != null) {
                long id = ContentUris.parseId(uri);
                c0316l = c0316l2;
                try {
                    this.f6298b.delete(Uri.parse("content://mms/" + id + "/addr"), "type=" + i4, null);
                } catch (SQLiteException e4) {
                    Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when delete", e4);
                } catch (IllegalArgumentException e5) {
                    Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when delete", e5);
                }
                o(id, i4, c0309eArrC);
                if (i4 == 151) {
                    for (C0309e c0309e : c0309eArrC) {
                        if (c0309e != null) {
                            hashSet.add(c0309e.f());
                        }
                    }
                }
            } else {
                c0316l = c0316l2;
            }
            i2++;
            c0316l2 = c0316l;
            c2 = 0;
        }
        if (!hashSet.isEmpty()) {
            contentValues.put("thread_id", Long.valueOf(C0334a.C0113a.a(this.f6297a, hashSet)));
        }
        C0384b.x(this.f6298b, uri, contentValues);
    }

    public final void u(Uri uri, C0313i c0313i, int i2) throws C0303b {
        try {
            h0.c cVar = d;
            synchronized (cVar) {
                if (cVar.f(uri)) {
                    try {
                        cVar.wait();
                    } catch (InterruptedException e2) {
                        Log.e("PduPersister", "updateParts: ", e2);
                    }
                    h0.d dVarA = d.a(uri);
                    if (dVarA != null) {
                        ((C0311g) dVarA.b()).j(c0313i);
                    }
                    d.m(uri, true);
                } else {
                    d.m(uri, true);
                }
            }
            ArrayList arrayList = new ArrayList();
            C0365a c0365a = new C0365a();
            int iH = c0313i.h();
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            for (int i4 = 0; i4 < iH; i4++) {
                C0318n c0318nC = c0313i.c(i4);
                Uri uriI = c0318nC.i();
                if (uriI == null || TextUtils.isEmpty(uriI.getAuthority()) || !uriI.getAuthority().startsWith("mms")) {
                    arrayList.add(c0318nC);
                } else {
                    c0365a.put(uriI, c0318nC);
                    if (sb.length() > 1) {
                        sb.append(" AND ");
                    }
                    sb.append("_id");
                    sb.append("!=");
                    DatabaseUtils.appendEscapedSQLString(sb, uriI.getLastPathSegment());
                }
            }
            sb.append(')');
            long id = ContentUris.parseId(uri);
            try {
                this.f6298b.delete(Uri.parse(Telephony.Mms.CONTENT_URI + "/" + id + "/part"), sb.length() > 2 ? sb.toString() : null, null);
            } catch (SQLiteException e4) {
                Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when delete", e4);
            } catch (IllegalArgumentException e5) {
                Log.e("SqliteWrapper", "SqliteWrapper: catch an exception when delete", e5);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                q((C0318n) it.next(), id);
            }
            for (Map.Entry entry : c0365a.entrySet()) {
                t((Uri) entry.getKey(), (C0318n) entry.getValue());
            }
            if (i2 != -1) {
                ContentValues contentValues = new ContentValues(1);
                if (j0.c.b()) {
                    contentValues.put("sub_id", Integer.valueOf(i2));
                } else {
                    C0336a.a(i2);
                }
                C0384b.x(this.f6298b, uri, contentValues);
            }
            h0.c cVar2 = d;
            synchronized (cVar2) {
                cVar2.m(uri, false);
                cVar2.notifyAll();
            }
        } catch (Throwable th) {
            h0.c cVar3 = d;
            synchronized (cVar3) {
                cVar3.m(uri, false);
                cVar3.notifyAll();
                throw th;
            }
        }
    }
}
