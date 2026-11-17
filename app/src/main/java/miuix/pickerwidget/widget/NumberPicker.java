package miuix.pickerwidget.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.C0188i;
import androidx.appcompat.widget.Y;
import com.android.mmt.R;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import miuix.view.HapticCompat;
import q.C0366b;
import t.C0384b;

/* loaded from: classes.dex */
public class NumberPicker extends LinearLayout {

    /* renamed from: D0, reason: collision with root package name */
    private static final AtomicInteger f7197D0 = new AtomicInteger(0);

    /* renamed from: E0, reason: collision with root package name */
    static final c f7198E0 = new e();

    /* renamed from: F0, reason: collision with root package name */
    private static final char[] f7199F0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: A, reason: collision with root package name */
    private c f7200A;

    /* renamed from: A0, reason: collision with root package name */
    private String f7201A0;

    /* renamed from: B, reason: collision with root package name */
    private long f7202B;

    /* renamed from: B0, reason: collision with root package name */
    private String f7203B0;

    /* renamed from: C, reason: collision with root package name */
    private final SparseArray<String> f7204C;

    /* renamed from: C0, reason: collision with root package name */
    private boolean f7205C0;

    /* renamed from: D, reason: collision with root package name */
    private final int[] f7206D;

    /* renamed from: E, reason: collision with root package name */
    private final Paint f7207E;

    /* renamed from: F, reason: collision with root package name */
    private int f7208F;

    /* renamed from: G, reason: collision with root package name */
    private int f7209G;

    /* renamed from: H, reason: collision with root package name */
    private int f7210H;

    /* renamed from: I, reason: collision with root package name */
    private final Scroller f7211I;

    /* renamed from: J, reason: collision with root package name */
    private final Scroller f7212J;

    /* renamed from: K, reason: collision with root package name */
    private int f7213K;
    private h L;
    private b M;

    /* renamed from: N, reason: collision with root package name */
    private a f7214N;

    /* renamed from: O, reason: collision with root package name */
    private float f7215O;
    private long P;

    /* renamed from: Q, reason: collision with root package name */
    private float f7216Q;

    /* renamed from: R, reason: collision with root package name */
    private VelocityTracker f7217R;

    /* renamed from: S, reason: collision with root package name */
    private int f7218S;

    /* renamed from: T, reason: collision with root package name */
    private int f7219T;

    /* renamed from: U, reason: collision with root package name */
    private int f7220U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f7221V;

    /* renamed from: W, reason: collision with root package name */
    private final boolean f7222W;

    /* renamed from: a0, reason: collision with root package name */
    private final int f7223a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f7224b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f7225c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f7226d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f7227e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f7228f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f7229g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f7230h0;

    /* renamed from: i, reason: collision with root package name */
    private final int f7231i;

    /* renamed from: i0, reason: collision with root package name */
    private final g f7232i0;

    /* renamed from: j, reason: collision with root package name */
    private int f7233j;

    /* renamed from: j0, reason: collision with root package name */
    private int f7234j0;

    /* renamed from: k, reason: collision with root package name */
    private int f7235k;

    /* renamed from: k0, reason: collision with root package name */
    private Paint f7236k0;

    /* renamed from: l, reason: collision with root package name */
    private i f7237l;

    /* renamed from: l0, reason: collision with root package name */
    private int f7238l0;

    /* renamed from: m, reason: collision with root package name */
    private final EditText f7239m;

    /* renamed from: m0, reason: collision with root package name */
    private float f7240m0;

    /* renamed from: n, reason: collision with root package name */
    private final int f7241n;

    /* renamed from: n0, reason: collision with root package name */
    private int f7242n0;

    /* renamed from: o, reason: collision with root package name */
    private final int f7243o;

    /* renamed from: o0, reason: collision with root package name */
    private int f7244o0;
    private final int p;
    private float p0;

    /* renamed from: q, reason: collision with root package name */
    private final int f7245q;
    private float q0;

    /* renamed from: r, reason: collision with root package name */
    private int f7246r;

    /* renamed from: r0, reason: collision with root package name */
    private int f7247r0;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f7248s;

    /* renamed from: s0, reason: collision with root package name */
    private int f7249s0;

    /* renamed from: t, reason: collision with root package name */
    private final int f7250t;

    /* renamed from: t0, reason: collision with root package name */
    private float f7251t0;
    private int u;

    /* renamed from: u0, reason: collision with root package name */
    private float f7252u0;

    /* renamed from: v, reason: collision with root package name */
    private String[] f7253v;

    /* renamed from: v0, reason: collision with root package name */
    private int f7254v0;

    /* renamed from: w, reason: collision with root package name */
    private int f7255w;

    /* renamed from: w0, reason: collision with root package name */
    private int f7256w0;

    /* renamed from: x, reason: collision with root package name */
    private int f7257x;

    /* renamed from: x0, reason: collision with root package name */
    private int f7258x0;

    /* renamed from: y, reason: collision with root package name */
    private int f7259y;

    /* renamed from: y0, reason: collision with root package name */
    private CharSequence f7260y0;

    /* renamed from: z, reason: collision with root package name */
    private f f7261z;

    /* renamed from: z0, reason: collision with root package name */
    private float f7262z0;

    public static class CustomEditText extends C0188i {
        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.TextView
        public final void onEditorAction(int i2) {
            super.onEditorAction(i2);
            if (i2 == 6) {
                clearFocus();
            }
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NumberPicker.this.f7225c0 = true;
        }
    }

    class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private boolean f7264i;

        b() {
        }

        static void a(b bVar, boolean z4) {
            bVar.f7264i = z4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NumberPicker.this.s(this.f7264i);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed(this, numberPicker.f7202B);
        }
    }

    public interface c {
    }

    class d extends NumberKeyListener {
        d() {
        }

        @Override // android.text.method.NumberKeyListener, android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i2, int i4, Spanned spanned, int i5, int i6) {
            if (NumberPicker.this.f7253v == null) {
                CharSequence charSequenceFilter = super.filter(charSequence, i2, i4, spanned, i5, i6);
                if (charSequenceFilter == null) {
                    charSequenceFilter = charSequence.subSequence(i2, i4);
                }
                String str = String.valueOf(spanned.subSequence(0, i5)) + ((Object) charSequenceFilter) + ((Object) spanned.subSequence(i6, spanned.length()));
                return "".equals(str) ? str : (NumberPicker.this.B(str) > NumberPicker.this.f7257x || str.length() > String.valueOf(NumberPicker.this.f7257x).length()) ? "" : charSequenceFilter;
            }
            String strValueOf = String.valueOf(charSequence.subSequence(i2, i4));
            if (TextUtils.isEmpty(strValueOf)) {
                return "";
            }
            String str2 = String.valueOf(spanned.subSequence(0, i5)) + ((Object) strValueOf) + ((Object) spanned.subSequence(i6, spanned.length()));
            String lowerCase = String.valueOf(str2).toLowerCase();
            for (String str3 : NumberPicker.this.f7253v) {
                if (str3.toLowerCase().startsWith(lowerCase)) {
                    NumberPicker.b(NumberPicker.this, str2.length(), str3.length());
                    return str3.subSequence(i5, str3.length());
                }
            }
            return "";
        }

        @Override // android.text.method.NumberKeyListener
        protected final char[] getAcceptedChars() {
            return NumberPicker.f7199F0;
        }

        @Override // android.text.method.KeyListener
        public final int getInputType() {
            return 1;
        }
    }

    static class e implements c {
    }

    public interface f {
        void a(NumberPicker numberPicker, int i2, int i4);
    }

    class g implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private int f7267i;

        /* renamed from: j, reason: collision with root package name */
        private int f7268j;

        g() {
        }

        public final void a(int i2) {
            c();
            this.f7268j = 1;
            this.f7267i = i2;
            NumberPicker.this.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        public final void b(int i2) {
            c();
            this.f7268j = 2;
            this.f7267i = i2;
            NumberPicker.this.post(this);
        }

        public final void c() {
            this.f7268j = 0;
            this.f7267i = 0;
            NumberPicker.this.removeCallbacks(this);
            if (NumberPicker.this.f7229g0) {
                NumberPicker.this.f7229g0 = false;
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.invalidate(0, numberPicker.f7228f0, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
            }
            if (NumberPicker.this.f7230h0) {
                NumberPicker.this.f7230h0 = false;
                NumberPicker numberPicker2 = NumberPicker.this;
                numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.f7227e0);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2 = this.f7268j;
            if (i2 == 1) {
                int i4 = this.f7267i;
                if (i4 == 1) {
                    NumberPicker.this.f7229g0 = true;
                    NumberPicker numberPicker = NumberPicker.this;
                    numberPicker.invalidate(0, numberPicker.f7228f0, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                    return;
                } else {
                    if (i4 != 2) {
                        return;
                    }
                    NumberPicker.this.f7230h0 = true;
                    NumberPicker numberPicker2 = NumberPicker.this;
                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.f7227e0);
                    return;
                }
            }
            if (i2 != 2) {
                return;
            }
            int i5 = this.f7267i;
            if (i5 == 1) {
                if (!NumberPicker.this.f7229g0) {
                    NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                NumberPicker.e(NumberPicker.this);
                NumberPicker numberPicker3 = NumberPicker.this;
                numberPicker3.invalidate(0, numberPicker3.f7228f0, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                return;
            }
            if (i5 != 2) {
                return;
            }
            if (!NumberPicker.this.f7230h0) {
                NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
            }
            NumberPicker.i(NumberPicker.this);
            NumberPicker numberPicker4 = NumberPicker.this;
            numberPicker4.invalidate(0, 0, numberPicker4.getRight(), NumberPicker.this.f7227e0);
        }
    }

    class h implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private int f7270i;

        /* renamed from: j, reason: collision with root package name */
        private int f7271j;

        h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f7271j < NumberPicker.this.f7239m.length()) {
                NumberPicker.this.f7239m.setSelection(this.f7270i, this.f7271j);
            }
        }
    }

    private static class i extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7273a = new a();

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            private Set<Integer> f7274a = new C0366b(0);

            /* renamed from: b, reason: collision with root package name */
            private SoundPool f7275b;

            /* renamed from: c, reason: collision with root package name */
            private int f7276c;
            private long d;

            a() {
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set<java.lang.Integer>, q.b] */
            final void a(Context context, int i2) {
                if (this.f7275b == null) {
                    SoundPool soundPool = new SoundPool(1, 1, 0);
                    this.f7275b = soundPool;
                    this.f7276c = soundPool.load(context, R.raw.number_picker_value_change, 1);
                }
                this.f7274a.add(Integer.valueOf(i2));
            }

            final void b() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                SoundPool soundPool = this.f7275b;
                if (soundPool == null || jCurrentTimeMillis - this.d <= 50) {
                    return;
                }
                soundPool.play(this.f7276c, 1.0f, 1.0f, 0, 0, 1.0f);
                this.d = jCurrentTimeMillis;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set<java.lang.Integer>, q.b] */
            /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Set<java.lang.Integer>, q.b] */
            final void c(int i2) {
                SoundPool soundPool;
                if (this.f7274a.remove(Integer.valueOf(i2)) && this.f7274a.isEmpty() && (soundPool = this.f7275b) != null) {
                    soundPool.release();
                    this.f7275b = null;
                }
            }
        }

        i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 0) {
                f7273a.a((Context) message.obj, message.arg1);
            } else if (i2 == 1) {
                f7273a.b();
            } else {
                if (i2 != 2) {
                    return;
                }
                f7273a.c(message.arg1);
            }
        }
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.numberPickerStyle);
        this.f7231i = f7197D0.incrementAndGet();
        this.f7233j = 1;
        this.f7235k = 2;
        this.f7246r = SearchActionModeView.ANIMATION_DURATION;
        this.f7202B = 300L;
        this.f7204C = new SparseArray<>();
        this.f7206D = new int[3];
        this.f7209G = Integer.MIN_VALUE;
        this.f7224b0 = 0;
        this.f7234j0 = -1;
        this.q0 = 0.95f;
        this.f7252u0 = 0.8f;
        this.f7262z0 = 1.0f;
        this.f7205C0 = true;
        float f4 = getResources().getDisplayMetrics().density;
        this.f7233j = getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_margin_left);
        this.f7235k = getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_margin_top);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0384b.f7874c, R.attr.numberPickerStyle, R.style.Widget_NumberPicker_DayNight);
        this.f7260y0 = typedArrayObtainStyledAttributes.getText(3);
        this.f7242n0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_text_size_highlight_normal));
        this.f7244o0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_text_size_hint_normal));
        this.f7247r0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_text_size));
        this.f7254v0 = typedArrayObtainStyledAttributes.getColor(0, resources.getColor(R.color.miuix_appcompat_number_picker_highlight_color));
        this.f7256w0 = typedArrayObtainStyledAttributes.getColor(1, resources.getColor(R.color.miuix_appcompat_number_picker_hint_color));
        this.f7258x0 = typedArrayObtainStyledAttributes.getColor(6, resources.getColor(R.color.miuix_appcompat_number_picker_label_color));
        this.f7238l0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelOffset(R.dimen.miuix_appcompat_number_picker_label_padding));
        typedArrayObtainStyledAttributes.recycle();
        this.f7249s0 = this.f7247r0;
        E();
        this.f7222W = true;
        this.f7223a0 = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.f7241n = (int) (45.0f * f4);
        this.f7243o = -1;
        this.p = (int) (f4 * 202.0f);
        this.f7245q = -1;
        this.f7246r = -1;
        this.f7248s = true;
        this.f7232i0 = new g();
        setWillNotDraw(false);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.miuix_appcompat_number_picker_layout, (ViewGroup) this, true);
        EditText editText = (EditText) findViewById(R.id.number_picker_input);
        this.f7239m = editText;
        editText.setOnFocusChangeListener(new miuix.pickerwidget.widget.b(this));
        editText.setFilters(new InputFilter[]{new d()});
        editText.setRawInputType(2);
        editText.setImeOptions(6);
        editText.setVisibility(4);
        editText.setGravity(8388611);
        editText.setScaleX(0.0f);
        editText.setSaveEnabled(false);
        editText.setPadding(this.f7238l0, editText.getPaddingTop(), this.f7238l0, editText.getPaddingRight());
        F();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7218S = viewConfiguration.getScaledTouchSlop();
        this.f7219T = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7220U = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        this.f7250t = (int) editText.getTextSize();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(this.f7242n0);
        paint.setTypeface(editText.getTypeface());
        paint.setColor(editText.getTextColors().getColorForState(LinearLayout.ENABLED_STATE_SET, -1));
        this.f7207E = paint;
        Paint paint2 = new Paint();
        this.f7236k0 = paint2;
        paint2.setAntiAlias(true);
        this.f7236k0.setFakeBoldText(true);
        this.f7236k0.setColor(this.f7258x0);
        this.f7236k0.setTextSize(this.f7247r0);
        this.f7211I = new Scroller(getContext(), null, true);
        this.f7212J = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        Y();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setOnTouchListener(new miuix.pickerwidget.widget.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B(String str) {
        try {
            if (this.f7253v == null) {
                return Integer.parseInt(str);
            }
            for (int i2 = 0; i2 < this.f7253v.length; i2++) {
                str = str.toLowerCase();
                if (this.f7253v[i2].toLowerCase().startsWith(str)) {
                    return this.f7255w + i2;
                }
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return this.f7255w;
        }
    }

    private int D(int i2) {
        int i4 = this.f7257x;
        if (i2 > i4) {
            int i5 = this.f7255w;
            return (((i2 - i4) % (i4 - i5)) + i5) - 1;
        }
        int i6 = this.f7255w;
        return i2 < i6 ? (i4 - ((i6 - i2) % (i4 - i6))) + 1 : i2;
    }

    private void E() {
        if (this.f7237l == null) {
            i iVar = new i(E3.a.a());
            this.f7237l = iVar;
            Context applicationContext = getContext().getApplicationContext();
            Message messageObtainMessage = iVar.obtainMessage(0, this.f7231i, 0);
            messageObtainMessage.obj = applicationContext;
            iVar.sendMessage(messageObtainMessage);
        }
    }

    private void F() {
        this.f7251t0 = getContext().getResources().getDimensionPixelSize(R.dimen.miuix_label_text_size_small);
        this.p0 = getContext().getResources().getDimensionPixelSize(R.dimen.miuix_text_size_small);
    }

    private void G() {
        this.f7204C.clear();
        int[] iArr = this.f7206D;
        int i2 = this.f7259y;
        for (int i4 = 0; i4 < this.f7206D.length; i4++) {
            int iD = (i4 - 1) + i2;
            if (this.f7221V) {
                iD = D(iD);
            }
            iArr[i4] = iD;
            t(iArr[i4]);
        }
    }

    private boolean H() {
        if (this.f7203B0 == null) {
            this.f7203B0 = (String) S2.d.a(S2.d.f(), "get", new Class[]{String.class, String.class}, "ro.product.mod_device", "");
        }
        return this.f7203B0.endsWith("_global");
    }

    private int I(int i2, int i4) {
        if (i4 == -1) {
            return i2;
        }
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i4), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        if (mode == 1073741824) {
            return i2;
        }
        throw new IllegalArgumentException(D2.e.b("Unknown measure mode: ", mode));
    }

    private boolean J(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i2 = this.f7209G - ((this.f7210H + finalY) % this.f7208F);
        if (i2 == 0) {
            return false;
        }
        int iAbs = Math.abs(i2);
        int i4 = this.f7208F;
        if (iAbs > i4 / 2) {
            i2 = i2 > 0 ? i2 - i4 : i2 + i4;
        }
        scrollBy(0, finalY + i2);
        return true;
    }

    private void K(int i2) {
        if (this.f7224b0 == i2) {
            return;
        }
        if (i2 == 0) {
            String str = this.f7201A0;
            if (str != null && !str.equals(this.f7239m.getText().toString())) {
                this.f7239m.setText(this.f7201A0);
            }
            this.f7201A0 = null;
            i iVar = this.f7237l;
            if (iVar != null) {
                iVar.removeMessages(1);
            }
        }
        this.f7224b0 = i2;
    }

    private void L(boolean z4, long j2) {
        b bVar = this.M;
        if (bVar == null) {
            this.M = new b();
        } else {
            removeCallbacks(bVar);
        }
        b.a(this.M, z4);
        postDelayed(this.M, j2);
    }

    private void M() {
        b bVar = this.M;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        h hVar = this.L;
        if (hVar != null) {
            removeCallbacks(hVar);
        }
        a aVar = this.f7214N;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        this.f7232i0.c();
    }

    private void V(int i2, boolean z4) {
        int iD = this.f7221V ? D(i2) : Math.min(Math.max(i2, this.f7255w), this.f7257x);
        int i4 = this.f7259y;
        if (i4 == iD) {
            return;
        }
        this.f7259y = iD;
        Y();
        if (z4) {
            sendAccessibilityEvent(4);
            i iVar = this.f7237l;
            if (iVar != null) {
                iVar.sendMessage(iVar.obtainMessage(1));
            }
            HapticCompat.performHapticFeedback(this, miuix.view.c.f7458h);
            f fVar = this.f7261z;
            if (fVar != null) {
                fVar.a(this, i4, this.f7259y);
            }
        }
        G();
        invalidate();
    }

    private void X() {
        if (this.f7248s) {
            float length = -1.0f;
            this.f7207E.setTextSize(this.f7242n0);
            String[] strArr = this.f7253v;
            int i2 = 0;
            if (strArr == null) {
                float f4 = 0.0f;
                while (i2 < 9) {
                    float fMeasureText = this.f7207E.measureText(String.valueOf(i2));
                    if (fMeasureText > f4) {
                        f4 = fMeasureText;
                    }
                    i2++;
                }
                length = (int) (v(this.f7257x).length() * f4);
            } else {
                int length2 = strArr.length;
                while (i2 < length2) {
                    float fMeasureText2 = this.f7207E.measureText(this.f7253v[i2]);
                    if (fMeasureText2 > length) {
                        length = fMeasureText2;
                    }
                    i2++;
                }
            }
            this.f7240m0 = length;
            float paddingRight = length + this.f7239m.getPaddingRight() + this.f7239m.getPaddingLeft() + getPaddingLeft() + getPaddingRight();
            if (this.f7246r != paddingRight) {
                int i4 = this.f7245q;
                if (paddingRight > i4) {
                    this.f7246r = (int) paddingRight;
                } else {
                    this.f7246r = i4;
                }
            }
        }
    }

    private boolean Y() {
        String[] strArr = this.f7253v;
        String strV = strArr == null ? v(this.f7259y) : strArr[this.f7259y - this.f7255w];
        if (TextUtils.isEmpty(strV)) {
            return false;
        }
        if (this.f7224b0 != 0) {
            this.f7201A0 = strV;
            return true;
        }
        if (strV.equals(this.f7239m.getText().toString())) {
            return true;
        }
        this.f7239m.setText(strV);
        return true;
    }

    static void b(NumberPicker numberPicker, int i2, int i4) {
        h hVar = numberPicker.L;
        if (hVar == null) {
            numberPicker.L = numberPicker.new h();
        } else {
            numberPicker.removeCallbacks(hVar);
        }
        numberPicker.L.f7270i = i2;
        numberPicker.L.f7271j = i4;
        numberPicker.post(numberPicker.L);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, byte] */
    static /* synthetic */ boolean e(NumberPicker numberPicker) {
        ?? r02 = (byte) (!numberPicker.f7229g0 ? 1 : 0);
        numberPicker.f7229g0 = r02;
        return r02;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, byte] */
    static /* synthetic */ boolean i(NumberPicker numberPicker) {
        ?? r02 = (byte) (!numberPicker.f7230h0 ? 1 : 0);
        numberPicker.f7230h0 = r02;
        return r02;
    }

    static void o(NumberPicker numberPicker, View view) {
        Objects.requireNonNull(numberPicker);
        String strValueOf = String.valueOf(((TextView) view).getText());
        if (TextUtils.isEmpty(strValueOf)) {
            numberPicker.Y();
        } else {
            numberPicker.V(numberPicker.B(strValueOf), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z4) {
        if (!this.f7222W) {
            if (z4) {
                V(this.f7259y + 1, true);
                return;
            } else {
                V(this.f7259y - 1, true);
                return;
            }
        }
        this.f7239m.setVisibility(4);
        if (!J(this.f7211I)) {
            J(this.f7212J);
        }
        this.f7213K = 0;
        if (z4) {
            this.f7211I.startScroll(0, 0, 0, -this.f7208F, 300);
        } else {
            this.f7211I.startScroll(0, 0, 0, this.f7208F, 300);
        }
        invalidate();
    }

    private void t(int i2) {
        String strV;
        SparseArray<String> sparseArray = this.f7204C;
        if (sparseArray.get(i2) != null) {
            return;
        }
        int i4 = this.f7255w;
        if (i2 < i4 || i2 > this.f7257x) {
            strV = "";
        } else {
            String[] strArr = this.f7253v;
            strV = strArr != null ? strArr[i2 - i4] : v(i2);
        }
        sparseArray.put(i2, strV);
    }

    private boolean u() {
        int i2 = this.f7209G - this.f7210H;
        if (i2 == 0) {
            return false;
        }
        this.f7213K = 0;
        int iAbs = Math.abs(i2);
        int i4 = this.f7208F;
        if (iAbs > i4 / 2) {
            if (i2 > 0) {
                i4 = -i4;
            }
            i2 += i4;
        }
        this.f7212J.startScroll(0, 0, 0, i2, 800);
        invalidate();
        return true;
    }

    private String v(int i2) {
        c cVar = this.f7200A;
        if (cVar == null) {
            return D3.a.a(-1, i2);
        }
        Objects.requireNonNull((e) cVar);
        return D3.a.a(2, i2);
    }

    private int w(float f4, int i2, boolean z4) {
        if (f4 >= 1.0f) {
            return i2;
        }
        return ((z4 ? (int) (((-f4) * Color.alpha(i2)) + Color.alpha(i2)) : (int) (f4 * Color.alpha(i2))) << 24) | (16777215 & i2);
    }

    private float y() {
        if (TextUtils.isEmpty(this.f7260y0) || H()) {
            return 0.0f;
        }
        return this.f7236k0.measureText(this.f7260y0.toString());
    }

    public final int A() {
        return this.f7255w;
    }

    public final int C() {
        return this.f7259y;
    }

    public final void N(String[] strArr) {
        if (this.f7253v == strArr) {
            return;
        }
        this.f7253v = strArr;
        if (strArr != null) {
            this.f7239m.setRawInputType(524289);
        } else {
            this.f7239m.setRawInputType(2);
        }
        Y();
        G();
        X();
    }

    public final void O(c cVar) {
        if (cVar == this.f7200A) {
            return;
        }
        this.f7200A = cVar;
        G();
        Y();
    }

    public final void P() {
        this.f7262z0 = 3.0f;
    }

    public final void Q(int i2) {
        if (this.f7257x == i2) {
            return;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.f7257x = i2;
        if (i2 < this.f7259y) {
            this.f7259y = i2;
        }
        W(i2 - this.f7255w > this.f7206D.length);
        G();
        Y();
        X();
        invalidate();
    }

    public final void R(int i2) {
        if (this.f7255w == i2) {
            return;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.f7255w = i2;
        if (i2 > this.f7259y) {
            this.f7259y = i2;
        }
        W(this.f7257x - i2 > this.f7206D.length);
        G();
        Y();
        X();
        invalidate();
    }

    public final void S() {
        this.f7202B = 100L;
    }

    public final void T(f fVar) {
        this.f7261z = fVar;
    }

    public final void U(int i2) {
        V(i2, false);
    }

    public final void W(boolean z4) {
        boolean z5 = this.f7257x - this.f7255w >= this.f7206D.length;
        if ((!z4 || z5) && z4 != this.f7221V) {
            this.f7221V = z4;
        }
        G();
        invalidate();
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller scroller = this.f7211I;
        if (scroller.isFinished()) {
            scroller = this.f7212J;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.f7213K == 0) {
            this.f7213K = scroller.getStartY();
        }
        scrollBy(0, currY - this.f7213K);
        this.f7213K = currY;
        if (!scroller.isFinished()) {
            invalidate();
            return;
        }
        if (scroller == this.f7211I) {
            if (!u()) {
                Y();
            }
            K(0);
        } else if (this.f7224b0 != 1) {
            Y();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0044, code lost:
    
        requestFocus();
        r5.f7234j0 = r0;
        M();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0052, code lost:
    
        if (r5.f7211I.isFinished() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
    
        if (r0 != 20) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0059, code lost:
    
        s(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005c, code lost:
    
        return true;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            if (this.f7222W) {
                int action = keyEvent.getAction();
                if (action != 0) {
                    if (action == 1 && this.f7234j0 == keyCode) {
                        this.f7234j0 = -1;
                        return true;
                    }
                } else if (!this.f7221V) {
                }
            }
        } else if (keyCode == 23 || keyCode == 66) {
            M();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            M();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            M();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        X();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        return NumberPicker.class.getName();
    }

    @Override // android.view.View
    protected final float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    @Override // android.view.View
    protected final float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        E();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        F();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f7237l;
        if (iVar != null) {
            iVar.sendMessage(iVar.obtainMessage(2, this.f7231i, 0));
            this.f7237l = null;
        }
        M();
        E3.a.b();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onDraw(Canvas canvas) {
        boolean z4;
        if (!this.f7222W) {
            super.onDraw(canvas);
            return;
        }
        float right = (((getRight() - getLeft()) + getPaddingLeft()) - getPaddingRight()) / 2;
        float f4 = (this.f7208F * 1) + this.f7209G;
        float f5 = this.f7210H;
        SparseArray<String> sparseArray = this.f7204C;
        int[] iArr = this.f7206D;
        int length = iArr.length;
        boolean z5 = false;
        int i2 = 0;
        while (i2 < length) {
            String str = sparseArray.get(iArr[i2]);
            float fAbs = Math.abs(f4 - f5) / this.f7208F;
            int i4 = this.f7242n0;
            float f6 = fAbs >= 1.0f ? this.f7244o0 : i4 + ((r15 - i4) * fAbs);
            while (true) {
                this.f7207E.setTextSize(f6);
                f6 *= this.q0;
                if (this.f7207E.measureText(str) <= getWidth() && this.f7207E.getTextSize() <= this.p0) {
                    break;
                } else {
                    z5 = false;
                }
            }
            this.f7207E.setColor(w(fAbs, this.f7256w0, z5));
            canvas.drawText(str, right, ((f6 - this.f7244o0) / 2.0f) + f5, this.f7207E);
            if (fAbs < 1.0f) {
                z4 = true;
                this.f7207E.setColor(w(fAbs, this.f7254v0, true));
                canvas.drawText(str, right, ((f6 - this.f7244o0) / 2.0f) + f5, this.f7207E);
            } else {
                z4 = true;
            }
            f5 += this.f7208F;
            i2++;
            z5 = false;
        }
        if (TextUtils.isEmpty(this.f7260y0) || H()) {
            return;
        }
        float fMeasureText = this.f7236k0.measureText(this.f7260y0.toString());
        canvas.drawText(this.f7260y0.toString(), Y.b(this) ? Math.max(((right - (this.f7240m0 / 2.0f)) - this.f7233j) - fMeasureText, 0.0f) : Math.min((this.f7240m0 / 2.0f) + right + this.f7233j, getWidth() - fMeasureText), (f4 - (this.f7242n0 / 2)) + (this.f7247r0 / 2) + this.f7235k, this.f7236k0);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isEnabled()) {
            accessibilityNodeInfo.setScrollable(true);
            accessibilityNodeInfo.addAction(8192);
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS);
            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(0, this.f7255w - 1, this.f7257x + 1, this.f7259y));
            StringBuilder sb = new StringBuilder();
            String[] strArr = this.f7253v;
            sb.append(strArr == null ? v(this.f7259y) : strArr[this.f7259y - this.f7255w]);
            sb.append(TextUtils.isEmpty(this.f7260y0) ? "" : this.f7260y0);
            accessibilityNodeInfo.setContentDescription(sb.toString());
            accessibilityNodeInfo.setStateDescription(getContext().getString(R.string.miuix_access_state_desc));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7222W || !isEnabled() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        M();
        this.f7239m.setVisibility(4);
        float y2 = motionEvent.getY();
        this.f7215O = y2;
        this.f7216Q = y2;
        this.P = motionEvent.getEventTime();
        this.f7225c0 = false;
        this.f7226d0 = false;
        float f4 = this.f7215O;
        if (f4 < this.f7227e0) {
            if (this.f7224b0 == 0) {
                this.f7232i0.a(2);
            }
        } else if (f4 > this.f7228f0 && this.f7224b0 == 0) {
            this.f7232i0.a(1);
        }
        if (!this.f7211I.isFinished()) {
            this.f7211I.forceFinished(true);
            this.f7212J.forceFinished(true);
            K(0);
        } else if (this.f7212J.isFinished()) {
            float f5 = this.f7215O;
            if (f5 < this.f7227e0) {
                L(false, ViewConfiguration.getLongPressTimeout());
            } else if (f5 > this.f7228f0) {
                L(true, ViewConfiguration.getLongPressTimeout());
            } else {
                this.f7226d0 = true;
                a aVar = this.f7214N;
                if (aVar == null) {
                    this.f7214N = new a();
                } else {
                    removeCallbacks(aVar);
                }
                postDelayed(this.f7214N, ViewConfiguration.getLongPressTimeout());
            }
        } else {
            this.f7211I.forceFinished(true);
            this.f7212J.forceFinished(true);
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        if (!this.f7222W) {
            super.onLayout(z4, i2, i4, i5, i6);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f7239m.getMeasuredWidth();
        int measuredHeight2 = this.f7239m.getMeasuredHeight();
        int i7 = (measuredWidth - measuredWidth2) / 2;
        int i8 = (measuredHeight - measuredHeight2) / 2;
        this.f7239m.layout(i7, i8, measuredWidth2 + i7, measuredHeight2 + i8);
        if (z4) {
            G();
            float bottom = (getBottom() - getTop()) - (this.f7206D.length * this.f7250t);
            if (bottom < 0.0f) {
                bottom = 0.0f;
            }
            int length = (int) ((bottom / r7.length) + 0.5f);
            this.u = length;
            this.f7208F = this.f7250t + length;
            int top = (this.f7239m.getTop() + this.f7239m.getBaseline()) - (this.f7208F * 1);
            this.f7209G = top;
            this.f7210H = top;
            Y();
            setVerticalFadingEdgeEnabled(true);
            setFadingEdgeLength(((getBottom() - getTop()) - this.f7250t) / 2);
            int height = getHeight();
            int i9 = this.f7241n;
            int i10 = this.f7223a0;
            int i11 = ((height - i9) / 2) - i10;
            this.f7227e0 = i11;
            this.f7228f0 = (i10 * 2) + i11 + i9;
        }
        float paddingLeft = ((getPaddingLeft() + (getRight() - getLeft())) - getPaddingRight()) / 2;
        if (y() > 0.0f) {
            int i12 = this.f7249s0;
            this.f7247r0 = i12;
            this.f7236k0.setTextSize(i12);
            while ((this.f7240m0 / 2.0f) + paddingLeft + this.f7233j + y() > getWidth()) {
                float f4 = this.f7247r0;
                if (f4 <= this.f7251t0) {
                    break;
                }
                int i13 = (int) (f4 * this.f7252u0);
                this.f7247r0 = i13;
                this.f7236k0.setTextSize(i13);
            }
        }
        Drawable background = getBackground();
        int i14 = this.f7246r + 20;
        if (this.f7205C0 && (background instanceof StateListDrawable)) {
            StateListDrawable stateListDrawable = (StateListDrawable) background;
            int stateCount = stateListDrawable.getStateCount();
            for (int i15 = 0; i15 < stateCount; i15++) {
                Drawable stateDrawable = stateListDrawable.getStateDrawable(i15);
                if (stateDrawable instanceof LayerDrawable) {
                    LayerDrawable layerDrawable = (LayerDrawable) stateDrawable;
                    int numberOfLayers = layerDrawable.getNumberOfLayers();
                    for (int i16 = 0; i16 < numberOfLayers; i16++) {
                        Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(layerDrawable.getId(i16));
                        if (drawableFindDrawableByLayerId instanceof GradientDrawable) {
                            ((GradientDrawable) drawableFindDrawableByLayerId).setSize(getWidth() > i14 ? i14 : getWidth(), getHeight());
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        if (!this.f7222W) {
            super.onMeasure(i2, i4);
            return;
        }
        super.onMeasure(I(i2, this.f7246r), I(i4, this.p));
        int i5 = this.f7245q;
        int measuredWidth = getMeasuredWidth();
        if (i5 != -1) {
            measuredWidth = View.resolveSizeAndState(Math.max(i5, measuredWidth), i2, 0);
        }
        int i6 = this.f7243o;
        int measuredHeight = getMeasuredHeight();
        if (i6 != -1) {
            measuredHeight = View.resolveSizeAndState(Math.max(i6, measuredHeight), i4, 0);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.f7222W) {
            return false;
        }
        if (this.f7217R == null) {
            this.f7217R = VelocityTracker.obtain();
        }
        this.f7217R.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            a aVar = this.f7214N;
            if (aVar != null) {
                removeCallbacks(aVar);
            }
            b bVar = this.M;
            if (bVar != null) {
                removeCallbacks(bVar);
            }
            this.f7232i0.c();
            VelocityTracker velocityTracker = this.f7217R;
            velocityTracker.computeCurrentVelocity(1000, this.f7220U);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) >= Math.abs(this.f7220U)) {
                yVelocity = (int) (yVelocity * this.f7262z0);
            }
            int i2 = yVelocity;
            if (Math.abs(i2) > this.f7219T) {
                this.f7213K = 0;
                if (i2 > 0) {
                    this.f7211I.fling(0, 0, 0, i2, 0, 0, 0, Integer.MAX_VALUE);
                } else {
                    this.f7211I.fling(0, Integer.MAX_VALUE, 0, i2, 0, 0, 0, Integer.MAX_VALUE);
                }
                invalidate();
                K(2);
            } else {
                int y2 = (int) motionEvent.getY();
                int iAbs = (int) Math.abs(y2 - this.f7215O);
                long eventTime = motionEvent.getEventTime() - this.P;
                if (iAbs > this.f7218S || eventTime >= ViewConfiguration.getLongPressTimeout()) {
                    u();
                } else if (this.f7226d0) {
                    this.f7226d0 = false;
                } else {
                    int i4 = (y2 / this.f7208F) - 1;
                    if (i4 > 0) {
                        s(true);
                        this.f7232i0.b(1);
                    } else if (i4 < 0) {
                        s(false);
                        this.f7232i0.b(2);
                    }
                }
                K(0);
            }
            this.f7217R.recycle();
            this.f7217R = null;
        } else if (actionMasked == 2 && !this.f7225c0) {
            float y4 = motionEvent.getY();
            if (this.f7224b0 == 1) {
                scrollBy(0, (int) (y4 - this.f7216Q));
                invalidate();
            } else if (((int) Math.abs(y4 - this.f7215O)) > this.f7218S) {
                M();
                K(1);
            }
            this.f7216Q = y4;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (super.performAccessibilityAction(i2, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        if (i2 != 4096 && i2 != 8192) {
            return false;
        }
        s(i2 == 4096);
        return true;
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i4) {
        int[] iArr = this.f7206D;
        boolean z4 = this.f7221V;
        if (!z4 && i4 > 0 && iArr[1] <= this.f7255w) {
            this.f7210H = this.f7209G;
            return;
        }
        if (!z4 && i4 < 0 && iArr[1] >= this.f7257x) {
            this.f7210H = this.f7209G;
            return;
        }
        this.f7210H += i4;
        while (true) {
            int i5 = this.f7210H;
            if (i5 - this.f7209G <= this.u) {
                break;
            }
            this.f7210H = i5 - this.f7208F;
            if (iArr.length - 1 >= 0) {
                System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
            }
            int i6 = iArr[1] - 1;
            if (this.f7221V && i6 < this.f7255w) {
                i6 = this.f7257x;
            }
            iArr[0] = i6;
            t(i6);
            V(iArr[1], true);
            if (!this.f7221V && iArr[1] <= this.f7255w) {
                this.f7210H = this.f7209G;
            }
        }
        while (true) {
            int i7 = this.f7210H;
            if (i7 - this.f7209G >= (-this.u)) {
                return;
            }
            this.f7210H = i7 + this.f7208F;
            if (iArr.length - 1 >= 0) {
                System.arraycopy(iArr, 1, iArr, 0, iArr.length - 1);
            }
            int i8 = iArr[iArr.length - 2] + 1;
            if (this.f7221V && i8 > this.f7257x) {
                i8 = this.f7255w;
            }
            iArr[iArr.length - 1] = i8;
            t(i8);
            V(iArr[1], true);
            if (!this.f7221V && iArr[1] >= this.f7257x) {
                this.f7210H = this.f7209G;
            }
        }
    }

    public final String[] x() {
        return this.f7253v;
    }

    public final int z() {
        return this.f7257x;
    }
}
