package com.android.mmt.util;

import a.C0178a;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseLongArray;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.transaction.SmsReceiver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.android.mmt.util.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0287t {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6037a;

    /* renamed from: b, reason: collision with root package name */
    private static int f6038b;

    /* renamed from: c, reason: collision with root package name */
    private static SparseLongArray f6039c = new SparseLongArray();
    private static final SubscriptionManager d = SubscriptionManager.from(MmsApp.c());

    /* renamed from: e, reason: collision with root package name */
    private static final TelephonyManager f6040e = (TelephonyManager) MmsApp.c().getSystemService("phone");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f6041f = 0;

    /* renamed from: com.android.mmt.util.t$a */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(MmsApp.c(), MmsApp.c().getResources().getString(R.string.cannot_send_message_reason), 0).show();
        }
    }

    public static boolean A(int i2) {
        return i2 >= 0 && i2 < g();
    }

    public static boolean B(int i2) {
        if (i2 == 0 && c(1) != 0) {
            return false;
        }
        if (i2 == 1 && c(0) != 0) {
            return false;
        }
        if (i2 == -1) {
            return v();
        }
        return true;
    }

    public static boolean C() {
        return D(0) || D(1);
    }

    public static boolean D(int i2) {
        try {
            if (!A(i2)) {
                return false;
            }
            SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = d.getActiveSubscriptionInfoForSimSlotIndex(i2);
            return (activeSubscriptionInfoForSimSlotIndex != null || x()) ? activeSubscriptionInfoForSimSlotIndex != null : ((TelephonyManager) MmsApp.c().getSystemService(TelephonyManager.class)).hasIccCard();
        } catch (SecurityException e2) {
            A.f(e2);
            return false;
        }
    }

    public static boolean E(int i2) {
        String strO = o(i2);
        if (strO == null || !"100".equals(S2.c.a("persist.radio.ais_sim_lock", "")) || strO.startsWith("52003")) {
            return false;
        }
        Log.v("MSimUtils", "Ais card is locked");
        return true;
    }

    public static void F(int i2, PhoneStateListener phoneStateListener, int i4) {
        if (A(i2)) {
            try {
                f6040e.listen(phoneStateListener, i4);
            } catch (SecurityException e2) {
                A.f(e2);
            }
        }
    }

    public static boolean G(Context context, Uri uri, Long l2, Integer num) {
        if (uri == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", (Integer) 6);
        contentValues.put("read", (Integer) 0);
        if (l2 != null) {
            contentValues.put("out_time", l2);
        }
        if (num != null) {
            contentValues.put("status", num);
        }
        contentValues.put("error_code", (Integer) 0);
        return 1 == O.g(context, context.getContentResolver(), uri, contentValues, null, null);
    }

    public static void H(SubscriptionManager.OnSubscriptionsChangedListener onSubscriptionsChangedListener) {
        if (x()) {
            try {
                d.addOnSubscriptionsChangedListener(onSubscriptionsChangedListener);
            } catch (SecurityException e2) {
                A.f(e2);
            }
        }
    }

    public static void I(Context context, int i2) {
        if (i2 != Integer.MAX_VALUE) {
            J(context, i2, true);
            return;
        }
        int iG = g();
        for (int i4 = 0; i4 < iG; i4++) {
            J(context, i4, true);
        }
    }

    public static void J(Context context, int i2, boolean z4) {
        Intent intent = new Intent("com.android.mmt.transaction.SEND_MESSAGE", null, context, SmsReceiver.class);
        intent.addFlags(268435456);
        intent.putExtra("slot_id", i2);
        intent.putExtra("show_toast_when_offline", z4);
        Log.d("MSimUtils", "send queued message with broadcast with slotId " + i2);
        context.sendBroadcast(intent);
    }

    public static void K(Context context, int i2) {
        if (i2 != Integer.MAX_VALUE) {
            J(context, i2, false);
            return;
        }
        int iG = g();
        for (int i4 = 0; i4 < iG; i4++) {
            J(context, i4, false);
        }
    }

    public static void L(Context context, int i2) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName("com.android.phone", "com.android.phone.settings.SmscAddressSettingActivity");
        intent.putExtra("slot_id", i2);
        context.startActivity(intent);
    }

    public static void M(SubscriptionManager.OnSubscriptionsChangedListener onSubscriptionsChangedListener) {
        if (x()) {
            try {
                d.removeOnSubscriptionsChangedListener(onSubscriptionsChangedListener);
            } catch (SecurityException e2) {
                A.f(e2);
            }
        }
    }

    public static void N(boolean z4) {
        if (z4 || f6039c.size() <= 0) {
            y();
            int iD = d();
            synchronized (f6039c) {
                f6038b = iD;
            }
            long jM = m(0);
            synchronized (f6039c) {
                f6039c.clear();
                f6039c.put(0, jM);
            }
            if (x()) {
                long jM2 = m(1);
                synchronized (f6039c) {
                    f6039c.put(1, jM2);
                }
            }
        }
    }

    public static Uri a(Context context, Uri uri, String str, String str2, Long l2, boolean z4, long j2, long j4) {
        ContentValues contentValues = new ContentValues(7);
        contentValues.put("address", str);
        if (l2 != null) {
            contentValues.put("date", l2);
        }
        contentValues.put("read", (Integer) 1);
        contentValues.put("subject", (String) null);
        contentValues.put("body", str2);
        if (z4) {
            contentValues.put("status", (Integer) 32);
        }
        if (j2 != -1) {
            contentValues.put("thread_id", Long.valueOf(j2));
        }
        if (j4 != -1) {
            contentValues.put("sub_id", Long.valueOf(j4));
        }
        return O.d(context, context.getContentResolver(), uri, contentValues);
    }

    public static String b(long j2, String str) {
        if (!x()) {
            return str;
        }
        return Long.toString(j2) + "_" + str;
    }

    public static int c(int i2) {
        if (!A(i2)) {
            return 0;
        }
        try {
            return C0178a.d(MmsApp.c(), (int) m(i2));
        } catch (SecurityException e2) {
            A.f(e2);
            return 0;
        }
    }

    public static int d() {
        int activeSubscriptionInfoCount = 0;
        if (x()) {
            try {
                activeSubscriptionInfoCount = d.getActiveSubscriptionInfoCount();
            } catch (SecurityException e2) {
                A.f(e2);
            }
            if (activeSubscriptionInfoCount >= 0) {
                return activeSubscriptionInfoCount;
            }
            Log.e("MSimUtils", "getInsertedSimCount count < 0");
            return activeSubscriptionInfoCount;
        }
        try {
            int phoneCount = f6040e.getPhoneCount();
            int i2 = 0;
            for (int i4 = 0; i4 < phoneCount; i4++) {
                if (C0178a.k(MmsApp.c(), i4)) {
                    i2++;
                }
            }
            return i2;
        } catch (SecurityException e4) {
            A.f(e4);
            return 0;
        }
    }

    public static int e() {
        return f6038b;
    }

    public static int f() {
        if (!x()) {
            try {
                if (d.getActiveSubscriptionInfoForSimSlotIndex(0) == null) {
                    if (!f6040e.hasIccCard()) {
                        return -1;
                    }
                }
                return 0;
            } catch (SecurityException e2) {
                A.f(e2);
                return -1;
            }
        }
        for (int i2 = 0; i2 < g(); i2++) {
            try {
                if (d.getActiveSubscriptionInfoForSimSlotIndex(i2) != null) {
                    return i2;
                }
            } catch (SecurityException e4) {
                A.f(e4);
                return -1;
            }
        }
        return -1;
    }

    public static int g() {
        int phoneCount;
        try {
            phoneCount = f6040e.getPhoneCount();
        } catch (SecurityException e2) {
            A.f(e2);
            phoneCount = 0;
        }
        if (phoneCount < 0) {
            Log.e("MSimUtils", "getMultiSimCount count < 0");
        }
        return phoneCount;
    }

    public static long h(Context context, String str) {
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        return i(context, hashSet);
    }

    @SuppressLint({"NewApi"})
    public static long i(Context context, Set<String> set) {
        try {
            return Telephony.Threads.getOrCreateThreadId(context, set);
        } catch (IllegalArgumentException e2) {
            S2.e.a().post(new a());
            e2.printStackTrace();
            return -1L;
        } catch (SecurityException e4) {
            A.g(e4);
            return -1L;
        }
    }

    public static int j(int i2) {
        if (!A(i2)) {
            return 0;
        }
        try {
            return C0178a.e(MmsApp.c(), (int) m(i2));
        } catch (SecurityException e2) {
            A.f(e2);
            return 0;
        }
    }

    public static String k(int i2) {
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex;
        try {
            activeSubscriptionInfoForSimSlotIndex = d.getActiveSubscriptionInfoForSimSlotIndex(i2);
        } catch (SecurityException e2) {
            A.f(e2);
        }
        if (activeSubscriptionInfoForSimSlotIndex != null) {
            return activeSubscriptionInfoForSimSlotIndex.getDisplayName().toString();
        }
        if (x()) {
            Log.e("MSimUtils", "getSimDisplayName is empty");
        }
        return null;
    }

    public static int l(int i2) {
        if (x()) {
            if (i2 == 0) {
                return R.drawable.sim_card_1;
            }
            if (i2 == 1) {
                return R.drawable.sim_card_2;
            }
        }
        return 0;
    }

    public static long m(int i2) {
        long subscriptionId = -1;
        try {
            SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = d.getActiveSubscriptionInfoForSimSlotIndex(i2);
            if (activeSubscriptionInfoForSimSlotIndex != null) {
                subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
            } else if (!x()) {
                subscriptionId = 0;
            }
        } catch (SecurityException e2) {
            A.f(e2);
        }
        return subscriptionId;
    }

    public static String n(int i2) {
        String number = null;
        try {
            SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = d.getActiveSubscriptionInfoForSimSlotIndex(i2);
            if (activeSubscriptionInfoForSimSlotIndex != null) {
                number = activeSubscriptionInfoForSimSlotIndex.getNumber();
            } else if (x()) {
                Log.e("MSimUtils", "getSimNumber is empty");
            }
        } catch (SecurityException e2) {
            A.f(e2);
        }
        return number;
    }

    public static String o(int i2) {
        try {
            String strI = C0178a.i(MmsApp.c(), (int) m(i2));
            Log.v("MSimUtils", "getSimOperator oper is " + strI);
            return strI;
        } catch (SecurityException e2) {
            A.f(e2);
            return null;
        }
    }

    public static int p(List<Long> list) {
        HashSet hashSet = new HashSet();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            int iQ = q(it.next().longValue());
            if (A(iQ)) {
                hashSet.add(Integer.valueOf(iQ));
            }
        }
        int size = hashSet.size();
        int iIntValue = size >= g() ? Integer.MAX_VALUE : size == 1 ? ((Integer) hashSet.iterator().next()).intValue() : -1;
        hashSet.clear();
        return iIntValue;
    }

    public static int q(long j2) {
        if (!x()) {
            return 0;
        }
        try {
            SubscriptionInfo activeSubscriptionInfo = d.getActiveSubscriptionInfo((int) j2);
            if (activeSubscriptionInfo == null) {
                return -1;
            }
            return activeSubscriptionInfo.getSimSlotIndex();
        } catch (SecurityException e2) {
            A.f(e2);
            return -1;
        }
    }

    public static int r(long j2) {
        if (!x()) {
            return 0;
        }
        int iIndexOfValue = f6039c.indexOfValue(j2);
        if (iIndexOfValue >= 0) {
            return f6039c.keyAt(iIndexOfValue);
        }
        return -1;
    }

    public static int s(Bundle bundle) {
        int i2 = 0;
        if (x() && (i2 = bundle.getInt("slot_id", 0)) < 0) {
            Log.e("MSimUtils", "getSlotIdFromBundle slotId < 0");
        }
        return i2;
    }

    public static int t(Intent intent) {
        int intExtra;
        int i2;
        if (intent == null) {
            Log.e("MSimUtils", "getSlotIdFromIntent intent is null");
            return 0;
        }
        if (!x()) {
            return 0;
        }
        if (intent.hasExtra("slot_id")) {
            intExtra = intent.getIntExtra("slot_id", 0);
            i2 = 1;
        } else if (intent.hasExtra("android.telephony.extra.SLOT_INDEX")) {
            intExtra = intent.getIntExtra("android.telephony.extra.SLOT_INDEX", 0);
            i2 = 2;
        } else {
            i2 = 3;
            intExtra = 0;
        }
        Log.d("MSimUtils", "getSlotIdFromIntent: log_lcf_slotId_for_debug keyType:" + i2);
        try {
            throw new Exception("log_lcf_slotId_for_debug keytype:" + i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (intExtra < 0) {
                Log.e("MSimUtils", "getSlotIdFromIntent slotId < 0");
            }
            return intExtra;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SmsManager u(int i2) {
        SmsManager smsManagerForSubscriptionId;
        if (x()) {
            smsManagerForSubscriptionId = A(i2) ? SmsManager.getSmsManagerForSubscriptionId((int) m(i2)) : null;
        } else {
            if (i2 == 0) {
                smsManagerForSubscriptionId = SmsManager.getDefault();
            }
        }
        if (smsManagerForSubscriptionId == null) {
            Log.e("MSimUtils", "getSmsManager is null");
        }
        return smsManagerForSubscriptionId;
    }

    public static boolean v() {
        for (int i2 = 0; i2 < f6040e.getPhoneCount(); i2++) {
            try {
                if (c(i2) != 0) {
                    return false;
                }
            } catch (SecurityException e2) {
                A.f(e2);
                return true;
            }
        }
        return true;
    }

    public static boolean w(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 5 || !str.startsWith("460")) {
            return false;
        }
        String strSubstring = str.substring(3, 5);
        return TextUtils.equals(strSubstring, "03") || TextUtils.equals(strSubstring, "05") || TextUtils.equals(strSubstring, "11");
    }

    public static boolean x() {
        return g() > 1;
    }

    public static boolean y() {
        int activeSubscriptionInfoCount;
        if (x()) {
            try {
                activeSubscriptionInfoCount = d.getActiveSubscriptionInfoCount();
            } catch (SecurityException e2) {
                A.f(e2);
                activeSubscriptionInfoCount = 0;
            }
            if (activeSubscriptionInfoCount > 1) {
                synchronized (f6039c) {
                    f6037a = true;
                }
                return true;
            }
        }
        synchronized (f6039c) {
            f6037a = false;
        }
        return false;
    }

    public static boolean z() {
        return f6037a;
    }
}
