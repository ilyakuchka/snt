package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private Context f3865a;

    /* renamed from: b, reason: collision with root package name */
    private long f3866b = 0;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f3867c = null;
    private SharedPreferences.Editor d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3868e;

    /* renamed from: f, reason: collision with root package name */
    private String f3869f;
    private PreferenceScreen g;

    /* renamed from: h, reason: collision with root package name */
    private c f3870h;

    /* renamed from: i, reason: collision with root package name */
    private a f3871i;

    /* renamed from: j, reason: collision with root package name */
    private b f3872j;

    public interface a {
        void f(Preference preference);
    }

    public interface b {
    }

    public interface c {
        boolean j(Preference preference);
    }

    public g(Context context) {
        this.f3865a = context;
        this.f3869f = d(context);
    }

    public static SharedPreferences c(Context context) {
        return context.getSharedPreferences(d(context), 0);
    }

    private static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public final <T extends Preference> T a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.g;
        if (preferenceScreen == null) {
            return null;
        }
        return (T) preferenceScreen.x0(charSequence);
    }

    public final Context b() {
        return this.f3865a;
    }

    final SharedPreferences.Editor e() {
        if (!this.f3868e) {
            return j().edit();
        }
        if (this.d == null) {
            this.d = j().edit();
        }
        return this.d;
    }

    final long f() {
        long j2;
        synchronized (this) {
            j2 = this.f3866b;
            this.f3866b = 1 + j2;
        }
        return j2;
    }

    public final b g() {
        return this.f3872j;
    }

    public final c h() {
        return this.f3870h;
    }

    public final PreferenceScreen i() {
        return this.g;
    }

    public final SharedPreferences j() {
        if (this.f3867c == null) {
            this.f3867c = this.f3865a.getSharedPreferences(this.f3869f, 0);
        }
        return this.f3867c;
    }

    public final PreferenceScreen k(Context context, int i2) {
        this.f3868e = true;
        PreferenceScreen preferenceScreen = (PreferenceScreen) new f(context, this).c(i2);
        preferenceScreen.L(this);
        SharedPreferences.Editor editor = this.d;
        if (editor != null) {
            editor.apply();
        }
        this.f3868e = false;
        return preferenceScreen;
    }

    public final void l(a aVar) {
        this.f3871i = aVar;
    }

    public final void m(b bVar) {
        this.f3872j = bVar;
    }

    public final void n(c cVar) {
        this.f3870h = cVar;
    }

    public final boolean o(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.g;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.P();
        }
        this.g = preferenceScreen;
        return true;
    }

    final boolean p() {
        return !this.f3868e;
    }

    public final void q(Preference preference) {
        a aVar = this.f3871i;
        if (aVar != null) {
            aVar.f(preference);
        }
    }
}
