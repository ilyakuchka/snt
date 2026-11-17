package L0;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c {
    public static a a(a aVar, a aVar2) {
        if (aVar.equals(aVar2)) {
            return null;
        }
        if (aVar.f() == aVar2.f() && aVar.b() == aVar2.b() && aVar.g() == aVar2.g() && TextUtils.equals(aVar.i(), aVar2.i()) && aVar.j() == aVar2.j() && aVar.m() == aVar2.m() && aVar.h() == aVar2.h() && aVar.l() == aVar2.l() && aVar.c() == aVar2.c() && aVar.d() == aVar2.d() && aVar.k() == aVar2.k()) {
            return null;
        }
        aVar2.s(aVar.b());
        aVar2.A(aVar.g());
        aVar2.C(aVar.i());
        aVar2.D(aVar.j());
        aVar2.G(aVar.m());
        aVar2.B(aVar.h());
        aVar2.F(aVar.l());
        aVar2.u(aVar.c());
        aVar2.v(aVar.d());
        aVar2.E(aVar.k());
        return aVar2;
    }

    static List b(List list) {
        List listSubList;
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            int size = (list.size() / 300) + (list.size() % 300 > 0 ? 1 : 0);
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 == size - 1) {
                    listSubList = list.subList(i2 * 300, list.size());
                } else {
                    int i4 = i2 * 300;
                    listSubList = list.subList(i4, i4 + 300);
                }
                arrayList.add(listSubList);
            }
        }
        return arrayList;
    }

    public static String c(int i2) {
        return i2 != 1 ? i2 != 2 ? "sms" : "rms" : "mms";
    }
}
