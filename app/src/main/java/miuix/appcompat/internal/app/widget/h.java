package miuix.appcompat.internal.app.widget;

import b0.C0225b;
import java.util.Iterator;
import miuix.appcompat.app.b;
import miuix.appcompat.internal.app.widget.g;

/* loaded from: classes.dex */
final class h implements C0225b.h {

    /* renamed from: a, reason: collision with root package name */
    g.b f6990a = new g.b();

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f6991b;

    h(g gVar) {
        this.f6991b = gVar;
    }

    @Override // b0.C0225b.h
    public final void a(int i2) {
        if (this.f6991b.d != null) {
            Iterator it = this.f6991b.d.iterator();
            while (it.hasNext()) {
                ((b.a) it.next()).a(i2);
            }
        }
    }

    @Override // b0.C0225b.h
    public final void b(int i2) {
        int iP = this.f6991b.f6982c.p(i2);
        this.f6991b.f6980a.N(iP);
        k kVar = this.f6991b.f6982c;
        C0225b unused = this.f6991b.f6981b;
        kVar.h(this.f6991b.f6982c.k(i2, false, false));
        if (this.f6991b.d != null) {
            Iterator it = this.f6991b.d.iterator();
            while (it.hasNext()) {
                ((b.a) it.next()).b(iP);
            }
        }
    }

    @Override // b0.C0225b.h
    public final void c(int i2, float f4) {
        this.f6990a.a(i2, f4);
        if (this.f6990a.f6987c || this.f6991b.d == null) {
            return;
        }
        boolean zM = this.f6991b.f6982c.m(this.f6990a.f6988e);
        boolean zM2 = this.f6991b.f6982c.m(this.f6990a.f6989f);
        if (this.f6991b.f6982c.n()) {
            i2 = this.f6991b.f6982c.p(i2);
            if (!this.f6990a.d) {
                i2--;
                f4 = 1.0f - f4;
            }
        }
        Iterator it = this.f6991b.d.iterator();
        while (it.hasNext()) {
            ((b.a) it.next()).c(i2, f4, zM, zM2);
        }
    }
}
