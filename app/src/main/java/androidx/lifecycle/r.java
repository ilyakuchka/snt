package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.g;
import androidx.lifecycle.t;
import java.util.Objects;

/* loaded from: classes.dex */
public final class r implements k {

    /* renamed from: q, reason: collision with root package name */
    private static final r f3704q = new r();

    /* renamed from: m, reason: collision with root package name */
    private Handler f3709m;

    /* renamed from: i, reason: collision with root package name */
    private int f3705i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f3706j = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3707k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3708l = true;

    /* renamed from: n, reason: collision with root package name */
    private final l f3710n = new l(this);

    /* renamed from: o, reason: collision with root package name */
    private Runnable f3711o = new a();
    b p = new b();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.h();
            r.this.i();
        }
    }

    final class b implements t.a {
        b() {
        }
    }

    private r() {
    }

    public static k j() {
        return f3704q;
    }

    static void k(Context context) {
        r rVar = f3704q;
        Objects.requireNonNull(rVar);
        rVar.f3709m = new Handler();
        rVar.f3710n.f(g.b.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new s(rVar));
    }

    @Override // androidx.lifecycle.k
    public final g a() {
        return this.f3710n;
    }

    final void b() {
        int i2 = this.f3706j - 1;
        this.f3706j = i2;
        if (i2 == 0) {
            this.f3709m.postDelayed(this.f3711o, 700L);
        }
    }

    final void d() {
        int i2 = this.f3706j + 1;
        this.f3706j = i2;
        if (i2 == 1) {
            if (!this.f3707k) {
                this.f3709m.removeCallbacks(this.f3711o);
            } else {
                this.f3710n.f(g.b.ON_RESUME);
                this.f3707k = false;
            }
        }
    }

    final void f() {
        int i2 = this.f3705i + 1;
        this.f3705i = i2;
        if (i2 == 1 && this.f3708l) {
            this.f3710n.f(g.b.ON_START);
            this.f3708l = false;
        }
    }

    final void g() {
        int i2 = this.f3705i - 1;
        this.f3705i = i2;
        if (i2 == 0 && this.f3707k) {
            this.f3710n.f(g.b.ON_STOP);
            this.f3708l = true;
        }
    }

    final void h() {
        if (this.f3706j == 0) {
            this.f3707k = true;
            this.f3710n.f(g.b.ON_PAUSE);
        }
    }

    final void i() {
        if (this.f3705i == 0 && this.f3707k) {
            this.f3710n.f(g.b.ON_STOP);
            this.f3708l = true;
        }
    }
}
