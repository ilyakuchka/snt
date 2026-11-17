package p1;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Deprecated
/* loaded from: classes.dex */
public abstract class g<T extends View, Z> extends p1.a<Z> {

    /* renamed from: i, reason: collision with root package name */
    protected final T f7580i;

    /* renamed from: j, reason: collision with root package name */
    private final a f7581j;

    static final class a {
        static Integer d;

        /* renamed from: a, reason: collision with root package name */
        private final View f7582a;

        /* renamed from: b, reason: collision with root package name */
        private final List<e> f7583b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private ViewTreeObserverOnPreDrawListenerC0132a f7584c;

        /* renamed from: p1.g$a$a, reason: collision with other inner class name */
        private static final class ViewTreeObserverOnPreDrawListenerC0132a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: i, reason: collision with root package name */
            private final WeakReference<a> f7585i;

            ViewTreeObserverOnPreDrawListenerC0132a(a aVar) {
                this.f7585i = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f7585i.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f7582a = view;
        }

        private int d(int i2, int i4, int i5) {
            int i6 = i4 - i5;
            if (i6 > 0) {
                return i6;
            }
            int i7 = i2 - i5;
            if (i7 > 0) {
                return i7;
            }
            if (this.f7582a.isLayoutRequested() || i4 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = this.f7582a.getContext();
            if (d == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Objects.requireNonNull(windowManager, "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                d = Integer.valueOf(Math.max(point.x, point.y));
            }
            return d.intValue();
        }

        private int e() {
            int paddingBottom = this.f7582a.getPaddingBottom() + this.f7582a.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.f7582a.getLayoutParams();
            return d(this.f7582a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        private int f() {
            int paddingRight = this.f7582a.getPaddingRight() + this.f7582a.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.f7582a.getLayoutParams();
            return d(this.f7582a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        private boolean g(int i2, int i4) {
            if (i2 > 0 || i2 == Integer.MIN_VALUE) {
                return i4 > 0 || i4 == Integer.MIN_VALUE;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<p1.e>] */
        final void a() {
            if (this.f7583b.isEmpty()) {
                return;
            }
            int iF = f();
            int iE = e();
            if (g(iF, iE)) {
                Iterator it = new ArrayList(this.f7583b).iterator();
                while (it.hasNext()) {
                    ((e) it.next()).e(iF, iE);
                }
                b();
            }
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<p1.e>] */
        final void b() {
            ViewTreeObserver viewTreeObserver = this.f7582a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f7584c);
            }
            this.f7584c = null;
            this.f7583b.clear();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<p1.e>] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList, java.util.List<p1.e>] */
        final void c(e eVar) {
            int iF = f();
            int iE = e();
            if (g(iF, iE)) {
                eVar.e(iF, iE);
                return;
            }
            if (!this.f7583b.contains(eVar)) {
                this.f7583b.add(eVar);
            }
            if (this.f7584c == null) {
                ViewTreeObserver viewTreeObserver = this.f7582a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0132a viewTreeObserverOnPreDrawListenerC0132a = new ViewTreeObserverOnPreDrawListenerC0132a(this);
                this.f7584c = viewTreeObserverOnPreDrawListenerC0132a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0132a);
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<p1.e>] */
        final void h(e eVar) {
            this.f7583b.remove(eVar);
        }
    }

    public g(T t2) {
        Objects.requireNonNull(t2, "Argument must not be null");
        this.f7580i = t2;
        this.f7581j = new a(t2);
    }

    @Override // p1.f
    public final void b(o1.b bVar) {
        this.f7580i.setTag(R.id.glide_custom_view_target_tag, bVar);
    }

    @Override // p1.f
    public final void f(e eVar) {
        this.f7581j.c(eVar);
    }

    @Override // p1.f
    public final void g(e eVar) {
        this.f7581j.h(eVar);
    }

    @Override // p1.f
    public final o1.b i() {
        Object tag = this.f7580i.getTag(R.id.glide_custom_view_target_tag);
        if (tag == null) {
            return null;
        }
        if (tag instanceof o1.b) {
            return (o1.b) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // p1.f
    public void j(Drawable drawable) {
        this.f7581j.b();
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Target for: ");
        sbD.append(this.f7580i);
        return sbD.toString();
    }
}
