package miuix.internal.view;

import m3.AbstractC0350b;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements AbstractC0350b.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7127a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7128b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f7127a = i2;
        this.f7128b = obj;
    }

    @Override // m3.AbstractC0350b.c
    public final void a(AbstractC0350b abstractC0350b, float f4, float f5) {
        switch (this.f7127a) {
            case 0:
                ((d) this.f7128b).g.invalidateSelf();
                break;
            default:
                ((miuix.slidingwidget.widget.a) this.f7128b).f7406v.invalidate();
                break;
        }
    }
}
