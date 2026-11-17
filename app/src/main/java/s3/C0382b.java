package s3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.SparseArray;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

/* renamed from: s3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0382b {

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray<WeakReference<Object>> f7869a = new SparseArray<>();

    private static int a(Context context) {
        Context baseContext = context;
        Activity activity = null;
        while (activity == null && baseContext != null) {
            if (baseContext instanceof Activity) {
                activity = (Activity) baseContext;
            } else {
                baseContext = baseContext instanceof ContextWrapper ? ((ContextWrapper) baseContext).getBaseContext() : null;
            }
        }
        return activity != null ? activity.hashCode() : context.hashCode();
    }

    public static void b(Context context) {
        f7869a.remove(a(context));
    }

    public static void c(Context context, Object obj) {
        Object obj2;
        int iA = a(context);
        if (f7869a.get(iA) != null && (obj2 = f7869a.get(iA).get()) != null && obj2 != obj && (obj2 instanceof PopupWindow)) {
            PopupWindow popupWindow = (PopupWindow) obj2;
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
        }
        f7869a.put(iA, new WeakReference<>(obj));
    }
}
