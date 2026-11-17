package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.l;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2601a;

    /* renamed from: b, reason: collision with root package name */
    private final f f2602b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f2603c;
    private final int d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2604e;

    /* renamed from: f, reason: collision with root package name */
    private View f2605f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2606h;

    /* renamed from: i, reason: collision with root package name */
    private l.a f2607i;

    /* renamed from: j, reason: collision with root package name */
    private j f2608j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f2609k;
    private int g = 8388611;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f2610l = new a();

    final class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            k.this.d();
        }
    }

    public k(Context context, f fVar, View view, boolean z4, int i2, int i4) {
        this.f2601a = context;
        this.f2602b = fVar;
        this.f2605f = view;
        this.f2603c = z4;
        this.d = i2;
        this.f2604e = i4;
    }

    private void k(int i2, int i4, boolean z4, boolean z5) {
        j jVarB = b();
        jVarB.r(z5);
        if (z4) {
            int i5 = this.g;
            View view = this.f2605f;
            int i6 = androidx.core.view.o.d;
            if ((Gravity.getAbsoluteGravity(i5, view.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f2605f.getWidth();
            }
            jVarB.p(i2);
            jVarB.s(i4);
            int i7 = (int) ((this.f2601a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            jVarB.m(new Rect(i2 - i7, i4 - i7, i2 + i7, i4 + i7));
        }
        jVarB.f();
    }

    public final void a() {
        if (c()) {
            this.f2608j.dismiss();
        }
    }

    public final j b() {
        if (this.f2608j == null) {
            Display defaultDisplay = ((WindowManager) this.f2601a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            j cVar = Math.min(point.x, point.y) >= this.f2601a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new c(this.f2601a, this.f2605f, this.d, this.f2604e, this.f2603c) : new o(this.f2601a, this.f2602b, this.f2605f, this.d, this.f2604e, this.f2603c);
            cVar.i(this.f2602b);
            cVar.q(this.f2610l);
            cVar.l(this.f2605f);
            cVar.d(this.f2607i);
            cVar.n(this.f2606h);
            cVar.o(this.g);
            this.f2608j = cVar;
        }
        return this.f2608j;
    }

    public final boolean c() {
        j jVar = this.f2608j;
        return jVar != null && jVar.isShowing();
    }

    protected void d() {
        this.f2608j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f2609k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void e(View view) {
        this.f2605f = view;
    }

    public final void f(boolean z4) {
        this.f2606h = z4;
        j jVar = this.f2608j;
        if (jVar != null) {
            jVar.n(z4);
        }
    }

    public final void g() {
        this.g = 8388613;
    }

    public final void h(PopupWindow.OnDismissListener onDismissListener) {
        this.f2609k = onDismissListener;
    }

    public final void i(l.a aVar) {
        this.f2607i = aVar;
        j jVar = this.f2608j;
        if (jVar != null) {
            jVar.d(aVar);
        }
    }

    public final void j() {
        boolean z4;
        if (c()) {
            z4 = true;
        } else {
            z4 = false;
            if (this.f2605f != null) {
                k(0, 0, false, false);
                z4 = true;
            }
        }
        if (!z4) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final boolean l() {
        if (c()) {
            return true;
        }
        if (this.f2605f == null) {
            return false;
        }
        k(0, 0, false, false);
        return true;
    }

    public final boolean m(int i2, int i4) {
        if (c()) {
            return true;
        }
        if (this.f2605f == null) {
            return false;
        }
        k(i2, i4, true, true);
        return true;
    }
}
