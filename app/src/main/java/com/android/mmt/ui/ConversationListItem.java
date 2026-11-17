package com.android.mmt.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.mmt.R;
import com.android.mmt.ui.C0269z;
import com.android.mmt.util.C0279k;
import x0.C0414a;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class ConversationListItem extends ConstraintLayout implements C0414a.c, S0.b {

    /* renamed from: h0, reason: collision with root package name */
    private static Rect f4717h0 = new Rect();

    /* renamed from: A, reason: collision with root package name */
    private LinearLayout f4718A;

    /* renamed from: B, reason: collision with root package name */
    private ImageView f4719B;

    /* renamed from: C, reason: collision with root package name */
    private ImageView f4720C;

    /* renamed from: D, reason: collision with root package name */
    private ImageView f4721D;

    /* renamed from: E, reason: collision with root package name */
    private CheckBox f4722E;

    /* renamed from: F, reason: collision with root package name */
    private ImageView f4723F;

    /* renamed from: G, reason: collision with root package name */
    private ImageView f4724G;

    /* renamed from: H, reason: collision with root package name */
    private Drawable f4725H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f4726I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f4727J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f4728K;
    private boolean L;
    private View.OnTouchListener M;

    /* renamed from: N, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f4729N;

    /* renamed from: O, reason: collision with root package name */
    private Scroller f4730O;
    private Context P;

    /* renamed from: Q, reason: collision with root package name */
    private C0416c f4731Q;

    /* renamed from: R, reason: collision with root package name */
    private char[] f4732R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f4733S;

    /* renamed from: T, reason: collision with root package name */
    private int f4734T;

    /* renamed from: U, reason: collision with root package name */
    private int f4735U;

    /* renamed from: V, reason: collision with root package name */
    private int f4736V;

    /* renamed from: W, reason: collision with root package name */
    private int f4737W;

    /* renamed from: a0, reason: collision with root package name */
    private int f4738a0;

    /* renamed from: b0, reason: collision with root package name */
    private Rect f4739b0;

    /* renamed from: c0, reason: collision with root package name */
    private Paint f4740c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f4741d0;

    /* renamed from: e0, reason: collision with root package name */
    private C0279k.c f4742e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f4743f0;

    /* renamed from: g0, reason: collision with root package name */
    private Runnable f4744g0;

    /* renamed from: x, reason: collision with root package name */
    private TextView f4745x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f4746y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f4747z;

    final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (!ConversationListItem.this.L || !ConversationListItem.m(ConversationListItem.this, motionEvent)) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                ConversationListItem.this.f4736V = view.getContext().getResources().getColor(R.color.drag_background_color_right_p);
                ConversationListItem.this.invalidate();
                return true;
            }
            if (ConversationListItem.this.f4736V != view.getContext().getResources().getColor(R.color.drag_background_color_right)) {
                ConversationListItem.this.f4736V = view.getContext().getResources().getColor(R.color.drag_background_color_right);
                ConversationListItem.this.invalidate();
            }
            if (motionEvent.getAction() == 1) {
                ConversationListItem conversationListItem = ConversationListItem.this;
                conversationListItem.z(conversationListItem.f4731Q.I());
            }
            return true;
        }
    }

    final class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            ConversationListItem.this.setActivated(z4);
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConversationListItem.this.G();
        }
    }

    public ConversationListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4728K = false;
        this.L = false;
        this.f4732R = new char[64];
        this.f4734T = 0;
        this.f4744g0 = new c();
        this.P = context;
        this.f4730O = new Scroller(context);
        this.f4725H = context.getResources().getDrawable(R.drawable.unread);
        this.f4738a0 = context.getResources().getDimensionPixelSize(R.dimen.conversation_list_item_drag_text_size);
        this.f4735U = context.getResources().getColor(R.color.drag_background_color);
        this.f4736V = context.getResources().getColor(R.color.drag_background_color_right);
        this.f4737W = context.getResources().getColor(R.color.drag_text_color);
        this.f4741d0 = (int) context.getResources().getDimension(R.dimen.multi_checkbox_size);
        Drawable background = getBackground();
        if (background != null) {
            background.getPadding(f4717h0);
        }
        this.M = new a();
        this.f4729N = new b();
    }

    private void B(boolean z4, float f4) throws Resources.NotFoundException {
        if (z4) {
            if (this.f4727J) {
                this.f4722E.setAlpha(f4);
                float f5 = (0.2f * f4) + 0.8f;
                this.f4722E.setScaleX(f5);
                this.f4722E.setScaleY(f5);
                this.f4722E.setVisibility(0);
            } else {
                this.f4722E.setVisibility(8);
                if (this.f4723F.getVisibility() == 0) {
                    ConstraintLayout.a aVar = (ConstraintLayout.a) this.f4723F.getLayoutParams();
                    aVar.setMarginEnd((int) (this.f4741d0 * f4));
                    this.f4723F.setLayoutParams(aVar);
                }
            }
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f4743f0.getLayoutParams();
            aVar2.setMarginEnd((int) (this.f4741d0 * f4));
            this.f4743f0.setLayoutParams(aVar2);
            if (this.f4724G.getVisibility() == 0) {
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.conversation_media_tag_margin);
                ConstraintLayout.a aVar3 = (ConstraintLayout.a) this.f4724G.getLayoutParams();
                aVar3.setMarginEnd((int) (dimensionPixelSize * f4));
                this.f4724G.setLayoutParams(aVar3);
                return;
            }
            return;
        }
        if (this.f4727J) {
            this.f4722E.setAlpha(1.0f - f4);
            float f6 = 1.0f - (0.2f * f4);
            this.f4722E.setScaleX(f6);
            this.f4722E.setScaleY(f6);
            this.f4722E.setVisibility(0);
        } else {
            this.f4722E.setVisibility(8);
            if (this.f4723F.getVisibility() == 0) {
                ConstraintLayout.a aVar4 = (ConstraintLayout.a) this.f4723F.getLayoutParams();
                aVar4.setMarginEnd((int) ((1.0f - f4) * this.f4741d0));
                this.f4723F.setLayoutParams(aVar4);
            }
        }
        ConstraintLayout.a aVar5 = (ConstraintLayout.a) this.f4743f0.getLayoutParams();
        float f7 = 1.0f - f4;
        aVar5.setMarginEnd((int) (this.f4741d0 * f7));
        this.f4743f0.setLayoutParams(aVar5);
        if (this.f4724G.getVisibility() == 0) {
            int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.conversation_media_tag_margin);
            ConstraintLayout.a aVar6 = (ConstraintLayout.a) this.f4724G.getLayoutParams();
            aVar6.setMarginEnd((int) (dimensionPixelSize2 * f7));
            this.f4724G.setLayoutParams(aVar6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.f4733S) {
            this.f4745x.setText(R.string.sp_conversation_title);
        } else if (w()) {
            this.f4745x.setText(R.string.block_messaging_entry_title);
        } else {
            this.f4745x.setText(this.f4732R, 0, this.f4731Q.G().g(this.f4732R));
        }
    }

    static boolean m(ConversationListItem conversationListItem, MotionEvent motionEvent) {
        if (conversationListItem.getLayoutDirection() == 1) {
            if (motionEvent.getX() >= conversationListItem.u()) {
                return false;
            }
        } else if (motionEvent.getX() <= conversationListItem.getWidth() - ((int) conversationListItem.u())) {
            return false;
        }
        return true;
    }

    private void s(int i2) {
        Log.v("ConversationListItem", "close menu" + i2);
        this.L = false;
        this.f4730O.startScroll(i2, 0, 0 - i2, 0);
        invalidate();
    }

    private float u() {
        return getContext().getResources().getDimension(R.dimen.list_item_right_menu_width);
    }

    private void v() {
        ViewStub viewStub;
        if (this.f4722E != null || (viewStub = (ViewStub) findViewById(android.R.id.checkbox)) == null) {
            return;
        }
        this.f4722E = (CheckBox) viewStub.inflate();
    }

    private boolean x() {
        return this.f4734T > 0;
    }

    public final void A() {
        if (this.L) {
            s(this.f4730O.getCurrX());
        } else {
            int currX = this.f4730O.getCurrX();
            this.f4730O.startScroll(currX, 0, -currX, 0, 10);
            invalidate();
        }
        this.L = false;
    }

    public final void C() {
        this.f4733S = false;
    }

    public final void D(C0279k.c cVar) {
        this.f4742e0 = cVar;
    }

    public final void E(int i2) {
        this.f4734T = i2;
    }

    public final void F() {
        this.f4730O.setFinalX(0);
        this.f4733S = false;
        this.f4734T = 0;
        C0414a.n0(this);
        S2.e.a().removeCallbacks(this.f4744g0);
    }

    public final boolean H() {
        C0416c c0416c = this.f4731Q;
        if (c0416c == null || !c0416c.F() || !this.f4726I) {
            return false;
        }
        this.f4726I = false;
        return true;
    }

    public final boolean I(int i2) {
        boolean z4 = this.f4726I;
        boolean z5 = i2 > 0;
        this.f4726I = z5;
        return z5 != z4;
    }

    @Override // S0.b
    public final void a(boolean z4) {
        v();
        if (z4) {
            return;
        }
        this.f4722E.setVisibility(8);
    }

    @Override // S0.b
    public final void b(boolean z4) throws Resources.NotFoundException {
        v();
        B(z4, 0.0f);
    }

    @Override // S0.b
    public final void c(boolean z4, float f4) throws Resources.NotFoundException {
        v();
        B(z4, f4);
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (!this.f4730O.computeScrollOffset() || getScrollX() == this.f4730O.getCurrX()) {
            return;
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int currX = this.f4730O.getCurrX();
        boolean z4 = getLayoutDirection() == 1;
        if (currX > 0) {
            canvas.save();
            int width = getWidth();
            int height = getHeight();
            canvas.clipRect(z4 ? width - currX : 0, 0, z4 ? width + 0 : currX, height);
            int i2 = (int) (width * 0.33f);
            Rect rect = this.f4739b0;
            if (rect == null) {
                this.f4739b0 = new Rect(z4 ? width - i2 : 0, 0, z4 ? width + 0 : width, height);
            } else {
                rect.set(z4 ? width - i2 : 0, 0, z4 ? width + 0 : width, height);
            }
            Paint paint = this.f4740c0;
            if (paint == null) {
                this.f4740c0 = new Paint(1);
            } else {
                paint.setFlags(1);
            }
            this.f4740c0.setTextSize(this.f4738a0);
            this.f4740c0.setColor(this.f4735U);
            canvas.drawRect(this.f4739b0, this.f4740c0);
            this.f4740c0.setColor(this.f4737W);
            Paint.FontMetrics fontMetrics = this.f4740c0.getFontMetrics();
            float f4 = fontMetrics.bottom;
            float f5 = height;
            float f6 = (f5 - ((f5 - (f4 - fontMetrics.top)) / 2.0f)) - f4;
            int iMeasureText = (int) this.f4740c0.measureText(this.P.getString(R.string.message_readed));
            String string = this.P.getString(R.string.message_readed);
            int i4 = width / 12;
            int i5 = iMeasureText + i4;
            if (z4) {
                i4 = width - i5;
            }
            canvas.drawText(string, i4, f6, this.f4740c0);
            canvas.restore();
            if (z4) {
                currX = -currX;
            }
            canvas.translate(currX, 0.0f);
        } else {
            canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int i6 = width2 + currX;
            canvas.clipRect(z4 ? width2 - width2 : i6, 0, z4 ? width2 - i6 : width2, height2);
            int iU = width2 - ((int) u());
            Rect rect2 = new Rect(z4 ? width2 - width2 : iU, 0, z4 ? width2 - iU : width2, height2);
            Paint paint2 = new Paint(1);
            paint2.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.delete_menu_text_size));
            paint2.setColor(this.f4736V);
            canvas.drawRect(rect2, paint2);
            paint2.setColor(this.f4737W);
            Paint.FontMetrics fontMetrics2 = paint2.getFontMetrics();
            float f7 = fontMetrics2.bottom;
            float f8 = height2;
            float f9 = (f8 - ((f8 - (f7 - fontMetrics2.top)) / 2.0f)) - f7;
            int iMeasureText2 = (int) paint2.measureText(this.P.getString(R.string.delete_message));
            int iU2 = width2 - (((int) (u() + iMeasureText2)) / 2);
            int i7 = iMeasureText2 + iU2;
            String string2 = this.P.getString(R.string.delete_message);
            if (z4) {
                iU2 = width2 - i7;
            }
            canvas.drawText(string2, iU2, f9, paint2);
            canvas.restore();
            if (z4) {
                currX = -currX;
            }
            canvas.translate(currX, 0.0f);
        }
        super.onDraw(canvas);
        if (this.f4726I) {
            this.f4725H.draw(canvas);
        }
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.f4745x = (TextView) findViewById(R.id.from);
        this.f4746y = (TextView) findViewById(R.id.subject);
        this.f4747z = (TextView) findViewById(R.id.date);
        this.f4723F = (ImageView) findViewById(R.id.arrow);
        this.f4743f0 = findViewById(R.id.end_holder);
        this.f4724G = (ImageView) findViewById(R.id.mediaTag);
        setOnTouchListener(this.M);
        if (com.android.mmt.util.e0.f()) {
            androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
            bVar.d(this);
            int[] iArr = {R.id.date, R.id.sim_indicator, R.id.indicator_container};
            for (int i2 = 0; i2 < 3; i2++) {
                bVar.c(iArr[i2]);
                if (i2 > 0) {
                    bVar.g(iArr[i2], 6, iArr[i2 - 1], 7);
                }
            }
            bVar.g(R.id.date, 6, R.id.subject, 6);
            bVar.g(R.id.avatar, 4, R.id.date, 4);
            bVar.g(R.id.msg_count, 7, R.id.checkbox_container, 6);
            bVar.f(R.id.date, 3, R.id.subject, 4);
            bVar.f(R.id.date, 4, 0, 4);
            bVar.f(R.id.subject, 4, R.id.date, 3);
            bVar.f(0, 3, R.id.date, 4);
            bVar.l();
            bVar.a(this);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        boolean z5 = getLayoutDirection() == 1;
        Rect rect = f4717h0;
        int i7 = z5 ? rect.right : rect.left;
        int i8 = f4717h0.top;
        if (this.f4726I) {
            int intrinsicHeight = this.f4725H.getIntrinsicHeight();
            int intrinsicWidth = this.f4725H.getIntrinsicWidth();
            int i9 = ((i6 - i4) - intrinsicHeight) / 2;
            int bottom = (((this.f4745x.getBottom() + this.f4745x.getTop()) - intrinsicHeight) / 2) + i8;
            Drawable drawable = this.f4725H;
            int i10 = ((i7 - intrinsicWidth) / 2) + i2;
            int i11 = ((i7 + intrinsicWidth) / 2) + i2;
            int i12 = intrinsicHeight + bottom;
            int i13 = z5 ? i5 - i11 : i10;
            if (z5) {
                i11 = i5 - i10;
            }
            drawable.setBounds(i13, bottom, i11, i12);
        }
    }

    public final void r(C0416c c0416c, boolean z4, boolean z5, int i2, int i4) throws Resources.NotFoundException {
        boolean z6;
        C0416c c0416c2;
        ViewStub viewStub;
        this.f4731Q = c0416c;
        this.f4730O.setFinalX(0);
        this.f4727J = (x() || this.f4733S) ? false : true;
        boolean z7 = (!z4 || x() || this.f4733S) ? false : true;
        if (z4 && this.f4722E == null && (viewStub = (ViewStub) findViewById(android.R.id.checkbox)) != null) {
            CheckBox checkBox = (CheckBox) viewStub.inflate();
            this.f4722E = checkBox;
            checkBox.setVisibility(8);
        }
        CheckBox checkBox2 = this.f4722E;
        if (checkBox2 != null) {
            if (!this.f4727J) {
                checkBox2.setVisibility(8);
            }
            this.f4722E.setEnabled(z7);
            this.f4722E.setChecked(c0416c.O());
            setActivated(z7 && c0416c.O());
            if (z7) {
                this.f4722E.setOnCheckedChangeListener(this.f4729N);
            }
        }
        if ((x() || this.f4733S) && !com.android.mmt.util.e0.f()) {
            this.f4747z.setVisibility(8);
        } else {
            this.f4747z.setVisibility(0);
            this.f4747z.setText(this.f4731Q.A());
        }
        String strW = c0416c.G().size() == 1 ? c0416c.G().get(0).W() : null;
        if (C0414a.T() != 2) {
            z6 = true;
        } else {
            if (!TextUtils.isEmpty(strW) && (c0416c2 = this.f4731Q) != null) {
                synchronized (c0416c2) {
                }
            }
            z6 = false;
        }
        if (z6) {
            this.f4731Q.Q(false, true);
        }
        if (x() || this.f4733S) {
            this.f4723F.setVisibility(0);
        } else {
            this.f4723F.setVisibility(8);
        }
        G();
        C0414a.J(this, strW);
        String strH = c0416c.H();
        if (w()) {
            strH = c0416c.G().h(",") + ":" + strH;
        }
        if (this.f4733S) {
            I(i2);
        } else if (w()) {
            I(i4);
        } else {
            this.f4726I = false;
        }
        this.f4746y.setText(strH);
        boolean z8 = this.f4733S;
        boolean zK = c0416c.K();
        boolean zL = c0416c.L();
        boolean zM = c0416c.M();
        if (zK || zL || zM) {
            if (this.f4718A == null) {
                ViewStub viewStub2 = (ViewStub) findViewById(R.id.indicator_container);
                if (viewStub2 != null) {
                    viewStub2.inflate();
                }
                this.f4718A = (LinearLayout) findViewById(R.id.indicator_container);
            }
            this.f4718A.removeAllViews();
            if (zK && !z8) {
                if (this.f4719B == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(this.P).inflate(R.layout.conversation_list_item_indicator, (ViewGroup) this.f4718A, false);
                    this.f4719B = imageView;
                    imageView.setContentDescription(this.P.getString(R.string.type_attachment));
                    this.f4719B.setImageResource(R.drawable.conversation_attachment_indicator);
                }
                this.f4718A.addView(this.f4719B);
            }
            if (zL && !z8) {
                if (this.f4720C == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(this.P).inflate(R.layout.conversation_list_item_indicator, (ViewGroup) this.f4718A, false);
                    this.f4720C = imageView2;
                    imageView2.setContentDescription(this.P.getString(R.string.draft));
                    this.f4720C.setImageResource(R.drawable.conversation_draft_indicator);
                }
                this.f4718A.addView(this.f4720C);
            }
            if (zM && !z8) {
                if (this.f4721D == null) {
                    ImageView imageView3 = (ImageView) LayoutInflater.from(this.P).inflate(R.layout.conversation_list_item_indicator, (ViewGroup) this.f4718A, false);
                    this.f4721D = imageView3;
                    imageView3.setContentDescription(this.P.getString(R.string.failed_to_send));
                    this.f4721D.setImageResource(R.drawable.conversation_error_indicator);
                }
                this.f4718A.addView(this.f4721D);
            }
        } else {
            LinearLayout linearLayout = this.f4718A;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
        }
        if (z5 || !z7) {
            return;
        }
        B(true, 1.0f);
    }

    @Override // x0.C0414a.c
    public final void t(C0414a c0414a) {
        C0416c c0416c;
        C0415b c0415bG;
        if (c0414a == null || (c0416c = this.f4731Q) == null || (c0415bG = c0416c.G()) == null || !c0415bG.contains(c0414a)) {
            return;
        }
        S2.e.a().removeCallbacks(this.f4744g0);
        S2.e.a().post(this.f4744g0);
    }

    public final boolean w() {
        int i2 = this.f4734T;
        Uri uri = C0416c.f8050r;
        return (i2 & 1) == 1;
    }

    public final boolean y() {
        return this.f4733S;
    }

    public final void z(long j2) {
        C0279k.c cVar = this.f4742e0;
        if (cVar != null) {
            C0269z.e eVar = (C0269z.e) cVar;
            Log.v("ConversationFragment", " on menu item click" + j2);
            if (j2 > 0) {
                C0269z.B1(j2, C0269z.this.f5798k0);
            }
        }
        A();
    }
}
