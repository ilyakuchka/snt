package Z2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class g extends k {
    public static boolean c(Collection collection, Iterable iterable) {
        f3.c.d(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z4 = false;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z4 = true;
            }
        }
        return z4;
    }

    public static int d(Iterable iterable) {
        f3.c.d(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }

    public static Object e(List list) {
        f3.c.d(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static /* synthetic */ Appendable f(Iterable iterable, Appendable appendable) throws IOException {
        k.a(iterable, appendable, "\n", "", "", -1, "...", null);
        return appendable;
    }

    public static List g(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        f3.c.c(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }

    public static List h(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List i(Object... objArr) {
        f3.c.d(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new c(objArr, true));
    }

    public static List j(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : g(list.get(0)) : m.f2185i;
    }

    public static List k(Collection collection, Object obj) {
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static void l() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static List m(Iterable iterable) {
        List listN;
        f3.c.d(iterable, "<this>");
        boolean z4 = iterable instanceof Collection;
        if (!z4) {
            if (z4) {
                listN = n((Collection) iterable);
            } else {
                ArrayList arrayList = new ArrayList();
                k.b(iterable, arrayList);
                listN = arrayList;
            }
            return j(listN);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m.f2185i;
        }
        if (size != 1) {
            return n(collection);
        }
        return g(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static List n(Collection collection) {
        f3.c.d(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set o(Iterable iterable) {
        Set setSingleton;
        f3.c.d(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return o.f2187i;
            }
            if (size != 1) {
                int size2 = collection.size();
                if (size2 >= 0) {
                    size2 = size2 < 3 ? size2 + 1 : size2 < 1073741824 ? (int) ((size2 / 0.75f) + 1.0f) : Integer.MAX_VALUE;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(size2);
                k.b(iterable, linkedHashSet);
                return linkedHashSet;
            }
            setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : ((ArrayList) iterable).iterator().next());
            f3.c.c(setSingleton, "singleton(element)");
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            k.b(iterable, linkedHashSet2);
            int size3 = linkedHashSet2.size();
            if (size3 == 0) {
                setSingleton = o.f2187i;
            } else {
                if (size3 != 1) {
                    return linkedHashSet2;
                }
                setSingleton = Collections.singleton(linkedHashSet2.iterator().next());
                f3.c.c(setSingleton, "singleton(element)");
            }
        }
        return setSingleton;
    }
}
