package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

/* loaded from: classes.dex */
public final class e {
    public static int a(Context context, int i2, int i4) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i4;
    }

    public static boolean b(TypedArray typedArray, int i2, int i4, boolean z4) {
        return typedArray.getBoolean(i2, typedArray.getBoolean(i4, z4));
    }

    public static int c(TypedArray typedArray) {
        return typedArray.getResourceId(23, typedArray.getResourceId(0, 0));
    }

    public static String d(TypedArray typedArray, int i2, int i4) {
        String string = typedArray.getString(i2);
        return string == null ? typedArray.getString(i4) : string;
    }

    public static CharSequence[] e(TypedArray typedArray, int i2, int i4) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        return textArray == null ? typedArray.getTextArray(i4) : textArray;
    }
}
