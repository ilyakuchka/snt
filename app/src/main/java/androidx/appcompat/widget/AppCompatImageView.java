package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView {

    /* renamed from: i, reason: collision with root package name */
    private final C0184e f2708i;

    /* renamed from: j, reason: collision with root package name */
    private final C0191l f2709j;

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f2708i;
        if (c0184e != null) {
            c0184e.a();
        }
        C0191l c0191l = this.f2709j;
        if (c0191l != null) {
            c0191l.a();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return this.f2709j.b() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f2708i;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f2708i;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0191l c0191l = this.f2709j;
        if (c0191l != null) {
            c0191l.a();
        }
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0191l c0191l = this.f2709j;
        if (c0191l != null) {
            c0191l.a();
        }
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i2) {
        C0191l c0191l = this.f2709j;
        if (c0191l != null) {
            c0191l.d(i2);
        }
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0191l c0191l = this.f2709j;
        if (c0191l != null) {
            c0191l.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Q.a(context);
        O.a(this, getContext());
        C0184e c0184e = new C0184e(this);
        this.f2708i = c0184e;
        c0184e.d(attributeSet, i2);
        C0191l c0191l = new C0191l(this);
        this.f2709j = c0191l;
        c0191l.c(attributeSet, i2);
    }
}
