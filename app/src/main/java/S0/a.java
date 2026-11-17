package S0;

import N.j;
import Q0.ViewOnClickListenerC0169b;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class a<M> extends j<M, RecyclerView.x> implements ViewOnClickListenerC0169b.a {

    /* renamed from: e, reason: collision with root package name */
    protected k.d<M> f1341e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f1342f;
    protected boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1343h;

    /* renamed from: i, reason: collision with root package name */
    private int f1344i;

    /* renamed from: j, reason: collision with root package name */
    private int f1345j;

    /* renamed from: k, reason: collision with root package name */
    private HashSet<Long> f1346k;

    /* renamed from: l, reason: collision with root package name */
    protected ViewOnClickListenerC0169b.a f1347l;

    /* renamed from: m, reason: collision with root package name */
    protected ViewOnClickListenerC0169b.InterfaceC0031b<M> f1348m;

    public a(k.d<M> dVar, ViewOnClickListenerC0169b.InterfaceC0031b<M> interfaceC0031b) {
        super(dVar);
        this.f1342f = false;
        this.g = false;
        this.f1343h = false;
        this.f1344i = 0;
        this.f1345j = 0;
        this.f1346k = new HashSet<>();
        this.f1341e = dVar;
        this.f1348m = null;
    }

    @Override // N.j
    public M G(int i2) {
        return (M) super.G(i2);
    }

    public void J(int i2) {
        g(i2, true);
    }

    public void K() {
        L(!R());
    }

    public void L(boolean z4) {
        this.f1343h = z4;
        this.f1345j = z4 ? this.f1344i : 0;
        this.f1346k.clear();
        n();
    }

    public void M() {
        this.f1342f = true;
        L(false);
    }

    public void N() {
        this.f1342f = false;
        L(false);
    }

    public int O() {
        return this.f1345j;
    }

    public long P(int i2) {
        throw null;
    }

    public Set<Long> Q() {
        return this.f1346k;
    }

    public boolean R() {
        return this.f1344i == this.f1345j;
    }

    public boolean S() {
        return this.f1343h;
    }

    public boolean T() {
        return this.f1342f;
    }

    public final boolean U(int i2) {
        return this.f1343h ? !this.f1346k.contains(Long.valueOf(P(i2))) : this.f1346k.contains(Long.valueOf(P(i2)));
    }

    public void V(int i2) {
        this.f1344i = i2;
        L(this.f1343h);
    }

    public void W(boolean z4) {
        this.g = z4;
    }

    public void X(ViewOnClickListenerC0169b.a aVar) {
        this.f1347l = aVar;
    }

    public void Y(ViewOnClickListenerC0169b.InterfaceC0031b<M> interfaceC0031b) {
        this.f1348m = interfaceC0031b;
    }

    public void g(int i2, boolean z4) {
        if (this.f1343h) {
            if (z4) {
                this.f1345j++;
                this.f1346k.remove(Long.valueOf(P(i2)));
            } else {
                this.f1345j--;
                this.f1346k.add(Long.valueOf(P(i2)));
            }
        } else if (z4) {
            this.f1345j++;
            this.f1346k.add(Long.valueOf(P(i2)));
        } else {
            this.f1345j--;
            this.f1346k.remove(Long.valueOf(P(i2)));
        }
        ViewOnClickListenerC0169b.a aVar = this.f1347l;
        if (aVar != null) {
            aVar.g(i2, z4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long k(int i2) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void x(RecyclerView.x xVar, int i2) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.x y(ViewGroup viewGroup, int i2) {
        throw null;
    }
}
