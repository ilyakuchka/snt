package miuix.internal.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import m3.AbstractC0350b;
import m3.C0351c;
import n3.AbstractC0355a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private int f7129a;

    /* renamed from: b, reason: collision with root package name */
    private int f7130b;
    private miuix.internal.view.b d;

    /* renamed from: e, reason: collision with root package name */
    private miuix.internal.view.b f7132e;

    /* renamed from: f, reason: collision with root package name */
    private miuix.internal.view.b f7133f;
    private CheckBoxAnimatedStateListDrawable g;

    /* renamed from: h, reason: collision with root package name */
    private C0351c f7134h;

    /* renamed from: i, reason: collision with root package name */
    private C0351c f7135i;

    /* renamed from: j, reason: collision with root package name */
    private C0351c f7136j;

    /* renamed from: k, reason: collision with root package name */
    private C0351c f7137k;

    /* renamed from: l, reason: collision with root package name */
    private C0351c f7138l;

    /* renamed from: m, reason: collision with root package name */
    private C0351c f7139m;

    /* renamed from: n, reason: collision with root package name */
    private C0351c f7140n;

    /* renamed from: o, reason: collision with root package name */
    private C0351c f7141o;
    private C0351c p;

    /* renamed from: q, reason: collision with root package name */
    private C0351c f7142q;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7148x;

    /* renamed from: c, reason: collision with root package name */
    private float f7131c = 1.0f;

    /* renamed from: r, reason: collision with root package name */
    private miuix.internal.view.c f7143r = new miuix.internal.view.c(this, 0);

    /* renamed from: s, reason: collision with root package name */
    private AbstractC0350b.c f7144s = new a();

    /* renamed from: t, reason: collision with root package name */
    private AbstractC0355a<CheckBoxAnimatedStateListDrawable> f7145t = new b();
    private AbstractC0355a<CheckBoxAnimatedStateListDrawable> u = new c();

    /* renamed from: v, reason: collision with root package name */
    private AbstractC0355a<d> f7146v = new C0123d();

    /* renamed from: w, reason: collision with root package name */
    private AbstractC0355a<miuix.internal.view.b> f7147w = new e();

    final class a implements AbstractC0350b.c {
        a() {
        }

        @Override // m3.AbstractC0350b.c
        public final void a(AbstractC0350b abstractC0350b, float f4, float f5) {
            d.this.g.j(d.this.f());
            d.this.g.invalidateSelf();
        }
    }

    final class b extends AbstractC0355a<CheckBoxAnimatedStateListDrawable> {
        b() {
            super("Scale");
        }

        @Override // n3.AbstractC0355a
        public final float a(CheckBoxAnimatedStateListDrawable checkBoxAnimatedStateListDrawable) {
            return d.this.g.d();
        }

        @Override // n3.AbstractC0355a
        public final void b(CheckBoxAnimatedStateListDrawable checkBoxAnimatedStateListDrawable, float f4) {
            d.this.g.j(f4);
        }
    }

    final class c extends AbstractC0355a<CheckBoxAnimatedStateListDrawable> {
        c() {
            super("ContentAlpha");
        }

        @Override // n3.AbstractC0355a
        public final float a(CheckBoxAnimatedStateListDrawable checkBoxAnimatedStateListDrawable) {
            return checkBoxAnimatedStateListDrawable.c();
        }

        @Override // n3.AbstractC0355a
        public final void b(CheckBoxAnimatedStateListDrawable checkBoxAnimatedStateListDrawable, float f4) {
            CheckBoxAnimatedStateListDrawable checkBoxAnimatedStateListDrawable2 = checkBoxAnimatedStateListDrawable;
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            checkBoxAnimatedStateListDrawable2.i(f4);
        }
    }

    /* renamed from: miuix.internal.view.d$d, reason: collision with other inner class name */
    final class C0123d extends AbstractC0355a<d> {
        C0123d() {
            super("Scale");
        }

        @Override // n3.AbstractC0355a
        public final float a(d dVar) {
            return d.this.f();
        }

        @Override // n3.AbstractC0355a
        public final void b(d dVar, float f4) {
            d.this.i(f4);
        }
    }

    final class e extends AbstractC0355a<miuix.internal.view.b> {
        e() {
            super("Alpha");
        }

        @Override // n3.AbstractC0355a
        public final float a(miuix.internal.view.b bVar) {
            return bVar.getAlpha() / 255;
        }

        @Override // n3.AbstractC0355a
        public final void b(miuix.internal.view.b bVar, float f4) {
            miuix.internal.view.b bVar2 = bVar;
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            bVar2.setAlpha((int) (f4 * 255.0f));
        }
    }

    final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!d.this.f7141o.g()) {
                d.this.f7141o.n();
            }
            if (d.this.p.g()) {
                return;
            }
            d.this.p.n();
        }
    }

    public d(CheckBoxAnimatedStateListDrawable checkBoxAnimatedStateListDrawable, boolean z4, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f7129a = i6;
        this.f7130b = i7;
        this.f7148x = z4;
        miuix.internal.view.b bVar = new miuix.internal.view.b(i2, i6, i7, i8, i9, i10);
        this.d = bVar;
        bVar.setAlpha(this.f7129a);
        miuix.internal.view.b bVar2 = new miuix.internal.view.b(i4, i6, i7, 0, 0, 0);
        this.f7132e = bVar2;
        bVar2.setAlpha(0);
        miuix.internal.view.b bVar3 = new miuix.internal.view.b(i5, i6, i7, 0, 0, 0);
        this.f7133f = bVar3;
        bVar3.setAlpha(255);
        this.g = checkBoxAnimatedStateListDrawable;
        C0351c c0351c = new C0351c(this, this.f7146v, 0.6f);
        this.f7134h = c0351c;
        c0351c.p().e(986.96f);
        this.f7134h.p().c(0.99f);
        this.f7134h.p().d(0.6f);
        this.f7134h.i(0.002f);
        this.f7134h.c(this.f7144s);
        C0351c c0351c2 = new C0351c(this, this.f7146v, 1.0f);
        this.f7137k = c0351c2;
        c0351c2.p().e(986.96f);
        this.f7137k.p().c(0.6f);
        this.f7137k.i(0.002f);
        this.f7137k.c(new miuix.internal.view.e(this));
        C0351c c0351c3 = new C0351c(this.g, this.u, 0.5f);
        this.f7140n = c0351c3;
        c0351c3.p().e(986.96f);
        this.f7140n.p().c(0.99f);
        this.f7140n.i(0.00390625f);
        this.f7140n.c(this.f7143r);
        C0351c c0351c4 = new C0351c(this.f7132e, this.f7147w, 0.1f);
        this.f7135i = c0351c4;
        c0351c4.p().e(986.96f);
        this.f7135i.p().c(0.99f);
        this.f7135i.i(0.00390625f);
        this.f7135i.c(this.f7143r);
        C0351c c0351c5 = new C0351c(this.f7132e, this.f7147w, 0.0f);
        this.f7136j = c0351c5;
        c0351c5.p().e(986.96f);
        this.f7136j.p().c(0.99f);
        this.f7136j.i(0.00390625f);
        this.f7136j.c(this.f7143r);
        C0351c c0351c6 = new C0351c(this.f7133f, this.f7147w, 1.0f);
        this.f7138l = c0351c6;
        c0351c6.p().e(986.96f);
        this.f7138l.p().c(0.7f);
        this.f7138l.i(0.00390625f);
        this.f7138l.c(this.f7143r);
        C0351c c0351c7 = new C0351c(this.g, this.u, 1.0f);
        this.f7141o = c0351c7;
        c0351c7.p().e(438.64f);
        this.f7141o.p().c(0.6f);
        this.f7141o.i(0.00390625f);
        this.f7141o.c(this.f7143r);
        C0351c c0351c8 = new C0351c(this.f7133f, this.f7147w, 0.0f);
        this.f7139m = c0351c8;
        c0351c8.p().e(986.96f);
        this.f7139m.p().c(0.99f);
        this.f7139m.i(0.00390625f);
        this.f7139m.c(this.f7143r);
        C0351c c0351c9 = new C0351c(this.g, this.f7145t, 1.0f);
        this.p = c0351c9;
        c0351c9.p().e(438.64f);
        this.p.p().c(0.6f);
        this.p.i(0.002f);
        this.p.c(this.f7143r);
        if (this.f7148x) {
            this.p.m(5.0f);
        } else {
            this.p.m(10.0f);
        }
        C0351c c0351c10 = new C0351c(this.g, this.f7145t, 0.3f);
        this.f7142q = c0351c10;
        c0351c10.p().e(986.96f);
        this.f7142q.p().c(0.99f);
        this.f7142q.i(0.002f);
        this.f7142q.c(this.f7144s);
    }

    public final void e(Canvas canvas) {
        this.d.draw(canvas);
        this.f7132e.draw(canvas);
        this.f7133f.draw(canvas);
    }

    public final float f() {
        return this.f7131c;
    }

    public final void g(int i2, int i4, int i5, int i6) {
        this.d.setBounds(i2, i4, i5, i6);
        this.f7132e.setBounds(i2, i4, i5, i6);
        this.f7133f.setBounds(i2, i4, i5, i6);
    }

    public final void h(Rect rect) {
        this.d.setBounds(rect);
        this.f7132e.setBounds(rect);
        this.f7133f.setBounds(rect);
    }

    public final void i(float f4) {
        this.d.a(f4);
        this.f7132e.a(f4);
        this.f7133f.a(f4);
        this.f7131c = f4;
    }

    protected final void j(boolean z4, boolean z5) {
        if (z5 && Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (!this.f7134h.g()) {
                this.f7134h.n();
            }
            if (!this.f7140n.g()) {
                this.f7140n.n();
            }
            if (!z4 && !this.f7135i.g()) {
                this.f7135i.n();
            }
            if (this.f7136j.g()) {
                this.f7136j.d();
            }
            if (this.f7137k.g()) {
                this.f7137k.d();
            }
            if (this.f7141o.g()) {
                this.f7141o.d();
            }
            if (this.p.g()) {
                this.p.d();
            }
            if (this.f7142q.g()) {
                this.f7142q.d();
            }
            if (this.f7139m.g()) {
                this.f7139m.d();
            }
            if (this.f7138l.g()) {
                this.f7138l.d();
            }
        }
    }

    protected final void k(boolean z4, boolean z5) {
        if (!z5 || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            if (z4) {
                this.f7133f.setAlpha((int) (this.f7138l.p().a() * 255.0f));
                return;
            } else {
                this.f7133f.setAlpha((int) (this.f7139m.p().a() * 255.0f));
                return;
            }
        }
        if (this.f7134h.g()) {
            this.f7134h.d();
        }
        if (this.f7140n.g()) {
            this.f7140n.d();
        }
        if (this.f7135i.g()) {
            this.f7135i.d();
        }
        if (!this.f7136j.g()) {
            this.f7136j.n();
        }
        if (z4) {
            if (this.f7139m.g()) {
                this.f7139m.d();
            }
            if (!this.f7138l.g()) {
                this.f7138l.n();
            }
            new Handler().postDelayed(new f(), 50L);
            if (this.f7148x) {
                this.f7137k.m(10.0f);
            } else {
                this.f7137k.m(5.0f);
            }
        } else {
            if (this.f7138l.g()) {
                this.f7138l.d();
            }
            if (!this.f7139m.g()) {
                this.f7139m.n();
            }
            if (!this.f7142q.g()) {
                this.f7142q.n();
            }
        }
        this.f7137k.n();
    }

    protected final void l(boolean z4, boolean z5) {
        if (!z5) {
            this.f7133f.setAlpha(0);
            this.f7132e.setAlpha(0);
            this.d.setAlpha(this.f7130b);
        } else {
            if (z4) {
                this.f7133f.setAlpha(255);
                this.f7132e.setAlpha(25);
            } else {
                this.f7133f.setAlpha(0);
                this.f7132e.setAlpha(0);
            }
            this.d.setAlpha(this.f7129a);
        }
    }
}
