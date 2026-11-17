package j1;

import V0.l;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import s1.j;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final U0.a f6381a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f6382b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f6383c;
    final com.bumptech.glide.i d;

    /* renamed from: e, reason: collision with root package name */
    private final Z0.d f6384e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6385f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.h<Bitmap> f6386h;

    /* renamed from: i, reason: collision with root package name */
    private a f6387i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6388j;

    /* renamed from: k, reason: collision with root package name */
    private a f6389k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f6390l;

    /* renamed from: m, reason: collision with root package name */
    private l<Bitmap> f6391m;

    /* renamed from: n, reason: collision with root package name */
    private a f6392n;

    /* renamed from: o, reason: collision with root package name */
    private int f6393o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f6394q;

    static class a extends p1.c<Bitmap> {

        /* renamed from: l, reason: collision with root package name */
        private final Handler f6395l;

        /* renamed from: m, reason: collision with root package name */
        final int f6396m;

        /* renamed from: n, reason: collision with root package name */
        private final long f6397n;

        /* renamed from: o, reason: collision with root package name */
        private Bitmap f6398o;

        a(Handler handler, int i2, long j2) {
            this.f6395l = handler;
            this.f6396m = i2;
            this.f6397n = j2;
        }

        @Override // p1.f
        public final void j(Drawable drawable) {
            this.f6398o = null;
        }

        @Override // p1.f
        public final void k(Object obj, q1.b bVar) {
            this.f6398o = (Bitmap) obj;
            this.f6395l.sendMessageAtTime(this.f6395l.obtainMessage(1, this), this.f6397n);
        }

        final Bitmap l() {
            return this.f6398o;
        }
    }

    public interface b {
        void a();
    }

    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                f.this.k((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            f.this.d.o((a) message.obj);
            return false;
        }
    }

    f(com.bumptech.glide.c cVar, U0.a aVar, int i2, int i4, l<Bitmap> lVar, Bitmap bitmap) {
        Z0.d dVarE = cVar.e();
        com.bumptech.glide.i iVarO = com.bumptech.glide.c.o(cVar.g());
        com.bumptech.glide.h<Bitmap> hVarB0 = com.bumptech.glide.c.o(cVar.g()).m().a(((o1.e) ((o1.e) new o1.e().f(Y0.l.f1981a).Z()).U()).O(i2, i4));
        this.f6383c = new ArrayList();
        this.d = iVarO;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.f6384e = dVarE;
        this.f6382b = handler;
        this.f6386h = hVarB0;
        this.f6381a = aVar;
        l(lVar, bitmap);
    }

    private void j() {
        if (!this.f6385f || this.g) {
            return;
        }
        a aVar = this.f6392n;
        if (aVar != null) {
            this.f6392n = null;
            k(aVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.f6381a.f();
        this.f6381a.d();
        this.f6389k = new a(this.f6382b, this.f6381a.a(), jUptimeMillis);
        this.f6386h.a(new o1.e().T(new r1.b(Double.valueOf(Math.random())))).i0(this.f6381a).e0(this.f6389k);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    final void a() {
        this.f6383c.clear();
        Bitmap bitmap = this.f6390l;
        if (bitmap != null) {
            this.f6384e.e(bitmap);
            this.f6390l = null;
        }
        this.f6385f = false;
        a aVar = this.f6387i;
        if (aVar != null) {
            this.d.o(aVar);
            this.f6387i = null;
        }
        a aVar2 = this.f6389k;
        if (aVar2 != null) {
            this.d.o(aVar2);
            this.f6389k = null;
        }
        a aVar3 = this.f6392n;
        if (aVar3 != null) {
            this.d.o(aVar3);
            this.f6392n = null;
        }
        this.f6381a.clear();
        this.f6388j = true;
    }

    final ByteBuffer b() {
        return this.f6381a.g().asReadOnlyBuffer();
    }

    final Bitmap c() {
        a aVar = this.f6387i;
        return aVar != null ? aVar.l() : this.f6390l;
    }

    final int d() {
        a aVar = this.f6387i;
        if (aVar != null) {
            return aVar.f6396m;
        }
        return -1;
    }

    final Bitmap e() {
        return this.f6390l;
    }

    final int f() {
        return this.f6381a.e();
    }

    final int g() {
        return this.f6394q;
    }

    final int h() {
        return this.f6381a.b() + this.f6393o;
    }

    final int i() {
        return this.p;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    final void k(a aVar) {
        this.g = false;
        if (this.f6388j) {
            this.f6382b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f6385f) {
            this.f6392n = aVar;
            return;
        }
        if (aVar.l() != null) {
            Bitmap bitmap = this.f6390l;
            if (bitmap != null) {
                this.f6384e.e(bitmap);
                this.f6390l = null;
            }
            a aVar2 = this.f6387i;
            this.f6387i = aVar;
            int size = this.f6383c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    ((b) this.f6383c.get(size)).a();
                }
            }
            if (aVar2 != null) {
                this.f6382b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        j();
    }

    final void l(l<Bitmap> lVar, Bitmap bitmap) {
        Objects.requireNonNull(lVar, "Argument must not be null");
        this.f6391m = lVar;
        Objects.requireNonNull(bitmap, "Argument must not be null");
        this.f6390l = bitmap;
        this.f6386h = this.f6386h.a(new o1.e().V(lVar));
        this.f6393o = j.d(bitmap);
        this.p = bitmap.getWidth();
        this.f6394q = bitmap.getHeight();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    final void m(b bVar) {
        if (this.f6388j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f6383c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f6383c.isEmpty();
        this.f6383c.add(bVar);
        if (!zIsEmpty || this.f6385f) {
            return;
        }
        this.f6385f = true;
        this.f6388j = false;
        j();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<j1.f$b>] */
    final void n(b bVar) {
        this.f6383c.remove(bVar);
        if (this.f6383c.isEmpty()) {
            this.f6385f = false;
        }
    }
}
