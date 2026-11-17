package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: W, reason: collision with root package name */
    private CharSequence f3725W;

    /* renamed from: X, reason: collision with root package name */
    private String f3726X;

    /* renamed from: Y, reason: collision with root package name */
    private Drawable f3727Y;

    /* renamed from: Z, reason: collision with root package name */
    private String f3728Z;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence f3729a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f3730b0;

    public interface a {
        <T extends Preference> T r(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7878i, i2, i4);
        String strD = x.e.d(typedArrayObtainStyledAttributes, 9, 0);
        this.f3725W = strD;
        if (strD == null) {
            this.f3725W = A();
        }
        this.f3726X = x.e.d(typedArrayObtainStyledAttributes, 8, 1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(6);
        this.f3727Y = drawable == null ? typedArrayObtainStyledAttributes.getDrawable(2) : drawable;
        this.f3728Z = x.e.d(typedArrayObtainStyledAttributes, 11, 3);
        this.f3729a0 = x.e.d(typedArrayObtainStyledAttributes, 10, 4);
        this.f3730b0 = typedArrayObtainStyledAttributes.getResourceId(7, typedArrayObtainStyledAttributes.getResourceId(5, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final CharSequence A0() {
        return this.f3729a0;
    }

    public final CharSequence B0() {
        return this.f3728Z;
    }

    public final void C0(int i2) {
        this.f3725W = i().getString(i2);
    }

    public final void D0() {
        this.f3729a0 = null;
    }

    @Override // androidx.preference.Preference
    protected void O() {
        x().q(this);
    }

    public final Drawable w0() {
        return this.f3727Y;
    }

    public final int x0() {
        return this.f3730b0;
    }

    public final CharSequence y0() {
        return this.f3726X;
    }

    public final CharSequence z0() {
        return this.f3725W;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, x.e.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(Context context) {
        this(context, null);
    }
}
