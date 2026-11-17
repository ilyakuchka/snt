package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class I {

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f3470i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f3471j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f3472k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ ArrayList f3473l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ArrayList f3474m;

        a(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f3470i = i2;
            this.f3471j = arrayList;
            this.f3472k = arrayList2;
            this.f3473l = arrayList3;
            this.f3474m = arrayList4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (int i2 = 0; i2 < this.f3470i; i2++) {
                View view = (View) this.f3471j.get(i2);
                String str = (String) this.f3472k.get(i2);
                int i4 = androidx.core.view.o.d;
                view.setTransitionName(str);
                ((View) this.f3473l.get(i2)).setTransitionName((String) this.f3474m.get(i2));
            }
        }
    }

    protected static boolean g(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean d(Object obj);

    public abstract Object e(Object obj);

    protected final void f(View view, Rect rect) {
        int i2 = androidx.core.view.o.d;
        if (view.isAttachedToWindow()) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r0[0], r0[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object h(Object obj, Object obj2, Object obj3);

    public abstract Object i(Object obj, Object obj2, Object obj3);

    final ArrayList<String> j(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            int i4 = androidx.core.view.o.d;
            arrayList2.add(view.getTransitionName());
            view.setTransitionName(null);
        }
        return arrayList2;
    }

    public abstract void k(Object obj, View view, ArrayList<View> arrayList);

    public abstract void l(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void m(Object obj, Rect rect);

    public abstract void n(Object obj, View view);

    public void o(Object obj, Runnable runnable) {
        runnable.run();
    }

    final void p(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            int i4 = androidx.core.view.o.d;
            String transitionName = view2.getTransitionName();
            arrayList4.add(transitionName);
            if (transitionName != null) {
                view2.setTransitionName(null);
                String str = map.get(transitionName);
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i5))) {
                        arrayList2.get(i5).setTransitionName(transitionName);
                        break;
                    }
                    i5++;
                }
            }
        }
        androidx.core.view.n.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void q(Object obj, View view, ArrayList<View> arrayList);

    public abstract void r(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object s(Object obj);
}
