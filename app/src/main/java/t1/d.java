package t1;

/* loaded from: classes.dex */
public abstract class d {

    private static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f7904a;

        a() {
        }

        @Override // t1.d
        public final void b(boolean z4) {
            this.f7904a = z4;
        }

        @Override // t1.d
        public final void c() {
            if (this.f7904a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    d() {
    }

    public static d a() {
        return new a();
    }

    abstract void b(boolean z4);

    public abstract void c();
}
