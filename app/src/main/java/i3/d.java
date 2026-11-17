package i3;

import g3.C0326c;
import g3.C0327d;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes.dex */
final class d implements h3.c<C0326c> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f6341a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6342b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6343c;
    private final e3.c<CharSequence, Integer, Y2.d<Integer, Integer>> d;

    public static final class a implements Iterator<C0326c> {

        /* renamed from: i, reason: collision with root package name */
        private int f6344i = -1;

        /* renamed from: j, reason: collision with root package name */
        private int f6345j;

        /* renamed from: k, reason: collision with root package name */
        private int f6346k;

        /* renamed from: l, reason: collision with root package name */
        private C0326c f6347l;

        /* renamed from: m, reason: collision with root package name */
        private int f6348m;

        a() {
            int i2 = d.this.f6342b;
            int length = d.this.f6341a.length();
            if (length >= 0) {
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > length) {
                    i2 = length;
                }
                this.f6345j = i2;
                this.f6346k = i2;
                return;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void a() {
            Y2.d dVar;
            if (this.f6346k < 0) {
                this.f6344i = 0;
                this.f6347l = null;
                return;
            }
            if (d.this.f6343c > 0) {
                int i2 = this.f6348m + 1;
                this.f6348m = i2;
                if (i2 >= d.this.f6343c) {
                    this.f6347l = new C0326c(this.f6345j, n.h(d.this.f6341a));
                    this.f6346k = -1;
                } else if (this.f6346k <= d.this.f6341a.length() && (dVar = (Y2.d) d.this.d.b(d.this.f6341a, Integer.valueOf(this.f6346k))) != null) {
                    int iIntValue = ((Number) dVar.a()).intValue();
                    int iIntValue2 = ((Number) dVar.b()).intValue();
                    this.f6347l = C0327d.b(this.f6345j, iIntValue);
                    int i4 = iIntValue + iIntValue2;
                    this.f6345j = i4;
                    this.f6346k = i4 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.f6347l = new C0326c(this.f6345j, n.h(d.this.f6341a));
                    this.f6346k = -1;
                }
            }
            this.f6344i = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f6344i == -1) {
                a();
            }
            return this.f6344i == 1;
        }

        @Override // java.util.Iterator
        public final C0326c next() {
            if (this.f6344i == -1) {
                a();
            }
            if (this.f6344i == 0) {
                throw new NoSuchElementException();
            }
            C0326c c0326c = this.f6347l;
            Objects.requireNonNull(c0326c, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f6347l = null;
            this.f6344i = -1;
            return c0326c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i2, int i4, e3.c<? super CharSequence, ? super Integer, Y2.d<Integer, Integer>> cVar) {
        f3.c.d(charSequence, "input");
        this.f6341a = charSequence;
        this.f6342b = i2;
        this.f6343c = i4;
        this.d = cVar;
    }

    @Override // h3.c
    public final Iterator<C0326c> iterator() {
        return new a();
    }
}
