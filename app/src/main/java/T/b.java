package T;

import D2.e;
import N.n;
import R.g;
import R.i;
import R.k;
import android.database.Cursor;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class b<T> extends n<T> {

    /* renamed from: c, reason: collision with root package name */
    private final k f1521c;
    private final String d;

    /* renamed from: e, reason: collision with root package name */
    private final String f1522e;

    /* renamed from: f, reason: collision with root package name */
    private final i f1523f;
    private final g.c g;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f1525i = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private final boolean f1524h = false;

    protected b(i iVar, k kVar, String... strArr) {
        this.f1523f = iVar;
        this.f1521c = kVar;
        StringBuilder sbD = e.d("SELECT COUNT(*) FROM ( ");
        sbD.append(kVar.f());
        sbD.append(" )");
        this.d = sbD.toString();
        StringBuilder sbD2 = e.d("SELECT * FROM ( ");
        sbD2.append(kVar.f());
        sbD2.append(" ) LIMIT ? OFFSET ?");
        this.f1522e = sbD2.toString();
        this.g = new a(this, strArr);
        l();
    }

    private k k(int i2, int i4) {
        k kVarI = k.I(this.f1522e, this.f1521c.f0() + 2);
        kVarI.e0(this.f1521c);
        kVarI.v(kVarI.f0() - 1, i4);
        kVarI.v(kVarI.f0(), i2);
        return kVarI;
    }

    private void l() {
        if (this.f1525i.compareAndSet(false, true)) {
            this.f1523f.j().b(this.g);
        }
    }

    @Override // N.e
    public final boolean d() {
        l();
        this.f1523f.j().g();
        return super.d();
    }

    @Override // N.n
    public final void g(n.d dVar, n.b<T> bVar) throws Throwable {
        Throwable th;
        k kVarK;
        l();
        List<T> listEmptyList = Collections.emptyList();
        this.f1523f.c();
        Cursor cursorU = null;
        try {
            int iJ = j();
            int iMax = 0;
            if (iJ != 0) {
                int i2 = dVar.f709a;
                int i4 = dVar.f710b;
                int i5 = dVar.f711c;
                iMax = Math.max(0, Math.min(((((iJ - i4) + i5) - 1) / i5) * i5, (i2 / i5) * i5));
                kVarK = k(iMax, Math.min(iJ - iMax, dVar.f710b));
                try {
                    cursorU = this.f1523f.u(kVarK);
                    listEmptyList = i(cursorU);
                    this.f1523f.v();
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorU != null) {
                        cursorU.close();
                    }
                    this.f1523f.h();
                    if (kVarK != null) {
                        kVarK.g0();
                    }
                    throw th;
                }
            } else {
                kVarK = null;
            }
            if (cursorU != null) {
                cursorU.close();
            }
            this.f1523f.h();
            if (kVarK != null) {
                kVarK.g0();
            }
            bVar.a(listEmptyList, iMax, iJ);
        } catch (Throwable th3) {
            th = th3;
            kVarK = null;
        }
    }

    @Override // N.n
    public final void h(n.g gVar, n.e<T> eVar) {
        List<T> listI;
        k kVarK = k(gVar.f714a, gVar.f715b);
        if (this.f1524h) {
            this.f1523f.c();
            Cursor cursorU = null;
            try {
                cursorU = this.f1523f.u(kVarK);
                listI = i(cursorU);
                this.f1523f.v();
            } finally {
                if (cursorU != null) {
                    cursorU.close();
                }
                this.f1523f.h();
                kVarK.g0();
            }
        } else {
            Cursor cursorU2 = this.f1523f.u(kVarK);
            try {
                listI = i(cursorU2);
            } finally {
                cursorU2.close();
                kVarK.g0();
            }
        }
        eVar.a(listI);
    }

    protected abstract List<T> i(Cursor cursor);

    public final int j() {
        l();
        k kVarI = k.I(this.d, this.f1521c.f0());
        kVarI.e0(this.f1521c);
        Cursor cursorU = this.f1523f.u(kVarI);
        try {
            if (cursorU.moveToFirst()) {
                return cursorU.getInt(0);
            }
            return 0;
        } finally {
            cursorU.close();
            kVarI.g0();
        }
    }
}
