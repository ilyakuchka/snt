package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.versionedparcelable.a;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3284a = aVar.n(iconCompat.f3284a, 1);
        iconCompat.f3286c = aVar.i(iconCompat.f3286c);
        iconCompat.d = aVar.p(iconCompat.d, 3);
        iconCompat.f3287e = aVar.n(iconCompat.f3287e, 4);
        iconCompat.f3288f = aVar.n(iconCompat.f3288f, 5);
        iconCompat.g = (ColorStateList) aVar.p(iconCompat.g, 6);
        iconCompat.f3290i = aVar.r(iconCompat.f3290i, 7);
        iconCompat.f3291j = aVar.r(iconCompat.f3291j, 8);
        iconCompat.f3289h = PorterDuff.Mode.valueOf(iconCompat.f3290i);
        switch (iconCompat.f3284a) {
            case -1:
                Parcelable parcelable = iconCompat.d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f3285b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.d;
                if (parcelable2 != null) {
                    iconCompat.f3285b = parcelable2;
                } else {
                    byte[] bArr = iconCompat.f3286c;
                    iconCompat.f3285b = bArr;
                    iconCompat.f3284a = 3;
                    iconCompat.f3287e = 0;
                    iconCompat.f3288f = bArr.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f3286c, Charset.forName("UTF-16"));
                iconCompat.f3285b = str;
                if (iconCompat.f3284a == 2 && iconCompat.f3291j == null) {
                    iconCompat.f3291j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f3285b = iconCompat.f3286c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        Objects.requireNonNull(aVar);
        iconCompat.f3290i = iconCompat.f3289h.name();
        switch (iconCompat.f3284a) {
            case -1:
                iconCompat.d = (Parcelable) iconCompat.f3285b;
                break;
            case 1:
            case 5:
                iconCompat.d = (Parcelable) iconCompat.f3285b;
                break;
            case 2:
                iconCompat.f3286c = ((String) iconCompat.f3285b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f3286c = (byte[]) iconCompat.f3285b;
                break;
            case 4:
            case 6:
                iconCompat.f3286c = iconCompat.f3285b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.f3284a;
        if (-1 != i2) {
            aVar.C(i2, 1);
        }
        byte[] bArr = iconCompat.f3286c;
        if (bArr != null) {
            aVar.y(bArr);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            aVar.E(parcelable, 3);
        }
        int i4 = iconCompat.f3287e;
        if (i4 != 0) {
            aVar.C(i4, 4);
        }
        int i5 = iconCompat.f3288f;
        if (i5 != 0) {
            aVar.C(i5, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            aVar.E(colorStateList, 6);
        }
        String str = iconCompat.f3290i;
        if (str != null) {
            aVar.G(str, 7);
        }
        String str2 = iconCompat.f3291j;
        if (str2 != null) {
            aVar.G(str2, 8);
        }
    }
}
