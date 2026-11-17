package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.E;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0206b implements Parcelable {
    public static final Parcelable.Creator<C0206b> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    final int[] f3498i;

    /* renamed from: j, reason: collision with root package name */
    final ArrayList<String> f3499j;

    /* renamed from: k, reason: collision with root package name */
    final int[] f3500k;

    /* renamed from: l, reason: collision with root package name */
    final int[] f3501l;

    /* renamed from: m, reason: collision with root package name */
    final int f3502m;

    /* renamed from: n, reason: collision with root package name */
    final String f3503n;

    /* renamed from: o, reason: collision with root package name */
    final int f3504o;
    final int p;

    /* renamed from: q, reason: collision with root package name */
    final CharSequence f3505q;

    /* renamed from: r, reason: collision with root package name */
    final int f3506r;

    /* renamed from: s, reason: collision with root package name */
    final CharSequence f3507s;

    /* renamed from: t, reason: collision with root package name */
    final ArrayList<String> f3508t;
    final ArrayList<String> u;

    /* renamed from: v, reason: collision with root package name */
    final boolean f3509v;

    /* renamed from: androidx.fragment.app.b$a */
    final class a implements Parcelable.Creator<C0206b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final C0206b createFromParcel(Parcel parcel) {
            return new C0206b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final C0206b[] newArray(int i2) {
            return new C0206b[i2];
        }
    }

    public C0206b(C0205a c0205a) {
        int size = c0205a.f3383a.size();
        this.f3498i = new int[size * 5];
        if (!c0205a.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3499j = new ArrayList<>(size);
        this.f3500k = new int[size];
        this.f3501l = new int[size];
        int i2 = 0;
        int i4 = 0;
        while (i2 < size) {
            E.a aVar = c0205a.f3383a.get(i2);
            int i5 = i4 + 1;
            this.f3498i[i4] = aVar.f3396a;
            ArrayList<String> arrayList = this.f3499j;
            Fragment fragment = aVar.f3397b;
            arrayList.add(fragment != null ? fragment.f3435n : null);
            int[] iArr = this.f3498i;
            int i6 = i5 + 1;
            iArr[i5] = aVar.f3398c;
            int i7 = i6 + 1;
            iArr[i6] = aVar.d;
            int i8 = i7 + 1;
            iArr[i7] = aVar.f3399e;
            iArr[i8] = aVar.f3400f;
            this.f3500k[i2] = aVar.g.ordinal();
            this.f3501l[i2] = aVar.f3401h.ordinal();
            i2++;
            i4 = i8 + 1;
        }
        this.f3502m = c0205a.f3387f;
        this.f3503n = c0205a.f3389i;
        this.f3504o = c0205a.f3497s;
        this.p = c0205a.f3390j;
        this.f3505q = c0205a.f3391k;
        this.f3506r = c0205a.f3392l;
        this.f3507s = c0205a.f3393m;
        this.f3508t = c0205a.f3394n;
        this.u = c0205a.f3395o;
        this.f3509v = c0205a.p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f3498i);
        parcel.writeStringList(this.f3499j);
        parcel.writeIntArray(this.f3500k);
        parcel.writeIntArray(this.f3501l);
        parcel.writeInt(this.f3502m);
        parcel.writeString(this.f3503n);
        parcel.writeInt(this.f3504o);
        parcel.writeInt(this.p);
        TextUtils.writeToParcel(this.f3505q, parcel, 0);
        parcel.writeInt(this.f3506r);
        TextUtils.writeToParcel(this.f3507s, parcel, 0);
        parcel.writeStringList(this.f3508t);
        parcel.writeStringList(this.u);
        parcel.writeInt(this.f3509v ? 1 : 0);
    }

    public C0206b(Parcel parcel) {
        this.f3498i = parcel.createIntArray();
        this.f3499j = parcel.createStringArrayList();
        this.f3500k = parcel.createIntArray();
        this.f3501l = parcel.createIntArray();
        this.f3502m = parcel.readInt();
        this.f3503n = parcel.readString();
        this.f3504o = parcel.readInt();
        this.p = parcel.readInt();
        this.f3505q = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3506r = parcel.readInt();
        this.f3507s = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3508t = parcel.createStringArrayList();
        this.u = parcel.createStringArrayList();
        this.f3509v = parcel.readInt() != 0;
    }
}
