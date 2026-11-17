package C3;

import android.content.Context;
import android.content.res.Resources;
import com.android.mmt.R;
import w3.AbstractC0410c;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static AbstractC0410c<b> f72b;

    /* renamed from: a, reason: collision with root package name */
    private Resources f73a;

    final class a extends AbstractC0410c<b> {
        a() {
        }

        @Override // w3.AbstractC0410c
        protected final b a(Object obj) {
            return new b((Context) obj);
        }

        @Override // w3.AbstractC0410c
        protected final void c(b bVar, Object obj) {
            b.a(bVar, (Context) obj);
        }
    }

    b(Context context) {
        this.f73a = context.getResources();
    }

    static void a(b bVar, Context context) {
        bVar.f73a = context.getResources();
    }

    public static b m(Context context) {
        if (f72b == null) {
            f72b = new a();
        }
        return f72b.b(context);
    }

    public final String[] b() {
        return this.f73a.getStringArray(R.array.am_pms);
    }

    public final String[] c() {
        return this.f73a.getStringArray(R.array.chinese_days);
    }

    public final String[] d() {
        return this.f73a.getStringArray(R.array.chinese_digits);
    }

    public final String[] e() {
        return this.f73a.getStringArray(R.array.chinese_leap_months);
    }

    public final String[] f() {
        return this.f73a.getStringArray(R.array.chinese_months);
    }

    public final String[] g() {
        return this.f73a.getStringArray(R.array.chinese_symbol_animals);
    }

    public final String[] h() {
        return this.f73a.getStringArray(R.array.detailed_am_pms);
    }

    public final String[] i() {
        return this.f73a.getStringArray(R.array.earthly_branches);
    }

    public final String[] j() {
        return this.f73a.getStringArray(R.array.eras);
    }

    public final String[] k() {
        return this.f73a.getStringArray(R.array.heavenly_stems);
    }

    public final String[] l() {
        return this.f73a.getStringArray(R.array.months);
    }

    public final String[] n() {
        return this.f73a.getStringArray(R.array.months_short);
    }

    public final String[] o() {
        return this.f73a.getStringArray(R.array.week_days_short);
    }

    public final String[] p() {
        return this.f73a.getStringArray(R.array.months_shortest);
    }

    public final String[] q() {
        return this.f73a.getStringArray(R.array.week_days_shortest);
    }

    public final String[] r() {
        return this.f73a.getStringArray(R.array.solar_terms);
    }

    public final String[] s() {
        return this.f73a.getStringArray(R.array.week_days);
    }
}
