package A0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<a4.m> f9a;

    o(ArrayList<a4.m> arrayList) {
        this.f9a = arrayList;
    }

    public final int a() {
        return this.f9a.size();
    }

    public final a4.m b(int i2) {
        try {
            return this.f9a.get(i2);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }
}
