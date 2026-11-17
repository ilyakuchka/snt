package com.android.mmt.transaction;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import t.C0384b;

/* loaded from: classes.dex */
public class SmsReportService extends Service implements TextToSpeech.OnInitListener {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f4534s = 0;

    /* renamed from: i, reason: collision with root package name */
    private TextToSpeech f4535i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4536j;

    /* renamed from: k, reason: collision with root package name */
    private HashMap<String, String> f4537k;

    /* renamed from: l, reason: collision with root package name */
    private String f4538l;

    /* renamed from: m, reason: collision with root package name */
    private int f4539m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f4540n = -1;

    /* renamed from: o, reason: collision with root package name */
    private Handler f4541o = new Handler();
    private Runnable p = new a();

    /* renamed from: q, reason: collision with root package name */
    private BroadcastReceiver f4542q = new c();

    /* renamed from: r, reason: collision with root package name */
    private BroadcastReceiver f4543r = new d();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SmsReportService.this.f4540n == -1 && SmsReportService.this.f4539m > 0) {
                SmsReportService smsReportService = SmsReportService.this;
                smsReportService.stopSelf(smsReportService.f4539m);
                SmsReportService.this.f4539m = -1;
            }
            StringBuilder sbD = D2.e.d("runnable mErrorStartId is ");
            sbD.append(SmsReportService.this.f4539m);
            W2.a.b("SmsReportService", sbD.toString());
        }
    }

    final class b implements TextToSpeech.OnUtteranceCompletedListener {
        b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onUtteranceCompleted(String str) throws NumberFormatException {
            int i2;
            int i4 = SmsReportService.f4534s;
            ((AudioManager) MmsApp.c().getSystemService("audio")).abandonAudioFocus(null);
            W2.a.b("SmsReportService", "onUtteranceCompleted utteranceId is " + str);
            Objects.requireNonNull(SmsReportService.this);
            String[] strArrSplit = TextUtils.split(str, "__");
            if (strArrSplit == null || strArrSplit.length != 4) {
                i2 = -1;
            } else {
                String str2 = strArrSplit[3];
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        i2 = Integer.parseInt(str2);
                    } catch (Exception e2) {
                        W2.a.b("SmsReportService", e2.toString());
                    }
                }
            }
            if (i2 != -1) {
                SmsReportService.this.stopSelf(i2);
                W2.a.b("SmsReportService", "stop startId is " + i2);
                if (i2 == SmsReportService.this.f4540n) {
                    if (SmsReportService.this.f4539m > SmsReportService.this.f4540n) {
                        SmsReportService.this.j();
                    }
                    SmsReportService.this.f4540n = -1;
                }
            }
        }
    }

    final class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("miui.intent.action.KEYCODE_EXTERNAL".equals(intent.getAction())) {
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent == null) {
                    W2.a.b("SmsReportService", " no key event!");
                    return;
                }
                int keyCode = keyEvent.getKeyCode();
                if ((keyCode == 26 || keyCode == 25 || keyCode == 164 || keyCode == 85 || keyCode == 79) && SmsReportService.f(SmsReportService.this)) {
                    try {
                        SmsReportService.this.f4535i.stop();
                    } catch (IllegalArgumentException e2) {
                        W2.a.c("SmsReportService", "Fail to stop tts", e2);
                    }
                }
            }
        }
    }

    final class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (SmsReportService.h(SmsReportService.this)) {
                if (SmsReportService.i(SmsReportService.this, (AudioManager) context.getSystemService("audio"))) {
                    try {
                        SmsReportService.this.f4535i.stop();
                    } catch (IllegalArgumentException e2) {
                        W2.a.c("SmsReportService", "Fail to stop tts", e2);
                    }
                }
            }
        }
    }

    static boolean f(SmsReportService smsReportService) {
        return smsReportService.f4535i != null && smsReportService.f4536j;
    }

    static boolean h(SmsReportService smsReportService) {
        Objects.requireNonNull(smsReportService);
        return Settings.System.getInt(smsReportService.getContentResolver(), "voiceassist_report_method", 2) == 0;
    }

    static boolean i(SmsReportService smsReportService, AudioManager audioManager) {
        Objects.requireNonNull(smsReportService);
        if (!audioManager.isWiredHeadsetOn()) {
            if (smsReportService.f4535i != null && smsReportService.f4536j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Handler handler = this.f4541o;
        if (handler == null) {
            W2.a.b("SmsReportService", "Attempt to post delayed runnable while handler thread is dead.");
        } else {
            handler.removeCallbacks(this.p);
            this.f4541o.postDelayed(this.p, 3000L);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("miui.intent.action.KEYCODE_EXTERNAL");
        C0384b.t(this, this.f4542q, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.HEADSET_PLUG");
        C0384b.t(this, this.f4543r, intentFilter2);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        TextToSpeech textToSpeech = this.f4535i;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
        Handler handler = this.f4541o;
        if (handler != null) {
            handler.removeCallbacks(this.p);
        }
        unregisterReceiver(this.f4542q);
        unregisterReceiver(this.f4543r);
        super.onDestroy();
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public final void onInit(int i2) {
        this.f4536j = true;
        if (i2 != 0) {
            W2.a.b("SmsReportService", "Could not initialize TextToSpeech.");
            try {
                TextToSpeech textToSpeech = this.f4535i;
                if (textToSpeech != null) {
                    textToSpeech.shutdown();
                }
            } catch (IllegalArgumentException e2) {
                W2.a.c("SmsReportService", "Fail to shutdown tts", e2);
            }
            this.f4535i = null;
            return;
        }
        TextToSpeech textToSpeech2 = this.f4535i;
        if (textToSpeech2 != null) {
            int language = textToSpeech2.setLanguage(Locale.CHINA);
            if (language == -1 || language == -2) {
                W2.a.b("SmsReportService", "Language is not available.");
            } else {
                W2.a.f("SmsReportService", "init success");
                this.f4535i.setOnUtteranceCompletedListener(new b());
            }
        }
        if (this.f4535i.speak(this.f4538l, 1, this.f4537k) == -1) {
            W2.a.b("SmsReportService", "Fail to speak tts.");
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i4) {
        if (intent == null) {
            this.f4539m = i4;
            j();
            return super.onStartCommand(intent, i2, i4);
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            this.f4539m = i4;
            j();
            return super.onStartCommand(intent, i2, i4);
        }
        if (!C0287t.v()) {
            this.f4539m = i4;
            j();
            return super.onStartCommand(intent, i2, i4);
        }
        this.f4540n = i4;
        String string = extras.getString("sms_address");
        this.f4538l = "";
        char c2 = extras.getChar("sms_contact");
        if (c2 == '1' || c2 == '2') {
            this.f4538l = getString(R.string.in_sms) + "," + extras.getString("sms_name");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.in_sms));
            sb.append(",");
            sb.append(getString(R.string.unknown_num));
            this.f4538l = C2.c.b(sb, " ", string);
        }
        this.f4538l += ". " + extras.getString("sms_body");
        HashMap<String, String> map = new HashMap<>();
        this.f4537k = map;
        map.put("com.miui.voiceassist.priority", "800");
        this.f4537k.put("utteranceId", C0287t.s(extras) + "__" + extras.getString("sms_address") + "__" + c2 + "__" + i4);
        this.f4537k.put("streamType", "3");
        ((AudioManager) MmsApp.c().getSystemService("audio")).requestAudioFocus(null, 3, 2);
        TextToSpeech textToSpeech = this.f4535i;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            this.f4535i = null;
        }
        this.f4536j = false;
        this.f4535i = new TextToSpeech(this, this);
        return super.onStartCommand(intent, i2, i4);
    }
}
