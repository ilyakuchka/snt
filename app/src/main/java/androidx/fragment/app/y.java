package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.w;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    ArrayList<B> f3633i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<String> f3634j;

    /* renamed from: k, reason: collision with root package name */
    C0206b[] f3635k;

    /* renamed from: l, reason: collision with root package name */
    int f3636l;

    /* renamed from: m, reason: collision with root package name */
    String f3637m;

    /* renamed from: n, reason: collision with root package name */
    ArrayList<String> f3638n;

    /* renamed from: o, reason: collision with root package name */
    ArrayList<Bundle> f3639o;
    ArrayList<w.k> p;

    final class a implements Parcelable.Creator<y> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final y createFromParcel(Parcel parcel) {
            return new y(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final y[] newArray(int i2) {
            return new y[i2];
        }
    }

    public y() {
        this.f3637m = null;
        this.f3638n = new ArrayList<>();
        this.f3639o = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f3633i);
        parcel.writeStringList(this.f3634j);
        parcel.writeTypedArray(this.f3635k, i2);
        parcel.writeInt(this.f3636l);
        parcel.writeString(this.f3637m);
        parcel.writeStringList(this.f3638n);
        parcel.writeTypedList(this.f3639o);
        parcel.writeTypedList(this.p);
    }

    public y(Parcel parcel) {
        this.f3637m = null;
        this.f3638n = new ArrayList<>();
        this.f3639o = new ArrayList<>();
        this.f3633i = parcel.createTypedArrayList(B.CREATOR);
        this.f3634j = parcel.createStringArrayList();
        this.f3635k = (C0206b[]) parcel.createTypedArray(C0206b.CREATOR);
        this.f3636l = parcel.readInt();
        this.f3637m = parcel.readString();
        this.f3638n = parcel.createStringArrayList();
        this.f3639o = parcel.createTypedArrayList(Bundle.CREATOR);
        this.p = parcel.createTypedArrayList(w.k.CREATOR);
    }
}
