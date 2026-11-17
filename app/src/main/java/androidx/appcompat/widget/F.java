package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class F implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name */
    private final float f2736i;

    /* renamed from: j, reason: collision with root package name */
    private final int f2737j;

    /* renamed from: k, reason: collision with root package name */
    private final int f2738k;

    /* renamed from: l, reason: collision with root package name */
    final View f2739l;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f2740m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f2741n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2742o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private final int[] f2743q = new int[2];

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent parent = F.this.f2739l.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            F.this.e();
        }
    }

    public F(View view) {
        this.f2739l = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2736i = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f2737j = tapTimeout;
        this.f2738k = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    private void a() {
        Runnable runnable = this.f2741n;
        if (runnable != null) {
            this.f2739l.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f2740m;
        if (runnable2 != null) {
            this.f2739l.removeCallbacks(runnable2);
        }
    }

    public abstract m.b b();

    protected abstract boolean c();

    protected boolean d() {
        m.b bVarB = b();
        if (bVarB == null || !bVarB.isShowing()) {
            return true;
        }
        bVarB.dismiss();
        return true;
    }

    final void e() {
        a();
        View view = this.f2739l;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f2742o = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0112  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        boolean z4;
        boolean z5;
        boolean z6;
        D d;
        boolean z7 = this.f2742o;
        if (z7) {
            View view2 = this.f2739l;
            m.b bVarB = b();
            if (bVarB == null || !bVarB.isShowing() || (d = (D) bVarB.h()) == null || !d.isShown()) {
                z6 = false;
                z5 = (z6 && d()) ? false : true;
            } else {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                view2.getLocationOnScreen(this.f2743q);
                motionEventObtainNoHistory.offsetLocation(r6[0], r6[1]);
                d.getLocationOnScreen(this.f2743q);
                motionEventObtainNoHistory.offsetLocation(-r3[0], -r3[1]);
                boolean zB = d.b(motionEventObtainNoHistory, this.p);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z8 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (zB && z8) {
                    z6 = true;
                }
                if (z6) {
                }
            }
        } else {
            View view3 = this.f2739l;
            if (view3.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0) {
                    this.p = motionEvent.getPointerId(0);
                    if (this.f2740m == null) {
                        this.f2740m = new a();
                    }
                    view3.postDelayed(this.f2740m, this.f2737j);
                    if (this.f2741n == null) {
                        this.f2741n = new b();
                    }
                    view3.postDelayed(this.f2741n, this.f2738k);
                } else if (actionMasked2 == 1) {
                    a();
                } else if (actionMasked2 == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.p);
                    if (iFindPointerIndex >= 0) {
                        float x2 = motionEvent.getX(iFindPointerIndex);
                        float y2 = motionEvent.getY(iFindPointerIndex);
                        float f4 = this.f2736i;
                        float f5 = -f4;
                        if (!(x2 >= f5 && y2 >= f5 && x2 < ((float) (view3.getRight() - view3.getLeft())) + f4 && y2 < ((float) (view3.getBottom() - view3.getTop())) + f4)) {
                            a();
                            view3.getParent().requestDisallowInterceptTouchEvent(true);
                            z4 = true;
                        }
                        z5 = z4 && c();
                        if (z5) {
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                            this.f2739l.onTouchEvent(motionEventObtain);
                            motionEventObtain.recycle();
                        }
                    }
                } else if (actionMasked2 == 3) {
                }
                z4 = false;
                if (z4) {
                    if (z5) {
                    }
                }
            } else {
                z4 = false;
                if (z4) {
                }
            }
        }
        this.f2742o = z5;
        return z5 || z7;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f2742o = false;
        this.p = -1;
        Runnable runnable = this.f2740m;
        if (runnable != null) {
            this.f2739l.removeCallbacks(runnable);
        }
    }
}
