package m3;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import m3.AbstractC0350b;
import m3.C0349a;
import n3.AbstractC0355a;
import n3.AbstractC0356b;

/* renamed from: m3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0350b<T extends AbstractC0350b<T>> implements C0349a.b {
    final Object d;

    /* renamed from: e, reason: collision with root package name */
    final AbstractC0355a f6584e;

    /* renamed from: i, reason: collision with root package name */
    private float f6587i;

    /* renamed from: a, reason: collision with root package name */
    float f6581a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    float f6582b = Float.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    boolean f6583c = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f6585f = false;
    float g = -3.4028235E38f;

    /* renamed from: h, reason: collision with root package name */
    private long f6586h = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f6588j = 0;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList<InterfaceC0118b> f6589k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<c> f6590l = new ArrayList<>();

    /* renamed from: m3.b$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        float f6591a;

        /* renamed from: b, reason: collision with root package name */
        float f6592b;

        a() {
        }
    }

    /* renamed from: m3.b$b, reason: collision with other inner class name */
    public interface InterfaceC0118b {
        void a();
    }

    /* renamed from: m3.b$c */
    public interface c {
        void a(AbstractC0350b abstractC0350b, float f4, float f5);
    }

    <K> AbstractC0350b(K k2, AbstractC0355a<K> abstractC0355a) {
        this.d = k2;
        this.f6584e = abstractC0355a;
        if (abstractC0355a == AbstractC0356b.d || abstractC0355a == AbstractC0356b.f7496e || abstractC0355a == AbstractC0356b.f7497f) {
            this.f6587i = 0.1f;
            return;
        }
        if (abstractC0355a == AbstractC0356b.g) {
            this.f6587i = 0.00390625f;
        } else if (abstractC0355a == AbstractC0356b.f7494b || abstractC0355a == AbstractC0356b.f7495c) {
            this.f6587i = 0.002f;
        } else {
            this.f6587i = 1.0f;
        }
    }

    private void e(boolean z4) {
        this.f6585f = false;
        C0349a.g().h(this);
        this.f6586h = 0L;
        this.f6583c = false;
        for (int i2 = 0; i2 < this.f6589k.size(); i2++) {
            if (this.f6589k.get(i2) != null) {
                this.f6589k.get(i2).a();
            }
        }
        h(this.f6589k);
    }

    private static <T> void h(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // m3.C0349a.b
    public final boolean a(long j2) {
        long j4 = this.f6586h;
        if (j4 == 0) {
            this.f6586h = j2;
            j(this.f6582b);
            return false;
        }
        this.f6586h = j2;
        boolean zO = o(j2 - j4);
        float fMin = Math.min(this.f6582b, Float.MAX_VALUE);
        this.f6582b = fMin;
        float fMax = Math.max(fMin, this.g);
        this.f6582b = fMax;
        j(fMax);
        if (zO) {
            e(false);
        }
        return zO;
    }

    public final T b(InterfaceC0118b interfaceC0118b) {
        if (!this.f6589k.contains(interfaceC0118b)) {
            this.f6589k.add(interfaceC0118b);
        }
        return this;
    }

    public final T c(c cVar) {
        if (this.f6585f) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe miuix.animation.");
        }
        if (!this.f6590l.contains(cVar)) {
            this.f6590l.add(cVar);
        }
        return this;
    }

    public final void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f6585f) {
            e(true);
        }
    }

    final float f() {
        return this.f6587i * 0.75f;
    }

    public final boolean g() {
        return this.f6585f;
    }

    public final T i(float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f6587i = f4;
        return this;
    }

    final void j(float f4) {
        this.f6584e.b(this.d, f4);
        for (int i2 = 0; i2 < this.f6590l.size(); i2++) {
            if (this.f6590l.get(i2) != null) {
                this.f6590l.get(i2).a(this, this.f6582b, this.f6581a);
            }
        }
        h(this.f6590l);
    }

    public final void k(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        this.f6588j = j2;
    }

    public final T l(float f4) {
        this.f6582b = f4;
        this.f6583c = true;
        return this;
    }

    public final T m(float f4) {
        this.f6581a = f4;
        return this;
    }

    public void n() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        boolean z4 = this.f6585f;
        if (z4 || z4) {
            return;
        }
        this.f6585f = true;
        if (!this.f6583c) {
            this.f6582b = this.f6584e.a(this.d);
        }
        float f4 = this.f6582b;
        if (f4 > Float.MAX_VALUE || f4 < this.g) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        C0349a.g().f(this, this.f6588j);
    }

    abstract boolean o(long j2);
}
