package L3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final a f560a = new a();

    public static final class a {

        /* renamed from: L3.z$a$a, reason: collision with other inner class name */
        public static final class C0017a extends z {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ v f561b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f562c;
            final /* synthetic */ byte[] d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f563e;

            C0017a(v vVar, int i2, byte[] bArr, int i4) {
                this.f561b = vVar;
                this.f562c = i2;
                this.d = bArr;
                this.f563e = i4;
            }

            @Override // L3.z
            public final long a() {
                return this.f562c;
            }

            @Override // L3.z
            public final v b() {
                return this.f561b;
            }

            @Override // L3.z
            public final void c(X3.e eVar) throws IOException {
                eVar.g(this.d, this.f563e, this.f562c);
            }
        }

        public final z a(byte[] bArr, v vVar, int i2, int i4) {
            M3.c.d(bArr.length, i2, i4);
            return new C0017a(vVar, i4, bArr, i2);
        }
    }

    public abstract long a() throws IOException;

    public abstract v b();

    public abstract void c(X3.e eVar) throws IOException;
}
