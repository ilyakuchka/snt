package J;

import F.b;
import F.c;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends androidx.core.view.a {

    /* renamed from: k, reason: collision with root package name */
    private static final Rect f268k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: e, reason: collision with root package name */
    private final AccessibilityManager f272e;

    /* renamed from: f, reason: collision with root package name */
    private final View f273f;
    private C0012a g;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f269a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private final Rect f270b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    private final Rect f271c = new Rect();
    private final int[] d = new int[2];

    /* renamed from: h, reason: collision with root package name */
    int f274h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    int f275i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private int f276j = Integer.MIN_VALUE;

    /* renamed from: J.a$a, reason: collision with other inner class name */
    private class C0012a extends c {
        C0012a() {
        }

        @Override // F.c
        public final b a(int i2) {
            return b.u(a.this.g(i2));
        }

        @Override // F.c
        public final b b(int i2) {
            int i4 = i2 == 2 ? a.this.f274h : a.this.f275i;
            if (i4 == Integer.MIN_VALUE) {
                return null;
            }
            return b.u(a.this.g(i4));
        }

        @Override // F.c
        public final boolean d(int i2, int i4, Bundle bundle) {
            return a.this.l(i2, i4, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f273f = view;
        this.f272e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        int i2 = o.d;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    private boolean a(int i2) {
        if (this.f274h != i2) {
            return false;
        }
        this.f274h = Integer.MIN_VALUE;
        this.f273f.invalidate();
        m(i2, 65536);
        return true;
    }

    private AccessibilityEvent b(int i2, int i4) {
        if (i2 == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i4);
            this.f273f.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i4);
        b bVarG = g(i2);
        accessibilityEventObtain2.getText().add(bVarG.n());
        accessibilityEventObtain2.setContentDescription(bVarG.l());
        accessibilityEventObtain2.setScrollable(bVarG.s());
        accessibilityEventObtain2.setPassword(bVarG.r());
        accessibilityEventObtain2.setEnabled(bVarG.p());
        accessibilityEventObtain2.setChecked(bVarG.o());
        i(accessibilityEventObtain2);
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(bVarG.j());
        accessibilityEventObtain2.setSource(this.f273f, i2);
        accessibilityEventObtain2.setPackageName(this.f273f.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    public final boolean c(MotionEvent motionEvent) {
        int i2;
        if (!this.f272e.isEnabled() || !this.f272e.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || (i2 = this.f276j) == Integer.MIN_VALUE) {
                return false;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f276j = Integer.MIN_VALUE;
                m(Integer.MIN_VALUE, 128);
                m(i2, 256);
            }
            return true;
        }
        float x2 = motionEvent.getX();
        motionEvent.getY();
        int iD = d(x2);
        int i4 = this.f276j;
        if (i4 != iD) {
            this.f276j = iD;
            m(iD, 128);
            m(i4, 256);
        }
        return iD != Integer.MIN_VALUE;
    }

    protected abstract int d(float f4);

    protected abstract void e(List<Integer> list);

    public final void f() {
        ViewParent parent;
        if (!this.f272e.isEnabled() || (parent = this.f273f.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventB = b(-1, 2048);
        accessibilityEventB.setContentChangeTypes(1);
        parent.requestSendAccessibilityEvent(this.f273f, accessibilityEventB);
    }

    final b g(int i2) {
        int i4 = 0;
        if (i2 == -1) {
            b bVarV = b.v(this.f273f);
            View view = this.f273f;
            int i5 = o.d;
            view.onInitializeAccessibilityNodeInfo(bVarV.Z());
            ArrayList arrayList = new ArrayList();
            e(arrayList);
            if (bVarV.i() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            while (i4 < size) {
                bVarV.c(this.f273f, ((Integer) arrayList.get(i4)).intValue());
                i4++;
            }
            return bVarV;
        }
        b bVarT = b.t();
        bVarT.J();
        bVarT.K();
        bVarT.E("android.view.View");
        Rect rect = f268k;
        bVarT.A(rect);
        bVarT.B(rect);
        bVarT.P(this.f273f);
        k(bVarT);
        if (bVarT.n() == null && bVarT.l() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        bVarT.g(this.f270b);
        if (this.f270b.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iF = bVarT.f();
        if ((iF & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iF & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        bVarT.N(this.f273f.getContext().getPackageName());
        bVarT.W(this.f273f, i2);
        if (this.f274h == i2) {
            bVarT.z(true);
            bVarT.a(128);
        } else {
            bVarT.z(false);
            bVarT.a(64);
        }
        boolean z4 = this.f275i == i2;
        if (z4) {
            bVarT.a(2);
        } else if (bVarT.q()) {
            bVarT.a(1);
        }
        bVarT.L(z4);
        this.f273f.getLocationOnScreen(this.d);
        bVarT.h(this.f269a);
        if (this.f269a.equals(rect)) {
            bVarT.g(this.f269a);
            if (bVarT.f114b != -1) {
                b bVarT2 = b.t();
                for (int i6 = bVarT.f114b; i6 != -1; i6 = bVarT2.f114b) {
                    bVarT2.Q(this.f273f);
                    bVarT2.A(f268k);
                    k(bVarT2);
                    bVarT2.g(this.f270b);
                    Rect rect2 = this.f269a;
                    Rect rect3 = this.f270b;
                    rect2.offset(rect3.left, rect3.top);
                }
                bVarT2.x();
            }
            this.f269a.offset(this.d[0] - this.f273f.getScrollX(), this.d[1] - this.f273f.getScrollY());
        }
        if (this.f273f.getLocalVisibleRect(this.f271c)) {
            this.f271c.offset(this.d[0] - this.f273f.getScrollX(), this.d[1] - this.f273f.getScrollY());
            if (this.f269a.intersect(this.f271c)) {
                bVarT.B(this.f269a);
                Rect rect4 = this.f269a;
                if (rect4 != null && !rect4.isEmpty() && this.f273f.getWindowVisibility() == 0) {
                    Object parent = this.f273f.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            i4 = 1;
                        }
                    }
                }
                if (i4 != 0) {
                    bVarT.Y();
                }
            }
        }
        return bVarT;
    }

    @Override // androidx.core.view.a
    public final c getAccessibilityNodeProvider(View view) {
        if (this.g == null) {
            this.g = new C0012a();
        }
        return this.g;
    }

    protected abstract boolean h(int i2, int i4);

    protected abstract void i(AccessibilityEvent accessibilityEvent);

    protected abstract void j(b bVar);

    protected abstract void k(b bVar);

    final boolean l(int i2, int i4, Bundle bundle) {
        int i5;
        int i6;
        if (i2 == -1) {
            View view = this.f273f;
            int i7 = o.d;
            return view.performAccessibilityAction(i4, bundle);
        }
        boolean z4 = false;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 64) {
                    return i4 != 128 ? h(i2, i4) : a(i2);
                }
                if (this.f272e.isEnabled() && this.f272e.isTouchExplorationEnabled() && (i6 = this.f274h) != i2) {
                    if (i6 != Integer.MIN_VALUE) {
                        a(i6);
                    }
                    this.f274h = i2;
                    this.f273f.invalidate();
                    m(i2, 32768);
                    z4 = true;
                }
            } else if (this.f275i == i2) {
                this.f275i = Integer.MIN_VALUE;
                m(i2, 8);
                z4 = true;
            }
        } else if ((this.f273f.isFocused() || this.f273f.requestFocus()) && (i5 = this.f275i) != i2) {
            if (i5 != Integer.MIN_VALUE) {
                this.f275i = Integer.MIN_VALUE;
                m(i5, 8);
            }
            this.f275i = i2;
            m(i2, 8);
            z4 = true;
        }
        return z4;
    }

    public final boolean m(int i2, int i4) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f272e.isEnabled() || (parent = this.f273f.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f273f, b(i2, i4));
    }

    @Override // androidx.core.view.a
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // androidx.core.view.a
    public final void onInitializeAccessibilityNodeInfo(View view, b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        j(bVar);
    }
}
