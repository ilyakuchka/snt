package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.o;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import i.C0333a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import t.C0384b;

/* loaded from: classes.dex */
public class d extends RecyclerView.e<h> implements Preference.c {

    /* renamed from: c, reason: collision with root package name */
    private PreferenceGroup f3850c;
    private List<Preference> d;

    /* renamed from: e, reason: collision with root package name */
    private List<Preference> f3851e;

    /* renamed from: f, reason: collision with root package name */
    private List<b> f3852f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f3853h = new a();
    private Handler g = new Handler();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.M();
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        int f3855a;

        /* renamed from: b, reason: collision with root package name */
        int f3856b;

        /* renamed from: c, reason: collision with root package name */
        String f3857c;

        b(Preference preference) {
            this.f3857c = preference.getClass().getName();
            this.f3855a = preference.p();
            this.f3856b = preference.B();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3855a == bVar.f3855a && this.f3856b == bVar.f3856b && TextUtils.equals(this.f3857c, bVar.f3857c);
        }

        public final int hashCode() {
            return this.f3857c.hashCode() + ((((527 + this.f3855a) * 31) + this.f3856b) * 31);
        }
    }

    public d(PreferenceGroup preferenceGroup) {
        this.f3850c = preferenceGroup;
        this.f3850c.j0(this);
        this.d = new ArrayList();
        this.f3851e = new ArrayList();
        this.f3852f = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f3850c;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            E(((PreferenceScreen) preferenceGroup2).G0());
        } else {
            E(true);
        }
        M();
    }

    private List<Preference> G(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iA0 = preferenceGroup.A0();
        int i2 = 0;
        for (int i4 = 0; i4 < iA0; i4++) {
            Preference preferenceZ0 = preferenceGroup.z0(i4);
            if (preferenceZ0.G()) {
                if (!J(preferenceGroup) || i2 < preferenceGroup.y0()) {
                    arrayList.add(preferenceZ0);
                } else {
                    arrayList2.add(preferenceZ0);
                }
                if (preferenceZ0 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceZ0;
                    if (!(!(preferenceGroup2 instanceof PreferenceScreen))) {
                        continue;
                    } else {
                        if (J(preferenceGroup) && J(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        Iterator it = ((ArrayList) G(preferenceGroup2)).iterator();
                        while (it.hasNext()) {
                            Preference preference = (Preference) it.next();
                            if (!J(preferenceGroup) || i2 < preferenceGroup.y0()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i2++;
                        }
                    }
                } else {
                    i2++;
                }
            }
        }
        if (J(preferenceGroup) && i2 > preferenceGroup.y0()) {
            androidx.preference.a aVar = new androidx.preference.a(preferenceGroup.i(), arrayList2, preferenceGroup.m());
            aVar.l0(new e(this, preferenceGroup));
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.ArrayList, java.util.List<androidx.preference.d$b>] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList, java.util.List<androidx.preference.d$b>] */
    private void H(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.F0();
        int iA0 = preferenceGroup.A0();
        for (int i2 = 0; i2 < iA0; i2++) {
            Preference preferenceZ0 = preferenceGroup.z0(i2);
            list.add(preferenceZ0);
            b bVar = new b(preferenceZ0);
            if (!this.f3852f.contains(bVar)) {
                this.f3852f.add(bVar);
            }
            if (preferenceZ0 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceZ0;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    H(list, preferenceGroup2);
                }
            }
            preferenceZ0.j0(this);
        }
    }

    private boolean J(PreferenceGroup preferenceGroup) {
        return preferenceGroup.y0() != Integer.MAX_VALUE;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    public final Preference I(int i2) {
        if (i2 < 0 || i2 >= j()) {
            return null;
        }
        return (Preference) this.f3851e.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void x(h hVar, int i2) {
        I(i2).N(hVar);
    }

    public final void L() {
        this.g.removeCallbacks(this.f3853h);
        this.g.post(this.f3853h);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    final void M() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).j0(null);
        }
        ArrayList arrayList = new ArrayList(this.d.size());
        this.d = arrayList;
        H(arrayList, this.f3850c);
        this.f3851e = (ArrayList) G(this.f3850c);
        Objects.requireNonNull(this.f3850c);
        n();
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            Objects.requireNonNull((Preference) it2.next());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    public void f(Preference preference) {
        int iIndexOf = this.f3851e.indexOf(preference);
        if (iIndexOf != -1) {
            p(iIndexOf, preference);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int j() {
        return this.f3851e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final long k(int i2) {
        if (m()) {
            return I(i2).m();
        }
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<androidx.preference.d$b>] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList, java.util.List<androidx.preference.d$b>] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList, java.util.List<androidx.preference.d$b>] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int l(int i2) {
        b bVar = new b(I(i2));
        int iIndexOf = this.f3852f.indexOf(bVar);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.f3852f.size();
        this.f3852f.add(bVar);
        return size;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.ArrayList, java.util.List<androidx.preference.d$b>] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final RecyclerView.x y(ViewGroup viewGroup, int i2) {
        b bVar = (b) this.f3852f.get(i2);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, C0384b.g);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = C0333a.a(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(bVar.f3855a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            int i4 = o.d;
            viewInflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i5 = bVar.f3856b;
            if (i5 != 0) {
                layoutInflaterFrom.inflate(i5, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new h(viewInflate);
    }
}
