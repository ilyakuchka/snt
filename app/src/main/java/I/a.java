package I;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* renamed from: i, reason: collision with root package name */
    private final Parcelable f264i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f263j = new C0010a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: I.a$a, reason: collision with other inner class name */
    static class C0010a extends a {
        C0010a() {
        }
    }

    a() {
        this.f264i = null;
    }

    public final Parcelable a() {
        return this.f264i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f264i, i2);
    }

    static class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            if (parcel.readParcelable(null) == null) {
                return a.f263j;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new a[i2];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f263j;
            }
            throw new IllegalStateException("superState must be null");
        }
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f264i = parcelable == f263j ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f264i = parcelable == null ? f263j : parcelable;
    }
}
