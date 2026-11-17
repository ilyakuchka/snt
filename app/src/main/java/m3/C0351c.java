package m3;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import m3.AbstractC0350b;
import n3.AbstractC0355a;

/* renamed from: m3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0351c extends AbstractC0350b<C0351c> {

    /* renamed from: m, reason: collision with root package name */
    private e f6593m;

    /* renamed from: n, reason: collision with root package name */
    private float f6594n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6595o;

    public <K> C0351c(K k2, AbstractC0355a<K> abstractC0355a, float f4) {
        super(k2, abstractC0355a);
        this.f6593m = null;
        this.f6594n = Float.MAX_VALUE;
        this.f6595o = false;
        this.f6593m = new e(f4);
    }

    @Override // m3.AbstractC0350b
    public final void n() {
        e eVar = this.f6593m;
        if (eVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dA = eVar.a();
        if (dA > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dA < this.g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        this.f6593m.f(f());
        super.n();
    }

    @Override // m3.AbstractC0350b
    final boolean o(long j2) {
        if (this.f6595o) {
            float f4 = this.f6594n;
            if (f4 != Float.MAX_VALUE) {
                this.f6593m.d(f4);
                this.f6594n = Float.MAX_VALUE;
            }
            this.f6582b = this.f6593m.a();
            this.f6581a = 0.0f;
            this.f6595o = false;
            return true;
        }
        if (this.f6594n != Float.MAX_VALUE) {
            this.f6593m.a();
            long j4 = j2 / 2;
            AbstractC0350b.a aVarG = this.f6593m.g(this.f6582b, this.f6581a, j4);
            this.f6593m.d(this.f6594n);
            this.f6594n = Float.MAX_VALUE;
            AbstractC0350b.a aVarG2 = this.f6593m.g(aVarG.f6591a, aVarG.f6592b, j4);
            this.f6582b = aVarG2.f6591a;
            this.f6581a = aVarG2.f6592b;
        } else {
            AbstractC0350b.a aVarG3 = this.f6593m.g(this.f6582b, this.f6581a, j2);
            this.f6582b = aVarG3.f6591a;
            this.f6581a = aVarG3.f6592b;
        }
        float fMax = Math.max(this.f6582b, this.g);
        this.f6582b = fMax;
        float fMin = Math.min(fMax, Float.MAX_VALUE);
        this.f6582b = fMin;
        if (!this.f6593m.b(fMin, this.f6581a)) {
            return false;
        }
        this.f6582b = this.f6593m.a();
        this.f6581a = 0.0f;
        return true;
    }

    public final e p() {
        return this.f6593m;
    }

    public final void q() {
        if (!(this.f6593m.f6598b > 0.0d)) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f6585f) {
            this.f6595o = true;
        }
    }
}
