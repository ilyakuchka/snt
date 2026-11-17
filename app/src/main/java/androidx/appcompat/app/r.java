package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;
import t.C0384b;

/* loaded from: classes.dex */
final class r {
    private static r d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f2421a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f2422b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2423c = new a();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f2424a;

        /* renamed from: b, reason: collision with root package name */
        long f2425b;

        a() {
        }
    }

    r(Context context, LocationManager locationManager) {
        this.f2421a = context;
        this.f2422b = locationManager;
    }

    static r a(Context context) {
        if (d == null) {
            Context applicationContext = context.getApplicationContext();
            d = new r(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return d;
    }

    private Location b(String str) {
        try {
            if (this.f2422b.isProviderEnabled(str)) {
                return this.f2422b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    final boolean c() {
        long j2;
        a aVar = this.f2423c;
        if (aVar.f2425b > System.currentTimeMillis()) {
            return aVar.f2424a;
        }
        Location locationB = C0384b.k(this.f2421a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? b("network") : null;
        Location locationB2 = C0384b.k(this.f2421a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? b("gps") : null;
        if (locationB2 == null || locationB == null ? locationB2 != null : locationB2.getTime() > locationB.getTime()) {
            locationB = locationB2;
        }
        if (locationB == null) {
            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int i2 = Calendar.getInstance().get(11);
            return i2 < 6 || i2 >= 22;
        }
        a aVar2 = this.f2423c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        q qVarB = q.b();
        qVarB.a(jCurrentTimeMillis - 86400000, locationB.getLatitude(), locationB.getLongitude());
        qVarB.a(jCurrentTimeMillis, locationB.getLatitude(), locationB.getLongitude());
        boolean z4 = qVarB.f2420c == 1;
        long j4 = qVarB.f2419b;
        long j5 = qVarB.f2418a;
        qVarB.a(jCurrentTimeMillis + 86400000, locationB.getLatitude(), locationB.getLongitude());
        long j6 = qVarB.f2419b;
        if (j4 == -1 || j5 == -1) {
            j2 = 43200000 + jCurrentTimeMillis;
        } else {
            j2 = (jCurrentTimeMillis > j5 ? j6 + 0 : jCurrentTimeMillis > j4 ? j5 + 0 : j4 + 0) + 60000;
        }
        aVar2.f2424a = z4;
        aVar2.f2425b = j2;
        return aVar.f2424a;
    }
}
