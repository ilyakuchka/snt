package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: W, reason: collision with root package name */
    protected boolean f3822W;

    /* renamed from: X, reason: collision with root package name */
    private CharSequence f3823X;

    /* renamed from: Y, reason: collision with root package name */
    private CharSequence f3824Y;

    /* renamed from: Z, reason: collision with root package name */
    private boolean f3825Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f3826a0;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
    }

    public final void A0(CharSequence charSequence) {
        this.f3823X = charSequence;
        if (this.f3822W) {
            H();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void B0(View view) {
        int i2;
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        boolean z4 = true;
        if (!this.f3822W || TextUtils.isEmpty(this.f3823X)) {
            if (!this.f3822W && !TextUtils.isEmpty(this.f3824Y)) {
                textView.setText(this.f3824Y);
            }
            if (z4) {
                CharSequence charSequenceY = y();
                if (!TextUtils.isEmpty(charSequenceY)) {
                    textView.setText(charSequenceY);
                    z4 = false;
                }
            }
            i2 = z4 ? 8 : 0;
            if (i2 == textView.getVisibility()) {
                textView.setVisibility(i2);
                return;
            }
            return;
        }
        textView.setText(this.f3823X);
        z4 = false;
        if (z4) {
        }
        if (z4) {
        }
        if (i2 == textView.getVisibility()) {
        }
    }

    protected final void C0(h hVar) {
        B0(hVar.B(R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected final void O() {
        boolean z4 = !this.f3822W;
        if (e(Boolean.valueOf(z4))) {
            x0(z4);
        }
    }

    @Override // androidx.preference.Preference
    protected final Object Q(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    @Override // androidx.preference.Preference
    protected final void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        x0(aVar.f3827i);
    }

    @Override // androidx.preference.Preference
    protected final Parcelable V() {
        Parcelable parcelableV = super.V();
        if (F()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f3827i = this.f3822W;
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected final void W(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        x0(t(((Boolean) obj).booleanValue()));
    }

    @Override // androidx.preference.Preference
    public final boolean s0() {
        return (this.f3826a0 ? this.f3822W : !this.f3822W) || super.s0();
    }

    public final boolean w0() {
        return this.f3822W;
    }

    public final void x0(boolean z4) {
        boolean z5 = this.f3822W != z4;
        if (z5 || !this.f3825Z) {
            this.f3822W = z4;
            this.f3825Z = true;
            Y(z4);
            if (z5) {
                I(s0());
                H();
            }
        }
    }

    public final void y0(boolean z4) {
        this.f3826a0 = z4;
    }

    public final void z0(CharSequence charSequence) {
        this.f3824Y = charSequence;
        if (this.f3822W) {
            return;
        }
        H();
    }

    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0070a();

        /* renamed from: i, reason: collision with root package name */
        boolean f3827i;

        /* renamed from: androidx.preference.TwoStatePreference$a$a, reason: collision with other inner class name */
        static class C0070a implements Parcelable.Creator<a> {
            C0070a() {
            }

            @Override // android.os.Parcelable.Creator
            public final a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final a[] newArray(int i2) {
                return new a[i2];
            }
        }

        a(Parcel parcel) {
            super(parcel);
            this.f3827i = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3827i ? 1 : 0);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context) {
        this(context, null);
    }
}
