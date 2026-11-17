package P0;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import c.C0227a;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.ui.C0243g0;
import com.android.mmt.ui.G0;
import com.android.mmt.ui.I0;
import com.android.mmt.ui.NewMessageActivity;
import com.android.mmt.util.C0271c;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;
import f0.C0303b;
import g0.C0309e;
import g0.C0311g;
import g0.C0312h;
import g0.C0318n;
import g0.C0319o;
import g0.C0322r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f935a = {"address", "d_rpt", "rr"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f936b = {"address", "delivery_status", "read_status"};

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f937c = 0;

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f938i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Uri f939j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ContentValues f940k;

        a(Context context, Uri uri, ContentValues contentValues) {
            this.f938i = context;
            this.f939j = uri;
            this.f940k = contentValues;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = this.f938i;
            O.g(context, context.getContentResolver(), this.f939j, this.f940k, null, null);
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f941a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f942b;

        public b(String str, int i2) {
            this.f941a = str;
            this.f942b = i2 == 128;
        }

        public final String a() {
            return this.f941a;
        }

        public final boolean b() {
            return this.f942b;
        }
    }

    static final class c {

        /* renamed from: a, reason: collision with root package name */
        final int f943a;

        /* renamed from: b, reason: collision with root package name */
        final int f944b;

        public c(int i2, int i4) {
            this.f943a = i2;
            this.f944b = i4;
        }
    }

    static {
        Uri.parse("content://sms/mx_status");
        Uri.parse("content://sms/sent");
        Uri.parse("content://mms/sent");
    }

    private static void a(StringBuilder sb, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (sb.length() == 0) {
            sb.append(str);
        } else if (sb.charAt(sb.length() - 1) == '\n') {
            sb.append(str);
        } else {
            sb.append('\n');
            sb.append(str);
        }
    }

    public static boolean b(Context context) {
        if (TextUtils.isEmpty("com.google.android.apps.photos")) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo("com.google.android.apps.photos", 8192) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void c(Context context, List<C0243g0> list) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(l(list));
            Toast.makeText(context, R.string.copy_message_text_success, 0).show();
        } catch (Exception e2) {
            Log.e("Mms", "onContextItemSelected: copyMessageTextToClipboard items failed", e2);
        }
    }

    public static String d(Cursor cursor, int i2, int i4) {
        String string = cursor.getString(i2);
        int i5 = cursor.getInt(i4);
        return TextUtils.isEmpty(string) ? "" : i5 == 0 ? string : new C0309e(i5, C0319o.d(string)).f();
    }

    public static String e(String str, int i2) {
        return TextUtils.isEmpty(str) ? "" : i2 == 0 ? str : new C0309e(i2, C0319o.d(str)).f();
    }

    public static void f(Context context, List<C0243g0> list) {
        Intent intent = new Intent(context, (Class<?>) NewMessageActivity.class);
        intent.putExtra("forwarded_message", true);
        androidx.preference.g.c(context);
        if (list.size() <= 1) {
            C0243g0 c0243g0 = list.get(0);
            if (c0243g0.Z()) {
                intent.putExtra("sms_body", c0243g0.g());
                context.startActivity(intent);
                return;
            }
            String string = context.getString(R.string.forward_prefix);
            if (c0243g0.F() != null) {
                StringBuilder sbD = D2.e.d(string);
                sbD.append(c0243g0.F());
                string = sbD.toString();
            }
            intent.putExtra("msg_uri", c0243g0.v());
            intent.putExtra("subject", string);
            context.startActivity(intent);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (C0243g0 c0243g02 : list) {
            if (sb.length() > 0) {
                sb.append("\n\n");
            }
            if (c0243g02.Z()) {
                a(sb, c0243g02.g());
            } else {
                a(sb, c0243g02.F());
                G0 g0D = c0243g02.D();
                for (int i2 = 0; i2 < g0D.k(); i2++) {
                    I0 i0E = g0D.i(i2).e();
                    a(sb, i0E != null ? i0E.D() : null);
                }
            }
        }
        intent.putExtra("sms_body", sb.toString());
        context.startActivity(intent);
    }

    public static int g(SharedPreferences sharedPreferences) {
        int i2 = sharedPreferences.getBoolean("pref_key_delivery_reports", false) ? 20 : 0;
        long jM = C0287t.m(0);
        if (jM >= 0 && sharedPreferences.getBoolean(C0287t.b(jM, "pref_key_mms_read_reports"), false)) {
            i2 |= 1;
        }
        if (!C0287t.x()) {
            return i2;
        }
        long jM2 = C0287t.m(1);
        return (jM2 <= 0 || !sharedPreferences.getBoolean(C0287t.b(jM2, "pref_key_mms_read_reports"), false)) ? i2 : i2 | 2;
    }

    private static String h(long j2) {
        float f4 = j2;
        if (j2 < 1024) {
            return String.valueOf(f4) + "B";
        }
        if (j2 < 1048576) {
            return String.format(Locale.ENGLISH, "%.2f", Float.valueOf(f4 / 1024.0f)) + "KB";
        }
        return String.format(Locale.ENGLISH, "%.2f", Float.valueOf(f4 / 1048576.0f)) + "MB";
    }

    public static long i(String str, long j2) {
        return "mms".equals(str) ? -j2 : "rms".equals(str) ? (j2 * 2) + 1 : j2 * 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0398 A[LOOP:2: B:149:0x0392->B:151:0x0398, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String j(Context context, Cursor cursor, C0243g0 c0243g0) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        int length;
        ArrayList<b> arrayList;
        ArrayList<C0161g> arrayList2;
        ArrayMap arrayMap;
        c cVar;
        String strN;
        int i2;
        C0309e[] c0309eArrN;
        if (cursor == null) {
            return null;
        }
        if (!"mms".equals(cursor.getString(0))) {
            Log.d("Mms", "getTextMessageDetails");
            StringBuilder sb = new StringBuilder();
            Resources resources = context.getResources();
            sb.append(resources.getString(R.string.message_type_label));
            Objects.requireNonNull(c0243g0);
            sb.append(resources.getString(R.string.text_message));
            sb.append('\n');
            int i4 = cursor.getInt(8);
            if (C0227a.b(i4)) {
                sb.append(resources.getString(R.string.to_address_label));
            } else {
                sb.append(resources.getString(R.string.from_label));
            }
            sb.append(cursor.getString(3));
            if (i4 == 1) {
                long j2 = cursor.getLong(6);
                if (j2 > 0) {
                    sb.append('\n');
                    sb.append(resources.getString(R.string.sent_label));
                    sb.append(r(context, j2, false));
                }
            }
            sb.append('\n');
            if (i4 == 3) {
                sb.append(resources.getString(R.string.saved_label));
            } else if (i4 == 1) {
                sb.append(resources.getString(R.string.received_label));
            } else {
                sb.append(resources.getString(R.string.sent_label));
            }
            sb.append(r(context, cursor.getLong(5), false));
            if (i4 == 2) {
                long j4 = cursor.getLong(6);
                if (j4 > 0) {
                    sb.append('\n');
                    sb.append(resources.getString(R.string.received_label));
                    sb.append(r(context, j4, false));
                }
            }
            int i5 = cursor.getInt(11);
            if (i5 != 0 && i5 != -1) {
                sb.append('\n');
                sb.append(resources.getString(R.string.error_code_label));
                sb.append(i5);
            }
            if (!c0243g0.R()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("creator"));
                if (!TextUtils.isEmpty(string)) {
                    try {
                        applicationInfo = context.getPackageManager().getApplicationInfo(string, 0);
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                    CharSequence applicationLabel = applicationInfo != null ? context.getPackageManager().getApplicationLabel(applicationInfo) : null;
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        string = applicationLabel;
                    }
                    sb.append("\n");
                    sb.append(resources.getString(R.string.from_pkg_name));
                    sb.append((CharSequence) string);
                }
            }
            return sb.toString();
        }
        int i6 = cursor.getInt(17);
        if (i6 != 128) {
            if (i6 == 130) {
                return p(context, cursor);
            }
            if (i6 != 132) {
                Log.w("Mms", "No details could be retrieved.");
                return "";
            }
        }
        if (cursor.getInt(17) == 130) {
            return p(context, cursor);
        }
        StringBuilder sb2 = new StringBuilder();
        Resources resources2 = context.getResources();
        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, cursor.getLong(1));
        try {
            C0311g c0311g = (C0311g) C0319o.e(context.getApplicationContext()).h(uriWithAppendedId);
            sb2.append(resources2.getString(R.string.message_type_label));
            Objects.requireNonNull(c0243g0);
            sb2.append(resources2.getString(R.string.multimedia_message));
            if (c0311g instanceof C0322r) {
                C0309e c0309eN = ((C0322r) c0311g).n();
                String strF = c0309eN != null ? c0309eN.f() : "";
                sb2.append('\n');
                sb2.append(resources2.getString(R.string.from_label));
                if (TextUtils.isEmpty(strF)) {
                    strF = resources2.getString(R.string.hidden_sender_address);
                }
                sb2.append(strF);
            }
            C0309e[] c0309eArrI = c0311g.i();
            if (c0309eArrI == null || c0309eArrI.length <= 0) {
                Log.w("Mms", "recipient list is empty!");
            } else {
                sb2.append('\n');
                sb2.append(resources2.getString(R.string.to_address_label));
                sb2.append(C0309e.b(c0309eArrI));
            }
            boolean z4 = c0311g instanceof g0.t;
            if (z4 && (c0309eArrN = ((g0.t) c0311g).n()) != null && c0309eArrN.length > 0) {
                sb2.append('\n');
                sb2.append(resources2.getString(R.string.bcc_label));
                sb2.append(C0309e.b(c0309eArrN));
            }
            int i7 = cursor.getInt(8);
            if (i7 == 1 && c0243g0.n() > 0) {
                sb2.append('\n' + resources2.getString(R.string.sent_label));
                sb2.append(r(context, c0243g0.n(), false));
            }
            sb2.append('\n');
            if (i7 == 3) {
                sb2.append(resources2.getString(R.string.saved_label));
            } else if (i7 == 1) {
                sb2.append(resources2.getString(R.string.received_label));
            } else {
                sb2.append(resources2.getString(R.string.sent_label));
            }
            sb2.append(r(context, c0311g.f() * 1000, false));
            C0309e c0309eH = c0311g.h();
            if (c0309eH == null || TextUtils.isEmpty(c0309eH.f())) {
                length = 0;
            } else {
                sb2.append('\n');
                sb2.append(resources2.getString(R.string.subject_label));
                String strF2 = c0309eH.f();
                length = strF2.length() + 0;
                sb2.append(strF2);
            }
            sb2.append('\n');
            sb2.append(resources2.getString(R.string.priority_label));
            int iG = c0311g.g();
            Resources resources3 = context.getResources();
            sb2.append(iG != 128 ? iG != 130 ? resources3.getString(R.string.priority_normal) : resources3.getString(R.string.priority_high) : resources3.getString(R.string.priority_low));
            int iH = c0243g0.D().h() + length;
            sb2.append('\n');
            sb2.append(resources2.getString(R.string.message_size_label));
            sb2.append(((iH - 1) / 1024) + 1);
            sb2.append(" KB");
            if (z4 && c0243g0.U() && c0243g0.p() != 1) {
                Cursor cursorE = O.e(context, context.getContentResolver(), Uri.withAppendedPath(Telephony.Mms.REPORT_REQUEST_URI, String.valueOf(c0243g0.z())), f935a, null, null, null);
                if (cursorE == null) {
                    arrayList = null;
                    if (arrayList != null || arrayList.size() == 0) {
                        arrayList2 = null;
                    } else {
                        cursorE = O.e(context, context.getContentResolver(), Uri.withAppendedPath(Telephony.Mms.REPORT_STATUS_URI, String.valueOf(c0243g0.z())), f936b, null, null, null);
                        if (cursorE != null) {
                            arrayMap = null;
                        } else {
                            try {
                                arrayMap = new ArrayMap();
                                while (cursorE.moveToNext()) {
                                    String string2 = cursorE.getString(0);
                                    arrayMap.put(S2.d.h(string2) ? C0227a.a(string2) : PhoneNumberUtils.stripSeparators(string2), new c(cursorE.getInt(1), cursorE.getInt(2)));
                                }
                                cursorE.close();
                            } finally {
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        for (b bVar : arrayList) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(context.getString(R.string.status_label));
                            if (arrayMap == null) {
                                strN = context.getString(R.string.status_pending);
                            } else {
                                String strA = bVar.a();
                                String strA2 = S2.d.h(strA) ? C0227a.a(strA) : PhoneNumberUtils.stripSeparators(strA);
                                Iterator it = arrayMap.keySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        cVar = null;
                                        break;
                                    }
                                    String str = (String) it.next();
                                    if (!S2.d.h(strA2)) {
                                        if (PhoneNumberUtils.compare(str, strA2)) {
                                            cVar = (c) arrayMap.get(str);
                                            break;
                                        }
                                    } else {
                                        if (TextUtils.equals(str, strA2)) {
                                            cVar = (c) arrayMap.get(str);
                                            break;
                                        }
                                    }
                                    sb3.append(strN);
                                    arrayList3.add(new C0161g(context.getString(R.string.recipient_label) + bVar.a(), sb3.toString()));
                                }
                                if (cVar == null) {
                                    strN = context.getString(R.string.status_pending);
                                } else {
                                    if (bVar.b() && (i2 = cVar.f944b) != 0) {
                                        if (i2 == 128) {
                                            strN = context.getString(R.string.status_read);
                                        } else if (i2 == 129) {
                                            strN = context.getString(R.string.status_unread);
                                        }
                                        sb3.append(strN);
                                        arrayList3.add(new C0161g(context.getString(R.string.recipient_label) + bVar.a(), sb3.toString()));
                                    }
                                    strN = n(context, cVar.f943a);
                                    sb3.append(strN);
                                    arrayList3.add(new C0161g(context.getString(R.string.recipient_label) + bVar.a(), sb3.toString()));
                                }
                            }
                            sb3.append(strN);
                            arrayList3.add(new C0161g(context.getString(R.string.recipient_label) + bVar.a(), sb3.toString()));
                        }
                        arrayList2 = arrayList3;
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        sb2.append('\n');
                        sb2.append(resources2.getString(R.string.delivery_report_activity));
                        for (C0161g c0161g : arrayList2) {
                            sb2.append('\n');
                            sb2.append(c0161g.f920a);
                            sb2.append(", ");
                            sb2.append(c0161g.f921b);
                        }
                    }
                } else {
                    try {
                        if (cursorE.getCount() <= 0) {
                            cursorE.close();
                            arrayList = null;
                            if (arrayList != null) {
                                cursorE = O.e(context, context.getContentResolver(), Uri.withAppendedPath(Telephony.Mms.REPORT_STATUS_URI, String.valueOf(c0243g0.z())), f936b, null, null, null);
                                if (cursorE != null) {
                                }
                                ArrayList arrayList32 = new ArrayList();
                                while (r0.hasNext()) {
                                }
                                arrayList2 = arrayList32;
                                if (arrayList2 != null) {
                                    sb2.append('\n');
                                    sb2.append(resources2.getString(R.string.delivery_report_activity));
                                    while (r0.hasNext()) {
                                    }
                                }
                            }
                        } else {
                            arrayList = new ArrayList();
                            while (cursorE.moveToNext()) {
                                String string3 = cursorE.getString(0);
                                cursorE.getInt(1);
                                arrayList.add(new b(string3, cursorE.getInt(2)));
                            }
                            if (arrayList != null) {
                            }
                        }
                    } finally {
                    }
                }
            }
            return sb2.toString();
        } catch (C0303b e4) {
            Log.e("Mms", "Failed to load the message: " + uriWithAppendedId, e4);
            return context.getResources().getString(R.string.cannot_get_details);
        }
    }

    public static String k(CharSequence charSequence) {
        int[] iArrCalculateLength = SmsMessage.calculateLength(charSequence, MmsApp.f4463s);
        int i2 = iArrCalculateLength[0];
        int i4 = iArrCalculateLength[2];
        if (i2 <= 1) {
            return String.valueOf(i4);
        }
        return i4 + "(" + i2 + ")";
    }

    public static String l(List<C0243g0> list) {
        StringBuilder sb = new StringBuilder();
        for (C0243g0 c0243g0 : list) {
            if (c0243g0.Z()) {
                a(sb, c0243g0.g());
            } else {
                a(sb, c0243g0.F());
                G0 g0D = c0243g0.D();
                for (int i2 = 0; i2 < g0D.k(); i2++) {
                    I0 i0E = g0D.i(i2).e();
                    a(sb, i0E != null ? i0E.D() : null);
                }
            }
        }
        return sb.toString();
    }

    public static int m(Uri uri) {
        if (uri != null) {
            Cursor cursorE = O.e(MmsApp.c(), MmsApp.c().getContentResolver(), uri, new String[]{"thread_id"}, null, null, null);
            if (cursorE != null) {
                try {
                    if (cursorE.moveToFirst()) {
                        return BugleDatabase.y().x().u(cursorE.getLong(0)) != null ? 3 : 0;
                    }
                } finally {
                    cursorE.close();
                }
            }
        }
        return 0;
    }

    public static String n(Context context, int i2) {
        return i2 != 0 ? (i2 == 134 || i2 == 129) ? context.getString(R.string.status_received) : i2 != 130 ? context.getString(R.string.status_failed) : context.getString(R.string.status_rejected) : context.getString(R.string.status_pending);
    }

    public static int o(int i2) {
        return (i2 * 5) + 1000 + 0;
    }

    private static String p(Context context, Cursor cursor) throws Resources.NotFoundException {
        StringBuilder sb = new StringBuilder();
        Resources resources = context.getResources();
        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, cursor.getLong(1));
        try {
            C0312h c0312h = (C0312h) C0319o.e(context.getApplicationContext()).h(uriWithAppendedId);
            sb.append(resources.getString(R.string.message_type_label));
            sb.append(resources.getString(R.string.multimedia_notification));
            C0309e c0309eG = c0312h.g();
            String strF = c0309eG != null ? c0309eG.f() : "";
            sb.append('\n');
            sb.append(resources.getString(R.string.from_label));
            if (TextUtils.isEmpty(strF)) {
                strF = resources.getString(R.string.hidden_sender_address);
            }
            sb.append(strF);
            sb.append('\n');
            sb.append(resources.getString(R.string.expire_on, r(context, c0312h.f() * 1000, false)));
            C0309e c0309eJ = c0312h.j();
            if (c0309eJ != null && !TextUtils.isEmpty(c0309eJ.f())) {
                sb.append('\n');
                sb.append(resources.getString(R.string.subject_label));
                sb.append(c0309eJ.f());
            }
            sb.append('\n');
            sb.append(resources.getString(R.string.message_class_label));
            sb.append(new String(c0312h.h()));
            sb.append('\n');
            sb.append(resources.getString(R.string.message_size_label));
            sb.append(String.valueOf((c0312h.i() + 1023) / 1024));
            sb.append(context.getString(R.string.kilobyte));
            return sb.toString();
        } catch (C0303b e2) {
            Log.e("Mms", "Failed to load the message: " + uriWithAppendedId, e2);
            return context.getResources().getString(R.string.cannot_get_details);
        }
    }

    public static String q(Context context, long j2) {
        return s(context, j2, true, 0, true);
    }

    public static String r(Context context, long j2, boolean z4) {
        return s(context, j2, z4, 0, false);
    }

    private static String s(Context context, long j2, boolean z4, int i2, boolean z5) {
        int i4 = i2 | 33676;
        if (z4) {
            C3.a aVar = new C3.a();
            int iO = aVar.o(1);
            int iO2 = aVar.o(12);
            aVar.A(j2);
            boolean z6 = iO == aVar.o(1);
            if (z6) {
                i4 &= -513;
            }
            if (z5 && iO2 == aVar.o(12) && z6) {
                i4 &= -897;
            }
        }
        return C3.c.a(context, j2, i4);
    }

    public static boolean t(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "pref_key_enable_notification_body", 1) == 1;
    }

    public static String u(String str, String str2, int i2, int i4) {
        String str3;
        String strReplaceAll = str.replaceAll("\\s+", " ");
        if (strReplaceAll.length() <= i2) {
            return strReplaceAll;
        }
        int iIndexOf = strReplaceAll.indexOf(str2);
        int iMax = Math.max(i4, i2 - str2.length());
        int iMin = Math.min(iIndexOf, iMax / 2);
        int i5 = iIndexOf - iMin;
        int iMin2 = Math.min(iMax - iMin, (strReplaceAll.length() - str2.length()) - iIndexOf);
        int length = str2.length() + iIndexOf + iMin2;
        String str4 = "…";
        if (i5 != 0) {
            i5++;
            str3 = "…";
        } else {
            str3 = "";
        }
        if (length != strReplaceAll.length()) {
            length--;
        } else {
            str4 = "";
        }
        if (length > strReplaceAll.length()) {
            Log.e("Mms", "limit=" + i2 + " minR" + i4 + " pos=" + iIndexOf + " remaining=" + iMax + " leftRemaining=" + iMin + " leftPos=" + i5 + " rightRemaining=" + iMin2 + " rightPos=" + length);
        }
        StringBuilder sbD = D2.e.d(str3);
        sbD.append(strReplaceAll.substring(i5, length));
        sbD.append(str4);
        return sbD.toString();
    }

    public static String v(Context context) {
        int count;
        ContentResolver contentResolver = context.getContentResolver();
        Resources resources = context.getResources();
        StringBuilder sb = new StringBuilder();
        Cursor cursorE = O.e(context, contentResolver, Telephony.Mms.CONTENT_URI, new String[]{"_id", "m_size"}, "m_type != 134 AND deleted = 0", null, null);
        long j2 = 0;
        if (cursorE != null) {
            try {
                int count2 = cursorE.getCount();
                if (cursorE.moveToFirst()) {
                    do {
                        j2 += cursorE.getInt(1);
                    } while (cursorE.moveToNext());
                }
                cursorE.close();
                count = count2;
            } finally {
            }
        } else {
            count = 0;
        }
        sb.append(resources.getString(R.string.storage_dialog_mms, Integer.valueOf(count)));
        sb.append("\n");
        sb.append(resources.getString(R.string.storage_dialog_mms_size) + h(j2));
        sb.append("\n");
        long[] jArr = new long[2];
        cursorE = O.e(context, context.getContentResolver(), Uri.parse("content://mms/part-size/"), null, "mid IN (select _id from pdu where deleted = 0)", null, null);
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    int columnIndex = cursorE.getColumnIndex("size");
                    if (columnIndex > -1) {
                        jArr[0] = cursorE.getLong(columnIndex);
                    }
                    int columnIndex2 = cursorE.getColumnIndex("db-size");
                    if (columnIndex2 > -1) {
                        jArr[1] = cursorE.getLong(columnIndex2);
                    }
                }
                cursorE.close();
            } finally {
            }
        }
        sb.append(resources.getString(R.string.storage_dialog_attachments) + h(jArr[0]));
        sb.append("\n");
        cursorE = O.e(context, contentResolver, Telephony.Sms.CONTENT_URI, new String[]{"_id"}, "deleted = 0", null, null);
        if (cursorE != null) {
            try {
                count = cursorE.getCount();
            } finally {
            }
        }
        sb.append(resources.getString(R.string.storage_dialog_sms, Integer.valueOf(count)));
        sb.append("\n");
        sb.append(resources.getString(R.string.storage_dialog_database) + h(jArr[1]));
        sb.append("\n");
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        sb.append(resources.getString(R.string.storage_dialog_available_space) + h(((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())));
        return sb.toString();
    }

    private static File w(String str, String str2) {
        File file = new File(C2.c.a(str, ".", str2));
        int i2 = 2;
        while (file.exists()) {
            file = new File(str + "_" + i2 + "." + str2);
            i2++;
        }
        return file;
    }

    public static void x(Context context, Collection collection, Runnable runnable) {
        String str = "m_type = 132 AND read = 0 AND rr = 128";
        if (collection != null) {
            str = "m_type = 132 AND read = 0 AND rr = 128 AND thread_id IN (" + TextUtils.join(",", collection) + ")";
        }
        Cursor cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.Inbox.CONTENT_URI, new String[]{"_id", "m_id", "sub_id"}, str, null, null);
        if (cursorE == null) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        try {
            if (cursorE.getCount() == 0) {
                runnable.run();
                return;
            }
            while (cursorE.moveToNext()) {
                arrayMap.put(cursorE.getString(1), C0271c.a(context, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, cursorE.getLong(0))));
                arrayMap2.put(cursorE.getString(1), Long.valueOf(cursorE.getLong(2)));
            }
            cursorE.close();
            S2.e.a().post(new q(context, new n(arrayMap, context, arrayMap2, runnable), new o(runnable), new p(runnable)));
        } finally {
            cursorE.close();
        }
    }

    public static void y(Context context, String str, long j2, boolean z4) {
        Uri uriWithAppendedId = ContentUris.withAppendedId("sms".equals(str) ? Telephony.Sms.CONTENT_URI : Telephony.Mms.CONTENT_URI, j2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("locked", Integer.valueOf(z4 ? 1 : 0));
        Q2.c.a(new a(context, uriWithAppendedId, contentValues));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.ContentResolver] */
    public static String z(Context context, C0318n c0318n, String str) throws Throwable {
        ?? r11;
        FileOutputStream fileOutputStream;
        File fileW;
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        ?? I2 = c0318n.i();
        InputStream inputStream = null;
        try {
            try {
                I2 = context.getContentResolver().openInputStream(I2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
            I2 = 0;
        } catch (Throwable th2) {
            th = th2;
            r11 = 0;
            S2.d.c(inputStream);
            S2.d.d(r11);
            throw th;
        }
        try {
            if (I2 instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) I2;
                byte[] bArrJ = c0318n.j();
                if (bArrJ == null) {
                    bArrJ = c0318n.e();
                }
                if (bArrJ == null) {
                    bArrJ = c0318n.k();
                }
                String strReplaceAll = bArrJ == null ? str : new String(bArrJ).replaceAll("[?|*|:]", "_");
                int iLastIndexOf = strReplaceAll.lastIndexOf(47);
                if (iLastIndexOf >= 0) {
                    strSubstring = str;
                    if (iLastIndexOf < strReplaceAll.length() - 1) {
                        strSubstring = strReplaceAll.substring(iLastIndexOf + 1);
                    }
                } else {
                    strSubstring = strReplaceAll;
                }
                int iIndexOf = strSubstring.indexOf(".");
                if (iIndexOf == -1) {
                    strSubstring2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(new String(c0318n.g()));
                    strSubstring3 = strSubstring;
                } else {
                    strSubstring2 = strSubstring.substring(iIndexOf + 1, strSubstring.length());
                    strSubstring3 = strSubstring.substring(0, iIndexOf);
                }
                fileW = w((Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS + "/") + strSubstring3, strSubstring2);
                File parentFile = fileW.getParentFile();
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    Log.e("Mms", "[MMS] copyPart: mkdirs for " + parentFile.getPath() + " failed!");
                    S2.d.c(I2);
                    return null;
                }
                fileOutputStream = new FileOutputStream(fileW);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                } catch (IOException e4) {
                    e = e4;
                    Log.e("Mms", "IOException caught while opening or reading stream", e);
                    S2.d.c(I2);
                    S2.d.d(fileOutputStream);
                    return null;
                }
            } else {
                fileW = null;
                fileOutputStream = null;
            }
            S2.d.c(I2);
            S2.d.d(fileOutputStream);
            if (fileW == null) {
                return null;
            }
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(fileW)));
            return fileW.getPath();
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
            inputStream = I2;
            r11 = str;
            S2.d.c(inputStream);
            S2.d.d(r11);
            throw th;
        }
    }
}
