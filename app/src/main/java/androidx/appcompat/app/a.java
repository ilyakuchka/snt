package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.fragment.app.E;

/* loaded from: classes.dex */
public abstract class a {

    public interface b {
        void a();
    }

    @Deprecated
    public static abstract class c {
        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract int d();

        public abstract CharSequence e();

        public abstract void f();

        public abstract c g(CharSequence charSequence);
    }

    @Deprecated
    public interface d {
        void a(c cVar, E e2);

        void b(c cVar, E e2);

        void c(c cVar, E e2);
    }

    public abstract int a();

    @Deprecated
    public abstract c b(int i2);

    public abstract Context c();

    public abstract void d();

    public abstract boolean e();

    @Deprecated
    public abstract void f(c cVar);

    public abstract void g(boolean z4);

    public abstract void h(int i2);

    public abstract void i();

    public abstract void j(boolean z4);

    @Deprecated
    public abstract void k(int i2);

    public abstract void l(CharSequence charSequence);

    public abstract void m(int i2);

    public abstract void n(CharSequence charSequence);

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0055a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f2312a;

        public C0055a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2312a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.g);
            this.f2312a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0055a() {
            super(-2, -2);
            this.f2312a = 8388627;
        }

        public C0055a(int i2) {
            super(-2, -1);
            this.f2312a = 8388627;
        }

        public C0055a(C0055a c0055a) {
            super((ViewGroup.MarginLayoutParams) c0055a);
            this.f2312a = 0;
            this.f2312a = c0055a.f2312a;
        }

        public C0055a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2312a = 0;
        }
    }
}
