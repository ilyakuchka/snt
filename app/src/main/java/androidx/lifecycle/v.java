package androidx.lifecycle;

import java.util.Objects;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final a f3716a;

    /* renamed from: b, reason: collision with root package name */
    private final w f3717b;

    public interface a {
        u a();
    }

    static abstract class b extends c implements a {
        b() {
        }

        @Override // androidx.lifecycle.v.a
        public final u a() {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract u b();
    }

    static class c {
        c() {
        }
    }

    public v(w wVar, a aVar) {
        this.f3716a = aVar;
        this.f3717b = wVar;
    }

    public final <T extends u> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        String strC = D2.e.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
        T t2 = (T) this.f3717b.b(strC);
        if (!cls.isInstance(t2)) {
            a aVar = this.f3716a;
            T t4 = (T) (aVar instanceof b ? ((b) aVar).b() : aVar.a());
            this.f3717b.d(strC, t4);
            return t4;
        }
        Object obj = this.f3716a;
        if (!(obj instanceof c)) {
            return t2;
        }
        Objects.requireNonNull((c) obj);
        return t2;
    }
}
