package miuix.androidbasewidget.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0188i;

/* loaded from: classes.dex */
public class b extends C0188i {

    /* renamed from: l, reason: collision with root package name */
    private TextWatcher f6617l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6618m;

    /* renamed from: n, reason: collision with root package name */
    private int f6619n;

    /* renamed from: o, reason: collision with root package name */
    private final int f6620o;

    private class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            b.this.e();
            if (b.this.f6618m) {
                b.this.f6618m = false;
                b bVar = b.this;
                bVar.removeTextChangedListener(bVar.f6617l);
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public final void e() {
        if (TextUtils.isEmpty(null)) {
            getBackground().setLevel(0);
            return;
        }
        getBackground().setLevel(404);
        if (this.f6618m) {
            return;
        }
        this.f6618m = true;
        addTextChangedListener(this.f6617l);
    }

    @Override // android.widget.TextView, android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zOnPreDraw = super.onPreDraw();
        setHighlightColor(Color.argb(38, Color.red(this.f6619n), Color.green(this.f6619n), Color.blue(this.f6619n)));
        Drawable textSelectHandleLeft = getTextSelectHandleLeft();
        Drawable textSelectHandleRight = getTextSelectHandleRight();
        Drawable textSelectHandle = getTextSelectHandle();
        Drawable textCursorDrawable = getTextCursorDrawable();
        if (this.f6619n != this.f6620o) {
            Drawable[] drawableArr = {textSelectHandleLeft, textSelectHandleRight, textSelectHandle, textCursorDrawable};
            for (int i2 = 0; i2 < 4; i2++) {
                drawableArr[i2].setColorFilter(this.f6619n, PorterDuff.Mode.SRC_IN);
            }
        }
        setTextSelectHandleLeft(textSelectHandleLeft);
        setTextSelectHandleRight(textSelectHandleRight);
        setTextSelectHandle(textSelectHandle);
        setTextCursorDrawable(textCursorDrawable);
        return zOnPreDraw;
    }

    public b(Context context, AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        super(context, attributeSet, i2);
        this.f6617l = new a();
        int color = getResources().getColor(com.android.mmt.R.color.miuix_appcompat_handle_and_cursor_color);
        this.f6620o = color;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2095O, i2, com.android.mmt.R.style.Widget_EditText_DayNight);
        this.f6619n = typedArrayObtainStyledAttributes.getColor(0, color);
        typedArrayObtainStyledAttributes.recycle();
    }
}
