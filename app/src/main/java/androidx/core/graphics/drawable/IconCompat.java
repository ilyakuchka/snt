package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f3283k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f3284a;

    /* renamed from: b, reason: collision with root package name */
    Object f3285b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3286c;
    public Parcelable d;

    /* renamed from: e, reason: collision with root package name */
    public int f3287e;

    /* renamed from: f, reason: collision with root package name */
    public int f3288f;
    public ColorStateList g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f3289h;

    /* renamed from: i, reason: collision with root package name */
    public String f3290i;

    /* renamed from: j, reason: collision with root package name */
    public String f3291j;

    public IconCompat() {
        this.f3284a = -1;
        this.f3286c = null;
        this.d = null;
        this.f3287e = 0;
        this.f3288f = 0;
        this.g = null;
        this.f3289h = f3283k;
        this.f3290i = null;
    }

    public static IconCompat a(int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f3287e = i2;
        iconCompat.f3285b = "";
        iconCompat.f3291j = "";
        return iconCompat;
    }

    public final int b() {
        int i2 = this.f3284a;
        if (i2 == -1) {
            return ((Icon) this.f3285b).getResId();
        }
        if (i2 == 2) {
            return this.f3287e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final int c() {
        int i2 = this.f3284a;
        return i2 == -1 ? ((Icon) this.f3285b).getType() : i2;
    }

    public final Uri d() {
        int i2 = this.f3284a;
        if (i2 == -1) {
            return ((Icon) this.f3285b).getUri();
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f3285b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @Deprecated
    public final Icon e() {
        Icon iconCreateWithBitmap;
        String resPackage;
        int i2 = this.f3284a;
        switch (i2) {
            case -1:
                return (Icon) this.f3285b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.f3285b);
                break;
            case 2:
                if (i2 == -1) {
                    resPackage = ((Icon) this.f3285b).getResPackage();
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + this);
                    }
                    resPackage = TextUtils.isEmpty(this.f3291j) ? ((String) this.f3285b).split(":", -1)[0] : this.f3291j;
                }
                iconCreateWithBitmap = Icon.createWithResource(resPackage, this.f3287e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) this.f3285b, this.f3287e, this.f3288f);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) this.f3285b);
                break;
            case 5:
                iconCreateWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f3285b);
                break;
            case 6:
                iconCreateWithBitmap = Icon.createWithAdaptiveBitmapContentUri(d());
                break;
        }
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f3289h;
        if (mode == f3283k) {
            return iconCreateWithBitmap;
        }
        iconCreateWithBitmap.setTintMode(mode);
        return iconCreateWithBitmap;
    }

    public final String toString() {
        String str;
        if (this.f3284a == -1) {
            return String.valueOf(this.f3285b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f3284a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f3284a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f3285b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f3285b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f3291j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f3287e);
                if (this.f3288f != 0) {
                    sb.append(" off=");
                    sb.append(this.f3288f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f3285b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.f3289h != f3283k) {
            sb.append(" mode=");
            sb.append(this.f3289h);
        }
        sb.append(")");
        return sb.toString();
    }

    private IconCompat(int i2) {
        this.f3286c = null;
        this.d = null;
        this.f3287e = 0;
        this.f3288f = 0;
        this.g = null;
        this.f3289h = f3283k;
        this.f3290i = null;
        this.f3284a = 2;
    }
}
