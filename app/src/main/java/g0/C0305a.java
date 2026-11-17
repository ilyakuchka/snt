package g0;

import f0.C0302a;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0305a extends C0310f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6245b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0305a(C0316l c0316l, int i2) {
        super(c0316l);
        this.f6245b = i2;
    }

    public final void e(byte[] bArr) {
        switch (this.f6245b) {
            case 0:
                this.f6252a.l(bArr, 152);
                break;
            default:
                this.f6252a.l(bArr, 152);
                break;
        }
    }

    public C0305a(byte[] bArr) throws C0302a {
        this.f6245b = 0;
        c(133);
        d();
        e(bArr);
    }

    public C0305a(byte[] bArr, int i2) throws C0302a {
        this.f6245b = 1;
        c(131);
        d();
        e(bArr);
        this.f6252a.k(i2, 149);
    }
}
