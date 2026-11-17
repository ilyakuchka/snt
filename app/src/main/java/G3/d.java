package G3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.e;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class d extends O.b {

    /* renamed from: C0, reason: collision with root package name */
    private f f203C0;

    /* renamed from: D0, reason: collision with root package name */
    private a f204D0;

    final class a implements c {
        a() {
        }

        @Override // G3.c
        public final void a(g.a aVar) {
            d.this.q1(aVar);
        }

        @Override // G3.c
        public final View b(Context context) {
            return d.o1(d.this, context);
        }

        @Override // G3.c
        public final void c(View view) {
            d.this.k1(view);
        }

        @Override // G3.c
        public final boolean d() {
            return false;
        }
    }

    public d() {
        a aVar = new a();
        this.f204D0 = aVar;
        this.f203C0 = new f(aVar, this);
    }

    static /* synthetic */ View o1(d dVar, Context context) {
        return dVar.l1();
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
    public final Dialog e1(Bundle bundle) {
        return this.f203C0.a();
    }

    @Override // O.b, androidx.preference.b
    protected final void n1(e.a aVar) {
        throw new UnsupportedOperationException("using miuix builder instead");
    }

    protected final void q1(g.a aVar) {
        super.n1(new G3.a(B(), aVar));
    }
}
