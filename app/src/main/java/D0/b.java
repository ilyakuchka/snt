package D0;

import L0.c;
import android.app.Application;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.ui.C0243g0;
import com.android.mmt.ui.C0247i0;
import com.android.mmt.util.O;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f80a;

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f81i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f82j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Uri f83k;

        a(long j2, int i2, Uri uri) {
            this.f81i = j2;
            this.f82j = i2;
            this.f83k = uri;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long j2 = this.f81i;
            int i2 = this.f82j;
            Uri uri = this.f83k;
            if (uri == null) {
                Cursor cursorE = O.e(MmsApp.c(), MmsApp.c().getContentResolver(), Telephony.MmsSms.CONTENT_DRAFT_URI, null, "thread_id=" + j2, null, null);
                if (cursorE != null && cursorE.getCount() > 0) {
                    Log.d("NewMessageInjector", "innerUpdateDraft: do nothing");
                    return;
                } else {
                    Log.d("NewMessageInjector", "innerUpdateDraft: deleteDraft");
                    L0.b.a(j2, true);
                    return;
                }
            }
            Cursor cursorE2 = O.e(MmsApp.c(), MmsApp.c().getContentResolver(), uri, null, null, null, null);
            if (cursorE2 != null) {
                try {
                    cursorE2.moveToFirst();
                    C0243g0 c0243g0 = new C0243g0(MmsApp.c(), c.c(i2), cursorE2, new C0247i0.c(cursorE2, false), 0);
                    L0.a aVar = new L0.a();
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
                        if (c0243g0.Z()) {
                            aVar.w(false);
                        }
                    }
                    BugleDatabase.y().x().F(aVar, true, 3);
                } catch (Exception e2) {
                    Log.e("NewMessageInjector", "onMessageSaveDraft", e2);
                }
            }
        }
    }

    public static void a(long j2, int i2, Uri uri) {
        Log.d("NewMessageInjector", "onMessageSaveDraft: " + j2 + " | " + i2 + " | " + uri);
        Q2.c.a(new a(j2, i2, uri));
    }

    public static void b(int i2, long j2) {
        long j4;
        L0.a aVarT;
        Log.d("NewMessageInjector", "onMessageSendFail: " + i2 + " | " + j2);
        Application applicationC = MmsApp.c();
        Uri uri = Telephony.Sms.CONTENT_URI;
        if (i2 != 0 && i2 == 1) {
            uri = Telephony.Mms.CONTENT_URI;
        }
        Cursor cursorE = O.e(applicationC, applicationC.getContentResolver(), ContentUris.withAppendedId(uri, j2), new String[]{"thread_id"}, null, null, null);
        if (cursorE != null) {
            try {
                j4 = cursorE.moveToNext() ? cursorE.getLong(0) : -1L;
            } finally {
                cursorE.close();
            }
        } else {
            j4 = -1;
        }
        if (j4 == -1 || (aVarT = BugleDatabase.y().x().t(j4)) == null) {
            return;
        }
        aVarT.t();
        BugleDatabase.y().x().F(aVarT, false, 5);
    }
}
