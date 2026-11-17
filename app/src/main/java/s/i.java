package s;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i extends e {

    /* renamed from: i0, reason: collision with root package name */
    protected e[] f7816i0 = new e[4];

    /* renamed from: j0, reason: collision with root package name */
    protected int f7817j0 = 0;

    public final void n0(e eVar) {
        int i2 = this.f7817j0 + 1;
        e[] eVarArr = this.f7816i0;
        if (i2 > eVarArr.length) {
            this.f7816i0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f7816i0;
        int i4 = this.f7817j0;
        eVarArr2[i4] = eVar;
        this.f7817j0 = i4 + 1;
    }

    public final void o0() {
        this.f7817j0 = 0;
    }
}
