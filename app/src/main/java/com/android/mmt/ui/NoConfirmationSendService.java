package com.android.mmt.ui;

import android.app.IntentService;
import android.content.ContentUris;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.util.C0273e;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0292y;
import f0.C0303b;
import g0.C0318n;
import g0.C0319o;
import j3.C0338a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import k3.C0344a;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class NoConfirmationSendService extends IntentService {

    /* renamed from: m, reason: collision with root package name */
    public static HashSet<Pair<String, Pair<String, Integer>>> f5193m = new HashSet<>();

    /* renamed from: i, reason: collision with root package name */
    private Handler f5194i;

    /* renamed from: j, reason: collision with root package name */
    x0.j f5195j;

    /* renamed from: k, reason: collision with root package name */
    int f5196k;

    /* renamed from: l, reason: collision with root package name */
    private final C0273e.InterfaceC0107e f5197l;

    final class a implements C0273e.InterfaceC0107e {
        a() {
        }

        @Override // com.android.mmt.util.C0273e.InterfaceC0107e
        public final void a(C0318n c0318n, boolean z4) {
            int i2 = -1;
            if (c0318n == null) {
                NoConfirmationSendService.this.b(-1, R.string.type_picture);
                return;
            }
            C0319o c0319oE = C0319o.e(NoConfirmationSendService.this.getApplicationContext());
            x0.j jVar = NoConfirmationSendService.this.f5195j;
            Uri uriQ = jVar.Q(true);
            if (uriQ != null) {
                try {
                    Uri uriQ2 = c0319oE.q(c0318n, ContentUris.parseId(uriQ));
                    int iT = jVar.T(1, uriQ2, z4);
                    Log.i("Mms/NoConfirmationSendService", "ResizeImageResultCallback: dataUri=" + uriQ2);
                    i2 = iT;
                } catch (C0303b unused) {
                }
            }
            NoConfirmationSendService.this.b(i2, R.string.type_picture);
        }
    }

    public NoConfirmationSendService() {
        super(NoConfirmationSendService.class.getName());
        this.f5194i = new Handler();
        this.f5197l = new a();
        setIntentRedelivery(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, int i4) {
        if (i2 == 0) {
            x0.j jVar = this.f5195j;
            jVar.S(jVar.z(), this.f5196k);
        } else {
            Resources resources = getResources();
            StringBuilder sbC = C2.c.c("handleAddAttachmentError: error: ", i2, ", attachmentType: ");
            sbC.append(resources.getString(i4));
            Log.w("Mms/NoConfirmationSendService", sbC.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x026b A[PHI: r8
      0x026b: PHI (r8v20 java.lang.String) = (r8v13 java.lang.String), (r8v19 java.lang.String) binds: [B:98:0x0269, B:105:0x0295] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onHandleIntent(Intent intent) {
        boolean z4;
        Y1.a.c("NoConfirmationSendService onHandleIntent", new Object[0]);
        if (intent == null) {
            Y1.a.l("Null intent. Bail.", new Object[0]);
            return;
        }
        String action = intent.getAction();
        if ("com.android.mmt.intent.action.SEND_AND_REMOVE_PENNDING_MESSAGE".equals(action)) {
            String stringExtra = intent.getStringExtra("extra_address");
            int iT = C0287t.t(intent);
            if (TextUtils.isEmpty(stringExtra) || f5193m.size() <= 0) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator<Pair<String, Pair<String, Integer>>> it = f5193m.iterator();
            while (it.hasNext()) {
                Pair<String, Pair<String, Integer>> next = it.next();
                if (!((String) next.first).equals(stringExtra)) {
                    hashSet.add(next);
                } else if (((Integer) ((Pair) next.second).second).intValue() == iT) {
                    try {
                        new O0.s(getBaseContext(), new String[]{(String) next.first}, (String) ((Pair) next.second).first, 0L, 0L, ((Integer) ((Pair) next.second).second).intValue()).a();
                    } catch (Exception e2) {
                        Log.e("Mms/NoConfirmationSendService", "Failed to send SMS message, threadId=0", e2);
                    }
                } else {
                    hashSet.add(next);
                }
            }
            f5193m.clear();
            if (hashSet.isEmpty()) {
                return;
            }
            f5193m.addAll(hashSet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Y1.a.l("Called to send SMS/MMS but no extras", new Object[0]);
            return;
        }
        int iS = C0287t.s(extras);
        Y1.a.c(D2.e.b("onHandleIntent  slotId = ", iS), new Object[0]);
        if (iS < 0 || !C0287t.D(iS)) {
            iS = C0287t.f();
            Y1.a.c(D2.e.b("inserted slotId = ", iS), new Object[0]);
            if (iS == -1) {
                Y1.a.d("No usable sim card", new Object[0]);
                return;
            }
        }
        Uri data = intent.getData();
        Uri uri = C0416c.f8050r;
        String schemeSpecificPart = data.getSchemeSpecificPart();
        int iIndexOf = schemeSpecificPart.indexOf(63);
        if (iIndexOf != -1) {
            schemeSpecificPart = schemeSpecificPart.substring(0, iIndexOf);
        }
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            Y1.a.l("Recipient(s) cannot be empty", new Object[0]);
            return;
        }
        if (extras.getBoolean("showUI", false)) {
            intent.addFlags(268435456);
            ComposeMessageRouterActivity.e(this, intent);
            return;
        }
        if ("com.android.mmt.intent.action.SENDTO_NO_CONFIRMATION".equals(action) || "android.intent.action.RESPOND_VIA_MESSAGE".equals(action)) {
            String string = extras.getString("android.intent.extra.TEXT");
            if (TextUtils.isEmpty(string)) {
                Y1.a.l("Message cannot be empty", new Object[0]);
                return;
            }
            for (String strA : TextUtils.split(schemeSpecificPart, ";")) {
                int i2 = C0292y.f6056e;
                int i4 = C0344a.d;
                C0338a c0338aI = C0338a.i(strA, null);
                if (!TextUtils.isEmpty(strA)) {
                    String strE = c0338aI.e();
                    String strD = c0338aI.d();
                    if (!TextUtils.isEmpty(strD) && !c0338aI.h()) {
                        strA = C2.c.a("+", strD, strE);
                    } else if (c0338aI.h()) {
                        strA = strE;
                    } else {
                        String simCountryIso = ((TelephonyManager) MmsApp.c().getSystemService("phone")).getSimCountryIso();
                        if (!TextUtils.isEmpty(simCountryIso)) {
                            String upperCase = simCountryIso.toUpperCase();
                            if (!TextUtils.isEmpty(upperCase)) {
                                strE = PhoneNumberUtils.formatNumberToE164(strA, upperCase);
                                if (!TextUtils.isEmpty(strE)) {
                                }
                            }
                        }
                    }
                }
                c0338aI.j();
                f5193m.add(Pair.create(strA, Pair.create(string, Integer.valueOf(iS))));
                this.f5194i.postDelayed(new y0(strA, iS), 10000L);
            }
            return;
        }
        if ("com.android.mmt.intent.action.SEND_MMS_NO_CONFIRMATION".equals(intent.getAction())) {
            int i5 = extras.getInt("attachment_type");
            Uri uri2 = Uri.parse(extras.getString("path"));
            if (uri2 != null) {
                try {
                    grantUriPermission(getPackageName(), uri2, 1);
                    z4 = true;
                } catch (SecurityException e4) {
                    Log.w("Mms/NoConfirmationSendService", "grantUriReadPermission: No permission to read this Uri.");
                    e4.printStackTrace();
                    z4 = false;
                }
                if (z4) {
                    String[] strArrSplit = TextUtils.split(schemeSpecificPart, ";");
                    for (String str : strArrSplit) {
                        String strReplaceAll = str.replaceAll(" ", "");
                        this.f5195j = new x0.j(null);
                        C0415b c0415b = new C0415b();
                        c0415b.add(C0414a.O(strReplaceAll));
                        this.f5195j.U(C0416c.p(this, c0415b));
                        this.f5195j.Y();
                        Objects.requireNonNull(this.f5195j);
                        this.f5196k = iS;
                        if (i5 == 1) {
                            int iT2 = this.f5195j.T(1, uri2, false);
                            Log.d("Mms/NoConfirmationSendService", "addImage: result: " + iT2);
                            if (iT2 == -4 || iT2 == -2) {
                                Log.i("Mms/NoConfirmationSendService", "addImage: resize image ");
                                C0273e.a(getApplicationContext(), uri2, this.f5194i, this.f5197l, false);
                            } else {
                                b(iT2, R.string.type_picture);
                            }
                        } else if (i5 != 3) {
                            Log.w("Mms/NoConfirmationSendService", "handleSendMms: Unsupported Attachment Type.");
                        } else {
                            int iT3 = this.f5195j.T(3, uri2, false);
                            Log.d("Mms/NoConfirmationSendService", "addAudio: result: " + iT3);
                            b(iT3, R.string.type_audio);
                        }
                    }
                }
            }
        }
    }

    public NoConfirmationSendService(String str) {
        super(str);
        this.f5194i = new Handler();
        this.f5197l = new a();
        setIntentRedelivery(true);
    }
}
