package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.w;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
final class k implements androidx.core.view.k {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f2402a;

    k(j jVar) {
        this.f2402a = jVar;
    }

    @Override // androidx.core.view.k
    public final w a(View view, w wVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iH = wVar.h();
        int iE0 = this.f2402a.e0(wVar);
        if (iH != iE0) {
            int iF = wVar.f();
            int iG = wVar.g();
            int iE = wVar.e();
            w.a aVar = new w.a(wVar);
            aVar.c(y.b.a(iF, iE0, iG, iE));
            wVar = aVar.a();
        }
        return androidx.core.view.o.g(view, wVar);
    }
}
