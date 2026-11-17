package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class G extends I {

    final class a extends Transition.EpicenterCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f3460a;

        a(Rect rect) {
            this.f3460a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public final Rect onGetEpicenter(Transition transition) {
            return this.f3460a;
        }
    }

    final class b implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3461a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3462b;

        b(View view, ArrayList arrayList) {
            this.f3461a = view;
            this.f3462b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f3461a.setVisibility(8);
            int size = this.f3462b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f3462b.get(i2)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    final class c implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f3463a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3464b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f3465c;
        final /* synthetic */ ArrayList d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f3466e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f3467f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3463a = obj;
            this.f3464b = arrayList;
            this.f3465c = obj2;
            this.d = arrayList2;
            this.f3466e = obj3;
            this.f3467f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition transition) {
            Object obj = this.f3463a;
            if (obj != null) {
                G.this.u(obj, this.f3464b, null);
            }
            Object obj2 = this.f3465c;
            if (obj2 != null) {
                G.this.u(obj2, this.d, null);
            }
            Object obj3 = this.f3466e;
            if (obj3 != null) {
                G.this.u(obj3, this.f3467f, null);
            }
        }
    }

    final class d extends Transition.EpicenterCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f3468a;

        d(Rect rect) {
            this.f3468a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public final Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f3468a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f3468a;
        }
    }

    G() {
    }

    private static boolean t(Transition transition) {
        return (I.g(transition.getTargetIds()) && I.g(transition.getTargetNames()) && I.g(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.I
    public final void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.I
    public final void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                b(transitionSet.getTransitionAt(i2), arrayList);
                i2++;
            }
            return;
        }
        if (t(transition) || !I.g(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i2 < size) {
            transition.addTarget(arrayList.get(i2));
            i2++;
        }
    }

    @Override // androidx.fragment.app.I
    public final void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.I
    public final boolean d(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.I
    public final Object e(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.I
    public final Object h(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.I
    public final Object i(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.I
    public final void k(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.I
    public final void l(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.I
    public final void m(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new d(rect));
        }
    }

    @Override // androidx.fragment.app.I
    public final void n(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            f(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.I
    public final void o(Object obj, Runnable runnable) {
        ((Transition) obj).addListener(new H(runnable));
    }

    @Override // androidx.fragment.app.I
    public final void q(Object obj, View view, ArrayList<View> arrayList) {
        boolean z4;
        boolean z5;
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            int size2 = targets.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size2) {
                    z4 = false;
                    break;
                } else {
                    if (targets.get(i4) == view2) {
                        z4 = true;
                        break;
                    }
                    i4++;
                }
            }
            if (!z4) {
                int i5 = androidx.core.view.o.d;
                if (view2.getTransitionName() != null) {
                    targets.add(view2);
                }
                for (int i6 = size2; i6 < targets.size(); i6++) {
                    View view3 = targets.get(i6);
                    if (view3 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view3;
                        int childCount = viewGroup.getChildCount();
                        for (int i7 = 0; i7 < childCount; i7++) {
                            View childAt = viewGroup.getChildAt(i7);
                            int i8 = 0;
                            while (true) {
                                if (i8 >= size2) {
                                    z5 = false;
                                    break;
                                } else {
                                    if (targets.get(i8) == childAt) {
                                        z5 = true;
                                        break;
                                    }
                                    i8++;
                                }
                            }
                            if (!z5 && childAt.getTransitionName() != null) {
                                targets.add(childAt);
                            }
                        }
                    }
                }
            }
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.I
    public final void r(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            u(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.I
    public final Object s(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public final void u(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                u(transitionSet.getTransitionAt(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (t(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i2 < size) {
            transition.addTarget(arrayList2.get(i2));
            i2++;
        }
        int size2 = arrayList.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return;
            } else {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }
}
