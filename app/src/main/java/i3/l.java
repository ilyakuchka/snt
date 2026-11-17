package i3;

import java.util.List;

/* loaded from: classes.dex */
final class l extends f3.d implements e3.c<CharSequence, Integer, Y2.d<? extends Integer, ? extends Integer>> {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ List<String> f6353i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f6354j;

    l(List<String> list, boolean z4) {
        this.f6353i = list;
        this.f6354j = z4;
    }

    @Override // e3.c
    public final Y2.d<? extends Integer, ? extends Integer> b(CharSequence charSequence, Integer num) {
        CharSequence charSequence2 = charSequence;
        int iIntValue = num.intValue();
        f3.c.d(charSequence2, "$this$$receiver");
        Y2.d dVarF = n.f(charSequence2, this.f6353i, iIntValue, this.f6354j);
        if (dVarF != null) {
            return new Y2.d<>(dVarF.c(), Integer.valueOf(((String) dVarF.d()).length()));
        }
        return null;
    }
}
