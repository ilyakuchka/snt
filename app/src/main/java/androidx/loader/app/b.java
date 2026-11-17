package androidx.loader.app;

import androidx.lifecycle.k;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Objects;
import q.h;
import t.C0384b;

/* loaded from: classes.dex */
final class b extends androidx.loader.app.a {

    /* renamed from: a, reason: collision with root package name */
    private final k f3719a;

    /* renamed from: b, reason: collision with root package name */
    private final C0066b f3720b;

    public static class a<D> extends o<D> {
        @Override // androidx.lifecycle.LiveData
        protected final void i() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected final void j() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public final void l(p<? super D> pVar) {
            super.l(pVar);
        }

        @Override // androidx.lifecycle.o, androidx.lifecycle.LiveData
        public final void n(D d) {
            super.n(d);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            C0384b.e(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    static class C0066b extends u {

        /* renamed from: c, reason: collision with root package name */
        private static final v.a f3721c = new a();

        /* renamed from: b, reason: collision with root package name */
        private h<a> f3722b = new h<>();

        /* renamed from: androidx.loader.app.b$b$a */
        static class a implements v.a {
            a() {
            }

            @Override // androidx.lifecycle.v.a
            public final u a() {
                return new C0066b();
            }
        }

        C0066b() {
        }

        static C0066b e(w wVar) {
            return (C0066b) new v(wVar, f3721c).a(C0066b.class);
        }

        @Override // androidx.lifecycle.u
        protected final void c() {
            if (this.f3722b.j() <= 0) {
                this.f3722b.b();
            } else {
                Objects.requireNonNull(this.f3722b.k(0));
                throw null;
            }
        }

        public final void d(String str, PrintWriter printWriter) {
            if (this.f3722b.j() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.f3722b.j() <= 0) {
                    return;
                }
                a aVarK = this.f3722b.k(0);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f3722b.g());
                printWriter.print(": ");
                printWriter.println(aVarK.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(0);
                printWriter.print(" mArgs=");
                printWriter.println((Object) null);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println((Object) null);
                throw null;
            }
        }

        final void f() {
            int iJ = this.f3722b.j();
            for (int i2 = 0; i2 < iJ; i2++) {
                Objects.requireNonNull(this.f3722b.k(i2));
            }
        }
    }

    b(k kVar, w wVar) {
        this.f3719a = kVar;
        this.f3720b = C0066b.e(wVar);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3720b.d(str, printWriter);
    }

    @Override // androidx.loader.app.a
    public final void c() {
        this.f3720b.f();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0384b.e(this.f3719a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
