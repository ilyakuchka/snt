package r0;

import android.util.LongSparseArray;

/* renamed from: r0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0376a {

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<b> f7685a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final LongSparseArray<String> f7686b = new LongSparseArray<>();

    public final b a(long j2) {
        return this.f7685a.get(j2);
    }

    public final void b(long j2) {
        this.f7685a.remove(j2);
    }

    public final void c(long j2) {
        this.f7686b.remove(j2);
    }
}
