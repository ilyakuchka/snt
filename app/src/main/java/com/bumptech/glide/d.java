package com.bumptech.glide;

import Y0.m;
import a1.j;
import android.content.Context;
import com.bumptech.glide.c;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import l1.k;
import q.C0365a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private m f6072b;

    /* renamed from: c, reason: collision with root package name */
    private Z0.d f6073c;
    private Z0.h d;

    /* renamed from: e, reason: collision with root package name */
    private a1.h f6074e;

    /* renamed from: f, reason: collision with root package name */
    private b1.a f6075f;
    private b1.a g;

    /* renamed from: h, reason: collision with root package name */
    private a1.g f6076h;

    /* renamed from: i, reason: collision with root package name */
    private a1.j f6077i;

    /* renamed from: j, reason: collision with root package name */
    private l1.f f6078j;

    /* renamed from: l, reason: collision with root package name */
    private k.b f6080l;

    /* renamed from: m, reason: collision with root package name */
    private b1.a f6081m;

    /* renamed from: n, reason: collision with root package name */
    private List<o1.d<Object>> f6082n;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f6071a = new C0365a();

    /* renamed from: k, reason: collision with root package name */
    private c.a f6079k = new a();

    final class a implements c.a {
        a() {
        }

        @Override // com.bumptech.glide.c.a
        public final o1.e a() {
            return new o1.e();
        }
    }

    final class b implements c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o1.e f6083a;

        b(o1.e eVar) {
            this.f6083a = eVar;
        }

        @Override // com.bumptech.glide.c.a
        public final o1.e a() {
            o1.e eVar = this.f6083a;
            return eVar != null ? eVar : new o1.e();
        }
    }

    final c a(Context context) {
        if (this.f6075f == null) {
            this.f6075f = b1.a.d();
        }
        if (this.g == null) {
            this.g = b1.a.c();
        }
        if (this.f6081m == null) {
            this.f6081m = b1.a.b();
        }
        if (this.f6077i == null) {
            this.f6077i = new j.a(context).a();
        }
        if (this.f6078j == null) {
            this.f6078j = new l1.f();
        }
        if (this.f6073c == null) {
            int iB = this.f6077i.b();
            if (iB > 0) {
                this.f6073c = new Z0.i(iB);
            } else {
                this.f6073c = new Z0.e();
            }
        }
        if (this.d == null) {
            this.d = new Z0.h(this.f6077i.a());
        }
        if (this.f6074e == null) {
            this.f6074e = new a1.h(this.f6077i.c());
        }
        if (this.f6076h == null) {
            this.f6076h = new a1.g(context);
        }
        if (this.f6072b == null) {
            this.f6072b = new m(this.f6074e, this.f6076h, this.g, this.f6075f, b1.a.e(), this.f6081m);
        }
        List<o1.d<Object>> list = this.f6082n;
        if (list == null) {
            this.f6082n = Collections.emptyList();
        } else {
            this.f6082n = Collections.unmodifiableList(list);
        }
        return new c(context, this.f6072b, this.f6074e, this.f6073c, this.d, new k(this.f6080l), this.f6078j, this.f6079k, this.f6071a, this.f6082n);
    }

    public final d b(o1.e eVar) {
        this.f6079k = new b(eVar);
        return this;
    }

    public final d c(a1.j jVar) {
        this.f6077i = jVar;
        return this;
    }

    final void d(k.b bVar) {
        this.f6080l = bVar;
    }
}
