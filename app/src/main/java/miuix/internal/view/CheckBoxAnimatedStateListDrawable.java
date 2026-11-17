package miuix.internal.view;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.android.mmt.R;
import miuix.internal.view.a;

/* loaded from: classes.dex */
public class CheckBoxAnimatedStateListDrawable extends miuix.internal.view.a {

    /* renamed from: k, reason: collision with root package name */
    private d f7105k;

    /* renamed from: l, reason: collision with root package name */
    private float f7106l;

    /* renamed from: m, reason: collision with root package name */
    private float f7107m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7108n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7109o;
    private boolean p;

    protected static class a extends a.C0122a {
        protected a() {
        }

        @Override // miuix.internal.view.a.C0122a
        protected final Drawable a(Resources resources, Resources.Theme theme, a.C0122a c0122a) {
            return new CheckBoxAnimatedStateListDrawable(resources, theme, c0122a);
        }
    }

    public CheckBoxAnimatedStateListDrawable() {
        this.f7106l = 1.0f;
        this.f7107m = 1.0f;
        this.f7108n = false;
        this.f7109o = false;
    }

    private int e(TypedArray typedArray, int i2) {
        try {
            return typedArray.getColor(i2, 0);
        } catch (UnsupportedOperationException e2) {
            Log.w("MiuixCheckbox", "try catch UnsupportedOperationException insafeGetColor", e2);
            return 0;
        }
    }

    private int f(TypedArray typedArray, int i2) {
        try {
            return typedArray.getInt(i2, 0);
        } catch (Exception e2) {
            Log.w("MiuixCheckbox", "try catch Exception insafeGetInt", e2);
            return 0;
        }
    }

    @Override // miuix.internal.view.a
    protected a.C0122a a() {
        return new a();
    }

    @Override // android.graphics.drawable.AnimatedStateListDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) throws Resources.NotFoundException {
        super.applyTheme(theme);
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(b(), Y1.a.f2102W);
        this.f7112i.f7114b = e(typedArrayObtainStyledAttributes, 5);
        this.f7112i.f7115c = e(typedArrayObtainStyledAttributes, 2);
        this.f7112i.d = e(typedArrayObtainStyledAttributes, 3);
        this.f7112i.f7116e = e(typedArrayObtainStyledAttributes, 6);
        this.f7112i.f7117f = f(typedArrayObtainStyledAttributes, 1);
        boolean z4 = false;
        this.f7112i.g = f(typedArrayObtainStyledAttributes, 0);
        this.f7112i.f7118h = f(typedArrayObtainStyledAttributes, 8);
        this.f7112i.f7119i = f(typedArrayObtainStyledAttributes, 7);
        a.C0122a c0122a = this.f7112i;
        try {
            z4 = typedArrayObtainStyledAttributes.getBoolean(9, false);
        } catch (Exception e2) {
            Log.w("MiuixCheckbox", "try catch Exception insafeGetBoolean", e2);
        }
        c0122a.f7120j = z4;
        typedArrayObtainStyledAttributes.recycle();
        a.C0122a c0122a2 = this.f7112i;
        this.f7105k = new d(this, this instanceof RadioButtonAnimatedStateListDrawable, c0122a2.f7114b, c0122a2.f7115c, c0122a2.d, c0122a2.f7117f, c0122a2.g, c0122a2.f7116e, c0122a2.f7118h, c0122a2.f7119i);
    }

    protected int b() {
        return R.style.CheckWidgetDrawable_CheckBox;
    }

    public final float c() {
        return this.f7107m;
    }

    public final float d() {
        return this.f7106l;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable current = getCurrent();
        if (current != null && (current instanceof BitmapDrawable)) {
            super.draw(canvas);
            return;
        }
        if (!this.f7112i.f7120j) {
            d dVar = this.f7105k;
            if (dVar != null) {
                dVar.e(canvas);
            }
            super.draw(canvas);
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 2));
        if (this.p) {
            d dVar2 = this.f7105k;
            if (dVar2 != null) {
                dVar2.e(canvas);
            }
            setAlpha((int) (this.f7107m * 255.0f));
        } else {
            setAlpha(76);
        }
        canvas.save();
        Rect bounds = getBounds();
        float f4 = this.f7106l;
        canvas.scale(f4, f4, (bounds.left + bounds.right) / 2, (bounds.top + bounds.bottom) / 2);
        super.draw(canvas);
        canvas.restore();
    }

    protected void g(int i2, int i4, int i5, int i6) {
        d dVar = this.f7105k;
        if (dVar != null) {
            dVar.g(i2, i4, i5, i6);
        }
    }

    protected void h(Rect rect) {
        d dVar = this.f7105k;
        if (dVar != null) {
            dVar.h(rect);
        }
    }

    public final void i(float f4) {
        this.f7107m = f4;
    }

    public final void j(float f4) {
        this.f7106l = f4;
    }

    @Override // android.graphics.drawable.AnimatedStateListDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected final boolean onStateChange(int[] iArr) {
        d dVar;
        d dVar2;
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f7105k == null) {
            return zOnStateChange;
        }
        Drawable current = getCurrent();
        if (current != null && (current instanceof BitmapDrawable)) {
            return super.onStateChange(iArr);
        }
        this.p = false;
        boolean z4 = false;
        boolean z5 = false;
        for (int i2 : iArr) {
            if (i2 == 16842919) {
                z4 = true;
            } else if (i2 == 16842912) {
                z5 = true;
            } else if (i2 == 16842910) {
                this.p = true;
            }
        }
        if (z4 && (dVar2 = this.f7105k) != null) {
            dVar2.j(z5, this.f7112i.f7120j);
        }
        if (!this.f7108n && !z4) {
            boolean z6 = this.p;
            d dVar3 = this.f7105k;
            if (dVar3 != null) {
                dVar3.l(z5, z6);
                invalidateSelf();
            }
        }
        if (!z4 && ((this.f7108n || z5 != this.f7109o) && (dVar = this.f7105k) != null)) {
            dVar.k(z5, this.f7112i.f7120j);
        }
        this.f7108n = z4;
        this.f7109o = z5;
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i2, int i4, int i5, int i6) {
        super.setBounds(i2, i4, i5, i6);
        g(i2, i4, i5, i6);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect rect) {
        super.setBounds(rect);
        h(rect);
    }

    public CheckBoxAnimatedStateListDrawable(Resources resources, Resources.Theme theme, a.C0122a c0122a) {
        super(resources, theme, c0122a);
        this.f7106l = 1.0f;
        this.f7107m = 1.0f;
        this.f7108n = false;
        this.f7109o = false;
        this.f7105k = new d(this, this instanceof RadioButtonAnimatedStateListDrawable, c0122a.f7114b, c0122a.f7115c, c0122a.d, c0122a.f7117f, c0122a.g, c0122a.f7116e, c0122a.f7118h, c0122a.f7119i);
    }
}
