package g3;

import Z2.p;
import java.util.NoSuchElementException;

/* renamed from: g3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0325b extends p {

    /* renamed from: i, reason: collision with root package name */
    private final int f6304i;

    /* renamed from: j, reason: collision with root package name */
    private final int f6305j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6306k;

    /* renamed from: l, reason: collision with root package name */
    private int f6307l;

    public C0325b(int i2, int i4, int i5) {
        this.f6304i = i5;
        this.f6305j = i4;
        boolean z4 = true;
        if (i5 <= 0 ? i2 < i4 : i2 > i4) {
            z4 = false;
        }
        this.f6306k = z4;
        this.f6307l = z4 ? i2 : i4;
    }

    @Override // Z2.p
    public final int a() {
        int i2 = this.f6307l;
        if (i2 != this.f6305j) {
            this.f6307l = this.f6304i + i2;
        } else {
            if (!this.f6306k) {
                throw new NoSuchElementException();
            }
            this.f6306k = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6306k;
    }
}
