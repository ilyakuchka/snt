package androidx.recyclerview.widget;

/* loaded from: classes.dex */
final class n {

    /* renamed from: b, reason: collision with root package name */
    int f4245b;

    /* renamed from: c, reason: collision with root package name */
    int f4246c;
    int d;

    /* renamed from: e, reason: collision with root package name */
    int f4247e;

    /* renamed from: h, reason: collision with root package name */
    boolean f4249h;

    /* renamed from: i, reason: collision with root package name */
    boolean f4250i;

    /* renamed from: a, reason: collision with root package name */
    boolean f4244a = true;

    /* renamed from: f, reason: collision with root package name */
    int f4248f = 0;
    int g = 0;

    n() {
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("LayoutState{mAvailable=");
        sbD.append(this.f4245b);
        sbD.append(", mCurrentPosition=");
        sbD.append(this.f4246c);
        sbD.append(", mItemDirection=");
        sbD.append(this.d);
        sbD.append(", mLayoutDirection=");
        sbD.append(this.f4247e);
        sbD.append(", mStartLine=");
        sbD.append(this.f4248f);
        sbD.append(", mEndLine=");
        sbD.append(this.g);
        sbD.append('}');
        return sbD.toString();
    }
}
