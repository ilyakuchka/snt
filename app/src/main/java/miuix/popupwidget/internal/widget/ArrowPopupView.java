package miuix.popupwidget.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public class ArrowPopupView extends FrameLayout implements View.OnTouchListener {

    /* renamed from: G, reason: collision with root package name */
    public static final /* synthetic */ int f7299G = 0;

    /* renamed from: A, reason: collision with root package name */
    private Drawable f7300A;

    /* renamed from: B, reason: collision with root package name */
    private Drawable f7301B;

    /* renamed from: C, reason: collision with root package name */
    private Rect f7302C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f7303D;

    /* renamed from: E, reason: collision with root package name */
    private int f7304E;

    /* renamed from: F, reason: collision with root package name */
    private int f7305F;

    /* renamed from: i, reason: collision with root package name */
    private AppCompatImageView f7306i;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f7307j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f7308k;

    /* renamed from: l, reason: collision with root package name */
    private LinearLayout f7309l;

    /* renamed from: m, reason: collision with root package name */
    private AppCompatButton f7310m;

    /* renamed from: n, reason: collision with root package name */
    private AppCompatButton f7311n;

    /* renamed from: o, reason: collision with root package name */
    private a f7312o;
    private Drawable p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f7313q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f7314r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f7315s;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f7316t;
    private Drawable u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f7317v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f7318w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f7319x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f7320y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f7321z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrowPopupView arrowPopupView = ArrowPopupView.this;
            int i2 = ArrowPopupView.f7299G;
            Objects.requireNonNull(arrowPopupView);
            throw null;
        }
    }

    public ArrowPopupView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.arrowPopupViewStyle);
        this.f7302C = new Rect();
        new RectF();
        this.f7303D = true;
        this.f7305F = 0;
        setForceDarkAllowed(false);
        this.f7303D = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2106a, R.attr.arrowPopupViewStyle, R.style.Widget_ArrowPopupView_DayNight);
        this.p = typedArrayObtainStyledAttributes.getDrawable(6);
        this.f7313q = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f7314r = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f7315s = typedArrayObtainStyledAttributes.getDrawable(9);
        this.f7316t = typedArrayObtainStyledAttributes.getDrawable(10);
        this.u = typedArrayObtainStyledAttributes.getDrawable(11);
        this.f7317v = typedArrayObtainStyledAttributes.getDrawable(3);
        this.f7318w = typedArrayObtainStyledAttributes.getDrawable(8);
        this.f7319x = typedArrayObtainStyledAttributes.getDrawable(7);
        this.f7320y = typedArrayObtainStyledAttributes.getDrawable(12);
        this.f7321z = typedArrayObtainStyledAttributes.getDrawable(13);
        this.f7301B = typedArrayObtainStyledAttributes.getDrawable(5);
        this.f7300A = typedArrayObtainStyledAttributes.getDrawable(4);
        typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_arrow_popup_window_elevation));
        typedArrayObtainStyledAttributes.recycle();
        context.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_arrow_popup_window_min_border);
    }

    private boolean a(int i2) {
        return (this.f7305F & i2) == i2;
    }

    private boolean b() {
        return a(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onDraw(Canvas canvas) {
        int i2;
        int right;
        float f4;
        int i4;
        int measuredWidth;
        int right2;
        if (this.p != null) {
            return;
        }
        int width = (this.f7308k.getWidth() / 2) + 0;
        int height = (this.f7308k.getHeight() / 2) + 0;
        int i5 = this.f7305F;
        if (i5 != 8) {
            if (i5 == 16) {
                f4 = 180.0f;
                measuredWidth = (this.f7306i.getMeasuredWidth() / 2) + 0;
                right2 = this.f7308k.getRight();
            } else if (i5 == 32) {
                f4 = -90.0f;
                measuredWidth = (this.f7306i.getMeasuredHeight() / 2) + 0;
                right2 = this.f7308k.getBottom();
            } else {
                if (i5 == 64) {
                    f4 = 90.0f;
                    int measuredHeight = (this.f7306i.getMeasuredHeight() / 2) + 0;
                    i2 = measuredHeight + 0;
                    right = this.f7308k.getBottom() - measuredHeight;
                    int iSave = canvas.save();
                    canvas.rotate(f4, width, height);
                    i4 = this.f7305F;
                    if (i4 == 8 || i4 == 16) {
                        float f5 = 0;
                        canvas.translate(f5, f5);
                        this.f7313q.setBounds(0, 0, i2, this.f7308k.getHeight());
                        canvas.translate(0.0f, !b() ? this.f7304E : -this.f7304E);
                        this.f7313q.draw(canvas);
                        canvas.translate(i2, 0.0f);
                        this.f7314r.setBounds(0, 0, right, this.f7308k.getHeight());
                        this.f7314r.draw(canvas);
                    } else if (i4 == 32 || i4 == 64) {
                        canvas.translate(width - (this.f7308k.getHeight() / 2), height - (this.f7308k.getWidth() / 2));
                        this.f7313q.setBounds(0, 0, i2, this.f7308k.getWidth());
                        canvas.translate(0.0f, a(32) ? this.f7304E : -this.f7304E);
                        this.f7313q.draw(canvas);
                        canvas.translate(i2, 0.0f);
                        this.f7314r.setBounds(0, 0, right, this.f7308k.getWidth());
                        this.f7314r.draw(canvas);
                    }
                    canvas.restoreToCount(iSave);
                }
                i2 = 0;
                right = 0;
            }
            i2 = right2 - measuredWidth;
            right = measuredWidth + 0;
            int iSave2 = canvas.save();
            canvas.rotate(f4, width, height);
            i4 = this.f7305F;
            if (i4 == 8) {
                float f52 = 0;
                canvas.translate(f52, f52);
                this.f7313q.setBounds(0, 0, i2, this.f7308k.getHeight());
                canvas.translate(0.0f, !b() ? this.f7304E : -this.f7304E);
                this.f7313q.draw(canvas);
                canvas.translate(i2, 0.0f);
                this.f7314r.setBounds(0, 0, right, this.f7308k.getHeight());
                this.f7314r.draw(canvas);
            }
            canvas.restoreToCount(iSave2);
        }
        int measuredWidth2 = (this.f7306i.getMeasuredWidth() / 2) + 0;
        i2 = measuredWidth2 + 0;
        right = this.f7308k.getRight() - measuredWidth2;
        f4 = 0.0f;
        int iSave22 = canvas.save();
        canvas.rotate(f4, width, height);
        i4 = this.f7305F;
        if (i4 == 8) {
        }
        canvas.restoreToCount(iSave22);
    }

    @Override // android.view.View
    protected final void onFinishInflate() throws Resources.NotFoundException {
        super.onFinishInflate();
        this.f7306i = (AppCompatImageView) findViewById(R.id.popup_arrow);
        this.f7307j = (FrameLayout) findViewById(android.R.id.content);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content_wrapper);
        this.f7308k = linearLayout;
        linearLayout.setBackground(this.p);
        this.f7308k.setMinimumHeight(getContext().getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_arrow_popup_view_min_height));
        if (this.f7313q != null && this.f7314r != null) {
            Rect rect = new Rect();
            this.f7313q.getPadding(rect);
            LinearLayout linearLayout2 = this.f7308k;
            int i2 = rect.top;
            linearLayout2.setPadding(i2, i2, i2, i2);
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.title_layout);
        this.f7309l = linearLayout3;
        linearLayout3.setBackground(this.f7315s);
        this.f7310m = (AppCompatButton) findViewById(android.R.id.button2);
        this.f7311n = (AppCompatButton) findViewById(android.R.id.button1);
        a aVar = new a();
        this.f7312o = new a();
        this.f7310m.setOnClickListener(aVar);
        this.f7311n.setOnClickListener(this.f7312o);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        throw null;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        Rect rect = this.f7302C;
        this.f7308k.getHitRect(rect);
        if (motionEvent.getAction() != 0 || rect.contains(x2, y2)) {
            return false;
        }
        throw null;
    }
}
