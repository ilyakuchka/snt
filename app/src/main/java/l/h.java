package l;

import android.view.animation.Interpolator;
import androidx.core.view.t;
import androidx.core.view.u;
import java.util.ArrayList;
import java.util.Iterator;
import t.C0384b;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f6508c;
    u d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6509e;

    /* renamed from: b, reason: collision with root package name */
    private long f6507b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final C0384b f6510f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<t> f6506a = new ArrayList<>();

    final class a extends C0384b {

        /* renamed from: z, reason: collision with root package name */
        private boolean f6513z = false;

        /* renamed from: A, reason: collision with root package name */
        private int f6511A = 0;

        a() {
        }

        @Override // androidx.core.view.u
        public final void a() {
            int i2 = this.f6511A + 1;
            this.f6511A = i2;
            if (i2 == h.this.f6506a.size()) {
                u uVar = h.this.d;
                if (uVar != null) {
                    uVar.a();
                }
                this.f6511A = 0;
                this.f6513z = false;
                h.this.b();
            }
        }

        @Override // t.C0384b, androidx.core.view.u
        public final void c() {
            if (this.f6513z) {
                return;
            }
            this.f6513z = true;
            u uVar = h.this.d;
            if (uVar != null) {
                uVar.c();
            }
        }
    }

    public final void a() {
        if (this.f6509e) {
            Iterator<t> it = this.f6506a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f6509e = false;
        }
    }

    final void b() {
        this.f6509e = false;
    }

    public final h c(t tVar) {
        if (!this.f6509e) {
            this.f6506a.add(tVar);
        }
        return this;
    }

    public final h d(t tVar, t tVar2) {
        this.f6506a.add(tVar);
        tVar2.h(tVar.c());
        this.f6506a.add(tVar2);
        return this;
    }

    public final h e() {
        if (!this.f6509e) {
            this.f6507b = 250L;
        }
        return this;
    }

    public final h f(Interpolator interpolator) {
        if (!this.f6509e) {
            this.f6508c = interpolator;
        }
        return this;
    }

    public final h g(u uVar) {
        if (!this.f6509e) {
            this.d = uVar;
        }
        return this;
    }

    public final void h() {
        if (this.f6509e) {
            return;
        }
        Iterator<t> it = this.f6506a.iterator();
        while (it.hasNext()) {
            t next = it.next();
            long j2 = this.f6507b;
            if (j2 >= 0) {
                next.d(j2);
            }
            Interpolator interpolator = this.f6508c;
            if (interpolator != null) {
                next.e(interpolator);
            }
            if (this.d != null) {
                next.f(this.f6510f);
            }
            next.j();
        }
        this.f6509e = true;
    }
}
