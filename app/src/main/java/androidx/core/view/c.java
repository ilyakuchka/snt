package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    final ClipData f3294a;

    /* renamed from: b, reason: collision with root package name */
    final int f3295b;

    /* renamed from: c, reason: collision with root package name */
    final int f3296c;
    final Uri d;

    /* renamed from: e, reason: collision with root package name */
    final Bundle f3297e;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        ClipData f3298a;

        /* renamed from: b, reason: collision with root package name */
        int f3299b;

        /* renamed from: c, reason: collision with root package name */
        int f3300c;
        Uri d;

        /* renamed from: e, reason: collision with root package name */
        Bundle f3301e;

        public a(ClipData clipData, int i2) {
            this.f3298a = clipData;
            this.f3299b = i2;
        }

        public final c a() {
            return new c(this);
        }

        public final a b(Bundle bundle) {
            this.f3301e = bundle;
            return this;
        }

        public final a c(int i2) {
            this.f3300c = i2;
            return this;
        }

        public final a d(Uri uri) {
            this.d = uri;
            return this;
        }
    }

    c(a aVar) {
        ClipData clipData = aVar.f3298a;
        Objects.requireNonNull(clipData);
        this.f3294a = clipData;
        int i2 = aVar.f3299b;
        if (i2 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 3));
        }
        if (i2 > 3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 3));
        }
        this.f3295b = i2;
        int i4 = aVar.f3300c;
        if ((i4 & 1) == i4) {
            this.f3296c = i4;
            this.d = aVar.d;
            this.f3297e = aVar.f3301e;
        } else {
            StringBuilder sbD = D2.e.d("Requested flags 0x");
            sbD.append(Integer.toHexString(i4));
            sbD.append(", but only 0x");
            sbD.append(Integer.toHexString(1));
            sbD.append(" are allowed");
            throw new IllegalArgumentException(sbD.toString());
        }
    }

    public final ClipData a() {
        return this.f3294a;
    }

    public final int b() {
        return this.f3296c;
    }

    public final int c() {
        return this.f3295b;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("ContentInfoCompat{clip=");
        sbD.append(this.f3294a);
        sbD.append(", source=");
        int i2 = this.f3295b;
        sbD.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? String.valueOf(i2) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
        sbD.append(", flags=");
        int i4 = this.f3296c;
        sbD.append((i4 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i4));
        sbD.append(", linkUri=");
        sbD.append(this.d);
        sbD.append(", extras=");
        sbD.append(this.f3297e);
        sbD.append("}");
        return sbD.toString();
    }
}
