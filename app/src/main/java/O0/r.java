package O0;

import O0.f;
import android.telephony.SubscriptionManager;
import com.android.mmt.MmsApp;
import com.android.mmt.util.C0275g;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.C0288u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class r {
    private static r d = new r();

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<c> f820a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private SubscriptionManager.OnSubscriptionsChangedListener f821b = new a();

    /* renamed from: c, reason: collision with root package name */
    private f.h f822c = new b();

    final class a extends SubscriptionManager.OnSubscriptionsChangedListener {
        a() {
        }

        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
        public final void onSubscriptionsChanged() throws Throwable {
            r.a(r.this);
        }
    }

    final class b implements f.h {
        b() {
        }

        @Override // O0.f.h
        public final void a() throws Throwable {
            r.a(r.this);
        }
    }

    interface c {
        void a();
    }

    private r() {
    }

    static void a(r rVar) throws Throwable {
        Objects.requireNonNull(rVar);
        if (C0275g.b()) {
            C0288u.h();
        }
        d dVarG = d.g();
        Objects.requireNonNull(dVarG);
        Q2.c.a(new O0.b(dVarG));
        Iterator<c> it = rVar.f820a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static r b() {
        return d;
    }

    public final void c() {
        MmsApp.c();
        if (C0287t.x()) {
            C0287t.H(this.f821b);
        } else {
            f.j().s(this.f822c);
        }
    }

    public final void d() {
        MmsApp.c();
        if (C0287t.x()) {
            C0287t.M(this.f821b);
        } else {
            f.j().t(this.f822c);
        }
    }
}
