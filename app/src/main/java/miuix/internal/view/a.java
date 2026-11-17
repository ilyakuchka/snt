package miuix.internal.view;

import android.content.res.Resources;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;

/* loaded from: classes.dex */
public class a extends AnimatedStateListDrawable {

    /* renamed from: j, reason: collision with root package name */
    private static final String f7111j = a.class.getName();

    /* renamed from: i, reason: collision with root package name */
    protected C0122a f7112i;

    public a() {
        this.f7112i = a();
    }

    protected C0122a a() {
        return new C0122a();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return true;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f7112i;
    }

    @Override // android.graphics.drawable.AnimatedStateListDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer
    protected final void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (this.f7112i == null) {
            this.f7112i = a();
        }
        this.f7112i.f7113a = drawableContainerState;
    }

    /* renamed from: miuix.internal.view.a$a, reason: collision with other inner class name */
    public static class C0122a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        Drawable.ConstantState f7113a;

        /* renamed from: b, reason: collision with root package name */
        int f7114b;

        /* renamed from: c, reason: collision with root package name */
        int f7115c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        int f7116e;

        /* renamed from: f, reason: collision with root package name */
        int f7117f;
        int g;

        /* renamed from: h, reason: collision with root package name */
        int f7118h;

        /* renamed from: i, reason: collision with root package name */
        int f7119i;

        /* renamed from: j, reason: collision with root package name */
        boolean f7120j;

        protected Drawable a(Resources resources, Resources.Theme theme, C0122a c0122a) {
            return new a(resources, theme, c0122a);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            Drawable.ConstantState constantState = this.f7113a;
            if (constantState == null) {
                return false;
            }
            return constantState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            Drawable.ConstantState constantState = this.f7113a;
            if (constantState == null) {
                return -1;
            }
            return constantState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            if (this.f7113a == null) {
                return null;
            }
            return a(null, null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            if (this.f7113a == null) {
                return null;
            }
            return a(resources, null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            if (this.f7113a == null) {
                return null;
            }
            return a(resources, theme, this);
        }
    }

    protected a(Resources resources, Resources.Theme theme, C0122a c0122a) {
        Drawable drawableNewDrawable;
        if (c0122a != null) {
            if (resources == null) {
                drawableNewDrawable = c0122a.f7113a.newDrawable();
            } else if (theme == null) {
                drawableNewDrawable = c0122a.f7113a.newDrawable(resources);
            } else {
                drawableNewDrawable = c0122a.f7113a.newDrawable(resources, theme);
            }
            if (drawableNewDrawable != null) {
                c0122a.f7113a = drawableNewDrawable.getConstantState();
            }
            setConstantState((DrawableContainer.DrawableContainerState) c0122a.f7113a);
            onStateChange(getState());
            jumpToCurrentState();
            C0122a c0122a2 = this.f7112i;
            c0122a2.f7114b = c0122a.f7114b;
            c0122a2.f7115c = c0122a.f7115c;
            c0122a2.d = c0122a.d;
            c0122a2.f7120j = c0122a.f7120j;
            return;
        }
        Log.e(f7111j, "checkWidgetConstantState is null ,but it can't be null", null);
    }
}
