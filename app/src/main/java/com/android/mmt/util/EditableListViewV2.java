package com.android.mmt.util;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.ui.O0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class EditableListViewV2 extends O0 {

    /* renamed from: i1, reason: collision with root package name */
    private static final int f5848i1 = ViewConfiguration.getDoubleTapTimeout();

    /* renamed from: j1, reason: collision with root package name */
    public static final /* synthetic */ int f5849j1 = 0;

    /* renamed from: N0, reason: collision with root package name */
    protected boolean f5850N0;

    /* renamed from: O0, reason: collision with root package name */
    private boolean f5851O0;

    /* renamed from: P0, reason: collision with root package name */
    private boolean f5852P0;

    /* renamed from: Q0, reason: collision with root package name */
    private O0.d f5853Q0;

    /* renamed from: R0, reason: collision with root package name */
    private l f5854R0;

    /* renamed from: S0, reason: collision with root package name */
    private h f5855S0;

    /* renamed from: T0, reason: collision with root package name */
    private g f5856T0;

    /* renamed from: U0, reason: collision with root package name */
    private ActionMode f5857U0;

    /* renamed from: V0, reason: collision with root package name */
    private Integer f5858V0;

    /* renamed from: W0, reason: collision with root package name */
    private boolean f5859W0;

    /* renamed from: X0, reason: collision with root package name */
    private boolean f5860X0;

    /* renamed from: Y0, reason: collision with root package name */
    private int f5861Y0;

    /* renamed from: Z0, reason: collision with root package name */
    private RecyclerView f5862Z0;

    /* renamed from: a1, reason: collision with root package name */
    private View f5863a1;

    /* renamed from: b1, reason: collision with root package name */
    private int f5864b1;

    /* renamed from: c1, reason: collision with root package name */
    private Message f5865c1;

    /* renamed from: d1, reason: collision with root package name */
    private int f5866d1;

    /* renamed from: e1, reason: collision with root package name */
    private int f5867e1;

    /* renamed from: f1, reason: collision with root package name */
    private View f5868f1;

    /* renamed from: g1, reason: collision with root package name */
    private boolean f5869g1;

    /* renamed from: h1, reason: collision with root package name */
    private Handler f5870h1;

    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                l lVar = EditableListViewV2.this.f5854R0;
                RecyclerView unused = EditableListViewV2.this.f5862Z0;
                View unused2 = EditableListViewV2.this.f5863a1;
                int i4 = EditableListViewV2.this.f5864b1;
                Objects.requireNonNull(EditableListViewV2.this);
                lVar.b(i4);
                EditableListViewV2.this.f5860X0 = false;
                return;
            }
            if (i2 != 2) {
                return;
            }
            l lVar2 = EditableListViewV2.this.f5854R0;
            RecyclerView unused3 = EditableListViewV2.this.f5862Z0;
            View unused4 = EditableListViewV2.this.f5863a1;
            int i5 = EditableListViewV2.this.f5864b1;
            Objects.requireNonNull(EditableListViewV2.this);
            lVar2.a(i5);
            EditableListViewV2.this.f5860X0 = false;
        }
    }

    final class b implements O0.d {
        b() {
        }

        @Override // com.android.mmt.ui.O0.d
        public final void a(RecyclerView recyclerView, View view, int i2) {
            EditableListViewV2.this.f5862Z0 = recyclerView;
            EditableListViewV2.this.f5863a1 = view;
            EditableListViewV2.this.f5864b1 = i2;
            if (!EditableListViewV2.this.f5860X0) {
                EditableListViewV2.this.f5861Y0 = i2;
                EditableListViewV2.this.f5860X0 = true;
                EditableListViewV2 editableListViewV2 = EditableListViewV2.this;
                editableListViewV2.f5865c1 = editableListViewV2.f5870h1.obtainMessage();
                EditableListViewV2.this.f5870h1.removeMessages(1);
                EditableListViewV2.this.f5865c1.what = 1;
                EditableListViewV2.this.f5870h1.sendMessageDelayed(EditableListViewV2.this.f5865c1, EditableListViewV2.f5848i1);
                return;
            }
            if (EditableListViewV2.this.f5861Y0 == i2) {
                EditableListViewV2.this.f5870h1.removeMessages(1);
                EditableListViewV2.this.f5864b1 = i2;
                EditableListViewV2 editableListViewV22 = EditableListViewV2.this;
                editableListViewV22.f5865c1 = editableListViewV22.f5870h1.obtainMessage();
                EditableListViewV2.this.f5865c1.what = 2;
                EditableListViewV2.this.f5870h1.sendMessageAtFrontOfQueue(EditableListViewV2.this.f5865c1);
                EditableListViewV2.this.f5860X0 = false;
                return;
            }
            EditableListViewV2 editableListViewV23 = EditableListViewV2.this;
            editableListViewV23.f5865c1 = editableListViewV23.f5870h1.obtainMessage();
            EditableListViewV2.this.f5870h1.removeMessages(1);
            EditableListViewV2.this.f5860X0 = true;
            EditableListViewV2.this.f5865c1.what = 1;
            EditableListViewV2.this.f5861Y0 = i2;
            EditableListViewV2.this.f5870h1.sendMessageDelayed(EditableListViewV2.this.f5865c1, EditableListViewV2.f5848i1);
        }
    }

    final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f5873i;

        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (EditableListViewV2.this.f5868f1 == null) {
                    return;
                }
                if (EditableListViewV2.this.getBottom() - EditableListViewV2.this.f5868f1.getTop() < EditableListViewV2.this.f5868f1.getHeight()) {
                    c cVar = c.this;
                    EditableListViewV2.this.y0(cVar.f5873i);
                }
                EditableListViewV2.this.f5868f1 = null;
            }
        }

        c(int i2) {
            this.f5873i = i2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (EditableListViewV2.this.f5868f1 == null) {
                return;
            }
            EditableListViewV2.this.f5868f1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            EditableListViewV2.this.f5868f1.post(new a());
        }
    }

    final class d implements View.OnAttachStateChangeListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f5876i;

        d(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.f5876i = onGlobalLayoutListener;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            if (EditableListViewV2.this.f5868f1 != null) {
                EditableListViewV2.this.f5868f1.getViewTreeObserver().removeOnGlobalLayoutListener(this.f5876i);
            }
        }
    }

    public interface e {
        void a(boolean z4);

        void b(boolean z4);

        void c(boolean z4, float f4);
    }

    public interface f extends ActionMode.Callback {
        void a(j jVar);

        void b(View view, boolean z4, boolean z5);
    }

    class g implements f {

        /* renamed from: a, reason: collision with root package name */
        private f f5878a;

        /* renamed from: b, reason: collision with root package name */
        private EditableListViewV2 f5879b;

        public g(EditableListViewV2 editableListViewV2) {
            this.f5879b = editableListViewV2;
        }

        @Override // com.android.mmt.util.EditableListViewV2.f
        public final void a(j jVar) {
            this.f5878a.a(jVar);
        }

        @Override // com.android.mmt.util.EditableListViewV2.f
        public final void b(View view, boolean z4, boolean z5) {
            this.f5878a.b(view, z4, z5);
        }

        public final void d(f fVar) {
            this.f5878a = fVar;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f5878a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f5878a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            Integer num = EditableListViewV2.this.f5858V0;
            if (EditableListViewV2.this.f5855S0.f5881a) {
                return true;
            }
            EditableListViewV2 editableListViewV2 = EditableListViewV2.this;
            editableListViewV2.f5851O0 = editableListViewV2.isClickable();
            EditableListViewV2 editableListViewV22 = EditableListViewV2.this;
            editableListViewV22.f5852P0 = editableListViewV22.isLongClickable();
            EditableListViewV2.this.f5853Q0 = this.f5879b.O0();
            EditableListViewV2.this.f5870h1.post(new RunnableC0282n(this));
            Integer num2 = null;
            if (num != null) {
                Integer numValueOf = Integer.valueOf(EditableListViewV2.a1(EditableListViewV2.this, num.intValue()));
                if (numValueOf.intValue() != -1) {
                    num2 = numValueOf;
                }
            }
            h.p(EditableListViewV2.this.f5855S0, num2);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.f5878a.onDestroyActionMode(actionMode);
            EditableListViewV2.this.f5857U0 = null;
            if (EditableListViewV2.this.f5855S0.f5881a) {
                this.f5879b.U0(EditableListViewV2.this.f5853Q0);
                EditableListViewV2 editableListViewV2 = EditableListViewV2.this;
                editableListViewV2.setClickable(editableListViewV2.f5851O0);
                EditableListViewV2 editableListViewV22 = EditableListViewV2.this;
                editableListViewV22.setLongClickable(editableListViewV22.f5852P0);
                h.q(EditableListViewV2.this.f5855S0);
            }
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f5878a.onPrepareActionMode(actionMode, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class h extends RecyclerView.g implements j {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5881a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5882b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5883c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private HashSet<Long> f5884e;

        /* renamed from: f, reason: collision with root package name */
        private Integer f5885f;
        private LongSparseArray<Integer> g;

        /* renamed from: h, reason: collision with root package name */
        private RecyclerView.e f5886h;

        protected h() {
            t();
        }

        static void m(h hVar, RecyclerView.e eVar) {
            RecyclerView.e eVar2 = hVar.f5886h;
            if (eVar2 != null) {
                eVar2.F(hVar);
            }
            hVar.f5886h = eVar;
            if (eVar != null) {
                eVar.D(hVar);
            }
            hVar.f5884e.clear();
            hVar.g.clear();
            hVar.d = true;
            if (hVar.f5881a) {
                hVar.w(null);
            }
        }

        static boolean n(h hVar) {
            return hVar.f5886h != null;
        }

        static Boolean o(h hVar, View view, int i2) {
            Object obj;
            if (!hVar.f5881a || (obj = hVar.f5886h) == null) {
                return null;
            }
            boolean z4 = (!(obj instanceof k) || ((k) obj).c(i2)) && hVar.v(i2);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
            if (checkBox != null && checkBox.isEnabled()) {
                checkBox.setChecked(z4);
            }
            if (EditableListViewV2.this.f5856T0 != null) {
                EditableListViewV2.this.f5856T0.b(view, z4, false);
            }
            hVar.w(Integer.valueOf(i2));
            return Boolean.valueOf(z4);
        }

        static void p(h hVar, Integer num) {
            if (hVar.f5881a || hVar.f5886h == null || EditableListViewV2.this.f5856T0 == null) {
                return;
            }
            hVar.f5881a = true;
            hVar.f5884e.clear();
            hVar.f5885f = num;
            if (num != null) {
                hVar.v(num.intValue());
                EditableListViewV2.this.f5856T0.a(hVar);
            }
            hVar.f5883c = true;
            hVar.f5882b = true;
            hVar.f5886h.n();
            hVar.f5882b = false;
        }

        static void q(h hVar) {
            if (!hVar.f5881a || hVar.f5886h == null || EditableListViewV2.this.f5856T0 == null) {
                return;
            }
            hVar.f5881a = false;
            hVar.f5884e.clear();
            hVar.f5883c = true;
            hVar.f5882b = true;
            hVar.f5886h.n();
            hVar.f5882b = false;
        }

        private void s() {
            if (this.d) {
                HashSet<Long> hashSet = new HashSet<>();
                this.g.clear();
                for (int i2 = 0; i2 < this.f5886h.j(); i2++) {
                    Long lValueOf = Long.valueOf(u(i2));
                    if (this.f5884e.contains(lValueOf)) {
                        hashSet.add(lValueOf);
                    }
                    this.g.put(lValueOf.longValue(), Integer.valueOf(i2));
                }
                this.f5884e = hashSet;
                this.d = false;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private long u(int i2) {
            RecyclerView.e eVar = this.f5886h;
            return eVar instanceof i ? ((i) eVar).h(i2) : eVar.k(i2);
        }

        private boolean v(int i2) {
            long jU = u(i2);
            if (this.f5884e.contains(Long.valueOf(jU))) {
                this.f5884e.remove(Long.valueOf(jU));
                return false;
            }
            this.f5884e.add(Long.valueOf(jU));
            return true;
        }

        private void w(Integer num) {
            this.f5885f = num;
            if (EditableListViewV2.this.f5856T0 != null) {
                EditableListViewV2.this.f5856T0.a(this);
            }
        }

        @Override // com.android.mmt.util.EditableListViewV2.j
        public final HashSet<Long> a() {
            if (!this.f5881a || this.f5886h == null) {
                return new HashSet<>();
            }
            s();
            return new HashSet<>(this.f5884e);
        }

        @Override // com.android.mmt.util.EditableListViewV2.j
        public final int b() {
            if (!this.f5881a || this.f5886h == null) {
                return 0;
            }
            s();
            return this.f5884e.size();
        }

        @Override // com.android.mmt.util.EditableListViewV2.j
        public final void c() {
            Object obj;
            if (!this.f5881a || (obj = this.f5886h) == null) {
                return;
            }
            if (obj instanceof k) {
                k kVar = (k) obj;
                int iD = kVar.d();
                int i2 = 0;
                for (int i4 = 0; i4 < this.f5886h.j(); i4++) {
                    if (i2 == iD) {
                        this.f5884e.add(Long.valueOf(u(i4)));
                    } else if (kVar.c(i4)) {
                        this.f5884e.add(Long.valueOf(u(i4)));
                    } else {
                        i2++;
                    }
                }
            } else {
                for (int i5 = 0; i5 < this.f5886h.j(); i5++) {
                    this.f5884e.add(Long.valueOf(u(i5)));
                }
            }
            for (int i6 = 0; i6 < EditableListViewV2.this.getChildCount(); i6++) {
                View childAt = EditableListViewV2.this.getChildAt(i6);
                CheckBox checkBox = (CheckBox) childAt.findViewById(R.id.checkbox);
                if (checkBox != null && checkBox.isEnabled()) {
                    checkBox.setChecked(true);
                }
                if (EditableListViewV2.this.f5856T0 != null) {
                    EditableListViewV2.this.f5856T0.b(childAt, true, true);
                }
            }
            w(null);
        }

        @Override // com.android.mmt.util.EditableListViewV2.j
        public final SortedSet<Integer> d() {
            TreeSet treeSet = new TreeSet();
            if (this.f5881a && this.f5886h != null) {
                s();
                Iterator<Long> it = this.f5884e.iterator();
                while (it.hasNext()) {
                    treeSet.add(this.g.get(it.next().longValue()));
                }
            }
            return treeSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.mmt.util.EditableListViewV2.j
        public final boolean e() {
            if (!this.f5881a || this.f5886h == null) {
                return false;
            }
            s();
            RecyclerView.e eVar = this.f5886h;
            if (!(eVar instanceof k)) {
                return eVar.j() == this.f5884e.size();
            }
            k kVar = (k) eVar;
            int iD = kVar.d();
            int i2 = 0;
            for (int i4 = 0; i4 < this.f5886h.j(); i4++) {
                if (i2 == iD) {
                    if (!this.f5884e.contains(Long.valueOf(u(i4)))) {
                        return false;
                    }
                } else if (kVar.c(i4)) {
                    if (!this.f5884e.contains(Long.valueOf(u(i4)))) {
                        return false;
                    }
                } else {
                    i2++;
                }
            }
            return this.f5884e.size() > 0;
        }

        @Override // com.android.mmt.util.EditableListViewV2.j
        public final void f() {
            if (!this.f5881a || this.f5886h == null) {
                return;
            }
            this.f5884e.clear();
            for (int i2 = 0; i2 < EditableListViewV2.this.getChildCount(); i2++) {
                View childAt = EditableListViewV2.this.getChildAt(i2);
                CheckBox checkBox = (CheckBox) childAt.findViewById(R.id.checkbox);
                if (checkBox != null && checkBox.isEnabled()) {
                    checkBox.setChecked(false);
                }
                if (EditableListViewV2.this.f5856T0 != null) {
                    EditableListViewV2.this.f5856T0.b(childAt, false, true);
                }
            }
            w(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void g() {
            EditableListViewV2 editableListViewV2 = EditableListViewV2.this;
            editableListViewV2.f5850N0 = editableListViewV2.Q0() > EditableListViewV2.this.f5866d1;
            EditableListViewV2 editableListViewV22 = EditableListViewV2.this;
            editableListViewV22.f5866d1 = editableListViewV22.Q0();
            if (!this.f5883c) {
                this.d = true;
                if (this.f5881a && this.f5885f != null) {
                    w(null);
                }
            }
            this.f5883c = false;
        }

        public final boolean r(int i2) {
            Object obj = this.f5886h;
            return !(obj instanceof k) || ((k) obj).c(i2);
        }

        protected final void t() {
            this.f5883c = false;
            this.f5881a = false;
            this.d = true;
            HashSet<Long> hashSet = this.f5884e;
            if (hashSet == null) {
                this.f5884e = new HashSet<>();
            } else {
                hashSet.clear();
            }
            this.f5885f = null;
            LongSparseArray<Integer> longSparseArray = this.g;
            if (longSparseArray == null) {
                this.g = new LongSparseArray<>();
            } else {
                longSparseArray.clear();
            }
        }
    }

    public interface i {
        long h(int i2);
    }

    public interface j {
        HashSet<Long> a();

        int b();

        void c();

        SortedSet<Integer> d();

        boolean e();

        void f();
    }

    public interface k {
        boolean c(int i2);

        int d();
    }

    public interface l {
        void a(int i2);

        void b(int i2);
    }

    public EditableListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5850N0 = true;
        this.f5859W0 = false;
        this.f5860X0 = false;
        this.f5861Y0 = -1;
        this.f5862Z0 = null;
        this.f5863a1 = null;
        this.f5864b1 = -1;
        this.f5865c1 = null;
        this.f5866d1 = 0;
        this.f5867e1 = -1;
        this.f5868f1 = null;
        this.f5869g1 = false;
        this.f5870h1 = new a();
    }

    static int a1(EditableListViewV2 editableListViewV2, int i2) {
        Objects.requireNonNull(editableListViewV2);
        if (i2 < 0) {
            return i2;
        }
        if (editableListViewV2.R0(i2) || editableListViewV2.S0(i2)) {
            return -1;
        }
        return i2 - editableListViewV2.N0();
    }

    public final void C1() {
        Handler handler = this.f5870h1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void D1(int i2) {
        if (this.f5856T0 == null || this.f5855S0.f5881a) {
            return;
        }
        this.f5858V0 = Integer.valueOf(i2);
        this.f5857U0 = startActionMode(this.f5856T0);
        View view = this.f5868f1;
        if (view != null) {
            c cVar = new c(i2);
            view.addOnAttachStateChangeListener(new d(cVar));
            this.f5868f1.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
        }
    }

    public final void E1() {
        if (this.f5856T0 == null || !this.f5855S0.f5881a) {
            return;
        }
        this.f5858V0 = null;
        this.f5857U0.finish();
    }

    public final j F1() {
        if (this.f5856T0 != null) {
            return this.f5855S0;
        }
        return null;
    }

    public final int G1() {
        return this.f5867e1;
    }

    public final boolean H1() {
        if (this.f5856T0 != null) {
            return this.f5855S0.f5882b;
        }
        return false;
    }

    public final boolean I1() {
        if (this.f5856T0 != null) {
            return this.f5855S0.f5881a;
        }
        return false;
    }

    public final void J1(boolean z4) {
        this.f5867e1 = -1;
        if (z4) {
            this.f5868f1 = null;
        }
    }

    public final void K1(f fVar) {
        if (this.f5856T0 == null) {
            this.f5856T0 = new g(this);
        }
        this.f5856T0.d(fVar);
        h hVar = this.f5855S0;
        if (hVar == null) {
            this.f5855S0 = new h();
        } else {
            hVar.t();
        }
        V0(new C0281m(this));
        U0(new O0.d() { // from class: com.android.mmt.util.l
            @Override // com.android.mmt.ui.O0.d
            public final void a(RecyclerView recyclerView, View view, int i2) {
                int i4 = EditableListViewV2.f5849j1;
            }
        });
        if (h.n(this.f5855S0) || P0() == null) {
            return;
        }
        h.m(this.f5855S0, P0());
    }

    public final void L1(boolean z4) {
        this.f5859W0 = z4;
    }

    public final void M1(l lVar) {
        this.f5854R0 = lVar;
        U0(new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int iL0;
        if (this.f5859W0 && (iL0 = L0()) > 0) {
            n0(iL0 - 1);
        }
        super.onLayout(z4, i2, i4, i5, i6);
    }

    @Override // com.android.mmt.ui.O0, androidx.recyclerview.widget.RecyclerView
    public final void p0(RecyclerView.e eVar) {
        super.p0(eVar);
        h hVar = this.f5855S0;
        if (hVar != null) {
            h.m(hVar, eVar);
        }
    }

    @Override // android.view.View
    public final void setOnCreateContextMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        super.setOnCreateContextMenuListener(onCreateContextMenuListener);
        this.f5869g1 = onCreateContextMenuListener != null;
    }
}
