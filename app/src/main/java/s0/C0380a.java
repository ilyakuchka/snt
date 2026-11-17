package s0;

import android.content.Context;
import java.util.LinkedList;

/* renamed from: s0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0380a {

    /* renamed from: b, reason: collision with root package name */
    private static C0380a f7839b;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<Object> f7840a = new LinkedList<>();

    private C0380a() {
    }

    public static synchronized C0380a b(Context context) {
        C0380a c0380a = f7839b;
        if (c0380a != null) {
            return c0380a;
        }
        C0380a c0380a2 = new C0380a();
        f7839b = c0380a2;
        return c0380a2;
    }

    public final synchronized void a() {
        this.f7840a.clear();
    }
}
