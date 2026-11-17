package g0;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

/* renamed from: g0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0313i {

    /* renamed from: a, reason: collision with root package name */
    private Vector<C0318n> f6254a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, C0318n> f6255b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, C0318n> f6256c;
    private Map<String, C0318n> d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, C0318n> f6257e;

    public C0313i() {
        this.f6254a = null;
        this.f6255b = null;
        this.f6256c = null;
        this.d = null;
        this.f6257e = null;
        this.f6254a = new Vector<>();
        this.f6255b = new HashMap();
        this.f6256c = new HashMap();
        this.d = new HashMap();
        this.f6257e = new HashMap();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    private void i(C0318n c0318n) {
        byte[] bArrD = c0318n.d();
        if (bArrD != null) {
            this.f6255b.put(new String(bArrD), c0318n);
        }
        byte[] bArrE = c0318n.e();
        if (bArrE != null) {
            this.f6256c.put(new String(bArrE), c0318n);
        }
        byte[] bArrK = c0318n.k();
        if (bArrK != null) {
            this.d.put(new String(bArrK), c0318n);
        }
        byte[] bArrJ = c0318n.j();
        if (bArrJ != null) {
            this.f6257e.put(new String(bArrJ), c0318n);
        }
    }

    public final void a(C0318n c0318n) {
        Objects.requireNonNull(c0318n);
        i(c0318n);
        this.f6254a.add(0, c0318n);
    }

    public final boolean b(C0318n c0318n) {
        Objects.requireNonNull(c0318n);
        i(c0318n);
        return this.f6254a.add(c0318n);
    }

    public final C0318n c(int i2) {
        return this.f6254a.get(i2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    public final C0318n d(String str) {
        return (C0318n) this.f6255b.get(str);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    public final C0318n e(String str) {
        return (C0318n) this.f6256c.get(str);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    public final C0318n f(String str) {
        return (C0318n) this.f6257e.get(str);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.String, g0.n>] */
    public final C0318n g(String str) {
        return (C0318n) this.d.get(str);
    }

    public final int h() {
        return this.f6254a.size();
    }

    public final void j() {
        this.f6254a.clear();
    }
}
