package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, u> f3718a = new HashMap<>();

    public final void a() {
        Iterator<u> it = this.f3718a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f3718a.clear();
    }

    final u b(String str) {
        return this.f3718a.get(str);
    }

    final Set<String> c() {
        return new HashSet(this.f3718a.keySet());
    }

    final void d(String str, u uVar) {
        u uVarPut = this.f3718a.put(str, uVar);
        if (uVarPut != null) {
            uVarPut.c();
        }
    }
}
