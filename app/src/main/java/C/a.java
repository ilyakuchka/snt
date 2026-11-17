package C;

import C.j;
import android.graphics.Typeface;

/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ j.c f17i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ Typeface f18j;

    a(j.c cVar, Typeface typeface) {
        this.f17i = cVar;
        this.f18j = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17i.b(this.f18j);
    }
}
