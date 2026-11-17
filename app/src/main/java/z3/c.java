package z3;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private DisplayMetrics f8170a;

    /* renamed from: b, reason: collision with root package name */
    private int f8171b;

    /* renamed from: c, reason: collision with root package name */
    private int f8172c;
    private float d;

    public c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f8170a = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(this.f8170a);
        DisplayMetrics displayMetrics = this.f8170a;
        this.f8171b = displayMetrics.widthPixels;
        this.f8172c = displayMetrics.heightPixels;
        this.d = displayMetrics.density;
    }

    public final float a() {
        return this.d;
    }

    public final int b() {
        return this.f8172c;
    }

    public final int c() {
        return this.f8171b;
    }
}
