package x;

import java.util.Objects;

/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ d f8007i;

    c(d dVar) {
        this.f8007i = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Objects.requireNonNull(this.f8007i);
    }
}
