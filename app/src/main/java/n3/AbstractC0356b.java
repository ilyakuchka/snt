package n3;

import android.view.View;
import com.android.mmt.R;

/* renamed from: n3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0356b extends AbstractC0355a<View> {

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC0356b f7494b;

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC0356b f7495c;
    public static final AbstractC0356b d;

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC0356b f7496e;

    /* renamed from: f, reason: collision with root package name */
    public static final AbstractC0356b f7497f;
    public static final AbstractC0356b g;

    /* renamed from: n3.b$a */
    final class a extends AbstractC0356b {
        a() {
            super("y");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getY();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setY(f4);
        }
    }

    /* renamed from: n3.b$b, reason: collision with other inner class name */
    final class C0130b extends AbstractC0356b {
        C0130b() {
            super("z");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getZ();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setZ(f4);
        }
    }

    /* renamed from: n3.b$c */
    final class c extends AbstractC0356b {
        c() {
            super("height");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            View view2 = view;
            int height = view2.getHeight();
            Float f4 = (Float) view2.getTag(R.id.miuix_animation_tag_set_height);
            if (f4 != null) {
                return f4.floatValue();
            }
            if (height == 0) {
                if (view2.getTag(R.id.miuix_animation_tag_init_layout) != null) {
                    height = view2.getMeasuredHeight();
                }
            }
            return height;
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            View view2 = view;
            view2.getLayoutParams().height = (int) f4;
            view2.setTag(R.id.miuix_animation_tag_set_height, Float.valueOf(f4));
            view2.requestLayout();
        }
    }

    /* renamed from: n3.b$d */
    final class d extends AbstractC0356b {
        d() {
            super("width");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            View view2 = view;
            int width = view2.getWidth();
            Float f4 = (Float) view2.getTag(R.id.miuix_animation_tag_set_width);
            if (f4 != null) {
                return f4.floatValue();
            }
            if (width == 0) {
                if (view2.getTag(R.id.miuix_animation_tag_init_layout) != null) {
                    width = view2.getMeasuredWidth();
                }
            }
            return width;
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            View view2 = view;
            view2.getLayoutParams().width = (int) f4;
            view2.setTag(R.id.miuix_animation_tag_set_width, Float.valueOf(f4));
            view2.requestLayout();
        }
    }

    /* renamed from: n3.b$e */
    final class e extends AbstractC0356b {
        e() {
            super("alpha");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getAlpha();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setAlpha(f4);
        }
    }

    /* renamed from: n3.b$f */
    final class f extends AbstractC0356b {
        f() {
            super("autoAlpha");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getAlpha();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            View view2 = view;
            view2.setAlpha(f4);
            boolean z4 = Math.abs(f4) <= 0.00390625f;
            if (view2.getVisibility() != 0 && f4 > 0.0f && !z4) {
                view2.setVisibility(0);
            } else if (z4) {
                view2.setVisibility(8);
            }
        }
    }

    /* renamed from: n3.b$g */
    final class g extends AbstractC0356b {
        g() {
            super("scrollX");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getScrollX();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setScrollX((int) f4);
        }
    }

    /* renamed from: n3.b$h */
    final class h extends AbstractC0356b {
        h() {
            super("scrollY");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getScrollY();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setScrollY((int) f4);
        }
    }

    /* renamed from: n3.b$i */
    final class i extends AbstractC0356b {
        i() {
            super("deprecated_foreground");
        }

        @Override // n3.AbstractC0355a
        public final /* bridge */ /* synthetic */ float a(View view) {
            return 0.0f;
        }

        @Override // n3.AbstractC0355a
        public final /* bridge */ /* synthetic */ void b(View view, float f4) {
        }
    }

    /* renamed from: n3.b$j */
    final class j extends AbstractC0356b {
        j() {
            super("deprecated_background");
        }

        @Override // n3.AbstractC0355a
        public final /* bridge */ /* synthetic */ float a(View view) {
            return 0.0f;
        }

        @Override // n3.AbstractC0355a
        public final /* bridge */ /* synthetic */ void b(View view, float f4) {
        }
    }

    /* renamed from: n3.b$k */
    final class k extends AbstractC0356b {
        k() {
            super("translationX");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getTranslationX();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setTranslationX(f4);
        }
    }

    /* renamed from: n3.b$l */
    final class l extends AbstractC0356b {
        l() {
            super("translationY");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getTranslationY();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setTranslationY(f4);
        }
    }

    /* renamed from: n3.b$m */
    final class m extends AbstractC0356b {
        m() {
            super("translationZ");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getTranslationZ();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setTranslationZ(f4);
        }
    }

    /* renamed from: n3.b$n */
    final class n extends AbstractC0356b {
        n() {
            super("scaleX");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getScaleX();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setScaleX(f4);
        }
    }

    /* renamed from: n3.b$o */
    final class o extends AbstractC0356b {
        o() {
            super("scaleY");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getScaleY();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setScaleY(f4);
        }
    }

    /* renamed from: n3.b$p */
    final class p extends AbstractC0356b {
        p() {
            super("rotation");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getRotation();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setRotation(f4);
        }
    }

    /* renamed from: n3.b$q */
    final class q extends AbstractC0356b {
        q() {
            super("rotationX");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getRotationX();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setRotationX(f4);
        }
    }

    /* renamed from: n3.b$r */
    final class r extends AbstractC0356b {
        r() {
            super("rotationY");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getRotationY();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setRotationY(f4);
        }
    }

    /* renamed from: n3.b$s */
    final class s extends AbstractC0356b {
        s() {
            super("x");
        }

        @Override // n3.AbstractC0355a
        public final float a(View view) {
            return view.getX();
        }

        @Override // n3.AbstractC0355a
        public final void b(View view, float f4) {
            view.setX(f4);
        }
    }

    static {
        new k();
        new l();
        new m();
        f7494b = new n();
        f7495c = new o();
        d = new p();
        f7496e = new q();
        f7497f = new r();
        new s();
        new a();
        new C0130b();
        new c();
        new d();
        g = new e();
        new f();
        new g();
        new h();
        new i();
        new j();
    }

    public AbstractC0356b(String str) {
        super(str);
    }

    @Override // n3.AbstractC0355a
    public final String toString() {
        StringBuilder sbD = D2.e.d("ViewProperty{mPropertyName='");
        sbD.append(this.f7493a);
        sbD.append('\'');
        sbD.append('}');
        return sbD.toString();
    }
}
