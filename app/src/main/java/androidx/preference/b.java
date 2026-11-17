package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.e;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l;
import androidx.lifecycle.x;
import androidx.preference.DialogPreference;

/* loaded from: classes.dex */
public abstract class b extends DialogInterfaceOnCancelListenerC0216l implements DialogInterface.OnClickListener {

    /* renamed from: r0, reason: collision with root package name */
    private DialogPreference f3829r0;

    /* renamed from: s0, reason: collision with root package name */
    private CharSequence f3830s0;

    /* renamed from: t0, reason: collision with root package name */
    private CharSequence f3831t0;

    /* renamed from: u0, reason: collision with root package name */
    private CharSequence f3832u0;

    /* renamed from: v0, reason: collision with root package name */
    private CharSequence f3833v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f3834w0;

    /* renamed from: x0, reason: collision with root package name */
    private BitmapDrawable f3835x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f3836y0;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        super.e0(bundle);
        x xVarS = S();
        if (!(xVarS instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) xVarS;
        String string = z().getString("key");
        if (bundle != null) {
            this.f3830s0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f3831t0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f3832u0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f3833v0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f3834w0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f3835x0 = new BitmapDrawable(N(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.r(string);
        this.f3829r0 = dialogPreference;
        this.f3830s0 = dialogPreference.z0();
        this.f3831t0 = this.f3829r0.B0();
        this.f3832u0 = this.f3829r0.A0();
        this.f3833v0 = this.f3829r0.y0();
        this.f3834w0 = this.f3829r0.x0();
        Drawable drawableW0 = this.f3829r0.w0();
        if (drawableW0 == null || (drawableW0 instanceof BitmapDrawable)) {
            this.f3835x0 = (BitmapDrawable) drawableW0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableW0.getIntrinsicWidth(), drawableW0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableW0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableW0.draw(canvas);
        this.f3835x0 = new BitmapDrawable(N(), bitmapCreateBitmap);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l
    public Dialog e1(Bundle bundle) {
        ActivityC0219o activityC0219oX = x();
        this.f3836y0 = -2;
        e.a aVar = new e.a(activityC0219oX);
        aVar.m(this.f3830s0);
        aVar.e(this.f3835x0);
        aVar.j(this.f3831t0, this);
        aVar.h(this.f3832u0, this);
        View viewL1 = l1();
        if (viewL1 != null) {
            k1(viewL1);
            aVar.n(viewL1);
        } else {
            aVar.f(this.f3833v0);
        }
        n1(aVar);
        androidx.appcompat.app.e eVarA = aVar.a();
        if (j1()) {
            eVarA.getWindow().setSoftInputMode(5);
        }
        return eVarA;
    }

    public final DialogPreference i1() {
        if (this.f3829r0 == null) {
            this.f3829r0 = (DialogPreference) ((DialogPreference.a) S()).r(z().getString("key"));
        }
        return this.f3829r0;
    }

    protected boolean j1() {
        return false;
    }

    protected void k1(View view) {
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f3833v0;
            int i2 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i2 = 0;
            }
            if (viewFindViewById.getVisibility() != i2) {
                viewFindViewById.setVisibility(i2);
            }
        }
    }

    protected final View l1() {
        int i2 = this.f3834w0;
        if (i2 == 0) {
            return null;
        }
        return F().inflate(i2, (ViewGroup) null);
    }

    public abstract void m1(boolean z4);

    protected void n1(e.a aVar) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f3836y0 = i2;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m1(this.f3836y0 == -1);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0216l, androidx.fragment.app.Fragment
    public void q0(Bundle bundle) {
        super.q0(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f3830s0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f3831t0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f3832u0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f3833v0);
        bundle.putInt("PreferenceDialogFragment.layout", this.f3834w0);
        BitmapDrawable bitmapDrawable = this.f3835x0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
