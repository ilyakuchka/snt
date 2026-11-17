package g3;

import java.util.Iterator;
import t.C0384b;

/* renamed from: g3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0324a implements Iterable<Integer> {

    /* renamed from: i, reason: collision with root package name */
    private final int f6301i;

    /* renamed from: j, reason: collision with root package name */
    private final int f6302j;

    /* renamed from: k, reason: collision with root package name */
    private final int f6303k;

    public C0324a(int i2, int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f6301i = i2;
        this.f6302j = C0384b.o(i2, i4, i5);
        this.f6303k = i5;
    }

    public final int d() {
        return this.f6301i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0324a) {
            if (!isEmpty() || !((C0324a) obj).isEmpty()) {
                C0324a c0324a = (C0324a) obj;
                if (this.f6301i != c0324a.f6301i || this.f6302j != c0324a.f6302j || this.f6303k != c0324a.f6303k) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f6302j;
    }

    public final int h() {
        return this.f6303k;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f6303k + (((this.f6301i * 31) + this.f6302j) * 31);
    }

    public boolean isEmpty() {
        if (this.f6303k > 0) {
            if (this.f6301i > this.f6302j) {
                return true;
            }
        } else if (this.f6301i < this.f6302j) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        return new C0325b(this.f6301i, this.f6302j, this.f6303k);
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f6303k > 0) {
            sb = new StringBuilder();
            sb.append(this.f6301i);
            sb.append("..");
            sb.append(this.f6302j);
            sb.append(" step ");
            i2 = this.f6303k;
        } else {
            sb = new StringBuilder();
            sb.append(this.f6301i);
            sb.append(" downTo ");
            sb.append(this.f6302j);
            sb.append(" step ");
            i2 = -this.f6303k;
        }
        sb.append(i2);
        return sb.toString();
    }
}
