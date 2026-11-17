package w3;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;

/* renamed from: w3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0408a {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean b(Context context) throws NoSuchFieldException, SecurityException {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        Point point2 = new Point();
        WindowManager windowManager2 = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager2.getDefaultDisplay();
        try {
            try {
                Field declaredField = defaultDisplay.getClass().getDeclaredField("mDisplayInfo");
                declaredField.setAccessible(true);
                Object objF = Y1.a.f(defaultDisplay, declaredField);
                try {
                    Field field = objF.getClass().getField("logicalWidth");
                    field.setAccessible(true);
                    point2.x = ((Integer) Y1.a.f(objF, field)).intValue();
                    try {
                        Field field2 = objF.getClass().getField("logicalHeight");
                        field2.setAccessible(true);
                        point2.y = ((Integer) Y1.a.f(objF, field2)).intValue();
                    } catch (NoSuchFieldException e2) {
                        throw new RuntimeException(e2);
                    }
                } catch (NoSuchFieldException e4) {
                    throw new RuntimeException(e4);
                }
            } catch (NoSuchFieldException e5) {
                throw new RuntimeException(e5);
            }
        } catch (Exception e6) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager2.getDefaultDisplay().getRealMetrics(displayMetrics);
            point2.x = displayMetrics.widthPixels;
            point2.y = displayMetrics.heightPixels;
            Log.w("MiuixUtils", "catch error! failed to get physical size", e6);
        }
        return context.getResources().getConfiguration().toString().contains("mWindowingMode=freeform") && ((((float) point.x) + 0.0f) / ((float) point2.x) <= 0.9f || (((float) point.y) + 0.0f) / ((float) point2.y) <= 0.9f);
    }
}
