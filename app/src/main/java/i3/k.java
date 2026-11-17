package i3;

/* loaded from: classes.dex */
final class k extends f3.d implements e3.c<CharSequence, Integer, Y2.d<? extends Integer, ? extends Integer>> {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ char[] f6351i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f6352j;

    k(char[] cArr, boolean z4) {
        this.f6351i = cArr;
        this.f6352j = z4;
    }

    @Override // e3.c
    public final Y2.d<? extends Integer, ? extends Integer> b(CharSequence charSequence, Integer num) {
        CharSequence charSequence2 = charSequence;
        int iIntValue = num.intValue();
        f3.c.d(charSequence2, "$this$$receiver");
        int iK = n.k(charSequence2, this.f6351i, iIntValue, this.f6352j);
        if (iK < 0) {
            return null;
        }
        return new Y2.d<>(Integer.valueOf(iK), 1);
    }
}
