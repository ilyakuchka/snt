package c;

import android.content.Context;
import android.net.Uri;
import android.provider.Telephony;

/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0227a {
    public static String a(String str) {
        return Telephony.Mms.extractAddrSpec(str);
    }

    public static boolean b(int i2) {
        return Telephony.Sms.isOutgoingFolder(i2);
    }

    public static boolean c(String str) {
        return Telephony.Mms.isPhoneNumber(str);
    }

    public static boolean d(Context context, Uri uri, int i2, int i4) {
        return Telephony.Sms.moveMessageToFolder(context, uri, i2, i4);
    }
}
