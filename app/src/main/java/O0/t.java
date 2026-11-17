package O0;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import c.C0227a;
import com.android.mmt.MmsApp;
import com.android.mmt.transaction.MessageStatusReceiver;
import com.android.mmt.transaction.SmsReceiver;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0292y;
import e0.C0298a;
import f0.C0303b;
import java.util.ArrayList;
import x0.C0416c;

/* loaded from: classes.dex */
public final class t extends s {

    /* renamed from: l, reason: collision with root package name */
    private final boolean f834l;

    /* renamed from: m, reason: collision with root package name */
    private String f835m;

    /* renamed from: n, reason: collision with root package name */
    private Uri f836n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f837o;

    public t(Context context, String str, String str2, long j2, boolean z4, Uri uri, int i2, boolean z5) {
        super(context, null, str2, j2, 0L, i2);
        this.f834l = z4;
        this.f835m = str;
        this.f836n = uri;
        this.f837o = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<String> b(String str) throws ClassNotFoundException {
        ArrayList<String> arrayListDivideMessage;
        String str2;
        if (MmsApp.f4463s) {
            W2.a.a("SmsSingleRecipientSender", "divideMessage sUseGsmAlphabet is true");
            boolean z4 = C0287t.j(this.f833i) == 2;
            W2.a.a("SmsSingleRecipientSender", "divideMessage useCdma is " + z4);
            W2.a.f("SmsSingleRecipientSender", "divideMessage useCdma is " + z4);
            int[] iArrCalculateLength = SmsMessage.calculateLength(str, true);
            arrayListDivideMessage = null;
            if (iArrCalculateLength[3] == 1) {
                W2.a.f("SmsSingleRecipientSender", "divideMessage encoding 7bit");
                int i2 = (iArrCalculateLength[4] == 0 || iArrCalculateLength[5] == 0) ? (iArrCalculateLength[4] == 0 && iArrCalculateLength[5] == 0) ? 0 : 4 : 7;
                if (iArrCalculateLength[0] > 1) {
                    i2 += 6;
                }
                if (i2 != 0) {
                    i2++;
                }
                int i4 = 160 - i2;
                try {
                    Class<?> cls = Class.forName("com.android.internal.telephony.Sms7BitEncodingTranslator");
                    try {
                        str2 = (String) cls.getDeclaredMethod("translate", CharSequence.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z4));
                    } catch (NoSuchMethodException e2) {
                        try {
                            str2 = (String) cls.getDeclaredMethod("translate", CharSequence.class).invoke(null, str);
                        } catch (Exception unused) {
                            W2.a.b("SmsSingleRecipientSender", "sms7BitEncodingTranslate e" + e2);
                            str2 = null;
                            if (TextUtils.isEmpty(str2)) {
                            }
                            if (arrayListDivideMessage == null) {
                            }
                            return arrayListDivideMessage;
                        }
                    } catch (Exception e4) {
                        W2.a.b("SmsSingleRecipientSender", "sms7BitEncodingTranslate e" + e4);
                        str2 = null;
                    }
                } catch (Exception e5) {
                    W2.a.b("SmsSingleRecipientSender", "sms7BitEncodingTranslate e" + e5);
                }
                if (TextUtils.isEmpty(str2)) {
                    int length = str2.length();
                    arrayListDivideMessage = new ArrayList<>(iArrCalculateLength[0]);
                    int i5 = 0;
                    while (i5 < length) {
                        int iMin = (z4 && iArrCalculateLength[0] == 1) ? Math.min(i4, length - i5) + i5 : C0298a.a(str2, i5, i4, iArrCalculateLength[4], iArrCalculateLength[5]);
                        if (iMin <= i5 || iMin > length) {
                            W2.a.b("SmsSingleRecipientSender", "divideMessage failed (" + i5 + ">=" + iMin + " or " + iMin + ">=" + length + ")");
                            break;
                        }
                        arrayListDivideMessage.add(str2.substring(i5, iMin));
                        i5 = iMin;
                    }
                } else {
                    W2.a.b("SmsSingleRecipientSender", "divideMessage return for newMsgBody is empty");
                }
            } else {
                W2.a.f("SmsSingleRecipientSender", "divideMessage return for not 7bit encoding");
            }
        } else {
            arrayListDivideMessage = C0287t.u(this.f833i).divideMessage(str);
        }
        if (arrayListDivideMessage == null) {
            W2.a.b("SmsSingleRecipientSender", "divideMessage messages is empty");
        }
        return arrayListDivideMessage;
    }

    @Override // O0.s
    public final boolean a() throws C0303b, ClassNotFoundException {
        ArrayList<String> arrayListB;
        if (this.d == null) {
            throw new C0303b("Null message body or have multiple destinations.");
        }
        if (TextUtils.isEmpty(this.f835m)) {
            throw new C0303b("Dest is null.");
        }
        if (k0.d.f() == null || !(S2.d.h(this.f835m) || C0292y.a(this.f835m))) {
            arrayListB = b(this.d);
            String strReplaceAll = this.f835m.replaceAll(" ", "");
            this.f835m = strReplaceAll;
            this.f835m = C0416c.k0(this.f827a, this.f831f, strReplaceAll);
        } else {
            String str = this.f835m + " " + this.d;
            this.f835m = k0.d.f();
            arrayListB = b(str);
        }
        ArrayList<String> arrayList = arrayListB;
        int size = L2.a.a(arrayList) ? 0 : arrayList.size();
        if (size == 0) {
            throw new C0303b(C2.c.b(D2.e.d("SmsMessageSender.sendMessage: divideMessage returned empty messages. Original message is \""), this.d, "\""));
        }
        if (!C0227a.d(this.f827a, this.f836n, 4, 0)) {
            StringBuilder sbD = D2.e.d("SmsMessageSender.sendMessage: couldn't move message to outbox: ");
            sbD.append(this.f836n);
            throw new C0303b(sbD.toString());
        }
        ArrayList<PendingIntent> arrayList2 = new ArrayList<>(size);
        ArrayList<PendingIntent> arrayList3 = new ArrayList<>(size);
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f834l && i2 == size - 1) {
                Intent intent = new Intent("com.android.mmt.transaction.MessageStatusReceiver.MESSAGE_STATUS_RECEIVED", this.f836n, this.f827a, MessageStatusReceiver.class);
                intent.addFlags(268435456);
                intent.putExtra("slot_id", this.f833i);
                arrayList2.add(PendingIntent.getBroadcast(this.f827a, 0, intent, 33554432));
            } else {
                arrayList2.add(null);
            }
            Intent intent2 = new Intent("com.android.mmt.transaction.MESSAGE_SENT", this.f836n, this.f827a, SmsReceiver.class);
            intent2.addFlags(268435456);
            intent2.putExtra("show_toast_when_offline", this.f837o);
            intent2.putExtra("slot_id", this.f833i);
            int i4 = 1;
            if (i2 == size - 1) {
                intent2.putExtra("SendNextMsg", true);
            } else {
                i4 = 0;
            }
            arrayList3.add(PendingIntent.getBroadcast(this.f827a, i4, intent2, 67108864));
        }
        try {
            SmsManager smsManagerU = C0287t.u(this.f833i);
            if (smsManagerU == null) {
                W2.a.a("SmsSingleRecipientSender", "get SmsManager is failed for slotId " + this.f833i);
                return false;
            }
            if (MmsApp.c().getSharedPreferences("cmd", 0).getBoolean("debug", false)) {
                W2.a.a("SmsSingleRecipientSender", " send text message " + this.f835m + " ");
            }
            smsManagerU.sendMultipartTextMessage(PhoneNumberUtils.stripSeparators(this.f835m), this.f830e, arrayList, arrayList3, arrayList2);
            return false;
        } catch (Exception e2) {
            W2.a.c("SmsSingleRecipientSender", "SmsMessageSender.sendMessage: caught", e2);
            throw new C0303b("SmsMessageSender.sendMessage: caught " + e2 + " from SmsManager.sendTextMessage()");
        }
    }
}
