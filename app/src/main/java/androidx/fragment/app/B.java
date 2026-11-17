package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class B implements Parcelable {
    public static final Parcelable.Creator<B> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    final String f3364i;

    /* renamed from: j, reason: collision with root package name */
    final String f3365j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f3366k;

    /* renamed from: l, reason: collision with root package name */
    final int f3367l;

    /* renamed from: m, reason: collision with root package name */
    final int f3368m;

    /* renamed from: n, reason: collision with root package name */
    final String f3369n;

    /* renamed from: o, reason: collision with root package name */
    final boolean f3370o;
    final boolean p;

    /* renamed from: q, reason: collision with root package name */
    final boolean f3371q;

    /* renamed from: r, reason: collision with root package name */
    final Bundle f3372r;

    /* renamed from: s, reason: collision with root package name */
    final boolean f3373s;

    /* renamed from: t, reason: collision with root package name */
    final int f3374t;
    Bundle u;

    final class a implements Parcelable.Creator<B> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final B createFromParcel(Parcel parcel) {
            return new B(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final B[] newArray(int i2) {
            return new B[i2];
        }
    }

    B(Fragment fragment) {
        this.f3364i = fragment.getClass().getName();
        this.f3365j = fragment.f3435n;
        this.f3366k = fragment.f3441v;
        this.f3367l = fragment.f3410E;
        this.f3368m = fragment.f3411F;
        this.f3369n = fragment.f3412G;
        this.f3370o = fragment.f3415J;
        this.p = fragment.u;
        this.f3371q = fragment.f3414I;
        this.f3372r = fragment.f3436o;
        this.f3373s = fragment.f3413H;
        this.f3374t = fragment.f3424V.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3364i);
        sb.append(" (");
        sb.append(this.f3365j);
        sb.append(")}:");
        if (this.f3366k) {
            sb.append(" fromLayout");
        }
        if (this.f3368m != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3368m));
        }
        String str = this.f3369n;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f3369n);
        }
        if (this.f3370o) {
            sb.append(" retainInstance");
        }
        if (this.p) {
            sb.append(" removing");
        }
        if (this.f3371q) {
            sb.append(" detached");
        }
        if (this.f3373s) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3364i);
        parcel.writeString(this.f3365j);
        parcel.writeInt(this.f3366k ? 1 : 0);
        parcel.writeInt(this.f3367l);
        parcel.writeInt(this.f3368m);
        parcel.writeString(this.f3369n);
        parcel.writeInt(this.f3370o ? 1 : 0);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeInt(this.f3371q ? 1 : 0);
        parcel.writeBundle(this.f3372r);
        parcel.writeInt(this.f3373s ? 1 : 0);
        parcel.writeBundle(this.u);
        parcel.writeInt(this.f3374t);
    }

    B(Parcel parcel) {
        this.f3364i = parcel.readString();
        this.f3365j = parcel.readString();
        this.f3366k = parcel.readInt() != 0;
        this.f3367l = parcel.readInt();
        this.f3368m = parcel.readInt();
        this.f3369n = parcel.readString();
        this.f3370o = parcel.readInt() != 0;
        this.p = parcel.readInt() != 0;
        this.f3371q = parcel.readInt() != 0;
        this.f3372r = parcel.readBundle();
        this.f3373s = parcel.readInt() != 0;
        this.u = parcel.readBundle();
        this.f3374t = parcel.readInt();
    }
}
