package Z0;

/* loaded from: classes.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2142a;

    @Override // Z0.a
    public final String a() {
        switch (this.f2142a) {
            case 0:
                return "ByteArrayPool";
            default:
                return "IntegerArrayPool";
        }
    }

    @Override // Z0.a
    public final int b(Object obj) {
        switch (this.f2142a) {
            case 0:
                return ((byte[]) obj).length;
            default:
                return ((int[]) obj).length;
        }
    }

    @Override // Z0.a
    public final int c() {
        switch (this.f2142a) {
            case 0:
                return 1;
            default:
                return 4;
        }
    }

    @Override // Z0.a
    public final Object newArray(int i2) {
        switch (this.f2142a) {
            case 0:
                return new byte[i2];
            default:
                return new int[i2];
        }
    }
}
