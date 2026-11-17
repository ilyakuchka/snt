package androidx.recyclerview.widget;

import F.b;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class v extends androidx.core.view.a {

    /* renamed from: a, reason: collision with root package name */
    final RecyclerView f4263a;

    /* renamed from: b, reason: collision with root package name */
    final a f4264b = new a(this);

    public static class a extends androidx.core.view.a {

        /* renamed from: a, reason: collision with root package name */
        final v f4265a;

        public a(v vVar) {
            this.f4265a = vVar;
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
            RecyclerView.l lVar;
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            if (this.f4265a.b() || (lVar = this.f4265a.f4263a.u) == null) {
                return;
            }
            lVar.i0(view, bVar);
        }

        @Override // androidx.core.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            RecyclerView.l lVar;
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            if (!this.f4265a.b() && (lVar = this.f4265a.f4263a.u) != null) {
                RecyclerView.q qVar = lVar.f3990b.f3946j;
            }
            return false;
        }
    }

    public v(RecyclerView recyclerView) {
        this.f4263a = recyclerView;
    }

    public androidx.core.view.a a() {
        return this.f4264b;
    }

    final boolean b() {
        return this.f4263a.S();
    }

    @Override // androidx.core.view.a
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        RecyclerView.l lVar;
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || b() || (lVar = ((RecyclerView) view).u) == null) {
            return;
        }
        lVar.h0(accessibilityEvent);
    }

    @Override // androidx.core.view.a
    public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
        RecyclerView.l lVar;
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        bVar.E(RecyclerView.class.getName());
        if (b() || (lVar = this.f4263a.u) == null) {
            return;
        }
        RecyclerView recyclerView = lVar.f3990b;
        RecyclerView.q qVar = recyclerView.f3946j;
        RecyclerView.v vVar = recyclerView.f3953m0;
        if (recyclerView.canScrollVertically(-1) || lVar.f3990b.canScrollHorizontally(-1)) {
            bVar.a(8192);
            bVar.U(true);
        }
        if (lVar.f3990b.canScrollVertically(1) || lVar.f3990b.canScrollHorizontally(1)) {
            bVar.a(4096);
            bVar.U(true);
        }
        bVar.G(b.C0004b.a(lVar.U(qVar, vVar), lVar.C(qVar, vVar)));
    }

    @Override // androidx.core.view.a
    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        RecyclerView.l lVar;
        if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        if (b() || (lVar = this.f4263a.u) == null) {
            return false;
        }
        return lVar.v0(i2);
    }
}
