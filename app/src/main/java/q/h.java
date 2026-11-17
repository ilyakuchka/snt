package q;

/* loaded from: classes.dex */
public final class h<E> implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    private static final Object f7634m = new Object();

    /* renamed from: i, reason: collision with root package name */
    private boolean f7635i = false;

    /* renamed from: j, reason: collision with root package name */
    private int[] f7636j;

    /* renamed from: k, reason: collision with root package name */
    private Object[] f7637k;

    /* renamed from: l, reason: collision with root package name */
    private int f7638l;

    public h() {
        int iC = c.c(10);
        this.f7636j = new int[iC];
        this.f7637k = new Object[iC];
    }

    private void d() {
        int i2 = this.f7638l;
        int[] iArr = this.f7636j;
        Object[] objArr = this.f7637k;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            Object obj = objArr[i5];
            if (obj != f7634m) {
                if (i5 != i4) {
                    iArr[i4] = iArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f7635i = false;
        this.f7638l = i4;
    }

    public final void a(int i2, E e2) {
        int i4 = this.f7638l;
        if (i4 != 0 && i2 <= this.f7636j[i4 - 1]) {
            h(i2, e2);
            return;
        }
        if (this.f7635i && i4 >= this.f7636j.length) {
            d();
        }
        int i5 = this.f7638l;
        if (i5 >= this.f7636j.length) {
            int iC = c.c(i5 + 1);
            int[] iArr = new int[iC];
            Object[] objArr = new Object[iC];
            int[] iArr2 = this.f7636j;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f7637k;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f7636j = iArr;
            this.f7637k = objArr;
        }
        this.f7636j[i5] = i2;
        this.f7637k[i5] = e2;
        this.f7638l = i5 + 1;
    }

    public final void b() {
        int i2 = this.f7638l;
        Object[] objArr = this.f7637k;
        for (int i4 = 0; i4 < i2; i4++) {
            objArr[i4] = null;
        }
        this.f7638l = 0;
        this.f7635i = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f7636j = (int[]) this.f7636j.clone();
            hVar.f7637k = (Object[]) this.f7637k.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E e(int i2, E e2) {
        int iA = c.a(this.f7636j, this.f7638l, i2);
        if (iA >= 0) {
            Object[] objArr = this.f7637k;
            if (objArr[iA] != f7634m) {
                return (E) objArr[iA];
            }
        }
        return e2;
    }

    public final int f(int i2) {
        if (this.f7635i) {
            d();
        }
        return c.a(this.f7636j, this.f7638l, i2);
    }

    public final int g() {
        if (this.f7635i) {
            d();
        }
        return this.f7636j[0];
    }

    public final void h(int i2, E e2) {
        int iA = c.a(this.f7636j, this.f7638l, i2);
        if (iA >= 0) {
            this.f7637k[iA] = e2;
            return;
        }
        int i4 = ~iA;
        int i5 = this.f7638l;
        if (i4 < i5) {
            Object[] objArr = this.f7637k;
            if (objArr[i4] == f7634m) {
                this.f7636j[i4] = i2;
                objArr[i4] = e2;
                return;
            }
        }
        if (this.f7635i && i5 >= this.f7636j.length) {
            d();
            i4 = ~c.a(this.f7636j, this.f7638l, i2);
        }
        int i6 = this.f7638l;
        if (i6 >= this.f7636j.length) {
            int iC = c.c(i6 + 1);
            int[] iArr = new int[iC];
            Object[] objArr2 = new Object[iC];
            int[] iArr2 = this.f7636j;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f7637k;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f7636j = iArr;
            this.f7637k = objArr2;
        }
        int i7 = this.f7638l;
        if (i7 - i4 != 0) {
            int[] iArr3 = this.f7636j;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr4 = this.f7637k;
            System.arraycopy(objArr4, i4, objArr4, i8, this.f7638l - i4);
        }
        this.f7636j[i4] = i2;
        this.f7637k[i4] = e2;
        this.f7638l++;
    }

    public final void i(int i2) {
        int iA = c.a(this.f7636j, this.f7638l, i2);
        if (iA >= 0) {
            Object[] objArr = this.f7637k;
            Object obj = objArr[iA];
            Object obj2 = f7634m;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.f7635i = true;
            }
        }
    }

    public final int j() {
        if (this.f7635i) {
            d();
        }
        return this.f7638l;
    }

    public final E k(int i2) {
        if (this.f7635i) {
            d();
        }
        return (E) this.f7637k[i2];
    }

    public final String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f7638l * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f7638l; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            if (this.f7635i) {
                d();
            }
            sb.append(this.f7636j[i2]);
            sb.append('=');
            E eK = k(i2);
            if (eK != this) {
                sb.append(eK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
