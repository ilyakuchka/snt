package N;

import N.e;
import N.i;
import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Executor;
import n.C0352a;

/* loaded from: classes.dex */
public final class g<Key, Value> {

    /* renamed from: a, reason: collision with root package name */
    private i.f f649a;

    /* renamed from: b, reason: collision with root package name */
    private e.a<Key, Value> f650b;

    /* renamed from: c, reason: collision with root package name */
    private i.c f651c;

    @SuppressLint({"RestrictedApi"})
    private Executor d = C0352a.j();

    public g(e.a<Key, Value> aVar, i.f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("PagedList.Config must be provided");
        }
        this.f650b = aVar;
        this.f649a = fVar;
    }

    @SuppressLint({"RestrictedApi"})
    public final LiveData<i<Value>> a() {
        i.f fVar = this.f649a;
        i.c cVar = this.f651c;
        e.a<Key, Value> aVar = this.f650b;
        Executor executorL = C0352a.l();
        Executor executor = this.d;
        return (LiveData<i<Value>>) new f(executor, aVar, fVar, executorL, executor, cVar).b();
    }

    public final g<Key, Value> b(i.c<Value> cVar) {
        this.f651c = cVar;
        return this;
    }
}
