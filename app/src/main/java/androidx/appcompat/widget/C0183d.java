package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import i.C0333a;

/* renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0183d extends AutoCompleteTextView {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f3003k = {R.attr.popupBackground};

    /* renamed from: i, reason: collision with root package name */
    private final C0184e f3004i;

    /* renamed from: j, reason: collision with root package name */
    private final C0202x f3005j;

    public C0183d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.android.mmt.R.attr.autoCompleteTextViewStyle);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f3004i;
        if (c0184e != null) {
            c0184e.a();
        }
        C0202x c0202x = this.f3005j;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0189j.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f3004i;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f3004i;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.AutoCompleteTextView
    public final void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(C0333a.a(getContext(), i2));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0202x c0202x = this.f3005j;
        if (c0202x != null) {
            c0202x.h(context, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0183d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, com.android.mmt.R.attr.autoCompleteTextViewStyle);
        Q.a(context);
        O.a(this, getContext());
        U u = U.u(getContext(), attributeSet, f3003k, com.android.mmt.R.attr.autoCompleteTextViewStyle, 0);
        if (u.r(0)) {
            setDropDownBackgroundDrawable(u.f(0));
        }
        u.v();
        C0184e c0184e = new C0184e(this);
        this.f3004i = c0184e;
        c0184e.d(attributeSet, com.android.mmt.R.attr.autoCompleteTextViewStyle);
        C0202x c0202x = new C0202x(this);
        this.f3005j = c0202x;
        c0202x.f(attributeSet, com.android.mmt.R.attr.autoCompleteTextViewStyle);
        c0202x.b();
    }
}
