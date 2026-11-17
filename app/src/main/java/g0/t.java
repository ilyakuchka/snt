package g0;

import android.util.Log;
import f0.C0302a;

/* loaded from: classes.dex */
public final class t extends C0311g {
    public t() {
        try {
            c(128);
            d();
            this.f6252a.l("application/vnd.wap.multipart.related".getBytes(), 132);
            this.f6252a.h(new C0309e("insert-address-token".getBytes()), 137);
            this.f6252a.l(("T" + Long.toHexString(System.currentTimeMillis())).getBytes(), 152);
        } catch (C0302a e2) {
            Log.e("SendReq", "Unexpected InvalidHeaderValueException.", e2);
            throw new RuntimeException(e2);
        }
    }

    public final C0309e[] n() {
        return this.f6252a.c(129);
    }

    public final byte[] o() {
        return this.f6252a.f(152);
    }

    public final void p(int i2) throws C0302a {
        this.f6252a.k(i2, 134);
    }

    public final void q() {
        this.f6252a.j(604800L, 136);
    }

    public final void r(byte[] bArr) {
        this.f6252a.l(bArr, 138);
    }

    public final void s(long j2) {
        this.f6252a.j(j2, 142);
    }

    public final void t(int i2) throws C0302a {
        this.f6252a.k(i2, 144);
    }

    public final void u(C0309e[] c0309eArr) {
        this.f6252a.i(c0309eArr);
    }

    public final void v(byte[] bArr) {
        this.f6252a.l(bArr, 152);
    }

    t(C0316l c0316l, C0313i c0313i) {
        super(c0316l, c0313i);
    }
}
