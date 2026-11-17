package androidx.versionedparcelable;

import C2.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import q.C0365a;

/* loaded from: classes.dex */
final class b extends a {
    private final SparseIntArray d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f4302e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4303f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final String f4304h;

    /* renamed from: i, reason: collision with root package name */
    private int f4305i;

    /* renamed from: j, reason: collision with root package name */
    private int f4306j;

    /* renamed from: k, reason: collision with root package name */
    private int f4307k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0365a(), new C0365a(), new C0365a());
    }

    @Override // androidx.versionedparcelable.a
    public final void B(int i2) {
        this.f4302e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.a
    public final void D(Parcelable parcelable) {
        this.f4302e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public final void F(String str) {
        this.f4302e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public final void a() {
        int i2 = this.f4305i;
        if (i2 >= 0) {
            int i4 = this.d.get(i2);
            int iDataPosition = this.f4302e.dataPosition();
            this.f4302e.setDataPosition(i4);
            this.f4302e.writeInt(iDataPosition - i4);
            this.f4302e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected final a b() {
        Parcel parcel = this.f4302e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f4306j;
        if (i2 == this.f4303f) {
            i2 = this.g;
        }
        return new b(parcel, iDataPosition, i2, c.b(new StringBuilder(), this.f4304h, "  "), this.f4299a, this.f4300b, this.f4301c);
    }

    @Override // androidx.versionedparcelable.a
    public final boolean f() {
        return this.f4302e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public final byte[] h() {
        int i2 = this.f4302e.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        this.f4302e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected final CharSequence j() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4302e);
    }

    @Override // androidx.versionedparcelable.a
    public final boolean l(int i2) {
        while (this.f4306j < this.g) {
            int i4 = this.f4307k;
            if (i4 == i2) {
                return true;
            }
            if (String.valueOf(i4).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f4302e.setDataPosition(this.f4306j);
            int i5 = this.f4302e.readInt();
            this.f4307k = this.f4302e.readInt();
            this.f4306j += i5;
        }
        return this.f4307k == i2;
    }

    @Override // androidx.versionedparcelable.a
    public final int m() {
        return this.f4302e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public final <T extends Parcelable> T o() {
        return (T) this.f4302e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public final String q() {
        return this.f4302e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public final void u(int i2) {
        a();
        this.f4305i = i2;
        this.d.put(i2, this.f4302e.dataPosition());
        B(0);
        B(i2);
    }

    @Override // androidx.versionedparcelable.a
    public final void v(boolean z4) {
        this.f4302e.writeInt(z4 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.a
    public final void x(byte[] bArr) {
        if (bArr == null) {
            this.f4302e.writeInt(-1);
        } else {
            this.f4302e.writeInt(bArr.length);
            this.f4302e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected final void z(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4302e, 0);
    }

    private b(Parcel parcel, int i2, int i4, String str, C0365a<String, Method> c0365a, C0365a<String, Method> c0365a2, C0365a<String, Class> c0365a3) {
        super(c0365a, c0365a2, c0365a3);
        this.d = new SparseIntArray();
        this.f4305i = -1;
        this.f4307k = -1;
        this.f4302e = parcel;
        this.f4303f = i2;
        this.g = i4;
        this.f4306j = i2;
        this.f4304h = str;
    }
}
