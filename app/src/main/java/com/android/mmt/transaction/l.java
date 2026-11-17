package com.android.mmt.transaction;

import O0.v;
import O0.w;
import P0.r;
import android.content.Context;
import android.net.Network;
import android.util.Pair;
import f0.C0303b;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class l extends O0.k {

    /* renamed from: q, reason: collision with root package name */
    protected static volatile long f4638q;

    /* renamed from: r, reason: collision with root package name */
    protected static volatile int f4639r;

    /* renamed from: k, reason: collision with root package name */
    protected Context f4640k;

    /* renamed from: l, reason: collision with root package name */
    protected String f4641l;

    /* renamed from: m, reason: collision with root package name */
    protected w f4642m = new w();

    /* renamed from: n, reason: collision with root package name */
    protected v f4643n;

    /* renamed from: o, reason: collision with root package name */
    private Network f4644o;
    protected long p;

    public l(Context context, v vVar) {
        this.f4640k = context;
        this.f4643n = vVar;
    }

    public static long d() {
        return f4638q;
    }

    public static int e() {
        return f4639r;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return getClass().equals(lVar.getClass()) && this.f4641l.equals(lVar.f4641l);
    }

    protected final byte[] f(String str) throws IOException {
        int i2 = r.f937c;
        return a.f(this.f4640k, 0L, str, null, 2, this.f4643n.d(), this.f4643n.b(), this.f4643n.c(), this.f4644o);
    }

    public abstract int g();

    public void h() {
    }

    public final int hashCode() {
        return Pair.create(getClass(), this.f4641l).hashCode();
    }

    public void i() {
    }

    public abstract void j();

    protected final byte[] k(byte[] bArr, O0.m mVar) throws C0303b, IOException {
        return l(bArr, this.f4643n.a());
    }

    protected final byte[] l(byte[] bArr, String str) throws IOException {
        int i2 = r.f937c;
        return a.f(this.f4640k, 0L, str, bArr, 1, this.f4643n.d(), this.f4643n.b(), this.f4643n.c(), this.f4644o);
    }

    public final void m(Network network) {
        this.f4644o = network;
    }

    public final String toString() {
        String simpleName = getClass().getSimpleName();
        w wVar = this.f4642m;
        if (wVar == null || wVar.a() == null) {
            return D2.e.c(simpleName, ", uri=null");
        }
        return simpleName + ", uri=" + this.f4642m.a();
    }
}
