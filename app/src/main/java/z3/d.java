package z3;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import y3.C0426a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static int f8173a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f8174b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f8175c = -1;
    private static final int[] d = {R.attr.state_single, R.attr.state_first, R.attr.state_middle, R.attr.state_last};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f8176e = {R.attr.state_single};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f8177f = {R.attr.state_first};
    private static final int[] g = {R.attr.state_middle};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f8178h = {R.attr.state_last};

    private static int a(Context context, int i2) {
        return context.getResources().getDimensionPixelSize(i2);
    }

    public static void b(View view, int i2, int i4) {
        if (view != null && i4 != 0) {
            Drawable background = view.getBackground();
            if ((background instanceof StateListDrawable) && C0426a.b((StateListDrawable) background, d)) {
                C0426a c0426a = new C0426a(background);
                view.setBackground(c0426a);
                background = c0426a;
            }
            if (background instanceof C0426a) {
                ((C0426a) background).c(i4 == 1 ? f8176e : i2 == 0 ? f8177f : i2 == i4 + (-1) ? f8178h : g);
            }
        }
        c(view, i2, i4);
    }

    public static void c(View view, int i2, int i4) {
        int i5;
        int i6;
        if (view == null || i4 == 0) {
            return;
        }
        Context context = view.getContext();
        int paddingStart = view.getPaddingStart();
        view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        view.getPaddingBottom();
        if (i4 != 1) {
            if (f8173a == -1) {
                f8173a = a(context, com.android.mmt.R.dimen.miuix_appcompat_drop_down_menu_padding_small);
            }
            if (f8174b == -1) {
                f8174b = a(context, com.android.mmt.R.dimen.miuix_appcompat_drop_down_menu_padding_large);
            }
            if (i2 == 0) {
                i5 = f8174b;
                i6 = f8173a;
            } else if (i2 == i4 - 1) {
                i5 = f8173a;
                i6 = f8174b;
            } else {
                i5 = f8173a;
            }
            view.setPaddingRelative(paddingStart, i5, paddingEnd, i6);
        }
        if (f8175c == -1) {
            f8175c = a(context, com.android.mmt.R.dimen.miuix_appcompat_drop_down_menu_padding_single_item);
        }
        i5 = f8175c;
        i6 = i5;
        view.setPaddingRelative(paddingStart, i5, paddingEnd, i6);
    }
}
