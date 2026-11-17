package N;

import androidx.recyclerview.widget.k;
import java.util.Objects;

/* loaded from: classes.dex */
final class l extends k.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f698a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f699b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ k f700c;
    final /* synthetic */ k.d d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f701e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f702f;

    l(k kVar, int i2, k kVar2, k.d dVar, int i4, int i5) {
        this.f698a = kVar;
        this.f699b = i2;
        this.f700c = kVar2;
        this.d = dVar;
        this.f701e = i4;
        this.f702f = i5;
    }

    @Override // androidx.recyclerview.widget.k.b
    public final boolean a(int i2, int i4) {
        Object obj = this.f698a.get(i2 + this.f699b);
        k kVar = this.f700c;
        Object obj2 = kVar.get(i4 + kVar.o());
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return this.d.a(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.k.b
    public final boolean b(int i2, int i4) {
        Object obj = this.f698a.get(i2 + this.f699b);
        k kVar = this.f700c;
        Object obj2 = kVar.get(i4 + kVar.o());
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return this.d.b(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.k.b
    public final void c(int i2, int i4) {
        Object obj = this.f698a.get(i2 + this.f699b);
        k kVar = this.f700c;
        Object obj2 = kVar.get(i4 + kVar.o());
        if (obj == null || obj2 == null) {
            return;
        }
        Objects.requireNonNull(this.d);
    }

    @Override // androidx.recyclerview.widget.k.b
    public final int d() {
        return this.f702f;
    }

    @Override // androidx.recyclerview.widget.k.b
    public final int e() {
        return this.f701e;
    }
}
