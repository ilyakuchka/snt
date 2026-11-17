package g0;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/* renamed from: g0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0309e implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    private int f6250i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f6251j;

    public C0309e(int i2, byte[] bArr) {
        Objects.requireNonNull(bArr, "EncodedStringValue: Text-string is null.");
        this.f6250i = i2;
        byte[] bArr2 = new byte[bArr.length];
        this.f6251j = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public static String b(C0309e[] c0309eArr) {
        StringBuilder sb = new StringBuilder();
        int length = c0309eArr.length - 1;
        for (int i2 = 0; i2 <= length; i2++) {
            sb.append(c0309eArr[i2].f());
            if (i2 < length) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static C0309e c(C0309e c0309e) {
        if (c0309e == null) {
            return null;
        }
        return new C0309e(c0309e.f6250i, c0309e.f6251j);
    }

    public static C0309e[] d(String[] strArr) {
        int length = strArr.length;
        if (length <= 0) {
            return null;
        }
        C0309e[] c0309eArr = new C0309e[length];
        for (int i2 = 0; i2 < length; i2++) {
            c0309eArr[i2] = new C0309e(strArr[i2]);
        }
        return c0309eArr;
    }

    public final void a(byte[] bArr) throws IOException {
        Objects.requireNonNull(bArr, "Text-string is null.");
        if (this.f6251j == null) {
            byte[] bArr2 = new byte[bArr.length];
            this.f6251j = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.f6251j);
            byteArrayOutputStream.write(bArr);
            this.f6251j = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new NullPointerException("appendTextString: failed when write a new Text-string");
        }
    }

    public final Object clone() throws CloneNotSupportedException {
        super.clone();
        byte[] bArr = this.f6251j;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        try {
            return new C0309e(this.f6250i, bArr2);
        } catch (Exception e2) {
            Log.e("EncodedStringValue", "failed to clone an EncodedStringValue: " + this);
            e2.printStackTrace();
            throw new CloneNotSupportedException(e2.getMessage());
        }
    }

    public final int e() {
        return this.f6250i;
    }

    public final String f() {
        int i2 = this.f6250i;
        if (i2 == 0) {
            return new String(this.f6251j);
        }
        try {
            try {
                return new String(this.f6251j, C0307c.b(i2));
            } catch (UnsupportedEncodingException unused) {
                return new String(this.f6251j);
            }
        } catch (UnsupportedEncodingException unused2) {
            return new String(this.f6251j, "iso-8859-1");
        }
    }

    public final byte[] g() {
        byte[] bArr = this.f6251j;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final void h(byte[] bArr) {
        Objects.requireNonNull(bArr, "EncodedStringValue: Text-string is null.");
        byte[] bArr2 = new byte[bArr.length];
        this.f6251j = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public C0309e(byte[] bArr) {
        this(106, bArr);
    }

    public C0309e(String str) {
        this(106, str);
    }

    public C0309e(int i2, String str) {
        Objects.requireNonNull(str, "EncodedStringValue: Text-string is null");
        this.f6250i = i2;
        try {
            this.f6251j = str.getBytes(C0307c.b(i2));
        } catch (UnsupportedEncodingException e2) {
            Log.e("EncodedStringValue", "Input encoding " + i2 + " must be supported.", e2);
            this.f6251j = str.getBytes();
        }
    }
}
