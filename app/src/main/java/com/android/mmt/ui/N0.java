package com.android.mmt.ui;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.ui.O0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class N0 extends RecyclerView.e<RecyclerView.x> {

    /* renamed from: h, reason: collision with root package name */
    private static int f5093h = 10000000;

    /* renamed from: i, reason: collision with root package name */
    private static int f5094i = 20000000;

    /* renamed from: c, reason: collision with root package name */
    private d f5095c;
    private e d;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<View> f5096e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private SparseArray<View> f5097f = new SparseArray<>();
    private RecyclerView.e g;

    final class a implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f5098i;

        a(int i2) {
            this.f5098i = i2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d dVar = N0.this.f5095c;
            int i2 = this.f5098i;
            N0.this.M(i2);
            O0.b bVar = (O0.b) dVar;
            if (O0.this.f5202I0 != null) {
                O0.this.f5202I0.a(O0.this, view, i2);
            }
        }
    }

    final class b implements View.OnLongClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f5100i;

        b(int i2) {
            this.f5100i = i2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            Log.v("Anting", " onlong click " + view);
            e eVar = N0.this.d;
            int i2 = this.f5100i;
            N0.this.M(i2);
            return O0.this.f5203J0.a(view, i2);
        }
    }

    class c extends RecyclerView.x {
        public c(View view) {
            super(view);
        }
    }

    public interface d {
    }

    public interface e {
    }

    public N0(RecyclerView.e eVar) {
        this.g = eVar;
    }

    public final void I(View view) {
        if (this.f5097f.indexOfValue(view) < 0) {
            SparseArray<View> sparseArray = this.f5097f;
            int i2 = f5094i;
            f5094i = i2 + 1;
            sparseArray.put(i2, view);
        }
        n();
    }

    public final void J(View view) {
        if (this.f5096e.indexOfValue(view) < 0) {
            SparseArray<View> sparseArray = this.f5096e;
            int i2 = f5093h;
            f5093h = i2 + 1;
            sparseArray.put(i2, view);
        }
        n();
    }

    public final RecyclerView.e K() {
        return this.g;
    }

    public final int L() {
        SparseArray<View> sparseArray = this.f5096e;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        return 0;
    }

    public final Object M(int i2) {
        if (this.g != null && !P(i2) && !O(i2)) {
            RecyclerView.e eVar = this.g;
            if (eVar instanceof C0) {
                return ((C0) eVar).G(i2 - this.f5096e.size());
            }
        }
        return null;
    }

    public final int N() {
        return this.g.j();
    }

    public final boolean O(int i2) {
        return i2 >= this.g.j() + this.f5096e.size();
    }

    public final boolean P(int i2) {
        return i2 < this.f5096e.size();
    }

    public final boolean Q(View view) {
        int iIndexOfValue = this.f5096e.indexOfValue(view);
        if (iIndexOfValue < 0) {
            return false;
        }
        this.f5096e.removeAt(iIndexOfValue);
        n();
        return true;
    }

    public final void R(ArrayList<View> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.f5097f.clear();
            return;
        }
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (this.f5097f.indexOfValue(next) < 0) {
                SparseArray<View> sparseArray = this.f5097f;
                int i2 = f5093h;
                f5093h = i2 + 1;
                sparseArray.put(i2, next);
            }
        }
    }

    public final void S(ArrayList<View> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.f5096e.clear();
            return;
        }
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (this.f5096e.indexOfValue(next) < 0) {
                SparseArray<View> sparseArray = this.f5096e;
                int i2 = f5093h;
                f5093h = i2 + 1;
                sparseArray.put(i2, next);
            }
        }
    }

    public final void T(d dVar) {
        this.f5095c = dVar;
    }

    public final void U(e eVar) {
        this.d = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int j() {
        return this.f5097f.size() + this.f5096e.size() + this.g.j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final long k(int i2) {
        if (this.g != null && !P(i2) && !O(i2)) {
            RecyclerView.e eVar = this.g;
            if (eVar instanceof C0) {
                return ((C0) eVar).k(i2 - this.f5096e.size());
            }
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int l(int i2) {
        if (P(i2)) {
            return this.f5096e.keyAt(i2);
        }
        if (O(i2)) {
            return this.f5097f.keyAt((i2 - this.f5096e.size()) - this.g.j());
        }
        return this.g.l(i2 - this.f5096e.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void x(RecyclerView.x xVar, int i2) {
        if (this.f5095c != null) {
            xVar.f4055i.setOnClickListener(new a(i2));
        }
        if (this.d != null) {
            xVar.f4055i.setOnLongClickListener(new b(i2));
        }
        if (P(i2) || O(i2)) {
            return;
        }
        this.g.x(xVar, i2 - this.f5096e.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final RecyclerView.x y(ViewGroup viewGroup, int i2) {
        if (this.f5096e.indexOfKey(i2) >= 0) {
            return new c(this.f5096e.get(i2));
        }
        return this.f5097f.indexOfKey(i2) >= 0 ? new c(this.f5097f.get(i2)) : this.g.y(viewGroup, i2);
    }
}
