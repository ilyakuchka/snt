package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.a;
import com.android.mmt.R;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<View, t> f3313a;

    /* renamed from: b, reason: collision with root package name */
    private static final m f3314b;

    /* renamed from: c, reason: collision with root package name */
    private static b f3315c;
    public static final /* synthetic */ int d = 0;

    final class a implements m {
        a() {
        }

        @Override // androidx.core.view.m
        public final androidx.core.view.c a(androidx.core.view.c cVar) {
            return cVar;
        }
    }

    static class b implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: i, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f3316i = new WeakHashMap<>();

        b() {
        }

        final void a(View view) {
            this.f3316i.put(view, Boolean.valueOf(view.getVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
        }

        final void b(View view) {
            this.f3316i.remove(view);
            view.removeOnAttachStateChangeListener(this);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class c<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f3317a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<T> f3318b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3319c;
        private final int d;

        c(int i2, Class<T> cls, int i4, int i5) {
            this.f3317a = i2;
            this.f3318b = cls;
            this.d = i4;
            this.f3319c = i5;
        }

        final boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        abstract T b(View view);

        abstract void c(View view, T t2);

        final T d(View view) {
            if (Build.VERSION.SDK_INT >= this.f3319c) {
                return b(view);
            }
            T t2 = (T) view.getTag(this.f3317a);
            if (this.f3318b.isInstance(t2)) {
                return t2;
            }
            return null;
        }

        final void e(View view, T t2) {
            if (Build.VERSION.SDK_INT >= this.f3319c) {
                c(view, t2);
                return;
            }
            if (f(d(view), t2)) {
                int i2 = o.d;
                View.AccessibilityDelegate accessibilityDelegate = view.getAccessibilityDelegate();
                androidx.core.view.a aVar = accessibilityDelegate == null ? null : accessibilityDelegate instanceof a.C0062a ? ((a.C0062a) accessibilityDelegate).f3292a : new androidx.core.view.a(accessibilityDelegate);
                if (aVar == null) {
                    aVar = new androidx.core.view.a();
                }
                o.j(view, aVar);
                view.setTag(this.f3317a, t2);
                o.f(view, this.d);
            }
        }

        abstract boolean f(T t2, T t4);
    }

    private static class d {

        final class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f3320a;

            a(View view, k kVar) {
                this.f3320a = kVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return this.f3320a.a(view, w.o(windowInsets, view)).n();
            }
        }

        static w a(View view, w wVar, Rect rect) {
            WindowInsets windowInsetsN = wVar.n();
            if (windowInsetsN != null) {
                return w.o(view.computeSystemWindowInsets(windowInsetsN, rect), view);
            }
            rect.setEmpty();
            return wVar;
        }

        static void b(View view, k kVar) {
            if (kVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e {
        public static w a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            w wVarO = w.o(rootWindowInsets, null);
            wVarO.m(wVarO);
            wVarO.d(view.getRootView());
            return wVarO;
        }
    }

    private static class f {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i4) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i4);
        }
    }

    static {
        new AtomicInteger(1);
        f3313a = null;
        f3314b = new a();
        f3315c = new b();
    }

    public static t a(View view) {
        if (f3313a == null) {
            f3313a = new WeakHashMap<>();
        }
        t tVar = f3313a.get(view);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(view);
        f3313a.put(view, tVar2);
        return tVar2;
    }

    public static w b(View view, w wVar, Rect rect) {
        return d.a(view, wVar, rect);
    }

    public static w c(View view, w wVar) {
        WindowInsets windowInsetsN = wVar.n();
        if (windowInsetsN != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsN);
            if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsN)) {
                return w.o(windowInsetsDispatchApplyWindowInsets, view);
            }
        }
        return wVar;
    }

    public static CharSequence d(View view) {
        return new q(CharSequence.class).d(view);
    }

    public static w e(View view) {
        return e.a(view);
    }

    static void f(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z4 = d(view) != null && view.getVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z4) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z4 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z4) {
                    accessibilityEventObtain.getText().add(d(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        }
                        if (((View) parent).getImportantForAccessibility() == 4) {
                            view.setImportantForAccessibility(2);
                            break;
                        }
                        parent = parent.getParent();
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(d(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static w g(View view, w wVar) {
        WindowInsets windowInsetsN = wVar.n();
        if (windowInsetsN != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsN);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsN)) {
                return w.o(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static androidx.core.view.c h(View view, androidx.core.view.c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        l lVar = (l) view.getTag(R.id.tag_on_receive_content_listener);
        if (lVar == null) {
            return (view instanceof m ? (m) view : f3314b).a(cVar);
        }
        androidx.core.view.c cVarA = lVar.a(view, cVar);
        if (cVarA == null) {
            return null;
        }
        return (view instanceof m ? (m) view : f3314b).a(cVarA);
    }

    public static void i(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2) {
        f.a(view, context, iArr, attributeSet, typedArray, i2, 0);
    }

    public static void j(View view, androidx.core.view.a aVar) {
        if (aVar == null && (view.getAccessibilityDelegate() instanceof a.C0062a)) {
            aVar = new androidx.core.view.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
    }

    public static void k(View view, CharSequence charSequence) {
        new q(CharSequence.class).e(view, charSequence);
        if (charSequence != null) {
            f3315c.a(view);
        } else {
            f3315c.b(view);
        }
    }

    public static void l(View view, k kVar) {
        d.b(view, kVar);
    }

    public static void m(View view, CharSequence charSequence) {
        new r(CharSequence.class).e(view, charSequence);
    }
}
