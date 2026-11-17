package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Objects;
import q.C0365a;

/* loaded from: classes.dex */
final class F {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3402a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    static final I f3403b = new G();

    /* renamed from: c, reason: collision with root package name */
    static final I f3404c;

    static {
        I i2;
        try {
            i2 = (I) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            i2 = null;
        }
        f3404c = i2;
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z4) {
        if (z4) {
            Objects.requireNonNull(fragment2);
        } else {
            Objects.requireNonNull(fragment);
        }
    }

    static void b(C0365a<String, String> c0365a, C0365a<String, View> c0365a2) {
        int size = c0365a.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            if (!c0365a2.containsKey(c0365a.l(size))) {
                c0365a.j(size);
            }
        }
    }

    static void c(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }
}
