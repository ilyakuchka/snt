package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: c0, reason: collision with root package name */
    private CharSequence[] f3738c0;

    /* renamed from: d0, reason: collision with root package name */
    private CharSequence[] f3739d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f3740e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f3741f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f3742g0;

    public static final class b implements Preference.g<ListPreference> {

        /* renamed from: a, reason: collision with root package name */
        private static b f3744a;

        private b() {
        }

        public static b b() {
            if (f3744a == null) {
                f3744a = new b();
            }
            return f3744a;
        }

        @Override // androidx.preference.Preference.g
        public final CharSequence a(Preference preference) {
            ListPreference listPreference = (ListPreference) preference;
            return TextUtils.isEmpty(listPreference.G0()) ? listPreference.i().getString(R.string.not_set) : listPreference.G0();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7880k, i2, i4);
        this.f3738c0 = x.e.e(typedArrayObtainStyledAttributes, 2, 0);
        this.f3739d0 = x.e.e(typedArrayObtainStyledAttributes, 3, 1);
        if (typedArrayObtainStyledAttributes.getBoolean(4, typedArrayObtainStyledAttributes.getBoolean(4, false))) {
            p0(b.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0384b.f7882m, i2, i4);
        this.f3741f0 = x.e.d(typedArrayObtainStyledAttributes2, 33, 7);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final int E0(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f3739d0) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.f3739d0[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public final CharSequence[] F0() {
        return this.f3738c0;
    }

    public final CharSequence G0() {
        CharSequence[] charSequenceArr;
        int iE0 = E0(this.f3740e0);
        if (iE0 < 0 || (charSequenceArr = this.f3738c0) == null) {
            return null;
        }
        return charSequenceArr[iE0];
    }

    public final CharSequence[] H0() {
        return this.f3739d0;
    }

    public final String I0() {
        return this.f3740e0;
    }

    public void J0(CharSequence[] charSequenceArr) {
        this.f3738c0 = charSequenceArr;
    }

    public final void K0(int i2) {
        this.f3739d0 = i().getResources().getTextArray(i2);
    }

    public final void L0(String str) {
        boolean z4 = !TextUtils.equals(this.f3740e0, str);
        if (z4 || !this.f3742g0) {
            this.f3740e0 = str;
            this.f3742g0 = true;
            a0(str);
            if (z4) {
                H();
            }
        }
    }

    @Override // androidx.preference.Preference
    protected final Object Q(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // androidx.preference.Preference
    protected final void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        L0(aVar.f3743i);
    }

    @Override // androidx.preference.Preference
    protected final Parcelable V() {
        Parcelable parcelableV = super.V();
        if (F()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f3743i = this.f3740e0;
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected final void W(Object obj) {
        L0(v((String) obj));
    }

    @Override // androidx.preference.Preference
    public final CharSequence y() {
        if (z() != null) {
            return z().a(this);
        }
        CharSequence charSequenceG0 = G0();
        CharSequence charSequenceY = super.y();
        String str = this.f3741f0;
        if (str == null) {
            return charSequenceY;
        }
        Object[] objArr = new Object[1];
        if (charSequenceG0 == null) {
            charSequenceG0 = "";
        }
        objArr[0] = charSequenceG0;
        String str2 = String.format(str, objArr);
        if (TextUtils.equals(str2, charSequenceY)) {
            return charSequenceY;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0068a();

        /* renamed from: i, reason: collision with root package name */
        String f3743i;

        /* renamed from: androidx.preference.ListPreference$a$a, reason: collision with other inner class name */
        static class C0068a implements Parcelable.Creator<a> {
            C0068a() {
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
            this.f3743i = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f3743i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, x.e.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public ListPreference(Context context) {
        this(context, null);
    }
}
