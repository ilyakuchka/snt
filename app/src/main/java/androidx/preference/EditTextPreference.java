package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: c0, reason: collision with root package name */
    private String f3735c0;

    public static final class b implements Preference.g<EditTextPreference> {

        /* renamed from: a, reason: collision with root package name */
        private static b f3737a;

        private b() {
        }

        public static b b() {
            if (f3737a == null) {
                f3737a = new b();
            }
            return f3737a;
        }

        @Override // androidx.preference.Preference.g
        public final CharSequence a(Preference preference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            return TextUtils.isEmpty(editTextPreference.E0()) ? editTextPreference.i().getString(R.string.not_set) : editTextPreference.E0();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7879j, i2, 0);
        if (x.e.b(typedArrayObtainStyledAttributes, 0, 0, false)) {
            p0(b.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final String E0() {
        return this.f3735c0;
    }

    public final void F0(String str) {
        boolean zS0 = s0();
        this.f3735c0 = str;
        a0(str);
        boolean zS02 = s0();
        if (zS02 != zS0) {
            I(zS02);
        }
        H();
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
        F0(aVar.f3736i);
    }

    @Override // androidx.preference.Preference
    protected final Parcelable V() {
        Parcelable parcelableV = super.V();
        if (F()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f3736i = this.f3735c0;
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected final void W(Object obj) {
        F0(v((String) obj));
    }

    @Override // androidx.preference.Preference
    public final boolean s0() {
        return TextUtils.isEmpty(this.f3735c0) || super.s0();
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0067a();

        /* renamed from: i, reason: collision with root package name */
        String f3736i;

        /* renamed from: androidx.preference.EditTextPreference$a$a, reason: collision with other inner class name */
        static class C0067a implements Parcelable.Creator<a> {
            C0067a() {
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
            this.f3736i = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f3736i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, x.e.a(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle), 0);
    }
}
