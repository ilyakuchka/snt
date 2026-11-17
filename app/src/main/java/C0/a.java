package C0;

import android.content.Context;
import com.android.mmt.MmsApp;
import com.android.mmt.transaction.d;
import com.android.mmt.ui.C0243g0;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static b f55a;

    /* renamed from: b, reason: collision with root package name */
    private static b f56b;

    public static void a() {
        Objects.requireNonNull(f55a);
    }

    public static void b(long j2) {
        Objects.requireNonNull((c) f55a);
        d.s(j2);
    }

    public static Context c() {
        Objects.requireNonNull((c) f55a);
        return MmsApp.c();
    }

    public static int d(Object obj) {
        Objects.requireNonNull((c) f56b);
        return ((C0243g0) obj).w();
    }

    public static void e(b bVar) {
        f55a = bVar;
    }

    public static void f(b bVar) {
        f56b = bVar;
    }
}
