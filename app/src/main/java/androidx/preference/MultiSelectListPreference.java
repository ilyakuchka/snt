package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.android.mmt.R;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import t.C0384b;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: c0, reason: collision with root package name */
    private CharSequence[] f3745c0;

    /* renamed from: d0, reason: collision with root package name */
    private CharSequence[] f3746d0;

    /* renamed from: e0, reason: collision with root package name */
    private Set<String> f3747e0;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, 0);
        this.f3747e0 = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7881l, i2, 0);
        this.f3745c0 = x.e.e(typedArrayObtainStyledAttributes, 2, 0);
        this.f3746d0 = x.e.e(typedArrayObtainStyledAttributes, 3, 1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final CharSequence[] E0() {
        return this.f3745c0;
    }

    public final CharSequence[] F0() {
        return this.f3746d0;
    }

    public final Set<String> G0() {
        return this.f3747e0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    public final void H0(Set<String> set) {
        this.f3747e0.clear();
        this.f3747e0.addAll(set);
        b0(set);
        H();
    }

    @Override // androidx.preference.Preference
    protected final Object Q(TypedArray typedArray, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected final void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        H0(aVar.f3748i);
    }

    @Override // androidx.preference.Preference
    protected final Parcelable V() {
        Parcelable parcelableV = super.V();
        if (F()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f3748i = this.f3747e0;
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected final void W(Object obj) {
        H0(w((Set) obj));
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0069a();

        /* renamed from: i, reason: collision with root package name */
        Set<String> f3748i;

        /* renamed from: androidx.preference.MultiSelectListPreference$a$a, reason: collision with other inner class name */
        static class C0069a implements Parcelable.Creator<a> {
            C0069a() {
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
            int i2 = parcel.readInt();
            this.f3748i = new HashSet();
            String[] strArr = new String[i2];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f3748i, strArr);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set, java.util.Set<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3748i.size());
            ?? r02 = this.f3748i;
            parcel.writeStringArray((String[]) r02.toArray(new String[r02.size()]));
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, x.e.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle), 0);
    }
}
