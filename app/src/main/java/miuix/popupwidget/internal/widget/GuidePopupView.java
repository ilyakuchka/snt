package miuix.popupwidget.internal.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public class GuidePopupView extends FrameLayout implements View.OnTouchListener {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f7323w = 0;

    /* renamed from: i, reason: collision with root package name */
    private View f7324i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f7325j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7326k;

    /* renamed from: l, reason: collision with root package name */
    private int f7327l;

    /* renamed from: m, reason: collision with root package name */
    private int f7328m;

    /* renamed from: n, reason: collision with root package name */
    private int f7329n;

    /* renamed from: o, reason: collision with root package name */
    private int f7330o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f7331q;

    /* renamed from: r, reason: collision with root package name */
    private float f7332r;

    /* renamed from: s, reason: collision with root package name */
    private float f7333s;

    /* renamed from: t, reason: collision with root package name */
    private float f7334t;
    private final Paint u;

    /* renamed from: v, reason: collision with root package name */
    private int f7335v;

    final class a extends AnimatorListenerAdapter {

        /* renamed from: i, reason: collision with root package name */
        private boolean f7336i;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f7336i = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.f7336i) {
                return;
            }
            GuidePopupView guidePopupView = GuidePopupView.this;
            int i2 = GuidePopupView.f7323w;
            Objects.requireNonNull(guidePopupView);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            this.f7336i = false;
        }
    }

    final class b extends AnimatorListenerAdapter {

        /* renamed from: i, reason: collision with root package name */
        private boolean f7338i;

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f7338i = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.f7338i) {
                return;
            }
            GuidePopupView guidePopupView = GuidePopupView.this;
            int i2 = GuidePopupView.f7323w;
            Objects.requireNonNull(guidePopupView);
            Objects.requireNonNull(GuidePopupView.this);
            Objects.requireNonNull(GuidePopupView.this);
            throw null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            this.f7338i = false;
            GuidePopupView guidePopupView = GuidePopupView.this;
            int i2 = GuidePopupView.f7323w;
            Objects.requireNonNull(guidePopupView);
        }
    }

    public GuidePopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.guidePopupViewStyle);
        this.f7326k = true;
        Paint paint = new Paint();
        this.u = paint;
        new a();
        new b();
        this.f7335v = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2108b, R.attr.guidePopupViewStyle, R.style.Widget_GuidePopupView_DayNight);
        this.f7332r = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.f7333s = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        this.f7334t = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
        typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setColor(typedArrayObtainStyledAttributes.getColor(4, -1));
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 15);
        typedArrayObtainStyledAttributes.getColorStateList(2);
        typedArrayObtainStyledAttributes.recycle();
        this.f7328m = (int) ((this.f7334t * 2.5f) + this.f7333s);
    }

    private void a(Canvas canvas, int i2) {
        float f4;
        this.u.setAntiAlias(true);
        this.u.setStyle(Paint.Style.FILL);
        float f5 = (this.p / 2) + this.f7329n + 0;
        float f6 = (this.f7331q / 2) + this.f7330o + 0;
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    f4 = 90.0f;
                    break;
                case 3:
                    f4 = -90.0f;
                    break;
                case 4:
                    f4 = -45.0f;
                    break;
                case 5:
                    f4 = 135.0f;
                    break;
                case 6:
                    f4 = 45.0f;
                    break;
                case 7:
                    f4 = -135.0f;
                    break;
                default:
                    f4 = 0.0f;
                    break;
            }
        } else {
            f4 = 180.0f;
        }
        canvas.save();
        canvas.rotate(f4, f5, f6);
        canvas.translate(0.0f, this.f7327l);
        int iSave = canvas.save();
        canvas.clipRect(f5 - 2.0f, f6, f5 + 2.0f, f6 + this.f7332r, Region.Op.DIFFERENCE);
        canvas.drawCircle(f5, f6, this.f7332r, this.u);
        canvas.restoreToCount(iSave);
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setStrokeWidth(4.0f);
        canvas.drawLine(f5, f6, f5, f6 + this.f7333s, this.u);
        float f7 = f6 + this.f7333s + this.f7334t;
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setStrokeWidth(4.0f);
        canvas.drawCircle(f5, f7, this.f7334t, this.u);
        canvas.restore();
    }

    private void b(int i2, LinearLayout linearLayout) {
        int measuredWidth;
        float f4;
        int measuredHeight;
        int i4;
        int measuredHeight2;
        float f5 = this.f7327l + this.f7333s + this.f7334t;
        int i5 = (this.p / 2) + this.f7329n;
        int i6 = (this.f7331q / 2) + this.f7330o;
        switch (i2) {
            case 0:
            case 5:
            case 7:
                measuredWidth = i5 - (linearLayout.getMeasuredWidth() / 2);
                f4 = i6 - f5;
                measuredHeight = linearLayout.getMeasuredHeight() / 2;
                i4 = (int) (f4 - measuredHeight);
                break;
            case 1:
            case 4:
            case 6:
                measuredWidth = i5 - (linearLayout.getMeasuredWidth() / 2);
                f4 = i6 + f5;
                measuredHeight = linearLayout.getMeasuredHeight() / 2;
                i4 = (int) (f4 - measuredHeight);
                break;
            case 2:
                measuredWidth = (int) ((i5 - f5) - (linearLayout.getMeasuredWidth() / 2));
                measuredHeight2 = linearLayout.getMeasuredHeight() / 2;
                i4 = i6 - measuredHeight2;
                break;
            case 3:
                measuredWidth = (int) ((i5 + f5) - (linearLayout.getMeasuredWidth() / 2));
                measuredHeight2 = linearLayout.getMeasuredHeight() / 2;
                i4 = i6 - measuredHeight2;
                break;
            default:
                i4 = 0;
                measuredWidth = 0;
                break;
        }
        int iSin = (int) (Math.sin(0.7853981633974483d) * f5);
        int i7 = (int) (f5 - iSin);
        if (i2 != 4) {
            if (i2 == 5) {
                measuredWidth -= iSin;
            } else {
                if (i2 != 6) {
                    if (i2 == 7) {
                        measuredWidth += iSin;
                    }
                    int i8 = measuredWidth + 0;
                    int i9 = i4 + 0;
                    linearLayout.layout(i8, i9, linearLayout.getMeasuredWidth() + i8, linearLayout.getMeasuredHeight() + i9);
                }
                measuredWidth -= iSin;
            }
            i4 += i7;
            int i82 = measuredWidth + 0;
            int i92 = i4 + 0;
            linearLayout.layout(i82, i92, linearLayout.getMeasuredWidth() + i82, linearLayout.getMeasuredHeight() + i92);
        }
        measuredWidth += iSin;
        i4 -= i7;
        int i822 = measuredWidth + 0;
        int i922 = i4 + 0;
        linearLayout.layout(i822, i922, linearLayout.getMeasuredWidth() + i822, linearLayout.getMeasuredHeight() + i922);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate(this.f7329n, this.f7330o);
        this.f7324i.setDrawingCacheEnabled(true);
        this.f7324i.buildDrawingCache();
        canvas.drawBitmap(this.f7324i.getDrawingCache(), 0.0f, 0.0f, (Paint) null);
        this.f7324i.setDrawingCacheEnabled(false);
        canvas.restore();
        a(canvas, this.f7335v);
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.f7325j = (LinearLayout) findViewById(R.id.text_group);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e3  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int i7 = 0;
        if (this.p == 0 || this.f7331q == 0) {
            View view = this.f7324i;
            this.f7324i = view;
            this.p = view.getWidth();
            this.f7331q = this.f7324i.getHeight();
            int[] iArr = new int[2];
            this.f7324i.getLocationInWindow(iArr);
            this.f7329n = iArr[0];
            this.f7330o = iArr[1];
        }
        this.f7334t = (float) Math.max(Math.sqrt(Math.pow(this.f7325j.getMeasuredHeight(), 2.0d) + Math.pow(this.f7325j.getMeasuredWidth(), 2.0d)) / 2.0d, this.f7334t);
        if (this.f7335v != -1) {
            if (this.f7326k) {
                int i8 = this.p / 2;
                int i9 = this.f7331q / 2;
                int iSqrt = (int) Math.sqrt(Math.pow(i9, 2.0d) + Math.pow(i8, 2.0d));
                int i10 = this.f7335v;
                if (i10 == 0 || i10 == 1) {
                    this.f7327l = i9;
                } else if (i10 == 2 || i10 == 3) {
                    this.f7327l = i8;
                } else {
                    this.f7327l = iSqrt;
                }
            } else {
                this.f7327l = 0;
            }
            b(this.f7335v, this.f7325j);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i11 = 4;
        int i12 = this.f7330o;
        int i13 = this.f7331q;
        int i14 = this.f7329n;
        int i15 = this.p;
        int[] iArr2 = {i12, (height - i12) - i13, i14, (width - i14) - i15};
        int i16 = (i15 / 2) + i14;
        int i17 = (i13 / 2) + i12;
        int i18 = Integer.MIN_VALUE;
        int i19 = 0;
        while (true) {
            if (i7 >= 4) {
                i7 = i19;
                break;
            } else {
                if (iArr2[i7] >= this.f7328m) {
                    break;
                }
                if (iArr2[i7] > i18) {
                    i18 = iArr2[i7];
                    i19 = i7;
                }
                i7++;
            }
        }
        if (i7 == 0) {
            float f4 = i16;
            float f5 = this.f7334t;
            if (f4 >= f5) {
                if (width - i16 < f5) {
                }
            }
            i11 = 7;
        } else if (i7 != 1) {
            if (i7 == 2) {
                float f6 = i17;
                float f7 = this.f7334t;
                if (f6 >= f7) {
                    if (height - i17 < f7) {
                        i11 = 5;
                    }
                }
            } else if (i7 == 3) {
                float f8 = i17;
                float f9 = this.f7334t;
                if (f8 >= f9) {
                    if (height - i17 < f9) {
                        i11 = 7;
                    }
                }
            }
        } else {
            float f10 = i16;
            float f11 = this.f7334t;
            if (f10 >= f11) {
                i11 = ((float) (width - i16)) < f11 ? 6 : i7;
            }
        }
        this.f7335v = i11;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int i2 = this.f7329n;
        Rect rect = new Rect(i2, this.f7330o, this.f7324i.getWidth() + i2, this.f7324i.getHeight() + this.f7330o);
        if (motionEvent.getAction() != 0 || !rect.contains(x2, y2)) {
            throw null;
        }
        this.f7324i.callOnClick();
        return true;
    }
}
