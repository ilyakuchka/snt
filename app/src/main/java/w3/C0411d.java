package w3;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.WindowManager;

/* renamed from: w3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0411d {
    public static void a(Context context, Point point) {
        Rect bounds = ((WindowManager) context.getSystemService("window")).getMaximumWindowMetrics().getBounds();
        point.x = bounds.width();
        point.y = bounds.height();
    }

    public static Point b(Context context) {
        Point point = new Point();
        c(context, point);
        return point;
    }

    public static void c(Context context, Point point) {
        Rect bounds = ((WindowManager) context.getSystemService("window")).getCurrentWindowMetrics().getBounds();
        point.x = bounds.width();
        point.y = bounds.height();
    }
}
