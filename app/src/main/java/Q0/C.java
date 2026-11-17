package Q0;

import android.util.Log;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class C implements androidx.lifecycle.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1066a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F f1067b;

    public /* synthetic */ C(F f4, int i2) {
        this.f1066a = i2;
        this.f1067b = f4;
    }

    @Override // androidx.lifecycle.p
    public final void a(Object obj) {
        switch (this.f1066a) {
            case 0:
                F f4 = this.f1067b;
                Integer num = (Integer) obj;
                int i2 = F.f1070F0;
                Objects.requireNonNull(f4);
                Log.d("TabConversationF", "placeholder change: " + num);
                f4.n1().m(num.intValue());
                f4.n1().o(f4);
                f4.n1().j().g(f4, new C(f4, 1));
                break;
            default:
                F.C1(this.f1067b, (N.i) obj);
                break;
        }
    }
}
