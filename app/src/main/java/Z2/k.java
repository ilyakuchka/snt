package Z2;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends i {
    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, e3.b<? super T, ? extends CharSequence> bVar) throws IOException {
        f3.c.d(iterable, "<this>");
        f3.c.d(charSequence, "separator");
        f3.c.d(charSequence2, "prefix");
        f3.c.d(charSequence3, "postfix");
        f3.c.d(charSequence4, "truncated");
        a2.append(charSequence2);
        int i4 = 0;
        for (T t2 : iterable) {
            i4++;
            if (i4 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i4 > i2) {
                break;
            }
            i3.f.o(a2, t2, bVar);
        }
        if (i2 >= 0 && i4 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> iterable, C c2) {
        f3.c.d(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }
}
