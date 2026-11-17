package o1;

import V0.h;
import Y0.l;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.android.mmt.R;
import f1.j;
import f1.k;
import f1.m;
import f1.o;
import java.util.Map;
import java.util.Objects;
import o1.a;

/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: B, reason: collision with root package name */
    private boolean f7520B;

    /* renamed from: C, reason: collision with root package name */
    private Resources.Theme f7521C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f7522D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f7523E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f7524F;

    /* renamed from: H, reason: collision with root package name */
    private boolean f7526H;

    /* renamed from: i, reason: collision with root package name */
    private int f7527i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f7531m;

    /* renamed from: n, reason: collision with root package name */
    private int f7532n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f7533o;
    private int p;
    private boolean u;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f7539w;

    /* renamed from: x, reason: collision with root package name */
    private int f7540x;

    /* renamed from: j, reason: collision with root package name */
    private float f7528j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    private l f7529k = l.d;

    /* renamed from: l, reason: collision with root package name */
    private com.bumptech.glide.f f7530l = com.bumptech.glide.f.NORMAL;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7534q = true;

    /* renamed from: r, reason: collision with root package name */
    private int f7535r = -1;

    /* renamed from: s, reason: collision with root package name */
    private int f7536s = -1;

    /* renamed from: t, reason: collision with root package name */
    private V0.f f7537t = r1.a.c();

    /* renamed from: v, reason: collision with root package name */
    private boolean f7538v = true;

    /* renamed from: y, reason: collision with root package name */
    private h f7541y = new h();

    /* renamed from: z, reason: collision with root package name */
    private Map<Class<?>, V0.l<?>> f7542z = new s1.b();

    /* renamed from: A, reason: collision with root package name */
    private Class<?> f7519A = Object.class;

    /* renamed from: G, reason: collision with root package name */
    private boolean f7525G = true;

    private static boolean F(int i2, int i4) {
        return (i2 & i4) != 0;
    }

    private T R() {
        if (this.f7520B) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public final Map<Class<?>, V0.l<?>> A() {
        return this.f7542z;
    }

    public final boolean B() {
        return this.f7526H;
    }

    public final boolean C() {
        return this.f7523E;
    }

    public final boolean D() {
        return this.f7534q;
    }

    final boolean E() {
        return this.f7525G;
    }

    public final boolean G() {
        return this.f7538v;
    }

    public final boolean H() {
        return this.u;
    }

    public final boolean I() {
        return F(this.f7527i, 2048);
    }

    public T J() {
        this.f7520B = true;
        return this;
    }

    public T K() {
        return (T) N(j.f6191c, new f1.g());
    }

    public T L() {
        T t2 = (T) N(j.f6190b, new f1.h());
        t2.f7525G = true;
        return t2;
    }

    public T M() {
        T t2 = (T) N(j.f6189a, new o());
        t2.f7525G = true;
        return t2;
    }

    final T N(j jVar, V0.l<Bitmap> lVar) {
        if (this.f7522D) {
            return (T) clone().N(jVar, lVar);
        }
        h(jVar);
        return (T) W(lVar, false);
    }

    public T O(int i2, int i4) {
        if (this.f7522D) {
            return (T) clone().O(i2, i4);
        }
        this.f7536s = i2;
        this.f7535r = i4;
        this.f7527i |= 512;
        R();
        return this;
    }

    public a P() {
        if (this.f7522D) {
            return clone().P();
        }
        this.p = R.drawable.message_attachment_default;
        int i2 = this.f7527i | 128;
        this.f7533o = null;
        this.f7527i = i2 & (-65);
        R();
        return this;
    }

    public a Q() {
        com.bumptech.glide.f fVar = com.bumptech.glide.f.LOW;
        if (this.f7522D) {
            return clone().Q();
        }
        this.f7530l = fVar;
        this.f7527i |= 8;
        R();
        return this;
    }

    public <Y> T S(V0.g<Y> gVar, Y y2) {
        if (this.f7522D) {
            return (T) clone().S(gVar, y2);
        }
        Objects.requireNonNull(gVar, "Argument must not be null");
        this.f7541y.e(gVar, y2);
        R();
        return this;
    }

    public T T(V0.f fVar) {
        if (this.f7522D) {
            return (T) clone().T(fVar);
        }
        this.f7537t = fVar;
        this.f7527i |= 1024;
        R();
        return this;
    }

    public a U() {
        if (this.f7522D) {
            return clone().U();
        }
        this.f7534q = false;
        this.f7527i |= 256;
        R();
        return this;
    }

    public T V(V0.l<Bitmap> lVar) {
        return (T) W(lVar, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final T W(V0.l<Bitmap> lVar, boolean z4) {
        if (this.f7522D) {
            return (T) clone().W(lVar, z4);
        }
        m mVar = new m(lVar, z4);
        X(Bitmap.class, lVar, z4);
        X(Drawable.class, mVar, z4);
        X(BitmapDrawable.class, mVar, z4);
        X(j1.c.class, new j1.e(lVar), z4);
        R();
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map<java.lang.Class<?>, V0.l<?>>, s1.b] */
    final <Y> T X(Class<Y> cls, V0.l<Y> lVar, boolean z4) {
        if (this.f7522D) {
            return (T) clone().X(cls, lVar, z4);
        }
        Objects.requireNonNull(lVar, "Argument must not be null");
        this.f7542z.put(cls, lVar);
        int i2 = this.f7527i | 2048;
        this.f7538v = true;
        int i4 = i2 | 65536;
        this.f7527i = i4;
        this.f7525G = false;
        if (z4) {
            this.f7527i = i4 | 131072;
            this.u = true;
        }
        R();
        return this;
    }

    final a Y(V0.l lVar) {
        j jVar = j.f6191c;
        if (this.f7522D) {
            return clone().Y(lVar);
        }
        h(jVar);
        return V(lVar);
    }

    public a Z() {
        if (this.f7522D) {
            return clone().Z();
        }
        this.f7526H = true;
        this.f7527i |= 1048576;
        R();
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v45, types: [java.util.Map<java.lang.Class<?>, V0.l<?>>, s1.b] */
    public T a(a<?> aVar) {
        if (this.f7522D) {
            return (T) clone().a(aVar);
        }
        if (F(aVar.f7527i, 2)) {
            this.f7528j = aVar.f7528j;
        }
        if (F(aVar.f7527i, 262144)) {
            this.f7523E = aVar.f7523E;
        }
        if (F(aVar.f7527i, 1048576)) {
            this.f7526H = aVar.f7526H;
        }
        if (F(aVar.f7527i, 4)) {
            this.f7529k = aVar.f7529k;
        }
        if (F(aVar.f7527i, 8)) {
            this.f7530l = aVar.f7530l;
        }
        if (F(aVar.f7527i, 16)) {
            this.f7531m = aVar.f7531m;
            this.f7532n = 0;
            this.f7527i &= -33;
        }
        if (F(aVar.f7527i, 32)) {
            this.f7532n = aVar.f7532n;
            this.f7531m = null;
            this.f7527i &= -17;
        }
        if (F(aVar.f7527i, 64)) {
            this.f7533o = aVar.f7533o;
            this.p = 0;
            this.f7527i &= -129;
        }
        if (F(aVar.f7527i, 128)) {
            this.p = aVar.p;
            this.f7533o = null;
            this.f7527i &= -65;
        }
        if (F(aVar.f7527i, 256)) {
            this.f7534q = aVar.f7534q;
        }
        if (F(aVar.f7527i, 512)) {
            this.f7536s = aVar.f7536s;
            this.f7535r = aVar.f7535r;
        }
        if (F(aVar.f7527i, 1024)) {
            this.f7537t = aVar.f7537t;
        }
        if (F(aVar.f7527i, 4096)) {
            this.f7519A = aVar.f7519A;
        }
        if (F(aVar.f7527i, 8192)) {
            this.f7539w = aVar.f7539w;
            this.f7540x = 0;
            this.f7527i &= -16385;
        }
        if (F(aVar.f7527i, 16384)) {
            this.f7540x = aVar.f7540x;
            this.f7539w = null;
            this.f7527i &= -8193;
        }
        if (F(aVar.f7527i, 32768)) {
            this.f7521C = aVar.f7521C;
        }
        if (F(aVar.f7527i, 65536)) {
            this.f7538v = aVar.f7538v;
        }
        if (F(aVar.f7527i, 131072)) {
            this.u = aVar.u;
        }
        if (F(aVar.f7527i, 2048)) {
            this.f7542z.putAll(aVar.f7542z);
            this.f7525G = aVar.f7525G;
        }
        if (F(aVar.f7527i, 524288)) {
            this.f7524F = aVar.f7524F;
        }
        if (!this.f7538v) {
            this.f7542z.clear();
            int i2 = this.f7527i & (-2049);
            this.u = false;
            this.f7527i = i2 & (-131073);
            this.f7525G = true;
        }
        this.f7527i |= aVar.f7527i;
        this.f7541y.d(aVar.f7541y);
        R();
        return this;
    }

    public T b() {
        if (this.f7520B && !this.f7522D) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f7522D = true;
        return (T) J();
    }

    public T c() {
        j jVar = j.f6191c;
        return (T) Y(new f1.g());
    }

    @Override // 
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t2 = (T) super.clone();
            h hVar = new h();
            t2.f7541y = hVar;
            hVar.d(this.f7541y);
            s1.b bVar = new s1.b();
            t2.f7542z = bVar;
            bVar.putAll(this.f7542z);
            t2.f7520B = false;
            t2.f7522D = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public T e(Class<?> cls) {
        if (this.f7522D) {
            return (T) clone().e(cls);
        }
        this.f7519A = cls;
        this.f7527i |= 4096;
        R();
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.Map<java.lang.Class<?>, V0.l<?>>, q.g] */
    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Float.compare(aVar.f7528j, this.f7528j) == 0 && this.f7532n == aVar.f7532n && s1.j.b(this.f7531m, aVar.f7531m) && this.p == aVar.p && s1.j.b(this.f7533o, aVar.f7533o) && this.f7540x == aVar.f7540x && s1.j.b(this.f7539w, aVar.f7539w) && this.f7534q == aVar.f7534q && this.f7535r == aVar.f7535r && this.f7536s == aVar.f7536s && this.u == aVar.u && this.f7538v == aVar.f7538v && this.f7523E == aVar.f7523E && this.f7524F == aVar.f7524F && this.f7529k.equals(aVar.f7529k) && this.f7530l == aVar.f7530l && this.f7541y.equals(aVar.f7541y) && this.f7542z.equals(aVar.f7542z) && this.f7519A.equals(aVar.f7519A) && s1.j.b(this.f7537t, aVar.f7537t) && s1.j.b(this.f7521C, aVar.f7521C)) {
                return true;
            }
        }
        return false;
    }

    public T f(l lVar) {
        if (this.f7522D) {
            return (T) clone().f(lVar);
        }
        this.f7529k = lVar;
        this.f7527i |= 4;
        R();
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.Class<?>, V0.l<?>>, s1.b] */
    public T g() {
        if (this.f7522D) {
            return (T) clone().g();
        }
        this.f7542z.clear();
        int i2 = this.f7527i & (-2049);
        this.u = false;
        this.f7538v = false;
        this.f7527i = (i2 & (-131073)) | 65536;
        this.f7525G = true;
        R();
        return this;
    }

    public T h(j jVar) {
        return (T) S(j.f6193f, jVar);
    }

    public final int hashCode() {
        float f4 = this.f7528j;
        int i2 = s1.j.f7867c;
        return s1.j.f(this.f7521C, s1.j.f(this.f7537t, s1.j.f(this.f7519A, s1.j.f(this.f7542z, s1.j.f(this.f7541y, s1.j.f(this.f7530l, s1.j.f(this.f7529k, (((((((((((((s1.j.f(this.f7539w, (s1.j.f(this.f7533o, (s1.j.f(this.f7531m, ((Float.floatToIntBits(f4) + 527) * 31) + this.f7532n) * 31) + this.p) * 31) + this.f7540x) * 31) + (this.f7534q ? 1 : 0)) * 31) + this.f7535r) * 31) + this.f7536s) * 31) + (this.u ? 1 : 0)) * 31) + (this.f7538v ? 1 : 0)) * 31) + (this.f7523E ? 1 : 0)) * 31) + (this.f7524F ? 1 : 0))))))));
    }

    public a i() {
        if (this.f7522D) {
            return clone().i();
        }
        this.f7532n = R.drawable.message_attachment_default;
        int i2 = this.f7527i | 32;
        this.f7531m = null;
        this.f7527i = i2 & (-17);
        R();
        return this;
    }

    public a j() {
        V0.b bVar = V0.b.f1753j;
        return S(k.f6194f, bVar).S(j1.h.f6401a, bVar);
    }

    public final l k() {
        return this.f7529k;
    }

    public final int l() {
        return this.f7532n;
    }

    public final Drawable m() {
        return this.f7531m;
    }

    public final Drawable n() {
        return this.f7539w;
    }

    public final int o() {
        return this.f7540x;
    }

    public final boolean p() {
        return this.f7524F;
    }

    public final h q() {
        return this.f7541y;
    }

    public final int r() {
        return this.f7535r;
    }

    public final int s() {
        return this.f7536s;
    }

    public final Drawable t() {
        return this.f7533o;
    }

    public final int u() {
        return this.p;
    }

    public final com.bumptech.glide.f v() {
        return this.f7530l;
    }

    public final Class<?> w() {
        return this.f7519A;
    }

    public final V0.f x() {
        return this.f7537t;
    }

    public final float y() {
        return this.f7528j;
    }

    public final Resources.Theme z() {
        return this.f7521C;
    }
}
