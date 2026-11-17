package h1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import i.C0333a;
import w.C0405a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f6321a = true;

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        return c(context, context, i2, theme);
    }

    public static Drawable b(Context context, Context context2, int i2) {
        return c(context, context2, i2, null);
    }

    private static Drawable c(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (f6321a) {
                return C0333a.a(theme != null ? new l.d(context2, theme) : context2, i2);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            int i4 = C0405a.f7979b;
            return context2.getDrawable(i2);
        } catch (NoClassDefFoundError unused2) {
            f6321a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return context2.getResources().getDrawable(i2, theme);
    }
}
