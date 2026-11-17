package com.android.mmt.transaction;

import P0.r;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.UserManager;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LongSparseArray;
import b.C0223a;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.ui.ComposeMessageRouterActivity;
import com.android.mmt.ui.MmsTabActivity;
import com.android.mmt.ui.NewMessagePopupActivity;
import com.android.mmt.util.C0271c;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0292y;
import com.android.mmt.util.O;
import g0.C0309e;
import g0.C0319o;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import r.C0374g;
import v.C0398e;
import v.C0399f;
import x0.C0414a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    private static HandlerThread f4602e;

    /* renamed from: f, reason: collision with root package name */
    private static Handler f4603f;

    /* renamed from: l, reason: collision with root package name */
    private static Object f4608l;

    /* renamed from: m, reason: collision with root package name */
    public static Uri f4609m;

    /* renamed from: n, reason: collision with root package name */
    private static Long f4610n;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4599a = {"thread_id", "date", "_id", "sub", "sub_cs", "sub_id"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f4600b = {"thread_id", "date", "_id", "subject", "body", "sub_id", "address"};

    /* renamed from: c, reason: collision with root package name */
    private static final C0090d f4601c = new C0090d();
    private static final Uri d = Uri.parse("content://mms-sms/undelivered");
    private static long g = 1000;

    /* renamed from: h, reason: collision with root package name */
    private static Ringtone f4604h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Runnable f4605i = new a();

    /* renamed from: j, reason: collision with root package name */
    private static long f4606j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static Object f4607k = new Object();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.f4604h != null) {
                if (d.f4604h.isPlaying()) {
                    d.f4603f.removeCallbacks(d.f4605i);
                    d.f4603f.postDelayed(d.f4605i, d.g);
                } else {
                    d.f4604h.stop();
                    Log.d("Mms:app", "ring tone need stop");
                    d.f4604h = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f4611a;

        /* renamed from: b, reason: collision with root package name */
        public int f4612b;

        public b(CharSequence charSequence, int i2) {
            this.f4611a = charSequence;
            this.f4612b = i2;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public Intent f4613a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f4614b;

        /* renamed from: c, reason: collision with root package name */
        public String f4615c;
        public int d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f4616e;

        /* renamed from: f, reason: collision with root package name */
        public long f4617f;
        public CharSequence g;

        /* renamed from: h, reason: collision with root package name */
        public V2.b f4618h;

        /* renamed from: i, reason: collision with root package name */
        public int f4619i;

        /* renamed from: j, reason: collision with root package name */
        public Uri f4620j;

        /* renamed from: k, reason: collision with root package name */
        public Object f4621k;

        /* renamed from: l, reason: collision with root package name */
        public Q2.b f4622l;

        public c(Intent intent, Intent intent2, String str, int i2, CharSequence charSequence, long j2, CharSequence charSequence2, V2.b bVar, int i4, Uri uri) {
            this.f4613a = intent;
            this.f4614b = intent2;
            this.f4615c = str;
            this.d = i2;
            this.f4616e = charSequence;
            this.f4617f = j2;
            this.g = charSequence2;
            this.f4618h = bVar;
            this.f4619i = i4;
            this.f4620j = uri;
            if (this.f4621k != null) {
                this.f4621k = null;
            } else {
                this.f4621k = f.a(uri.getLastPathSegment());
            }
            this.f4622l = e.a(uri.getLastPathSegment());
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(Context context) throws Resources.NotFoundException, SecurityException {
            if (!d.l(this.f4618h)) {
                d.d(context, this.f4613a, this.f4614b, this.f4615c, this.d, this.f4616e, this.f4617f, this.g, this.f4618h, this.f4619i, this.f4620j, (Q2.a) this.f4621k, this);
                return;
            }
            StringBuilder sbD = D2.e.d("deliver notification for threaId ");
            sbD.append(this.f4618h.f1766a);
            sbD.append(" but only play sms sound, package is:");
            this.f4618h.b();
            sbD.append("com.android.mmt");
            Log.d("Mms:app", sbD.toString());
            S2.e.a().post(new h(this, context));
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            boolean z4 = true;
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks.isEmpty()) {
                z4 = false;
            } else {
                ComponentName componentName = runningTasks.get(0).topActivity;
                if (!componentName.getPackageName().equals("com.android.mmt") || !componentName.getClassName().equals("com.android.mmt.ui.NewMessagePopupActivity")) {
                }
            }
            if (z4) {
                Uri uri = d.f4609m;
            }
            D0.a.a(d.f4606j);
        }
    }

    /* renamed from: com.android.mmt.transaction.d$d, reason: collision with other inner class name */
    private static final class C0090d implements Comparator<c> {
        C0090d() {
        }

        @Override // java.util.Comparator
        public final int compare(c cVar, c cVar2) {
            return Long.signum(cVar2.f4617f - cVar.f4617f);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static Map<String, Q2.b> f4623a = Collections.synchronizedMap(new HashMap());

        static Q2.b a(String str) {
            return f4623a.remove(str);
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private static Hashtable<String, Object> f4624a;

        static {
            new ArrayList();
            new AtomicInteger(979);
            new Hashtable();
            f4624a = new Hashtable<>();
        }

        static Object a(String str) {
            return f4624a.remove(str);
        }
    }

    static {
        new Hashtable();
        f4608l = new Object();
        new HashSet();
        f4610n = 0L;
    }

    public static void A(int i2) {
        x(MmsApp.c(), false, 0L, i2);
    }

    public static void B(long j2) {
        synchronized (f4607k) {
            Log.d("Mms:app", "set sCurrentMessageThreadId = " + j2);
            f4606j = j2;
        }
    }

    public static void C() {
        synchronized (f4608l) {
        }
    }

    public static void D() {
        int i2;
        Application applicationC = MmsApp.c();
        ContentResolver contentResolver = applicationC.getContentResolver();
        Uri uri = Telephony.Mms.Inbox.CONTENT_URI;
        StringBuilder sbD = D2.e.d("m_type=");
        sbD.append(String.valueOf(130));
        sbD.append(" AND ");
        sbD.append("st");
        sbD.append("=");
        sbD.append(String.valueOf(135));
        Cursor cursorE = O.e(applicationC, contentResolver, uri, null, sbD.toString(), null, null);
        if (cursorE == null) {
            i2 = 0;
        } else {
            int count = cursorE.getCount();
            cursorE.close();
            i2 = count;
        }
        if (i2 < 1) {
            r(531);
        }
    }

    public static void E() {
        if (v(MmsApp.c(), null) < 1) {
            r(789);
        }
    }

    public static void F(long j2) {
        long[] jArr = {0, 0};
        if (v(MmsApp.c(), jArr) <= 0 || jArr[0] != j2 || jArr[1] == 0) {
            return;
        }
        r(789);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0246  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void d(Context context, Intent intent, Intent intent2, String str, int i2, CharSequence charSequence, long j2, CharSequence charSequence2, V2.b bVar, int i4, Uri uri, Q2.a aVar, c cVar) throws Resources.NotFoundException, SecurityException {
        String str2;
        String quantityString;
        Intent intent3;
        int i5;
        Bundle bundle;
        int i6;
        boolean z4;
        boolean zEquals;
        Uri uriC;
        String string;
        StringBuilder sbD = D2.e.d("updateNotification  (null == itemExtra) = ");
        sbD.append(aVar == null);
        Log.i("Mms:app", sbD.toString());
        long j4 = bVar.f1766a;
        int iO = r.o((int) j4);
        v.g gVar = new v.g(context, O0.d.g().f(1, i4));
        C0414a c0414a = bVar.f1767b;
        if (c0414a != null && !TextUtils.isEmpty(c0414a.W()) && (uriC = bVar.c()) != null && (string = uriC.toString()) != null && !string.isEmpty()) {
            gVar.f7952q.add(string);
        }
        gVar.d();
        gVar.l(i2);
        gVar.o(charSequence);
        gVar.p(j2);
        gVar.k();
        if (bVar.f1767b != null) {
            intent.putExtra("FROM_WHERE", 1);
        }
        PendingIntent activity = PendingIntent.getActivity(context, iO, intent, 201326592, null);
        Bundle bundle2 = new Bundle();
        if (bVar.f1768c > 1) {
            Resources resources = context.getResources();
            str2 = "";
            int i7 = bVar.f1768c;
            quantityString = resources.getQuantityString(R.plurals.notification_multiple, i7, Integer.valueOf(i7));
            bundle2.putBoolean("miui.showAction", true);
        } else {
            str2 = "";
            bundle2.putBoolean("miui.expandableOnKeyguard", true);
            bundle2.putBoolean("miui.showAction", true);
            bundle2.putBoolean("miui.actionExpandable", true);
            quantityString = str2;
        }
        boolean z5 = intent2 != null && intent2.getBooleanExtra("showBody", true);
        String stringExtra = intent2 != null ? intent2.getStringExtra("from") : str2;
        gVar.e(activity);
        gVar.j();
        boolean z6 = z5 && aVar != null;
        Intent intent4 = new Intent(context, (Class<?>) NotificationAssistService.class);
        intent4.setPackage(context.getPackageName());
        intent4.putExtra("is_verification_code", z6);
        intent4.putExtra("extra_notification_id", iO);
        intent4.putExtra("extra_address", stringExtra);
        intent4.putExtra("function_type", "function_delete");
        intent4.putExtra("extra_threadid", j4);
        intent4.setData(uri);
        C0398e.a aVar2 = new C0398e.a(R.drawable.play_icon, context.getString(R.string.notification_delete), PendingIntent.getService(context, 2, intent4, 201326592));
        String str3 = quantityString + str;
        gVar.f(str3);
        gVar.g(charSequence2);
        Q2.b bVar2 = cVar.f4622l;
        if (z5 && i2 == R.drawable.stat_notify_sms) {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks.isEmpty()) {
                zEquals = false;
                if (zEquals) {
                    Intent intent5 = new Intent(context, (Class<?>) NotificationAssistService.class);
                    intent5.setPackage(context.getPackageName());
                    intent5.putExtra("extra_notification_id", iO);
                    intent5.putExtra("extra_address", stringExtra);
                    intent5.putExtra("function_type", "function_seen");
                    intent5.putExtra("extra_threadid", j4);
                    intent5.setData(uri);
                    gVar.a(new C0398e.a(R.drawable.stat_notify_sms, context.getString(R.string.notification_seen), PendingIntent.getService(context, 4, intent5, 201326592)).a());
                    gVar.a(aVar2.a());
                    intent3 = intent2;
                    gVar.a(new C0398e.a(R.drawable.stat_notify_sms, context.getString(R.string.quick_reply), PendingIntent.getActivity(context, 3, intent3, 201326592)).a());
                    C0399f c0399f = new C0399f();
                    c0399f.b(str3);
                    gVar.n(c0399f);
                    i5 = 0;
                    bundle = bundle2;
                }
            } else {
                ComponentName componentName = runningTasks.get(0).topActivity;
                ComponentName componentName2 = runningTasks.get(0).baseActivity;
                if ("com.android.mmt".equals(componentName.getPackageName())) {
                    String className = componentName.getClassName();
                    if (className.equals("com.android.mmt.ui.MessagingAdvancedPreferenceActivity") || className.equals("com.android.mmt.ui.MessagingPreferenceActivity") || className.equals("com.android.mmt.ui.ManageSimMessages") || className.equals("com.android.mmt.ui.MxPreferenceActivity") || (C0287t.x() && (className.equals("com.android.mmt.ui.SelectCardPreferenceActivity") || className.equals("com.android.mmt.ui.MultiSimPreferenceAcitvity")))) {
                        zEquals = "com.android.mmt".equals(componentName2.getPackageName());
                    } else if (!"com.android.mmt.ui.NewMessagePopupActivity".equals(className)) {
                        zEquals = true;
                    }
                    if (zEquals) {
                    }
                }
            }
        } else {
            intent3 = intent2;
            i5 = 0;
            bundle = bundle2;
            bundle.putBoolean("miui.actionExpandable", false);
        }
        gVar.i(bundle);
        Notification notificationB = gVar.b();
        notificationB.flags |= 1;
        notificationB.ledARGB = android.R.color.holo_red_light;
        int[] iArr = new int[2];
        iArr[i5] = 3000;
        iArr[1] = 4000 - iArr[i5];
        notificationB.ledOffMS = iArr[i5];
        notificationB.ledOnMS = iArr[1];
        if (O2.a.b()) {
            i6 = 2;
            notificationB.defaults = 2;
        } else {
            notificationB.defaults = i5;
            i6 = 2;
        }
        TextUtils.isEmpty(null);
        notificationB.flags |= 16;
        notificationB.sound = RingtoneManager.getActualDefaultRingtoneUri(context, i6);
        String str4 = str2;
        y(iO, notificationB, i4, bVar);
        if (intent3 != null) {
            String stringExtra2 = intent3.getStringExtra("from");
            int i8 = C0292y.f6056e;
            if (TextUtils.isEmpty(stringExtra2)) {
                Log.e("Mms_NumberUtils", "notifyIncomingSmsMmsToBracelet: context or address is null");
                z4 = false;
            } else {
                C0414a c0414aO = C0414a.O(stringExtra2);
                z4 = false;
                c0414aO.m0(false, false);
                String strW = c0414aO.W();
                Intent intent6 = new Intent("miui.sms.ACTION_ALARM");
                String strU = c0414aO.U();
                intent6.putExtra("number", strW);
                if (strU == null || !strU.equals(strW)) {
                    intent6.putExtra("contact", strU);
                } else {
                    intent6.putExtra("contact", str4);
                }
                context.sendBroadcast(intent6, "miui.permission.BLE_IMMEDIATE_ALERT");
            }
        } else {
            z4 = false;
        }
        if (System.currentTimeMillis() - androidx.preference.g.c(context).getLong("report_status_from_notification", 0L) <= 86400000 ? z4 : true) {
            androidx.preference.g.c(context).edit().putLong("report_status_from_notification", System.currentTimeMillis()).apply();
        }
    }

    static void e(Context context) throws IOException {
        if (((UserManager) C0.a.c().getSystemService(UserManager.class)).isQuietModeEnabled(Process.myUserHandle())) {
            Log.d("Mms:app", "enable Quiet mode or blockType is NONE_BUT_MUTE");
            return;
        }
        boolean z4 = true;
        if (f4609m == null) {
            boolean z5 = false;
            try {
                InputStream inputStreamOpenInputStream = C0.a.c().getContentResolver().openInputStream(Uri.parse("file:///product/media/audio/ui/MessageSent.ogg"));
                if (inputStreamOpenInputStream == null) {
                    z4 = false;
                }
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                z5 = z4;
            } catch (IOException unused) {
            }
            if (z5) {
                f4609m = Uri.parse("file:///product/media/audio/ui/MessageSent.ogg");
            } else {
                f4609m = Uri.parse("file:///system/media/audio/ui/MessageComplete.ogg");
            }
        }
        Ringtone ringtone = f4604h;
        if (ringtone != null) {
            ringtone.stop();
            Log.d("Mms:app", "ring tone need stop");
        }
        f4604h = null;
        Uri uri = f4609m;
        if (uri != null) {
            Ringtone ringtone2 = RingtoneManager.getRingtone(context, uri);
            f4604h = ringtone2;
            if (ringtone2 != null) {
                ringtone2.setStreamType(5);
                f4604h.play();
                f4603f.removeCallbacks(f4605i);
                f4603f.postDelayed(f4605i, g);
            }
        }
    }

    static void f(CharSequence charSequence, long j2) {
        synchronized (f4610n) {
            long j4 = System.currentTimeMillis() - f4610n.longValue() > j2 ? 0L : j2;
            f4610n = Long.valueOf(System.currentTimeMillis());
            S2.e.a().postDelayed(new g(charSequence, j2), j4);
        }
    }

    static b j(Context context, Uri uri) {
        Cursor cursorE;
        if (uri != null && (cursorE = O.e(context, context.getContentResolver(), uri, f4600b, null, null, null)) != null) {
            try {
                if (cursorE.moveToFirst()) {
                    String string = cursorE.getString(cursorE.getColumnIndexOrThrow("address"));
                    C0414a c0414aO = C0414a.O(string);
                    c0414aO.m0(true, true);
                    String strB0 = c0414aO.b0();
                    int iQ = C0287t.q(cursorE.getLong(cursorE.getColumnIndexOrThrow("sub_id")));
                    synchronized (c0414aO) {
                    }
                    if (!TextUtils.isEmpty(strB0)) {
                        string = strB0 + "(" + string + ")";
                    }
                    return new b(String.format(context.getString(R.string.delivery_toast_body), string), iQ);
                }
            } finally {
                cursorE.close();
            }
        }
        return null;
    }

    static void k(Context context, CharSequence charSequence, long j2, int i2) {
        synchronized (f4605i) {
            if (f4603f == null) {
                HandlerThread handlerThread = new HandlerThread("MessagingNotification WorkerThread", 10);
                f4602e = handlerThread;
                handlerThread.start();
                f4603f = new Handler(f4602e.getLooper());
            }
        }
        f4603f.post(new com.android.mmt.transaction.f(context, i2, charSequence, j2));
    }

    static boolean l(V2.b bVar) {
        boolean z4 = false;
        if (bVar instanceof V2.a) {
            synchronized (f4607k) {
                long j2 = bVar.f1766a;
                if (j2 > 0 && j2 == f4606j && (bVar instanceof V2.a)) {
                    z4 = true;
                }
            }
        }
        return z4;
    }

    public static void m() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        E();
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        D();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0389 A[LOOP:0: B:59:0x0234->B:108:0x0389, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03a0 A[LOOP:1: B:13:0x007a->B:112:0x03a0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x035b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0360  */
    @SuppressLint({"LogTagMismatch"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void n(Context context, long j2) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        String str;
        String str2;
        Uri uri;
        String str3;
        boolean z4;
        C0414a c0414aO;
        boolean z5;
        ArrayMap arrayMap;
        String strF;
        String str4;
        LongSparseArray longSparseArray;
        String str5;
        String str6;
        String str7;
        ArrayMap arrayMap2;
        String str8;
        boolean z6;
        boolean z7;
        c cVarU;
        boolean z8;
        c cVar;
        String str9;
        c cVarU2;
        c cVar2;
        ArrayMap arrayMap3;
        String string;
        String str10;
        LongSparseArray longSparseArray2;
        String str11;
        String str12;
        String str13;
        Context context2 = context;
        Log.i("Mms:app", "blockingUpdateMessageIndicator");
        TreeSet treeSet = new TreeSet(f4601c);
        LongSparseArray longSparseArray3 = new LongSparseArray();
        ArrayMap arrayMap4 = new ArrayMap();
        ContentResolver contentResolver = context.getContentResolver();
        String str14 = "(msg_box=1 AND read=0 AND (m_type=130 OR m_type=132))";
        String str15 = " AND ";
        String str16 = "thread_id";
        if (j2 != -1) {
            str14 = "(msg_box=1 AND read=0 AND (m_type=130 OR m_type=132)) AND thread_id=" + j2;
        }
        Cursor cursorE = O.e(context, contentResolver, Telephony.Mms.CONTENT_URI, f4599a, str14, null, "date desc");
        String str17 = "sub_id";
        String str18 = "date";
        String str19 = "_id";
        if (cursorE == null) {
            z5 = true;
            str2 = "_id";
            str = "thread_id";
            str3 = " AND ";
            z8 = z5;
            str8 = str18;
            str4 = str17;
            arrayMap2 = arrayMap4;
            longSparseArray = longSparseArray3;
            cVar = null;
            str5 = str;
            str6 = str2;
            str7 = str3;
        } else {
            try {
                if (cursorE.moveToFirst()) {
                    boolean zT = r.t(context);
                    boolean z9 = true;
                    c cVar3 = null;
                    while (true) {
                        c cVar4 = cVar3;
                        long j4 = cursor.getLong(cursor.getColumnIndexOrThrow(str16));
                        try {
                            if (longSparseArray3.indexOfKey(j4) >= 0) {
                                ((V2.b) longSparseArray3.get(j4)).f1768c++;
                                z7 = true;
                                str6 = str19;
                                str8 = str18;
                                cursor2 = cursor;
                                str4 = str17;
                                str7 = str15;
                                arrayMap2 = arrayMap4;
                                longSparseArray = longSparseArray3;
                                cVarU = cVar4;
                                str5 = str16;
                            } else {
                                str = str16;
                                str2 = str19;
                                Uri uriBuild = Telephony.Mms.CONTENT_URI.buildUpon().appendPath(Long.toString(cursor.getLong(cursor.getColumnIndexOrThrow(str19)))).build();
                                String strA = C0271c.a(context2, uriBuild);
                                C0414a c0414a = (C0414a) arrayMap4.get(strA);
                                if (c0414a == null) {
                                    uri = uriBuild;
                                    c0414aO = C0414a.O(strA);
                                    str3 = str15;
                                    c0414aO.m0(true, true);
                                    arrayMap4.put(strA, c0414aO);
                                    z4 = true;
                                } else {
                                    uri = uriBuild;
                                    str3 = str15;
                                    z4 = true;
                                    c0414aO = c0414a;
                                }
                                if (c0414aO.d0()) {
                                    cursor.close();
                                    z5 = z4;
                                    break;
                                }
                                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("sub"));
                                int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("sub_cs"));
                                if (TextUtils.isEmpty(string2)) {
                                    strF = "";
                                    arrayMap = arrayMap4;
                                } else {
                                    arrayMap = arrayMap4;
                                    strF = new C0309e(i2, C0319o.d(string2)).f();
                                }
                                long j5 = cursor.getLong(cursor.getColumnIndexOrThrow(str18)) * 1000;
                                if (!zT || TextUtils.isEmpty(strF)) {
                                    strF = context2.getString(R.string.new_message_arrived);
                                }
                                String str20 = str18;
                                V2.a aVar = new V2.a(j4, c0414aO, j5, strF);
                                longSparseArray3.put(j4, aVar);
                                if (z9) {
                                    str8 = str20;
                                    cursor2 = cursor;
                                    str4 = str17;
                                    str6 = str2;
                                    str7 = str3;
                                    longSparseArray = longSparseArray3;
                                    arrayMap2 = arrayMap;
                                    str5 = str;
                                    cVarU = u(c0414aO, strF, context, R.drawable.stat_notify_mms, aVar, j5, C0287t.q(cursor.getLong(cursor.getColumnIndexOrThrow(str17))), uri, zT);
                                    z7 = true;
                                } else {
                                    cursor2 = cursor;
                                    str4 = str17;
                                    longSparseArray = longSparseArray3;
                                    str5 = str;
                                    str6 = str2;
                                    str7 = str3;
                                    arrayMap2 = arrayMap;
                                    str8 = str20;
                                    z6 = z9;
                                    z7 = true;
                                    if (cursor2.moveToNext()) {
                                        cursor2.close();
                                        z8 = z7;
                                        cVar = cVar4;
                                        break;
                                    }
                                    LongSparseArray longSparseArray4 = longSparseArray;
                                    ArrayMap arrayMap5 = arrayMap2;
                                    context2 = context;
                                    z9 = z6;
                                    str16 = str5;
                                    arrayMap4 = arrayMap5;
                                    cursor = cursor2;
                                    longSparseArray3 = longSparseArray4;
                                    cVar3 = cVar4;
                                    str18 = str8;
                                    str17 = str4;
                                    str15 = str7;
                                    str19 = str6;
                                }
                            }
                            if (cursor2.moveToNext()) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2.close();
                            throw th;
                        }
                        cVar4 = cVarU;
                        z6 = false;
                    }
                } else {
                    z5 = true;
                    str2 = "_id";
                    str = "thread_id";
                    str3 = " AND ";
                    z8 = z5;
                    str8 = str18;
                    str4 = str17;
                    arrayMap2 = arrayMap4;
                    longSparseArray = longSparseArray3;
                    cVar = null;
                    str5 = str;
                    str6 = str2;
                    str7 = str3;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
            }
        }
        if (cVar != null) {
            treeSet.add(cVar);
        }
        if (j2 != -1) {
            str9 = "thread_id=" + j2;
        } else {
            str9 = null;
        }
        ContentResolver contentResolver2 = context.getContentResolver();
        String strA2 = !TextUtils.isEmpty(str9) ? C2.c.a("(type = 1 AND seen = 0)", str7, str9) : "(type = 1 AND seen = 0)";
        Log.i("Mms:app", "getSmsNewMessageNotificationInfo: where = " + strA2);
        cursorE = O.e(context, contentResolver2, Telephony.Sms.CONTENT_URI, f4600b, strA2, null, "date desc");
        if (cursorE == null) {
            Log.i("Mms:app", "getSmsNewMessageNotificationInfo: cursor is null");
        } else {
            try {
                if (cursorE.moveToFirst()) {
                    boolean zT2 = r.t(context);
                    cVarU2 = null;
                    C0414a c0414aO2 = null;
                    while (true) {
                        long j6 = cursorE.getLong(cursorE.getColumnIndexOrThrow(str5));
                        String str21 = str8;
                        long j7 = cursorE.getLong(cursorE.getColumnIndexOrThrow(str21));
                        String string3 = cursorE.getString(cursorE.getColumnIndexOrThrow("address"));
                        String string4 = cursorE.getString(cursorE.getColumnIndexOrThrow("body"));
                        if (z8) {
                            c0414aO2 = (C0414a) arrayMap2.get(string3);
                            if (c0414aO2 == null) {
                                c0414aO2 = C0414a.O(string3);
                                cVar2 = cVarU2;
                                c0414aO2.m0(true, true);
                                arrayMap2.put(string3, c0414aO2);
                            } else {
                                cVar2 = cVarU2;
                            }
                            if (c0414aO2.d0()) {
                                Log.i("Mms:app", "getSmsNewMessageNotificationInfo: send to voice mail");
                                break;
                            }
                        } else {
                            cVar2 = cVarU2;
                        }
                        C0414a c0414a2 = c0414aO2;
                        LongSparseArray longSparseArray5 = longSparseArray;
                        if (longSparseArray5.indexOfKey(j6) < 0 || ((V2.b) longSparseArray5.get(j6)).d < j7) {
                            String str22 = str6;
                            ArrayMap arrayMap6 = arrayMap2;
                            Uri uriBuild2 = Telephony.Sms.CONTENT_URI.buildUpon().appendPath(Long.toString(cursorE.getLong(cursorE.getColumnIndexOrThrow(str22)))).build();
                            if (!zT2 || TextUtils.isEmpty(string4)) {
                                arrayMap3 = arrayMap6;
                                string = context.getString(R.string.new_message_arrived);
                            } else {
                                string = string4;
                                arrayMap3 = arrayMap6;
                            }
                            V2.a aVar2 = new V2.a(j6, c0414a2, j7, string);
                            if (longSparseArray5.indexOfKey(j6) >= 0) {
                                str10 = str22;
                                aVar2.f1768c += ((V2.b) longSparseArray5.get(j6)).f1768c;
                            } else {
                                str10 = str22;
                            }
                            longSparseArray5.put(j6, aVar2);
                            if (z8) {
                                String str23 = str4;
                                str12 = str10;
                                longSparseArray2 = longSparseArray5;
                                str13 = str23;
                                str11 = str21;
                                cVarU2 = u(c0414a2, string, context, R.drawable.stat_notify_sms, aVar2, j7, C0287t.q(cursorE.getLong(cursorE.getColumnIndexOrThrow(str23))), uriBuild2, zT2);
                                if (cursorE.moveToNext()) {
                                    break;
                                }
                                str8 = str11;
                                c0414aO2 = c0414a2;
                                z8 = false;
                                arrayMap2 = arrayMap3;
                                str6 = str12;
                                longSparseArray = longSparseArray2;
                                str4 = str13;
                            } else {
                                longSparseArray2 = longSparseArray5;
                                str11 = str21;
                                str12 = str10;
                                str13 = str4;
                            }
                        } else {
                            ((V2.b) longSparseArray5.get(j6)).f1768c++;
                            Log.i("Mms:app", "filter dup threadId");
                            arrayMap3 = arrayMap2;
                            longSparseArray2 = longSparseArray5;
                            str11 = str21;
                            str13 = str4;
                            str12 = str6;
                        }
                        cVarU2 = cVar2;
                        if (cursorE.moveToNext()) {
                        }
                    }
                    if (cVarU2 != null) {
                        treeSet.add(cVarU2);
                    }
                    if (!treeSet.isEmpty()) {
                        Log.i("Mms:app", "blockingUpdateMessageIndicator: accumulator info is empty");
                        return;
                    }
                    if (Log.isLoggable("Mms:app", 2)) {
                        Log.d("Mms:app", "blockingUpdateNewMessageIndicator: isNewtrue");
                    }
                    c cVar5 = (c) treeSet.first();
                    if (cVar5 != null) {
                        cVar5.a(context);
                        return;
                    }
                    return;
                }
                Log.i("Mms:app", "getSmsNewMessageNotificationInfo: cursor is empty");
            } finally {
                cursorE.close();
            }
        }
        cVarU2 = null;
        if (cVarU2 != null) {
        }
        if (!treeSet.isEmpty()) {
        }
    }

    public static void o(long j2) throws Throwable {
        if (j2 > 0) {
            n(MmsApp.c(), j2);
        }
    }

    public static void p(long j2) {
        Log.d("newMessage", "block updater: false");
        if (j2 > 0) {
            n(MmsApp.c(), j2);
        }
    }

    public static void q() {
        ((NotificationManager) MmsApp.c().getSystemService("notification")).cancelAll();
    }

    public static void r(int i2) {
        ((NotificationManager) MmsApp.c().getSystemService("notification")).cancel(null, i2);
    }

    public static void s(long j2) {
        if (j2 > 0) {
            int iO = r.o((int) j2);
            for (int i2 : C0374g.c(3)) {
                r(C0374g.b(i2) + iO);
            }
        }
    }

    private static Intent t(Context context, V2.b bVar) {
        if (bVar.f1766a > 0) {
            return bVar.a(context);
        }
        Intent intent = new Intent(context, (Class<?>) MmsTabActivity.class);
        intent.setFlags(603979776);
        return intent;
    }

    private static c u(C0414a c0414a, String str, Context context, int i2, V2.b bVar, long j2, int i4, Uri uri, boolean z4) {
        Intent intent;
        CharSequence charSequence;
        Intent intentT = t(context, bVar);
        long j4 = bVar.f1766a;
        String strW = c0414a.W();
        if (TextUtils.isEmpty(strW)) {
            intent = null;
        } else {
            intent = new Intent(context, (Class<?>) NewMessagePopupActivity.class);
            intent.putExtra("from", strW);
            intent.putExtra("body", str);
            intent.putExtra("time", j2);
            intent.putExtra("slot_id", i4);
            intent.putExtra("showBody", z4);
            intent.putExtra("thread_id", j4);
            intent.setData(uri);
            intent.setFlags(872415232);
        }
        String strReplace = "";
        if (TextUtils.isEmpty(null)) {
            CharSequence string = context.getString(R.string.unknown_sender);
            if (TextUtils.isEmpty(strW)) {
                charSequence = string;
            } else {
                C0414a c0414a2 = bVar.f1767b;
                if (c0414a2 == null || TextUtils.isEmpty(c0414a2.b0())) {
                    string = PhoneNumberUtils.createTtsSpannable(strW);
                } else {
                    C0414a c0414a3 = bVar.f1767b;
                    if (c0414a3 == null || c0414a3.U() == null) {
                        charSequence = "";
                    } else {
                        string = bVar.f1767b.U().replace('\n', ' ').replace('\r', ' ');
                    }
                }
                charSequence = string;
            }
        } else {
            charSequence = null;
        }
        if (c0414a != null && c0414a.U() != null) {
            strReplace = c0414a.U().replace('\n', ' ').replace('\r', ' ');
        }
        StringBuilder sb = new StringBuilder(strReplace);
        sb.append(':');
        sb.append(' ');
        int length = sb.length();
        if (!TextUtils.isEmpty(null)) {
            throw null;
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str.replace('\n', ' ').replace('\r', ' '));
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new StyleSpan(1), 0, length, 33);
        return new c(intentT, intent, str, i2, spannableString, j2, charSequence, bVar, i4, uri);
    }

    private static int v(Context context, long[] jArr) {
        Cursor cursorE = O.e(context, context.getContentResolver(), d, new String[]{"thread_id"}, "read=0", null, null);
        if (cursorE == null) {
            return 0;
        }
        int count = cursorE.getCount();
        if (jArr != null) {
            try {
                if (cursorE.moveToFirst()) {
                    jArr[0] = cursorE.getLong(0);
                    if (jArr.length >= 2) {
                        long j2 = jArr[0];
                        while (true) {
                            if (!cursorE.moveToNext()) {
                                break;
                            }
                            if (cursorE.getLong(0) != j2) {
                                j2 = 0;
                                break;
                            }
                        }
                        jArr[1] = j2;
                    }
                }
            } finally {
                cursorE.close();
            }
        }
        return count;
    }

    public static void w(long j2) {
        x(MmsApp.c(), true, j2, 0);
    }

    private static void x(Context context, boolean z4, long j2, int i2) {
        String string;
        String string2;
        Intent intent;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        long[] jArr = {0, 1};
        int iV = v(context, jArr);
        if (iV != 0 || z4) {
            boolean z5 = jArr[1] != 0 || z4;
            v.g gVar = new v.g(context, O0.d.g().f(1, i2));
            if (iV > 1) {
                string2 = z4 ? context.getString(R.string.message_send_failed_title) : context.getString(R.string.notification_failed_multiple, Integer.toString(iV));
                string = z4 ? context.getString(R.string.message_download_failed_title) : context.getString(R.string.notification_failed_multiple_title);
            } else {
                string = z4 ? context.getString(R.string.message_download_failed_title) : context.getString(R.string.message_send_failed_title);
                string2 = context.getString(R.string.message_failed_body);
            }
            if (!z5) {
                intent = new Intent(context, (Class<?>) MmsTabActivity.class);
                intent.setFlags(603979776);
            } else if (z4) {
                intent = ComposeMessageRouterActivity.a(context, j2);
                intent.putExtra("failed_download_flag", true);
                intent.setAction("downloading_failed_action");
            } else {
                intent = ComposeMessageRouterActivity.a(context, jArr[0]);
                intent.putExtra("undelivered_flag", true);
                intent.setAction("sending_failed_action");
            }
            intent.addFlags(67108864);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592, null);
            gVar.l(R.drawable.stat_notify_sms_failed);
            gVar.o(string);
            gVar.g(string);
            gVar.f(string2);
            gVar.e(activity);
            gVar.m(RingtoneManager.getActualDefaultRingtoneUri(context, 2));
            Notification notificationB = gVar.b();
            if (!z4) {
                notificationManager.notify(null, 789, notificationB);
            } else {
                notificationB.flags |= 16;
                notificationManager.notify(null, 531, notificationB);
            }
        }
    }

    private static void y(int i2, Notification notification, int i4, V2.b bVar) {
        ((NotificationManager) MmsApp.c().getSystemService("notification")).notify(null, i2, notification);
        if (bVar != null) {
            try {
                Intent intent = new Intent("com.android.mmt.transaction.NotificationReceiver.NOTIFICATION_UPDATE");
                intent.putExtra("notificationId", i2);
                intent.putExtra("notification", notification);
                intent.putExtra("clickIntent", t(MmsApp.c(), bVar));
                intent.putExtra("slotId", i4);
                intent.setPackage(MmsApp.c().getPackageName());
                MmsApp.c().sendBroadcastAsUser(intent, C0223a.f4308a);
            } catch (Exception e2) {
                Log.e("Mms:app", " error sending broadcast", e2);
            }
        }
    }

    public static void z() {
        x(MmsApp.c(), false, 0L, 0);
    }
}
