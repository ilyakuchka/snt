package K0;

import M0.d;
import M0.f;
import android.content.Context;
import android.os.Bundle;
import com.android.mmt.storage.bugle.BugleDatabase;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private static b f328c = new b();

    /* renamed from: a, reason: collision with root package name */
    private Context f329a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f330b;

    private b() {
    }

    public static b a() {
        return f328c;
    }

    public final Context b() {
        return this.f329a;
    }

    public final void c() {
        f.a(this.f329a);
        d.b().c(this.f329a);
    }

    public final void d(Context context, Bundle bundle) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f329a = applicationContext;
        BugleDatabase.z(applicationContext);
        this.f330b = bundle;
        BugleDatabase.z(this.f329a);
        f.a(this.f329a);
        d.b().c(this.f329a);
    }

    public final boolean e() {
        return this.f330b.getBoolean("collapse_sp");
    }

    public final boolean f() {
        return this.f330b.getBoolean("show_block");
    }
}
