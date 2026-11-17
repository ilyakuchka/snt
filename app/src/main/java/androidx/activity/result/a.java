package androidx.activity.result;

import D2.e;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0053a();

    /* renamed from: i, reason: collision with root package name */
    private final int f2242i;

    /* renamed from: j, reason: collision with root package name */
    private final Intent f2243j;

    /* renamed from: androidx.activity.result.a$a, reason: collision with other inner class name */
    final class C0053a implements Parcelable.Creator<a> {
        C0053a() {
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

    public a(int i2, Intent intent) {
        this.f2242i = i2;
        this.f2243j = intent;
    }

    public final Intent a() {
        return this.f2243j;
    }

    public final int b() {
        return this.f2242i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sbD = e.d("ActivityResult{resultCode=");
        int i2 = this.f2242i;
        sbD.append(i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK");
        sbD.append(", data=");
        sbD.append(this.f2243j);
        sbD.append('}');
        return sbD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2242i);
        parcel.writeInt(this.f2243j == null ? 0 : 1);
        Intent intent = this.f2243j;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    a(Parcel parcel) {
        this.f2242i = parcel.readInt();
        this.f2243j = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
