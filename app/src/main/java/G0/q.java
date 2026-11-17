package G0;

import android.content.Context;
import android.util.Log;
import g0.C0307c;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class q extends m {

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f197s;

    /* renamed from: t, reason: collision with root package name */
    private final int f198t;

    public q(Context context, String str, String str2, int i2, byte[] bArr, n nVar) {
        super(context, str, str2, bArr != null ? bArr : new byte[0]);
        this.f198t = i2 == 0 ? 4 : i2;
        this.f197s = F(bArr);
    }

    private CharSequence F(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            int i2 = this.f198t;
            return i2 == 0 ? new String(bArr) : new String(bArr, C0307c.b(i2));
        } catch (UnsupportedEncodingException e2) {
            StringBuilder sbD = D2.e.d("Unsupported encoding: ");
            sbD.append(this.f198t);
            Log.e("Mms/text", sbD.toString(), e2);
            return new String(bArr);
        }
    }

    public final void E() {
        CharSequence charSequence = this.f197s;
        this.f197s = new String(charSequence != null ? charSequence.toString() : "");
    }

    public final int G() {
        return this.f198t;
    }

    public final String H() {
        if (this.f197s == null) {
            this.f197s = F(q());
        }
        CharSequence charSequence = this.f197s;
        if (!(charSequence instanceof String)) {
            this.f197s = charSequence.toString();
        }
        return this.f197s.toString();
    }

    public final void I(CharSequence charSequence) {
        this.f197s = charSequence;
        g();
    }
}
