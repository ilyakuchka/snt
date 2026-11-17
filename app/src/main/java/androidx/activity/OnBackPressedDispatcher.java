package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f2233a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayDeque<b> f2234b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements i, androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final g f2235a;

        /* renamed from: b, reason: collision with root package name */
        private final b f2236b;

        /* renamed from: c, reason: collision with root package name */
        private a f2237c;

        LifecycleOnBackPressedCancellable(g gVar, b bVar) {
            this.f2235a = gVar;
            this.f2236b = bVar;
            gVar.a(this);
        }

        @Override // androidx.activity.a
        public final void cancel() {
            this.f2235a.c(this);
            this.f2236b.e(this);
            a aVar = this.f2237c;
            if (aVar != null) {
                aVar.cancel();
                this.f2237c = null;
            }
        }

        @Override // androidx.lifecycle.i
        public final void g(k kVar, g.b bVar) {
            if (bVar == g.b.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar2 = this.f2236b;
                onBackPressedDispatcher.f2234b.add(bVar2);
                a aVar = onBackPressedDispatcher.new a(bVar2);
                bVar2.a(aVar);
                this.f2237c = aVar;
                return;
            }
            if (bVar != g.b.ON_STOP) {
                if (bVar == g.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                a aVar2 = this.f2237c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }

    private class a implements androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final b f2238a;

        a(b bVar) {
            this.f2238a = bVar;
        }

        @Override // androidx.activity.a
        public final void cancel() {
            OnBackPressedDispatcher.this.f2234b.remove(this.f2238a);
            this.f2238a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f2233a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public final void a(k kVar, b bVar) {
        g gVarA = kVar.a();
        if (gVarA.b() == g.c.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(gVarA, bVar));
    }

    public final void b() {
        Iterator<b> itDescendingIterator = this.f2234b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            b next = itDescendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f2233a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
