package X3;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1879a;

    /* renamed from: b, reason: collision with root package name */
    public int f1880b;

    /* renamed from: c, reason: collision with root package name */
    public int f1881c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1882e;

    /* renamed from: f, reason: collision with root package name */
    public t f1883f;
    public t g;

    public t() {
        this.f1879a = new byte[8192];
        this.f1882e = true;
        this.d = false;
    }

    public final t a() {
        t tVar = this.f1883f;
        if (tVar == this) {
            tVar = null;
        }
        t tVar2 = this.g;
        f3.c.b(tVar2);
        tVar2.f1883f = this.f1883f;
        t tVar3 = this.f1883f;
        f3.c.b(tVar3);
        tVar3.g = this.g;
        this.f1883f = null;
        this.g = null;
        return tVar;
    }

    public final t b(t tVar) {
        tVar.g = this;
        tVar.f1883f = this.f1883f;
        t tVar2 = this.f1883f;
        f3.c.b(tVar2);
        tVar2.g = tVar;
        this.f1883f = tVar;
        return tVar;
    }

    public final t c() {
        this.d = true;
        return new t(this.f1879a, this.f1880b, this.f1881c, true);
    }

    public final void d(t tVar, int i2) {
        if (!tVar.f1882e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i4 = tVar.f1881c;
        int i5 = i4 + i2;
        if (i5 > 8192) {
            if (tVar.d) {
                throw new IllegalArgumentException();
            }
            int i6 = tVar.f1880b;
            if (i5 - i6 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = tVar.f1879a;
            Z2.d.b(bArr, bArr, 0, i6, i4);
            tVar.f1881c -= tVar.f1880b;
            tVar.f1880b = 0;
        }
        byte[] bArr2 = this.f1879a;
        byte[] bArr3 = tVar.f1879a;
        int i7 = tVar.f1881c;
        int i8 = this.f1880b;
        Z2.d.b(bArr2, bArr3, i7, i8, i8 + i2);
        tVar.f1881c += i2;
        this.f1880b += i2;
    }

    public t(byte[] bArr, int i2, int i4, boolean z4) {
        f3.c.d(bArr, "data");
        this.f1879a = bArr;
        this.f1880b = i2;
        this.f1881c = i4;
        this.d = z4;
        this.f1882e = false;
    }
}
