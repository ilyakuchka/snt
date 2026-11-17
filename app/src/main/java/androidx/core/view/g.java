package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private ViewParent f3304a;

    /* renamed from: b, reason: collision with root package name */
    private ViewParent f3305b;

    /* renamed from: c, reason: collision with root package name */
    private final View f3306c;
    private boolean d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f3307e;

    public g(View view) {
        this.f3306c = view;
    }

    private boolean g(int i2, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        ViewParent viewParentH;
        int i8;
        int i9;
        int[] iArr3;
        if (!this.d || (viewParentH = h(i7)) == null) {
            return false;
        }
        if (i2 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f3306c.getLocationInWindow(iArr);
            i8 = iArr[0];
            i9 = iArr[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr2 == null) {
            if (this.f3307e == null) {
                this.f3307e = new int[2];
            }
            int[] iArr4 = this.f3307e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        View view = this.f3306c;
        if (viewParentH instanceof i) {
            ((i) viewParentH).o(view, i2, i4, i5, i6, i7, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i5;
            iArr3[1] = iArr3[1] + i6;
            if (viewParentH instanceof h) {
                ((h) viewParentH).p(view, i2, i4, i5, i6, i7);
            } else if (i7 == 0) {
                try {
                    viewParentH.onNestedScroll(view, i2, i4, i5, i6);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedScroll", e2);
                }
            }
        }
        if (iArr != null) {
            this.f3306c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i8;
            iArr[1] = iArr[1] - i9;
        }
        return true;
    }

    private ViewParent h(int i2) {
        if (i2 == 0) {
            return this.f3304a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f3305b;
    }

    public final boolean a(float f4, float f5, boolean z4) {
        ViewParent viewParentH;
        if (!this.d || (viewParentH = h(0)) == null) {
            return false;
        }
        try {
            return viewParentH.onNestedFling(this.f3306c, f4, f5, z4);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedFling", e2);
            return false;
        }
    }

    public final boolean b(float f4, float f5) {
        ViewParent viewParentH;
        if (!this.d || (viewParentH = h(0)) == null) {
            return false;
        }
        try {
            return viewParentH.onNestedPreFling(this.f3306c, f4, f5);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedPreFling", e2);
            return false;
        }
    }

    public final boolean c(int i2, int i4, int[] iArr, int[] iArr2, int i5) {
        ViewParent viewParentH;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.d || (viewParentH = h(i5)) == null) {
            return false;
        }
        if (i2 == 0 && i4 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f3306c.getLocationInWindow(iArr2);
            i6 = iArr2[0];
            i7 = iArr2[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr == null) {
            if (this.f3307e == null) {
                this.f3307e = new int[2];
            }
            iArr3 = this.f3307e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        View view = this.f3306c;
        if (viewParentH instanceof h) {
            ((h) viewParentH).l(view, i2, i4, iArr3, i5);
        } else if (i5 == 0) {
            try {
                viewParentH.onNestedPreScroll(view, i2, i4, iArr3);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedPreScroll", e2);
            }
        }
        if (iArr2 != null) {
            this.f3306c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i6;
            iArr2[1] = iArr2[1] - i7;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final void d(int i2, int i4, int[] iArr, int i5, int[] iArr2) {
        g(0, i2, 0, i4, iArr, i5, iArr2);
    }

    public final boolean e(int i2, int i4, int i5, int i6, int[] iArr) {
        return g(i2, i4, i5, i6, iArr, 0, null);
    }

    public final boolean f(int i2, int i4, int i5, int i6, int[] iArr, int i7) {
        return g(i2, i4, i5, i6, iArr, i7, null);
    }

    public final boolean i(int i2) {
        return h(i2) != null;
    }

    public final boolean j() {
        return this.d;
    }

    public final void k(boolean z4) {
        if (this.d) {
            View view = this.f3306c;
            int i2 = o.d;
            view.stopNestedScroll();
        }
        this.d = z4;
    }

    public final boolean l(int i2, int i4) {
        boolean zOnStartNestedScroll;
        if (i(i4)) {
            return true;
        }
        if (this.d) {
            View view = this.f3306c;
            for (ViewParent parent = this.f3306c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.f3306c;
                boolean z4 = parent instanceof h;
                if (z4) {
                    zOnStartNestedScroll = ((h) parent).q(view, view2, i2, i4);
                } else if (i4 == 0) {
                    try {
                        zOnStartNestedScroll = parent.onStartNestedScroll(view, view2, i2);
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e2);
                    }
                } else {
                    zOnStartNestedScroll = false;
                }
                if (zOnStartNestedScroll) {
                    if (i4 == 0) {
                        this.f3304a = parent;
                    } else if (i4 == 1) {
                        this.f3305b = parent;
                    }
                    View view3 = this.f3306c;
                    if (z4) {
                        ((h) parent).j(view, view3, i2, i4);
                    } else if (i4 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i2);
                        } catch (AbstractMethodError e4) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e4);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = parent;
                }
            }
        }
        return false;
    }

    public final void m(int i2) {
        ViewParent viewParentH = h(i2);
        if (viewParentH != null) {
            View view = this.f3306c;
            if (viewParentH instanceof h) {
                ((h) viewParentH).k(view, i2);
            } else if (i2 == 0) {
                try {
                    viewParentH.onStopNestedScroll(view);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onStopNestedScroll", e2);
                }
            }
            if (i2 == 0) {
                this.f3304a = null;
            } else {
                if (i2 != 1) {
                    return;
                }
                this.f3305b = null;
            }
        }
    }
}
