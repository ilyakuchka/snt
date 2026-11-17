package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.g;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3664a;

    /* renamed from: b, reason: collision with root package name */
    private final b.a f3665b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3664a = obj;
        this.f3665b = b.f3670c.b(obj.getClass());
    }

    @Override // androidx.lifecycle.i
    public final void g(k kVar, g.b bVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f3665b.a(kVar, bVar, this.f3664a);
    }
}
