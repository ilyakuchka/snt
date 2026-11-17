package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;

/* loaded from: classes.dex */
public final class Q extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2814a = new Object();

    public static Context a(Context context) {
        if (!(context instanceof Q) && !(context.getResources() instanceof T)) {
            context.getResources();
            int i2 = X.f2969a;
        }
        return context;
    }
}
