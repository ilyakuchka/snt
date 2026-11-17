package c3;

import f3.c;

/* renamed from: c3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0229a extends b3.a {
    @Override // b3.a
    public final void a(Throwable th, Throwable th2) {
        c.d(th, "cause");
        c.d(th2, "exception");
        th.addSuppressed(th2);
    }
}
