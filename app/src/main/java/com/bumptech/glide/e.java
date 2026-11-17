package com.bumptech.glide;

import Y0.m;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.c;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    static final j<?, ?> f6084k = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Z0.b f6085a;

    /* renamed from: b, reason: collision with root package name */
    private final g f6086b;

    /* renamed from: c, reason: collision with root package name */
    private final p2.c f6087c;
    private final c.a d;

    /* renamed from: e, reason: collision with root package name */
    private final List<o1.d<Object>> f6088e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f6089f;
    private final m g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f6090h;

    /* renamed from: i, reason: collision with root package name */
    private final int f6091i;

    /* renamed from: j, reason: collision with root package name */
    private o1.e f6092j;

    public e(Context context, Z0.b bVar, g gVar, p2.c cVar, c.a aVar, Map map, List list, m mVar) {
        super(context.getApplicationContext());
        this.f6085a = bVar;
        this.f6086b = gVar;
        this.f6087c = cVar;
        this.d = aVar;
        this.f6088e = list;
        this.f6089f = map;
        this.g = mVar;
        this.f6090h = false;
        this.f6091i = 4;
    }

    public final <X> p1.g<ImageView, X> a(ImageView imageView, Class<X> cls) {
        Objects.requireNonNull(this.f6087c);
        if (Bitmap.class.equals(cls)) {
            return new p1.b(imageView, 0);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new p1.b(imageView, 1);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }

    public final Z0.b b() {
        return this.f6085a;
    }

    public final List<o1.d<Object>> c() {
        return this.f6088e;
    }

    public final synchronized o1.e d() {
        if (this.f6092j == null) {
            this.f6092j = this.d.a().J();
        }
        return this.f6092j;
    }

    public final <T> j<?, T> e(Class<T> cls) {
        j<?, T> jVar = (j) this.f6089f.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : this.f6089f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j) entry.getValue();
                }
            }
        }
        return jVar == null ? (j<?, T>) f6084k : jVar;
    }

    public final m f() {
        return this.g;
    }

    public final int g() {
        return this.f6091i;
    }

    public final g h() {
        return this.f6086b;
    }

    public final boolean i() {
        return this.f6090h;
    }
}
