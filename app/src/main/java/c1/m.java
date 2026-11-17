package c1;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
public final class m<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final s1.g<a<A>, B> f4415a = new l();

    static final class a<A> {
        private static final Queue<a<?>> d;

        /* renamed from: a, reason: collision with root package name */
        private int f4416a;

        /* renamed from: b, reason: collision with root package name */
        private int f4417b;

        /* renamed from: c, reason: collision with root package name */
        private A f4418c;

        static {
            int i2 = s1.j.f7867c;
            d = new ArrayDeque(0);
        }

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayDeque, java.util.Queue<c1.m$a<?>>] */
        static a a(Object obj) {
            a aVar;
            ?? r02 = d;
            synchronized (r02) {
                aVar = (a) r02.poll();
            }
            if (aVar == null) {
                aVar = new a();
            }
            aVar.f4418c = obj;
            aVar.f4417b = 0;
            aVar.f4416a = 0;
            return aVar;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayDeque, java.util.Queue<c1.m$a<?>>] */
        public final void b() {
            ?? r02 = d;
            synchronized (r02) {
                r02.offer(this);
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4417b == aVar.f4417b && this.f4416a == aVar.f4416a && this.f4418c.equals(aVar.f4418c);
        }

        public final int hashCode() {
            return this.f4418c.hashCode() + (((this.f4416a * 31) + this.f4417b) * 31);
        }
    }

    public final Object a(Object obj) {
        a<A> aVarA = a.a(obj);
        B b2 = this.f4415a.b(aVarA);
        aVarA.b();
        return b2;
    }

    public final void b(Object obj, Object obj2) {
        this.f4415a.f(a.a(obj), obj2);
    }
}
