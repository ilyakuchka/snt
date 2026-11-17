package v0;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.mmt.MmsApp;

/* renamed from: v0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0403d implements InterfaceC0402c {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f7961a;

    public C0403d() {
        if (TextUtils.isEmpty("Mms_SharedPreference")) {
            throw new IllegalArgumentException("configFileName: Mms_SharedPreference 为空 不合法！");
        }
        Application applicationC = MmsApp.c();
        if (applicationC == null) {
            return;
        }
        this.f7961a = applicationC.getSharedPreferences("Mms_SharedPreference", 0);
    }

    public final boolean a(String str) {
        return this.f7961a.getBoolean(str, false);
    }

    public final long b(String str, long j2) {
        return this.f7961a.getLong(str, j2);
    }

    public final String c(String str, String str2) {
        return this.f7961a.getString(str, str2);
    }

    public final void d(String str, boolean z4) {
        this.f7961a.edit().putBoolean(str, z4).apply();
    }

    public final void e(String str, long j2) {
        this.f7961a.edit().putLong(str, j2).apply();
    }

    public final void f(String str, String str2) {
        this.f7961a.edit().putString(str, str2).apply();
    }
}
