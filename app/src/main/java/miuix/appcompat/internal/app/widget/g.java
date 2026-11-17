package miuix.appcompat.internal.app.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.a;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import b0.C0225b;
import com.android.mmt.R;
import java.util.ArrayList;
import miuix.appcompat.app.b;
import miuix.appcompat.internal.app.widget.d;
import z3.C0432b;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private d f6980a;

    /* renamed from: b, reason: collision with root package name */
    private C0225b f6981b;

    /* renamed from: c, reason: collision with root package name */
    private k f6982c;
    private ArrayList<b.a> d;

    /* renamed from: e, reason: collision with root package name */
    private a.d f6983e = new a();

    final class a implements a.d {
        a() {
        }

        @Override // androidx.appcompat.app.a.d
        public final void a(a.c cVar, E e2) {
        }

        @Override // androidx.appcompat.app.a.d
        public final void b(a.c cVar, E e2) throws Resources.NotFoundException {
            int iC = g.this.f6982c.c();
            for (int i2 = 0; i2 < iC; i2++) {
                if (g.this.f6982c.l(i2) == cVar) {
                    g.this.f6981b.A(i2, cVar instanceof d.C0119d ? ((d.C0119d) cVar).d : true);
                    return;
                }
            }
        }

        @Override // androidx.appcompat.app.a.d
        public final void c(a.c cVar, E e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f6985a = -1;

        /* renamed from: b, reason: collision with root package name */
        private float f6986b;

        /* renamed from: c, reason: collision with root package name */
        boolean f6987c;
        boolean d;

        /* renamed from: e, reason: collision with root package name */
        int f6988e;

        /* renamed from: f, reason: collision with root package name */
        int f6989f;

        b() {
        }

        final void a(int i2, float f4) {
            if (f4 < 1.0E-4f) {
                this.f6988e = this.f6989f;
                this.f6985a = -1;
                this.f6986b = 0.0f;
                this.d = true;
                return;
            }
            if (this.f6985a != i2) {
                this.f6985a = i2;
                this.f6986b = f4;
                this.f6987c = true;
                this.d = false;
                return;
            }
            if (this.f6987c) {
                this.f6987c = false;
                boolean z4 = f4 > this.f6986b;
                this.f6988e = z4 ? i2 : i2 + 1;
                if (z4) {
                    i2++;
                }
                this.f6989f = i2;
            }
        }
    }

    g(d dVar, w wVar) throws Resources.NotFoundException {
        this.f6980a = dVar;
        ActionBarOverlayLayout actionBarOverlayLayoutH = dVar.H();
        Context context = actionBarOverlayLayoutH.getContext();
        View viewFindViewById = actionBarOverlayLayoutH.findViewById(R.id.view_pager);
        if (viewFindViewById instanceof C0225b) {
            this.f6981b = (C0225b) viewFindViewById;
        } else {
            C0225b c0225b = new C0225b(context);
            this.f6981b = c0225b;
            c0225b.setId(R.id.view_pager);
            ((ViewGroup) actionBarOverlayLayoutH.findViewById(android.R.id.content)).addView(this.f6981b, new C0225b.f());
        }
        k kVar = new k(context, wVar);
        this.f6982c = kVar;
        this.f6981b.y(kVar);
        this.f6981b.b(new h(this));
        int i2 = C0432b.f8169a;
        q qVar = new q(this.f6981b, this.f6982c);
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        this.d.add(qVar);
    }

    final int e(String str, a.c cVar, Class cls, Bundle bundle) throws Resources.NotFoundException {
        ((d.C0119d) cVar).i(this.f6983e);
        this.f6980a.J(cVar);
        int iJ = this.f6982c.j(str, cls, bundle, cVar);
        if (this.f6982c.n()) {
            this.f6981b.z(this.f6982c.c() - 1);
        }
        return iJ;
    }

    final void f(b.a aVar) {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        this.d.add(aVar);
    }

    final Fragment g(int i2) {
        return this.f6982c.k(i2, true, true);
    }

    final int h() {
        return this.f6982c.c();
    }

    final void i() {
        this.f6980a.K();
        this.f6982c.o();
    }
}
