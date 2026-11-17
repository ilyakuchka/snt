package R;

import R.i;
import V.c;
import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final c.InterfaceC0043c f1226a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1227b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1228c;
    public final i.c d;

    /* renamed from: e, reason: collision with root package name */
    public final List<i.b> f1229e;

    /* renamed from: f, reason: collision with root package name */
    public final List<Object> f1230f = Collections.emptyList();
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1231h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f1232i;

    /* renamed from: j, reason: collision with root package name */
    public final Executor f1233j;

    @SuppressLint({"LambdaLast"})
    public c(Context context, String str, c.InterfaceC0043c interfaceC0043c, i.c cVar, List list, boolean z4, int i2, Executor executor, Executor executor2) {
        this.f1226a = interfaceC0043c;
        this.f1227b = context;
        this.f1228c = str;
        this.d = cVar;
        this.f1229e = list;
        this.g = z4;
        this.f1231h = i2;
        this.f1232i = executor;
        this.f1233j = executor2;
    }
}
