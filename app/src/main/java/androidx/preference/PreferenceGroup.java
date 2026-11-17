package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t.C0384b;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: W, reason: collision with root package name */
    final q.g<String, Long> f3786W;

    /* renamed from: X, reason: collision with root package name */
    private final Handler f3787X;

    /* renamed from: Y, reason: collision with root package name */
    private List<Preference> f3788Y;

    /* renamed from: Z, reason: collision with root package name */
    private boolean f3789Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f3790a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f3791b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f3792c0;

    /* renamed from: d0, reason: collision with root package name */
    private final Runnable f3793d0;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                PreferenceGroup.this.f3786W.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, 0);
        this.f3786W = new q.g<>();
        this.f3787X = new Handler();
        this.f3789Z = true;
        this.f3790a0 = 0;
        this.f3791b0 = false;
        this.f3792c0 = Integer.MAX_VALUE;
        this.f3793d0 = new a();
        this.f3788Y = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7884o, i2, 0);
        this.f3789Z = x.e.b(typedArrayObtainStyledAttributes, 2, 2, true);
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            E0(typedArrayObtainStyledAttributes.getInt(1, typedArrayObtainStyledAttributes.getInt(1, Integer.MAX_VALUE)));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    private boolean D0(Preference preference) {
        boolean zRemove;
        synchronized (this) {
            preference.T();
            if (preference.s() == this) {
                preference.d(null);
            }
            zRemove = this.f3788Y.remove(preference);
            if (zRemove) {
                String strO = preference.o();
                if (strO != null) {
                    this.f3786W.put(strO, Long.valueOf(preference.m()));
                    this.f3787X.removeCallbacks(this.f3793d0);
                    this.f3787X.post(this.f3793d0);
                }
                if (this.f3791b0) {
                    preference.P();
                }
            }
        }
        return zRemove;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    public final int A0() {
        return this.f3788Y.size();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List, java.util.List<androidx.preference.Preference>] */
    public final void B0() {
        synchronized (this) {
            ?? r02 = this.f3788Y;
            int size = r02.size();
            while (true) {
                size--;
                if (size >= 0) {
                    D0((Preference) r02.get(0));
                }
            }
        }
        J();
    }

    public final boolean C0(Preference preference) {
        boolean zD0 = D0(preference);
        J();
        return zD0;
    }

    public final void E0(int i2) {
        if (i2 != Integer.MAX_VALUE && !C()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f3792c0 = i2;
    }

    final void F0() {
        synchronized (this) {
            Collections.sort(this.f3788Y);
        }
    }

    @Override // androidx.preference.Preference
    public final void I(boolean z4) {
        super.I(z4);
        int iA0 = A0();
        for (int i2 = 0; i2 < iA0; i2++) {
            z0(i2).S(z4);
        }
    }

    @Override // androidx.preference.Preference
    public final void K() {
        super.K();
        this.f3791b0 = true;
        int iA0 = A0();
        for (int i2 = 0; i2 < iA0; i2++) {
            z0(i2).K();
        }
    }

    @Override // androidx.preference.Preference
    public final void P() {
        super.P();
        this.f3791b0 = false;
        int iA0 = A0();
        for (int i2 = 0; i2 < iA0; i2++) {
            z0(i2).P();
        }
    }

    @Override // androidx.preference.Preference
    protected final void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(b.class)) {
            super.U(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        this.f3792c0 = bVar.f3795i;
        super.U(bVar.getSuperState());
    }

    @Override // androidx.preference.Preference
    protected final Parcelable V() {
        return new b(super.V(), this.f3792c0);
    }

    @Override // androidx.preference.Preference
    protected final void g(Bundle bundle) {
        super.g(bundle);
        int iA0 = A0();
        for (int i2 = 0; i2 < iA0; i2++) {
            z0(i2).g(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected final void h(Bundle bundle) {
        super.h(bundle);
        int iA0 = A0();
        for (int i2 = 0; i2 < iA0; i2++) {
            z0(i2).h(bundle);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    public final void w0(Preference preference) {
        long jF;
        if (this.f3788Y.contains(preference)) {
            return;
        }
        if (preference.o() != null) {
            PreferenceGroup preferenceGroupS = this;
            while (preferenceGroupS.s() != null) {
                preferenceGroupS = preferenceGroupS.s();
            }
            String strO = preference.o();
            if (preferenceGroupS.x0(strO) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + strO + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.r() == Integer.MAX_VALUE) {
            if (this.f3789Z) {
                int i2 = this.f3790a0;
                this.f3790a0 = i2 + 1;
                preference.m0(i2);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).f3789Z = this.f3789Z;
            }
        }
        int iBinarySearch = Collections.binarySearch(this.f3788Y, preference);
        if (iBinarySearch < 0) {
            iBinarySearch = (iBinarySearch * (-1)) - 1;
        }
        preference.S(s0());
        synchronized (this) {
            this.f3788Y.add(iBinarySearch, preference);
        }
        g gVarX = x();
        String strO2 = preference.o();
        if (strO2 == null || !this.f3786W.containsKey(strO2)) {
            jF = gVarX.f();
        } else {
            jF = this.f3786W.getOrDefault(strO2, null).longValue();
            this.f3786W.remove(strO2);
        }
        preference.M(gVarX, jF);
        preference.d(this);
        if (this.f3791b0) {
            preference.K();
        }
        J();
    }

    public final <T extends Preference> T x0(CharSequence charSequence) {
        T t2;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(o(), charSequence)) {
            return this;
        }
        int iA0 = A0();
        for (int i2 = 0; i2 < iA0; i2++) {
            PreferenceGroup preferenceGroup = (T) z0(i2);
            if (TextUtils.equals(preferenceGroup.o(), charSequence)) {
                return preferenceGroup;
            }
            if ((preferenceGroup instanceof PreferenceGroup) && (t2 = (T) preferenceGroup.x0(charSequence)) != null) {
                return t2;
            }
        }
        return null;
    }

    public final int y0() {
        return this.f3792c0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<androidx.preference.Preference>] */
    public final Preference z0(int i2) {
        return (Preference) this.f3788Y.get(i2);
    }

    static class b extends Preference.b {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        int f3795i;

        static class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i2) {
                return new b[i2];
            }
        }

        b(Parcel parcel) {
            super(parcel);
            this.f3795i = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3795i);
        }

        b(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f3795i = i2;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }
}
