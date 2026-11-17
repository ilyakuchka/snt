package h1;

import Y0.t;
import Y0.x;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements x<T>, t {

    /* renamed from: i, reason: collision with root package name */
    protected final T f6322i;

    public b(T t2) {
        Objects.requireNonNull(t2, "Argument must not be null");
        this.f6322i = t2;
    }

    @Override // Y0.t
    public void a() {
        T t2 = this.f6322i;
        if (t2 instanceof BitmapDrawable) {
            ((BitmapDrawable) t2).getBitmap().prepareToDraw();
        } else if (t2 instanceof j1.c) {
            ((j1.c) t2).c().prepareToDraw();
        }
    }

    @Override // Y0.x
    public final Object get() {
        Drawable.ConstantState constantState = this.f6322i.getConstantState();
        return constantState == null ? this.f6322i : constantState.newDrawable();
    }
}
