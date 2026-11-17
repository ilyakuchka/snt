package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements i {

    /* renamed from: b, reason: collision with root package name */
    private static int f2229b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f2230c;
    private static Field d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f2231e;

    /* renamed from: a, reason: collision with root package name */
    private Activity f2232a;

    @Override // androidx.lifecycle.i
    public final void g(k kVar, g.b bVar) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (bVar != g.b.ON_DESTROY) {
            return;
        }
        if (f2229b == 0) {
            try {
                f2229b = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                d = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                f2231e = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f2230c = declaredField3;
                declaredField3.setAccessible(true);
                f2229b = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f2229b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2232a.getSystemService("input_method");
            try {
                Object obj = f2230c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f2231e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused2) {
                            }
                        } catch (ClassCastException unused3) {
                        } catch (IllegalAccessException unused4) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
