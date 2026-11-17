package C;

import C.f;
import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class h implements Callable<f.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f37a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f38b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f39c;
    final /* synthetic */ int d;

    h(String str, Context context, e eVar, int i2) {
        this.f37a = str;
        this.f38b = context;
        this.f39c = eVar;
        this.d = i2;
    }

    @Override // java.util.concurrent.Callable
    public final f.b call() throws Exception {
        return f.b(this.f37a, this.f38b, this.f39c, this.d);
    }
}
