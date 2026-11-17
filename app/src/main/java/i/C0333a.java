package i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.L;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* renamed from: i.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0333a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f6333a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f6334b = 0;

    static {
        new ThreadLocal();
        new WeakHashMap(0);
        f6333a = new Object();
    }

    public static Drawable a(Context context, int i2) {
        return L.c().e(context, i2);
    }
}
