package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import i.C0333a;

/* renamed from: androidx.appcompat.widget.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0185f extends CheckedTextView {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f3011j = {R.attr.checkMark};

    /* renamed from: i, reason: collision with root package name */
    private final C0202x f3012i;

    public C0185f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0202x c0202x = this.f3012i;
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

    @Override // android.widget.CheckedTextView
    public final void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(C0333a.a(getContext(), i2));
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0202x c0202x = this.f3012i;
        if (c0202x != null) {
            c0202x.h(context, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0185f(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Q.a(context);
        O.a(this, getContext());
        C0202x c0202x = new C0202x(this);
        this.f3012i = c0202x;
        c0202x.f(attributeSet, i2);
        c0202x.b();
        U u = U.u(getContext(), attributeSet, f3011j, i2, 0);
        setCheckMarkDrawable(u.f(0));
        u.v();
    }
}
