package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.c;
import l1.l;
import l1.m;
import l1.o;

/* loaded from: classes.dex */
public class i implements ComponentCallbacks2, l1.h {

    /* renamed from: t, reason: collision with root package name */
    private static final o1.e f6113t = new o1.e().e(Bitmap.class).J();

    /* renamed from: i, reason: collision with root package name */
    protected final c f6114i;

    /* renamed from: j, reason: collision with root package name */
    protected final Context f6115j;

    /* renamed from: k, reason: collision with root package name */
    final l1.g f6116k;

    /* renamed from: l, reason: collision with root package name */
    private final m f6117l;

    /* renamed from: m, reason: collision with root package name */
    private final l f6118m;

    /* renamed from: n, reason: collision with root package name */
    private final o f6119n;

    /* renamed from: o, reason: collision with root package name */
    private final Runnable f6120o;
    private final Handler p;

    /* renamed from: q, reason: collision with root package name */
    private final l1.c f6121q;

    /* renamed from: r, reason: collision with root package name */
    private final CopyOnWriteArrayList<o1.d<Object>> f6122r;

    /* renamed from: s, reason: collision with root package name */
    private o1.e f6123s;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            i iVar = i.this;
            iVar.f6116k.a(iVar);
        }
    }

    private class b implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private final m f6125a;

        b(m mVar) {
            this.f6125a = mVar;
        }

        @Override // l1.c.a
        public final void a(boolean z4) {
            if (z4) {
                synchronized (i.this) {
                    this.f6125a.d();
                }
            }
        }
    }

    static {
        new o1.e().e(j1.c.class).J();
    }

    public i(c cVar, l1.g gVar, l lVar, Context context) {
        m mVar = new m();
        l1.d dVarF = cVar.f();
        this.f6119n = new o();
        a aVar = new a();
        this.f6120o = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.p = handler;
        this.f6114i = cVar;
        this.f6116k = gVar;
        this.f6118m = lVar;
        this.f6117l = mVar;
        this.f6115j = context;
        l1.c cVarA = ((l1.f) dVarF).a(context.getApplicationContext(), new b(mVar));
        this.f6121q = cVarA;
        if (s1.j.g()) {
            handler.post(aVar);
        } else {
            gVar.a(this);
        }
        gVar.a(cVarA);
        this.f6122r = new CopyOnWriteArrayList<>(cVar.h().c());
        s(cVar.h().d());
        cVar.k(this);
    }

    @Override // l1.h
    public final synchronized void a() {
        synchronized (this) {
            this.f6117l.c();
        }
        this.f6119n.a();
    }

    @Override // l1.h
    public final synchronized void d() {
        synchronized (this) {
            this.f6117l.e();
        }
        this.f6119n.d();
    }

    @Override // l1.h
    public final synchronized void e() {
        this.f6119n.e();
        Iterator it = ((ArrayList) this.f6119n.m()).iterator();
        while (it.hasNext()) {
            o((p1.f) it.next());
        }
        this.f6119n.l();
        this.f6117l.b();
        this.f6116k.b(this);
        this.f6116k.b(this.f6121q);
        this.p.removeCallbacks(this.f6120o);
        this.f6114i.n(this);
    }

    public <ResourceType> h<ResourceType> l(Class<ResourceType> cls) {
        return new h<>(this.f6114i, this, cls, this.f6115j);
    }

    public h<Bitmap> m() {
        return l(Bitmap.class).a(f6113t);
    }

    public h<Drawable> n() {
        return l(Drawable.class);
    }

    public final void o(p1.f<?> fVar) {
        if (fVar == null) {
            return;
        }
        boolean zU = u(fVar);
        o1.b bVarI = fVar.i();
        if (zU || this.f6114i.l(fVar) || bVarI == null) {
            return;
        }
        fVar.b(null);
        bVarI.clear();
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
    }

    final List<o1.d<Object>> p() {
        return this.f6122r;
    }

    final synchronized o1.e q() {
        return this.f6123s;
    }

    public h<Drawable> r(Uri uri) {
        return n().h0(uri);
    }

    protected synchronized void s(o1.e eVar) {
        this.f6123s = eVar.clone().b();
    }

    final synchronized void t(p1.f<?> fVar, o1.b bVar) {
        this.f6119n.n(fVar);
        this.f6117l.f(bVar);
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f6117l + ", treeNode=" + this.f6118m + "}";
    }

    final synchronized boolean u(p1.f<?> fVar) {
        o1.b bVarI = fVar.i();
        if (bVarI == null) {
            return true;
        }
        if (!this.f6117l.a(bVarI)) {
            return false;
        }
        this.f6119n.o(fVar);
        fVar.b(null);
        return true;
    }
}
