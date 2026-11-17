package t3;

import android.content.Context;
import android.content.res.TypedArray;
import com.android.mmt.R;
import z3.C0431a;

/* renamed from: t3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0386a {

    /* renamed from: a, reason: collision with root package name */
    private Context f7905a;

    private C0386a(Context context) {
        this.f7905a = context;
    }

    public static C0386a b(Context context) {
        return new C0386a(context);
    }

    public final boolean a() {
        return this.f7905a.getApplicationInfo().targetSdkVersion < 14;
    }

    public final int c() {
        return this.f7905a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public final int d() {
        return this.f7905a.getResources().getInteger(R.integer.abc_max_action_buttons);
    }

    public final int e() {
        return this.f7905a.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_bar_stacked_tab_max_width);
    }

    public final int f() {
        Context context = this.f7905a;
        int[] iArr = Y1.a.f2098S;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, android.R.attr.actionBarTabBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(4, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (layoutDimension > 0) {
            return layoutDimension;
        }
        TypedArray typedArrayObtainStyledAttributes2 = this.f7905a.obtainStyledAttributes(null, iArr, android.R.attr.actionBarStyle, 0);
        int layoutDimension2 = typedArrayObtainStyledAttributes2.getLayoutDimension(4, 0);
        typedArrayObtainStyledAttributes2.recycle();
        return layoutDimension2;
    }

    public final boolean g() {
        return C0431a.c(this.f7905a, R.attr.actionBarEmbedTabs, false);
    }

    public final boolean h() {
        return C0431a.c(this.f7905a, R.attr.actionBarTightTitle, false);
    }
}
