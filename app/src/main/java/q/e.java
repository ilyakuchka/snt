package q;

/* loaded from: classes.dex */
public final class e<E> implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    private static final Object f7618m = new Object();

    /* renamed from: i, reason: collision with root package name */
    private boolean f7619i = false;

    /* renamed from: j, reason: collision with root package name */
    private long[] f7620j;

    /* renamed from: k, reason: collision with root package name */
    private Object[] f7621k;

    /* renamed from: l, reason: collision with root package name */
    private int f7622l;

    public e() {
        int iD = c.d(10);
        this.f7620j = new long[iD];
        this.f7621k = new Object[iD];
    }

    private void c() {
        int i2 = this.f7622l;
        long[] jArr = this.f7620j;
        Object[] objArr = this.f7621k;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            Object obj = objArr[i5];
            if (obj != f7618m) {
                if (i5 != i4) {
                    jArr[i4] = jArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f7619i = false;
        this.f7622l = i4;
    }

    public final void a() {
        int i2 = this.f7622l;
        Object[] objArr = this.f7621k;
        for (int i4 = 0; i4 < i2; i4++) {
            objArr[i4] = null;
        }
        this.f7622l = 0;
        this.f7619i = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.f7620j = (long[]) this.f7620j.clone();
            eVar.f7621k = (Object[]) this.f7621k.clone();
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E d(long j2, E e2) {
        int iB = c.b(this.f7620j, this.f7622l, j2);
        if (iB >= 0) {
            Object[] objArr = this.f7621k;
            if (objArr[iB] != f7618m) {
                return (E) objArr[iB];
            }
        }
        return e2;
    }

    public final void e(long j2, E e2) {
        int iB = c.b(this.f7620j, this.f7622l, j2);
        if (iB >= 0) {
            this.f7621k[iB] = e2;
            return;
        }
        int i2 = ~iB;
        int i4 = this.f7622l;
        if (i2 < i4) {
            Object[] objArr = this.f7621k;
            if (objArr[i2] == f7618m) {
                this.f7620j[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f7619i && i4 >= this.f7620j.length) {
            c();
            i2 = ~c.b(this.f7620j, this.f7622l, j2);
        }
        int i5 = this.f7622l;
        if (i5 >= this.f7620j.length) {
            int iD = c.d(i5 + 1);
            long[] jArr = new long[iD];
            Object[] objArr2 = new Object[iD];
            long[] jArr2 = this.f7620j;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f7621k;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f7620j = jArr;
            this.f7621k = objArr2;
        }
        int i6 = this.f7622l;
        if (i6 - i2 != 0) {
            long[] jArr3 = this.f7620j;
            int i7 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i7, i6 - i2);
            Object[] objArr4 = this.f7621k;
            System.arraycopy(objArr4, i2, objArr4, i7, this.f7622l - i2);
        }
        this.f7620j[i2] = j2;
        this.f7621k[i2] = e2;
        this.f7622l++;
    }

    public final void f(long j2) {
        int iB = c.b(this.f7620j, this.f7622l, j2);
        if (iB >= 0) {
            Object[] objArr = this.f7621k;
            Object obj = objArr[iB];
            Object obj2 = f7618m;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f7619i = true;
            }
        }
    }

    public final void g(int i2) {
        Object[] objArr = this.f7621k;
        Object obj = objArr[i2];
        Object obj2 = f7618m;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f7619i = true;
        }
    }

    public final int h() {
        if (this.f7619i) {
            c();
        }
        return this.f7622l;
    }

    public final E i(int i2) {
        if (this.f7619i) {
            c();
        }
        return (E) this.f7621k[i2];
    }

    public final String toString() {
        if (this.f7619i) {
            c();
        }
        int i2 = this.f7622l;
        if (i2 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i2 * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f7622l; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            if (this.f7619i) {
                c();
            }
            sb.append(this.f7620j[i4]);
            sb.append('=');
            if (this.f7619i) {
                c();
            }
            Object obj = this.f7621k[i4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
