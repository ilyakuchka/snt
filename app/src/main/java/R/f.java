package R;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    final Set<LiveData> f1234a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final i f1235b;

    f(i iVar) {
        this.f1235b = iVar;
    }

    final LiveData a(String[] strArr, Callable callable) {
        return new l(this.f1235b, this, callable, strArr);
    }
}
