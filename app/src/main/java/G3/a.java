package G3;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.app.e;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
final class a extends e.a {

    /* renamed from: c, reason: collision with root package name */
    private g.a f199c;

    public a(Context context, g.a aVar) {
        super(context, 0);
        this.f199c = aVar;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.f199c.b(listAdapter, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a d(View view) {
        this.f199c.e(view);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a e(Drawable drawable) {
        this.f199c.g(drawable);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a f(CharSequence charSequence) {
        this.f199c.k(charSequence);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a g(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.f199c.l(charSequenceArr, zArr, onMultiChoiceClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f199c.n(charSequence, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a i(DialogInterface.OnKeyListener onKeyListener) {
        this.f199c.r(onKeyListener);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f199c.u(charSequence, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a k(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
        this.f199c.v(listAdapter, i2, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a l(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
        this.f199c.w(charSequenceArr, i2, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a m(CharSequence charSequence) {
        this.f199c.y(charSequence);
        return this;
    }

    @Override // androidx.appcompat.app.e.a
    public final e.a n(View view) {
        this.f199c.z(view);
        return this;
    }
}
