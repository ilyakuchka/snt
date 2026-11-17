package Q0;

import android.app.Application;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class B extends q {

    /* renamed from: z0, reason: collision with root package name */
    public static final /* synthetic */ int f1062z0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    private List<Integer> f1063w0 = new ArrayList(4);

    /* renamed from: x0, reason: collision with root package name */
    private List<String> f1064x0 = new ArrayList(4);

    /* renamed from: y0, reason: collision with root package name */
    private int f1065y0;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList, java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    public B() {
        this.f1065y0 = 1;
        this.f1063w0.add(1);
        this.f1063w0.add(2);
        Application applicationC = MmsApp.c();
        this.f1064x0.add(applicationC.getString(R.string.sp_category_all));
        this.f1064x0.add(applicationC.getString(R.string.sp_category_bank));
        this.f1065y0 = 1;
    }

    @Override // Q0.q
    protected final void j1() {
        super.j1();
        n1().o(this);
        final int i2 = 0;
        n1().j().g(this, new androidx.lifecycle.p(this) { // from class: Q0.A

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ B f1061b;

            {
                this.f1061b = this;
            }

            @Override // androidx.lifecycle.p
            public final void a(Object obj) {
                switch (i2) {
                    case 0:
                        B b2 = this.f1061b;
                        int i4 = B.f1062z0;
                        b2.f1138m0.I((N.i) obj);
                        break;
                    default:
                        B b4 = this.f1061b;
                        int i5 = B.f1062z0;
                        b4.f1138m0.I((N.i) obj);
                        break;
                }
            }
        });
    }

    @Override // Q0.q
    protected final int m1() {
        if (n1() != null) {
            return n1().f();
        }
        return 2;
    }

    @Override // Q0.q
    protected final int p1() {
        return R.layout.fragment_conversation_service;
    }

    @Override // Q0.q
    protected final void y1() {
    }
}
