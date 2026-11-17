package L0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private long f337a;

    /* renamed from: b, reason: collision with root package name */
    private long f338b;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private int f340e;

    /* renamed from: j, reason: collision with root package name */
    private int f344j;

    /* renamed from: k, reason: collision with root package name */
    private long f345k;

    /* renamed from: m, reason: collision with root package name */
    private long f347m;

    /* renamed from: c, reason: collision with root package name */
    private long f339c = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f341f = 0;
    private int g = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f342h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f343i = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f346l = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f348n = 0;

    public final void A(long j2) {
        this.f339c = Math.max(j2, 0L);
    }

    public final void B(int i2) {
        this.g = i2;
    }

    public final void C(String str) {
        this.d = str;
    }

    public final void D(int i2) {
        this.f340e = i2;
    }

    public final void E(int i2) {
        this.f346l = i2;
    }

    public final void F(int i2) {
        this.f342h = i2;
    }

    public final void G(int i2) {
        this.f341f = Math.max(i2, 0);
    }

    public final void H(long j2) {
        this.f347m = j2;
    }

    public final int a() {
        return this.f348n;
    }

    public final long b() {
        return this.f338b;
    }

    public final int c() {
        return this.f343i;
    }

    public final int d() {
        return this.f344j;
    }

    public final long e() {
        return this.f345k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f337a != aVar.f337a || this.f338b != aVar.f338b || this.f339c != aVar.f339c || this.f340e != aVar.f340e || this.f341f != aVar.f341f || this.g != aVar.g || this.f342h != aVar.f342h || this.f343i != aVar.f343i || this.f344j != aVar.f344j || this.f345k != aVar.f345k || this.f346l != aVar.f346l || this.f347m != aVar.f347m) {
            return false;
        }
        String str = this.d;
        return str != null ? str.equals(aVar.d) : aVar.d == null;
    }

    public final long f() {
        return this.f337a;
    }

    public final long g() {
        return this.f339c;
    }

    public final int h() {
        return this.g;
    }

    public final int hashCode() {
        long j2 = this.f337a;
        long j4 = this.f338b;
        int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.f339c;
        int i4 = (i2 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        String str = this.d;
        int iHashCode = (((((((((((((i4 + (str != null ? str.hashCode() : 0)) * 31) + this.f340e) * 31) + this.f341f) * 31) + this.g) * 31) + this.f342h) * 31) + this.f343i) * 31) + this.f344j) * 31;
        long j6 = this.f345k;
        int i5 = (((iHashCode + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.f346l) * 31;
        long j7 = this.f347m;
        return i5 + ((int) ((j7 >>> 32) ^ j7));
    }

    public final String i() {
        return this.d;
    }

    public final int j() {
        return this.f340e;
    }

    public final int k() {
        return this.f346l;
    }

    public final int l() {
        return this.f342h;
    }

    public final int m() {
        return this.f341f;
    }

    public final long n() {
        return this.f347m;
    }

    public final boolean o() {
        return this.f344j != 0;
    }

    public final boolean p() {
        return this.f345k != 0;
    }

    public final boolean q() {
        return this.f343i != 0;
    }

    public final void r(int i2) {
        this.f348n = i2;
    }

    public final void s(long j2) {
        this.f338b = j2;
    }

    public final void t() {
        this.f343i = 1;
    }

    public final void u(int i2) {
        this.f343i = i2;
    }

    public final void v(int i2) {
        this.f344j = i2;
    }

    public final void w(boolean z4) {
        this.f344j = z4 ? 1 : 0;
    }

    public final void x(long j2) {
        this.f345k = j2;
    }

    public final void y(boolean z4) {
        this.f345k = z4 ? 1L : 0L;
    }

    public final void z(long j2) {
        this.f337a = j2;
    }
}
