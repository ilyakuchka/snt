package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import com.android.mmt.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a implements l {

    /* renamed from: i, reason: collision with root package name */
    protected Context f2484i;

    /* renamed from: j, reason: collision with root package name */
    protected Context f2485j;

    /* renamed from: k, reason: collision with root package name */
    protected f f2486k;

    /* renamed from: l, reason: collision with root package name */
    protected LayoutInflater f2487l;

    /* renamed from: m, reason: collision with root package name */
    private l.a f2488m;

    /* renamed from: n, reason: collision with root package name */
    private int f2489n = R.layout.abc_action_menu_layout;

    /* renamed from: o, reason: collision with root package name */
    private int f2490o = R.layout.abc_action_menu_item_layout;
    protected m p;

    public a(Context context) {
        this.f2484i = context;
        this.f2487l = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.l
    public void a(f fVar, boolean z4) {
        l.a aVar = this.f2488m;
        if (aVar != null) {
            aVar.a(fVar, z4);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean b(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void c(Context context, f fVar) {
        this.f2485j = context;
        LayoutInflater.from(context);
        this.f2486k = fVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public final void d(l.a aVar) {
        this.f2488m = aVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean e(h hVar) {
        return false;
    }

    public abstract void f(h hVar, m.a aVar);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.appcompat.view.menu.f] */
    @Override // androidx.appcompat.view.menu.l
    public boolean g(p pVar) {
        l.a aVar = this.f2488m;
        p pVar2 = pVar;
        if (aVar == null) {
            return false;
        }
        if (pVar == null) {
            pVar2 = this.f2486k;
        }
        return aVar.b(pVar2);
    }

    protected abstract boolean h(ViewGroup viewGroup, int i2);

    public final l.a i() {
        return this.f2488m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View j(h hVar, View view, ViewGroup viewGroup) {
        m.a aVar = view instanceof m.a ? (m.a) view : (m.a) this.f2487l.inflate(this.f2490o, viewGroup, false);
        f(hVar, aVar);
        return (View) aVar;
    }

    public m k(ViewGroup viewGroup) {
        if (this.p == null) {
            m mVar = (m) this.f2487l.inflate(this.f2489n, viewGroup, false);
            this.p = mVar;
            mVar.b(this.f2486k);
            updateMenuView(true);
        }
        return this.p;
    }

    public abstract boolean l(h hVar);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.l
    public void updateMenuView(boolean z4) {
        ViewGroup viewGroup = (ViewGroup) this.p;
        if (viewGroup == null) {
            return;
        }
        f fVar = this.f2486k;
        int i2 = 0;
        if (fVar != null) {
            fVar.k();
            ArrayList<h> arrayListR = this.f2486k.r();
            int size = arrayListR.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                h hVar = arrayListR.get(i5);
                if (l(hVar)) {
                    View childAt = viewGroup.getChildAt(i4);
                    h itemData = childAt instanceof m.a ? ((m.a) childAt).getItemData() : null;
                    View viewJ = j(hVar, childAt, viewGroup);
                    if (hVar != itemData) {
                        viewJ.setPressed(false);
                        viewJ.jumpDrawablesToCurrentState();
                    }
                    if (viewJ != childAt) {
                        ViewGroup viewGroup2 = (ViewGroup) viewJ.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(viewJ);
                        }
                        ((ViewGroup) this.p).addView(viewJ, i4);
                    }
                    i4++;
                }
            }
            i2 = i4;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!h(viewGroup, i2)) {
                i2++;
            }
        }
    }
}
