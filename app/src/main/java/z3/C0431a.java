package z3;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.android.mmt.R;

/* renamed from: z3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0431a {

    /* renamed from: a, reason: collision with root package name */
    private static final TypedValue f8167a = new TypedValue();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f8168b = new ThreadLocal<>();

    private static TypedValue a(Context context) {
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            return f8167a;
        }
        ThreadLocal<TypedValue> threadLocal = f8168b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static int b(Context context, int i2) {
        TypedValue typedValueA = a(context);
        if (context.getTheme().resolveAttribute(i2, typedValueA, true)) {
            return typedValueA.resourceId;
        }
        return -1;
    }

    public static boolean c(Context context, int i2, boolean z4) {
        TypedValue typedValueA = a(context);
        return context.getTheme().resolveAttribute(i2, typedValueA, true) ? typedValueA.type == 18 && typedValueA.data != 0 : z4;
    }

    public static int d(Context context, int i2) {
        return context.getResources().getDimensionPixelSize(b(context, i2));
    }

    public static Drawable e(Context context, int i2) {
        TypedValue typedValueA = a(context);
        if (!context.getTheme().resolveAttribute(i2, typedValueA, true)) {
            return null;
        }
        if (typedValueA.resourceId > 0) {
            return context.getResources().getDrawable(typedValueA.resourceId, context.getTheme());
        }
        int i4 = typedValueA.type;
        if (i4 < 28 || i4 > 31) {
            return null;
        }
        return new ColorDrawable(typedValueA.data);
    }

    public static float f(Context context) {
        TypedValue typedValueA = a(context);
        if (context.getTheme().resolveAttribute(R.attr.popupWindowShadowAlpha, typedValueA, true) && typedValueA.type == 4) {
            return typedValueA.data;
        }
        return 0.0f;
    }

    public static int g(Context context, int i2, int i4) {
        TypedValue typedValueA = a(context);
        return (context.getTheme().resolveAttribute(i2, typedValueA, true) && typedValueA.type == 16) ? typedValueA.data : i4;
    }

    public static TypedValue h(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }
}
