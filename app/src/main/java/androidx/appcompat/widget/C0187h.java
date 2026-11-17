package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.L;
import com.android.mmt.R;
import i.C0333a;
import y.C0419a;

/* renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0187h {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f3018b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static C0187h f3019c;
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: collision with root package name */
    private L f3020a;

    /* renamed from: androidx.appcompat.widget.h$a */
    final class a implements L.c {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f3021a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f3022b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f3023c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        private final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f3024e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f3025f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        a() {
        }

        private boolean a(int[] iArr, int i2) {
            for (int i4 : iArr) {
                if (i4 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList b(Context context, int i2) {
            int iC = O.c(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{O.f2810b, O.d, O.f2811c, O.f2813f}, new int[]{O.b(context, R.attr.colorButtonNormal), C0419a.a(iC, i2), C0419a.a(iC, i2), i2});
        }

        private LayerDrawable d(L l2, Context context, int i2) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            Drawable drawableE = l2.e(context, R.drawable.abc_star_black_48dp);
            Drawable drawableE2 = l2.e(context, R.drawable.abc_star_half_black_48dp);
            if ((drawableE instanceof BitmapDrawable) && drawableE.getIntrinsicWidth() == dimensionPixelSize && drawableE.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableE;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableE.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableE.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableE2 instanceof BitmapDrawable) && drawableE2.getIntrinsicWidth() == dimensionPixelSize && drawableE2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableE2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableE2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableE2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        private void f(Drawable drawable, int i2, PorterDuff.Mode mode) {
            PorterDuffColorFilter porterDuffColorFilterG;
            if (C.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C0187h.f3018b;
            }
            synchronized (C0187h.class) {
                porterDuffColorFilterG = L.g(i2, mode);
            }
            drawable.setColorFilter(porterDuffColorFilterG);
        }

        public final Drawable c(L l2, Context context, int i2) {
            if (i2 == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{l2.e(context, R.drawable.abc_cab_background_internal_bg), l2.e(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i2 == R.drawable.abc_ratingbar_material) {
                return d(l2, context, R.dimen.abc_star_big);
            }
            if (i2 == R.drawable.abc_ratingbar_indicator_material) {
                return d(l2, context, R.dimen.abc_star_medium);
            }
            if (i2 == R.drawable.abc_ratingbar_small_material) {
                return d(l2, context, R.dimen.abc_star_small);
            }
            return null;
        }

        public final ColorStateList e(Context context, int i2) {
            if (i2 == R.drawable.abc_edit_text_material) {
                int i4 = C0333a.f6334b;
                return context.getColorStateList(R.color.abc_tint_edittext);
            }
            if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
                int i5 = C0333a.f6334b;
                return context.getColorStateList(R.color.abc_tint_switch_track);
            }
            if (i2 == R.drawable.abc_switch_thumb_material) {
                int[][] iArr = new int[3][];
                int[] iArr2 = new int[3];
                ColorStateList colorStateListD = O.d(context, R.attr.colorSwitchThumbNormal);
                if (colorStateListD == null || !colorStateListD.isStateful()) {
                    iArr[0] = O.f2810b;
                    iArr2[0] = O.b(context, R.attr.colorSwitchThumbNormal);
                    iArr[1] = O.f2812e;
                    iArr2[1] = O.c(context, R.attr.colorControlActivated);
                    iArr[2] = O.f2813f;
                    iArr2[2] = O.c(context, R.attr.colorSwitchThumbNormal);
                } else {
                    iArr[0] = O.f2810b;
                    iArr2[0] = colorStateListD.getColorForState(iArr[0], 0);
                    iArr[1] = O.f2812e;
                    iArr2[1] = O.c(context, R.attr.colorControlActivated);
                    iArr[2] = O.f2813f;
                    iArr2[2] = colorStateListD.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            }
            if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
                return b(context, O.c(context, R.attr.colorButtonNormal));
            }
            if (i2 == R.drawable.abc_btn_borderless_material) {
                return b(context, 0);
            }
            if (i2 == R.drawable.abc_btn_colored_material) {
                return b(context, O.c(context, R.attr.colorAccent));
            }
            if (i2 == R.drawable.abc_spinner_mtrl_am_alpha || i2 == R.drawable.abc_spinner_textfield_background_material) {
                int i6 = C0333a.f6334b;
                return context.getColorStateList(R.color.abc_tint_spinner);
            }
            if (a(this.f3022b, i2)) {
                return O.d(context, R.attr.colorControlNormal);
            }
            if (a(this.f3024e, i2)) {
                int i7 = C0333a.f6334b;
                return context.getColorStateList(R.color.abc_tint_default);
            }
            if (a(this.f3025f, i2)) {
                int i8 = C0333a.f6334b;
                return context.getColorStateList(R.color.abc_tint_btn_checkable);
            }
            if (i2 != R.drawable.abc_seekbar_thumb_material) {
                return null;
            }
            int i9 = C0333a.f6334b;
            return context.getColorStateList(R.color.abc_tint_seek_thumb);
        }

        public final boolean g(Context context, int i2, Drawable drawable) {
            if (i2 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                f(layerDrawable.findDrawableByLayerId(android.R.id.background), O.c(context, R.attr.colorControlNormal), C0187h.f3018b);
                f(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), O.c(context, R.attr.colorControlNormal), C0187h.f3018b);
                f(layerDrawable.findDrawableByLayerId(android.R.id.progress), O.c(context, R.attr.colorControlActivated), C0187h.f3018b);
                return true;
            }
            if (i2 != R.drawable.abc_ratingbar_material && i2 != R.drawable.abc_ratingbar_indicator_material && i2 != R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            f(layerDrawable2.findDrawableByLayerId(android.R.id.background), O.b(context, R.attr.colorControlNormal), C0187h.f3018b);
            f(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), O.c(context, R.attr.colorControlActivated), C0187h.f3018b);
            f(layerDrawable2.findDrawableByLayerId(android.R.id.progress), O.c(context, R.attr.colorControlActivated), C0187h.f3018b);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x006d A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean h(Context context, int i2, Drawable drawable) {
            int iRound;
            int i4;
            boolean z4;
            PorterDuffColorFilter porterDuffColorFilterG;
            PorterDuff.Mode mode = C0187h.f3018b;
            boolean zA = a(this.f3021a, i2);
            int i5 = android.R.attr.colorBackground;
            if (zA) {
                i5 = R.attr.colorControlNormal;
            } else if (a(this.f3023c, i2)) {
                i5 = R.attr.colorControlActivated;
            } else if (a(this.d, i2)) {
                mode = PorterDuff.Mode.MULTIPLY;
            } else {
                if (i2 == R.drawable.abc_list_divider_mtrl_alpha) {
                    i4 = android.R.attr.colorForeground;
                    iRound = Math.round(40.8f);
                    z4 = true;
                    if (!z4) {
                        return false;
                    }
                    if (C.a(drawable)) {
                        drawable = drawable.mutate();
                    }
                    int iC = O.c(context, i4);
                    synchronized (C0187h.class) {
                        porterDuffColorFilterG = L.g(iC, mode);
                    }
                    drawable.setColorFilter(porterDuffColorFilterG);
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
                if (i2 != R.drawable.abc_dialog_material_background) {
                    iRound = -1;
                    i4 = 0;
                    z4 = false;
                    if (!z4) {
                    }
                }
            }
            i4 = i5;
            iRound = -1;
            z4 = true;
            if (!z4) {
            }
        }
    }

    public static synchronized C0187h b() {
        if (f3019c == null) {
            g();
        }
        return f3019c;
    }

    public static synchronized void g() {
        if (f3019c == null) {
            C0187h c0187h = new C0187h();
            f3019c = c0187h;
            c0187h.f3020a = L.c();
            f3019c.f3020a.k(new a());
        }
    }

    public final synchronized Drawable c(Context context, int i2) {
        return this.f3020a.e(context, i2);
    }

    final synchronized Drawable d(Context context, int i2) {
        return this.f3020a.f(context, i2, true);
    }

    final synchronized ColorStateList e(Context context, int i2) {
        return this.f3020a.h(context, i2);
    }

    public final synchronized void f(Context context) {
        this.f3020a.j(context);
    }
}
