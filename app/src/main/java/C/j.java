package C;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f41a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f42b;

        @Deprecated
        public a(int i2, b[] bVarArr) {
            this.f41a = i2;
            this.f42b = bVarArr;
        }

        public final b[] a() {
            return this.f42b;
        }

        public final int b() {
            return this.f41a;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f43a;

        /* renamed from: b, reason: collision with root package name */
        private final int f44b;

        /* renamed from: c, reason: collision with root package name */
        private final int f45c;
        private final boolean d;

        /* renamed from: e, reason: collision with root package name */
        private final int f46e;

        @Deprecated
        public b(Uri uri, int i2, int i4, boolean z4, int i5) {
            Objects.requireNonNull(uri);
            this.f43a = uri;
            this.f44b = i2;
            this.f45c = i4;
            this.d = z4;
            this.f46e = i5;
        }

        public final int a() {
            return this.f46e;
        }

        public final int b() {
            return this.f44b;
        }

        public final Uri c() {
            return this.f43a;
        }

        public final int d() {
            return this.f45c;
        }

        public final boolean e() {
            return this.d;
        }
    }

    public static class c {
        public void a(int i2) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, e eVar, int i2, boolean z4, int i4, Handler handler, c cVar) {
        C.c cVar2 = new C.c(cVar, handler);
        return z4 ? f.d(context, eVar, cVar2, i2, i4) : f.c(context, eVar, i2, cVar2);
    }
}
