package miuix.miuixbasewidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import miuix.view.HapticCompat;
import miuix.view.c;
import t.C0384b;

/* loaded from: classes.dex */
public class FloatingActionButton extends ImageView {

    /* renamed from: i, reason: collision with root package name */
    private final int f7170i;

    /* renamed from: j, reason: collision with root package name */
    private final int f7171j;

    /* renamed from: k, reason: collision with root package name */
    private final int f7172k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f7173l;

    /* renamed from: m, reason: collision with root package name */
    private StateListDrawable f7174m;

    /* renamed from: n, reason: collision with root package name */
    private int f7175n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7176o;
    private a p;

    class a extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f7177a;

        a(Drawable drawable) {
            this.f7177a = drawable;
            new Paint();
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            int width = FloatingActionButton.this.getWidth();
            int paddingLeft = FloatingActionButton.this.getPaddingLeft();
            int paddingTop = FloatingActionButton.this.getPaddingTop();
            int paddingRight = (((width - paddingLeft) - FloatingActionButton.this.getPaddingRight()) / 2) * 2;
            this.f7177a.setBounds(paddingLeft, paddingTop, paddingLeft + paddingRight, paddingRight + paddingTop);
            this.f7177a.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable.ConstantState getConstantState() {
            return this.f7177a.getConstantState();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return this.f7177a.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i2) {
            this.f7177a.setAlpha(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
            this.f7177a.setColorFilter(colorFilter);
        }
    }

    private static class b extends OvalShape {

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<View> f7179i;

        public b(View view) {
            this.f7179i = new WeakReference<>(view);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public final void draw(Canvas canvas, Paint paint) {
            View view = this.f7179i.get();
            if (view != null) {
                int width = view.getWidth();
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                canvas.drawCircle(paddingLeft + r0, paddingTop + r0, ((width - paddingLeft) - view.getPaddingRight()) / 2, paint);
            }
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        float f4 = getContext().getResources().getDisplayMetrics().density;
        this.f7171j = (int) (0.0f * f4);
        int i2 = (int) (f4 * 5.45f);
        this.f7172k = i2;
        this.f7170i = i2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7872a, 0, R.style.Widget_FloatingActionButton);
        this.f7173l = typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.f7176o = typedArrayObtainStyledAttributes.hasValue(0);
        this.f7175n = typedArrayObtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.miuix_appcompat_fab_color_light));
        typedArrayObtainStyledAttributes.recycle();
        this.p = new a(getContext().getResources().getDrawable(R.drawable.miuix_appcompat_fab_empty_holder));
        if (getBackground() != null) {
            this.f7176o = false;
        } else if (this.f7176o) {
            super.setBackground(a());
        } else {
            super.setBackground(b());
        }
        c();
    }

    private Drawable a() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new b(this));
        if (this.f7173l) {
            int i2 = this.f7175n;
            int iArgb = Color.argb(25, Color.red(i2), Math.max(0, Color.green(i2) - 30), Color.blue(i2));
            setLayerType(2, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer(this.f7170i, this.f7171j, this.f7172k, iArgb);
        }
        shapeDrawable.getPaint().setColor(this.f7175n);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, this.p});
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new b(this));
        shapeDrawable2.getPaint().setColor(218103808);
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{layerDrawable, shapeDrawable2});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(ImageView.PRESSED_ENABLED_STATE_SET, layerDrawable2);
        stateListDrawable.addState(ImageView.ENABLED_SELECTED_STATE_SET, layerDrawable2);
        stateListDrawable.addState(ImageView.EMPTY_STATE_SET, layerDrawable);
        return stateListDrawable;
    }

    private Drawable b() {
        if (this.f7174m == null) {
            this.f7175n = getContext().getResources().getColor(R.color.miuix_appcompat_fab_color_light);
            this.f7176o = true;
            this.f7174m = (StateListDrawable) a();
        }
        return this.f7174m;
    }

    private void c() {
        if (this.f7173l && this.f7176o) {
            setPadding(Math.max(0, this.f7170i - this.f7171j), Math.max(0, this.f7170i - this.f7172k), Math.max(0, this.f7170i + this.f7171j), Math.max(0, this.f7170i + this.f7172k));
        } else {
            setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = (((getWidth() - paddingLeft) - getPaddingRight()) / 2) * 2;
        this.p.setBounds(paddingLeft, paddingTop, paddingLeft + width, width + paddingTop);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final boolean performClick() {
        HapticCompat.performHapticFeedback(this, c.d);
        return super.performClick();
    }

    @Override // android.view.View
    public final void setBackground(Drawable drawable) {
        this.f7176o = false;
        if (drawable == null) {
            drawable = b();
        }
        super.setBackground(drawable);
        c();
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i2) {
        if (!this.f7176o || this.f7175n != i2) {
            this.f7175n = i2;
            super.setBackground(a());
            c();
        }
        this.f7176o = true;
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        this.f7176o = false;
        if (i2 == 0) {
            super.setBackground(b());
        } else {
            super.setBackgroundResource(i2);
        }
        c();
    }
}
