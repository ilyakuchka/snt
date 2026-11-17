package G0;

/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: j, reason: collision with root package name */
    private final String f175j;

    /* renamed from: k, reason: collision with root package name */
    private String f176k;

    /* renamed from: l, reason: collision with root package name */
    private int f177l;

    /* renamed from: m, reason: collision with root package name */
    private int f178m;

    /* renamed from: n, reason: collision with root package name */
    private int f179n;

    /* renamed from: o, reason: collision with root package name */
    private int f180o;
    private String p;

    public n(String str, int i2, int i4, int i5) {
        this.f175j = str;
        this.f176k = "meet";
        this.f177l = 0;
        this.f178m = i2;
        this.f179n = i4;
        this.f180o = i5;
        this.p = null;
    }

    public final String p() {
        return this.p;
    }

    public final String q() {
        return this.f176k;
    }

    public final int r() {
        return this.f180o;
    }

    public final int s() {
        return this.f177l;
    }

    public final String t() {
        return this.f175j;
    }

    public final int u() {
        return this.f178m;
    }

    public final int v() {
        return this.f179n;
    }

    public final void w(int i2) {
        this.f178m = i2;
        g();
    }

    public n(String str, String str2, int i2, int i4, int i5, int i6, String str3) {
        this.f175j = str;
        this.f176k = str2;
        this.f177l = i2;
        this.f178m = i4;
        this.f179n = i5;
        this.f180o = i6;
        this.p = str3;
    }
}
