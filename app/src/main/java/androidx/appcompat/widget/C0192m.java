package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import i.C0333a;

/* renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0192m extends MultiAutoCompleteTextView {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f3033k = {R.attr.popupBackground};

    /* renamed from: i, reason: collision with root package name */
    private final C0184e f3034i;

    /* renamed from: j, reason: collision with root package name */
    private final C0202x f3035j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0192m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.android.mmt.R.attr.autoCompleteTextViewStyle);
        Q.a(context);
        O.a(this, getContext());
        U u = U.u(getContext(), attributeSet, f3033k, com.android.mmt.R.attr.autoCompleteTextViewStyle, 0);
        if (u.r(0)) {
            setDropDownBackgroundDrawable(u.f(0));
        }
        u.v();
        C0184e c0184e = new C0184e(this);
        this.f3034i = c0184e;
        c0184e.d(attributeSet, com.android.mmt.R.attr.autoCompleteTextViewStyle);
        C0202x c0202x = new C0202x(this);
        this.f3035j = c0202x;
        c0202x.f(attributeSet, com.android.mmt.R.attr.autoCompleteTextViewStyle);
        c0202x.b();
    }

    @Override // android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f3034i;
        if (c0184e != null) {
            c0184e.a();
        }
        C0202x c0202x = this.f3035j;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0189j.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f3034i;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f3034i;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public final void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(C0333a.a(getContext(), i2));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0202x c0202x = this.f3035j;
        if (c0202x != null) {
            c0202x.h(context, i2);
        }
    }
}
