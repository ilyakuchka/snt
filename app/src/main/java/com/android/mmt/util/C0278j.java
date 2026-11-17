package com.android.mmt.util;

import a.C0178a;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.MessagingPreferenceActivity;
import f0.C0303b;
import g0.C0309e;
import g0.C0310f;
import g0.C0312h;
import g0.C0319o;
import t.C0384b;
import x0.C0414a;

/* renamed from: com.android.mmt.util.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0278j {
    private static C0278j d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f6025a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f6026b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    private final SharedPreferences f6027c;

    /* renamed from: com.android.mmt.util.j$a */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(C0278j.this.f6025a, R.string.service_message_not_found, 1).show();
        }
    }

    /* renamed from: com.android.mmt.util.j$b */
    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f6029i;

        b(String str) {
            this.f6029i = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(C0278j.this.f6025a, this.f6029i, 1).show();
        }
    }

    private C0278j(Context context) {
        this.f6025a = context;
        this.f6027c = androidx.preference.g.c(context);
    }

    private boolean b(SharedPreferences sharedPreferences, boolean z4, long j2) throws NoSuchMethodException {
        boolean zA;
        if (sharedPreferences.getBoolean(C0287t.b(j2, "pref_key_mms_auto_retrieval"), true)) {
            if (!z4) {
                return true;
            }
            if (C0384b.j("PL")) {
                boolean z5 = sharedPreferences.getBoolean(C0287t.b(j2, "pref_key_mms_retrieval_during_national_roaming"), true);
                boolean z6 = sharedPreferences.getBoolean(C0287t.b(j2, "pref_key_mms_retrieval_during_international_roaming"), false);
                if (z5 && z6) {
                    return true;
                }
                if (!z5 && !z6) {
                    return false;
                }
                try {
                    zA = B.a(this.f6025a, (int) j2);
                } catch (SecurityException e2) {
                    A.f(e2);
                    zA = false;
                }
                if (zA) {
                    if (z5) {
                        return true;
                    }
                } else if (z6) {
                    return true;
                }
            } else if (sharedPreferences.getBoolean(C0287t.b(j2, "pref_key_mms_retrieval_during_roaming"), MessagingPreferenceActivity.O(j2))) {
                return true;
            }
        }
        return false;
    }

    public static C0278j c() {
        C0278j c0278j = d;
        if (c0278j != null) {
            return c0278j;
        }
        throw new IllegalStateException("Uninitialized.");
    }

    private String d(Uri uri) throws C0303b {
        String string;
        C0312h c0312h = (C0312h) C0319o.e(this.f6025a).h(uri);
        C0309e c0309eJ = c0312h.j();
        String strF = c0309eJ != null ? c0309eJ.f() : this.f6025a.getString(R.string.no_subject);
        C0309e c0309eG = c0312h.g();
        if (c0309eG != null) {
            C0414a c0414aO = C0414a.O(c0309eG.f());
            c0414aO.m0(true, true);
            string = c0414aO.U();
        } else {
            string = this.f6025a.getString(R.string.unknown_sender);
        }
        return this.f6025a.getString(R.string.dl_failure_notification, strF, string);
    }

    public static void e(Context context) {
        if (d != null) {
            Log.w("DownloadManager", "Already initialized.");
        }
        d = new C0278j(context.getApplicationContext());
    }

    private boolean g(long j2) {
        if (!C0287t.x()) {
            return "true".equals(S2.c.a("gsm.operator.isroaming", null));
        }
        int iQ = C0287t.q(j2);
        if (!C0287t.A(iQ)) {
            return false;
        }
        try {
            return C0178a.l(MmsApp.c(), (int) C0287t.m(iQ));
        } catch (SecurityException e2) {
            A.f(e2);
            return false;
        }
    }

    public final boolean f(long j2) {
        return b(this.f6027c, g(j2), j2);
    }

    public final void h(Uri uri, int i2, long j2) {
        try {
            C0310f c0310fH = C0319o.e(this.f6025a).h(uri);
            if (!(c0310fH instanceof C0312h)) {
                if (c0310fH == null) {
                    Log.e("DownloadManager", "pdu is not Notification ind");
                    return;
                }
                Log.e("DownloadManager", "pdu is not Notification ind for uri " + c0310fH.toString());
                return;
            }
            if (((C0312h) c0310fH).f() < System.currentTimeMillis() / 1000 && i2 == 129) {
                this.f6026b.post(new a());
                Context context = this.f6025a;
                O.c(context, context.getContentResolver(), uri, null, null);
                return;
            }
            if (i2 == 135) {
                try {
                    this.f6026b.post(new b(d(uri)));
                } catch (C0303b e2) {
                    Log.e("DownloadManager", e2.getMessage(), e2);
                }
            } else if (j2 >= 0 && C0287t.A(C0287t.q(j2)) && !b(this.f6027c, g(j2), j2)) {
                i2 |= 4;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("st", Integer.valueOf(i2));
            Context context2 = this.f6025a;
            O.g(context2, context2.getContentResolver(), uri, contentValues, null, null);
        } catch (C0303b e4) {
            Log.e("DownloadManager", e4.getMessage(), e4);
        }
    }
}
