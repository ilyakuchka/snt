package Q0;

import N.e;
import N.i;
import android.util.Log;
import androidx.lifecycle.LiveData;
import com.android.mmt.storage.bugle.BugleDatabase;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class y extends androidx.lifecycle.u {

    /* renamed from: b, reason: collision with root package name */
    private i.f f1190b;

    /* renamed from: c, reason: collision with root package name */
    private i.c f1191c;
    private LiveData<N.i<L0.a>> d;

    /* renamed from: e, reason: collision with root package name */
    private int f1192e;
    private LiveData<Integer> g;

    /* renamed from: i, reason: collision with root package name */
    private LiveData<Integer> f1195i;

    /* renamed from: f, reason: collision with root package name */
    private int f1193f = 0;

    /* renamed from: h, reason: collision with root package name */
    private androidx.lifecycle.o<Integer> f1194h = new androidx.lifecycle.o<>(1);

    /* renamed from: j, reason: collision with root package name */
    private androidx.lifecycle.o<Integer> f1196j = new androidx.lifecycle.o<>(0);

    public y(int i2) {
        this.f1192e = 0;
        this.f1192e = i2;
    }

    public static /* synthetic */ void d(y yVar, Integer num) {
        if (yVar.f1196j.e().compareTo(num) != 0) {
            yVar.f1196j.n(num);
        }
    }

    public static /* synthetic */ void e(y yVar, Integer num) {
        if (yVar.f1194h.e().compareTo(num) != 0) {
            yVar.f1194h.n(num);
        }
    }

    private boolean n(int i2) {
        return (i2 & 8) == 8;
    }

    public final int f() {
        return this.f1192e;
    }

    public final LiveData<Integer> g() {
        return this.f1194h;
    }

    public final L0.d h() {
        return BugleDatabase.y().x();
    }

    public final LiveData<Integer> i() {
        return this.f1196j;
    }

    public final LiveData<N.i<L0.a>> j() {
        return this.d;
    }

    public final void k() {
        androidx.lifecycle.o<Integer> oVar = this.f1194h;
        oVar.n(oVar.e());
    }

    public final void l(i.c cVar) {
        this.f1191c = cVar;
    }

    public final void m(int i2) {
        this.f1193f = i2;
    }

    public final void o(androidx.lifecycle.k kVar) {
        if (this.f1190b == null) {
            i.f.a aVar = new i.f.a();
            aVar.c();
            aVar.d();
            aVar.b();
            this.f1190b = aVar.a();
        }
        e.a<Integer, L0.a> aVarN = null;
        StringBuilder sbD = D2.e.d("configPagedList: ");
        sbD.append(this.f1193f);
        sbD.append(" | ");
        sbD.append(this.f1192e);
        Log.d("ConversationModel", sbD.toString());
        ArrayList arrayList = new ArrayList();
        final int i2 = 1;
        final int i4 = 0;
        if ((this.f1193f & 1) == 1) {
            arrayList.add(-100);
        }
        if (n(this.f1193f)) {
            arrayList.add(-103);
        }
        StringBuilder sbD2 = D2.e.d("special threads: ");
        sbD2.append(Arrays.toString(arrayList.toArray()));
        Log.d("ConversationModel", sbD2.toString());
        int i5 = this.f1192e;
        int i6 = i5 == 768 ? 1 : 0;
        if (i5 == 0) {
            aVarN = BugleDatabase.y().x().n(n(this.f1193f), arrayList);
        } else if (i5 == 768) {
            aVarN = BugleDatabase.y().x().o(n(this.f1193f), arrayList, i6);
        }
        if (aVarN != null) {
            LiveData<N.i<L0.a>> liveData = this.d;
            if (liveData != null) {
                liveData.m(kVar);
            }
            N.g gVar = new N.g(aVarN, this.f1190b);
            gVar.b(this.f1191c);
            this.d = gVar.a();
        }
        if (kVar != null) {
            LiveData<Integer> liveData2 = this.g;
            if (liveData2 != null) {
                liveData2.m(kVar);
            }
            LiveData<Integer> liveDataX = h().x(arrayList, i6);
            this.g = liveDataX;
            liveDataX.g(kVar, new androidx.lifecycle.p(this) { // from class: Q0.x

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ y f1189b;

                {
                    this.f1189b = this;
                }

                @Override // androidx.lifecycle.p
                public final void a(Object obj) {
                    switch (i4) {
                        case 0:
                            y.e(this.f1189b, (Integer) obj);
                            break;
                        default:
                            y.d(this.f1189b, (Integer) obj);
                            break;
                    }
                }
            });
            LiveData<Integer> liveData3 = this.f1195i;
            if (liveData3 != null) {
                liveData3.m(kVar);
            }
            LiveData<Integer> liveDataX2 = h().x(new ArrayList(), i6);
            this.f1195i = liveDataX2;
            liveDataX2.g(kVar, new androidx.lifecycle.p(this) { // from class: Q0.x

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ y f1189b;

                {
                    this.f1189b = this;
                }

                @Override // androidx.lifecycle.p
                public final void a(Object obj) {
                    switch (i2) {
                        case 0:
                            y.e(this.f1189b, (Integer) obj);
                            break;
                        default:
                            y.d(this.f1189b, (Integer) obj);
                            break;
                    }
                }
            });
        }
    }
}
