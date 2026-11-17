package G3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.e;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class e extends O.c {

    /* renamed from: D0, reason: collision with root package name */
    private f f206D0;

    /* renamed from: E0, reason: collision with root package name */
    private a f207E0;

    final class a implements c {
        a() {
        }

        @Override // G3.c
        public final void a(g.a aVar) {
            e.this.q1(aVar);
        }

        @Override // G3.c
        public final View b(Context context) {
            return e.o1(e.this, context);
        }

        @Override // G3.c
        public final void c(View view) {
            e.this.k1(view);
        }

        @Override // G3.c
        public final boolean d() {
            return false;
        }
    }

    public e() {
        a aVar = new a();
        this.f207E0 = aVar;
        this.f206D0 = new f(aVar, this);
    }

    static /* synthetic */ View o1(e eVar, Context context) {
        return eVar.l1();
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
    public final Dialog e1(Bundle bundle) {
        return this.f206D0.a();
    }

    @Override // O.c, androidx.preference.b
    protected final void n1(e.a aVar) {
        throw new UnsupportedOperationException("using miuix builder instead");
    }

    protected final void q1(g.a aVar) {
        super.n1(new G3.a(B(), aVar));
    }
}
