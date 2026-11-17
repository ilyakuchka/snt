package Q;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    final b f1056a;

    /* renamed from: b, reason: collision with root package name */
    int f1057b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f1058c = -1;
    int d = -1;

    /* renamed from: e, reason: collision with root package name */
    Object f1059e = null;

    public a(b bVar) {
        this.f1056a = bVar;
    }

    @Override // Q.b
    public final void a(int i2, int i4) {
        int i5;
        if (this.f1057b == 2 && (i5 = this.f1058c) >= i2 && i5 <= i2 + i4) {
            this.d += i4;
            this.f1058c = i2;
        } else {
            e();
            this.f1058c = i2;
            this.d = i4;
            this.f1057b = 2;
        }
    }

    @Override // Q.b
    public final void b(int i2, int i4) {
        int i5;
        if (this.f1057b == 1 && i2 >= (i5 = this.f1058c)) {
            int i6 = this.d;
            if (i2 <= i5 + i6) {
                this.d = i6 + i4;
                this.f1058c = Math.min(i2, i5);
                return;
            }
        }
        e();
        this.f1058c = i2;
        this.d = i4;
        this.f1057b = 1;
    }

    @Override // Q.b
    public final void c(int i2, int i4) {
        e();
        this.f1056a.c(i2, i4);
    }

    @Override // Q.b
    public final void d(int i2, int i4, Object obj) {
        int i5;
        int i6;
        int i7;
        if (this.f1057b == 3 && i2 <= (i6 = this.d + (i5 = this.f1058c)) && (i7 = i2 + i4) >= i5 && this.f1059e == obj) {
            this.f1058c = Math.min(i2, i5);
            this.d = Math.max(i6, i7) - this.f1058c;
            return;
        }
        e();
        this.f1058c = i2;
        this.d = i4;
        this.f1059e = obj;
        this.f1057b = 3;
    }

    public final void e() {
        int i2 = this.f1057b;
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            this.f1056a.b(this.f1058c, this.d);
        } else if (i2 == 2) {
            this.f1056a.a(this.f1058c, this.d);
        } else if (i2 == 3) {
            this.f1056a.d(this.f1058c, this.d, this.f1059e);
        }
        this.f1059e = null;
        this.f1057b = 0;
    }
}
