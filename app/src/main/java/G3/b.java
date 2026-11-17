package G3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.e;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class b extends O.a {

    /* renamed from: B0, reason: collision with root package name */
    private f f200B0;

    /* renamed from: C0, reason: collision with root package name */
    private a f201C0;

    final class a implements c {
        a() {
        }

        @Override // G3.c
        public final void a(g.a aVar) {
            new G3.a(b.this.B(), aVar);
        }

        @Override // G3.c
        public final View b(Context context) {
            return b.p1(b.this, context);
        }

        @Override // G3.c
        public final void c(View view) {
            b.this.k1(view);
        }

        @Override // G3.c
        public final boolean d() {
            return true;
        }
    }

    public b() {
        a aVar = new a();
        this.f201C0 = aVar;
        this.f200B0 = new f(aVar, this);
    }

    static /* synthetic */ View p1(b bVar, Context context) {
        return bVar.l1();
    }

    @Override // androidx.preference.b, androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
    public final Dialog e1(Bundle bundle) {
        return this.f200B0.a();
    }

    @Override // androidx.preference.b
    protected final void n1(e.a aVar) {
        throw new UnsupportedOperationException("using miuix builder instead");
    }
}
