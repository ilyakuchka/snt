package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.J;
import androidx.appcompat.widget.K;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class c extends j implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: A, reason: collision with root package name */
    private boolean f2494A;

    /* renamed from: B, reason: collision with root package name */
    private int f2495B;

    /* renamed from: C, reason: collision with root package name */
    private int f2496C;

    /* renamed from: E, reason: collision with root package name */
    private boolean f2498E;

    /* renamed from: F, reason: collision with root package name */
    private l.a f2499F;

    /* renamed from: G, reason: collision with root package name */
    ViewTreeObserver f2500G;

    /* renamed from: H, reason: collision with root package name */
    private PopupWindow.OnDismissListener f2501H;

    /* renamed from: I, reason: collision with root package name */
    boolean f2502I;

    /* renamed from: j, reason: collision with root package name */
    private final Context f2503j;

    /* renamed from: k, reason: collision with root package name */
    private final int f2504k;

    /* renamed from: l, reason: collision with root package name */
    private final int f2505l;

    /* renamed from: m, reason: collision with root package name */
    private final int f2506m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f2507n;

    /* renamed from: o, reason: collision with root package name */
    final Handler f2508o;

    /* renamed from: w, reason: collision with root package name */
    private View f2514w;

    /* renamed from: x, reason: collision with root package name */
    View f2515x;

    /* renamed from: y, reason: collision with root package name */
    private int f2516y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f2517z;
    private final List<f> p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    final List<d> f2509q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f2510r = new a();

    /* renamed from: s, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f2511s = new b();

    /* renamed from: t, reason: collision with root package name */
    private final J f2512t = new C0057c();
    private int u = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f2513v = 0;

    /* renamed from: D, reason: collision with root package name */
    private boolean f2497D = false;

    final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (!c.this.isShowing() || c.this.f2509q.size() <= 0 || ((d) c.this.f2509q.get(0)).f2525a.k()) {
                return;
            }
            View view = c.this.f2515x;
            if (view == null || !view.isShown()) {
                c.this.dismiss();
                return;
            }
            Iterator it = c.this.f2509q.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f2525a.f();
            }
        }
    }

    final class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = c.this.f2500G;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    c.this.f2500G = view.getViewTreeObserver();
                }
                c cVar = c.this;
                cVar.f2500G.removeGlobalOnLayoutListener(cVar.f2510r);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.c$c, reason: collision with other inner class name */
    final class C0057c implements J {

        /* renamed from: androidx.appcompat.view.menu.c$c$a */
        final class a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ d f2521i;

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ MenuItem f2522j;

            /* renamed from: k, reason: collision with root package name */
            final /* synthetic */ f f2523k;

            a(d dVar, MenuItem menuItem, f fVar) {
                this.f2521i = dVar;
                this.f2522j = menuItem;
                this.f2523k = fVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d dVar = this.f2521i;
                if (dVar != null) {
                    c.this.f2502I = true;
                    dVar.f2526b.e(false);
                    c.this.f2502I = false;
                }
                if (this.f2522j.isEnabled() && this.f2522j.hasSubMenu()) {
                    this.f2523k.y(this.f2522j, 4);
                }
            }
        }

        C0057c() {
        }

        /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
        @Override // androidx.appcompat.widget.J
        public final void e(f fVar, MenuItem menuItem) {
            c.this.f2508o.removeCallbacksAndMessages(null);
            int size = c.this.f2509q.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (fVar == ((d) c.this.f2509q.get(i2)).f2526b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i4 = i2 + 1;
            c.this.f2508o.postAtTime(new a(i4 < c.this.f2509q.size() ? (d) c.this.f2509q.get(i4) : null, menuItem, fVar), fVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.J
        public final void g(f fVar, MenuItem menuItem) {
            c.this.f2508o.removeCallbacksAndMessages(fVar);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final K f2525a;

        /* renamed from: b, reason: collision with root package name */
        public final f f2526b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2527c;

        public d(K k2, f fVar, int i2) {
            this.f2525a = k2;
            this.f2526b = fVar;
            this.f2527c = i2;
        }

        public final ListView a() {
            return this.f2525a.h();
        }
    }

    public c(Context context, View view, int i2, int i4, boolean z4) {
        this.f2503j = context;
        this.f2514w = view;
        this.f2505l = i2;
        this.f2506m = i4;
        this.f2507n = z4;
        int i5 = androidx.core.view.o.d;
        this.f2516y = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f2504k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2508o = new Handler();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0155  */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(f fVar) {
        d dVar;
        View childAt;
        int i2;
        int i4;
        MenuItem item;
        e eVar;
        int headersCount;
        int firstVisiblePosition;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2503j);
        e eVar2 = new e(fVar, layoutInflaterFrom, this.f2507n, R.layout.abc_cascading_menu_item_layout);
        if (!isShowing() && this.f2497D) {
            eVar2.e(true);
        } else if (isShowing()) {
            eVar2.e(j.t(fVar));
        }
        int iK = j.k(eVar2, this.f2503j, this.f2504k);
        K k2 = new K(this.f2503j, this.f2505l, this.f2506m);
        k2.x(this.f2512t);
        k2.t(this);
        k2.s(this);
        k2.l(this.f2514w);
        k2.o(this.f2513v);
        k2.r();
        k2.q();
        k2.setAdapter(eVar2);
        k2.n(iK);
        k2.o(this.f2513v);
        if (this.f2509q.size() > 0) {
            ?? r32 = this.f2509q;
            dVar = (d) r32.get(r32.size() - 1);
            f fVar2 = dVar.f2526b;
            int size = fVar2.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    item = null;
                    break;
                }
                item = fVar2.getItem(i5);
                if (item.hasSubMenu() && fVar == item.getSubMenu()) {
                    break;
                } else {
                    i5++;
                }
            }
            if (item != null) {
                ListView listViewA = dVar.a();
                ListAdapter adapter = listViewA.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    eVar = (e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    eVar = (e) adapter;
                    headersCount = 0;
                }
                int count = eVar.getCount();
                int i6 = 0;
                while (true) {
                    if (i6 >= count) {
                        i6 = -1;
                        break;
                    } else if (item == eVar.getItem(i6)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                childAt = (i6 != -1 && (firstVisiblePosition = (i6 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) ? listViewA.getChildAt(firstVisiblePosition) : null;
            }
            if (childAt == null) {
                k2.y();
                k2.v();
                ?? r9 = this.f2509q;
                ListView listViewA2 = ((d) r9.get(r9.size() - 1)).a();
                int[] iArr = new int[2];
                listViewA2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                this.f2515x.getWindowVisibleDisplayFrame(rect);
                if (this.f2516y == 1) {
                    i2 = (listViewA2.getWidth() + iArr[0]) + iK > rect.right ? 0 : 1;
                } else if (iArr[0] - iK < 0) {
                }
                boolean z4 = i2 == 1;
                this.f2516y = i2;
                k2.l(childAt);
                if ((this.f2513v & 5) == 5) {
                    if (!z4) {
                        iK = childAt.getWidth();
                        i4 = 0 - iK;
                    }
                    i4 = iK + 0;
                } else {
                    if (z4) {
                        iK = childAt.getWidth();
                        i4 = iK + 0;
                    }
                    i4 = 0 - iK;
                }
                k2.setHorizontalOffset(i4);
                k2.u();
                k2.setVerticalOffset(0);
            } else {
                if (this.f2517z) {
                    k2.setHorizontalOffset(this.f2495B);
                }
                if (this.f2494A) {
                    k2.setVerticalOffset(this.f2496C);
                }
                k2.p(j());
            }
            this.f2509q.add(new d(k2, fVar, this.f2516y));
            k2.f();
            ListView listViewH = k2.h();
            listViewH.setOnKeyListener(this);
            if (dVar == null || !this.f2498E || fVar.f2552m == null) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewH, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(fVar.f2552m);
            listViewH.addHeaderView(frameLayout, null, false);
            k2.f();
            return;
        }
        dVar = null;
        if (childAt == null) {
        }
        this.f2509q.add(new d(k2, fVar, this.f2516y));
        k2.f();
        ListView listViewH2 = k2.h();
        listViewH2.setOnKeyListener(this);
        if (dVar == null) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    @Override // androidx.appcompat.view.menu.l
    public final void a(f fVar, boolean z4) {
        int size = this.f2509q.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (fVar == ((d) this.f2509q.get(i2)).f2526b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            return;
        }
        int i4 = i2 + 1;
        if (i4 < this.f2509q.size()) {
            ((d) this.f2509q.get(i4)).f2526b.e(false);
        }
        d dVar = (d) this.f2509q.remove(i2);
        dVar.f2526b.B(this);
        if (this.f2502I) {
            dVar.f2525a.w();
            dVar.f2525a.m();
        }
        dVar.f2525a.dismiss();
        int size2 = this.f2509q.size();
        if (size2 > 0) {
            this.f2516y = ((d) this.f2509q.get(size2 - 1)).f2527c;
        } else {
            View view = this.f2514w;
            int i5 = androidx.core.view.o.d;
            this.f2516y = view.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z4) {
                ((d) this.f2509q.get(0)).f2526b.e(false);
                return;
            }
            return;
        }
        dismiss();
        l.a aVar = this.f2499F;
        if (aVar != null) {
            aVar.a(fVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f2500G;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f2500G.removeGlobalOnLayoutListener(this.f2510r);
            }
            this.f2500G = null;
        }
        this.f2515x.removeOnAttachStateChangeListener(this.f2511s);
        this.f2501H.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.l
    public final void d(l.a aVar) {
        this.f2499F = aVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    @Override // m.b
    public final void dismiss() {
        int size = this.f2509q.size();
        if (size <= 0) {
            return;
        }
        d[] dVarArr = (d[]) this.f2509q.toArray(new d[size]);
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            d dVar = dVarArr[size];
            if (dVar.f2525a.isShowing()) {
                dVar.f2525a.dismiss();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.f>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.f>] */
    @Override // m.b
    public final void f() {
        if (isShowing()) {
            return;
        }
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            u((f) it.next());
        }
        this.p.clear();
        View view = this.f2514w;
        this.f2515x = view;
        if (view != null) {
            boolean z4 = this.f2500G == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f2500G = viewTreeObserver;
            if (z4) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f2510r);
            }
            this.f2515x.addOnAttachStateChangeListener(this.f2511s);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean flagActionItems() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    @Override // androidx.appcompat.view.menu.l
    public final boolean g(p pVar) {
        Iterator it = this.f2509q.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (pVar == dVar.f2526b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        i(pVar);
        l.a aVar = this.f2499F;
        if (aVar != null) {
            aVar.b(pVar);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    @Override // m.b
    public final ListView h() {
        if (this.f2509q.isEmpty()) {
            return null;
        }
        return ((d) this.f2509q.get(r1.size() - 1)).a();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.f>] */
    @Override // androidx.appcompat.view.menu.j
    public final void i(f fVar) {
        fVar.c(this, this.f2503j);
        if (isShowing()) {
            u(fVar);
        } else {
            this.p.add(fVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    @Override // m.b
    public final boolean isShowing() {
        return this.f2509q.size() > 0 && ((d) this.f2509q.get(0)).f2525a.isShowing();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void l(View view) {
        if (this.f2514w != view) {
            this.f2514w = view;
            int i2 = this.u;
            int i4 = androidx.core.view.o.d;
            this.f2513v = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void n(boolean z4) {
        this.f2497D = z4;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void o(int i2) {
        if (this.u != i2) {
            this.u = i2;
            View view = this.f2514w;
            int i4 = androidx.core.view.o.d;
            this.f2513v = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        int size = this.f2509q.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f2509q.get(i2);
            if (!dVar.f2525a.isShowing()) {
                break;
            } else {
                i2++;
            }
        }
        if (dVar != null) {
            dVar.f2526b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void p(int i2) {
        this.f2517z = true;
        this.f2495B = i2;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.f2501H = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void r(boolean z4) {
        this.f2498E = z4;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void s(int i2) {
        this.f2494A = true;
        this.f2496C = i2;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<androidx.appcompat.view.menu.c$d>] */
    @Override // androidx.appcompat.view.menu.l
    public final void updateMenuView(boolean z4) {
        Iterator it = this.f2509q.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((d) it.next()).a().getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((e) adapter).notifyDataSetChanged();
        }
    }
}
