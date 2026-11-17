package com.android.mmt.ui;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import c.C0227a;
import com.android.mmt.R;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.util.BackgroundCleaner;
import com.android.mmt.util.C0271c;
import f0.C0303b;
import g0.C0309e;
import g0.C0319o;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import t0.C0385a;
import x0.C0414a;

/* renamed from: com.android.mmt.ui.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0243g0 implements BackgroundCleaner.c {

    /* renamed from: A, reason: collision with root package name */
    private Uri f5562A;

    /* renamed from: B, reason: collision with root package name */
    private int f5563B;

    /* renamed from: C, reason: collision with root package name */
    private String f5564C;

    /* renamed from: D, reason: collision with root package name */
    private SoftReference<G0> f5565D;

    /* renamed from: E, reason: collision with root package name */
    private int f5566E;

    /* renamed from: F, reason: collision with root package name */
    private String f5567F;

    /* renamed from: G, reason: collision with root package name */
    private int f5568G;

    /* renamed from: H, reason: collision with root package name */
    private String f5569H;

    /* renamed from: I, reason: collision with root package name */
    private String f5570I;

    /* renamed from: J, reason: collision with root package name */
    private G0.c f5571J;

    /* renamed from: K, reason: collision with root package name */
    private int f5572K;
    private int L;
    private int M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f5573N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f5574O;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5575a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5576b;

    /* renamed from: c, reason: collision with root package name */
    private final long f5577c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private final long f5578e;

    /* renamed from: f, reason: collision with root package name */
    private final long f5579f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private int f5580h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5581i;

    /* renamed from: j, reason: collision with root package name */
    private String f5582j;

    /* renamed from: k, reason: collision with root package name */
    private long f5583k;

    /* renamed from: l, reason: collision with root package name */
    private long f5584l;

    /* renamed from: m, reason: collision with root package name */
    private String f5585m;

    /* renamed from: n, reason: collision with root package name */
    private C0414a f5586n;

    /* renamed from: o, reason: collision with root package name */
    private int f5587o;
    private String p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f5588q;

    /* renamed from: r, reason: collision with root package name */
    private G0.c f5589r;

    /* renamed from: s, reason: collision with root package name */
    private String f5590s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5591t;
    private ArrayList<a> u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<Uri> f5592v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5593w;

    /* renamed from: x, reason: collision with root package name */
    private int f5594x;

    /* renamed from: y, reason: collision with root package name */
    private int f5595y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f5596z;

    /* renamed from: com.android.mmt.ui.g0$a */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5597a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f5598b;

        public a(String str, Uri uri) {
            this.f5597a = str;
            this.f5598b = uri;
        }
    }

    public C0243g0(Context context, Uri uri, long j2, String str, long j4, String str2, long j5) {
        this.L = -1;
        this.M = 0;
        this.f5573N = true;
        this.f5575a = context.getApplicationContext();
        this.f5576b = "sms";
        this.f5562A = uri;
        this.f5583k = j2;
        this.p = str;
        this.f5579f = j4;
        this.g = 1;
        this.f5577c = 0L;
        this.f5578e = j5;
        this.d = str2;
        this.f5585m = str2;
    }

    public final String A() {
        return this.f5570I;
    }

    public final G0.c B() {
        return this.f5571J;
    }

    public final boolean C() {
        return this.f5573N;
    }

    public final G0 D() {
        SoftReference<G0> softReference = this.f5565D;
        G0 g02 = softReference != null ? softReference.get() : null;
        if (g02 != null) {
            return g02;
        }
        G0 g03 = new G0(this.f5575a);
        g03.p(this.f5562A);
        this.f5565D = new SoftReference<>(g03);
        return g03;
    }

    public final long E() {
        return this.f5579f;
    }

    public final String F() {
        return this.f5564C;
    }

    public final String G() {
        return this.f5590s;
    }

    public final long H() {
        return this.f5578e;
    }

    public final String I() {
        return this.f5576b;
    }

    final boolean J() {
        int i2;
        return (Z() && !TextUtils.isEmpty(this.p)) || (U() && (((i2 = this.f5563B) == 132 || i2 == 128) && !TextUtils.isEmpty(this.f5567F)));
    }

    public final void K(String str, boolean z4, int i2, boolean z5) {
        this.f5573N = z4;
        this.M = i2;
        if ("LIST".equals(str)) {
            if (!V()) {
                this.L = 0;
                return;
            }
            if (this.f5591t && Y()) {
                this.L = 1;
                return;
            } else if (Q()) {
                this.L = 2;
                return;
            } else {
                this.L = 1;
                return;
            }
        }
        if (!V()) {
            this.L = z5 ? 4 : 3;
            return;
        }
        if (this.f5591t && Y()) {
            this.L = z5 ? 7 : 6;
        } else if (Q()) {
            this.L = z5 ? 9 : 8;
        } else {
            this.L = z5 ? 7 : 6;
        }
    }

    final boolean L() {
        return this.L == 11;
    }

    final boolean M() {
        int i2 = this.L;
        return i2 >= 3 && i2 <= 4;
    }

    final boolean N() {
        int i2 = this.L;
        return i2 >= 3 && i2 <= 9;
    }

    final boolean O() {
        int i2 = this.L;
        return i2 >= 6 && i2 <= 9;
    }

    public final boolean P() {
        return this.f5563B != 130;
    }

    public final boolean Q() {
        return (U() && this.f5572K >= 10) || (!this.f5591t ? !(!Z() || this.g != 5) : !(!Z() || this.u.size() <= 0));
    }

    public final boolean R() {
        return this.f5591t;
    }

    final boolean S() {
        int i2 = this.L;
        return i2 >= 0 && i2 <= 2;
    }

    public final boolean T() {
        return this.f5581i;
    }

    public final boolean U() {
        return "mms".equals(this.f5576b);
    }

    public final boolean V() {
        int i2;
        int i4;
        return (U() && ((i4 = this.g) == 4 || i4 == 2)) || (Z() && ((i2 = this.g) == 5 || i2 == 4 || i2 == 6 || i2 == 2)) || this.f5591t || this.f5596z;
    }

    public final boolean W() {
        return this.f5596z;
    }

    public final boolean X() {
        return this.f5593w;
    }

    public final boolean Y() {
        int i2;
        if (this.f5591t && Z()) {
            return this.f5594x > 0;
        }
        if (!Q()) {
            if ((U() && this.g == 4) || (Z() && ((i2 = this.g) == 5 || i2 == 4 || i2 == 6))) {
                return true;
            }
        }
        return false;
    }

    public final boolean Z() {
        return "sms".equals(this.f5576b);
    }

    public final synchronized void a(Uri uri) {
        boolean z4;
        Iterator<Uri> it = this.f5592v.iterator();
        while (true) {
            if (!it.hasNext()) {
                z4 = false;
                break;
            } else if (it.next().equals(uri)) {
                z4 = true;
                break;
            }
        }
        if (!z4) {
            this.f5592v.add(uri);
        }
    }

    public final synchronized void a0(Uri uri) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f5592v.size()) {
                i2 = -1;
                break;
            } else if (this.f5592v.get(i2).equals(uri)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.f5592v.remove(i2);
        }
    }

    @Override // com.android.mmt.util.BackgroundCleaner.c
    public final void b() {
        SoftReference<G0> softReference = this.f5565D;
        if (softReference != null) {
            softReference.clear();
            this.f5565D = null;
        }
    }

    public final ArrayList<Uri> b0() {
        return this.f5592v;
    }

    public final void c() {
        if (!"sms".equals(this.f5576b) || C0227a.b(this.g)) {
            return;
        }
        C0414a c0414aO = C0414a.O(this.f5585m);
        c0414aO.m0(false, false);
        this.f5586n = c0414aO;
    }

    public final void c0() {
        this.L = -1;
    }

    public final ArrayList<a> d() {
        return this.u;
    }

    public final int d0() {
        return this.f5595y;
    }

    public final String e() {
        return this.f5585m;
    }

    public final void e0(CharSequence charSequence) {
        this.f5588q = charSequence;
    }

    public final int f() {
        int i2 = this.f5566E;
        if (i2 == 3) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        return i2 == 4 ? 2 : 3;
    }

    public final void f0(C0414a c0414a) {
        if (c0414a != null) {
            this.f5586n = c0414a;
            this.f5585m = c0414a.W();
        }
    }

    public final String g() {
        return (U() && this.f5566E == 0) ? this.f5575a.getString(R.string.loading_mms) : this.p;
    }

    public final CharSequence h() {
        return this.f5588q;
    }

    public final int i() {
        return this.g;
    }

    public final C0414a j() {
        return this.f5586n;
    }

    public final G0.c k() {
        return this.f5589r;
    }

    public final String l() {
        C0414a c0414a = this.f5586n;
        return c0414a != null ? c0414a.U() : this.f5575a.getString(R.string.messagelist_sender_self);
    }

    public final long m() {
        return this.f5583k;
    }

    public final long n() {
        return this.f5584l;
    }

    public final int o() {
        return this.M;
    }

    public final int p() {
        return this.f5580h;
    }

    public final long q() {
        return this.f5583k;
    }

    public final String r() {
        return this.f5582j;
    }

    public final int s() {
        return this.L;
    }

    public final int t() {
        return this.f5568G;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("type: ");
        sbD.append(this.f5576b);
        sbD.append(" box: ");
        sbD.append(this.g);
        sbD.append(" uri: ");
        sbD.append(this.f5562A);
        sbD.append(" address: ");
        sbD.append(this.f5585m);
        sbD.append(" contact: ");
        sbD.append(l());
        sbD.append(" read: ");
        sbD.append(false);
        sbD.append(" delivery status: ");
        sbD.append(D2.e.h(this.f5580h));
        return sbD.toString();
    }

    public final int u() {
        return this.f5563B;
    }

    public final Uri v() {
        return this.f5562A;
    }

    public final int w() {
        return this.f5566E;
    }

    public final String x() {
        return this.f5567F;
    }

    public final int y() {
        return this.f5587o;
    }

    public final long z() {
        return this.f5577c;
    }

    public C0243g0(Context context, String str, Cursor cursor, C0247i0.c cVar, int i2) throws C0303b {
        this(context, str, cursor, cVar, 0L, null, i2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x04ab  */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.Integer>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0243g0(Context context, String str, Cursor cursor, C0247i0.c cVar, long j2, String str2, int i2, boolean z4) throws C0303b {
        Cursor cursorE;
        String strF;
        this.L = -1;
        this.M = 0;
        this.f5573N = true;
        this.f5575a = context;
        this.d = str2;
        long j4 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        this.f5577c = j4;
        long j5 = cursor.getLong(cVar.f5637c);
        this.f5578e = j5;
        this.f5579f = cursor.getLong(cVar.f5653w);
        this.f5591t = (i2 & 1) != 0;
        this.f5596z = (i2 & 2) != 0;
        boolean z5 = (i2 & 4) != 0;
        this.f5574O = (i2 & 8) != 0;
        this.f5576b = str;
        this.f5593w = j2 > 0 && j5 != j2;
        this.u = new ArrayList<>();
        this.f5592v = new ArrayList<>();
        this.f5594x = 0;
        this.f5595y = 0;
        this.f5569H = null;
        this.f5570I = null;
        if ("sms".equals(str)) {
            int i4 = cursor.getInt(cVar.f5640h);
            this.g = i4;
            if (!z5) {
                long j6 = cursor.getLong(cVar.f5641i);
                if (j6 == -1) {
                    this.f5580h = 1;
                } else if (j6 >= 64) {
                    this.f5580h = 3;
                } else if (j6 < 32) {
                    this.f5580h = 6;
                } else if (i4 == 2) {
                    this.f5580h = 5;
                } else {
                    this.f5580h = 4;
                }
            }
            this.f5562A = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, j4);
            this.f5585m = cursor.getString(cVar.d);
            this.p = cursor.getString(cVar.f5638e);
            this.f5583k = cursor.getLong(cVar.f5639f);
            this.f5584l = cursor.getLong(cVar.g);
            this.f5581i = cursor.getInt(cVar.f5642j) != 0;
            cursor.getInt(cVar.f5643k);
            if (this.f5591t) {
                Cursor cursorE2 = com.android.mmt.util.O.e(context, context.getContentResolver(), Telephony.Sms.CONTENT_URI, new String[]{"address", "_id"}, "thread_id=? AND date=? AND type=?", new String[]{String.valueOf(j5), String.valueOf(this.f5583k), String.valueOf(5)}, null);
                if (cursorE2 != null) {
                    while (cursorE2.moveToNext()) {
                        String string = cursorE2.getString(0);
                        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, cursorE2.getLong(1));
                        this.u.add(new a(string, uriWithAppendedId));
                        this.f5592v.add(uriWithAppendedId);
                    }
                    cursorE2.close();
                }
                Cursor cursorE3 = com.android.mmt.util.O.e(context, context.getContentResolver(), Telephony.Sms.CONTENT_URI, new String[]{"address", "body"}, "thread_id=? AND date=? AND type=?", new String[]{String.valueOf(this.f5578e), String.valueOf(this.f5583k), String.valueOf(6)}, " date ASC");
                if (cursorE3 != null) {
                    this.f5594x = cursorE3.getCount();
                    if (cursorE3.moveToFirst()) {
                        this.f5569H = cursorE3.getString(0);
                        this.f5570I = cursorE3.getString(1);
                    }
                    cursorE3.close();
                }
                if (this.f5569H == null) {
                    this.f5569H = this.f5585m;
                }
                if (this.f5570I == null) {
                    this.f5570I = this.p;
                }
                if (!this.f5574O) {
                    this.f5571J = G0.d.b(this.f5575a).d(this.f5570I);
                }
                cursorE = com.android.mmt.util.O.e(context, context.getContentResolver(), Telephony.Sms.CONTENT_URI, new String[]{"address"}, "thread_id=? AND date=? AND (type=? OR type=? OR type=?)", new String[]{String.valueOf(this.f5578e), String.valueOf(this.f5583k), String.valueOf(4), String.valueOf(5), String.valueOf(2)}, null);
                if (cursorE != null) {
                    this.f5595y = cursorE.getCount();
                }
            }
            if (!this.f5574O) {
                this.f5589r = G0.d.b(this.f5575a).d(this.p);
            }
            if (C0227a.b(this.g)) {
                if (this.f5591t) {
                    C0414a c0414aO = C0414a.O(this.f5569H);
                    c0414aO.m0(false, false);
                    this.f5586n = c0414aO;
                } else if (this.f5596z) {
                    C0414a c0414aO2 = C0414a.O(this.f5585m);
                    c0414aO2.m0(false, false);
                    this.f5586n = c0414aO2;
                }
            } else {
                C0414a c0414aO3 = C0414a.O(this.f5585m);
                c0414aO3.m0(false, false);
                this.f5586n = c0414aO3;
            }
        } else if ("mms".equals(str)) {
            this.f5562A = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j4);
            this.g = cursor.getInt(cVar.f5648q);
            this.f5563B = cursor.getInt(cVar.p);
            this.f5583k = cursor.getLong(cVar.f5646n) * 1000;
            this.f5584l = cursor.getLong(cVar.f5647o) * 1000;
            this.f5572K = cursor.getInt(cVar.f5649r);
            this.f5587o = cursor.getInt(cVar.f5654x);
            String string2 = cursor.getString(cVar.f5644l);
            if (!TextUtils.isEmpty(string2)) {
                this.f5564C = new C0309e(cursor.getInt(cVar.f5645m), C0319o.d(string2)).f();
            }
            G0 g0D = D();
            I0 i0L = g0D.l();
            if (i0L != null) {
                this.f5567F = i0L.D();
            }
            this.f5581i = cursor.getInt(cVar.f5650s) != 0;
            if (g0D.o()) {
                this.f5566E = 6;
            } else {
                I0 i0J = g0D.j();
                int iY = i0J != null ? i0J.y() : -1;
                if (iY >= 0) {
                    this.f5566E = ((Integer) C0385a.C0138a.f7894a.get(Integer.valueOf(iY))).intValue();
                }
            }
            if (this.f5566E == 0) {
                int i5 = P0.r.f937c;
                if (context != null) {
                    Intent intent = new Intent("android.provider.Telephony.MAKE_MMS_PREVIEW");
                    intent.putExtra("_id", j4);
                    intent.setPackage("com.android.providers.telephony");
                    context.startService(intent);
                }
            }
            int i6 = this.f5563B;
            if (130 == i6) {
                this.f5580h = 1;
                this.p = cursor.getString(cVar.f5651t);
                this.f5568G = cursor.getInt(cVar.u);
                int i7 = P0.r.f937c;
                this.f5582j = context.getString(R.string.expire_on, C3.c.c(context, cursor.getInt(cVar.f5652v) * 1000));
            } else {
                if (z5) {
                    if (i6 == 132) {
                        this.f5585m = null;
                    } else {
                        this.f5585m = context.getString(R.string.messagelist_sender_self);
                    }
                } else if (i6 == 132) {
                    String str3 = this.d;
                    this.f5585m = str3;
                    Uri uri = this.f5562A;
                    if (TextUtils.isEmpty(str3)) {
                        this.f5585m = C0271c.a(context, uri);
                    }
                    if (!TextUtils.isEmpty(this.f5585m)) {
                        C0414a c0414aO4 = C0414a.O(this.f5585m);
                        c0414aO4.m0(false, false);
                        this.f5586n = c0414aO4;
                    }
                } else if (i6 == 128) {
                    String str4 = this.d;
                    this.f5585m = str4;
                    if (TextUtils.isEmpty(str4)) {
                        String lastPathSegment = this.f5562A.getLastPathSegment();
                        Uri.Builder builderBuildUpon = Telephony.Mms.CONTENT_URI.buildUpon();
                        builderBuildUpon.appendPath(lastPathSegment).appendPath("addr");
                        cursorE = com.android.mmt.util.O.e(context, context.getContentResolver(), builderBuildUpon.build(), new String[]{"address", "charset"}, "type=151", null, null);
                        if (cursorE != null) {
                            try {
                                if (cursorE.moveToFirst()) {
                                    String string3 = cursorE.getString(0);
                                    if (!TextUtils.isEmpty(string3)) {
                                        strF = new C0309e(cursorE.getInt(1), C0319o.d(string3)).f();
                                        cursorE.close();
                                        this.f5585m = strF;
                                    }
                                }
                                cursorE.close();
                                strF = "";
                                this.f5585m = strF;
                            } finally {
                            }
                        } else {
                            strF = "";
                            this.f5585m = strF;
                        }
                    }
                } else {
                    this.f5585m = context.getString(R.string.messagelist_sender_self);
                }
                this.f5580h = 1;
                if (!z5 && V() && !this.f5591t) {
                    int i8 = this.f5587o;
                    if (i8 <= 0) {
                        int i9 = P0.r.f937c;
                        cursorE = com.android.mmt.util.O.e(context, context.getContentResolver(), Uri.withAppendedPath(Uri.withAppendedPath(Telephony.Mms.CONTENT_URI, "report-status-ext"), String.valueOf(j4)), new String[]{"delivery_status"}, null, null, null);
                        if (cursorE != null) {
                            try {
                                if (cursorE.moveToFirst()) {
                                    i8 = cursorE.getInt(0);
                                    cursorE.close();
                                } else {
                                    cursorE.close();
                                    i8 = 0;
                                }
                            } finally {
                            }
                        } else {
                            i8 = 0;
                        }
                    }
                    if (i8 == 0) {
                        this.f5580h = 1;
                    } else if (i8 != 134) {
                        switch (i8) {
                            case 128:
                                this.f5580h = 9;
                                break;
                            case 129:
                                this.f5580h = 6;
                                break;
                            case 130:
                                this.f5580h = 8;
                                break;
                            default:
                                this.f5580h = 3;
                                break;
                        }
                    }
                }
                this.p = this.f5567F;
                this.f5590s = "text/plain";
                this.f5568G = 0;
            }
            if (this.f5591t) {
                this.f5570I = this.p;
            }
        } else {
            throw new C0303b(D2.e.c("Unknown type of the message: ", str));
        }
        if (z5) {
            this.L = 11;
        }
        BackgroundCleaner.j().k(this);
    }
}
