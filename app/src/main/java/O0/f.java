package O0;

import a.C0178a;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.transaction.TransactionService;
import com.android.mmt.util.C0287t;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import t.C0384b;
import x0.C0414a;

/* loaded from: classes.dex */
public final class f extends BroadcastReceiver {

    /* renamed from: l, reason: collision with root package name */
    private static f f773l;

    /* renamed from: a, reason: collision with root package name */
    private Context f774a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f775b;

    /* renamed from: f, reason: collision with root package name */
    private g f778f;
    private g g;

    /* renamed from: h, reason: collision with root package name */
    private C0027f f779h;

    /* renamed from: i, reason: collision with root package name */
    private C0027f f780i;

    /* renamed from: c, reason: collision with root package name */
    private AtomicInteger f776c = new AtomicInteger(-1);

    /* renamed from: e, reason: collision with root package name */
    private final Handler f777e = S2.e.a();

    /* renamed from: j, reason: collision with root package name */
    private final HashSet<h> f781j = new HashSet<>();

    /* renamed from: k, reason: collision with root package name */
    private Runnable f782k = new a();
    private boolean[] d = new boolean[2];

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (f.this.m() && f.this.f775b) {
                for (int i2 = 0; i2 < C0287t.g(); i2++) {
                    if (f.this.l(i2)) {
                        Y1.a.k(D2.e.b("updateMmsAvailability slotId ", i2), new Object[0]);
                        f fVar = f.this;
                        f.c(fVar, fVar.f774a, i2);
                    }
                }
            }
        }
    }

    final class b extends ContentObserver {

        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Y1.a.k("mobile data or enable mms is changed", new Object[0]);
                f.this.f776c.set((f.this.n() || f.this.k()) ? 1 : 0);
                f.this.f777e.removeCallbacks(f.this.f782k);
                f.this.f777e.post(f.this.f782k);
            }
        }

        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4) {
            Q2.c.a(new a());
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.h(f.this);
        }
    }

    final class d implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f787i;

        d(String str) {
            this.f787i = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0414a.u0();
            if ("LOADED".equals(this.f787i) || "NOT_READY".equals(this.f787i) || "READY".equals(this.f787i) || "ABSENT".equals(this.f787i)) {
                C0287t.N(true);
            }
        }
    }

    final class e implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f788i;

        e(Context context) {
            this.f788i = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler handlerA = S2.e.a();
            final Context context = this.f788i;
            handlerA.post(new Runnable() { // from class: O0.g
                @Override // java.lang.Runnable
                public final void run() {
                    com.bumptech.glide.c.c(context).b();
                }
            });
        }
    }

    /* renamed from: O0.f$f, reason: collision with other inner class name */
    private class C0027f extends g {
        public C0027f(f fVar, Context context, int i2, Handler handler) {
            super(context, i2, handler);
        }

        @Override // O0.f.g
        public final void b() {
            if (!C0287t.A(this.f790b) || this.f791c) {
                return;
            }
            ((TelephonyManager) MmsApp.c().getSystemService(TelephonyManager.class)).listen(this, 32);
            this.f791c = true;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCallStateChanged(int i2, String str) {
            int i4 = this.f790b == 0 ? 1 : 0;
            Y1.a.k("MmsSystemEventReceiver", D2.e.b("try send sms again for slot: ", i4));
            if (C0287t.B(i4)) {
                if (this.f791c) {
                    c();
                }
                this.f791c = false;
                Y1.a.k("MmsSystemEventReceiver", "slot(" + i4 + ") senable, so let it go");
                C0287t.I(MmsApp.c(), i4);
            }
        }
    }

    private class g extends PhoneStateListener {

        /* renamed from: a, reason: collision with root package name */
        private Context f789a;

        /* renamed from: b, reason: collision with root package name */
        protected int f790b;
        private Handler d;

        /* renamed from: e, reason: collision with root package name */
        private Runnable f792e = new a();

        /* renamed from: c, reason: collision with root package name */
        protected boolean f791c = false;

        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Y1.a.k("send queued message without toast", new Object[0]);
                C0287t.K(g.this.f789a, g.this.f790b);
            }
        }

        public g(Context context, int i2, Handler handler) {
            this.f789a = context;
            this.f790b = i2;
            this.d = handler;
        }

        public void b() {
            if (!C0287t.A(this.f790b) || this.f791c) {
                return;
            }
            ((TelephonyManager) MmsApp.c().getSystemService(TelephonyManager.class)).listen(this, 1);
            this.f791c = true;
        }

        protected final void c() {
            if (C0287t.A(this.f790b)) {
                ((TelephonyManager) MmsApp.c().getSystemService(TelephonyManager.class)).listen(this, 0);
                this.d.removeCallbacks(this.f792e);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            if (serviceState.getState() == 0) {
                Y1.a.k("on service state is in service", new Object[0]);
                if (this.f791c) {
                    c();
                    this.d.postDelayed(this.f792e, 10000L);
                }
                this.f791c = false;
            }
        }
    }

    public interface h {
        void a();
    }

    private f(Context context) {
        this.f774a = context;
        for (int i2 = 0; i2 < 2; i2++) {
            this.d[i2] = false;
        }
    }

    static void c(f fVar, Context context, int i2) {
        Objects.requireNonNull(fVar);
        Y1.a.k("wakeUpService: start transaction service slotId " + i2, new Object[0]);
        Intent intent = new Intent(fVar.f774a, (Class<?>) TransactionService.class);
        intent.setAction("android.intent.action.ACTION_WAKEUP");
        intent.putExtra("slot_id", i2);
        context.startService(intent);
    }

    static void h(f fVar) {
        ConnectivityManager connectivityManager = (ConnectivityManager) fVar.f774a.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(2);
        if (networkInfo != null && networkInfo.isAvailable()) {
            Y1.a.k("mobile mms available", new Object[0]);
            fVar.f775b = true;
            fVar.f777e.removeCallbacks(fVar.f782k);
            fVar.f777e.post(fVar.f782k);
            return;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 == null || !networkInfo2.isAvailable()) {
            Y1.a.k("mobile or mobile mms is not available", new Object[0]);
            fVar.f775b = false;
        } else {
            Y1.a.k("mobile available", new Object[0]);
            fVar.f775b = true;
            fVar.f777e.removeCallbacks(fVar.f782k);
            fVar.f777e.post(fVar.f782k);
        }
    }

    private int i() throws Resources.NotFoundException {
        int identifier;
        int i2 = 1;
        try {
            identifier = Resources.getSystem().getIdentifier("config_alwaysEnableMms_off_array", "array", "android.miui");
        } catch (Exception e2) {
            Log.e("MmsSystemEventReceiver", "exception when read config from framework", e2);
        }
        if (identifier == 0) {
            Log.d("MmsSystemEventReceiver", "not found array resources");
            return 1;
        }
        String[] stringArray = this.f774a.getResources().getStringArray(identifier);
        int iG = C0287t.g();
        for (int i4 = 0; i4 < iG; i4++) {
            String lowerCase = C0178a.j(C0178a.g((int) C0287t.m(i4)), "gsm.sim.operator.iso-country").toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                int length = stringArray.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    if (TextUtils.equals(stringArray[i5], lowerCase)) {
                        Log.v("MmsSystemEventReceiver", "found matched region ");
                        i2 = 0;
                        break;
                    }
                    i5++;
                }
            }
        }
        return i2;
    }

    public static synchronized f j() {
        if (f773l == null) {
            f773l = new f(MmsApp.c());
        }
        return f773l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        boolean z4 = Settings.System.getInt(this.f774a.getContentResolver(), "always_enable_mms", 1) == 1;
        Y1.a.k("isAlwaysEnableMmsAllowed allowed is " + z4, new Object[0]);
        return z4;
    }

    public final boolean l(int i2) {
        boolean z4 = C0287t.A(i2) ? this.d[i2] : false;
        Y1.a.k("isListening slotId " + i2 + " allowed is " + z4, new Object[0]);
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final boolean m() {
        if (this.f776c.get() == -1) {
            ?? r02 = (n() || k()) ? 1 : 0;
            this.f776c.set(r02);
            Y1.a.k("isMmsAllowed inited for " + ((boolean) r02), new Object[0]);
        }
        return this.f776c.get() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n() {
        boolean z4;
        boolean z5 = true;
        if (C0287t.x()) {
            z4 = C0287t.D(0) && Settings.Global.getInt(this.f774a.getContentResolver(), "mobile_data0", i()) == 1;
            if (!z4 && C0287t.D(1)) {
                if (Settings.Global.getInt(this.f774a.getContentResolver(), "mobile_data1", i()) != 1) {
                    z5 = false;
                }
                z4 = z5;
            }
        } else {
            if (Settings.Global.getInt(this.f774a.getContentResolver(), "mobile_data", i()) != 1) {
            }
            z4 = z5;
        }
        Y1.a.k("isMobileDataAllowed allowed is " + z4, new Object[0]);
        return z4;
    }

    public final void o(int i2) {
        Y1.a.k(D2.e.b("listenForMmsAvailability slotId ", i2), new Object[0]);
        if (C0287t.A(i2)) {
            this.d[i2] = true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.CONTENT_CHANGED".equals(action)) {
            h0.c.e().g((Uri) intent.getParcelableExtra("deleted_contents"));
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            Q2.c.a(new c());
            return;
        }
        if (!"android.intent.action.SIM_STATE_CHANGED".equals(action)) {
            if (!"android.intent.action.AIRPLANE_MODE".equals(action) && "miui.intent.action.ACTION_THEME_CHANGED".equals(action)) {
                Q2.c.a(new e(context));
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("ss");
        Iterator<h> it = this.f781j.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                next.a();
            }
        }
        S2.e.a().postDelayed(new d(stringExtra), 500L);
    }

    public final void p() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CONTENT_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("com.miui.virtualsim.action.STATUS_CHANGE");
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("miui.intent.action.ACTION_THEME_CHANGED");
        C0384b.t(this.f774a, this, intentFilter);
        b bVar = new b(this.f777e);
        ContentResolver contentResolver = this.f774a.getContentResolver();
        if (C0287t.x()) {
            contentResolver.registerContentObserver(Settings.Global.getUriFor("mobile_data0"), false, bVar);
            contentResolver.registerContentObserver(Settings.Global.getUriFor("mobile_data1"), false, bVar);
        } else {
            contentResolver.registerContentObserver(Settings.Global.getUriFor("mobile_data"), false, bVar);
        }
        contentResolver.registerContentObserver(Settings.System.getUriFor("always_enable_mms"), false, bVar);
    }

    public final void q(int i2) {
        if (i2 == 0) {
            if (this.f779h == null) {
                this.f779h = new C0027f(this, this.f774a, i2, this.f777e);
            }
            this.f779h.b();
        } else if (1 == i2) {
            if (this.f780i == null) {
                this.f780i = new C0027f(this, this.f774a, i2, this.f777e);
            }
            this.f780i.b();
        }
    }

    public final void r(int i2) {
        if (i2 == 0) {
            if (this.f778f == null) {
                this.f778f = new g(this.f774a, i2, this.f777e);
            }
            this.f778f.b();
        } else if (1 == i2) {
            if (this.g == null) {
                this.g = new g(this.f774a, i2, this.f777e);
            }
            this.g.b();
        }
    }

    public final void s(h hVar) {
        if (this.f781j.contains(hVar)) {
            return;
        }
        this.f781j.add(hVar);
    }

    public final void t(h hVar) {
        if (this.f781j.contains(hVar)) {
            this.f781j.remove(hVar);
        }
    }

    public final void u(int i2) {
        if (C0287t.A(i2) && this.d[i2]) {
            Y1.a.k(D2.e.b("unlistenForMmsAvailability slotId ", i2), new Object[0]);
            this.d[i2] = false;
        }
    }
}
