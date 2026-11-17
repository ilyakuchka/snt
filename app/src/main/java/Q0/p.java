package Q0;

import Q0.m;
import Q0.q;
import android.content.res.Resources;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements androidx.lifecycle.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1127a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f1128b;

    public /* synthetic */ p(q qVar, int i2) {
        this.f1127a = i2;
        this.f1128b = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    @Override // androidx.lifecycle.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Object obj) throws Resources.NotFoundException {
        boolean z4;
        switch (this.f1127a) {
            case 0:
                final q qVar = this.f1128b;
                Integer num = (Integer) obj;
                int i2 = q.f1129v0;
                Objects.requireNonNull(qVar);
                qVar.f1143t0 = num.intValue();
                final int i4 = 1;
                if (num.intValue() == 0) {
                    S0.c cVar = qVar.f1138m0;
                    if (cVar.a0() + cVar.c0() != 0) {
                        S0.c cVar2 = qVar.f1138m0;
                        if (cVar2.a0() + cVar2.c0() != 1 || qVar.f1138m0.b0(5) == null) {
                            z4 = false;
                        }
                    }
                    z4 = true;
                }
                qVar.x1(z4);
                S2.e.a().postDelayed(new Runnable() { // from class: Q0.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                m mVar = (m) qVar;
                                int i5 = m.f1114J0;
                                if (mVar.F1() != null) {
                                    ((m.b) mVar.F1()).l(false);
                                    break;
                                }
                                break;
                            default:
                                qVar.v1();
                                break;
                        }
                    }
                }, 500L);
                qVar.u1(num.intValue());
                break;
            case 1:
                q qVar2 = this.f1128b;
                qVar2.f1138m0.V(((Integer) obj).intValue());
                if (qVar2.f1138m0.T() && qVar2.e1() != null && (qVar2.e1() instanceof q.i)) {
                    ((q.i) qVar2.e1()).j(qVar2.f1138m0.O());
                    break;
                }
                break;
            default:
                C0170c c0170c = (C0170c) this.f1128b;
                int i5 = C0170c.f1094z0;
                c0170c.f1138m0.I((N.i) obj);
                break;
        }
    }
}
