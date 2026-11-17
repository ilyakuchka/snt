package androidx.lifecycle;

import androidx.lifecycle.g;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements i {

    /* renamed from: a, reason: collision with root package name */
    private final e f3646a;

    /* renamed from: b, reason: collision with root package name */
    private final i f3647b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3648a;

        static {
            int[] iArr = new int[g.b.values().length];
            f3648a = iArr;
            try {
                iArr[g.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3648a[g.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3648a[g.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3648a[g.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3648a[g.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3648a[g.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3648a[g.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    FullLifecycleObserverAdapter(e eVar, i iVar) {
        this.f3646a = eVar;
        this.f3647b = iVar;
    }

    @Override // androidx.lifecycle.i
    public final void g(k kVar, g.b bVar) {
        switch (a.f3648a[bVar.ordinal()]) {
            case 1:
                this.f3646a.f();
                break;
            case 2:
                this.f3646a.d();
                break;
            case 3:
                this.f3646a.b();
                break;
            case 4:
                this.f3646a.c();
                break;
            case 5:
                this.f3646a.a();
                break;
            case 6:
                this.f3646a.e();
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        i iVar = this.f3647b;
        if (iVar != null) {
            iVar.g(kVar, bVar);
        }
    }
}
